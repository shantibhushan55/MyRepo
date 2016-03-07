package com.hp.es.service.util.xml;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.TransactionIdGenerator;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.MessageBody;
import com.hp.es.xml.service.MessageHeaderType;
import com.hp.es.xml.service.MessageSecurityType;
import com.hp.es.xml.service.MessageTrailerType;
import com.hp.es.xml.service.SecurityCredentialsType;
import com.hp.es.xml.service.ServiceDescriptorType;
import com.hp.es.xml.service.types.MessageTypeType;
import com.hp.sif.SifUtil;

public class EIAMessageHelper {

	public EIAMessageHelper() {
		super();
	}
    
    static public EIAMessage createEmptyEIAReplyMessage(String transactionId) {
        EIAMessage message = new EIAMessage();
        ESLog.debug("Enter createEmptyEIAReplyMessage To TransactionLoggingMessageSender to get Transaction!");
        //header
        message.setMessageHeader(new MessageHeaderType());
        if(stringNotEmpty(transactionId)&&!"0".equals(transactionId)){
			 message.getMessageHeader().setMessageID(transactionId);
		}else{
			message.getMessageHeader().setMessageID(TransactionIdGenerator.getInstance().nextId());
		}
        
        message.getMessageHeader().setTimeStamp(SifUtil.getLocalTimeStamp());
        message.getMessageHeader().setServiceDescriptor(new ServiceDescriptorType());
        message.getMessageHeader().getServiceDescriptor().setMajorVersion(EsConstants.ES_MAJOR_VERSION);
        message.getMessageHeader().getServiceDescriptor().setMinorVersion(EsConstants.ES_MINOR_VERSION);
        message.getMessageHeader().getServiceDescriptor().setServiceID(EsConstants.ES_SERVICE_ID);
        
        message.getMessageHeader().setMessageSecurity(new MessageSecurityType());
        message.getMessageHeader().getMessageSecurity().setSecurityCredentials(new SecurityCredentialsType());
        message.getMessageHeader().getMessageSecurity().getSecurityCredentials().setUserName(EsConstants.ES_DEFAULT_USER);
        message.getMessageHeader().getMessageSecurity().getSecurityCredentials().setUserPassword(EsConstants.ES_DEFAULT_PWD);
        message.getMessageHeader().setMessageType(MessageTypeType.REPLY);
        ///body
        message.setMessageBody(new MessageBody());
        message.getMessageBody().setEIAError(null);
        message.getMessageBody().setEsReply(null);
        message.getMessageBody().setEsRequest(null);

        //trailer
        message.setMessageTrailer(new MessageTrailerType());
        return message;
    }
    
	/*
	 * This method is used internally to create an empty eia message to receive an eror later on
	 * 
	 */
	static public EIAMessage createEmptyEIAErrorMessage(String transactionId) {
		 ESLog.debug("Enter createEmptyEIAErrorMessage "+transactionId+" To TransactionLoggingMessageSender to get Transaction!");
		EIAMessage message = new EIAMessage();
		//header
		message.setMessageHeader(new MessageHeaderType());
		//message.getMessageHeader().setMessageID("error");
		
		 if(stringNotEmpty(transactionId)&&!"0".equals(transactionId)){
			 message.getMessageHeader().setMessageID(transactionId);
		}else{
			message.getMessageHeader().setMessageID(TransactionIdGenerator.getInstance().nextId());
		}
		
		message.getMessageHeader().setTimeStamp(SifUtil.getLocalTimeStamp());
		message.getMessageHeader().setServiceDescriptor(new ServiceDescriptorType());
		message.getMessageHeader().getServiceDescriptor().setMajorVersion(EsConstants.ES_MAJOR_VERSION);
		message.getMessageHeader().getServiceDescriptor().setMinorVersion(EsConstants.ES_MINOR_VERSION);
		message.getMessageHeader().getServiceDescriptor().setServiceID(EsConstants.ES_SERVICE_ID);
		
		message.getMessageHeader().setMessageSecurity(new MessageSecurityType());
		message.getMessageHeader().getMessageSecurity().setSecurityCredentials(new SecurityCredentialsType());
		message.getMessageHeader().getMessageSecurity().getSecurityCredentials().setUserName(EsConstants.ES_DEFAULT_USER);
		message.getMessageHeader().getMessageSecurity().getSecurityCredentials().setUserPassword(EsConstants.ES_DEFAULT_PWD);
		message.getMessageHeader().setMessageType(MessageTypeType.ERROR);
		message.getMessageHeader().setMessageID(transactionId);
		///body
		message.setMessageBody(new MessageBody());
		message.getMessageBody().setEIAError(null);
		message.getMessageBody().setEsReply(null);
		message.getMessageBody().setEsRequest(null);

		//trailer
		message.setMessageTrailer(new MessageTrailerType());
		return message;
	}
		
