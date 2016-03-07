/*
 * Created on Mar 16, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import junit.framework.TestCase;

import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EsRequestComplexType;


/**
 * @author juhank
 */
public class WorkingMapperTest extends TestCase {

	private EsRequestComplexType _request;
	
//	public static void main(String[] args) {
//		junit.textui.TestRunner.run(WorkingMapperTest.class);
//	}

//	public WorkingMapperTest(String arg0) {
//		super(arg0);
//		createRequest();
//	}
//
//	public static Test suite() {
//        // discover test*() methods via reflection:
//        return new TestSuite(WorkingMapperTest.class);
//    }
//	
	/*
	 * Test method for mapping workings
	 */
	public void testWorkingsWithWarning1005() {
//		WarrantyTransaction transaction = createTransaction("1005", "Message of warning id 1005");
//		WorkingComplexType workings[] = null;
//		EsRequestComplexType request = createWarrantyRequest();
//		WorkingMapper wm = WorkingMapper.getInstance(transaction, request,null, null);
//		try {
//			workings = wm.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertNotNull(workings);
//		assertEquals(workings[0].getWorkingName(), "SWOP Warranty ID");
//		assertEquals(workings[0].getWorkingValue(), "232323");
//
//		assertEquals(workings[1].getWorkingName(), "SWOP Warranty Start Date");
//		assertEquals(workings[1].getWorkingValue(), "2005-10-03");
//
//		assertEquals(workings[2].getWorkingName(), "SWOP Grace Period");
//		assertEquals(workings[2].getWorkingValue(), "2");
//
//		assertEquals(workings[3].getWorkingName(), "SWOP Proof Of Purchase Date");
//		assertEquals(workings[3].getWorkingValue(), "2006-03-25");
//
//		assertEquals(workings[4].getWorkingName(), "SWOP Shipment Date");
//		assertEquals(workings[4].getWorkingValue(), "2006-03-23");
//
//		assertEquals(workings[5].getWorkingName(), "SWOP Installation Date");
//		assertEquals(workings[5].getWorkingValue(), "2006-03-26");
//
//		assertEquals(workings[6].getWorkingName(), "SWOP Born On Date");
//		assertEquals(workings[6].getWorkingValue(), "2006-03-24");
//
//		assertEquals(workings[7].getWorkingName(), "SWOP Factory Restart Date");
//		assertEquals(workings[7].getWorkingValue(), "2006-03-27");
//
//		assertEquals(workings[8].getWorkingName(), "SWOP Start Date Type");
//		assertEquals(workings[8].getWorkingValue(), "03");
//
//		assertEquals(workings[9].getWorkingName(), "SWOP Instance");
//		assertEquals(workings[9].getWorkingValue(), "NOT_CONFIGURED");
//
//		assertEquals(workings[10].getWorkingName(), "SWOP Request Status");
//		assertEquals(workings[10].getWorkingValue(), "Error");
//
//		assertEquals(workings[11].getWorkingName(), "SWOP Original Product");
//		assertEquals(workings[11].getWorkingValue(), "11113333");
//
//		assertEquals(workings[12].getWorkingName(), "SWOP Original Alias");
//		assertEquals(workings[12].getWorkingValue(), "778877");
//
//		assertEquals(workings[13].getWorkingName(), "SWOP Unit List Returned");
//		assertEquals(workings[13].getWorkingValue(), "N");
//
//		assertEquals(workings[14].getWorkingName(), "SWOP Product Base Warranty");
//		assertEquals(workings[14].getWorkingValue(), "N");
	}
//	
//	private EsRequestComplexType createWarrantyRequest() {
//		EsRequestComplexType request = new EsRequestComplexType ();
//		request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
//		request.getEsRequestComplexTypeChoice().setWarrantyRequest(new WarrantyRequest());
//		request.getEsRequestComplexTypeChoice().getWarrantyRequest().setProductID("OriginalProduct");
//		return request;
//	}
//
//	public void testWorkingsWithWarning1009() {
//		WarrantyTransaction transaction = createTransaction("1009", "Message of warning id 1009");
//		WorkingComplexType workings[] = null;
//		EsRequestComplexType request = createWarrantyRequest();
//		WorkingMapper wm = WorkingMapper.getInstance(transaction, request,null, null);
//		try {
//			workings = wm.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertNotNull(workings);
//		assertEquals(workings[0].getWorkingName(), "SWOP Warranty ID");
//		assertEquals(workings[0].getWorkingValue(), "232323");
//
//		assertEquals(workings[1].getWorkingName(), "SWOP Warranty Start Date");
//		assertEquals(workings[1].getWorkingValue(), "2005-10-03");
//
//		assertEquals(workings[2].getWorkingName(), "SWOP Grace Period");
//		assertEquals(workings[2].getWorkingValue(), "2");
//
//		assertEquals(workings[3].getWorkingName(), "SWOP Proof Of Purchase Date");
//		assertEquals(workings[3].getWorkingValue(), "2006-03-25");
//
//		assertEquals(workings[4].getWorkingName(), "SWOP Shipment Date");
//		assertEquals(workings[4].getWorkingValue(), "2006-03-23");
//
//		assertEquals(workings[5].getWorkingName(), "SWOP Installation Date");
//		assertEquals(workings[5].getWorkingValue(), "2006-03-26");
//
//		assertEquals(workings[6].getWorkingName(), "SWOP Born On Date");
//		assertEquals(workings[6].getWorkingValue(), "2006-03-24");
//
//		assertEquals(workings[7].getWorkingName(), "SWOP Factory Restart Date");
//		assertEquals(workings[7].getWorkingValue(), "2006-03-27");
//
//		assertEquals(workings[8].getWorkingName(), "SWOP Start Date Type");
//		assertEquals(workings[8].getWorkingValue(), "03");
//
//		assertEquals(workings[9].getWorkingName(), "SWOP Instance");
//		assertEquals(workings[9].getWorkingValue(), "NOT_CONFIGURED");
//
//		assertEquals(workings[10].getWorkingName(), "SWOP Request Status");
//		assertEquals(workings[10].getWorkingValue(), "Error");
//
//		assertEquals(workings[11].getWorkingName(), "SWOP Unit List Returned");
//		assertEquals(workings[11].getWorkingValue(), "N");
//
//		assertEquals(workings[12].getWorkingName(), "SWOP Product Base Warranty");
//		assertEquals(workings[12].getWorkingValue(), "Y");
//	}
//	
//	public void testWorkingsWithWarning1000() {
//		WarrantyTransaction transaction = createTransaction("1000", "Message of warning id 1000");
//		WorkingComplexType workings[] = null;
//		EsRequestComplexType request = createWarrantyRequest();
//		WorkingMapper wm = WorkingMapper.getInstance(transaction, request,null, null);
//		
//		try {
//			workings = wm.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertNotNull(workings);
//		assertEquals(workings[0].getWorkingName(), "SWOP Warranty ID");
//		assertEquals(workings[0].getWorkingValue(), "232323");
//
//		assertEquals(workings[1].getWorkingName(), "SWOP Warranty Start Date");
//		assertEquals(workings[1].getWorkingValue(), "2005-10-03");
//
//		assertEquals(workings[2].getWorkingName(), "SWOP Grace Period");
//		assertEquals(workings[2].getWorkingValue(), "2");
//
//		assertEquals(workings[3].getWorkingName(), "SWOP Proof Of Purchase Date");
//		assertEquals(workings[3].getWorkingValue(), "2006-03-25");
//
//		assertEquals(workings[4].getWorkingName(), "SWOP Shipment Date");
//		assertEquals(workings[4].getWorkingValue(), "2006-03-23");
//
//		assertEquals(workings[5].getWorkingName(), "SWOP Installation Date");
//		assertEquals(workings[5].getWorkingValue(), "2006-03-26");
//
//		assertEquals(workings[6].getWorkingName(), "SWOP Born On Date");
//		assertEquals(workings[6].getWorkingValue(), "2006-03-24");
//
//		assertEquals(workings[7].getWorkingName(), "SWOP Factory Restart Date");
//		assertEquals(workings[7].getWorkingValue(), "2006-03-27");
//
//		assertEquals(workings[8].getWorkingName(), "SWOP Start Date Type");
//		assertEquals(workings[8].getWorkingValue(), "03");
//
//		assertEquals(workings[9].getWorkingName(), "SWOP Instance");
//		assertEquals(workings[9].getWorkingValue(), "NOT_CONFIGURED");
//
//		assertEquals(workings[10].getWorkingName(), "SWOP Request Status");
//		assertEquals(workings[10].getWorkingValue(), "Error");
//
//		assertEquals(workings[11].getWorkingName(), "SWOP Unit List Returned");
//		assertEquals(workings[11].getWorkingValue(), "N");
//
//		assertEquals(workings[12].getWorkingName(), "SWOP Product Base Warranty");
//		assertEquals(workings[12].getWorkingValue(), "N");
//	}

