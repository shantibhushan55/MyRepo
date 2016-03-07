/*
 * Project: HPS Entitlement Service
 *
 * Copyright (c) 2006 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
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

abstract public class ContractRequester {

    private Operation _contractOperation;

    public ContractRequester(OperationManager opManager) throws SifException {
    	_contractOperation = opManager.getPublicOperation("getContractEntitlement");
        if(_contractOperation == null) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,
                "Internal Error",
                "Contract Entitlement operation could not be found");
        }
    }

    // call the contract operation
    public RequesterReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metrics) {

        ESLog.debug("Enter");
        EsReply contractReply = null;
        EsReply combinedReply = null;
        RequesterReply rReply = null;
        try {
            ESLog.debug("Calling GetContractEntitlement operation ...");
            contractReply = (EsReply)_contractOperation.processRequest(createContractRequest(request), context, metrics);
            combinedReply = buildCombinedEntitlementReply(request, contractReply);
            rReply = new RequesterReply(combinedReply);
        } catch(SifException ee) {
            ESLog.debug("Caught SifException"+ ee.getMessage());
            rReply = new RequesterReply(ee);
        } catch (ClassCastException e2) {
            SifException ex = ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,
                "The Operation '" + _contractOperation.toString() + "'" +
                " didn't return an EsReply as expected");
            rReply = new RequesterReply(ex);
        }

        ESLog.debug("Exit");
        return rReply;
    }
    
    abstract protected EsReply buildCombinedEntitlementReply(EsRequestComplexType request, EsReply reply) throws SifException;
    
    abstract protected EsRequestComplexType createContractRequest(EsRequestComplexType combinedRequest);
}