/*
 * Created on Mar 11, 2005
 */
package com.hp.es.service.orchestration.sap;

import com.hp.es.service.util.ESLog;
import com.hp.ruc.config.ReadOnlyProperties;


/**
 * @author juhank
 *
 * Holds the configuration of the (main and failover) host (URL, user,
 * password for failover) and the region name.
 */
public class RegionConfiguration {

	private final static long DEFAULT_MAX_WAIT_TIME = 3000;
	private final static long DEFAULT_FAILOVER_MODE_DURATION = 60000;
	
    private final static String PROP_SOAP_IMPL = "es.sap.orchestration.regions.soap.implementation";
    private final static String PROP_SOAP_IMPL_DEFAULT = "com.hp.es.service.orchestration.sap.SocketSapSOAPAccess";

    
	private long failoverModeDuration;
	private String regionName;
	// main properties
	private String mainUrl;
	private String mainUser;
	private String mainPassword;
	private long mainMaxWaitTime;
    private long mainConnectionTimeout;
    private int  mainConsecutiveError;
    private long mainConnectionTimeoutCheckPeriod;
    
	// failover properties
	private String failoverUrl;
	private String failoverUser;
	private String failoverPassword;
	private long failoverMaxWaitTime;
    private long failoverConnectionTimeout;
    private int  failoverConsecutiveError;
    private long failoverConnectionTimeoutCheckPeriod;
	private boolean mainEnable = true;
	private boolean failoverEnable = true;
	
	//private String poolImplementation;
	private String soapAccessImplementation;
	private String mainHost;
	private String failoverHost;
	
	private String retunInfoLevel;
	private String retunInfoModifier;
	
	public String getRetunInfoLevel() {
		return retunInfoLevel;
	}

	public void setRetunInfoLevel(String retunInfoLevel) {
		this.retunInfoLevel = retunInfoLevel;
	}

	public String getRetunInfoModifier() {
		return retunInfoModifier;
	}

	public void setRetunInfoModifier(String retunInfoModifier) {
		this.retunInfoModifier = retunInfoModifier;
	}    

	public RegionConfiguration(ReadOnlyProperties prop, String key) {
		storeProperties(prop, key);
	}

	/**
	 * Extracts the regionName form the key
	 * Note: The key has the defined structure:
	 * 		 [PREFIX].[REGION_NAME].[PROPERTY]
	 * @param key
	 * @return
	 */
	private String extractRegionName(String key) {
		// remove everything after the last dot (including the dot)
		String tmpString = key.substring(0, key.lastIndexOf("."));
		// from the new string get everything after the last dot
		return tmpString.substring(tmpString.lastIndexOf(".") + 1);
	}

	/**
	 * Store the needed properties from the configuration file in the object
	 * @param prop
	 * @param key
	 */
	private void storeProperties(ReadOnlyProperties prop, String key) {
		regionName = extractRegionName(key);

		String tempFailoverModeDuration = prop.getProperty("es.sap.orchestration.failover.mode.duration");
		try {
			failoverModeDuration = Long.parseLong(tempFailoverModeDuration);
		} catch(NumberFormatException nfe) {
			ESLog.debug("Error in property: failoverDuration = " +
					tempFailoverModeDuration + ", using default = " + DEFAULT_FAILOVER_MODE_DURATION);
			failoverModeDuration = DEFAULT_FAILOVER_MODE_DURATION;
            ESLog.error("Failover mode duration wrong: " + tempFailoverModeDuration);


		}
		soapAccessImplementation = prop.getProperty(PROP_SOAP_IMPL,PROP_SOAP_IMPL_DEFAULT);
		if ("ASTRO2".equalsIgnoreCase(regionName)) {
		    mainEnable = true;
            failoverEnable = false;

            mainUrl = prop.getProperty(key + "mainUrl");
            if (mainUrl == null)
                ESLog.error("Error in ASTRO2 property: mainUrl");

            mainUser = prop.getProperty(key + "mainUser");
            if (mainUser == null)
                ESLog.error("Error in ASTRO2 property: mainUser");

            mainPassword = prop.getProperty(key + "mainPassword");
            if (mainPassword == null)
                ESLog.error("Error in ASTRO2 property: mainPassword");

            mainMaxWaitTime = getLong(prop, key + "mainMaxWaitTime", DEFAULT_MAX_WAIT_TIME);
        } else if ("snr".equalsIgnoreCase(regionName)) { //SNR properties
		    mainEnable = true;
            failoverEnable = false;

            mainUrl = prop.getProperty(key + "url");
            if (mainUrl == null)
                ESLog.error("Error in SNR property: url");

            mainUser = prop.getProperty(key + "user");
            if (mainUser == null)
                ESLog.error("Error in SNR property: user");

            mainPassword = prop.getProperty(key + "password");
            if (mainPassword == null)
                ESLog.error("Error in SNR property: password");
            
            retunInfoLevel = prop.getProperty(key + "returninfo.level");
            if (retunInfoLevel == null)
                ESLog.error("Error in SNR property: returninfo.level");
            
            retunInfoModifier = prop.getProperty(key + "returninfo.modifier");
            if (retunInfoModifier == null)
                ESLog.error("Error in SNR property: returninfo.modifier");            
            
            mainConnectionTimeout = getLong(prop, key + "connectionTimeout", 0);
            mainMaxWaitTime = getLong(prop, key + "maxWaitTime", DEFAULT_MAX_WAIT_TIME);
            failoverUrl = null;
            failoverUser = null;
            failoverPassword = null;
            failoverEnable = false;
        	
        	
        }else {//standard SAP case
            // main properties
            mainUrl = prop.getProperty(key + "mainUrl");
            mainHost = prop.getProperty(key + "mainHost");
            mainUser = prop.getProperty(key + "mainUser");
            mainPassword = prop.getProperty(key + "mainPassword");
            mainMaxWaitTime = getLong(prop, key + "mainMaxWaitTime", DEFAULT_MAX_WAIT_TIME);
            mainConnectionTimeout = getLong(prop, key + "mainConnectionTimeout", 0);
            mainConsecutiveError = getInteger(prop, key + "mainConsecutiveError", 5);
            mainConnectionTimeoutCheckPeriod = getLong(prop, key + "mainConnectionTimeoutCheckPeriod", 0);
            mainEnable = getBoolean(prop, key + "mainConnectionEnable", true);

            // failover properties
            failoverUrl = prop.getProperty(key + "failoverUrl");
            failoverHost = prop.getProperty(key + "failoverHost");
            failoverUser = prop.getProperty(key + "failoverUser");
            failoverPassword = prop.getProperty(key + "failoverPassword");
            failoverMaxWaitTime = getLong(prop, key + "failoverMaxWaitTime", DEFAULT_MAX_WAIT_TIME);
            failoverConnectionTimeout = getLong(prop, key + "failoverConnectionTimeout", 0);
            failoverConsecutiveError = getInteger(prop, key + "failoverConsecutiveError", 5);
            failoverConnectionTimeoutCheckPeriod = getLong(prop, key + "failoverConnectionTimeoutCheckPeriod", 0);
            failoverEnable = getBoolean(prop, key + "failoverConnectionEnable", true);
        }
	}



