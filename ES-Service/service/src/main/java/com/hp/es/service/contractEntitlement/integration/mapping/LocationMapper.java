package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.LocationComplexType;

abstract class LocationMapper {

    protected ContractTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected EsReplyContext _ctx = null;

    protected LocationMapper(ContractTransaction transaction, XMLIdGenerator XMLIdGenerator, EsReplyContext ctx) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _ctx = ctx;
    }

    public LocationMapper(ContractTransaction transaction, XMLIdGenerator XMLIdGenerator) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _ctx = null;
    }
    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract LocationComplexType[] map() throws MappingException;
}
