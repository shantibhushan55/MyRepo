package com.hp.es.service.transactionLogging;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.TransactionIdGenerator;
import com.hp.es.service.util.xml.EIAErrorHelper;
import com.hp.es.service.util.xml.EIAMessageHelper;
import com.hp.es.tm.Transaction;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.types.MessageTypeType;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class EsTransactionHelper {
	private boolean tmEnable = false;

	/**
	 * EsTransactionHelper disable constructor
	 */
	private EsTransactionHelper() {
		super();
		tmEnable = Configuration.getInstance().getProperties().getBoolean(
				EsConstants.ES_TM_ENABLED);
	}

	/*
	 * singleton
	 */
	private static EsTransactionHelper instance = new EsTransactionHelper();

	public void sendTransactionToTransactionLoggingMessageSender(EsRequestComplexType esRequest,
			EsReply esReply,EsReply replybeforeFraud, ComplianceValidationReply cvsReply, String transactionId, long startTime, long endTime,MetricsHandler handler) {
		if (!tmEnable)
			return;
		
		EIAMessage	eiaRequest, eiaReply,eiaReplyBeforeFraud;
		eiaRequest = convertEsRequestToEiaRequest(esRequest,transactionId);
		eiaReply   = convertEsReplyToEiaReply(esReply,transactionId);
		eiaReplyBeforeFraud   = convertEsReplyToEiaReply(replybeforeFraud,transactionId);
		sendTransactionToTransactionLoggingMessageSender(eiaRequest, eiaReply,eiaReplyBeforeFraud,cvsReply, startTime,endTime, handler);

	}

	public void sendTransactionToTransactionLoggingMessageSender(EsRequestComplexType esRequest,
			SifException e,String transactionId, long startTime, long endTime,MetricsHandler handler) {
		if (!tmEnable)
			return;

		EIAMessage	eiaRequest, eiaReply;
		eiaRequest = convertEsRequestToEiaRequest(esRequest,transactionId);
		eiaReply   = convertSifExceptionToEiaReply(e,transactionId);
		/*
		 * change hard coded null to eiaReply used by Worker: processNextSubRequest
		 */
		sendTransactionToTransactionLoggingMessageSender(eiaRequest, eiaReply,eiaReply,null, startTime,
				endTime, handler);

	}


	public void sendTransactionToTransactionLoggingMessageSender(EIAMessage eiaRequest,
			EIAMessage eiaReply, EIAMessage replybeforeFraud, ComplianceValidationReply cvsReply, long startTime, long endTime,MetricsHandler handler) {
        MetricsEntry entry = null;
        if (handler!=null) {
        	entry = handler.addEntry("ComplianceValidationReply.callComplianceValidationService()");
        	entry.actionStart();
        }
		try  {
			if (!tmEnable) {
				if (ESLog.isDebugLogEnabled())
					ESLog.debug("TM is not enabled");
			} else {
				synchronized (EsTransactionHelper.class) {
					/*
					 * We start the sender thread if not started
					 */
	
					if (!TransactionLoggingMessageSender.getInstance().isRunning()) {
						Thread thread = new Thread(TransactionLoggingMessageSender.getInstance());
						thread.start();
					}
				}
				ESLog.debug("ENTER");
				Transaction trans = buildTransaction(startTime, endTime,eiaRequest, eiaReply,replybeforeFraud,  cvsReply);
				TransactionLoggingMessageSender.getInstance().addToTransactionQueue(trans);
	
			}
		}finally {
            if (entry!=null)
                entry.actionDone();
		}
	}	
	
	
	
	
		private EIAMessage convertEsReplyToEiaReply(EsReply esReply,String transactionId){
		EIAMessage eiaMessage = EIAMessageHelper.createEmptyEIAReplyMessage(transactionId);
		eiaMessage.getMessageBody().setEsReply(esReply);
		return eiaMessage;
	}

	private EIAMessage convertEsRequestToEiaRequest(EsRequestComplexType esRequest,String transactionId)  {
		EIAMessage eiaMessage = EIAMessageHelper.createEmptyEIARequestMessage(transactionId);
		eiaMessage.getMessageBody().setEsRequest(esRequest);

		return eiaMessage;
	}	
	

	private EIAMessage convertSifExceptionToEiaReply(SifException e, String transactionId) {
		EIAMessage errorMessage = null;
		EIAError error = EIAErrorHelper.toEIAError(e);
		/*
		 * We are copying the content of the request Message in the error reply
		 */

		errorMessage = EIAMessageHelper.createEmptyEIAErrorMessage (transactionId);
		errorMessage.getMessageHeader().setMessageType(MessageTypeType.ERROR);
		//errorMessage.getMessageHeader().setMessageID(transactionId);
		
		errorMessage.getMessageBody().setEsRequest(null);
        errorMessage.getMessageBody().setEsReply(null);
        errorMessage.getMessageBody().setEIAError(error);
		
		
		return errorMessage;
	}


	/*
	 * This method build a transaction object for fraud
	 */
	private Transaction buildTransaction(long startTime, long endTime,
			EIAMessage eiaRequest, EIAMessage eiaReply,EIAMessage eiaReplybeforeFraud,ComplianceValidationReply cvsReply  ) {
		Transaction transaction = new Transaction();
		transaction.setStartDate(startTime);
		transaction.setEndDate(endTime);
		transaction.setRequest(eiaRequest);
		transaction.setReply(eiaReplybeforeFraud);
		transaction.setReplyAfterFraud(eiaReply);
		transaction.setComplianceServiceReply(cvsReply);
		

		return transaction;
	}

	/**
	 * @return the instance
	 */
	public static EsTransactionHelper getInstance() {
		return instance;
	}

	public void sendTransactionToTransactionLoggingMessageSender(
			EIAMessage request, SifException e, long startTime, long endTime, MetricsHandler handler) {
		EIAMessage	eiaRequest, eiaReply;
		 
		if(request != null) {
			if(request.getMessageHeader()== null || request.getMessageHeader().getMessageID() == null ) {
				ESLog.debug("Enter sendTransaction To TransactionLoggingMessageSender to get Transaction!");
				request.getMessageHeader().setMessageID(TransactionIdGenerator.getInstance().nextId());
			}
			
			eiaReply   = convertSifExceptionToEiaReply(e,request.getMessageHeader().getMessageID());
			/*
			 * change hard coded null to eiaReply used by EsHttpListener: processRequest
			 */
			sendTransactionToTransactionLoggingMessageSender(request, eiaReply,eiaReply,null, startTime,
					endTime, handler);
		}
		
	}


}
