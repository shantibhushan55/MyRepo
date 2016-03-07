/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/EsReplyContext.java 1.31 2004-09-28 10:10:34+02 stefsobe Exp $
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
 * $Log: EsReplyContext.java,v $
 * Revision 1.31  2004-09-28 10:10:34+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * minor changes
 *
 * Revision 1.30  2004-07-16 10:05:42+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * getOosWarrantyStartDate may return null
 *
 * Revision 1.29  2004-07-12 15:05:52+02  juhank
 * Author: juhank@hankejuergen.emea.cpqcorp.net ()
 * added initialization of serviceStartDateElgibilityMap and oosWtyStartDateMap
 *
 * Revision 1.28  2004-07-02 11:55:38+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Add two HashMap: serviceStartDateElgibilityMap and oosWtyStartDateMap for PoP.

 * Four related getter and setter methods are added.
 *
 * Revision 1.27  2004-05-08 04:42:39+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.26  2004-05-05 15:41:28+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.25  2004-03-15 15:22:12+01  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * fix possible null pointer exceptions
 *
 * Revision 1.24  2004-01-29 18:07:26+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.23  2003-12-02 17:17:42+01  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * fix: don't overwrite HashMap for prodID-aggrProdID mapping
 *
 * Revision 1.22  2003-11-04 20:37:46+01  RONAR
 * Author: RONAR@dhcp-15-197-229-237.bbn.hp.com ()
 * Change for C3 iteration
 *
 * Revision 1.21  2003-09-18 11:06:08+02  GERE
 * Author: GERE@dhcp-15-197-232-0.bbn.hp.com ()
 * setting of location.PSPID removed because this field comes now directly from the DB
 *
 * Revision 1.20  2003-09-17 14:14:34+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * just change formatting
 *
 * Revision 1.19  2003-09-16 14:23:12+02  GERE
 * Author: GERE@dhcp-15-197-232-0.bbn.hp.com ()
 * usage of the current milliseconds change to a id counter
 *
 * Revision 1.18  2003-09-10 16:54:14+02  GERE
 * Author: GERE@dhcp-15-197-232-0.bbn.hp.com ()
 * Aggregation logic for CarePacks changed (WITS 653)
 *
 * Revision 1.17  2003-09-08 15:19:55+02  RONAR
 * Author: RONAR@dhcp-15-197-238-62.bbn.hp.com ()
 * updated for 6.0 care pack
 *
 * Revision 1.16  2003-09-05 15:55:16+02  GERE
 * Author: GERE@dhcp-15-197-232-0.bbn.hp.com ()
 * handling of OosGroup without an OOS while creating the references between the AppliesTo and the OOS
 *
 * Revision 1.15  2003-09-05 15:47:05+02  RONAR
 * Author: RONAR@dhcp-15-197-238-62.bbn.hp.com ()
 * udpated 6.0 care pack related changes
 *
 * Revision 1.14  2003-08-04 16:51:45+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.13  2003-07-18 11:51:58+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * rename getContract() to getUniqueContract(); add getContract()
 *
 * Revision 1.12  2003-07-14 17:25:56+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * fix compareTo method
 *
 * Revision 1.11  2003-07-03 12:19:48+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * use constant DateTimeBase.GREATER_THAN
 *
 * Revision 1.10  2003-07-03 11:57:05+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * change behavior for special handling flag
 *
 * Revision 1.9  2003-06-25 10:47:42+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * change calculation of the active contract flags
 *
 * Revision 1.8  2003-05-27 10:16:19+02  juhank
 * Author: juhank@dhcp-15-197-230-117.bbn.hp.com ()
 * merged changes from 5_0C2 branch
 *
 * Revision 1.7  2003-05-12 01:59:58+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.6  2003-05-08 11:40:17+02  lbednari
 * Author: lbednari@dhcp-15-197-235-62.bbn.hp.com ()
 * - changed to use TreeMap instead HashMap
 *
 * Revision 1.5  2003-04-29 16:35:27+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * add JavaDoc
 *
 * Revision 1.4  2003-04-28 15:20:48+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * fix calculation of header end date
 *
 * Revision 1.3  2003-04-17 08:55:51+02  GERE
 * Author: GERE@dhcp-15-198-3-194.bbn.hp.com ()
 * properties for the getAssociatedContractsOperation added
 *
 * Revision 1.2  2003-04-16 16:12:32+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * several changes
 *
 * Revision 1.1  2003-04-15 13:58:33+02  stefsobe
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
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.hp.es.service.contractEntitlement.db.OutputDetails;
import com.hp.es.service.contractEntitlement.keys.AppliesToKey;
import com.hp.es.service.contractEntitlement.keys.ContactKey;
import com.hp.es.service.contractEntitlement.keys.DelivModifierKey;
import com.hp.es.service.contractEntitlement.keys.DeliverableKey;
import com.hp.es.service.contractEntitlement.keys.Key;
import com.hp.es.service.contractEntitlement.keys.LocationKey;
import com.hp.es.service.contractEntitlement.keys.ModifierKey;
import com.hp.es.service.contractEntitlement.keys.OOSKey;
import com.hp.es.service.contractEntitlement.keys.ObligationHeaderKey;
import com.hp.es.service.contractEntitlement.keys.ServiceKey;
import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.XMLIdGenerator;
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
 * This class stores all objects (classes created by Castor based on the
 * XML schema of the EsReply) for one EsReply. The database managers can
 * use the addXXX(Key, Object) methods to store that data. Note that the
 * class is not thread-save but the addXXX(Key, Object) methods could be
 * called in parallel because there is no interaction between the different
 * objects. The class that calls the addXXX(Key, Object) method has to make
 * sure that no duplicates are added. In the case of Contracts, only one
 * contract per service agreement ID should be added.<p>
 * When all data are available, the related objects can be merged together,
 * e.g. all Modifiers are merged into the Offers. This will be done by the
 * class that creates the EsReply. The corresponding mergeXXX() methods
 * have to be called for this.<p>
 * If necessary, the ID/IDREF relations have to be created by calling the
 * createXXXRefs() methods. This must be done only if the corresponding
 * objects are included in the reply, e.g. call the createAppliesToOOSRefs()
 * method only if the OOS is part of the EsReply.<p>
 * When all the relations are created, the top-level objects of the reply
 * (Contact, Contract, Location, OOS) can ge accessed by the getXXX() method
 * and put into the EsReply object.<p>
 * Since only the top-level objects are accessed when the reply is generated,
 * only related objects will be part of the reply. E.g. if a modifier was read
 * from the database (and stored in the EsReplyContext) which had no relation
 * to an offer, it won't be part of the reply.<p>
 * For the top-level objects of type Contact and Location you can choose if
 * only objects that are referenced (by IDREF in OOS or Contract) or if all
 * available Contact and Location will be part of the reply.
 */
