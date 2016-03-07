package com.hp.es.service.orchestration.sap;

import junit.framework.TestCase;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS.ZA2FMAESGETENTV3WS;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsReply;
import com.hp.ruc.config.DynConfigFactory;
import com.hp.ruc.config.ReadOnlyProperties;
import com.hp.sif.SifException;

public class ASTRO2RegionTest extends TestCase {
    public void testCallMainHost() {
        ReadOnlyProperties prop = null;
        try {
            DynConfigFactory configFactory = DynConfigFactory.getDynInstance();
            prop = configFactory.getConfig(EsConstants.ES_PROPERTIES_FILENAME);
        } catch (Exception e) {
            ESLog.error("Failed to load the configuration for ASTRO2.", e);
        }
        RegionConfiguration regionConfig = new RegionConfiguration(prop, "es.sap.ASTRO2" + ".");

        ASTRO2Region astro2Region = ASTRO2Region.getInstance((RegionConfiguration) regionConfig);


        ZA2FMAESGETENTV3WS astro2Request = new ZA2FMAESGETENTV3WS();
        astro2Request.setCLIENTTYPE("ES");
        astro2Request.setOPTION("CATS");        
        astro2Request.setCOUNTRY("US");           
        astro2Request.setPRODUCTNUMBER("Q5569A");
        astro2Request.setSERIALNUMBER("MY63UP71SS");
        Transaction reply=null;
        try {
            reply = astro2Region.callMainHost(EsConstants.ASTRO2_SOAP_PACKAGE_NAME, EsConstants.SAP_FUNCTION_NAME_ASTRO2, astro2Request, "ASTRO2", true);
        } catch (SifException e) {          
            e.printStackTrace();
        }
      
        if(reply != null)  {
        	EsReply esReply =reply.getMappedReply();
        	reply = null;
        }
        
    }
}
