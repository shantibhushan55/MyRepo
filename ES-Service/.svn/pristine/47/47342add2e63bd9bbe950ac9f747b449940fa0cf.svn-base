package com.hp.es.service.compliancevalidation;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.TransactionIdGenerator;
import com.hp.es.xml.service.CombinedProductEntitlementComplexType;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.es.xml.service.types.ContractIdentifierTypeType;
import com.hp.es.xml.service.types.ErrorLevelType;
import com.hp.es.xml.service.types.MessageTypeType;
import com.hp.it.sbs.compliancevalidation.beans.AppContext;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationDevice;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply;
import com.hp.it.sbs.compliancevalidation.beans.FraudMessageBSO;
import com.hp.it.sbs.compliancevalidation.transport.client.ComplianceValidationServiceClient;
import com.hp.it.egitsbs.core.client.beans.ServiceAuthentication;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author ANVOI A helper to the compliance validation service client
 */
public class ComplianceValidationHelper {

	private static final String ERROR_TYPE = "E";
	private static final String ERROR_LEVEL = ErrorLevelType.FUNCTIONAL
			.toString();
	private static final String WARNING_LEVEL = ErrorLevelType.WARNING
			.toString();
	private static final String WARNING_CLASS = "InvalidDataFormat";
	private static final String ERROR_CLASS = "InvalidDataFormat";
	private static final int INTERNAL_ERROR = 9999;
	private static final String WARRANTY_OBLIGATION_DOMAIN = "WARRANTY";
	private static final String CAREPACK_OBLIGATION_DOMAIN = "CAREPACK";

	private static final String CONTRACT_OBLIGATION_DOMAIN = "CONTRACT";
	private static ComplianceValidationHelper instance = new ComplianceValidationHelper();
	private ComplianceValidationServiceClient cvsService;
	private boolean cvsEnable;
	private String cvsAppID;
	private String cvsUserID;
	private String cvsUserPassword;
	private String cvsSBSLifecycle;
	private String cvsSBSURL;
	private String invalidSNErrorid;
	private String invalidSNErrorString;

	// private String cvsTimeout;

	private synchronized void loadProperties() {
		String sCvsEnable = Configuration.getInstance().getProperties()
				.getProperty(EsConstants.CVS_ENABLE);
		if (sCvsEnable != null && sCvsEnable.length() > 0) {
			cvsEnable = Boolean.valueOf(sCvsEnable);
		} else {
			cvsEnable = EsConstants.CVS_ENABLE_DEFAULT;
		}

		cvsAppID = Configuration
				.getInstance()
				.getProperties()
				.getProperty(EsConstants.CVS_ES_APP_ID,
						EsConstants.CVS_ES_APP_ID_DEFAULT);
		cvsUserID = Configuration
				.getInstance()
				.getProperties()
				.getProperty(EsConstants.CVS_USER_ID,
						EsConstants.CVS_USER_ID_DEFAULT);
		cvsUserPassword = Configuration
				.getInstance()
				.getProperties()
				.getProperty(EsConstants.CVS_USER_PASSWORD,
						EsConstants.CVS_USER_PASSWORD_DEFAULT);
		cvsSBSLifecycle = Configuration
				.getInstance()
				.getProperties()
				.getProperty(EsConstants.CVS_SBS_LIFECYCLE,
						EsConstants.CVS_SBS_LIFECYCLE_DEFAULT);
		invalidSNErrorid = Configuration
				.getInstance()
				.getProperties()
				.getProperty(EsConstants.CVS_INVALID_SN_ERROR_ID,
						EsConstants.CVS_INVALID_SN_ERROR_ID);
		invalidSNErrorString = Configuration
				.getInstance()
				.getProperties()
				.getProperty(EsConstants.CVS_INVALID_SN_ERROR_STR,
						EsConstants.CVS_INVALID_SN_ERROR_STR_DEFAULT);
		// handle lifecycle
		System.setProperty("sbs.lifecycle", cvsSBSLifecycle);
		cvsSBSURL = Configuration.getInstance().getProperties()
				.getProperty(EsConstants.CVS_SBS_URL);
		
/**
		if (cvsSBSURL == null || cvsSBSURL.trim().length() == 0) {
			cvsSBSURL = EsConstants.CVS_SBS_URL_DEFAULT;
		}
		ESLog.debug("cvsSBSURL::" + cvsSBSURL);
		if (cvsSBSURL != null && cvsSBSURL.trim().length() > 0) {
			System.setProperty("sbs." + cvsSBSLifecycle.toLowerCase()
					+ ".pattern", cvsSBSURL);
		}
		*/
	}

