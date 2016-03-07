/*
 * Created on Jun 12, 2006
 */
package com.hp.es.service.warrantyEntitlement.integration;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.ManufacturingInstalledBaseHeaderType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 * This class is used for accessing all SWOP instance. It is used if the request
 * contains a serial number.
 */
public class MultipleInstanceIntegration extends WarrantyIntegration {



	

	public MultipleInstanceIntegration(String regionName, String countryCode, ManufacturingInstalledBaseHeaderType manufacturingInstalledBaseServiceReply,SifException manufacturingInstalledBaseServiceSE) {
		super();
		_region = RegionFactory.getInstance().getRegionByName(regionName);
		_isLocal = regionName.equals(RegionFactory.getInstance().lookupRegionName(countryCode));
		_manufacturingInstalledBaseServiceReply = manufacturingInstalledBaseServiceReply;
		_manufacturingInstalledBaseServiceSE= manufacturingInstalledBaseServiceSE;
	}

	/*
	 *  Execute method
	 */
	public Transaction execute(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		ESLog.debug("Entering multiple instance integration (Unit Warranty)");
		return callRegion(request, metricsHandler);
	}
}