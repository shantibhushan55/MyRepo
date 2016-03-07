
package com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * SAP Service ZES_CONTRACT_SUM_ES10 via SOAP
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ZES_CONTRACT_SUM_ES10Service", targetNamespace = "urn:sap-com:document:sap:rfc:functions", wsdlLocation = "ZES_CONTRACT_SUM_ES10/ZES_CONTRACT_SUM_ES10.wsdl")
public class ZESCONTRACTSUMES10Service
    extends Service
{

    private final static URL ZESCONTRACTSUMES10SERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Service.class.getResource(".");
            url = new URL(baseUrl, "ZES_CONTRACT_SUM_ES10/ZES_CONTRACT_SUM_ES10.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'ZES_CONTRACT_SUM_ES10/ZES_CONTRACT_SUM_ES10.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        ZESCONTRACTSUMES10SERVICE_WSDL_LOCATION = url;
    }

    public ZESCONTRACTSUMES10Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ZESCONTRACTSUMES10Service() {
        super(ZESCONTRACTSUMES10SERVICE_WSDL_LOCATION, new QName("urn:sap-com:document:sap:rfc:functions", "ZES_CONTRACT_SUM_ES10Service"));
    }

    /**
     * 
     * @return
     *     returns ZESCONTRACTSUMES10PortType
     */
    @WebEndpoint(name = "ZES_CONTRACT_SUM_ES10PortType")
    public ZESCONTRACTSUMES10PortType getZESCONTRACTSUMES10PortType() {
        return super.getPort(new QName("urn:sap-com:document:sap:rfc:functions", "ZES_CONTRACT_SUM_ES10PortType"), ZESCONTRACTSUMES10PortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ZESCONTRACTSUMES10PortType
     */
    @WebEndpoint(name = "ZES_CONTRACT_SUM_ES10PortType")
    public ZESCONTRACTSUMES10PortType getZESCONTRACTSUMES10PortType(WebServiceFeature... features) {
        return super.getPort(new QName("urn:sap-com:document:sap:rfc:functions", "ZES_CONTRACT_SUM_ES10PortType"), ZESCONTRACTSUMES10PortType.class, features);
    }

}
