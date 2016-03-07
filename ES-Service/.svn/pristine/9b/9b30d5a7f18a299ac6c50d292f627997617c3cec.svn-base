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
package com.hp.es.service.contractSummary.integration;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractSummary.integration.mapping.CQSSummaryRequestMapper;
import com.hp.es.service.contractSummary.integration.mapping.ContractSummaryMapper;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public class CQSGetContractSummaryIntegration  extends CQSContractSummaryIntegration{

	/**
	 * 
	 */
	public CQSGetContractSummaryIntegration(String regionName) {
		super(regionName);
	}
	
	public ContractSummaryTransaction doContractSummaryIntegration(EsRequestComplexType request, MetricsHandler handler) throws SifException {
		ESLog.debug("Mapping ES request to CQS request");
		// map ES request to CQS request
		Object cqsRequest = mapEsRequest2CQSRequest(request);
		// pass request to the region and get the result
		Transaction transaction = null;
		try {
			ESLog.debug("Send request to CQS using Region: " + _region.getConfiguration().getRegionName()); 

			transaction = _region.execute(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_SUM, cqsRequest, getRegionDisplayName(),isLocal(),handler);	

		} catch (Exception e) {
			if(ESLog.isDebugLogEnabled())
				ESLog.debug("Exception while connecting to CQS", e);
				
			ESLog.error("Exception while connecting to CQS"+ e.getMessage());
			if (e instanceof SifException) {
				throw (SifException)e;
			}else {
	            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
	            		"Exception while connecting to CQS", e.toString());
			}
		}
		
		// Check the reply for any errors
		if(transaction.isSourceSystemError()) {
			// CQS ERRORS
			mapSourceSystemError2ComposedErrors((ContractSummaryTransaction) transaction, request);
			return (ContractSummaryTransaction) transaction;
		}else if (transaction instanceof ErrorTransaction) {
			ESLog.debug("We have an error ...");
			// ERROR
			// There is no need to do anything here, it will be done in the composition layer
			// so we simply return the transaction
			
			return mapErrorTransaction2ComposedErrors(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT,(ErrorTransaction)transaction);
		} else  {
			ESLog.debug("We have a sucessfull reply ...");
			// NORMAL REPLY
			
			mapCQSReply2EsReply((ContractSummaryTransaction) transaction, request);
			return (ContractSummaryTransaction) transaction;
		}				
	}

	/**
	 * @param esRequest
	 * @return an reply suitable for input to Region.execute()
	 */
	public Object mapEsRequest2CQSRequest(EsRequestComplexType esRequest) {
		return CQSSummaryRequestMapper.getInstance().map(esRequest);
	}

	protected void mapCQSReply2EsReply(ContractSummaryTransaction transaction, EsRequestComplexType request) throws SifException {
		ESLog.debug("start");
		ContractSummaryMapper mapper = ContractSummaryMapper.getInstance(transaction, request);
		try {
			ESLog.debug("Creating the reply structure");
			EsReply reply = new EsReply();
			reply.setEsHeader(new EsHeader());
			reply.getEsHeader().setInputRequest(request);
			ESLog.debug("Warnings will be mapped");
			reply.getEsHeader().setWarnings(mapWarnings(transaction));
			reply.setEsReplyChoice(new EsReplyChoice());
			ESLog.debug("A ContractSummary will be mapped");
			reply.getEsReplyChoice().setContractSummary(mapper.map());
			if(request.getEsRequestComplexTypeChoice().getContractSummaryRequest().getIncludeWorkings()) {
				reply.getEsReplyChoice().getContractSummary().addWorking(mapWorking(transaction));
			}
			transaction.setMappedReply(reply);

		}catch(MappingException e) {
			ESLog.info("Exception while mapping", e);
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"");
		}
		
		ESLog.debug("end");		
		
	}

}
