package com.hp.es.service.warrantyEntitlement.integration.mapping;

import junit.framework.TestCase;

import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSOOS;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSSERVICE;

/**
 * This is a TestCase for MetroOfferMapperTest (testing PWA specially)
 *
 * @author Chunyang
 * @since ES Service 9.0.5
 */
public class MetroOfferMapperTest extends TestCase {
    private static final String PAGE_LIMIT_REACHED_DATE = "2008-02-02";
    private static final String END_PAGE_COUNT = "100";
    private static final String START_PAGE_COUNT = "10";
    private static final String OOS_TYPE = "OOS";
    private static final String GROUP_TYPE = "GROUP";
    private static final String CURRENT_PAGE_COUNT_DATE = "2007-03-20";
    private static final String CURRENT_PAGE_COUNT = "50";
    private static final String OOSKEY_1 = "OOSKEY-001";
    private static final String OOSKEY_2 = "OOSKEY-002";
    private static final String GROUP_ID = "GROUP_ID-001";

    protected ZESCQSSERVICE _service_1Appl_1ObjRef;
    protected ZESCQSSERVICE _service_1Appl_3ObjRefs;
    protected ZESCQSSERVICE _service_3Appls_1ObjRefPerAppl;
    protected ZESCQSSERVICE _service_3Appls_3ObjRefsPerAppl;

    protected ZESCQSSERVICE _service_1Appl_1Obj_TypeIsGROUP;

    protected ZESCQSOOS _firstCqsOOS;

//    public static void main(String[] args) {
//        junit.textui.TestRunner.run(MetroOfferMapperTest.class);
//    }

//   public MetroOfferMapperTest(String arg0) {
//        super(arg0);
//        prepareCqsService();
//        prepareFirstOOS(OOSKEY_1);
//    }

//    public static Test suite() {
//        return new TestSuite(MetroOfferMapperTest.class);
//    }

