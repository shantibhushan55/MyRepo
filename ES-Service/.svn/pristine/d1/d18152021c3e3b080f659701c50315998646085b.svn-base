/*
 * Created on Mar 14, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * @author juhank
 */
public abstract class ErrorMapper {

	protected Collection _swopErrors;
	protected EsRequestComplexType _request;
	
    protected ErrorMapper(Collection swopErrors, EsRequestComplexType request) {
    	_swopErrors = swopErrors;
    	_request = request;
    }

    
    
    public static ErrorMapper getInstance(Collection swopErrors, EsRequestComplexType request) {

            return new MetroErrorMapper(swopErrors, request);
    }
    /**
     * map
     * @return
     * @throws MappingException
     */
    public ArrayList map() throws MappingException
    {
    	if(_swopErrors == null) {
    		return null;
    	}
    	
     	ESLog.debug("Mapping errors ...");
     	ArrayList errors = new ArrayList();
    	
    	Iterator iterator = _swopErrors.iterator();
    	while(iterator.hasNext()) {
    		SifException se = mapError(iterator.next());
    		if(se != null) {
    			errors.add(se);
    		}
    	}
        return errors;
    }

	/**
	 * @param zwtyerrortab
	 * @return
	 */
	protected abstract SifException mapError(Object swopError) ;
	
	protected SifException getError(String errorId, String message) {
	
		// 2000, 2001
		if(errorId.equals("2000") || errorId.equals("2001")) {
			if(_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getProductID() != null) {
				return ErrorFactory.getSifException(ErrorFactory.id210_PRODUCT_NR_NOT_FOUND,_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getProductID()
						, "SWOP " + errorId + ": " + message);
			}else if (_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getSparePartNumber() != null){
				return ErrorFactory.getSifException(ErrorFactory.id210_PRODUCT_NR_NOT_FOUND,_request.getEsRequestComplexTypeChoice().getWarrantyRequest().getSparePartNumber()
						, "SWOP " + errorId + ": " + message);				
			}else {
				return ErrorFactory.getSifException(ErrorFactory.id210_PRODUCT_NR_NOT_FOUND,"-"
						, "SWOP " + errorId + ": " + message);				
				
			}
		}
		// 2002, 2003
		if(errorId.equals("2002") || errorId.equals("2003")) {
			return ErrorFactory.getSifException(ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA, "CountryCode", "SWOP " + errorId + ": " + message);
		}
		// 2004
		if(errorId.equals("2004")) {
			return ErrorFactory.getSifException(ErrorFactory.id200_MISSING_PARAMETER,
					message, "SWOP " + errorId + ": " + message);
		}
		// 2005
		if(errorId.equals("2005")|| errorId.equals("2031")|| errorId.equals("2032")) {
			return ErrorFactory.getSifException(ErrorFactory.id212_NO_START_DATE, "SWOP " + errorId + ": " + message);
		}
		// 2006, 2007, 2013, 2014, 2015, 2016
		if(errorId.equals("2006") || errorId.equals("2007") || 
				errorId.equals("2013") || errorId.equals("2014") || 
				errorId.equals("2015") || errorId.equals("2016")) {
			return ErrorFactory.getSifException(ErrorFactory.id214_PRODUCT_PART_NOT_ELIGIBLE, "SWOP " + errorId + ": " + message);
		}
		// 2008
		if(errorId.equals("2008")) {
			return ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND, "SWOP " + errorId + ": " + message);
		}
		// 2009, 2018
		if(errorId.equals("2009") || errorId.equals("2018")) {
			return ErrorFactory.getSifException(ErrorFactory.id213_NO_WARRANTY_FOUND, "SWOP " + errorId + ": " + message);
		}
		// 2010
		if(errorId.equals("2010")) {
			return ErrorFactory.getSifException(ErrorFactory.id202_PRODUCT_NR_NOT_PROVIDED, "SWOP " + errorId + ": " + message);
		}
		// 2017
		if(errorId.equals("2017")) {
			return ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND, "SWOP " + errorId + ": " + message);
		}
		
		// 2022
		if(errorId.equals("2022")) {
			return ErrorFactory.getSifException(ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA, "Serial Number", "SWOP " + errorId + ": " + message);
		}	
	
		
		
		// 2033
		if(errorId.equals("2033")) {
			return ErrorFactory.getSifException(ErrorFactory.id212_NO_START_DATE, "SWOP " + errorId + ": " + message);
		}	

		// 2019 and others
		if(errorId.equals("2019") || errorId.startsWith("2")) {
			return ErrorFactory.getSifException(ErrorFactory.id224_ALL_SOURCE_SYSTEMS_TIMED_OUT, "SWOP", "SWOP " + errorId + ": " + message);
		}
		// a warning, will not be mapped
		return null; 
	}	
	
	
	
}
