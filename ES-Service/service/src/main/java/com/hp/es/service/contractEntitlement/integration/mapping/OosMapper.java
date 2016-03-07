package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.OOSComplexType;

abstract class OosMapper {

    protected ContractTransaction _transaction;
	protected XMLIdGenerator _generator;
	protected EsReplyContext _ctx = null;

    protected OosMapper(ContractTransaction transaction, XMLIdGenerator generator, EsReplyContext ctx) {
        _transaction = transaction;
        _generator = generator;
        _ctx  = ctx;
    }

    public OosMapper(ContractTransaction transaction, XMLIdGenerator generator) {
        _transaction = transaction;
        _generator = generator;
        _ctx = null;
    }
    /*
     * map
     * @return OOSComplexType[]
     */
    abstract OOSComplexType[] map() throws MappingException;
}