public class EsReplyContext {

    /*
     * Some static strings to avoid the string creation
     */
    static final String EMPTY_STRING          = "";
    static final String BLUE_PORTFOLIO_FLAG   = "S";
    static final String RED_PORTFOLIO_FLAG    = "C";
    static final String PURPLE_PORTFOLIO_FLAG = "G";
    static final String BLUE_KEY_PREFIX       = "S-";
    static final String RED_KEY_PREFIX        = "C-";
    static final String PURPLE_KEY_PREFIX     = "G-";
    static final String CARE_PACK_KEY_PREFIX  = "CP_";
    static final String INTERNAL_PREFIX       = "INTERNAL_ID_";

    /*
     * The values of following maps are objects of classes generated by Castor.
     * The keys are classes from com.hp.es.service.replyGeneration.keys.*
     */
    private TreeMap<Key, Object> locationMap;
    private TreeMap<ObligationHeaderKey, ContractComplexType> allContractMap;     // keys=ObligationHeaderKey, values=ContractComplexType
    private TreeMap<ObligationHeaderKey, String> contractMap;        // keys=ObligationHeaderKey, values=key from uniqueContractMap
    private TreeMap<String, ContractComplexType> uniqueContractMap;  // keys=Strings (e.g. SAID), values=ContractComplexType
    private TreeMap<Key, Object> contactMap;
    private TreeMap<Key, Object> oosMap;
    private TreeMap<Key, Object> obligationHeaderMap;
    private TreeMap<Key, Object> serviceItemMap;
    private TreeMap<Key, Object> offerMap;
    private TreeMap<Key, Object> modifierMap;
    private TreeMap<Key, Object> deliverableMap;
    private TreeMap<Key, Object> delivModifierMap;
    private TreeMap<Key, Object> appliesToMap;
    private HashMap<String, String> aggProductIdMap;

    // The following two elements are for PoP
    private HashMap<Key, Object> serviceStartDateElgibilityMap;
    private HashMap<Key, Object> oosWtyStartDateMap;

    private org.exolab.castor.types.Date overallContractStartDate;
    private org.exolab.castor.types.Date overallContractEndDate;
    private boolean isActiveContractEntitlement;

    private int currentChunkSize;
    private int totalResultSize;
    private int uniqueId = 1;

    private OutputDetails outputDetails;
    /*
     * XMLIdGenerator used for ID/IDREF references in the XML schema
     */
    private XMLIdGenerator XMLIdGenerator;

    /**
     * public Constructor
     */
    public EsReplyContext(OutputDetails outputDetails) {

        this.outputDetails = outputDetails;

        locationMap = new TreeMap<Key, Object>();
        allContractMap = new TreeMap<ObligationHeaderKey, ContractComplexType>();
        contractMap = new TreeMap<ObligationHeaderKey, String>();
        uniqueContractMap = new TreeMap<String, ContractComplexType>();
        contactMap = new TreeMap<Key, Object>();
        oosMap = new TreeMap<Key, Object>();
        obligationHeaderMap = new TreeMap<Key, Object>();
        serviceItemMap = new TreeMap<Key, Object>();
        offerMap = new TreeMap<Key, Object>();
        modifierMap = new TreeMap<Key, Object>();
        deliverableMap = new TreeMap<Key, Object>();
        delivModifierMap = new TreeMap<Key, Object>();
        appliesToMap = new TreeMap<Key, Object>();
        aggProductIdMap = new HashMap<String, String>();
        serviceStartDateElgibilityMap = new HashMap<Key, Object>();
        oosWtyStartDateMap = new HashMap<Key, Object>();

        isActiveContractEntitlement = false;
        overallContractStartDate = null;
        overallContractEndDate = null;

        XMLIdGenerator = XMLIdGenerator.getXMLIdGenerator('C');
    }

    /**
     * @returns true if at least one active AppliesTo was found
     */
    public boolean isActiveContractEntitlement() {
        return isActiveContractEntitlement;
    }

    /**
     * @returns true if at least one active AppliesTo was found
     */
    public org.exolab.castor.types.Date getOverallContractStartDate() {
        return overallContractStartDate;
    }

    /**
     * @returns true if at least one active AppliesTo was found
     */
    public org.exolab.castor.types.Date getOverallContractEndDate() {
        return overallContractEndDate;
    }

