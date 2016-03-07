package com.hp.es.service.contractEntitlement.integration;

import java.util.ArrayList;
import java.util.List;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.db.DbContractEntitlementManager;
import com.hp.es.service.contractEntitlement.db.OutputDetails;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.ContactComplexType;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class ODSGetContractIntegration extends ODSIntegration {

	public ODSGetContractIntegration() {
		super();
	}

    /**
     * This method has to be imeplemented by the sub classes. It processes the
     * the requests and return an EsReply, which is sent back to the client.
     * @param request the request that was sent from the client
     * @param metricsHandler
     * @throws SifException      Thrown when the request couldn't be processed
     *                           successfully.
     * @return EsReply the reply that can be sent back to the client
     * @roseuid 3E6F2B640149
     */
    public ContractTransaction doContractIntegration(EsRequestComplexType request,
                              MetricsHandler metricsHandler)
                  throws SifException {

        ContractRequest cr = request.getEsRequestComplexTypeChoice().getContractRequest();
        DbContractEntitlementManager dbContractEntitlementManager =DbContractEntitlementManager.getNewInstance();
        EsReplyContext ctx = null;
        try {
            OutputDetails details = new OutputDetails(cr);
            ctx = new EsReplyContext(details);

            // call the database
            int errorId = dbContractEntitlementManager.getContractEntitlement(
                        ctx,
                        cr.getContractIdentifier(),
                        cr.getContractIdentifierType(),
                        cr.getDataEntrySite(),
                        cr.getProductID(),
                        null,   // serial# only for GetContractEntBySn
                        cr.getSourceCustomerID(),
                        cr.getRedAccessID(),
                        cr.getRedGroupSerialNo(),
                        //null,   // redGroupSerialNo
                        cr.getMNContractSourceDoc(),
                        cr.getIsoCountryCd(),
                        cr.getCustomerDefinedID(),
                        cr.getEntitlementCheckDate(),
                        cr.getActiveContractsOnly(),
                        cr.getActiveServicesOnly(),
                        cr.getStandAloneOffersOnly(),
                        details,
                        false,
                        metricsHandler,
                        false);

            // check for errors returned from the database
            if (errorId!=0) {
                // map errorId to SifException
                // this probably needs to be enhanced to provide more details
                throw ErrorFactory.getSifException(errorId);
            }

            // merge objects, create ID/IDREFs, calculate overall start/end dates
            ctx.mergeAndCalculateAll();

            ContractEntitlementComplexType result = new ContractEntitlementComplexType();
            result.setActiveContractEntitlement(ctx.isActiveContractEntitlement());
            result.setOverallContractStartDate(ctx.getOverallContractStartDate());
            result.setOverallContractEndDate(ctx.getOverallContractEndDate());

            result.setContact( (ContactComplexType[])ctx.getContacts().toArray(new ContactComplexType[0]) );
            result.setContract( (ContractComplexType[])ctx.getContracts().toArray(new ContractComplexType[0]) );
            result.setLocation( (LocationComplexType[])ctx.getLocations().toArray(new LocationComplexType[0]) );
            result.setOOS( (OOSComplexType[])ctx.getOOSes().toArray(new OOSComplexType[0]) );

            EsHeader esHeader = new EsHeader();
            esHeader.setInputRequest(request);
            // transaction ID is set in service handler class

            EsReplyChoice esReplyChoice = new EsReplyChoice();
            esReplyChoice.setContractEntitlement(result);

            EsReply esReply = new EsReply();
            esReply.setEsHeader(esHeader);
            esReply.setEsReplyChoice(esReplyChoice);

            //adding working
            
            ContractTransaction trans = new ContractTransaction(null, false,null, "", EsConstants.ODS_SYSTEM_NAME,true);
            trans.setODSSucessStatus();
            if(request.getEsRequestComplexTypeChoice().getContractRequest().getIncludeWorkings()) {
            	esReply.getEsReplyChoice().getContractEntitlement().addWorking(mapWorking(trans));
            }
            
            // For Customer Indicator we need the reference of ObligationHeader to Location
            trans.setOHeadLocMap(dbContractEntitlementManager.getOHeadLocMap());
            trans.setMappedReply(esReply);
            
            return trans;
        } catch (DataAccessException e) {
            // map to SifException
//            ESLog.error("Unexpected Data access exception", e.getCause());
//            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,
//                "Unknow database exception while processing ContractRequest.");
            ESLog.debug("Caught a DataAccessException while processing ContractRequest.");
            ContractTransaction trans = new ContractTransaction(null, false,null, "", EsConstants.ODS_SYSTEM_NAME,true);
            List<SifException> mappedErrors=new ArrayList<SifException>();
            SifException sifException = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Unknow database exception while processing ContractRequest");
            mappedErrors.add(sifException);
            trans.setMappedErrors(mappedErrors);
            return trans;
        } catch (DatabaseDownException e) {
            ESLog.info("Caught a DatabaseDownException while processing ContractRequest.",e);
            ContractTransaction trans = new ContractTransaction(null, false,null, "", EsConstants.ODS_SYSTEM_NAME,true);
            List<SifException> mappedErrors=new ArrayList<SifException>();
            SifException sifException = ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE,"ES database is down");
            mappedErrors.add(sifException);
            trans.setMappedErrors(mappedErrors);
            return trans;
        }finally {
        	dbContractEntitlementManager.destroy();
        }
    }

    /*
     * There is no region Configuration for such an integration 
     *  (non-Javadoc)
     * @see com.hp.es.service.IntegrationInterface#getRegionConfiguration()
     */
	public RegionConfiguration getRegionConfiguration() {
		//ALWAYS RETURN NULL
		return null;
	}

	public boolean isRegionInFailoverMode() {
		//		ALWAYS RETURN FALSE
		return false;
	}

	public boolean isLocal() {
		return true;
	}
    private EsReply generateEsReplyWithWarning(int errorId, String errorText) {
        ESLog.debug("Enter generateEsReplyWithWarning()");
        EIAError eiaError = ErrorFactory.getEIAError(errorId, errorText);
        
        Warnings warnings = new Warnings();
        warnings.addEIAError(eiaError);
        
        EsReply esReply = new EsReply();
        EsHeader esHeader=new EsHeader();
        esReply.setEsHeader(esHeader);
        esReply.getEsHeader().setWarnings(warnings);
        
        ESLog.debug("Exit createEsReplyWithWarning()");
        return esReply;
    }	
}
