package com.hp.es.service.orchestration.sap;

import java.io.IOException;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.plumbing.SAPConnectivity;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.sif.SifException;

public class SOAPRegion extends Region {
	private  SapSOAPAccess _mainAccess;
	private  SapSOAPAccess _failoverAccess;

	//OLCAYYE, 20th April 2007, contractSummary test
	//protected SOAPRegion(RegionConfiguration config) {
	public SOAPRegion(RegionConfiguration config) {
		super(config);

	}


	protected Transaction callMainHost(String packageName, String sapFunctionName, Object request, String regionDisplayName, boolean isLocal) throws SifException {
    	ESLog.debug("Enter");
    	Transaction reply  = null;

		try {
			
	    	ESLog.debug("Sending request to main host (Region: " + config.getRegionName() + ")");
	    	synchronized(initMutex) {
	    	}
	    	long beforeCallExecute=System.currentTimeMillis();
	    	SapSOAPReply sourceReply = _mainAccess.execute(packageName, sapFunctionName, request);
	        long afterCallExecute=System.currentTimeMillis();
            long callExecute= afterCallExecute-beforeCallExecute;
            ESLog.debug("callMainHost - execute(): duration is: " + callExecute);
	
            // clear the error count since everything was ok
			clearMainErrorCounter();
            reply = Transaction.getInstance(config, false, sourceReply, sapFunctionName,regionDisplayName,isLocal);
            		
		} catch(Exception e) {
	    	ESLog.info("EXCEPTION in calling main host: ", e);
	    	if(isValidExceptionForErrorCount(e,true)) {	    		
	    		increaseAndCheckMainErrorCount();
	    		ESLog.info("Main SAP  "+getConfiguration().getRegionName()+" just got a valid exception for error count, it is now "+mainAccessErrorCount);
	    	}
	    	throw mapToSifException(e);
		} finally {
	    	ESLog.debug("Exit");
		}
		return reply;
	}

	/**
	 * Calling the failover host and managing the error count in case
	 * an error occurs
	 * @param sapFunctionName
	 * @param request
	 * @param isLocal 
	 * @return
	 * @throws Exception, SAPException
	 */
	protected Transaction callFailoverHost(String packageName, String sapFunctionName, Object request,String regionDisplayName, boolean isLocal)
			throws SifException {
    	ESLog.debug("Enter");
    	Transaction reply  = null;
    	
		try {
	    	ESLog.debug("Sending request to failover host (Region: " + config.getRegionName() + ")");
	    	synchronized(initMutex) {
	    	}
	    	
	    	long beforeCallExecute=System.currentTimeMillis();
	    	SapSOAPReply sourceReply  = _failoverAccess.execute(packageName, sapFunctionName, request);
	        long afterCallExecute=System.currentTimeMillis();
            long callExecute= afterCallExecute-beforeCallExecute;
            ESLog.debug("callFailoverHost - execute(): duration is: " + callExecute);
	    	
			// clear the error count since everything was ok
			clearFailoverErrorCounter();
			
            long beforeCallCheckForFailoverExpiration=System.currentTimeMillis();
            checkForFailoverExpiration();
	        long afterCallCheckForFailoverExpiration=System.currentTimeMillis();
            long callFailoverHostCheckForFailoverExpiration= afterCallCheckForFailoverExpiration-beforeCallCheckForFailoverExpiration;
            ESLog.debug("callFailoverHost - checkForFailoverExpiration(): duration is: " + callFailoverHostCheckForFailoverExpiration);
				
			reply = Transaction.getInstance(config, true, sourceReply, sapFunctionName,regionDisplayName, isLocal);
		} catch(Exception e) {
	    	ESLog.info("EXCEPTION in calling failover host: ", e);
	    	if(isValidExceptionForErrorCount(e,false)) {
	    		increaseAndCheckFailoverErrorCount();
	    		ESLog.info("Failover SAP "+getConfiguration().getRegionName()+" just got a valid exception for error count, it is now "+failoverAccessErrorCount);
	    	}
	    	throw mapToSifException(e);
		} finally {
	    	ESLog.debug("Exit");
		}
		return reply;
	}

	/**
	 * Checks the execption if we need need to increase the error count.
	 * Returns true if the execption is a valid exception for it.
	 * @param ex
	 * @return
	 */
	protected boolean isValidExceptionForErrorCount(Exception ex, boolean fromMain) {

		if(ex instanceof SapAccessFailureException) {
            // IOException are thrown if the url is not valid
            ESLog.info("We had a SapAccessFailureException: " + ex);
			return true;
		}

		if(ESLog.isDebugLogEnabled())	 ESLog.debug("We had some other exception", ex);
		return false;
	}	
	
