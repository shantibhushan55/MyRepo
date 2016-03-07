package com.hp.es.service.routingDetails.integration.mapping;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.routingDetails.orchestration.RoutingDetailsTransaction;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.RoutingDetailsComplexType;
import com.hp.sif.SifException;

/**
 * 
 * @author Chunyang
 * @since 9.0.2
 */
public class SOAPRoutingDetailsMapper extends RoutingDetailsMapper {

    public SOAPRoutingDetailsMapper(RoutingDetailsTransaction transaction, EsRequestComplexType request,
            EsReplyContext ctx) {
        super(transaction, request, ctx);
    }

    public RoutingDetailsComplexType map() throws MappingException, SifException {
        // 
        return null;
    }

}
