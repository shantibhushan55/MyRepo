/*
 * Project: HPS Entitlement Service - Mercury Integration
 *
 * Copyright (c) 2007 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * Revision 1.0  
 * Author: olcay.yesilyurt@hp.com
 * Initial revision
 *
 */
package com.hp.es.service.contractSummary.orchestration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import org.exolab.castor.types.DateTimeBase;

import com.hp.es.service.contractSummary.integration.mapping.CSWorkingMapper;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.ContractSummaryComplexType;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.ObligationHeaderComplexType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.es.xml.service.types.ContractStatusType;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public class ContractSummaryTransactionComposition  extends GenericContractSummaryTransactionComposition {

	private static ContractSummaryTransactionComposition _instance =  new ContractSummaryTransactionComposition();;
	
	/*
	 * Constructor
	 */
	protected ContractSummaryTransactionComposition() {
		super();
	}

	
	/*
	 * 
	 */
	protected void calculateReplyHeaderFields(EsReply finalReply) {
		finalReply.getEsReplyChoice().getContractSummary().setActiveContractEntitlement(isObligationHeaderActive(finalReply));
		finalReply.getEsReplyChoice().getContractSummary().setOverallContractStartDate(getEarliestHeaderStartDate(finalReply));
		finalReply.getEsReplyChoice().getContractSummary().setOverallContractEndDate(getLatestHeaderEndDate(finalReply));
	}

	
	
    /**
     * This Methode checks if an obligation header object has a true active status (ContractStatus)
     * @return true if an obligation header's contractStatus is checked "X"
     */
    private boolean isObligationHeaderActive(EsReply finalReply) {
    	boolean isActive = false;
    	
        if(finalReply != null) {
	        if(finalReply.getEsReplyChoice().getContractSummary() !=null) {
	        	ObligationHeaderComplexType[] obHeaders= finalReply.getEsReplyChoice().getContractSummary().getObligationHeader();
	            // iterate over all obligation Header
	            for (int i = 0; i<obHeaders.length;i++ ) {
	            	ObligationHeaderComplexType oh = (ObligationHeaderComplexType)obHeaders[i];
	            	if (oh.getContractStatus().equals(ContractStatusType.A)
                            || oh.getContractStatus().equals(ContractStatusType.E)
                            || oh.getContractStatus().equals(ContractStatusType.I)) {
                        // ENUMERATION A = Active
                        // ENUMERATION E = EverGreen
	            		// ENUMERATION I = Informal
                        return true;
	            	}
	            	else if(oh.getContractStatus().equals(ContractStatusType.B)){
                        // (DeliveryBlock == 'HW' or DeliveryBlock =='SW')
                        // And 
	            	    // ((CheckDate >= StartDate AND (EndDate not empty AND CheckDate <= EndDate) Or (EndDate is empty)))
	            	    boolean deliveryBlockFlag = ("HW".equalsIgnoreCase(oh.getDeliveryBlock()) || "SW".equalsIgnoreCase(oh.getDeliveryBlock()));
                        if (deliveryBlockFlag == true) {
                            org.exolab.castor.types.Date checkDate = finalReply.getEsHeader().getInputRequest().getEsRequestComplexTypeChoice().getContractSummaryRequest().getEntitlementCheckDate();
                            if ((checkDate == null) || (checkDate.toString().trim().equalsIgnoreCase("0000-00-00")) || (checkDate.toString().trim().length() <= 0)) {
                                checkDate = new org.exolab.castor.types.Date(new java.util.Date());
                            }
                            org.exolab.castor.types.Date endDate = oh.getHeaderEndDate();
                            org.exolab.castor.types.Date startDate = oh.getHeaderStartDate();

                            boolean startDateFlag=(checkDate.compareTo(startDate) == DateTimeBase.GREATER_THAN || checkDate.compareTo(startDate) == DateTimeBase.EQUALS);
                            boolean endDateFlag=(checkDate.compareTo(endDate) == DateTimeBase.LESS_THAN || checkDate.compareTo(endDate) == DateTimeBase.EQUALS);
                            if (endDate == null || (startDateFlag == true && endDateFlag == true))
                                return true;
                        }
                    }
	            }
	        }
        }
    	return isActive;
    }

    
    /**
     * @return the earliest start date (HeaderStartDate) from all existing ObligationHeader objects
     */
    private org.exolab.castor.types.Date getEarliestHeaderStartDate(EsReply finalReply) {
        org.exolab.castor.types.Date date = null;
        // find the earliest start date from all ObligationHeaders
     	
        if(finalReply != null) {
	        if(finalReply.getEsReplyChoice().getContractSummary() !=null) {
	        	ObligationHeaderComplexType[] obHeaders= finalReply.getEsReplyChoice().getContractSummary().getObligationHeader();
	            // iterate over all obligation Header
	            for (int i = 0; i<obHeaders.length;i++ ) {
	            	ObligationHeaderComplexType oh = (ObligationHeaderComplexType)obHeaders[i];
	            	if(oh.getHeaderStartDate() != null){
	                    if (date==null || date.compareTo(oh.getHeaderStartDate())== org.exolab.castor.types.DateTimeBase.GREATER_THAN) {
	                        date = oh.getHeaderStartDate();
	                    }	
	            	}
	            }
	        }
        }
        return date;
    }

    
    
    /**
     * @return the latest header end date (HeaderEndDate) from all existing ObligationHeader objects
     */
    private org.exolab.castor.types.Date getLatestHeaderEndDate(EsReply finalReply) {
        org.exolab.castor.types.Date date = null;
        // find the latest end date from all ObligationHeaders

        if(finalReply != null) {
	        if(finalReply.getEsReplyChoice().getContractSummary() !=null) {
	        	ObligationHeaderComplexType[] obHeaders= finalReply.getEsReplyChoice().getContractSummary().getObligationHeader();
	            // iterate over all obligation Header
	            for (int i = 0; i<obHeaders.length;i++ ) {
	            	ObligationHeaderComplexType oh = (ObligationHeaderComplexType)obHeaders[i];
	            	ContractStatusType status = oh.getContractStatus();
	            	if (status.equals(ContractStatusType.E)) {
	            	    //E means EverGreen. In this case, the OverallEndDate should be empty. 
                        return null;
                    }
	            	if (status.equals(ContractStatusType.I) && oh.getHeaderEndDate() == null) {
                        // if the obligation status is Informal, the OverallEndDate
                        // should be empty once obligation endDate is empty.
                        return null;
                    }
	            	if (status.equals(ContractStatusType.B)
                            && finalReply.getEsReplyChoice().getContractSummary().getActiveContractEntitlement() == true
                            && oh.getHeaderEndDate() == null) {
                        // if the obligation status is Blocked, the OverallEndDate
                        // should be empty once obligation endDate is empty.
                        return null;
                    }
                    
	            	if(oh.getHeaderEndDate() != null){
	                    if (date==null || date.compareTo(oh.getHeaderEndDate())== org.exolab.castor.types.DateTimeBase.LESS_THAN) {
	                        date = oh.getHeaderEndDate();
	                    }	
	            	}
	            }
	        }
        }
        return date;
    }
	
	
	public EsReply getComposedReply(ArrayList replies, boolean includeWorkings) throws SifException {
		EsReply finalReply = null;
		EsReply odsReply = null;
		EsReply cqsReply = null;
		SifException odsException = null;
		SifException cqsException = null;
		/*
		 * We have 2 groups of Transaction potentially, CQS and ODS
		 * We need to compose one reply from CQS and one for ODS
		 */
		ESLog.debug("Composing reply");
		try {
			
			odsReply = getODSEsReply(replies);			
		}catch(SifException e) {
			ESLog.debug("ODS reply is a SifException" + e.getMessage());
			odsException = e;			
		}
		
		try {
			cqsReply = getCQSEsReply(replies,includeWorkings);
		}catch(SifException e) {
			ESLog.debug("CQS reply is a SifException"  + e.getMessage());
			cqsException = e;
		}	
		
		/*
		 * We should always have an answer as we first got the exection if any case
		 * but we will generate a 9999 if we cannot find any reply
		 * 
		 */
		if((cqsReply == null) && (odsReply == null) &&(odsException == null) &&(cqsException == null)) {
			ESLog.debug("Internal error, no reply for cqs or ods, this is a bug");
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Composition of reply failed because there is no reply to compose");
		}else if((cqsReply != null) && (odsReply == null)) {
			ESLog.debug("No ODS reply, we take CQS reply");
			finalReply=cqsReply;
			//add warning for ODS
			if (odsException != null && includeWorkings) {
				CSWorkingMapper errorWork = new CSWorkingMapper(odsException.getErrorText(),"ODS Customer Indicator");						
				WorkingComplexType working = errorWork.map();
				if(working != null) {
					finalReply.getEsReplyChoice().getContractSummary().addWorking(working);
				}
			}
		}else if((cqsReply == null) && (odsReply != null)) {
			ESLog.debug("No CQS reply, we take ODS reply");
			finalReply=odsReply;
			//				add warning for CQS
			if(includeWorkings && cqsException != null) {
				
				finalReply = addCQSNoReplyWorkings(finalReply,replies );	
			}

			
		}else if (((cqsReply == null) && (odsReply == null)) && ((odsException != null) || (cqsException != null))) {
			if (cqsException != null) 
				throw cqsException;
			else
				throw odsException;
			
		}else {
			//In that case both reply are not null
			//we have to merge the reply together
			ESLog.debug("Reply from both, they will be merge");
			finalReply =  mergeCQSandODSreply(cqsReply, odsReply);
		}
		/*
		 * If we had an exception we may have to add a warning
		 */
		if(cqsException != null || odsException !=null ) {
			String unavailableRegionList = ContractSummaryErrorsProcessing.getInstance().getUnavailableRegionList(replies);
			if(unavailableRegionList.trim().length() !=0) {
				addWarning(unavailableRegionList, finalReply);	
			}
		}
		
		return finalReply;
	}


	
	protected EsReply mergeCQSandODSreply(EsReply cqsReply, EsReply odsReply) {
		EsReply finalReply = null;
		if(cqsReply== null || odsReply ==null) {
			if(cqsReply != null)
				finalReply= cqsReply;
			if(odsReply != null) 
				finalReply= odsReply;
		}else  {
			//We will then merge  everything except header
			//So in other word we only map header
			ContractSummaryComplexType odsC = odsReply.getEsReplyChoice().getContractSummary();
			ContractSummaryComplexType cqsC = cqsReply.getEsReplyChoice().getContractSummary();
			finalReply = cqsReply;
			
			//Obligation Headers
			if(odsC.getObligationHeaderCount() != 0) {
				for(int i = 0; i< odsC.getObligationHeaderCount(); i++) {
					cqsC.addObligationHeader(odsC.getObligationHeader(i));
				}
			}			
			

			//Workings
			if(odsC.getWorkingCount() != 0) {
				for(int i = 0; i< odsC.getWorkingCount(); i++) {
					cqsC.addWorking(odsC.getWorking(i));
				}
			}
		}
		return finalReply;
	}
	
	
	
	private EsReply addCQSNoReplyWorkings(EsReply finalReply, ArrayList replies) {
		try {
			ArrayList list = getOnlyCQSTransaction(replies);
			Iterator iter = list.iterator();
			while(iter.hasNext()) {
				Transaction transCQS = (Transaction)iter.next();
				WorkingComplexType working = ContractSummaryErrorsProcessing.getInstance().getErrorWorking(transCQS);
				if(working != null) {
					finalReply.getEsReplyChoice().getContractSummary().addWorking(working);
				}
			}
			
		} catch (SifException e) {

			ESLog.debug("Error while adding workings", e);
		}
		
		
		return finalReply;
	}

	
	
	/*
	 * This method compose the CQS ES reply
	 * @param the list of replies
	 * @return the EsReply which can be null
	 * @throws a SifException if appropriate
	 */
	protected EsReply getCQSEsReply(ArrayList trans, boolean includeWorking) throws SifException {
		//The first thing that we do is to extract only the CQS transaction in a new table
		ArrayList list = getOnlyCQSTransaction(trans);

		//we create the final reply
		EsReply finalReply= null;
		/* WITS.1468 The workings which document error transactions
		 * The workings for the successfully finished transactions were created while mapping*/		
		TreeMap errorMaps = new TreeMap();
		
		
		//We then go through the array
		if(list != null) {
			Iterator it = list.iterator();
			//we then look if we don't only have errors
			
			if(ContractSummaryErrorsProcessing.getInstance().countSifException(list) == list.size()) {
				throw ContractSummaryErrorsProcessing.getInstance().getHighestPriorityException(list);
			}else {
				
				while(it.hasNext()) {
					Object tmp = it.next();
					if(tmp instanceof ContractSummaryTransaction)  {
						ContractSummaryTransaction transCQS = (ContractSummaryTransaction) tmp;
						if(transCQS.getMappedReply() != null) {
							ESLog.debug("The mapped reply is not null, we will merge it with the final reply");
							finalReply= merge2CQSContractReplies(finalReply, transCQS.getMappedReply());
						}else {
							if(includeWorking) {
								WorkingComplexType working = ContractSummaryErrorsProcessing.getInstance().getErrorWorking(transCQS);
								errorMaps.put(working.getWorkingName(), working);
							}
							
						}
					}else if (tmp instanceof ErrorTransaction) {
						ErrorTransaction transCQS = (ErrorTransaction) tmp;

						
						WorkingComplexType working = ContractSummaryErrorsProcessing.getInstance().getErrorWorking(transCQS);
						errorMaps.put(working.getWorkingName(), working);
						
					}

				}
				
				//WITS.1468 Now we add the workings for the error transactions
				if(includeWorking) {
					for (int i=0;i<finalReply.getEsReplyChoice().getContractSummary().getWorkingCount();i++) {
						WorkingComplexType working = finalReply.getEsReplyChoice().getContractSummary().getWorking(i);
						errorMaps.put(working.getWorkingName(), working);
						finalReply.getEsReplyChoice().getContractSummary().removeWorking(working);
					}
					for (Iterator itWk=errorMaps.values().iterator(); itWk.hasNext();) {
						WorkingComplexType sortWorking = (WorkingComplexType)itWk.next();
						ESLog.debug("Error working: " + sortWorking.getWorkingName() + ", " + sortWorking.getWorkingValue());			
						finalReply.getEsReplyChoice().getContractSummary().addWorking(sortWorking);
					}
				}
				//End WITS.1468				

				
				//we calculate the header fields now.
				calculateReplyHeaderFields(finalReply); 				
				
			}
			
		}else {
			ESLog.debug("No CQS reply, null will be returned.");
		}
		return finalReply;
	}	
	
	/*
	 * @param the final reply. It will be modified
	 * @param the reply to merge with
	 */
	protected EsReply merge2CQSContractReplies(EsReply finalReply, EsReply esReply) {
		EsReply replyReturned = null;

		
		if(finalReply== null && esReply !=null) {
			replyReturned= esReply;
		}else  {
			//We will then copy everything except header
			//So in other word we only map header
			if(esReply != null) {
				ContractSummaryComplexType finalC = finalReply.getEsReplyChoice().getContractSummary();
				ContractSummaryComplexType mergeC = esReply.getEsReplyChoice().getContractSummary();
				if(finalC== null) {
					if(mergeC != null) {
						esReply.getEsReplyChoice().setContractSummary(mergeC);
					}
				}else if(mergeC != null) {
					
					//Obligation Header
					if(mergeC.getObligationHeaderCount() != 0) {
						for(int i = 0; i< mergeC.getObligationHeaderCount(); i++) {
							finalC.addObligationHeader(mergeC.getObligationHeader(i));
						}
					}					

					//Product List
					if(mergeC.getProductListCount() != 0) {
						for(int i = 0; i< mergeC.getProductListCount(); i++) {
							finalC.addProductList(mergeC.getProductList(i));
						}
					}					
					
					//Workings
					if(mergeC.getWorkingCount() != 0) {
						for(int i = 0; i< mergeC.getWorkingCount(); i++) {
							finalC.addWorking(mergeC.getWorking(i));
						}
					}										
					
				} 
				
				replyReturned = finalReply;
			}
						
		}

		return replyReturned;
	}

	
	
	/*
	 * get Instance singleton method
	 */
	public static ContractSummaryTransactionComposition getInstance()  {
			return _instance;
	}
	
}
