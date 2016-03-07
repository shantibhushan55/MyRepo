/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/serviceHandler/Operation.java 1.15 2004-09-27 17:57:48+02 stefsobe Exp $
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
 * $Log: Operation.java,v $
 * Revision 1.15  2004-09-27 17:57:48+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.14  2004-05-08 04:40:54+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.13  2004-05-05 15:39:32+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.12  2004-01-29 18:05:09+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.11  2003-08-19 13:35:37+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * change Operation class to accept and return Objects instead of 
 * EsRequestComplexType and EsReply
 *
 * Revision 1.10  2003-08-04 16:49:42+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.9  2003-07-14 15:12:20+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * remove ArmTransaction
 *
 * Revision 1.8  2003-06-18 16:43:43+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * use  ArmTransaction
 *
 * Revision 1.7  2003-06-04 19:26:02+02  lbednari
 * Author: lbednari@bbnnaid28.bbn.hp.com ()
 * using new constants for error ids
 *
 * Revision 1.6  2003-05-27 03:43:35+02  lbednari
 * Author: lbednari@bbnnaid189.bbn.hp.com ()
 * - merged changes from dev5_0C2 branch
 *
 * Revision 1.5  2003-05-12 01:58:03+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.4  2003-04-30 10:39:31+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * - obsolete WarrantyDetailsKNIGHT, WarrantyDetailsKNIGHTImpl,
 *   EsLocalState, HPSEServiceHandler, WarrantyService,
 *   WarrantyServiceImpl, whole state package
 * - applied KNIGHT WSDL change (for red warranty)
 *
 * Revision 1.3  2003-04-25 14:30:53+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * adjusted EIA message
 *
 * Revision 1.2  2003-04-14 18:34:22+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * make init() protected
 *
 * Revision 1.1  2003-04-04 14:58:35+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */

package com.hp.es.service.operations;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Abstract class that is the base of all operations that handles incoming
 * requests. It is very important to understand that the same Operation object
 * will be used by the OperationManager to process different requests in
 * parallel. This means the operations have to be implemented as stateless
 * objects. For performance reasons, the synchronizations (if necessary) should
 * be kept to a minimum.
 * 
 * @since ES 4.0
 */
abstract public class Operation {


	/**
	 * The service handlers calls the processRequest() method which first calls
	 * the validateRequest() method and then the process() method (both
	 * implemented by the sub classes).
	 * 
	 * @param request
	 *            the request that was sent from the client
	 * @param metricsHandler
	 * @throws SifException
	 *             Thrown when the request couldn't be processed successfully.
	 * @return Object the reply that can be sent back to the client
	 */
	public final Object processRequest(Object request,
			OperationContext context, MetricsHandler metricsHandler)
			throws SifException {

		if (request == null) {
			ESLog
					.error("The request must never be null in Operation.processRequest");
			throw ErrorFactory
					.getSifException(
							ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
							"(could not determine which)",
							"The request must never be null in Operation.processRequest");
		}
		Object o = null;

		validateRequest(request, metricsHandler);
		o = process(request, context, metricsHandler);

		return o;
	}

	/**
	 * This method has to be implemented by the sub classes. It processes the
	 * the requests and returns an reply object, which is sent back to the
	 * client.
	 * 
	 * @param request
	 *            the request that was sent from the client
	 * @param metricsHandler
	 * @throws SifException
	 *             Thrown when the request couldn't be processed successfully.
	 * @return Object the reply that can be sent back to the client
	 */
	protected abstract Object process(Object request, OperationContext context,
			MetricsHandler metricsHandler) throws SifException;

	/**
	 * This method is called by the OperationManager when a new object of the
	 * Operation is created. All time-consuming initializations should be done
	 * here. <b>Note:</b> The same Operation object will be used in parallel by
	 * multiple threads. The access to other resources needs to be synchronized
	 * if necessary.
	 */
	protected abstract void init();

	/**
	 * This method is automatically called before the execute() is called. It
	 * should validate if all input parameter are meaningful and complete. When
	 * this method doesn't throw an exception, the execute() method should be
	 * able to process the request.
	 * 
	 * @param request
	 *            the request that was sent from the client
	 * @param metricsHandler
	 * @throws SifException
	 *             when the parameter of the request are not complete or not
	 *             meaningful, i.e. when the request cannot be handled by the
	 *             operation
	 */
	protected abstract void validateRequest(Object request,
			MetricsHandler metricsHandler) throws SifException;

	/**
	 * @return the OperationManager instance that created this operation
	 */
	public OperationManager getOperationManager() {
		return operationManager;
	}

	/**
	 * This method is called by the OperationManager.
	 * 
	 * @param the
	 *            OperationManager instance that created this operation
	 */
	void setOperationManager(OperationManager operationManager) {
		this.operationManager = operationManager;
	}

	/* OperationManager instance that created this operation */
	private OperationManager operationManager = null;

}