	private ComplianceValidationHelper() {
		loadProperties();
		cvsService = getAndCreateNewComplianceValidationService();
	}

	/*
	 * Modify the ES reply
	 */
	public ComplianceValidationReply callComplianceValidationService(
			final EIAMessage reply, final EIAMessage request,
			String transactionId, MetricsHandler handler) throws SifException {
		ComplianceValidationReply cvsReply = null;
		MetricsEntry entry = null;
		if (handler != null) {
			entry = handler
					.addEntry("ComplianceValidationReply.callComplianceValidationService()");
			entry.actionStart();
		}
		try {
			if (reply != null && reply.getMessageBody() != null
					&& reply.getMessageBody().getEsReply() != null) {
				if (request == null || request.getMessageBody() == null
						|| request.getMessageBody().getEsRequest() == null) {
					cvsReply = callComplianceValidationService(reply
							.getMessageBody().getEsReply(), null, transactionId);
				} else {
					cvsReply = callComplianceValidationService(reply
							.getMessageBody().getEsReply(), request
							.getMessageBody().getEsRequest(), transactionId);
				}
			}
		} finally {
			if (entry != null)
				entry.actionDone();
		}
		return cvsReply;
	}

	/*
	 * call cvs with the ES reply
	 */
	public ComplianceValidationReply callComplianceValidationService(
			final EsReply reply, final EsRequestComplexType request,
			String transactionId) throws SifException {
		ComplianceValidationReply cvsReply = null;
		ESLog.debug("Entering callComplianceValidationService");
		long startTime = System.currentTimeMillis();
		// long cvsworkerTime=0;
		long endTime = 0;
		if (isCVSrelevant(reply)) {
			AppContext appCtx = new AppContext();
			appCtx.setApplicationID(cvsAppID);
			appCtx.setApplicationSrcTransactionID(transactionId);

			ComplianceValidationDevice device = getDeviceFromEsReply(reply,
					request);
			String obligationDomains = getObligationDomainList(reply);
			if (device != null && obligationDomains != null) {
				ComplianceValidationServiceClient service = getAndCreateNewComplianceValidationService();
				if (service != null) {
					ESLog.debug("calling ComplianceValidationService");
					try {
						ESLog.debug("appCtx::" + appCtx + "  device::" + device
								+ "  obligationDomains::" + obligationDomains);
						ESLog.debug("service::" + service);
						cvsReply = service
								.validateComplianceValidationDeviceByObligationDomain(
										appCtx, device, obligationDomains);
						ESLog.debug("cvsReply::::" + cvsReply);
					} catch (Exception e) {
						setComplianceValidationService(null);
						// e.printStackTrace();
						ESLog.error("calling ComplianceValidationService got error: "+ e.toString());
						throw ErrorFactory
								.getSifException(
										ErrorFactory.id8001_SYSTEM_NOT_AVAILABLE,
										"Exception while connecting to compliance validation service",
										"");
					} finally {
						endTime = System.currentTimeMillis();
						StringBuffer sb = new StringBuffer();
						sb.append("[Metro-cvs] Function callComplianceValidationService|");
						sb.append("TotalTime " + (endTime - startTime) + "|");
						// sb.append("cvsworkerTime "+(cvsworkerTime -
						// startTime)+"|");
						// sb.append("cvsReplyTime "+(endTime - cvsworkerTime));
						ESLog.info(sb.toString());
					}

					if (cvsReply != null) {
						ESLog.debug("calling ComplianceValidationService succeded got the reply: "
								+ cvsReply);
					}
					// resetComplianceValidationService();
				} else {
					ESLog.error("There is an error in retrieving the CVS service ");
				}
			}
		}
		return cvsReply;

	}

	/*
	 * Modify the ES reply
	 */
	public EsReply modifyESReply(final EsReply reply,
			final ComplianceValidationReply cvsReply) throws SifException {
		EsReply modifiedReply = null;

		// if cvsreply is null we can stop here
		if (cvsReply != null && cvsReply.getMessageList() != null
				&& cvsReply.getMessageList().size() > 0) {
			List<FraudMessageBSO> listMes = cvsReply.getMessageList();
			if (isErrorMessage(listMes)) {
				throw generateSifException(listMes.get(0));
			} else {
				modifiedReply = reply;
				Iterator<FraudMessageBSO> itMessage = listMes.iterator();
				while (itMessage.hasNext()) {
					FraudMessageBSO message = itMessage.next();
					EIAError error = generateEIAError(message);
					if (reply.getEsHeader().getWarnings() == null) {
						reply.getEsHeader().setWarnings(new Warnings());
					}
					reply.getEsHeader().getWarnings().addEIAError(error);
				}
			}
		} else {// if cvsreply is null we can stop here
			ESLog.debug("No CVS message to affect to reply");
		}
		return modifiedReply;
	}

