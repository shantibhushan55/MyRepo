/*
 * Created on Jul 31, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hp.es.service.combinedEntitlement.byPn;

import com.hp.es.service.combinedEntitlement.requester.ContractRequester;
import com.hp.es.service.operations.OperationManager;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.CombinedProductEntitlementComplexType;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.EntitlementByPnRequest;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.sif.SifException;

/**
 * @author juhank
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PnContractRequester extends ContractRequester {

	/**
	 * @param opManager
	 * @throws SifException
	 */
	public PnContractRequester(OperationManager opManager) throws SifException {
		super(opManager);
	}


	/* (non-Javadoc)
	 * @see com.hp.es.service.combinedEntitlement.requester.ContractRequester#buildCombinedEntitlementReply(com.hp.es.xml.service.EsRequestComplexType, com.hp.es.xml.service.EsReply)
	 */
	protected EsReply buildCombinedEntitlementReply(EsRequestComplexType request, EsReply reply) throws SifException {
        CombinedProductEntitlementComplexType result = new CombinedProductEntitlementComplexType();
        
        result.setActiveContractEntitlement(reply.getEsReplyChoice().getContractEntitlement().getActiveContractEntitlement());
        result.setOverallContractStartDate(reply.getEsReplyChoice().getContractEntitlement().getOverallContractStartDate());
        result.setOverallContractEndDate(reply.getEsReplyChoice().getContractEntitlement().getOverallContractEndDate());

        // warranty
        result.setActiveWarrantyEntitlement(false);

        result.setContact(reply.getEsReplyChoice().getContractEntitlement().getContact());
        result.setContract(reply.getEsReplyChoice().getContractEntitlement().getContract());
        result.setLocation(reply.getEsReplyChoice().getContractEntitlement().getLocation());
        result.setWorking(reply.getEsReplyChoice().getContractEntitlement().getWorking());
        result.setCustomerIdentification(reply.getEsReplyChoice().getContractEntitlement().getCustomerIdentification());
        if ((reply.getEsReplyChoice().getContractEntitlement().getOOSCount() == 0) &&
            (request.getEsRequestComplexTypeChoice().getEntitlementByPnRequest().getIncludeOOSes() == true) ) {
            // NO DATA FOUND
            ESLog.debug("No data found");
            throw ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND);
        }

        ESLog.debug("Found OOSes");
        if (request.getEsRequestComplexTypeChoice().getEntitlementByPnRequest().getIncludeOOSes()) {
            result.setOOS(reply.getEsReplyChoice().getContractEntitlement().getOOS());
        }
        else {
            result.removeAllOOS();            
        }

        ESLog.debug("Building header");
        EsHeader esHeader = new EsHeader();
        esHeader.setInputRequest(request);
        
        esHeader.setWarnings(reply.getEsHeader().getWarnings());
        
        // transaction ID is set by service handler

        EsReplyChoice esReplyChoice = new EsReplyChoice();
        esReplyChoice.setCombinedProductEntitlement(result);

        EsReply esReply = new EsReply();
        esReply.setEsHeader(esHeader);
        esReply.setEsReplyChoice(esReplyChoice);

        ESLog.debug("Exit");
        return esReply;
	}

    /**
     * Creates a new EsRequest with an contract request
     * @param combinedRequest
     * @return EsRequest with ContractRequest
     */
    protected EsRequestComplexType createContractRequest(EsRequestComplexType combinedRequest){
		EntitlementByPnRequest pnRequest = combinedRequest.getEsRequestComplexTypeChoice().getEntitlementByPnRequest();
		// create the contract request
		ContractRequest cr = new ContractRequest();
		cr.setActiveContractsOnly(pnRequest.getActiveContractsOnly());
		cr.setActiveServicesOnly( pnRequest.getActiveServicesOnly());
		cr.setContractIdentifier(pnRequest.getContractIdentifier());
		cr.setContractIdentifierType(pnRequest.getContractIdentifierType());
		cr.setCustomerDefinedID(pnRequest.getCustomerDefinedID());
		cr.setDataEntrySite(pnRequest.getDataEntrySite());
		cr.setEntitlementCheckDate(pnRequest.getEntitlementCheckDate());
		cr.setIncludeAddresses(pnRequest.getIncludeAddresses());
		cr.setIncludeContacts(pnRequest.getIncludeContacts());
		cr.setIncludeDeliverables(pnRequest.getIncludeDeliverables());
		cr.setIncludeModifiers(pnRequest.getIncludeModifiers());
		cr.setIncludeOffers(pnRequest.getIncludeOffers());
		cr.setIncludeOOSes(pnRequest.getIncludeOOSes());
		cr.setIncludeUniqueDeliverables(pnRequest.getIncludeUniqueDeliverables());
		cr.setIncludeUniqueOffers(pnRequest.getIncludeUniqueOffers());
		cr.setIncludeWorkings(pnRequest.getIncludeWorkings());
		cr.setIsoCountryCd(pnRequest.getIsoCountryCd());
		cr.setMNContractSourceDoc(pnRequest.getMNContractSourceDoc());
		cr.setProductID(pnRequest.getProductID());
		cr.setRedAccessID(pnRequest.getRedAccessID());
		cr.setRedGroupSerialNo(pnRequest.getRedGroupSerialNo());
		cr.setSourceCustomerID(pnRequest.getSourceCustomerID());
		cr.setStandAloneOffersOnly(pnRequest.getStandAloneOffersOnly());
		//SWServiceLevelCategory
		cr.setIncludeSoftwareServiceLevelCategory(pnRequest.getIncludeSoftwareServiceLevelCategory());
		//CustomerIndicator flag
		cr.setIncludeCustomerIndicator(pnRequest.getIncludeCustomerIndicator());		
		//Soecial instruction flag
		cr.setIncludeSpecialInstructions(pnRequest.getIncludeSpecialInstructions());
		cr.setIncludeManufacturerInfo(pnRequest.isIncludeManufacturerInfo());
		cr.setIncludeCustomerIdentificationInformation(pnRequest.isIncludeCustomerIdentificationInformation());
		
		// create the ES Request complex type and set the contract request
		EsRequestComplexType cRequest = new EsRequestComplexType();
        cRequest.setOperation("getContractEntitlement");
        cRequest.setClientAppID(combinedRequest.getClientAppID());
        cRequest.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
		cRequest.getEsRequestComplexTypeChoice().setContractRequest(cr);
		return cRequest;
    }	
	
}
