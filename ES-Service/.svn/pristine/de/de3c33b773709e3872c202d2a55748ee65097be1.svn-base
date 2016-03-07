/*
 * BatchRequestMapperTest.java
 * Created on 3 d�c. 2004
 *
 * Entitlement Service Project
 */
package com.hp.es.test.batchEntitlement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.service.batchEntitlement.SubRequest;
import com.hp.es.test.hpsetest.proxy.CastorObjectComparator;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
/**
 * @author anvoi
 *
 */
public class BatchRequestMapperTest extends TestCase {

    /**
     * 
     */
    public BatchRequestMapperTest() {
        super();
    }

    /**
     * @param arg0
     */
    public BatchRequestMapperTest(String arg0) {
        super(arg0);
    }


    /*
     * @return the test suite
     */
    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(BatchRequestMapperTest.class);
    }

    /*
     * Main Method
     * @param no parameters supported

    public static void main(String[] args) {
        BatchRequestMapperTest t = new BatchRequestMapperTest("");
            
    }
     */
    
    /**
     * test1.
     */
    public void test1() {
        // Test 1 (Error)
        //serial Number == null, productId ="111", isoCountry="US", includeContract and includeOffer not spoecified
        try {
            SubRequest sr = new SubRequest();
            sr.setIsoCountryCode("US");
            sr.setSerialNumber(null);
            sr.setProductId("111");
            sr.setIncludeContracts(false);
            sr.setIncludeOffers(false);      
            
//            BatchRequestMapper.getInstance().createEsRequestComplexType(sr);
            assertFalse("Test case 1 should have generated an execption", true);
        }catch(Exception e) {
            //
            assertTrue(true);
        }
    }
    
    /**
     * test2.
     */
    public void test2() {
        // Test 2 (Error)
        //serial Number == "12345", productId ="111", isoCountry=null, includeContract and includeOffer not spoecified
        try {
            SubRequest sr = new SubRequest();
            sr.setIsoCountryCode(null);
            sr.setSerialNumber("12345");
            sr.setProductId("111");
            sr.setIncludeContracts(false);
            sr.setIncludeOffers(false);                  
//            BatchRequestMapper.getInstance().createEsRequestComplexType(sr);
            assertFalse("Test case 2 should have generated an execption", true);
        }catch(Exception e) {
            //
            assertTrue(true);
        }
    }
        
    /**
     * test3.
     */
    public void test3() {
//      //Test 3 (Error)
        //serial Number == "", productId ="111", isoCountry="", includeContract and includeOffer not spoecified
        try {
            SubRequest sr = new SubRequest();
            sr.setIsoCountryCode("");
            sr.setSerialNumber("12345");
            sr.setProductId("");
            sr.setIncludeContracts(false);
            sr.setIncludeOffers(false);                              
//            BatchRequestMapper.getInstance().createEsRequestComplexType(sr);
            assertFalse("Test case 3 should have generated an execption", true);
        }catch(Exception e) {
            //
            assertTrue(true);
        }
    }
    
    /**
     * test4.
     */
    public void test4() {
 
        EsRequestComplexType request = buildRequestObject("US","12345","111", false, false);
        
        //Test 4 (valid)
        //serial Number == "12345", productId ="111", isoCountry="US", includeContract=true and includeOffer true
        try {
            SubRequest sr = new SubRequest();
            sr.setIsoCountryCode("US");
            sr.setSerialNumber("12345");
            sr.setProductId("111");
            sr.setIncludeContracts(false);
            sr.setIncludeOffers(false);                  
            
//            EsRequestComplexType requestReceived = 
//                BatchRequestMapper.getInstance().createEsRequestComplexType(sr);

            
//            assertTrue("Test case 4 comparison failed", compare(requestReceived,request));
        }catch(Exception e) {
            //
            assertFalse("Test case 4 should not have generated an execption",true);
        }        
    }

    /*
     * buildRequestObject
     * @param isoCountryCode
     * @param serialNumber
     * @param productId
     * @param includeContracts
     * @param includeOffers
     * @return request the built request
     * @throws MapperException
     */    
    private EsRequestComplexType buildRequestObject(String isoCountryCode,String serialNumber,
            String productId, boolean includeContracts, boolean includeOffers) {
        EsRequestComplexType request = new EsRequestComplexType();
        EsRequestComplexTypeChoice erctc = new EsRequestComplexTypeChoice();
        EntitlementBySnRequest     ebsr  = new EntitlementBySnRequest();           
        request.setClientAppID("ESBATCH");
        request.setOperation("getEntitlementBySn");
        /*
         * As not specified we are setting activeXXonly to false
         */
        
        ebsr.setIncludeContracts(includeContracts);
        ebsr.setIncludeOffers(includeOffers);
        
        ebsr.setIncludeWarranty(true);
        
        ebsr.setIsoCountryCd(isoCountryCode);
        ebsr.setProductID(productId);
        ebsr.setSerialNumber(serialNumber);
        erctc.setEntitlementBySnRequest(ebsr);
        request.setEsRequestComplexTypeChoice(erctc);  
        return request;
    }
    
    /*
     * buildRequestObject
     * @param isoCountryCode
     * @param serialNumber
     */
    private boolean compare(EsRequestComplexType expected, EsRequestComplexType current) throws Exception{
     CastorObjectComparator cc= new CastorObjectComparator(null);
     
     
     return cc.compare(expected,current,"root");   
    }

}
