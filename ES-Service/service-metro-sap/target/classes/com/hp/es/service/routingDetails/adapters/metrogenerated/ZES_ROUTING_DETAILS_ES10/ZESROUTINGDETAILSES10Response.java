
package com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10;

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
 *         &lt;element name="ROUTING_DETAILS" type="{urn:sap-com:document:sap:rfc:functions}ZGIS_ROUTING_DETAILS"/>
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
@XmlRootElement(name = "ZES_ROUTING_DETAILS_ES10.Response")
public class ZESROUTINGDETAILSES10Response {

    @XmlElement(name = "ROUTING_DETAILS", required = true)
    protected ZGISROUTINGDETAILS routingdetails;

    /**
     * Gets the value of the routingdetails property.
     * 
     * @return
     *     possible object is
     *     {@link ZGISROUTINGDETAILS }
     *     
     */
    public ZGISROUTINGDETAILS getROUTINGDETAILS() {
        return routingdetails;
    }

    /**
     * Sets the value of the routingdetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZGISROUTINGDETAILS }
     *     
     */
    public void setROUTINGDETAILS(ZGISROUTINGDETAILS value) {
        this.routingdetails = value;
    }

}
