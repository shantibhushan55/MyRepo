package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYMODIFIERLINE;
import com.hp.es.xml.service.ModifierComplexType;

public class MetroModifierMapper extends ModifierMapper {

	public MetroModifierMapper(Collection swopModifiers) {
		super(swopModifiers);
	}

	 /**
     * map
     * @return
     * @throws MappingException
     */
    ModifierComplexType[] map() throws MappingException    {
    	if(_swopModifiers == null) {
    		return new ModifierComplexType[0];
    	}
    	
    	ESLog.debug("Mapping " + _swopModifiers.size() + "modifiers ...");
    	ModifierComplexType[] modifiers = new ModifierComplexType[_swopModifiers.size()];
    	
    	Iterator iterator = _swopModifiers.iterator();
		int i = 0;
    	while(iterator.hasNext()) {
    		modifiers[i] = mapModifier((ZWTYMODIFIERLINE) iterator.next());
    		i++;
    	}
        return modifiers;
    }

    /**
     * mapModifier
     * @param swopModifier
     * @return
     * @throws MappingException
     */
     protected ModifierComplexType mapModifier(ZWTYMODIFIERLINE swopModifier) throws MappingException {

    	ESLog.debug("Mapping modifier: " + swopModifier.getMODNAME());
     	ModifierComplexType modifier = new ModifierComplexType();
     	modifier.setModName(MappingUtils.nullString(swopModifier.getMODNAME())); 
     	modifier.setModValue(MappingUtils.nullString(swopModifier.getMODVALUE()));
     	modifier.setModDesc(swopModifier.getMODDESC());
     	
        return modifier;
    }

}
