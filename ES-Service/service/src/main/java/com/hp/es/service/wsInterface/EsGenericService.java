package com.hp.es.service.wsInterface;

import javax.servlet.ServletException;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.TransactionIdGenerator;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * This class is used to expose an ES service on a web service interface. We
 * could have imagine another level of abstraction but it was not created It is
 * responsible of
 * <UL>
 * <LI>unwrapping the enveloppe from a message (extraction of message body)
 * <LI>sending the message without enveloppe to the service handler
 * <LI>representing the status of the service to the service handler
 * <LI>initialization of the overall environment
 * </UL>
 * 
 * @author Antoine Voiry
 * @since 9.0
 * 
 */
abstract public class EsGenericService {
	protected EsServiceHandler _serviceHandler = null;

	public EsGenericService() {
		super();
		_serviceHandler = new EsServiceHandler();
		_serviceHandler.init();
	}

	/**
	 * This method needs ton be implemented to extract the enveloppe.
	 * 
	 * @param requestMessage
	 *            (Object, implementation will have to cast)
	 * @return a request
	 * @throws SifException
	 */
	abstract EsRequestComplexType extractMessageEnveloppe(Object requestMessage)
			throws SifException;

	/**
	 * This method needs to be implemented to transform a EsReply into a reply
	 * with an enveloppe.
	 * 
	 * @param a
	 *            reply message
	 * @param the
	 *            original request message
	 * @return a reply
	 * @throws SifException
	 */
	abstract Object transformIntoReplyMessage(EsReply reply,
			Object requestMessage) throws SifException;

	/**
	 * This method needs to be implemented to transform a EsReply into a reply
	 * with an enveloppe.
	 * 
	 * @param the
	 *            original request message
	 * @param an
	 *            exception SifException
	 * @param MetricsHandler
	 *            to track time
	 * @param the
	 *            transaction ID
	 * @return a reply
	 * @throws SifException
	 */
	abstract Object transformIntoErrorReplyMessage(Object requestMessage,
			SifException ee, MetricsHandler handler, String transId)
			throws SifException;

	/**
	 * This method init the service
	 * 
	 * @throws ServletException
	 */
	synchronized void init() throws ServletException {
		ESLog.info("Enter");
		_serviceHandler.init();
		ESLog.info("Exit");
	}



	/*
	 * This method is called by the implementation to process a message
	 * 
	 * @param1 requestMessage
	 * 
	 * @return replyMessage
	 */
	public Object processMessage(Object requestMessage, MetricsHandler handler) {
		// get a new transaction ID and log the transaction start
		ESLog.debug("Enter processMessage To TransactionLoggingMessageSender to get Transaction!");
	//	String transId = TransactionIdGenerator.getInstance().nextId();
		String transId=null;
		

		ESLog.debug("Starting transaction " + transId);
		Object replyMessage = null;
		EsRequestComplexType request = null;
		EsReply reply = null;
		MetricsEntry overallTime = null;

		// this is the entry point from EIA SF; we create the MetricsHandler
		// that follows the entire request

		if (handler != null)
			overallTime = handler.startEntry(EsGenericService.class.getName());

		try {
			// Extract the message body so we can do something
			request = extractMessageEnveloppe(requestMessage);

			// check the request on a text-based level
			if (request == null) {
				ESLog.debug("Request is invalid");
				throw ErrorFactory
						.getSifException(ErrorFactory.id120_INVALID_REQUEST);
			}

			ESLog.debug("Calling service");
	
			if(requestMessage instanceof EIAMessage){
				transId=((EIAMessage)requestMessage).getMessageHeader().getMessageID();
			}
			
			if(transId == null || transId.trim().equals("")||"0".equals(transId)){
				ESLog.debug("Enter processMessage,Transaction is empty, To TransactionLoggingMessageSender to get Transaction!");
				transId = TransactionIdGenerator.getInstance().nextId();
			}
			reply = _serviceHandler.callService(request, transId, handler);

			ESLog.debug("Got reply from service, will transform it in a reply");
			replyMessage = transformIntoReplyMessage(reply, requestMessage);

		} catch (SifException ee) {
			// Todo look if we can print request
			// ESLog.log(ee, "Failed to process following request with:\n" +
			// strRequest);
			ESLog.debug("Failed to process request " + ee.getMessage());
			// We must not let our "internal" exceptions out;
			// translate them to 9999 Internal exceptions, and put the old
			// ErrorText into DataPayLoad. See service.util.ErrorFactory for
			// more discussion on ES's reuse of SifException
			if (ErrorFactory.isHpseInternal(ee)) {
				ESLog.error("Caught an ES internal" + ee.getClass().getName());
				ee = ErrorFactory.getSifException(
						ErrorFactory.id9999_INTERNAL_ERROR, ee.getErrorText());
			}

			try {
				replyMessage = transformIntoErrorReplyMessage(requestMessage,
						ee, handler, transId);
			} catch (SifException e) {
				/*
				 * If we are not able to process the SifExcep^tion we have a
				 * very big issue. In such a case, we print to log and leave
				 * repolymessage to NULL The servlet will try to generate an
				 * internal error
				 */

				ESLog.log(e,
						"Failed to generate reply message for an exception ");
				replyMessage = null;

			}
		} catch (Throwable thr) {

			// /Todo look if we can print request
			/*
			 * ESLog.logITO(ItoErrorFactory.getItoError(
			 * ItoErrorFactory.ID_1099_UNEXPECTED_FATAL_EXCEPTION,
			 * thr.getClass().getName()), "Failed to process request with:\n" +
			 * strRequest);
			 */
			// ESLog.debug("Caught a Throwable, stack trace will follow, Failed to process request",
			// thr);
			ESLog
					.error(
							"Caught a Throwable, stack trace will follow, Failed to process request ",
							thr);

			SifException ee = ErrorFactory.getSifException(
					ErrorFactory.id9999_INTERNAL_ERROR, thr.toString());
			try {
				replyMessage = transformIntoErrorReplyMessage(requestMessage,
						ee, handler, transId);
			} catch (SifException e) {
				ESLog.log(e,
						"Failed to generate reply message for an exception ");
				replyMessage = null;
			}
		} finally {
			if (overallTime != null)
				overallTime.actionDone();

			if (ESLog.isDebugLogEnabled()) {
				ESLog.debug("Finishing transaction " + transId);
				// for maximum reportability
				// (grep 'Performance data gathered' | your formatting commands)
				if (handler != null) {
					ESLog.debug("Performance data gathered : "
							+ handler.getReadableOverview());

					// for quick-n-easy readability in the log file
					ESLog.debug("Performance data gathered : "
							+ handler.getMultilineOverview());
				}
			}

		}

		return replyMessage;
	}
}
