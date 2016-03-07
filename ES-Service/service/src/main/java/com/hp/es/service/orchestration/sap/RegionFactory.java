/*
 * Created on Mar 9, 2005
 */
package com.hp.es.service.orchestration.sap;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.config.ReadOnlyProperties;

/**
 * @author juhank
 *
 * The RegionFactory produces and stores the Region objects which are used by
 * the orchestration. It also monitors the configuration file and in case of a change of the
 * related properties it destroys and recreates all the Region objects.
 *
 */
public class RegionFactory implements ConfigChangeListener {

    private final static String PROP_PREFIX = "es.sap.";
    private final static String PROP_REGION_LIST = "es.sap.orchestration.regions";
    private final static String REGION_LIST_DEFAULT = "AM,EMEA,AP";
    
    private final static String PROP_LOCAL_REGION = "es.sap.orchestration.regions.localregion";
    private final static String REGION_LOCAL_DEFAULT = "AM";
    
    private final static String PROP_REGION_IMP = "es.sap.orchestration.regions.accessmethod";
    private final static String REGION_IMP_DEFAULT = "SOAP_METRO";
    


    
    static private RegionFactory instance = null;

    private ArrayList _regionNames = new ArrayList();
    private Map _regionConfigurations = new HashMap();
    private Map _regions = new HashMap();
    private String _localRegionName = null;
    private Map _countryOfServiceMapping = new HashMap();
    private Map _AmericasCountries = new HashMap();

  // private String _regionImpl = null;




    private RegionFactory(){
        Configuration.getInstance().addConfigChangeListener(this);
        Configuration.getInstance().addConfigChangeListener(EsConstants.COUNTRY_OF_SERVICE_MAPPING_FILE, this);
        Configuration.getInstance().addConfigChangeListener(EsConstants.AMERICASCOUNTRIES_PROPERTIES_FILENAME, this);
	}

    /**
     * Returning the singleton
     * @return
     */
    public static synchronized RegionFactory getInstance() {
        if (instance == null) {
            ESLog.debug("Creating singleton instance for RegionFactory");
            instance = new RegionFactory();
        }
        return instance;
    }

	/**
	 * Create all regions
	 * Note the local region will be part of the regions. It doesn't need 
	 * to be create separately 
	 */
	private void createRegions() {
		synchronized(this) {
            // get rid of old connections
			ESLog.info("Creating regions");
            _regions.clear();
            // create new ones
            for (int i=0; i<_regionNames.size(); i++) {
                String regionName = (String)_regionNames.get(i);
    			ESLog.debug("Creating region " + regionName);
    			Region region = null;
			    region = new SOAPRegion((RegionConfiguration)(_regionConfigurations.get(regionName)));                
                _regions.put(regionName, region );
            }
		}
	}

	/**
     * Modifies all 3 reagions.
	 * Note the local region will be part of the regions. It doesn't need 
	 * to be create separately 
     */
    private void modifyRegions() {
		synchronized(this) {
			ESLog.info("Modifying regions");
            for (int i=0; i<_regionNames.size(); i++) {
                String thisRegion = (String)_regionNames.get(i);
    			ESLog.debug("Modifying region " + thisRegion);
                Region region = (Region) (_regions.get(thisRegion));
                RegionConfiguration config = (RegionConfiguration) (_regionConfigurations.get(thisRegion));
                region.modify(config);
            }
		}
    }

    /**
     * Adds all regions to an ArrayList and returns it.
     * @return regionList
     */
	public ArrayList getAvailableRegions() {
    	ESLog.debug("Returning ALL regions in an ArrayList");
	    ArrayList regionList = new ArrayList();
        for (int i=0; i<_regionNames.size(); i++) {
            regionList.add(_regions.get(_regionNames.get(i)));
        }
		return regionList;
	}
	
    /**
     * Returns the local region
     * @return Region
     */
	public Region getLocalRegion() {
    	ESLog.debug("Returning the local region: " + _localRegionName);
    	return (Region) _regions.get(_localRegionName);
	}

    /**
     * Returns the local region name
     * @return Region
     */
	public String getLocalRegionName() {
    	return _localRegionName;
	}

	/**
     * Returns the country of service region for the specified country code
     * @return Region
     */
	public Region getCountryOfServiceRegion(String countryCode) {
    	ESLog.debug("Returning the country of service region for country: " + countryCode);
		return (Region) _regions.get(lookupRegionName(countryCode));
	}
	
	/**
	 * Gets the region Name for the specified country code. The country code
	 * is checked in the CountryOfServiceMapping.properties
	 * @param countryCode
	 * @return
	 */
	public String lookupRegionName(String countryCode) {
    	ESLog.debug("Input country code: " + countryCode);
    	if(_countryOfServiceMapping.isEmpty()) {
			ESLog.error("The Country of Service Mapping has not been loaded. " + 
					"Please check whether the file is available or not. The value 'AM' will be returned.");
			return "AM";
    	}
    	String regionName = (String)_countryOfServiceMapping.get(countryCode);
		if(regionName == null || "".equals(regionName)) {
			regionName = (String)_countryOfServiceMapping.get("Default");
	    	ESLog.debug("The specified country code does not map to a region. " +
	    			"The default region name is used: " + regionName);
		} else {
			ESLog.debug("Found RegionName: " + regionName);
		}
		return regionName;
	}
	
