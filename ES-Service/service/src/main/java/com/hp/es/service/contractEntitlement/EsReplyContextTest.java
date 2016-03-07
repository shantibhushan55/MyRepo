/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/EsReplyContextTest.java 1.11 2004-05-08 04:42:40+02 entitlem Exp $
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
 * $Log: EsReplyContextTest.java,v $
 * Revision 1.11  2004-05-08 04:42:40+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.10  2004-05-05 15:41:29+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.9  2004-01-29 18:07:27+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.8  2003-08-04 16:51:46+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.7  2003-07-18 11:52:20+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * reformatting
 *
 * Revision 1.6  2003-06-25 10:48:53+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * add check for active-obligations flag
 *
 * Revision 1.5  2003-05-27 10:16:19+02  juhank
 * Author: juhank@dhcp-15-197-230-117.bbn.hp.com ()
 * merged changes from 5_0C2 branch
 *
 * Revision 1.4  2003-05-12 02:00:00+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.3  2003-04-29 16:35:14+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * add test for "last CDO publish date" and unique deliverables/offers
 *
 * Revision 1.2  2003-04-28 12:42:11+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * remove redModCode from ModifierKey; add testUniqueOffers()
 *
 * Revision 1.1  2003-04-16 16:55:49+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 * Revision 1.1  2003-03-26 15:34:25+01  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.service.contractEntitlement.db.OutputDetails;
import com.hp.es.service.contractEntitlement.keys.AppliesToKey;
import com.hp.es.service.contractEntitlement.keys.ContactKey;
import com.hp.es.service.contractEntitlement.keys.DelivModifierKey;
import com.hp.es.service.contractEntitlement.keys.DeliverableKey;
import com.hp.es.service.contractEntitlement.keys.LocationKey;
import com.hp.es.service.contractEntitlement.keys.ModifierKey;
import com.hp.es.service.contractEntitlement.keys.OOSKey;
import com.hp.es.service.contractEntitlement.keys.ObligationHeaderKey;
import com.hp.es.service.contractEntitlement.keys.ServiceKey;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.ContactComplexType;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.Deliverable;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.ModifierComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.ServiceItem;
import com.hp.es.xml.service.UniqueDeliverable;
import com.hp.es.xml.service.UniqueOffer;

/**
 * JUnit test case for EsReplyContext
 *
 * Todo:
 *    testCreateOosLocationRefs
 *    testCreateOosContactRefs
 *    test that the contract with the latest getCdoPublishDate is used
 */
public class EsReplyContextTest extends TestCase {

