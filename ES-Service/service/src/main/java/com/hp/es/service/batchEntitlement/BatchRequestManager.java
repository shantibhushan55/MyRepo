/*
 * Created on Dec 7, 2004
 */
package com.hp.es.service.batchEntitlement;

import java.util.ArrayList;

import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.wsInterface.EsServiceHandler;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;

/**
 * This class is responsible for managing the number of parallel workers
 * running for batch entitlement. When the number of allowed workers are
 * changed in the config file or the batch entitlement is disabled/enabled,
 * the BatchRequestManager will automatically adjust the number of running
 * workers.
 */
public class BatchRequestManager implements ConfigChangeListener {

    static private final int DEFAULT_MAX_PARALLEL_THREADS = 2;
    static private BatchRequestManager instance = new BatchRequestManager();

    private BatchLoadMonitor batchLoadMonitor;
    private ArrayList<Worker> workers = new ArrayList<Worker>();
    private boolean batchEntitlementEnabled = true;
    private int threadCount = DEFAULT_MAX_PARALLEL_THREADS;


    /**
     * Create a BatchLoadMonitor, registers it with the Operation class
     * and register itself as ConfigChangeListener.
     */
    private BatchRequestManager() {
        if (ESLog.isDebugLogEnabled()) {
            ESLog.debug("Constructing BatchRequestManager.");
        }
        batchLoadMonitor = new BatchLoadMonitor();

        // make sure the load monitor gets notified by the Operation.
        EsServiceHandler.addLoadChangeListener(batchLoadMonitor);

        // This will automatically call the configChanged() method with
        // the initial configurations, i.e the further initialization is
        // done there.
        Configuration.getInstance().addConfigChangeListener(this);
    }

    /**
     * @return the BatchRequestManager object (singleton).
     */
    public static  BatchRequestManager getInstance() {
        return instance;
    }

    /**
     * Read and initialize following values: <ul>
     * <li>batchEntitlement.enabled
     * <li>batchEntitlement.threadCount
     * </ul>
     * It also adjusts the number of threads running in parallel.
     * @see com.hp.ruc.config.ConfigChangeListener#configChanged(com.hp.ruc.config.ConfigChangeEvent)
     */
    public void configChanged(ConfigChangeEvent event) {
        if (event!=null && event.getNewConfig()!=null) {
            ESLog.info("Reload configuration");
            try {
                batchEntitlementEnabled = event.getNewConfig()
                        .getBooleanProperty("batchEntitlement.enabled",
                                Boolean.TRUE).booleanValue();
            }
            catch (Exception e) {
                batchEntitlementEnabled = true;
            }

            try {
                threadCount = event.getNewConfig().getInteger("batchEntitlement.threadCount");
            }
            catch (Exception e) {
                threadCount = DEFAULT_MAX_PARALLEL_THREADS;
            }

            if (!batchEntitlementEnabled || threadCount < 0) {
                threadCount = 0;
            }

            adjustRunningWorkers();

            if (ESLog.isDebugLogEnabled()) {
                ESLog.debug("batchEntitlementEnabled = " + batchEntitlementEnabled);
                ESLog.debug("threadCount = " + threadCount);
            }
        }
    }

    /**
     * Make sure that the correct number of workers is running.
     * We need to synchronize that method
     */
    private  synchronized void  adjustRunningWorkers() {
        ESLog.debug("BatchRequestManager needs to have "+threadCount +" thread(s) while currently "+workers.size()+" are registered.");
        // starts threads if necessary
        while (workers.size()<threadCount) {
            if (ESLog.isDebugLogEnabled()) {
                ESLog.debug("Starting 1 worker ");
            }
            Worker w = new Worker(batchLoadMonitor);
            workers.add(w);
            batchLoadMonitor.operationHasStarted();
            w.start();

        }

        // stops threads if necessary (the first condition is used to avoid
        // possible exceptions if threadCount would be negative)
        while (workers.size()>0 && workers.size()>threadCount) {
            if (ESLog.isDebugLogEnabled()) {
                ESLog.debug("Stopping 1 worker ");
            }
            Worker w = (Worker)workers.remove(workers.size()-1);
            // just set the flag and the worker will automatically finish
            w.setStopFlag();
        }
    }

    /**
     * Return current thread count
     * @return int
     */
    public int getThreadCount() {
        return this.threadCount;
    }
}
