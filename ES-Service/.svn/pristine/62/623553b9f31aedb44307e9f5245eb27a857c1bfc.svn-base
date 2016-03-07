/*
 * 
 */
package com.hp.es.service.wsInterface;

import javax.servlet.ServletException;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.xml.EIAErrorHelper;
import com.hp.es.service.util.xml.EIAMessageHelper;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * This class is the Http implemntation of EsGenericService
 * HTTP service use the EIA enveloppe
 */
public class EsHttpService extends EsGenericService {

	public EsHttpService() {
		super();
	}

	/*
	 * This method returns an EsRequestComplexType that represents the EIAMessage
	 * @see com.hp.es.service.wsInterface.EsGenericService#extractMessageEnveloppe(java.lang.Object)
	 */
	EsRequestComplexType extractMessageEnveloppe(Object requestMessage) throws SifException {
		if (requestMessage instanceof EIAMessage)  {
			return extractEIAEnveloppe((EIAMessage)requestMessage);
		}else {
	        throw ErrorFactory.getSifException(
	                ErrorFactory.id9999_INTERNAL_ERROR,
	                "Unexpected EIAError, HttpService miused");
			
		}
		
	}
	
	/*
	 * This method returns an EsRequestComplexType that represents the EIAMessage
	 * @see com.hp.es.service.wsInterface.EsGenericService#extractMessageEnveloppe(java.lang.Object)
	 */	
	private EsRequestComplexType extractEIAEnveloppe(EIAMessage message) {
		return message.getMessageBody().getEsRequest();
	}


	/**
     * Transforms the EIA request message into an EIA error reply message and sets
     * the message body of that message to the XML representation of the passed
     * SifException.
     * @param requestMessage Message to use for building the reply message.
     * @param ee Exception for filling the message body
     * @return EIA error reply message
     */
    private EIAMessage transformIntoEIAErrorReplyMessage(
        EIAMessage requestMessage,
        SifException ee,
        MetricsHandler metricsHandler,
        String transactionId) {
    	
        MetricsEntry entry = null;
        
        
        if (metricsHandler != null) {
            entry = metricsHandler.startEntry("GenericServiceHandler.transformIntoErrorReplyMessage");
        }

        try {

        	//Put eiaerror in an enveloppe
        	EIAError error = EIAErrorHelper.toEIAError(ee, transactionId);
        	EIAMessage errorMessage = EIAMessageHelper.transformRequestInEIAErrorMessage(error,requestMessage);

            return errorMessage ;
        } finally {
            if (entry != null) {
                entry.actionDone();
            }
        }
        
    }
    
    /*
     * This method return an EIAmessage based on the reply
     *  (non-Javadoc)
     * @see com.hp.es.service.wsInterface.EsGenericService#transformIntoReplyMessage(com.hp.es.xml.service.EsReply, java.lang.Object)
     */
	Object transformIntoReplyMessage(EsReply reply, Object requestMessage) throws SifException {
		if (requestMessage instanceof EIAMessage)  {
			 ESLog.debug("A reply message will be generated with the service reply and the source request");
			return EIAMessageHelper.transformRequestInReplyMessage(reply,(EIAMessage)requestMessage);
		}else {
	        throw ErrorFactory.getSifException(
	                ErrorFactory.id9999_INTERNAL_ERROR,
	                "Unexpected EIAError, HttpService miused");
			
		}
		
	}


	Object transformIntoErrorReplyMessage(Object requestMessage, SifException ee, MetricsHandler handler, String transId) throws SifException {

		if (requestMessage instanceof EIAMessage)  {
			ESLog.debug("A reply message will be generated with the service execption and the source request");
			return transformIntoEIAErrorReplyMessage((EIAMessage) requestMessage, ee, handler, transId);
		}else {
	        throw ErrorFactory.getSifException(
	                ErrorFactory.id9999_INTERNAL_ERROR,
	                "Unexpected EIAError, HttpService miused");
			
		}
	}

	
	/*
	 * Init method (non-Javadoc)
	 * @see com.hp.es.service.wsInterface.EsGenericService#init()
	 */
	synchronized void init() throws ServletException {
		   super.init();
		   ESLog.info("Enter");

	        try {
	            EsRequestComplexType request = new EsRequestComplexType();
	            EsRequestComplexTypeChoice complexTypeChoice =
	                new EsRequestComplexTypeChoice();
	            request.setEsRequestComplexTypeChoice(complexTypeChoice);
	            EntitlementBySnRequest snRequest = new EntitlementBySnRequest();
	            complexTypeChoice.setEntitlementBySnRequest(snRequest);

	            // Set all necessary parameters for the request
	            request.setClientAppID("es");
	            request.setOperation("getEntitlementBySn");
	            snRequest.setSerialNumber("HPSEJG1001");
	            snRequest.setIncludeContracts(true);
	            snRequest.setIncludeWarranty(true);
	            snRequest.setIsoCountryCd("US");
	            
	            EIAMessage message = EIAMessageHelper.createEmptyEIARequestMessage("");
	            
	            message.getMessageBody().setEsRequest(request);
	            
	            processMessage(message, null);
	            ESLog.info("Entitlement Service (ES) started up successfully");

	        } catch (Exception exception) {
	            // something unexpected has happened - we will not start
	            ESLog.error("Exception from initial call to an ES operation (prevents from starting)", exception);
	            ESLog.debug("The exception is converted into a ServletException");
	            throw new ServletException(exception.toString());
	        } finally {
	            ESLog.info("Leave");
	        }
	       
		
	}


	

}
