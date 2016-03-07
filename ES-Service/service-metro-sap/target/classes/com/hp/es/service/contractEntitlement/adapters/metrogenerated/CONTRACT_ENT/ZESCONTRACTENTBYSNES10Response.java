
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

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
 *         &lt;element name="ES_REPLY" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_ENTITLEMENT_REPLY_V1"/>
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
@XmlRootElement(name = "ZES_CONTRACT_ENT_BY_SN_ES10.Response")
public class ZESCONTRACTENTBYSNES10Response {

    @XmlElement(name = "ES_REPLY", required = true)
    protected ZESCQSENTITLEMENTREPLYV1 esreply;

    /**
     * Gets the value of the esreply property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSENTITLEMENTREPLYV1 }
     *     
     */
    public ZESCQSENTITLEMENTREPLYV1 getESREPLY() {
        return esreply;
    }

    /**
     * Sets the value of the esreply property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSENTITLEMENTREPLYV1 }
     *     
     */
    public void setESREPLY(ZESCQSENTITLEMENTREPLYV1 value) {
        this.esreply = value;
    }

}
