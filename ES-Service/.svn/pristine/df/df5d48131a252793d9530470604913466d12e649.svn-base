/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSMESSAGE;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.Warnings;

/**
 * Error ID	Error text / description	
 * 901	The UnitList was truncated - There were more units than we have returned in the list (maximum number of units is 100) =>426	
 * 902	Number of OOSes and related Services was truncated =>426
 *
 */
class MetroWarningMapper extends WarningMapper{

	/**
	 * 
	 */
  	MetroWarningMapper(Collection cqsWarnings, String sapRegionDisplayName) {
    	super(cqsWarnings,sapRegionDisplayName);;
    }
	
    /**
     * map
     * @return
     * @throws MappingException
     */
    public Warnings map() throws MappingException {
    	
    	// in case cqs warnings are null, we return null
    	if(_cqsWarnings == null) {
    		return null;
    	}

    	ESLog.debug("Mapping warning ...");
     	Warnings warn = new Warnings();

    	
    	Iterator iterator = _cqsWarnings.iterator();
    	while(iterator.hasNext()) {
    		EIAError se = mapWarning((ZESCQSMESSAGE) iterator.next());
    		if(se != null) {
    			warn.addEIAError(se);
    		}
    	}
    	
    	// in case we don't have any warnings we return null
    	if (warn.getEIAErrorCount() == 0) {
    		return null;
    	}
        return warn;
    }

	/**
	 * @param Zes_cqs_messages_t
	 * @return
	 * @throws MappingException 
	 */
	protected EIAError mapWarning(ZESCQSMESSAGE cqsMessage) throws MappingException {
		
		int errorId =MappingUtils.stringToInt(cqsMessage.getMSGNO());
		
		if(errorId == 901|| errorId == 902) {
			return ErrorFactory.getEIAError(ErrorFactory.id436_SOURCE_SYSTEM_RETURNED_WARNING_OR_ERROR,_sapRegionDisplayName,cqsMessage.getMSGNO().toString(),cqsMessage.getMESSAGE());
		}

		if(errorId == 903) {
			return ErrorFactory.getEIAError(ErrorFactory.id437_SPECIAL_INSTRUCTION_FIELD_TRUNCARED,MappingUtils.stripLeadingDigitsAndBlanks(cqsMessage.getMESSAGE()), MappingUtils.stripLeadingDigitsAndBlanks(cqsMessage.getMESSAGE()));
			
		}

		return null;	
			
	}	
	

}