    /**
     * mapToSifException
     * @param ex
     * @return
     */
	protected  SifException mapToSifException(Exception ex) {
		if(ex instanceof IOException) {
            return ErrorFactory.getSifException(ErrorFactory.id8001_SYSTEM_NOT_AVAILABLE,ex.getMessage());
		}else if (ex instanceof SapAccessFailureException){
		    return ErrorFactory.getSifException(ErrorFactory.id8001_SYSTEM_NOT_AVAILABLE,ex.getMessage());
		}else if(ex instanceof SifException) {
            // e.g. message errors, etc...
			return (SifException)ex;
		}else {
			return ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Unknown error");
		}
	}

	protected void initConnections() {
    	ESLog.debug("Enter");
		// create access object for main host
    	synchronized(initMutex) {
    		 
	    	// log the used configuration in debug mode
	    	logConfiguration();
	
	    	ESLog.info("Creating main instance for region: " + config.getRegionName());
			_mainAccess = SapSOAPAccess.getInstance("SAP",config.getSoapAccessImplementation(),config.getMainUrl(), 
                    config.getMainUser(), config.getMainPassword(), config.getMainMaxWaitTime(),config.getFailoverModeDuration());
				
	    		
	    	ESLog.debug("main instance: " + _mainAccess);
	
	    	ESLog.info("Creating failover instance for region: " + config.getRegionName());
        	_failoverAccess = SapSOAPAccess.getInstance("SAP",config.getSoapAccessImplementation(),config.getFailoverUrl(), 
                    config.getFailoverUser(), config.getFailoverPassword(), config.getFailoverMaxWaitTime(),config.getFailoverModeDuration()) ; 		
	    	
	    	ESLog.debug("failover instance: " + _failoverAccess);
    	}
    	ESLog.debug("Exit");
	}

	protected boolean isFailoverInstanceAvailable() {
		try {
			return _failoverAccess.isAvailable();
		} catch(Exception e) {
			// Nothing to do. In this case there is really 
			// a problem with the region, so we return false
		}
		return false;
	}

	protected boolean isMainInstanceAvailable() {
		ESLog.debug("SOAPRegion isMainInstanceAvailable: old:"+_mainAccess.isAvailable());
		try {
			Object request = SAPConnectivity.getRequest();
			String packageName = getPackageName(EsConstants.SAP_FUNCTION_NAME_SWOP);
			_mainAccess.execute(packageName,EsConstants.SAP_FUNCTION_NAME_SWOP, request);
			ESLog.debug("SOAPRegion isMainInstanceAvailable: new:true");
			return true;
		} catch(Exception e) {
			// Nothing to do. In this case there is really 
			// a problem with the region, so we return false
			ESLog.error("Error when checking if main instance is available",e);
		}
		ESLog.debug("SOAPRegion isMainInstanceAvailable: new:false");
		return false;
	}

	protected void setFailoverInstanceUnAvailable() {
		try {
			_failoverAccess.setUnAvailable();
			
		} catch(Exception e) {
        	ESLog.info("Failed to set failover unvailability flag");
		}
	}

	protected void setMainInstanceUnAvailable() {
		try {
			_mainAccess.setUnAvailable();
		} catch(Exception e) {
	    	ESLog.info("Failed to set main unvailability flag");
		}
	}

	public String getMainState() {
		return _mainAccess.getMainState();
	}

	public String getFailoverState() {
		return _failoverAccess.getMainState();
	}

	protected String getPackageName(String sapFunctionName) {
		
		if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT)) {
			return EsConstants.CQS_SOAP_PACKAGE_NAME;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT_BYSN)) {
			return EsConstants.CQSBYSN_SOAP_PACKAGE_NAME;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_SWOP)) {
			return EsConstants.SWOP_SOAP_PACKAGE_NAME;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_IBSEARCH)) {
			return EsConstants.IBSEARCH_SOAP_PACKAGE_NAME;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_SUM)) {
			return EsConstants.CQSCS_SOAP_PACKAGE_NAME;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_UNITEVENTHISTORY)) {
			return EsConstants.UNITEVENTHISTORY_SOAP_PACKAGE_NAME;
		}
		
		
		return null;
	}
}
