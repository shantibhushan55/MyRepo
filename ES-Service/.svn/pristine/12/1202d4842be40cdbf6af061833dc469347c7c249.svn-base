/**
 * 
 */
package com.hp.es.service.wsInterface;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.ServletException;

import org.apache.oro.text.regex.MalformedPatternException;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.compliancevalidation.ComplianceValidationHelper;
import com.hp.es.service.transactionLogging.EsTransactionHelper;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.RegExDateMatcher;
import com.hp.es.service.util.TransactionIdGenerator;
import com.hp.es.service.util.exception.MissingDataException;
import com.hp.es.service.util.xml.EIAErrorHelper;
import com.hp.es.service.util.xml.MarshalHelper;
import com.hp.es.service.util.xml.MessageScan;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.MessageBody;
import com.hp.es.xml.service.MessageHeaderType;
import com.hp.es.xml.service.MessageSecurityType;
import com.hp.es.xml.service.MessageStateType;
import com.hp.es.xml.service.SecurityCredentialsType;
import com.hp.es.xml.service.ServiceDescriptorType;
import com.hp.es.xml.service.types.MessageTypeType;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;
import com.hp.sif.http.SifHttpErrorException;
import com.hp.sif.http.UTF8Servlet;

/**
 * @author ANVOI
 * 
 */
public class EsHttpListener extends UTF8Servlet {

	EsHttpService _service = new EsHttpService();
	private static final long serialVersionUID = -7053956707473487241L;

	/**
	 * Constructor
	 */
	public EsHttpListener() {
		super();
	}

	/**
	 * This method is called during intialization. This is triggered by the
	 * web.xml
	 */
	public synchronized void init() throws ServletException {
		try {
			super.init();
			ESLog.info("Starting service initialization");

			// send a request to the service to initialize it
			_service.init();

			ESLog.info("Service initialization is DONE");
		} catch (Exception e) {
			ESLog.error("Initialization failed", e);
			throw new ServletException();
		}
	}

