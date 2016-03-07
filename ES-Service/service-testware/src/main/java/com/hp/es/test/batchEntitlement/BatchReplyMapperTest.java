/*
 * BatchReplyMapperTest.java
 * Created on 5 d�c. 2004
 *
 * Entitlement Service Project
 */
package com.hp.es.test.batchEntitlement;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author ANVOI
 *
 */
public class BatchReplyMapperTest extends TestCase {

    /**
     * Standard constructor
     */
    public BatchReplyMapperTest() {
        super();
    }

    /**
     * Constructor with class name passed as String
     * @param arg0
     */
    public BatchReplyMapperTest(String arg0) {
        super(arg0);
    }


    /*
     * @return the test suite
     */
    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(BatchReplyMapperTest.class);
    }

    /*
     * Tests With SifException
     * 
     */
        
    /**
     * test1: test mapEstoEntitlementItem with null SifException
     */
    public void test1() {
//        try {
//            SifException e= null;
//            SubRequest sr = new SubRequest();
//            sr.setIsoCountryCode(null);
//            sr.setSerialNumber(null);
//            sr.setProductId(null);
//            sr.setIncludeContracts(false);
//            sr.setIncludeOffers(false);
//            
//            BatchReplyMapper.getInstance().mapEsReplytoEntitlementItem(e, sr);
//            assertFalse("Test case 1 should have generated an exception", true);
//        }catch(MapperException e) {
//            //
//            assertTrue(true);
//        }
    }
    
    /**
     * test2: test mapEstoEntitlementItem A null serial Number
     */
