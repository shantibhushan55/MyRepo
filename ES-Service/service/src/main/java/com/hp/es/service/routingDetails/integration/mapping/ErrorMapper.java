package com.hp.es.service.routingDetails.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * 108 Mandatory Service Agreement ID has not been provided => 200
 * 201 No entries found => 300 
 * 202 Found Contract XXXXX is invalid - No ISO Country Code for ProductShipTo Location exists => 237 
 * 899 Internal error - Any unanticipated error occurred during the processing of the request => 434
 * 
 * @author Chunyang
 * @since 9.0.2
 */
public abstract class ErrorMapper {

    protected Collection<?> _cqsErrors;
    protected EsRequestComplexType _request;
    protected String _sapRegionDisplayName;

    protected final static HashMap<String, String> _errorIdMap = new HashMap<String, String>();
    protected final static HashMap<String, String> _parameterTypeMap = new HashMap<String, String>();
    static {
        _errorIdMap.put("108", "200");
        _parameterTypeMap.put("108", "Mandatory Service Agreement ID  has not  been provided");

        _errorIdMap.put("201", "300");
        _parameterTypeMap.put("201", null);

        _errorIdMap.put("202", "237");
        _parameterTypeMap.put("202", null);

        _errorIdMap.put("899", "434");
        _parameterTypeMap.put("899", null);

    }

    protected ErrorMapper(Collection<?> cqsErrors, EsRequestComplexType request, String sapRegionDisplayName) {
        _cqsErrors = cqsErrors;
        _request = request;
        _sapRegionDisplayName = sapRegionDisplayName;
    }

    public static ErrorMapper getInstance(Collection<?> errors, EsRequestComplexType request, String sapRegionDisplayName) {
        return new MetroErrorMapper(errors, request, sapRegionDisplayName);
    }

    /**
     * map
     * 
     * @return
     * @throws MappingException
     */
    public abstract ArrayList<?> map() throws MappingException;

    protected abstract SifException mapError(Object cqsMessage);

}