	/*
	 * Modify the ES reply
	 */
	public EIAMessage modifyESReply(final EIAMessage reply,
			final ComplianceValidationReply cvsReply) {
		EIAMessage modifiedEIAReply = null;
		if (reply.getMessageBody() != null
				&& reply.getMessageBody().getEsReply() != null) {
			modifiedEIAReply = reply;
			try {
				modifiedEIAReply.getMessageBody().setEsReply(
						modifyESReply(modifiedEIAReply.getMessageBody()
								.getEsReply(), cvsReply));
			} catch (SifException e) {
				// This update the reply to an error if required.
				modifiedEIAReply.getMessageHeader().setMessageType(
						MessageTypeType.ERROR);
				modifiedEIAReply.getMessageBody().setEsReply(null);// we must be
																	// removing
																	// the reply
				modifiedEIAReply.getMessageBody().setEIAError(
						ErrorFactory.convertSifException(e));
			}
		}
		return modifiedEIAReply;
	}

	/*
	 * return a SIFException
	 */
	private SifException generateSifException(FraudMessageBSO fraudMessageBSO) {
		SifException se = new SifException();
		Date d = new Date();
		if (fraudMessageBSO != null) {
			se.setDataPayload(null);
			if (fraudMessageBSO.getFraudMessageTypeCode().equalsIgnoreCase(
					ERROR_TYPE)) {
				se.setErrorLevel(ERROR_LEVEL);
				se.setErrorClass(ERROR_CLASS);
			} else {// warning
				se.setErrorLevel(WARNING_LEVEL);
				se.setErrorClass(WARNING_CLASS);
			}
			se.setErrorID(fraudMessageBSO.getFraudMessageIdentifier());
			// TODO, do a proper mapping between error and warning.
			se.setErrorText(fraudMessageBSO.getFraudMessageText());
			se.setTimeStamp(DateHelper.toTimeStampString(d));
		} else {
			se = ErrorFactory.getSifException(INTERNAL_ERROR);
		}
		return se;
	}

	/*
	 * return a SIFException
	 */
	public SifException generateSifExceptionForInvalidSn() {
		SifException se = new SifException();
		Date d = new Date();
		se.setDataPayload(null);
		se.setErrorClass(ERROR_CLASS);
		se.setErrorID(invalidSNErrorid);
		se.setErrorLevel(ERROR_LEVEL);
		se.setErrorText(invalidSNErrorString);
		se.setTimeStamp(DateHelper.toTimeStampString(d));
		return se;
	}

	private boolean isErrorMessage(List<FraudMessageBSO> listMes) {
		Iterator<FraudMessageBSO> itMessage = listMes.iterator();
		while (itMessage.hasNext()) {
			FraudMessageBSO message = itMessage.next();
			return message.getFraudMessageTypeCode().equals(ERROR_TYPE);
		}
		return false;
	}

	private EIAError generateEIAError(FraudMessageBSO message) {
		SifException e = generateSifException(message);
		return ErrorFactory.convertSifException(e);
	}

	private synchronized ComplianceValidationServiceClient getAndCreateNewComplianceValidationService() {
		synchronized (ComplianceValidationServiceClient.class) {
			if (cvsService == null) {
				ESLog.debug("Getting an instance of the service");
				ServiceAuthentication authInfo = new ServiceAuthentication(
						cvsUserID, cvsUserPassword);
				cvsService = new ComplianceValidationServiceClient(authInfo);
			}
		}
		return cvsService;
	}

	private synchronized void setComplianceValidationService(
			ComplianceValidationServiceClient service) {
		synchronized (ComplianceValidationServiceClient.class) {
			cvsService = service;
		}
	}

