package com.hp.es.service.catsAgreement.integration;

import java.util.ArrayList;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.sap.ASTRO2Region;
import com.hp.es.service.orchestration.sap.Region;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.ruc.config.DynConfigFactory;
import com.hp.ruc.config.ReadOnlyProperties;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

public abstract class ASTRO2CatsAgreementIntegration extends CatsAgreementIntegration {

    protected Region _region = null;
    private String _clientType = null;
    private String _callOption = null;

    protected ASTRO2CatsAgreementIntegration(WarrantyEntitlementComplexType warrantyEntitlement) {
        super(warrantyEntitlement);
        ReadOnlyProperties prop = null;
        try {
            DynConfigFactory configFactory = DynConfigFactory.getDynInstance();
            prop = configFactory.getConfig(EsConstants.ES_PROPERTIES_FILENAME);
            setClientType(prop.getProperty(EsConstants.ASTRO2_CLIENT_TYPE, "ES"));
            setCallOption(prop.getProperty(EsConstants.ASTRO2_CALL_OPTION, "CATS"));
        } catch (Exception e) {
            ESLog.error("Failed to load the configuration for ASTRO2.", e);
        }
        RegionConfiguration regionConfig = new RegionConfiguration(prop, EsConstants.ASTRO2_PROP_PREFIX + ".");

        ASTRO2Region astro2Region = ASTRO2Region.getInstance((RegionConfiguration) regionConfig);
        _region = astro2Region;

    }

    protected abstract CatsAgreementTransaction doCatsAgreementIntegration(EsRequestComplexType request, MetricsHandler handler) throws SifException;

    public boolean isLocal() {
        return true;
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

    /**
     * Currenty there is no region for ASTRO2 source system. So we take a blank value as the region.
     */
    public final String getRegionDisplayName() {
        return "ASTRO2 AES";
    }

    protected final CatsAgreementTransaction mapErrorTransaction2ComposedErrors(String sapFunctionName, ErrorTransaction transaction)
            throws SifException {
        CatsAgreementTransaction ct = new CatsAgreementTransaction(_region.getConfiguration(), _region.inFailoverMode(), null, sapFunctionName,
                getRegionDisplayName(), true);
        Throwable t = transaction.getSourceSystemThrowable();
        ArrayList<SifException> listErrors = new ArrayList<SifException>();
        if (t instanceof SifException) {
            listErrors.add((SifException) t);
        } else {
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "ASTRO2", "Unkown Exception class:" + t.getClass().getName()
                    + ", Message: " + t.getMessage());
        }

        ct.setMappedErrors(listErrors);
        return ct;
    }

    protected abstract EIAError mapError(CatsAgreementTransaction transaction) throws MappingException;

    public String getCallOption() {
        return _callOption;
    }

    public void setCallOption(String callOption) {
        this._callOption = callOption;
    }

    public String getClientType() {
        return _clientType;
    }

    public void setClientType(String clientType) {
        this._clientType = clientType;
    }

    public String getSwopProductId() {
        if (_swopWarranty != null && _swopWarranty.getOOS() != null && _swopWarranty.getOOS().getProduct() != null)
            return _swopWarranty.getOOS().getProduct().getProductID();

        return null;
    }

    public String getSwopShipToCountry() {
        if (_swopWarranty != null && _swopWarranty.getOOS() != null)
            return _swopWarranty.getOOS().getShipToCountry();

        return null;
    }

}
