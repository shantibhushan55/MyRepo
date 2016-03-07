
package com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_CONTRACT_REQUEST_SUM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_CONTRACT_REQUEST_SUM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SVC_AGREEMENT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_SW_PRODUCTS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_HW_PRODUCTS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_JW_PRODUCTS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
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
 *         &lt;element name="ACTIVE_CONTRACTS_ONLY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SERVICEABLE_PRODUCTS_ONLY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SERVICEABLE_PROD_OFFER_LIST" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_SERVICEABLE_PROD_SUM_T" minOccurs="0"/>
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
 *         &lt;element name="INCLUDE_SW_SERVICE_LEVEL_CAT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCLUDE_FUNCTIONAL_LOCATION" minOccurs="0">
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
@XmlType(name = "ZES_CQS_CONTRACT_REQUEST_SUM", propOrder = {
    "svcagreementid",
    "includeswproducts",
    "includehwproducts",
    "includejwproducts",
    "checkdate",
    "activecontractsonly",
    "serviceableproductsonly",
    "serviceableprodofferlist",
    "includeaddresses",
    "includecontacts",
    "includeservices",
    "includedeliverables",
    "includeswservicelevelcat",
    "includefunctionallocation",
    "includeruntime"
})
public class ZESCQSCONTRACTREQUESTSUM {

    @XmlElement(name = "SVC_AGREEMENT_ID")
    protected String svcagreementid;
    @XmlElement(name = "INCLUDE_SW_PRODUCTS")
    protected String includeswproducts;
    @XmlElement(name = "INCLUDE_HW_PRODUCTS")
    protected String includehwproducts;
    @XmlElement(name = "INCLUDE_JW_PRODUCTS")
    protected String includejwproducts;
    @XmlElement(name = "CHECK_DATE")
    protected String checkdate;
    @XmlElement(name = "ACTIVE_CONTRACTS_ONLY")
    protected String activecontractsonly;
    @XmlElement(name = "SERVICEABLE_PRODUCTS_ONLY")
    protected String serviceableproductsonly;
    @XmlElement(name = "SERVICEABLE_PROD_OFFER_LIST")
    protected ZESCQSSERVICEABLEPRODSUMT serviceableprodofferlist;
    @XmlElement(name = "INCLUDE_ADDRESSES")
    protected String includeaddresses;
    @XmlElement(name = "INCLUDE_CONTACTS")
    protected String includecontacts;
    @XmlElement(name = "INCLUDE_SERVICES")
    protected String includeservices;
    @XmlElement(name = "INCLUDE_DELIVERABLES")
    protected String includedeliverables;
    @XmlElement(name = "INCLUDE_SW_SERVICE_LEVEL_CAT")
    protected String includeswservicelevelcat;
    @XmlElement(name = "INCLUDE_FUNCTIONAL_LOCATION")
    protected String includefunctionallocation;
    @XmlElement(name = "INCLUDE_RUNTIME")
    protected String includeruntime;

    /**
     * Gets the value of the svcagreementid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSVCAGREEMENTID() {
        return svcagreementid;
    }

    /**
     * Sets the value of the svcagreementid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSVCAGREEMENTID(String value) {
        this.svcagreementid = value;
    }

    /**
     * Gets the value of the includeswproducts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDESWPRODUCTS() {
        return includeswproducts;
    }

    /**
     * Sets the value of the includeswproducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDESWPRODUCTS(String value) {
        this.includeswproducts = value;
    }

    /**
     * Gets the value of the includehwproducts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDEHWPRODUCTS() {
        return includehwproducts;
    }

    /**
     * Sets the value of the includehwproducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDEHWPRODUCTS(String value) {
        this.includehwproducts = value;
    }

    /**
     * Gets the value of the includejwproducts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDEJWPRODUCTS() {
        return includejwproducts;
    }

    /**
     * Sets the value of the includejwproducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDEJWPRODUCTS(String value) {
        this.includejwproducts = value;
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
     * Gets the value of the serviceableproductsonly property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEABLEPRODUCTSONLY() {
        return serviceableproductsonly;
    }

    /**
     * Sets the value of the serviceableproductsonly property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEABLEPRODUCTSONLY(String value) {
        this.serviceableproductsonly = value;
    }

    /**
     * Gets the value of the serviceableprodofferlist property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSSERVICEABLEPRODSUMT }
     *     
     */
    public ZESCQSSERVICEABLEPRODSUMT getSERVICEABLEPRODOFFERLIST() {
        return serviceableprodofferlist;
    }

    /**
     * Sets the value of the serviceableprodofferlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSSERVICEABLEPRODSUMT }
     *     
     */
    public void setSERVICEABLEPRODOFFERLIST(ZESCQSSERVICEABLEPRODSUMT value) {
        this.serviceableprodofferlist = value;
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
     * Gets the value of the includeswservicelevelcat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDESWSERVICELEVELCAT() {
        return includeswservicelevelcat;
    }

    /**
     * Sets the value of the includeswservicelevelcat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDESWSERVICELEVELCAT(String value) {
        this.includeswservicelevelcat = value;
    }

    /**
     * Gets the value of the includefunctionallocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCLUDEFUNCTIONALLOCATION() {
        return includefunctionallocation;
    }

    /**
     * Sets the value of the includefunctionallocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCLUDEFUNCTIONALLOCATION(String value) {
        this.includefunctionallocation = value;
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
