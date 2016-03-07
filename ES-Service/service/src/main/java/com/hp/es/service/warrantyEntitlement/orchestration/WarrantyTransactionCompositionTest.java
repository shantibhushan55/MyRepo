/**
 * 
 */
package com.hp.es.service.warrantyEntitlement.orchestration;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public class WarrantyTransactionCompositionTest extends TestCase {

	/**
	 * 
	 */
	public WarrantyTransactionCompositionTest() {
		super();
	}

   /* public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(WarrantyTransactionCompositionTest.class);
    }
*/
	
	/**
	 * @param arg0
	 */
	public WarrantyTransactionCompositionTest(String arg0) {
		super(arg0);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//junit.textui.TestRunner.run(suite());
		WarrantyTransactionCompositionTest cc= new WarrantyTransactionCompositionTest();
		//cc.testGetComposedReplyForProductWarranty();
		cc.testGetComposedReplyWithOnlyRepliesForAUnitList();
	}
	
	/*
	 * Test with an Null list of replies
	 */
	/*public void testGetComposedReplyWithNullOrchestrationReplies() {
		ArrayList replies = null;
		EsRequestComplexType request = null;
		try {
			WarrantyTransactionComposition.getInstance().getComposedReply(replies, request);
			fail();
		}catch(SifException e) {
			assertTrue(true);
		}
		
		
		
	}*/

	
	/*
	 * Test with an mty list of replies
	 */
/*	public void testGetComposedReplyWithEmptyOrchestrationReplies() {
		ArrayList replies = null;
		EsRequestComplexType request = null;
		try {
			WarrantyTransactionComposition.getInstance().getComposedReply(replies, request);
			fail();
		}catch(SifException e) {
			assertTrue(true);
		}
	}	*/
	
	/*
	 * Test with an mty list of replies
	 */
	/*public void testGetComposedReplyWithOnlyException() {
		

		ArrayList replies = new ArrayList();
		EsRequestComplexType request = null;
		for(int i= 0;i<4;i++) {
			if(i%2 == 0) {
				Transaction reply = new ErrorTransaction(null, false, ErrorFactory.getSifException(ErrorFactory.id214_PRODUCT_PART_NOT_ELIGIBLE),"ERROR" +i, true);
				replies.add(reply);
			}else {
				Transaction reply = new ErrorTransaction(null, false, ErrorFactory.getSifException(ErrorFactory.id210_PRODUCT_NR_NOT_FOUND),"ERROR" +i, true);
				replies.add(reply);				
			}
		}
		
		try {
			WarrantyTransactionComposition.getInstance().getComposedReply(replies, request);
			
		}catch(SifException e) {
			assertEquals("We waited for a 9999","9999",e.getErrorID());
		}
	}		

	*/
	/*
	 * Test with an mty list of replies
	 */
	public void testGetComposedReplyWithOnlyRepliesForAUnitList() {
		

		ArrayList replies = new ArrayList();
		EsRequestComplexType request = null;
		for(int i= 0;i<6;i++) {
			Transaction tr = new WarrantyTransaction(null, false, null, "","ERROR" +i,true);
			EsReply esReply = new EsReply();
			esReply.setEsHeader(new EsHeader());
			esReply.setEsReplyChoice(new EsReplyChoice());
			replies.add(tr);
			if(i%2 == 0) {
				esReply.getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
				
				WarrantyComplexType war = new WarrantyComplexType();
				esReply.getEsReplyChoice().getWarrantyEntitlement().addWarranty(war);
				war.setWarrantyDeterminationCode("0"+i);			
				
				esReply.getEsReplyChoice().getWarrantyEntitlement().setOOS(new OOSComplexType());
				
				esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().addSerialNumber("SN1234");
				esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().setProduct(new ProductComplexType());
				
				esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct().setProductID("PN78"+i);
			}else {
				esReply.getEsReplyChoice().setUnitList(new UnitListComplexType());
				UnitListComplexType ul = esReply.getEsReplyChoice().getUnitList();
				ul.setSerialNumber("SN1234");
				ProductComplexType pct = new ProductComplexType();
				pct.setProductID("PNUL1"+i);
				pct.setProductDescription("aaa");
				ul.addProduct(pct);
				pct = new ProductComplexType();
				pct.setProductID("PNUL2"+i);
				pct.setProductDescription("pRODOCUT");
				ul.addProduct(pct);
			}
			
			tr.setMappedReply(esReply);
		}
		
		try {
			EsReply reply = WarrantyTransactionComposition.getInstance().getComposedReply(replies, request);
			
			assertEquals("Unit List does not match",9,reply.getEsReplyChoice().getUnitList().getProductCount());
		}catch(SifException e) {
			fail("Unexpected exception");
		}
	}
	
	/*
	 * Test with an mty list of replies
	 */
	/*public void testGetComposedReplyWithOnlyRepliesForAUnitListAndException() {
		

		ArrayList replies = new ArrayList();
		EsRequestComplexType request = null;
		
		for(int i= 0;i<6;i++) {

			if(i == 0 || i == 1) {
				SifException e = ErrorFactory.getSifException(ErrorFactory.id8001_SYSTEM_NOT_AVAILABLE,"AP"+i);
				ErrorTransaction reply = new ErrorTransaction(null, false, e,"ERROR" +i, true); 
				replies.add(reply);
				
		
			}else {  
				Transaction repliesi = new WarrantyTransaction(null, false, null, "","REPLY" +i, true);
				EsReply esReply = new EsReply();
				esReply.setEsHeader(new EsHeader());
				esReply.setEsReplyChoice(new EsReplyChoice());			
				if(i%2 == 0) {
					esReply.getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
					
					WarrantyComplexType war = new WarrantyComplexType();
					esReply.getEsReplyChoice().getWarrantyEntitlement().addWarranty(war);
					war.setWarrantyDeterminationCode("0"+i);			
					
					esReply.getEsReplyChoice().getWarrantyEntitlement().setOOS(new OOSComplexType());
					
					esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().addSerialNumber("SN1234");
					esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().setProduct(new ProductComplexType());
					
					esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct().setProductID("PN78"+i);
				}else {
					esReply.getEsReplyChoice().setUnitList(new UnitListComplexType());
					UnitListComplexType ul = esReply.getEsReplyChoice().getUnitList();
					ul.setSerialNumber("SN1234");
					ProductComplexType pct = new ProductComplexType();
					pct.setProductID("PNUL1"+i);
					pct.setProductDescription("aaa");
					ul.addProduct(pct);
					pct = new ProductComplexType();
					pct.setProductID("PNUL2"+i);
					pct.setProductDescription("pRODOCUT");
					ul.addProduct(pct);
				}
				repliesi .setMappedReply(esReply);
				replies.add(repliesi );
			}
			
			
		}
		
		try {
			EsReply reply = WarrantyTransactionComposition.getInstance().getComposedReply(replies, request);
			
			assertEquals("Unit List does not match",6,reply.getEsReplyChoice().getUnitList().getProductCount());
			assertEquals("Warning cpount does not match",1,reply.getEsHeader().getWarnings().getEIAErrorCount());
			assertEquals("Id does not match","400",reply.getEsHeader().getWarnings().getEIAError(0).getErrorID());
			assertEquals("The following systems are not available, warranty calculation is proceeding with reduced logic: NOT_CONFIGURED, NOT_CONFIGURED",reply.getEsHeader().getWarnings().getEIAError(0).getErrorText());
			
		}catch(SifException e) {
			fail("Unexpected exception");
		}
	}	*/

	
	/*
	 * Test with an mty list of replies
	 */
	/*public void testGetComposedReplyWithOnlyRepliesForAUnitListAndException2() {
		

		ArrayList replies = new ArrayList();
		EsRequestComplexType request = null;
		for(int i= 0;i<6;i++) {

			if(i == 0 || i == 1) {
				SifException e = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR);
				ErrorTransaction reply = new ErrorTransaction(null, false, e,"ERROR" +i, true); 
				replies.add(reply);
				
		
			}else {  
				WarrantyTransaction repliesi = new WarrantyTransaction(null, false, null, "","REPLY" +i, true);
				EsReply esReply = new EsReply();
				esReply.setEsHeader(new EsHeader());
				esReply.setEsReplyChoice(new EsReplyChoice());			
				if(i%2 == 0) {
					esReply.getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
					
					WarrantyComplexType war = new WarrantyComplexType();
					esReply.getEsReplyChoice().getWarrantyEntitlement().addWarranty(war);
					war.setWarrantyDeterminationCode("0"+i);			
					
					esReply.getEsReplyChoice().getWarrantyEntitlement().setOOS(new OOSComplexType());
					
					esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().addSerialNumber("SN1234");
					esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().setProduct(new ProductComplexType());
					
					esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct().setProductID("PN78"+i);
				}else {
					esReply.getEsReplyChoice().setUnitList(new UnitListComplexType());
					UnitListComplexType ul = esReply.getEsReplyChoice().getUnitList();
					ul.setSerialNumber("SN1234");
					ProductComplexType pct = new ProductComplexType();
					pct.setProductID("PNUL1"+i);
					pct.setProductDescription("aaa");
					ul.addProduct(pct);
					pct = new ProductComplexType();
					pct.setProductID("PNUL2"+i);
					pct.setProductDescription("pRODOCUT");
					ul.addProduct(pct);
				}
				repliesi.setMappedReply(esReply);
				replies.add(repliesi);
			}
			
			
		}
		
		try {
			EsReply reply = WarrantyTransactionComposition.getInstance().getComposedReply(replies, request);
			
			assertEquals("Unit List does not match",6,reply.getEsReplyChoice().getUnitList().getProductCount());
			assertEquals("Warning cpount does not match",null,reply.getEsHeader().getWarnings());
			
		}catch(SifException e) {
			fail("Unexpected exception");
		}
	}	*/

	
	/*
	 * Test with an mty list of replies
	 */
	/*public void testGetComposedReplyForProductWarranty() {
		

		ArrayList replies = new ArrayList(6);
		EsRequestComplexType request = null;
		for(int i= 0;i<6;i++) {

			if(i == 0 || i == 1) {
				SifException e = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR);
				ErrorTransaction reply = new ErrorTransaction(null, false, e, "ERROR" +i, true); 
				replies.add(reply);
				
		
			}else {  
				Transaction reply = new WarrantyTransaction(null, false, null, "", "Reply" +i, true);
				replies.add(reply);
				EsReply esReply = new EsReply();
				esReply.setEsHeader(new EsHeader());
				esReply.setEsReplyChoice(new EsReplyChoice());			

				esReply.getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
				
				WarrantyComplexType war = new WarrantyComplexType();
				esReply.getEsReplyChoice().getWarrantyEntitlement().addWarranty(war);
				war.setWarrantyDeterminationCode("0"+i);			
				
				reply.setMappedReply(esReply);
				reply.setLocal(true);
				
			}
			
			
		}
		
		try {
			EsReply reply = WarrantyTransactionComposition.getInstance().getComposedReply(replies, request);
			System.out.println(reply.getEsReplyChoice().getWarrantyEntitlement());
			assertNotSame("Unit List does not match",null,reply.getEsReplyChoice().getWarrantyEntitlement());
			
			
		}catch(SifException e) {
			fail("Unexpected exception");
			System.out.println("$$$$$$$$$$$$$"+e);
		}
	}	
*/
	/*
	 * Test with an mty list of replies
	 */
	/*public void testGetComposedReplyForIBWarranty() {
		

		ArrayList replies = new ArrayList(6);
		EsRequestComplexType request = null;
		for(int i= 0;i<6;i++) {

			if(i == 0 || i == 1) {
				SifException e = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR);
				ErrorTransaction reply = new ErrorTransaction(null, false, e,"ERROR" +i, true); 
				replies.add(reply);
				
		
			}else {  
				Transaction reply =  new WarrantyTransaction(null, false, null, "","REPLY" +i, true);
				EsReply esReply = new EsReply();
				esReply.setEsHeader(new EsHeader());
				esReply.setEsReplyChoice(new EsReplyChoice());			

				esReply.getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
				
				WarrantyComplexType war = new WarrantyComplexType();
				esReply.getEsReplyChoice().getWarrantyEntitlement().addWarranty(war);
				war.setWarrantyDeterminationCode("0"+i);			
				
				esReply.getEsReplyChoice().getWarrantyEntitlement().setOOS(new OOSComplexType());
				
				esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().addSerialNumber("SN1234");
				esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().setProduct(new ProductComplexType());
				
				esReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct().setProductID("PN78");
				reply.setMappedReply(esReply);
				reply.setLocal(true);
				
			}
			
			
		}
		
		try {
			EsReply reply = WarrantyTransactionComposition.getInstance().getComposedReply(replies, request);
			
			assertEquals("Warranty det code is not as expected","04",reply.getEsReplyChoice().getWarrantyEntitlement().getWarranty(0).getWarrantyDeterminationCode());
			
			
		}catch(SifException e) {
			e.printStackTrace();
			fail("Unexpected exception");
		}
	}		*/
}