	/**
	 * processRequest
	 * 
	 * @param1 request message
	 * @return reply message
	 */
	public String processRequest(String requestString)
			throws SifHttpErrorException {

		long startTime = System.currentTimeMillis();
		EIAMessage request = null;
		EIAMessage reply = null;
		EIAMessage originalReply = null;
		String replyXml = null;
		ComplianceValidationReply cvsReply = null;

		MetricsHandler handler = null;
		boolean sentToTm = false;


		if (ESLog.isDebugLogEnabled())
			handler = new MetricsHandler();
		ESLog.debug("enter");

		//TODO change that so that this is being called CVS
		boolean fraudEnable = Configuration.getInstance().getProperties()
				.getBoolean(EsConstants.ES_FRAUD_ENABLED);
		ESLog.debug("FRAUD enable is:" + fraudEnable);

		try {
			ESLog.debug("Received request " + requestString);

			// verify the request
			verifyRawXmlRequest(requestString, handler);
			request = MarshalHelper.unmarshalUsingEIAMappingFile(requestString,
					handler);
			// assign the transaction Id
			ESLog.debug("Enter processRequest To TransactionLoggingMessageSender to get Transaction!");
			request.getMessageHeader().setMessageID(TransactionIdGenerator.getInstance().nextId());



			ESLog.debug("FRAUD enable is:" + fraudEnable);
			// first step: preprocessing retrieveNoQueryBackendFraudUnitDetails

			// second step: get EIAMessage object
			ESLog.debug("before processMessage: request:" + request);
			reply = (EIAMessage) _service.processMessage(request, handler);
			ESLog.debug("after processMessage: request:" + request);
			ESLog.debug("after processMessage: reply:" + reply);
			// hold orginalReplyXml String
			originalReply = null;
			SifException seFromCvs = null;
			try {
				cvsReply =ComplianceValidationHelper.getInstance().callComplianceValidationService(reply, request,request.getMessageHeader().getMessageID(),handler);
				ESLog.info("CVS Reply:"+cvsReply);
				
			}catch(SifException se) {
				seFromCvs=se;
			}
			
			if(cvsReply !=null && cvsReply.getMessageList() != null && cvsReply.getMessageList().size()>0) {
				originalReply = copyReply(reply);
				reply=ComplianceValidationHelper.getInstance().modifyESReply(reply, cvsReply);
			}else if(seFromCvs != null)  {
				reply=ComplianceValidationHelper.getInstance().modifyESReply(reply, seFromCvs);
			}
			
			
			replyXml = MarshalHelper.marshal(reply, handler);

			if (replyXml == null) {
				ESLog
						.error("Reply XML is null, we are generating an internal error");
				throw ErrorFactory.getSifException(
						ErrorFactory.id9999_INTERNAL_ERROR,
						"Unexpected ES error");
			}


			
			if(ESLog.isDebugLogEnabled()) {
				ESLog.debug("reply.getMessageBody().getEIAError():"
						+ reply.getMessageBody().getEIAError());
				ESLog.debug("reply.getMessageBody().getEsReply():"
						+ reply.getMessageBody().getEsReply());
			}
		} catch (SifException e) {
			ESLog.info("Caught a SifException", e);
			ESLog.info("Request String=" + requestString);
			ESLog.info("Reply String=" + replyXml);
			replyXml = createErrorResponse(e);
			long endTime = System.currentTimeMillis();
			EsTransactionHelper.getInstance().sendTransactionToTransactionLoggingMessageSender(request, e,  startTime, endTime,handler);
			sentToTm=true;
			if (handler != null) {
				ESLog.debug("[perf] TM (endTime-startTime): " + (endTime - startTime)+"\n Metrics Handler information : "+ handler.getMultilineOverview());
				handler = null;
			}

		} finally {
			if (reply != null && !sentToTm) {
				long endTime = System.currentTimeMillis();
				ESLog.debug("[perf] TM (endTime-startTime): " + (endTime - startTime));

				ESLog.debug("start send JMS message to TM module.");
				  //log transaction
				EsTransactionHelper.getInstance()
							.sendTransactionToTransactionLoggingMessageSender(request,
									reply,originalReply
									,cvsReply,startTime, endTime,handler);
				sentToTm=true;
				
				if (handler != null) {
					ESLog.debug("[perf] TM (endTime-startTime): " + (endTime - startTime)+"\n Metrics Handler information : "+ handler.getMultilineOverview());
					handler = null;
				}
			} else {
				if(!sentToTm) {
					ESLog.error("No reply XML for request and not logged and not logged " + requestString + "replys xml is" +replyXml);
				}
			}
		}
		// Adding castor prolog
		replyXml = EsConstants.CASTOR_PROLOGUE + replyXml;
		ESLog.debug("processed reply:" + replyXml);
		ESLog.debug("exit");
		return replyXml;
	}

	private EIAMessage copyReply(EIAMessage reply) {

		EIAMessage replycopied = new EIAMessage();
    	try {
    		replycopied.setMessageHeader(reply.getMessageHeader());
    		replycopied.setMessageTrailer(reply.getMessageTrailer());
    		replycopied.setMessageBody(new MessageBody());
    		replycopied.getMessageBody().setEsReply(reply.getMessageBody().getEsReply());
		} catch (Exception e) {
			ESLog.error("Error in cloning", e);
			replycopied = reply;
		}

		return replycopied;
	}

	/**
	 * This method should validate if all input parameter are meaningful and
	 * complete on a text based layer (i.e. prevent 32nd March 2003). When this
	 * method doesn't throw an exception, we should be able to process the
	 * request.<br>
	 * 
	 * @param rawRequestXML
	 *            the request (pure XML string) that was sent from the client
	 * @param metricsHandler
	 * @throws SifException
	 *             when the parameter of the request are not complete or not
	 *             meaningful, i.e. when the request cannot be handled by the
	 *             operation
	 * @roseuid 3E6F279500F6
	 */
	protected final void verifyRawXmlRequest(String rawRequestXML,
			MetricsHandler metricsHandler) throws SifException {

		MetricsEntry entry = null;
		if (metricsHandler != null) {
			entry = metricsHandler.startEntry("ESHttpListener.verifyRequest");
		}

		try {
			if (rawRequestXML != null) {
				verifyDateFormat(rawRequestXML);
			}
		} finally {
			if (entry != null)
				entry.actionDone();
		}
	}

