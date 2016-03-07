/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.Collection;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.Warnings;

/**
 * Error ID	Error text / description	
 * 901	The UnitList was truncated - There were more units than we have returned in the list (maximum number of units is 100) =>426	
 * 902	Number of OOSes and related Services was truncated =>426
 *
 */
abstract public class WarningMapper {

	protected Collection _cqsWarnings;
	protected String _sapRegionDisplayName;
	

	/**
	 * 
	 */
	public WarningMapper(Collection cqsWarnings, String sapRegionDisplayName) {
    	_cqsWarnings = cqsWarnings;
    	_sapRegionDisplayName = sapRegionDisplayName;
    }
	
    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract public Warnings map() throws MappingException;

    
    /**
     * getInstance - decided in which mode we are JCO or SOAP/Castor
     * @param cqsWarnings
     * @param sapRegionDisplayName
     * @return
     */
	public static WarningMapper getInstance(Collection cqsWarnings, String sapRegionDisplayName) {
            return new MetroWarningMapper(cqsWarnings, sapRegionDisplayName);
	}    
}
