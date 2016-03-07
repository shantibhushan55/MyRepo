/*
 * Created on Mar 1, 2006
 *
 */
package com.hp.es.service.orchestration.sap;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.ThreadLocalHolder;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author juhank
 *
 * Region is a wrapper object for the access to the SAP region. It contains
 * the access object for the main access and the failover access.
 * It handles the failover by itself. It will be created by the RegionFactory
 * and used by the Orchestration.
 * Features:
 * - Will manage the failover
 * - Keeps track of errors from SAP access
 */
public abstract class  Region {

    protected static final long MAX_CONNECT_WAIT_MILLIS = 30000;
    protected Object initMutex = new Object();

    protected Object objSyncFailover =new Object();
    
	protected boolean failoverMode = false;
	protected RegionConfiguration config = null;
	protected int mainAccessErrorCount = 0;
	protected int failoverAccessErrorCount = 0;
	
	
	protected long failoverStartTime = 0;
	
	
	protected abstract Transaction callMainHost(String packageName, String sapFunctionName, Object request, String regionDisplayName, boolean isLocal) throws SifException;
	protected abstract Transaction callFailoverHost(String packageName, String sapFunctionName, Object request, String regionDisplayName, boolean isLocal) throws SifException;
	
	/**
	 * Checks the execption if we need need to increase the error count.
	 * Returns true if the execption is a valid exception for it.
	 * @param ex
	 * @return
	 */
	protected abstract boolean isValidExceptionForErrorCount(Exception ex, boolean fromMain);
    
	/**
     * mapToSifException
     * @param ex
     * @return
     */
	protected abstract  SifException mapToSifException(Exception ex);
	
	/**
	 * create access objects for main and failover host
	 */
	protected abstract void initConnections();
	
	
	protected abstract boolean isFailoverInstanceAvailable();
	protected abstract boolean isMainInstanceAvailable();
	
	
	protected abstract void setFailoverInstanceUnAvailable();
	protected abstract void setMainInstanceUnAvailable();
	
	protected abstract String getPackageName(String sapFunctionName);
	/**
	 * Get the main pool state and usage
	 * @return String containing the main pool state and usage
	 */
	public abstract String getMainState();
	
	/**
	 * Get the failover pool state and usage
	 * @return String containing the failover pool state and usage
	 */
	public abstract String getFailoverState();
	
	//OLCAYYE, 20th April 2007, contractSummary test
	//protected Region(RegionConfiguration config) {
	public Region(RegionConfiguration config) {
		this.config = config;
		initConnections();
	}

