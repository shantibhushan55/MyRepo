/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/combinedEntitlement/reply/ReplyCreator.java 1.20 2004-09-27 17:56:57+02 stefsobe Exp $
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
 * $Log: ReplyCreator.java,v $
 * Revision 1.20  2004-09-27 17:56:57+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.19  2004-07-22 10:16:13+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * call method from DateHelper to align PoP
 *
 * Revision 1.18  2004-07-22 07:49:58+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Use GMT to calculate the PoP alignment
 *
 * Revision 1.17  2004-07-20 08:36:07+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Do some optimization of the code. The field originalEndDate may be null.
 *
 * Revision 1.16  2004-07-16 10:05:11+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Prevent wtyStartDateFromCDO and originalStartDate and originalEndDate from Null
 *
 * Revision 1.15  2004-07-16 09:04:22+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * When the warranty start date of warranty entitlement is not available, use pop from es request
 *
 * Revision 1.14  2004-07-09 03:41:29+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * PoP rule adjust:

 * 1. Warranty entitlement may or may not have been requested

 * 2. recalculatedWarrantyStartDate now from two sources
 *
 * Revision 1.13  2004-07-02 11:52:35+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Add a method "popDateAlignment"  to do PoP logic
 *
 * Revision 1.12  2004-05-08 04:41:53+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.11  2004-05-05 15:40:38+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.10  2004-02-16 15:33:23+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.9  2004-01-29 18:06:22+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.8  2003-08-04 16:50:46+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.7  2003-07-16 19:27:20+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * replaced error id literals w/their ErrorFactory aliases; deduped some string literals
 *
 * Revision 1.6  2003-07-11 19:03:33+02  lbednari
 * Author: lbednari@bbnnaid399.bbn.hp.com ()
 * renamed mergeErrors and rewrote a bit
 *
 * Revision 1.5  2003-07-10 18:33:39+02  lbednari
 * Author: lbednari@dhcp-15-197-235-62.bbn.hp.com ()
 * - removed special handling of 202 in error merging
 *
 * Revision 1.4  2003-06-24 18:17:20+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * added check for IncludeOffer WITS 523
 *
 * Revision 1.3  2003-06-24 13:50:04+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * added new business logic for checkFlagsForWarranty()

 * WITS 518
 *
 * Revision 1.2  2003-06-04 19:25:49+02  lbednari
 * Author: lbednari@bbnnaid28.bbn.hp.com ()
 * using new constants for error ids
 *
 * Revision 1.1  2003-06-04 15:12:40+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * Initial revision
 *
 *
 */
package com.hp.es.service.combinedEntitlement.reply;

import org.exolab.castor.types.Date;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.keys.ServiceKey;
import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EntitlementByXXRequestComplexType;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.ServiceItem;
import com.hp.es.xml.service.Warnings;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.types.ErrorLevelType;
import com.hp.sif.SifException;

abstract public class ReplyCreator {

    protected EsRequestComplexType _combinedRequest;
    protected RequesterReply _warrantyReply;
    protected RequesterReply _contractReply;
    boolean _includeOffers;
    boolean _includeDeliverables;
    boolean _includeModifiers;

    protected EsReplyContext _ctx;

    protected String WARRANTY_SOURCE = "Source WARRANTY ";
    protected String CONTRACT_SOURCE = "Source CONTRACT ";

    public ReplyCreator(EsRequestComplexType combinedRequest,
                        boolean includeOffers, boolean includeDeliverables,
                        boolean includeModifiers) {
        _includeOffers = includeOffers;
        _includeDeliverables = includeDeliverables;
        _includeModifiers = includeModifiers;
        _combinedRequest = combinedRequest;
        _warrantyReply = null;
        _contractReply = null;
        _warrantyReply = new NullRequesterReply();//modified by WangLong
        _contractReply = new NullRequesterReply();//modified by WangLong
        _ctx = null;
    }


    /**
     * Creates an EsReply depending on the variables
     * - _contractReply
     * - _contractReply
     *
     * @return EsReply
     * @throws SifException
     */
    abstract public EsReply create() throws SifException;

    /**
     * Does the merge of the reply in case that we have NO unit lists in the
     * replies. The replies could contain errors.
     * @return EsReply
     */
    abstract protected EsReply doStandardMerge() throws SifException;

