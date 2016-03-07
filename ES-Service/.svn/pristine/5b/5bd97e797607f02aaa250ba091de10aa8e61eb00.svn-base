package com.hp.es.service.contractEntitlement.orchestration;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.integration.mapping.WorkingMapper;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.sif.SifException;

public class ContractTransactionComposition extends GenericContractTransactionComposition {

	private static ContractTransactionComposition _instance = new ContractTransactionComposition();
	
	/*
	 * Constructor
	 */
	protected ContractTransactionComposition() {
		super();
	}

	/*
	 * This method gets a compose reply from the list of replies
	 * It only work for contract Reply
	 * (non-Javadoc)
	 * @see com.hp.es.service.orchestration.TransactionComposition#getComposedReply(com.hp.es.service.orchestration.Transaction[])
	 */
	public EsReply getComposedReply(ArrayList replies,  boolean includeWorkings) throws SifException {
		EsReply finalReply = null;
		EsReply odsReply = null;
		EsReply odsciReply = null;
		EsReply cqsReply = null;
		SifException odsException = null;
		SifException odsciException = null;
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
			
			odsciReply = getODSCIEsReply(replies);			
		}catch(SifException e) {
			ESLog.debug("ODS Customer Indicator reply is a SifException" + e.getMessage());
			odsciException = e;			
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
				WorkingMapper errorWork = new WorkingMapper(odsException.getErrorText(),EsConstants.ODS_SYSTEM_NAME);						
				WorkingComplexType working = errorWork.map();
				if(working != null) {
					finalReply.getEsReplyChoice().getContractEntitlement().addWorking(working);
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
			//For bysn case, we may have to "merge" them
			ESLog.debug("Reply from both, they will be merge");
			finalReply =  mergeCQSandODSreply(cqsReply, odsReply);
		}
		/*
		 * If we had an exception we may have to add a warning
		 */
		if(cqsException != null) {
			String unavailableRegionList = ContractErrorsProcessing.getInstance().getUnavailableRegionList(replies);
			if(unavailableRegionList.trim().length() !=0) {
				addSystemNotAvailableWarning(unavailableRegionList, finalReply);	
			}
		}
		if(odsException !=null ){
		    if((ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE+"").equals(odsException.getErrorID())){
		        addSystemNotAvailableWarning(EsConstants.ODS_SYSTEM_NAME, finalReply);
		    }
		}
		//add warning for ODS Customer Indicator
		if (odsciException != null && includeWorkings) {
			WorkingMapper errorWork = new WorkingMapper(odsciException.getErrorText(),EsConstants.ODSCI_SYSTEM_NAME);						
			WorkingComplexType working = errorWork.map();
			if(working != null) {
				finalReply.getEsReplyChoice().getContractEntitlement().addWorking(working);
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
				WorkingComplexType working = ContractErrorsProcessing.getInstance().getErrorWorking(transCQS);
				if(working != null) {
					finalReply.getEsReplyChoice().getContractEntitlement().addWorking(working);
				}
			}
			
		} catch (SifException e) {

			ESLog.debug("Error while adding workings", e);
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
			ContractEntitlementComplexType odsC = odsReply.getEsReplyChoice().getContractEntitlement();
			ContractEntitlementComplexType cqsC = cqsReply.getEsReplyChoice().getContractEntitlement();
			finalReply = cqsReply;
			//Contact
			if(odsC.getContactCount() != 0) {
				HashMap mapContacts = new HashMap();
				
				if(cqsC.getContactCount() != 0) {
					for(int i=0;i < cqsC.getContactCount(); i++) {
						mapContacts.put(cqsC.getContact(i).getSourcePersonID(),cqsC.getContact(i));
					}
				}
				for(int i = 0; i< odsC.getContactCount(); i++) {
					if(!mapContacts.containsKey(odsC.getContact(i).getSourcePersonID())) {
						cqsC.addContact(odsC.getContact(i));
					}
				}
			}
			
			//Contract
			if(odsC.getContractCount() != 0) {
				for(int i = 0; i< odsC.getContractCount(); i++) {
					cqsC.addContract(odsC.getContract(i));
				}
			}			
			
			//Location
			
			if(odsC.getLocationCount() != 0) {
				
				HashMap mapLocations = new HashMap();
				
				if(cqsC.getLocationCount() != 0) {
					for(int i=0;i < cqsC.getLocationCount(); i++) {
						mapLocations.put(cqsC.getLocation(i).getSourceCustomerID(),cqsC.getLocation(i));
					}
				}				
				for(int i = 0; i< odsC.getLocationCount(); i++) {
					if(!mapLocations.containsKey(odsC.getLocation(i).getSourceCustomerID()))
						cqsC.addLocation(odsC.getLocation(i));
				}
			}								
			//OOSes
			if(odsC.getOOSCount() != 0) {
				HashMap mapOOSES = new HashMap();
				
				if(cqsC.getOOSCount() != 0) {
					for(int i=0;i < cqsC.getOOSCount(); i++) {
						// WITS.1475: indexOutOfBounds exception!
						mapOOSES.put(cqsC.getOOS(i).getOOSKey(),cqsC.getOOS(i));
					}
				}				
				
				for(int i = 0; i< odsC.getOOSCount(); i++) {
					//WITS.1481 Use OOSes from CQS if they are available and not from ODS 
					if(!mapOOSES.containsKey(odsC.getOOS(i).getOOSKey())) {
						cqsC.addOOS(odsC.getOOS(i));
					}
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

	protected void calculateReplyHeaderFields(EsReply finalReply) {
        /*
         * 
         */
        org.exolab.castor.types.Date overallContractStartDate = null;
        org.exolab.castor.types.Date overallContractEndDate = null;
        boolean isActiveContractEntitlement = false;
		// used to calculate the max header end date
        boolean firstContract = true;

        if(finalReply != null) {
	        if(finalReply.getEsReplyChoice().getContractEntitlement() !=null) {
	        	ContractComplexType[] contracts= finalReply.getEsReplyChoice().getContractEntitlement().getContract();
	        	
	            // iterate over all contracts that already have an offer assigned
	            for (int i = 0; i<contracts.length;i++ ) {
	                ContractComplexType c = (ContractComplexType)contracts[i];
	                org.exolab.castor.types.Date startDate = null;
	                org.exolab.castor.types.Date endDate = null;
	
	                Enumeration obligationHeaderEnum = c.enumerateObligationHeader();
	                if (obligationHeaderEnum!=null) {
	                    boolean firstObligation = true;
	                    while (obligationHeaderEnum.hasMoreElements()) {
	                        ObligationHeader oh = (ObligationHeader)
	                                        obligationHeaderEnum.nextElement();
	                        // min start date
	                        startDate = DateHelper.minDate(startDate, oh.getHeaderStartDate());
	
	                        // max end date
	                        // (will be null if at least one header end date is null)
	                        if (firstObligation) {
	                            endDate = oh.getHeaderEndDate();
	                            firstObligation = false;
	                        }
	                        else {
	                            endDate = DateHelper.maxDate(endDate, oh.getHeaderEndDate());
	                        }
	
	
	                    }
	                }
	
	
	                // global "active entitlement flag" for all contracts:
	                // Shows whether any of the underlying contracts is active
	                isActiveContractEntitlement = isActiveContractEntitlement || c.getActiveContractEntitlement();
	
	                // overallContractStartDate/overallContractEndDate
	                overallContractStartDate = DateHelper.minDate(overallContractStartDate, startDate);
	                if (firstContract) {
	                    overallContractEndDate = endDate;
	                    firstContract = false;
	                }
	                else {
	                    overallContractEndDate = DateHelper.maxDate(overallContractEndDate, endDate);
	                }
	            }
	        	
	        }
			
			
			
	        finalReply.getEsReplyChoice().getContractEntitlement().setActiveContractEntitlement(isActiveContractEntitlement);
			finalReply.getEsReplyChoice().getContractEntitlement().setOverallContractStartDate(overallContractStartDate);
			finalReply.getEsReplyChoice().getContractEntitlement().setOverallContractEndDate(overallContractEndDate);
        }
		
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
				ContractEntitlementComplexType finalC = finalReply.getEsReplyChoice().getContractEntitlement();
				ContractEntitlementComplexType mergeC = esReply.getEsReplyChoice().getContractEntitlement();
				if(finalC== null) {
					if(mergeC != null) {
						esReply.getEsReplyChoice().setContractEntitlement(mergeC);
					}
				}else if(mergeC != null) {
					//Contact
					if(mergeC.getContactCount() != 0) {
						for(int i = 0; i< mergeC.getContactCount(); i++) {
							finalC.addContact(mergeC.getContact(i));
						}
					}
					
					//Contract
					if(mergeC.getContractCount() != 0) {
						for(int i = 0; i< mergeC.getContractCount(); i++) {
							finalC.addContract(mergeC.getContract(i));
						}
					}			
					
					//Location
					
					if(mergeC.getLocationCount() != 0) {
						for(int i = 0; i< mergeC.getLocationCount(); i++) {
							finalC.addLocation(mergeC.getLocation(i));
						}
					}								
					//Obligation Header
					if(mergeC.getOOSCount() != 0) {
						for(int i = 0; i< mergeC.getOOSCount(); i++) {
							finalC.addOOS(mergeC.getOOS(i));
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
			
			if(ContractErrorsProcessing.getInstance().countSifException(list) == list.size()) {
				throw ContractErrorsProcessing.getInstance().getHighestPriorityException(list);
			}else {
				
				while(it.hasNext()) {
					Object tmp = it.next();
					if(tmp instanceof ContractTransaction)  {
						ContractTransaction transCQS = (ContractTransaction) tmp;
						if(transCQS.getMappedReply() != null) {
							ESLog.debug("The mapped reply is not null, we will merge it with the final reply");
							finalReply= merge2CQSContractReplies(finalReply, transCQS.getMappedReply());
						}else {
							if(includeWorking) {
								WorkingComplexType working = ContractErrorsProcessing.getInstance().getErrorWorking(transCQS);
								errorMaps.put(working.getWorkingName(), working);
							}
							
						}
					}else if (tmp instanceof ErrorTransaction) {
						ErrorTransaction transCQS = (ErrorTransaction) tmp;

						
						WorkingComplexType working = ContractErrorsProcessing.getInstance().getErrorWorking(transCQS);
						errorMaps.put(working.getWorkingName(), working);
						
					}

				}
				
				//WITS.1468 Now we add the workings for the error transactions
				if(includeWorking) {
					for (int i=0;i<finalReply.getEsReplyChoice().getContractEntitlement().getWorkingCount();i++) {
						WorkingComplexType working = finalReply.getEsReplyChoice().getContractEntitlement().getWorking(i);
						errorMaps.put(working.getWorkingName(), working);
						finalReply.getEsReplyChoice().getContractEntitlement().removeWorking(working);
					}
					for (Iterator itWk=errorMaps.values().iterator(); itWk.hasNext();) {
						WorkingComplexType sortWorking = (WorkingComplexType)itWk.next();
						ESLog.debug("Error working: " + sortWorking.getWorkingName() + ", " + sortWorking.getWorkingValue());			
						finalReply.getEsReplyChoice().getContractEntitlement().addWorking(sortWorking);
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
	 * get Instance singleton method
	 */
	public synchronized static ContractTransactionComposition getInstance()  {
			return _instance;
	}

}