	/**
	 * Executing the request against the main or failover instance
	 * @param sapFunctionName
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Transaction execute(String sapFunctionName, Object request, String sapRegionDisplayName, boolean isLocal, MetricsHandler metricsHandler)
			throws Exception {

    	ESLog.debug("Executing request");
        String regionName = getConfiguration().getRegionName();
        ThreadLocalHolder.getRegionNames().set(regionName);
        Transaction result = null;
        MetricsEntry entry = null;
        if(metricsHandler != null) {
        	entry=metricsHandler.addEntry("SAP_CALL_"+regionName+"_"+sapFunctionName);
        }
        String packageName = getPackageName(sapFunctionName);
        try {
        	ESLog.debug("Region execute: inFailoverMode:" +inFailoverMode());
        	if(entry != null) 
        		entry.actionStart();
    		if (inFailoverMode() == false && config.isMainEnable()) {
    			ESLog.debug(".....Normal mode(main host)....."); 
	        	ThreadLocalHolder.getHostNames().set(config.getMainHost());
	        	ThreadLocalHolder.getHostUrls().set(config.getMainUrl());
                result = callMainHost(packageName, sapFunctionName, request, sapRegionDisplayName, isLocal);
		    } else if(config.isFailoverEnable()){
		    	ESLog.debug(".....Failover mode(fail over).....");
                ThreadLocalHolder.getHostNames().set(config.getFailoverHost());
	        	ThreadLocalHolder.getHostUrls().set(config.getFailoverUrl());
		        result = callFailoverHost(packageName, sapFunctionName, request, sapRegionDisplayName, isLocal);
            } else {
            	ESLog.error("Failover and main are setup to be disable");
            	throw ErrorFactory.getSifException(ErrorFactory.id8001_SYSTEM_NOT_AVAILABLE,"Region is disable");
            }
        } catch (Exception ex) {
            // In case of exceptions we have to check whether this failure means
            // we should count as normal end or as failure...
            if (ex instanceof SifException) {
                if ( ((SifException)ex).getErrorID().equals(""+ErrorFactory.id8001_SYSTEM_NOT_AVAILABLE)) {
                	if(inFailoverMode()){
                		ESLog.error("Region"+getFailoverConfigURL() + " not available" + ex.getMessage());
                	}else {
                		ESLog.error("Region"+getMainConfigURL() + " not available" + ex.getMessage());
                	}
                }
            }
            throw ex;
        } finally {
        	ESLog.debug("Remove all messages in ThreadLocal");
        	ThreadLocalHolder.removeAll();
        	if(entry != null)
        		entry.actionDone();
        }

        return result;
	}

	
	/**
	 * Safely remove both connections to SAP, and setup
	 * the access classes with the new conifguration
	 */
	public void modify(RegionConfiguration regionConfig) {
		// store the new configuration
		this.config = regionConfig;
		// create the new instances with the new configuration
    	ESLog.debug("Creating new instances");
		initConnections();
	}

	/**
	 * Returns the configuration of the region
	 * @return
	 */
	public RegionConfiguration getConfiguration() {
		return this.config;
	}

	/**
	 * Logs the used configuration to the log file
	 * @param conifgurationToLog
	 */
	protected void logConfiguration() {
		if(ESLog.isDebugLogEnabled()) {
	    	ESLog.debug("**** MAIN **** REGION: " + config.getRegionName());
	    	ESLog.debug("getMainUrl         : " + config.getMainUrl());
	    	ESLog.debug("getMainHost        : " + config.getMainHost());
	    	ESLog.debug("getMainUser        : " + config.getMainUser());
	    	ESLog.debug("getMainPassword    : " + config.getMainPassword());

	    	ESLog.debug("getMainConnectionTimeout : " + config.getMainConnectionTimeout());
	    	ESLog.debug("getMainConnectionTimeoutCheckPeriod : " + config.getMainConnectionTimeoutCheckPeriod());
	    	ESLog.debug("getMainMaxWaitTime : " + config.getMainMaxWaitTime());

	    	ESLog.debug("getRetunInfoLevel    : " + config.getRetunInfoLevel());
	    	ESLog.debug("getRetunInfoModifier    : " + config.getRetunInfoModifier());
	    	
	    	ESLog.debug("**** FAILOVER **** REGION: " + config.getRegionName());
	    	ESLog.debug("getFailoverUrl         : " + config.getFailoverUrl());
	    	ESLog.debug("getFailoverHost        : " + config.getFailoverHost());
	    	ESLog.debug("getFailoverUser        : " + config.getFailoverUser());
	    	ESLog.debug("getFailoverPassword    : " + config.getFailoverPassword());
	    	ESLog.debug("getFailoverConnectionTimeout : " + config.getFailoverConnectionTimeout());
	    	ESLog.debug("getFailoverFonnectionTimeoutCheckPeriod : " + config.getFailoverFonnectionTimeoutCheckPeriod());
	    	ESLog.debug("getFailoverMaxWaitTime : " + config.getFailoverMaxWaitTime());
		}
	}

	/**
	 * return the failover mode
	 * @return
	 */
	public  boolean inFailoverMode() {
		synchronized (objSyncFailover) {
			return failoverMode;
		}
			
	}

	
	
