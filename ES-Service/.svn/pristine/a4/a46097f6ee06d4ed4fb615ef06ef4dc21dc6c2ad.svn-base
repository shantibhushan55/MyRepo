package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.Map;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.sif.SifException;

abstract class OfferMapper {

	protected Object _service;
	protected XMLIdGenerator _generator;
	protected Map _oosMap;
	protected Map _oosKeyListMapbyOOSGroupId;
	protected EsReplyContext _ctx;
    protected Object _firstCqsOOS;
    protected static final String OOS_TYPE = "OOS";


	OfferMapper(Object service, XMLIdGenerator generator, Map oosMap, Map oosKeyListMapbyOOSGroupId, EsReplyContext ctx, Object firstCqsOOS) {
		_service = service;
		_generator = generator;
		_oosMap = oosMap;
		_oosKeyListMapbyOOSGroupId = oosKeyListMapbyOOSGroupId;
		_ctx = ctx;
        _firstCqsOOS=firstCqsOOS;
	}

	/*
	 * Map an offer and related object
	 */
	abstract OfferComplexType map(boolean includeDeliverables, boolean  includeModifiers, String sourceObligationI) throws SifException ;	
	

}
