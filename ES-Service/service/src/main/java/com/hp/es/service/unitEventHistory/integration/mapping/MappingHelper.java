/*
 * Created on Mar 24, 2006
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hp.es.service.unitEventHistory.integration.mapping;

import com.hp.es.xml.service.InstalledBaseUnitRequest;

/**
 * @author JUHANK
 */
public class MappingHelper {

	private static MappingHelper _instance = new MappingHelper();
    public final static int DEFAULT_MAX_RESULT_SIZE = 10;
	
	private MappingHelper() {
	}
	
	/**
	 * getInstance
	 * @return
	 */
	public static MappingHelper getInstance() { 
		return _instance;
	}	
	

	/**
	 * checks if we have a default result size, if not we are setting it to DEFAULT_MAX_RESULT_SIZE 
	 * which is 10
	 * @param request
	 * @return
	 */
	public int getRequestedTotalResultSize(InstalledBaseUnitRequest request) {
		if(request == null) {
			return 0;
		}
		int resultSize = 0;
		if(request.hasTotalResultSize()) {
			resultSize = request.getTotalResultSize(); 
		} else {
			resultSize = DEFAULT_MAX_RESULT_SIZE;
		}
		return resultSize;
	}
}
