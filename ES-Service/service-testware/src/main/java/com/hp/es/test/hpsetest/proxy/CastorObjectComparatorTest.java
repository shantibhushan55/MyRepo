/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/test/hpsetest/proxy/CastorObjectComparatorTest.java 1.4 2004-05-08 04:41:18+02 entitlem Exp $
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
 * $Log: CastorObjectComparatorTest.java,v $
 * Revision 1.4  2004-05-08 04:41:18+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.3  2004-05-05 15:39:58+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.2  2004-01-29 18:05:36+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.1  2003-09-02 11:08:34+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.test.hpsetest.proxy;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.Warnings;

/**
 *
 */
public class CastorObjectComparatorTest extends TestCase {

    public CastorObjectComparatorTest(String inName) {
        super(inName);
    }

    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(CastorObjectComparatorTest.class);
    }

    public static void main (String s[]) {
        CastorObjectComparatorTest t = new CastorObjectComparatorTest("");
        t.test();
    }

    /**
     * Execute comparisions.
     */
    public void test() {
        EsReply r1 = new EsReply();
        EsReply r2 = new EsReply();

        assertTrue("comparing objects failed (1)", compare1(null, r1, r2));
        // only one has EsHeader
        r1.setEsHeader(new EsHeader());
        assertFalse("comparing objects failed (2)", compare1(null, r1, r2));
        assertTrue ("comparing objects failed (3)", compare1(".*/EsHeader$", r1, r2));
        // both have EsHeader
        r2.setEsHeader(new EsHeader());
        assertTrue ("comparing objects failed (4)", compare1(null, r1, r2));

        // only one has transactionID
        r1.getEsHeader().setTransactionID("a");
        assertFalse("comparing objects failed (5)", compare1(null, r1, r2));
        assertTrue ("comparing objects failed (6)", compare1(".*TransactionID", r1, r2));

        // both have transactionID
        r2.getEsHeader().setTransactionID("b");
        assertFalse("comparing objects failed (7)", compare1(null, r1, r2));
        assertTrue ("comparing objects failed (8)", compare1(".*TransactionID", r1, r2));
        r2.getEsHeader().setTransactionID("a");
        assertTrue ("comparing objects failed (9)", compare1(null, r1, r2));


        EIAError e1 = new EIAError();
        e1.setDataPayLoad("payload1");
        EIAError e2 = new EIAError();
        e2.setDataPayLoad("payload2");
        r1.getEsHeader().setWarnings(new Warnings());
        r1.getEsHeader().getWarnings().addEIAError(e1);
        r1.getEsHeader().getWarnings().addEIAError(e2);
        assertFalse("comparing objects failed (10)", compare1(null, r1, r2));
        assertTrue ("comparing objects failed (11)", compare1("/root/EsHeader/Warnings.*", r1, r2));

        e1 = new EIAError();
        e1.setDataPayLoad("payload1");
        r2.getEsHeader().setWarnings(new Warnings());
        r2.getEsHeader().getWarnings().addEIAError(e1);
        assertFalse("comparing objects failed (12)", compare1(null, r1, r2));
        assertTrue ("comparing objects failed (13)", compare1("/root/Es.*", r1, r2));

        e2 = new EIAError();
        e2.setDataPayLoad("payload1");
        r2.getEsHeader().getWarnings().addEIAError(e2);
        assertFalse("comparing objects failed (14)", compare1(null, r1, r2));

        e2.setDataPayLoad("payload2");
        assertTrue ("comparing objects failed (15)", compare1(null, r1, r2));

    }

    /**
     *
     * @param ignore
     * @param o1
     * @param o2
     * @return
     */
    private boolean compare1(String ignore, Object o1, Object o2) {
        ArrayList list = new ArrayList();
        if (ignore!=null) {
            list.add(ignore);
        }
        return compare2(list, o1, o2);
    }

    /**
     *
     * @param ignoreList
     * @param o1
     * @param o2
     * @return
     */
    private boolean compare2(ArrayList ignoreList, Object o1, Object o2) {
        String ignore[] = null;
        if (ignoreList!=null) {
            ignore = (String[])ignoreList.toArray(new String[0]);
        }

        CastorObjectComparator comp = new CastorObjectComparator(ignore);
        try {
            return comp.compare(o1, o2, "root");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

