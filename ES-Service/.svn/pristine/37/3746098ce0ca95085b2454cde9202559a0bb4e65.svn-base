/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration;

import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.contractEntitlement.integration.mapping.WorkingMapper;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public abstract class ContractIntegration implements IntegrationInterface {

	/**
	 * 
	 */
	protected ContractIntegration() {
		super();
	
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */
	public Transaction execute(EsRequestComplexType request,  MetricsHandler handler)	throws SifException {
		return doContractIntegration(request, handler);
	}
	
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */	
	protected abstract ContractTransaction doContractIntegration(EsRequestComplexType request, MetricsHandler handler)	throws SifException;
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getName()
	 */
	public abstract String getName();
	
	/*
	 * Map working
	 */
	protected final WorkingComplexType mapWorking(ContractTransaction transaction) {
		WorkingMapper mapper = new WorkingMapper(transaction.getSourceSystemStatus(),getRegionDisplayName());
		
		return mapper.map();
	}	
}
