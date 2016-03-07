/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/serviceHandler/OperationManager.java 1.17 2004-09-27 17:57:49+02 stefsobe Exp $
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
 * $Log: OperationManager.java,v $
 * Revision 1.17  2004-09-27 17:57:49+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.16  2004-05-08 04:40:54+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.15  2004-05-05 15:39:32+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.14  2004-04-05 17:43:28+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * add isFailover()
 *
 * Revision 1.13  2004-04-05 16:58:39+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * add getFailoverMode()
 *
 * Revision 1.12  2004-02-05 14:48:22+01  lbednari
 * Author: lbednari@schmucknicola.emea.cpqcorp.net ()
 * - property file name change
 *
 * Revision 1.11  2004-01-29 18:05:10+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.10  2003-10-14 18:38:52+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * add ITO log when service is configure to failoverMode=always.
 *
 * Revision 1.9  2003-10-14 17:01:29+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * change enableFailoverState()
 *
 * Revision 1.8  2003-10-14 14:36:26+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * implement different failover modes (never, always, normal)
 *
 * Revision 1.7  2003-08-04 16:49:42+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.6  2003-07-14 15:18:49+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * load time limit for operations from config file and initialize the TransactionMonitor class
 *
 * Revision 1.5  2003-05-27 03:43:37+02  lbednari
 * Author: lbednari@bbnnaid189.bbn.hp.com ()
 * - merged changes from dev5_0C2 branch
 *
 * Revision 1.4  2003-05-12 01:58:04+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.3  2003-04-28 12:27:44+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * update package name
 *
 * Revision 1.2  2003-04-23 15:55:45+02  lbednari
 * Author: lbednari@bbnnaid950.bbn.hp.com ()
 * - using new isClassPathBAsed() method to determine where the config has been loaded from
 *
 * Revision 1.1  2003-04-04 14:58:35+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */

package com.hp.es.service.operations;

import java.util.Enumeration;
import java.util.HashMap;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.config.DynConfigFactory;
import com.hp.ruc.config.ReadOnlyProperties;

/**
 * This class reads the operations from a properties file and provides access
 * to the operation objects. In the properties file all valid operations
 * (public/private) are configured for the services.
 * <p>
 * When the properties file is changed, the configuration is reloaded
 * automatically. No restart of the service is required.
 * <p>
 * Following system properties can be used to change the behavior of the class.
 * Note that these settings cannot be changed at runtime, i.e. they are read
 * when the OperationManager object is created.
 * <p>
 * <table border="1" cellspacing="2">
 * <tr>
 *    <td>com.hp.es.serviceHandler.OperationManager.file</td>
 *    <td>the name of the properties file that contains the operation
 *        settings (default is 'CommonService.properties')</td>
 * </tr>
 * <tr>
 *    <td>com.hp.es.serviceHandler.OperationManager.configReloadInterval</td>
 *    <td>specifies how often (in seconds) the properties file is checked if
 *        something has changed. (default is 60 sec). Zero means that the
 *        file is never checked."</td>
 * </tr>
 * </table>
 * <p>
 * Following properties are supported (in the properties file):
 * <p>
 * <table border="1" cellspacing="2">
 * <tr>
 *    <td>SERVICE.operation.NAME.class</td>
 *    <td>the class that is instantiated to handle the operation NAME
 *        (e.g. 'getContractEntitlement') by the service SERVICE (e.g.
 *        'es', 'acme') </td>
 * </tr>
 * <tr>
 *    <td>SERVICE.operation.NAME.scope</td>
 *    <td>may be either 'private' or 'public' (default is 'public')</td>
 * </tr>
 * </table>
 * @since ES 4.0
 */
public class OperationManager implements ConfigChangeListener {

    /**
     * This method can be used by the service handlers to get an operation
     * that was configured as public operation, i.e. an operation that can
     * be called by the clients of the service.
     * @param operationName the operation specified in the EsRequestComplexType (see the
     *                  getOperation() method of EsRequestComplexType). The OperationManager
     *                  will return an Operation object that can handle
     *                  this type of operation.
     * @return Operation that was configured for this type of request.
     *                  The method return <code>null</code> if no operation was
     *                  configured. In the failover mode, the method will
     *                  return the FailoverOperation.
     * @roseuid 3E6F26F10309
     */
    public Operation getPublicOperation(String operationName) {
        return getOperation(operationName, publicOperations);
    }

