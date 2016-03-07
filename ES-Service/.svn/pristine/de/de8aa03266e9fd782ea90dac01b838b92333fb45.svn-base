package com.hp.es.service;

/**
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/RequestCleanerTest.java 1.8 2004-07-01 15:41:03+02 wanglon Exp $
 *
 * Copyright (c) 2001 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * @author Dave Frey
 *
 * $Log: RequestCleanerTest.java,v $
 * Revision 1.8  2004-07-01 15:41:03+02  wanglon
 * Author: wanglon@sh01015.china.hp.com ()
 * Upper CCID in cleaner.
 *
 * Revision 1.7  2004-06-30 09:42:24+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Modification for EntitlementCheckDate Null case.

 * Add expectedCheckDate in three methods: testEntitlementBySnRequestCleaner, testEntitlementByPnRequestCleaner, testContractRequestCleaner.
 *
 * Revision 1.6  2004-06-22 09:24:13+02  wanglon
 * Author: wanglon@sh01015.china.hp.com ()
 * Enchance the cleaner
 *
 * Revision 1.5  2004-05-08 04:41:49+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.4  2004-05-05 15:40:34+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.3  2004-01-29 18:06:17+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.2  2003-08-04 16:50:42+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.1  2003-06-19 17:18:41+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * initially targets only the "remove product option" functionality
 *
 */
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * JUnit test class for <tt>RequestCleaner</tt> class.
 * <p>
 * Currently there is minimal coverage here; I'm targeting specifically the product option treatment
 * and we can add tests later if it's interesting.
 */
