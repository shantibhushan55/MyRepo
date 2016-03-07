/*
 * Created on Jul 14, 2006
 */
package com.hp.es.service.ibSearch.integration.mapping;

import java.util.Iterator;

import com.hp.es.service.ibSearch.orchestration.IBSearchTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH.ZWTYERROR;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;

/**
 * @author JUHANK
 */
public class MetroWarningMapper extends WarningMapper {

	/**
	 * @param request
	 * @param transaction
	 */
	public MetroWarningMapper(EsRequestComplexType request, IBSearchTransaction transaction) {
		super(request, transaction);
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.ibSearch.integration.mapping.WarningMapper#map()
	 */
	public Warnings map() throws MappingException {

		// in case ibsearch warnings are null, we return null
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
	private EIAError mapWarning(ZWTYERROR ibWarning) {
		// 1013
		if(ibWarning.getID().equals("1013")) {
            return ErrorFactory.getEIAError(ErrorFactory.id408_UNIT_LIST_TRUNCATED); 
		}
		// 1XXX
		if(ibWarning.getID().startsWith("1")) {
			return ErrorFactory.getEIAError(ErrorFactory.id436_SOURCE_SYSTEM_RETURNED_WARNING_OR_ERROR, 
					_transaction.getRegionDisplayName(), ibWarning.getID(), ibWarning.getMESSAGE()); 
		}
		// not a warning, will not be mapped
		return null; 
	}		
}
