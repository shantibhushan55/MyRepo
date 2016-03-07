/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/combinedEntitlement/requester/WarrantyRequester.java 1.12 2004-09-28 13:48:52+02 stefsobe Exp $
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
 * $Log: WarrantyRequester.java,v $
 * Revision 1.12  2004-09-28 13:48:52+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change log level; rename method of ConfigHolder
 *
 * Revision 1.11  2004-09-27 17:56:58+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.10  2004-05-08 04:41:52+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.9  2004-05-05 15:40:37+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.8  2004-02-16 15:33:30+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.7  2004-01-29 18:06:21+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.6  2003-08-19 13:34:01+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * add handling for ClassCastException
 *
 * Revision 1.5  2003-08-04 16:50:44+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-06-26 14:37:32+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * added NULL check for the requested warranty operation
 *
 * Revision 1.3  2003-06-26 14:15:02+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * WITS 532: getActiveOnlyWarrantyEntitlement was called as a public operation,

 * but it is a private operation
 *
 * Revision 1.2  2003-06-05 16:57:04+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * added active only check
 *
 * Revision 1.1  2003-06-04 15:12:46+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * Initial revision
 *
 * Revision 1.5  2003-06-02 12:58:32+02  JUHANK
 * Author: JUHANK@dhcp-15-197-230-117.bbn.hp.com ()
 * removed commented out code
 *
 * Revision 1.4  2003-05-27 03:10:18+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * moving trunk rev after introducing new file from branch 5_0C2
 *
 * Revision 1.3  2003-05-20 18:43:05+02  lbednari
 * Author: lbednari@dhcp-15-197-235-62.bbn.hp.com ()
 * - using the oepration manager for getting hold of warranty operation
 *
 * Revision 1.2  2003-05-20 16:53:35+02  lbednari
 * Author: lbednari@dhcp-15-197-235-62.bbn.hp.com ()
 * - reafctored Requester objects and decision making in ReplyCreator
 *
 * Revision 1.1  2003-05-19 13:01:48+02  JUHANK
 * Author: JUHANK@dhcp-15-197-230-117.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.combinedEntitlement.requester;

import com.hp.es.service.combinedEntitlement.reply.RequesterReply;
import com.hp.es.service.operations.Operation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.operations.OperationManager;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class WarrantyRequester {

    private Operation _warrantyOperation;
    private boolean _activeOnly;

    public WarrantyRequester(OperationManager opManager, boolean activeOnly) throws SifException {
        _activeOnly = activeOnly;
        if(_activeOnly == true) {
            _warrantyOperation = opManager.getAnyOperation("getActiveOnlyWarrantyEntitlement");
        } else {
            _warrantyOperation = opManager.getPublicOperation("getWarrantyEntitlement");
        }
        if(_warrantyOperation == null) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,
                "Internal Error",
                "Warranty Entitlement operation could not be found");
        }
    }

    // call the warranty operation
    public RequesterReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metrics) {

        ESLog.debug("Enter");
        EsReply wReply = null;
        RequesterReply rReply = null;
        try {
            ESLog.debug("Calling GetWarrantyEntitlement operation ...");
            wReply = (EsReply)_warrantyOperation.processRequest(request, context, metrics);
            rReply = new RequesterReply(wReply);
        } catch(SifException ee) {
        	ESLog.debug("Caught SifException"+ ee.getMessage());
            rReply = new RequesterReply(ee);
        } catch (ClassCastException e2) {
            SifException ex = ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,
                "The Operation '" + _warrantyOperation.toString() + "'" +
                " didn't return an EsReply as expected");
            rReply = new RequesterReply(ex);
        }

        ESLog.debug("Exit");
        return rReply;
    }
}