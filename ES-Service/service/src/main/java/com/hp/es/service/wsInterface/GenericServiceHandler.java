/*
 * Project: Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/serviceHandler/GenericServiceHandler.java 1.44 2004-09-27 17:57:47+02 stefsobe Exp $
 *
 * Copyright (c) 2002 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 *
 * Revision 1.38  2004-01-29 18:05:07+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.37  2004-01-29 16:12:19+01  lbednari
 * Author: lbednari@schmucknicola.emea.hpqcorp.net ()
 * - added protection against endless failover cycles
 *
 * Revision 1.36  2003-10-14 17:37:26+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * add log
 *
 * Revision 1.35  2003-10-14 16:39:00+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * add message to data payload when sending the failover request fails.
 *
 * Revision 1.34  2003-10-13 11:57:46+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * minor change for payload
 *
 * Revision 1.33  2003-09-26 16:53:24+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * add log methods in order to be able to use different log classes for

 * the GenericServiceHandler
 *
 * Revision 1.32  2003-09-23 16:30:14+02  GERE
 * Author: GERE@dhcp-15-197-232-0.bbn.hp.com ()
 * previous changes removed
 *
 * Revision 1.31  2003-09-23 10:56:18+02  GERE
 * Author: GERE@dhcp-15-197-232-0.bbn.hp.com ()
 * new Counters added to find a performance issue

 * some logs commented out.

 * Should be removed
 *
 * Revision 1.30  2003-08-20 15:44:40+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * move some methods/functionalities from EsServiceHandler to GenericServiceHandler
 *
 * Revision 1.29  2003-08-04 16:49:40+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.28  2003-07-14 15:11:44+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * remove ArmTransaction
 *
 * Revision 1.27  2003-07-09 18:17:51+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * added TX it at end of DataPayload if we render an EIAError
 *
 * Revision 1.26  2003-07-03 13:36:01+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * remove HPSEConstants
 *
 * Revision 1.25  2003-07-01 22:43:19+02  lbednari
 * Author: lbednari@bbnnaid62.bbn.hp.com ()
 * - moved trans ID handling mostly to GenericServiceHandler from EsServiceHandler
 *
 * Revision 1.24  2003-07-01 21:47:20+02  lbednari
 * Author: lbednari@bbnnaid62.bbn.hp.com ()
 * removed call to obsolete method in ESLog (3.0.1 statistics file)
 *
 * Revision 1.23  2003-06-30 17:20:46+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * trying to implement esRequest in error reply, but not finished

 * see WITS 331
 *
 * Revision 1.22  2003-06-18 16:43:43+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * use  ArmTransaction
 *
 * Revision 1.21  2003-06-17 15:01:27+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * use ESLog instead of _notify; remove unused code; make code more readable
 *
 */

package com.hp.es.service.wsInterface;

import com.hp.es.service.operations.OperationManager;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Implements basic service handler tasks like
 * <UL>
 * <LI>maintaining ES metrics data
 * <LI>transformation of caught exceptions into sif error replies
 * </UL>
 * Subclasses have to implement callService and the other abstract methods to
 * insert service specific handling. They have to call the constructor
 * GenericServiceHandler(String, String) in order to initialize the
 * GenericServiceHandler properly.
 * @author Laslo Bednarik
 * @since 3.0
 * 
 */

// We don't need to immplement ServiceHandler anymore
//abstract public class GenericServiceHandler implements ServiceHandler, ConfigChangeListener {
abstract public class GenericServiceHandler {

    /** String for getting file revision to appear in out put of "what" command on UX */
    

    private String serviceHandlerPrefix;
    private String serviceHandlerName;
    private String serviceHandlerMajorVersion;
    private String serviceHandlerMinorVersion;
    
    protected OperationManager operationManager;
    
    /**
     * This constructor needs to be used by the subclasses to initialize
     * the GenericServiceHandler!
     * @param name Name of the service handler
     * @param prefix The prefix in the Common.properties file
     */
    protected GenericServiceHandler(String name, String prefix, String majorVersion,String minorVersion) {
        serviceHandlerName = name;
        serviceHandlerPrefix = prefix;
        serviceHandlerMajorVersion = majorVersion;
        serviceHandlerMinorVersion = minorVersion;
    }

    /**
     * This method will be called by the SIF to initialize
     * the service.
     */
    final public synchronized void init() {
        ESLog.info("Initialization of "+ serviceHandlerName);

        try {
        	ESLog.debug("Operation manager will be loaded and we will keep an handle on it.");
            operationManager = OperationManager.getInstance(serviceHandlerPrefix);
        }
        catch (Exception e) {
        	
            ESLog.error("Cannot read config file "+OperationManager.getConfigFile(), e);
            
        }
    }

    /**
     * helper method to access the Operation manager. If the operation manager was
     * not yet initialized (in the init() method, this method throws an exception.
     * @return the current operation manager for the current service handler
     * @throws SifException if operation manager is not available
     */
    protected OperationManager getOperationManager() throws SifException {
        if (operationManager == null) {
            ESLog.error("The OperationManager is not available.");
            throw ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,
                "The OperationManager is not available in "
                    + "OperationManager|getOperationManager");
        }
        return operationManager;
    }

    /**
     * Receives the request XML message and has to produce the reply XML message.
     * @param EsRequest the request
     * @param transaction ID - unique ID within any Run of the application
     * @param handler
     * @return String containing the XML reply
     * @throws SifException
     */
    abstract protected EsReply callService(EsRequestComplexType request, String transactionID, MetricsHandler handler)
    throws SifException;

 

 
    /**
     * This method should validate if all input parameter are meaningful and
     * complete on a text based layer (i.e. prevent 32nd March 2003).
     * When this method doesn't throw an exception, we should
     * be able to process the request.<br>
     * @param rawRequestXML the request (pure XML string) that was sent from the client
     * @param metricsHandler
     * @throws SifException when the parameter of the request are not complete
     *                      or not meaningful, i.e. when the request cannot
     *                      be handled by the operation
     */
    protected final void verifyRequest(EsRequestComplexType rawRequest, MetricsHandler metricsHandler) throws SifException {
    	// WE ARE not anymore in XML at this level and the check are not possible anymore
    	
    	/* MetricsEntry entry = null;
        if (metricsHandler != null) {
            entry = metricsHandler.startEntry("GenericServiceHandler.verifyRequest");
        }

        try {
            if (rawRequestXML != null) {
                // this matcher catches all date fields out of the request
                RegExDateMatcher matcher = new RegExDateMatcher();
                // SDF for american date
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                // fail for incorrect dates, i.e. 32nd MAR 2003
                sdf.setLenient(false);
                String [] dates = matcher.match(rawRequestXML);
                // maybe we do not have dates in the request at all...
                if (dates != null) {
                    for (int i=0; i<dates.length; i++) {
                        try {
                            sdf.parse(dates[i]);
                        } catch (Exception ex) {
                            throw ErrorFactory.getSifException(ErrorFactory.id120_INVALID_REQUEST, "invalid date: " + dates[i] + ": " +  ex.getMessage());
                        }
                    }
                }
            }
        } finally {
            if (entry != null)
                entry.actionDone();
        }
        */
    }

	public String getServiceHandlerMajorVersion() {
		return serviceHandlerMajorVersion;
	}

	public String getServiceHandlerMinorVersion() {
		return serviceHandlerMinorVersion;
	}

	public String getServiceHandlerName() {
		return serviceHandlerName;
	}

	public String getServiceHandlerPrefix() {
		return serviceHandlerPrefix;
	}

 
}