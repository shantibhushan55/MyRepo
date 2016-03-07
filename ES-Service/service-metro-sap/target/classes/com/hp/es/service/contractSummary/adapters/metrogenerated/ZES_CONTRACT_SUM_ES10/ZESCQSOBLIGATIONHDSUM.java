
package com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_OBLIGATION_HD_SUM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_OBLIGATION_HD_SUM">
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
 *         &lt;element name="SOURCE_OBLIGATION_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTRACT_DOC_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HEADER_START_DATE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HEADER_END_DATE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTRACT_STATUS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DELIVERY_BLOCK" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ACTIVE_OBLIGATION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AMP_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SW_SERVICE_LEVEL_CATEGORY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FUNCTIONAL_LOCATION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HP_ADMIN_PERSON_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SOLD_TO_CUSTOMER_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
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
@XmlType(name = "ZES_CQS_OBLIGATION_HD_SUM", propOrder = {
    "mandt",
    "sourceobligationid",
    "contractdoctype",
    "headerstartdate",
    "headerenddate",
    "contractstatus",
    "deliveryblock",
    "activeobligation",
    "ampid",
    "swservicelevelcategory",
    "functionallocation",
    "hpadminpersonid",
    "soldtocustomerid"
})
public class ZESCQSOBLIGATIONHDSUM {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "SOURCE_OBLIGATION_ID")
    protected String sourceobligationid;
    @XmlElement(name = "CONTRACT_DOC_TYPE")
    protected String contractdoctype;
    @XmlElement(name = "HEADER_START_DATE")
    protected String headerstartdate;
    @XmlElement(name = "HEADER_END_DATE")
    protected String headerenddate;
    @XmlElement(name = "CONTRACT_STATUS")
    protected String contractstatus;
    @XmlElement(name = "DELIVERY_BLOCK")
    protected String deliveryblock;
    @XmlElement(name = "ACTIVE_OBLIGATION")
    protected String activeobligation;
    @XmlElement(name = "AMP_ID")
    protected String ampid;
    @XmlElement(name = "SW_SERVICE_LEVEL_CATEGORY")
    protected String swservicelevelcategory;
    @XmlElement(name = "FUNCTIONAL_LOCATION")
    protected String functionallocation;
    @XmlElement(name = "HP_ADMIN_PERSON_ID")
    protected String hpadminpersonid;
    @XmlElement(name = "SOLD_TO_CUSTOMER_ID")
    protected String soldtocustomerid;

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
     * Gets the value of the sourceobligationid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOURCEOBLIGATIONID() {
        return sourceobligationid;
    }

    /**
     * Sets the value of the sourceobligationid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOURCEOBLIGATIONID(String value) {
        this.sourceobligationid = value;
    }

    /**
     * Gets the value of the contractdoctype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTRACTDOCTYPE() {
        return contractdoctype;
    }

    /**
     * Sets the value of the contractdoctype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTRACTDOCTYPE(String value) {
        this.contractdoctype = value;
    }

    /**
     * Gets the value of the headerstartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHEADERSTARTDATE() {
        return headerstartdate;
    }

    /**
     * Sets the value of the headerstartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHEADERSTARTDATE(String value) {
        this.headerstartdate = value;
    }

    /**
     * Gets the value of the headerenddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHEADERENDDATE() {
        return headerenddate;
    }

    /**
     * Sets the value of the headerenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHEADERENDDATE(String value) {
        this.headerenddate = value;
    }

    /**
     * Gets the value of the contractstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTRACTSTATUS() {
        return contractstatus;
    }

    /**
     * Sets the value of the contractstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTRACTSTATUS(String value) {
        this.contractstatus = value;
    }

    /**
     * Gets the value of the deliveryblock property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERYBLOCK() {
        return deliveryblock;
    }

    /**
     * Sets the value of the deliveryblock property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERYBLOCK(String value) {
        this.deliveryblock = value;
    }

    /**
     * Gets the value of the activeobligation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVEOBLIGATION() {
        return activeobligation;
    }

    /**
     * Sets the value of the activeobligation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIVEOBLIGATION(String value) {
        this.activeobligation = value;
    }

    /**
     * Gets the value of the ampid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMPID() {
        return ampid;
    }

    /**
     * Sets the value of the ampid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMPID(String value) {
        this.ampid = value;
    }

    /**
     * Gets the value of the swservicelevelcategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWSERVICELEVELCATEGORY() {
        return swservicelevelcategory;
    }

    /**
     * Sets the value of the swservicelevelcategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWSERVICELEVELCATEGORY(String value) {
        this.swservicelevelcategory = value;
    }

    /**
     * Gets the value of the functionallocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNCTIONALLOCATION() {
        return functionallocation;
    }

    /**
     * Sets the value of the functionallocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNCTIONALLOCATION(String value) {
        this.functionallocation = value;
    }

    /**
     * Gets the value of the hpadminpersonid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPADMINPERSONID() {
        return hpadminpersonid;
    }

    /**
     * Sets the value of the hpadminpersonid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPADMINPERSONID(String value) {
        this.hpadminpersonid = value;
    }

    /**
     * Gets the value of the soldtocustomerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOLDTOCUSTOMERID() {
        return soldtocustomerid;
    }

    /**
     * Sets the value of the soldtocustomerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOLDTOCUSTOMERID(String value) {
        this.soldtocustomerid = value;
    }

}
