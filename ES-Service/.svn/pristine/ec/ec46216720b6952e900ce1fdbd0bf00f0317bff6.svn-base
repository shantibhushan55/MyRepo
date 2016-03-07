/*
 * Created on Mar 8, 2006
 *
 */
package com.hp.es.service.contractEntitlement;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.ProductNumberValidator;
import com.hp.es.service.contractEntitlement.orchestration.ContractOrchestration;
import com.hp.es.service.operations.EsOperation;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author gary_w_smith
 */
public class GetContractEntitlementOperation extends EsOperation {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hp.es.service.operations.EsOperation#verifyRequest(com.hp.es.xml.service.EsRequestComplexType,
	 *      com.hp.ruc.metrics.MetricsHandler)
	 */
	protected void verifyRequest(EsRequestComplexType request,
			MetricsHandler metricsHandler) throws SifException {

		ContractRequest cr = request.getEsRequestComplexTypeChoice()
				.getContractRequest();
		if (cr == null) {
			throw ErrorFactory.getSifException(
					ErrorFactory.id120_INVALID_REQUEST,
					"The GetContractEntitlement operation requires an "
							+ "ContractRequest request.");
		}

		checkMandatoryParameter(
				cr.getContractIdentifier(),
				"ContractIdentifier",
				"The parameter ContractIdentifier is missing in GetContractEntitlementOperation");

		EsCheckDateRange.verifyDate(cr.getEntitlementCheckDate());
		if( (cr.getProductID()!=null) && (cr.getProductID().trim().length()!=0)){
			int maximum=Configuration.getInstance().getProperties().getIntegerProperty(EsConstants.ES_PN_MAXLENGTH,20);
			ProductNumberValidator.verifyProductNumberGreaterThan(cr.getProductID(), maximum);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hp.es.service.operations.EsOperation#execute(com.hp.es.xml.service.EsRequestComplexType,
	 *      com.hp.ruc.metrics.MetricsHandler)
	 */
	protected EsReply execute(EsRequestComplexType request, OperationContext context,
			MetricsHandler metricsHandler) throws SifException {

		EsReply reply = null;
		ESLog.debug("Enter");

		ESLog.debug("Sending request to orchestration");
		reply = ContractOrchestration.getInstance().execute(request, context, metricsHandler);

		ESLog.debug("End");
		return reply;
	}

	/*
	 * 
	 * The GetContractEntitlementOperation should init the
	 * Orchestration 
	 * @see com.hp.es.service.operations.Operation#init()
	 */
	protected void init() {
		ContractOrchestration.getInstance();
	}


}