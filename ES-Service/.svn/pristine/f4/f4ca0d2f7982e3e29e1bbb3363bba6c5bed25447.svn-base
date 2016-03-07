/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/OutputDetails.java 1.16 2004-05-08 04:42:51+02 entitlem Exp $
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
 * $Log: OutputDetails.java,v $
 * Revision 1.16  2004-05-08 04:42:51+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.15  2004-05-05 15:41:40+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.14  2004-01-29 18:07:38+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.13  2003-08-28 11:14:34+02  lbednari
 * Author: lbednari@bbnnaid340.bbn.hp.com ()
 * - IncludeWarrantyWorkings -> IncludeWorkings
 *
 * Revision 1.12  2003-08-04 16:51:58+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.11  2003-06-16 17:09:37+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * higher-level elements will be implicitly included in the response even if they have not been explicitly requested
 *
 * Revision 1.10  2003-06-04 16:21:35+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * remove IncludeOOSes flag from EntitlementbySn; add JavaDoc; make some constructors private
 *
 * Revision 1.9  2003-06-02 08:22:41+02  JUHANK
 * Author: JUHANK@dhcp-15-197-230-117.bbn.hp.com ()
 * Note last check in wasn't correct. Now the following things are done
 * - added missing flags (includeAddresses, includeOOSes) for
 *   EntitlementBySnRequest
 * - added flags for EntitlementByPnRequest
 *
 * Revision 1.7  2003-05-28 18:02:33+02  JUHANK
 * Author: JUHANK@dhcp-15-197-230-117.bbn.hp.com ()
 * set the flags for Offer/Deliverable/Modifier for the request of
 * the EntBySn operation
 *
 * Revision 1.6  2003-05-22 14:25:33+02  THKOE
 * Author: THKOE@dhcp-15-197-238-218.bbn.hp.com ()
 * constructor for PrintAdvantageEntitlement-operation added
 *
 * Revision 1.5  2003-05-12 02:00:10+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.4  2003-05-05 16:55:02+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * fix bug for includeContracts
 *
 * Revision 1.3  2003-04-17 09:00:07+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * new CTor for usage within the getAssociatedContractsOperation
 *
 * Revision 1.2  2003-04-16 16:17:09+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * remove hasIncludeXXX() methods in constructors
 *
 * Revision 1.1  2003-04-15 14:01:04+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import com.hp.es.xml.service.AssociatedContractsRequest;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.ContractRequestComplexType;
import com.hp.es.xml.service.EntitlementByPnRequest;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EntitlementByXXRequestComplexType;
import com.hp.es.xml.service.PrintAdvantageRequest;

/**
 * This class encapsulates the output details information, i.e. which elements
 * should be part of the reply. The class also guarantees that some of the
 * higher-level elements will be implicitly included in the response even if
 * they have not been explicitly requested, e.g. if includeModifiers is set to
 * true then also includeOffer is automatically true.
 */
public class OutputDetails {

    // constants defined in database
    static private final String C_DETAIL_CONTRACT     = "CONTRACT";
    static private final String C_DETAIL_OOS          = "OOS";
    static private final String C_DETAIL_ADDRESS      = "ADDRESS";
    static private final String C_DETAIL_CONTACT      = "CONTACT";
    static private final String C_DETAIL_OFFER        = "OFFER";
    static private final String C_DETAIL_DLV          = "DELIVERABLE";
    static private final String C_DETAIL_MOD          = "MODIFIER";
    static private final String C_DETAIL_UNIQUE_OFFER = "UNIQUEO";
    static private final String C_DETAIL_UNIQUE_DLV   = "UNIQUED";

    private boolean includeAddresses;
    private boolean includeContacts;
    private boolean includeOffers;
    private boolean includeDeliverables;
    private boolean includeModifiers;
    private boolean includeWarranty;
    private boolean includeContracts;
    private boolean includeServiceNotes;
    private boolean includeOOSes;
    private boolean includeWorkings;
    private boolean includeUniqueOffers;
    private boolean includeUniqueDeliverables;

    /**
     * Default initialization. Set all include flags to false.
     */
    public OutputDetails() {
        includeAddresses = false;
        includeContacts = false;
        includeOffers = false;
        includeDeliverables = false;
        includeModifiers = false;
        includeWarranty = false;
        includeContracts = false;
        includeServiceNotes = false;
        includeOOSes = false;
        includeWorkings = false;
        includeUniqueOffers = false;
        includeUniqueDeliverables = false;
    }

    /**
     * Fill all flags based on the given EntitlementByPnRequest
     * @param request
     */
    public OutputDetails(EntitlementByPnRequest request) {
        this((EntitlementByXXRequestComplexType)request);
        includeOOSes = request.getIncludeOOSes();
        includeUniqueDeliverables = request.getIncludeUniqueDeliverables();
        includeUniqueOffers = request.getIncludeUniqueOffers();
    }

    /**
     * The constructor for the AssociatedContractsRequest doesn't read
     * any values from the request. The detail level for this Operation
     * won't be passed to the DB procedure. The OutputDetails object
     * will be used to concat the DB result only (in the EsReplyContext).
     * @param request this parameter is only used to get the right constructor.
     */
    public OutputDetails(AssociatedContractsRequest request) {
        this();
        includeContracts = true;
    }

    /**
     * The PrintAdvatageRequest doesn't have any include flags.
     * The OutputDetails object will be used to concat the DB
     * result only (in the EsReplyContext).
     * @param request
     */
    public OutputDetails(PrintAdvantageRequest request) {
        this();
        includeContracts = true;
        includeOffers = true;
        includeOOSes = true;
    }

