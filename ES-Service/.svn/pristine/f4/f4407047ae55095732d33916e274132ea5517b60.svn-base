/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSMODIFIER;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.xml.service.ModifierComplexType;

/**
 * @author anvoi
 *
 */
class MetroModifierMapper extends  ModifierMapper{

	/**
	 * @param _generator 
	 * @param modifier 
	 * 
	 */
	MetroModifierMapper(Object modifier) {
		super(modifier);

	}

	ModifierComplexType map() {
	    ZESCQSMODIFIER modifier = (ZESCQSMODIFIER)_modifierObject;
		ModifierComplexType mod = new ModifierComplexType();
		ESLog.debug("Mapping modifier ");
		
		mod.setModDesc(MappingUtils.nullString(modifier.getMODDESC()));
		mod.setModName(MappingUtils.nullString(modifier.getMODNAME()));
		mod.setModValue(MappingUtils.nullString(modifier.getMODVALUE()));
		return mod;
	}

}
