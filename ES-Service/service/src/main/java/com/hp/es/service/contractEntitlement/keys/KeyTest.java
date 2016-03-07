/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/keys/KeyTest.java 1.7 2004-05-08 04:42:57+02 entitlem Exp $
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
 * $Log: KeyTest.java,v $
 * Revision 1.7  2004-05-08 04:42:57+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.6  2004-05-05 15:41:47+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.5  2004-01-29 18:07:45+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.4  2003-08-04 16:52:04+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.3  2003-05-12 02:00:16+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-04-28 12:43:08+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * remove redModCode from ModifierKey
 *
 * Revision 1.1  2003-04-15 14:00:31+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.keys;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * JUnit test case for all Keys in the current package. The tests ensures that
 * <ul>
 * <li>the equals method works correctly
 * <li>the hash codes are correctly calculated
 * <li>the toString method returns the expected results
 * <li>the parent key is correctly returned
 * </ul>
 */
public class KeyTest extends TestCase {

    public KeyTest(String inName) {
        super(inName);
    }

    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(KeyTest.class);
    }
 
    public static void main(String[] args) {
    //  KeyTest o = new KeyTest("test");
    //  o.testOperationManager();
        junit.textui.TestRunner.run(suite());
    }

    //==========================================================================
    public void testContactKey() {

        ContactKey key1 = new ContactKey("1");
        ContactKey key2 = new ContactKey("1");

        assertTrue("The hash codes for the Keys are not identical",
                   key1.hashCode()==key2.hashCode());

        assertTrue("parentKey for ContactKey must be null",
                   key1.getParent()==null);

        assertTrue("toString() returns wrong result: '" + key1.toString() + "'",
                   "1".equals(key1.toString()));

        assertTrue("equals() method returns false for equal keys",
                   key1.equals(key2));

        key1 = new ContactKey("2");
        assertTrue("equals() method still returns true when paramter has changed",
                   ! key1.equals(key2));


        key2 = new ContactKey(key1);
        assertTrue("new Key(Key) doesn't return an identical key",
                   key2.equals(key1));
        assertTrue("The hash codes for the Keys are not identical after constructor Key(Key)",
                   key1.hashCode()==key2.hashCode());
    }

    //==========================================================================
    public void testDeliverableKey() {

        DeliverableKey key1 = new DeliverableKey("1", "2", "3", "4");
        DeliverableKey key2 = new DeliverableKey("1", "2", "3", "4");

        assertTrue("The hash codes for the Keys are not identical",
                   key1.hashCode()==key2.hashCode());

        ServiceKey parent = new ServiceKey("1", "2");
        assertTrue("parentKey for DeliverableKey is wrong",
                   parent.equals(key1.getParent()));

        assertTrue("toString() returns wrong result: '" + key1.toString() + "'",
                   "1|2|3|4".equals(key1.toString()));


        assertTrue("equals() method returns false for equal keys",
                   key1.equals(key2));

        key1 = new DeliverableKey("x", "2", "3", "4");
        assertTrue("equals() method still returns true when paramter 'sourceObligationID' has changed",
                   ! key1.equals(key2));

        key1 = new DeliverableKey("1", "x", "3", "4");
        assertTrue("equals() method still returns true when paramter 'item' has changed",
                   ! key1.equals(key2));

        key1 = new DeliverableKey("1", "2", "x", "4");
        assertTrue("equals() method still returns true when paramter 'dlvName' has changed",
                   ! key1.equals(key2));

        key1 = new DeliverableKey("1", "2", "3", "x");
        assertTrue("equals() method still returns true when paramter 'redDlvCode' has changed",
                   ! key1.equals(key2));

        key2 = new DeliverableKey(key1);
        assertTrue("new Key(Key) doesn't return an identical key",
                   key2.equals(key1));
        assertTrue("The hash codes for the Keys are not identical after constructor Key(Key)",
                   key1.hashCode()==key2.hashCode());
    }

    //==========================================================================
    public void testDelivModifierKey() {

        DelivModifierKey key1 = new DelivModifierKey("1", "2", "3", "4", "5", "6");
        DelivModifierKey key2 = new DelivModifierKey("1", "2", "3", "4", "5", "6");

        assertTrue("The hash codes for the Keys are not identical",
                   key1.hashCode()==key2.hashCode());

        DeliverableKey parent = new DeliverableKey("1", "2", "3", "4");
        assertTrue("parentKey for DelivModifierKey is wrong",
                   parent.equals(key1.getParent()));

        assertTrue("toString() returns wrong result: '" + key1.toString() + "'",
                   "1|2|3|4|5|6".equals(key1.toString()));

        assertTrue("equals() method returns false for equal keys",
                   key1.equals(key2));

        key1 = new DelivModifierKey("x", "2", "3", "4", "5", "6");
        assertTrue("equals() method still returns true when paramter 'sourceObligationID' has changed",
                   ! key1.equals(key2));

        key1 = new DelivModifierKey("1", "x", "3", "4", "5", "6");
        assertTrue("equals() method still returns true when paramter 'item' has changed",
                   ! key1.equals(key2));


        key1 = new DelivModifierKey("1", "2", "x", "4", "5", "6");
        assertTrue("equals() method still returns true when paramter 'dlvName' has changed",
                   ! key1.equals(key2));

        key1 = new DelivModifierKey("1", "2", "3", "x", "5", "6");
        assertTrue("equals() method still returns true when paramter 'redDlvCode' has changed",
                   ! key1.equals(key2));

        key1 = new DelivModifierKey("1", "2", "3", "4", "x", "6");
        assertTrue("equals() method still returns true when paramter 'modName' has changed",
                   ! key1.equals(key2));

        key1 = new DelivModifierKey("1", "2", "3", "4", "5", "x");
        assertTrue("equals() method still returns true when paramter 'redModCode' has changed",
                   ! key1.equals(key2));


        key2 = new DelivModifierKey(key1);
        assertTrue("new Key(Key) doesn't return an identical key",
                   key2.equals(key1));
        assertTrue("The hash codes for the Keys are not identical after constructor Key(Key)",
                   key1.hashCode()==key2.hashCode());
    }

    //==========================================================================
    public void testLocationKey() {

        LocationKey key1 = new LocationKey("1");
        LocationKey key2 = new LocationKey("1");

        assertTrue("The hash codes for the Keys are not identical",
                   key1.hashCode()==key2.hashCode());

        assertTrue("parentKey for LocationKey must be null",
                   key1.getParent()==null);

        assertTrue("toString() returns wrong result: '" + key1.toString() + "'",
                   "1".equals(key1.toString()));

        assertTrue("equals() method returns false for equal keys",
                   key1.equals(key2));

        key1 = new LocationKey("2");
        assertTrue("equals() method still returns true when paramter 'sourceCustomerID' has changed",
                   ! key1.equals(key2));

        key2 = new LocationKey(key1);
        assertTrue("new Key(Key) doesn't return an identical key",
                   key2.equals(key1));
        assertTrue("The hash codes for the Keys are not identical after constructor Key(Key)",
                   key1.hashCode()==key2.hashCode());
    }

    //==========================================================================
    public void testModifierKey() {

        ModifierKey key1 = new ModifierKey("1", "2", "3");
        ModifierKey key2 = new ModifierKey("1", "2", "3");

        assertTrue("The hash codes for the Keys are not identical",
                   key1.hashCode()==key2.hashCode());

        ServiceKey parent = new ServiceKey("1", "2");
        assertTrue("parentKey for ModifierKey is wrong",
                   parent.equals(key1.getParent()));


        assertTrue("toString() returns wrong result: '" + key1.toString() + "'",
                   "1|2|3".equals(key1.toString()));


        assertTrue("equals() method returns false for equal keys",
                   key1.equals(key2));

        key1 = new ModifierKey("x", "2", "3");
        assertTrue("equals() method still returns true when paramter 'sourceObligationID' has changed",
                   ! key1.equals(key2));

        key1 = new ModifierKey("1", "x", "3");
        assertTrue("equals() method still returns true when paramter 'item' has changed",
                   ! key1.equals(key2));

        key1 = new ModifierKey("1", "2", "x");
        assertTrue("equals() method still returns true when paramter 'name' has changed",
                   ! key1.equals(key2));


        key2 = new ModifierKey(key1);
        assertTrue("new Key(Key) doesn't return an identical key",
                   key2.equals(key1));
        assertTrue("The hash codes for the Keys are not identical after constructor Key(Key)",
                   key1.hashCode()==key2.hashCode());
    }

    //==========================================================================
    public void testObligationHeaderKey() {

        ObligationHeaderKey key1 = new ObligationHeaderKey("1");
        ObligationHeaderKey key2 = new ObligationHeaderKey("1");

        assertTrue("The hash codes for the Keys are not identical",
                   key1.hashCode()==key2.hashCode());

        assertTrue("parentKey for ObligationHeaderKey must be null",
                   key1.getParent()==null);

        assertTrue("toString() returns wrong result: '" + key1.toString() + "'",
                   "1".equals(key1.toString()));

        assertTrue("equals() method returns false for equal keys",
                   key1.equals(key2));

        key1 = new ObligationHeaderKey("2");
        assertTrue("equals() method still returns true when paramter 'sourceObligationID' has changed",
                   ! key1.equals(key2));

        key2 = new ObligationHeaderKey(key1);
        assertTrue("new Key(Key) doesn't return an identical key",
                   key2.equals(key1));
        assertTrue("The hash codes for the Keys are not identical after constructor Key(Key)",
                   key1.hashCode()==key2.hashCode());
    }


    //==========================================================================
    public void testOOSKey() {

        OOSKey key1 = new OOSKey("1");
        OOSKey key2 = new OOSKey("1");

        assertTrue("The hash codes for the Keys are not identical",
                   key1.hashCode()==key2.hashCode());

        assertTrue("parentKey for OOSKey must be null",
                   key1.getParent()==null);

        assertTrue("toString() returns wrong result: '" + key1.toString() + "'",
                   "1".equals(key1.toString()));


        assertTrue("equals() method returns false for equal keys",
                   key1.equals(key2));

        key1 = new OOSKey("x");
        assertTrue("equals() method still returns true when paramter 'oosKey' has changed",
                   ! key1.equals(key2));

        key2 = new OOSKey(key1);
        assertTrue("new Key(Key) doesn't return an identical key",
                   key2.equals(key1));
        assertTrue("The hash codes for the Keys are not identical after constructor Key(Key)",
                   key1.hashCode()==key2.hashCode());
    }


    //==========================================================================
    public void testServiceKey() {

        ServiceKey key1 = new ServiceKey("1", "2");
        ServiceKey key2 = new ServiceKey("1", "2");

        assertTrue("The hash codes for the Keys are not identical",
                   key1.hashCode()==key2.hashCode());

        ObligationHeaderKey parent = new ObligationHeaderKey("1");
        assertTrue("parentKey for ServiceKey is wrong",
                   parent.equals(key1.getParent()));


        assertTrue("toString() returns wrong result: '" + key1.toString() + "'",
                   "1|2".equals(key1.toString()));

        assertTrue("equals() method returns false for equal keys",
                   key1.equals(key2));

        key1 = new ServiceKey("x", "2");
        assertTrue("equals() method still returns true when paramter 'sourceObligationID' has changed",
                   ! key1.equals(key2));

        key1 = new ServiceKey("1", "x");
        assertTrue("equals() method still returns true when paramter 'serviceKey' has changed",
                   ! key1.equals(key2));

        key2 = new ServiceKey(key1);
        assertTrue("new Key(Key) doesn't return an identical key",
                   key2.equals(key1));
        assertTrue("The hash codes for the Keys are not identical after constructor Key(Key)",
                   key1.hashCode()==key2.hashCode());
    }

    //==========================================================================
    public void testAppliesToKey() {

        AppliesToKey key1 = new AppliesToKey("1", "2", "3");
        AppliesToKey key2 = new AppliesToKey("1", "2", "3");

        assertTrue("The hash codes for the Keys are not identical",
                   key1.hashCode()==key2.hashCode());

        ServiceKey parent = new ServiceKey("1", "2");
        assertTrue("parentKey for ServiceKey is wrong",
                   parent.equals(key1.getParent()));

        assertTrue("toString() returns wrong result: '" + key1.toString() + "'",
                   "1|2|3".equals(key1.toString()));


        assertTrue("equals() method returns false for equal keys",
                   key1.equals(key2));

        key1 = new AppliesToKey("x", "2", "3");
        assertTrue("equals() method still returns true when paramter 'sourceObligationID' has changed",
                   ! key1.equals(key2));

        key1 = new AppliesToKey("1", "x", "3");
        assertTrue("equals() method still returns true when paramter 'serviceKey' has changed",
                   ! key1.equals(key2));

        key1 = new AppliesToKey("1", "2", "x");
        assertTrue("equals() method still returns true when paramter 'serviceKey' has changed",
                   ! key1.equals(key2));

        key2 = new AppliesToKey(key1);
        assertTrue("new Key(Key) doesn't return an identical key",
                   key2.equals(key1));
        assertTrue("The hash codes for the Keys are not identical after constructor Key(Key)",
                   key1.hashCode()==key2.hashCode());
    }
}
