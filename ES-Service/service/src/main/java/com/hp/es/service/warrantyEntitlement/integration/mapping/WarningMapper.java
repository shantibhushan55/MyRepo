/*
 * Created on Mar 14, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.Iterator;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.orchestration.WarrantyTransaction;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.sif.SifException;

/**
 * @author juhank
 */
abstract class WarningMapper {
    protected EsRequestComplexType _request;
    protected WarrantyTransaction _transaction;

    WarningMapper(EsRequestComplexType request, WarrantyTransaction transaction) {
    	_request = request;
    	_transaction = transaction;
    }

    /**
     * map
     * @return
     * @throws MappingException
     */
    Warnings map() throws MappingException {
    	/*
    	 * TODO: add snr working
    	 */
    	if(!_transaction.isSourceSystemWarnings()) {
    		return null;
    	}
    	
     	ESLog.debug("Mapping warnings ...");
     	Warnings warnings = new Warnings();


		
    	Iterator iterator = _transaction.getSourceSystemWarnings().iterator();
    	while(iterator.hasNext()) {
    		EIAError eiaError = mapWarning(iterator.next());
    		if(eiaError != null) {
    			warnings.addEIAError(eiaError);
    		}
    	}
    	// check if we have no warnings, then we will return
    	// null, that we don't have any tag in the XML reply
    	if(warnings.getEIAErrorCount() == 0) {
    		return null;
    	} else {
    		return warnings;
    	}
    }

    
    protected abstract EIAError mapWarning(Object swopWarning);

	abstract EIAError getWarning420();
	abstract EIAError getWarning441();
	abstract EIAError getWarning440(String parentBundleHpSerialNumber,String parentBundleHpProductId);
	abstract EIAError getWarning434(SifException se) ;
	
	public static WarningMapper getInstance(EsRequestComplexType request, WarrantyTransaction transaction) {

            return new MetroWarningMapper(request, transaction);
	}


    
}
