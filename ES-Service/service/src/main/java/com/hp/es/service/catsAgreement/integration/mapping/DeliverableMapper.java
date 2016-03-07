package com.hp.es.service.catsAgreement.integration.mapping;

import java.util.Collection;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.Deliverable;

abstract class DeliverableMapper {

    protected Collection _a2Deliverables;

    DeliverableMapper(Collection a2Deliverables) {
        _a2Deliverables = a2Deliverables;
    }

    /**
     * map
     * 
     * @return
     * @throws MappingException
     */
    abstract Deliverable[] map() throws MappingException;
}
