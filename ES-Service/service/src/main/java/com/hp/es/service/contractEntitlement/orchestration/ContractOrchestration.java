package com.hp.es.service.contractEntitlement.orchestration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.db.OutputDetails;
import com.hp.es.service.contractEntitlement.integration.CQSGetContractBySNIntegration;
import com.hp.es.service.contractEntitlement.integration.CQSGetContractIntegration;
import com.hp.es.service.contractEntitlement.integration.CQSIntegration;
import com.hp.es.service.contractEntitlement.integration.ODSGetContractBySNIntegration;
import com.hp.es.service.contractEntitlement.integration.ODSGetContractIntegration;
import com.hp.es.service.contractEntitlement.integration.ODSIntegration;
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
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class ContractOrchestration extends SourceSystemsOrchestration implements ConfigChangeListener {

	static protected final String THREAD_TIMEOUT_PROPERTY = "es.contractservice.orchestration.thread.timeout";
	static protected final long DEFAULT_THREAD_TIMEOUT = 5000;
	
	static protected final String CONTRACT_SYSTEMS_PROPERTY = "es.contractservice.orchestration.systems";
	static protected final String DEFAULT_CONTRACT_SYSTEMS = "ODS,CQS";

	protected HashMap<String, CQSIntegration> _cqsContractIntegrationList = null;
	protected HashMap<String, CQSIntegration> _cqsContractBySnIntegrationList = null;
	
	protected ODSIntegration _odsContractIntegration = null;
	protected ODSIntegration _odsContractBySNIntegration = null;
	protected ODSCustomerIndicatorIntegration _odsCustomerIndicatorIntegration = null;

	//Both of them must never be set to false.
	protected boolean   _cqsEnable = true;
	protected boolean   _odsEnable = true;

	/*
	 * Singleton
	 */
	protected final static ContractOrchestration _instance = new ContractOrchestration();

	/*
	 * Default Constructor. It will do initializatiuon at the same time
	 */
	private ContractOrchestration() {
		super();
		Configuration.getInstance().addConfigChangeListener(this);
		init();
	}

	/*
	 * Initialization method It should only be ran once
	 */
	protected synchronized int init() {
		ESLog.debug("Initialization of ContractOrchestration");
		ArrayList<?> listOfRegionName = RegionFactory.getInstance().getAvailableRegionsName();
		
		/*
		 * We need to create the integration layers.
		 */
		// First we create the local one
		_odsContractIntegration = new ODSGetContractIntegration();
		_odsContractBySNIntegration = new ODSGetContractBySNIntegration();
		_odsCustomerIndicatorIntegration = new ODSGetCustomerIndicatorIntegration();
		
		_cqsContractIntegrationList = null;
		_cqsContractBySnIntegrationList = null;
		
		
		_cqsContractIntegrationList = new HashMap<String, CQSIntegration>(listOfRegionName.size());
		_cqsContractBySnIntegrationList = new HashMap<String, CQSIntegration>(listOfRegionName.size());

		for (int i = 0; i < listOfRegionName.size(); i++) {
			String regionName = (String) listOfRegionName.get(i);
			CQSIntegration cqs = new CQSGetContractIntegration(regionName);
			CQSIntegration cqsBySN = new CQSGetContractBySNIntegration(regionName);
			
			_cqsContractIntegrationList.put(regionName, cqs);
			_cqsContractBySnIntegrationList.put(regionName, cqsBySN);
		}
		ESLog.debug("Initialization of ContractOrchestration");
		return 0;
	}

	/*
	 * Instance Method
	 */
	public static ContractOrchestration getInstance() {
		return _instance;
	}

	
	/**
	 * getContractEntitlementBySerialNumberForOrchestration 
	 * Decide which scenario we need to call
	 * 
	 * @param request
	 * @param metricsHandler
	 * @return
	 * @throws SifException
	 */
	public ContractBySnReply getContractEntitlementBySerialNumberForOrchestration(EsRequestComplexType request,
			MetricsHandler metricsHandler) throws SifException {

		ArrayList<Transaction> replies = null;
		try {
			switch(ContractScenario.getInstance().determineContractScenario(request,_cqsEnable,_odsEnable)) {
				case ContractScenario.ODS_ONLY_SCENARIO:
					ESLog.debug("ODS ONLY SCENARIO");
					replies = getContractEntitlementBySNFromODS(request,metricsHandler);
					break;
	
				case ContractScenario.CQS_ONLY_SCENARIO:
					ESLog.debug("ODS ONLY SCENARIO");
					replies = getContractEntitlementBySNFromCQS(request,metricsHandler);
					break;
					
				case ContractScenario.CQS_AND_ODS_SCENARIO:
					ESLog.debug("ODS & CQS");
					replies = getContractEntitlementBySNFromCQSAndODS(request,metricsHandler);
					break;				
			}
			
			EsReply reply = processListOfBySNReplies(replies,metricsHandler, request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().getIncludeWorkings());
			reply.getEsHeader().setInputRequest(request);
			ContractBySnReply cbsr = new ContractBySnReply( reply,getMapOfStandardizedProduct(replies), getReplyContext(replies, request));
			return cbsr;
		}finally {
			cleanContractReplies(replies);
		}
	}
	
	
	
	private void cleanContractReplies(ArrayList<Transaction> replies) {
		ESLog.debug("Cleaning up orchestration");
		try {
			if(replies != null) {
				Iterator<Transaction> it = replies.iterator();
				// go through all replies 
				while(it.hasNext()) {
					Transaction tr= it.next();
					tr.destroy();
				}
			}
		}catch(Exception e)  {
			ESLog.debug("Found an exception while cleaning up",e);
		}
	}

	/**
	 * getReplyContext
	 * 
	 * @param replies
	 * @param request
	 * @return
	 */
	private EsReplyContext getReplyContext(ArrayList<Transaction> replies, EsRequestComplexType request) {
		EsReplyContext finalContext = new EsReplyContext(new OutputDetails(request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest()));
		Iterator<Transaction> it = replies.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if( tmp instanceof ContractTransaction) {
				ContractTransaction tr = (ContractTransaction)tmp;
				
				if(tr.getReplyContext() != null) {
					finalContext.mergeWith(tr.getReplyContext());
				}
			}
		}
		return finalContext;
	}

	/*
	 * Concatenate all maps in  one.
	 */
	private HashMap<?, ?> getMapOfStandardizedProduct(ArrayList<Transaction> replies) {
		Iterator<Transaction> it = replies.iterator();
		HashMap finalMap = new HashMap();
		while(it.hasNext()) {
			Transaction t = it.next();
			if(t.getMappedReply() != null) {
				HashMap<?, ?> map =((ContractTransaction)t).getStandardizedProductHashMap();
				if(map!= null) {
					finalMap.putAll(map);
				}
			}
		}
		return finalMap;
	}

	/**
	 * getContractEntitlement
	 * Decide which scenario to call
	 * 
	 * @param request
	 * @param metricsHandler
	 * @param includeWorkings
	 * @return
	 * @throws SifException
	 */
	protected EsReply getContractEntitlement(EsRequestComplexType request,
			MetricsHandler metricsHandler,  boolean includeWorkings) throws SifException {

		ArrayList<Transaction> replies = null;
		try {
			switch(ContractScenario.getInstance().determineContractScenario(request,_cqsEnable,_odsEnable)) {
				case ContractScenario.ODS_ONLY_SCENARIO:
					replies = getContractEntitlementFromODS(request,metricsHandler);
					break;
	
				case ContractScenario.CQS_ONLY_SCENARIO:
					replies = getContractEntitlementFromCQS(request,metricsHandler);
					break;
					
				case ContractScenario.CQS_AND_ODS_SCENARIO:
					replies = getContractEntitlementFromCQSAndODS(request,metricsHandler);
					break;				
			}
				
			
			// Now we got all the replies from ODS and CQS
			// Call here ODS to get Customer Indicator and map them to apropriate ObligationHeader objects
			
			//if(includeCustomerIndicator)
	       	int errorId = -1;
			if(request.getEsRequestComplexTypeChoice().getContractRequest().getIncludeCustomerIndicator()){
				errorId = getCustomerIndicatorFromODS(replies,request,metricsHandler);			
			}		
	
			EsReply esReply = processListOfReplies(replies,metricsHandler, includeWorkings);
	
			//if(includeCustomerIndicator) and if(includeWorkings)
			if(request.getEsRequestComplexTypeChoice().getContractRequest().getIncludeCustomerIndicator() 
					&& includeWorkings && esReply !=null 
					&& esReply.getEsReplyChoice() !=null && esReply.getEsReplyChoice().getContractEntitlement() !=null){
				ContractEntitlementComplexType cectmp = esReply.getEsReplyChoice().getContractEntitlement();
				if(errorId == 0){
					ESLog.debug("mapping a success customer identicator");
					CSWorkingMapper mapper = new CSWorkingMapper("success","ODS Customer Indicator");
					cectmp.addWorking(mapper.map());
					
				}else if(errorId == ErrorFactory.id300_NO_DATA_FOUND){
					ESLog.debug("mapping a no data found customer identicator");
					CSWorkingMapper mapper = new CSWorkingMapper("No data found","ODS Customer Indicator");
					cectmp.addWorking(mapper.map());				
				}else if(errorId == ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE){
					ESLog.debug("mapping a system not available customer identicator");
	                CSWorkingMapper mapper = new CSWorkingMapper("ES database is down","ODS Customer Indicator");
	                cectmp.addWorking(mapper.map());               
	            }
			}		
			return esReply;
		}finally {
			cleanContractReplies(replies);
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
	private int getCustomerIndicatorFromODS(ArrayList<Transaction> cqsReplies, EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		Transaction odsReply = null;
      	int errorId = 0;
		ESLog.debug("Calling ODS for ContractEntitlement");
		//For each obligation header:
		//	Get the SourceCustomerID (AMID Level 1) of the SoldTo Customer address
		//	Search in the database whether there is one or several customer indicators that match the SourceCustomerID (AMID Level 1) 
		//	Add the customer indicators in the obligation header segment of the ES response
		try{
			errorId = _odsCustomerIndicatorIntegration.doCustomerIndicatorIntegration(cqsReplies,request,metricsHandler);
		}catch(Throwable thr){
			if(thr instanceof DatabaseDownException) {
				ESLog.error("Caught DatabaseDownException from ODS access -> passing it on to signal that service is down");
				odsReply = new ErrorTransaction(null, false, thr, EsConstants.ODSCI_SYSTEM_NAME, true);
				errorId=ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE;
			}
			if(thr instanceof SifException) {
				ESLog.debug("Caught SifException: " + thr.getMessage() + " -> creating ErrorTransaction for ODS");
				odsReply = new ErrorTransaction(null, false, thr, EsConstants.ODSCI_SYSTEM_NAME, true);
			}			
		}
		if(odsReply != null){
			cqsReplies.add(odsReply);				
		}
		ESLog.debug("Done calling to ODS");
		return errorId;
	}
	

	/**
	 * processListOfBySNReplies
	 * This method take the reply out of the list of replies
	 * 
	 * @param a list of replies
	 * @param metrics handler to get performance data
	 */
	private EsReply processListOfBySNReplies(ArrayList<Transaction> replies, MetricsHandler metricsHandler,  boolean includeWorkings) throws SifException {
		//We only got exception.
		ESLog.debug("Contracts by serial Number processing & merging is beginning");
		
		if(ContractErrorsProcessing.getInstance().countSifException(replies) == replies.size()) {

			//We only got exception.
			ESLog.debug("We only got execption so , First we try to prioritize errors");
			
			SifException composedError = ContractErrorsProcessing.getInstance().getHighestPriorityException(replies);
			if(composedError != null) {
				ESLog.debug("Warranty merging was having only exception");
				throw composedError;
			}
		}
		//We are getting a reply how of it
		ESLog.debug("A composed reply will be generated");

		return ContractBySNTransactionComposition.getInstance().getComposedReply(replies,  includeWorkings);
	}


	/** 
	 * processListOfReplies
	 * This method take the reply out of the list of replies
	 * 
	 * @param a list of replies
	 * @param metrics handler to get performance data
	 */
	private EsReply processListOfReplies(ArrayList<Transaction> replies, MetricsHandler metricsHandler, boolean includeWorkings) throws SifException {
		//We only got exception.
		ESLog.debug("Contracts processing merging is beginning");
		
		if(ContractErrorsProcessing.getInstance().countSifException(replies) == replies.size()) {

			//We only got exception.
			ESLog.debug("We only got execption so , First we try to prioritize errors");
			
			SifException composedError = ContractErrorsProcessing.getInstance().getHighestPriorityException(replies);
			if(composedError != null) {
				ESLog.debug("Contract orchestration was having only exception");
				throw composedError;
			}
		}
		//We are getting a reply how of it
		ESLog.debug("A composed reply will be generated");
		
		return ContractTransactionComposition.getInstance().getComposedReply(replies,  includeWorkings);
	}	
	
	/**
	 * getContractEntitlementFromODS
	 * this method gets Contract entitlement from Entitlement ODS
	 * 
	 * @param the request
	 * @param a metrics handler
	 * @return a list of 1 reply
	 */
	private ArrayList<Transaction> getContractEntitlementFromODS(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		ESLog.debug("Calling ODS");
		// There is no timeout when only accesing ODS
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		
		Transaction odsTran = _odsContractIntegration.doContractIntegration(request,metricsHandler);
		list.add(odsTran);
		
		ESLog.debug("Done calling to ODS");
		return list;
	}

	/** 
	 * getContractEntitlementFromCQSAndODS
	 * Call CQS and ODS
	 * 
	 * @param the request
	 * @param a metrics handler
	 * @return a list of replies
	 */
	private ArrayList<Transaction> getContractEntitlementFromCQSAndODS(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		ESLog.debug("Starting calling CQS and ODS");
		ArrayList <OrchestrationWorker> listOfOrchestrationWorkers = new ArrayList<OrchestrationWorker>(_cqsContractIntegrationList.size());
		ArrayList <Transaction> replies;

		OrchestrationWorker integrationLayerThread = null;
		Transaction odsReply = null;
		
		// create all threads and add them to a list
		Iterator<CQSIntegration> cqsIntegrationListIterator = _cqsContractIntegrationList.values().iterator();
		while (cqsIntegrationListIterator.hasNext()) {
			CQSGetContractIntegration currentIntegrationObject = (CQSGetContractIntegration) cqsIntegrationListIterator.next();
					
			ESLog.debug("Prepraring thread for region: "+ currentIntegrationObject.getRegionName());
			integrationLayerThread = new OrchestrationWorker(request,currentIntegrationObject, metricsHandler);
			listOfOrchestrationWorkers.add(integrationLayerThread);
		}		
		
		// start threads and wait for the result
		try {
			// start the CQS threads
			ESLog.debug("Start CQS threads");
			long startTime = startWorkerThreads(listOfOrchestrationWorkers);
			// start the ODS request using the current thread
			// NOTE: This is done to have the DatabaseDownException passed all the way down to the 
			//       ServiceHandler
			try {
				ESLog.debug("Start ODS request on main thread");
				odsReply = _odsContractIntegration.doContractIntegration(request,metricsHandler);
			} catch(Throwable thr) {
			    ESLog.debug("Caught Throwable",thr);
				if(thr instanceof SifException) {
					ESLog.debug("Caught SifException: " + thr.getMessage() + " -> creating ErrorTransaction for ODS");
					odsReply = new ErrorTransaction(null, false, thr, EsConstants.ODS_SYSTEM_NAME, true);
				}
			}  finally {
				ESLog.debug("Wait for the CQS threads");
				replies = waitForWorkerThreads(listOfOrchestrationWorkers, startTime);
				ESLog.debug("CQS threads are done");
			}
			replies.add(odsReply);
		} finally {
			listOfOrchestrationWorkers.clear();
			ESLog.debug("Done calling CQS and ODS");
		}
		return replies;		
	}
	
	/** 
	 * getContractEntitlementFromCQS
	 * Call CQS
	 * 
	 * @param the request
	 * @param a metrics handler
	 * @return a list of replies
	 */	
	private ArrayList<Transaction> getContractEntitlementFromCQS(EsRequestComplexType request, MetricsHandler metricsHandler) {
		ESLog.debug("Starting calling CQS");
		ArrayList<OrchestrationWorker> listOfOrchestrationWorkers = new ArrayList<OrchestrationWorker>(_cqsContractIntegrationList.size());
		ArrayList<Transaction> replies = null;
		OrchestrationWorker integrationLayerThread;
		
		// create the CQS threads
		Iterator<CQSIntegration> cqsIntegrationListIterator = _cqsContractIntegrationList.values().iterator();
		while (cqsIntegrationListIterator.hasNext()) {
			CQSGetContractIntegration currentIntegrationObject = (CQSGetContractIntegration) cqsIntegrationListIterator.next();
					
			ESLog.debug("Prepraring thread for region: "
					+ currentIntegrationObject.getRegionName());
			integrationLayerThread = new OrchestrationWorker(request,
					currentIntegrationObject, metricsHandler);
			listOfOrchestrationWorkers.add(integrationLayerThread);
		}		

		// start all CQS threads
		try {
			ESLog.debug("Start CQS threads");
			long startTime = startWorkerThreads(listOfOrchestrationWorkers);
			ESLog.debug("Wait for the CQS threads");
			replies = waitForWorkerThreads(listOfOrchestrationWorkers, startTime);
		}finally {
			listOfOrchestrationWorkers.clear();
			ESLog.debug("Done calling CQS");
		}
		return replies;
	}
	
	
	/**
	 * getContractEntitlementBySNFromODS
	 * this method get Contract entitlement from Entitlement ODS
	 * 
	 * @param the request
	 * @param a metrics handler
	 * @return a list of 1 reply
	 */
	private ArrayList<Transaction> getContractEntitlementBySNFromODS(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		ESLog.debug("Calling ODS");
		ArrayList<Transaction> list = new ArrayList<Transaction>(1);
		Transaction reply = _odsContractBySNIntegration.doContractIntegration(request,metricsHandler);
		list.add(reply);
		
		ESLog.debug("Done Calling ODS");
		return list;
	}

	/**
	 * getContractEntitlementBySNFromCQSAndODS
	 * Call CQS and ODS for a reply
	 * 
	 * @param the request
	 * @param a metrics handler
	 * @return a list of replies
	 */
	private ArrayList<Transaction> getContractEntitlementBySNFromCQSAndODS(EsRequestComplexType request, MetricsHandler metricsHandler) {
		ESLog.debug("Starting calling CQSbySN and ODS");
		ArrayList<OrchestrationWorker> listOfOrchestrationWorker = new ArrayList<OrchestrationWorker>(_cqsContractBySnIntegrationList.size());
		ArrayList<Transaction> replies = null;
		OrchestrationWorker integrationLayerThread;
		Transaction odsReply = null;

		Iterator<CQSIntegration> cqsIntegrationListIterator = _cqsContractBySnIntegrationList.values().iterator();
		while (cqsIntegrationListIterator.hasNext()) {
			CQSGetContractBySNIntegration currentIntegrationObject = (CQSGetContractBySNIntegration) cqsIntegrationListIterator.next();
					
			ESLog.debug("Prepraring thread for region: "
					+ currentIntegrationObject.getRegionName());
			integrationLayerThread = new OrchestrationWorker(request,
					currentIntegrationObject, metricsHandler);
			listOfOrchestrationWorker.add(integrationLayerThread);
		}		

		// start threads and wait for the result
		try {
			// start the CQS threads
			ESLog.debug("Start CQSbySN threads");
			long startTime = startWorkerThreads(listOfOrchestrationWorker);
			// start the ODS request using the current thread
			// NOTE: This is done to have the DatabaseDownException passed all the way down to the 
			//       ServiceHandler
			try {
				ESLog.debug("Start ODS (bySN) request on main thread");
				odsReply = _odsContractBySNIntegration.doContractIntegration(request,metricsHandler);
			} catch(Throwable thr) {
				if(thr instanceof SifException) {
					ESLog.debug("Caught SifException: " + thr.getMessage() + " -> creating ErrorTransaction for ODS (bySN)");
					odsReply = new ErrorTransaction(null, false, thr, "ODS", true);
				}
			}  finally {
				ESLog.debug("Wait for the CQSbySN threads");
				replies = waitForWorkerThreads(listOfOrchestrationWorker, startTime);
				ESLog.debug("CQSbySN threads are done");
			}
			replies.add(odsReply);
		} finally {
			listOfOrchestrationWorker.clear();
			ESLog.debug("Done calling CQSbySN and ODS");
		}
		return replies;
	}
	
	/**
	 * getContractEntitlementBySNFromCQS
	 * Call CQS 
	 * 
	 * @param the request
	 * @param a metrics handler
	 * @return a list of replies
	 */	
	private ArrayList<Transaction> getContractEntitlementBySNFromCQS(EsRequestComplexType request, MetricsHandler metricsHandler) {
		ESLog.debug("Starting calling CQSbySN");
		ArrayList<OrchestrationWorker> listOfOrchestrationWorker = new ArrayList<OrchestrationWorker>(_cqsContractBySnIntegrationList.size());
		ArrayList<Transaction> replies;
		OrchestrationWorker integrationLayerThread;
		
		// create the threads
		Iterator<CQSIntegration> cqsIntegrationListIterator = _cqsContractBySnIntegrationList.values().iterator();
		while (cqsIntegrationListIterator.hasNext()) {
			CQSGetContractBySNIntegration currentIntegrationObject = (CQSGetContractBySNIntegration) cqsIntegrationListIterator.next();
					
			ESLog.debug("Prepraring thread for region: "
					+ currentIntegrationObject.getRegionName());
			integrationLayerThread = new OrchestrationWorker(request,
					currentIntegrationObject, metricsHandler);
			listOfOrchestrationWorker.add(integrationLayerThread);
		}		
		
		// start all threads and wait for the reply
		try {
			ESLog.debug("Start CQSbySN threads");
			long startTime = startWorkerThreads(listOfOrchestrationWorker);
			ESLog.debug("Wait for the CQSbySN threads");
			replies = waitForWorkerThreads(listOfOrchestrationWorker, startTime);
		}finally {
			listOfOrchestrationWorker.clear();
			ESLog.debug("Done calling CQSbySN");
		}
		return replies;
	}	
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hp.ruc.config.ConfigChangeListener#configChanged(com.hp.ruc.config.ConfigChangeEvent)
	 */
	public void configChanged(ConfigChangeEvent event) {
		if (event != null && event.getNewConfig() != null) {
			String threadTimeoutEnable = event.getNewConfig().getProperty("es.sap.integration.thread.timeout.enable");
			String threadTimeout = event.getNewConfig().getProperty("es.sap.integration.thread.timeout");
			
			if((threadTimeoutEnable != null) && (threadTimeoutEnable.trim().equalsIgnoreCase("true"))){
				_threadTimeoutEnable = true;				
			}
			if((threadTimeout != null) && (threadTimeout.trim().length() > 0)){
				_threadTimeout = Long.parseLong(threadTimeout);
			}

			String temp = event.getNewConfig().getProperty(
					THREAD_TIMEOUT_PROPERTY);
			temp = event.getNewConfig().getProperty(CONTRACT_SYSTEMS_PROPERTY);
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

	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.SourceSystemsOrchestration#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */
	public EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler) throws SifException {
		if(request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest() != null) {
			return getContractEntitlementBySerialNumber(request, metricsHandler);

		}else if(request.getEsRequestComplexTypeChoice().getContractRequest() != null) {
			return getContractEntitlement(request, metricsHandler,  request.getEsRequestComplexTypeChoice().getContractRequest().getIncludeWorkings());
		}
		return null;
	}

	private EsReply getContractEntitlementBySerialNumber(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		ContractBySnReply  cbsr = getContractEntitlementBySerialNumberForOrchestration(request, metricsHandler);
		return cbsr.getEsReply();
	}
}
