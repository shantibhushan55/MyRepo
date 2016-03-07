package com.hp.es.service.catsAgreement.integration.mapping;

import java.util.Collection;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ModifierComplexType;

abstract class ModifierMapper {
    protected Collection _a2Modifiers;

    ModifierMapper(Collection a2Modifiers) {
        _a2Modifiers = a2Modifiers;
    }

    static ModifierMapper getInstance(Collection a2Modifiers) {
        return new MetroModifierMapper(a2Modifiers);
    }

    /**
     * 
     * map
     * 
     * @return
     * @throws MappingException
     * @throws MappingException
     */
    abstract ModifierComplexType[] map() throws MappingException;
}