    /**
     * This is a helper method to finalize the context. Since the current
     * implementation puts only object into the context that will be available
     * in the output, we have to merge everything.
     */
    public void mergeAndCalculateAll() {
        if (outputDetails.isIncludeModifiers()) {
            mergeDelivModifierToDeliverable();
            mergeModifierToOffer();
        }
        // Note: deliverables are need to calculate the unique deliverables
        //       they will be removed later
        if (outputDetails.isIncludeDeliverables() || outputDetails.isIncludeUniqueDeliverables()) {
            mergeDeliverableToOffer();
        }

        // Note: offers are need to calculate the unique offers
        //       they will be removed later
        if (outputDetails.isIncludeOffers() || outputDetails.isIncludeUniqueOffers() ) {
            mergeAppliesToToOffer();
            mergeOfferToContract();
        }

        mergeServiceItemToObligationHeader();
        mergeObligationHeaderToContract();

        if (outputDetails.isIncludeContacts()) {
            createContactRefs(true, outputDetails.isIncludeOOSes(), true);
        }

        if (outputDetails.isIncludeAddresses()) {
            createLocationRefs(true, outputDetails.isIncludeOOSes(), true);
        }

        if (outputDetails.isIncludeOffers() && outputDetails.isIncludeOOSes()) {
            createAppliesToOOSRefs();
        }

        if (outputDetails.isIncludeOffers()) {
            createServiceItemOfferRefs();
        }

        // unique offers and deliverables
        if (outputDetails.isIncludeUniqueOffers()) {
            createUniqueOffersAndDeliverables(
                        outputDetails.isIncludeUniqueDeliverables());

            // if only the unique offers or deliverables are included
            // remove source offer or deliverable references
            if (!outputDetails.isIncludeOffers()){
                Iterator<Key> it = obligationHeaderMap.keySet().iterator();
                while (it.hasNext()){
                    ObligationHeaderKey key = (ObligationHeaderKey)it.next();
                    ObligationHeader ohdr = (ObligationHeader)obligationHeaderMap.get(key);
                    ohdr.removeAllServiceItem();

                    ContractComplexType contr = getUniqueContract(key);
                    if (contr != null) {
                       contr.removeAllOffer();
                    }
                }
            }
            else {
                if (!outputDetails.isIncludeDeliverables()){
                    // offers are included but deliverable not
                    Iterator<Key> it = offerMap.keySet().iterator();
                    while (it.hasNext()){
                        ServiceKey key = (ServiceKey)it.next();
                        OfferComplexType offer = (OfferComplexType)offerMap.get(key);
                        offer.removeAllDeliverable();
                        offer.removeAllModifier();
                    }
                }
            }
        }

        calculateAggregatedValues();
    }

    /**
     * Method to access the Locations for the current reply. This method should
     * be called after all appropriate mergeXXX() and createXXXRefs() methods
     * were called.
     * @return Collection of LocationComplexType
     */
    public Collection<Object> getLocations() {
        return locationMap.values();
    }

    /**
     * Method to access the Contacts for the current reply. This method should
     * be called after all appropriate mergeXXX() and createXXXRefs() methods
     * were called.
     * @return Collection of ContactComplexType
     */
    public Collection<Object> getContacts() {
        return contactMap.values();
    }

    /**
     * @return ContactComplexType
     */
    public ContactComplexType getContact(ContactKey key) {
        return (ContactComplexType)contactMap.get(key);
    }

   /**
    * The addContract() method automatically combines contracts with the same
    * service agreement ID etc., i.e. if there are two contracts from the same
    * portfolio (R,B,P) with the same identifier, only the contract with the
    * newest CdoPublishedDate is stored.
    * This means the getContract(ObligationHeaderKey) not necessarily return
    * the same ContractComplexType that was added by the addContract() method.
    * @return the ContractComplexType indentified by the ObligationHeaderKey
    */
   public ContractComplexType getUniqueContract(ObligationHeaderKey key) {
    Object o = contractMap.get(key);
    if (o != null) {
        return uniqueContractMap.get(o);
    }
    return null;
   }

   /**
    * Contrary to the getUniqueContract() method, this method returns exactly
    * the same contract as stored for the current ObligationHeaderKey
    * @return the ContractComplexType indentified by the ObligationHeaderKey
    */
   public ContractComplexType getContract(ObligationHeaderKey key) {
       return allContractMap.get(key);
   }

    /**
     * Method to access the Contracts for the current reply. This method should
     * be called after all appropriate mergeXXX() and createXXXRefs() methods
     * were called.<p>
     * The method returns one ContractComplexType per service agreement ID!<ul>
     * <li>see also {@link getContract(ObligationHeaderKey)}
     * <li>see also {@link addContract(ObligationHeaderKey, ContractComplexType)}
     * </ul>
     * @return Collection of ContractComplexType
     */
    public Collection<ContractComplexType> getContracts() {
        return uniqueContractMap.values();
    }

    /**
     * @return the OOSComplexType indentified by the OOSKey
     */
    public OOSComplexType getOOS(OOSKey key) {
        return (OOSComplexType)oosMap.get(key);
    }

    /**
     * Method to access the OOSes for the current reply. This method should
     * be called after all appropriate mergeXXX() and createXXXRefs() methods
     * were called.
     * @return Collection of OOSComplexType
     */
    public Collection<Object> getOOSes() {
        return oosMap.values();
    }

    /**
     * Method to access the AppliesTo for the current reply. This method should
     * be called for PoP date alignment
     * were called.
     * @return Collection of AppliesTo
     */
    public TreeMap<Key, Object> getAppliesTo() {
        return appliesToMap;
    }

    /**
     * @return the String indentified by the ServiceKey
     */
    public String getSvcWtyStartDateEligibility(ServiceKey key) {
        return (String)serviceStartDateElgibilityMap.get(key);
    }

    /**
     * @return the org.exolab.castor.types.Date indentified by the OOSKey
     */
    public org.exolab.castor.types.Date getOosWarrantyStartDate(String key) {
    	//NPE HERE
        java.sql.Date result = (java.sql.Date)oosWtyStartDateMap.get(new OOSKey(key));
        if (result == null) {
            return null;
        }
        return (new org.exolab.castor.types.Date(new java.util.Date(result.getYear(), result.getMonth(), result.getDate())));
    }

    /**
     * Store the given object identified by the key.
     */
    public void addLocation(LocationKey key, LocationComplexType o) {
        o.setId(XMLIdGenerator.nextId());
        storeObject(key, o, locationMap);
    }


    /**
     * Store the relation between the "real" product ID and the mapped
     * product ID.
     */
    public void setAggProductId(String prodId, String aggProdId) {
        aggProductIdMap.put(prodId, aggProdId);
    }

    /**
     * Return a HashMap that cointains the mapping the "real" product ID
     * and the mapped product ID.
     */
    public HashMap<String, String> getAggProductIdMapping() {
        return aggProductIdMap;
    }

