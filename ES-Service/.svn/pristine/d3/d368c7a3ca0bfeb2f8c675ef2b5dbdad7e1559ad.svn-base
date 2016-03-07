package com.hp.es.service;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/*
 * There should an integration class created by function
 * an integration object should then be created by region
 */
public interface IntegrationInterface {
	
	
	/*
	 * Execute a request 
	 * @param a request
	 * @param a reply
	 * @throws SifException
	 */
	public Transaction execute(EsRequestComplexType request, MetricsHandler handler) throws SifException;
	
	/*
	 * Get the name of the orchestration layer
	 */
	public String getName();

	public RegionConfiguration getRegionConfiguration();

	public boolean isRegionInFailoverMode();
	
	public String getRegionDisplayName();

	public boolean isLocal();


}
