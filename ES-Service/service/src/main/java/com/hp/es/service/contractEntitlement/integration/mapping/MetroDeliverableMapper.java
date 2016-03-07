package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.List;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSDELIVERABLE;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSMODIFIER;
import com.hp.es.service.contractEntitlement.keys.DelivModifierKey;
import com.hp.es.service.contractEntitlement.keys.DeliverableKey;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.xml.service.Deliverable;
import com.hp.es.xml.service.ModifierComplexType;

class MetroDeliverableMapper extends DeliverableMapper {



	MetroDeliverableMapper(Object del, EsReplyContext ctx) {
		super(del, ctx);
		
	}

	/*
	 * Map deliverable
	 * @return deliverable (mapped)
	 */
	Deliverable map(String sourceObligationId, String item) {
		ZESCQSDELIVERABLE delObj =  (ZESCQSDELIVERABLE) _del;
		Deliverable deliverable = new Deliverable();
		ESLog.debug("Mapping Deliverable (Deliverable): ");
		/*  CQS                     ES
		 * Deliverable	DelivCode	Deliverable	DelivCode
		 * Deliverable	DelivName	Deliverable	DelivName
		 * Deliverable	DelivValue	Deliverable	DelivValue
		 */
		
		deliverable.setDelivCode(MappingUtils.nullString(delObj.getDELIVCODE()));
		deliverable.setDelivName(MappingUtils.nullString(delObj.getDELIVNAME()));
		deliverable.setDelivValue(MappingUtils.nullString(delObj.getDELIVVALUE()));
		
		deliverable.setDelivModifier(mapDelivModifiers(delObj.getDELIVMODIFIERS().getItem(), sourceObligationId, item));
		
		if(_ctx != null) {
	        String name = deliverable.getDelivName();
	        String dlvCode = deliverable.getDelivCode();
	        DeliverableKey key = new DeliverableKey(sourceObligationId, item, name, dlvCode);
	        _ctx.addDeliverable(key, deliverable);
		}		
		
		
		return deliverable;
	}

	/*
	 * map delivery modifier
	 * @param a collection of delivery modifier
	 * @return an array of ModifierComplexType
	 */
	protected ModifierComplexType[] mapDelivModifiers(List<ZESCQSMODIFIER> list, String sourceObligationId, String item) {
		ModifierComplexType[] delModifiers = null;
		ArrayList listDelModifiers = new ArrayList();
		
		
		
		//going through modifiers
		for (ZESCQSMODIFIER delMod : list) {
			ModifierMapper mapper = new MetroModifierMapper(delMod);
			ModifierComplexType delModTmp = mapper.map();
			listDelModifiers.add(mapper.map());
			if(_ctx != null) {
		        String name               =delModTmp.getModName();
		        String redDlvCode         = delModTmp.getModValue();
		        String modName            = delModTmp.getModName();
		        String redModCode         = "";

		        DelivModifierKey key = new DelivModifierKey(sourceObligationId, item,
		                                                    name, redDlvCode,
		                                                    modName, redModCode );				

		        _ctx.addDelivModifier(key, delModTmp);
			}	
		}
		

		delModifiers =(ModifierComplexType[]) listDelModifiers.toArray(new ModifierComplexType[0]);
		
		return delModifiers;
	}

}
