/**
 * 
 */
package com.hp.es.service.contractSummary.integration.mapping;

import com.hp.es.service.contractSummary.EsReplyCSContext;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ProductListComplexType;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
abstract class CSProductListMapper {

	protected ContractSummaryTransaction _transaction;
	protected EsReplyCSContext _ctx;

	/**
	 * 
	 */
	protected CSProductListMapper(ContractSummaryTransaction transaction, EsReplyCSContext ctx) {
		_transaction = transaction;
		_ctx = ctx;
	}
	

	abstract ProductListComplexType[] map() throws MappingException, SifException;	
	
}
