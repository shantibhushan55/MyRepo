/**
 * 
 */
package com.hp.es.tm.service;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.hp.es.service.util.ESLog;
import com.hp.es.tm.FraudTransaction;
import com.hp.es.tm.util.exception.TmException;
import com.hp.es.xml.service.CombinedProductEntitlementComplexType;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.WarrantyComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply;

/**
 * @author ANVOI
 *
 */
class TransactionCVSHelper {
	// set fraudTransaction about four date field and
	// OriginalWarrantyDeterminationCode
	static void processTransaction( EIAMessage reply, FraudTransaction fraudTransaction, ComplianceValidationReply cvsReply) throws TmException {
		
		if (reply == null
				|| reply.getMessageBody()  == null
				|| fraudTransaction == null) {
			ESLog.error("Can't process Response Code with a empty reply!");
			throw new TmException("Can't process Response Code with a empty reply!");
		}
		EsReply esreply = reply.getMessageBody().getEsReply();
		// responseBeforeFraud=getResponseCode(replyBeforeFraud);
		//Calculation the original reply response code
		String response = TransactionReplyHelper.getResponseCode(reply);

	
		
		if (esreply != null) {
			EsReplyChoice esReplyChoice = esreply.getEsReplyChoice();
			if (esReplyChoice != null) {
				/*String operation = esreply.getEsHeader().getInputRequest()
						.getOperation();*/
				Timestamp contractEndDate = null;
				Timestamp contractStartDate = null;
				Timestamp warrantyEndDate = null;
				Timestamp warrantyStartDate = null;
				
				String warrantyDeterminationCode = null;
				String warrantyId = null;

				// getEntitlementBySn
				// CombinedUnitEntitlement-OverallContractStartDate��OverallWarrantyStartDate
				if (esReplyChoice.getCombinedUnitEntitlement() != null) {
					CombinedUnitEntitlementComplexType combinedUnitEntitlementComplexType = esReplyChoice.getCombinedUnitEntitlement();
					if (combinedUnitEntitlementComplexType != null) {
						if (combinedUnitEntitlementComplexType
								.getOverallContractEndDate() != null)
							contractEndDate = new Timestamp(
									combinedUnitEntitlementComplexType
											.getOverallContractEndDate()
											.toDate().getTime());
						if (combinedUnitEntitlementComplexType
								.getOverallContractStartDate() != null)
							contractStartDate = new Timestamp(
									combinedUnitEntitlementComplexType
											.getOverallContractStartDate()
											.toDate().getTime());
						if (combinedUnitEntitlementComplexType
								.getOverallWarrantyEndDate() != null)
							warrantyEndDate = new Timestamp(
									combinedUnitEntitlementComplexType
											.getOverallWarrantyEndDate()
											.toDate().getTime());
						if (combinedUnitEntitlementComplexType
								.getOverallWarrantyStartDate() != null)
							warrantyStartDate = new Timestamp(
									combinedUnitEntitlementComplexType
											.getOverallWarrantyStartDate()
											.toDate().getTime());
						WarrantyComplexType[] warrantyEntitlementComplexTypes = combinedUnitEntitlementComplexType.getWarranty();
						if (warrantyEntitlementComplexTypes != null && warrantyEntitlementComplexTypes.length >0 ) {
							//now let's assign id and detcode
							if(warrantyEntitlementComplexTypes[0] != null) {
								warrantyDeterminationCode = warrantyEntitlementComplexTypes[0].getWarrantyDeterminationCode();
								warrantyId=warrantyEntitlementComplexTypes[0].getTermCode();
							}
						}						
					}
					

					ESLog
							.debug("processFraudTransaction|warrantyEntitlementComplexType:contractEndDate:"
									+ contractEndDate
									+ ",contractStartDate:"
									+ contractStartDate
									+ ",warrantyEndDate:"
									+ warrantyEndDate
									+ ",warrantyStartDate:"
									+ warrantyStartDate);

					// getEntitlementByPn
					// CombinedProductEntitlement-OverallContractStartDate��OverallWarrantyStartDate
				} else if (esReplyChoice.getCombinedProductEntitlement() != null) {
					CombinedProductEntitlementComplexType combinedProductEntitlementComplexType = esReplyChoice.getCombinedProductEntitlement();
					if (combinedProductEntitlementComplexType != null) {
						if (combinedProductEntitlementComplexType
								.getOverallContractEndDate() != null)
							contractEndDate = new Timestamp(
									combinedProductEntitlementComplexType
											.getOverallContractEndDate()
											.toDate().getTime());
						if (combinedProductEntitlementComplexType
								.getOverallContractStartDate() != null)
							contractStartDate = new Timestamp(
									combinedProductEntitlementComplexType
											.getOverallContractStartDate()
											.toDate().getTime());
						if (combinedProductEntitlementComplexType
								.getOverallWarrantyEndDate() != null)
							warrantyEndDate = new Timestamp(
									combinedProductEntitlementComplexType
											.getOverallWarrantyEndDate()
											.toDate().getTime());
						if (combinedProductEntitlementComplexType
								.getOverallWarrantyStartDate() != null)
							warrantyStartDate = new Timestamp(
									combinedProductEntitlementComplexType
											.getOverallWarrantyStartDate()
											.toDate().getTime());
						WarrantyComplexType[] warrantyEntitlementComplexTypes = combinedProductEntitlementComplexType.getWarranty();
						if (warrantyEntitlementComplexTypes != null && warrantyEntitlementComplexTypes.length >0 ) {
							//now let's assign id and detcode
							if(warrantyEntitlementComplexTypes[0] != null) {
								warrantyDeterminationCode = warrantyEntitlementComplexTypes[0].getWarrantyDeterminationCode();
								warrantyId=warrantyEntitlementComplexTypes[0].getTermCode();
							}
						}	
						
						ESLog
								.debug("processFraudTransaction|warrantyEntitlementComplexType:contractEndDate:"
										+ contractEndDate
										+ ",contractStartDate:"
										+ contractStartDate
										+ ",warrantyEndDate:"
										+ warrantyEndDate
										+ ",warrantyStartDate:"
										+ warrantyStartDate);
					}

				} else if (esReplyChoice.getWarrantyEntitlement() != null) {
					// getWarrantyEntitlement
					// WarrantyEntitlement-OverallWarrantyStartDate
					WarrantyEntitlementComplexType warrantyEntitlementComplexType = esReplyChoice.getWarrantyEntitlement();
					if (warrantyEntitlementComplexType != null) {
						if (warrantyEntitlementComplexType
								.getOverallWarrantyEndDate() != null)
							warrantyEndDate = new Timestamp(
									warrantyEntitlementComplexType
											.getOverallWarrantyEndDate()
											.toDate().getTime());

						if (warrantyEntitlementComplexType
								.getOverallWarrantyStartDate() != null)
							warrantyStartDate = new Timestamp(
									warrantyEntitlementComplexType
											.getOverallWarrantyStartDate()
											.toDate().getTime());
						
						WarrantyComplexType[] warrantyEntitlementComplexTypes = warrantyEntitlementComplexType.getWarranty();
						if (warrantyEntitlementComplexTypes != null && warrantyEntitlementComplexTypes.length >0 ) {
							//now let's assign id and detcode
							if(warrantyEntitlementComplexTypes[0] != null) {
								warrantyDeterminationCode = warrantyEntitlementComplexTypes[0].getWarrantyDeterminationCode();
								warrantyId=warrantyEntitlementComplexTypes[0].getTermCode();
							}
						}							
						ESLog
								.debug("processFraudTransaction|warrantyEntitlementComplexType:contractEndDate:"
										+ contractEndDate
										+ ",contractStartDate:"
										+ contractStartDate
										+ ",warrantyEndDate:"
										+ warrantyEndDate
										+ ",warrantyStartDate:"
										+ warrantyStartDate);
					}

				}
				fraudTransaction.setOriginalEntitlementResponseCode(response);
				fraudTransaction.setOriginalWarrantyDeterminationCode(warrantyDeterminationCode);
				fraudTransaction.setOriginalWarrantyId(warrantyId);
				fraudTransaction.setOriginalContractEndDate(contractEndDate);
				fraudTransaction.setOriginalContractStartDate(contractStartDate);
				fraudTransaction.setOriginalWarrantyEndDate(warrantyEndDate);
				fraudTransaction.setOriginalWarrantyStartDate(warrantyStartDate);
				fraudTransaction.setFraudCheckTransactionId(new BigDecimal(cvsReply.getCheckTransactionId()));
				fraudTransaction.setFlagTypeCode(cvsReply.getValidationResponseID());
				
			}
		}
	}

}
