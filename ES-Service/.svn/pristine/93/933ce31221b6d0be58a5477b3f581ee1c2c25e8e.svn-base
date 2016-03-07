/**
 * 
 */
package com.hp.es.tm.service;

import java.math.BigDecimal;

import com.hp.es.service.util.ESLog;
import com.hp.es.tm.util.exception.TmException;
import com.hp.es.xml.service.EIAMessage;

/**
 * @author ANVOI
 *
 */
final class  RequestHelper {

	/**
	 * 
	 */
	private RequestHelper() {
	}

	/*
	 * Get the client app id
	 */
	static String getClientAppId (EIAMessage request) {
		String clientAppId = null;
		if(request.getMessageBody() != null){
			if(request.getMessageBody().getEsRequest() != null){
				clientAppId = request.getMessageBody().getEsRequest().getClientAppID();
				if(clientAppId == null || clientAppId.trim().length() < 1){
					ESLog.debug("use UserName to replace clientAppId");
					clientAppId = request.getMessageHeader().getMessageSecurity().getSecurityCredentials().getUserName();
				}
				ESLog.debug("ES Client AppId=" + clientAppId);
			}
		}
		return clientAppId;
	}
	
	
	/*
	 * Get the client app id
	 */
	static String getESOperation (EIAMessage request) {
		String esOperation = null;
		if(request.getMessageBody() != null){
			if(request.getMessageBody().getEsRequest() != null){
				esOperation = request.getMessageBody().getEsRequest().getOperation();
				ESLog.debug("ES Operation=" + esOperation);
			}
		}
		return esOperation;
	}
	
	public static BigDecimal getTransactionId(EIAMessage request) throws TmException {
		if(null == request.getMessageHeader()|| null == request.getMessageHeader().getMessageID()
				|| request.getMessageHeader().getMessageID().length() == 0) {
			ESLog.error("Transaction ID is null");
			throw new TmException(
					"Transaction ID is null");
		}
		return new BigDecimal(request.getMessageHeader().getMessageID());
	}
	
}