    /**
     * Fill all flags based on the given ContractRequest
     * @param request
     */
    public OutputDetails(ContractRequest request) {
        this((ContractRequestComplexType)request);
        includeOOSes = request.getIncludeOOSes();
        includeUniqueDeliverables = request.getIncludeUniqueDeliverables();
        includeUniqueOffers = request.getIncludeUniqueOffers();
    }

    /**
     * Fill all flags based on the given EntitlementBySnRequest
     * @param request
     */
    public OutputDetails(EntitlementBySnRequest request) {
        this((EntitlementByXXRequestComplexType)request);
        includeOOSes = true;
    }

    /**
     * Fill all flags based on the given ContractRequestComplexType
     * @param request
     */
    private OutputDetails(ContractRequestComplexType request) {
        this();
        includeContracts = true;
        includeAddresses = request.getIncludeAddresses();
        includeContacts = request.getIncludeContacts();
        includeDeliverables = request.getIncludeDeliverables();
        includeModifiers = request.getIncludeModifiers();
        includeOffers = request.getIncludeOffers();
    }

    /**
     * Fill all flags based on the given EntitlementByXXRequestComplexType
     * @param request
     */
    private OutputDetails(EntitlementByXXRequestComplexType request) {
        this((ContractRequestComplexType)request);
        includeContracts = request.getIncludeContracts();
        includeServiceNotes = request.getIncludeServiceNotes();
        includeWarranty = request.getIncludeWarranty();
        includeWorkings = request.getIncludeWorkings();
    }

    public boolean isIncludeAddresses() {
        return includeAddresses;
    }

    public void setIncludeAddresses(boolean newIncludeAddresses) {
        includeAddresses = newIncludeAddresses;
    }

    public void setIncludeContacts(boolean newIncludeContacts) {
        includeContacts = newIncludeContacts;
    }

    public boolean isIncludeContacts() {
        return includeContacts;
    }

    public void setIncludeOffers(boolean newIncludeOffers) {
        includeOffers = newIncludeOffers;
    }

    public boolean isIncludeOffers() {
        return includeOffers ||
               isIncludeDeliverables() ||
               isIncludeModifiers();
    }

    public void setIncludeDeliverables(boolean newIncludeDeliverables) {
        includeDeliverables = newIncludeDeliverables;
    }

    public boolean isIncludeDeliverables() {
        return includeDeliverables ||
               isIncludeModifiers();
    }

    public void setIncludeModifiers(boolean newIncludeModifiers) {
        includeModifiers = newIncludeModifiers;
    }

    public boolean isIncludeModifiers() {
        return includeModifiers;
    }

    public void setIncludeWarranty(boolean newIncludeWarranty) {
        includeWarranty = newIncludeWarranty;
    }

    public boolean isIncludeWarranty() {
        return includeWarranty;
    }

    public void setIncludeContracts(boolean newIncludeContracts) {
        includeContracts = newIncludeContracts;
    }

    public boolean isIncludeContracts() {
        return includeContracts ||
               isIncludeUniqueOffers() ||
               isIncludeOffers();
    }

    public void setIncludeServiceNotes(boolean newIncludeServiceNotes) {
        includeServiceNotes = newIncludeServiceNotes;
    }

    public boolean isIncludeServiceNotes() {
        return includeServiceNotes;
    }

    public void setIncludeOOSes(boolean newIncludeOOSes) {
        includeOOSes = newIncludeOOSes;
    }

    public boolean isIncludeOOSes() {
        return includeOOSes;
    }

    public void setIncludeWorkings(boolean newIncludeWorkings) {
        includeWorkings = newIncludeWorkings;
    }

    public boolean isIncludeWorkings() {
        return includeWorkings;
    }

    public void setIncludeUniqueOffers(boolean newIncludeUniqueOffers) {
        includeUniqueOffers = newIncludeUniqueOffers;
    }

    public boolean isIncludeUniqueOffers() {
        return includeUniqueOffers ||
               isIncludeUniqueDeliverables();
    }

    public void setIncludeUniqueDeliverables(boolean newIncludeUniqueDeliverables) {
        includeUniqueDeliverables = newIncludeUniqueDeliverables;
    }

    public boolean isIncludeUniqueDeliverables() {
        return includeUniqueDeliverables;
    }

    /**
     * This method format all include flags. The string
     * will be passed to the DB procedures.
     * @return String containing constants for the database
     */
    public String toDbString() {
        StringBuffer buf = new StringBuffer();
        if (this.isIncludeContracts()) {
            buf.append(C_DETAIL_CONTRACT);
            buf.append('|');
        }
        if (this.isIncludeOOSes()) {
            buf.append(C_DETAIL_OOS);
            buf.append('|');
        }
        if (this.isIncludeAddresses()) {
            buf.append(C_DETAIL_ADDRESS);
            buf.append('|');
        }
        if (this.isIncludeContacts()) {
            buf.append(C_DETAIL_CONTACT);
            buf.append('|');
        }
        if (this.isIncludeOffers()) {
            buf.append(C_DETAIL_OFFER);
            buf.append('|');
        }
        if (this.isIncludeDeliverables()) {
            buf.append(C_DETAIL_DLV);
            buf.append('|');
        }
        if (this.isIncludeModifiers()) {
            buf.append(C_DETAIL_MOD);
            buf.append('|');
        }
        if (this.isIncludeUniqueDeliverables()) {
            buf.append(C_DETAIL_UNIQUE_DLV);
            buf.append('|');
        }
        if (this.isIncludeUniqueOffers()) {
            buf.append(C_DETAIL_UNIQUE_OFFER);
            buf.append('|');
        }
        return buf.toString();
    }
}
