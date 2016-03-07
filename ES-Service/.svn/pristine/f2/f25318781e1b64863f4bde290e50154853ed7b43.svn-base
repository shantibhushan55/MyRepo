package com.hp.es.service.plumbing;

import java.util.ArrayList;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.orchestration.sap.Region;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU.ZWARRANTYLOOKUPPARALLELBSU;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.ruc.util.StringUtil;

/*
 * This class test sap connectivity
 */
public class SAPConnectivity {

    public static final int OK = 0;
    public static final int FAILOVER = 1;
    public static final int ERROR = 2;

    public SAPConnectivity() {
        super();
    }

    public static String getSAPRegionsStatus() {
        StringBuffer sb = new StringBuffer();
        ArrayList listOfRegionName = getAvailableRegionNames();
        for (int i = 0; i < listOfRegionName.size(); i++) {
            String regionName = (String) listOfRegionName.get(i);
            Region region = RegionFactory.getInstance().getRegionByName(regionName);

            sb.append("MAIN REGION " + regionName + " Configuration");
            sb.append(region.getMainConfig());
            sb.append("MAIN REGION " + regionName + " Pool state/usage");
            sb.append(region.getMainState());

            sb.append("FAILOVER REGION " + regionName + " Configuration");
            sb.append(region.getFailoverConfig());
            sb.append("FAILOVER REGION " + regionName + " Pool state/usage");
            sb.append(region.getFailoverState());

        }
        return sb.toString();
    }

    public static String getLocalRegionName() {
        return RegionFactory.getInstance().getLocalRegionName();
    }

    public static ArrayList getAvailableRegionNames() {
        return RegionFactory.getInstance().getAvailableRegionsName();
    }

    public static String getMainConfig(String regionName) {
        return RegionFactory.getInstance().getRegionByName(regionName).getMainConfig();
    }

    public static String getFailoverConfig(String regionName) {
        return RegionFactory.getInstance().getRegionByName(regionName).getFailoverConfig();
    }

    public static String getMainState(String regionName) {
        String mainStatus = RegionFactory.getInstance().getRegionByName(regionName).getMainState();
        // do some string cosmetics before returning
        mainStatus = StringUtil.replace(mainStatus, "\t", "   ");
        mainStatus = StringUtil.replace(mainStatus, "waiting     ", "waiting   ");
        mainStatus = StringUtil.replace(mainStatus, "number ", "Number ");
        mainStatus = StringUtil.replace(mainStatus, "current ", "Current ");
        mainStatus = StringUtil.replace(mainStatus, " Pool ", "");
        return mainStatus;
    }

    public static String getFailoverState(String regionName) {
        String failoverStatus = RegionFactory.getInstance().getRegionByName(regionName).getFailoverState();
        // do some string cosmetics before returning
        failoverStatus = StringUtil.replace(failoverStatus, "\t", "   ");
        failoverStatus = StringUtil.replace(failoverStatus, "waiting     ", "waiting   ");
        failoverStatus = StringUtil.replace(failoverStatus, "number ", "Number ");
        failoverStatus = StringUtil.replace(failoverStatus, "current ", "Current ");
        failoverStatus = StringUtil.replace(failoverStatus, " Pool ", "");
        return failoverStatus;
    }

    public static int getRegionStatus(String regionName) {
        if (!testRegionConnectivity(regionName))
            return ERROR;
        if (RegionFactory.getInstance().getRegionByName(regionName).inFailoverMode())
            return FAILOVER;
        else
            return OK;
    }

    public static boolean getRegionFailoverStatus(String regionName) {
    	return RegionFactory.getInstance().getRegionByName(regionName).getConfiguration().isFailoverEnable();
    }
    
    public static Object getRequest(){
    	Object request = null;

        ZWARRANTYLOOKUPPARALLELBSU metroRequest = new ZWARRANTYLOOKUPPARALLELBSU();
        metroRequest.setSERIALNUM(Configuration.getInstance().getProperties().getProperty(EsConstants.ES_PLUMBING_SAP_SN));
        metroRequest.setISOCOUNTRYCODE(Configuration.getInstance().getProperties().getProperty(EsConstants.ES_PLUMBING_SAP_COUNTRYCODE));
        metroRequest.setPRODUCTNUM(Configuration.getInstance().getProperties().getProperty(EsConstants.ES_PLUMBING_SAP_PN));
        request=metroRequest;
        return request;
    }
    
    
    public static boolean testRegionConnectivity(String regionName) {
        Region region = RegionFactory.getInstance().getRegionByName(regionName);
        Object request = getRequest();
        try {
            long start = System.currentTimeMillis();
            region.execute(EsConstants.SAP_FUNCTION_NAME_SWOP, request, regionName, true, new MetricsHandler());
            ESLog.debug("Testing connectivity for region " + regionName + (region.inFailoverMode() ? " (FAILOVER)" : " (MAIN)")
                    + " SUCCESSFUL; response time: " + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            ESLog.error("Testing connectivity for region " + regionName + (region.inFailoverMode() ? " (FAILOVER)" : " (MAIN)") + " FAILED!", e);
            return false;
        }
        return true;
    }

    public static void main(String[] argv) {
        System.out.println(getSAPRegionsStatus());
        System.out.println(testRegionConnectivity("AM"));
    }

};
