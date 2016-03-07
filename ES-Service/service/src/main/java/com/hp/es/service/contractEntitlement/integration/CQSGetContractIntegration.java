/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.integration.mapping.CQSRequestMapper;
import com.hp.es.service.contractEntitlement.integration.mapping.ContractEntitlementMapper;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
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
 * @author ANVOI
 *
 */
public class CQSGetContractIntegration extends CQSIntegration {

	/**
	 * 
	 */
	public CQSGetContractIntegration(String regionName) {
		super(regionName);
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.contractEntitlement.integration.CQSIntegration#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 * @param request
	 * @param handler
	 * @return a Reply
	 */
	public ContractTransaction doContractIntegration(EsRequestComplexType request, MetricsHandler handler)
			throws SifException {


		ESLog.debug("Mapping ES request to CQS request");
		// map ES request to CQS request
		Object cqsRequest = mapEsRequest2CQSRequest(request);
		
		// pass request to the region and get the result
		Transaction transaction = null;
		try {
			ESLog.debug("Send request to CQS using Region: " + _region.getConfiguration().getRegionName()); 
				transaction = _region.execute(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT, 
						cqsRequest, getRegionDisplayName(),isLocal(),handler);
				
		} catch (Exception e) {
			if(ESLog.isDebugLogEnabled())
				ESLog.debug("Exception while connecting to CQS", e);
			
			ESLog.error("Exception while connecting to CQS"+ e.getMessage());
			if (e instanceof SifException) {
				throw (SifException)e;
			}
	            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
	            		"Exception while connecting to CQS", e.toString());
		}
				
		// Check which reply we have error, unit list, or normal reply
		if(transaction.isSourceSystemError()) {
			// CQS ERRORS
			mapSourceSystemError2ComposedErrors((ContractTransaction) transaction, request);				
			return (ContractTransaction) transaction;
		}else if (transaction instanceof ErrorTransaction) {
			ESLog.debug("We have an error ...");
			// ERROR
			// There is no need to do anything here, it will be done in the composition layer
			// so we simply return the transaction
			return mapErrorTransaction2ComposedErrors(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT,(ErrorTransaction)transaction);				
		} else  {
			ESLog.debug("We have a reply ...");
			// NORMAL REPLY
			mapCQSReply2EsReply((ContractTransaction) transaction, request);
			return (ContractTransaction) transaction;
		}		
	}


	/* @param the transaction (in/out)
	 * @param the request
	 * @throws SifException
	 * 
	 */
	protected void mapCQSReply2EsReply(ContractTransaction transaction, EsRequestComplexType request) throws SifException {
		ESLog.debug("start");
		ContractEntitlementMapper mapper = ContractEntitlementMapper.getInstance(transaction, request);
		
		try {
			ESLog.debug("Creating the reply structure");
			EsReply reply = new EsReply();
			reply.setEsHeader(new EsHeader());
			reply.getEsHeader().setInputRequest(request);
			ESLog.debug("Warnings will be mapped");
			reply.getEsHeader().setWarnings(mapWarnings(transaction));
			reply.setEsReplyChoice(new EsReplyChoice());
			ESLog.debug("A ContractEntitlement will be mapped");
			reply.getEsReplyChoice().setContractEntitlement(mapper.map());
			if(request.getEsRequestComplexTypeChoice().getContractRequest().getIncludeWorkings()) {
				reply.getEsReplyChoice().getContractEntitlement().addWorking(mapWorking(transaction));
			}
			transaction.setMappedReply(reply);

		}catch(MappingException e) {
			ESLog.info("Exception while mapping", e);
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"");
		}
		
		ESLog.debug("end");		
	}
	
	
	/**
	 * @param esRequest
	 * @return an reply suitable for input to Region.execute()
	 */
	public Object mapEsRequest2CQSRequest(EsRequestComplexType esRequest) {
		return CQSRequestMapper.getInstance().map(esRequest);
	}


}