	/**
	 * Create the request
	 */
	private void createRequest() {
//		_request = new EsRequestComplexType();
//		_request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
//		_request.getEsRequestComplexTypeChoice().setWarrantyRequest(new WarrantyRequest());
//		_request.getEsRequestComplexTypeChoice().getWarrantyRequest().setProductID("22334455");
//		_request.getEsRequestComplexTypeChoice().getWarrantyRequest().setServiceID("667766");
//		Calendar cal = Calendar.getInstance(); 
//		cal.set(2006, 2, 13);		
//		_request.getEsRequestComplexTypeChoice().getWarrantyRequest().setProofPurchaseDate(MappingUtils.mapToCastorDate(cal.getTime()));
	}	
	
	/**
	 * Create the transaction
*/
	private WarrantyTransaction createTransaction(String warningId, String warningMessage) {
		// create warning
		
//		ZWTYERRORTAB swopWarnings = new ZWTYERRORTAB();
//
//		ZWTYERROR swopWarning = new ZWTYERROR();
//		swopWarning.setID(warningId);
//		swopWarning.setMESSAGE(warningMessage);
//		swopWarnings.getItem().add(swopWarning);
//		
//		
//		// creating objects
//		ZWTYPRODINFO prodInfo = new ZWTYPRODINFO();
//		//ArrayList prodList = new ArrayList();
//		ZWARRANTYLOOKUPPARALLELBSUResponse wty = new ZWARRANTYLOOKUPPARALLELBSUResponse();
//		ZWTYOOSINFO oos = new ZWTYOOSINFO();
		WarrantyTransaction transaction = new WarrantyTransaction(null, false, null, null, null,true);


		// setting objects
		// OOS

//		oos.setSHIPMENTDATE("2008-12-12");
//
//		oos.setBORNONDATE("2008-12-13");
//		
//		oos.setPROOFOFPURCHASEDATE("2008-12-12");
//		
//		oos.setINSTALLATIONDATE("2008-12-12");
//		
//		oos.setFACTORYRESTARTDATE("2008-12-12");
//		oos.setPRODUCTALIAS("778877");
//		
//		
//		wty.setZWTYLOOKUP(new ZWTYLOOKUP());
//		wty.getZWTYLOOKUP().setWTYENTITLEMENT(new ZWTYWTYENT());
//		wty.getZWTYLOOKUP().getWTYENTITLEMENT().setOOSINFO(oos);
//		
//		// WARRANTY INFO
//		wty.getZWTYLOOKUP().getWTYENTITLEMENT().setWARRANTYINFO(new ZWTYWTYINFO());
//		wty.getZWTYLOOKUP().getWTYENTITLEMENT().getWARRANTYINFO().setWARRANTYID("232323");
//
//		wty.getZWTYLOOKUP().getWTYENTITLEMENT().getWARRANTYINFO().setWARRANTYSTARTDATE("2012-12-12");
//		wty.getZWTYLOOKUP().getWTYENTITLEMENT().getWARRANTYINFO().setGRACEPERIOD("2");
//		wty.getZWTYLOOKUP().getWTYENTITLEMENT().getWARRANTYINFO().setSOURCEDATEFORWARRANTYSTART("01");
//
//		wty.getZWTYLOOKUP().getWTYENTITLEMENT().setPRODUCTINFO(prodInfo);
//		// PRODUCT INFO
//		prodInfo.setPRODUCTNUM("11113333");
//
//		transaction.setSourceSystemResponse(wty);
		
		return transaction;
	}		 
	
}
