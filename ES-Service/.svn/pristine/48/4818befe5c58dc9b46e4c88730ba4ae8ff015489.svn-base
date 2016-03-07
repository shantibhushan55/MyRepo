package com.hp.es.service.catsAgreement.orchestration;

import com.hp.es.service.catsAgreement.integration.ASTRO2GetCatsAgreementIntegration;
import com.hp.es.service.operations.OperationContext;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.OrchestrationWorker;
import com.hp.es.service.orchestration.SourceSystemsOrchestration;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public class CatsAgreementOrchestration extends SourceSystemsOrchestration implements ConfigChangeListener {

    /*
     * Singleton
     */
    protected final static CatsAgreementOrchestration _instance = new CatsAgreementOrchestration();

    /*
     * Default Constructor. It will do initializatiuon at the same time
     */
    private CatsAgreementOrchestration() {
        super();
        Configuration.getInstance().addConfigChangeListener(this);
    }

    /*
     * Instance Method
     */
    public static  CatsAgreementOrchestration getInstance() {
        return _instance;
    }

    protected int init() {
        // nothing to do anymore after changing to country of service
        return 0;
    }


    /**
     * The public interface which gets CATS agreement information from CATS source system (ASTRO2).
     * 
     * @param request
     * @param swopWarrantyEntitlement
     *            The warranty information is needed for the CATS Agreement information integration
     * @param metricsHandler
     * @return
     * @throws SifException
     */
    public Transaction getTransaction(EsRequestComplexType request, OperationContext context, MetricsHandler metricsHandler) throws SifException {
        String methodId = "CatsAgreementOrchestration.execute()";
        MetricsEntry overallTime = null;
        if (metricsHandler != null)
            overallTime = metricsHandler.startEntry(methodId);

        ESLog.debug("execute starting");
        Transaction reply = null;
        try {
            reply = getCatsFromAstro2(request, context, metricsHandler);
            return reply;
        } catch (Throwable thr) {
            ESLog.debug("Caught SifException: " + thr.getMessage() + " -> creating ErrorTransaction for ASTRO2");
            reply = new ErrorTransaction(null, false, thr, "ASTRO2", true);
            return reply;
        } finally {
            if (overallTime != null)
                overallTime.actionDone();
        }
    }

    /**
     * This method is used for sending the request to ASTRO2 source system
     * 
     * @param request
     * @param metricsHandler
     */
    protected Transaction getCatsFromAstro2(EsRequestComplexType request, OperationContext context, MetricsHandler metricsHandler)
            throws SifException {
        Transaction reply = null;
        ESLog.debug("Enter");
        WarrantyEntitlementComplexType swopWarrantyEntitlement = context.getEsReplyOfSwop().getEsReplyChoice().getWarrantyEntitlement();
        ASTRO2GetCatsAgreementIntegration catsIntegration = new ASTRO2GetCatsAgreementIntegration(swopWarrantyEntitlement);
        context.setRegionConfiguration(catsIntegration.getRegionConfiguration());
        // start threads for the received access objects w/ timeout
        OrchestrationWorker integrationLayerThread = new OrchestrationWorker(request, catsIntegration, metricsHandler);
        ESLog.debug("Starting 1 thread");
        try {
            reply = startOneThreadAndWaitForReply(integrationLayerThread);
        } finally {
            integrationLayerThread = null;
        }
        ESLog.debug("Exit");
        return reply;
    }

    public void configChanged(ConfigChangeEvent event) {
        String threadTimeoutEnable = event.getNewConfig().getProperty("es.astro2.integration.thread.timeout.enable");
        String threadTimeout = event.getNewConfig().getProperty("es.astro2.integration.thread.timeout");

        if ((threadTimeoutEnable != null) && (threadTimeoutEnable.trim().equalsIgnoreCase("true"))) {
            _threadTimeoutEnable = true;
        }
        if ((threadTimeout != null) && (threadTimeout.trim().length() > 0)) {
            _threadTimeout = Long.parseLong(threadTimeout);
        }
    }

    /**
     * @deprecated please use getTransaction method
     */
    public EsReply execute(EsRequestComplexType request, OperationContext context, MetricsHandler metricsHandler) throws SifException {
        // DO NOTHING
        return null;
    }
}
