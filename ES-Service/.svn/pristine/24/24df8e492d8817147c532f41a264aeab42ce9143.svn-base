package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWTYDELIVERABLE;
import com.hp.es.xml.service.Deliverable;

class MetroDeliverableMapper extends DeliverableMapper {

	MetroDeliverableMapper(Collection swopDeliverables) {
		super(swopDeliverables);
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.warrantyEntitlement.integration.mapping.DeliverableMapper#map()
	 */
	Deliverable[] map() throws MappingException 
	{
		if(_swopDeliverables == null) {
			return new Deliverable[0];
		}
		
	 	ESLog.debug("Mapping " + _swopDeliverables.size() + " deliverables ...");
		Deliverable[] deliverables = new Deliverable[_swopDeliverables.size()];
		
		Iterator iterator = _swopDeliverables.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			deliverables[i] = mapDeliverable((ZWTYDELIVERABLE) iterator.next());
			i++;
		}
	    return deliverables;
	}

	/**
	 * mapDeliverable
	 * @param swopDeliverable
	 * @return
	 * @throws MappingException
	 */
	 private Deliverable mapDeliverable(ZWTYDELIVERABLE swopDeliverable) throws MappingException {
	 	ESLog.debug("Mapping deliverable: " + swopDeliverable.getDELIVNAME());
	 	Deliverable deliverable = new Deliverable();
	 	deliverable.setDelivCode(MappingUtils.nullString(swopDeliverable.getDELIVCODE()));
	 	deliverable.setDelivName(MappingUtils.nullString(swopDeliverable.getDELIVNAME()));
	 	deliverable.setDelivValue(swopDeliverable.getDELIVVALUE());
	 	
	    return deliverable;
	}

}
