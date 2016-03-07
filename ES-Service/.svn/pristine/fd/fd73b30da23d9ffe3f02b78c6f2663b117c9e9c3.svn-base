/*
 * Project: HPS Entitlement Service
 *
 * Copyright (c) 2003 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 */
package com.hp.es.service.combinedEntitlement.bySn;

import java.util.Enumeration;

import com.hp.es.service.combinedEntitlement.reply.ReplyCreator;
import com.hp.es.service.combinedEntitlement.reply.RequesterReply;
import com.hp.es.service.db.DbSkuKmatManager;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.ContactComplexType;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.sif.SifException;


public class SnReplyCreator extends ReplyCreator {
    /**
     * Adds the contract information to the EsReply. It assumes the EsReply was
     * created with buildCombinedUnitEntitlementReply()
     */
    private void addWarrantyToReply(boolean warrantyOosHasPriority) {
        ESLog.debug("Enter");

        CombinedUnitEntitlementComplexType root =  _contractReply.getReply().getEsReplyChoice().getCombinedUnitEntitlement();

        // check if warranty was requested
        WarrantyEntitlementComplexType we = _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement();
        if(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getIncludeWarranty() == true) {

            root.setActiveWarrantyEntitlement(we.getActiveWarrantyEntitlement());
            root.setOverallWarrantyStartDate(we.getOverallWarrantyStartDate());
            root.setOverallWarrantyEndDate(we.getOverallWarrantyEndDate());

            checkFlagsForWarranty();
            root.setWarranty(we.getWarranty());
            addAllWorkings(we.getWorking(),root);
            addWarnings(_warrantyReply.getReply(), _contractReply.getReply());

            Enumeration enumeration = we.enumerateLocation();
            while (enumeration.hasMoreElements()) {
                root.addLocation( (LocationComplexType) enumeration.nextElement());
            }
        } else {
            // clear the fields
            root.setActiveWarrantyEntitlement(false);
            root.setOverallWarrantyStartDate(null);
            root.setOverallWarrantyEndDate(null);
            root.removeAllWarranty();
            root.removeAllWorking();
        }


        // check if service notes were requested
        // note that in line with \uFFFD5.3.3.3 (assuming it is also relevant for bySn calls although it is described under
        // the byPn opertaion) of the ES 5.0 SRS warranty warnings will not be part of the overall
        // reply if only ServiceNotes were requested from the warranty side...
        if(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getIncludeServiceNotes() == true) {
            root.setServiceNote(we.getServiceNote());
        } else {
            root.removeAllServiceNote();
        }

        // overwrite the contract OOS with the warranty OOS if needed
        if (warrantyOosHasPriority) {
            root.setOOS(we.getOOS());
            // resolve the references for the new OOS
            adjustContractOosReferences();
        } else {
            // if contract OOS is used, then create reference to the address
            // returned by warranty subsystem.
            root.getOOS().setWarrantyShipToCustomerRef(we.getOOS().getWarrantyShipToCustomerRef());
            // update remaining addresses
            adjustWarrantyOosReferences();
        }

        ESLog.debug("Exit");
    }

	/**
	 * Merges the workings from contract and Warranty into the
	 * Unified Entitlement Reply
	 * @param wSource
	 * @param ueTarget
	 */
	private void addAllWorkings(WorkingComplexType[] wWorking, CombinedUnitEntitlementComplexType ueReply) {
		for(int i=0;i<wWorking.length;i++) {
			ueReply.addWorking(wWorking[i]);
		}
	}

    public SnReplyCreator(EsRequestComplexType combinedRequest) {
        super(combinedRequest,
                combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getIncludeOffers(),
                combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getIncludeDeliverables(),
                combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getIncludeModifiers());
    }

