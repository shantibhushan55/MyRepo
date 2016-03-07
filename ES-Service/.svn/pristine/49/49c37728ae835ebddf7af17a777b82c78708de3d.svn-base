/*
 * Created on Mar 20, 2006
 */
package com.hp.es.service.unitEventHistory.orchestration;

import java.util.ArrayList;

import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.orchestration.OrchestrationWorker;
import com.hp.es.service.orchestration.SourceSystemsOrchestration;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.unitEventHistory.integration.UnitEventHistoryIntegration;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 * The orchestration is only used for passing the requests and replies.
 * No orchestration is done, since we are sending the request only
 * to the local region.
 */
public class UnitEventHistoryOrchestraction extends SourceSystemsOrchestration   implements ConfigChangeListener{	
	/*
	 * Singleton
	 */
	protected final static UnitEventHistoryOrchestraction _instance = new UnitEventHistoryOrchestraction();
	protected UnitEventHistoryIntegration _uehIntegration = null;
	/*
	 * Default Constructor.
	 */
	private UnitEventHistoryOrchestraction() {
		super();
        Configuration.getInstance().addConfigChangeListener(this);
	}

	/*
	 * Instance Method
	 */
	public static synchronized UnitEventHistoryOrchestraction getInstance() {
		return _instance;
	}
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.SourceSystemsOrchestration#init()
	 */
	protected synchronized int init() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.orchestration.SourceSystemsOrchestration#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */
	public EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler) throws SifException {
		ESLog.debug("Start Unit event historythread");
        ArrayList replies = null;
        EsReply esReply = null;
		try {
            replies = getUnitHistoryFromMultipleInstances(request, metricsHandler);
            esReply = findReplyFromMultipleUnitHistoryReplies(replies, metricsHandler);

		}finally {

		}
		return esReply;				
	}
	
	private EsReply findReplyFromMultipleUnitHistoryReplies(ArrayList replies,
			MetricsHandler metricsHandler) throws SifException {
        ESLog.debug("Warranty merging is beginning");

        if (UnitEventHistoryErrorsProcessing.getInstance().countSifException(replies) == replies.size()) {

            // We only got exception.
            ESLog.debug("We only got execption so , First we try to prioritize errors");

            SifException composedError = UnitEventHistoryErrorsProcessing.getInstance().getHighestPriorityException(replies);
            if (composedError != null) {
                ESLog.debug("Warranty merging was having only exception");
                throw composedError;
            }
        }
        // We are getting a reply how of it
        ESLog.debug("A composed reply will be generated");

        return UnitEventHistoryTransactionComposition.getInstance().getReplyWithUnitEventHistory(replies);
	}

	/*
	 * get unit history from multiple instancec
	 */
    protected ArrayList getUnitHistoryFromMultipleInstances(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
        ArrayList replies = null;
        // access objects from factory
        ESLog.debug("Starting multiple instance access");
        ArrayList threadList = new ArrayList();
        ArrayList listOfRegionName = RegionFactory.getInstance().getAvailableRegionsName();

        // We need to create the integration layers.
        for (int i = 0; i < listOfRegionName.size(); i++) {
            String regionName = (String) listOfRegionName.get(i);
            UnitEventHistoryIntegration currentUniitHistoryIntegrationObject = new UnitEventHistoryIntegration(regionName);
            ESLog.debug("Prepraring thread for region: " + currentUniitHistoryIntegrationObject.getRegionName());
            Thread integrationLayerThread = new OrchestrationWorker(request, currentUniitHistoryIntegrationObject, metricsHandler);
            threadList.add(integrationLayerThread);
        }
        // start threads for the received access objects w/ timeout
        ESLog.debug("Starting threads");

        try {
            ESLog.debug("Start SWOP access threads");
            long startTime = startWorkerThreads(threadList);
            ESLog.debug("Wait for the SWOP access threads");
            replies = waitForWorkerThreads(threadList, startTime);
        } finally {
            threadList.clear();
        }

        return replies;

    }	

	public void configChanged(ConfigChangeEvent event) {
		/*
		 * TODO change that
		 */
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
