
package com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZA2_AES_OFFER_V3_S complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZA2_AES_OFFER_V3_S">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OFFER_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OFFER_DESCRIPTION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OFFER_START_DATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="OFFER_END_DATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="START_DATE_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OFFER_STATUS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OFFER_LENGTH" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GIS_OFFER_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DELIVERABLE_NAMES" type="{urn:sap-com:document:sap:rfc:functions}ZA2_AES_DELIVERABLE_V3_T" minOccurs="0"/>
 *         &lt;element name="MODIFIER_DESCRIPTIONS" type="{urn:sap-com:document:sap:rfc:functions}ZA2_AES_MODIFIER_V3_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZA2_AES_OFFER_V3_S", propOrder = {
    "offercode",
    "offerdescription",
    "offerstartdate",
    "offerenddate",
    "startdatetype",
    "offerstatus",
    "offerlength",
    "gisoffercode",
    "deliverablenames",
    "modifierdescriptions"
})
public class ZA2AESOFFERV3S {

    @XmlElement(name = "OFFER_CODE")
    protected String offercode;
    @XmlElement(name = "OFFER_DESCRIPTION")
    protected String offerdescription;
    @XmlElement(name = "OFFER_START_DATE")
    protected String offerstartdate;
    @XmlElement(name = "OFFER_END_DATE")
    protected String offerenddate;
    @XmlElement(name = "START_DATE_TYPE")
    protected String startdatetype;
    @XmlElement(name = "OFFER_STATUS")
    protected String offerstatus;
    @XmlElement(name = "OFFER_LENGTH")
    protected String offerlength;
    @XmlElement(name = "GIS_OFFER_CODE")
    protected String gisoffercode;
    @XmlElement(name = "DELIVERABLE_NAMES")
    protected ZA2AESDELIVERABLEV3T deliverablenames;
    @XmlElement(name = "MODIFIER_DESCRIPTIONS")
    protected ZA2AESMODIFIERV3T modifierdescriptions;

    /**
     * Gets the value of the offercode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFERCODE() {
        return offercode;
    }

    /**
     * Sets the value of the offercode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFERCODE(String value) {
        this.offercode = value;
    }

    /**
     * Gets the value of the offerdescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFERDESCRIPTION() {
        return offerdescription;
    }

    /**
     * Sets the value of the offerdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFERDESCRIPTION(String value) {
        this.offerdescription = value;
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
     * Gets the value of the startdatetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTARTDATETYPE() {
        return startdatetype;
    }

    /**
     * Sets the value of the startdatetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTARTDATETYPE(String value) {
        this.startdatetype = value;
    }

    /**
     * Gets the value of the offerstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFERSTATUS() {
        return offerstatus;
    }

    /**
     * Sets the value of the offerstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFERSTATUS(String value) {
        this.offerstatus = value;
    }

    /**
     * Gets the value of the offerlength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFERLENGTH() {
        return offerlength;
    }

    /**
     * Sets the value of the offerlength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFERLENGTH(String value) {
        this.offerlength = value;
    }

    /**
     * Gets the value of the gisoffercode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGISOFFERCODE() {
        return gisoffercode;
    }

    /**
     * Sets the value of the gisoffercode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGISOFFERCODE(String value) {
        this.gisoffercode = value;
    }

    /**
     * Gets the value of the deliverablenames property.
     * 
     * @return
     *     possible object is
     *     {@link ZA2AESDELIVERABLEV3T }
     *     
     */
    public ZA2AESDELIVERABLEV3T getDELIVERABLENAMES() {
        return deliverablenames;
    }

    /**
     * Sets the value of the deliverablenames property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZA2AESDELIVERABLEV3T }
     *     
     */
    public void setDELIVERABLENAMES(ZA2AESDELIVERABLEV3T value) {
        this.deliverablenames = value;
    }

    /**
     * Gets the value of the modifierdescriptions property.
     * 
     * @return
     *     possible object is
     *     {@link ZA2AESMODIFIERV3T }
     *     
     */
    public ZA2AESMODIFIERV3T getMODIFIERDESCRIPTIONS() {
        return modifierdescriptions;
    }

    /**
     * Sets the value of the modifierdescriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZA2AESMODIFIERV3T }
     *     
     */
    public void setMODIFIERDESCRIPTIONS(ZA2AESMODIFIERV3T value) {
        this.modifierdescriptions = value;
    }

}
