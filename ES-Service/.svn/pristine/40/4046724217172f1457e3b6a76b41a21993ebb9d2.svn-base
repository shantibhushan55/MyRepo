/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/EsCheckDateRangeTest.java 1.5 2004-05-08 04:42:42+02 entitlem Exp $
 *
 * Copyright (c) 2002 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 * 
 * $Log: EsCheckDateRangeTest.java,v $
 * Revision 1.5  2004-05-08 04:42:42+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.4  2004-05-05 15:41:32+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.3  2004-01-29 18:07:29+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.2  2003-08-04 16:51:49+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.1  2003-06-24 14:08:08+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement;

import java.util.Calendar;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.sif.SifException;

/**
 * EsCheckDateRangeTest
 */
public class EsCheckDateRangeTest extends TestCase {

    public EsCheckDateRangeTest(String inName) {
        super(inName);
    }
    
    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(EsCheckDateRangeTest.class);
    }
    
    public void testRange() {
        assertTrue ("check with 'current day' failed",      testRange(0));
        assertTrue ("check with 'current day + 1' failed",  testRange(1));
        assertFalse("check with 'current day + 2' failed",  testRange(2));
        assertTrue ("check with 'current day - 90' failed", testRange(-90));
        assertFalse("check with 'current day - 91' failed", testRange(-91));
    }
    
    private boolean testRange(int offset) {
        try {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, offset);
            
            EsCheckDateRange.verifyDate(
                                new org.exolab.castor.types.Date(c.getTime())); 
        }
        catch (SifException e) {
            return false;
        }
        return true;
    }
     
    public static void main(String[] args) {
        EsCheckDateRangeTest t = new EsCheckDateRangeTest("test");
        t.testRange();
    }
}
