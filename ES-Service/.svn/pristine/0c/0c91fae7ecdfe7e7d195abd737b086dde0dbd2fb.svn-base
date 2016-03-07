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

import java.util.ArrayList;
import java.util.Collection;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractSummary.integration.mapping.CSErrorMapper;
import com.hp.es.service.contractSummary.integration.mapping.CSWarningMapper;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.sap.Region;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public abstract class CQSContractSummaryIntegration extends ContractSummaryIntegration {

	protected boolean _isLocal = false;
	protected Region _region = null;
	/**
	 * 
	 */
	protected CQSContractSummaryIntegration(String regionName) {
		super();
		_region = RegionFactory.getInstance().getRegionByName(regionName);
		_isLocal = regionName.equals(_region.getConfiguration().getRegionName());
	}
	
	public abstract ContractSummaryTransaction doContractSummaryIntegration(EsRequestComplexType request, MetricsHandler handler) throws SifException;

	protected abstract void mapCQSReply2EsReply(ContractSummaryTransaction transaction, EsRequestComplexType request) throws SifException;
	
	public boolean isLocal() {
		return _isLocal;
	}

	public boolean isRegionInFailoverMode() {
		return _region.inFailoverMode();
	}
	
	public String getRegionName() {
		return _region.getConfiguration().getRegionName();
	}
	
	public RegionConfiguration getRegionConfiguration() {
		return _region.getConfiguration();
	}

	public String getName() {
		return this.getClass().toString() + "-" + _region.getConfiguration().getRegionName();
	}	
	
	public final String getRegionDisplayName() {
		return EsConstants.CQS_SYSTEM_NAME +getRegionName();
	}  

	protected final ContractSummaryTransaction mapErrorTransaction2ComposedErrors(String sapFunctionName, ErrorTransaction transaction) throws SifException {
		ContractSummaryTransaction ct = new ContractSummaryTransaction(_region.getConfiguration(), _region.inFailoverMode(),null, sapFunctionName, getRegionDisplayName(), _isLocal);
		Throwable t = transaction.getSourceSystemThrowable();
		ArrayList listErrors = new ArrayList();
		if(t instanceof SifException) {
			listErrors.add((SifException)t);		
		}else {
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Unkown Exception class:"+ t.getClass().getName() +", Message: "+t.getMessage());
		}
		
		ct.setMappedErrors(listErrors);
		return ct;
	}	

	protected final void mapSourceSystemError2ComposedErrors(ContractSummaryTransaction transaction, EsRequestComplexType request) throws SifException {
		Collection cqsErrors = transaction.getSourceSystemErrors();
		CSErrorMapper mapper = CSErrorMapper.getInstance(cqsErrors, request, transaction.getRegionDisplayName());
		try {
			transaction.setMappedErrors(mapper.map());
			
		} catch (MappingException e) {
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Caught runtime exception "+e.getMessage());
		}
	}

	/*
	 * Map warning
	 */
	protected final Warnings mapWarnings(ContractSummaryTransaction transaction) throws MappingException {

		CSWarningMapper mapper = CSWarningMapper.getInstance(transaction.getSourceSystemWarnings(), getRegionDisplayName());
		
		return mapper.map();
	}
	
}
