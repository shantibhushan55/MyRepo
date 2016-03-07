/*
 * Project: HPS Entitlement Service - Mercury Integration
 *
 * Copyright (c) 2007 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * Revision 1.0  
 * Author: olcay.yesilyurt@hp.com
 * Initial revision
 *
 */
package com.hp.es.service.contractSummary.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSMESSAGE;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public class MetroCSErrorMapper extends CSErrorMapper {

	/**
	 * 
	 */
	protected MetroCSErrorMapper(Collection cqsErrors, EsRequestComplexType request, String sapRegionDisplayName) {
    	super(cqsErrors, request, sapRegionDisplayName);
	}

	
	
	public ArrayList map() throws MappingException {
    	if(_cqsErrors == null) {
    		return null;
    	}
    	
     	ESLog.debug("Mapping errors ...");
     	ArrayList eiaErrors = new ArrayList();
    	
    	Iterator iterator = _cqsErrors.iterator();
    	while(iterator.hasNext()) {
    		SifException se = mapError((ZESCQSMESSAGE) iterator.next());
    		if(se != null) {
    			eiaErrors.add(se);
    		}
    	}
        return eiaErrors;
	}

	
    protected  SifException mapError(Object cqsMessage) {

    	return mapError((ZESCQSMESSAGE) cqsMessage);
    }
    
    
    
	/**
	 * @param ZESCQSMESSAGE
	 * @return
	 */
	protected SifException mapError(ZESCQSMESSAGE cqsMessage) {
		String errorId =cqsMessage.getMSGNO().toString();
		String mappedId =(String) _errorIdMap.get(errorId);
		
		int sifErrorId = Integer.parseInt(mappedId);
		if((mappedId != null) && (sifErrorId != ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE)) {
			String reason = (String) _parameterTypeMap.get(errorId);
			if(reason != null) {
				return ErrorFactory.getSifException(sifErrorId,reason);
			}else {
				return ErrorFactory.getSifException(sifErrorId);
			}
		}


		return ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE,_sapRegionDisplayName);
			
	}    

}
