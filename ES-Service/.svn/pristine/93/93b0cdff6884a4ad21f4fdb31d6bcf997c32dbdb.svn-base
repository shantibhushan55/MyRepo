
package com.hp.es.service.unitEventHistory.integration.mapping;

import java.util.Iterator;

import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWTYERROR;
import com.hp.es.service.unitEventHistory.orchestration.UnitEventHistoryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;

/**
 * @author BURRELLWB
 */
class MetroWarningMapper extends WarningMapper {

	/**
	 * @param request
	 * @param transaction
	 */
	public MetroWarningMapper(EsRequestComplexType request, UnitEventHistoryTransaction transaction) {
		super(request, transaction);
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.unitEventHistory.integration.mapping.WarningMapper#map()
	 */
	public Warnings map() throws MappingException {

		// in case Unit Event History warnings are null, we return null
    	if(!_transaction.isSourceSystemWarnings()) {
    		return null;
    	}
    	
     	ESLog.debug("Mapping warnings ...");
     	Warnings warnings = new Warnings();
    	
    	Iterator iterator = _transaction.getSourceSystemWarnings().iterator();
    	while(iterator.hasNext()) {
    		EIAError eiaError = mapWarning((ZWTYERROR) iterator.next());
    		if(eiaError != null) {
    			warnings.addEIAError(eiaError);
    		}
    	}
    	// in case we don't have any warnings we return null
    	if (warnings.getEIAErrorCount() == 0) {
    		return null;
    	}
        return warnings;
	}

	/**
	 * @param zwtyerrortab
	 * @return
	 */
	protected EIAError mapWarning(ZWTYERROR uehWarning) {
		// 1013
		if(uehWarning.getID().equals("1013")) {
            return ErrorFactory.getEIAError(ErrorFactory.id408_UNIT_LIST_TRUNCATED); 
		}
		// 1XXX
		if(uehWarning.getID().startsWith("1")) {
			return ErrorFactory.getEIAError(ErrorFactory.id436_SOURCE_SYSTEM_RETURNED_WARNING_OR_ERROR, 
					_transaction.getRegionDisplayName(), uehWarning.getID(), uehWarning.getMESSAGE()); 
		}
		// not a warning, will not be mapped
		return null; 
	}		
}