	/**
	 * Gets the countrie Name for the specified country code. The country code
	 * is checked in the AmericasCountries.properties
	 * @param countryCode
	 * @return
	 */
	public String lookupAmericasCountries(String countryCode) {
    	ESLog.debug("Input country code: " + countryCode);
    	if(_AmericasCountries.isEmpty()) {
			ESLog.error("The Country of Service Mapping has not been loaded. " + 
					"Please check whether the file is available or not. The value 'AM' will be returned.");
			return null;
    	}
    	String countryName = (String)_AmericasCountries.get(countryCode);
		if(countryName == null || "".equals(countryName)) {
			return null;
		} else {
			ESLog.debug("Found countryName: " + countryName);
		}
		return countryName;
	}
	
    /**
     * Returns the specified region
     * @return Region
     */
	public Region getRegionByName(String regionName) {
    	ESLog.debug("Returning the region: " + regionName);
    	return (Region) _regions.get(regionName);
	}
	
	
	//-------------------------------------------------
	// DO WE REALLY NEED TO RETURN THE REGION NAMES?
	
    /**
     * Adds all regions to an ArrayList and returns it.
     * @return regionList
     */
	public ArrayList getAvailableRegionsName() {
		return _regionNames;
	}

    /**
     * OBSOLETE
     * Adds all regions to an ArrayList and returns it.
     * @return regionList
     */
	/*
	public String getLocalRegionName() {
		return _localRegionName;
	}
	*/
	
	// ------------------------------------------------
	
	/**
	 * @see com.hp.ruc.config.ConfigChangeListener#configChanged(com.hp.ruc.config.ConfigChangeEvent)
	 * Monitor config file
	 */
	public void configChanged(ConfigChangeEvent event) {
		// check if we have a new configuration
        if (event == null || event.getNewConfig() == null) {
        	return;
        }
        
        ESLog.debug("Received config change event for: " + event.getConfigName());
        
        
		// if the country of service mapping has changed
		if(EsConstants.COUNTRY_OF_SERVICE_MAPPING_FILE.equalsIgnoreCase(event.getConfigName())) {
            ESLog.info("(Re-)load configuration: " + event.getConfigName());
			// clear the mapping map
            _countryOfServiceMapping.clear();
            ReadOnlyProperties config = event.getNewConfig();

            Enumeration e = config.propertyNames();
            int counter = 0;
            while(e.hasMoreElements()) {
                String name = (String) e.nextElement();
                _countryOfServiceMapping.put(name, config.getProperty(name));
                counter++;
            }
            ESLog.debug("Loaded " + counter + " country of service mappings");
		} else if (EsConstants.AMERICASCOUNTRIES_PROPERTIES_FILENAME.equalsIgnoreCase(event.getConfigName())) {
            ESLog.info("(Re-)load configuration: " + event.getConfigName());
            // clear the mapping map
            _AmericasCountries.clear();
            ReadOnlyProperties config = event.getNewConfig();

            Enumeration e = config.propertyNames();
            int counter = 0;
            while (e.hasMoreElements()) {
                String name = (String) e.nextElement();
                if (EsConstants.AMS_COUNTRIES.equalsIgnoreCase(config.getProperty(name))) {
                    _AmericasCountries.put(name, name);
                    counter++;
                }
            }
            ESLog.debug("Loaded " + counter + " Americas countries");

		// if the region configuration has changed 
		} else {
            ESLog.info("(Re-)load configuration: " + event.getConfigName());
            ReadOnlyProperties config = event.getNewConfig();

            // get the region names
            _regionNames.clear();
            String regionDefString = config.getProperty(PROP_REGION_LIST, REGION_LIST_DEFAULT);
            ESLog.info("Found Regions: " + regionDefString);
            StringTokenizer st = new StringTokenizer(regionDefString, ",");
            while (st.hasMoreTokens()) {
                String singleRegion = st.nextToken().trim();
                ESLog.debug("Region: " + singleRegion);
                _regionNames.add(singleRegion);
            }
            
            // get the local region name
            _localRegionName = config.getProperty(PROP_LOCAL_REGION, REGION_LOCAL_DEFAULT);
            
            //_regionImpl =config.getProperty(PROP_REGION_IMP, REGION_IMP_DEFAULT);

            // get all configurations
            _regionConfigurations.clear();
            for (int i=0; i<_regionNames.size(); i++) {
                String thisRegionName = (String)_regionNames.get(i);
                ESLog.info("Reading config for region " + thisRegionName);
                RegionConfiguration regionConfig = new RegionConfiguration(
                    config, PROP_PREFIX + thisRegionName + ".");
                _regionConfigurations.put(thisRegionName, regionConfig);
            }

            // create/update region objects
            if (_regions.isEmpty()) {
                createRegions();
            } else {
                modifyRegions();
            }
		}
	}


	
}
