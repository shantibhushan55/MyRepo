package com.hp.es.tm.service;

import java.math.BigDecimal;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;
import com.hp.es.tm.TmTransaction;
import com.hp.es.tm.util.exception.TmException;
import com.hp.es.xml.service.CombinedProductEntitlementComplexType;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.ContractSummaryComplexType;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.InstalledBaseUnitListComplexType;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;

class TransactionCommonFieldHelper {
	/*
	 * Process the common fields
	 */
	static void  processCommonFields(EIAMessage request, EIAMessage reply,
			TmTransaction tmTrans, long startDate, long responseTime)
			throws TmException {
		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||processCommonFields|Enter");

		if (request == null) {
			ESLog.error("Can't Generate TmTransaction with a null request!");
			throw new TmException(
					"The request can't be null when process Common Fields");
		}
		if (reply == null) {
			ESLog.error("Can't Generate TmTransaction with a null reply!");
			throw new TmException(
					"The reply can't be null when process Common Fields");
		}
		// Process the Start date and End date which from Transaction

		String clientAppId = RequestHelper.getClientAppId(request);
		String esOperation = RequestHelper.getESOperation(request);
		BigDecimal transactionId = RequestHelper.getTransactionId(request);

		// Process reply SN product line and country code
		String replySn = null;
		String replyPn = null;
		String replyProductLine = null;
		String replyCountryCd = null;

		if (reply.getMessageBody() != null) {
			if (reply.getMessageBody().getEsReply() != null) {
				if (reply.getMessageBody().getEsReply().getEsReplyChoice() != null) {
					EsReplyChoice esReplyChoice = reply.getMessageBody()
							.getEsReply().getEsReplyChoice();
					if (esReplyChoice.getCombinedUnitEntitlement() != null) {
						CombinedUnitEntitlementComplexType combinedUnitEntitlement = esReplyChoice
								.getCombinedUnitEntitlement();
						if (combinedUnitEntitlement.getOOS() != null) {
							if (combinedUnitEntitlement.getOOS()
									.getSerialNumber() != null
									&& combinedUnitEntitlement.getOOS()
											.getSerialNumber().length > 0) {
								replySn = combinedUnitEntitlement.getOOS()
										.getSerialNumber(0);
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("combinedUnitEntitlement|ES Reply Serial Number="
													+ replySn);
							}

							if (combinedUnitEntitlement.getOOS().getProduct() != null) {
								replyPn = combinedUnitEntitlement.getOOS()
										.getProduct().getProductID();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("combinedUnitEntitlement|ES Reply Product Number="
													+ replyPn);
								replyProductLine = combinedUnitEntitlement
										.getOOS().getProduct()
										.getProductLineCode();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("combinedUnitEntitlement|ES Reply Product Line Code="
													+ replyProductLine);
							}
						}
						if (combinedUnitEntitlement.getLocation() != null
								&& combinedUnitEntitlement.getLocation().length > 0) {
							replyCountryCd = combinedUnitEntitlement
									.getLocation(0).getIsoCountryCd();
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("combinedUnitEntitlement|ES Reply Country Code="
												+ replyCountryCd);
						}
					}
					if (esReplyChoice.getWarrantyEntitlement() != null) {
						WarrantyEntitlementComplexType warrantyEntitlement = esReplyChoice
								.getWarrantyEntitlement();
						if (warrantyEntitlement.getOOS() != null) {
							if (warrantyEntitlement.getOOS().getSerialNumber() != null
									&& warrantyEntitlement.getOOS()
											.getSerialNumber().length > 0) {
								replySn = warrantyEntitlement.getOOS()
										.getSerialNumber(0);
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("warrantyEntitlement|ES Reply Serial Number="
													+ replySn);
							}

							if (warrantyEntitlement.getOOS().getProduct() != null) {
								replyPn = warrantyEntitlement.getOOS()
										.getProduct().getProductID();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("warrantyEntitlement|ES Reply Product Number="
													+ replyPn);
								replyProductLine = warrantyEntitlement.getOOS()
										.getProduct().getProductLineCode();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("warrantyEntitlement|ES Reply Product Line Code="
													+ replyProductLine);
							}
						}
						if (warrantyEntitlement.getLocation() != null
								&& warrantyEntitlement.getLocation().length > 0) {
							replyCountryCd = warrantyEntitlement.getLocation(0)
									.getIsoCountryCd();
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("warrantyEntitlement|ES Reply Country Code="
												+ replyCountryCd);
						}
					}
					if (esReplyChoice.getUnitList() != null) {
						UnitListComplexType unitList = esReplyChoice
								.getUnitList();
						replySn = unitList.getSerialNumber();
						if (ESLog.isDebugLogEnabled())
							ESLog.debug("unitList|ES Reply Serial Number="
									+ replySn);
						if (unitList.getProduct() != null
								&& unitList.getProduct().length > 0) {
							replyPn = unitList.getProduct(0).getProductID();
							if (ESLog.isDebugLogEnabled())
								ESLog.debug("unitList|ES Reply Product Number="
										+ replyPn);
							replyProductLine = unitList.getProduct(0)
									.getProductLineCode();
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("unitList|ES Reply Product Line Code="
												+ replyProductLine);
						}
					}
					if (esReplyChoice.getInstalledBaseUnitList() != null) {
						InstalledBaseUnitListComplexType installedBaseUnitList = esReplyChoice
								.getInstalledBaseUnitList();
						if (installedBaseUnitList.getOOS() != null
								&& installedBaseUnitList.getOOS().length > 0) {
							if (installedBaseUnitList.getOOS(0)
									.getSerialNumber() != null
									&& installedBaseUnitList.getOOS(0)
											.getSerialNumber().length > 0) {
								replySn = installedBaseUnitList.getOOS(0)
										.getSerialNumber(0);
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("installedBaseUnitList|ES Reply Serial Number="
													+ replySn);
							}

							if (installedBaseUnitList.getOOS(0).getProduct() != null) {
								replyPn = installedBaseUnitList.getOOS(0)
										.getProduct().getProductID();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("installedBaseUnitList|ES Reply Product Number="
													+ replyPn);
								replyProductLine = installedBaseUnitList
										.getOOS(0).getProduct()
										.getProductLineCode();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("installedBaseUnitList|ES Reply Product Line Code="
													+ replyProductLine);
							}
						}
					}
					if (esReplyChoice.getContractEntitlement() != null) {
						ContractEntitlementComplexType contractEntitlement = esReplyChoice
								.getContractEntitlement();
						if (contractEntitlement.getOOS() != null
								&& contractEntitlement.getOOS().length > 0) {

							if (contractEntitlement.getOOS(0).getSerialNumber() != null
									&& contractEntitlement.getOOS(0)
											.getSerialNumber().length > 0) {
								replySn = contractEntitlement.getOOS(0)
										.getSerialNumber(0);
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("contractEntitlement|ES Reply Serial Number="
													+ replySn);
							}
							if (contractEntitlement.getOOS(0).getProduct() != null) {
								replyPn = contractEntitlement.getOOS(0)
										.getProduct().getProductID();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("contractEntitlement|ES Reply Product Number="
													+ replyPn);
								replyProductLine = contractEntitlement
										.getOOS(0).getProduct()
										.getProductLineCode();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("contractEntitlement|ES Reply Product Line Code="
													+ replyProductLine);
							}
						}
						if (contractEntitlement.getLocation() != null
								&& contractEntitlement.getLocation().length > 0) {
							replyCountryCd = contractEntitlement.getLocation(0)
									.getIsoCountryCd();
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("contractEntitlement|ES Reply Country Code="
												+ replyCountryCd);
						}
					}
					if (esReplyChoice.getContractSummary() != null) {
						ContractSummaryComplexType contractSummary = esReplyChoice
								.getContractSummary();
						if (contractSummary.getProductList() != null
								&& contractSummary.getProductList().length > 0) {
							replyPn = contractSummary.getProductList(0)
									.getProductID();
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("contractSummary|ES Reply Product Number="
												+ replyPn);
						}
						if (contractSummary.getLocation() != null
								&& contractSummary.getLocation().length > 0) {
							replyCountryCd = contractSummary.getLocation(0)
									.getIsoCountryCd();
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("contractSummary|ES Reply Country Code="
												+ replyCountryCd);
						}
					}
					if (esReplyChoice.getCombinedProductEntitlement() != null) {
						CombinedProductEntitlementComplexType combinedProductEntitlement = esReplyChoice
								.getCombinedProductEntitlement();
						if (combinedProductEntitlement.getOOS() != null
								&& combinedProductEntitlement.getOOS().length > 0) {
							if (combinedProductEntitlement.getOOS(0)
									.getProduct() != null) {
								replyPn = combinedProductEntitlement.getOOS(0)
										.getProduct().getProductID();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("combinedProductEntitlement|ES Reply Product Number="
													+ replyPn);
								replyProductLine = combinedProductEntitlement
										.getOOS(0).getProduct()
										.getProductLineCode();
								if (ESLog.isDebugLogEnabled())
									ESLog
											.debug("combinedProductEntitlement|ES Reply Product Line Code="
													+ replyProductLine);
							}
						}
						if (combinedProductEntitlement.getLocation() != null
								&& combinedProductEntitlement.getLocation().length > 0) {
							replyCountryCd = combinedProductEntitlement
									.getLocation(0).getIsoCountryCd();
							if (ESLog.isDebugLogEnabled())
								ESLog
										.debug("combinedProductEntitlement|ES Reply Country Code="
												+ replyCountryCd);
						}
					}
				}
			}
		}
		tmTrans.setTransactionId(transactionId);
		tmTrans.setStartDate(startDate);
		tmTrans.setResponseTime(responseTime);
		tmTrans.setEsVersion(EsConstants.ES_TM_VERSION);
		tmTrans.setAppClientId(clientAppId);
		tmTrans.setEsOperation(esOperation);
		tmTrans.setReplySn(replySn);
		tmTrans.setReplyPn(replyPn);
		tmTrans.setReplyProductLine(replyProductLine);
		tmTrans.setReplyCountryCode(replyCountryCd);
		if (ESLog.isDebugLogEnabled())
			ESLog.debug("TmService||processCommonFields|Exit");
	}

	
	
}
