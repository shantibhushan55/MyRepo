
package com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZA2_AES_MODIFIER_V3_S complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZA2_AES_MODIFIER_V3_S">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MODIFIER_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MODIFIER_VALUE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MODIFIER" minOccurs="0">
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
@XmlType(name = "ZA2_AES_MODIFIER_V3_S", propOrder = {
    "modifiername",
    "modifiervalue",
    "modifier"
})
public class ZA2AESMODIFIERV3S {

    @XmlElement(name = "MODIFIER_NAME")
    protected String modifiername;
    @XmlElement(name = "MODIFIER_VALUE")
    protected String modifiervalue;
    @XmlElement(name = "MODIFIER")
    protected String modifier;

    /**
     * Gets the value of the modifiername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODIFIERNAME() {
        return modifiername;
    }

    /**
     * Sets the value of the modifiername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODIFIERNAME(String value) {
        this.modifiername = value;
    }

    /**
     * Gets the value of the modifiervalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODIFIERVALUE() {
        return modifiervalue;
    }

    /**
     * Sets the value of the modifiervalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODIFIERVALUE(String value) {
        this.modifiervalue = value;
    }

    /**
     * Gets the value of the modifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODIFIER() {
        return modifier;
    }

    /**
     * Sets the value of the modifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODIFIER(String value) {
        this.modifier = value;
    }

}
