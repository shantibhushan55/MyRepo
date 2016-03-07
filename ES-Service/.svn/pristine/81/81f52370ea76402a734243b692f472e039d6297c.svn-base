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

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSMESSAGE;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.Warnings;

/**
 * @author yesilyur
 *
 */
public class MetroCSWarningMapper extends CSWarningMapper{

	/**
	 * 
	 */
	MetroCSWarningMapper(Collection cqsWarnings, String sapRegionDisplayName) {
    	super(cqsWarnings,sapRegionDisplayName);;
	}

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
	 * @param Zes_cqs_message
	 * @return
	 * @throws MappingException 
	 */
	protected EIAError mapWarning(ZESCQSMESSAGE cqsMessage) throws MappingException {
		
		int errorId =MappingUtils.stringToInt(cqsMessage.getMSGNO());
		
		// ContractSummary: SRS: 5.3.4.2 Warning Messages should be only logged!
		if(errorId == 901|| errorId == 902) {
			EIAError eiaError = ErrorFactory.getEIAError(ErrorFactory.id436_SOURCE_SYSTEM_RETURNED_WARNING_OR_ERROR,_sapRegionDisplayName,cqsMessage.getMSGNO().toString(),cqsMessage.getMESSAGE());
			String errID = "WARNING ID: "+eiaError.getErrorID();
			String errMsg = ", TEXT: "+eiaError.getErrorText();
			String payLoad = ", PAYLOAD: "+eiaError.getDataPayLoad();
			String warnMsg =errID+ errMsg + payLoad;
			ESLog.info(warnMsg);
			//return ErrorFactory.getEIAError(ErrorFactory.id436_SOURCE_SYSTEM_RETURNED_WARNING_OR_ERROR,_sapRegionDisplayName,cqsMessage.getMSG_NO().toString(),cqsMessage.getMESSAGE());
		}
		return null;	
	}	
}
