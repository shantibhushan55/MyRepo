package com.hp.es.service.catsAgreement.integration.mapping;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESMODIFIERV3S;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ModifierComplexType;

public class MetroModifierMapper extends ModifierMapper {

    MetroModifierMapper(Collection a2Modifiers) {
        super(a2Modifiers);
    }

    ModifierComplexType[] map() throws MappingException {
        if (_a2Modifiers == null) {
            return new ModifierComplexType[0];
        }
        ESLog.debug("Mapping " + _a2Modifiers.size() + " modifiers ...");
        ModifierComplexType[] modifiers = new ModifierComplexType[_a2Modifiers.size()];

        Iterator iterator = _a2Modifiers.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            modifiers[i] = mapModifier((ZA2AESMODIFIERV3S) iterator.next());
            i++;
        }
        return modifiers;
    }

    private ModifierComplexType mapModifier(ZA2AESMODIFIERV3S a2Modifier) {

        ESLog.debug("Mapping modifier: " + a2Modifier.getMODIFIERNAME());
        ModifierComplexType modifier = new ModifierComplexType();
        modifier.setModName(MappingUtils.nullString(a2Modifier.getMODIFIERNAME()));
        modifier.setModValue(MappingUtils.nullString(a2Modifier.getMODIFIERVALUE()));
        modifier.setModDesc(a2Modifier.getMODIFIER());

        return modifier;
    }

}
