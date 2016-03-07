package com.hp.es.service.plumbing;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2FMAESGETENTV3WS;
import com.hp.es.service.orchestration.sap.ASTRO2Region;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.ruc.config.DynConfigFactory;
import com.hp.ruc.config.ReadOnlyProperties;
import com.hp.ruc.metrics.MetricsHandler;

/**
 * Check the connectivity of ASTRO2 source system.
 * 
 * @author Chunyang Wang
 * @since ES Sirocco Release (10.1.1)
 */
public class Astro2Connectivity {
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;

    public static int getAstro2Status() {
        Object request = buildCatsRequest();

        if (testAstro2Connectivity(request) == true)
            return SUCCESS;
        else
            return FAILURE;
    }

    private static Object buildCatsRequest() {
        Object request;
        ZA2FMAESGETENTV3WS metroRequest = new ZA2FMAESGETENTV3WS();
        metroRequest.setCLIENTTYPE(Configuration.getInstance().getProperties().getProperty(EsConstants.ASTRO2_CLIENT_TYPE));
        metroRequest.setOPTION(Configuration.getInstance().getProperties().getProperty(EsConstants.ASTRO2_CALL_OPTION));
        metroRequest.setCOUNTRY(Configuration.getInstance().getProperties().getProperty(EsConstants.ES_PLUMBING_ASTRO2_COUNTRYCODE));
        metroRequest.setPRODUCTNUMBER(Configuration.getInstance().getProperties().getProperty(EsConstants.ES_PLUMBING_ASTRO2_PN));
        metroRequest.setSERIALNUMBER(Configuration.getInstance().getProperties().getProperty(EsConstants.ES_PLUMBING_ASTRO2_SN));
        request = metroRequest;

        return request;
    }

    private static boolean testAstro2Connectivity(Object request) {
        ASTRO2Region astro2Region = null;
        ReadOnlyProperties prop = null;
        try {
            DynConfigFactory configFactory = DynConfigFactory.getDynInstance();
            prop = configFactory.getConfig(EsConstants.ES_PROPERTIES_FILENAME);
            RegionConfiguration regionConfig = new RegionConfiguration(prop, EsConstants.ASTRO2_PROP_PREFIX + ".");

            astro2Region = ASTRO2Region.getInstance((RegionConfiguration) regionConfig);
            ESLog.debug("Testing connectivity for ASTRO2: the config is " + astro2Region.getMainConfig());

            long start = System.currentTimeMillis();

            astro2Region.execute(EsConstants.SAP_FUNCTION_NAME_ASTRO2, request, null, true, new MetricsHandler());

            ESLog.debug("Testing connectivity for ASTRO2: SUCCESSFUL!  response time: " + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            ESLog.error("Testing connectivity for ASTRO2: FAILED!", e);
            return false;
        }

        return true;
    }

    public static String getConfig() {
        StringBuffer sb = new StringBuffer();
        sb.append("URL:           ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.ASTRO2_PROP_PREFIX + ".mainUrl"));
        sb.append("\n");

        sb.append("User:          ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.ASTRO2_PROP_PREFIX + ".mainUser"));
        sb.append("\n");

        sb.append("Client Type:   ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.ASTRO2_PROP_PREFIX + ".clientType"));
        sb.append("\n");

        sb.append("Call Option:   ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.ASTRO2_PROP_PREFIX + ".callOption"));
        sb.append("\n");
        sb.append("Pool Size:     ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.ASTRO2_PROP_PREFIX + ".mainPoolSize"));
        sb.append("\n");

        sb.append("Max Wait Time: ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.ASTRO2_PROP_PREFIX + ".mainMaxWaitTime"));
        sb.append("\n");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print("Connection " + ((SUCCESS == Astro2Connectivity.getAstro2Status()) ? "SUCCESSFUL" : "FAILED"));
        System.out.print("Configuration: \n" + Astro2Connectivity.getConfig());
    }
}
