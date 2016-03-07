/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/combinedEntitlement/byPn/PnReplyCreator.java 1.12 2004-09-27 17:56:53+02 stefsobe Exp $
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
 * $Log: PnReplyCreator.java,v $
 * Revision 1.12  2004-09-27 17:56:53+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.11  2004-07-16 04:39:19+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * getEntitlementByPN does not need PoP alignment
 *
 * Revision 1.10  2004-07-02 11:53:29+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * add call of "popDateAlignment"
 *
 * Revision 1.9  2004-05-08 04:41:58+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:40:45+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-04-27 22:26:09+02  lbednari
 * Author: lbednari@bbnnaid344.bbn.hp.com ()
 * - warranty warnings were not included in the final reply in all cases
 * - also when only service notes but no warranty was requested the warranty warnings are now skipped
 *
 * Revision 1.6  2004-02-16 15:33:06+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.5  2004-01-29 18:06:29+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.4  2003-08-04 16:50:52+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.3  2003-07-01 21:48:32+02  lbednari
 * Author: lbednari@bbnnaid62.bbn.hp.com ()
 * - transaction id in EsHeader now set on service handler level
 *
 * Revision 1.2  2003-06-24 13:44:17+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * WITS 517

 * added check for includeOOSes
 *
 * Revision 1.1  2003-06-04 15:12:28+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * Initial revision
 *
 *
 */
package com.hp.es.service.combinedEntitlement.byPn;

import com.hp.es.service.combinedEntitlement.reply.ReplyCreator;
import com.hp.es.service.combinedEntitlement.reply.RequesterReply;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.CombinedProductEntitlementComplexType;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.sif.SifException;

public class PnReplyCreator extends ReplyCreator {

    public PnReplyCreator(EsRequestComplexType combinedRequest) {
        super(combinedRequest,
                combinedRequest.getEsRequestComplexTypeChoice().getEntitlementByPnRequest().getIncludeOffers(),
                combinedRequest.getEsRequestComplexTypeChoice().getEntitlementByPnRequest().getIncludeDeliverables(),
                combinedRequest.getEsRequestComplexTypeChoice().getEntitlementByPnRequest().getIncludeModifiers());
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
        // CASE - STANDARD REPLY
        // Note: If we are here in the code we don't have any list in the reply
        //       We can do a standard merge
        ESLog.debug("CASE - Standard Reply");

        //As chapter 3.10.1 in ES_SRS_8_0.doc shows, getEntitlementByPN needs not PoP alignment so far
        //popDateAlignment(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementByPnRequest());

        return doStandardMerge();
    }

    
	/**
	 * Merges the workings from contract and Warranty into the 
	 * Unified Entitlement Reply
	 * @param wSource
	 * @param ueTarget
	 */
	private void addAllWorkings(WorkingComplexType[] wWorking, CombinedProductEntitlementComplexType ueReply) {
		for(int i=0;i<wWorking.length;i++) {
			ueReply.addWorking(wWorking[i]);
		}		
	}
    /**
     * Does the merge of the reply in case that we have NO unit lists in the
     * replies. The replies could contain errors.
     * @return EsReply
     */
    protected EsReply doStandardMerge() throws SifException {
        ESLog.debug("Enter");
        // CASE - Both have a valid reply
        if(_warrantyReply.isNormalReply() && _contractReply.isNormalReply()) {
            ESLog.debug("Warranty and Contract have valid reply");
            // add the warranty to the contract reply
            addWarrantyToReply();
            return _contractReply.getReply();
        // CASE - one of the replies has an error
        } else if ( (_warrantyReply.isErrorReply() || _contractReply.isErrorReply()) &&
                    (! _warrantyReply.isNull()) && (!_contractReply.isNull())
                  ) {
            ESLog.debug("Only 1 match & one error");
            if(_warrantyReply.isErrorReply()) {
                ESLog.debug("Warranty problem");
                // warranty is null, add warranty exception to the contract reply
                addErrorToReply(_contractReply.getReply(), _warrantyReply.getException(), true);
                return _contractReply.getReply();
            }

            ESLog.debug("Contract problem");
            // contract is null, add contract exception to the warranty reply
            addErrorToReply(_warrantyReply.getReply(), _contractReply.getException(), true);
            EsReply empty = createEmptyReply();
            _contractReply = new RequesterReply(empty);
            addWarrantyToReply();
                return _contractReply.getReply();
        // CASE - one of the replies is NULL
        } else {
            ESLog.debug("Only 1 match & one empty");
            if(_warrantyReply.isNull()) {
                ESLog.debug("Contract only result");
                if (_contractReply.isErrorReply()) throw _contractReply.getException();
                return _contractReply.getReply();
            }
            
            ESLog.debug("Warranty only result");
            if (_warrantyReply.isErrorReply()) throw _warrantyReply.getException();
            // pretend we have a contract result and simply add the wty stuff to it
            EsReply empty = createEmptyReply();
            _contractReply = new RequesterReply(empty);
            addWarrantyToReply();
            return _contractReply.getReply();
        }
    }

    /**
     * Adds the contract information to the EsReply. It assumes the EsReply was
     * created with buildCombinedEntitlementReply()
     */
    private void addWarrantyToReply() {
        ESLog.debug("Enter");

        CombinedProductEntitlementComplexType root =  _contractReply.getReply().getEsReplyChoice().getCombinedProductEntitlement();

        // check if warranty was requested
        if(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementByPnRequest().getIncludeWarranty() == true) {

            // ActiveWarrantyEntitlement
            root.setActiveWarrantyEntitlement(_warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getActiveWarrantyEntitlement());

            // OverallWarrantyStartDate
            root.setOverallWarrantyStartDate(
                        _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getOverallWarrantyStartDate());

            // OverallWarrantyEndDate
            root.setOverallWarrantyEndDate(
                        _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getOverallWarrantyEndDate());

            // Warranty
            checkFlagsForWarranty();
            root.setWarranty(
                    _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getWarranty());

            // Working
            addAllWorkings(_warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getWorking(), root);
            

            // add warnings from warranty if any
            addWarnings(_warrantyReply.getReply(), _contractReply.getReply());

        } else {
            // clear the fields
            root.setActiveWarrantyEntitlement(false);
            root.setOverallWarrantyStartDate(null);
            root.setOverallWarrantyEndDate(null);
            root.removeAllWarranty();
            root.removeAllWorking();
        }


        // check if service notes were requested
        // note that in line with \uFFFD5.3.3.3 of the ES 5.0 SRS warranty warnings will not be part of the overall
        // reply if only ServiceNotes were requested from the warranty side...
        if(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementByPnRequest().getIncludeServiceNotes() == true) {
            // ServiceNote
            root.setServiceNote(
                        _warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getServiceNote());
        } else {
            root.removeAllServiceNote();
        }

        // add the warranty OOS
        if(_combinedRequest.getEsRequestComplexTypeChoice().getEntitlementByPnRequest().getIncludeOOSes() == true) {
            root.addOOS(_warrantyReply.getReply().getEsReplyChoice().getWarrantyEntitlement().getOOS());
        }

        ESLog.debug("Exit");
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
        reply.getEsReplyChoice().setCombinedProductEntitlement(new CombinedProductEntitlementComplexType());
        reply.getEsReplyChoice().getCombinedProductEntitlement().setActiveContractEntitlement(false);
        return reply;
    }
}