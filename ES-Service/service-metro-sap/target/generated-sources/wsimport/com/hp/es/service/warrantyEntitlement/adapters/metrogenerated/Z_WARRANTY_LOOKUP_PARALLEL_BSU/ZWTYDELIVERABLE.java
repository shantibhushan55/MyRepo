
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTYDELIVERABLE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTYDELIVERABLE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DELIVCODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DELIVNAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DELIVVALUE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
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
@XmlType(name = "ZWTYDELIVERABLE", propOrder = {
    "delivcode",
    "delivname",
    "delivvalue"
})
public class ZWTYDELIVERABLE {

    @XmlElement(name = "DELIVCODE")
    protected String delivcode;
    @XmlElement(name = "DELIVNAME")
    protected String delivname;
    @XmlElement(name = "DELIVVALUE")
    protected String delivvalue;

    /**
     * Gets the value of the delivcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVCODE() {
        return delivcode;
    }

    /**
     * Sets the value of the delivcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVCODE(String value) {
        this.delivcode = value;
    }

    /**
     * Gets the value of the delivname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVNAME() {
        return delivname;
    }

    /**
     * Sets the value of the delivname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVNAME(String value) {
        this.delivname = value;
    }

    /**
     * Gets the value of the delivvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVVALUE() {
        return delivvalue;
    }

    /**
     * Sets the value of the delivvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVVALUE(String value) {
        this.delivvalue = value;
    }

}
