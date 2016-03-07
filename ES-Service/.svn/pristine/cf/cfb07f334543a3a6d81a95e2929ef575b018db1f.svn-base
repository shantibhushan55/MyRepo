package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCONTRACTENTBYSNES10;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSENBYSNREQUESTV1;
import com.hp.es.service.util.DateHelper;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsRequestComplexType;

class MetroCQSBySNRequestMapper extends CQSBySNRequestMapper {

	MetroCQSBySNRequestMapper() {
		super();
	}
	
	
	public Object map(EsRequestComplexType esRequest) {
		// For brevity, extract the ContractRequest from the incoming EsRequest
		EntitlementBySnRequest sr = esRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest();

		// Create the request structure
		ZESCQSENBYSNREQUESTV1 cqsRequest = new ZESCQSENBYSNREQUESTV1();

		// Populate the request structure fields from the esRequest
		cqsRequest.setPRODUCTID(sr.getProductID());
		cqsRequest.setSERIALNUMBER(sr.getSerialNumber());
		
		cqsRequest.setCHECKDATE(DateHelper.toIsoDateString(sr.getEntitlementCheckDate()));
		cqsRequest.setCONTRACTIDENTIFIER(sr.getContractIdentifier());
		
		if (sr.getContractIdentifierType() != null) {
			if (sr.getContractIdentifierType().toString().equals("FunctionalLocation"))
				// The CQS interface uses SAR instead of FunctionalLocation
				cqsRequest.setCONTRACTIDENTIFIERTYPE("SAR");
			else
				cqsRequest.setCONTRACTIDENTIFIERTYPE(sr.getContractIdentifierType().toString());
		}
		
		cqsRequest.setDATAENTRYSITE(sr.getDataEntrySite());

		cqsRequest.setSOURCECUSTOMERID(sr.getSourceCustomerID());
		cqsRequest.setACTIVECONTRACTSONLY(sr.getActiveContractsOnly() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setACTIVESERVICESONLY(sr.getActiveServicesOnly() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);

		cqsRequest.setINCLUDEADDRESSES(sr.getIncludeAddresses() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDECONTACTS(sr.getIncludeContacts() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		
		
		cqsRequest.setINCLUDESERVICES(sr.getIncludeOffers() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		/* WITS 1471: No special mapping for modifiers and deliverables needed any longer.
		 * This is now done in RequestCleaner() */
		cqsRequest.setINCLUDEDELIVERABLES(sr.getIncludeDeliverables() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		cqsRequest.setINCLUDEMODIFIERS(sr.getIncludeModifiers() ? EsConstants.ABAP_TRUE : EsConstants.ABAP_FALSE);
		/*if(sr.getIncludeModifiers() ) {
			cqsRequest.setINCLUDESERVICES(EsConstants.ABAPTRUE);
			cqsRequest.setINCLUDEDELIVERABLES(EsConstants.ABAPTRUE);
			cqsRequest.setINCLUDEMODIFIERS(EsConstants.ABAPTRUE);			
		}else if(sr.getIncludeDeliverables()) {
			cqsRequest.setINCLUDESERVICES(EsConstants.ABAPTRUE);
			cqsRequest.setINCLUDEDELIVERABLES(EsConstants.ABAPTRUE);
			cqsRequest.setINCLUDEMODIFIERS(EsConstants.ABAPFALSE);
		}else if (sr.getIncludeOffers()) {
			cqsRequest.setINCLUDESERVICES(EsConstants.ABAPTRUE);
			cqsRequest.setINCLUDEDELIVERABLES(EsConstants.ABAPFALSE);
			cqsRequest.setINCLUDEMODIFIERS(EsConstants.ABAPFALSE);
		}else {
			cqsRequest.setINCLUDESERVICES(EsConstants.ABAPFALSE);
			cqsRequest.setINCLUDEDELIVERABLES(EsConstants.ABAPFALSE);
			cqsRequest.setINCLUDEMODIFIERS(EsConstants.ABAPFALSE);		
		} 
		END WITS.1471*/	
		
		if(sr.isIncludeManufacturerInfo()) {
			cqsRequest.setINCLUDEMVINFOR(EsConstants.ABAP_TRUE);
		} else {
			cqsRequest.setINCLUDEMVINFOR(EsConstants.ABAP_FALSE);
		}
		
		if(sr.isIncludeCustomerIdentificationInformation()) { 
			cqsRequest.setINCLUDECUSTOMERIDINFO(EsConstants.ABAP_TRUE);
		} else {
			cqsRequest.setINCLUDECUSTOMERIDINFO(EsConstants.ABAP_FALSE);
		}
		
		
		
		// Now fill the resulting object
		ZESCONTRACTENTBYSNES10 result = new ZESCONTRACTENTBYSNES10();

		
		result.setESREQUEST(cqsRequest);

		return result;

	}



}
