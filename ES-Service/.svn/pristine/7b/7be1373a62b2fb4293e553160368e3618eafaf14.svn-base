package com.hp.es.service.routingDetails.orchestration;

import java.util.ArrayList;

import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.orchestration.OrchestrationWorker;
import com.hp.es.service.orchestration.SourceSystemsOrchestration;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.routingDetails.integration.RoutingDetailsIntegration;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author Chunyang
 * @since 9.0.2
 */
public class RoutingDetailsOrchestration extends SourceSystemsOrchestration implements ConfigChangeListener {

    private static final String ROUTING_DETAILS_ORCHESTRATION_REGION = "es.routingdetails.orchestration.region";
    private static final String DEFAULT_REGION = "AM";
    protected String region = DEFAULT_REGION;
    /*
     * Singleton
     */
    protected static RoutingDetailsOrchestration _instance =null;
    protected RoutingDetailsIntegration _routingDetailsIntegration = null;

    /*
     * Default Constructor. It will do initializatiuon at the same time
     */
    protected RoutingDetailsOrchestration() {
        super();
        Configuration.getInstance().addConfigChangeListener(this);
        init();
    }

    /*
     * Instance Method
     */
    public synchronized static RoutingDetailsOrchestration getInstance() {
    	if(_instance == null) {
    		_instance = new RoutingDetailsOrchestration();
    	}
        return _instance;
    }

    protected int init() {
        ESLog.debug("Initialization of RoutingDetailsOrchestration");
        _routingDetailsIntegration = new RoutingDetailsIntegration(region);
        ESLog.debug("Exit");
        return 1;
    }

    public EsReply execute(EsRequestComplexType request, OperationContext context,MetricsHandler metricsHandler) throws SifException {
        Transaction transaction = null;

        ESLog.debug("Start RoutingDetails thread");
        OrchestrationWorker orchestrationWorker = new OrchestrationWorker(request, _routingDetailsIntegration,
                metricsHandler);
        try {
            transaction = startOneThreadAndWaitForReply(orchestrationWorker);
        } finally {
            orchestrationWorker = null;
        }

        // check for errors
        ESLog.debug("Check for errors");
        if (transaction.getMappedErrors() != null) {
            if (transaction.getMappedErrors().size() != 0) {
                ArrayList list = new ArrayList();
                list.add(transaction);
                throw RoutingDetailsErrorsProcessing.getInstance().getHighestPriorityException(list);
            }
        }

        // return the ES reply
        ESLog.debug("We have a RoutingDetails reply, let's return it");
        return transaction.getMappedReply();
    }

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
        	
            region = event.getNewConfig().getProperty(ROUTING_DETAILS_ORCHESTRATION_REGION);
        }
    }
}
