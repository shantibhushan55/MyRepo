/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/serviceHandler/EsServiceHandler.java 1.28 2004-09-27 17:57:46+02 stefsobe Exp $
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
 * $Log: EsServiceHandler.java,v $
 */
package com.hp.es.service.wsInterface;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.batchEntitlement.BatchRequestManager;
import com.hp.es.service.manufacturingHeaderInformation.ManufacturingInstalledBaseServiceOperation;
import com.hp.es.service.operations.Operation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.LoadChangeListener;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Handle all requests for the Entitlement Service.
 * 
 * @since ES 4.0
 */
public class EsServiceHandler extends GenericServiceHandler {

	/**
	 * The operations prefix used in the CommonService.properties file for the
	 * Entitlement Service.
	 */
	static private final String SERVICE_PREFIX = EsConstants.ES_SERVICE_ID;
	static private final String SERVICE_DESC = "ES service handler";
	static private final String SERVICE_MAJOR_VERSION = EsConstants.ES_MAJOR_VERSION;
	static private final String SERVICE_MINOR_VERSION = EsConstants.ES_MINOR_VERSION;

	static private ArrayList<LoadChangeListener> listeners = null;
	static private int runningOperations = 0;

	/*
	 * We assume that if there is several service Handler, we will have only one
	 * BatchRequestManager we keep it here to avoid it to be deleted from memory
	 */
	static private BatchRequestManager batchManager = BatchRequestManager
			.getInstance();
	protected Configuration _config;

	/**
	 * EsServiceHandler
	 */
	public EsServiceHandler() {
		super(SERVICE_DESC, SERVICE_PREFIX, SERVICE_MAJOR_VERSION,
				SERVICE_MINOR_VERSION);
		if (ESLog.isDebugLogEnabled()) {
			ESLog.debug("Constructing EsServiceHandler.");
		}
		// Service handlers normally live very long so there is no harm
		// doing this each time a service handler is constructed
		_config = Configuration.getInstance();
	}

	/**
	 * This method is called by EIA Service manager to release resources
	 */
	public void destroy() {
		// nothing to destroy
	}

	
	/**
	 * This method unmarshals the current XML string and invokes the operation
	 * that can handle the request. The reply for the request is returned as XML
	 * string.
	 * 
	 * @param bodyXml
	 *            request as XML string
	 * @param transaction
	 *            ID - unique ID within any Run of the application
	 * @param handler
	 *            used to collect metrics
	 * @return java.lang.String XML response for the current request
	 * @throws com.hp.sif.SifException
	 *             if any application error occurs while processing the request
	 * @throws com.hp.es.service.wsInterface.FailoverException
	 *             if the current request should be forwarded to a failover
	 *             server
	 */
	protected EsReply callService(EsRequestComplexType request,
			String transactionID, MetricsHandler handler) throws SifException {

		final String method = "EsServiceHandler.callService()";

		MetricsEntry entry = null;
		if (handler != null)
			entry = handler.addEntry(method);

		try {
			fireLoadHasIncreased();
			if (entry != null)
				entry.actionStart();
			EsReply reply = callServiceWithObject(request, transactionID,
					handler);
			return reply;
		} catch (StackOverflowError e) {
			// When a StackoverflowError occurs while unmarshalling we should
			// catch this exception and return a 120 error (invalid request).
			ESLog.error("Castor unmarshalling Exception ", e);
			throw ErrorFactory
					.getSifException(ErrorFactory.id120_INVALID_REQUEST,
							" XML request is syntactically not correct, e.g. unexpected elements");
		} finally {
			// We are not catching any other exception as the only remaining was
			// runtime and we were not logging anything for it
			if (entry != null)
				entry.actionDone();
			fireLoadHasDecreased();
		}
	}