    /**
     * Creates an EsReply depending on the variables
     * - _contractReply
     * - _contractReply
     *
     * @return EsReply
     * @throws SifException
     */
    public EsReply create() throws SifException {
        ESLog.debug("Enter");
        // do first a check if all variables are null
        // if yes, throw an SifException
        nullCheck();
        // look for warnings and add the source to the data payload
        addSourceToWarnings();
        // find out what is available
        // CASE - Warranty Exception and Contract Exception
        if ( _warrantyReply.isErrorReply() && _contractReply.isErrorReply() ) {
            ESLog.debug("CASE - Warranty Exception and Contract Exception");
            throw doExceptionMerge();
        }
        // CASE - LIST
        // Note: Only one of the replies needs to have a list, then we create
        //       a unit list reply
        if( _warrantyReply.isListReply() || _contractReply.isListReply() ) {
            ESLog.debug("CASE - List");
            return doListMerge();
        }
        // CASE - STANDARD REPLY
        // Note: If we are here in the code we don't have any list in the reply
        //       We can do a standard merge
        ESLog.debug("CASE - Standard Reply");

        popDateAlignment(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest());

        return doStandardMerge();
    }


    /**
     * Does the merge of the reply in case that at least 1 reply contains a
     * unit list. The replies could contain errors.
     * @return EsReply
     */
    private EsReply doListMerge() {
        ESLog.debug("Enter");
        //########################################################################
        // CASE - 2 lists
        if(_warrantyReply.isListReply() && _contractReply.isListReply()) {
            ESLog.debug("CASE - 2 lists");
            // merge the lists
            UnitListMerger merger = new UnitListMerger(
                _combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getSerialNumber(),
                _warrantyReply.getUnitList(), _contractReply.getUnitList() );
            _contractReply.getReply().getEsReplyChoice().setUnitList(merger.getMergedList());
            // merge the errors if we have some
            addWarnings(_warrantyReply.getReply(), _contractReply.getReply());
            return _contractReply.getReply();
        }

        //########################################################################
        // CASE - 1 list / 1 match (we already know one is a list else we would not be here)
        if(_warrantyReply.isNormalReply() || _contractReply.isNormalReply()) {
            ESLog.debug("CASE - 1 list / 1 match");
            // single product has right to overwrite only if it is coming from wty
            boolean preferSingleProduct = false;
            UnitListComplexType list = null;
            ProductComplexType singleProduct = null;
            EsReply overallReply = null;
            if(_warrantyReply.isNormalReply()) {
                ESLog.debug("Contract returned list");
                String sn = _combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getSerialNumber();
                singleProduct = _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct();
                // warranty empty PN & contract Multiple PNS & 12 length SN
                // return Merged result using any of the contract OOS found
                if(sn != null && sn.length() == 12 && !_warrantyReply.hasProductId()){
                    if(rebuildUnitListToCombinedUnit(false)){
                        return _contractReply.getReply();
                    }
                }
                //warranty empty PN & contract Multiple PNS & not 12 length SN
                //Unit list based on contract reply
                if(sn != null && sn.length() != 12 && !_warrantyReply.hasProductId()){
                    singleProduct = null;
                }
                // warranty one PN & contract Multiple PNS & 12 length SN
                // Merged result using warranty OOS
                if(sn != null && sn.length() == 12 && _warrantyReply.hasProductId()){
                    if(addWarrantyToReplyBybuildUnitListReply(true)){
                        return _contractReply.getReply();
                    }
                }
                // warranty one PN & contract Multiple PNS & not 12 length SN
                // Unit list with merged PNs from both sources
                if(sn != null && sn.length() != 12 && _warrantyReply.hasProductId()){
                }
                //singleProduct = _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct();
                preferSingleProduct = true;
                list = _contractReply.getUnitList();
                overallReply = _contractReply.getReply();
                addWarnings(_warrantyReply.getReply(), overallReply);
            } else {
                ESLog.debug("Warranty returned list");
                singleProduct = _contractReply.getReply().getEsReplyChoice().getCombinedUnitEntitlement().getOOS().getProduct();
                preferSingleProduct = false;
                list = _warrantyReply.getUnitList();
                // we have to create a new reply structure as the one returned from contract side does not have
                // the right type (normal, not list) and the one from wty has the wrong header info
                overallReply = createEmptyReply();
                overallReply.getEsHeader().setWarnings(_warrantyReply.getReply().getEsHeader().getWarnings());
                overallReply.getEsReplyChoice().setCombinedUnitEntitlement(null);
                addWarnings(_contractReply.getReply(), overallReply);
            }
            UnitListMerger merger =
                new UnitListMerger(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getSerialNumber(),
                    singleProduct, list, preferSingleProduct);
            overallReply.getEsReplyChoice().setUnitList(merger.getMergedList());
            // merge errors
            return overallReply;
        }

        //########################################################################
        // CASE - 1 list / 1 null (we already know one is a list else we would not be here)
        if(_warrantyReply.isNull() || _contractReply.isNull()) {
            ESLog.debug("CASE - 1 list / 1 null");
            UnitListComplexType list = null;
            EsReply overallReply = null;
            if(_warrantyReply.isNull()) {
                ESLog.debug("Contract list + wty null");
                list = _contractReply.getUnitList();
                overallReply = _contractReply.getReply();
                String sn = _combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getSerialNumber();
                if(sn!=null && sn.length() ==12){
                    if(rebuildUnitListToCombinedUnit(false)){
                        return _contractReply.getReply();
                    }
                }
            } else {
                ESLog.debug("Warranty list + contract null");
                list = _warrantyReply.getUnitList();
                // we have to create a new reply structure as the one returned from contract side does not have
                // the right type (normal, not list) and the one from wty has the wrong header info
                overallReply = createEmptyReply();
                overallReply.getEsHeader().setWarnings(_warrantyReply.getReply().getEsHeader().getWarnings());
                overallReply.getEsReplyChoice().setCombinedUnitEntitlement(null);
            }
            UnitListMerger merger =
                new UnitListMerger(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getSerialNumber(),
                    (ProductComplexType)null, list);
            overallReply.getEsReplyChoice().setUnitList(merger.getMergedList());
            return overallReply;
        }

        //########################################################################
        // CASE - 1 list / 1 error (we already know one is a list else we would not be here)
        ESLog.debug("CASE - 1 list / 1 error");
        UnitListComplexType list = null;
        EsReply overallReply = null;
        SifException singleError = null;
        if (_warrantyReply.isErrorReply()) {
            ESLog.debug("Contract list + wty error");
            list = _contractReply.getUnitList();
            singleError = _warrantyReply.getException();
            overallReply = _contractReply.getReply();
            //warranty other error & contract Multiple PNS & 12 length SN
            //Merged result using any of the contract OOS PNs found, warning on warranty error in reply header
            String sn = _combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getSerialNumber();
            if(sn!=null && sn.length() ==12){
                if(rebuildUnitListToCombinedUnit(true)){
                    return _contractReply.getReply();
                }
            }
        }
        else {
            ESLog.debug("Warranty list + contract error");
            list = _warrantyReply.getUnitList();
            singleError = _contractReply.getException();
            // we have to create a new reply structure as the one returned from
            // contract side does not have
            // the right type (normal, not list) and the one from wty has the
            // wrong header info
            overallReply = createEmptyReply();
            overallReply.getEsHeader().setWarnings(
                    _warrantyReply.getReply().getEsHeader().getWarnings());
            overallReply.getEsReplyChoice().setCombinedUnitEntitlement(null);
        }
        UnitListMerger merger = new UnitListMerger(_combinedRequest
                .getEsRequestComplexTypeChoice().getEntitlementBySnRequest()
                .getSerialNumber(), (ProductComplexType) null, list);
        overallReply.getEsReplyChoice().setUnitList(merger.getMergedList());
        addErrorToReply(overallReply, singleError, false);
        return overallReply;
    }

