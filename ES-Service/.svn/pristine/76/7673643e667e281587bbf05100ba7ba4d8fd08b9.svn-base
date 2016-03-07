package com.hp.es.service.ibSearch.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH.ZWTYERROR;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

public class MetroErrorMapper extends ErrorMapper {

	public MetroErrorMapper(Collection ibErrors, EsRequestComplexType request) {
		super(ibErrors, request);
	}

	public ArrayList map() throws MappingException {
    	if(_ibErrors == null) {
    		return null;
    	}
    	
     	ESLog.debug("Mapping IB errors ...");
     	ArrayList errors = new ArrayList();
    	
    	Iterator iterator = _ibErrors.iterator();
    	while(iterator.hasNext()) {
    		SifException se = mapError((ZWTYERROR) iterator.next());
    		if(se != null) {
    			errors.add(se);
    		}
    	}
        return errors;
    }

	/**
	 * mapError
	 * @param zwtyerrortab
	 * @return
	 */
	private SifException mapError(ZWTYERROR swopError) {
		// 2000
		if(swopError.getID().equals("2000")) {
			return ErrorFactory.getSifException(ErrorFactory.id210_PRODUCT_NR_NOT_FOUND,
					_request.getEsRequestComplexTypeChoice().getInstalledBaseUnitRequest().getProductID());
		}
		// 2019
		if(swopError.getID().equals("2019")) {
			return ErrorFactory.getSifException(ErrorFactory.id224_ALL_SOURCE_SYSTEMS_TIMED_OUT, "SWOP");
		}
		// 2020
		if(swopError.getID().equals("2020")) {
			return ErrorFactory.getSifException(ErrorFactory.id200_MISSING_PARAMETER);
		}
		// 2021, 2007
		if(swopError.getID().equals("2021") || swopError.getID().equals("2007")) {
			return ErrorFactory.getSifException(ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA);
		}
		// 2017, other
		if(swopError.getID().equals("2017") || swopError.getID().startsWith("2")) {
			return ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND);
		}
		// a error, will not be mapped
		return null; 
	}	

}
