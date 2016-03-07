/**
 * 
 */
package com.hp.es.service.manufacturingHeaderInformation.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.manufacturingHeaderInformation.orchestration.ManufacturingInstalledBaseServiceError;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public class ManufacturingInstalledBaseServiceMetroErrrorMapper {

	protected Collection 		   _sourceSystemErrors;

	//disable default constructor
	private ManufacturingInstalledBaseServiceMetroErrrorMapper() {
		
	}
	


	public static ManufacturingInstalledBaseServiceMetroErrrorMapper getInstance() {
		return new ManufacturingInstalledBaseServiceMetroErrrorMapper();
	}


	public ArrayList  <SifException>  map(Collection sourceSystemErrors) throws MappingException {
    	if(sourceSystemErrors == null || sourceSystemErrors.isEmpty()) {
    		return null;
    	}
    	
     	ESLog.debug("Mapping Unit Event History errors ...");
     	ArrayList <SifException> errors = new ArrayList();
     	
     	Iterator iterator = sourceSystemErrors.iterator();
     	while(iterator.hasNext()) {
     		
     		//System.out.println("instance of error "+ iterator.next().getClass());
    		
    		ManufacturingInstalledBaseServiceError errorTmp = (ManufacturingInstalledBaseServiceError) iterator.next();
    		SifException se = mapError(errorTmp);
    		if(se != null) {
    			errors.add(se);
    		}
    	}
     	
    	
        return errors;
    }
	
	private SifException mapError(ManufacturingInstalledBaseServiceError snrError) {
		
		ESLog.debug("ManufacturingInstalledBaseServiceError : "+ snrError);
		if(snrError != null && snrError.getErrorId()!= null && snrError.getErrorId().equals("E-0001")) {
			return ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND, snrError.getErrorDescription());
		}
		if(snrError != null && snrError.getErrorId()!= null && snrError.getErrorId().equals("E-0000")) {
			return null;
		}
		if(snrError != null && snrError.getErrorId()!= null && snrError.getErrorId().equals("E-0002")) {
			return ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE, snrError.getErrorDescription());
		}
		if(snrError != null && snrError.getErrorId()!= null && snrError.getErrorId().equals("E-0003")) {
			return ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE, snrError.getErrorDescription());
		}
		if(snrError != null && snrError.getErrorId()!= null && snrError.getErrorId().equals("E-0004")) {
			return ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE, snrError.getErrorDescription());
		}
		if(snrError != null && snrError.getErrorId()!= null && snrError.getErrorId().equals("E-0005")) {
			return ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE, snrError.getErrorDescription());
		}
		if(snrError != null && snrError.getErrorId()!= null && snrError.getErrorId().equals("E-0010")) {
			return ErrorFactory.getSifException(ErrorFactory.id434_SYSTEMS_NOT_AVAILABLE, snrError.getErrorDescription());
		}
		if(snrError != null && snrError.getErrorId()!= null && snrError.getErrorId().equals("E-0011")) {
			return ErrorFactory.getSifException(ErrorFactory.id300_NO_DATA_FOUND, snrError.getErrorDescription());
		}
		//if no mapping null will be returned
		return null;	
			
	}

	/**
	 * mapError
	 * @param zwtyerrortab
	 * @return

	private SifException mapError(ZWTYERROR swopError) {
		/*
		 * 0000	Successful Completion
		   2028	NO Valid Event data Found for this Productnum Serialnum
		   2029	Product and Serial Number Required
		   2030 No Record Found for this Productnum Serialnum

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
*/

}
