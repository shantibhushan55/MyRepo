package com.hp.es.service.unitEventHistory.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY.ZWTYERROR;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

public class MetroErrrorMapper extends ErrorMapper {

	public MetroErrrorMapper(Collection sourceSystemErrors,
			EsRequestComplexType request) {
		super(sourceSystemErrors, request);
	}

	
	
	
	public ArrayList map() throws MappingException {
    	if(_sourceSystemErrors == null || _sourceSystemErrors.isEmpty()) {
    		return null;
    	}
    	
     	ESLog.debug("Mapping Unit Event History errors ...");
     	ArrayList errors = new ArrayList();
    	
    	Iterator iterator = _sourceSystemErrors.iterator();
    	while(iterator.hasNext()) {
    		
    		ZWTYERROR errorTmp = (ZWTYERROR) iterator.next();
    		SifException se = mapError(errorTmp);
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
		/*
		 * 0000	Successful Completion
		   2028	NO Valid Event data Found for this Productnum Serialnum
		   2029	Product and Serial Number Required
		   2030 No Record Found for this Productnum Serialnum
		 */
    	ESLog.debug("swopError.getID()="+swopError.getID());
      	ESLog.debug("swopError.getMESSAGE()="+swopError.getMESSAGE());

		// 0000
		if(swopError.getID().equals("0000")) {// successfull completion but empty reply
			return ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND);
		}

		// 2028
		if(swopError.getID().equals("2028")) {// successfull completion but empty reply
			return ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND, swopError.getMESSAGE());
		}	
		
		// 2029
		if(swopError.getID().equals("2029")) {// successfull completion but empty reply
			return ErrorFactory.getSifException(ErrorFactory.id200_MISSING_PARAMETER, swopError.getMESSAGE());
			
		}		
		
		// 2030
		if(swopError.getID().equals("2030")) {// successfull completion but empty reply
			return ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND, swopError.getMESSAGE());
		}	
		
		
		// a error, will not be mapped
		return null; 
	}	


}
