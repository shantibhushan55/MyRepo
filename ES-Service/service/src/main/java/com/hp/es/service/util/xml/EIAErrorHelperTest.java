/**
 *  com.hp.es.service.util
 *  EIAErrorHelperTest.java
 */
package com.hp.es.service.util.xml;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.service.util.ErrorFactory;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public class EIAErrorHelperTest extends TestCase {

	/*
     * @return the test suite
     */
    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(EIAErrorHelperTest.class);
    }

	/**
	 * Constructor
	 */
	public EIAErrorHelperTest() {
		super();
	}

	
    /**
	 * Constructor
	 * @param arg0
	 */
	public EIAErrorHelperTest(String arg0) {
		super(arg0);
	}
	/*
	 * test testToEIAWrappedErrorReplyString
	 */
	public void testToEIAWrappedErrorReplyStringWithValidSifException() {
		SifException ee = ErrorFactory.getSifException(
                ErrorFactory.id101_SERVICE_IS_DOWN);
		String xml = EIAErrorHelper.toEIAWrappedErrorReplyString(ee);
		
		assertNotNull(xml);
		
	}
    
	
	/*
	 * test testToEIAWrappedErrorReplyStringWithNullSifException
	 */
	public void testToEIAWrappedErrorReplyStringWithNullSifException() {
		SifException ee = null;
		String xml = EIAErrorHelper.toEIAWrappedErrorReplyString(ee);
		
		assertNotNull(xml);
		
		xml = EIAErrorHelper.toEIAWrappedErrorReplyString(ee,null);
		
		assertNotNull(xml);		
		
	}	
    

}
