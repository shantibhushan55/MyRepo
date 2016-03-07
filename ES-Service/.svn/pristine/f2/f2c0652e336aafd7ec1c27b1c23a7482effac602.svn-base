package com.hp.es.service.unitEventHistory.integration.mapping;

import com.hp.es.service.unitEventHistory.orchestration.UnitEventHistoryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsRequestComplexType;

public class UnitEventHistoryHeaderMapper {
	
    protected EsRequestComplexType _request;
    protected UnitEventHistoryTransaction _transaction;

	public UnitEventHistoryHeaderMapper(EsRequestComplexType request,
			UnitEventHistoryTransaction transaction) {
	       _request = request;
	       _transaction = transaction;
	}
	
	
	/**
     * map
     * @return
     * @throws MappingException 
     */
	public EsHeader map() throws MappingException{
    	ESLog.debug("Mapping ES header");		
    	EsHeader result = new EsHeader();
    	WarningMapper wm = WarningMapper.getInstance(_request, _transaction);
        result.setWarnings(wm.map()); 
        result.setInputRequest(_request);
        return result;
	}

}
