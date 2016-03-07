package com.hp.es.service.manufacturingHeaderInformation.integration.mapping;

import javax.xml.bind.JAXBElement;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ManufacturingBillOfMaterialRequest;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ObjectFactory;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.sif.SifException;


public class ManufacturingInstalledBaseServiceMetroRequestMapper extends ManufacturingInstalledBaseServiceRequestMapper {

	public ManufacturingInstalledBaseServiceMetroRequestMapper(EsRequestComplexType inputRequest) {
		super(inputRequest);
	}

	/*
	 * This method generate the request
	 * (non-Javadoc)
	 * @see com.hp.es.service.manufacturingHeaderInformation.integration.mapping.ManufacturingInstalledBaseServiceRequestMapper#map()
	 */
	public ManufacturingBillOfMaterialRequest map() throws SifException {
		ManufacturingBillOfMaterialRequest esBomRequest = null;
    	ESLog.debug("Mapping ES request to SNR Manufacturing service request");	
    	String snrUserName = "";
    	String snrPassword = "";
    	String snrReturnInfoLevel = "";
    	String snrReturnInfoModifier = "";
    	
    	if(_inputRequest != null && _inputRequest.getEsRequestComplexTypeChoice() != null && _inputRequest.getEsRequestComplexTypeChoice()
    			.getWarrantyRequest() != null && _inputRequest.getEsRequestComplexTypeChoice().getWarrantyRequest().getSerialNumber() != null 
    			&& _inputRequest.getEsRequestComplexTypeChoice().getWarrantyRequest().getSerialNumber().trim().length()>0) {
    		
	    	WarrantyRequest esWarrantyRequest = _inputRequest.getEsRequestComplexTypeChoice().getWarrantyRequest();
	    	esBomRequest = new ManufacturingBillOfMaterialRequest();
	    	ObjectFactory objectFactory = new ObjectFactory();
	    	JAXBElement<String> esWarrantyRequestSn = objectFactory.createProductBillOfMaterialSerialNumber(esWarrantyRequest.getSerialNumber());
	    	JAXBElement<String> esWarrantyRequestPn = objectFactory.createProductBillOfMaterialProductNumber(esWarrantyRequest.getProductID()); 
	    	esBomRequest.setSerialNumber(esWarrantyRequestSn);
	    	esBomRequest.setProductNumber(esWarrantyRequestPn);
	    		    	
	    	snrUserName = Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_USER_NAME);
	    	snrPassword = Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_PWD);
	    	snrReturnInfoLevel = Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_RETURN_INFO_LEVEL);
	    	snrReturnInfoModifier = Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_RETURN_INFO_MODIFIER);
	    	
	    	esBomRequest.setPassword(objectFactory.createManufacturingBillOfMaterialRequestPassword(snrPassword));
	    	esBomRequest.setUserName(objectFactory.createManufacturingBillOfMaterialRequestUserName(snrUserName));
	    	
	    	esBomRequest.setReturnInfoLevel(objectFactory.createManufacturingBillOfMaterialRequestReturnInfoLevel(snrReturnInfoLevel));
	    	esBomRequest.setReturnInfoModifier(objectFactory.createManufacturingBillOfMaterialRequestReturnInfoModifier(snrReturnInfoModifier));
	    	
	    	
    	}else {
    		throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Input SNR request not supported");
    	}
		return esBomRequest;
	}

}