	private void verifyDateFormat(String rawRequestXML) throws SifException {
		// this matcher catches all date fields out of the request
		RegExDateMatcher matcher = new RegExDateMatcher();
		// SDF for american date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// fail for incorrect dates, i.e. 32nd MAR 2003
		sdf.setLenient(false);
		String[] dates = matcher.match(rawRequestXML);
		// maybe we do not have dates in the request at all...
		if (dates != null) {
			for (int i = 0; i < dates.length; i++) {
				try {
					sdf.parse(dates[i]);
				} catch (Exception ex) {
					throw ErrorFactory.getSifException(
							ErrorFactory.id120_INVALID_REQUEST,
							"invalid date: " + dates[i] + ": "
									+ ex.getMessage());
				}
			}
		}
	}

	/**
	 * Wrap the message in an enveloppe if it was not having one
	 * 
	 * @see com.hp.sif.http.UTF8Servlet#wrapMessageEnvellope(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	public String wrapMessageEnvellope(String serviceIdString,
			String majorVersionString, String minorVersionString,
			String userNameString, String userPwString, String validatedString,
			String messageIdString, String requestString) {
		String messageXml = null;
		try {
			MessageHeaderType header = new MessageHeaderType();
			ESLog.debug("Enter wrapMessageEnvellope To TransactionLoggingMessageSender to get Transaction!");
			header.setMessageID(TransactionIdGenerator.getInstance().nextId());
			header.setMessageSecurity(new MessageSecurityType());
			header.getMessageSecurity().setSecurityCredentials(
					new SecurityCredentialsType());
			header.getMessageSecurity().getSecurityCredentials().setUserName(
					userNameString);
			header.getMessageSecurity().getSecurityCredentials()
					.setUserPassword(userPwString);
			header.setMessageState(new MessageStateType());
			header.getMessageState().setValidated(validatedString);
			header.setServiceDescriptor(new ServiceDescriptorType());
			header.getServiceDescriptor().setMinorVersion(minorVersionString);
			header.getServiceDescriptor().setMajorVersion(majorVersionString);
			header.getServiceDescriptor().setServiceID(serviceIdString);
			header.setMessageType(MessageTypeType.REQUEST);
			String headerXml = MarshalHelper.marshal(header, null);

			requestString = removeXMLDeclaration(requestString);
			messageXml = EsConstants.CASTOR_PROLOGUE + "<EIAMessage>"
					+ headerXml + "\n<MessageBody>\n" + requestString
					+ "\n</MessageBody>\n <MessageTrailer/>\n </EIAMessage>";
		} catch (SifException e) {
			ESLog.info("Caught a SifException", e);
		}
		return messageXml;
	}

	/**
	 * createErrorResponse
	 * 
	 * @param se
	 * @return
	 * @throws SifHttpErrorException
	 */
	private String createErrorResponse(SifException se)
			throws SifHttpErrorException {
		String replyXml = EIAErrorHelper.toEIAWrappedErrorReplyString(se);
		if (replyXml == null) {
			ESLog
					.info("Failed to generate the reply for a SifException, an HTTP error is being generated");
			SifHttpErrorException ee = new SifHttpErrorException();
			ee.setHttpReturnCode(500);
			ee.setHttpReturnMessage("Unexpected ES issue");
			throw ee;
		}
		return replyXml;
	}