    public EsReplyContextTest(String inName) {
        super(inName);
    }

    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(EsReplyContextTest.class);
    }

    public static void main(String[] args) {
      EsReplyContextTest t = new EsReplyContextTest("test");
      t.testThatNewestContractIsUsed();
        //junit.textui.TestRunner.run(suite());
    }

    //==========================================================================
    public void testMergeDelivModifierToDeliverable() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        c.mergeDelivModifierToDeliverable();

        // insert objects and verify that they are merged correctly
        Deliverable t1 = new Deliverable();
        Deliverable t2 = new Deliverable();
        Deliverable t3 = new Deliverable();
        c.addDeliverable(new DeliverableKey("x", "y", "z", "0"), t1);
        c.addDeliverable(new DeliverableKey("1", "1", "1", "1"), t2);
        c.addDeliverable(new DeliverableKey("2", "2", "2", "2"), t3);

        ModifierComplexType s1 = new ModifierComplexType();
        ModifierComplexType s2 = new ModifierComplexType();
        ModifierComplexType s3 = new ModifierComplexType();
        c.addDelivModifier(new DelivModifierKey("1", "1", "1", "1", "1.5", "1.6"), s1);
        c.addDelivModifier(new DelivModifierKey("2", "2", "2", "2", "2.5", "2.6"), s2);
        c.addDelivModifier(new DelivModifierKey("2", "2", "2", "2", "3.5", "3.6"), s3);

        c.mergeDelivModifierToDeliverable();
        verifyCounts("Deliverable.getDelivModifierCount()",
                   t1.getDelivModifierCount(), t2.getDelivModifierCount(), t3.getDelivModifierCount());
        verifyContainment(t2.enumerateDelivModifier(), s1, null);
        verifyContainment(t3.enumerateDelivModifier(), s2, s3);
    }

    //==========================================================================
    public void testMergeAppliesToToOffer() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        c.mergeAppliesToToOffer();

        // insert objects and verify that they are merged correctly
        OfferComplexType t1 = new OfferComplexType();
        OfferComplexType t2 = new OfferComplexType();
        OfferComplexType t3 = new OfferComplexType();
        c.addOffer(new ServiceKey("x", "y"), t1);
        c.addOffer(new ServiceKey("1", "1"), t2);
        c.addOffer(new ServiceKey("2", "2"), t3);

        AppliesTo s1 = new AppliesTo();
        AppliesTo s2 = new AppliesTo();
        AppliesTo s3 = new AppliesTo();
        c.addAppliesTo(new AppliesToKey("1", "1", "1.3"), s1);
        c.addAppliesTo(new AppliesToKey("2", "2", "2.3"), s2);
        c.addAppliesTo(new AppliesToKey("2", "2", "3.3"), s3);

        c.mergeAppliesToToOffer();
        verifyCounts("OfferComplexType.getAppliesToCount()",
                   t1.getAppliesToCount(), t2.getAppliesToCount(), t3.getAppliesToCount());
        verifyContainment(t2.enumerateAppliesTo(), s1, null);
        verifyContainment(t3.enumerateAppliesTo(), s2, s3);
    }

    //==========================================================================
    public void testMergeDeliverableToOffer() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        c.mergeDeliverableToOffer();

        // insert objects and verify that they are merged correctly
        OfferComplexType t1 = new OfferComplexType();
        OfferComplexType t2 = new OfferComplexType();
        OfferComplexType t3 = new OfferComplexType();
        c.addOffer(new ServiceKey("x", "y"), t1);
        c.addOffer(new ServiceKey("1", "1"), t2);
        c.addOffer(new ServiceKey("2", "2"), t3);

        Deliverable s1 = new Deliverable();
        Deliverable s2 = new Deliverable();
        Deliverable s3 = new Deliverable();
        c.addDeliverable(new DeliverableKey("1", "1", "1.3", "1.4"), s1);
        c.addDeliverable(new DeliverableKey("2", "2", "2.3", "2.4"), s2);
        c.addDeliverable(new DeliverableKey("2", "2", "3.3", "3.4"), s3);

        c.mergeDeliverableToOffer();
        verifyCounts("OfferComplexType.getDeliverableCount()",
                   t1.getDeliverableCount(), t2.getDeliverableCount(), t3.getDeliverableCount());
        verifyContainment(t2.enumerateDeliverable(), s1, null);
        verifyContainment(t3.enumerateDeliverable(), s2, s3);
    }

    //==========================================================================
    public void testMergeModifierToOffer() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        c.mergeModifierToOffer();

        // insert objects and verify that they are merged correctly
        OfferComplexType t1 = new OfferComplexType();
        OfferComplexType t2 = new OfferComplexType();
        OfferComplexType t3 = new OfferComplexType();
        c.addOffer(new ServiceKey("x", "y"), t1);
        c.addOffer(new ServiceKey("1", "1"), t2);
        c.addOffer(new ServiceKey("2", "2"), t3);

        ModifierComplexType s1 = new ModifierComplexType();
        ModifierComplexType s2 = new ModifierComplexType();
        ModifierComplexType s3 = new ModifierComplexType();
        c.addModifier(new ModifierKey("1", "1", "1.3"), s1);
        c.addModifier(new ModifierKey("2", "2", "2.3"), s2);
        c.addModifier(new ModifierKey("2", "2", "3.3"), s3);

        c.mergeModifierToOffer();
        verifyCounts("OfferComplexType.getModifierCount()",
                   t1.getModifierCount(), t2.getModifierCount(), t3.getModifierCount());
        verifyContainment(t2.enumerateModifier(), s1, null);
        verifyContainment(t3.enumerateModifier(), s2, s3);
    }

    //==========================================================================
    public void testMergeOfferToContract() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        c.mergeOfferToContract();

        // insert objects and verify that they are merged correctly
        ContractComplexType t1 = new ContractComplexType();
        t1.setSvcAgreementID("1");
        t1.setPortfolioFlag("G");
        ContractComplexType t2 = new ContractComplexType();
        t2.setSvcAgreementID("2");
        t2.setPortfolioFlag("G");
        ContractComplexType t3 = new ContractComplexType();
        t3.setSvcAgreementID("3");
        t3.setPortfolioFlag("G");
        c.addContract(new ObligationHeaderKey("x"), t1);
        c.addContract(new ObligationHeaderKey("1"), t2);
        c.addContract(new ObligationHeaderKey("2"), t3);

        OfferComplexType s1 = new OfferComplexType();
        OfferComplexType s2 = new OfferComplexType();
        OfferComplexType s3 = new OfferComplexType();
        c.addOffer(new ServiceKey("1", "1.2"), s1);
        c.addOffer(new ServiceKey("2", "2.2"), s2);
        c.addOffer(new ServiceKey("2", "3.2"), s3);

        c.mergeOfferToContract();
        verifyCounts("ContractComplexType.getOfferCount()",
                   t1.getOfferCount(), t2.getOfferCount(), t3.getOfferCount());
        verifyContainment(t2.enumerateOffer(), s1, null);
        verifyContainment(t3.enumerateOffer(), s2, s3);
    }

    //==========================================================================
    public void testMergeObligationHeaderToContract() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        c.mergeObligationHeaderToContract();

        // insert objects and verify that they are merged correctly
        ContractComplexType t1 = new ContractComplexType();
        t1.setSvcAgreementID("1");
        t1.setPortfolioFlag("G");
        ContractComplexType t2 = new ContractComplexType();
        t2.setSvcAgreementID("2");
        t2.setPortfolioFlag("G");
        ContractComplexType t3 = new ContractComplexType();
        t3.setSvcAgreementID("3");
        t3.setPortfolioFlag("G");
        c.addContract(new ObligationHeaderKey("x"), t1);
        c.addContract(new ObligationHeaderKey("1"), t2);
        c.addContract(new ObligationHeaderKey("2"), t3);
        c.addContract(new ObligationHeaderKey("3"), t3); // note: again t3 !!!

        ObligationHeader s1 = new ObligationHeader();
        ObligationHeader s2 = new ObligationHeader();
        ObligationHeader s3 = new ObligationHeader();
        c.addObligationHeader(new ObligationHeaderKey("1"), s1); // linked to t2
        c.addObligationHeader(new ObligationHeaderKey("2"), s2); // linked to t3
        c.addObligationHeader(new ObligationHeaderKey("3"), s3); // linked to t3

        c.mergeObligationHeaderToContract();
        verifyCounts("ContractComplexType.getOfferCount()",
                   t1.getObligationHeaderCount(), t2.getObligationHeaderCount(), t3.getObligationHeaderCount());
        verifyContainment(t2.enumerateObligationHeader(), s1, null);
        verifyContainment(t3.enumerateObligationHeader(), s2, s3);
    }

    //==========================================================================
    public void testMergeServiceItemToObligationHeader() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        c.mergeServiceItemToObligationHeader();

        // insert objects and verify that they are merged correctly
        ObligationHeader t1 = new ObligationHeader();
        ObligationHeader t2 = new ObligationHeader();
        ObligationHeader t3 = new ObligationHeader();
        c.addObligationHeader(new ObligationHeaderKey("x"), t1);
        c.addObligationHeader(new ObligationHeaderKey("1"), t2);
        c.addObligationHeader(new ObligationHeaderKey("2"), t3);

        ServiceItem s1 = new ServiceItem();
        ServiceItem s2 = new ServiceItem();
        ServiceItem s3 = new ServiceItem();
        c.addServiceItem(new ServiceKey("1", "1.2"), s1);
        c.addServiceItem(new ServiceKey("2", "2.2"), s2);
        c.addServiceItem(new ServiceKey("2", "3.2"), s3);

        c.mergeServiceItemToObligationHeader();
        verifyCounts("ObligationHeader.getServiceItemCount()",
                   t1.getServiceItemCount(), t2.getServiceItemCount(), t3.getServiceItemCount());
        verifyContainment(t2.enumerateServiceItem(), s1, null);
        verifyContainment(t3.enumerateServiceItem(), s2, s3);
    }

    //==========================================================================
    public void testCreateAppliesToOOSRefs() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        c.createAppliesToOOSRefs();

        AppliesTo t1 = new AppliesTo();
        AppliesTo t2 = new AppliesTo();
        AppliesTo t3 = new AppliesTo();
        c.addAppliesTo(new AppliesToKey("1.1", "1.2", "x"), t1);
        c.addAppliesTo(new AppliesToKey("2.1", "2.2", "1"), t2);
        c.addAppliesTo(new AppliesToKey("3.1", "3.2", "2"), t3);

        OOSComplexType s1 = new OOSComplexType();
        OOSComplexType s2 = new OOSComplexType();
        OOSComplexType s3 = new OOSComplexType();
        c.addOOS(new OOSKey("y"), s1);
        c.addOOS(new OOSKey("1"), s2);
        c.addOOS(new OOSKey("2"), s3);

        c.createAppliesToOOSRefs();

        verifyIds("OOSComplexType.getId()", s1.getId(), s2.getId(), s3.getId());
        assertTrue("t1.getOOSRef() should be null", t1.getOOSRef()==null);
        assertTrue("t2.getOOSRef() should be s2",   t2.getOOSRef()==s2);
        assertTrue("t3.getOOSRef() should be s3",   t3.getOOSRef()==s3);
    }

    //==========================================================================
    public void testCreateServiceItemOfferRefs() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        c.createServiceItemOfferRefs();

        ServiceItem t1 = new ServiceItem();
        ServiceItem t2 = new ServiceItem();
        ServiceItem t3 = new ServiceItem();
        c.addServiceItem(new ServiceKey("x", "y"), t1);
        c.addServiceItem(new ServiceKey("2", "2"), t2);
        c.addServiceItem(new ServiceKey("3", "3"), t3);

        OfferComplexType s1 = new OfferComplexType();
        OfferComplexType s2 = new OfferComplexType();
        OfferComplexType s3 = new OfferComplexType();
        c.addOffer(new ServiceKey("1", "1"), s1);
        c.addOffer(new ServiceKey("2", "2"), s2);
        c.addOffer(new ServiceKey("3", "3"), s3);

        c.createServiceItemOfferRefs();

        verifyIds("OfferComplexType.getId()", s1.getId(), s2.getId(), s3.getId());
        assertTrue("getOfferRef() for t1 should be null", t1.getOfferRef()==null);
        assertTrue("getOfferRef() for t2 should be s2", t2.getOfferRef()==s2);
        assertTrue("getOfferRef() for t3 should be s3", t3.getOfferRef()==s3);
    }

    //==========================================================================
    public void testContactRefs() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        assertTrue("c.getContracts() should return an empty collection",
                   c.getContracts().isEmpty());
        // contracts with different contacts
        ContractComplexType t1 = new ContractComplexType();
        t1.setSvcAgreementID("1");
        t1.setPortfolioFlag("G");
        t1.setHWShipToPersonID("PersonID1");
        ContractComplexType t2 = new ContractComplexType();
        t2.setSvcAgreementID("2");
        t2.setPortfolioFlag("G");
        t2.setSWShipToPersonID("PersonID2");
        ContractComplexType t3 = new ContractComplexType();
        t3.setSvcAgreementID("3");
        t3.setPortfolioFlag("G");
        t3.setSystemMgrPersonID("PersonID3");
        c.addContract(new ObligationHeaderKey("t1"), t1);
        c.addContract(new ObligationHeaderKey("t2"), t2);
        c.addContract(new ObligationHeaderKey("t3"), t3);

        // OOOSes with different contacts
        OOSComplexType t4 = new OOSComplexType();
        t4.setOOSKey("1");
        t4.setHWShipToPersonID("PersonID4");
        OOSComplexType t5 = new OOSComplexType();
        t5.setOOSKey("2");
        t5.setSWShipToPersonID("PersonID5");
        OOSComplexType t6 = new OOSComplexType();
        t6.setOOSKey("3");
        t6.setSystemMgrPersonID("PersonID6");
        c.addOOS(new OOSKey("t4"), t4);
        c.addOOS(new OOSKey("t5"), t5);
        c.addOOS(new OOSKey("t6"), t6);

        // all contacts
        ContactComplexType s1 = new ContactComplexType();
        s1.setSourcePersonID("PersonID1");
        ContactComplexType s2 = new ContactComplexType();
        s1.setSourcePersonID("PersonID2");
        ContactComplexType s3 = new ContactComplexType();
        s1.setSourcePersonID("PersonID3");
        ContactComplexType s4 = new ContactComplexType();
        s1.setSourcePersonID("PersonID4");
        ContactComplexType s5 = new ContactComplexType();
        s1.setSourcePersonID("PersonID5");
        ContactComplexType s6 = new ContactComplexType();
        s1.setSourcePersonID("PersonID6");
        ContactComplexType s7 = new ContactComplexType();
        s1.setSourcePersonID("unknown");
        c.addContact(new ContactKey("PersonID1"), s1);
        c.addContact(new ContactKey("PersonID2"), s2);
        c.addContact(new ContactKey("PersonID3"), s3);
        c.addContact(new ContactKey("PersonID4"), s4);
        c.addContact(new ContactKey("PersonID5"), s5);
        c.addContact(new ContactKey("PersonID6"), s6);
        c.addContact(new ContactKey("unknown"), s7);

        // don't remove unused contacts
        c.createContactRefs(false, true, true);
        Collection result = c.getContacts();
        assertTrue("contact collection should have 7 elements", result.size()==7);
        assertTrue("PersonID1 is not part of the result", result.contains(s1));
        assertTrue("PersonID2 is not part of the result", result.contains(s2));
        assertTrue("PersonID3 is not part of the result", result.contains(s3));
        assertTrue("PersonID4 is not part of the result", result.contains(s4));
        assertTrue("PersonID5 is not part of the result", result.contains(s5));
        assertTrue("PersonID6 is not part of the result", result.contains(s6));
        assertTrue("unknown is not part of the result", result.contains(s7));

        // remove duplicates unused contacts
        c.createContactRefs(true, true, true);
        result = c.getContacts();
        assertTrue("contact collection should have 6 elements", result.size()==6);
        assertTrue("PersonID1 is not part of the result", result.contains(s1));
        assertTrue("PersonID2 is not part of the result", result.contains(s2));
        assertTrue("PersonID3 is not part of the result", result.contains(s3));
        assertTrue("PersonID4 is not part of the result", result.contains(s4));
        assertTrue("PersonID5 is not part of the result", result.contains(s5));
        assertTrue("PersonID6 is not part of the result", result.contains(s6));

        // check if the IDs are generated correctly
        assertTrue("s1.getId() should not be null", s1.getId()!=null);
        assertTrue("s2.getId() should not be null", s2.getId()!=null);
        assertTrue("s3.getId() should not be null", s3.getId()!=null);
        assertTrue("s4.getId() should not be null", s4.getId()!=null);
        assertTrue("s5.getId() should not be null", s5.getId()!=null);
        assertTrue("s6.getId() should not be null", s6.getId()!=null);
        assertTrue("s7.getId() should not be null", s7.getId()!=null);
        HashSet set = new HashSet();
        set.add(s1.getId());
        set.add(s2.getId());
        set.add(s3.getId());
        set.add(s4.getId());
        set.add(s5.getId());
        set.add(s6.getId());
        set.add(s7.getId());
        assertTrue("s1.getId() are not unique", set.size()==7);
    }

    //==========================================================================
    public void testLocationRefs() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        assertTrue("c.getContracts() should return an empty collection",
                   c.getContracts().isEmpty());
        // Contracts with different Locations
        ContractComplexType t1 = new ContractComplexType();
        t1.setSvcAgreementID("1");
        t1.setPortfolioFlag("G");
        t1.setProductShipToCustomerID("CustomerID1");
        ContractComplexType t2 = new ContractComplexType();
        t2.setSvcAgreementID("2");
        t2.setPortfolioFlag("G");
        t2.setSWShipToCustomerID("CustomerID2");
        ContractComplexType t3 = new ContractComplexType();
        t3.setSvcAgreementID("3");
        t3.setPortfolioFlag("G");
        t3.setSoldToCustomerID("CustomerID3");
        c.addContract(new ObligationHeaderKey("t1"), t1);
        c.addContract(new ObligationHeaderKey("t2"), t2);
        c.addContract(new ObligationHeaderKey("t3"), t3);

        // OOOSes with different Locations
        OOSComplexType t4 = new OOSComplexType();
        t4.setOOSKey("1");
        t4.setProductShipToCustomerID("CustomerID4");
        OOSComplexType t5 = new OOSComplexType();
        t5.setOOSKey("2");
        t5.setSWShipToCustomerID("CustomerID5");
        OOSComplexType t6 = new OOSComplexType();
        t6.setOOSKey("3");
        t6.setProductShipToCustomerID("CustomerID6");
        c.addOOS(new OOSKey("t4"), t4);
        c.addOOS(new OOSKey("t5"), t5);
        c.addOOS(new OOSKey("t6"), t6);

        // all Locations
        LocationComplexType s1 = new LocationComplexType();
        s1.setSourceCustomerID("CustomerID1");
        LocationComplexType s2 = new LocationComplexType();
        s1.setSourceCustomerID("CustomerID2");
        LocationComplexType s3 = new LocationComplexType();
        s1.setSourceCustomerID("CustomerID3");
        LocationComplexType s4 = new LocationComplexType();
        s1.setSourceCustomerID("CustomerID4");
        LocationComplexType s5 = new LocationComplexType();
        s1.setSourceCustomerID("CustomerID5");
        LocationComplexType s6 = new LocationComplexType();
        s1.setSourceCustomerID("CustomerID6");
        LocationComplexType s7 = new LocationComplexType();
        s1.setSourceCustomerID("unknown");
        c.addLocation(new LocationKey("CustomerID1"), s1);
        c.addLocation(new LocationKey("CustomerID2"), s2);
        c.addLocation(new LocationKey("CustomerID3"), s3);
        c.addLocation(new LocationKey("CustomerID4"), s4);
        c.addLocation(new LocationKey("CustomerID5"), s5);
        c.addLocation(new LocationKey("CustomerID6"), s6);
        c.addLocation(new LocationKey("unknown"), s7);

        // don't remove unused Locations
        c.createLocationRefs(false, true, true);
        Collection result = c.getLocations();
        assertTrue("Location collection should have 7 elements", result.size()==7);
        assertTrue("CustomerID1 is not part of the result", result.contains(s1));
        assertTrue("CustomerID2 is not part of the result", result.contains(s2));
        assertTrue("CustomerID3 is not part of the result", result.contains(s3));
        assertTrue("CustomerID4 is not part of the result", result.contains(s4));
        assertTrue("CustomerID5 is not part of the result", result.contains(s5));
        assertTrue("CustomerID6 is not part of the result", result.contains(s6));
        assertTrue("unknown is not part of the result", result.contains(s7));

        // remove duplicates unused Locations
        c.createLocationRefs(true, true, true);
        result = c.getLocations();
        assertTrue("Location collection should have 6 elements", result.size()==6);
        assertTrue("CustomerID1 is not part of the result", result.contains(s1));
        assertTrue("CustomerID2 is not part of the result", result.contains(s2));
        assertTrue("CustomerID3 is not part of the result", result.contains(s3));
        assertTrue("CustomerID4 is not part of the result", result.contains(s4));
        assertTrue("CustomerID5 is not part of the result", result.contains(s5));
        assertTrue("CustomerID6 is not part of the result", result.contains(s6));

        // check if the IDs are generated correctly
        assertTrue("s1.getId() should not be null", s1.getId()!=null);
        assertTrue("s2.getId() should not be null", s2.getId()!=null);
        assertTrue("s3.getId() should not be null", s3.getId()!=null);
        assertTrue("s4.getId() should not be null", s4.getId()!=null);
        assertTrue("s5.getId() should not be null", s5.getId()!=null);
        assertTrue("s6.getId() should not be null", s6.getId()!=null);
        assertTrue("s7.getId() should not be null", s7.getId()!=null);
        HashSet set = new HashSet();
        set.add(s1.getId());
        set.add(s2.getId());
        set.add(s3.getId());
        set.add(s4.getId());
        set.add(s5.getId());
        set.add(s6.getId());
        set.add(s7.getId());
        assertTrue("s1.getId() are not unique", set.size()==7);
    }

    //==========================================================================
    public void testGetContract() {
        EsReplyContext c = new EsReplyContext(new OutputDetails());
        // make sure the method can be called when no objects are available
        assertTrue("c.getContracts() is not empty", c.getContracts().size()==0);

        // make sure that non-identical objects are merged correctly
        ContractComplexType c1 = new ContractComplexType();
        c1.setSvcAgreementID("SvcAgreementID1");
        c1.setPortfolioFlag("G");
        ContractComplexType c2 = new ContractComplexType();
        c2.setSvcAgreementID("SvcAgreementID2");
        c2.setPortfolioFlag("G");
        ContractComplexType c3 = new ContractComplexType();
        c3.setSvcAgreementID("SvcAgreementID2");  // same key as c2
        c3.setPortfolioFlag("G");

        c.addContract(new ObligationHeaderKey("1"), c1);
        c.addContract(new ObligationHeaderKey("2"), c2);
        c.addContract(new ObligationHeaderKey("3"), c3);

        Collection result = c.getContracts();
        assertTrue("The result collection must not be null", result!=null);
        assertTrue("The size result collection must be 2", result.size()==2);

        Iterator it = result.iterator();
        ContractComplexType res1 = (ContractComplexType)it.next();
        ContractComplexType res2 = (ContractComplexType)it.next();
        assertTrue("The c.getContracts() method returned two identical objects",
                   res1!=res2);

        // make sure that "c1 and (c2 or c3)" are returned
        assertTrue("c1 is not part of the result", (res1==c1 || res2==c1));
    }


    //==========================================================================
    public void testUniqueOffersAndDeliverables() {
        OutputDetails details = new OutputDetails();
        details.setIncludeContracts(true);
        details.setIncludeOffers(true);
        details.setIncludeUniqueOffers(true);
        details.setIncludeUniqueDeliverables(true);
        EsReplyContext c = new EsReplyContext(details);

        ServiceKey key1 = new ServiceKey("1", "1");
        ServiceKey key2 = new ServiceKey("1", "2");
        ServiceKey key3 = new ServiceKey("1", "3");
        ContractComplexType contract = new ContractComplexType();
        c.addContract((ObligationHeaderKey)key1.getParent(), contract);

        OfferComplexType o1 = new OfferComplexType();
        o1.setOfferCode("code1");
        {
            Deliverable d1 = new Deliverable();
            d1.setDelivCode("d1");
            o1.addDeliverable(d1);
            Deliverable d2 = new Deliverable();
            d2.setDelivCode("d2");
            o1.addDeliverable(d2);
        }
        c.addOffer(key1, o1);
        OfferComplexType o2 = new OfferComplexType();
        o2.setOfferCode("code1");
        {
            Deliverable d1 = new Deliverable();
            d1.setDelivCode("d1");
            o1.addDeliverable(d1);
            Deliverable d2 = new Deliverable();
            d2.setDelivCode("d3");
            o1.addDeliverable(d2);
        }
        c.addOffer(key2, o2);
        OfferComplexType o3 = new OfferComplexType();
        o3.setOfferCode("code2");
        c.addOffer(key3, o3);

        c.mergeAndCalculateAll();
        ContractComplexType contract2 =
                    (ContractComplexType)c.getContracts().iterator().next();
        assertTrue("Contracts are not identical", contract==contract2);

        Enumeration enumeration = contract2.enumerateUniqueOffer();
        UniqueOffer offer1 = null;
        UniqueOffer offer2 = null;
        if (enumeration.hasMoreElements()) {
            offer1 = (UniqueOffer)enumeration.nextElement();
        }
        if (enumeration.hasMoreElements()) {
            offer2 = (UniqueOffer)enumeration.nextElement();
        }

        assertTrue("two unique offers expected", (offer1!=null && offer2!=null));
        assertTrue("there are more unique offeres than expected", !enumeration.hasMoreElements());
        assertTrue("unexcpected offer codes",
                    (offer1.getOfferCode().equals("code1") && offer2.getOfferCode().equals("code2")) ||
                    (offer1.getOfferCode().equals("code2") && offer2.getOfferCode().equals("code1"))
                    );

        // test unique deliverables
        if (offer1.getOfferCode().equals("code1")) {
            enumeration = offer1.enumerateUniqueDeliverable();
        }
        else {
            enumeration = offer2.enumerateUniqueDeliverable();
        }

        HashSet result = new HashSet();
        result.add("d1");
        result.add("d2");
        result.add("d3");
        while (enumeration.hasMoreElements()) {
            UniqueDeliverable ud = (UniqueDeliverable)enumeration.nextElement();
            if ( !result.remove(ud.getDelivCode())) {
                fail("missing deliverable code '" + ud.getDelivCode() +
                     "'for unique deliverable" );
            }
        }
        // finally, the result-set must be empty
        assertTrue("Following deliverable codes are missing: " +result.toString(),
                    result.size()==0);
    }

    //==========================================================================
    /**
     * make sure that following values are correctly calculated:
     * <table>
     * <tr><td>Contract</td><td>ActiveContractEntitlement</td></tr>
     * <tr><td>Contract</td><td>HeaderStartDate</td></tr>
     * <tr><td>Contract</td><td>HeaderEndDate</td></tr>
     * <tr><td>Contract</td><td>CCRN</td></tr>
     * </table>
     */
    public void testAggregatedValues() {
        try {
            OutputDetails details = new OutputDetails();
            details.setIncludeContracts(true);

            org.exolab.castor.types.Date date1 = new org.exolab.castor.types.Date("2002-01-01");
            org.exolab.castor.types.Date date2 = new org.exolab.castor.types.Date("2002-02-02");
            org.exolab.castor.types.Date date3 = new org.exolab.castor.types.Date("2002-03-03");
            org.exolab.castor.types.Date date4 = new org.exolab.castor.types.Date("2002-04-04");

            ContractComplexType c = new ContractComplexType();
            c.setSvcAgreementID("1");
            c.setPortfolioFlag("G");

            ObligationHeader oh1 = new ObligationHeader();
            oh1.setHeaderStartDate(date1);
            oh1.setHeaderEndDate(date2);
            oh1.setCCRN("ccrn");
            oh1.setActiveObligation(true);

            ObligationHeader oh2 = new ObligationHeader();
            oh2.setHeaderStartDate(date3);
            oh2.setHeaderEndDate(date4);
            oh2.setCCRN("ccrn");
            oh2.setActiveObligation(false);

            EsReplyContext ctx = new EsReplyContext(details);
            ctx.addContract(new ObligationHeaderKey("1"), c);
            ctx.addObligationHeader(new ObligationHeaderKey("1"), oh1);
            ctx.addContract(new ObligationHeaderKey("2"), c);    // same contract
            ctx.addObligationHeader(new ObligationHeaderKey("2"), oh2);
            ctx.mergeAndCalculateAll();

            Collection coll = ctx.getContracts();
            assertTrue("Only one contract should be returned", coll.size()==1);
            assertTrue("getOverallContractStartDate() is wrong",
                        ctx.getOverallContractStartDate().compareTo(date1)
                        ==org.exolab.castor.types.DateTimeBase.EQUALS);
            assertTrue("getOverallContractEndDate() is wrong",
                        ctx.getOverallContractEndDate().compareTo(date4)
                        ==org.exolab.castor.types.DateTimeBase.EQUALS);
            assertTrue("getHeaderStartDate() is wrong",
                        c.getHeaderStartDate().compareTo(date1)
                        ==org.exolab.castor.types.DateTimeBase.EQUALS);
            assertTrue("getHeaderEndDate() is wrong",
                        c.getHeaderEndDate().compareTo(date4)
                        ==org.exolab.castor.types.DateTimeBase.EQUALS);
            assertTrue("CCRN must be 'ccrn'", c.getCCRN().equals("ccrn"));
            assertTrue("Contract should be active if one OH is active",
                        c.getActiveContractEntitlement());
            assertTrue("ctx.isActiveContractEntitlement() should return true" +
                       " if one contract is active",
                        ctx.isActiveContractEntitlement());

            // verify what happens if one header end date is null and if the CCRN
            // string is not unique
            c.setCCRN(null);
            oh1.setHeaderEndDate(null);
            oh1.setCCRN("blabla");
            ctx.mergeAndCalculateAll();
            assertTrue("Only one contract should be returned", coll.size()==1);
            assertTrue("getOverallContractStartDate() is wrong",
                        ctx.getOverallContractStartDate().compareTo(date1)
                        ==org.exolab.castor.types.DateTimeBase.EQUALS);
            assertTrue("getOverallContractEndDate() must be null",
                        ctx.getOverallContractEndDate()==null);
            assertTrue("getHeaderStartDate() is wrong",
                        c.getHeaderStartDate().compareTo(date1)
                        ==org.exolab.castor.types.DateTimeBase.EQUALS);
            assertTrue("getHeaderEndDate() must be null",
                        c.getHeaderEndDate()==null);
            assertTrue("CCRN must be null", c.getCCRN()==null);
        }
        catch (java.text.ParseException e) {
            fail(e.toString());
        }
    }

    //==========================================================================
    /**
     * When two contracts exist for the same obligation header ID, the newest
     * entry (CdoPublishDate) has to be used.
     */
    public void testThatNewestContractIsUsed() {

            ContractComplexType c1 = new ContractComplexType();
            c1.setSvcAgreementID("1");
            c1.setPortfolioFlag("G");
            c1.setCdoPublishDate("01-01-2002T08:41:35:023Z");

            ContractComplexType c2 = new ContractComplexType();
            c2.setSvcAgreementID("1");
            c2.setPortfolioFlag("G");
            c2.setCdoPublishDate("01-01-2002T08:41:35:024Z");

            EsReplyContext ctx = new EsReplyContext(new OutputDetails());
            ctx.addContract(new ObligationHeaderKey("1"), c1);
            ctx.addContract(new ObligationHeaderKey("1"), c2);
            assertTrue("only one contract must be available", ctx.getContracts().size()==1);
            assertTrue("The newest contract was not used",
                        ((ContractComplexType)ctx.getContracts().iterator().next())==c2);
            // try it again with different insert order
            ctx = new EsReplyContext(new OutputDetails());
            ctx.addContract(new ObligationHeaderKey("1"), c2);
            ctx.addContract(new ObligationHeaderKey("1"), c1);
            assertTrue("only one contract must be available", ctx.getContracts().size()==1);
            assertTrue("The newest contract was not used",
                        ((ContractComplexType)ctx.getContracts().iterator().next())==c2);
        }

    /**
     * Verify that
     * <ul>
     * <li>cnt0==0
     * <li>cnt1==1
     * <li>cnt2==2
     * </ul>
     */
    private void verifyCounts(String method, int cnt0, int cnt1, int cnt2) {
        assertTrue(method + " returned unexpected value (cnt0 should be 0)", cnt0==0);
        assertTrue(method + " returned unexpected value (cnt1 should be 1)", cnt1==1);
        assertTrue(method + " returned unexpected value (cnt2 should be 2)", cnt2==2);
    }

    /**
     * Verify that
     * <ul>
     * <li>id0==null
     * <li>id1!=null
     * <li>id2!=null
     * <li>id1!=id2
     * </ul>
     */
    private void verifyIds(String method, String id0, String id1, String id2) {
        assertTrue(method + " returned unexpected value (id0 shouldn't be null)", id0!=null);
        assertTrue(method + " returned unexpected value (id1 shouldn't be null)", id1!=null);
        assertTrue(method + " returned unexpected value (id2 shouldn't be null)", id2!=null);
        assertTrue(method + " returned the same ID for different objects",
                    (! id0.equals(id1)) && (! id0.equals(id2)) && (! id1.equals(id2)));
    }

    /**
     * Make sure that o1 and o2 are contained in the enumeration. If o1 or
     * o2 are null, they must not be in the enumeration, i.e. they are ignored.
     */
    private void verifyContainment(Enumeration enumeration, Object o1, Object o2) {
        if (enumeration==null) {
            fail("<castorObject>.enumerateXXX() should not be null");
        }
        else {
            Object x1 = null;
            Object x2 = null;
            if (enumeration.hasMoreElements()) {
                x1 = enumeration.nextElement();
            }
            if (enumeration.hasMoreElements()) {
                x2 = enumeration.nextElement();
            }

            if (o1!=null && o1!=x1 && o1!=x2) {
                fail("First object o1 is not in the enumeration.");
            }
            if (o2!=null && o2!=x1 && o2!=x2) {
                fail("First object o2 is not in the enumeration.");
            }
            if (x1!=null && x1==x2) {
                fail("The enumeration contained identical objects");
            }
        }
    }
}