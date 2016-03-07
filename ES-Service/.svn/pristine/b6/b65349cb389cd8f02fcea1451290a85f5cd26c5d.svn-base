/**
 * 
 */
package com.hp.es.service.contractSummary.integration.mapping;

import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.AddressComplexType;

/**
 * @author yesilyur
 *
 */
public abstract class CSLocationMapper {

    protected ContractSummaryTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected EsReplyCSContext _ctx = null;
	
    protected CSLocationMapper(ContractSummaryTransaction transaction, XMLIdGenerator XMLIdGenerator, EsReplyCSContext ctx) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _ctx = ctx;
    }

    public CSLocationMapper(ContractSummaryTransaction transaction, XMLIdGenerator XMLIdGenerator) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _ctx = null;
    }
    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract AddressComplexType[] map() throws MappingException;
}
