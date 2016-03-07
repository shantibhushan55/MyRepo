package com.hp.es.service.catsAgreement.integration.mapping;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.config.ReadOnlyProperties;

public class WarrantyDeterminationCode implements ConfigChangeListener {
    ReadOnlyProperties _mappingProperties = null; 

    private static WarrantyDeterminationCode _instance = new WarrantyDeterminationCode();
	
	private WarrantyDeterminationCode() {
		super();
		// add the class to the config listener to watch the files WarrantyDeterminationCodeTableForAstro2.properties
        Configuration.getInstance().addConfigChangeListener(EsConstants.WARRANTY_DETERMINATION_CODE_TABLE_FOR_ASTRO2_PROPERTIES_FILENAME, this);
	}

	/*
	 * A method returning the skeleton
	 */
	public static WarrantyDeterminationCode getInstance() {

		return _instance;
		
	}

	/* (non-Javadoc)
	 * @see com.hp.ruc.config.ConfigChangeListener#configChanged(com.hp.ruc.config.ConfigChangeEvent)
	 */
	public void configChanged(ConfigChangeEvent event) {
        if (event != null && event.getNewConfig() != null) {
            ESLog.info("(Re-)load configuration");
            if (EsConstants.WARRANTY_DETERMINATION_CODE_TABLE_FOR_ASTRO2_PROPERTIES_FILENAME.equals(event.getConfigName()))
                _mappingProperties = event.getNewConfig();
        }
    }

	/**
	 * getWarrantyDeterminationCode
	 * @param astro2StartDateType
	 * @return
	 */
	public String getWarrantyDeterminationCode(String astro2StartDateType) {
		if(_mappingProperties == null) {
            return "";
		} else { 
			if(_mappingProperties.getProperty(astro2StartDateType) == null) {
				return "";
			} else {
				return _mappingProperties.getProperty(astro2StartDateType);
			}
		}
	}
	
	/**
	 * getWarrantyDeterminationDescription
	 * @param astro2StartDateType
	 * @return
	 */
	public String getWarrantyDeterminationDescription(String astro2StartDateType) {
		if(_mappingProperties == null) {
            return "";
		} else {
			if(_mappingProperties.getProperty(astro2StartDateType + ".description") == null) {
				return "";
			} else { 
				return _mappingProperties.getProperty(astro2StartDateType + ".description");
			}
		}
	}
	
}