	/**
	 * Increase the main error count and check if we need to
	 * start the failover mode
	 */
	protected  void increaseAndCheckMainErrorCount() {
		// increase error count for main host and check if we need to switch to failover
		int tmpmainAccessErrorCount = 0;
		synchronized (objSyncFailover) {
			mainAccessErrorCount = mainAccessErrorCount + 1;
			tmpmainAccessErrorCount=mainAccessErrorCount;
		}
		
    	ESLog.debug("increaseAndCheckMainErrorCount:mainAccessErrorCount: " + tmpmainAccessErrorCount);
    	ESLog.debug("increaseAndCheckMainErrorCount:MainConsecutiveError: " + config.getMainConsecutiveError());
    	ESLog.debug("increaseAndCheckMainErrorCount:!inFailoverMode(): " + !inFailoverMode());
    	ESLog.debug("increaseAndCheckMainErrorCount:config.getRegionName(): " + config.getRegionName());
    	ESLog.debug("increaseAndCheckMainErrorCount:MainUrl: " + config.getMainUrl());
    	ESLog.debug("increaseAndCheckMainErrorCount:FailoverUrl: " + config.getFailoverUrl());
    	
    	// check if we should switch to failover instance
    	if((tmpmainAccessErrorCount >= config.getMainConsecutiveError()) && !inFailoverMode()) {
        	// we don't switch to failover if failover is down or not enabled
    		ESLog.debug("isFailoverInstanceAvailable: " + isFailoverInstanceAvailable());
    		if(config.isFailoverEnable() && isFailoverInstanceAvailable()) {
    			// failover instance is enabled and available => go to failover 
    			ESLog.debug("increaseAndCheckMainErrorCount: startFailoverMode");
    			startFailoverMode();
    		} else {
    			// either the failover is not enabled or available => log ITO message
    			ESLog.error("SAP main and failover for region " + getConfiguration().getRegionName() + " unavailable");
    		}
    	}
	}

	/**
	 * Increase the failover error count and check if we need to
	 * end the failover mode
	 */
	protected void increaseAndCheckFailoverErrorCount() {
		int tmpfailoverAccessErrorCount = 0;
		synchronized (objSyncFailover) {
			failoverAccessErrorCount = failoverAccessErrorCount + 1;
			tmpfailoverAccessErrorCount=failoverAccessErrorCount;
		}
    	ESLog.debug("failoverAccessErrorCount: " + tmpfailoverAccessErrorCount);

    	// check if we should switch to main instance
    	if((tmpfailoverAccessErrorCount >= config.getFailoverConsecutiveError()) && inFailoverMode()) {
        	// we don't switch to main if main is down or not enabled
    		if(config.isMainEnable() && isMainInstanceAvailable()) {
    			// main instance is enabled and available => go to main 
    			ESLog.info("Failover will be stopped and pool will be maintained as not working for " + getConfiguration().getRegionName());
    			endFailoverMode();
    		} else {
    			// either the main is not enabled or available => log ITO message
    			ESLog.error("SAP main and failover for region " + getConfiguration().getRegionName() + " unavailable");
    		}
    	}
	}

	/**
	 * Start failover mode and set all the parameters for it
	 */
	protected void startFailoverMode() {
    	ESLog.info("Starting failover mode for "+getConfiguration().getRegionName());
    	synchronized (objSyncFailover) {
    		if(!failoverMode) {
					failoverMode = true;
					mainAccessErrorCount =0;
					
					//we told the pool that it is having a major issue
					setMainInstanceUnAvailable();
					failoverStartTime = System.currentTimeMillis();
					ESLog.error("Region " + getConfiguration().getRegionName() + " switched to failover mode");
	    	}else {
	    		ESLog.info("Region " + getConfiguration().getRegionName() + "is already in failover mode");
	    	}
    	}
			
	        


	}

