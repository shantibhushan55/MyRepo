/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.ibSearch.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;

/**
 * @author JUHANK
 */
public abstract class ErrorMapper {
	protected Collection _ibErrors;
	protected EsRequestComplexType _request;
	
    protected ErrorMapper(Collection ibErrors, EsRequestComplexType request) {
    	_ibErrors = ibErrors;
    	_request = request;
    }

    
    
    public static ErrorMapper getInstance(Collection ibErrors, EsRequestComplexType request) {
            return new MetroErrorMapper(ibErrors,  request);
    }
    
    
    /**
     * map
     * @return
     * @throws MappingException
     */
    public abstract ArrayList map() throws MappingException;
    

}
