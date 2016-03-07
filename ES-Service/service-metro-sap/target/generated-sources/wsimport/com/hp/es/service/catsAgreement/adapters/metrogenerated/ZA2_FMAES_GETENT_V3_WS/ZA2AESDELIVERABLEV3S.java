
package com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZA2_AES_DELIVERABLE_V3_S complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZA2_AES_DELIVERABLE_V3_S">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DELIVERABLE_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DELIVERABLE_VALUE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DELIVERABLE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
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
@XmlType(name = "ZA2_AES_DELIVERABLE_V3_S", propOrder = {
    "deliverablename",
    "deliverablevalue",
    "deliverable"
})
public class ZA2AESDELIVERABLEV3S {

    @XmlElement(name = "DELIVERABLE_NAME")
    protected String deliverablename;
    @XmlElement(name = "DELIVERABLE_VALUE")
    protected String deliverablevalue;
    @XmlElement(name = "DELIVERABLE")
    protected String deliverable;

    /**
     * Gets the value of the deliverablename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERABLENAME() {
        return deliverablename;
    }

    /**
     * Sets the value of the deliverablename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERABLENAME(String value) {
        this.deliverablename = value;
    }

    /**
     * Gets the value of the deliverablevalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERABLEVALUE() {
        return deliverablevalue;
    }

    /**
     * Sets the value of the deliverablevalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERABLEVALUE(String value) {
        this.deliverablevalue = value;
    }

    /**
     * Gets the value of the deliverable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERABLE() {
        return deliverable;
    }

    /**
     * Sets the value of the deliverable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERABLE(String value) {
        this.deliverable = value;
    }

}
