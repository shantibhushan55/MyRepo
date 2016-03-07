/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/OutputDetailsTest.java 1.6 2004-05-08 04:42:54+02 entitlem Exp $
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
 * $Log: OutputDetailsTest.java,v $
 * Revision 1.6  2004-05-08 04:42:54+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.5  2004-05-05 15:41:43+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.4  2004-01-29 18:07:41+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-08-28 11:14:36+02  lbednari
 * Author: lbednari@bbnnaid340.bbn.hp.com ()
 * - IncludeWarrantyWorkings -> IncludeWorkings
 *
 * Revision 1.2  2003-08-04 16:52:01+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.1  2003-06-17 13:33:19+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.xml.service.AssociatedContractsRequest;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.EntitlementByPnRequest;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.PrintAdvantageRequest;

/**
 * Test if the include flags are set correctly based on the flags set in the
 * request. This class also tests if the higher level elements are implicitely
 * included, e.g. if IncludeDeliverables is true, then automatically includeOffer
 * must be true.
 */
public class OutputDetailsTest extends TestCase {

    public OutputDetailsTest(String inName) {
        super(inName);
    }

    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(OutputDetailsTest.class);
    }

    public void testEntitlementByPnRequest() {
        EntitlementByPnRequest r;

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeAddresses wrong", getOD(r).isIncludeAddresses());
        r.setIncludeAddresses(true);
        Assert.assertTrue("isIncludeAddresses wrong", getOD(r).isIncludeAddresses());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeContacts wrong", getOD(r).isIncludeContacts());
        r.setIncludeContacts(true);
        Assert.assertTrue("isIncludeContacts wrong", getOD(r).isIncludeContacts());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeContracts wrong", getOD(r).isIncludeContracts());
        r.setIncludeContracts(true);
        Assert.assertTrue("isIncludeContracts wrong", getOD(r).isIncludeContracts());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());
        r.setIncludeDeliverables(true);
        Assert.assertTrue("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());
        r.setIncludeModifiers(true);
        Assert.assertTrue("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeOffers wrong", getOD(r).isIncludeOffers());
        r.setIncludeOffers(true);
        Assert.assertTrue("isIncludeOffers wrong", getOD(r).isIncludeOffers());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeOOSes wrong", getOD(r).isIncludeOOSes());
        r.setIncludeOOSes(true);
        Assert.assertTrue("isIncludeOOSes wrong", getOD(r).isIncludeOOSes());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeServiceNotes wrong", getOD(r).isIncludeServiceNotes());
        r.setIncludeServiceNotes(true);
        Assert.assertTrue("isIncludeServiceNotes wrong", getOD(r).isIncludeServiceNotes());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeUniqueDeliverables wrong", getOD(r).isIncludeUniqueDeliverables());
        r.setIncludeUniqueDeliverables(true);
        Assert.assertTrue("isIncludeUniqueDeliverables wrong", getOD(r).isIncludeUniqueDeliverables());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeUniqueOffers wrong", getOD(r).isIncludeUniqueOffers());
        r.setIncludeUniqueOffers(true);
        Assert.assertTrue("isIncludeUniqueOffers wrong", getOD(r).isIncludeUniqueOffers());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeWarranty wrong", getOD(r).isIncludeWarranty());
        r.setIncludeWarranty(true);
        Assert.assertTrue("isIncludeWarranty wrong", getOD(r).isIncludeWarranty());

        r = new EntitlementByPnRequest();
        Assert.assertFalse("isIncludeWorkings wrong", getOD(r).isIncludeWorkings());
        r.setIncludeWorkings(true);
        Assert.assertTrue("isIncludeWorkings wrong", getOD(r).isIncludeWorkings());
    }

    public void testAssociatedContractsRequest() {
        AssociatedContractsRequest r = new AssociatedContractsRequest();
        OutputDetails od = new OutputDetails(r);
        Assert.assertFalse("isIncludeAddresses wrong", od.isIncludeAddresses());
        Assert.assertFalse("isIncludeContacts wrong", od.isIncludeContacts());
        Assert.assertTrue ("isIncludeContracts wrong", od.isIncludeContracts());
        Assert.assertFalse("isIncludeDeliverables wrong", od.isIncludeDeliverables());
        Assert.assertFalse("isIncludeModifiers wrong", od.isIncludeModifiers());
        Assert.assertFalse("isIncludeOffers wrong", od.isIncludeOffers());
        Assert.assertFalse("isIncludeOOSes wrong", od.isIncludeOOSes());
        Assert.assertFalse("isIncludeServiceNotes wrong", od.isIncludeServiceNotes());
        Assert.assertFalse("isIncludeUniqueDeliverables wrong", od.isIncludeUniqueDeliverables());
        Assert.assertFalse("isIncludeUniqueOffers wrong", od.isIncludeUniqueOffers());
        Assert.assertFalse("isIncludeWarranty wrong", od.isIncludeWarranty());
        Assert.assertFalse("isIncludeWorkings wrong", od.isIncludeWorkings());
    }

    public void testPrintAdvantageRequest() {
        PrintAdvantageRequest r = new PrintAdvantageRequest();
        OutputDetails od = new OutputDetails(r);
        Assert.assertFalse("isIncludeAddresses wrong", od.isIncludeAddresses());
        Assert.assertFalse("isIncludeContacts wrong", od.isIncludeContacts());
        Assert.assertTrue ("isIncludeContracts wrong", od.isIncludeContracts());
        Assert.assertFalse("isIncludeDeliverables wrong", od.isIncludeDeliverables());
        Assert.assertFalse("isIncludeModifiers wrong", od.isIncludeModifiers());
        Assert.assertTrue ("isIncludeOffers wrong", od.isIncludeOffers());
        Assert.assertTrue ("isIncludeOOSes wrong", od.isIncludeOOSes());
        Assert.assertFalse("isIncludeServiceNotes wrong", od.isIncludeServiceNotes());
        Assert.assertFalse("isIncludeUniqueDeliverables wrong", od.isIncludeUniqueDeliverables());
        Assert.assertFalse("isIncludeUniqueOffers wrong", od.isIncludeUniqueOffers());
        Assert.assertFalse("isIncludeWarranty wrong", od.isIncludeWarranty());
        Assert.assertFalse("isIncludeWorkings wrong", od.isIncludeWorkings());
    }

    public void testEntitlementBySnRequest() {
        EntitlementBySnRequest r;

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeAddresses wrong", getOD(r).isIncludeAddresses());
        r.setIncludeAddresses(true);
        Assert.assertTrue("isIncludeAddresses wrong", getOD(r).isIncludeAddresses());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeContacts wrong", getOD(r).isIncludeContacts());
        r.setIncludeContacts(true);
        Assert.assertTrue("isIncludeContacts wrong", getOD(r).isIncludeContacts());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeContracts wrong", getOD(r).isIncludeContracts());
        r.setIncludeContracts(true);
        Assert.assertTrue("isIncludeContracts wrong", getOD(r).isIncludeContracts());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());
        r.setIncludeDeliverables(true);
        Assert.assertTrue("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());
        r.setIncludeModifiers(true);
        Assert.assertTrue("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeOffers wrong", getOD(r).isIncludeOffers());
        r.setIncludeOffers(true);
        Assert.assertTrue("isIncludeOffers wrong", getOD(r).isIncludeOffers());

        // OOSes are always included
        r = new EntitlementBySnRequest();
        Assert.assertTrue ("isIncludeOOSes wrong", getOD(r).isIncludeOOSes());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeServiceNotes wrong", getOD(r).isIncludeServiceNotes());
        r.setIncludeServiceNotes(true);
        Assert.assertTrue("isIncludeServiceNotes wrong", getOD(r).isIncludeServiceNotes());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeUniqueDeliverables wrong", getOD(r).isIncludeUniqueDeliverables());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeUniqueOffers wrong", getOD(r).isIncludeUniqueOffers());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeWarranty wrong", getOD(r).isIncludeWarranty());
        r.setIncludeWarranty(true);
        Assert.assertTrue("isIncludeWarranty wrong", getOD(r).isIncludeWarranty());

        r = new EntitlementBySnRequest();
        Assert.assertFalse("isIncludeWorkings wrong", getOD(r).isIncludeWorkings());
        r.setIncludeWorkings(true);
        Assert.assertTrue("isIncludeWorkings wrong", getOD(r).isIncludeWorkings());
    }

    public void testContractRequest() {
        ContractRequest r;

        r = new ContractRequest();
        Assert.assertFalse("isIncludeAddresses wrong", getOD(r).isIncludeAddresses());
        r.setIncludeAddresses(true);
        Assert.assertTrue("isIncludeAddresses wrong", getOD(r).isIncludeAddresses());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeContacts wrong", getOD(r).isIncludeContacts());
        r.setIncludeContacts(true);
        Assert.assertTrue("isIncludeContacts wrong", getOD(r).isIncludeContacts());

        // alwasy true
        r = new ContractRequest();
        Assert.assertTrue ("isIncludeContracts wrong", getOD(r).isIncludeContracts());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());
        r.setIncludeDeliverables(true);
        Assert.assertTrue("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());
        r.setIncludeModifiers(true);
        Assert.assertTrue("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeOffers wrong", getOD(r).isIncludeOffers());
        r.setIncludeOffers(true);
        Assert.assertTrue("isIncludeOffers wrong", getOD(r).isIncludeOffers());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeOOSes wrong", getOD(r).isIncludeOOSes());
        r.setIncludeOOSes(true);
        Assert.assertTrue("isIncludeOOSes wrong", getOD(r).isIncludeOOSes());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeServiceNotes wrong", getOD(r).isIncludeServiceNotes());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeUniqueDeliverables wrong", getOD(r).isIncludeUniqueDeliverables());
        r.setIncludeUniqueDeliverables(true);
        Assert.assertTrue("isIncludeUniqueDeliverables wrong", getOD(r).isIncludeUniqueDeliverables());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeUniqueOffers wrong", getOD(r).isIncludeUniqueOffers());
        r.setIncludeUniqueOffers(true);
        Assert.assertTrue("isIncludeUniqueOffers wrong", getOD(r).isIncludeUniqueOffers());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeWarranty wrong", getOD(r).isIncludeWarranty());

        r = new ContractRequest();
        Assert.assertFalse("isIncludeWorkings wrong", getOD(r).isIncludeWorkings());
    }

    public void testImplicitInclusionOfHigherLevelElements() {
        EntitlementByPnRequest r;

        r = new EntitlementByPnRequest();
        r.setIncludeModifiers(true);
        Assert.assertTrue("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());
        Assert.assertTrue("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());
        Assert.assertTrue("isIncludeOffers wrong", getOD(r).isIncludeOffers());
        Assert.assertTrue("isIncludeContracts wrong", getOD(r).isIncludeContracts());
        // all others remain false
        assertFalseElements(r);

        r = new EntitlementByPnRequest();
        r.setIncludeDeliverables(true);
        Assert.assertFalse("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());
        Assert.assertTrue ("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());
        Assert.assertTrue ("isIncludeOffers wrong", getOD(r).isIncludeOffers());
        Assert.assertTrue ("isIncludeContracts wrong", getOD(r).isIncludeContracts());
        // all others remain false
        assertFalseElements(r);

        r = new EntitlementByPnRequest();
        r.setIncludeOffers(true);
        Assert.assertFalse("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());
        Assert.assertFalse("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());
        Assert.assertTrue ("isIncludeOffers wrong", getOD(r).isIncludeOffers());
        Assert.assertTrue ("isIncludeContracts wrong", getOD(r).isIncludeContracts());
        // all others remain false
        assertFalseElements(r);

        r = new EntitlementByPnRequest();
        r.setIncludeContracts(true);
        Assert.assertFalse("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());
        Assert.assertFalse("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());
        Assert.assertFalse("isIncludeOffers wrong", getOD(r).isIncludeOffers());
        Assert.assertTrue ("isIncludeContracts wrong", getOD(r).isIncludeContracts());
        // all others remain false
        assertFalseElements(r);

        r = new EntitlementByPnRequest();
        r.setIncludeUniqueDeliverables(true);
        Assert.assertFalse("isIncludeModifiers wrong", getOD(r).isIncludeModifiers());
        Assert.assertFalse("isIncludeDeliverables wrong", getOD(r).isIncludeDeliverables());
        Assert.assertFalse("isIncludeOffers wrong", getOD(r).isIncludeOffers());
        Assert.assertTrue ("isIncludeContracts wrong", getOD(r).isIncludeContracts());
        Assert.assertFalse("isIncludeAddresses wrong", getOD(r).isIncludeAddresses());
        Assert.assertFalse("isIncludeContacts wrong", getOD(r).isIncludeContacts());
        Assert.assertFalse("isIncludeOOSes wrong", getOD(r).isIncludeOOSes());
        Assert.assertFalse("isIncludeServiceNotes wrong", getOD(r).isIncludeServiceNotes());
        Assert.assertTrue ("isIncludeUniqueDeliverables wrong", getOD(r).isIncludeUniqueDeliverables());
        Assert.assertTrue ("isIncludeUniqueOffers wrong", getOD(r).isIncludeUniqueOffers());
        Assert.assertFalse("isIncludeWarranty wrong", getOD(r).isIncludeWarranty());
        Assert.assertFalse("isIncludeWorkings wrong", getOD(r).isIncludeWorkings());
    }

    private void assertFalseElements(EntitlementByPnRequest r) {
        Assert.assertFalse("isIncludeAddresses wrong", getOD(r).isIncludeAddresses());
        Assert.assertFalse("isIncludeContacts wrong", getOD(r).isIncludeContacts());
        Assert.assertFalse("isIncludeOOSes wrong", getOD(r).isIncludeOOSes());
        Assert.assertFalse("isIncludeServiceNotes wrong", getOD(r).isIncludeServiceNotes());
        Assert.assertFalse("isIncludeUniqueDeliverables wrong", getOD(r).isIncludeUniqueDeliverables());
        Assert.assertFalse("isIncludeUniqueOffers wrong", getOD(r).isIncludeUniqueOffers());
        Assert.assertFalse("isIncludeWarranty wrong", getOD(r).isIncludeWarranty());
        Assert.assertFalse("isIncludeWorkings wrong", getOD(r).isIncludeWorkings());
    }

    private OutputDetails getOD(EntitlementByPnRequest r) {
        return new OutputDetails(r);
    }

    private OutputDetails getOD(EntitlementBySnRequest r) {
        return new OutputDetails(r);
    }

    private OutputDetails getOD(ContractRequest r) {
        return new OutputDetails(r);
    }

    public static void main(String[] args) {
    }
}
