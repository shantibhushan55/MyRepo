package com.hp.es.service.manufacturingHeaderInformation.orchestration;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.Region;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.SapSOAPAccess;
import com.hp.es.service.orchestration.sap.SapSOAPReply;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.sif.SifException;

public class SnrRegion extends Region {
    private SapSOAPAccess _mainAccess;
    private static SnrRegion _region = null;

    
    
    /*
     * constructor with parameters
     */
    private SnrRegion(RegionConfiguration config) {
        super(config);
    }

    public static synchronized SnrRegion  getInstance(RegionConfiguration config) {
    	if(_region == null) {
    		_region = new SnrRegion(config);
    	}
    	return _region;
    }
    
    protected Transaction callMainHost(String packageName, String sapFunctionName, Object request, String regionDisplayName, boolean isLocal)
            throws SifException {
        ESLog.debug("Enter");
        Transaction reply = null;

        try {

            ESLog.debug("Sending request to main host (Region: " + config.getRegionName() + ")");
            synchronized (initMutex) {
            }
            SapSOAPReply sourceReply = _mainAccess.execute(packageName, sapFunctionName, request);

            reply = Transaction.getInstance(config, false, sourceReply, sapFunctionName, regionDisplayName, isLocal);

        } catch (Exception e) {
            ESLog.info("EXCEPTION in calling main host: ", e);
            throw mapToSifException(e);
        } finally {
            ESLog.debug("Exit");
        }
        return reply;
    }

    /**
     * !!! Not available for SNR !!!
     * 
     * Calling the failover host and managing the error count in case an error occurs
     * 
     * @param sapFunctionName
     * @param request
     * @param isLocal
     * @return
     * @throws Exception,
     *             SAPException
     */
    protected Transaction callFailoverHost(String packageName, String sapFunctionName, Object request, String regionDisplayName, boolean isLocal)
            throws SifException {
        ESLog.debug("Enter");
        try {
            return callMainHost(packageName, sapFunctionName, request, regionDisplayName, isLocal);
        } finally {
            ESLog.debug("Exit");
        }
    }

    /**
     * !!! Not available for SNR !!!
     * 
     * Checks the execption if we need need to increase the error count. Returns true if the
     * execption is a valid exception for it.
     * 
     * @param ex
     * @return
     */
    protected boolean isValidExceptionForErrorCount(Exception ex, boolean fromMain) {
        return false;
    }

    /**
     * mapToSifException
     * 
     * @param ex
     * @return
     */
    protected SifException mapToSifException(Exception ex) {
        if (ex instanceof SifException) {
            // e.g. message errors, etc...
            return (SifException) ex;
        } else {
            return ErrorFactory.getSifException(ErrorFactory.id8001_SYSTEM_NOT_AVAILABLE, "Exception while connecting to SNR", "Unkown Exception class:"
                    + ex.getClass().getName() + ", Message: " + ex.getMessage());
        }
    }

    protected void initConnections() {
        ESLog.debug("Enter");
        // create access object for main host
        synchronized (initMutex) {


            // log the used configuration in debug mode
            logConfiguration();

            ESLog.info("Creating main instance for region: " + config.getRegionName());
            _mainAccess = SapSOAPAccess.getInstance("SNR",config.getSoapAccessImplementation(), config.getMainUrl(), config.getMainUser(), config
                    .getMainPassword(), config.getMainMaxWaitTime(), config.getFailoverModeDuration());

            ESLog.debug("main instance: " + _mainAccess);
        }

        ESLog.debug("Exit");

    }

    /**
     * !!! Not available for SNR !!!
     */
    protected boolean isFailoverInstanceAvailable() {
        return false;
    }

    protected boolean isMainInstanceAvailable() {
        return true;
    }

    /**
     * !!! Not available for SNR !!!
     */
    protected void setFailoverInstanceUnAvailable() {

    }

    protected void setMainInstanceUnAvailable() {
        try {
            _mainAccess.setUnAvailable();
        } catch (Exception e) {
            ESLog.info("Failed to set main unvailability flag");
        }
    }

    public String getMainState() {
        return _mainAccess.getMainState();
    }

    /**
     * !!! Not available for SNR !!!
     */
    public String getFailoverState() {
        return "!!! Not available for SNR !!!";
    }



    protected String getPackageName(String sapFunctionName) {

        if (sapFunctionName.equalsIgnoreCase(EsConstants.FUNCTION_NAME_SNR_MFG)) {
            return EsConstants.SNR_MFG_SOAP_PACKAGE_NAME;
        }
        return null;
    }

}
