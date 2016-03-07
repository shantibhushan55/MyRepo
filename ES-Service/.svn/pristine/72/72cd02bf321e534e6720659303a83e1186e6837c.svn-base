/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/serviceHandler/EsOperation.java 1.6 2004-07-14 08:30:46+02 stefsobe Exp $
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
 * $Log: EsOperation.java,v $
 * Revision 1.6  2004-07-14 08:30:46+02  stefsobe
 * Author: stefsobe@15.96.140.246 ()
 * move execution of RequestCleaner from EsServiceHandler to EsOperation
 *
 * Revision 1.5  2004-07-02 12:34:35+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * add checkMandatoryParameter
 *
 * Revision 1.4  2004-05-08 04:40:56+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.3  2004-05-05 15:39:34+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.2  2004-01-29 18:05:11+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.1  2003-08-19 13:32:45+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.operations;

import com.hp.es.service.RequestCleaner;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Base class for all ES operations
 */
public abstract class EsOperation extends Operation {

	/**
	 * This method needs to be implemented by the sub classes. It should verify
	 * the data of the request and throw an exception if the request cannot be
	 * processed because of incorrect or missing date.
	 */
	abstract protected void verifyRequest(EsRequestComplexType request,
			MetricsHandler metricsHandler) throws SifException;

	/**
	 * This method needs to be implemented by the sub classes. It should verify
	 * the data of the request and throw an exception if the request cannot be
	 * processed because of incorrect or missing date.
	 */
	abstract protected EsReply execute(EsRequestComplexType request,
			OperationContext context, MetricsHandler metricsHandler)
			throws SifException;

	/**
	 * Make sure that the request is of type EsRequestComplexType and call the
	 * verifyRequest method of the sub classes
	 */
	protected void validateRequest(Object request, MetricsHandler metricsHandler)
			throws SifException {

		if (request instanceof EsRequestComplexType) {
			verifyRequest((EsRequestComplexType) request, metricsHandler);
		} else {
			throw ErrorFactory.getSifException(
					ErrorFactory.id120_INVALID_REQUEST,
					"The ES operation requires an request of the type "
							+ "EsRequestComplexType.");
		}
	}

	/**
	 * This method is used to check request parameter
	 */
	protected void checkMandatoryParameter(String value, String field,
			String explanation) throws SifException {
		if (value == null) {
			throw ErrorFactory.getSifException(
					ErrorFactory.id200_MISSING_PARAMETER, explanation);
		} else if (value.trim().length() == 0) {
			throw ErrorFactory.getSifException(
					ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA, field);
		}
	}

	/**
	 * This method is used to check request parameter it also checks the max
	 * length of a field (>)
	 */
	protected void checkMandatoryParameter(String value, String field,
			int maxlength, String explanation) throws SifException {
		checkMandatoryParameter(value, field, explanation);
		if (value.trim().length() > maxlength) {
			throw ErrorFactory.getSifException(
					ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA, field);
		}
	}

	/**
	 * Just forward the request to the execute() method
	 */
	protected Object process(Object request, OperationContext context,
			MetricsHandler metricsHandler) throws SifException {
		EsRequestComplexType esRequest = (EsRequestComplexType) request;
		RequestCleaner.cleanThisRequest(esRequest);
		return execute(esRequest, context, metricsHandler);
	}
	

	/*
	 * Guess the message type
	 */
	protected String getMessageType(EIAMessage eiaMessage) {
		if(eiaMessage != null) {
			if (eiaMessage.getMessageHeader() != null && eiaMessage.getMessageHeader().getMessageType() != null) {
				return eiaMessage.getMessageHeader().getMessageType().value();
			}
			if(eiaMessage.getMessageBody()!= null && eiaMessage.getMessageBody().getEsReply() != null) {
				return "reply";
			}
			if(eiaMessage.getMessageBody()!= null && eiaMessage.getMessageBody().getEsRequest() != null) {
				return "request";
			}
			if(eiaMessage.getMessageBody()!= null && eiaMessage.getMessageBody().getEIAError() != null) {
				return "error";
			}
		}
			
			
		return null;
	}

}
