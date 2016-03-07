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
package com.hp.es.service.combinedEntitlement.bySn;

import java.util.ArrayList;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.ProductNumberValidator;
import com.hp.es.service.SerialNumberValidator;
import com.hp.es.service.combinedEntitlement.reply.ReplyCreator;
import com.hp.es.service.combinedEntitlement.reply.RequesterReply;
import com.hp.es.service.combinedEntitlement.requester.ContractBySnRequester;
import com.hp.es.service.combinedEntitlement.requester.WarrantyRequester;
import com.hp.es.service.contractEntitlement.EsCheckDateRange;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.serviceNotes.ServiceNoteIntegration;
import com.hp.es.service.serviceNotes.ServiceNoteTransaction;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Handle the GetEntitlementBySn request
 */
public class GetEntitlementBySnOperation extends EsOperation {

	// need static variable in order to catch exception of inner class (contract
	// call thread)
	// static Exception cctException = null;
	/**
	 * Process a request of type EntitlementBySnRequest
	 * 
	 * @param request
	 *            the request that was sent from the client
	 * @param metricsHandler
	 * @throws SifException
	 *             Thrown when the request couldn't be processed successfully.
	 * @return EsReply the reply that can be sent back to the client
	 * @roseuid 3E6F2B640149
	 */
	protected EsReply execute(EsRequestComplexType combinedRequest,
			OperationContext context, MetricsHandler metricsHandler)
			throws SifException {
		ESLog.debug("Enter");
		// final variables need for CCT (contract call thread)
		final SnReplyCreator replyCreator = new SnReplyCreator(combinedRequest);
		final EsRequestComplexType combinedRequestCCT = combinedRequest;
		// final MetricsHandler metricsHandlerCCT = metricsHandler;
		final ArrayList cctExceptionList = new ArrayList(1);

		try {
			// build the CombinedUnitEntitlement
			ESLog.debug("Building CombinedUnitEntitlementReply ...");
			com.hp.es.service.util.Surprise.check(combinedRequest
					.getEsRequestComplexTypeChoice()
					.getEntitlementBySnRequest());
			// CONTRACT CALL
			Thread contractCallThread = new Thread() {
				public void run() {
					cctExceptionList.clear();
					try {
						if (combinedRequestCCT.getEsRequestComplexTypeChoice()
								.getEntitlementBySnRequest()
								.getIncludeContracts() == true) {
							// no contract request needs to be created, the
							// request can be passed
							// directly to the requester
							ESLog.debug("Calling GetContractBySN operation");
							ContractBySnRequester cbsRequester = new ContractBySnRequester();

							RequesterReply cbsReply = cbsRequester.execute(
									combinedRequestCCT, new MetricsHandler());
							// cbsReply.get
							replyCreator.setContractReply(cbsReply);
							replyCreator.setEsReplyContext(cbsReply
									.getEsReplyContext());
							replyCreator.setContractReply(cbsReply);

						}
					} catch (Exception e) {
						cctExceptionList.add(e);
						interrupt();
					}
				}
			};
			contractCallThread.start();
			// WARRANTY CALL

			if (combinedRequest.getEsRequestComplexTypeChoice()
					.getEntitlementBySnRequest().getIncludeWarranty() == true
					|| combinedRequest.getEsRequestComplexTypeChoice()
							.getEntitlementBySnRequest()
							.getIncludeServiceNotes() == true) {

				// generate WarrantyRequest
				EsRequestComplexType wRequest = createWarrantyRequest(combinedRequest);
				// call the GetWarrantyEntitlement operation
				ESLog.debug("Calling GetWarrantyEntitlement operation");
				WarrantyRequester wRequester = new WarrantyRequester(
						getOperationManager(), combinedRequest
								.getEsRequestComplexTypeChoice()
								.getEntitlementBySnRequest()
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
					// TODO throw (DatabaseDownException) cctException;
				}
				if (cctException instanceof SifException) {
					throw (SifException) cctException;
				}
				ESLog.error("Unexpected exception", cctException);
				throw ErrorFactory
						.getSifException(ErrorFactory.id9999_INTERNAL_ERROR);
			}

			// Duplicate Check for CATS
			checkDuplicateCATS(replyCreator, context);
			if (context.getCatsWarrantyEntitlement() != null) {
				// calculate the overall warranty (startdate/enddate/status)
				context.calculateOverallWarrantyEntitlementForCATS(replyCreator
						.getWarrantyReply().getReply().getEsReplyChoice()
						.getWarrantyEntitlement());
			}
			// create and return the reply
			EsReply reply = replyCreator.create();

			// We also need to check that a product ID was provided as input
			// parameter!
			if (combinedRequest.getEsRequestComplexTypeChoice()
					.getEntitlementBySnRequest().getIncludeServiceNotes()
					&& reply.getEsReplyChoice().getCombinedUnitEntitlement() != null) {
				EntitlementBySnRequest snRequest = combinedRequest
						.getEsRequestComplexTypeChoice()
						.getEntitlementBySnRequest();
				EsRequestComplexType wRequestServiceNote = createServiceNoteWarrantyRequest(
						reply, snRequest.getSerialNumber(), snRequest
								.getProductID());
				ServiceNoteIntegration integ = ServiceNoteIntegration
						.getInstance();
				ServiceNoteTransaction snTrans = null;

				try {
					snTrans = (ServiceNoteTransaction) integ.execute(
							wRequestServiceNote, metricsHandler);

					if (snTrans.getMappedErrors() == null
							&& snTrans.getMappedReply() != null) {
						reply.getEsReplyChoice().getCombinedUnitEntitlement()
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
		 * 
		 * TODO:
		 * This should be changed so that the Service Notes should rather be
		 * using the EsReply
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
		wr.setSerialNumber(reqSerialNumber);
		if (reqProductId != null) {
			wr.setProductID(reqProductId);
		} else {
			CombinedUnitEntitlementComplexType combinedUnitEntitlement = reply
					.getEsReplyChoice().getCombinedUnitEntitlement();
			if (combinedUnitEntitlement.getOOS() != null) {
				System.out.println("getOOS");
				if (combinedUnitEntitlement.getOOS().getProduct() != null) {
					System.out.println("getProduct");
					wr.setProductID(combinedUnitEntitlement.getOOS()
							.getProduct().getProductID());
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
	 * 
	 * @roseuid 3E6F2D770264
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
	 * @roseuid 3E6F279500F6
	 */
	protected void verifyRequest(EsRequestComplexType request,
			MetricsHandler metricsHandler) throws SifException {
		EntitlementBySnRequest entBySnRequest = request
				.getEsRequestComplexTypeChoice().getEntitlementBySnRequest();
		if (entBySnRequest == null) {
			throw ErrorFactory.getSifException(
					ErrorFactory.id120_INVALID_REQUEST,
					"The GetEntitlementBySn operation requires an "
							+ "EntitlementBySnRequest request.");
		}

		checkMandatoryParameter(entBySnRequest.getSerialNumber(),
				"SerialNumber",
				"The parameter SerialNumber is missing in GetEntitlementBySnOperation");

		if ((entBySnRequest.getIncludeWarranty() == false)
				&& (entBySnRequest.getIncludeContracts() == false)
				&& (entBySnRequest.getIncludeServiceNotes() == false)) {
			throw ErrorFactory
					.getSifException(
							ErrorFactory.id120_INVALID_REQUEST,
							"The GetEntitlementBySn operation requires at least "
									+ "IncludeWarranty or IncludeContracts set to 'true'");
		}
		EsCheckDateRange.verifyDate(entBySnRequest.getEntitlementCheckDate());
		SerialNumberValidator.verifyInvalidSerialNumber(entBySnRequest
				.getSerialNumber());
		SerialNumberValidator
				.verifyInvalidSerialNumberPrefix(entBySnRequest
						.getSerialNumber());
		SerialNumberValidator.verifyInvalidSerialNumberSuffix(entBySnRequest.getSerialNumber());
		if( (entBySnRequest.getProductID()!=null) && (entBySnRequest.getProductID().trim().length()!=0)){
			int maximum=Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_PN_MAXLENGTH,20);
			ProductNumberValidator.verifyProductNumberGreaterThan(entBySnRequest.getProductID(), maximum);
		}

	}

	/**
	 * Creates a new EsRequest with an warranty request
	 * 
	 * @param combinedRequest
	 * @return EsRequest with WarrantyRequest
	 */
	private EsRequestComplexType createWarrantyRequest(
			EsRequestComplexType combinedRequest) {
		EntitlementBySnRequest snRequest = combinedRequest
				.getEsRequestComplexTypeChoice().getEntitlementBySnRequest();
		EsRequestComplexType wRequest = new EsRequestComplexType();
		wRequest
				.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
		wRequest.setOperation("getWarrantyEntitlement");
		wRequest.setClientAppID(combinedRequest.getClientAppID());
		WarrantyRequest wr = new WarrantyRequest();
		wr.setSerialNumber(snRequest.getSerialNumber());
		wr.setProductID(snRequest.getProductID());
		wr.setIsoCountryCd(snRequest.getIsoCountryCd());
		wr.setEntitlementCheckDate(snRequest.getEntitlementCheckDate());
		wr.setProofPurchaseDate(snRequest.getProofPurchaseDate());
		wr.setServiceID(snRequest.getServiceID());
		wr.setMarketSegment(snRequest.getMarketSegment());
		wr.setGeoCode(snRequest.getGeoCode());
		wr.setIncludeServiceNotes(snRequest.getIncludeServiceNotes());
		wr.setIncludeWorkings(snRequest.getIncludeWorkings());
		wr.setSourceSystem(snRequest.getWarrantySourceSystem());

		/*
		 * Request parameters for 3G functionality (OWNERSHIPTYPE and
		 * PARTLEVELWARRANTY) .
		 */
		String ownershiptype = snRequest.getCustomerOwnershipType();
		if (ownershiptype != null) {
			wr.setCustomerOwnershipType(ownershiptype);
		}

		if (snRequest.getIncludePartLevelWarranty()) {
			wr.setIncludePartLevelWarranty(true);
		}

		// in case both SN&PN were provided we want to make sure getWtyEnt wont
		// ever return a UnitList (same SN but different PN found) - see WITS
		// 584
		wr.setIncludeAddresses(snRequest.getIncludeAddresses());
		wr.setIncludeCATS(snRequest.getIncludeCATS());
		wRequest.getEsRequestComplexTypeChoice().setWarrantyRequest(wr);
		return wRequest;
	}

	/**
	 * CATS agreement information: Duplicate Data Filter:
	 * 
	 * It needs to be checked if the CATS Agreement is already available as a
	 * Care Pack (from WWPACK), to avoid to display duplicate information. The
	 * Care Pack Serial Number from both replies is used to check if duplicated
	 * information had been received. In case of duplicate data, the WWPACK
	 * information takes precedence.
	 * 
	 * ES just check this in getEntitlementBySn operation.
	 * 
	 */

	private void checkDuplicateCATS(ReplyCreator replyCreator,
			OperationContext context) {
		ESLog.debug("Enter");
		WarrantyComplexType catsWarranty = null;
		ContractComplexType[] contract = null;

		WarrantyEntitlementComplexType catsWE = context
				.getCatsWarrantyEntitlement();
		if (catsWE != null && catsWE.getWarrantyCount() > 0)
			catsWarranty = catsWE.getWarranty()[0];
		else
			return;

		RequesterReply cReply = replyCreator.getContractReply();
		if (cReply != null
				&& cReply.getReply() != null
				&& cReply.getReply().getEsReplyChoice() != null
				&& cReply.getReply().getEsReplyChoice()
						.getCombinedUnitEntitlement() != null
				&& cReply.getReply().getEsReplyChoice()
						.getCombinedUnitEntitlement().getContractCount() > 0)
			contract = cReply.getReply().getEsReplyChoice()
					.getCombinedUnitEntitlement().getContract();
		else
			return;

		for (int i = 0; i < contract.length; i++) {
			String carePackSN = contract[i].getHPCarePackSerialNumber();
			if (carePackSN != null
					&& carePackSN.equalsIgnoreCase(catsWarranty
							.getWarrantyComment())) {
				// remove the this warranty
				ESLog
						.debug("Duplicate Data: CATS Agreement is already available as a Care Pack (from WWPACK). The WWPACK information takes precedence");
				replyCreator.getWarrantyReply().getReply().getEsReplyChoice()
						.getWarrantyEntitlement().removeWarranty(catsWarranty);
				context.setCatsWarrantyEntitlement(null);
				return;
			}
		}
	}

	
}
