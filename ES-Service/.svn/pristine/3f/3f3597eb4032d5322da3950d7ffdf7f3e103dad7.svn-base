package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSAPPLIESTO;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSDELIVERABLE;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSMODIFIER;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOBJECTREF;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOOS;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSSERVICE;
import com.hp.es.service.contractEntitlement.keys.ModifierKey;
import com.hp.es.service.contractEntitlement.keys.ServiceKey;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.Deliverable;
import com.hp.es.xml.service.ModifierComplexType;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.sif.SifException;

class MetroOfferMapper extends OfferMapper{



	MetroOfferMapper(Object service, XMLIdGenerator generator, Map oosMap, Map oosKeyListMapbyOOSGroupId, EsReplyContext ctx, Object firstCqsOOS) {
		super(service, generator, oosMap, oosKeyListMapbyOOSGroupId, ctx, firstCqsOOS);
	}

	/*
	 * Map an offer and related object
	 */
	OfferComplexType map(boolean includeDeliverables, boolean  includeModifiers, String sourceObligationId) throws SifException {
		// Local Object
		OfferComplexType offer = new OfferComplexType();

		/*
		 * Mapping
		 * Service	SvcProductID 				Offer	OfferCode
		 * Service	Service - SvcDescription	Offer	OfferDescription
		 * Service	SvcProductType				Offer	SvcProductType
		 * Service	SvcProductLine				Offer	SvcProductLine
		 * Service	StandAloneOffer				Offer	StandAloneOffer
		 * Service	IncidentBasedOffer			Offer	IncidentBasedOffer
		 * Service	ServiceQuantity				Offer	ServiceQuantity
		 * Service	AvailableQuantity			Offer	AvailableQuantity
		 */
		ZESCQSSERVICE serviceTmp = (ZESCQSSERVICE)_service;
		ESLog.debug("Mapping Service (Offer): ");
		offer.setId(_generator.nextId());
		offer.setOfferCode(MappingUtils.nullString(serviceTmp.getSVCPRODUCTID()));
		offer.setOfferDescription(MappingUtils.nullString(serviceTmp.getSVCDESCRIPTION()));
		offer.setSvcProductType(MappingUtils.nullString(serviceTmp.getSVCPRODUCTTYPE()));
		offer.setSvcProductLine(MappingUtils.nullString(serviceTmp.getSVCPRODUCTLINE()));

		offer.setStandAloneOffer(MappingUtils.mapToBoolean(serviceTmp.getSTANDALONESERVICE()));
		offer.setIncidentBasedOffer(MappingUtils.mapToBoolean(serviceTmp.getINCIDENTBASEDSERVICE()));
		try {
			offer.setServiceQuantity(MappingUtils.floatStringToInt(serviceTmp.getSERVICEQUANTITY()));
			offer.setAvailableQuantity(MappingUtils.floatStringToInt(serviceTmp.getAVAILABLEQUANTITY()));
		}catch(MappingException e) {
			ESLog.info("Caught Number Format", e);
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Incorrect Quantity, CQS mapping issue");
		}
		//

		if(includeDeliverables) {
			//deliverable
			ESLog.debug("Mapping Offer deliverables");
			offer.setDeliverable(mapDeliverable(sourceObligationId,MappingUtils.nullString(serviceTmp.getITEM())));
		}



		ESLog.debug("Mapping Offer appliesTo");
		//AppliesTo
		offer.setAppliesTo(mapAppliesTo(sourceObligationId,MappingUtils.nullString(serviceTmp.getITEM())));


		if(includeModifiers) {
			ESLog.debug("Mapping Offer modifiers");
			//
			offer.setModifier(mapModifiers(sourceObligationId,MappingUtils.nullString(serviceTmp.getITEM())));
            if (_firstCqsOOS != null) {
                ESLog.debug("Mapping PWA info to Offer modifiers");
                mapPWAModifiers(sourceObligationId, MappingUtils.nullString(serviceTmp.getITEM()), offer);
            }
		}

		if(_ctx != null) {
			String item  = serviceTmp.getITEM();
			ServiceKey key = new ServiceKey(sourceObligationId, item);
	        _ctx.addOffer(key, offer);
		}

		ESLog.debug("Offer is mapped");
		return offer;
	}
    /**
     * For PWA information (START_PAGE_COUNT, END_PAGE_COUNT, PAGE_LIMIT_REACHED_DATE, CURRENT_PAGE_COUNT,
     * CURRENT_PAGE_COUNT_DATE), JCOPWAModifierMapper should be used to map them to ES offer/modifier.
     *
     * @param sourceObligationId
     * @param item
     * @param offer
     * @since 9.0.5
     */
    protected void mapPWAModifiers(String sourceObligationId, String item, OfferComplexType offer) {
        if (_firstCqsOOS == null)
            return;

        boolean flagCurrentPageCount = false;
        boolean flagEndPageCount = false;
        int valueCurrentPageCount = 0;
        int valueEndPageCount = 0;

        ZESCQSOOS firstCqsOOS=(ZESCQSOOS) _firstCqsOOS;
        ZESCQSSERVICE service=(ZESCQSSERVICE) _service;

        // Map PWA_CURRENT_PAGE_COUNT from OOS
        if (isTheServiceAppliesToTheOOS (service, firstCqsOOS) && isPWAValueAvailable(firstCqsOOS.getCURRENTPAGECOUNT())) {
            ESLog.debug("Mapping PWA CURRENT_PAGE_COUNT. Its value is " + firstCqsOOS.getCURRENTPAGECOUNT());
            ModifierComplexType mod = new ModifierComplexType();
            mod.setModName(PWAConstants.MOD_NAME_CURRENT_PAGE_COUNT);
            mod.setModValue(firstCqsOOS.getCURRENTPAGECOUNT().trim());

            //CurrentPageCount will be used to calculate the value of PageLimitStatus. Here we track it.
            try {
                valueCurrentPageCount = MappingUtils.stringToInt(mod.getModValue().trim());
                flagCurrentPageCount = true;
            } catch (MappingException e) {
                // if MappingException occurs, flagCurrentPageCount is still false.
            }

            addModifier(sourceObligationId, item, offer, mod);
        }

        // Map PWA_CURRENT_PAGE_COUNT_DATE from OOS
        if (isTheServiceAppliesToTheOOS (service, firstCqsOOS) && isPWAValueAvailable(firstCqsOOS.getCURRENTPAGECOUNTDATE())) {
            ESLog.debug("Mapping PWA CURRENT_PAGE_COUNT_DATE. Its value is " + firstCqsOOS.getCURRENTPAGECOUNTDATE());
            ModifierComplexType mod = new ModifierComplexType();
            mod.setModName(PWAConstants.MOD_NAME_CURRENT_PAGE_COUNT_DATE);
            mod.setModValue(firstCqsOOS.getCURRENTPAGECOUNTDATE().trim());
            addModifier(sourceObligationId, item, offer, mod);
        }

        // Map START_PAGE_COUNT, END_PAGE_COUNT and PAGE_LIMIT_REACHED_DATE from AppliesTo.ObjectRef


        if (service.getAPPLIESTO() != null) {
            Collection appls = service.getAPPLIESTO().getItem();
            Iterator itAppl = appls.iterator();
            ZESCQSOBJECTREF objRef = null;
            // going through the list to get right objRef. Once the right objRef is found, we can end the loop.
            while (itAppl.hasNext() && objRef == null) {

                // The following logic describes the process of finding the right ObjectRef.
                // For each AppliesTo
                //      If AppliesTo.ObjectRefType ==â€�OOSâ€�
                //          For each AppliesTo.ObjectRef
                //              Take the first one ObjectRef which is connected to this OOS. The â€œconnectedâ€� means
                //              ObjectRef.ObjectRefKey= firstOOS.key. Once we get the right ObjectRef, we end all loops.
                //      Else //it means ObjectRefType is "OOSGroup"
                //          For each AppliesTo.ObjectRef
                //              In this case ObjectRef.ObjectRefKey is an OOSGroupID. We should check if the firstOOS is in this
                //              OOSGroup. If yes, we also get the right ObjectRef and end all loops.

                ZESCQSAPPLIESTO appl = (ZESCQSAPPLIESTO) itAppl.next();
                if (appl.getOBJECTTYPE() != null) {
                    Collection objRefs = appl.getOBJECTREF().getItem();
                    Iterator itObjRef = objRefs.iterator();
                    while (itObjRef.hasNext() && objRef == null) {
                        ZESCQSOBJECTREF objRefTmp = (ZESCQSOBJECTREF) itObjRef.next();
                        if (appl.getOBJECTTYPE().trim().equalsIgnoreCase(OOS_TYPE)) {
                            if (firstCqsOOS.getOOSKEY().equals(objRefTmp.getOBJECTREFKEY()))
                                objRef = objRefTmp;
                        } else {// OOSGroup
                            String groupId = objRefTmp.getOBJECTREFKEY();
                            Collection oosKeys = getOOSKeyListForOOSGroupId(groupId);
                            if (oosKeys != null) {
                                Iterator itOOSkey = oosKeys.iterator();
                                while (itOOSkey.hasNext() && objRef == null) {
                                    String oosKey = (String) itOOSkey.next();
                                    if (oosKey.equals(firstCqsOOS.getOOSKEY()))
                                        objRef = objRefTmp;
                                }
                            }
                        }
                    }// end of OOSGroup
                }
            }
            if (objRef != null) {
                // Map PWA_START_PAGE_COUNT from AppliesTo.ObjectRef
                if (isPWAValueAvailable(objRef.getSTARTPAGECOUNT())) {
                    ESLog.debug("Mapping PWA START_PAGE_COUNT. Its value is " + objRef.getSTARTPAGECOUNT());
                    ModifierComplexType mod = new ModifierComplexType();
                    mod.setModName(PWAConstants.MOD_NAME_START_PAGE_COUNT);
                    mod.setModValue(objRef.getSTARTPAGECOUNT().trim());
                    addModifier(sourceObligationId, item, offer, mod);
                }

                // Map PWA_PAGE_LIMIT_REACHED_DATE from AppliesTo.ObjectRef
                if (isPWAValueAvailable(objRef.getPAGELIMITREACHEDDATE())) {
                    ESLog.debug("Mapping PWA PAGE_LIMIT_REACHED_DATE. Its value is " + objRef.getPAGELIMITREACHEDDATE());
                    ModifierComplexType mod = new ModifierComplexType();
                    mod.setModName(PWAConstants.MOD_NAME_PAGE_LIMIT_REACHED_DATE);
                    mod.setModValue(objRef.getPAGELIMITREACHEDDATE().trim());
                    addModifier(sourceObligationId, item, offer, mod);
                }

                // Map PWA_END_PAGE_COUNT from AppliesTo.ObjectRef
                if (isPWAValueAvailable(objRef.getENDPAGECOUNT())) {
                    ESLog.debug("Mapping PWA END_PAGE_COUNT. Its value is " + objRef.getENDPAGECOUNT());
                    ModifierComplexType mod = new ModifierComplexType();
                    mod.setModName(PWAConstants.MOD_NAME_END_PAGE_COUNT);
                    mod.setModValue(objRef.getENDPAGECOUNT().trim());

                    //EndPageCount will be used to calculate the value of PageLimitStatus. Here we track it.
                    try {
                        valueEndPageCount = MappingUtils.stringToInt(mod.getModValue().trim());
                        flagEndPageCount = true;
                    } catch (MappingException e) {
                        // if MappingException occurs, flagCurrentPageCount is still false.
                    }

                    addModifier(sourceObligationId, item, offer, mod);
                }
            }
        }
        // The modifier PAGE_LIMIT_STATUS exists only if CURRENT_PAGE_COUNT and END_PAGE_COUNT are available.
        if (flagCurrentPageCount && flagEndPageCount) {
            ModifierComplexType mod = new ModifierComplexType();
            mod.setModName(PWAConstants.MOD_NAME_PAGE_LIMIT_STATUS);
            mod.setModValue((valueCurrentPageCount <= valueEndPageCount) ? PWAConstants.PAGE_LIMIT_STATUS_ACTIVE
                    : PWAConstants.PAGE_LIMIT_STATUS_EXPIRED);

            addModifier(sourceObligationId, item, offer, mod);
        }
    }

