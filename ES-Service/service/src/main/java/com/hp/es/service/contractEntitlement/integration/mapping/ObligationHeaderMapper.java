package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.HashMap;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ObligationHeader;

abstract class ObligationHeaderMapper {

    protected Object _header;
	protected HashMap     _offerMap;
	protected EsReplyContext _ctx;
	
/*
	ObligationHeaderMapper(Object header, XMLIdGenerator generator, HashMap offerMap) {
    	_header = header;
    	_offerMap  = offerMap;
    	
    	
	}*/
	public ObligationHeaderMapper(Object header, XMLIdGenerator generator, HashMap offerMap, EsReplyContext ctx) {
    	_header = header;
    	_offerMap  = offerMap;
    	_ctx = ctx;
    	
	}	
	/*
	 * @return obligation header mapped
	 */
	abstract ObligationHeader map() throws MappingException ;


}
