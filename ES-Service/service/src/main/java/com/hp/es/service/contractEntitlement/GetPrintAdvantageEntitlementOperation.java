/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/GetPrintAdvantageEntitlementOperation.java 1.22 2004-09-27 17:57:06+02 stefsobe Exp $
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
 * $Log: GetPrintAdvantageEntitlementOperation.java,v $
 * Revision 1.22  2004-09-27 17:57:06+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 */
package com.hp.es.service.contractEntitlement;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.TreeMap;

import com.hp.es.service.contractEntitlement.db.DbContractEntitlementManager;
import com.hp.es.service.contractEntitlement.db.OutputDetails;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.Deliverable;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.PrintAdvantageEntitlementComplexType;
import com.hp.es.xml.service.PrintAdvantageRequest;
import com.hp.es.xml.service.Warnings;
import com.hp.es.xml.service.types.ContractIdentifierTypeType;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Handle the GetPrintAdvantageEntitlement request
 * @author Thorsten Koevi
 */
public class GetPrintAdvantageEntitlementOperation extends EsOperation {

  //  private DbContractEntitlementManager dbContractEntitlementManager;

    /**
     * @see com.hp.es.serviceHandler.Operation#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
     */
    protected EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler)
        throws SifException {

        PrintAdvantageRequest paRequest = request.getEsRequestComplexTypeChoice().getPrintAdvantageRequest();
        OutputDetails outputDetails = new OutputDetails(paRequest);
        EsReplyContext replyContext = new EsReplyContext(outputDetails);
        DbContractEntitlementManager dbContractEntitlementManager =DbContractEntitlementManager.getNewInstance();
        try {
            int errorID = dbContractEntitlementManager.getPrintAdvantageEntitlement(
                        replyContext,
                        paRequest.getContractIdentifier(),
                        paRequest.getContractIdentifierType(),
                        paRequest.getIsoCountryCd(),
                        outputDetails,
                        metricsHandler);

            // check for errors returned from the database
            if (errorID!=0) {
                // map errorId to SifException
                // this probably needs to be enhanced to provide more details
               throw ErrorFactory.getSifException(errorID);
            }

            // merge objects, create ID/IDREFs, calculate overall start/end dates
            replyContext.mergeAndCalculateAll();

            return generateReply(replyContext, request);

        }
        catch (DataAccessException e) {
            ESLog.info("Caught a DataAccessException while processing PrintAdvantageRequest.");
            return generateEsReplyWithWarning(ErrorFactory.id9999_INTERNAL_ERROR,"Unknow database exception while processing PrintAdvantageRequest.",request);           
            
        } catch (DatabaseDownException e) {
            ESLog.info("Caught a DatabaseDownException while processing PrintAdvantageRequest.");
            return generateEsReplyWithWarning(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE,"ODS",request);           
        }finally {
        	dbContractEntitlementManager.destroy();
        	/*if(replyContext != null) 
        		replyContext.destroy();*/
        }
    }

    /**
     * @see com.hp.es.serviceHandler.Operation#init()
     */
    protected void init() {
        // just to make sure that the database is initialized when the
        // first request comes in
    }

    /**
     * @see com.hp.es.serviceHandler.Operation#verifyRequest(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
     */
    protected void verifyRequest(EsRequestComplexType request, MetricsHandler metricsHandler)
    throws SifException {

    PrintAdvantageRequest paRequest = request.getEsRequestComplexTypeChoice().getPrintAdvantageRequest();
    if(paRequest == null) {
        throw ErrorFactory.getSifException(ErrorFactory.id120_INVALID_REQUEST,
                "The GetPrintAdvantageEntitlement operation requires a " +
                "PrintAdvantage request.");
    }
    else if (!paRequest.getContractIdentifier().startsWith("PA")) {
        throw ErrorFactory.getSifException(ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "ContractIdentifier", "The ContractIdentifier has to start with PA " +
                "for the PrintAdvantageEntitlement operation.");
    }
    else if (!paRequest.getContractIdentifierType().equals(ContractIdentifierTypeType.FUNCTIONALLOCATION)) {
        throw ErrorFactory.getSifException(ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "ContractIdentifierType", "The ContractIdentifierType has to be set to "+
                "FunctionalLocation for the PrintAdvantageEntitlement operation.");
    }
}

    /**
     * This method generates the EsReply for the given input data from the replyContext.
     * For this operation we remove all obligation header information and merge offers with
     * the same offer code together.
     * @param replyContext contains all information for the reply
     * @param request the original request which will be included in the reply
     * @return
     * @throws SifException
     */
    protected EsReply generateReply( EsReplyContext replyContext, EsRequestComplexType request )
        throws SifException {

        PrintAdvantageEntitlementComplexType result = new PrintAdvantageEntitlementComplexType();

        for (Iterator it = replyContext.getContracts().iterator(); it.hasNext();) {
            ContractComplexType contract = (ContractComplexType)it.next();
            result.addContract(contract);

            // Remove all ServiceItems for the obligation headers because the offers are
            // merged together. The items wouldn't be meaningful anymore.
            for (Enumeration enumOhdr=contract.enumerateObligationHeader(); enumOhdr.hasMoreElements(); ) {
                ObligationHeader ohdr = (ObligationHeader)enumOhdr.nextElement();
                ohdr.removeAllServiceItem();
            }

            // First merge all offers with the same offer code together
            TreeMap tmpMap = new TreeMap();
            for (Enumeration enumOffer=contract.enumerateOffer(); enumOffer.hasMoreElements(); ) {
                OfferComplexType nextOffer = (OfferComplexType)enumOffer.nextElement();

                // For PrintAdvantage contracts, each offer should have exactly one
                // AppliesTo with one OOS.
                if (nextOffer.getAppliesToCount()>1) {
                    ESLog.info("PrintAdvantage contracts shouldn't have more than one " +
                                "AppliesTos, but the offer " + nextOffer.getOfferCode() +
                                " has " + nextOffer.getAppliesToCount() + " AppliesTo.");
                }

                if (nextOffer.getAppliesToCount()>0) {
                    // create a new deliverable (always use the first applies-to)
                    AppliesTo appliesTo = nextOffer.getAppliesTo(0);
                    OOSComplexType oos  = (OOSComplexType)appliesTo.getOOSRef();
                    if (oos!=null && oos.getProduct()!=null ) {
                        Deliverable deliv = new Deliverable();
                        deliv.setDelivCode(oos.getProduct().getProductID());
                        deliv.setDelivName(oos.getProduct().getProductDescription());
                        deliv.setAvailableQuantity(nextOffer.getAvailableQuantity());
                        deliv.setDeliverableQuantity(nextOffer.getServiceQuantity());
                        nextOffer.addDeliverable(deliv);
                    }
                }

                // check if we already have an offer for the same
                // offer code/service product type
                String key = nextOffer.getOfferCode()==null ? "" : nextOffer.getOfferCode();
                if (nextOffer.getSvcProductType()!=null) {
                    if (nextOffer.getSvcProductType().equals("PS")) {
                        // this is just to have the PS offers sorted at the top in the
                        // xml reply
                        key = key + " ";
                    }
                    else {
                        key = key + "#" + nextOffer.getSvcProductType();
                    }
                }

                OfferComplexType prevOffer = (OfferComplexType)tmpMap.get(key);
                if (prevOffer == null) {
                    // Remove AvailableQuantity and ServiceQuantity from Offer
                    nextOffer.deleteAvailableQuantity();
                    nextOffer.deleteServiceQuantity();
                    // Remove the AppliesTo as it is not needed in the reply of this operation
                    nextOffer.removeAllAppliesTo();
                    // setIncidentBasedOffer flag to true for all non-PS services
                    if (nextOffer.getSvcProductType() != null
                        && !nextOffer.getSvcProductType().equals("PS")) {
                        nextOffer.setIncidentBasedOffer(true);
                    }

                    tmpMap.put(key, nextOffer);
                }
                else {
                    if (nextOffer.getDeliverableCount() > 0) {
                        // there is only one deliverable
                        prevOffer.addDeliverable(nextOffer.getDeliverable(0));
                    }
                }
            }
            // Now overwrite with the new merged offers.
            contract.setOffer( (OfferComplexType[])tmpMap.values().toArray(new OfferComplexType[0]) );


            // Iterate over all unique offers and merge the deliverables with the same
            // productID and calculate the quantities.
            for (Enumeration enumOffer=contract.enumerateOffer(); enumOffer.hasMoreElements(); ) {

                tmpMap.clear();
                OfferComplexType nextOffer = (OfferComplexType)enumOffer.nextElement();

                for (Enumeration enumDeliv=nextOffer.enumerateDeliverable(); enumDeliv.hasMoreElements(); ) {
                    Deliverable nextDeliv = (Deliverable)enumDeliv.nextElement();

                    // Check if there is already a deliverable with the same deliverable code.
                    String key = nextDeliv.getDelivCode()==null ? "" : nextDeliv.getDelivCode();
                    Deliverable prevDeliv = (Deliverable)tmpMap.get(key);
                    if (prevDeliv==null) {
                         tmpMap.put(key, nextDeliv);
                    }
                    // else sum up the availableQuantity and serviceQuantity
                    else {
                        prevDeliv.setAvailableQuantity(
                                    prevDeliv.getAvailableQuantity() +
                                    nextDeliv.getAvailableQuantity());
                        prevDeliv.setDeliverableQuantity(
                                    prevDeliv.getDeliverableQuantity() +
                                    nextDeliv.getDeliverableQuantity());
                    }
                }
                nextOffer.setDeliverable((Deliverable[])tmpMap.values().toArray(new Deliverable[0]) );
            }
        }

        EsReply esReply = new EsReply();
        EsReplyChoice esReplyChoice = new EsReplyChoice();
        esReply.setEsReplyChoice(esReplyChoice);
        esReplyChoice.setPrintAdvantageEntitlement(result);

        EsHeader esHeader = new EsHeader();
        esHeader.setInputRequest(request);
        // transaction ID is set in service handler class

        esReply.setEsHeader(esHeader);

        return esReply;
    }
    private EsReply generateEsReplyWithWarning(int errorId, String errorText, EsRequestComplexType request) {
        ESLog.debug("Enter generateEsReplyWithWarning()");
        EIAError eiaError = ErrorFactory.getEIAError(errorId, errorText);
        
        Warnings warnings = new Warnings();
        warnings.addEIAError(eiaError);
        
        EsReply esReply = new EsReply();
        EsHeader esHeader=new EsHeader();
        esReply.setEsHeader(esHeader);
        esReply.getEsHeader().setWarnings(warnings);
        esReply.getEsHeader().setInputRequest(request);
        ESLog.debug("Exit createEsReplyWithWarning()");
        return esReply;
    }


}
