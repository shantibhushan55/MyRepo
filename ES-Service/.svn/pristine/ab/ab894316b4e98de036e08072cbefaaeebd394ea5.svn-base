/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSAPPLIESTO;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOBJECTREF;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSPROFITCENTER;
import com.hp.es.service.contractEntitlement.keys.AppliesToKey;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ProfitCenter;
import com.hp.es.xml.service.types.StatusType;

/**
 * @author anvoi
 *
 */
class MetroAppliesToMapper extends AppliesToMapper {



	/**
	 * @param oosMap 
	 * @param _generator 
	 * @param appl 
	 * 
	 */
	MetroAppliesToMapper(ZESCQSAPPLIESTO appl, XMLIdGenerator generator, Map oosMapbyOOSKey, Map oosKeyListMapbyOOSGroupId, EsReplyContext ctx) {
		super(appl, generator, oosMapbyOOSKey, oosKeyListMapbyOOSGroupId, ctx);
	}

	/*
	 * Mapping applies to
	 */
	Collection map(String sourceObligationId, String item) {
		ArrayList lisApplyTo = new ArrayList();
		ZESCQSAPPLIESTO applObj = (ZESCQSAPPLIESTO) _appl; 
		ESLog.debug("Mapping Service (Applies To)");
		
		/*
		 * AppliesTo Mapping
		* The CQS AppliesTo-Element has the same structure as in CDO, which is different to ES:
		* ObjectType= OOSGroup or OOS
		*  ObjectRef  - ObjectRefKey = OOSGroup/Functional Locatio or OOSKey
		* 
		* Logic:
		* If Applies to with ObjectType= OOS
		* 	CQS AppliesTo ObjectRef  - ObjectRefKey is directly mapped to ES Applies - OOSkey
		* Else
		* 	All OOS - OOSkey belonging to OOSes having an OOSGroupID matching the CQS.ObjectRefKey need to be mapped to ES Applies - OOSkey.
		* 	In this case one ES ES Applies can reference several OOSe
		 */
		
		if(applObj.getOBJECTTYPE() != null && applObj.getOBJECTTYPE().trim().equalsIgnoreCase(OOS_TYPE)) {
			
			Collection listAppl = applObj.getOBJECTREF().getItem();
			Iterator itAppl = listAppl.iterator();
			while(itAppl.hasNext()) {
				ZESCQSOBJECTREF objRef = (ZESCQSOBJECTREF) itAppl.next();
				
				AppliesTo appl = createAppliesToWithNoRef(objRef);
				
				
				appl.setOOSRef(getOOS(objRef.getOBJECTREFKEY()));
				appl.setOOSKey(MappingUtils.nullString(objRef.getOBJECTREFKEY()));
				
				
				
				lisApplyTo.add(appl);
				if(_ctx != null) {

			        String oosKey             = appl.getOOSKey();

			        AppliesToKey key = new AppliesToKey(sourceObligationId, item, oosKey);
			        _ctx.addAppliesTo(key,appl);
				}			
			}
			
			
			
		}else {
			Collection listAppl = applObj.getOBJECTREF().getItem();
			Iterator itAppl = listAppl.iterator();
			while(itAppl.hasNext()) {
				ZESCQSOBJECTREF objRef = (ZESCQSOBJECTREF) itAppl.next();
				Collection tmpCol = getOOSKeyListForOOSGroupId(objRef.getOBJECTREFKEY());
				if(tmpCol != null) {
					Iterator itOOSkey = tmpCol.iterator();
					
					while(itOOSkey.hasNext()) {
						String    oosKey = (String) itOOSkey.next();
						AppliesTo appl = createAppliesToWithNoRef(objRef);
						OOSComplexType tmp = getOOS(oosKey);
						appl.setOOSRef(tmp);
						appl.setOOSKey(tmp.getOOSKey());
						if(_ctx != null) {
					        AppliesToKey key = new AppliesToKey(sourceObligationId, item, oosKey);
					        _ctx.addAppliesTo(key,appl);
						}						
						lisApplyTo.add(appl);
					}
				}else{
				    //fixed for "QC.CR.ID 1716 Missing AppliesTo if includeOOS = false for OOSGroup"
				    AppliesTo appl = createAppliesToWithNoRef(objRef);
				    if(_ctx != null) {
                        AppliesToKey key = new AppliesToKey(sourceObligationId, item, "");
                        _ctx.addAppliesTo(key,appl);
                    }                       
                    lisApplyTo.add(appl);
				}
			}
		}
		return lisApplyTo;
	}




	/*
	 * create a standard apply to
	 */
	protected AppliesTo createAppliesToWithNoRef(ZESCQSOBJECTREF objRef) {
		AppliesTo appl = new AppliesTo();
		
		appl.setActiveAppliesTo(MappingUtils.mapToBoolean(objRef.getACTIVEAPPLIESTO()));
		
		appl.setDeliveryBlock(MappingUtils.nullString(objRef.getDELIVERYBLOCK()));
		
		appl.setStartDate(MappingUtils.mapToCastorDate(objRef.getSTARTDATE()));
		appl.setEndDate(MappingUtils.mapToCastorDate(objRef.getENDDATE()));
		
		appl.setStatus(StatusType.valueOf(MappingUtils.nullString(objRef.getITEMSTATUS())));
		
		appl.setProfitCenter(mapProfitCenter(objRef.getPROFITCENTER()));
		return appl;
	}


	/*
	 * Map a profitcenter
	 */
	protected ProfitCenter mapProfitCenter(ZESCQSPROFITCENTER profitcenter) {
		ProfitCenter pc = null;
		String entity =  MappingUtils.nullString(profitcenter.getENTITY());
		String subentity = MappingUtils.nullString(profitcenter.getSUBENTITY());
		String department =MappingUtils.nullString(profitcenter.getDEPARTMENT());
		String workforce = MappingUtils.nullString(profitcenter.getWORKFORCE());
		
		if (entity!=null || subentity!=null || department!=null || workforce!=null ) {
            pc = new ProfitCenter();
            pc.setDepartment(department);
            pc.setEntity(entity);
            pc.setSubEntity(subentity);
            pc.setWorkforce(workforce);

        }
		return pc;
	}

}
