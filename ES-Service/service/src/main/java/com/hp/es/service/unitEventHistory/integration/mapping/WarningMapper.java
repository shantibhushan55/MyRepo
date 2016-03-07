
package com.hp.es.service.unitEventHistory.integration.mapping;

import com.hp.es.service.unitEventHistory.orchestration.UnitEventHistoryTransaction;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;

/**
 * @author BURRELLWB
 */
abstract public class WarningMapper {
	
    protected EsRequestComplexType _request;
    protected UnitEventHistoryTransaction _transaction;

    public WarningMapper(EsRequestComplexType request, UnitEventHistoryTransaction transaction) {
    	_request = request;
    	_transaction = transaction;
    }

    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract public Warnings map() throws MappingException; 

	public static WarningMapper getInstance(EsRequestComplexType request, UnitEventHistoryTransaction transaction) {
        return new MetroWarningMapper(request, transaction);
 	}

}
	
