package com.hp.es.service.catsAgreement.integration.mapping;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2AESDELIVERABLEV3S;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.Deliverable;

/**
 * 
 * @author Chunyang Wang
 * 
 */
public class MetroDeliverableMapper extends DeliverableMapper {
    MetroDeliverableMapper(Collection a2Deliverables) {
        super(a2Deliverables);
    }

    Deliverable[] map() throws MappingException {
        if (_a2Deliverables == null) {
            return new Deliverable[0];
        }

        ESLog.debug("Mapping " + _a2Deliverables.size() + " deliverables.");
        Deliverable[] deliverables = new Deliverable[_a2Deliverables.size()];

        Iterator iterator = _a2Deliverables.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            deliverables[i++] = mapDeliverable((ZA2AESDELIVERABLEV3S) iterator.next());
        }
        return deliverables;
    }

    /**
     * mapDeliverable
     * 
     * @param a2Deliverable
     * @return
     * @throws MappingException
     */
    private Deliverable mapDeliverable(ZA2AESDELIVERABLEV3S a2Deliverable) throws MappingException {
        ESLog.debug("Mapping deliverable: " + a2Deliverable.getDELIVERABLENAME());
        Deliverable deliverable = new Deliverable();
        deliverable.setDelivCode(MappingUtils.nullString(a2Deliverable.getDELIVERABLENAME()));
        deliverable.setDelivName(MappingUtils.nullString(a2Deliverable.getDELIVERABLE()));
        deliverable.setDelivValue(a2Deliverable.getDELIVERABLEVALUE());

        return deliverable;
    }

}
