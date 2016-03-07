
package com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_PRODUCT_ID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_PRODUCT_ID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SVC_PRODUCT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_PRODUCT_ID", propOrder = {
    "svcproductid"
})
public class ZESCQSPRODUCTID {

    @XmlElement(name = "SVC_PRODUCT_ID")
    protected String svcproductid;

    /**
     * Gets the value of the svcproductid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSVCPRODUCTID() {
        return svcproductid;
    }

    /**
     * Sets the value of the svcproductid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSVCPRODUCTID(String value) {
        this.svcproductid = value;
    }

}