	private String getObligationDomainList(EsReply reply) {
		if (reply != null && reply.getEsReplyChoice() != null) {
			if (reply.getEsReplyChoice().getCombinedProductEntitlement() != null) {
				return getObligationDomainList(reply.getEsReplyChoice()
						.getCombinedProductEntitlement());
			}
			if (reply.getEsReplyChoice().getCombinedUnitEntitlement() != null) {
				return getObligationDomainList(reply.getEsReplyChoice()
						.getCombinedUnitEntitlement());
			}
			if (reply.getEsReplyChoice().getWarrantyEntitlement() != null) {
				return getObligationDomainList(reply.getEsReplyChoice()
						.getWarrantyEntitlement());
			}			
			if (reply.getEsReplyChoice().getContractEntitlement() != null) {
				return getObligationDomainList(reply.getEsReplyChoice()
						.getContractEntitlement());
			}	
		}
		return null;
	}

	/**
	 * 
	 * @param contractEntitlement
	 * 			ContractEntitlementComplexType
	 * @return obligationDomainList
	 * 			String
	 */
	private String getObligationDomainList(
			ContractEntitlementComplexType contractEntitlement) {
		String obligationDomainList = null;
		if (contractEntitlement.getContract() != null) {
			ContractComplexType[] contracts = contractEntitlement
					.getContract();
			boolean hasContract = false;
			boolean hasCarepack = false;
			for (int iContracts = 0; iContracts < contracts.length; iContracts++) {
				if (contracts[iContracts] != null
						&& contracts[iContracts].getObligationHeader() != null) {
					ObligationHeader[] headers = contracts[iContracts]
							.getObligationHeader();
					for (int iHeaders = 0; iHeaders < headers.length; iHeaders++) {
						if (headers[iHeaders] != null) {
							if (headers[iHeaders].getObligationType()
									.equalsIgnoreCase("C")) {
								hasContract = true;
							} else {
								hasCarepack = true;
							}
						}
					}
				}
			}

			if (hasContract) {
				obligationDomainList = CONTRACT_OBLIGATION_DOMAIN;
			}
			if (hasCarepack) {
				if (obligationDomainList != null) {
					obligationDomainList = obligationDomainList + ","
							+ CAREPACK_OBLIGATION_DOMAIN;
				} else {
					obligationDomainList = CAREPACK_OBLIGATION_DOMAIN;
				}
			}
		}		
		return obligationDomainList;
	}

	private String getObligationDomainList(
			WarrantyEntitlementComplexType warrantyEntitlement) {
		return WARRANTY_OBLIGATION_DOMAIN;
	}

	private String getObligationDomainList(
			CombinedUnitEntitlementComplexType combinedUnitEntitlement) {

		String obligationDomainList = null;
		if (combinedUnitEntitlement.getContract() != null) {
			ContractComplexType[] contracts = combinedUnitEntitlement
					.getContract();
			boolean hasContract = false;
			boolean hasCarepack = false;
			for (int iContracts = 0; iContracts < contracts.length; iContracts++) {
				if (contracts[iContracts] != null
						&& contracts[iContracts].getObligationHeader() != null) {
					ObligationHeader[] headers = contracts[iContracts]
							.getObligationHeader();
					for (int iHeaders = 0; iHeaders < headers.length; iHeaders++) {
						if (headers[iHeaders] != null) {
							if (headers[iHeaders].getObligationType()
									.equalsIgnoreCase("C")) {
								hasContract = true;
							} else {
								hasCarepack = true;
							}
						}
					}
				}
			}

			if (hasContract) {
				obligationDomainList = CONTRACT_OBLIGATION_DOMAIN;
			}
			if (hasCarepack) {
				if (obligationDomainList != null) {
					obligationDomainList = obligationDomainList + ","
							+ CAREPACK_OBLIGATION_DOMAIN;
				} else {
					obligationDomainList = CAREPACK_OBLIGATION_DOMAIN;
				}
			}
		}
		if (combinedUnitEntitlement.getWarranty() != null
				&& combinedUnitEntitlement.getWarranty().length > 0) {
			if (obligationDomainList != null) {
				obligationDomainList = obligationDomainList + ","
						+ WARRANTY_OBLIGATION_DOMAIN;
			} else {
				obligationDomainList = WARRANTY_OBLIGATION_DOMAIN;
			}

		}
		return obligationDomainList;
	}

