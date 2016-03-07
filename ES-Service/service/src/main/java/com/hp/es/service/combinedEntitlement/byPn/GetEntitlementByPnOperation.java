package com.hp.es.service.combinedEntitlement.byPn;

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
 *
 */
import java.util.ArrayList;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.combinedEntitlement.reply.RequesterReply;
import com.hp.es.service.combinedEntitlement.requester.ContractRequester;
import com.hp.es.service.combinedEntitlement.requester.WarrantyRequester;
import com.hp.es.service.contractEntitlement.EsCheckDateRange;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.serviceNotes.ServiceNoteIntegration;
import com.hp.es.service.serviceNotes.ServiceNoteTransaction;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EntitlementByPnRequest;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Handle the GetEntitlementByPn request
 */
public class GetEntitlementByPnOperation extends EsOperation {
	// need static variable in order to catch exception of inner class (contract
	// call thread)
	// static Exception cctException = null;
	public GetEntitlementByPnOperation() {
	}

	/**
	 * Process a request of type EntitlementByPnRequest
	 * 
	 * @param request
	 *            the request that was sent from the client
	 * @param metricsHandler
	 * @throws SifException
	 *             Thrown when the request couldn't be processed successfully.
	 * @return EsReply the reply that can be sent back to the client
	 */
	protected EsReply execute(EsRequestComplexType combinedRequest,
			final OperationContext context, MetricsHandler metricsHandler)
			throws SifException {

		ESLog.debug("Enter");

		// final variables need for CCT (contract call thread)
		final PnReplyCreator replyCreator = new PnReplyCreator(combinedRequest);
		final EsRequestComplexType combinedRequestCCT = combinedRequest;
		// final MetricsHandler metricsHandlerCCT = metricsHandler;
		// final variables need for cctException
		final ArrayList cctExceptionList = new ArrayList(1);
		try {
			// CONTRACT CALL
			Thread contractCallThread = new Thread() {
				public void run() {
					// cctException = null;
					cctExceptionList.clear();
					try {
						if (combinedRequestCCT.getEsRequestComplexTypeChoice()
								.getEntitlementByPnRequest()
								.getIncludeContracts() == true) {
							// call the GetContractEntitlement operation
							ESLog
									.debug("Calling GetContractEntitlement operation");
							ContractRequester cRequester = new PnContractRequester(
									getOperationManager());
							RequesterReply rcReply = cRequester.execute(
									combinedRequestCCT, context,
									new MetricsHandler());
							// fill the reply creator
							replyCreator.setContractReply(rcReply);
						}
					} catch (Exception e) {
						cctExceptionList.add(e);
						interrupt();
					}
				}
			};
			contractCallThread.start();

			// WARRANTY CALL
			if ((combinedRequest.getEsRequestComplexTypeChoice()
					.getEntitlementByPnRequest().getIncludeWarranty() == true)
					|| (combinedRequest.getEsRequestComplexTypeChoice()
							.getEntitlementByPnRequest()
							.getIncludeServiceNotes() == true)) {
				// generate WarrantyRequest
				EsRequestComplexType wRequest = createWarrantyRequest(combinedRequest);
				// call the GetWarrantyEntitlement operation
				ESLog.debug("Calling GetWarrantyEntitlement operation");
				WarrantyRequester wRequester = new WarrantyRequester(
						getOperationManager(), combinedRequest
								.getEsRequestComplexTypeChoice()
								.getEntitlementByPnRequest()
								.getActiveWarrantyOnly());
				RequesterReply rwReply = wRequester.execute(wRequest, context,
						new MetricsHandler());
				// fill the reply creator
				if (rwReply != null) {
					replyCreator.setWarrantyReply(rwReply);
				}
			}

			// wait for the CCT (contract call thread) to be finished
			try {
				contractCallThread.join();
			} catch (InterruptedException e) {
			}

			// Get back exception from inner thread
			Exception cctException = null;
			if (cctExceptionList.size() > 0) {
				cctException = (Exception) cctExceptionList.get(0);
			}

			if (cctException != null) {
				if (cctException instanceof DatabaseDownException) {
					// throw (DatabaseDownException) cctException;
				}
				if (cctException instanceof SifException) {
					throw (SifException) cctException;
				}

				ESLog.error("Unexpected exception", cctException);
				throw ErrorFactory
						.getSifException(ErrorFactory.id9999_INTERNAL_ERROR);
			}
			// create and return the reply
			EsReply reply = replyCreator.create();

			// We also need to check that a product ID was provided as input
			// parameter!
			if (combinedRequest.getEsRequestComplexTypeChoice()
					.getEntitlementByPnRequest().getIncludeServiceNotes()
					&& reply.getEsReplyChoice().getCombinedProductEntitlement() != null) {
				EntitlementByPnRequest pnRequest = combinedRequest
						.getEsRequestComplexTypeChoice()
						.getEntitlementByPnRequest();
				EsRequestComplexType wRequestServiceNote = createServiceNoteWarrantyRequest(
						reply, null, pnRequest.getProductID());
				ServiceNoteIntegration snIntegration = ServiceNoteIntegration
						.getInstance();
				ServiceNoteTransaction snTrans = null;

				try {

					snTrans = (ServiceNoteTransaction) snIntegration.execute(
							wRequestServiceNote, metricsHandler);
					if (snTrans.getMappedErrors() == null
							&& snTrans.getMappedReply() != null) {
						reply.getEsReplyChoice()
								.getCombinedProductEntitlement()
								.setServiceNote(
										snTrans.getMappedReply()
												.getEsReplyChoice()
												.getWarrantyEntitlement()
												.getServiceNote());
					} else {
						ESLog.debug("SN retrieval failed!");
					}
				} finally {
					if (snTrans != null)
						snTrans.destroy();
				}

			}
			return reply;

		} finally {
			ESLog.debug("Exit");
		}
	}

