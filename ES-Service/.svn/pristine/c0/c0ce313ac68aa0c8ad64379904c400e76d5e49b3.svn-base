/*
 * Created on Mar 10, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.Collection;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ModifierComplexType;

/**
 * @author JUHANK
 */
abstract class ModifierMapper {
	
	protected Collection _swopModifiers;

    ModifierMapper(Collection swopModifiers) {
    	_swopModifiers = swopModifiers;
    }

    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract ModifierComplexType[] map() throws MappingException;


}