    /**
     * Store the given object identified by the key.<p>
     * <b>Note: </b> The keys are of the type ObligationHeaderKey not
     * ContractKey because several contracts might be combined to one single
     * contract (e.g. based on the svcAgreementID).
     */
    public void addContract(ObligationHeaderKey key, ContractComplexType o){

        if (key==null) {
            throw new NullPointerException("The key must never be null");
        }

        if (o==null) {
            throw new NullPointerException("The object must never be null");
        }

        // in order to be able to merge different types of contract
        // (blue, red, purple), different keys have to be created depending
        // on the portfolio
        String key2 = null;
        if (o.getPortfolioFlag()!=null) {
            if (o.getHPCarePackSerialNumber() != null){
               key2 = CARE_PACK_KEY_PREFIX + o.getHPCarePackSerialNumber()
               + '-' + o.getProductShipToCountryCode()
               + '-' + o.getPortfolioFlag();
            }
            else if (o.getPortfolioFlag().equals(PURPLE_PORTFOLIO_FLAG)) {
                key2 = PURPLE_KEY_PREFIX + o.getSvcAgreementID();
            }
            else if (o.getPortfolioFlag().equals(BLUE_PORTFOLIO_FLAG)) {
                key2 = BLUE_KEY_PREFIX + o.getOOSGroupID() + '-' + o.getDataEntrySite();
            }
            else if (o.getPortfolioFlag().equals(RED_PORTFOLIO_FLAG)) {
                // SRS 6.0 - There is no aggregation for red contracts.
                key2 = INTERNAL_PREFIX +  produceUniqueId();
            }
        }
        // no merge
        if (key2==null) {
            key2 = INTERNAL_PREFIX + produceUniqueId();
        }

        // The unique ContractComplexTypes are stored in the uniqueContractMap.
        // The contractMap contains a mapping between the ObligationHeaderKey
        // and the key in uniqueContractMap
        ContractComplexType tmp = uniqueContractMap.get(key2);
        if (tmp==null) {
            uniqueContractMap.put(key2, o);
        }
        else {
            // The newest contract is stored in the uniqueContractMap.
            // Note: The special handling flag is set to true if at least
            // one of the contracts has the flag set to true!!!
            String tmpPublishDate = tmp.getCdoPublishDate();
            String ctrPublishDate = o.getCdoPublishDate();

            if (ctrPublishDate==null || ctrPublishDate.compareTo(tmpPublishDate)>0 ) {
                // if newer than replace
                uniqueContractMap.put(key2, o);
                o.setSpecialHandling(o.getSpecialHandling() || tmp.getSpecialHandling());
            }
            else {
                tmp.setSpecialHandling(o.getSpecialHandling() || tmp.getSpecialHandling());
            }
        }

        contractMap.put(key, key2);
        allContractMap.put(key, o);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addContact(ContactKey key, ContactComplexType o) {
        o.setId(XMLIdGenerator.nextId());
        storeObject(key, o, contactMap);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addOOS(OOSKey key, OOSComplexType o) {
        o.setId(XMLIdGenerator.nextId());
        storeObject(key, o, oosMap);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addObligationHeader(ObligationHeaderKey key, ObligationHeader o) {
        storeObject(key, o, obligationHeaderMap);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addServiceItem(ServiceKey key, ServiceItem o) {
        storeObject(key, o, serviceItemMap);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addOffer(ServiceKey key, OfferComplexType o) {
        o.setId(XMLIdGenerator.nextId());
        storeObject(key, o, offerMap);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addModifier(ModifierKey key, ModifierComplexType o) {
        storeObject(key, o, modifierMap);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addDeliverable(DeliverableKey key, Deliverable o) {
        storeObject(key, o, deliverableMap);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addDelivModifier(DelivModifierKey key, ModifierComplexType o) {
        storeObject(key, o, delivModifierMap);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addAppliesTo(AppliesToKey key, AppliesTo o) {
        storeObject(key, o, appliesToMap);
    }

    /**
     * Store the given object identified by the key.
     */
    public void addSvcWtyStartDateEligibility(ServiceKey key, String s) {
        if (s != null) {
            storeObject(key, s, serviceStartDateElgibilityMap);
        } else {
            storeObject(key, "F", serviceStartDateElgibilityMap);
        }
    }

    /**
     * Store the given object identified by the key.
     */
    public void addOosWarrantyStartDate(OOSKey key, java.sql.Date d) {
        if (d != null) {
            storeObject(key, d, oosWtyStartDateMap);
        }
    }

    /**
     * Just put the key-object pair into the map.
     */
    private void storeObject(Key key, Object o, Map<Key, Object> target) {
        if (key==null) {
            throw new NullPointerException("The key must never be null");
        }

        if (o==null) {
            throw new NullPointerException("The object must never be null");
        }
        target.put(key, o);
    }

    /**
     * Assign DelivModifier to Deliverable
     */
    void mergeDelivModifierToDeliverable() {
        Iterator<Key> it = delivModifierMap.keySet().iterator();
        while (it.hasNext()) {
            DelivModifierKey key = (DelivModifierKey)it.next();
            DeliverableKey parent = (DeliverableKey)key.getParent();
            Deliverable o = (Deliverable)deliverableMap.get(parent);
            if (o != null) {
                o.addDelivModifier((ModifierComplexType)delivModifierMap.get(key));
            }
        }
    }

    /**
     * Assign Deliverable to Offer
     */
    void mergeDeliverableToOffer() {
        Iterator<Key> it = deliverableMap.keySet().iterator();
        while (it.hasNext()) {
            DeliverableKey key = (DeliverableKey)it.next();
            ServiceKey parent = (ServiceKey)key.getParent();
            OfferComplexType o = (OfferComplexType)offerMap.get(parent);
            if (o!=null) {
                o.addDeliverable((Deliverable)deliverableMap.get(key));
            }
        }
    }

    /**
     * Assign Modifier to Offer
     */
    void mergeModifierToOffer() {
        Iterator<Key> it = modifierMap.keySet().iterator();
        while (it.hasNext()) {
            ModifierKey key = (ModifierKey)it.next();
            ServiceKey parent = (ServiceKey)key.getParent();
            OfferComplexType o = (OfferComplexType)offerMap.get(parent);
            if (o!=null) {
                o.addModifier((ModifierComplexType)modifierMap.get(key));
            }
        }
    }

    /**
     * Assign AppliesTo to Offer
     */
    void mergeAppliesToToOffer() {
        Iterator<Key> it = appliesToMap.keySet().iterator();
        while (it.hasNext()) {
            AppliesToKey key = (AppliesToKey)it.next();
            ServiceKey parent =(ServiceKey)key.getParent();
            OfferComplexType o = (OfferComplexType)offerMap.get(parent);
            if (o!=null) {
                o.addAppliesTo((AppliesTo)appliesToMap.get(key));
            }
        }
    }

    /**
     * Assign Offer to Contract
     */
    void mergeOfferToContract() {
        Iterator<Key> it = offerMap.keySet().iterator();
        while (it.hasNext()) {
            ServiceKey key = (ServiceKey)it.next();
            // note: key is ObligationHeaderKey not ContractKey
            ObligationHeaderKey parent = (ObligationHeaderKey)key.getParent();
            ContractComplexType o = getUniqueContract(parent);
            if (o!=null) {
                o.addOffer((OfferComplexType)offerMap.get(key));
            }
        }
    }

    /**
     * Assign ObligationHeader to Contract
     */
    void mergeObligationHeaderToContract() {
        Iterator<Key> it = obligationHeaderMap.keySet().iterator();
        while (it.hasNext()) {
            ObligationHeaderKey key = (ObligationHeaderKey)it.next();
            ObligationHeaderKey parent = key;
            ContractComplexType o = getUniqueContract(parent);
            if (o!=null) {
                o.addObligationHeader((ObligationHeader)obligationHeaderMap.get(key));
            }
        }
    }

    /**
     * Assign ServiceItem to ObligationHeader
     */
    void mergeServiceItemToObligationHeader() {
        Iterator<Key> it = serviceItemMap.keySet().iterator();
        while (it.hasNext()) {
            ServiceKey key = (ServiceKey)it.next();
            ObligationHeaderKey parent = (ObligationHeaderKey)key.getParent();
            ObligationHeader o = (ObligationHeader)obligationHeaderMap.get(parent);
            if (o!=null) {
                o.addServiceItem((ServiceItem)serviceItemMap.get(key));
            }
        }
    }


    /**
     * This method fills the IDs for the locations and the location-IDREFs for
     * OOS and contracts. This method must only be called if the Locations
     * will be part of the EsReply!
     * @param removeUnusedLocations 'true' if the location should contain only
     *                              Locations that were references somewhere else
     * @param createOOSRefs 'true' if the reference should be created for OOSes
     * @param createContractRefs 'true' if the reference should be created for
     *                              Contract
     */
    void createLocationRefs(boolean removeUnusedLocations,
                            boolean createOOSRefs,
                            boolean createContractRefs) {

        TreeMap<Key, Object> map = new TreeMap<Key, Object>();
        if (createContractRefs) {
            // referenced from contract
            for (Iterator<ContractComplexType> it=uniqueContractMap.values().iterator(); it.hasNext();) {
                ContractComplexType c = it.next();
                c.setSoldToCustomerRef  ( addLocation(map, c.getSoldToCustomerID()) );
                c.setSWShipToCustomerRef( addLocation(map, c.getSWShipToCustomerID()) );
                c.setProductShipToCustomerRef( addLocation(map, c.getProductShipToCustomerID()) );
                c.setPSPCustomerRef(addLocation(map, c.getPSPCustomerID()));
                c.setOrderingPartyCustomerRef( addLocation(map, c.getOrderingPartyCustomerID()));
            }
        }

        if (createOOSRefs) {
            // referenced from OOS
            for (Iterator<Object> it=oosMap.values().iterator(); it.hasNext();) {
                OOSComplexType c = (OOSComplexType)it.next();
                c.setSWShipToCustomerRef( addLocation(map, c.getSWShipToCustomerID()) );
                c.setProductShipToCustomerRef( addLocation(map, c.getProductShipToCustomerID()) );
            }
        }

        // just overwrite the locationMap
        if (removeUnusedLocations) {
            locationMap = map;
        }
    }

    /**
     * Helper method that inserts the Location identified by the given id into
     * the map and returns the current Location object
     */
    private LocationComplexType addLocation(Map<Key, Object> map, String id) {
        if (id==null) {
            return null;
        }
        LocationKey key = new LocationKey(id);
        LocationComplexType location = (LocationComplexType)locationMap.get(key);
        if (location!=null) {
            map.put(key, location);
        }
        return location;
    }

    /**
     * This method fills the IDs for the locations and the location-IDREFs for
     * OOS and contracts.
     * @param removeUnusedLocations 'true' if the location should contain only
     *                              Locations that were references somewhere else
     * @param createOOSRefs 'true' if the reference should be created for OOSes
     * @param createContractRefs 'true' if the reference should be created for
     *                              Contract
     */
    void createContactRefs( boolean removeUnusedContact,
                            boolean createOOSRefs,
                            boolean createContractRefs) {

        TreeMap<Key, Object> map = new TreeMap<Key, Object>();
        if (createContractRefs) {
            // referenced from contract
            for (Iterator<ContractComplexType> it=uniqueContractMap.values().iterator(); it.hasNext();) {
                ContractComplexType c = it.next();
                c.setSystemMgrPersonRef( addContact(map, c.getSystemMgrPersonID()) );
                c.setSWShipToPersonRef ( addContact(map, c.getSWShipToPersonID()) );
                c.setHWShipToPersonRef ( addContact(map, c.getHWShipToPersonID()) );
                c.setPSPCustomerRef(addContact(map, c.getPSPCustomerID()) );
                c.setHPAdminPersonRef ( addContact(map, c.getHPAdminPersonID()) );
                c.setOrdererPersonRef( addContact(map, c.getOrdererPersonID()));
            }
        }

        if (createOOSRefs) {
            // referenced from OOS
            for (Iterator<Object> it=oosMap.values().iterator(); it.hasNext();) {
                OOSComplexType c = (OOSComplexType)it.next();
                c.setSystemMgrPersonRef( addContact(map, c.getSystemMgrPersonID()) );
                c.setSWShipToPersonRef ( addContact(map, c.getSWShipToPersonID()) );
                c.setHWShipToPersonRef ( addContact(map, c.getHWShipToPersonID()) );
            }
        }

        // just overwrite the locationMap
        if (removeUnusedContact) {
            contactMap = map;
        }
    }

    /**
     * Helper method that inserts the Contact identified by the given id into
     * the map and returns the current Contact object
     */
    private ContactComplexType addContact(Map<Key, Object> map, String id) {
        if (id==null) {
            return null;
        }
        ContactKey key = new ContactKey(id);
        ContactComplexType contact = (ContactComplexType)contactMap.get(key);
        if (contact!=null) {
            map.put(key, contact);
        }
        return contact;
    }

    /**
     * Create references (ID/IDREF in XML schema) for AppliesTo and OOS.
     * <b>Note:</b> Currently one AppliesTo will contain 0 or 1 OOSes
     */
    void createAppliesToOOSRefs() {
        Iterator<Key> it = appliesToMap.keySet().iterator();
        while (it.hasNext()) {
            AppliesToKey key = (AppliesToKey)it.next();
            String oosKeyString = key.getOOSKey();
            if (oosKeyString != null) {
                OOSKey oosKey = new OOSKey(oosKeyString);
                AppliesTo val1 = (AppliesTo) appliesToMap.get(key);
                OOSComplexType val2 = (OOSComplexType) oosMap.get(oosKey);
                if (val1 != null && val2 != null) {
                    val1.setOOSRef(val2);
                }
            }
        }
    }

    /**
     * Create references (ID/IDREF in XML schema) for offers and service items.
     * <b>Note:</b> Currently this is a one-to-one relation
     */
    void createServiceItemOfferRefs() {
        Iterator<Key> it = serviceItemMap.keySet().iterator();
        while (it.hasNext()) {
            ServiceKey key = (ServiceKey)it.next();
            ServiceItem      val1 = (ServiceItem)serviceItemMap.get(key);
            OfferComplexType val2 = (OfferComplexType)offerMap.get(key);
            if (val1!=null && val2!=null) {
                val1.setOfferRef(val2);
            }
        }
    }

    /**
     * Following values are calculated:
     * <table>
     * <tr><td>global</td><td>overallContractStartDate</td></tr>
     * <tr><td>global</td><td>overallContractEndDate</td></tr>
     * <tr><td>Contract</td><td>ActiveContractEntitlement</td></tr>
     * <tr><td>Contract</td><td>HeaderStartDate</td></tr>
     * <tr><td>Contract</td><td>HeaderEndDate</td></tr>
     * <tr><td>Contract</td><td>CCRN</td></tr>
     * </table>
     */
    public void calculateAggregatedValues() {
        // used to calculate the max header end date
        boolean firstContract = true;

        // iterate over all contracts that already have the offers assigned
        for (Iterator<ContractComplexType> it=getContracts().iterator(); it.hasNext(); ) {
            ContractComplexType c = it.next();
            org.exolab.castor.types.Date startDate = null;
            org.exolab.castor.types.Date endDate = null;
            HashSet<String> ccrn = new HashSet<String>();
            boolean isActiveContract = false;

            Enumeration<?> obligationHeaderEnum = c.enumerateObligationHeader();
            if (obligationHeaderEnum!=null) {
                boolean firstObligation = true;
                while (obligationHeaderEnum.hasMoreElements()) {
                    ObligationHeader oh = (ObligationHeader)
                                    obligationHeaderEnum.nextElement();
                    // min start date
                    startDate = minDate(startDate, oh.getHeaderStartDate());

                    // max end date
                    // (will be null if at least one header end date is null)
                    if (firstObligation) {
                        endDate = oh.getHeaderEndDate();
                        firstObligation = false;
                    }
                    else {
                        endDate = maxDate(endDate, oh.getHeaderEndDate());
                    }

                    // CCRN
                    if (oh.getCCRN()!=null) {
                        ccrn.add(oh.getCCRN());
                    }

                    // isActiveContract: Shows whether any of the underlying
                    // Obligationheaders is active
                    isActiveContract = isActiveContract || oh.getActiveObligation();

                    // global "active entitlement flag" for all contracts:
                    // Shows whether any of the underlying contracts is active
                    isActiveContractEntitlement = isActiveContractEntitlement ||
                                                  isActiveContract;
                }
            }

            c.setActiveContractEntitlement(isActiveContract);
            c.setHeaderStartDate(startDate);
            c.setHeaderEndDate(endDate);
            // check if CCRN is unique accross obligation header
            if (ccrn.size()==1) {
                c.setCCRN(ccrn.iterator().next());
            }

            // overallContractStartDate/overallContractEndDate
            overallContractStartDate = minDate(overallContractStartDate, startDate);
            if (firstContract) {
                overallContractEndDate = endDate;
                firstContract = false;
            }
            else {
                overallContractEndDate = maxDate(overallContractEndDate, endDate);
            }
        }
    }

    /**
     * Assign UniqueDeliverables to Contract. This method requires that the
     * mergeOffersToContract() was called before!!!
     */
    void createUniqueOffersAndDeliverables(boolean calculateUniqueDeliverables) {
        // iterate over all contracts that already have the offers assigned
        for (Iterator<ContractComplexType> it=getContracts().iterator(); it.hasNext(); ) {
            ContractComplexType c = it.next();
            Enumeration<?> allOffersEnum = c.enumerateOffer();
            if (allOffersEnum!=null) {
                TreeMap<String, UniqueOffer> uniqueOffers = new TreeMap<String, UniqueOffer>();
                TreeMap<String, TreeMap<String, UniqueDeliverable>> uniqueDeliverablesForOfferCode = new TreeMap<String, TreeMap<String, UniqueDeliverable>>();

                while (allOffersEnum.hasMoreElements()) {
                    OfferComplexType o = (OfferComplexType)allOffersEnum.nextElement();
                    UniqueOffer tmp = uniqueOffers.get(o.getOfferCode());
                    if (tmp==null) {
                        // it is the first offer for that offer code
                        tmp = new UniqueOffer();
                        tmp.setOfferCode(o.getOfferCode());
                        tmp.setOfferDescription(o.getOfferDescription());
                        tmp.setSvcProductType(o.getSvcProductType());
                        tmp.setServiceStartDate(getServiceStartDate(null, o));
                        tmp.setServiceEndDate(getServiceEndDate(null, o));
                        uniqueOffers.put(o.getOfferCode(), tmp);
                    }
                    else {
                        // take the existin unique offer and update the dates
                        tmp.setServiceStartDate(getServiceStartDate(tmp, o));
                        tmp.setServiceEndDate(getServiceEndDate(tmp, o));
                    }

                    // now create the unique deliverables for the offer code
                    if (calculateUniqueDeliverables) {
                        TreeMap<String, UniqueDeliverable> uniqueDeliverables = uniqueDeliverablesForOfferCode.get(o.getOfferCode());
                        if (uniqueDeliverables==null) {
                            uniqueDeliverables = new TreeMap<String, UniqueDeliverable>();
                            uniqueDeliverablesForOfferCode.put(o.getOfferCode(),
                                                               uniqueDeliverables);
                        }

                        Enumeration<?> delivEnum = o.enumerateDeliverable();
                        while (delivEnum.hasMoreElements()) {
                            Deliverable d = (Deliverable)delivEnum.nextElement();
                            UniqueDeliverable ud = uniqueDeliverables.get(d.getDelivCode());
                            if (ud==null) {
                                ud = new UniqueDeliverable();
                                // not set according to definition in SRS
                                // ud.setAvailableQuantity(d.getAvailableQuantity());
                                ud.setDelivCode(d.getDelivCode());
                                ud.setDelivName(d.getDelivName());
                                ud.setDelivValue(d.getDelivValue());
                                uniqueDeliverables.put(ud.getDelivCode(), ud);
                            }
                        }
                    }
                }

                // now put the unique offeres and deliverables into the contract
                for (Iterator<UniqueOffer> itUo=uniqueOffers.values().iterator(); itUo.hasNext();) {
                    UniqueOffer uo = itUo.next();
                    TreeMap<?, ?> uniqueDeliverables = uniqueDeliverablesForOfferCode.get(uo.getOfferCode());
                    if (uniqueDeliverables!=null) {
                        for (Iterator<?> itUd=uniqueDeliverables.values().iterator(); itUd.hasNext();) {
                            uo.addUniqueDeliverable((UniqueDeliverable)itUd.next());
                        }
                    }
                    c.addUniqueOffer(uo);
                }
            }
        }
    }

    /**
     * @return the earlies service start date from all AppliesTo from the
     * offer or from the given unique offer object
     */
    private org.exolab.castor.types.Date getServiceStartDate(
                        UniqueOffer uniqueOffer, OfferComplexType offer) {
        org.exolab.castor.types.Date date = null;
        // find the earlies start date from all appliesTo of this offer
        if (offer!=null && offer.enumerateAppliesTo()!=null) {
            Enumeration<?> enumeration = offer.enumerateAppliesTo();
            while (enumeration.hasMoreElements()) {
                AppliesTo a = (AppliesTo)enumeration.nextElement();
                if (a.getStartDate()!=null) {
                    if (date==null || date.compareTo(a.getStartDate())==
                                    org.exolab.castor.types.DateTimeBase.GREATER_THAN) {
                        date = a.getStartDate();
                    }
                }
            }
        }

        if (uniqueOffer!=null) {
            return minDate(date, uniqueOffer.getServiceStartDate());
        }
        return date;
    }


    /**
     * @return the latest service end date from all AppliesTo from the
     * offer or from the given unique offer object
     */
    private org.exolab.castor.types.Date getServiceEndDate(
                        UniqueOffer uniqueOffer, OfferComplexType offer) {
        org.exolab.castor.types.Date date = null;
        // find the earlies end date from all appliesTo of this offer
        if (offer!=null && offer.enumerateAppliesTo()!=null) {
            Enumeration<?> enumeration = offer.enumerateAppliesTo();
            while (enumeration.hasMoreElements()) {
                AppliesTo a = (AppliesTo)enumeration.nextElement();
                if (a.getEndDate()!=null) {
                    if (date==null || date.compareTo(a.getEndDate())==
                                    org.exolab.castor.types.DateTimeBase.LESS_THAN) {
                        date = a.getEndDate();
                    }
                }
            }
        }

        if (uniqueOffer!=null) {
            return maxDate(date, uniqueOffer.getServiceEndDate());
        }
        return date;
    }

    private org.exolab.castor.types.Date minDate(
        org.exolab.castor.types.Date date1, org.exolab.castor.types.Date date2) {
        if (date1==null) {
            return date2;
        }
        if (date2==null) {
            return date1;
        }
        if (date1.compareTo(date2)==org.exolab.castor.types.DateTimeBase.LESS_THAN) {
            return date1;
        }
        return date2;
    }

    /**
     *
     * @param date1
     * @param date2
     * @return null if date1 or date2 is null; otherwise return the max
     *               of both dates
     */
    private org.exolab.castor.types.Date maxDate(
        org.exolab.castor.types.Date date1, org.exolab.castor.types.Date date2) {
        if (date1==null || date2==null) {
            return null;
        }
        if (date1.compareTo(date2)==org.exolab.castor.types.DateTimeBase.GREATER_THAN) {
            return date1;
        }
        return date2;
    }

    /**
     * @return amount of obligations returned by the last DB access
     *         this feature will be used only
     *         within the getAssociatedContractsOperation
     */
    public int getCurrentChunkSize() {
        return currentChunkSize;
    }

    /**
     * @param i amount of obligations returned by the last DB access
     */
    public void setCurrentChunkSize(int i) {
        currentChunkSize = i;
    }

    /**
     * @return amount of obligations found by the last DB access
     *         that fits the search criteria.
     *         This feature will be used only
     *         within the getAssociatedContractsOperation
     */
    public int getTotalResultSize() {
        return totalResultSize;
    }

    /**
     * @param i amount of obligations found by the last DB access
     *         that fits the search criteria.
     */
    public void setTotalResultSize(int i) {
        totalResultSize = i;
    }

    /**
     * return a "unique" ID which is used to distinguish contracts that
     * should not be merged together.
     */
    private int produceUniqueId() {
        return uniqueId++;
    }

    /**
     * return first OOS with ProductID when we meet multiple OOSs
     * if no OOS has ProductID, we return the first OOS
     * to make the return result constant, we sort the OOSes first
     * this logic is new since 8.2.0
     */
    public OOSComplexType getFirstOOS(OOSComplexType[] OOSes) {
        OOSComplexType firstOOS = null;
        for(int i = 0; i < OOSes.length - 1; i ++) {
            for(int j = i + 1; j < OOSes.length; j++) {
                if (OOSes[i].getOOSKey() != null && OOSes[j].getOOSKey() != null &&
                    OOSes[i].getOOSKey().compareTo(OOSes[j].getOOSKey()) > 0) {
                    OOSComplexType tempOOS = OOSes[i];
                    OOSes[i] = OOSes[j];
                    OOSes[j] = tempOOS;
                }
            }
        }
        for(int i = 0; i < OOSes.length; i ++) {
            if (OOSes[i].getProduct() != null) {
                if (OOSes[i].getProduct().getProductID() != null &&
                    !"".equals(OOSes[i].getProduct().getProductID())) {
                    firstOOS = OOSes[i];
                    break;
                }
            }
        }
        if (firstOOS == null && OOSes.length > 0 && OOSes[0] != null) {
            firstOOS = OOSes[0];
        }
        return firstOOS;
    }

	public void mergeWith(EsReplyContext replyContext) {

	    locationMap.putAll(replyContext.locationMap);
	    allContractMap.putAll(replyContext.allContractMap);;     // keys=ObligationHeaderKey, values=ContractComplexType
	    contractMap.putAll(replyContext.contractMap);        // keys=ObligationHeaderKey, values=key from uniqueContractMap
	    uniqueContractMap.putAll(replyContext.uniqueContractMap); ;  // keys=Strings (e.g. SAID), values=ContractComplexType
	    contactMap.putAll(replyContext.contactMap); ;
	    oosMap.putAll(replyContext.oosMap); ;
	    obligationHeaderMap.putAll(replyContext.obligationHeaderMap);
	    serviceItemMap.putAll(replyContext.serviceItemMap);
	    offerMap.putAll(replyContext.offerMap);
	    modifierMap.putAll(replyContext.modifierMap);
	    deliverableMap.putAll(replyContext.deliverableMap);
	    delivModifierMap.putAll(replyContext.delivModifierMap);
	    appliesToMap.putAll(replyContext.appliesToMap);
	    aggProductIdMap.putAll(replyContext.aggProductIdMap);

	    // The following two elements are for PoP
	    serviceStartDateElgibilityMap.putAll(replyContext.serviceStartDateElgibilityMap);
	    oosWtyStartDateMap.putAll(replyContext.oosWtyStartDateMap);
	    Date d1 = DateHelper.mapCastorDate2Java(replyContext.overallContractStartDate);
	    Date d2 = DateHelper.mapCastorDate2Java(overallContractStartDate);
	    
	    if(DateHelper.isGreater(d1,d2)) {
	    	overallContractStartDate =replyContext.overallContractStartDate; 
	    }
	 //   if(overallContractStartDate.
	    
	    if(!isActiveContractEntitlement && replyContext.isActiveContractEntitlement) {
	    	isActiveContractEntitlement = replyContext.isActiveContractEntitlement;
	    }

	    /*No merge of above
	     * 

	    private int currentChunkSize;
	    private int totalResultSize;
	    private int uniqueId = 1;		
	     */		
	}
	public void destroy() {
		   ESLog.debug("Destroy all, we finished using Context");
		   if(locationMap!=null) {
			   locationMap.clear();
			   locationMap=null;
		   }
		   if(allContractMap!=null) {
			   allContractMap.clear();
			   allContractMap=null;
		   }
		   if(contractMap!=null) {
			   contractMap.clear();
			   contractMap=null;
		   }
		   if(uniqueContractMap!=null) {
			   uniqueContractMap.clear();
			   uniqueContractMap=null;
		   }
		   if(contactMap!=null) {
			   contactMap.clear();
			   contactMap=null;
		   }
		   if(oosMap!=null) {
			   oosMap.clear();
			   oosMap=null;
		   }
		   if(obligationHeaderMap!=null) {
			   obligationHeaderMap.clear();
			   obligationHeaderMap=null;
		   }
		   if(serviceItemMap!=null) {
			   serviceItemMap.clear();
			   serviceItemMap=null;
		   }
		   if(offerMap!=null) {
			   offerMap.clear();
			   offerMap=null;
		   }
		   if(modifierMap!=null) {
			   modifierMap.clear();
			   modifierMap=null;
		   }
		   if(deliverableMap!=null) {
			   deliverableMap.clear();
			   deliverableMap=null;
		   }
		   if(delivModifierMap!=null) {
			   delivModifierMap.clear();
			   delivModifierMap=null;
		   }
		   if(appliesToMap!=null) {
			   appliesToMap.clear();
			   appliesToMap=null;
		   }
		   if(aggProductIdMap!=null) {
			   aggProductIdMap.clear();
			   aggProductIdMap=null;
		   }

		   if(oosWtyStartDateMap!=null) {
			   oosWtyStartDateMap.clear();
			   oosWtyStartDateMap=null;
		   }
			

		   overallContractStartDate= null;
		   overallContractEndDate = null;
		   ESLog.debug("Done with Destroy all, we finished using Context");
	}

}
