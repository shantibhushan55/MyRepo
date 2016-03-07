package com.hp.es.service.manufacturingHeaderInformation.integration.mapping;

import com.hp.es.service.manufacturingHeaderInformation.orchestration.ManufacturingInstalledBaseServiceTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsRequestComplexType;

public class ManufacturingInstalledBaseServiceHeaderMapper {
	  protected EsRequestComplexType _request;
	  protected ManufacturingInstalledBaseServiceTransaction _transaction;
	  
	public ManufacturingInstalledBaseServiceHeaderMapper(EsRequestComplexType request,
			ManufacturingInstalledBaseServiceTransaction transaction) {
	       _request = request;
	       _transaction = transaction;
	}
	
	
	/**
     * map
     * @return
     * @throws MappingException 
     */
	public EsHeader map()throws MappingException {
    	ESLog.debug("Mapping ES header");		
    	EsHeader esHeader = new EsHeader();
    	esHeader.setInputRequest(_request);
     	ESLog.debug("Mapping ES header done");	
        return esHeader;
	}

}
