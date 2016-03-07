
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_MODIFIER complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_MODIFIER">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MANDT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MOD_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MOD_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MOD_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_MODIFIER", propOrder = {
    "mandt",
    "modname",
    "modvalue",
    "moddesc"
})
public class ZESCQSMODIFIER {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "MOD_NAME")
    protected String modname;
    @XmlElement(name = "MOD_VALUE")
    protected String modvalue;
    @XmlElement(name = "MOD_DESC")
    protected String moddesc;

    /**
     * Gets the value of the mandt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMANDT() {
        return mandt;
    }

    /**
     * Sets the value of the mandt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMANDT(String value) {
        this.mandt = value;
    }

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
