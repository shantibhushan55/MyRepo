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
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public class WarrantyErrorsProcessingTest extends TestCase {

	/**
	 * 
	 */
	public WarrantyErrorsProcessingTest() {
		super();
	}

	/**
	 * @param arg0
	 */
	public WarrantyErrorsProcessingTest(String arg0) {
		super(arg0);
	}
	
    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(WarrantyErrorsProcessingTest.class);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		junit.textui.TestRunner.run(suite());

	}
	
	
	/*
	 * Test with an Null list of replies
	 */
	public void testCountSifExceptionWithNullOrchestrationReplies() throws SifException {
		ArrayList replies = null;
		
		int count = WarrantyErrorsProcessing.getInstance().countSifException(replies);
		assertEquals("its should have been 0",0,count);
		
		
	}

	
	/*
	 * Test with an mty list of replies
	 */
	public void testCountSifExceptionWithEmptyOrchestrationReplies() throws SifException {
		ArrayList replies = new ArrayList(10);
		
		int count = WarrantyErrorsProcessing.getInstance().countSifException(replies);
		assertEquals("its should have been 0",0,count);
	}

	
	/*
	 * Test with an mty list of replies
	 */
	public void testCountSifExceptionWithOnlyException() throws SifException {
		ArrayList replies = new ArrayList(10);
		for(int i=0;i<10;i++) {
			Transaction reply = new ErrorTransaction(null, true, new RuntimeException(),"Error" +i, true);
			replies.add(reply);
		}
		int count = WarrantyErrorsProcessing.getInstance().countSifException(replies);
		assertEquals("its should have been 10",10,count);
	}	
	
	/*
	 * Test with an mty list of replies
	 */
	public void testCountSifExceptionWithnotOnlyException() throws SifException {
		ArrayList replies = new ArrayList(10);
		for(int i=0;i<10;i++) {
			Transaction reply = new ErrorTransaction(null, true, new RuntimeException(),"Error" +i, true);
			if(i%2 != 0) {
				reply.setSourceSystemResponse(null);
				reply.setSourceSystemThrowable(null);
			}
			
			replies.add(reply);
		}
		int count = WarrantyErrorsProcessing.getInstance().countSifException(replies);
		assertEquals("its should have been 10",10, count);
	}
	
	
	
	/*
	 * Test with an Null list of replies
	 */
	public void testGetHighestPriorityExceptionWithNullOrchestrationReplies() throws SifException {
		ArrayList replies = null;
		
		SifException e = WarrantyErrorsProcessing.getInstance().getHighestPriorityException(replies);
		
		assertEquals("its should have been a 9999","9999",e.getErrorID());
		
		
	}

	
	/*
	 * Test with an mty list of replies
	 */
	public void testGetHighestPriorityExceptionWithEmptyOrchestrationReplies() throws SifException {
		ArrayList replies = new ArrayList(10);
		
		SifException e = WarrantyErrorsProcessing.getInstance().getHighestPriorityException(replies);
		
		assertEquals("its should have been a 9999","9999",e.getErrorID());
	}

	
	/*
	 * Test with an mty list of replies
	 */
	public void testGetHighestPriorityExceptionWithOneException() throws SifException {
		ArrayList replies = new ArrayList(10);
		SifException e1 = ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND);
		Transaction reply = new ErrorTransaction(null, true, e1,"Error",true);
		replies.add(reply);
		
		
		SifException e2 = WarrantyErrorsProcessing.getInstance().getHighestPriorityException(replies);
		
		assertEquals("its should have been a 300","300",e2.getErrorID());
	}	
	
	/*
	 * Test with an mty list of replies
	 */
	public void testGetHighestPriorityExceptionWithSomeException() throws SifException {
		ArrayList replies = new ArrayList(10);
		for(int i=0;i<10;i++) {
			Transaction reply = null;
			if(i%2 != 0) {
				SifException e1 =ErrorFactory.getSifException(ErrorFactory.id214_PRODUCT_PART_NOT_ELIGIBLE);
				reply = new ErrorTransaction(null, true, e1,"Error" +i, true);
			}else {
				SifException e1 =ErrorFactory.getSifException(ErrorFactory.id200_MISSING_PARAMETER,"Id");
				reply = new ErrorTransaction(null, true, e1,"Error" +i, true);
			}
			
			replies.add(reply);
		}
		SifException e2 = WarrantyErrorsProcessing.getInstance().getHighestPriorityException(replies);
		
		assertEquals("its should have been a 214","214",e2.getErrorID());
	}	
	
	/*
	 * Test with an mty list of replies
	 */
	public void testGetHighestPriorityExceptionWithSomeExceptionToRefine() throws SifException {
		ArrayList replies = new ArrayList(10);
		for(int i = 0; i < 10; i++) {
			Transaction reply = null;
			if (i == 0) {
				SifException e1 = ErrorFactory.getSifException(210, "12345");
				reply = new ErrorTransaction(null, true, e1, "Error" +i, true);
			}else if(i%2 != 0) {
				SifException e1 = ErrorFactory.getSifException(8000, "AP" + i);
				reply = new ErrorTransaction(null, true, e1, "AP" + i, true);
			}else {
				SifException e1 = ErrorFactory.getSifException(234, "AP" + i);
				reply = new ErrorTransaction(null, true, e1, "AP" + i, true);			
				
			}
			
			replies.add(reply);
		}
		SifException e2 = WarrantyErrorsProcessing.getInstance().getHighestPriorityException(replies);
		
		assertEquals("its should have been a 234","234",e2.getErrorID());
	}	
		
}