    /**
     * Always need to check whether the service applies to the OOS, which is returned. If a service does not apply to
     * the OOS, then the modifiers for current page count and current page count date are not created for the service.
     */
	private boolean isTheServiceAppliesToTheOOS(ZESCQSSERVICE service, ZESCQSOOS oos) {
        if (service.getAPPLIESTO() != null) {
            Collection appliesToes = service.getAPPLIESTO().getItem();
            Iterator itAppl = appliesToes.iterator();

            while (itAppl.hasNext()) {
                ZESCQSAPPLIESTO appl = (ZESCQSAPPLIESTO) itAppl.next();
                Collection objRefs = appl.getOBJECTREF().getItem();

                if (objRefs != null && appl.getOBJECTTYPE() != null) {
                    Iterator itObjRef = objRefs.iterator();
                    while (itObjRef.hasNext()) {
                        ZESCQSOBJECTREF objRef = (ZESCQSOBJECTREF) itObjRef.next();
                        if (appl.getOBJECTTYPE().trim().equalsIgnoreCase(OOS_TYPE)) {
                            if (oos.getOOSKEY().equals(objRef.getOBJECTREFKEY()))
                                return true;
                        } else {// OOSGroup
                            String groupId = objRef.getOBJECTREFKEY();
                            Collection oosKeys = getOOSKeyListForOOSGroupId(groupId);
                            if (oosKeys != null) {
                                Iterator itOOSkey = oosKeys.iterator();
                                while (itOOSkey.hasNext()) {
                                    String oosKey = (String) itOOSkey.next();
                                    if (oosKey.equals(oos.getOOSKEY()))
                                        return true;
                                }
                            }
                        }
                    }// end of OOSGroup
                }
            }
        }
        return false;
    }

