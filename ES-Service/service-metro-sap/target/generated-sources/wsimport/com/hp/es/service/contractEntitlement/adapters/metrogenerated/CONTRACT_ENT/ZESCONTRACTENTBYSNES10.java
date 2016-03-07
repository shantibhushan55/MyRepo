
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
 *         &lt;element name="ES_REQUEST" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_ENBYSN_REQUEST_V1"/>
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
@XmlRootElement(name = "ZES_CONTRACT_ENT_BY_SN_ES10")
public class ZESCONTRACTENTBYSNES10 {

    @XmlElement(name = "ES_REQUEST", required = true)
    protected ZESCQSENBYSNREQUESTV1 esrequest;

    /**
     * Gets the value of the esrequest property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSENBYSNREQUESTV1 }
     *     
     */
    public ZESCQSENBYSNREQUESTV1 getESREQUEST() {
        return esrequest;
    }

    /**
     * Sets the value of the esrequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSENBYSNREQUESTV1 }
     *     
     */
    public void setESREQUEST(ZESCQSENBYSNREQUESTV1 value) {
        this.esrequest = value;
    }

}
