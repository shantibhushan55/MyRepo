package com.hp.es.service.plumbing;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.xml.EIAMessageHelper;
import com.hp.es.service.wsInterface.EsHttpService;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.MessageBody;
import com.hp.ruc.metrics.MetricsHandler;

public class EsServiceConnectivity {
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;

    public static int getServiceStatus() {
        EsRequestComplexType request = buildEsRequest();

        if (testServiceConnectivity(request) == true)
            return SUCCESS;
        else
            return FAILURE;
    }

    public static boolean testServiceConnectivity(EsRequestComplexType request) {
        EsHttpService service = new EsHttpService();

        EIAMessage eiaRequest = EIAMessageHelper.createEmptyEIARequestMessage("");
        eiaRequest.getMessageBody().setEsRequest(request);

        // call ES Service
        EIAMessage eiaReply = (EIAMessage) service.processMessage(eiaRequest, new MetricsHandler());

        return isReplySuccessful(eiaReply);
    }

    /**
     * the following responses can be used as success:
     *      - a normal reply
     *      - errors with the error code from 202 to 300
     * 
     * @param eiaReply
     * @return
     */
    private static boolean isReplySuccessful(EIAMessage eiaReply) {
        MessageBody messageBody = eiaReply.getMessageBody();
        EsReply esReply = messageBody.getEsReply();
        if (esReply != null) {
            ESLog.debug("Testing connectivity for ES SUCCESSFUL; We got an esReply.");
            return true;
        }

        EIAError eiaError = messageBody.getEIAError();
        int errorId = Integer.parseInt(eiaError.getErrorID());
        if (errorId <= 300 && errorId >= 202) {
            ESLog.debug("Testing connectivity for ES SUCCESSFUL; We got an eiaError: " + eiaError.getErrorID() + "; " + eiaError.getErrorText());
            return true;
        }

        ESLog.debug("Testing connectivity for ES FAILED; We got an eiaError: " + eiaError.getErrorID() + "; " + eiaError.getErrorText());
        return false;
    }

    private static EsRequestComplexType buildEsRequest() {
        EsRequestComplexType request = new EsRequestComplexType();
        EsRequestComplexTypeChoice complexTypeChoice = new EsRequestComplexTypeChoice();

        request.setEsRequestComplexTypeChoice(complexTypeChoice);

        EntitlementBySnRequest snRequest = new EntitlementBySnRequest();
        complexTypeChoice.setEntitlementBySnRequest(snRequest);

        // Set all necessary parameters for the request
        request.setClientAppID("es");
        request.setOperation("getEntitlementBySn");
        snRequest.setSerialNumber(Configuration.getInstance().getProperties().getProperty(EsConstants.ES_PLUMBING_SERVICE_SN));
        snRequest.setIncludeContracts(true);
        snRequest.setIncludeWarranty(true);
        snRequest.setIsoCountryCd(Configuration.getInstance().getProperties().getProperty(EsConstants.ES_PLUMBING_SERVICE_COUNTRYCODE));
        return request;
    }

    public static void main(String[] args) {

        System.out.println(EsServiceConnectivity.getServiceStatus());
    }
}