    /**
     * Does the merge of the reply in case that we have NO unit lists in the
     * replies. The replies could contain errors.
     *
     * @return EsReply
     */
    public EsReply doStandardMerge() throws SifException {
        ESLog.debug("Enter");
        //########################################################################
        // CASE - Both are ok
        if(_warrantyReply.isNormalReply() && _contractReply.isNormalReply()) {
            ESLog.debug("Warranty and Contract match");
            // both replies are ok
            // check if they match with PN/SN - the PN has to be available
            // 			TODO - VERIFY

            if(_warrantyReply.hasProductId() && _contractReply.hasProductId()) {
                // If the contract product number and the warranty product number are
                // not equivalent according to the existing rules, then a unit list is returned
                if(isMatch() == false) {
                	ESLog.debug("No PN match between Warranty and Contract");
                	return createUnitListReply();
                }
                // If the contract product number and the warranty
                // product number are equivalent according to the
                // existing rules, then the results are merged and the warranty PN is returned
                if(isMatch() == true) {
                	addWarrantyToReply(true);
                	return _contractReply.getReply();
                }
            }
            // -----------------------------------------------------------------
            // CASE - we have 2 empty ProductIds or no empty ProductId
            if((_warrantyReply.hasProductId() && _contractReply.hasProductId()) ||
                (!_warrantyReply.hasProductId() && !_contractReply.hasProductId())) {
                // both ProductIds are empty or both ProductIds are filled
                ESLog.debug("Both or no ProductId is empty");
                // add the warranty to the contract reply
                // NOTE: warranty is added to contract because warranty has the right
                //       to overwrite
                addWarrantyToReply(true);
            // -----------------------------------------------------------------
            // CASE - we have 1 empty ProductId
            } else {
                if(!_contractReply.hasProductId()) {
                    ESLog.debug("Contract ProductId is empty");
                    // overwrite with warranty data
                    addWarrantyToReply(true);
                } else {
                    ESLog.debug("Warranty ProductId is empty");
                    // add wty data but use the contract OOS
                    addWarrantyToReply(false);
                }
            }
            return _contractReply.getReply();
        //########################################################################
        // CASE - one of the replies has an error
        } else if ( (_warrantyReply.isErrorReply() || _contractReply.isErrorReply()) &&
                    (! _warrantyReply.isNull()) && (!_contractReply.isNull())
                  ) {
            ESLog.debug("Only 1 match & one error");
            if(_warrantyReply.isErrorReply()) {
                ESLog.debug("Warranty problem");
                // warranty is null, add warranty exception to the contract reply
                addErrorToReply(_contractReply.getReply(), _warrantyReply.getException(), false);
                return _contractReply.getReply();
            }

            ESLog.debug("Contract problem");
            // contract is null, add contract exception to the warranty reply
            addErrorToReply(_warrantyReply.getReply(), _contractReply
                    .getException(), false);
            EsReply empty = createEmptyReply();
            _contractReply = new RequesterReply(empty);
            addWarrantyToReply(true);
            return _contractReply.getReply();

                //########################################################################
        // CASE - one of the replies is NULL
        } else {
            ESLog.debug("Only 1 match & one empty");
            if(_warrantyReply.isNull()) {
                ESLog.debug("Contract only result");
                if (_contractReply.isErrorReply()) throw _contractReply.getException();
                return _contractReply.getReply();
            }

            ESLog.debug("Warranty only result");
            if (_warrantyReply.isErrorReply()) {
                throw _warrantyReply.getException();
            }
            // pretend we have a contract result and simply add the wty stuff to
            // it
            EsReply empty = createEmptyReply();
            _contractReply = new RequesterReply(empty);
            addWarrantyToReply(true);
            return _contractReply.getReply();
        }
    }
    /**
     * Adds the contract information to the EsReply. It assumes the EsReply was
     * created with buildUnitListReply()
     */
    private boolean addWarrantyToReplyBybuildUnitListReply(boolean warrantyOosHasPriority) {
        ESLog.debug("Enter");
        if(!rebuildUnitListToCombinedUnit(false)){
            return false;
        }
        addWarrantyToReply(warrantyOosHasPriority);
        ESLog.debug("Exit");
        return true;
    }

