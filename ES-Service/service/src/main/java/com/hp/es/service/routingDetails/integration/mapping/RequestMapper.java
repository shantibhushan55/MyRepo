package com.hp.es.service.routingDetails.integration.mapping;

import com.hp.es.xml.service.EsRequestComplexType;

/**
 * 
 * @author Chunyang
 * @since 9.0.2
 */
public abstract class RequestMapper {
    EsRequestComplexType _inputRequest = null;

    protected RequestMapper(EsRequestComplexType inputRequest) {
        _inputRequest = inputRequest;
    }

    /**
     * maps the ES request
     * 
     * @return
     */
    public abstract Object map();

    public static RequestMapper getInstance(EsRequestComplexType inputRequest) {
            return new MetroRequestMapper(inputRequest);

    }

}