    /*
     * Map Modifiers @return a list of modifier in an array
     */
	protected ModifierComplexType[] mapModifiers(String sourceObligationId, String item) {

		ModifierComplexType[] listMods = null;
		ZESCQSSERVICE serviceTmp = (ZESCQSSERVICE)_service;

		ArrayList arMods = new ArrayList();
		List<ZESCQSMODIFIER> listSourceModifiers = serviceTmp.getMODIFIERS().getItem();


		//going through the list
		for (ZESCQSMODIFIER modifier : listSourceModifiers) {
			ModifierMapper mapper = new MetroModifierMapper(modifier);
			ModifierComplexType mod = mapper.map();
            if (mod != null) {
                arMods.add(mod);
                if (_ctx != null) {
                    String name = mod.getModName();
                    ModifierKey key = new ModifierKey(sourceObligationId, item, name);
                    _ctx.addModifier(key, mod);
                }
            }
		}

		listMods = (ModifierComplexType[])arMods.toArray(new ModifierComplexType[0]);

		return listMods;
	}

	protected AppliesTo[] mapAppliesTo(String sourceObligationId, String item) {
		AppliesTo[] listAppl = null;
		ArrayList arAppl = new ArrayList();
		ZESCQSSERVICE serviceTmp = (ZESCQSSERVICE)_service;
		List<ZESCQSAPPLIESTO> listSourceAppl = serviceTmp.getAPPLIESTO().getItem();

		//going through the list
		for (ZESCQSAPPLIESTO appl : listSourceAppl) {
			AppliesToMapper mapper = new MetroAppliesToMapper(appl,_generator,_oosMap,_oosKeyListMapbyOOSGroupId, _ctx);
			Collection colAppliesTo = mapper.map(sourceObligationId, item);
			arAppl.addAll(colAppliesTo);
		}

		listAppl = (AppliesTo[])arAppl.toArray(new AppliesTo[0]);

		return listAppl;
	}

