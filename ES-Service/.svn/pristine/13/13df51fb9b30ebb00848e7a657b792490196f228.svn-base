/**
 * Project: Entitlement Service
 *
 * 
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
 */
 
package com.hp.es.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.xml.service.EIAError;


public class WarningsBuilderTest extends TestCase {
    
    public void testNull() throws Exception {
        List<?> result = WarningsBuilder.orderAndFilterWarnings(null);
        assertNull(result);
    }

    public void testEmpty() throws Exception {
        List<?> result = WarningsBuilder.orderAndFilterWarnings(new ArrayList<EIAError>());
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    public void testSort_sortedList() throws Exception {
        List<?> result = WarningsBuilder.orderAndFilterWarnings(sortedList);
        assertForSorted(result);
    }

    public void testSort_reverslySortedList() throws Exception {
        List<?> result = WarningsBuilder.orderAndFilterWarnings(reverslySortedList);
        assertForSorted(result);
    }

    public void testSort_unsortedList() throws Exception {
        List<?> result = WarningsBuilder.orderAndFilterWarnings(unsortedList);
        assertForSorted(result);
    }

    public void testSort_containsDoublesList() throws Exception {
        List<?> result = WarningsBuilder.orderAndFilterWarnings(containsDoublesList);
        assertForSorted(result);
    }

    public static Test suite() {
        return new TestSuite(WarningsBuilderTest.class);
    }
    
	protected final void assertForSorted(List<?> result) {
        assertNotNull(result);
        assertEquals(6, result.size()); 
        ArrayList<?> wrapped = new ArrayList<Object>(result);
        assertTrue(wrapped.get(0) == sortedList.get(0));       
        assertTrue(wrapped.get(1) == sortedList.get(1));       
        assertTrue(wrapped.get(2) == sortedList.get(2));       
        assertTrue(wrapped.get(3) == sortedList.get(3));       
        assertTrue(wrapped.get(4) == sortedList.get(4));       
        assertTrue(wrapped.get(5) == sortedList.get(5));       
    }
    
    private EIAError error1 = new EIAError();
    private EIAError error2 = new EIAError();
    private EIAError error3 = new EIAError();
    private EIAError error4 = new EIAError();
    private EIAError error5 = new EIAError();
    private EIAError error6 = new EIAError();
    
    private ArrayList<EIAError> sortedList = new ArrayList<EIAError>(6);
    private List<EIAError> reverslySortedList = new ArrayList<EIAError>(6);
    private List<EIAError> unsortedList = new ArrayList<EIAError>(6);
    private List<EIAError> containsDoublesList = new ArrayList<EIAError>(6);

	protected void setUp() throws Exception {
        super.setUp();

        error1.setErrorID("0");
        error1.setErrorText("T0");

        error2.setErrorID("1");
        error2.setErrorText("T0");

        error3.setErrorID("0");
        error3.setErrorText("T1");

        error4.setErrorID(null);
        error4.setErrorText("T0");

        error5.setErrorID("0");
        error5.setErrorText(null);
        
        error6.setErrorID(null);
        error6.setErrorText(null);
        
        sortedList.add(error1);
        sortedList.add(error3);
        sortedList.add(error5);
        sortedList.add(error2);
        sortedList.add(error4);
        sortedList.add(error6);

        reverslySortedList.add(error4);
        reverslySortedList.add(error6);
        reverslySortedList.add(error2);
        reverslySortedList.add(error5);
        reverslySortedList.add(error3);
        reverslySortedList.add(error1);
        
        unsortedList.add(error6);
        unsortedList.add(error2);
        unsortedList.add(error3);
        unsortedList.add(error4);
        unsortedList.add(error5);
        unsortedList.add(error1);
        
        containsDoublesList = new ArrayList<EIAError>(unsortedList);
        containsDoublesList.add(error1);
        containsDoublesList.add(error2);
        containsDoublesList.add(error3);
        containsDoublesList.add(error4);
        containsDoublesList.add(error5);
        containsDoublesList.add(error6);
        
    }

}
