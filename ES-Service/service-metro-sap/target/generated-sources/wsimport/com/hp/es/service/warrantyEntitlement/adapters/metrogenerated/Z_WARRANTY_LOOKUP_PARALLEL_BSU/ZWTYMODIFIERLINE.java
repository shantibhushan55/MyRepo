
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTYMODIFIERLINE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTYMODIFIERLINE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MODNAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MODVALUE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MODDESC" minOccurs="0">
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
@XmlType(name = "ZWTYMODIFIERLINE", propOrder = {
    "modname",
    "modvalue",
    "moddesc"
})
public class ZWTYMODIFIERLINE {

    @XmlElement(name = "MODNAME")
    protected String modname;
    @XmlElement(name = "MODVALUE")
    protected String modvalue;
    @XmlElement(name = "MODDESC")
    protected String moddesc;

    /**
     * Gets the value of the modname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODNAME() {
        return modname;
    }

    /**
     * Sets the value of the modname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODNAME(String value) {
        this.modname = value;
    }

    /**
     * Gets the value of the modvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODVALUE() {
        return modvalue;
    }

    /**
     * Sets the value of the modvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODVALUE(String value) {
        this.modvalue = value;
    }

    /**
     * Gets the value of the moddesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODDESC() {
        return moddesc;
    }

    /**
     * Sets the value of the moddesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODDESC(String value) {
        this.moddesc = value;
    }

}
