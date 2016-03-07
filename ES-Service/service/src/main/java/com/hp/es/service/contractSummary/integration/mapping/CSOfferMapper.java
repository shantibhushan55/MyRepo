/**
 * 
 */
package com.hp.es.service.contractSummary.integration.mapping;


import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.xml.service.Offer;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public abstract class CSOfferMapper {

	protected ContractSummaryTransaction _transaction;
	protected Object _service;
	protected EsReplyCSContext _ctx;

	/**
	 * 
	 */
	 CSOfferMapper(ContractSummaryTransaction transaction, Object service, EsReplyCSContext ctx) {
		 _transaction = transaction;
		 _service = service;
	    _ctx = ctx;
	}

	 /*
	 * Map an offer and related object
	 */
	abstract Offer map(boolean includeDeliverables) throws SifException ;	
	
}
