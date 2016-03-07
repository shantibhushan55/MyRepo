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
import java.util.HashMap;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
/**
 * 101	Incorrect Contract Identifier Type provided => 201	
 * 102	Incorrect Check Date provided - Allowed range: -90 days/+1day around current date => 201	
 * 104	Mandatory Contract Identifier has not  been provided => 200
 * 105	Invalid ISO Country Code provided	=> 201
 * 108	Mandatory Service Agreement ID  has not  been provided	=> 201
 * 201	No entries found	=> 300
 * 202	Found Contract XXXXX  is invalid - No ISO Country Code for ProductShipTo Location exists => 237	
 * 899	Internal error - Any unanticipated error occurred during the processing of the request	=> 434
 */

public abstract class CSErrorMapper {

	protected Collection _cqsErrors;
	protected EsRequestComplexType _request;
	protected String _sapRegionDisplayName;
	
	protected final static HashMap  _errorIdMap = new HashMap();
	protected final static HashMap  _parameterTypeMap = new HashMap();
	
	static {
		
        _errorIdMap.put("107","201");
        _parameterTypeMap.put("107","ServiceableProductsOfferList");

		_errorIdMap.put("101","201");
		_parameterTypeMap.put("101","ContractIdentifierType");
		
		_errorIdMap.put("102","201");
		_parameterTypeMap.put("102","EntitlementCheckDate");
		
		
		_errorIdMap.put("105","201");
		_parameterTypeMap.put("105","IsoCountryCode");
		
		
		_errorIdMap.put("108","200");
		_parameterTypeMap.put("108","Mandatory parameter is missing");

		_errorIdMap.put("201","300");
		//_parameterTypeMap.put("201",null);
		_parameterTypeMap.put("201","No data found");
		
		_errorIdMap.put("202","237");
		_parameterTypeMap.put("202",null);		

		_errorIdMap.put("899","224");
		_parameterTypeMap.put("899","All Source Systems are not available");
	}		
	

	/**
	 * 
	 */
    protected CSErrorMapper(Collection cqsErrors, EsRequestComplexType request, String sapRegionDisplayName) {
    	_cqsErrors = cqsErrors;
    	_request = request;
    	_sapRegionDisplayName = sapRegionDisplayName;
    }

    
    public static  CSErrorMapper getInstance(Collection cqsErrors, EsRequestComplexType request, String sapRegionDisplayName) {

            return new MetroCSErrorMapper(cqsErrors, request, sapRegionDisplayName);

        
    }
    
    
    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract public ArrayList map() throws MappingException; 

    
    protected abstract SifException mapError(Object cqsMessage);

}
