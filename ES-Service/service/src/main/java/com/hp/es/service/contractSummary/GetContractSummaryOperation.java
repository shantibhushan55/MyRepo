/*
 * Project: HPS Entitlement Service - Mercury Integration
 *
 * Copyright (c) 2007 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * Revision 1.0  
 * Author: olcay.yesilyurt@hp.com
 * Initial revision
 *
 */

package com.hp.es.service.contractSummary;

import java.util.Enumeration;

import com.hp.es.service.contractSummary.orchestration.ContractSummaryOrchestration;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.ContractSummaryRequest;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public class GetContractSummaryOperation extends EsOperation {


	public GetContractSummaryOperation() {
	}

	protected void verifyRequest(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		ContractSummaryRequest cr = request.getEsRequestComplexTypeChoice().getContractSummaryRequest();
		if (cr == null) {
			throw ErrorFactory.getSifException(
			ErrorFactory.id120_INVALID_REQUEST,
			"The GetContractSummary operation requires an "
					+ "ContractSummaryRequest request.");
		}

		checkMandatoryParameter(
				cr.getSvcAgreementID(),
				"SvcAgreementID",
			"The parameter SvcAgreementID is missing in GetContractSummaryOperation");

		EsCheckCSDateRange.verifyDate(cr.getEntitlementCheckDate());

		if((cr.getServiceableProductsOfferList() != null) && (cr.getServiceableProductsOfferList().getOfferCodeCount() > 0))
		{
			String offerList[] = cr.getServiceableProductsOfferList().getOfferCode();
			for (int i = 0; i < offerList.length; i++) {
				String offerCode = offerList[i];
				offerCode = offerCode.trim();
				if(offerCode.length() <=0){
					offerList[i] = null;
				}
				
			}
		}		
		
		
		if(cr.getServiceableProductsOnly())
		{
			if((cr.getServiceableProductsOfferList() != null) && (cr.getServiceableProductsOfferList().getOfferCodeCount() > 0))
			{
				Enumeration offerEnum = cr.getServiceableProductsOfferList().enumerateOfferCode();
				boolean isContentValid = false;
				while(offerEnum.hasMoreElements())
				{
					//String offerCode = ((String)offerEnum.nextElement()).replaceAll("\"", "");
					String offerCode = ((String)offerEnum.nextElement()).trim();
					if(offerCode.trim().length() > 0)
					{
						isContentValid = true;
						break;
					}
				}
				if(!isContentValid)
				{
					checkMandatoryParameter("","ServiceableProductsOfferList","ServiceableProductsOnly was set but the ServiceableProductsOfferList is empty");				
				}
			}
			else
			{
				checkMandatoryParameter("","ServiceableProductsOfferList","ServiceableProductsOnly was set but the ServiceableProductsOfferList is empty");				
			}
			
		}
	}

	
	/**
	 * @see com.hp.es.service.operations.EsOperation#execute(com.hp.es.xml.service.EsRequestComplexType,
	 *      com.hp.ruc.metrics.MetricsHandler)
	 */
	protected EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler) throws SifException {
		EsReply reply = null;
		ESLog.debug("Enter");

		ESLog.debug("Sending request to orchestration");
		reply = ContractSummaryOrchestration.getInstance().execute(request, context, metricsHandler);

		ESLog.debug("End");
		return reply;
	}
	
	/**
	 * 
	 * This methode initialize the Orchestration layer
	 *  
	 */
	protected void init() {
		ContractSummaryOrchestration.getInstance();		
	}



}
