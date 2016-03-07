/*
 * Created on Mar 10, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.Collection;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.Deliverable;

/**
 * @author JUHANK
 */
abstract class DeliverableMapper {
	protected Collection _swopDeliverables;

    DeliverableMapper(Collection swopDeliverables) {
    	_swopDeliverables = swopDeliverables;
    }

    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract Deliverable[] map() throws MappingException;

}
