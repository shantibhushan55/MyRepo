/*
 * Created on Dec 6, 2004
 */
package com.hp.es.service.batchEntitlement;

import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.LoadChangeListener;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;

/**
 * This class monitors the current load on the service (i.e. how many operations
 * are currently running). Depending on the load, it notifies waiting threads
 * (workers) to continue or keeps them waiting. 
 */
public class BatchLoadMonitor implements LoadChangeListener, ConfigChangeListener {
    
    static private int  DEFAULT_MAX_PARALLEL_OPERATION = 10;
    static private long DEFAULT_IDLE_TIME = 180000; // 3 minutes
    
    private int currentlyRunningOperations = 0;
    private int maxRunningOperations = DEFAULT_MAX_PARALLEL_OPERATION;
    private long idleTime = DEFAULT_IDLE_TIME;
    private Object sync = new Object();


    /**
     * The constructor automatically registers the current object as 
     * ConfigChangeListener with the EsConfiguration class.
     */
    public BatchLoadMonitor() {
        Configuration.getInstance().addConfigChangeListener(this);
    }
    
    /**
     * This method will be called when a operation has started.
     * @see com.hp.es.service.util.LoadChangeListener#operationHasStarted()
     */
    public void operationHasStarted() {
        currentlyRunningOperations++;
        /*
        if (ESLog.isDebugLogEnabled()) {
            ESLog.debug("An operation had started (currentlyRunningOperations="
                    + currentlyRunningOperations + ")");
        }
        */
    }

    /**
     * This method will be called when a operation has finished. When the new
     * load is below a configured limit, it releases one available worker thread.
     * @see com.hp.es.service.util.LoadChangeListener#operationHasFinished()
     */
    public void operationHasFinished() {
        currentlyRunningOperations--;
        /*
        if (ESLog.isDebugLogEnabled()) {
            ESLog.debug("An operation had finished (currentlyRunningOperations="
                    + currentlyRunningOperations + ")");
        }
        */

        synchronized(sync) {
            if (currentlyRunningOperations<maxRunningOperations) {
                /*
                if (ESLog.isDebugLogEnabled()) {
                    ESLog.debug("There is currently less running operation than max, a thread will be notified.");
                }
                */
                // "release" all waiting workers because notify() is known to be buggy.
                sync.notifyAll();
            }
        }
    }
    
    /**
     * This is a blocking method which is called by the workers. When the
     * service load is under a configured value, this method returns immediately.
     * Otherwise it will block until the load goes under that limit.
     * @param enforceMinimumWaitTime flag that can be used to enforce that
     * 		  the method blocks a certain time (e.g. when the worker detects
     * 		  that the request queue is empty, i.e. nothing is to do)
     */
    public void waitForLowLoad(boolean enforceMinimumWaitTime) {
        
        if(enforceMinimumWaitTime) {
	        try {
	            if (ESLog.isDebugLogEnabled()) {
	                ESLog.debug("Worker will wait idle for low load for "+idleTime + " msec");
	            }                   
	            Object o = new Object();
	            synchronized(o) {
	            	o.wait(idleTime);
	            }
	        }
	        catch (InterruptedException e) {
	            ESLog.error("Worker was interrupted while waiting idle for load", e);
	        }
        }
        
        synchronized(sync) {
            // do the check in a while loop becvauce we use notifyAll() 
            // in operationHasFinished()
            operationHasFinished();  
            while ((currentlyRunningOperations >= maxRunningOperations) ) {
                try {
                    //ESLog.debug("Worker will wait until to be notified.");
                    sync.wait();
                    //ESLog.debug("Worker woke up.");
                }
                catch (InterruptedException e) {
                }
                //ESLog.debug("Worker woke up");
                

            }
            operationHasStarted();
        }
    }

    /**
     * Read and initialize following values: <ul>
     * <li>batchEntitlement.threadIdleTime
     * <li>batchEntitlement.maxParallelRequests
     * </ul>
     * @see com.hp.ruc.config.ConfigChangeListener#configChanged(com.hp.ruc.config.ConfigChangeEvent)
     */
    public void configChanged(ConfigChangeEvent event) {
       
        if (event!=null && event.getNewConfig()!=null) {
            ESLog.info("Reload configuration");
            try {
                idleTime = Long.parseLong(event.getNewConfig().getProperty(
                        "batchEntitlement.threadIdleTime", "" + DEFAULT_IDLE_TIME));
            }
            catch (Exception e) {
                ESLog.error("Error while reading parameter 'batchEntitlement.threadIdleTime'", e);
                idleTime = DEFAULT_IDLE_TIME;
            }
            
            try {
               
                    
                maxRunningOperations = event.getNewConfig().getInteger(
                        "batchEntitlement.maxParallelRequests");
            }
            catch (Exception e) {
                ESLog.error("Error while reading parameter 'batchEntitlement.maxParallelRequests'", e);
                maxRunningOperations = DEFAULT_MAX_PARALLEL_OPERATION;
            }
            
           
            if (ESLog.isDebugLogEnabled()) {
                ESLog.debug("idleTime = " + idleTime);
                ESLog.debug("maxRunningOperations = " + maxRunningOperations);
            }
         
            
        }
    }


}
