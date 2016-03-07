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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSMESSAGE;
import com.hp.es.service.contractSummary.integration.CQSContractSummaryIntegration;
import com.hp.es.service.contractSummary.integration.CQSGetContractSummaryIntegration;
import com.hp.es.service.contractSummary.integration.mapping.CSWorkingMapper;
import com.hp.es.service.customerIndicator.ODSCustomerIndicatorIntegration;
import com.hp.es.service.customerIndicator.ODSGetCustomerIndicatorIntegration;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.OrchestrationWorker;
import com.hp.es.service.orchestration.SourceSystemsOrchestration;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ObligationHeaderComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;


/**
 * @author yesilyur
 *
 */
public class ContractSummaryOrchestration extends SourceSystemsOrchestration implements ConfigChangeListener {

	static protected final String THREAD_TIMEOUT_PROPERTY = "es.contractsummaryservice.orchestration.thread.timeout";
	static protected final long DEFAULT_THREAD_TIMEOUT = 5000;
	
	static protected final String CONTRACTSUMMARY_SYSTEMS_PROPERTY = "es.contractsummaryservice.orchestration.systems";
	static protected final String DEFAULT_CONTRACTSUMMARY_SYSTEMS = "ODS,CQS";

	protected HashMap _cqsContractSummaryIntegrationList = null;
	
	protected ODSCustomerIndicatorIntegration _odsCustomerIndicatorIntegration = null;
	

	//Both of them must never be set to false.
	protected boolean   _cqsEnable = true;
	protected boolean   _odsEnable = true;

	/*
	 * Singleton
	 */
	protected final static ContractSummaryOrchestration _instance = new ContractSummaryOrchestration();

	/**
	 * 
	 */
	public ContractSummaryOrchestration() {
		super();
		Configuration.getInstance().addConfigChangeListener(this);
		init();
	}
	
	protected int init() {
		ESLog.debug("Initialization of ContractSummaryOrchestration");
		ArrayList listOfRegionName = RegionFactory.getInstance().getAvailableRegionsName();
		
		/*
		 * We need to create the integration layers.
		 */
		// First we create the local one
		_odsCustomerIndicatorIntegration = new ODSGetCustomerIndicatorIntegration();
		//_odsCustomerIndicatorIntegration =  new MockODSGetContractSummaryIntegration();
		_cqsContractSummaryIntegrationList = null;
		//_cqsContractSummaryIntegrationList = new HashMap(listOfRegionName.size());
		_cqsContractSummaryIntegrationList = new HashMap(1);

		for (int i = 0; i < listOfRegionName.size(); i++) {
			String regionName = (String) listOfRegionName.get(i);
			CQSContractSummaryIntegration cqsSum = new CQSGetContractSummaryIntegration(regionName);			
			_cqsContractSummaryIntegrationList.put(regionName, cqsSum);
		}
		ESLog.debug("Initialization of ContractOrchestration");
		return 0;
	}
	