	private String getObligationDomainList(
			CombinedProductEntitlementComplexType combinedProductEntitlement) {
		String obligationDomainList = null;
		if (combinedProductEntitlement.getContract() != null) {
			ContractComplexType[] contracts = combinedProductEntitlement
					.getContract();
			boolean hasContract = false;
			boolean hasCarepack = false;
			for (int iContracts = 0; iContracts < contracts.length; iContracts++) {
				if (contracts[iContracts] != null
						&& contracts[iContracts].getObligationHeader() != null) {
					ObligationHeader[] headers = contracts[iContracts]
							.getObligationHeader();
					for (int iHeaders = 0; iHeaders < headers.length; iHeaders++) {
						if (headers[iHeaders] != null) {
							if (headers[iHeaders].getObligationType()
									.equalsIgnoreCase("C")) {
								hasContract = true;
							} else {
								hasCarepack = true;
							}
						}
					}
				}
			}

			if (hasContract) {
				obligationDomainList = CONTRACT_OBLIGATION_DOMAIN;
			}
			if (hasCarepack) {
				if (obligationDomainList != null) {
					obligationDomainList = obligationDomainList + ","
							+ CAREPACK_OBLIGATION_DOMAIN;
				} else {
					obligationDomainList = CAREPACK_OBLIGATION_DOMAIN;
				}
			}
		}
		if (combinedProductEntitlement.getWarranty() != null
				&& combinedProductEntitlement.getWarranty().length > 0) {
			if (obligationDomainList != null) {
				obligationDomainList = obligationDomainList + ","
						+ WARRANTY_OBLIGATION_DOMAIN;
			} else {
				obligationDomainList = WARRANTY_OBLIGATION_DOMAIN;
			}
		}

		return obligationDomainList;
	}

	private boolean isCVSrelevant(EsReply reply) {
		if (cvsEnable && reply != null && reply.getEsReplyChoice() != null /*no CVS if disbale or reply is null*/
				&& reply.getEsReplyChoice().getAssociatedContracts() == null /* no cvs for contract summary*/
				&& reply.getEsReplyChoice().getContractSummary() == null /* no cvs for contract summary*/				
				&& reply.getEsReplyChoice().getInstalledBaseUnitList() == null /* no cvs for ib*/
				&& reply.getEsReplyChoice()
						.getManufacturingInstalledBaseHeader() == null/* no cvs for  MIB*/
				&& reply.getEsReplyChoice().getPrintAdvantageEntitlement() == null /* no cvs for pa*/
				&& reply.getEsReplyChoice().getRoutingDetails() == null/* no cvs for ROUTING DETAILS*/
				&& reply.getEsReplyChoice().getUnitEventHistory() == null/* no cvs for uNIT EVENT HISTORY*/
				&& reply.getEsReplyChoice().getUnitList() == null) { /* no cvs for Unit list*/
			return true;
		}
		return false;
	}

	private ComplianceValidationDevice getDeviceFromEsReply(EsReply reply,
			EsRequestComplexType request) {
		if (reply != null && reply.getEsReplyChoice() != null) {
			if (reply.getEsReplyChoice().getContractEntitlement() != null) {
				return getDeviceFromEsReply(reply.getEsReplyChoice()
						.getContractEntitlement(), request);
			}			
			if (reply.getEsReplyChoice().getCombinedProductEntitlement() != null) {
				return getDeviceFromEsReply(reply.getEsReplyChoice()
						.getCombinedProductEntitlement(), request);
			}
			if (reply.getEsReplyChoice().getCombinedUnitEntitlement() != null) {
				return getDeviceFromEsReply(reply.getEsReplyChoice()
						.getCombinedUnitEntitlement(), request);
			}
			if (reply.getEsReplyChoice().getWarrantyEntitlement() != null) {
				return getDeviceFromEsReply(reply.getEsReplyChoice()
						.getWarrantyEntitlement(), request);
			}
		}		
		return null;
	}

		
	/**
	 * 
	 * @param contractEntitlement
	 * 			ContractEntitlementComplexType
	 * @param request
	 * 			EsRequestComplexType
	 * @return ComplianceValidationDevice
	 */
	private ComplianceValidationDevice getDeviceFromEsReply(
			ContractEntitlementComplexType contractEntitlement,
			EsRequestComplexType request) {
		ComplianceValidationDevice device = new ComplianceValidationDevice();
		ESLog.debug("Entering call contractEntitlement");
		// we'll try to get it from request
			if (request!=null && request.getEsRequestComplexTypeChoice() != null
					&& request.getEsRequestComplexTypeChoice().getContractRequest() != null) {
				ESLog.debug("contractEntitlement request pn:"+request.getEsRequestComplexTypeChoice()
						.getContractRequest().getProductID());
				device.setProductNumber(request.getEsRequestComplexTypeChoice()
						.getContractRequest().getProductID());
				ESLog.debug("contractEntitlement request countryCode:"+request.getEsRequestComplexTypeChoice()
						.getContractRequest().getIsoCountryCd());
				device.setCountryCode(request.getEsRequestComplexTypeChoice()
						.getContractRequest().getIsoCountryCd());
			}			
			if (contractEntitlement.getContract() != null
					&& contractEntitlement.getContractCount() > 0 
					&& contractEntitlement.getContract(0)!=null
					&& contractEntitlement.getContract(0).getSvcAgreementID()!=null) {
				ESLog.debug("contractEntitlement reply SAID:"+contractEntitlement.getContract(0)
						.getSvcAgreementID());
				device.setServiceAgreementID(contractEntitlement.getContract(0)
						.getSvcAgreementID());
			}else{
				if(request!=null && request.getEsRequestComplexTypeChoice() != null
						&& request.getEsRequestComplexTypeChoice().getContractRequest() != null 
						&& request.getEsRequestComplexTypeChoice().getContractRequest().getContractIdentifierType()!=null){
					int isSvcAgreementID = request.getEsRequestComplexTypeChoice()
					.getContractRequest().getContractIdentifierType().compareTo(ContractIdentifierTypeType.SVCAGREEMENTID);
					ESLog.debug("contractEntitlement request isSvcAgreementID:"+request.getEsRequestComplexTypeChoice().getContractRequest().getContractIdentifier());
					if(0==isSvcAgreementID){
						device.setServiceAgreementID(request.getEsRequestComplexTypeChoice().getContractRequest().getContractIdentifier());
					}
				}
			}
		return device;
	}

