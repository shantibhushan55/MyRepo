package com.hp.es.service.combinedEntitlement.bySn;

/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/combinedEntitlement/bySn/SnReplyCreatorTest.java 1.6 2004-05-08 04:41:55+02 entitlem Exp $
 *
 * Copyright (c) 2003 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * $Log: SnReplyCreatorTest.java,v $
 * Revision 1.6  2004-05-08 04:41:55+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.5  2004-05-05 15:40:41+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.4  2004-01-29 18:06:25+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-08-04 16:50:48+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.2  2003-06-04 19:25:47+02  lbednari
 * Author: lbednari@bbnnaid28.bbn.hp.com ()
 * using new constants for error ids
 *
 * Revision 1.1  2003-06-04 15:12:35+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * Initial revision
 *
 * Revision 1.3  2003-05-27 03:10:12+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * moving trunk rev after introducing new file from branch 5_0C2
 *
 * Revision 1.2  2003-05-20 16:53:33+02  lbednari
 * Author: lbednari@dhcp-15-197-235-62.bbn.hp.com ()
 * - reafctored Requester objects and decision making in ReplyCreator
 *
 * Revision 1.1  2003-05-19 13:01:46+02  JUHANK
 * Author: JUHANK@dhcp-15-197-230-117.bbn.hp.com ()
 * Initial revision
 *
 */

import java.lang.reflect.InvocationTargetException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.service.combinedEntitlement.reply.NullRequesterReply;
import com.hp.es.service.combinedEntitlement.reply.RequesterReply;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.ruc.util.PrivilegedAccessor;
import com.hp.sif.SifException;

public class SnReplyCreatorTest extends TestCase {

    SnReplyCreator _combined = null;
    RequesterReply _rwReply;
    RequesterReply _rcReply;

    /* -------------------------------------------------------------------------
    JUnit stuff
    ------------------------------------------------------------------------- */

    public SnReplyCreatorTest(String name) {
        super(name);
    }

    public static Test suite() {
        return new TestSuite(SnReplyCreatorTest.class);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    protected void setUp() throws Exception {
        super.setUp();
        EsRequestComplexType esreq = new EsRequestComplexType();
        _combined = new SnReplyCreator(esreq);

    }

    /* -------------------------------------------------------------------------
    test methods
    ------------------------------------------------------------------------- */

    /**
     * Testing create: all values null
     */
    public void testCreateAllNull() {
        SifException expectedException = ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR);
        SifException thrownException = null;
        RequesterReply reqReply = new NullRequesterReply();
        _combined.setContractReply(reqReply);
        _combined.setWarrantyReply(reqReply);

        try {
            _combined.create();
        } catch(SifException ee) {
            thrownException = ee;
        }
        if(thrownException != null) {
	        assertEquals(expectedException.getErrorID(), thrownException.getErrorID());
	        assertEquals(expectedException.getErrorText(), thrownException.getErrorText());
        }else {
        	assertFalse(true);
        }
    }


    /**
     * Testing create: 2 Exceptions
     */
    public void testExceptionCreation() {
        SifException exception201 = ErrorFactory.getSifException(ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA, "Xtreme");
        SifException exception100 = ErrorFactory.getSifException(ErrorFactory.id100_SERVICE_UNREACHABLE, "warranty");
        SifException thrownException = null;


        _combined.setContractReply(new RequesterReply(exception201));
        _combined.setWarrantyReply(new RequesterReply(exception100));

        try {
            _combined.create();
        } catch(SifException ee) {
            thrownException = ee;
        }
        assertEquals(exception100, thrownException);
    }

    public void testIsMatch1() {

        fillProduct("12345", "12345");

        Boolean trueFalse = null;

        try {
            try {
                trueFalse = (Boolean) PrivilegedAccessor.invokeMethod(_combined, "isMatch", null);
            } catch (InvocationTargetException ite) {
                fail("isMatch() has thrown an exception");
            }
            assertEquals(trueFalse.booleanValue(), true);
        }
        catch(Exception e) {
            System.err.println("Exception thrown:  "+e);
            e.printStackTrace();
            fail("Exception caught: " + e.toString());
        }
    }


    public void testIsMatch2() {

        fillProduct("12345", "23435");

        Boolean trueFalse = null;

        try {
            try {
                trueFalse = (Boolean) PrivilegedAccessor.invokeMethod(_combined, "isMatch", null);
            } catch (InvocationTargetException ite) {
                fail("isMatch() has thrown an exception");
            }
            assertEquals(trueFalse.booleanValue(), false);
        }
        catch(Exception e) {
            System.err.println("Exception thrown:  "+e);
            e.printStackTrace();
            fail("Exception caught: " + e.toString());
        }
    }

    private void fillProduct(String cProductID, String wProductID) {
        EsReply contractEsReply = new EsReply();
        contractEsReply.setEsReplyChoice(new EsReplyChoice());
        contractEsReply.getEsReplyChoice().setCombinedUnitEntitlement(new CombinedUnitEntitlementComplexType());
        contractEsReply.getEsReplyChoice().getCombinedUnitEntitlement().setOOS(new OOSComplexType());
        contractEsReply.getEsReplyChoice().getCombinedUnitEntitlement().getOOS().setProduct(new ProductComplexType());
        contractEsReply.getEsReplyChoice().getCombinedUnitEntitlement().getOOS().getProduct().setProductID(cProductID);
        _rcReply = new RequesterReply(contractEsReply);

        EsReply warrantyEsReply = new EsReply();
        warrantyEsReply.setEsReplyChoice(new EsReplyChoice());
        warrantyEsReply.getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
        warrantyEsReply.getEsReplyChoice().getWarrantyEntitlement().setOOS(new OOSComplexType());
        warrantyEsReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().setProduct(new ProductComplexType());
        warrantyEsReply.getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct().setProductID(wProductID);
        _rwReply = new RequesterReply(warrantyEsReply);

        _combined.setContractReply(_rcReply);
        _combined.setWarrantyReply(_rwReply);
    }

}