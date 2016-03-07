/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.ibSearch.integration.mapping;

import com.hp.es.service.ibSearch.orchestration.IBSearchTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsRequestComplexType;

/**
 * @author JUHANK
 */
public class IBHeaderMapper {
	
    protected EsRequestComplexType _request;
    protected IBSearchTransaction _transaction;

    public IBHeaderMapper(EsRequestComplexType request, IBSearchTransaction transaction) {
        _request = request;
        _transaction = transaction;
    }

    /**
     * map
     * @return
     * @throws MappingException 
     */
    public EsHeader map() throws MappingException {
    	ESLog.debug("Mapping ES header");		
    	EsHeader result = new EsHeader();
    	WarningMapper wm = WarningMapper.getInstance(_request, _transaction);
        result.setWarnings(wm.map()); 
        result.setInputRequest(_request);
        return result;
    }
}