    /**
     * rebuild _contractReply unitlist to CombinedUnitEntitlement. It assumes the EsReply was
     * created with buildUnitListReply()
     */
    private boolean rebuildUnitListToCombinedUnit(boolean addErrorMsg) {
        ESLog.debug("Enter");

        /**
         * WITS 1674
         * 1. code change:
         *  "this._ctx.mergeAndCalculateAll()" is replaced by "this._ctx.calculateAggregatedValues()"
         * 
         * 2.why
         *  - In rebuildUnitListToCombinedUnit method, calling calculateAggregatedValues will add duplicate items in contracts.
         *  - call calculateAggregatedValues to calculate the overall elements, such as OverallContractStartDate
         *  
         */
        this._ctx.calculateAggregatedValues();

        CombinedUnitEntitlementComplexType result = new CombinedUnitEntitlementComplexType();
        result.setActiveContractEntitlement(this._ctx.isActiveContractEntitlement());
        result.setOverallContractStartDate(this._ctx.getOverallContractStartDate());
        result.setOverallContractEndDate(this._ctx.getOverallContractEndDate());

        // warranty
        result.setActiveWarrantyEntitlement(false);

        result.setContact(  (ContactComplexType[])this._ctx.getContacts().toArray(new ContactComplexType[0]) );
        result.setContract( (ContractComplexType[])this._ctx.getContracts().toArray(new ContractComplexType[0]) );
        result.setLocation( (LocationComplexType[])this._ctx.getLocations().toArray(new LocationComplexType[0]) );

        int oosCount = this._ctx.getOOSes().size();
        if (oosCount==0) {
            ESLog.debug("No OSS found in warranty reply,Exit");
            return false;
        }
        ESLog.debug("Found " + oosCount + " OOS");

        OOSComplexType[] OOSes = (OOSComplexType[])_ctx.getOOSes().toArray(new OOSComplexType[0]);
        OOSComplexType firstOOS = _ctx.getFirstOOS(OOSes);
        if (firstOOS == null) {
            ESLog.debug("No OSS found in warranty reply,Exit");
            return false;
        }
        result.setOOS(firstOOS);

        if (oosCount > 1) {
            ContractComplexType[] contracts = result.getContract();
            for (int i = 0; i < contracts.length; i++) {
                OfferComplexType[] offers = contracts[i].getOffer();
                for (int j = 0; j < offers.length; j++) {
                    AppliesTo[] appliesTos = offers[j].getAppliesTo();
                    for (int k = 0; k < appliesTos.length; k++) {
                        AppliesTo to = appliesTos[k];
                        if (to.getOOSRef() != null) {
                            to.setOOSRef(firstOOS);
                        }
                    }
                }
            }
        }
        OOSes = null;

        if(!addErrorMsg){
            ESLog.debug("Re-Building header");
            EsHeader esHeader = new EsHeader();
            esHeader.setInputRequest(this._combinedRequest);
            this._contractReply.getReply().setEsHeader(esHeader);
            ESLog.debug("Re-Building Finish");
        }
        this._contractReply.getReply().getEsReplyChoice().setCombinedUnitEntitlement(result);
        this._contractReply.getReply().getEsReplyChoice().setUnitList(null);


        ESLog.debug("re-build CombinedUnitEntitlement OK");
        ESLog.debug("Exit");
        return true;
    }

