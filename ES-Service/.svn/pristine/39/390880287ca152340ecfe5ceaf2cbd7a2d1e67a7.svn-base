/**
 * 
 */
package com.hp.es.service.contractSummary.integration.mapping;

import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ContactComplexType;

/**
 * @author yesilyur
 *
 */
public abstract class CSContactMapper {

    protected ContractSummaryTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected EsReplyCSContext _ctx;
	
	/**
	 * 
	 */
	public CSContactMapper(ContractSummaryTransaction transaction, XMLIdGenerator XMLIdGenerator) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _ctx = null;
	}

    public CSContactMapper(ContractSummaryTransaction transaction, XMLIdGenerator XMLIdGenerator, EsReplyCSContext ctx) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _ctx = ctx;
    }

    abstract ContactComplexType[] map() throws MappingException;
	
}