	/**
	 * This method get an Es request ans end it to the requested operation. It
	 * was not called callService to allow easy counting with MetricsHandler
	 * 
	 * @param EsRequestComplexType
	 *            request as EsRequestComplexType
	 * @param transaction
	 *            ID - unique ID within any Run of the application
	 * @param handler
	 *            used to collect metrics
	 * @return EsReply response for the current request
	 * @throws com.hp.sif.SifException
	 *             if any application error occurs while processing the request
	 * @throws com.hp.es.service.wsInterface.FailoverException
	 *             if the current request should be forwarded to a failover
	 *             server
	 */
	public EsReply callServiceWithObject(EsRequestComplexType req,
			String transactionID, MetricsHandler handler) throws SifException {

		MetricsEntry entry = null;

		final String method = "EsServiceHandler.callServiceWithObject()";
		// Note that having a null handler is not valid
		if (handler != null) {
			entry = handler.addEntry(method);
		}

		// We are creating a big try/catch to handle TransactionMonitor
		try {
			// Start the time measuring for the current request...

			// Find the operation that handles the current request. Only
			// operations that are configured as 'public' are used.
			ESLog.debug("Trying to load the operation for "
					+ req.getOperation());
			Operation op = getOperationManager().getPublicOperation(
					req.getOperation());
			if (op == null) {
				ESLog.info("No Operation was configured for '"
						+ req.getOperation() + "'");
				throw ErrorFactory.getSifException(
						ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
						"Operation", "No Operation was configured for '"
								+ req.getOperation() + "' " + method);
			}

			EsReply reply = null;
			try {
				OperationContext context = new OperationContext();
				context.setOriginalOperationName(req.getOperation());			
				reply = (EsReply) op.processRequest(req, context, handler);
				
				
				
			} catch (ClassCastException e2) {
				ESLog.error("The Operation '" + req.getOperation() + "'"
						+ " didn't return an EsReply as expected");
				throw ErrorFactory.getSifException(
						ErrorFactory.id9999_INTERNAL_ERROR, "The Operation '"
								+ req.getOperation() + "'"
								+ " didn't return an EsReply as expected");
			}

			// note the transaction ID in the reply for reference by the client
			reply.getEsHeader().setTransactionID(transactionID);

			// count certain events based on the reply
			// we have to stop the time before to send the reply back
			// (this time is not including the marshalling and unmarshalling
			// before the change, this was including the marshalling but not the
			// unmarshalling
			return reply;
		} catch (SifException e) {
			// count the exception if necessary

			throw e;
		} catch (RuntimeException e2) {
			// just in case ...
			throw e2;
		} finally {
			if (entry != null)
				entry.actionDone();
		}
	}
	
	public EsReply callSnrService(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler)throws Exception{
		ManufacturingInstalledBaseServiceOperation snrMfgOperation = new ManufacturingInstalledBaseServiceOperation();
		
		EsReply esReply = (EsReply)snrMfgOperation.processRequest(request, context, metricsHandler);
		
		
		return esReply;
	}

	/**
	 * Inform all load monitors that the load has increased, i.e. an operation
	 * has started.
	 */
	private static synchronized void fireLoadHasIncreased() {
		runningOperations++;
		if (listeners != null) {
			for (Iterator<LoadChangeListener> it = listeners.iterator(); it.hasNext();) {
				it.next().operationHasStarted();
			}
		}
	}

	/**
	 * Inform all load monitors that the load has decreased, i.e. an operation
	 * has finished.
	 */
	private static synchronized void fireLoadHasDecreased() {
		runningOperations--;
		if (listeners != null) {
			for (Iterator<LoadChangeListener> it = listeners.iterator(); it.hasNext();) {
				it.next().operationHasFinished();
			}
		}
	}

	/**
	 * Register a new LoadChangeListener.
	 * 
	 * @param batchLoadMonitor
	 */
	public static synchronized void addLoadChangeListener(
			LoadChangeListener listener) {
		if (listener != null) {
			if (listeners == null) {
				listeners = new ArrayList<LoadChangeListener>();
			}
			listeners.add(listener);
			// It might be possible that there is already some load, i.e. we
			// have
			// to notify the monitor immediately about the current load
			for (int i = 0; i < runningOperations; i++) {
				listener.operationHasStarted();
			}
		}
	}

	public static BatchRequestManager getBatchManager() {
		return batchManager;
	}
}