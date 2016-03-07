
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
 *         &lt;element name="SVC_AGREEMENT_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlRootElement(name = "ZES_ROUTING_DETAILS_ES10")
public class ZESROUTINGDETAILSES10 {

    @XmlElement(name = "SVC_AGREEMENT_ID", required = true)
    protected String svcagreementid;

    /**
     * Gets the value of the svcagreementid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSVCAGREEMENTID() {
        return svcagreementid;
    }

    /**
     * Sets the value of the svcagreementid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSVCAGREEMENTID(String value) {
        this.svcagreementid = value;
    }

}
