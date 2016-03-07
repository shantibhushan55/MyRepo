/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/util/EsConfiguration.java 1.7 2004-09-27 17:57:43+02 stefsobe Exp $
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
 * $Log: EsConfiguration.java,v $
 */
package com.hp.es.service.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.hp.es.constants.EsConstants;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.config.DynConfigFactory;
import com.hp.ruc.config.ReadOnlyProperties;


/**
 * So far many classes have to read data from properties files and
 * have to make sure that certain settings are available. This functionality
 * should be moved into one single class.
 */
public class Configuration  {

    static private final int PROPS_RELOAD_SECS = 60; // check every 60 seconds

   

    // keeping track of all config files we already have at least one listener for
    private Set<String> alreadyWatching = (Set<String>)java.util.Collections.synchronizedSet(new HashSet<String>());


    /**
     * @return the EsConfiguration object (singleton).
     */
    public static Configuration getInstance() {
        // synchronization is no issue for performance - this method is
        // only called from the startup class and from static init blocks
        // of classes that want to make sure that everything is set up
        // for SSL
        synchronized (Configuration.class) {
            if (instance == null) {
                instance = new Configuration();
            }
        }
        return instance;
    }

    static private Configuration instance = null;

    private Configuration() {
    }

    /**
     * The method registers the ConfigChangeListener for the main config file.
     * Directly after the registration it calls the method configChanged() from
     * the ConfigChangeListener, i.e. the ConfigChangeListener is initialized
     * immediately.
     * @param listener
     */
    public void addConfigChangeListener(ConfigChangeListener listener) {
        addConfigChangeListener(EsConstants.ES_PROPERTIES_FILENAME, listener);
   }

    /**
     * The method registers the ConfigChangeListener for the main config file.
     * Directly after the registration it calls the method configChanged() from
     * the ConfigChangeListener, i.e. the ConfigChangeListener is initialized
     * immediately.
     * @param listener
     */
    public void addConfigChangeListener(String configName, ConfigChangeListener listener) {
        if (listener!=null) {

            try {
	            DynConfigFactory dcf = DynConfigFactory.getDynInstance();
	            ReadOnlyProperties conf = dcf.getConfig(configName);

	            // start watching when it is accessed the first time
	            if (! alreadyWatching.contains(configName)) {
                    if (conf.isClassPathBased()) {
                        dcf.watchClassPathConfig(
                                configName,
                                PROPS_RELOAD_SECS);
                    }
                    else {
                        dcf.watchFileSystemConfig(
                                configName,
                                PROPS_RELOAD_SECS);
                    }
                    alreadyWatching.add(configName);
                }

	            if (conf.isClassPathBased()) {
	                dcf.listenForClassPathConfig(configName, listener);
	            }
	            else {
	                dcf.listenForFileSystemConfig(configName, listener);
	            }

	            // Maybe the config was already watched by some other class and therefore
	            // there will be no initial change event sent to us - make sure we are
	            // initialized anyway...
	            ConfigChangeEvent event = new ConfigChangeEvent(configName, conf, conf, true);
	            listener.configChanged(event);
            }
            catch (IOException e) {
            	ESLog.error("Caught a throwable while loading configuration",e);
            }
        }
    }
    /**
     * get ReadOnlyProperties form config file.the ReadOnlyProperties do not refresh 
     * when config file change
     * @param configName
     * @return
     */
    public ReadOnlyProperties getProperties(String configName){
      DynConfigFactory configFactory = DynConfigFactory.getDynInstance();
      ReadOnlyProperties prop = null;
      try {
              //DynConfigFactory has already cache the ReadOnlyProperties 
              prop = configFactory.getConfig(configName);
      } catch (IOException e) {
    	  ESLog.error("Cannot load property");
      }
      return prop;
    }    
    
    /**
     * return default ReadOnlyProperties(for ES_PROPERTIES_FILENAME = "EntitlementService.properties")
     * @return
     */
    public ReadOnlyProperties getProperties() {              
          return getProperties(EsConstants.ES_PROPERTIES_FILENAME);
    }    

}
