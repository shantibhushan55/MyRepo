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
package com.hp.es.service.customerIndicator;

import java.util.ArrayList;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.integration.mapping.WorkingMapper;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.contractSummary.integration.mapping.CSWorkingMapper;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WorkingComplexType;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;


/**
 * @author yesilyur
 *
 */
public abstract class ODSCustomerIndicatorIntegration{

	/**
	 * Constructor
	 */
	protected ODSCustomerIndicatorIntegration() {
		init();		
	}
	

	public abstract int doCustomerIndicatorIntegration(ArrayList cqsReplies,EsRequestComplexType request, MetricsHandler handler) 
	throws SifException, DatabaseDownException;



	public String getName() {
		return this.getClass().toString();
	}
	
    protected DbCustomerIndicatorManager _dbCustomerIndicatorManager;
 
	/**
     * All time-consuming initializations should be done
     * here. <b>Note:</b> The same object will be used in parallel
     * by multiple threads. The access to other resources needs to be
     * synchronized if necessary.
     * 
     */
    protected void init() {
        // just to make sure that the database is initialized when the
        // first request comes in
        _dbCustomerIndicatorManager = DbCustomerIndicatorManager.getInstance();
    }

    
	public String getRegionDisplayName() {
		return EsConstants.ODSCI_SYSTEM_NAME;		
	}    
	
	/*
	 * Map working
	 */
	protected final WorkingComplexType mapWorking(ContractSummaryTransaction transaction) {
		CSWorkingMapper mapper = new CSWorkingMapper(transaction.getSourceSystemStatus(),getRegionDisplayName());
		return mapper.map();
	}	
	
	/*
	 * Map working
	 */
	protected final WorkingComplexType mapWorking(ContractTransaction transaction) {
		WorkingMapper mapper = new WorkingMapper(transaction.getSourceSystemStatus(),getRegionDisplayName());	
		return mapper.map();
	}	
	
}
