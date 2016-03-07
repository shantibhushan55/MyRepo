
package com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY;

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
 *       &lt;sequence>
 *         &lt;element name="SERIALNUM" type="{urn:sap-com:document:sap:rfc:functions}SerialNumber"/>
 *         &lt;element name="PRODUCTNUM" type="{urn:sap-com:document:sap:rfc:functions}ProductNumber"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serialnum",
    "productnum"
})
@XmlRootElement(name = "Z_WARRANTY_EVENT_HISTORY")
public class ZWARRANTYEVENTHISTORY {

    @XmlElement(name = "SERIALNUM", required = true)
    protected String serialnum;
    @XmlElement(name = "PRODUCTNUM", required = true)
    protected String productnum;

    /**
     * Gets the value of the serialnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIALNUM() {
        return serialnum;
    }

    /**
     * Sets the value of the serialnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIALNUM(String value) {
        this.serialnum = value;
    }

    /**
     * Gets the value of the productnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTNUM() {
        return productnum;
    }

    /**
     * Sets the value of the productnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTNUM(String value) {
        this.productnum = value;
    }

}
