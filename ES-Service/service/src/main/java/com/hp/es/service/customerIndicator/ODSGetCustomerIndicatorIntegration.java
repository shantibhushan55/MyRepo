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
package com.hp.es.service.customerIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.hp.es.service.contractEntitlement.ObligHeaderLocation;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.CustomerIndicator;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ObligationHeader;
import com.hp.es.xml.service.ObligationHeaderComplexType;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public class ODSGetCustomerIndicatorIntegration extends ODSCustomerIndicatorIntegration{

	private HashMap _mapOHeaderLocation; 
	private ArrayList _custIndicateList;

	/**
	 * 
	 */
	public ODSGetCustomerIndicatorIntegration() {
		super();
		_mapOHeaderLocation = new HashMap();
		_custIndicateList = new ArrayList();
	}
	
	
	public int doCustomerIndicatorIntegration(ArrayList cqsReplies,EsRequestComplexType request, MetricsHandler handler) throws SifException, DatabaseDownException {
		int errorId = 0;

		if((cqsReplies == null) || (request == null) ){
			return errorId;
		}
		
		if(request.getEsRequestComplexTypeChoice().getContractSummaryRequest() != null)
		{
			errorId = doContractSummaryRequest(cqsReplies,request,handler);
			
		}
		if(request.getEsRequestComplexTypeChoice().getEntitlementByPnRequest() != null){
			errorId = doContractRequest(cqsReplies,request,handler);
		}           
		if(request.getEsRequestComplexTypeChoice().getContractRequest() != null){
			errorId = doContractRequest(cqsReplies,request,handler);				
		}
		return errorId;
	}

	
	private int doContractSummaryRequest(ArrayList cqsReplies,EsRequestComplexType request, MetricsHandler handler) 
	throws SifException, DatabaseDownException {
   		// AMID						String	15	Account Management IDs (from ECM0701 file)
   		// AMID_LEVEL				Number	-	AMID Level (from the ECM0701 file)
   		// CUSTOMER_INDICATOR_NAME	String	15	Customer indicator name (from the ECM0701 file)
   		// CUSTOMER_INDICATOR_VALUE	String	30	Customer indicator value (from the ECM0701 file)
   		// OWNER						String	20	Name of the owner (from ECM0701 file)
   		// LAST_UPDATE_DATE			Date	-	The date of the last update
   		// The format of the date is YYYY-MM-DD e.g. 2007-03-30	

		//Collect all SoldToCustomIds of each ObligationHeader objects  

		ArrayList soldtoidList = new ArrayList();
       	int errorId = 0;
		
		try {
		       Iterator it = cqsReplies.iterator();
		       	while(it.hasNext()) {
					Object tmp = it.next();
					if(tmp instanceof ContractSummaryTransaction)  {
						ContractSummaryTransaction transCQS = (ContractSummaryTransaction) tmp;
						if(transCQS.getMappedReply() != null) {
							EsReply esReply = transCQS.getMappedReply();
							ObligationHeaderComplexType[] obligHeaders= esReply.getEsReplyChoice().getContractSummary().getObligationHeader();
							for (int i = 0; i < obligHeaders.length; i++) {
								ObligationHeaderComplexType oHeader = obligHeaders[i];
								String soldtoID = oHeader.getSoldToCustomID();
			                	if ((soldtoID != null) && soldtoID.trim().length() > 0) {
			                		if( !soldtoidList.contains(soldtoID) ){
			                			soldtoidList.add(soldtoID);
			                		}        											
			                	}		
							}
						}
					}
				}
		       	
		       	// call the database
		       	if(soldtoidList.size() > 0){
		            errorId = _dbCustomerIndicatorManager.getCustomerIndicator(soldtoidList,request,handler);   	       		
		       	}else{
		       		
		       	}
		       	
		       	// check for errors returned from the database
		       	if (errorId!=0) {
		       		return errorId;
		       		// map errorId to SifException
		       		// this probably needs to be enhanced to provide more details
//		       		throw ErrorFactory.getSifException(errorId);
		       	}
	        
		       	ArrayList custIndicateList = _dbCustomerIndicatorManager.getListCustomIndicat();
		       	
	        
		       	if((custIndicateList == null) || (custIndicateList.size() <= 0)){
		       		return ErrorFactory.id300_NO_DATA_FOUND;
		       	}
	     		       	
		       	//Add customer-indicator-name and customer-indicator-value returned from ODS to the cqsReply 
		        Iterator iter2 = cqsReplies.iterator();
		        while(iter2.hasNext()) 
		        {
					Object tmp = iter2.next();
					if(tmp instanceof ContractSummaryTransaction)  
					{
						ContractSummaryTransaction transCQS = (ContractSummaryTransaction) tmp;
						if(transCQS.getMappedReply() != null) 
						{
							EsReply esReply = transCQS.getMappedReply();
							ObligationHeaderComplexType[] obligHeaders= esReply.getEsReplyChoice().getContractSummary().getObligationHeader();
							for (int i = 0; i < obligHeaders.length; i++) 
							{
								ObligationHeaderComplexType oHeader = obligHeaders[i];
								String soldtoID = oHeader.getSoldToCustomID();
								Iterator iter3 = custIndicateList.iterator();
								while(iter3.hasNext())
								{
									CustomIndicator cusindObj = (CustomIndicator)iter3.next();
									if(soldtoID.trim().equalsIgnoreCase(cusindObj.getSoldToCustomerID()))
									{
//										oHeader.addCustomerIndicatorName(cusindObj.getCustomerIndicatorName());
//										oHeader.addCustomerIndicatorValue(cusindObj.getCustomerIndicatorValue());
										CustomerIndicator cusIndic = new CustomerIndicator();
										cusIndic.setCustomerIndicatorName(cusindObj.getCustomerIndicatorName());
										cusIndic.setCustomerIndicatorValue(cusindObj.getCustomerIndicatorValue());
										oHeader.addCustomerIndicator(cusIndic);
									}								
								}
							}
						}										
					}
			}		
		}catch (DataAccessException e) {
            // map to SifException
            ESLog.error("Unexpected Data access exception", e.getCause());
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,
                "Unknow database exception while processing ContractRequest.");
        }
		return errorId;
	}
	

	
	private int doContractRequest(ArrayList cqsReplies,EsRequestComplexType request, MetricsHandler handler) 
	throws SifException, DatabaseDownException {
   		// AMID						String	15	Account Management IDs (from ECM0701 file)
   		// AMID_LEVEL				Number	-	AMID Level (from the ECM0701 file)
   		// CUSTOMER_INDICATOR_NAME	String	15	Customer indicator name (from the ECM0701 file)
   		// CUSTOMER_INDICATOR_VALUE	String	30	Customer indicator value (from the ECM0701 file)
   		// OWNER						String	20	Name of the owner (from ECM0701 file)
   		// LAST_UPDATE_DATE			Date	-	The date of the last update
   		// The format of the date is YYYY-MM-DD e.g. 2007-03-30	

		//Collect all SoldToCustomIds of each ObligationHeader objects  

		ArrayList soldtoidList = new ArrayList();
       	int errorId = 0;
		
		try {
			
			Iterator it = cqsReplies.iterator();
			HashMap hMap = null;
			while(it.hasNext()) 
			{
				Transaction trTmp = (Transaction)it.next();
				if (trTmp instanceof ContractTransaction)
				{
					hMap = ((ContractTransaction)trTmp).getOHeadLocMap();
					if(hMap == null) continue;
					Iterator mapIter = hMap.values().iterator();
					while(mapIter.hasNext())
					{
						ObligHeaderLocation oHeadLoc = (ObligHeaderLocation)mapIter.next();
						String soldtoID = oHeadLoc.getSourceCustomerId();
	                	if ((soldtoID != null) && soldtoID.trim().length() > 0) 
	                	{
   							if( !soldtoidList.contains(soldtoID) )
   							{
   		                		soldtoidList.add(soldtoID);
   							}        												
	                	}
					}
				}
			}
		       	
	        // call the database
		       	if(soldtoidList.size() > 0){
		            errorId = _dbCustomerIndicatorManager.getCustomerIndicator(soldtoidList,request,handler);   	       		
		       	}
		       	
	        // check for errors returned from the database
	        if (errorId!=0) {
	       		return errorId;
	            // map errorId to SifException
	            // this probably needs to be enhanced to provide more details
	            // throw ErrorFactory.getSifException(errorId);
	        }
	        
	        ArrayList custIndicateList = _dbCustomerIndicatorManager.getListCustomIndicat();
	        _custIndicateList = custIndicateList;
	        
	        if((custIndicateList == null) || (custIndicateList.size() <= 0)){
	       		return ErrorFactory.id300_NO_DATA_FOUND;
	        }
	        	        
	        //Add customer-indicator-name and customer-indicator-value returned from ODS to the cqsReply 
	        Iterator iter2 = cqsReplies.iterator();
			HashMap hMap2 = null;

	        while(iter2.hasNext()) 
	        {
	        	Object tmp = iter2.next();
	        	if(tmp instanceof ContractTransaction)  
	        	{
	        		ContractTransaction transCQS = (ContractTransaction)tmp;
	        		hMap2 = ((ContractTransaction)transCQS).getOHeadLocMap();
					if(hMap2 == null) continue;
					_mapOHeaderLocation = hMap2; 
					

	        		if(transCQS.getMappedReply() != null) 
	        		{
	        			EsReply esReply = transCQS.getMappedReply();
	        			
	        			ContractComplexType[] contracts = esReply.getEsReplyChoice().getContractEntitlement().getContract();
	        			for (int i = 0; i < contracts.length; i++) 
	        			{
	        				ObligationHeader[] obligHeaders = contracts[i].getObligationHeader();
	        				for (int k = 0; k < obligHeaders.length; k++) 
	        				{
	        					ObligationHeader oHeader = obligHeaders[k];
	        					setSoldtoIDObligHeader(oHeader);
	        				}
	        			}					
	        		}
	        	}
	        }		
		}catch (DataAccessException e) {
            // map to SifException
            ESLog.error("Unexpected Data access exception", e.getCause());
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,
                "Unknow database exception while processing ContractRequest.");
        }
		return errorId;		
	}
	
	
	
	private void setSoldtoIDObligHeader(ObligationHeader oHeader){
		
		String sourceObligID = oHeader.getSourceObligationID();

		ObligHeaderLocation oHeadLoc = (ObligHeaderLocation)_mapOHeaderLocation.get(sourceObligID);
		if(oHeadLoc == null){
			return;
		}
		
		Iterator iter3 = _custIndicateList.iterator();
		while(iter3.hasNext())
		{
			CustomIndicator cusindObj = (CustomIndicator)iter3.next();
			if(cusindObj.getSoldToCustomerID().equalsIgnoreCase(oHeadLoc.getSourceCustomerId()) && 
					oHeadLoc.getSourceObligationId().equalsIgnoreCase(oHeader.getSourceObligationID())){
				
//				oHeader.addCustomerIndicatorName(cusindObj.getCustomerIndicatorName());
//				oHeader.addCustomerIndicatorValue(cusindObj.getCustomerIndicatorValue());
				CustomerIndicator cusIndic = new CustomerIndicator();
				cusIndic.setCustomerIndicatorName(cusindObj.getCustomerIndicatorName());
				cusIndic.setCustomerIndicatorValue(cusindObj.getCustomerIndicatorValue());
				oHeader.addCustomerIndicator(cusIndic);										
				
			}								
		}
	}
	
	
    /*
     * There is no region Configuration for such an integration 
     *  (non-Javadoc)
     * @see com.hp.es.service.IntegrationInterface#getRegionConfiguration()
     */
	public RegionConfiguration getRegionConfiguration() {
		//ALWAYS RETURN NULL
		return null;
	}

	public boolean isRegionInFailoverMode() {
		//		ALWAYS RETURN FALSE
		return false;
	}

	public boolean isLocal() {
		return true;
	}	

}
