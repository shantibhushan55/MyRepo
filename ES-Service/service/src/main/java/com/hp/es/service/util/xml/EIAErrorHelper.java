package com.hp.es.service.util.xml;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.types.ErrorLevelType;
import com.hp.es.xml.service.types.MessageTypeType;
import com.hp.sif.SifException;

public class EIAErrorHelper {

	public EIAErrorHelper() {
		super();
	}


	/*
	 * This static method create an EIAError based on a SIFException
	 * @param a SifException
	 * @return a EIAError
	 */
	public static EIAError toEIAError(SifException ee) {
		
		EIAError error = new EIAError();
		
		/*
		 * If the exception is null
		 * we should wrap it to a 9999 Exception
		 */
		if (ee == null) {
			ee= ErrorFactory.getSifException(
	                ErrorFactory.id9999_INTERNAL_ERROR,
            "Unexpected EIAError");
		}
		/*
		 * Now we are populating the error object
		 */
		error.setDataPayLoad(ee.getDataPayLoad());
		error.setErrorClass(ee.getErrorClass());
		error.setErrorID(ee.getErrorID());
		error.setErrorLevel(ErrorLevelType.valueOf(ee.getErrorLevel()));
		error.setErrorText(ee.getErrorText());
		error.setTimeStamp(ee.getTimeStamp());
		
		return error;
	}

	
	/*
	 * This static method create an EIAError based on a SIFException
	 * @param a SifException
	 * @param transaction Id
	 * @return a EIAError
	 */
	public static EIAError toEIAError(SifException ee,String transactionId) {
        // apply txid in DataPayload temporarily

        String dataPayload = ee.getDataPayLoad();
        if (transactionId == null) {
            transactionId = "";
        }
        final String txIdString = "[TXID " + transactionId + "]";
        if (dataPayload == null || dataPayload.trim().equals("")) {
            dataPayload = txIdString;
        } else {
            dataPayload = dataPayload + " " + txIdString;
        }

        ee.setDataPayload(dataPayload);		
	
		
		return toEIAError(ee);
	}

	/*
	 * This static method create an EIAMessage with an EIA error inside based on a SIFException
	 * @param a SifException
	 * @return a string representing the EIAMessage (null if there is an issue)
	 */
	public static String toEIAWrappedErrorReplyString(SifException e) {


		return toEIAWrappedErrorReplyString(e,null);
	}
	
	public static String toEIAWrappedErrorReplyString(SifException e, EIAMessage requestMessage) {
		EIAError error = toEIAError(e);
		EIAMessage errorMessage = null;
		/*
		 * We are copying the content of the request Message in the error reply
		 */
		if(requestMessage == null) {
			requestMessage = EIAMessageHelper.createEmptyEIAErrorMessage ("");
		}
		
		errorMessage = requestMessage;
		errorMessage.getMessageHeader().setMessageType(MessageTypeType.ERROR);
		errorMessage.getMessageBody().setEsRequest(null);
        errorMessage.getMessageBody().setEsReply(null);
        errorMessage.getMessageBody().setEIAError(error);
		

		String xml;
		try {
			xml = MarshalHelper.marshal(errorMessage,null);
		} catch (SifException e1) {
			/*
			 * If we get a SIF execption or whatever exception we cannot do anything about if except logging
			 * and returning a null
			 * the null will be interpreted as a HTTP error code			 
			 */

			ESLog.info("Exception while processing an error message",e1);
			xml = null;
		}
		return xml;
	}
}