    /**
     * When merging results from both sides and picking the wty OOS for the
     * overall reply: This means the AppliesTos from the contract side then
     * still point to the contract OOS which will not be in the reply. This
     * method creates the new references
     */
    private void adjustContractOosReferences() {
        ESLog.debug("Enter");
        CombinedUnitEntitlementComplexType root =  _contractReply.getReply().getEsReplyChoice().
                                                    getCombinedUnitEntitlement();
        for(int i = 0; i < root.getContractCount(); i++) {
            ContractComplexType contract = root.getContract(i);
            for(int k = 0; k < contract.getOfferCount(); k++) {
                OfferComplexType offer = contract.getOffer(k);
                for(int n = 0; n < offer.getAppliesToCount(); n++) {
                    offer.getAppliesTo(n).setOOSRef(root.getOOS());
                }
            }
        }
        ESLog.debug("Exit");
    }


    /**
     * When merging results from both sides and picking the contract OOS for the
     * overall reply: This means the AppliesTos from the warranty side then
     * still point to the warranty OOS which will not be in the reply. This
     * method creates the new references
     */
    private void adjustWarrantyOosReferences() {
        ESLog.debug("Enter");
        CombinedUnitEntitlementComplexType root =  _contractReply.getReply().getEsReplyChoice().
                                                    getCombinedUnitEntitlement();
        for(int i = 0; i < root.getWarrantyCount(); i++) {
            WarrantyComplexType warranty = root.getWarranty(i);
            for(int k = 0; k < warranty.getOfferCount(); k++) {
                OfferComplexType offer = warranty.getOffer(k);
                for(int n = 0; n < offer.getAppliesToCount(); n++) {
                    offer.getAppliesTo(n).setOOSRef(root.getOOS());
                }
            }
        }
        ESLog.debug("Exit");
    }

