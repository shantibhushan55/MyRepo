package com.hp.es.service.catsAgreement.integration;

import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public abstract class CatsAgreementIntegration implements IntegrationInterface {
    protected WarrantyEntitlementComplexType _swopWarranty;

    protected CatsAgreementIntegration(WarrantyEntitlementComplexType swopWarranty) {
        super();
        _swopWarranty = swopWarranty;
    }

    public Transaction execute(EsRequestComplexType request, MetricsHandler handler) throws SifException {
        return doCatsAgreementIntegration(request, handler);
    }

    protected abstract CatsAgreementTransaction doCatsAgreementIntegration(EsRequestComplexType request, MetricsHandler handler) throws SifException;

    public String getName() {
        return this.getClass().toString();
        
    }


	public RegionConfiguration getRegionConfiguration() {
		
		return null;
	}

	public String getRegionDisplayName() {
		
		return "ASTRO2 AES";
	}

	public boolean isLocal() {
		
		return false;
	}

	public boolean isRegionInFailoverMode() {
		return false;
	}


}
