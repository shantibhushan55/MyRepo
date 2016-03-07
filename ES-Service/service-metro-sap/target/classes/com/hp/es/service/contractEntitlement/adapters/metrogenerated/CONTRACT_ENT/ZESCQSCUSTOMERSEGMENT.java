
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_CUSTOMER_SEGMENT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_CUSTOMER_SEGMENT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SEGMENT_OWNER_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEGMENT_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_CUSTOMER_SEGMENT", propOrder = {
    "segmentownercode",
    "segmentcode"
})
public class ZESCQSCUSTOMERSEGMENT {

    @XmlElement(name = "SEGMENT_OWNER_CODE")
    protected String segmentownercode;
    @XmlElement(name = "SEGMENT_CODE")
    protected String segmentcode;

    /**
     * Gets the value of the segmentownercode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEGMENTOWNERCODE() {
        return segmentownercode;
    }

    /**
     * Sets the value of the segmentownercode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEGMENTOWNERCODE(String value) {
        this.segmentownercode = value;
    }

    /**
     * Gets the value of the segmentcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEGMENTCODE() {
        return segmentcode;
    }

    /**
     * Sets the value of the segmentcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEGMENTCODE(String value) {
        this.segmentcode = value;
    }

}