public class RequestCleanerTest
    extends TestCase{
    /* -------------------------------------------------------------------------
         JUnit stuff
         ------------------------------------------------------------------------- */
    public RequestCleanerTest(String name){
        super(name);
    }

    public static Test suite(){
        return new TestSuite(RequestCleanerTest.class);
    }

    public static void main(String[] args){
        junit.textui.TestRunner.run(suite());
    }

    protected void setUp() throws Exception{
        super.setUp();
    }

    /* -------------------------------------------------------------------------
         test methods
         ------------------------------------------------------------------------- */
    /**
     * Testing failure: no WarrantyContext.
     */
    public void testWarrantyRequestCleaner(){
//        String expectedProductID = null;
//        EsRequestComplexType request = new EsRequestComplexType();
//        EsRequestComplexTypeChoice choice = new EsRequestComplexTypeChoice();
//        WarrantyRequest req = new WarrantyRequest();
//        choice.setWarrantyRequest(req);
//        request.setEsRequestComplexTypeChoice(choice);
//        // null cases
//        // request.setProductID("A");
//        RequestCleaner.cleanThisRequest(request);
//        assertNull(req.getProductID());
//        req.setProductID(" ");
//        RequestCleaner.cleanThisRequest(request);
//        assertNull(req.getProductID());
//        req.setProductID("#");
//        RequestCleaner.cleanThisRequest(request);
//        assertNull(req.getProductID());
//        req.setProductID(" #123");
//        RequestCleaner.cleanThisRequest(request);
//        assertNull(req.getProductID());
//        // normal cases
//        expectedProductID = "A1234A";
//        req.setProductID("A1234A");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        req.setProductID("A1234A#");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        req.setProductID("A1234A#123");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        req.setProductID("   A1234A  #  123  ");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        // short cases
//        expectedProductID = "A";
//        req.setProductID("A#");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        req.setProductID("A#123");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        req.setProductID(" A # 123 ");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        //upper case
//        expectedProductID = "PROD123ABC";
//        String expectedSN = "SN123456789";
//        String expectedCC = "US";
//        req.setProductID("ProD123abc");
//        req.setSerialNumber("sn123456789");
//        req.setIsoCountryCd("us");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        assertEquals(expectedSN,req.getSerialNumber());
//        assertEquals(expectedCC,req.getIsoCountryCd());
    }

    public void testEntitlementBySnRequestCleaner(){
//        EsRequestComplexType request = new EsRequestComplexType();
//        EsRequestComplexTypeChoice choice = new EsRequestComplexTypeChoice();
//        EntitlementBySnRequest req = new EntitlementBySnRequest();
//        choice.setEntitlementBySnRequest(req);
//        request.setEsRequestComplexTypeChoice(choice);
//        //upper case
//        String expectedProductID = "PROD123ABC";
//        String expectedSN = "SN123456789";
//        String expectedCC = "US";
//        Date expectedCheckDate = new Date(new java.util.Date());
//        req.setProductID("ProD123abc");
//        req.setSerialNumber("sn123456789");
//        req.setIsoCountryCd("us");
//        req.setEntitlementCheckDate(null);
//        RequestCleaner.cleanThisRequest(request);
//        System.out.println(req.getProductID());
//        assertEquals(expectedProductID,req.getProductID());
//        assertEquals(expectedSN,req.getSerialNumber());
//        assertEquals(expectedCC,req.getIsoCountryCd());
//        assertEquals(expectedCheckDate.toString(), req.getEntitlementCheckDate().toString());
    }

    public void testEntitlementByPnRequestCleaner(){
//        EsRequestComplexType request = new EsRequestComplexType();
//        EsRequestComplexTypeChoice choice = new EsRequestComplexTypeChoice();
//        EntitlementByPnRequest req = new EntitlementByPnRequest();
//        choice.setEntitlementByPnRequest(req);
//        request.setEsRequestComplexTypeChoice(choice);
//        //upper case
//        String expectedProductID = "PROD123ABC";
//        String expectedCCID = "ABCDE";
//        String expectedCC = "US";
//        Date expectedCheckDate = new Date(new java.util.Date());
//        req.setProductID("ProD123abc");
//        req.setCustomerDefinedID("abcde");
//        req.setIsoCountryCd("us");
//        req.setEntitlementCheckDate(null);
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        assertEquals(expectedCCID,req.getCustomerDefinedID());
//        assertEquals(expectedCC,req.getIsoCountryCd());
//        assertEquals(expectedCheckDate.toString(), req.getEntitlementCheckDate().toString());
    }

    public void testContractRequestCleaner(){
//        EsRequestComplexType request = new EsRequestComplexType();
//        EsRequestComplexTypeChoice choice = new EsRequestComplexTypeChoice();
//        ContractRequest req = new ContractRequest();
//        choice.setContractRequest(req);
//        request.setEsRequestComplexTypeChoice(choice);
//        //upper case
//        String expectedProductID = "PROD123ABC";
//        String expectedCCID = "ABCDE";
//        String expectedCC = "US";
//        Date expectedCheckDate = new Date(new java.util.Date());
//        req.setProductID("ProD123abc");
//        req.setIsoCountryCd("us");
//        req.setCustomerDefinedID("abcde");
//        req.setEntitlementCheckDate(null);
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedProductID,req.getProductID());
//        assertEquals(expectedCC,req.getIsoCountryCd());
//        assertEquals(expectedCCID,req.getCustomerDefinedID());
//        assertEquals(expectedCheckDate.toString(), req.getEntitlementCheckDate().toString());
    }

    public void testAssociatedContractsRequest(){
//        EsRequestComplexType request = new EsRequestComplexType();
//        EsRequestComplexTypeChoice choice = new EsRequestComplexTypeChoice();
//        AssociatedContractsRequest req = new AssociatedContractsRequest();
//        choice.setAssociatedContractsRequest(req);
//        request.setEsRequestComplexTypeChoice(choice);
//        //upper case
//        String expectedCC = "US";
//        req.setIsoCountryCd("us");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedCC,req.getIsoCountryCd());
    }

    public void testPrintAdvantageRequest(){
//        EsRequestComplexType request = new EsRequestComplexType();
//        EsRequestComplexTypeChoice choice = new EsRequestComplexTypeChoice();
//        PrintAdvantageRequest req = new PrintAdvantageRequest();
//        choice.setPrintAdvantageRequest(req);
//        request.setEsRequestComplexTypeChoice(choice);
//        //upper case
//        String expectedCC = "US";
//        req.setIsoCountryCd("us");
//        RequestCleaner.cleanThisRequest(request);
//        assertEquals(expectedCC,req.getIsoCountryCd());
    }
}