	protected Deliverable[] mapDeliverable(String sourceObligationId, String item) {
		Deliverable[] listDel = null;
		ArrayList arDel = new ArrayList();
		ZESCQSSERVICE serviceTmp = (ZESCQSSERVICE)_service;
		List<ZESCQSDELIVERABLE> listSourceDel = serviceTmp.getDELIVERABLES().getItem();



		//going through the list
		for (ZESCQSDELIVERABLE del : listSourceDel) {
			DeliverableMapper mapper = new MetroDeliverableMapper(del, _ctx);
			Deliverable deliverable = mapper.map(sourceObligationId, item);
			arDel.add(deliverable);
		}

		listDel = (Deliverable[])arDel.toArray(new Deliverable[0]);


		return listDel;
	}

	/**
     * Refer to AppliesToMapper.getOOSKeyListForOOSGroupId
     * @param groupId
     * @return
	 */
    protected final AbstractList getOOSKeyListForOOSGroupId(String groupId) {
        return (ArrayList) _oosKeyListMapbyOOSGroupId.get(groupId);
    }

    /**
     * Check if the value of PWA fields is available
     * @param pwaValue
     * @return
     */
    private boolean isPWAValueAvailable(String pwaValue) {
        if (pwaValue == null || "".equals(pwaValue.trim()))
            return false;
        return true;
    }

    /**
     * Convenience method: to add Modifier to offer and EsReplyContext
     *
     * @param sourceObligationId
     * @param item
     * @param offer
     * @param mod
     */
    private void addModifier(String sourceObligationId, String item, OfferComplexType offer, ModifierComplexType mod) {
        if (mod != null) {
            offer.addModifier(mod);
            if (_ctx != null) {
                String name = mod.getModName();
                ModifierKey key = new ModifierKey(sourceObligationId, item, name);
                _ctx.addModifier(key, mod);
            }
        }
    }
}
