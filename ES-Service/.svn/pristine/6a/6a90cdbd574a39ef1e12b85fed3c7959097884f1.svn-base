package com.hp.es.service.warrantyEntitlement.orchestration;

import java.util.ArrayList;

import org.junit.Assert;

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
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.sif.SifException;

public class WarrantyDeterminationCodeTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(WarrantyDeterminationCodeTest.class);
	}

	public WarrantyDeterminationCodeTest(String arg0) {
		super(arg0);
	}

    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(WarrantyDeterminationCodeTest.class);
    }
    
	/*
	 * Test method for 'com.hp.es.service.warrantyEntitlement.orchestration.WarrantyDeterminationCode.getHigestPriority(OrchestrationReply[])'
	 */
	public void testGetHigestPriorityWithNullReplies() {
		ArrayList<Transaction> replies = null;
		EsRequestComplexType request = null;
		try {
			WarrantyDeterminationCode.getInstance().getHighestPriority(replies, request);
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}

	/*
	 * Test method for 'com.hp.es.service.warrantyEntitlement.orchestration.WarrantyDeterminationCode.getHigestPriority(OrchestrationReply[])'
	 */
	public void testGetHigestPriorityWithEmptyReplies() {
		ArrayList<Transaction> replies = new ArrayList<Transaction>(10);
		EsRequestComplexType request = null;
		try {
			WarrantyDeterminationCode.getInstance().getHighestPriority(replies, request);
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}	
	
	/*
	 * Test method for 'com.hp.es.service.warrantyEntitlement.orchestration.WarrantyDeterminationCode.getHigestPriority(OrchestrationReply[])'
	 */
	public void testGetHigestPriorityWithOnlyException() {
		ArrayList<Transaction> replies = new ArrayList<Transaction>(10);
		EsRequestComplexType request = null;
		for(int i= 0;i<10;i++) {
			Transaction reply = new ErrorTransaction(null, false, new Throwable(), "Error "+ i,true);
			replies.add(reply);
		}
		
		try {
			WarrantyDeterminationCode.getInstance().getHighestPriority(replies, request);
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}	
	
	/*
	 * Test method for 'com.hp.es.service.warrantyEntitlement.orchestration.WarrantyDeterminationCode.getHigestPriority(OrchestrationReply[])'
	 */
	public void testGetHigestPriorityWithRepliesAndException() {
		ArrayList<Transaction> replies = new ArrayList<Transaction>(10);
		EsRequestComplexType request = null;
		for(int i= 0;i<10;i++) {
			
			if(i%2 == 0) {
				Transaction reply = new ErrorTransaction(null, false, ErrorFactory.getSifException(ErrorFactory.id100_SERVICE_UNREACHABLE), "Region "+i, true);
				replies.add(reply);
			} else {
				Transaction reply = new WarrantyTransaction(null, false, null, "","REPLY"+i, true);
				reply.setSourceSystemThrowable(null);
				EsReply esReply = new EsReply();
				esReply.setEsHeader(new EsHeader());
				esReply.setEsReplyChoice(new EsReplyChoice());
				esReply.getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
				WarrantyComplexType war = new WarrantyComplexType();
				esReply.getEsReplyChoice().getWarrantyEntitlement().addWarranty(war);
				war.setWarrantyDeterminationCode("33");
				reply.setMappedReply(esReply);
				replies.add(reply);
			}
		}
		
		try {
			WarrantyDeterminationCode.getInstance().getHighestPriority(replies, request);
			assertTrue(true);
		} catch (SifException e1) {
			assertTrue(true);
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			e.printStackTrace();
			fail();
		}
	}

	/*
	 * Test the WarrantyDeterminationCode mapping
	 */
	public void testWarrantyDeterminationCode() {
		assertEquals("03", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("01"));
		assertEquals("02", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("02"));
		assertEquals("04", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("04"));
		assertEquals("09", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("09"));
		assertEquals("14", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("14"));
		assertEquals("30", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("06"));
		assertEquals("31", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("03"));
		assertEquals("32", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("05"));
		assertEquals("36", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("07"));
		//assertEquals("33", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("10"));
		assertEquals("33", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("33"));
		assertEquals("", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("88"));
		//tests added for TIBET 11		
		assertEquals("20", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("20"));
		assertEquals("21", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("21"));
		assertEquals("22", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("22"));
		assertEquals("23", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("23"));
		assertEquals("24", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("24"));
		assertEquals("25", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("25"));
		assertEquals("26", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("26"));
		assertEquals("27", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("27"));
		assertEquals("28", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationCode("28"));		
	}
	
	/*
	 * Test the WarrantyDeterminationDescription mapping
	 */
	public void testWarrantyDeterminationDescription() {
		assertEquals("Serial Number decode", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("01"));
		assertEquals("Ship date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("02"));
		assertEquals("Sales receipt Purchase date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("04"));
		assertEquals("Manufacturing date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("09"));
		assertEquals("Option warranty", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("14"));
		assertEquals("Factory Restart", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("06"));
		assertEquals("Install Date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("03"));
		assertEquals("Born On Date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("05"));
		assertEquals("Introduction", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("07"));
		assertEquals("", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("55"));
		//tests added for TIBET 11
		assertEquals("Factory restart", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("20"));
		assertEquals("Install Date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("21"));
		assertEquals("Born On Date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("22"));
		assertEquals("Sales receipt Purchase date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("23"));
		assertEquals("Out of Warranty", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("24"));
		assertEquals("Dealer Sold Date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("25"));
		assertEquals("Ship date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("26"));
		assertEquals("Ship date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("27"));
		assertEquals("SNR Manufacturing Date", WarrantyDeterminationCode.getInstance().getWarrantyDeterminationDescription("28"));
	}
	
}
