package com.hp.es.service.plumbing;

import junit.framework.TestCase;

import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;

public class EsServiceConnectivityTest extends TestCase {
    public void testOKWithReply() {
        EsRequestComplexType request = new EsRequestComplexType();
        EsRequestComplexTypeChoice complexTypeChoice = new EsRequestComplexTypeChoice();

        request.setEsRequestComplexTypeChoice(complexTypeChoice);

        EntitlementBySnRequest snRequest = new EntitlementBySnRequest();
        complexTypeChoice.setEntitlementBySnRequest(snRequest);

        // Set all necessary parameters for the request
        request.setClientAppID("es");
        request.setOperation("getEntitlementBySn");
        snRequest.setSerialNumber("CNU352130A");
        snRequest.setIncludeContracts(true);
        snRequest.setIncludeWarranty(true);
        snRequest.setIsoCountryCd("US");

        assertTrue(EsServiceConnectivity.testServiceConnectivity(request));
    }

    public void testOKWithError() {
        EsRequestComplexType request = new EsRequestComplexType();
        EsRequestComplexTypeChoice complexTypeChoice = new EsRequestComplexTypeChoice();

        request.setEsRequestComplexTypeChoice(complexTypeChoice);

        EntitlementBySnRequest snRequest = new EntitlementBySnRequest();
        complexTypeChoice.setEntitlementBySnRequest(snRequest);

        // Set all necessary parameters for the request
        request.setClientAppID("es");
        request.setOperation("getEntitlementBySn");
        snRequest.setSerialNumber("MCZ05O01001");
        snRequest.setProductID("_A5191B");
        snRequest.setIncludeContracts(true);
        snRequest.setIncludeWarranty(true);
        snRequest.setIsoCountryCd("US");

        assertTrue(EsServiceConnectivity.testServiceConnectivity(request));
    }

    public void testError() {
        EsRequestComplexType request = new EsRequestComplexType();
        EsRequestComplexTypeChoice complexTypeChoice = new EsRequestComplexTypeChoice();

        request.setEsRequestComplexTypeChoice(complexTypeChoice);

        EntitlementBySnRequest snRequest = new EntitlementBySnRequest();
        complexTypeChoice.setEntitlementBySnRequest(snRequest);

        // Set all necessary parameters for the request
        request.setClientAppID("es");
        request.setOperation("getEntitlementBySns");
        snRequest.setSerialNumber("CNU352130A");
        snRequest.setIncludeContracts(true);
        snRequest.setIncludeWarranty(true);
        snRequest.setIsoCountryCd("US");

        assertFalse(EsServiceConnectivity.testServiceConnectivity(request));
    }
}