	/**
	 * End the failover mode and set all the parameter for it
	 */
	protected void endFailoverMode() {
    	ESLog.error("Ending failover mode "+getConfiguration().getRegionName());
    	if(failoverMode) {
    		synchronized (objSyncFailover) {
				failoverMode = false;
				failoverAccessErrorCount = 0;
				failoverStartTime = 0 ;
				setFailoverInstanceUnAvailable();
    		}
    	}
    	ESLog.debug("Ending failover mode: failoverMode:" +failoverMode);
	}

	/**
	 * checks if the defined duration for failover mode has expired. If yes
	 * we will end the failover mode.
	 */
	protected synchronized void checkForFailoverExpiration() {
    	ESLog.debug("Checkin for failover expiration of failover mode (Duration: " + config.getFailoverModeDuration() + ")");
    	long timeInFailoverMode =0;
    	synchronized (objSyncFailover) {
    		timeInFailoverMode = System.currentTimeMillis() - failoverStartTime;
    	}
    	ESLog.debug("Time in failover mode: " + timeInFailoverMode);
		if(timeInFailoverMode > config.getFailoverModeDuration()) {
	        ESLog.info("Region " + getConfiguration().getRegionName() + " is in failover mode for : " + timeInFailoverMode + ",this exceed the planned " + config.getFailoverModeDuration() + "ms");
	        if(isMainInstanceAvailable()) {
	        	endFailoverMode();
	        } else {
	           // ESLog.logITO(ItoErrorFactory.getItoError(
	            //        ItoErrorFactory.ID_3712_SAP_FAIL_OVER, getConfiguration().getRegionName()), "SAP region " + getConfiguration().getRegionName() + " cannot switch back from failover as main is down");
	        	ESLog.error("Region " + getConfiguration().getRegionName() + "cannot switch back from failover as main is down");
	        	failoverStartTime = System.currentTimeMillis();
	        	ESLog.error("Failover mode will continue. New failover start time: " + failoverStartTime);
	        }
		}
	}

	/**
	 * Set the main error counter back to 0
	 */
	protected synchronized void clearMainErrorCounter() {
    	ESLog.debug("Clearing mainAccessErrorCount");
		mainAccessErrorCount = 0;
	}

	/**
	 * Set the failover error counter back to 0
	 */
	protected synchronized void clearFailoverErrorCounter() {
    	ESLog.debug("Clearing failoverAccessErrorCount");
		failoverAccessErrorCount = 0;
	}

	
	/**
	 * Get the main configuration
	 * @return String containing the main configuration
	 */
	public String getMainConfig(){
		StringBuffer sb = new StringBuffer();
    	sb.append("URL: " + config.getMainUrl() + "\n");
    	sb.append("User:          " + config.getMainUser() + "\n");
    	sb.append("Password:      " + config.getMainPassword() + "\n");
    	sb.append("Max Wait Time: " + config.getMainMaxWaitTime());
    	return sb.toString();
	}
	
	/**
	 * Get the main configuration
	 * @return String containing the main configuration
	 */
	public String getMainConfigURL(){
		StringBuffer sb = new StringBuffer();
    	sb.append("URL: " + config.getMainUrl() + "\t");
    	return sb.toString();
	}

	/**
	 * Get the failover configuration
	 * @return String containing the failover configuration
	 */
	public String getFailoverConfig(){
		StringBuffer sb = new StringBuffer();
    	sb.append("URL: " + config.getFailoverUrl() + "\n");
    	sb.append("User:          " + config.getFailoverUser() + "\n");
    	sb.append("Password:      " + config.getFailoverPassword() + "\n");

    	sb.append("Max Wait Time: " + config.getFailoverMaxWaitTime());
    	return sb.toString();
	}	
	/**
	 * Get the failover configuration
	 * @return String containing the failover configuration
	 */
	public String getFailoverConfigURL(){
		StringBuffer sb = new StringBuffer();
    	sb.append("URL: " + config.getFailoverUrl() + "\t");
    	return sb.toString();
	}	
	

}
