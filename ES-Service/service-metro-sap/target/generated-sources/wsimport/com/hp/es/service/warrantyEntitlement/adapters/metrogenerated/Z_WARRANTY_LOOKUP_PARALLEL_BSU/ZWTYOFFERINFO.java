
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_OFFERINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_OFFERINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OFFERPRODUCTID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OFFEROBLIGATIONTYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OFFERDESC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OFFERSTARTDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="OFFERENDDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="MODIFIER" type="{urn:sap-com:document:sap:rfc:functions}ZMODIFIERINFO" minOccurs="0"/>
 *         &lt;element name="DELIVERABLE" type="{urn:sap-com:document:sap:rfc:functions}ZDELIVERABLEINFO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZWTY_OFFERINFO", propOrder = {
    "offerproductid",
    "offerobligationtype",
    "offerdesc",
    "offerstartdate",
    "offerenddate",
    "modifier",
    "deliverable"
})
public class ZWTYOFFERINFO {

    @XmlElement(name = "OFFERPRODUCTID")
    protected String offerproductid;
    @XmlElement(name = "OFFEROBLIGATIONTYPE")
    protected String offerobligationtype;
    @XmlElement(name = "OFFERDESC")
    protected String offerdesc;
    @XmlElement(name = "OFFERSTARTDATE")
    protected String offerstartdate;
    @XmlElement(name = "OFFERENDDATE")
    protected String offerenddate;
    @XmlElement(name = "MODIFIER")
    protected ZMODIFIERINFO modifier;
    @XmlElement(name = "DELIVERABLE")
    protected ZDELIVERABLEINFO deliverable;

    /**
     * Gets the value of the offerproductid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFERPRODUCTID() {
        return offerproductid;
    }

    /**
     * Sets the value of the offerproductid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFERPRODUCTID(String value) {
        this.offerproductid = value;
    }

    /**
     * Gets the value of the offerobligationtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFEROBLIGATIONTYPE() {
        return offerobligationtype;
    }

    /**
     * Sets the value of the offerobligationtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFEROBLIGATIONTYPE(String value) {
        this.offerobligationtype = value;
    }

    /**
     * Gets the value of the offerdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFERDESC() {
        return offerdesc;
    }

    /**
     * Sets the value of the offerdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFERDESC(String value) {
        this.offerdesc = value;
    }

    /**
     * Gets the value of the offerstartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFERSTARTDATE() {
        return offerstartdate;
    }

    /**
     * Sets the value of the offerstartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFERSTARTDATE(String value) {
        this.offerstartdate = value;
    }

    /**
     * Gets the value of the offerenddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFERENDDATE() {
        return offerenddate;
    }

    /**
     * Sets the value of the offerenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFERENDDATE(String value) {
        this.offerenddate = value;
    }

    /**
     * Gets the value of the modifier property.
     * 
     * @return
     *     possible object is
     *     {@link ZMODIFIERINFO }
     *     
     */
    public ZMODIFIERINFO getMODIFIER() {
        return modifier;
    }

    /**
     * Sets the value of the modifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZMODIFIERINFO }
     *     
     */
    public void setMODIFIER(ZMODIFIERINFO value) {
        this.modifier = value;
    }

    /**
     * Gets the value of the deliverable property.
     * 
     * @return
     *     possible object is
     *     {@link ZDELIVERABLEINFO }
     *     
     */
    public ZDELIVERABLEINFO getDELIVERABLE() {
        return deliverable;
    }

    /**
     * Sets the value of the deliverable property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZDELIVERABLEINFO }
     *     
     */
    public void setDELIVERABLE(ZDELIVERABLEINFO value) {
        this.deliverable = value;
    }

}
