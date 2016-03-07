/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/routingDetails/GetRoutingDetailsOperation.java 1.5 2004-09-27 17:57:41+02 stefsobe Exp $
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
 * $Log: GetRoutingDetailsOperation.java,v $
 * Revision 1.5  2004-09-27 17:57:41+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.4  2004-05-08 04:41:50+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.3  2004-05-05 15:40:35+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.2  2004-01-29 18:06:19+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.1  2004-01-22 12:04:18+01  stefsobe
 * Author: stefsobe@sobesteffen ()
 * Initial revision
 *
 */
package com.hp.es.service.routingDetails;

import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.routingDetails.orchestration.RoutingDetailsOrchestration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.RoutingDetailsRequest;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Handle the GetRoutingDetails requests
 * 
 * @since ES 6.1
 */
public class GetRoutingDetailsOperation extends EsOperation {

    /**
     * This method calls the CQS to get the rounting details for the request. It then builds and returns the reply.
     */
    protected EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler) throws SifException {
        EsReply reply = null;
        ESLog.debug("Enter");
        ESLog.debug("Sending request to orchestration");
        reply = RoutingDetailsOrchestration.getInstance().execute(request, context, metricsHandler);
        ESLog.debug("End");
        return reply;
    }

    /**
     * Make sure the request has the type RoutingDetailsRequest and the SvcAgreementID is set. If not, throw an
     * exception.
     * 
     * @see com.hp.es.serviceHandler.EsOperation#verifyRequest(com.hp.es.xml.service.EsRequestComplexType,
     *      com.hp.ruc.metrics.MetricsHandler)
     */
    protected void verifyRequest(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
        RoutingDetailsRequest r = request.getEsRequestComplexTypeChoice().getRoutingDetailsRequest();
        if (r == null) {
            throw ErrorFactory.getSifException(ErrorFactory.id120_INVALID_REQUEST,
                    "The GetRoutingDetails operation requires an " + "RoutingDetailsRequest request.");
        }

        if (r.getSvcAgreementID() == null || r.getSvcAgreementID().trim().length() == 0) {
            throw ErrorFactory.getSifException(ErrorFactory.id120_INVALID_REQUEST,
                    "The SvcAgreementID needs to be specified for the GetRoutingDetails " + "operation.");
        }
    }

    /**
     * This method is called by the OperationManager when a new object of the Operation is created. All time-consuming
     * initializations should be done here. <b>Note:</b> The same Operation object will be used in parallel by multiple
     * threads. The access to other resources needs to be synchronized if necessary.
     */
    protected void init() {
        RoutingDetailsOrchestration.getInstance();
    }

	
}
