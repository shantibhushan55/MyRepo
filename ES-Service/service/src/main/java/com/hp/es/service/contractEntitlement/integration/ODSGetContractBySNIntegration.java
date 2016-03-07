package com.hp.es.service.contractEntitlement.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.db.DbContractEntitlementManager;
import com.hp.es.service.contractEntitlement.db.OutputDetails;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.ContactComplexType;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class ODSGetContractBySNIntegration extends ODSIntegration {

	public ODSGetContractBySNIntegration() {
		super();
	}

	/*
	 *  (non-Javadoc)
	 * @see com.hp.es.service.contractEntitlement.integration.ContractIntegration#doContractIntegration(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */
	public ContractTransaction doContractIntegration(EsRequestComplexType request, MetricsHandler handler)
				throws SifException {
		ContractTransaction tr = new ContractTransaction(null, false, null, null, "ODS", false);

        // Since 9.0.5 PWA, PSG logic is removed from Service.
        //But in backend, the logic is not removed, now we can pass the "false" to db procedure as workaround.
        boolean isPsgTransttionalRequest = false;
        EntitlementBySnRequest snr = request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest();
        OutputDetails details = new OutputDetails(snr);

        EsReplyContext ctx = new EsReplyContext(details);
        DbContractEntitlementManager dbContractEntitlementManager =DbContractEntitlementManager.getNewInstance();
        try {
        	ESLog.debug("Calling database");
        	int errorId = dbContractEntitlementManager.getContractEntitlement(
                        ctx,
                        snr.getContractIdentifier(),
                        snr.getContractIdentifierType(),
                        snr.getDataEntrySite(),
                        snr.getProductID(),
                        snr.getSerialNumber(),
                        snr.getSourceCustomerID(),
                        snr.getRedAccessID(),
                        snr.getRedGroupSerialNo(),
                        snr.getMNContractSourceDoc(),
                        null, //If SN is available, ISOCountryCode should be ignored for contract search according to WITS1221,
                        null,// customer Defined ID is not map
                        snr.getEntitlementCheckDate(),
                        snr.getActiveContractsOnly(),
                        snr.getActiveServicesOnly(),
                        false, // standaloneOffersOnly is always set to false
                        details,
                        true, //for iso_country_code
                        handler,
                        isPsgTransttionalRequest);

            // no error
            if (errorId == 0) {
                ESLog.debug("Building Combined XX Entitlement EsReply");
                EsReply reply = buildCombinedEntitlementReply(ctx, request);
                tr.setMappedReply(reply);
                tr.setStandardizedProductHashMap(ctx.getAggProductIdMapping());
                tr.setReplyContext(ctx);
    			if(snr.getIncludeWorkings()) {
    				reply.getEsReplyChoice().getCombinedUnitEntitlement().addWorking(mapWorking(tr));
    			}
                return tr;
            }
            // if the serial number identifies different products,
            // this operation returns a unit list
            else if (errorId == 202) {
                ESLog.debug("Building UnitList EsReply");
                EsReply reply = buildUnitListReply(ctx, request);
                tr.setMappedReply(reply);
                tr.setStandardizedProductHashMap(ctx.getAggProductIdMapping());
                tr.setReplyContext(ctx);
                return tr;
            }

            // map errorId to SifException
            // this probably needs to be enhanced to provide more details
            ESLog.debug("dbContractEntitlementManager returned error code " + errorId);
            throw ErrorFactory.getSifException(errorId);
        } catch (DataAccessException dae) {
            // map to SifException
            //ESLog.error("DataAccessException", dae);
            //throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Unknown database exception while processing ContractRequest request.");
            ESLog.debug("Caught a DataAccessException while processing ContractRequest.");
            ContractTransaction trans = new ContractTransaction(null, false,null, "", EsConstants.ODS_SYSTEM_NAME,true);
            List<SifException> mappedErrors=new ArrayList<SifException>();
            SifException sifException = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Unknow database exception while processing ContractRequest");
            mappedErrors.add(sifException);
            trans.setMappedErrors(mappedErrors);
            return trans;            
        } catch (DatabaseDownException e) {
            ESLog.debug("Caught a DatabaseDownException while processing ContractRequest.");
            ContractTransaction trans = new ContractTransaction(null, false,null, "", EsConstants.ODS_SYSTEM_NAME,true);
            List<SifException> mappedErrors=new ArrayList<SifException>();
            SifException sifException = ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE,"ES database is down");
            mappedErrors.add(sifException);
            trans.setMappedErrors(mappedErrors);
            return trans;
        } finally {
        	dbContractEntitlementManager.destroy();
            ESLog.debug("Exit");
        }
	}



	/*
	 * Build a Unit List
	 */
	private EsReply buildUnitListReply(EsReplyContext ctx, EsRequestComplexType request) {
        ESLog.debug("Enter");
        // merge objects, create ID/IDREFs, caclulate overall start/end dates
        ctx.mergeAndCalculateAll();

        UnitListComplexType result = new UnitListComplexType();
        for (Iterator<?> it=ctx.getOOSes().iterator(); it.hasNext(); ) {
            OOSComplexType oos = (OOSComplexType)it.next();
            result.addProduct(oos.getProduct());

            // all OOSes have exactly one serial number
            if (result.getSerialNumber() == null) {
                // if we have the SN request we can take the SN from it
                if(request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest() != null) {
                    result.setSerialNumber(request.getEsRequestComplexTypeChoice().
                            getEntitlementBySnRequest().getSerialNumber());
                }
            }
        }

        ESLog.debug("Building header");
        EsHeader esHeader = new EsHeader();
        esHeader.setInputRequest(request);
        // transaction ID is set by service handler

        // A default warning because this is a Unit list
        Warnings warnings = new Warnings();
        warnings.addEIAError(ErrorFactory.getEIAError(ErrorFactory.id202_PRODUCT_NR_NOT_PROVIDED));

        esHeader.setWarnings(warnings);


        EsReplyChoice esReplyChoice = new EsReplyChoice();
        esReplyChoice.setUnitList(result);

        EsReply esReply = new EsReply();
        esReply.setEsHeader(esHeader);
        esReply.setEsReplyChoice(esReplyChoice);


        ESLog.debug("Exit");
        return esReply;

	}

	private EsReply buildCombinedEntitlementReply(EsReplyContext ctx, EsRequestComplexType request) throws SifException {
		EsReply reply = null;
		CombinedUnitEntitlementComplexType result = new CombinedUnitEntitlementComplexType();

		ESLog.debug("Enter");
        ctx.mergeAndCalculateAll();


        result.setActiveContractEntitlement(ctx.isActiveContractEntitlement());
        result.setOverallContractStartDate(ctx.getOverallContractStartDate());
        result.setOverallContractEndDate(ctx.getOverallContractEndDate());

        // warranty
        result.setActiveWarrantyEntitlement(false);

        result.setContact((ContactComplexType[])ctx.getContacts().toArray(new ContactComplexType[0]));
        result.setContract((ContractComplexType[])ctx.getContracts().toArray(new ContractComplexType[0]));
        result.setLocation((LocationComplexType[])ctx.getLocations().toArray(new LocationComplexType[0]));

        int oosCount = ctx.getOOSes().size();
        if (oosCount==0) {
            // NO DATA FOUND
            ESLog.debug("No data found");
            throw ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND);
        }

        ESLog.debug("Found " + oosCount + " OOS");

	    OOSComplexType[] OOSes = (OOSComplexType[]) ctx.getOOSes().toArray(new OOSComplexType[0]);
        OOSComplexType firstOOS = ctx.getFirstOOS(OOSes);
        if (firstOOS == null) {
            // NO DATA FOUND
            ESLog.debug("No data found");
            throw ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND);
        }
        result.setOOS(firstOOS);

        if (oosCount > 1) {
            ContractComplexType[] contracts = result.getContract();
            for (int i = 0; i < contracts.length; i++) {
                OfferComplexType[] offers = contracts[i].getOffer();
                for (int j = 0; j < offers.length; j++) {
                    AppliesTo[] appliesTos = offers[j].getAppliesTo();
                    for (int k = 0; k < appliesTos.length; k++) {
                        AppliesTo to = appliesTos[k];
                        if (to.getOOSRef() != null) {
                            to.setOOSRef(result.getOOS());
                        }
                    }
                }
            }
        }

        ESLog.debug("Building header");
        EsHeader esHeader = new EsHeader();
        esHeader.setInputRequest(request);
        // transaction ID is set by service handler

        EsReplyChoice esReplyChoice = new EsReplyChoice();
        esReplyChoice.setCombinedUnitEntitlement(result);

        reply = new EsReply();
        reply.setEsHeader(esHeader);
        reply.setEsReplyChoice(esReplyChoice);

		return reply;
	}



	/*
	 * The 2 following methods do not fully apply for ODS calls
	 * They will return Null and false
	 */
	/*
	 *
	 *
	 *  (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getRegionConfiguration()
	 */
	public RegionConfiguration getRegionConfiguration() {
		return null;
	}

	public boolean isRegionInFailoverMode() {
		return false;
	}

	public boolean isLocal() {
		return true;
	}



}