    /**
     * Checks whether all variables are null and throws an exception in this
     * case
     * @throws SifException
     */
    protected void nullCheck() throws SifException {
        ESLog.debug("Enter");
        if(_warrantyReply.isNull() && _contractReply.isNull() ) {
            // All are null, throw an exception
            ESLog.debug("All are null");
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR);
        }
        ESLog.debug("Exit");
    }

    /**
     * Check which exception has the higher priority (the lower error id) and
     * return the exception
     * @return SifException
     */
    protected SifException doExceptionMerge() {
        ESLog.debug("Enter");
        SifException wtyException = _warrantyReply.getException();
        SifException conException = _contractReply.getException();
        // make sure that we don't return the DATA_NOT_FOUND exception, only if both
        // exceptions are not found
        // CASE - both have DATA_NOT_FOUND
        if((Integer.parseInt(wtyException.getErrorID()) == ErrorFactory.id300_NO_DATA_FOUND) &&
            (Integer.parseInt(conException.getErrorID()) == ErrorFactory.id300_NO_DATA_FOUND)) {
            wtyException.appendErrorText(conException.getErrorText());
            ESLog.debug("Both exceptions are data not found");
            return wtyException;
        }
        // CASE - warranty has DATA_NOT_FOUND
        if(Integer.parseInt(wtyException.getErrorID()) == ErrorFactory.id300_NO_DATA_FOUND) {
            ESLog.debug("Warranty exception is data not found -> Using contract exception");
            return conException;
        }

        // CASE - contract has DATA_NOT_FOUND
        if(Integer.parseInt(conException.getErrorID()) == ErrorFactory.id300_NO_DATA_FOUND) {
            ESLog.debug("Contract exception is data not found -> Using warranty exception");
            return wtyException;
        }

        // CASE - none of them have DATA_NOT_FOUND => Take the lower error id
        if(Integer.parseInt(wtyException.getErrorID()) <=
            Integer.parseInt(conException.getErrorID())) {
            ESLog.debug("Use warranty exception");
            if (Integer.parseInt(wtyException.getErrorID()) ==
                Integer.parseInt(conException.getErrorID())) {
                wtyException.appendErrorText(" | " + conException.getErrorText());
            }
            return wtyException;
        }

        ESLog.debug("Use contract exception");
        return conException;
    }

    /**
     * merges the warnings from 'from' reply to 'to' reply
     * @param from
     * @param to
     */
    protected void addWarnings(EsReply source, EsReply target) {

        Warnings sourceWarnings = source.getEsHeader().getWarnings();
        Warnings targetWarnings = target.getEsHeader().getWarnings();

        if(sourceWarnings != null) {
            if(targetWarnings == null) {
                // if we don't have 'to' warning we simply move all warnings from 'from'
                target.getEsHeader().setWarnings(sourceWarnings);
            }
            else {
                // if we have already have warnings on the target we add warnings from source
                for(int k = 0; k < sourceWarnings.getEIAErrorCount(); k ++) {
                    targetWarnings.addEIAError(sourceWarnings.getEIAError(k));
                }
            }
        }
    }

    /**
     * Converts and SifException into an EIAError and adds it to the combined
     * reply header. Depending on the includeNotFound flag, the not found errors
     * are included or not.
     * @param reply
     * @param ee
     * @param includeNotFound
     */
    protected void addErrorToReply(EsReply reply, SifException ee, boolean includeNotFound) {
        ESLog.debug("Enter addErrorToReply::");
        if(!includeNotFound) {
            // check if the exception is a DATA_NOT_FOUND. In this case we don't
            // add it to the reply
            if(Integer.parseInt(ee.getErrorID()) == ErrorFactory.id300_NO_DATA_FOUND) {
                ESLog.debug("Exception is a NO DATA FOUND -> we don't add it to the reply");
                return;
            }

            // check if we have an 202 exception from warranty which is basically
            // a 300 NO DATA FOUND exception
            // Since we add the source information to the datapayload we can always
            // assume that we have a filled datapayload field
            if((ee.getDataPayLoad().indexOf("WARRANTY") != -1) &&
                (Integer.parseInt(ee.getErrorID()) == ErrorFactory.id202_PRODUCT_NR_NOT_PROVIDED)) {
                ESLog.debug("Warranty Exception is a 202, which is seen as a NO DATA FOUND -> we don't add it to the reply");
                return;
            }
        }
        // check if we have a warnings object
        if(reply.getEsHeader().getWarnings() == null) {
            reply.getEsHeader().setWarnings(new Warnings());
        }
        // fill a new EIAError
        EIAError error = new EIAError();
        error.setDataPayLoad(ee.getDataPayLoad());
        error.setErrorClass(ee.getErrorClass());
        error.setErrorID(ee.getErrorID() == null ? "NOTSET" : ee.getErrorID());
        error.setErrorLevel(ErrorLevelType.valueOf(ee.getErrorLevel()));
        error.setErrorText(ee.getErrorText());
        error.setTimeStamp(ee.getTimeStamp());
        // add the error
        reply.getEsHeader().getWarnings().addEIAError(error);
        ESLog.debug("Exit");
    }

    /**
     * Checks for warnings in the reply or exception and add the source to the
     * data payload
     */
    protected void addSourceToWarnings() {
        ESLog.debug("Enter addSourceToWarnings()::");
        // check warranty
        if(_warrantyReply.isErrorReply()) {
            _warrantyReply.getException().setDataPayload(WARRANTY_SOURCE +
                            _warrantyReply.getException().getDataPayLoad());
        } else {
            // Do we have a reply and do we have warnings?
            if(!(_warrantyReply.isNull()) && (_warrantyReply.getReply().getEsHeader().getWarnings() != null)){
                for(int i = 0; i < _warrantyReply.getReply().getEsHeader().getWarnings().getEIAErrorCount(); i++) {
                    _warrantyReply.getReply().getEsHeader().getWarnings().getEIAError(i).
                            setDataPayLoad(WARRANTY_SOURCE + _warrantyReply.getReply().
                            getEsHeader().getWarnings().getEIAError(i).getDataPayLoad());
                }
            }
        }
        // check contract
        if(_contractReply.isErrorReply()) {
            _contractReply.getException().setDataPayload(CONTRACT_SOURCE +
                            _contractReply.getException().getDataPayLoad());
        } else {
            // Do we have a reply and do we have warnings?
            if(!(_contractReply.isNull()) && (_contractReply.getReply().getEsHeader().getWarnings() != null)) {
                for(int i = 0; i < _contractReply.getReply().getEsHeader().getWarnings().getEIAErrorCount(); i++) {
                    _contractReply.getReply().getEsHeader().getWarnings().getEIAError(i).
                        setDataPayLoad(CONTRACT_SOURCE + _contractReply.getReply().
                        getEsHeader().getWarnings().getEIAError(i).getDataPayLoad());
                }
            }
        }
        ESLog.debug("Exit addSourceToWarnings() ::");
    }

    /**
     * Checks for the flags IncludeOffers, IncludeModifiers and IncludeDeliverables
     * for the warranty part and clears them if needed
     */
    protected void checkFlagsForWarranty() {
        // if all is include get out of here
        if(_includeDeliverables && _includeModifiers && _includeOffers) {
            return;
        }

        // create temp flags for business logic
        boolean tempIncludeOffers = false;
        boolean tempIncludeDeliverables = false;
        boolean tempIncludeModifiers = false;

        // check if modifiers were requested  => included also Offers and Deliverables
        if(_includeModifiers) {
            tempIncludeOffers = true;
            tempIncludeDeliverables = true;
            tempIncludeModifiers = true;
        }
        // check if deliverables were requested => included also Offers
        if(_includeDeliverables) {
            tempIncludeOffers = true;
            tempIncludeDeliverables = true;
        }

        // check if offers were requested
        if(_includeOffers) {
            tempIncludeOffers = true;
        }

        WarrantyEntitlementComplexType warrantyEntitlement = _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement();

        // added or clear the Offers, Deliverables and Modifiers
        for(int i = 0; i < warrantyEntitlement.getWarrantyCount(); i++) {
            // check if we want the offers
            if(tempIncludeOffers) {
                for(int k = 0; k < warrantyEntitlement.getWarranty(i).getOfferCount(); k++) {
                    // check if we want the modifiers
                    if(!tempIncludeModifiers) {
                        warrantyEntitlement.getWarranty(i).getOffer(k).removeAllModifier();
                    }
                    // check if we want the deliverables
                    if(!tempIncludeDeliverables) {
                        warrantyEntitlement.getWarranty(i).getOffer(k).removeAllDeliverable();
                    }
                }
            } else {
                warrantyEntitlement.getWarranty(i).removeAllOffer();
            }
        }
    }

    /**
     * Do date alignment between Care Packs, Bundles and Warranty based on PoP date
     * The four conditions to do PoP are( excerpted from chapter 3.10.1 of ES_SRS_8_0.doc):
     * (1) At least Contract entitlement has been requested, Warranty entitlement may or may not have been requested
     * (2) A Proof-Of-Purchase date has been passed to ES
     * (3) The service had a WtyStartDateEligibility set to T (true) in the CDO message received from the source system
     * (4) The related OOS has a WtyStartDate attribute
     * In this function, the most complex logic is how to access AppliesTo from Contract. There are two paths:
     * One is Contract-->Offer-->AppliesTo, another one is Contract-->Obligationheader-->ServiceItem-->Offer-->AppliesTo.
     * We choose the latter, because the four conditions above use information stored in ServiceItem.
     */
    protected void popDateAlignment(EntitlementByXXRequestComplexType requestType) {
        boolean bIsCtrRequested = false; //condition (1)
        boolean bHasPoPInES = false; //condition (2)
        //boolean bIsWtyStartDateEligibility = false; //condition (3)
        //boolean bHasOOSWtyStartDate = false; //condition (4)

        if ((requestType.getIncludeContracts() == true)) {
            bIsCtrRequested = true;
        }

        if (requestType.getProofPurchaseDate() != null) {
            bHasPoPInES = true;
        }

        if (bIsCtrRequested && bHasPoPInES) {
            Date recalculatedWarrantyStartDate = null;

            if ((requestType.getIncludeWarranty() == true)) {
                if (_warrantyReply != null && _warrantyReply.getReply() != null &&
                    _warrantyReply.getReply().getEsReplyChoice() != null &&
                    _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement() != null ) {
                    recalculatedWarrantyStartDate = _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getOverallWarrantyStartDate();
                }
            }
            if (recalculatedWarrantyStartDate == null)
                recalculatedWarrantyStartDate = requestType.getProofPurchaseDate();

            if (recalculatedWarrantyStartDate == null) {
                return;
            }

            boolean bWarning431Raised = false;

            ContractComplexType [] ctrs = null;
            if (_contractReply != null &&
                _contractReply.getReply() != null &&
                _contractReply.getReply().getEsReplyChoice() != null &&
                _contractReply.getReply().getEsReplyChoice().getCombinedUnitEntitlement() != null) {

                ctrs = _contractReply.getReply().getEsReplyChoice().getCombinedUnitEntitlement().getContract();
            }
            if (ctrs != null) {
                for(int i = 0; i < ctrs.length; i++) {
                    ObligationHeader[] ohs = ctrs[i].getObligationHeader();
                    if (ohs == null) continue;
                    for(int j = 0; j < ohs.length; j ++) {
                        String sourceObligationID = ohs[j].getSourceObligationID();
                        ServiceItem [] sis = ohs[j].getServiceItem();
                        if (sis == null) continue;
                        for(int k = 0; k < sis.length; k ++) {
                            String serviceItem = sis[k].getItem();
                            ServiceKey serviceKey = new ServiceKey(sourceObligationID, serviceItem);
                            if ("T".equalsIgnoreCase(_ctx.getSvcWtyStartDateEligibility(serviceKey)) ||
                            	"X".equalsIgnoreCase(_ctx.getSvcWtyStartDateEligibility(serviceKey))) {
                                OfferComplexType offer = (OfferComplexType) sis[k].getOfferRef();
                                AppliesTo[] ats = offer.getAppliesTo();
                                if (ats == null) continue;
                                for (int n = 0; n < ats.length; n++) {
                                    Date wtyStartDateFromCDO = _ctx.getOosWarrantyStartDate(ats[n].getOOSKey());
                                    if (wtyStartDateFromCDO != null) {
                                        Date originalStartDate = ats[n].getStartDate();
                                        Date originalEndDate = ats[n].getEndDate();

                                        //here do the date alignment and raise warning 431 if needed
                                        //Only when the recalculatedWarrantyStartDate <> wtyStartDateFromCDO, the alignment happens

                                        if ( recalculatedWarrantyStartDate.getYear()  != wtyStartDateFromCDO.getYear() ||
                                             recalculatedWarrantyStartDate.getMonth() != wtyStartDateFromCDO.getMonth() ||
                                             recalculatedWarrantyStartDate.getDay()   != wtyStartDateFromCDO.getDay()) {
                                            boolean bAdjusted = false;
                                            if (originalStartDate != null) {
                                                ats[n].setStartDate(DateHelper.newDateWithOffset(originalStartDate, recalculatedWarrantyStartDate, wtyStartDateFromCDO));
                                                bAdjusted = true;
                                            }
                                            if (originalEndDate != null) {
                                                ats[n].setEndDate(DateHelper.newDateWithOffset(originalEndDate, recalculatedWarrantyStartDate, wtyStartDateFromCDO));
                                                bAdjusted = true;
                                            }


                                            if (! bWarning431Raised && bAdjusted) {
                                                bWarning431Raised = true;
                                                addErrorToReply(_contractReply.getReply(), ErrorFactory.getSifException(ErrorFactory.id431_START_DATE_REALIGNED), true);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void setContractReply(RequesterReply contractReply) {
        _contractReply = contractReply;
    }
    public void setWarrantyReply(RequesterReply warrantyReply) {
        _warrantyReply = warrantyReply;
    }
    public void setEsReplyContext(EsReplyContext ctx) {
        _ctx = ctx;
    }
    public RequesterReply getContractReply() {
        return _contractReply;
    }
    public RequesterReply getWarrantyReply() {
        return _warrantyReply;
    }
}