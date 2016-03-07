package com.hp.es.service.plumbing;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.compliancevalidation.ComplianceValidationHelper;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.TransactionIdGenerator;
import com.hp.es.service.util.xml.EIAMessageHelper;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply;

public class CVSConnectivity {

	public static final int SUCCESS = 0;
	public static final int FAILURE = 1;
	public static String cvsSBSLifecycle;

	public static String getConfig() {
		StringBuffer sb = new StringBuffer(500);
		
		
		sb.append("USER ID:   ");
		sb.append(Configuration.getInstance().getProperties()
				.getProperty(EsConstants.CVS_USER_ID, EsConstants.CVS_USER_ID_DEFAULT) +"\n");
		
		sb.append("CVS APP ID:           ");
		sb.append(Configuration.getInstance().getProperties()
				.getProperty(EsConstants.CVS_ES_APP_ID, EsConstants.CVS_ES_APP_ID_DEFAULT)+"\n");


		sb.append("CVS Lifecycle:          ");
		sb.append(Configuration.getInstance().getProperties()
				.getProperty(EsConstants.CVS_SBS_LIFECYCLE, EsConstants.CVS_SBS_LIFECYCLE_DEFAULT)+"\n");


		sb.append("CVS URL (override lifecyle if present):   ");
		
		cvsSBSLifecycle = Configuration
				.getInstance()
				.getProperties()
				.getProperty(EsConstants.CVS_SBS_LIFECYCLE,
						EsConstants.CVS_SBS_LIFECYCLE_DEFAULT);
		/**
		sb.append(Configuration.getInstance().getProperties()
				.getProperty(EsConstants.CVS_SBS_URL, EsConstants.CVS_SBS_URL_DEFAULT)+"\n");
		 */
		sb.append(System.getProperty("egitsbs." + cvsSBSLifecycle.toLowerCase()
				+ ".pattern"+"\n"));

		return sb.toString();
	}

	public static int getStatus() {
		if(testConnectivity()) {
			return SUCCESS;
		}
		return FAILURE;
	}

	private static boolean testConnectivity() {
		boolean connected = true;
		
		try {
			
			ComplianceValidationReply  cvsReply = ComplianceValidationHelper.getInstance().callComplianceValidationService(buildESReplyforCVS(), null,TransactionIdGenerator.getInstance().nextId(),null);
			
			if(null == cvsReply) {
				connected = false;
			}
		} catch (Exception e) {
			ESLog.error("error occured when connecting to CVS", e);
			connected = false;
		}
		
		return connected;
	}
	
    private static EIAMessage buildESReplyforCVS() {
		// TODO Auto-generated method stub
    	EIAMessage message =EIAMessageHelper.createEmptyEIAReplyMessage("");
    	message.getMessageBody().setEsReply(new EsReply());
    	message.getMessageBody().getEsReply().setEsReplyChoice(new EsReplyChoice());
    	message.getMessageBody().getEsReply().getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
    	message.getMessageBody().getEsReply().getEsReplyChoice().getWarrantyEntitlement().setOOS(new OOSComplexType());
    	
    	message.getMessageBody().getEsReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().addSerialNumber("CVSCONNECTIVITYSN");
    	message.getMessageBody().getEsReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().setProduct(new ProductComplexType());
    	message.getMessageBody().getEsReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct().setProductID("CVSCONNECTIVITYPN");
    	message.getMessageBody().getEsReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getProduct().setProductLineCode("CVS");
		return message;
	}

	public static void main(String[] args) {
    	
        System.out.println("Connection " + ((CVSConnectivity.testConnectivity() == true ) ? "SUCCESSFUL" : "FAILED"));
        System.out.println("Configuration: \n" + CVSConnectivity.getConfig());
    }

}
