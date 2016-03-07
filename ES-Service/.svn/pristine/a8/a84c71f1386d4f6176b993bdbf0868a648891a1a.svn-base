/**
 * 
 */
package com.hp.es.service.contractEntitlement.integration;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public abstract class ODSIntegration extends ContractIntegration {


	/**
	 * Constructor
	 */
	protected ODSIntegration() {
		super();
		init();		
	}


	
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#execute(com.hp.es.xml.service.EsRequestComplexType)
	 */
	public abstract ContractTransaction doContractIntegration(EsRequestComplexType request, MetricsHandler handler) 
			throws SifException;

	
	
	public String getName() {
		return this.getClass().toString();
	}


	
   


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
    }

    
	public String getRegionDisplayName() {
		return EsConstants.ODS_SYSTEM_NAME;
		
	}    
}
