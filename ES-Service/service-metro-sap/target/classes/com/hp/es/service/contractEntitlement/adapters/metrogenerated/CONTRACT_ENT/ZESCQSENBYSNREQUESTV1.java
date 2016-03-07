
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_ENBYSN_REQUEST_V1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_ENBYSN_REQUEST_V1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SERIAL_NUMBER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CHECK_DATE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SOURCE_CUSTOMER_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTRACT_IDENTIFIER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTRACT_IDENTIFIER_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DATA_ENTRY_SITE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ACTIVE_SERVICES_ONLY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ACTIVE_CONTRACTS_ONLY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_ADDRESSES" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_CONTACTS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_CUSTOMER_ID_INFO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_SERVICES" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_DELIVERABLES" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_MODIFIERS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_MV_INFOR" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_RUNTIME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
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
@XmlType(name = "ZES_CQS_ENBYSN_REQUEST_V1", propOrder = {
    "serialnumber",
    "productid",
    "checkdate",
    "sourcecustomerid",
    "contractidentifier",
    "contractidentifiertype",
    "dataentrysite",
    "activeservicesonly",
    "activecontractsonly",
    "includeaddresses",
    "includecontacts",
    "includecustomeridinfo",
    "includeservices",
    "includedeliverables",
    "includemodifiers",
    "includemvinfor",
    "includeruntime"
})
public class ZESCQSENBYSNREQUESTV1 {

    @XmlElement(name = "SERIAL_NUMBER")
    protected String serialnumber;
    @XmlElement(name = "PRODUCT_ID")
    protected String productid;
    @XmlElement(name = "CHECK_DATE")
    protected String checkdate;
    @XmlElement(name = "SOURCE_CUSTOMER_ID")
    protected String sourcecustomerid;
    @XmlElement(name = "CONTRACT_IDENTIFIER")
    protected String contractidentifier;
    @XmlElement(name = "CONTRACT_IDENTIFIER_TYPE")
    protected String contractidentifiertype;
    @XmlElement(name = "DATA_ENTRY_SITE")
    protected String dataentrysite;
    @XmlElement(name = "ACTIVE_SERVICES_ONLY")
    protected String activeservicesonly;
    @XmlElement(name = "ACTIVE_CONTRACTS_ONLY")
    protected String activecontractsonly;
    @XmlElement(name = "INCLUDE_ADDRESSES")
    protected String includeaddresses;
    @XmlElement(name = "INCLUDE_CONTACTS")
    protected String includecontacts;
    @XmlElement(name = "INCLUDE_CUSTOMER_ID_INFO")
    protected String includecustomeridinfo;
    @XmlElement(name = "INCLUDE_SERVICES")
    protected String includeservices;
    @XmlElement(name = "INCLUDE_DELIVERABLES")
    protected String includedeliverables;
    @XmlElement(name = "INCLUDE_MODIFIERS")
    protected String includemodifiers;
    @XmlElement(name = "INCLUDE_MV_INFOR")
    protected String includemvinfor;
    @XmlElement(name = "INCLUDE_RUNTIME")
    protected String includeruntime;

    /**
     * Gets the value of the serialnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIALNUMBER() {
        return serialnumber;
    }

    /**
     * Sets the value of the serialnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIALNUMBER(String value) {
        this.serialnumber = value;
    }

    /**
     * Gets the value of the productid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTID() {
        return productid;
    }

    /**
     * Sets the value of the productid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTID(String value) {
        this.productid = value;
    }

    /**
     * Gets the value of the checkdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHECKDATE() {
        return checkdate;
    }

    /**
     * Sets the value of the checkdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHECKDATE(String value) {
        this.checkdate = value;
    }

    /**
     * Gets the value of the sourcecustomerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOURCECUSTOMERID() {
        return sourcecustomerid;
    }

    /**
     * Sets the value of the sourcecustomerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOURCECUSTOMERID(String value) {
        this.sourcecustomerid = value;
    }

    /**
     * Gets the value of the contractidentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTRACTIDENTIFIER() {
        return contractidentifier;
    }

    /**
     * Sets the value of the contractidentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTRACTIDENTIFIER(String value) {
        this.contractidentifier = value;
    }

    /**
     * Gets the value of the contractidentifiertype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTRACTIDENTIFIERTYPE() {
        return contractidentifiertype;
    }

    /**
     * Sets the value of the contractidentifiertype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTRACTIDENTIFIERTYPE(String value) {
        this.contractidentifiertype = value;
    }

    /**
     * Gets the value of the dataentrysite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATAENTRYSITE() {
        return dataentrysite;
    }

    /**
     * Sets the value of the dataentrysite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATAENTRYSITE(String value) {
        this.dataentrysite = value;
    }

    /**
     * Gets the value of the activeservicesonly property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVESERVICESONLY() {
        return activeservicesonly;
    }

    /**
     * Sets the value of the activeservicesonly property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIVESERVICESONLY(String value) {
        this.activeservicesonly = value;
    }

    /**
     * Gets the value of the activecontractsonly property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVECONTRACTSONLY() {
        return activecontractsonly;
    }

    /**
     * Sets the value of the activecontractsonly property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIVECONTRACTSONLY(String value) {
        this.activecontractsonly = value;
    }

    /**
     * Gets the value of the includeaddresses property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDEADDRESSES() {
        return includeaddresses;
    }

    /**
     * Sets the value of the includeaddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDEADDRESSES(String value) {
        this.includeaddresses = value;
    }

    /**
     * Gets the value of the includecontacts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDECONTACTS() {
        return includecontacts;
    }

    /**
     * Sets the value of the includecontacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDECONTACTS(String value) {
        this.includecontacts = value;
    }

    /**
     * Gets the value of the includecustomeridinfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDECUSTOMERIDINFO() {
        return includecustomeridinfo;
    }

    /**
     * Sets the value of the includecustomeridinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDECUSTOMERIDINFO(String value) {
        this.includecustomeridinfo = value;
    }

    /**
     * Gets the value of the includeservices property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDESERVICES() {
        return includeservices;
    }

    /**
     * Sets the value of the includeservices property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDESERVICES(String value) {
        this.includeservices = value;
    }

    /**
     * Gets the value of the includedeliverables property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDEDELIVERABLES() {
        return includedeliverables;
    }

    /**
     * Sets the value of the includedeliverables property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDEDELIVERABLES(String value) {
        this.includedeliverables = value;
    }

    /**
     * Gets the value of the includemodifiers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDEMODIFIERS() {
        return includemodifiers;
    }

    /**
     * Sets the value of the includemodifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDEMODIFIERS(String value) {
        this.includemodifiers = value;
    }

    /**
     * Gets the value of the includemvinfor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDEMVINFOR() {
        return includemvinfor;
    }

    /**
     * Sets the value of the includemvinfor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDEMVINFOR(String value) {
        this.includemvinfor = value;
    }

    /**
     * Gets the value of the includeruntime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDERUNTIME() {
        return includeruntime;
    }

    /**
     * Sets the value of the includeruntime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDERUNTIME(String value) {
        this.includeruntime = value;
    }

}
