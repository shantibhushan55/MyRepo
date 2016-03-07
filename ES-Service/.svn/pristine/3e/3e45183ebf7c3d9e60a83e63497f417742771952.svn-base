package com.hp.es.service.ibSearch.integration.mapping;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH.ZWARRANTYWILDCARDSEARCH;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.InstalledBaseUnitRequest;

public class MetroRequestMapper extends RequestMapper {

	public MetroRequestMapper(EsRequestComplexType inputRequest) {
		super(inputRequest);
	}

	public Object map() {
    	ESLog.debug("Mapping ES request to IB request");		
    	InstalledBaseUnitRequest esRequest = _inputRequest.getEsRequestComplexTypeChoice().getInstalledBaseUnitRequest();
    	ZWARRANTYWILDCARDSEARCH ibRequest = new ZWARRANTYWILDCARDSEARCH();
    	ibRequest.setPRODUCTNUM(esRequest.getProductID());
    	ibRequest.setSERIALNUM(esRequest.getInstalledBaseUnitRequestChoice().getSerialNumber());
    	ibRequest.setSALESORDERNUM(esRequest.getInstalledBaseUnitRequestChoice().getSalesOrderNumber());
    	ibRequest.setTOTALRECORDRETURN(String.valueOf(MappingHelper.getInstance().getRequestedTotalResultSize(esRequest)));
		return ibRequest;
	}

}