	/**
	 * The method checks whether the request of the user is in line with the
	 * privileges of the user. If the privileges are not enough then a Sif
	 * exception will be thrown.
	 */
	public void verifyAccess(String requestMessage, String privilege)
			throws SifException {
		// prepare for scanning

		MessageScan messageScan = new MessageScan(requestMessage);
		if (ESLog.isDebugLogEnabled())
			ESLog.debug("verifying access for priviledge:" + privilege
					+ ", and request \n" + requestMessage);

		// get the client app id
		String clientAppId = null;
		try {
			clientAppId = messageScan.getClientAppId();
		} catch (MalformedPatternException mpe) {
			ESLog
					.debug(
							"MalformedPatternException while getting the clientAppId field",
							mpe);
			// nothing needs to be done here, in this case we just have no
			// client id
		} catch (MissingDataException mde) {
			ESLog.debug(
					"MissingDataException while getting the clientAppId field",
					mde);
			// nothing needs to be done here, in this case we just have no
			// client id
		}
		ESLog.debug("Request from client: " + clientAppId);

		// get the operation of the request
		String operation = null;
		try {
			operation = messageScan.getOperation();
		} catch (MalformedPatternException mpe) {
			String message = "MalformedPatternException while getting the operation field";
			ESLog.error(message, mpe);
			throw ErrorFactory.getSifException(
					ErrorFactory.id9999_INTERNAL_ERROR, message);
		} catch (MissingDataException mde) {
			ESLog.error(
					"MissingDataException while getting the operation field",
					mde);
			throw ErrorFactory.getSifException(
					ErrorFactory.id111_ACCESS_DENIED, "Authorization failure");
		}
		ESLog.debug("Requested operation: " + operation);

		// ---- NO DATA ACCESS ----
		if (privilege == null) {
			// user has no access at all
			ESLog.info("Authorization failure for client: " + clientAppId
					+ ". The client is not part of the ES groups");
			throw ErrorFactory.getSifException(
					ErrorFactory.id111_ACCESS_DENIED, "Authorization failure");
		}

		ESLog
				.debug("Priviledge is not null, now checking CONFIDENTIAL DATA ACCESS");

		// ---- CONFIDENTIAL DATA ACCESS ----
		// get the IncludeAddresses fields
		boolean includeAddresses = false;
		// OLCAYYE
		// WITS Issue 1626
		if (requestMessage.toLowerCase().indexOf("<includeaddresses>") > -1) {
			try {
				includeAddresses = MappingUtils.mapToBoolean(messageScan
						.getIncludeAddresses());
			} catch (MalformedPatternException mpe) {
				String message = "MalformedPatternException while getting the IncludeAddresses field";
				ESLog.error(message, mpe);
				throw ErrorFactory.getSifException(
						ErrorFactory.id9999_INTERNAL_ERROR, message);
			} catch (MissingDataException mde) {
				// we do nothing here. The field is optional and the default is
				// false
			}
			ESLog.debug("Requested IncludeAddresses: " + includeAddresses);
		}

		// get the IncludeContacts fields
		boolean includeContacts = false;
		// OLCAYYE
		// WITS Issue 1626
		if (requestMessage.toLowerCase().indexOf("<includecontacts>") > -1) {
			try {
				includeContacts = MappingUtils.mapToBoolean(messageScan
						.getIncludeContacts());
			} catch (MalformedPatternException mpe) {
				String message = "MalformedPatternException while getting the IncludeContacts field";
				ESLog.error(message, mpe);
				throw ErrorFactory.getSifException(
						ErrorFactory.id9999_INTERNAL_ERROR, message);
			} catch (MissingDataException mde) {
				// we do nothing here. The field is optional and the default is
				// false
			}
			ESLog.debug("Requested IncludeContacts: " + includeContacts);
		}
		// now let's check which include flags for the other operation which
		// needs confidential data access
		if (includeAddresses || includeContacts) {
			// addresses and/or contacts are requested => we need confidential
			// access privileges
			if (ACCESS_ROLE_CONFIDENTIAL.equals(privilege)) {
				// at this point we can return because the privileges are
				// correct for the operation
				return;
			} else {
				ESLog.debug("Requested IncludeContacts: " + includeContacts
						+ ", Requested includeAddresses: " + includeAddresses
						+ " and priviledge:" + privilege);

				logAndThrowAccessDeniedException(clientAppId, operation,
						includeAddresses, includeContacts, privilege);
			}
		}

		// ---- CONTRACT QUERY DATA ACCESS ----
		// check whether a operation has been requested where you need at least
		// contract query access
		if ("getAssociatedContracts".equalsIgnoreCase(operation)
				|| "getPrintAdvantageEntitlement".equalsIgnoreCase(operation)
				|| "getRoutingDetails".equalsIgnoreCase(operation)
				|| "getInstalledBaseUnits".equalsIgnoreCase(operation)
				|| "getEntitlementByPn".equalsIgnoreCase(operation)
				|| "getContractEntitlement".equalsIgnoreCase(operation)
				|| "getContractSummary".equalsIgnoreCase(operation)) {
			// for those operation we need contract query access or confidential
			// access
			if (ACCESS_ROLE_CONTRACT_QUERY.equals(privilege)
					|| ACCESS_ROLE_CONFIDENTIAL.equals(privilege)) {
				// at this point we can return already because the privileges
				// are correct for the operation
				return;
			} else {
				logAndThrowAccessDeniedException(clientAppId, operation,
						includeAddresses, includeContacts, privilege);
			}
		}

		// ---- BASIC DATA ACCESS ----
		// check for getWarrantyEntitlement and getEntitlementBySn
		if ("getEntitlementBySn".equalsIgnoreCase(operation)
				|| "getWarrantyEntitlement".equalsIgnoreCase(operation)
				|| "getUnitEventHistory".equalsIgnoreCase(operation)) {
			// all access roles can access those operations
			if (ACCESS_ROLE_BASIC.equals(privilege)
					|| ACCESS_ROLE_CONTRACT_QUERY.equals(privilege)
					|| ACCESS_ROLE_CONFIDENTIAL.equals(privilege)) {
				// at this point we can return because the privileges are
				// correct for the operation
				return;
			} else {
				logAndThrowAccessDeniedException(clientAppId, operation,
						includeAddresses, includeContacts, privilege);
			}
		}
		// at this point we have checked all operation and all input fields, if
		// there was no match, then
		// we don't grant access
		throw ErrorFactory.getSifException(ErrorFactory.id111_ACCESS_DENIED,
				"Authorization failure");
	}