	private EsRequestComplexType createServiceNoteWarrantyRequest(
			EsReply reply, String reqSerialNumber, String reqProductId) {
		/*
		 * The service notes are using only the serial number and the product
		 * ID. For historical reasons the service notes are generated into a
		 * warranty reply and it's also using a warranty request structure
		 */

		// Create the new service not (wrarranty) request based on the reply
		EsRequestComplexType serviceNoteRequest = new EsRequestComplexType();
		serviceNoteRequest
				.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
		serviceNoteRequest.setOperation("getWarrantyEntitlement");
		serviceNoteRequest.setClientAppID(reply.getEsHeader().getInputRequest()
				.getClientAppID());

		// Get the sn and pn from OOS or from request if no oos
		WarrantyRequest wr = new WarrantyRequest();
		wr.setProductID(reqProductId);
		wr.setSerialNumber(reqSerialNumber);
		// in case we did not have a SN we try to get it from the OOS
		if (reqSerialNumber == null) {
			if (reply.getEsReplyChoice().getCombinedProductEntitlement()
					.getOOSCount() > 0) {
				if (reply.getEsReplyChoice().getCombinedProductEntitlement()
						.getOOS(0).getSerialNumberCount() > 0) {
					wr.setSerialNumber(reply.getEsReplyChoice()
							.getCombinedProductEntitlement().getOOS(0)
							.getSerialNumber(0));
				}
			}
		}
		serviceNoteRequest.getEsRequestComplexTypeChoice().setWarrantyRequest(
				wr);

		return serviceNoteRequest;
	}

	/**
	 * This method is called by the OperationManager when a new object of the
	 * Operation is created. All time-consuming initializations should be done
	 * here. <b>Note:</b> The same Operation object will be used in parallel by
	 * multiple threads. The access to other resources needs to be synchronized
	 * if necessary.
	 */
	protected void init() {
	}

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
	protected void verifyRequest(EsRequestComplexType request,
			MetricsHandler metricsHandler) throws SifException {
		EntitlementByPnRequest cr = request.getEsRequestComplexTypeChoice()
				.getEntitlementByPnRequest();
		if (cr == null) {
			throw ErrorFactory.getSifException(
					ErrorFactory.id120_INVALID_REQUEST,
					"The GetEntitlementBySn operation requires an "
							+ "GetEntitlementByPn request.");
		}
		int maxLength=Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_PN_MAXLENGTH,20);
		checkMandatoryParameter(cr.getProductID(), "ProductID",maxLength,"The parameter ProductID is missing in GetEntitlementByPnOperation");
		if ((cr.getIncludeWarranty() == false)
				&& (cr.getIncludeContracts() == false)
				&& (cr.getIncludeServiceNotes() == false)) {
			throw ErrorFactory
					.getSifException(
							ErrorFactory.id120_INVALID_REQUEST,
							"The GetEntitlementByPn operation requires at least "
									+ "IncludeWarranty or IncludeContracts set to 'true'");
		}
		EsCheckDateRange.verifyDate(cr.getEntitlementCheckDate());
	}

	/**
	 * Creates a new EsRequest with an warranty request
	 * 
	 * @param combinedRequest
	 * @return EsRequest with WarrantyRequest
	 */
	private EsRequestComplexType createWarrantyRequest(
			EsRequestComplexType combinedRequest) {
		EntitlementByPnRequest pnRequest = combinedRequest
				.getEsRequestComplexTypeChoice().getEntitlementByPnRequest();
		EsRequestComplexType wRequest = new EsRequestComplexType();
		wRequest
				.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
		wRequest.setOperation("getWarrantyEntitlement");
		wRequest.setClientAppID(combinedRequest.getClientAppID());
		WarrantyRequest wr = new WarrantyRequest();
		wr.setProductID(pnRequest.getProductID());
		wr.setIsoCountryCd(pnRequest.getIsoCountryCd());
		wr.setEntitlementCheckDate(pnRequest.getEntitlementCheckDate());
		wr.setProofPurchaseDate(pnRequest.getProofPurchaseDate());
		wr.setServiceID(pnRequest.getServiceID());
		// AccurateConsumerWarrantyNeeded - Future Use
		wr.setMarketSegment(pnRequest.getMarketSegment());
		wr.setGeoCode(pnRequest.getGeoCode());
		wr.setIncludeServiceNotes(pnRequest.getIncludeServiceNotes());
		wr.setIncludeWorkings(pnRequest.getIncludeWorkings());
		wr.setSourceSystem(pnRequest.getWarrantySourceSystem());
		wr.setIncludeCATS(false);

		wRequest.getEsRequestComplexTypeChoice().setWarrantyRequest(wr);

		return wRequest;
	}

}
