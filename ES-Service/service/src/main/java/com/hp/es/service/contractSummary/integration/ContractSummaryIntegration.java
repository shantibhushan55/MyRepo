/*
 * Project: HPS Entitlement Service - Mercury Integration
 *
 * Copyright (c) 2007 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * Revision 1.0  
 * Author: olcay.yesilyurt@hp.com
 * Initial revision
 *
 */
package com.hp.es.service.contractSummary.integration;

import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.contractSummary.integration.mapping.CSWorkingMapper;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public abstract class ContractSummaryIntegration implements IntegrationInterface {

	/**
	 * 
	 */
	protected ContractSummaryIntegration() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */
	public Transaction execute(EsRequestComplexType request,  MetricsHandler handler)	throws SifException {
		return doContractSummaryIntegration(request, handler);
	}
	
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */	
	protected abstract ContractSummaryTransaction doContractSummaryIntegration(EsRequestComplexType request, MetricsHandler handler)	throws SifException;
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getName()
	 */
	public abstract String getName();
	
	/*
	 * Map working
	 */
	protected final WorkingComplexType mapWorking(ContractSummaryTransaction transaction) {
		CSWorkingMapper mapper = new CSWorkingMapper(transaction.getSourceSystemStatus(),getRegionDisplayName());
		return mapper.map();
	}	
	
}
