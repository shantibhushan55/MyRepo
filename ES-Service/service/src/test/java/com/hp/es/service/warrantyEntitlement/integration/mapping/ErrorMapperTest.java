/*
 * Created on Mar 15, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import junit.framework.TestCase;

import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.WarrantyRequest;

/**
 * @author juhank
 */
public class ErrorMapperTest extends TestCase {
	
	private EsRequestComplexType _request;
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(ErrorMapperTest.class);
	}

//	public ErrorMapperTest(String arg0) {
//		super(arg0);
//		createRequest();
//	}
//
//	public static Test suite() {
//        // discover test*() methods via reflection:
//        return new TestSuite(ErrorMapperTest.class);
//    }
//	
	/*
	 * Test method for mapping errors
	 */
	public void testErrorCode2000() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2000");
//		swopError.setMESSAGE("Message of error id 2000");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "210");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Product number was not found: 22334455");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2000: Message of error id 2000");
	}
//
	public void testErrorCode2001() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2001");
//		swopError.setMESSAGE("Message of error id 2001");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "210");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Product number was not found: 22334455");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2001: Message of error id 2001");
	}
//	
//	public void testErrorCode2002() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2002");
//		swopError.setMESSAGE("Message of error id 2002");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "201");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Parameter contains invalid data: CountryCode");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2002: Message of error id 2002");
//	}
//	
//	public void testErrorCode2003() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2003");
//		swopError.setMESSAGE("Message of error id 2003");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "201");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Parameter contains invalid data: CountryCode");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2003: Message of error id 2003");
//	}
//	
//	public void testErrorCode2004() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2004");
//		swopError.setMESSAGE("Message of error id 2004");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "200");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Mandatory parameter is missing: Message of error id 2004");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2004: Message of error id 2004");
//	}
//	
//	public void testErrorCode2005() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2005");
//		swopError.setMESSAGE("Message of error id 2005");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "212");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Warranty calculation not possible; could not find a start date. Retry with additional parameters");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2005: Message of error id 2005");
//	}
//
//	public void testErrorCode2006() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2006");
//		swopError.setMESSAGE("Message of error id 2006");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "214");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Product or part not eligible for warranty");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2006: Message of error id 2006");
//	}
//	
//	public void testErrorCode2007() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2007");
//		swopError.setMESSAGE("Message of error id 2007");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "214");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Product or part not eligible for warranty");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2007: Message of error id 2007");
//	}
//	
//	public void testErrorCode2008() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2008");
//		swopError.setMESSAGE("Message of error id 2008");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "300");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "No data found");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2008: Message of error id 2008");
//	}
//	
//	public void testErrorCode2009() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2009");
//		swopError.setMESSAGE("Message of error id 2009");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "213");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "No Warranty Found");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2009: Message of error id 2009");
//	}
//	
//	public void testErrorCode2010() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2010");
//		swopError.setMESSAGE("Message of error id 2010");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "202");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "No unit found with supplied serial number - try to additionally provide the product number");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2010: Message of error id 2010");
//	}
//	
//	public void testErrorCode2013() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2013");
//		swopError.setMESSAGE("Message of error id 2013");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "214");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Product or part not eligible for warranty");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2013: Message of error id 2013");
//	}
//	
//	public void testErrorCode2014() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2014");
//		swopError.setMESSAGE("Message of error id 2014");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "214");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Product or part not eligible for warranty");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2014: Message of error id 2014");
//	}
//	
//	public void testErrorCode2015() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2015");
//		swopError.setMESSAGE("Message of error id 2015");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "214");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Product or part not eligible for warranty");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2015: Message of error id 2015");
//	}
//	
//	public void testErrorCode2016() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2016");
//		swopError.setMESSAGE("Message of error id 2016");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "214");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "Product or part not eligible for warranty");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2016: Message of error id 2016");
//	}
//
//	public void testErrorCode2017() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2017");
//		swopError.setMESSAGE("Message of error id 2017");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "300");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "No data found");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2017: Message of error id 2017");
//	}
//	
//	public void testErrorCode2018() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2018");
//		swopError.setMESSAGE("Message of error id 2018");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "213");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "No Warranty Found");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2018: Message of error id 2018");
//	}
//	
//	public void testErrorCode2019() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2019");
//		swopError.setMESSAGE("Message of error id 2019");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "224");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "All Source Systems are not available: SWOP");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2019: Message of error id 2019");
//	}
//	
//	public void testErrorCode2777() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("2777");
//		swopError.setMESSAGE("Message of error id 2777");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), false);
//		assertEquals(eslist.size(), 1);
//		assertEquals(((SifException)eslist.get(0)).getErrorID(), "224");
//		assertEquals(((SifException)eslist.get(0)).getErrorText(), "All Source Systems are not available: SWOP");
//		assertEquals(((SifException)eslist.get(0)).getDataPayLoad(), "SWOP 2777: Message of error id 2777");
//	}
//	
//	public void testErrorCode1000() {
//		ZWTYERROR swopError = new ZWTYERROR();
//		swopError.setID("1000");
//		swopError.setMESSAGE("Message of error id 1000");
//		ArrayList swoplist = new ArrayList();
//		ArrayList eslist = null;
//		swoplist.add(swopError);
//		ErrorMapper em = ErrorMapper.getInstance(swoplist, _request);
//		try {
//			eslist = em.map();
//		} catch (MappingException e) {
//			fail();
//			return;
//		}
//		assertEquals(eslist.isEmpty(), true);
//		assertEquals(eslist.size(), 0);
//	}		

	/**
	 * Create the request
	 */
	private void createRequest() {
		_request = new EsRequestComplexType();
		_request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
		_request.getEsRequestComplexTypeChoice().setWarrantyRequest(new WarrantyRequest());
		_request.getEsRequestComplexTypeChoice().getWarrantyRequest().setProductID("22334455");
	}	
}