	/*
	 * This method is used internally to create an empty eia message to receive an eror later on
	 * 
	 */
	static public EIAMessage createEmptyEIARequestMessage(String transactionId) {
		EIAMessage message = new EIAMessage();
		ESLog.debug("Enter createEmptyEIARequestMessage To TransactionLoggingMessageSender to get Transaction!");
		//header
		message.setMessageHeader(new MessageHeaderType());
		
		 if(stringNotEmpty(transactionId)&&!"0".equals(transactionId)){
			 message.getMessageHeader().setMessageID(transactionId);
		}else{
			message.getMessageHeader().setMessageID(TransactionIdGenerator.getInstance().nextId());
		}
        
        message.getMessageHeader().setTimeStamp(SifUtil.getLocalTimeStamp());
		message.getMessageHeader().setServiceDescriptor(new ServiceDescriptorType());
		message.getMessageHeader().getServiceDescriptor().setMajorVersion(EsConstants.ES_MAJOR_VERSION);
		message.getMessageHeader().getServiceDescriptor().setMinorVersion(EsConstants.ES_MINOR_VERSION);
		message.getMessageHeader().getServiceDescriptor().setServiceID(EsConstants.ES_SERVICE_ID);
		
		message.getMessageHeader().setMessageSecurity(new MessageSecurityType());
		message.getMessageHeader().getMessageSecurity().setSecurityCredentials(new SecurityCredentialsType());
		message.getMessageHeader().getMessageSecurity().getSecurityCredentials().setUserName(EsConstants.ES_DEFAULT_USER);
		message.getMessageHeader().getMessageSecurity().getSecurityCredentials().setUserPassword(EsConstants.ES_DEFAULT_PWD);
		message.getMessageHeader().setMessageType(MessageTypeType.REQUEST);
		///body
		message.setMessageBody(new MessageBody());
		message.getMessageBody().setEIAError(null);
		message.getMessageBody().setEsReply(null);
		message.getMessageBody().setEsRequest(null);

		//trailer
		message.setMessageTrailer(new MessageTrailerType());
		return message;

	}
	
	/*
	 * A method to transform a reply into an eia reply message
	 * 
	 */
	public static EIAMessage transformRequestInReplyMessage(EsReply reply, EIAMessage requestMessage) {
		EIAMessage replyMessage = createEmptyEIAReplyMessage(requestMessage.getMessageHeader().getMessageID());

        replyMessage.getMessageBody().setEsReply(reply);
		return replyMessage;
	}

	

	/*
	 * A method to transform a reply into an eia reply message
	 * 
	 */
	public static EIAMessage transformRequestInEIAErrorMessage(EIAError reply, EIAMessage requestMessage) {
		EIAMessage errorMessage = null;

		errorMessage = createEmptyEIAErrorMessage(requestMessage.getMessageHeader().getMessageID());
		errorMessage.getMessageHeader().setMessageType(MessageTypeType.ERROR);
        errorMessage.getMessageBody().setEIAError(reply);

		return errorMessage;
	}	
	/**
	 * test if a string is not empty
	 * @param str the string to test
	 * @return true if not empty
	 */
	public static boolean stringNotEmpty(final String str){
		boolean notEmpty = false;
		
		if((str != null) && (!str.trim().equals(""))) {
			notEmpty = true;
		}
		return notEmpty;
	}

}
