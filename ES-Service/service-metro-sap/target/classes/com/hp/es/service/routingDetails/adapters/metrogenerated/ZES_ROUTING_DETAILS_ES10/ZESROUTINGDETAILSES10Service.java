
package com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * SAP Service ZES_ROUTING_DETAILS_ES10 via SOAP
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ZES_ROUTING_DETAILS_ES10Service", targetNamespace = "urn:sap-com:document:sap:rfc:functions", wsdlLocation = "ZES_ROUTING_DETAILS_ES10/ZES_ROUTING_DETAILS_ES10.wsdl")
public class ZESROUTINGDETAILSES10Service
    extends Service
{

    private final static URL ZESROUTINGDETAILSES10SERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESROUTINGDETAILSES10Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESROUTINGDETAILSES10Service.class.getResource(".");
            url = new URL(baseUrl, "ZES_ROUTING_DETAILS_ES10/ZES_ROUTING_DETAILS_ES10.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'ZES_ROUTING_DETAILS_ES10/ZES_ROUTING_DETAILS_ES10.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        ZESROUTINGDETAILSES10SERVICE_WSDL_LOCATION = url;
    }

    public ZESROUTINGDETAILSES10Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ZESROUTINGDETAILSES10Service() {
        super(ZESROUTINGDETAILSES10SERVICE_WSDL_LOCATION, new QName("urn:sap-com:document:sap:rfc:functions", "ZES_ROUTING_DETAILS_ES10Service"));
    }

    /**
     * 
     * @return
     *     returns ZESROUTINGDETAILSES10PortType
     */
    @WebEndpoint(name = "ZES_ROUTING_DETAILS_ES10PortType")
    public ZESROUTINGDETAILSES10PortType getZESROUTINGDETAILSES10PortType() {
        return super.getPort(new QName("urn:sap-com:document:sap:rfc:functions", "ZES_ROUTING_DETAILS_ES10PortType"), ZESROUTINGDETAILSES10PortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ZESROUTINGDETAILSES10PortType
     */
    @WebEndpoint(name = "ZES_ROUTING_DETAILS_ES10PortType")
    public ZESROUTINGDETAILSES10PortType getZESROUTINGDETAILSES10PortType(WebServiceFeature... features) {
        return super.getPort(new QName("urn:sap-com:document:sap:rfc:functions", "ZES_ROUTING_DETAILS_ES10PortType"), ZESROUTINGDETAILSES10PortType.class, features);
    }

}