	/**
	 * 
	 * @param warrantyEntitlement
	 * 			WarrantyEntitlementComplexType
	 * @param request
	 * 			EsRequestComplexType
	 * @return ComplianceValidationDevice
	 */
	private ComplianceValidationDevice getDeviceFromEsReply(
			WarrantyEntitlementComplexType warrantyEntitlement,
			EsRequestComplexType request) {
		ComplianceValidationDevice device = new ComplianceValidationDevice();
		OOSComplexType oos = warrantyEntitlement.getOOS();
		if (oos != null) {
			if (oos.getProduct() != null) {
				device.setProductNumber(oos.getProduct().getProductID());
				device.setProductLine(oos.getProduct().getProductLineCode());
			}
			if (oos.getSerialNumber() != null && oos.getSerialNumberCount() > 0) {
				device.setSerialNumber(oos.getSerialNumber(0));
			}
			// fix the issue that country code can't pass to CVS
			if (oos.getShipToCountry() != null) {
				device.setCountryCode(oos.getShipToCountry());
			} else {
				if (request != null
						&& request.getEsRequestComplexTypeChoice() != null
						&& request.getEsRequestComplexTypeChoice()
								.getWarrantyRequest() != null) {
					device.setCountryCode(request
							.getEsRequestComplexTypeChoice()
							.getWarrantyRequest().getIsoCountryCd());
				}
			}

			/*
			 * Those are null for warranty and only exist for contract
			 */
			device.setMultiVendorID(null);
			device.setMultiVendorName(null);
			device.setMultiVendorProductNumber(null);
			// device.setMultiVendorSerialNumber(null);
		} else{// we'll try to get it from request
			if (request !=null && request.getEsRequestComplexTypeChoice() != null
					&& request.getEsRequestComplexTypeChoice()
							.getWarrantyRequest() != null) {

				device.setProductNumber(request.getEsRequestComplexTypeChoice()
						.getWarrantyRequest().getProductID());
				device.setSerialNumber(request.getEsRequestComplexTypeChoice()
						.getWarrantyRequest().getSerialNumber());
				device.setCountryCode(request.getEsRequestComplexTypeChoice()
						.getWarrantyRequest().getIsoCountryCd());
			}
		}

		return device;
	}

