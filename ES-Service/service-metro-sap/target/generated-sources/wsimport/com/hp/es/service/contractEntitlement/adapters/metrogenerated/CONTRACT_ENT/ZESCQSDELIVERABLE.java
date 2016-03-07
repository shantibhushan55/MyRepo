
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_DELIVERABLE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_DELIVERABLE">
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
 *         &lt;element name="DELIV_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELIV_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELIV_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELIV_MODIFIERS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_MODIFIERS_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_DELIVERABLE", propOrder = {
    "mandt",
    "delivcode",
    "delivname",
    "delivvalue",
    "delivmodifiers"
})
public class ZESCQSDELIVERABLE {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "DELIV_CODE")
    protected String delivcode;
    @XmlElement(name = "DELIV_NAME")
    protected String delivname;
    @XmlElement(name = "DELIV_VALUE")
    protected String delivvalue;
    @XmlElement(name = "DELIV_MODIFIERS")
    protected ZESCQSMODIFIERST delivmodifiers;

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

    /**
     * Gets the value of the delivmodifiers property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSMODIFIERST }
     *     
     */
    public ZESCQSMODIFIERST getDELIVMODIFIERS() {
        return delivmodifiers;
    }

    /**
     * Sets the value of the delivmodifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSMODIFIERST }
     *     
     */
    public void setDELIVMODIFIERS(ZESCQSMODIFIERST value) {
        this.delivmodifiers = value;
    }

}