    /**
     * This method can be used by the operations to get an another operation
     * that was configured as private or public operation. Private operations
     * cannot be called by the clients of the service but can be used internally.
     * @param operationName the operation specified in the EsRequestComplexType (see the
     *                  getOperation() method of EsRequestComplexType). The OperationManager
     *                  will return an Operation object that can handle
     *                  this type of operation.
     * @return Operation that was configured for this type of request.
     *                  The method return <code>null</code> if no operation was
     *                  configured. In the failover mode, the method will
     *                  return the FailoverOperation.
     */
    public Operation getAnyOperation(String operationName) {
        return getOperation(operationName, allOperations);
    }

    /**
     * The method returns<ul>
     * <li>null - If no operation was configured for the <code>operationName</code>
     *            or if the operation could not be instantiated or initilized.
     * <li>the FailoverOperation - if the failover mode was enabled
     * <li>an object of the configured operation class - in all other cases.
     * </ul>
     */
    private Operation getOperation(String operationName, HashMap operations) {
        if (operationName==null || operationName.length()==0) {
            return null;
        }
        ESLog.debug("Getting operation for "+operationName);
        Operation op = null;
        synchronized(this) {
            op = (Operation)operations.get(operationName);
        }
        
        return op;
    }
    
    /**
     * Get an OperationManager for the given service identified by the
     * <code>servicePrefix</code>. The prefix is used when the operations
     * are initilized from the config file. Only operations configured for that
     * service will be managed by the returned OperationManager.
     * @param servicePrefix unique name for the service in the properties file
     * @return com.hp.es.serviceHandler.OperationManager that manages the
     *            operations for that service. The method may also return
     *            <code>null</code>.
     * @exception java.io.FileNotFoundException when the config file is not available
     * @exception java.io.IOException when the config file is not accessible
     * @roseuid 3E6F32A50384
     */
    public static synchronized OperationManager getInstance(String servicePrefix)
                     throws java.io.FileNotFoundException, java.io.IOException {
        
    	ESLog.debug("Getting instance of Operation Manager for "+ servicePrefix);
    	if (servicePrefix==null || servicePrefix.trim().length()==0) {
            return null;
        }

            OperationManager mgr = (OperationManager)instances.get(servicePrefix);
            if (mgr==null) {
                mgr = new OperationManager(servicePrefix);
                mgr.init();
                instances.put(servicePrefix, mgr);
            }
            return mgr;
    }
    
    /**
     * This method is called by DynConfigFactory when the properties file has
     * changed. If the event would be null, the method does nothing.
     * @param event contains the changed properties
     * @roseuid 3E4A50DF00D2
     */
    public void configChanged(ConfigChangeEvent event) {
        if (event!=null) {
            init(event.getNewConfig());
        }
    }

    /**
     * Private constructor. Use getInstance() method to access the
     * OperationManager objects.
     * @roseuid 3E773E040329
     */
    private OperationManager(String servicePrefix) {
        this.servicePrefix = servicePrefix;

        this.allOperations = new HashMap();
        this.publicOperations = new HashMap();
        Configuration.getInstance().addConfigChangeListener(this);
    }

    /**
     * This method is called only once when an instance of OperationManager
     * is created. It initilizes the access and watching of the properties
     * file.
     */
    private synchronized void init() throws java.io.FileNotFoundException, java.io.IOException {


            DynConfigFactory configFactory = DynConfigFactory.getDynInstance();

            ReadOnlyProperties prop = configFactory.getConfig(propertiesFile);

            if (configReloadInterval>0) {
                if (prop.isClassPathBased()) {
                    configFactory.watchClassPathConfig(propertiesFile, configReloadInterval);
                    configFactory.listenForClassPathConfig(propertiesFile, this);
                } else {
                    configFactory.watchFileSystemConfig(propertiesFile, configReloadInterval);
                    configFactory.listenForFileSystemConfig(propertiesFile, this);
                }
            }

            init(prop);
    }