    /**
     * Checks the replies if the OOSs matches with the product number
     * @return boolean
     */
    private boolean isMatch() throws SifException {
        ESLog.debug("Enter");
        try {
            // check if we have a serial number with the length of 12
            // in this case it is always take this as a match
            if(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementBySnRequest()
                .getSerialNumber().length() == 12) {
                return true;
            }

            // If the request contained both SN and PN we consider them to be the same
            // even though the prod no can differ as described in the 5.0 SRS \uFFFD5.4.4.2
            String requestedProdId = _combinedRequest.getEsRequestComplexTypeChoice()
                                        .getEntitlementBySnRequest().getProductID();
            if(requestedProdId != null && !( "".equals(requestedProdId.trim()))) {
                return true;
            }

            // If request only had serial number and no product number
            // Get the warrantyProductId
            String warrantyProductId = null;
            ProductComplexType warrantyProduct = _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct();
            if((warrantyProduct != null) && (warrantyProduct.getProductID() != null)) {
            	warrantyProductId = warrantyProduct.getProductID().trim();
            } else {
            	warrantyProductId = "";
            }
            // Get the converetdWarrantyProductId  - by taking its corresponding KMAT entry if there is one
            String convertedWarrantyProductId = null;
            try {
                if (warrantyProductId.startsWith("47")) {
                    convertedWarrantyProductId =
                      DbSkuKmatManager.getInstance()
                            .skuKmatConversion(
                            _warrantyReply
                                .getReply()
                                .getEsReplyChoice()
                                .getWarrantyEntitlement()
                                .getOOS()
                                .getProduct()
                                .getProductID()
                                .trim());
                }
            } catch(DataAccessException e) {
                ESLog.error("skuKmatConversion failed: ", e);
                throw new RuntimeException(
                    "DBManagerImpl.getInstance().getDBSkuKmatManager().skuKmatConversion(ProductID()) caught DataAccessException: "
                        + e);
            } catch (DatabaseDownException e) {
                ESLog.error("skuKmatConversion failed: ", e);
                throw new RuntimeException(
                    "DBManagerImpl.getInstance().getDBSkuKmatManager().skuKmatConversion(ProductID()) caught DatabaseDownException: "
                        + e);            
             }

            if(convertedWarrantyProductId == null) {
                convertedWarrantyProductId = warrantyProductId;
            }

            // Get the ContractProductId and converetdContractProductId - if it is null then throw exception
            String contractProductId = null;
            ProductComplexType contractProduct = _contractReply.getReply().getEsReplyChoice().getCombinedUnitEntitlement().getOOS().getProduct();
            if((contractProduct != null) && (contractProduct.getProductID() != null)) {
                contractProductId = contractProduct.getProductID().toString().trim();
            }  else {
            	contractProductId = "";
            }

            String convertedContractProductId = null;
            if(_contractReply != null && _contractReply.getMappedProductList() != null) {
	            convertedContractProductId = (String) _contractReply.getMappedProductList().get(contractProductId);
	            if(convertedContractProductId == null) {
	                throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,
	                        "Aggregated Product Id is null for product Id: "
	                        + contractProductId);
	            }
            } else {
	            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,
	            		"Aggregated Product List s null");
            }
            // Compare convertedContractProductId with
            // converetdWarrantyProductId
            return convertedWarrantyProductId.equals(convertedContractProductId);
        } finally {
            ESLog.debug("Exit");
        }
    }


    /**
     * This method is only used if we have a mismatch of the product numbers,
     * when we have normal results from warranty and contract. So merging
     * of both sides is easy as we already know the prod number do not match.
     * NOTE: It uses the contract EsReply, sets the setCombinedUnitEntitlement to null,
     *       and add a Unit List with the 2 products (1 from contract, 1 from
     *       warranty), sets the warning and returns it.
     *       This way we don't need to fill the complete EsReply again.
     * @return UnitList EsReply
     */
    private EsReply createUnitListReply() {
        ESLog.debug("Enter");
        UnitListComplexType unitList = new UnitListComplexType();
        // add serial number
        unitList.setSerialNumber(_warrantyReply.getReply().getEsReplyChoice().
                            getWarrantyEntitlement().getOOS().getSerialNumber(0));
        // add contract product
        ProductComplexType conProduct = new ProductComplexType();
        if(_contractReply.getReply().getEsReplyChoice().getCombinedUnitEntitlement().getOOS().getProduct() != null) {
        	 conProduct.setProductID(_contractReply.getReply().getEsReplyChoice().
        	 		 getCombinedUnitEntitlement().getOOS().getProduct().getProductID());
        	 conProduct.setProductDescription(_contractReply.getReply().getEsReplyChoice().
        	 		getCombinedUnitEntitlement().getOOS().getProduct().getProductDescription());
        }
        unitList.addProduct(conProduct);
        // add warranty product
        ProductComplexType wtyProduct = new ProductComplexType();
        if(_warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct() != null) {
        	wtyProduct.setProductID(_warrantyReply.getReply().getEsReplyChoice().
        			getWarrantyEntitlement().getOOS().getProduct().getProductID());
        	wtyProduct.setProductDescription(_warrantyReply.getReply().getEsReplyChoice().
        			getWarrantyEntitlement().getOOS().getProduct().getProductDescription());
        }
        unitList.addProduct(wtyProduct);

        EsReply unitListReply = _contractReply.getReply();
        unitListReply.getEsReplyChoice().setCombinedUnitEntitlement(null);
        unitListReply.getEsReplyChoice().setUnitList(unitList);
        addWarnings(unitListReply, _warrantyReply.getReply());
        ESLog.debug("Exit");
        return unitListReply;
    }

    /**
     * This method creates an empty combined entitlement reply.
     * @return EsReply
     */
    private EsReply createEmptyReply() {
        EsReply reply = new EsReply();
        reply.setEsHeader(new EsHeader());
        reply.getEsHeader().setInputRequest(_combinedRequest);
        reply.setEsReplyChoice(new EsReplyChoice());
        reply.getEsReplyChoice().setCombinedUnitEntitlement(new CombinedUnitEntitlementComplexType());
        reply.getEsReplyChoice().getCombinedUnitEntitlement().setActiveContractEntitlement(false);
        return reply;
    }
}