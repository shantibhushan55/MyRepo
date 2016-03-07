/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.unitEventHistory.integration.mapping;

import com.hp.es.xml.service.EsRequestComplexType;

/**
 * @author JUHANK
 */
public abstract class RequestMapper {
	EsRequestComplexType _inputRequest = null;

	protected RequestMapper(EsRequestComplexType inputRequest) {
		_inputRequest = inputRequest;
	}

	/**
	 * maps the ES request
	 * @return
	 */
	public abstract Object map();

	
    public static RequestMapper getInstance(EsRequestComplexType inputRequest) {
            return new MetroRequestMapper(inputRequest);
        
    }
}