    /**
     * Initilizes the object from the properties file. See the class description
     * for the supported properties.
     */
    private void init(ReadOnlyProperties prop) {
    	ESLog.debug("OperationManager will be initialized"+ prop);
        if (prop==null) {
        	ESLog.debug("prop is null,OperationManager return.");
            return;
        }

        synchronized(this) {
        	ESLog.debug("start to clear operations hashmap and build new operations hashmap.");
            // contains the maximum execution times in milliseconds for
            // the operations
            HashMap executionTimeLogThreshholds = new HashMap();

            // remove all previous operations
            allOperations.clear();
            publicOperations.clear();
            
            ESLog.debug("finish clear operations hashmap and build new operations hashmap.");
            
            Enumeration enumeration = prop.propertyNames();
            
            ESLog.debug("init enumeration:"+enumeration);
            while (enumeration.hasMoreElements()) {

                String key = (String)enumeration.nextElement();
                
                ESLog.debug("init prop key:"+key);
                ESLog.debug("init prop servicePrefix:"+servicePrefix);
                
                String prefix = servicePrefix+".operation.";

                // find a class for the operation
                if (key.startsWith(prefix) && key.endsWith(".class")) {
                    String opName = key.substring(prefix.length(), key.length()-6);
                    if (opName.length()==0 || opName.indexOf('.')>=0) {
                    	ESLog.error("The parameter should have the format " +
                                     "<service>.operation.<operationName>.class");
                    } else {               	
                        String className = prop.getProperty(key);
                        ESLog.debug("init prop className:"+className);
                        
                        ESLog.debug("OperationManager will create"+ className);
                        try {
                            Class c = Class.forName(className);
                            Operation op = (Operation)c.newInstance();
                            op.init();
                            op.setOperationManager(this);

                            allOperations.put(opName, op);
                            String scope = prop.getProperty(prefix+opName+".scope");
                            if (scope==null || scope.equalsIgnoreCase("public")) {
                                publicOperations.put(opName, op);
                            }

                            String tmp = prefix+opName+".executionTimeLogThreshhold";
                            String value = prop.getProperty(tmp);
                            if (value!=null) {
                                Long milliseconds = null;
                                try {
                                    milliseconds = new Long(value);
                                    executionTimeLogThreshholds.put(opName, milliseconds);
                                } catch (Exception e) {
                                    ESLog.error("The parameter should " +
                                                 "should be numeric. Value ignored");
                                }
                            }
                        } catch (ClassNotFoundException e1) {
                            log(e1, key, className, " Class was not found!");
                        } catch (IllegalAccessException e2) {
                            log(e2, key, className, " Class cannot be accessed! Please check if the class is public.");
                        } catch (ClassCastException e3) {
                            log(e3, key, className, " Class cannot be casted to 'SwopAccass'.");
                        } catch (InstantiationException e4) {
                            log(e4, key, className, " Class cannot be instantiated. Make sure the class is not abstract.");
                        }
                        ESLog.debug("OperationManager created "+ className);
                    }
                }
            } // while

        }
    }


    private static void log(Exception e, String key, String c, String errorText) {
            String text = "Error in properties file '"
                    + propertiesFile + "': The class '"
                    + c + "' (for property '" + key
                    + "') is wrong. " + errorText;
            ESLog.error(text,e);
    }

    /**
     * @return the name of the properties file
     */
    static public String getConfigFile() {
        return propertiesFile;
    }

    // contains the OperationManager objects for the services
    static private HashMap instances = new HashMap();

    // the name of the properties file (must be somewhere in the classpath)
    static private final String propertiesFile =
          System.getProperty("com.hp.es.serviceHandler.OperationManager.file",
                             EsConstants.COMMON_PROPERTIES_FILENAME);

    // how often the config file is checked for modifications
    static private int configReloadInterval;

    static {
        try {
            configReloadInterval = Integer.parseInt(
               System.getProperty(
                "com.hp.es.serviceHandler.OperationManager.configReloadInterval",
                "60"));
        }
        catch (Exception e) {
            configReloadInterval = 60; // 1 minute
        }
    }


    private HashMap allOperations;
    private HashMap publicOperations;
    private String servicePrefix;
/*
    private String failoverMode;
    private FailoverOperation failoverOperation;
    private long failoverEndTime;
    private long failoverDuration;
    public static final String FAILOVER_NEVER  = "never";
    public static final String FAILOVER_ALWAYS = "always";
    public static final String FAILOVER_NORMAL = "normal";
*/
}
