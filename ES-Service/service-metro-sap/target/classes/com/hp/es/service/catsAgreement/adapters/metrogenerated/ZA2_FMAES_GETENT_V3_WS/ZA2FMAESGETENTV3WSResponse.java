
package com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ENTITLEMENT" type="{urn:sap-com:document:sap:rfc:functions}ZA2_AES_ENT_WEBSERVICE_V3_S"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "ZA2_FMAES_GETENT_V3_WS.Response")
public class ZA2FMAESGETENTV3WSResponse {

    @XmlElement(name = "ENTITLEMENT", required = true)
    protected ZA2AESENTWEBSERVICEV3S entitlement;

    /**
     * Gets the value of the entitlement property.
     * 
     * @return
     *     possible object is
     *     {@link ZA2AESENTWEBSERVICEV3S }
     *     
     */
    public ZA2AESENTWEBSERVICEV3S getENTITLEMENT() {
        return entitlement;
    }

    /**
     * Sets the value of the entitlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZA2AESENTWEBSERVICEV3S }
     *     
     */
    public void setENTITLEMENT(ZA2AESENTWEBSERVICEV3S value) {
        this.entitlement = value;
    }

}
