/**
 * 
 */
package com.hp.es.tm.service;

import com.hp.es.service.util.ESLog;
import com.hp.es.tm.TmTransaction;
import com.hp.es.tm.util.exception.TmException;
import com.hp.es.xml.service.CombinedProductEntitlementComplexType;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.MessageBody;
import com.hp.es.xml.service.PrintAdvantageEntitlementComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;

/**
 * @author ANVOI
 *
 */
final class TransactionReplyHelper {

	/**
	 * 
	 */
	private TransactionReplyHelper() {

	}

	/*
	 * Calculate the Numbers Of Contracts
	 */
	static void calculateNumberOfContracts(EIAMessage reply,
			TmTransaction tmTrans) throws TmException {
		int numberOfGisContracts = 0;
		int numberOfPmCpqContracts = 0;
		int numberOfPmHpContracts = 0;

		final String contractPortfolioFlagS = "S";
		final String contractPortfolioFlagC = "C";
		final String contractPortfolioFlagG = "G";
		ContractComplexType[] contracts;

		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||calculateNumberOfContracts|Enter");
		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||calculateNumberOfContracts|reply=" + reply);
		if (reply == null) {
			ESLog.error("reply is null!");
			throw new TmException(
					"Can't calculate the Number Of Contracts when reply is null");
		}
		if (reply.getMessageBody() != null) {
			if (reply.getMessageBody().getEsReply() != null) {
				EsReply esReply = reply.getMessageBody().getEsReply();
				if (esReply.getEsReplyChoice() != null) {
					EsReplyChoice esReplyChoice = reply.getMessageBody()
							.getEsReply().getEsReplyChoice();
					if (esReplyChoice.getCombinedProductEntitlement() != null) {
						CombinedProductEntitlementComplexType combinedProductEntitlement = esReplyChoice
								.getCombinedProductEntitlement();
						if (combinedProductEntitlement.getContract() != null) {
							contracts = combinedProductEntitlement
									.getContract();
							for (int i = 0; i < contracts.length; i++) {
								String portfolioFlag = contracts[i]
										.getPortfolioFlag();
								if (contractPortfolioFlagS
										.equals(portfolioFlag)) {
									numberOfPmHpContracts = numberOfPmHpContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getCombinedProductEntitlement|Number Of PmHpContracts="
														+ numberOfPmHpContracts);
								}
								if (contractPortfolioFlagC
										.equals(portfolioFlag)) {
									numberOfPmCpqContracts = numberOfPmCpqContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getCombinedProductEntitlement|Number Of PmCpqContracts="
														+ numberOfPmCpqContracts);
								}
								if (contractPortfolioFlagG
										.equals(portfolioFlag)) {
									numberOfGisContracts = numberOfGisContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getCombinedProductEntitlement|Number Of GisContracts="
														+ numberOfGisContracts);
								}
							}
						}
					}
					if (esReplyChoice.getContractEntitlement() != null) {
						ContractEntitlementComplexType contractEntitlement = esReplyChoice
								.getContractEntitlement();
						if (contractEntitlement.getContract() != null) {
							contracts = contractEntitlement.getContract();
							for (int i = 0; i < contracts.length; i++) {
								String portfolioFlag = contracts[i]
										.getPortfolioFlag();
								if (contractPortfolioFlagS
										.equals(portfolioFlag)) {
									numberOfPmHpContracts = numberOfPmHpContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getContractEntitlement|Number Of PmHpContracts="
														+ numberOfPmHpContracts);
								}
								if (contractPortfolioFlagC
										.equals(portfolioFlag)) {
									numberOfPmCpqContracts = numberOfPmCpqContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getContractEntitlement|Number Of PmCpqContracts="
														+ numberOfPmCpqContracts);
								}
								if (contractPortfolioFlagG
										.equals(portfolioFlag)) {
									numberOfGisContracts = numberOfGisContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getContractEntitlement|Number Of GisContracts="
														+ numberOfGisContracts);
								}
							}
						}
					}
					if (esReplyChoice.getPrintAdvantageEntitlement() != null) {
						PrintAdvantageEntitlementComplexType printAdvantageEntitlement = esReplyChoice
								.getPrintAdvantageEntitlement();
						if (printAdvantageEntitlement.getContract() != null) {
							contracts = printAdvantageEntitlement.getContract();
							for (int i = 0; i < contracts.length; i++) {
								String portfolioFlag = contracts[i]
										.getPortfolioFlag();
								if (contractPortfolioFlagS
										.equals(portfolioFlag)) {
									numberOfPmHpContracts = numberOfPmHpContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getPrintAdvantageEntitlement|Number Of PmHpContracts="
														+ numberOfPmHpContracts);
								}
								if (contractPortfolioFlagC
										.equals(portfolioFlag)) {
									numberOfPmCpqContracts = numberOfPmCpqContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getPrintAdvantageEntitlement|Number Of PmCpqContracts="
														+ numberOfPmCpqContracts);
								}
								if (contractPortfolioFlagG
										.equals(portfolioFlag)) {
									numberOfGisContracts = numberOfGisContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getPrintAdvantageEntitlement|Number Of GisContracts="
														+ numberOfGisContracts);
								}
							}
						}
					}
					if (esReplyChoice.getCombinedUnitEntitlement() != null) {
						CombinedUnitEntitlementComplexType combinedUnitEntitlement = esReplyChoice
								.getCombinedUnitEntitlement();
						if (combinedUnitEntitlement.getContract() != null) {
							contracts = combinedUnitEntitlement.getContract();
							for (int i = 0; i < contracts.length; i++) {
								String portfolioFlag = contracts[i]
										.getPortfolioFlag();
								if (contractPortfolioFlagS
										.equals(portfolioFlag)) {
									numberOfPmHpContracts = numberOfPmHpContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getCombinedUnitEntitlement|Number Of PmHpContracts="
														+ numberOfPmHpContracts);
								}
								if (contractPortfolioFlagC
										.equals(portfolioFlag)) {
									numberOfPmCpqContracts = numberOfPmCpqContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getCombinedUnitEntitlement|Number Of PmCpqContracts="
														+ numberOfPmCpqContracts);
								}
								if (contractPortfolioFlagG
										.equals(portfolioFlag)) {
									numberOfGisContracts = numberOfGisContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getCombinedUnitEntitlement|Number Of GisContracts="
														+ numberOfGisContracts);
								}
							}
						}
					}
					if (esReplyChoice.getAssociatedContracts() != null) {
						if (esReplyChoice.getAssociatedContracts()
								.getContract() != null) {
							contracts = esReplyChoice.getAssociatedContracts()
									.getContract();
							for (int i = 0; i < contracts.length; i++) {
								String portfolioFlag = contracts[i]
										.getPortfolioFlag();
								if (contractPortfolioFlagS
										.equals(portfolioFlag)) {
									numberOfPmHpContracts = numberOfPmHpContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getAssociatedContracts|Number Of PmHpContracts="
														+ numberOfPmHpContracts);
								}
								if (contractPortfolioFlagC
										.equals(portfolioFlag)) {
									numberOfPmCpqContracts = numberOfPmCpqContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getAssociatedContracts|Number Of PmCpqContracts="
														+ numberOfPmCpqContracts);
								}
								if (contractPortfolioFlagG
										.equals(portfolioFlag)) {
									numberOfGisContracts = numberOfGisContracts + 1;
									if (ESLog.isDebugLogEnabled())
										ESLog
												.debug("getAssociatedContracts|Number Of GisContracts="
														+ numberOfGisContracts);
								}
							}
						}
					}
				}
			}
		}

		tmTrans.setNumberGisContract(numberOfGisContracts);
		tmTrans.setNumberPmcpqContract(numberOfPmCpqContracts);
		tmTrans.setNumberPmhpContract(numberOfPmHpContracts);
		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||calculateNumberOfContracts|Exit");
	}

	static void calculateNumberOfWarranties(EIAMessage reply,
			TmTransaction tmTrans) throws TmException {
		int numberOfGisWarranties = 0;
		int numberOfPmCpqWarranties = 0;
		int numberOfPmHpWarranties = 0;

		final String contractPortfolioFlagS = "S";
		final String contractPortfolioFlagC = "C";
		final String contractPortfolioFlagG = "G";
		WarrantyComplexType[] warranties;

		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||calculateNumberOfWarranties|Enter");
		if (ESLog.isDebugLogEnabled())
			ESLog
					.debug("TmService||calculateNumberOfWarranties|reply="
							+ reply);
		if (reply == null) {
			ESLog.error("Reply is null!");
			throw new TmException(
					"Can't calculate the Number Of Warranties when reply is null!");
		}
		if (reply.getMessageBody().getEsReply() != null) {
			if (reply.getMessageBody().getEsReply().getEsReplyChoice() != null) {
				EsReplyChoice esReplyChoice = reply.getMessageBody()
						.getEsReply().getEsReplyChoice();
				if (esReplyChoice.getWarrantyEntitlement() != null) {
					WarrantyEntitlementComplexType warrantyEntitlement = esReplyChoice
							.getWarrantyEntitlement();
					warranties = warrantyEntitlement.getWarranty();
					for (int i = 0; i < warranties.length; i++) {
						String portfolioFlag = warranties[i].getPortfolioFlag()
								.toString();
						if (contractPortfolioFlagS.equals(portfolioFlag)) {
							numberOfPmHpWarranties = numberOfPmHpWarranties + 1;
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("getWarrantyEntitlement|Number Of PmHpWarranties="
												+ numberOfPmHpWarranties);
						}
						if (contractPortfolioFlagC.equals(portfolioFlag)) {
							numberOfPmCpqWarranties = numberOfPmCpqWarranties + 1;
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("getWarrantyEntitlement|Number Of PmCpqWarranties="
												+ numberOfPmCpqWarranties);
						}
						if (contractPortfolioFlagG.equals(portfolioFlag)) {
							numberOfGisWarranties = numberOfGisWarranties + 1;
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("getWarrantyEntitlement|Number Of GisWarranties="
												+ numberOfGisWarranties);
						}
					}
				}
				if (esReplyChoice.getCombinedUnitEntitlement() != null) {
					CombinedUnitEntitlementComplexType combinedUnitEntitlement = esReplyChoice
							.getCombinedUnitEntitlement();
					warranties = combinedUnitEntitlement.getWarranty();
					for (int i = 0; i < warranties.length; i++) {
						String portfolioFlag = warranties[i].getPortfolioFlag()
								.toString();
						if (contractPortfolioFlagS.equals(portfolioFlag)) {
							numberOfPmHpWarranties = numberOfPmHpWarranties + 1;
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("getCombinedUnitEntitlement|Number Of PmHpWarranties="
												+ numberOfPmHpWarranties);
						}
						if (contractPortfolioFlagC.equals(portfolioFlag)) {
							numberOfPmCpqWarranties = numberOfPmCpqWarranties + 1;
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("getCombinedUnitEntitlement|Number Of PmCpqWarranties="
												+ numberOfPmCpqWarranties);
						}
						if (contractPortfolioFlagG.equals(portfolioFlag)) {
							numberOfGisWarranties = numberOfGisWarranties + 1;
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("getCombinedUnitEntitlement|Number Of GisWarranties="
												+ numberOfGisWarranties);
						}
					}
				}
				if (esReplyChoice.getCombinedProductEntitlement() != null) {
					CombinedProductEntitlementComplexType combinedProductEntitlement = esReplyChoice
							.getCombinedProductEntitlement();
					warranties = combinedProductEntitlement.getWarranty();
					for (int i = 0; i < warranties.length; i++) {
						String portfolioFlag = warranties[i].getPortfolioFlag()
								.toString();
						if (contractPortfolioFlagS.equals(portfolioFlag)) {
							numberOfPmHpWarranties = numberOfPmHpWarranties + 1;
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("getCombinedProductEntitlement|Number Of PmHpWarranties="
												+ numberOfPmHpWarranties);
						}
						if (contractPortfolioFlagC.equals(portfolioFlag)) {
							numberOfPmCpqWarranties = numberOfPmCpqWarranties + 1;
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("getCombinedProductEntitlement|Number Of PmCpqWarranties="
												+ numberOfPmCpqWarranties);
						}
						if (contractPortfolioFlagG.equals(portfolioFlag)) {
							numberOfGisWarranties = numberOfGisWarranties + 1;
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("getCombinedProductEntitlement|Number Of GisWarranties="
												+ numberOfGisWarranties);
						}
					}
				}
			}
		}
		tmTrans.setNumberGisCarepaqs(numberOfGisWarranties);
		tmTrans.setNumberPmhpCarepaqs(numberOfPmHpWarranties);
		tmTrans.setNumberPmcpqCarepaqs(numberOfPmCpqWarranties);
		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||calculateNumberOfWarranties|Exit");
	}

	protected static void processWarningCode(EIAMessage reply, TmTransaction tmTrans)
			throws TmException {
		String warningCode1 = null;
		String warningCode2 = null;
		String warningCode3 = null;
		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||processWarningCode|Enter");
		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||processWarningCode|reply=" + reply);
		if (reply == null) {
			ESLog.error("Can't process Warning Code with a empty reply!");
			throw new TmException(
					"Can't process Warning Code with a empty reply!");
		}
		if (reply.getMessageBody() == null) {
			return;
		}

		if (reply.getMessageBody().getEsReply() != null) {

			EsHeader esHeader = reply.getMessageBody().getEsReply()
					.getEsHeader();

			if (esHeader.getWarnings() != null) {
				Warnings warnings = esHeader.getWarnings();
				if (warnings.getEIAError() != null
						&& warnings.getEIAError().length >= 1) {

					warningCode1 = warnings.getEIAError(0).getErrorID();
					if (ESLog.isDebugLogEnabled())
						ESLog.debug("processWarningCode|WarningCode1="
								+ warningCode1);
					if (warnings.getEIAError().length > 2) {
						warningCode3 = warnings.getEIAError(2).getErrorID();
						if (ESLog.isDebugLogEnabled())
							ESLog.debug("processWarningCode|WarningCode3="
									+ warningCode3);
					}
					if (warnings.getEIAError().length > 1) {
						warningCode2 = warnings.getEIAError(1).getErrorID();
						if (ESLog.isDebugLogEnabled())
							ESLog.debug("processWarningCode|WarningCode2="
									+ warningCode2);
					}
				}
				tmTrans.setWarningCode1(warningCode1);
				tmTrans.setWarningCode2(warningCode2);
				tmTrans.setWarningCode3(warningCode3);
			}
		}
		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||processWarningCode|Exit");
	}

	// Start to process response code
	protected static void processReplyResponseCode(EIAMessage reply, TmTransaction tmTrans) throws TmException {
		ESLog.debug("TmService||processResponseCode|Enter");
		String response = null;

		if (reply == null || tmTrans == null) {
			ESLog.error("Can't process Response Code with a empty reply!");
			throw new TmException("Can't process Response Code with a empty reply!");
		}

		// responseBeforeFraud=getResponseCode(replyBeforeFraud);
		response = getResponseCode(reply);
		tmTrans.setResponseCode(response);

		ESLog.debug("TmService||processResponseCode|Exit");
	}

	static String getResponseCode(EIAMessage reply) {
		String responseCode = null;
		EIAError error = null;
		if (reply != null) {
			MessageBody messageBody = reply.getMessageBody();

			if (messageBody == null) {
				ESLog
						.debug("TmService||processResponseCode|messageBody is null!");
				return null;
			} else {
				ESLog.debug("TmService||processResponseCode|Message Body="
						+ messageBody.toString());
				error = messageBody.getEIAError();
				if (messageBody.getEsReply() == null && error != null) {
					ESLog.debug("TmService||processResponseCode|Error Id ="
							+ error);
					responseCode = error.getErrorID();
				} else if (messageBody.getEsReply() != null) {
					EsReply esReply = messageBody.getEsReply();
					if (esReply.getEsReplyChoice() != null) {
						EsReplyChoice esReplyChoice = esReply
								.getEsReplyChoice();
						if ((esReplyChoice.getWarrantyEntitlement() != null)
								&& (esReplyChoice.getWarrantyEntitlement()
										.getWarranty().length > 0)) {
							responseCode = esReplyChoice
									.getWarrantyEntitlement().getWarranty(0)
									.getWarrantyDeterminationCode();

						} else if ((esReplyChoice.getCombinedUnitEntitlement() != null)
								&& (esReplyChoice.getCombinedUnitEntitlement()
										.getWarranty().length > 0)) {
							responseCode = esReplyChoice
									.getCombinedUnitEntitlement()
									.getWarranty(0)
									.getWarrantyDeterminationCode();
						} else if ((esReplyChoice
								.getCombinedProductEntitlement() != null)
								&& (esReplyChoice
										.getCombinedProductEntitlement()
										.getWarranty().length > 0)) {
							responseCode = esReplyChoice
									.getCombinedProductEntitlement()
									.getWarranty(0)
									.getWarrantyDeterminationCode();
							ESLog
									.debug("TmService||processResponseCode|warranty Determ Code="
											+ responseCode);
						} else if (esReplyChoice.getUnitList() != null) {
							ESLog
									.debug("TmService||processResponseCode|Operating is UnitList: response code is 10!");
							responseCode = "10";
						} else {
							ESLog
									.debug("TmService||processResponseCode|Other Operation, response code is 1!");
							// add by kangli
							// here should be rechecked to add the operations of
							// GetEntitlementBySnOperation and
							// GetEntitlementByPnOperation
							responseCode = "1";
						}
					} else {
						responseCode = "1";
					}

				} else {
					responseCode = "1";
				}
			}
		} else {
			return null;
		}
		return responseCode;
	}	
	
}
