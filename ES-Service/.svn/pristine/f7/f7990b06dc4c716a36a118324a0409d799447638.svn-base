package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTES10;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSCONTRACTENREQUESTV1;
import com.hp.es.service.util.DateHelper;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.types.ContractIdentifierTypeType;



class MetroCQSRequestMapper extends CQSRequestMapper{

	protected MetroCQSRequestMapper() {
		super();
	}
	
	public Object map(EsRequestComplexType esRequest) {

		// For brevity, extract the ContractRequest from the incoming EsRequest
		ContractRequest cr = esRequest.getEsRequestComplexTypeChoice().getContractRequest();

		// Create the request structure
		ZESCQSCONTRACTENREQUESTV1 cqsRequest = new ZESCQSCONTRACTENREQUESTV1();

		// Populate the request structure fields from the esRequest
		cqsRequest.setPRODUCTID(cr.getProductID());
		cqsRequest.setISOCOUNTRYCODE(cr.getIsoCountryCd());
		cqsRequest.setCHECKDATE(DateHelper.toIsoDateString(cr.getEntitlementCheckDate()));
		cqsRequest.setCONTRACTIDENTIFIER(cr.getContractIdentifier());
		ContractIdentifierTypeType requestType = cr.getContractIdentifierType();
		if (requestType != null)
		{
			if ("FunctionalLocation".equals(requestType.toString()))
				// The CQS interface uses SAR instead of FunctionalLocation
				cqsRequest.setCONTRACTIDENTIFIERTYPE("SAR");
			else 
				cqsRequest.setCONTRACTIDENTIFIERTYPE(requestType.toString());
		}
		cqsRequest.setDATAENTRYSITE(cr.getDataEntrySite());
		cqsRequest.setCUSTOMERDEFINEDID(cr.getCustomerDefinedID());
		cqsRequest.setSOURCECUSTOMERID(cr.getSourceCustomerID());
		cqsRequest.setACTIVECONTRACTSONLY(cr.getActiveContractsOnly() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setACTIVESERVICESONLY(cr.getActiveServicesOnly() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setSTANDALONEOFFERSONLY(cr.getStandAloneOffersOnly() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDEOOSES(EsConstants.ABAP_TRUE);
		cqsRequest.setINCLUDEADDRESSES(cr.getIncludeAddresses() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDECONTACTS(cr.getIncludeContacts() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		
		/* WITS 1471: No special mapping for modifiers and deliverables needed any longer.
		 * This is now done in RequestCleaner() */
		cqsRequest.setINCLUDESERVICES(cr.getIncludeOffers() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDEDELIVERABLES(cr.getIncludeDeliverables() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDEMODIFIERS(cr.getIncludeModifiers() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		/*
		if(cr.getIncludeModifiers() ) {
			cqsRequest.setINCLUDE_SERVICES(EsConstants.ABAP_TRUE);
			cqsRequest.setINCLUDE_DELIVERABLES(EsConstants.ABAP_TRUE);
			cqsRequest.setINCLUDE_MODIFIERS(EsConstants.ABAP_TRUE);			
		}else if(cr.getIncludeUniqueDeliverables()) {
		//WITS.1464: Use Deliverables to compile the UniqueDeliverables afterwards
		}else if(cr.getIncludeDeliverables() | cr.getIncludeUniqueDeliverables()) {
			//In that case 
			cqsRequest.setINCLUDE_SERVICES(EsConstants.ABAP_TRUE);
			cqsRequest.setINCLUDE_DELIVERABLES(EsConstants.ABAP_TRUE);
			cqsRequest.setINCLUDE_MODIFIERS(EsConstants.ABAP_FALSE);
			//WITS.1464: Use Services to compile the UniqueOffers afterwards
			}else if (cr.getIncludeOffers() | cr.getIncludeUniqueOffers()) {
			cqsRequest.setINCLUDE_SERVICES(EsConstants.ABAP_TRUE);
			cqsRequest.setINCLUDE_DELIVERABLES(EsConstants.ABAP_FALSE);
			cqsRequest.setINCLUDE_MODIFIERS(EsConstants.ABAP_FALSE);
		}else {
			cqsRequest.setINCLUDE_SERVICES(EsConstants.ABAP_FALSE);
			cqsRequest.setINCLUDE_DELIVERABLES(EsConstants.ABAP_FALSE);
			cqsRequest.setINCLUDE_MODIFIERS(EsConstants.ABAP_FALSE);		
		}
		END WITS 1471*/
		//WITS.1464: Use Deliverables to compile the UniqueDeliverables afterwards
		if(cr.getIncludeUniqueDeliverables() & !cr.getIncludeDeliverables()) {
			//In that case 
			cqsRequest.setINCLUDESERVICES(EsConstants.ABAP_TRUE);
			cqsRequest.setINCLUDEDELIVERABLES(EsConstants.ABAP_TRUE);
		//WITS.1464: Use Services to compile the UniqueOffers afterwards
		}else if (cr.getIncludeUniqueOffers() & !cr.getIncludeOffers()) {
			cqsRequest.setINCLUDESERVICES(EsConstants.ABAP_TRUE);
		}//End WITS.1464
				
		cqsRequest.setINCLUDESPECIALINSTRUCTIONS(cr.getIncludeSpecialInstructions() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDESWSERVICELEVELCAT(cr.getIncludeSoftwareServiceLevelCategory() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);

		cqsRequest.setMAXOOSESNO("99999");
		
		if(cr.isIncludeManufacturerInfo()) {
			cqsRequest.setINCLUDEMVINFOR(EsConstants.ABAP_TRUE);
		} else {
			cqsRequest.setINCLUDEMVINFOR(EsConstants.ABAP_FALSE);
		}
		
		
		if(cr.isIncludeCustomerIdentificationInformation()) { 
			cqsRequest.setINCLUDECUSTOMERIDINFO(EsConstants.ABAP_TRUE);
		} else {
			cqsRequest.setINCLUDECUSTOMERIDINFO(EsConstants.ABAP_FALSE);
		}
		// Now fill the resulting object
		ZESCONTRACTENTES10 result = new ZESCONTRACTENTES10();
		result.setESREQUEST(cqsRequest);

		return result;
	}


	
	
}
