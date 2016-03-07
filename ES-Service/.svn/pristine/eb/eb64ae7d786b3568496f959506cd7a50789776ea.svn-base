package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ContactComplexType;

abstract class ContactMapper {


    protected ContractTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected EsReplyContext _ctx;

    ContactMapper(ContractTransaction transaction, XMLIdGenerator XMLIdGenerator) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _ctx = null;
    }
    public ContactMapper(ContractTransaction transaction, XMLIdGenerator XMLIdGenerator, EsReplyContext ctx) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator;
        _ctx = ctx;
    }

    abstract ContactComplexType[] map() throws MappingException;
}
