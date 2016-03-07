/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.ibSearch.integration.mapping;

import com.hp.es.service.ibSearch.orchestration.IBSearchTransaction;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;

/**
 * @author JUHANK
 */
abstract public class WarningMapper {
	
    protected EsRequestComplexType _request;
    protected IBSearchTransaction _transaction;

    public WarningMapper(EsRequestComplexType request, IBSearchTransaction transaction) {
    	_request = request;
    	_transaction = transaction;
    }

    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract public Warnings map() throws MappingException; 

	public static WarningMapper getInstance(EsRequestComplexType request, IBSearchTransaction transaction) {

            return new MetroWarningMapper(request, transaction);
	}

}
