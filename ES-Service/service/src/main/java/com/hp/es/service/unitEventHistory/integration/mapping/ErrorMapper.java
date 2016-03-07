/**
 * 
 */
package com.hp.es.service.unitEventHistory.integration.mapping;

import java.util.ArrayList;
import java.util.Collection;

import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;

/**
 * @author ANVOI
 *
 */
public class ErrorMapper {

	protected Collection 		   _sourceSystemErrors;
	protected EsRequestComplexType _request;
	
	//disable default constructor
	private ErrorMapper() {
		
	}
	
	public ErrorMapper(Collection sourceSystemErrors,
			EsRequestComplexType request) {
		_sourceSystemErrors= sourceSystemErrors;
		_request = request;
	}

	public static ErrorMapper getInstance(Collection sourceSystemErrors,
			EsRequestComplexType request) {
		return new MetroErrrorMapper(sourceSystemErrors,request);
	}

	public ArrayList map() throws MappingException {
		throw new MappingException("Not to be used directly");
	}

}