	/**
     * @param prop
     * @param key
     */
    private long getLong(ReadOnlyProperties prop, String key, long defaultValue) {
        String tempString = prop.getProperty(key);
        try {
			return Long.parseLong(tempString);
		}
        catch(Exception nfe) {
			ESLog.error("Error in property: " + key + " = " +
					tempString + ", using default = " + defaultValue);
		}
        return defaultValue;
    }
    
    private boolean getBoolean(ReadOnlyProperties prop, String key, boolean defaultValue) {
        String tempString = prop.getProperty(key);
        if(tempString == null  || "".equals(tempString)) {
        	return defaultValue;
        }
		return Boolean.valueOf(tempString).booleanValue();
	}    
    /**
     * @param prop
     * @param key
     */
    private int getInteger(ReadOnlyProperties prop, String key, int defaultValue) {
        String tempString = prop.getProperty(key);
        try {
			return Integer.parseInt(tempString);
		}
        catch(Exception nfe) {
			ESLog.error("Error in property: " + key + " = " +
					tempString + ", using default = " + defaultValue);
		}
        return defaultValue;
    }    
	/**
	 * @return Returns the regionName.
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @return Returns the failoverPassword.
	 */
	public String getFailoverPassword() {
		return failoverPassword;
	}
	/**
	 * @return Returns the failoverUrl.
	 */
	public String getFailoverUrl() {
		return failoverUrl;
	}
	/**
	 * @return Returns the failoverHost.
	 */
	public String getFailoverHost() {
		return failoverHost;
	}
	/**
	 * @return Returns the failoverUser.
	 */
	public String getFailoverUser() {
		return failoverUser;
	}
	/**
	 * @return Returns the mainPassword.
	 */
	public String getMainPassword() {
		return mainPassword;
	}
	/**
	 * @return Returns the mainUrl.
	 */
	public String getMainUrl() {
		return mainUrl;
	}
	/**
	 * @return Returns the mainHost.
	 */
	public String getMainHost() {
		return mainHost;
	}
	/**
	 * @return Returns the mainUser.
	 */
	public String getMainUser() {
		return mainUser;
	}

	/**
	 * @return Returns the failoverMaxWaitTime.
	 */
	public long getFailoverMaxWaitTime() {
		return failoverMaxWaitTime;
	}
	/**
	 * @return Returns the mainMaxWaitTime.
	 */
	public long getMainMaxWaitTime() {
		return mainMaxWaitTime;
	}
	/**
	 * @return Returns the failoverDuration.
	 */
	public long getFailoverModeDuration() {
		return failoverModeDuration;
	}
    
    /**
     * @return Returns the connectionTimeout.
     */
    public long getMainConnectionTimeout() {
        return mainConnectionTimeout;
    }
    /**
     * @return Returns the connectionTimeoutCheckPeriod.
     */
    public long getMainConnectionTimeoutCheckPeriod() {
        return mainConnectionTimeoutCheckPeriod;
    }
    /**
     * @return Returns the failoverConnectionTimeout.
     */
    public long getFailoverConnectionTimeout() {
        return failoverConnectionTimeout;
    }
    /**
     * @return Returns the failoverFonnectionTimeoutCheckPeriod.
     */
    public long getFailoverFonnectionTimeoutCheckPeriod() {
        return failoverConnectionTimeoutCheckPeriod;
    }



	int getFailoverConsecutiveError() {
		return failoverConsecutiveError;
	}

	int getMainConsecutiveError() {
		return mainConsecutiveError;
	}

	public boolean isFailoverEnable() {
		return failoverEnable;
	}

	boolean isMainEnable() {
		return mainEnable;
	}


	public String getSoapAccessImplementation() {
		return soapAccessImplementation;
	}

}
