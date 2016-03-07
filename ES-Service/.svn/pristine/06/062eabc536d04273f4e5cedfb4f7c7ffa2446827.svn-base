package com.hp.es.service.plumbing;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.manufacturingHeaderInformation.orchestration.ManufacturingInstalledBaseServiceOrchestraction;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.sif.SifException;

/**
 * Check the connectivity of SNR source system.
 * 
 * @author Srini Yeramsetty
 * @since ES Sirocco Release (10.1.1)
 */
public class SnrConnectivity {
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;
    
 

    public static int getSnrStatus() {
        if (testSnrConnectivity() == true)
            return SUCCESS;
        else
            return FAILURE;
    }

   

    private static boolean testSnrConnectivity() {
    	
    	boolean result = false;
    	long start = System.currentTimeMillis();
    	 try {
    		 
    		 ESLog.debug("Testing connectivity for SNR: the config is " + getConfig()  );
    		 EsReply reply = ManufacturingInstalledBaseServiceOrchestraction.getInstance().execute(buildSNRRequest(), null, null);
	         
    		 long end = start - System.currentTimeMillis();
	         
    		 if(null != reply){
    			 result= true;
    			 ESLog.debug("Testing connectivity for SNR: SUCCESSFUL!  response time: " + end + "ms");
    		 }
        } catch(SifException e)  {
        	if("300".equalsIgnoreCase(e.getErrorID())) {
        		long end = start - System.currentTimeMillis();
        		result= true;
        		ESLog.debug("Testing connectivity for SNR: SUCCESSFUL!  response time: " + end + "ms");
        	}else {
        		ESLog.error("Testing connectivity for SNR: FAILED!", e);
        	}
        	
    	 }   catch (Exception e) {
            ESLog.error("Testing connectivity for SNR: FAILED!", e);
        }

        return result;
    }

    private static EsRequestComplexType buildSNRRequest() {
    	EsRequestComplexType request = new EsRequestComplexType();
    	request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
    	request.getEsRequestComplexTypeChoice().setWarrantyRequest(new WarrantyRequest());
    	request.getEsRequestComplexTypeChoice().getWarrantyRequest().setProductID(Configuration.getInstance().getProperties().getProperty("es.plumbing.SNR.PN"));
    	request.getEsRequestComplexTypeChoice().getWarrantyRequest().setSerialNumber(Configuration.getInstance().getProperties().getProperty("es.plumbing.SNR.SN"));
		return request;
	}



	public static String getConfig() {
        StringBuffer sb = new StringBuffer();
        sb.append("URL:           ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_PROP_PREFIX + ".url"));
        sb.append("\n");

        sb.append("User:          ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_PROP_PREFIX + ".user"));
        sb.append("\n");

        sb.append(" IS SNr Enabled:   ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_PROP_PREFIX + ".enable"));
        sb.append("\n");

        sb.append("Returninfo level:   ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_PROP_PREFIX + ".returninfo.level"));
        sb.append("\n");
        
        sb.append("Returninfo Modifie:     ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_PROP_PREFIX + ".returninfo.modifier"));
        sb.append("\n");

        sb.append("Max Wait Time: ");
        sb.append(Configuration.getInstance().getProperties().getProperty(EsConstants.SNR_PROP_PREFIX + ".maxWaitTime"));
        sb.append("\n");

        return sb.toString();
    }
    

    public static void main(String[] args) {
        System.out.print("Connection " + ((SnrConnectivity.testSnrConnectivity() == true ) ? "SUCCESSFUL" : "FAILED"));
        System.out.print("Configuration: \n" + SnrConnectivity.getConfig());
    }
    
}
