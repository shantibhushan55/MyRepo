/**
 * 
 */
package com.hp.es.service.warrantyEntitlement.orchestration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.TransactionComposition;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.UnitListComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public class WarrantyTransactionComposition  extends TransactionComposition {

	private static WarrantyTransactionComposition _instance = new WarrantyTransactionComposition();

	/**
	 * 
	 */
	WarrantyTransactionComposition() {
		super();
	}
	
	/*
	 * Get the instance
	 * @return the singleton
	 */
	static WarrantyTransactionComposition getInstance() {
		// Get a singleton instance
		return _instance;
	}	

	/*
	 * 
	 * The 3 responses returned by the SWOP instances are composed 
	 * to form a consolidated ES response. 
	 * Each individual SWOP response is in canonical format 
	 * (the transformation is performed by the SWOP warranty interface) 
	 * and can be a unit list, 
	 * an IB based warranty (warranty without warning 402), 
	 * a product based warranty (warranty with warning 402) or an error. 
	 * Depending on the number of units found 
	 * and the number of errors, 
	 * ES will return one of the SWOP responses or will generate a new response.
	 * @param the list of reply
	 * @return a composed  reply
	 * @throws a SifException if not correctly used
	 *  
	 */
	public EsReply getComposedReply(ArrayList replies, EsRequestComplexType request) throws SifException {
		EsReply composedReply = null;
		
		int nbUnitFound = 0;
		
		
		// First let's check the number of reply we have 
		// we assume we have at least one warranty reply but let's first do a check
		if(countWarrantyReply(replies) == 0) {
			//throw 
			ESLog.debug("The replies array is not correct");
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"No reply to compose, and no swop error generated");
		}
		
		nbUnitFound = countNbUnitFound(replies);
		if(nbUnitFound == 0) {
			//1.1.1.1.1	Compose product based warranty response
			ESLog.debug("No Unit Found, we will compose product based warranty response ");
			composedReply = composeProductBasedWarranty(replies);
		} else if(nbUnitFound == 1) {
			//4.1.4.4.4	Compose IB based warranty response
			ESLog.debug("One Unit Found, we will compose IB based warranty response ");
			composedReply = composeIBBasedWarranty(replies, request);
		} else {
			//4.1.4.4.3	Compose units list response
			ESLog.debug(nbUnitFound + " units found, we will compose IB based warranty response ");
			composedReply = composeUnitList(replies);
			
		}
		ESLog.debug("returning the composed reply");
		return composedReply;
	}

	/*
	 * This method compose a Product Based Warranty
	 * @param the reply array
	 * @return the number of different unit found
	 */		
	private EsReply composeUnitList(ArrayList replies) throws SifException {
		// We need to compose a Unit list
		EsReply reply = null;
		ESLog.debug("In the process of generating the final unit list, by convention, we will take the local reply");
		HashSet unitFound = new HashSet();
		int productCounter = 0;
		int MAX_PRODUCTS_PER_UNIT_LIST = 20;
		
		// If multiple units are found, a unit list response is generated. The OOS section is filled with the serial number.
		// A product section is created for each different product numbers. The ProductID and the ProductDescription 
		// elements are filled from the SWOP responses. All other sections remain empty.
		if(replies != null) {
			Iterator it = replies.iterator();
			// go through all replies 
			while(it.hasNext()) {
				Transaction tr= (Transaction)it.next();
				//So we will take the first reply that contain oos and take it to build other*
				if((tr.getMappedReply() != null) && 
						(((tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement() != null) 
								&& (tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS() != null)) 
								||  (tr.getMappedReply().getEsReplyChoice().getUnitList() != null)) &&
									(reply == null)) {
					ESLog.debug("we create the final reply object");
					reply = new EsReply();
					// retrieving the header from the reply
					reply.setEsHeader(tr.getMappedReply().getEsHeader());
					//we remove the warning if any.
					reply.getEsHeader().setWarnings(null);
					reply.setEsReplyChoice(new EsReplyChoice());
					reply.getEsReplyChoice().setUnitList(new UnitListComplexType());
				}
				
				// get all OOSs
				if(tr.getMappedReply() != null ) {
					// check if we just have a warranty reply with 1 OOS
					if(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement() != null 
							&& tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS() != null) {
						// get the OOS
						OOSComplexType oos_tmp = tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS();
						
						// set the serial number
						if(oos_tmp.getSerialNumber(0) != null && oos_tmp.getSerialNumber(0).trim().length() != 0 && 
								reply.getEsReplyChoice().getUnitList().getSerialNumber() == null) {
							reply.getEsReplyChoice().getUnitList().setSerialNumber(oos_tmp.getSerialNumber(0));
						}
						
						// get the product
						if(oos_tmp.getProduct() != null) {
							String pnStr = oos_tmp.getProduct().getProductID();
							if(!unitFound.contains(pnStr)) {
								ESLog.debug("adding a new product number" + pnStr);
								ProductComplexType pct = new ProductComplexType();
								pct.setProductDescription(oos_tmp.getProduct().getProductDescription());
								pct.setProductID(oos_tmp.getProduct().getProductID());
								reply.getEsReplyChoice().getUnitList().addProduct(pct);
								unitFound.add(pnStr);
								// here we need to check immediately if we have reached
								// already the max number of products per unit list.
								productCounter++;
								if(productCounter == MAX_PRODUCTS_PER_UNIT_LIST) {
									// check if there are more replies. In this case the unit list is truncated
									// and we generate the truncated warning message
									if(it.hasNext()) {
										addTruncatedListWarning(reply);
									}
									return reply;
								}
							}
						}
					
					// check if we have a unit list
					} else if(tr.getMappedReply().getEsReplyChoice().getUnitList() != null) {
	
						// get the serial number
						if(tr.getMappedReply().getEsReplyChoice().getUnitList().getSerialNumber() != null && 
								tr.getMappedReply().getEsReplyChoice().getUnitList().getSerialNumber().trim().length() != 0 && 
								reply.getEsReplyChoice().getUnitList().getSerialNumber() == null) {
							reply.getEsReplyChoice().getUnitList().setSerialNumber(tr.getMappedReply().getEsReplyChoice().getUnitList().getSerialNumber());
						}
						
						// get all products
						ProductComplexType[] pct = tr.getMappedReply().getEsReplyChoice().getUnitList().getProduct();
						for(int iPct = 0; iPct < pct.length; iPct++) {
							String pnStr = pct[iPct].getProductID();
							if(!unitFound.contains(pnStr)) {
								ESLog.debug("adding a new product number" +pnStr );
								ProductComplexType pcType = new ProductComplexType();
								pcType.setProductDescription(pct[iPct].getProductDescription());
								pcType.setProductID(pct[iPct].getProductID());
								reply.getEsReplyChoice().getUnitList().addProduct(pcType);
								unitFound.add(pnStr);
								// here we need to check immediately if we have reached
								// already the max number of products per unit list.
								productCounter++;
								if(productCounter == MAX_PRODUCTS_PER_UNIT_LIST) {
									// check if there are more products in the unit list or
									// more replies. In this case the unit list is truncated
									// and we generate the truncated warning message
									if(((pct.length - iPct) > 1) || it.hasNext()) {
										addTruncatedListWarning(reply);
									}
									return reply;
								}
							}
						}
					}
				}
			}
		}
		return reply;
	}
	
	/**
	 * Adds the warning 408 (truncated unit list) to the reply
	 * @param reply
	 */
	private void addTruncatedListWarning(EsReply reply) {
		if(reply.getEsHeader().getWarnings() == null) {
			reply.getEsHeader().setWarnings(new Warnings());
		}
		reply.getEsHeader().getWarnings().addEIAError(ErrorFactory.getEIAError(ErrorFactory.id408_UNIT_LIST_TRUNCATED));
	}
	
	
	/*
	 * This method compose a IB Based Warranty
	 * @param the reply array
	 * @return the number of different unit found
	 */	
	private EsReply composeIBBasedWarranty(ArrayList replies, EsRequestComplexType request) throws SifException {
		// When a single unit is found, 
		// we determine the warranty to take using thje warranty determination code
		
		EsReply reply = null;
		ESLog.debug("In the process of composing a IB Based Warranty, by convention, we will take the highest prio determination code");
		reply = WarrantyDeterminationCode.getInstance().getHighestPriority(replies, request);
		ESLog.debug("adding a new product number" );
		return reply;
	}

	
	/*
	 * This method compose a Product Based Warranty
	 * @param the reply array
	 * @return the number of different unit found
	 */	
	private EsReply composeProductBasedWarranty(ArrayList replies) throws SifException {
		// When no unit are found and there is at least a valid response. 
		// This response is necessarly a product based warranty
		// This response must always be the local response
		EsReply reply = null;
		ESLog.debug("In the process of composing a product based warranty, by convention, we will take the local reply");
		reply = getLocalReply(replies);
		ESLog.debug("local reply is found: " + reply);
		return reply;
	}

	/*
	 * @param a list of orchestration
	 * reply
	 */
	private EsReply getLocalReply(ArrayList replies) throws SifException {
		ESLog.debug("begin");
		if(replies != null) {
			Iterator it = replies.iterator();
			
			while(it.hasNext()) {
				Transaction transaction = (Transaction)it.next();
				if((transaction != null) && (transaction.isLocal())) {
					if(transaction.getMappedReply() != null) {
						// we have a reply from the locat instance
						ESLog.debug("We have a local reply");
						
						// set the esReplyChoice with true to indicate this tranasction is selected as final es reply.
                        if (transaction instanceof WarrantyTransaction)
                            ((WarrantyTransaction) transaction).setEsReplyChoice(true);
                        
						return transaction.getMappedReply();
					} else {
						// check for the SifException
						ESLog.debug("The local reply is null. Check for SifException");
						if(transaction.getMappedErrors() != null) {
							ESLog.debug("We have a mapped error");
							throw WarrantyErrorsProcessing.getInstance().getHighestPriorityException(transaction);
						} else {
							// should never happen
							ESLog.info("The mapped errors are also empty => serious issue");
						}
					}
				}
			}
		}
		ESLog.debug("we will generate a SifException because we did not find a local reply or the reply was null");
		throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "getLocalReply was not used correctly");
	}

	/*
	 * This method count the number of unit found.
	 * The number of units is the number of different product numbers found in the responses 
	 * of type �unit list� or  type �IB warranty� (with an OOSKey).
	 * @param the reply array
	 * @return the number of different unit found
	 */
	private int countNbUnitFound(ArrayList replies) throws SifException {
		int nbUnitFound = 0;
		HashSet unitFound = new HashSet();
		
		ESLog.debug("begin");
		
		if(replies != null ) {
			Iterator it = replies.iterator();
			while(it.hasNext()) {
				Transaction tr = (Transaction)it.next();
				if((tr != null) && (tr.getMappedReply() != null)) {
					EsReply currObj = (EsReply) tr.getMappedReply();
					if(currObj.getEsReplyChoice() != null) {
						if(currObj.getEsReplyChoice().getWarrantyEntitlement() != null) {
							WarrantyEntitlementComplexType war = currObj.getEsReplyChoice().getWarrantyEntitlement();
							if((war.getOOS() != null) && (war.getOOS().getOOSKey() != null) && (war.getOOS().getOOSKey().trim().length() > 0) && 
									(war.getOOS().getProduct() != null) && (war.getOOS().getProduct().getProductID() != null) &&
									(war.getOOS().getProduct().getProductID().trim().length() > 0 ) ){
								unitFound.add(war.getOOS().getProduct().getProductID());
							}
								
						} else if(currObj.getEsReplyChoice().getUnitList() != null) {
							UnitListComplexType list = currObj.getEsReplyChoice().getUnitList();
							ProductComplexType[] pct = list.getProduct();
							for(int iPct = 0;iPct<pct.length;iPct ++) {
								unitFound.add(pct[iPct].getProductID());
							}
						}
					}
				}
			}
		}
		nbUnitFound = unitFound.size();
		ESLog.debug("End we found " + nbUnitFound + " Units");
		return nbUnitFound;
	}

	/*
	 * This method count the number of warranty reply in the reply array
	 * @param the reply array
	 * @return the number of warranty reply
	 */
	private int countWarrantyReply(ArrayList replies) throws SifException {
		int nbWarrantyReply = 0;
		ESLog.debug("begin");
		if(replies != null ) {
			Iterator it = replies.iterator();
			while(it.hasNext()) {
				Transaction tr = (Transaction)it.next();
				if((tr != null) && (tr.getMappedReply() != null)) {
					EsReply currObj = (EsReply) tr.getMappedReply();
					if(currObj.getEsReplyChoice() != null) {
						if((currObj.getEsReplyChoice().getWarrantyEntitlement() != null) ||
								currObj.getEsReplyChoice().getUnitList() != null) {
							nbWarrantyReply++;
						}
					}
					
				}
				
				
			}
		}
		ESLog.debug("end we found "+ nbWarrantyReply +" warranty replies");
		return nbWarrantyReply;
	}
	
}
//eof
