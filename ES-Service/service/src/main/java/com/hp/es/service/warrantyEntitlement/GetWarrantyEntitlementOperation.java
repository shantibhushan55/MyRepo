/*
 * Project: HPS Entitlement Service
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
 */
package com.hp.es.service.warrantyEntitlement;

import java.util.Date;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.ProductNumberValidator;
import com.hp.es.service.SerialNumberValidator;
import com.hp.es.service.catsAgreement.GetCatsAgreementOperation;
import com.hp.es.service.manufacturingHeaderInformation.orchestration.ManufacturingInstalledBaseServiceOrchestraction;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyOrchestration;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 *
 */
public class GetWarrantyEntitlementOperation extends EsOperation  {

	private boolean snrEnable;

	/**
	 * Nothing to do
	 */
	public GetWarrantyEntitlementOperation() {
	}

	/**
	 * This method has to be imeplemented by the sub classes. It processes the
	 * the requests and return an EsReply, which is sent back to the client.
	 * 
	 * @param request
	 *            the request that was sent from the client
	 * @param metricsHandler
	 * @throws SifException
	 *             Thrown when the request couldn't be processed successfully.
	 * @return EsReply the reply that can be sent back to the client
	 */
	protected EsReply execute(EsRequestComplexType request,
			OperationContext context, MetricsHandler metricsHandler)
			throws SifException {

		String methodId = "GetWarrantyEntitlementOperation.execute()";
		MetricsEntry overallTime = null;
		if (metricsHandler != null)
			overallTime = metricsHandler.startEntry(methodId);

		EsReply esReply = null;
		EsReply esReplyFromMIBService = null;
		SifException seFromMIBService = null;

		try {
			/*
			 * todo replace this field
			 */
			snrEnable=Configuration.getInstance().getProperties().getBoolean(EsConstants.SNR_ENABLE);
			if(snrEnable) {
				/*
				 * Only work if the operation was bysn or warranty
				 * does not work for getentbypn
				 */
				if (EsConstants.GET_WAR_ENT.equalsIgnoreCase(context.getOriginalOperationName())
						|| EsConstants.GET_ENT_BY_SN.equalsIgnoreCase(context.getOriginalOperationName())) {
					/* call SNR only when the SN provided in the request*/
					if(request != null && request.getEsRequestComplexTypeChoice() != null 
							&& request.getEsRequestComplexTypeChoice().getWarrantyRequest() != null 
							&& request.getEsRequestComplexTypeChoice().getWarrantyRequest().getSerialNumber() != null 
			    			&& request.getEsRequestComplexTypeChoice().getWarrantyRequest().getSerialNumber().trim().length()>0){
						
						try {
							esReplyFromMIBService = ManufacturingInstalledBaseServiceOrchestraction.getInstance().execute(request, context, metricsHandler);
							/*
							 * we'll need to store the unit list 
							 */
							if(esReplyFromMIBService != null && esReplyFromMIBService.getEsReplyChoice() !=null && esReplyFromMIBService.getEsReplyChoice().getUnitList() != null) {
								ESLog.debug("SNR have returned a unit list, we keep it for now");
								//return esReplyFromMIBService;
							}
						}catch (SifException se) {
							ESLog.debug("SNR have returned an exception , we store it for further usage");
							seFromMIBService = se;
						}
						context.setManufacturingInstalledBaseServicEsReply(esReplyFromMIBService);
						context.setManufacturingInstalledBaseServiceSifException(seFromMIBService);
	
					}
				}
			}

			
			esReply = WarrantyOrchestration.getInstance().execute(request,context, metricsHandler);

			// Get Cats agreement information (New feature since ES Sirocco
			// 10.1.1).
			if (EsConstants.GET_WAR_ENT.equalsIgnoreCase(context.getOriginalOperationName())
					|| EsConstants.GET_ENT_BY_SN.equalsIgnoreCase(context.getOriginalOperationName())) {
				GetCatsAgreementOperation catsOperation = new GetCatsAgreementOperation();
				context.setEsReplyOfSwop(esReply);
				catsOperation.execute(request, context, metricsHandler);
				// Calculate Overall warranty entitlement summary
				WarrantyEntitlementComplexType catsWE = context
						.getCatsWarrantyEntitlement();
				if (catsWE != null
						&& EsConstants.GET_WAR_ENT.equalsIgnoreCase(context
								.getOriginalOperationName())) {
					context.calculateOverallWarrantyEntitlementForCATS(esReply
							.getEsReplyChoice().getWarrantyEntitlement());
				}
			}
		} finally {
			if (overallTime != null)
				overallTime.actionDone();
		}
		return esReply;
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
		// This cannot be working well as the request need to be cleanup
		WarrantyRequest wr = request.getEsRequestComplexTypeChoice()
				.getWarrantyRequest();
		if (wr == null) {
			throw ErrorFactory
					.getSifException(ErrorFactory.id120_INVALID_REQUEST,
							"The GetWarrantyEntitlement operation requires a Warranty request.");
		}
		// We first check ISO country code
		checkMandatoryParameter(wr.getIsoCountryCd(), "IsoCountryCd()",
				"The parameter IsoCountryCd is missing in GetWarrantyEntitlementOperation");

		// If there is a proof of purchase date. It needs to be NOT in future.
		if (wr.getProofPurchaseDate() != null) {
			Date d = wr.getProofPurchaseDate().toDate();
			if (d.after(new Date())) {
				throw ErrorFactory
						.getSifException(
								ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
								"The parameter ProofOfPurchaseDate must NOT be a date in future.");
			}

		}

		// If we have a spare part number we must have ProofPurchaseDate, unit
		// Serial Number or DateCode is required
		if (wr.getSparePartNumber() != null
				&& wr.getSparePartNumber().trim().length() > 0) {
			if (wr.getProofPurchaseDate() == null
					&& (wr.getSerialNumber() == null || wr.getSerialNumber()
							.trim().length() == 0)
					&& (wr.getDateCode() == null || wr.getDateCode().trim()
							.length() == 0)) {
				throw ErrorFactory
						.getSifException(ErrorFactory.id200_MISSING_PARAMETER,
								"SparePartNumber requires proof of Purchase Date or serial number or date code");
			}
		}

		// If we have a spare part number we must have ProofPurchaseDate, unit
		// Serial Number or DateCode is required
		if ((wr.getSparePartNumber() == null || wr.getSparePartNumber().trim()
				.length() == 0)
				&& (wr.getSerialNumber() == null || wr.getSerialNumber().trim()
						.length() == 0)
				&& (wr.getProductID() == null || wr.getProductID().trim()
						.length() == 0)) {
			throw ErrorFactory
					.getSifException(
							ErrorFactory.id200_MISSING_PARAMETER,
							"Warranty entitlement requires SparePartNumber, proof Of Purchase Date or serial number or date code");
		}
		int minLength = Configuration.getInstance().getProperties()
				.getIntegerProperty(EsConstants.ES_SN_MINLENGTH);

		SerialNumberValidator.verifySerialNumberLessThan(wr.getSerialNumber(),
				minLength);
		SerialNumberValidator.verifyInvalidSerialNumber(wr
				.getSerialNumber());
		SerialNumberValidator.verifyInvalidSerialNumberPrefix(wr
				.getSerialNumber());
		SerialNumberValidator.verifyInvalidSerialNumberSuffix(wr.getSerialNumber());
		if( (wr.getProductID()!=null) && (wr.getProductID().trim().length()!=0)){
			int maximum=Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_PN_MAXLENGTH,20);
			ProductNumberValidator.verifyProductNumberGreaterThan(wr.getProductID(), maximum);
		}
	}
}