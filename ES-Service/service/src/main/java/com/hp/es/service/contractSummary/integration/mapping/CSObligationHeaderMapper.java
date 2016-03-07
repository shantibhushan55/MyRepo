/**
 * 
 */
package com.hp.es.service.contractSummary.integration.mapping;


import java.util.Map;

import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ObligationHeaderComplexType;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public abstract class CSObligationHeaderMapper {

    protected XMLIdGenerator _XMLIdGenerator;
    protected ContractSummaryTransaction _transaction;
    protected Map _locationMap;
    protected Map _contactMap;
	protected EsReplyCSContext _ctx;
    

	/**
	 * 
	 */
	public CSObligationHeaderMapper(ContractSummaryTransaction transaction, XMLIdGenerator generator, Map locationMap, Map contactMap, EsReplyCSContext ctx) {
		_transaction = transaction;
    	_ctx = ctx;
    	_XMLIdGenerator = generator;
    	_locationMap = locationMap;
    	_contactMap = contactMap;
    	
    	
	}

	abstract ObligationHeaderComplexType[] map(boolean includeOffers, boolean includeDeliverables,boolean includeContact, boolean includeLocation, boolean includeFunctionalLocation,boolean includeSWServiceLevelCategory) throws MappingException, SifException;	
}
