package com.hp.es.service.routingDetails.integration.mapping;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.routingDetails.orchestration.RoutingDetailsTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.RoutingDetailsComplexType;
import com.hp.sif.SifException;

/**
 * This class is used to map source system reply to es reply
 * @author Chunyang
 * @since 9.0.2
 */
public abstract class RoutingDetailsMapper {
    protected RoutingDetailsTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected EsRequestComplexType _request;
    static protected EsReplyContext _ctx;

    public RoutingDetailsMapper(RoutingDetailsTransaction transaction, EsRequestComplexType request, EsReplyContext ctx) {
        _transaction = transaction;
        _XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator();
        _request = request;
        _ctx = ctx;
    }

    public abstract RoutingDetailsComplexType map() throws MappingException, SifException;

    static public RoutingDetailsMapper getInstance(RoutingDetailsTransaction transaction, EsRequestComplexType request) {
        return new MetroRoutingDetailsMapper(transaction, request, _ctx);
        
    }
}