    public void testMapPWAModifiers_1() {
//        EsReplyContext ctx = new EsReplyContext(null);
//        OfferComplexType offer = new OfferComplexType();
//        MetroOfferMapper mapper = new MetroOfferMapper(_service_1Appl_1ObjRef, null, null, null, ctx, _firstCqsOOS);
//        mapper.mapPWAModifiers("sourceObligationId", "item", offer);
//        checkTestResult(offer);
    }
    /* 
    public void testMapPWAModifiers_2() {
        EsReplyContext ctx = new EsReplyContext(null);
        OfferComplexType offer = new OfferComplexType();
        MetroOfferMapper mapper = new MetroOfferMapper(_service_1Appl_3ObjRefs, null, null, null, ctx, _firstCqsOOS);
        mapper.mapPWAModifiers("sourceObligationId", "item", offer);
        checkTestResult(offer);
    }

    public void testMapPWAModifiers_3() {
        EsReplyContext ctx = new EsReplyContext(null);
        OfferComplexType offer = new OfferComplexType();
        MetroOfferMapper mapper = new MetroOfferMapper(_service_3Appls_1ObjRefPerAppl, null, null, null, ctx, _firstCqsOOS);
        mapper.mapPWAModifiers("sourceObligationId", "item", offer);
        checkTestResult(offer);
    }

    public void testMapPWAModifiers_4() {
        EsReplyContext ctx = new EsReplyContext(null);
        OfferComplexType offer = new OfferComplexType();
        MetroOfferMapper mapper = new MetroOfferMapper(_service_3Appls_3ObjRefsPerAppl, null, null, null, ctx, _firstCqsOOS);
        mapper.mapPWAModifiers("sourceObligationId", "item", offer);
        checkTestResult(offer);
    }

    public void testMapPWAModifiers_group_1() {
        EsReplyContext ctx = new EsReplyContext(null);
        OfferComplexType offer = new OfferComplexType();
        Map oosKeyListMapbyOOSGroupId = new HashMap();
        ArrayList list = new ArrayList();
        list.add(OOSKEY_1);
        list.add(OOSKEY_2);
        oosKeyListMapbyOOSGroupId.put(GROUP_ID, list);
        MetroOfferMapper mapper = new MetroOfferMapper(_service_1Appl_1Obj_TypeIsGROUP, null, null, oosKeyListMapbyOOSGroupId, ctx,
                _firstCqsOOS);
        mapper.mapPWAModifiers("sourceObligationId", "item", offer);
        checkTestResult(offer);
    }
    public void testMapPWAModifiers_WITS1577() {
        EsReplyContext ctx = new EsReplyContext(null);
        OfferComplexType offer = new OfferComplexType();

        ZESCQSOBJECTREF objRef2 = createObjectRef(OOSKEY_2);

        ZESCQSSERVICE service = new ZESCQSSERVICE();
        ZESCQSAPPLIESTO appliesTo = createAppliesTo(OOS_TYPE);
        addAppliesToToService(appliesTo, service);
        addObjectRefToAppliesTo(objRef2, appliesTo);

        //The OOSKey in firstOOS is OOSKEY_1.
        //The OOSKey in service.appliesTo.objRef is OOSKEY_2.
        //So Modifier for current page count and current page count date should not be added into the _ctx.offer
        prepareFirstOOS(OOSKEY_1);
        MetroOfferMapper  mapper=new MetroOfferMapper(service, null, null, null, ctx, _firstCqsOOS);
        mapper.mapPWAModifiers("sourceObligationId", "item", offer);

        //check result
        HashMap modsMap = new HashMap();
        ModifierComplexType[] mods = offer.getModifier();
        for (int i = 0; i < mods.length; i++) {
            ModifierComplexType mod = mods[i];
            modsMap.put(mod.getModName(), mod.getModValue());
        }

        assertFalse(modsMap.containsKey(PWAConstants.MOD_NAME_CURRENT_PAGE_COUNT));
        assertFalse(modsMap.containsKey(PWAConstants.MOD_NAME_CURRENT_PAGE_COUNT_DATE));

    }
    private void checkTestResult(OfferComplexType offer) {
        HashMap modsMap = new HashMap();
        ModifierComplexType[] mods = offer.getModifier();
        for (int i = 0; i < mods.length; i++) {
            ModifierComplexType mod = mods[i];
            modsMap.put(mod.getModName(), mod.getModValue());
        }

        assertTrue(modsMap.containsKey(PWAConstants.MOD_NAME_CURRENT_PAGE_COUNT));
        assertTrue(modsMap.containsKey(PWAConstants.MOD_NAME_CURRENT_PAGE_COUNT_DATE));
        assertEquals(CURRENT_PAGE_COUNT, modsMap.get(PWAConstants.MOD_NAME_CURRENT_PAGE_COUNT));
        assertEquals(CURRENT_PAGE_COUNT_DATE, modsMap.get(PWAConstants.MOD_NAME_CURRENT_PAGE_COUNT_DATE));

        assertTrue(modsMap.containsKey(PWAConstants.MOD_NAME_END_PAGE_COUNT));
        assertTrue(modsMap.containsKey(PWAConstants.MOD_NAME_PAGE_LIMIT_REACHED_DATE));
        assertTrue(modsMap.containsKey(PWAConstants.MOD_NAME_START_PAGE_COUNT));
        assertTrue(modsMap.containsKey(PWAConstants.MOD_NAME_PAGE_LIMIT_STATUS));
        assertEquals(END_PAGE_COUNT, modsMap.get(PWAConstants.MOD_NAME_END_PAGE_COUNT));
        assertEquals(PAGE_LIMIT_REACHED_DATE, modsMap.get(PWAConstants.MOD_NAME_PAGE_LIMIT_REACHED_DATE));
        assertEquals(START_PAGE_COUNT, modsMap.get(PWAConstants.MOD_NAME_START_PAGE_COUNT));
        assertEquals(PWAConstants.PAGE_LIMIT_STATUS_ACTIVE, modsMap.get(PWAConstants.MOD_NAME_PAGE_LIMIT_STATUS));
    }

    private ZESCQSAPPLIESTO createAppliesTo(String oosType) {
        ZESCQSAPPLIESTO appl = new ZESCQSAPPLIESTO();
        appl.setOBJECTTYPE(oosType);
        return appl;
    }

    private ZESCQSOBJECTREF createObjectRef(String oosKey) {
        ZESCQSOBJECTREF objRef = new ZESCQSOBJECTREF();
        objRef.setOBJECTREFKEY(oosKey);
        objRef.setSTARTPAGECOUNT(START_PAGE_COUNT);
        objRef.setENDPAGECOUNT(END_PAGE_COUNT);
        objRef.setPAGELIMITREACHEDDATE(PAGE_LIMIT_REACHED_DATE);
        return objRef;
    }

    private void prepareCqsService() {
        ZESCQSOBJECTREF objRef1 = createObjectRef(OOSKEY_1);
        ZESCQSOBJECTREF objRef2 = createObjectRef(OOSKEY_1);
        ZESCQSOBJECTREF objRef3 = createObjectRef(OOSKEY_2);

        ZESCQSOBJECTREF objRef_TypeIsGroup = createObjectRef(GROUP_ID);

        _service_1Appl_1ObjRef = new ZESCQSSERVICE();
        ZESCQSAPPLIESTO appl_1ObjRef = createAppliesTo(OOS_TYPE);
        addObjectRefToAppliesTo(objRef1, appl_1ObjRef);
        addAppliesToToService(appl_1ObjRef, _service_1Appl_1ObjRef);

        _service_1Appl_3ObjRefs = new ZESCQSSERVICE();
        ZESCQSAPPLIESTO appl_3ObjRef = createAppliesTo(OOS_TYPE);
        addObjectRefToAppliesTo(objRef1, objRef2, objRef3, appl_3ObjRef);
        addAppliesToToService(appl_3ObjRef, _service_1Appl_3ObjRefs);

        _service_3Appls_1ObjRefPerAppl = new ZESCQSSERVICE();
        ZESCQSAPPLIESTO appl1_1ObjRef = createAppliesTo(OOS_TYPE);
        addObjectRefToAppliesTo(objRef1, appl1_1ObjRef);
        ZESCQSAPPLIESTO appl2_1ObjRef = createAppliesTo(OOS_TYPE);
        addObjectRefToAppliesTo(objRef2, appl2_1ObjRef);

        ZESCQSAPPLIESTO appl3_1ObjRef = createAppliesTo(OOS_TYPE);
        addObjectRefToAppliesTo(objRef3, appl3_1ObjRef);

        addAppliesToToService(appl1_1ObjRef, appl2_1ObjRef, appl3_1ObjRef, _service_3Appls_1ObjRefPerAppl);

        _service_3Appls_3ObjRefsPerAppl = new ZESCQSSERVICE();
        ZESCQSAPPLIESTO appl1_3ObjRefsPerAppl = createAppliesTo(OOS_TYPE);
        addObjectRefToAppliesTo(objRef1, objRef2, objRef3, appl1_3ObjRefsPerAppl);
        ZESCQSAPPLIESTO appl2_3ObjRefsPerAppl = createAppliesTo(OOS_TYPE);
        addObjectRefToAppliesTo(objRef1, objRef2, objRef3, appl2_3ObjRefsPerAppl);
        ZESCQSAPPLIESTO appl3_3ObjRefsPerAppl = createAppliesTo(OOS_TYPE);
        addObjectRefToAppliesTo(objRef1, objRef2, objRef3, appl3_3ObjRefsPerAppl);

        addAppliesToToService(appl1_3ObjRefsPerAppl, _service_3Appls_3ObjRefsPerAppl);
        addAppliesToToService(appl2_3ObjRefsPerAppl, _service_3Appls_3ObjRefsPerAppl);
        addAppliesToToService(appl3_3ObjRefsPerAppl, _service_3Appls_3ObjRefsPerAppl);

        _service_1Appl_1Obj_TypeIsGROUP = new ZESCQSSERVICE();
        ZESCQSAPPLIESTO appl_1ObjRef_TypeIsGROUP = createAppliesTo(GROUP_TYPE);
        addObjectRefToAppliesTo(objRef_TypeIsGroup, appl_1ObjRef_TypeIsGROUP);
        addAppliesToToService(appl_1ObjRef_TypeIsGROUP, _service_1Appl_1Obj_TypeIsGROUP);

    }

    private void addAppliesToToService(ZESCQSAPPLIESTO appliesTo1, ZESCQSAPPLIESTO appliesTo2, ZESCQSAPPLIESTO appliesTo3,
            ZESCQSSERVICE service) {
        ZESCQSAPPLIESTOT applies = new ZESCQSAPPLIESTOT();
        applies.getItem().add(appliesTo1);
        applies.getItem().add(appliesTo2);
        applies.getItem().add(appliesTo3);
        service.setAPPLIESTO(applies);

    }

    private void addAppliesToToService(ZESCQSAPPLIESTO appliesTo, ZESCQSSERVICE service) {
        ZESCQSAPPLIESTOT applies = new ZESCQSAPPLIESTOT();
        applies.getItem().add(appliesTo);
        service.setAPPLIESTO(applies);
    }

    private void addObjectRefToAppliesTo(ZESCQSOBJECTREF objRef, ZESCQSAPPLIESTO appliesTo) {
        ZESCQSOBJECTREFST objRefs = new ZESCQSOBJECTREFST();
        objRefs.getItem().add(objRef);
        appliesTo.setOBJECTREF(objRefs);
    }

    private void addObjectRefToAppliesTo(ZESCQSOBJECTREF objRef1, ZESCQSOBJECTREF objRef2, ZESCQSOBJECTREF objRef3,
            ZESCQSAPPLIESTO appliesTo) {
        ZESCQSOBJECTREFST objRefs = new ZESCQSOBJECTREFST();
        objRefs.getItem().add(objRef1);
        objRefs.getItem().add(objRef2);
        objRefs.getItem().add(objRef3);
        appliesTo.setOBJECTREF(objRefs);
    }
*/
    private void prepareFirstOOS(String oosKey) {
        _firstCqsOOS = new ZESCQSOOS();
        _firstCqsOOS.setOOSKEY(oosKey);
        _firstCqsOOS.setCURRENTPAGECOUNT(CURRENT_PAGE_COUNT);
        _firstCqsOOS.setCURRENTPAGECOUNTDATE(CURRENT_PAGE_COUNT_DATE);
    }
}
