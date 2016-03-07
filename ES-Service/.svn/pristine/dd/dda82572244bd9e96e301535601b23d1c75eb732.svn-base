/*
 * Created on Mar 14, 2006
 */
package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * 101	Incorrect Contract Identifier Type provided => 201
 * 102	Incorrect Check Date provided - Allowed range: -90 days/+1day around current date => 201
 * 103	Mandatory Serial Number has not  been provided	=> 200
 * 104	Mandatory Contract Identifier has not  been provided => 200
 * 105	Invalid ISO Country Code provided	=> 201
 * 106	Invalid MaxOOSesNo provided. Allowed range: 0 - 9999, or empty for no limitation => 201
 * 107   Parameter contains invalid data: &1 (&2) =>201 (Added since ES 9.0.5 PWA)
 * 108	Mandatory Service Agreement ID  has not  been provided	=> 201
 * 201	No entries found	=> 300
 * 202	Found Contract XXXXX  is invalid - No ISO Country Code for ProductShipTo Location exists => 237
 * 899	Internal error - Any unanticipated error occurred during the processing of the request	=> 434
 */
public abstract class ErrorMapper {



	protected Collection<?> _cqsErrors;
	protected EsRequestComplexType _request;
	protected String _sapRegionDisplayName;

	protected final static HashMap<String, String>  _errorIdMap = new HashMap<String, String>();
	protected final static HashMap<String, String>  _parameterTypeMap = new HashMap<String, String>();


	static {
		_errorIdMap.put("101","201");
		_parameterTypeMap.put("101","ContractIdentifierType");

		_errorIdMap.put("102","201");
		_parameterTypeMap.put("102","EntitlementCheckDate");

		_errorIdMap.put("103","200");
		_parameterTypeMap.put("103","Serial Number must be supplied.");

		_errorIdMap.put("104","200");
		_parameterTypeMap.put("104","Contract Identifier is mandatory for contract queries in case no Serial number is provided");


		_errorIdMap.put("105","201");
		_parameterTypeMap.put("105","IsoCountryCode");

		_errorIdMap.put("106","201");
		_parameterTypeMap.put("106","MaxOOSesNo provided. Allowed range: 0 - 9999, or empty for no limitation");

        _errorIdMap.put("107","201");
        _parameterTypeMap.put("107","SerialNumber");

        _errorIdMap.put("108","200");
		_parameterTypeMap.put("108","Contract Identifier is mandatory for contract queries in case no Serial number is provided");

		_errorIdMap.put("201","300");
		_parameterTypeMap.put("201",null);

		_errorIdMap.put("202","237");
		_parameterTypeMap.put("202",null);

		_errorIdMap.put("899","434");
		_parameterTypeMap.put("899",null);
	}




    protected ErrorMapper(Collection<?> cqsErrors, EsRequestComplexType request, String sapRegionDisplayName) {
    	_cqsErrors = cqsErrors;
    	_request = request;
    	_sapRegionDisplayName = sapRegionDisplayName;
    }


    public static  ErrorMapper getInstance(Collection<?> cqsErrors, EsRequestComplexType request, String sapRegionDisplayName) {

            return new MetroErrorMapper(cqsErrors, request, sapRegionDisplayName);


    }


    /**
     * map
     * @return
     * @throws MappingException
     */
    abstract public ArrayList<?> map() throws MappingException;


    protected abstract SifException mapError(Object cqsMessage);
}
