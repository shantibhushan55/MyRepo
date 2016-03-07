package com.hp.es.service.warrantyEntitlement.integration.mapping;

import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWARRANTYLOOKUPPARALLELBSU;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;
import com.hp.es.xml.service.WarrantyRequest;

public class MetroRequestMapper extends RequestMapper {

	protected MetroRequestMapper(EsRequestComplexType inputRequest,
			String performProductBasedCalculation, ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply) {
		super(inputRequest, performProductBasedCalculation,manufacturingInstalledBaseServiceReply);
	}

	public Object map() {
    	ESLog.debug("Mapping ES request to SWOP request");		
		WarrantyRequest warrantyRequest = _inputRequest.getEsRequestComplexTypeChoice().getWarrantyRequest();
		
		ZWARRANTYLOOKUPPARALLELBSU swopRequest = new ZWARRANTYLOOKUPPARALLELBSU();
		swopRequest.setISOCOUNTRYCODE(warrantyRequest.getIsoCountryCd());
		swopRequest.setSERIALNUM(warrantyRequest.getSerialNumber());
		swopRequest.setPRODUCTNUM(warrantyRequest.getProductID());
		
		swopRequest.setPROOFOFPURCHASEDATE(MappingUtils.mapCastorToXMLDate(warrantyRequest.getProofPurchaseDate()));
		swopRequest.setSERVICEIDNUM(warrantyRequest.getServiceID());
		swopRequest.setRETRIEVEADDRESS(MappingUtils.mapOptionalBoolean(true, warrantyRequest.getIncludeAddresses()));
		swopRequest.setSPAREPARTNUM(warrantyRequest.getSparePartNumber());
		
		if(_manufacturingInstalledBaseServiceReply != null) {
			ESLog.debug("Mapping snr reply to SWOP request");	
			if(_manufacturingInstalledBaseServiceReply.getManufacturingDate() != null)
				swopRequest.setSNRMANUFACTUREDATE(DateHelper.toIsoDateString(_manufacturingInstalledBaseServiceReply.getManufacturingDate()));
			
			if(_manufacturingInstalledBaseServiceReply.getShipmentDate() != null)
				swopRequest.setSNRSHIPDATE(DateHelper.toIsoDateString(_manufacturingInstalledBaseServiceReply.getShipmentDate()));
			
			if(_manufacturingInstalledBaseServiceReply.getReturnDate() != null)
				swopRequest.setSNRRETURNDATE(DateHelper.toIsoDateString(_manufacturingInstalledBaseServiceReply.getReturnDate()));
			/*
			if(warrantyRequest.getProductID() == null || warrantyRequest.getProductID().trim().length()==0) {
				swopRequest.setPRODUCTNUM(_manufacturingInstalledBaseServiceReply.getOutputHpProductId());
			}*/
		}
		
		swopRequest.setDATECODE(warrantyRequest.getDateCode());
		if(_performProductBasedCalculation != null && "X".equalsIgnoreCase(_performProductBasedCalculation)) {
			swopRequest.setIVLOCALSYSTEM(_performProductBasedCalculation);
		}
       /*
        * Request parameters for 3G functionality (OWNERSHIPTYPE and PARTLEVELWARRANTY) .
        */
		String ownershiptype=warrantyRequest.getCustomerOwnershipType();
		
		if(ownershiptype != null)  {
			if ("consumer".equalsIgnoreCase(ownershiptype.trim())) {
				ownershiptype="01";
			}else if ("commercial".equalsIgnoreCase(ownershiptype.trim())) {
				ownershiptype="02";
			}else if ("01".equalsIgnoreCase(ownershiptype.trim())) {
				ownershiptype="01";
			}else if ("02".equalsIgnoreCase(ownershiptype.trim())) {
				ownershiptype="02";
			}
			swopRequest.setOWNERSHIPTYPE(ownershiptype);	
		}
		if(warrantyRequest.getIncludePartLevelWarranty()) {		
			swopRequest.setPARTLEVELWARRANTY("X");
		}

		return swopRequest;

	}

}
