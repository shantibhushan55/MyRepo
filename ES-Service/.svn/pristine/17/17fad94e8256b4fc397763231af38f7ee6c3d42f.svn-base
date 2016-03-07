package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.Map;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

abstract class ContractMapper {

    protected ContractTransaction _transaction;
    protected XMLIdGenerator _XMLIdGenerator;
    protected Map _oosMap;
    protected Map _locationMap;
    protected Map _contactMap;
    protected Map _oosKeyListMapbyOOSGroupId;
	protected EsRequestComplexType _request;
	protected EsReplyContext _ctx;
	
	
	public ContractMapper(ContractTransaction transaction, XMLIdGenerator generator, Map oosMap, Map locationMap, Map contactMap, Map oosKeyListMapbyOOSGroupId, EsReplyContext ctx) {
		_transaction = transaction;
		_XMLIdGenerator = generator;
		_oosMap = oosMap;
		_locationMap = locationMap;
		_contactMap = contactMap;
		_oosKeyListMapbyOOSGroupId = oosKeyListMapbyOOSGroupId;
		_ctx = ctx;
	}	

	abstract ContractComplexType[] map(boolean includeOffers, boolean includeDeliverables, boolean  includeModifiers, boolean includeContact, boolean includeLocation, boolean includeOOSes) throws MappingException, SifException;	
}