//    public void test2() {
//        try {
//            SifException e= new SifException();
//            e.setErrorID("1");
//            SubRequest sr = new SubRequest();
//            sr.setIsoCountryCode("iso");
//            sr.setSerialNumber(null);
//            sr.setProductId("product");
//            sr.setIncludeContracts(false);
//            sr.setIncludeOffers(false);
//            
//            EntitlementItem reply=buildReplyforTest2();
//            EntitlementItem replyReceived= 
//                BatchReplyMapper.getInstance().mapEsReplytoEntitlementItem(e, sr);
//            
//            assertTrue("Test case 2 comparison failed", compare(replyReceived,reply));
//        }catch(Exception e) {
//            //
//            assertFalse("Test case 2 should not have generated an exception",true);
//        }
//    }  
//    
//    
//    /**
//     * test3: test mapEstoEntitlementItem with SifException with errorId 234
//     */
//    public void test3() {
//
//        try {
//            SifException e= new SifException();
//            e.setErrorID("224");
//            
//            SubRequest sr = new SubRequest();
//            sr.setIsoCountryCode("iso");
//            sr.setSerialNumber("serial");
//            sr.setProductId("product");
//            sr.setIncludeContracts(false);
//            sr.setIncludeOffers(false);
//            
//            EntitlementItem reply=buildReplyforTest3();
//            EntitlementItem replyReceived= 
//                BatchReplyMapper.getInstance().mapEsReplytoEntitlementItem(e, sr);
//            assertTrue("Test case 3 comparison failed", compare(replyReceived,reply));
//        }catch(Exception e) {
//            //
//            assertFalse("Test case 3 should not have generated an exception",true);
//        }
//    }      
//
//    
//    /**
//     * test4: test mapEstoEntitlementItem with SifException with errorId "serial Number"
//     */
//    public void test4() {
//        try {
//            SifException e= new SifException();
//            e.setErrorID("serial Number");
//            SubRequest sr = new SubRequest();
//            sr.setIsoCountryCode("iso");
//            sr.setSerialNumber("serial");
//            sr.setProductId("product");
//            sr.setIncludeContracts(false);
//            sr.setIncludeOffers(false);
//            
//             
//            BatchReplyMapper.getInstance().mapEsReplytoEntitlementItem(e, sr);
//            assertFalse("Test case 4 should have generated an exception", false);
//        }catch(MapperException e) {
//            //we should get an exception in that test
//            assertTrue(true);
//        }
//    }      
//
//    /**
//     * test5: test mapEstoEntitlementItem with SifException with null errorId 
//     */
//    public void test5() {
//        try {
//            SifException e= new SifException();
//            e.setErrorID(null);
//
//            SubRequest sr = new SubRequest();
//            sr.setIsoCountryCode("iso");
//            sr.setSerialNumber("serial");
//            sr.setProductId("product");
//            sr.setIncludeContracts(false);
//            sr.setIncludeOffers(false);
//            
//            
//            
//            BatchReplyMapper.getInstance().mapEsReplytoEntitlementItem(e, sr);
//            assertFalse("Test case 5 should have generated an exception", false);
//        }catch(MapperException e) {
//            //          we should get an exception in that test
//            assertTrue(true);
//        }
//    }  
//    
//    
//    /*
//     * Tests With replies
//     */
//    /**
//     * test6: test mapEstoEntitlementItem with null EsReply 
//     * In that test, we will try to use the service to get Data and we will try to map it.
//     * The goal is not to prove correct mapping but more to prove that data can be mapped with no unexpected Exception
//     */
//    public void testRobustness() {
//        try {
//            String transId = null;
//            EsReply reply = null;
//            EsRequestComplexType request = null;
//            MetricsHandler handler   = null;
//            EntitlementItem batchReply= null;
//            EsServiceHandler serviceHandler = new EsServiceHandler();
//            BatchRequestMapper requestMapper= BatchRequestMapper.getInstance();
//            BatchReplyMapper replyMapper= BatchReplyMapper.getInstance();
//            SubRequest sr = null;
//            
//            System.out.println("Entering testRobustness");
//            // We call the service
//            
//            //First request (serial: 12345, pn=,country=US,includeContracts=false,includeOffers=false
//            	
//            serviceHandler.init();
//            
//            try {
//                transId = TransactionIdGenerator.getInstance().nextId();
//                handler = new MetricsHandler();
//                sr = new SubRequest();
//                sr.setIsoCountryCode("US");
//                sr.setSerialNumber("12345");
//                sr.setProductId("");
//                sr.setIncludeContracts(false);
//                sr.setIncludeOffers(false);                
//                
//                
//                request = requestMapper.createEsRequestComplexType(sr);                
//                reply = serviceHandler.callServiceWithObject(request,transId, handler);
//                batchReply= replyMapper.mapEsReplytoEntitlementItem(reply,sr);
//                
//                String ret = MarshalHelper.marshal(batchReply, handler);
//                System.out.println("TestRobustness 1 of Mapping for serial: 12345, pn=,country=US,includeContracts=false,includeOffers=false returned XML \n"+ret);
//            } catch(SifException e) {
//                try {
//	                batchReply= replyMapper.mapEsReplytoEntitlementItem(e,sr);
//	                String ret = MarshalHelper.marshal(batchReply, handler);
//	                System.out.println("TestRobustness 1 of Mapping for serial: 12345, pn=,country=US,includeContracts=false,includeOffers=false returned XML\n"+ret);
//                } catch(SifException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            
//            
//            try {
//                transId = TransactionIdGenerator.getInstance().nextId();
//                handler = new MetricsHandler();
//                sr = new SubRequest();
//                sr.setIsoCountryCode("US");
//                sr.setSerialNumber("12345");
//                sr.setProductId("");
//                sr.setIncludeContracts(true);
//                sr.setIncludeOffers(false);                
//                
//                
//                request = requestMapper.createEsRequestComplexType(sr);                
//                reply = serviceHandler.callServiceWithObject(request,transId, handler);
//                batchReply=replyMapper.mapEsReplytoEntitlementItem(reply,sr);
//                System.out.println("Mapping for test 2 robustness done will do marshalling");
//                String ret = MarshalHelper.marshal(batchReply, handler);
//                System.out.println("TestRobustness for test 2 of Mapping for serial: 12345, pn=,country=US,includeContracts=true,includeOffers=false returned XML:\n"+ret);
//            } catch(SifException e) {
//                try {
//	                batchReply= replyMapper.mapEsReplytoEntitlementItem(e,sr);
//	                String ret = MarshalHelper.marshal(batchReply, handler);
//	                System.out.println("TestRobustness for test 2 of Mapping for serial: 12345, pn=,country=US,includeContracts=true,includeOffers=false returned XML:\n"+ret);
//                } catch(SifException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            
//            try {
//                transId = TransactionIdGenerator.getInstance().nextId();
//                handler = new MetricsHandler();
//                sr = new SubRequest();
//                sr.setIsoCountryCode("US");
//                sr.setSerialNumber("HPSEJG1001");
//                sr.setProductId("");
//                sr.setIncludeContracts(true);
//                sr.setIncludeOffers(true);                
//
//                
//                request = requestMapper.createEsRequestComplexType(sr);                
//                reply = serviceHandler.callServiceWithObject(request,transId, handler);
//                batchReply=replyMapper.mapEsReplytoEntitlementItem(reply,sr);
//                System.out.println("Mapping for test 3 robustness done will do marshalling");
//                String ret = MarshalHelper.marshal(batchReply, handler);
//                
//                System.out.println("TestRobustness for test 3 of Mapping for serial: HPSEJG1001, pn=,country=US,includeContracts=true,includeOffers=true returned XML:\n"+ret);
//            } catch(SifException e) {
//                e.printStackTrace();
//                try {
//	                batchReply= replyMapper.mapEsReplytoEntitlementItem(e,sr);
//	                String ret = MarshalHelper.marshal(batchReply, handler);
//	                System.out.println("TestRobustness for test 3 of Mapping for serial: HPSEJG1001, pn=,country=US,includeContracts=true,includeOffers=true returned XML:\n"+ret);
//                } catch(SifException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            
//            try {
//                transId = TransactionIdGenerator.getInstance().nextId();
//                handler = new MetricsHandler();
//                sr = new SubRequest();
//                sr.setIsoCountryCode("US");
//                sr.setSerialNumber("HPSEJG1001");
//                sr.setProductId("");
//                sr.setIncludeContracts(true);
//                sr.setIncludeOffers(false);                                
//                
//                request = requestMapper.createEsRequestComplexType(sr);
//                
//                reply = serviceHandler.callServiceWithObject(request,transId, handler);
//                batchReply=replyMapper.mapEsReplytoEntitlementItem(reply,sr);
//                String ret = MarshalHelper.marshal(batchReply, handler);
//                
//                System.out.println("TestRobustness for test 4 of Mapping for serial: HPSEJG1001, pn=,country=US,includeContracts=true,includeOffers=false returned XML:\n"+ret);
//            } catch(SifException e) {
//                e.printStackTrace();
//                try {
//	                batchReply= replyMapper.mapEsReplytoEntitlementItem(e,sr);
//	                String ret = MarshalHelper.marshal(batchReply, handler);
//	                System.out.println("TestRobustness for test 4 of Mapping for serial: HPSEJG1001, pn=,country=US,includeContracts=true,includeOffers=true returned XML:\n"+ret);
//                } catch(SifException e1) {
//                    e1.printStackTrace();
//                }
//            }                        
//
//            try {
//                transId = TransactionIdGenerator.getInstance().nextId();
//                handler = new MetricsHandler();
//                sr = new SubRequest();
//                sr.setIsoCountryCode("US");
//                sr.setSerialNumber("OOS201P_0_SN_1");
//                sr.setProductId("");
//                sr.setIncludeContracts(true);
//                sr.setIncludeOffers(false);                
//                
//                
//                request = requestMapper.createEsRequestComplexType(sr);                
//                reply = serviceHandler.callServiceWithObject(request,transId, handler);
//                batchReply=replyMapper.mapEsReplytoEntitlementItem(reply,sr);
//                String ret = MarshalHelper.marshal(batchReply, handler);
//                
//                System.out.println("TestRobustness for test 4 of Mapping for serial: OOS201P_0_SN_1, pn=,country=US,includeContracts=true,includeOffers=false returned XML:\n"+ret);
//            } catch(SifException e) {
//                e.printStackTrace();
//                try {
//	                batchReply= replyMapper.mapEsReplytoEntitlementItem(e,sr);
//	                String ret = MarshalHelper.marshal(batchReply, handler);
//	                System.out.println("TestRobustness for test 4 of Mapping for serial: HPSEJG1001, pn=,country=US,includeContracts=true,includeOffers=false returned XML:\n"+ret);
//                } catch(SifException e1) {
//                    e1.printStackTrace();
//                }
//            }                                    
//            
//            try {
//                sr = new SubRequest();
//                sr.setIsoCountryCode("US");
//                sr.setSerialNumber("1J09FWB3E40S");
//                sr.setProductId("");
//                sr.setIncludeContracts(true);
//                sr.setIncludeOffers(true);                
//                
//                transId = TransactionIdGenerator.getInstance().nextId();
//                handler = new MetricsHandler();
//                request = requestMapper.createEsRequestComplexType(sr);                
//                reply = serviceHandler.callServiceWithObject(request,transId, handler);
//                batchReply=replyMapper.mapEsReplytoEntitlementItem(reply,sr);
//                String ret = MarshalHelper.marshal(batchReply, handler);
//                
//                System.out.println("TestRobustness for test 5 of Mapping for serial: 1J09FWB3E40S, pn=,country=US,includeContracts=true,includeOffers=true returned XML:\n"+ret);
//            } catch(SifException e) {
//                e.printStackTrace();
//                try {
//	                batchReply= replyMapper.mapEsReplytoEntitlementItem(e,sr);
//	                String ret = MarshalHelper.marshal(batchReply, handler);
//	                System.out.println("TestRobustness for test 5 of Mapping for serial: HPSEJG1001, pn=,country=US,includeContracts=true,includeOffers=true returned XML:\n"+ret);
//                } catch(SifException e1) {
//                    e1.printStackTrace();
//                }
//            }                                    
//            
//            assertTrue(true);
//        } catch(MapperException e) {
//            // we should not get an exception in that test
//            assertTrue("No Exception should be raised",false);
//        }
//    }  
// 
//    // We will extend the test coverage with some input parameters and some expected replies
//
//    /*
//
//     * test6: test mapEstoEntitlementItem with null EsReply 
//     * In that test, we will try to use the service to get Data and we will try to map it.
//     * The goal is not to prove correct mapping but more to prove that data can be mapped with no unexpected Exception
//    public void testWithFunctionnalTestreplies() {
//
//        File f = new File("C:\\work\\entitlement_project\\entitlement_svn\\service_8_1_1_C3_main\\service\\test\\functional\\reply");
//        String   list[] = f.list(new XMLFileFilter());
//        BatchReplyMapper mapper = BatchReplyMapper.getInstance();
//        EntitlementItem batchReply=null;
//        for(int cptFile=0; cptFile<list.length;cptFile++) {
//            try {
//	            String fileName= list[cptFile];
//	            File   file    = new File( "C:\\work\\entitlement_project\\entitlement_svn\\service_8_1_1_C3_main\\service\\test\\functional\\reply\\"+ fileName);
//	            FileInputStream fis = new FileInputStream(file);
//	            InputStreamReader fileReader = new InputStreamReader( fis, "UTF-8");
//	            String ret = readerToString(fileReader);
//	            
//	            EIAMessage    msg =EIADocumentHandler.readEIAMessage(ret);
//	            String messageType = EIADocumentHandler.getMessageType(msg);
//	            System.out.println("We read reply "+cptFile+ "let's map it");
//	            
//	            if (messageType.trim().equalsIgnoreCase("error")) {
//	                System.out.println("UnMarshalling "+cptFile+ " SifException");
//	                SifException e =
//	                    (SifException)MarshalHelper.unmarshal(
//	                        msg.getMessageBody(),
//	                        null,
//	                        SifException.class);
//	                
//	                batchReply= batchReply = mapper.mapEsReplytoEntitlementItem(e,"us","serial","product", true);
//	                System.out.println("Mapping done for  "+cptFile+ " SifException");
//	                String retXML = MarshalHelper.marshal(batchReply, null);
//	                
//	                System.out.println("TestRobustness for "+cptFile+"of Mapping for \n"+msg.getMessageBody()+"\n"+retXML);                
//	
//	            }else {
//	                System.out.println("Will be UnMarshalling "+fileName+ " EsReply");
//	                EsReply reply =
//	                    (EsReply)MarshalHelper.unmarshal(
//	                        msg.getMessageBody(),
//	                        null,
//	                        EsReply.class);
//	                
//	                EntitlementBySnRequest snRequest= reply.getEsHeader().getInputRequest().getEsRequestComplexTypeChoice().getEntitlementBySnRequest();
//	                if(snRequest.getIncludeWarranty() && snRequest.getIsoCountryCd()!=null && snRequest.getSerialNumber()!=null)  {
//	                    batchReply= mapper.mapEsReplytoEntitlementItem(reply,snRequest.getIsoCountryCd(),snRequest.getSerialNumber(),snRequest.getProductID(), snRequest.getIncludeOffers());
//		                System.out.println("Mapping done for  "+cptFile+ " EsReply umarshall will take place in a sec");
//		                String retXML = MarshalHelper.marshal(batchReply, null);
//		                System.out.println("TestRobustness for "+cptFile+"of Mapping for \n"+msg.getMessageBody()+"\n"+retXML);
//	                }else {
//	                    System.out.println("Test "+cptFile+ " does not include warranty so it's invalid");
//	                }
//	            }
//            }catch(Exception ex) {
//                ex.printStackTrace();
//            }
//
//            
//            
//            
//        }
//            
//        
//        
//    }
//*/    
//
//        
//    /*
//     * coompare
//     * @param expected 
//     * @param current
//     * @return true if both objects have the same content
//     */
//    private boolean compare(EntitlementItem expected, EntitlementItem current) throws Exception{
//        CastorObjectComparator cc= new CastorObjectComparator(null);
//        //We create a method local variable to allow smooth debugging.
//        
//        boolean bReturned=cc.compare(expected,current,"root");
//        
//        return bReturned;
//        
//    }
//
//    private EntitlementItem buildReplyforTest2() {
//        EntitlementItem itemReply = new EntitlementItem();
//        InputParameter ip =new InputParameter();
//        ip.setIsoCountryCd("iso");
//        ip.setProductID("product");
//        ip.setSerialNumber(null);
//        itemReply.setInputParameter(ip);
//        itemReply.setEntitlementStatus(EntitlementStatusType.E);
//        itemReply.setEntitlementSummary(null);
//        
//
//        itemReply.setPartialResultFlag(PartialResultFlagType.N);
//        
//        
//        return itemReply;
//    }
//    
//    
//    private EntitlementItem buildReplyforTest3() {
//        EntitlementItem itemReply = new EntitlementItem();
//        InputParameter ip =new InputParameter();
//        ip.setIsoCountryCd("iso");
//        ip.setProductID("product");
//        ip.setSerialNumber("serial");
//        
//        itemReply.setInputParameter(ip);
//        itemReply.setEntitlementStatus(EntitlementStatusType.E);
//        itemReply.setEntitlementSummary(null);
//        
//
//        itemReply.setPartialResultFlag(PartialResultFlagType.Y);
//        
//        
//        return itemReply;
//    }
    
    /**
     * Read the entire content of a Reader into a String
     *
     * @param a Reader object
     * @return String containing the content of the Reader
     * @throws IOException
     */
    public static String readerToString(Reader is) throws IOException{
       StringBuffer sb = new StringBuffer();
       char [] b = new char[8192];
       int n;
       //Read a block. If it gets any chars, append them.
       while((n = is.read(b)) > 0 ) {
        sb.append(b, 0, n);
        }
        //Only construct the String object once, here.
        return sb.toString();
    }    
}

/*
One inner class
*/
class XMLFileFilter implements java.io.FilenameFilter {

    public XMLFileFilter() {
    }

    public boolean accept(File dir, String name) {
        if(name != null) {
            if(name.startsWith("getEntitlementBySN")) {
	            if(name.endsWith(".xml")) {
	                return true;
	            }
            }
        }
        return false;
    }

    
    
}