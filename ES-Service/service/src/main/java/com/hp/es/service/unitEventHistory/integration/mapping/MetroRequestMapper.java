package com.hp.es.service.unitEventHistory.integration.mapping;

import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWARRANTYEVENTHISTORY;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.UnitEventHistoryRequest;

public class MetroRequestMapper extends RequestMapper {

	public MetroRequestMapper(EsRequestComplexType inputRequest) {
		super(inputRequest);
	}

	public Object map() {
    	ESLog.debug("Mapping ES request to ZWARRANTYEVENTHISTORY request");		
    	UnitEventHistoryRequest esRequest = _inputRequest.getEsRequestComplexTypeChoice().getUnitEventHistoryRequest();
    	ZWARRANTYEVENTHISTORY unitEventHistoryRequest = new ZWARRANTYEVENTHISTORY();
    	unitEventHistoryRequest.setPRODUCTNUM(esRequest.getProductNumber());
    	unitEventHistoryRequest.setSERIALNUM(esRequest.getSerialNumber());
		return unitEventHistoryRequest;
	}

}
