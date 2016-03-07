/*
 * Created on Jun 12, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 * This class is used for accessing only the local (country of service) instance.
 * It is used for for product and spare part calculation if no serial number is
 * passed with the request.
 */
public class SingleInstanceIntegration extends WarrantyIntegration {

	public SingleInstanceIntegration(String countryCode) { 
		super();
		_isLocal = true;
		_region = RegionFactory.getInstance().getCountryOfServiceRegion(countryCode);
	}

	/*
	 * Execute method
	 */
	public Transaction execute(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		ESLog.debug("Entering single integration (product / spare part)");
		return callRegion(request, metricsHandler);
	}
}