	public EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler) throws SifException {
		if(request.getEsRequestComplexTypeChoice().getContractSummaryRequest() != null) {
			return getContractSummary(request, metricsHandler,request.getEsRequestComplexTypeChoice().getContractSummaryRequest().getIncludeWorkings());
		}
		return null;
	}

	
	/**
	 * This methode replies the customer summary objects from CQS and ODS 
	 */	
	protected EsReply getContractSummary(EsRequestComplexType request,
			MetricsHandler metricsHandler,  boolean includeWorkings) throws SifException {

		ArrayList cqsReplies = null;
		try {
			cqsReplies = getContractSummaryFromCQS(request,metricsHandler);
			
			//if(includeCustomerIndicator)
	       	int errorId = -1;
	       	boolean includeCI = request.getEsRequestComplexTypeChoice().getContractSummaryRequest().getIncludeCustomerIndicator();
			if(includeCI){
				try {
	                errorId = getCustomerIndicatorFromODS(cqsReplies,request,metricsHandler);
	            } catch (DatabaseDownException e) {
	                ESLog.debug("Caught a DatabaseDownException while processing CustomerIndicator for ContractSummary.");
	                errorId=ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE;
	            }			
			}
			
			EsReply esReply =  processListOfReplies(cqsReplies,metricsHandler, includeWorkings);
	
			//if(includeCustomerIndicator) and if(includeWorkings)
			if(includeCI && includeWorkings){
				if(errorId == 0){
					CSWorkingMapper mapper = new CSWorkingMapper("success","ODS Customer Indicator");
					esReply.getEsReplyChoice().getContractSummary().addWorking(mapper.map());
				}else if(errorId == ErrorFactory.id300_NO_DATA_FOUND){
					CSWorkingMapper mapper = new CSWorkingMapper("No data found","ODS Customer Indicator");
					esReply.getEsReplyChoice().getContractSummary().addWorking(mapper.map());				
				}else if(errorId == ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE){
	                CSWorkingMapper mapper = new CSWorkingMapper("ES database is down","ODS Customer Indicator");
	                esReply.getEsReplyChoice().getContractSummary().addWorking(mapper.map());               
	            }
	
			}		
			if(includeCI && errorId==ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE){
			    ESLog.debug("Add db down warning");
		        EIAError eiaError = ErrorFactory.getEIAError(errorId, EsConstants.ODS_SYSTEM_NAME);
		        
		        EsHeader esHeader = esReply.getEsHeader();
		        if(esHeader==null){
		            esHeader=new EsHeader();
		        }
		        Warnings warnings = esHeader.getWarnings();
		        if(warnings==null){
		            warnings=new Warnings();
		        }
		        warnings.addEIAError(eiaError);
		        esHeader.setWarnings(warnings);
		        esReply.setEsHeader(esHeader);
		        
			}
			return esReply;
		}finally {
			cleanCQSReplies(cqsReplies);
		}
	}

	private void cleanCQSReplies(ArrayList replies) {
		ESLog.debug("Cleaning up orchestration");
		try {
			if(replies != null) {
				Iterator it = replies.iterator();
				// go through all replies 
				while(it.hasNext()) {
					Transaction tr= (Transaction)it.next();
					tr.destroy();
				}
			}
		}catch(Exception e)  {
			ESLog.debug("Found an exception while cleaning up",e);
		}
	}
	
	
	/**
	 * Mockup Service methode for Software-Service-Level-Catagory
	 * @param request 
	 * @param handler 
	 */
	public void addSoftwareServiceLevelCatagory(ArrayList cqsReplies,EsRequestComplexType request, MetricsHandler handler) throws SifException {
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
						oHeader.setSoftwareServiceLevelCategory("7001");
					}
				}
			}
		}		
	}
	
	
	/**
	 * getContractSummaryFromODS
	 * this method gets Contract Summary from Entitlement ODS
	 * 
	 * @param the request
	 * @param a metrics handler
	 * @return a list of 1 reply
	 */
	private int getCustomerIndicatorFromODS(ArrayList cqsReplies, EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException, DatabaseDownException {
		ESLog.debug("Calling ODS for ContractSummary");
       	int errorId = 0;
		Transaction odsReply = null;
		//For each obligation header:
		//	Get the SourceCustomerID (AMID Level 1) of the SoldTo Customer address
		//	Search in the database whether there is one or several customer indicators that match the SourceCustomerID (AMID Level 1) 
		//	Add the customer indicators in the obligation header segment of the ES response
		try{
			errorId = _odsCustomerIndicatorIntegration.doCustomerIndicatorIntegration(cqsReplies,request,metricsHandler);
			
		}catch(Throwable thr){
			if(thr instanceof DatabaseDownException) {
				ESLog.error("Caught DatabaseDownException from ODS access -> passing it on to signal that service is down",thr);
				throw (DatabaseDownException) thr;
			}
			if(thr instanceof SifException) {
				ESLog.debug("Caught SifException: " + thr.getMessage() + " -> creating ErrorTransaction for ODS",thr);
				odsReply = new ErrorTransaction(null, false, thr, "ODS Customer Indicator", true);
				errorId = -1;
			}			
		}
		if(odsReply != null){
			cqsReplies.add(odsReply);				
		}
		ESLog.debug("Done calling to ODS");
		return errorId;
	}
	

	/** 
	 * getContractSummaryFromCQS
	 * Call CQS
	 * 
	 * @param the request
	 * @param a metrics handler
	 * @return a list of replies
	 */	
	private ArrayList getContractSummaryFromCQS(EsRequestComplexType request, MetricsHandler metricsHandler) {

		ESLog.debug("Starting calling CQS");
		ArrayList listOfOrchestrationWorker = new ArrayList(_cqsContractSummaryIntegrationList.size());
		ArrayList replies = null;
		Thread integrationLayerThread;
		
		// create the CQS threads
		Iterator cqsIntegrationListIterator = _cqsContractSummaryIntegrationList.values().iterator();
		while (cqsIntegrationListIterator.hasNext()) {
			CQSGetContractSummaryIntegration currentIntegrationObject = (CQSGetContractSummaryIntegration) cqsIntegrationListIterator.next();
					
			ESLog.debug("Prepraring thread for region: "
					+ currentIntegrationObject.getRegionName());
			integrationLayerThread = new OrchestrationWorker(request,
					currentIntegrationObject, metricsHandler);
			listOfOrchestrationWorker.add(integrationLayerThread);
		}		

		// start all CQS threads
		try {
			ESLog.debug("Start CQS threads");
			long startTime = startWorkerThreads(listOfOrchestrationWorker);
			ESLog.debug("Wait for the CQS threads");
			replies = waitForWorkerThreads(listOfOrchestrationWorker, startTime);
		}finally {
			listOfOrchestrationWorker.clear();
			ESLog.debug("Done calling CQS");
		}
		
		
		return replies;
	}
	
		public ArrayList getContractSummaryFromCQS_SINGLE_THREAD(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
			ArrayList replies = new ArrayList();
			Transaction transaction = null;
			// start the IB search thread
			ESLog.debug("Start contractSummaty search thread");
			
			CQSGetContractSummaryIntegration currentIntegrationObject=null;
			Iterator cqsIntegrationListIterator = _cqsContractSummaryIntegrationList.values().iterator();
			while (cqsIntegrationListIterator.hasNext()) {
				currentIntegrationObject = (CQSGetContractSummaryIntegration) cqsIntegrationListIterator.next();
			}
			
			OrchestrationWorker integrationLayerThread = new OrchestrationWorker(
					request, currentIntegrationObject, metricsHandler);
			try {
				transaction = startOneThreadAndWaitForReply(integrationLayerThread);
			}finally {
				integrationLayerThread = null;
			}
			replies.add(transaction);
			ESLog.debug("Done calling CQS");
			
			return replies;			
		}
		
		
	
	public void configChanged(ConfigChangeEvent event) {
		if (event != null && event.getNewConfig() != null) {
			
			String threadTimeoutEnable = event.getNewConfig().getProperty("es.contractsummaryservice.orchestration.thread.timeout.enable");
			String threadTimeout = event.getNewConfig().getProperty("es.contractsummaryservice.orchestration.thread.timeout");
			
			if((threadTimeoutEnable != null) && (threadTimeoutEnable.trim().equalsIgnoreCase("true"))){
				_threadTimeoutEnable = true;				
			}
			if((threadTimeout != null) && (threadTimeout.trim().length() > 0)){
				_threadTimeout = Long.parseLong(threadTimeout);
			}
			
			
			String temp = event.getNewConfig().getProperty(
					THREAD_TIMEOUT_PROPERTY);
			temp = event.getNewConfig().getProperty(CONTRACTSUMMARY_SYSTEMS_PROPERTY);
            StringTokenizer st = new StringTokenizer(temp, ",");
            //We create temp variable so that we can safely and quickly save them next
            boolean odsEnable = false;
            boolean cqsEnable = false;
            while (st.hasMoreTokens()) {
            	String systemName = st.nextToken();
            	if(systemName.trim().equalsIgnoreCase("ODS")) {
            		odsEnable = true;
            	}else if(systemName.trim().equalsIgnoreCase("CQS")) {
            		cqsEnable = true;
            	}
            }
            //If no properties set, we default to both enable
            if(!odsEnable && !cqsEnable ) {
            	ESLog.error("No source system specified, by default CQS and ODS will be called");
            	odsEnable = true;
                cqsEnable = true;
            }
            //TODO: WE may need to synchronize
            _cqsEnable = cqsEnable;
            _odsEnable = odsEnable;
            
		}		
	}
	
	/** 
	 * processListOfReplies
	 * This method take the reply out of the list of replies
	 * 
	 * @param a list of replies
	 * @param metrics handler to get performance data
	 */
	
	private EsReply processListOfReplies(ArrayList replies, MetricsHandler metricsHandler, boolean includeWorkings) throws SifException 
	{
		//We only got exception.
		ESLog.debug("Contracts summary processing merging is beginning");
		if(ContractSummaryErrorsProcessing.getInstance().countSifException(replies) == replies.size()) 
		{

			//We only got exception.
			ESLog.debug("We only got execption so , First we try to prioritize errors");
			
			SifException composedError = ContractSummaryErrorsProcessing.getInstance().getHighestPriorityException(replies);
			if(composedError != null) 
			{
				ESLog.debug("Contract summary orchestration was having only exception");
				Iterator iter = replies.iterator();
				boolean isBrk = false;
				while(iter.hasNext())
				{
					Transaction reply = (Transaction)iter.next();
					if((reply != null) && (reply.getSourceSystemErrors() != null)) 
					{
						Collection cqsErrors = reply.getSourceSystemErrors();
						Iterator it = cqsErrors.iterator();
						while(it.hasNext()){
							Object msgObj = (Object) it.next();
							if (msgObj instanceof ZESCQSMESSAGE){
								ZESCQSMESSAGE msg = (ZESCQSMESSAGE)msgObj;
								if ((msg.getMESSAGE() != null) && (msg.getMESSAGE().trim().length() > 0)){
									composedError.setDataPayload(msg.getMESSAGE());
									isBrk = true;
									break;
								}									
							}
						}
						if(isBrk) break;
					}
					throw composedError;
				}
			}
		}
		
		ESLog.debug("A composed reply will be generated");		
		return ContractSummaryTransactionComposition.getInstance().getComposedReply(replies,  includeWorkings);
	}	
	
	
	public static ContractSummaryOrchestration getInstance() {
	    return _instance;
	}
	
}