	/**
	 * convinient method to log and throw the exception
	 * 
	 * @param clientAppId
	 * @param operation
	 * @param includeAdresses
	 * @param includeContacts
	 * @param privilege
	 * @throws SifException
	 */
	private void logAndThrowAccessDeniedException(String clientAppId,
			String operation, boolean includeAdresses, boolean includeContacts,
			String privilege) throws SifException {
		// no correct privileges to execute such an operation
		ESLog.info("Authorization failure for client: " + clientAppId
				+ ". The client is requesting operation " + operation
				+ " with IncludeAddresses = " + includeAdresses
				+ " and IncludeContacts = " + includeContacts
				+ ", with privilege " + privilege);
		throw ErrorFactory.getSifException(ErrorFactory.id111_ACCESS_DENIED,
				"Authorization failure");
	}

	/**
	 * creates an error reply for access denied
	 */
	public String createAccessDeniedErrorResponse()
			throws SifHttpErrorException {
		return EsConstants.CASTOR_PROLOGUE
				+ createErrorResponse(ErrorFactory.getSifException(
						ErrorFactory.id111_ACCESS_DENIED,
						"Authorization failure"));
	}

	/**
	 * In the service we always use LDAP
	 */
	public boolean useLdap() {
		return true;
	}

	/**
	 * gets the user and passord. It has to make sure that the user and password
	 * are not empty. If they are empty or null it needs to throw an access
	 * denied excreption
	 */
	public HashMap<String, String> getUserPassword(String requestMessage) throws SifException {
		MessageScan messageScan = new MessageScan(requestMessage);
		HashMap<String, String> userMap = new HashMap<String, String>();
		try {
			String userName = messageScan.getUserName();
			String password = messageScan.getPassword();
			if ((userName != null && "".equals(userName))
					|| (password != null && "".equals(password))) {
				ESLog.info("Empty user or password: user = " + userName
						+ " / password = " + password);
				throw ErrorFactory.getSifException(
						ErrorFactory.id111_ACCESS_DENIED,
						"Authentication failure");
			}
			userMap.put(KEY_USER, userName);
			userMap.put(KEY_PASSWORD, password);
		} catch (MalformedPatternException mpe) {
			ESLog
					.error("MalformedPatternException when getting user name and password - "
							+ mpe.toString());
			throw ErrorFactory.getSifException(
					ErrorFactory.id9999_INTERNAL_ERROR,
					"The specified pattern is malformed");
		} catch (MissingDataException mde) {
			ESLog.info("MissingDataException - " + mde.toString());
			throw ErrorFactory.getSifException(
					ErrorFactory.id111_ACCESS_DENIED, "Authentication failure");
		}
		return userMap;
	}
}