	/**
	 * 
	 * @param combinedUnitEntitlement
	 * 			CombinedUnitEntitlementComplexType
	 * @param request
	 * 			EsRequestComplexType
	 * @return ComplianceValidationDevice
	 */
	private ComplianceValidationDevice getDeviceFromEsReply(
			CombinedUnitEntitlementComplexType combinedUnitEntitlement,
			EsRequestComplexType request) {
		ComplianceValidationDevice device = new ComplianceValidationDevice();
		ESLog.debug("Entering call combinedUnitEntitlement");
		if (combinedUnitEntitlement.getContract() != null
				&& combinedUnitEntitlement.getContractCount() > 0 
				&& combinedUnitEntitlement.getContract(0)!=null 
				&& combinedUnitEntitlement.getContract(0).getSvcAgreementID()!=null) {
					ESLog.debug("combinedUnitEntitlement reply SAID:"+combinedUnitEntitlement.getContract(0).getSvcAgreementID());
					device.setServiceAgreementID(combinedUnitEntitlement.getContract(0).getSvcAgreementID());
		}else{
			if(request != null && request.getEsRequestComplexTypeChoice() != null
					&& request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest() != null 
					&& request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getContractIdentifierType()!=null){
				int isSvcAgreementID = request.getEsRequestComplexTypeChoice()
				.getEntitlementBySnRequest().getContractIdentifierType().compareTo(ContractIdentifierTypeType.SVCAGREEMENTID);
				ESLog.debug("combinedUnitEntitlement request isSvcAgreementID:"+request.getEsRequestComplexTypeChoice()
						.getEntitlementBySnRequest().getContractIdentifier());
				if(0==isSvcAgreementID){
					device.setServiceAgreementID(request.getEsRequestComplexTypeChoice()
				.getEntitlementBySnRequest().getContractIdentifier());
				}
			}
		}
		OOSComplexType oos = combinedUnitEntitlement.getOOS();
		if (oos != null) {

			if (oos.getProduct() != null) {
				device.setProductNumber(oos.getProduct().getProductID());
				device.setProductLine(oos.getProduct().getProductLineCode());
			}
			if (oos.getSerialNumber() != null && oos.getSerialNumberCount() > 0) {
				device.setSerialNumber(oos.getSerialNumber(0));
			}
			// fix the issue that country code can't pass to CVS
			if (oos.getShipToCountry() != null) {
				device.setCountryCode(oos.getShipToCountry());
			} else {
				if (request != null
						&& request.getEsRequestComplexTypeChoice() != null
						&& request.getEsRequestComplexTypeChoice()
								.getEntitlementBySnRequest() != null) {
					device.setCountryCode(request
							.getEsRequestComplexTypeChoice()
							.getEntitlementBySnRequest().getIsoCountryCd());
				}
			}

			if (oos.getProduct() != null
					&& oos.getProduct().getManufacturer() != null) {
				device.setMultiVendorID(oos.getProduct().getManufacturer()
						.getManufacturerCode());
				device.setMultiVendorName(oos.getProduct().getManufacturer()
						.getManufacturerName());
			}

			device.setMultiVendorProductNumber(oos
					.getManufacturerProductNumber());
			// device.setMultiVendorSerialNumber("");//????????
		} else{// we'll try to get it from request
			if (request!=null && request.getEsRequestComplexTypeChoice() != null
					&& request.getEsRequestComplexTypeChoice()
							.getEntitlementBySnRequest() != null) {

				device.setProductNumber(request.getEsRequestComplexTypeChoice()
						.getEntitlementBySnRequest().getProductID());
				device.setSerialNumber(request.getEsRequestComplexTypeChoice()
						.getEntitlementBySnRequest().getSerialNumber());
				device.setCountryCode(request.getEsRequestComplexTypeChoice()
						.getEntitlementBySnRequest().getIsoCountryCd());				
			}
		}

		return device;
	}

