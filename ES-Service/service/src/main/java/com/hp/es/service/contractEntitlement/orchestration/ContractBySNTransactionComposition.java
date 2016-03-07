/**
 * 
 */
package com.hp.es.service.contractEntitlement.orchestration;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.DateHelper;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.CombinedUnitEntitlementComplexType;
import com.hp.es.xml.service.ContactComplexType;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.LocationComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.sif.SifException;

/**
 * @author anvoi
 *
 */
public class ContractBySNTransactionComposition extends
		GenericContractTransactionComposition {
	private static ContractBySNTransactionComposition _instance = new ContractBySNTransactionComposition();
	/**
	 * 
	 */
	public ContractBySNTransactionComposition() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.contractEntitlement.orchestration.GenericContractTransactionComposition#getComposedReply(java.util.ArrayList)
	 */
	public EsReply getComposedReply(ArrayList replies, boolean includeWorkings) throws SifException {
		EsReply finalReply = null;
		/*
		 * We have 2 groups of Transaction potentially, CQS and ODS
		 * We need to compose one reply from CQS and one for ODS
		 */
		ESLog.debug("Composing reply");
		//First we check if we are not in a Unit List case.
		//int nbUnitFound = countUnitFound(replies);
		if(isNoUnitFound(replies)) {
			//We found nothing we have to get an Exception out of the list
			ESLog.debug("Counting units is wrong!");
			throw getExceptionFromList(replies);
		}else if(isMultipleUnitFound(replies)) {
			// We will have  a Unit List
			finalReply = mergeESRepliesInAUnitList(replies,includeWorkings);
		}else {			
			// We will have a Combined Reply
			finalReply = mergeESRepliesInACombinedReply(replies,includeWorkings);			
		}
		
		return finalReply;
	}

	
	private boolean isMultipleUnitFound(ArrayList replies) {
		/* Checks whether more than one unit is found based 
		 * on the standardized product ID 
		 * Returns TRUE in case more than one standardized products are found
		*/
		Iterator it = replies.iterator();
		Set s =  new HashSet();
		while(it.hasNext()) {
			Transaction tr = (Transaction)it.next();
			if (tr.getMappedReply() != null ) {
				if(tr.getMappedReply().getEsReplyChoice().getUnitList() != null ) {						
					return true;				
				}else {
					HashMap standProdMap =((ContractTransaction)tr).getStandardizedProductHashMap();
					OOSComplexType oos = tr.getMappedReply().getEsReplyChoice().getCombinedUnitEntitlement().getOOS();
					if(oos != null && oos.getProduct() !=null) {
						String productID = oos.getProduct().getProductID();
						if(productID!=null)
						    s.add(standProdMap.get(productID));
					}
					
					if (s.size()>1) {
						return true;
					}
				}
			} 
		}
		return false;		
	}

	private boolean isNoUnitFound(ArrayList replies) {
		// Returns false in case at least one oos was found
		if(replies != null){
			Iterator it = replies.iterator();
			
			while(it.hasNext()) {
				Transaction tr = (Transaction)it.next();
				if(tr==null){
					ESLog.debug("error happen:caught by tr is null at isNoUnitFound!NullPointException");
				}else if (tr.getMappedReply() != null) {
					
					if(tr.getMappedReply().getEsReplyChoice() == null
							|| tr.getMappedReply().getEsReplyChoice().getUnitList() != null || tr.getMappedReply().getEsReplyChoice().getCombinedUnitEntitlement() == null || (tr.getMappedReply().getEsReplyChoice().getCombinedUnitEntitlement() != null && tr.getMappedReply().getEsReplyChoice().getCombinedUnitEntitlement().getOOS() != null)) {
						return false;				
					}
				} 
			}
		}
		return true;
	}

	private EsReply mergeESRepliesInACombinedReply(ArrayList replies, boolean includeWorking) throws SifException {
		ArrayList listEx = new ArrayList();
		EsReply finalReply = null;
		//WITS.1483: CQS OOSes are always having a higher priority as ODS OOSes
		boolean mappedCqsOos = false;
		/* WITS.1468 The workings which document error transactions
		 * The workings for the successfully finished transactions were created while mapping*/		
		TreeMap errorMaps = new TreeMap();

		Iterator it = replies.iterator();

		finalReply = new EsReply();
		finalReply.setEsReplyChoice(new EsReplyChoice());
		finalReply.getEsReplyChoice().setCombinedUnitEntitlement(new CombinedUnitEntitlementComplexType());
		while(it.hasNext()) {
			Transaction tr = (Transaction)it.next();
			if(tr.getMappedErrors() != null && tr.getMappedErrors().size() != 0) {
				if(includeWorking) {
					WorkingComplexType working = ContractErrorsProcessing.getInstance().getErrorWorking(tr);
					errorMaps.put(working.getWorkingName(), working);
				}
				listEx.add(ContractErrorsProcessing.getInstance().getHighestPriorityException(tr));
			}else {
				EsReply reply = tr.getMappedReply();
				CombinedUnitEntitlementComplexType cueFinal = finalReply.getEsReplyChoice().getCombinedUnitEntitlement();
				CombinedUnitEntitlementComplexType cueTmp   = reply.getEsReplyChoice().getCombinedUnitEntitlement();
				
				//Contact
				if(cueTmp.getContactCount() != 0) {
					HashMap mapContacts = new HashMap();
					
					if(cueFinal.getContactCount() != 0) {
						for(int i=0;i < cueFinal.getContactCount(); i++) {
							mapContacts.put(cueFinal.getContact(i).getSourcePersonID(),cueFinal.getContact(i));
						}
					}
					for(int i = 0; i< cueTmp.getContactCount(); i++) {
						if(!mapContacts.containsKey(cueTmp.getContact(i).getSourcePersonID())) {
							cueFinal.addContact(cueTmp.getContact(i));
						}else {
							
							//we replace it the one we have is coming from CQS
							if(!tr.getRegionDisplayName().equalsIgnoreCase("ODS")) {
								ContactComplexType ctmp = (ContactComplexType) mapContacts.get(cueTmp.getContact(i).getSourcePersonID());
								//we need to copy the value
								ctmp.setEmailAddress(cueTmp.getContact(i).getEmailAddress());
								ctmp.setFaxNumber(cueTmp.getContact(i).getFaxNumber());
								ctmp.setFullName(cueTmp.getContact(i).getFullName());
								ctmp.setId(cueTmp.getContact(i).getId());
								ctmp.setPhoneNumber(cueTmp.getContact(i).getPhoneNumber());
								ctmp.setSourcePersonID(cueTmp.getContact(i).getSourcePersonID());
							}
						}
					}
				}
				
				//Contract
				if(cueTmp.getContractCount() != 0) {
					for(int i = 0; i< cueTmp.getContractCount(); i++) {
						cueFinal.addContract(cueTmp.getContract(i));
					}
				}			
				
				//Location
				
				if(cueTmp.getLocationCount() != 0) {
					
					HashMap mapLocations = new HashMap();
					
					if(cueFinal.getLocationCount() != 0) {
						for(int i=0;i < cueFinal.getLocationCount(); i++) {
							mapLocations.put(cueFinal.getLocation(i).getSourceCustomerID(),cueFinal.getLocation(i));
						}
					}				
					for(int i = 0; i< cueTmp.getLocationCount(); i++) {
						if(!mapLocations.containsKey(cueTmp.getLocation(i).getSourceCustomerID())) {
							cueFinal.addLocation(cueTmp.getLocation(i));
						}else {
							//we replace it the one we have is coming from CQS
							if(!tr.getRegionDisplayName().equalsIgnoreCase("ODS")) {
								LocationComplexType ctmp = (LocationComplexType) mapLocations.get(cueTmp.getLocation(i).getSourceCustomerID());
								ctmp=cueTmp.getLocation(i);
								ctmp.setCity(cueTmp.getLocation(i).getCity());
								ctmp.setFmtAddrLine1(cueTmp.getLocation(i).getFmtAddrLine1());
								ctmp.setFmtAddrLine2(cueTmp.getLocation(i).getFmtAddrLine1());
								ctmp.setFmtAddrLine3(cueTmp.getLocation(i).getFmtAddrLine1());
								ctmp.setFmtAddrLine4(cueTmp.getLocation(i).getFmtAddrLine1());
								ctmp.setFmtAddrLine5(cueTmp.getLocation(i).getFmtAddrLine1());
								ctmp.setGeographicArea(cueTmp.getLocation(i).getGeographicArea());
								ctmp.setId(cueTmp.getLocation(i).getId());
								ctmp.setIsoCountryCd(cueTmp.getLocation(i).getIsoCountryCd());
								ctmp.setPostalCode(cueTmp.getLocation(i).getPostalCode());
								ctmp.setPSPID(cueTmp.getLocation(i).getPSPID());
								ctmp.setSiteBusinessName1(cueTmp.getLocation(i).getSiteBusinessName1());
								ctmp.setSiteBusinessName2(cueTmp.getLocation(i).getSiteBusinessName2());
								ctmp.setSiteBusinessName3(cueTmp.getLocation(i).getSiteBusinessName3());
								ctmp.setSiteBusinessName4(cueTmp.getLocation(i).getSiteBusinessName4());
								ctmp.setSourceCustomerID(cueTmp.getLocation(i).getSourceCustomerID());
								ctmp.setStreetAddr1(cueTmp.getLocation(i).getStreetAddr1());
								ctmp.setStreetAddr2(cueTmp.getLocation(i).getStreetAddr2());
								
							}							
						}
					}
				}								
				//OOS
				//WITS.1483: CQS OOSes are always having a higher priority as ODS OOSes
				if(cueTmp.getOOS() != null) {					
					if(cueFinal.getOOS() != null) {
						if (!(tr.getRegionDisplayName().equalsIgnoreCase("ODS") && mappedCqsOos)) {
							if( (!tr.getRegionDisplayName().equalsIgnoreCase("ODS") && !mappedCqsOos) ||    //CQS OOses have a higher priority
								((( tr.getRegionDisplayName().equalsIgnoreCase("ODS") && !mappedCqsOos)  || //Only ODS OOSes: compare CDOPublishDate
								  (!tr.getRegionDisplayName().equalsIgnoreCase("ODS") &&  mappedCqsOos)) //Only CQS OOSes: compare CDOPublishDate
								  && !DateHelper.isGreater(getLastestCDOPublishDate(cueFinal), getLastestCDOPublishDate(cueTmp)))) {
							//if(!tr.getRegionDisplayName().equals("ODS")) {
								cueFinal.setOOS(cueTmp.getOOS());
								mappedCqsOos = tr.getRegionDisplayName().equalsIgnoreCase("ODS") ? false : true; 
							//}
							}							
						}
					}else {
						cueFinal.setOOS(cueTmp.getOOS());
						mappedCqsOos = tr.getRegionDisplayName().equalsIgnoreCase("ODS") ? false : true;
					}
				}					

				//Workings
				if(cueTmp.getWorkingCount() != 0 && includeWorking) {
					for(int i = 0; i< cueTmp.getWorkingCount(); i++) {
						WorkingComplexType working = cueTmp.getWorking(i);
						errorMaps.put(working.getWorkingName(), working);						
						//cueFinal.addWorking(cueTmp.getWorking(i));
					}
				}
				
				
				//Custiomer identifucation
				if(cueTmp.getCustomerIdentification() != null) {
					cueFinal.setCustomerIdentification(cueTmp.getCustomerIdentification());
					
				}
				
				
				
				
				
				
			}
	 		
		}

		finalReply.setEsHeader(new EsHeader());
		calculateReplyHeaderFields(finalReply);
		
		//WITS.1468 Now we add the workings to the reply
		if(includeWorking){
			for (Iterator itWk=errorMaps.values().iterator(); itWk.hasNext();) {
				WorkingComplexType sortWorking = (WorkingComplexType)itWk.next();
				ESLog.debug("Error working: " + sortWorking.getWorkingName() + ", " + sortWorking.getWorkingValue());			
				finalReply.getEsReplyChoice().getCombinedUnitEntitlement().addWorking(sortWorking);
			}
		}
		//End WITS.1468	

		/*
		 * If we had an exception we may have to add a warning
		 */
		if(!listEx.isEmpty()) {
			String unavailableRegionList = ContractErrorsProcessing.getInstance().getUnavailableRegionList(replies);
			if(unavailableRegionList.trim().length() !=0) {
				addSystemNotAvailableWarning(unavailableRegionList, finalReply);
			}
		}
		
		// WITS 1515
		// since the oos could have been replaced and/or other appliesTos could
		// have been added we need to adjust the appliesTo references to the OOS 
		// in the final reply
		OOSComplexType finalOos = finalReply.getEsReplyChoice().getCombinedUnitEntitlement().getOOS();
        ContractComplexType[] contracts = finalReply.getEsReplyChoice().getCombinedUnitEntitlement().getContract();
        for (int i = 0; i < contracts.length; i++) {
            OfferComplexType[] offers = contracts[i].getOffer();
            for (int j = 0; j < offers.length; j++) {
                AppliesTo[] appliesTos = offers[j].getAppliesTo();
                for (int k = 0; k < appliesTos.length; k++) {
                    AppliesTo to = appliesTos[k];
                    if (to.getOOSRef() != null) {
                        to.setOOSRef(finalOos);
                    }
                }
            }
        }

        return finalReply;			
	}

	private SifException getExceptionFromList(ArrayList replies) throws SifException {
		return ContractErrorsProcessing.getInstance().getHighestPriorityException(replies);
	}

/*	private int countUnitFound(ArrayList replies) {

		 We should only interact with mapped replies while composing
		
		
		Iterator it = replies.iterator();
		Set s =  new HashSet();
		while(it.hasNext()) {
			Transaction tr = (Transaction)it.next();
			if (tr.getMappedReply() != null ) {
				if(tr.getMappedReply().getEsReplyChoice().getUnitList() != null) {
					
					Enumeration products = tr.getMappedReply().getEsReplyChoice().getUnitList().enumerateProduct();
					while(products.hasMoreElements()) {
						ProductComplexType product = (ProductComplexType)products.nextElement();
						
						s.add(product.getProductID());
					}

				}else {
					if(tr.getMappedReply().getEsReplyChoice().getCombinedUnitEntitlement() != null) {
						s.add(tr.getMappedReply().getEsReplyChoice().getCombinedUnitEntitlement().getOOS().getProduct().getProductID());
					}
						
				}
			} 
		}
		return s.size();
	}*/

	private EsReply mergeESRepliesInAUnitList(ArrayList replies, boolean includeWorking) throws SifException {
		EsReply finalReply = null;

		
		Iterator it = replies.iterator();		
		TreeSet productSet = new TreeSet();
		
		finalReply = new EsReply();
		finalReply.setEsReplyChoice(new EsReplyChoice());
		finalReply.getEsReplyChoice().setUnitList(new UnitListComplexType());
		finalReply.setEsHeader(new EsHeader());
		Warnings finalWarnings = new Warnings();
		/* WITS.1468 No workjing for unit list*/		

		
		ArrayList listEx = new ArrayList();
		while(it.hasNext()) {
			Transaction tr = (Transaction)it.next();
			if(tr.getMappedErrors() != null && tr.getMappedErrors().size() != 0) {
				listEx.add(ContractErrorsProcessing.getInstance().getHighestPriorityException(tr));
			}else {
				/*
				 * Adding all warning
				 */
				EsReply reply = tr.getMappedReply();
				// add the warnings to the header if we had some
				if(tr.getMappedReply().getEsHeader().getWarnings() != null && tr.getMappedReply().getEsHeader().getWarnings().getEIAError() != null) {
					EIAError[] errors = tr.getMappedReply().getEsHeader().getWarnings().getEIAError();
					for(int i = 0; i < errors.length; i++) {
						finalWarnings.addEIAError(errors[i]);
					}
				}
				if(reply.getEsReplyChoice().getUnitList() != null) {
					//we add all the unit
					//First product
					if(finalReply.getEsReplyChoice().getUnitList().getSerialNumber() == null) {
						finalReply.getEsReplyChoice().getUnitList().setSerialNumber(reply.getEsReplyChoice().getUnitList().getSerialNumber());
						Enumeration e = reply.getEsReplyChoice().getUnitList().enumerateProduct();
						while(e.hasMoreElements()) {
							ProductComplexType pct = (ProductComplexType )e.nextElement();
							if(!productSet.contains(pct.getProductID())) {
								finalReply.getEsReplyChoice().getUnitList().addProduct(pct);
							}
						}

					}else {
						for(int i= 0; i < reply.getEsReplyChoice().getUnitList().getProductCount(); i++) {
							ProductComplexType pct = reply.getEsReplyChoice().getUnitList().getProduct(i);
							if(!productSet.contains(pct.getProductID())) {
								finalReply.getEsReplyChoice().getUnitList().addProduct(pct);
							}
						}
					}
					
				}else {
					/*
					 * this is where the NPE is
					 */
					if(finalReply.getEsReplyChoice().getUnitList().getSerialNumber() == null) {
						finalReply.getEsReplyChoice().getUnitList().setSerialNumber(reply.getEsReplyChoice().getCombinedUnitEntitlement().getOOS().getSerialNumber(0));
						finalReply.getEsReplyChoice().getUnitList().addProduct(reply.getEsReplyChoice().getCombinedUnitEntitlement().getOOS().getProduct());
					}else {
						if(reply.getEsReplyChoice().getCombinedUnitEntitlement().getOOS() != null)
							finalReply.getEsReplyChoice().getUnitList().addProduct(reply.getEsReplyChoice().getCombinedUnitEntitlement().getOOS().getProduct());
					}
				}
			}
			
		}
		// at the end we add the warnings which we had
		if(finalWarnings.getEIAErrorCount() > 0) {
			finalReply.getEsHeader().setWarnings(finalWarnings);
		} else {
			finalReply.getEsHeader().setWarnings(null);
		}
		calculateReplyHeaderFields(finalReply);
		

		
		//End WITS.1468	
		
		/*
		 * If we had an exception we may have to add a warning
		 */
		if(!listEx.isEmpty()) {
			//we may have to generate war
			String unavailableRegionList = ContractErrorsProcessing.getInstance().getUnavailableRegionList(replies);
			if(unavailableRegionList.trim().length() !=0) {
				addSystemNotAvailableWarning(unavailableRegionList, finalReply);
			}
		}
		return finalReply;

	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.contractEntitlement.orchestration.GenericContractTransactionComposition#calculateReplyHeaderFields(com.hp.es.xml.service.EsReply)
	 */
	protected void calculateReplyHeaderFields(EsReply finalReply) {
        org.exolab.castor.types.Date overallContractStartDate = null;
        org.exolab.castor.types.Date overallContractEndDate = null;

        boolean isActiveContractEntitlement = false;
		// used to calculate the max header end date
        boolean firstContract = true;

        if(finalReply.getEsReplyChoice().getCombinedUnitEntitlement() != null) {
        	ContractComplexType[] contracts= finalReply.getEsReplyChoice().getCombinedUnitEntitlement().getContract();
        	
            org.exolab.castor.types.Date startDate = null;
            org.exolab.castor.types.Date endDate = null;
            
            // iterate over all contracts that already have an offer assigned
            for (int i = 0; i < contracts.length; i++) {
                ContractComplexType c = (ContractComplexType)contracts[i];

                Enumeration obligationHeaderEnum = c.enumerateObligationHeader();
                if (obligationHeaderEnum != null) {
                    boolean firstObligation = true;
                    while (obligationHeaderEnum.hasMoreElements()) {
                        ObligationHeader oh = (ObligationHeader) obligationHeaderEnum.nextElement();
                        // min start date
                        startDate = DateHelper.minDate(startDate, oh.getHeaderStartDate());

                        // max end date
                        // (will be null if at least one header end date is null)
                        if (firstObligation) {
                            endDate = oh.getHeaderEndDate();
                            firstObligation = false;
                        } else {
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
        // set flags and dates for combined test case
        if(finalReply.getEsReplyChoice().getCombinedUnitEntitlement() != null) {
	        finalReply.getEsReplyChoice().getCombinedUnitEntitlement().setActiveContractEntitlement(isActiveContractEntitlement);
			finalReply.getEsReplyChoice().getCombinedUnitEntitlement().setOverallContractStartDate(overallContractStartDate);
			finalReply.getEsReplyChoice().getCombinedUnitEntitlement().setOverallContractEndDate(overallContractEndDate);
			//We set the overall warranty to false
			finalReply.getEsReplyChoice().getCombinedUnitEntitlement().setActiveWarrantyEntitlement(false);
        }
	}


	

	private Date getLastestCDOPublishDate(CombinedUnitEntitlementComplexType contract) {
		Date d= null;
		if(contract != null) {
			for(int i = 0; i< contract.getContractCount(); i++) {
				Date dateTmp = DateHelper.cdoDateToJavaDate(contract.getContract(i).getCdoPublishDate());
				if(d == null) {
					d=dateTmp;
				}else {
					if(dateTmp.after(d)) {
						d = dateTmp;
					}
					
				}
			}
		}
		return d;
	}

	/*
	 * get Instance singleton method
	 */
	public static synchronized GenericContractTransactionComposition getInstance()  {

			return _instance;
	}


}
