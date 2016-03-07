/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration;

import java.util.ArrayList;
import java.util.Collection;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.integration.mapping.ErrorMapper;
import com.hp.es.service.contractEntitlement.integration.mapping.WarningMapper;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
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
 * @author ANVOI
 *
 */
public abstract class CQSIntegration extends ContractIntegration {

	protected boolean _isLocal = false;
	protected Region _region = null;
	
	/**
	 * 
	 */
	protected CQSIntegration(String regionName) {
		super();
		_region = RegionFactory.getInstance().getRegionByName(regionName);
		_isLocal = regionName.equals(_region.getConfiguration().getRegionName());
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#execute(com.hp.es.xml.service.EsRequestComplexType)
	 */
	public abstract ContractTransaction doContractIntegration(EsRequestComplexType request, MetricsHandler handler) throws SifException;

	protected abstract void mapCQSReply2EsReply(ContractTransaction transaction, EsRequestComplexType request) throws SifException;
	
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
	
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getName()
	 */
	public String getName() {
		return this.getClass().toString() + "-" + _region.getConfiguration().getRegionName();
	}	
	
	public final String getRegionDisplayName() {
		return EsConstants.CQS_SYSTEM_NAME +getRegionName();
	}  
	
	/*
	 * 
	 */
	protected final ContractTransaction mapErrorTransaction2ComposedErrors(String sapFunctionName, ErrorTransaction transaction) throws SifException {
		ContractTransaction ct = new ContractTransaction(_region.getConfiguration(), _region.inFailoverMode(),null, sapFunctionName, getRegionDisplayName(), _isLocal);
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

	
	
	protected final void mapSourceSystemError2ComposedErrors(ContractTransaction transaction, EsRequestComplexType request) throws SifException {
		Collection cqsErrors = transaction.getSourceSystemErrors();
		ErrorMapper mapper = ErrorMapper.getInstance(cqsErrors, request, transaction.getRegionDisplayName());
		try {
			transaction.setMappedErrors(mapper.map());
			
		} catch (MappingException e) {
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Caught runtime exception "+e.getMessage());
		}
	}

	
	/*
	 * Map warning
	 */
	protected final Warnings mapWarnings(ContractTransaction transaction) throws MappingException {

		WarningMapper mapper = WarningMapper.getInstance(transaction.getSourceSystemWarnings(), getRegionDisplayName());
		
		return mapper.map();
	}
	

}