	/**
	 * 
	 * @param combinedProductEntitlement
	 * 			CombinedProductEntitlementComplexType
	 * @param request
	 * 			EsRequestComplexType
	 * @return ComplianceValidationDevice
	 */
	private ComplianceValidationDevice getDeviceFromEsReply(
			CombinedProductEntitlementComplexType combinedProductEntitlement,
			EsRequestComplexType request) {
		ComplianceValidationDevice device = new ComplianceValidationDevice();
		ESLog.debug("Entering call combinedProductEntitlement");
		if (combinedProductEntitlement.getContract() != null
				&& combinedProductEntitlement.getContractCount() > 0
				&& combinedProductEntitlement.getContract(0)!=null
				&& combinedProductEntitlement.getContract(0).getSvcAgreementID() != null) {
					ESLog.debug("combinedProductEntitlement reply SAID:"+combinedProductEntitlement.getContract(0).getSvcAgreementID());
					device.setServiceAgreementID(combinedProductEntitlement.getContract(0).getSvcAgreementID());
		}else{
				if(request!=null && request.getEsRequestComplexTypeChoice() != null
						&& request.getEsRequestComplexTypeChoice().getEntitlementByPnRequest() != null 
						&& request.getEsRequestComplexTypeChoice().getEntitlementByPnRequest().getContractIdentifierType()!=null){
					int isSvcAgreementID = request.getEsRequestComplexTypeChoice()
					.getEntitlementByPnRequest().getContractIdentifierType().compareTo(ContractIdentifierTypeType.SVCAGREEMENTID);
					ESLog.debug("combinedProductEntitlement request isSvcAgreementID:"+request.getEsRequestComplexTypeChoice()
							.getEntitlementByPnRequest().getContractIdentifier());
					if(0==isSvcAgreementID){
						device.setServiceAgreementID(request.getEsRequestComplexTypeChoice()
					.getEntitlementByPnRequest().getContractIdentifier());
					}
				}
			}
		if (combinedProductEntitlement.getOOS() != null
				&& combinedProductEntitlement.getOOS().length > 0) {

			OOSComplexType oos = combinedProductEntitlement.getOOS(0);
			if (oos != null) {

				if (oos.getProduct() != null) {
					device.setProductNumber(oos.getProduct().getProductID());
					device.setProductLine(oos.getProduct().getProductLineCode());
				}
				if (oos.getSerialNumber() != null
						&& oos.getSerialNumberCount() > 0) {
					device.setSerialNumber(oos.getSerialNumber(0));
				}
				// fix the issue country code can't pass to CVS
				if (oos.getShipToCountry() != null) {
					device.setCountryCode(oos.getShipToCountry());
				} else {
					if (request != null
							&& request.getEsRequestComplexTypeChoice() != null
							&& request.getEsRequestComplexTypeChoice()
									.getEntitlementByPnRequest() != null) {
						device.setCountryCode(request
								.getEsRequestComplexTypeChoice()
								.getEntitlementByPnRequest().getIsoCountryCd());
					}
				}

				if (oos.getProduct() != null
						&& oos.getProduct().getManufacturer() != null) {
					device.setMultiVendorID(oos.getProduct().getManufacturer()
							.getManufacturerCode());
					device.setMultiVendorName(oos.getProduct()
							.getManufacturer().getManufacturerName());
				}

				device.setMultiVendorProductNumber(oos
						.getManufacturerProductNumber());
				// device.setMultiVendorSerialNumber("");//????????
			}
		} else{// we'll try to get it from request
			if (request!=null && request.getEsRequestComplexTypeChoice() != null
					&& request.getEsRequestComplexTypeChoice()
							.getEntitlementByPnRequest() != null) {

				device.setProductNumber(request.getEsRequestComplexTypeChoice()
						.getEntitlementByPnRequest().getProductID());

				device.setCountryCode(request.getEsRequestComplexTypeChoice()
						.getEntitlementByPnRequest().getIsoCountryCd());
				
			}
		}

		return device;
	}

	public static ComplianceValidationHelper getInstance() {
		if (instance == null) {
			return new ComplianceValidationHelper();
		}
		return instance;
	}

	public EIAMessage modifyESReply(EIAMessage reply, SifException seFromCvs) {
		if (reply.getMessageBody() != null
				&& reply.getMessageBody().getEsReply() != null) {
			reply.getMessageBody().setEsReply(
					modifyESReply(reply.getMessageBody().getEsReply(),
							seFromCvs));
			return reply;
		}
		return reply;
	}

	public EsReply modifyESReply(EsReply reply, SifException seFromCvs) {
		if (reply.getEsHeader().getWarnings() == null) {
			reply.getEsHeader().setWarnings(new Warnings());
		}
		reply.getEsHeader().getWarnings()
				.addEIAError(ErrorFactory.convertSifException(seFromCvs));
		return reply;
	}

	public static void main(String[] args) {
		EsReply reply = null;
		String transactionId = null;
		reply = new EsReply();
		reply.setEsHeader(new EsHeader());
		reply.setEsReplyChoice(new EsReplyChoice());
		reply.getEsReplyChoice().setWarrantyEntitlement(
				new WarrantyEntitlementComplexType());
		OOSComplexType oos = new OOSComplexType();
		reply.getEsReplyChoice().getWarrantyEntitlement().setOOS(oos);
		oos.addSerialNumber("2551111A3");
		// oos.setShipToCountry("US");
		oos.setProduct(new ProductComplexType());
		oos.getProduct().setProductID("C4224A");
		oos.getProduct().setProductLineCode("8A");
		transactionId = TransactionIdGenerator.getInstance().nextId();
		ComplianceValidationReply cvr;
		try {
			cvr = ComplianceValidationHelper
					.getInstance()
					.callComplianceValidationService(reply, null, transactionId);
			System.out.println("cv reply " + cvr);
		} catch (SifException e) {
			e.printStackTrace();
		}

	}
}
