/*
 * Created on Mar 20, 2006
 */
package com.hp.es.service.ibSearch.orchestration;

import java.util.ArrayList;

import com.hp.es.service.ibSearch.integration.IBSearchIntegration;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.orchestration.OrchestrationWorker;
import com.hp.es.service.orchestration.SourceSystemsOrchestration;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 * The orchestration is only used for passing the requests and replies.
 * No orchestration is done, since we are sending the request only
 * to the local region.
 */
public class IBSearchOrchestraction extends SourceSystemsOrchestration   implements ConfigChangeListener{	
	/*
	 * Singleton
	 */
	protected final static IBSearchOrchestraction _instance = new IBSearchOrchestraction();
	protected IBSearchIntegration _ibSearchIntegration = null;
	/*
	 * Default Constructor.
	 */
	private IBSearchOrchestraction() {
		super();
        Configuration.getInstance().addConfigChangeListener(this);
		init();
	}

	/*
	 * Instance Method
	 */
	public static synchronized IBSearchOrchestraction getInstance() {
		return _instance;
	}
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.SourceSystemsOrchestration#init()
	 */
	protected synchronized int init() {
		_ibSearchIntegration = IBSearchIntegration.getInstance();
		return 1;
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.SourceSystemsOrchestration#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */
	public EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler) throws SifException {
		Transaction transaction = null;
		// start the IB search thread
		ESLog.debug("Start IB search thread");
		OrchestrationWorker integrationLayerThread = new OrchestrationWorker(
				request, _ibSearchIntegration, metricsHandler);
		try {
			transaction = startOneThreadAndWaitForReply(integrationLayerThread);
		}finally {
			integrationLayerThread = null;
		}
		
		// check for errors
		ESLog.debug("Check for errors");
		if(transaction.getMappedErrors() != null) {
			if(transaction.getMappedErrors().size() != 0) {
				ArrayList list = new ArrayList();
				list.add(transaction);
				throw IBSearchErrorsProcessing.getInstance().getHighestPriorityException(list);
			}
		}
		
		// return the ES reply
		ESLog.debug("We have a IB reply, let's return it");		
		return transaction.getMappedReply();				
	}
	
	public void configChanged(ConfigChangeEvent event) {
		String threadTimeoutEnable = event.getNewConfig().getProperty("es.ibsearch.swop.timeout.enable");
		String threadTimeout = event.getNewConfig().getProperty("es.ibsearch.swop.timeout");
		
		if((threadTimeoutEnable != null) && (threadTimeoutEnable.trim().equalsIgnoreCase("true"))){
			_threadTimeoutEnable = true;				
		}
		if((threadTimeout != null) && (threadTimeout.trim().length() > 0)){
			_threadTimeout = Long.parseLong(threadTimeout);
		}
		
	}
	

}
