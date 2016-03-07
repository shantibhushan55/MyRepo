
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_OBLIGATION_HEADER_V1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_OBLIGATION_HEADER_V1">
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
 *         &lt;element name="SOURCE_OBLIGATION_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBLIGATION_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTRACT_DOC_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CCRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUST_PURCHASE_ORDER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORIGINATING_ORDER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HEADER_START_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HEADER_END_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTRACT_STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELIVERY_BLOCK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE_OBLIGATION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHANNEL_PROFILE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHANNEL_RELATIONSHIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPECIAL_HANDLING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SUPPORT_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMP_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUST_SERVICE_AGREEMENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUSTOMER_SEGMENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRODUCT_SHIP_TO_COUNTRY_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CDO_PUBLISH_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SW_SERVICE_LEVEL_CATEGORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPECIAL_INSTRUCTIONS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBLIGATION_CONTACT" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_OBLIGATION_CONTACTS_T" minOccurs="0"/>
 *         &lt;element name="OBLIGATION_LOCATION" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_OBLIGATION_LOCATIONS_T" minOccurs="0"/>
 *         &lt;element name="SERVICES" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_SERVICES_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_OBLIGATION_HEADER_V1", propOrder = {
    "mandt",
    "sourceobligationid",
    "obligationtype",
    "contractdoctype",
    "ccrn",
    "custpurchaseorder",
    "originatingorder",
    "headerstartdate",
    "headerenddate",
    "contractstatus",
    "deliveryblock",
    "activeobligation",
    "channelprofile",
    "channelrelationship",
    "specialhandling",
    "supportgroupid",
    "ampid",
    "custserviceagreement",
    "customersegment",
    "productshiptocountrycode",
    "cdopublishdate",
    "swservicelevelcategory",
    "specialinstructions",
    "obligationcontact",
    "obligationlocation",
    "services"
})
public class ZESCQSOBLIGATIONHEADERV1 {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "SOURCE_OBLIGATION_ID")
    protected String sourceobligationid;
    @XmlElement(name = "OBLIGATION_TYPE")
    protected String obligationtype;
    @XmlElement(name = "CONTRACT_DOC_TYPE")
    protected String contractdoctype;
    @XmlElement(name = "CCRN")
    protected String ccrn;
    @XmlElement(name = "CUST_PURCHASE_ORDER")
    protected String custpurchaseorder;
    @XmlElement(name = "ORIGINATING_ORDER")
    protected String originatingorder;
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
    @XmlElement(name = "CHANNEL_PROFILE")
    protected String channelprofile;
    @XmlElement(name = "CHANNEL_RELATIONSHIP")
    protected String channelrelationship;
    @XmlElement(name = "SPECIAL_HANDLING")
    protected String specialhandling;
    @XmlElement(name = "SUPPORT_GROUP_ID")
    protected String supportgroupid;
    @XmlElement(name = "AMP_ID")
    protected String ampid;
    @XmlElement(name = "CUST_SERVICE_AGREEMENT")
    protected String custserviceagreement;
    @XmlElement(name = "CUSTOMER_SEGMENT")
    protected String customersegment;
    @XmlElement(name = "PRODUCT_SHIP_TO_COUNTRY_CODE")
    protected String productshiptocountrycode;
    @XmlElement(name = "CDO_PUBLISH_DATE")
    protected String cdopublishdate;
    @XmlElement(name = "SW_SERVICE_LEVEL_CATEGORY")
    protected String swservicelevelcategory;
    @XmlElement(name = "SPECIAL_INSTRUCTIONS")
    protected String specialinstructions;
    @XmlElement(name = "OBLIGATION_CONTACT")
    protected ZESCQSOBLIGATIONCONTACTST obligationcontact;
    @XmlElement(name = "OBLIGATION_LOCATION")
    protected ZESCQSOBLIGATIONLOCATIONST obligationlocation;
    @XmlElement(name = "SERVICES")
    protected ZESCQSSERVICEST services;

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
     * Gets the value of the obligationtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBLIGATIONTYPE() {
        return obligationtype;
    }

    /**
     * Sets the value of the obligationtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBLIGATIONTYPE(String value) {
        this.obligationtype = value;
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
     * Gets the value of the ccrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCRN() {
        return ccrn;
    }

    /**
     * Sets the value of the ccrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCRN(String value) {
        this.ccrn = value;
    }

    /**
     * Gets the value of the custpurchaseorder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTPURCHASEORDER() {
        return custpurchaseorder;
    }

    /**
     * Sets the value of the custpurchaseorder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTPURCHASEORDER(String value) {
        this.custpurchaseorder = value;
    }

    /**
     * Gets the value of the originatingorder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORIGINATINGORDER() {
        return originatingorder;
    }

    /**
     * Sets the value of the originatingorder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORIGINATINGORDER(String value) {
        this.originatingorder = value;
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
     * Gets the value of the channelprofile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHANNELPROFILE() {
        return channelprofile;
    }

    /**
     * Sets the value of the channelprofile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHANNELPROFILE(String value) {
        this.channelprofile = value;
    }

    /**
     * Gets the value of the channelrelationship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHANNELRELATIONSHIP() {
        return channelrelationship;
    }

    /**
     * Sets the value of the channelrelationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHANNELRELATIONSHIP(String value) {
        this.channelrelationship = value;
    }

    /**
     * Gets the value of the specialhandling property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPECIALHANDLING() {
        return specialhandling;
    }

    /**
     * Sets the value of the specialhandling property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPECIALHANDLING(String value) {
        this.specialhandling = value;
    }

    /**
     * Gets the value of the supportgroupid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUPPORTGROUPID() {
        return supportgroupid;
    }

    /**
     * Sets the value of the supportgroupid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUPPORTGROUPID(String value) {
        this.supportgroupid = value;
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
     * Gets the value of the custserviceagreement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTSERVICEAGREEMENT() {
        return custserviceagreement;
    }

    /**
     * Sets the value of the custserviceagreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTSERVICEAGREEMENT(String value) {
        this.custserviceagreement = value;
    }

    /**
     * Gets the value of the customersegment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMERSEGMENT() {
        return customersegment;
    }

    /**
     * Sets the value of the customersegment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMERSEGMENT(String value) {
        this.customersegment = value;
    }

    /**
     * Gets the value of the productshiptocountrycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTSHIPTOCOUNTRYCODE() {
        return productshiptocountrycode;
    }

    /**
     * Sets the value of the productshiptocountrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTSHIPTOCOUNTRYCODE(String value) {
        this.productshiptocountrycode = value;
    }

    /**
     * Gets the value of the cdopublishdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDOPUBLISHDATE() {
        return cdopublishdate;
    }

    /**
     * Sets the value of the cdopublishdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDOPUBLISHDATE(String value) {
        this.cdopublishdate = value;
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
     * Gets the value of the specialinstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPECIALINSTRUCTIONS() {
        return specialinstructions;
    }

    /**
     * Sets the value of the specialinstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPECIALINSTRUCTIONS(String value) {
        this.specialinstructions = value;
    }

    /**
     * Gets the value of the obligationcontact property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSOBLIGATIONCONTACTST }
     *     
     */
    public ZESCQSOBLIGATIONCONTACTST getOBLIGATIONCONTACT() {
        return obligationcontact;
    }

    /**
     * Sets the value of the obligationcontact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSOBLIGATIONCONTACTST }
     *     
     */
    public void setOBLIGATIONCONTACT(ZESCQSOBLIGATIONCONTACTST value) {
        this.obligationcontact = value;
    }

    /**
     * Gets the value of the obligationlocation property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSOBLIGATIONLOCATIONST }
     *     
     */
    public ZESCQSOBLIGATIONLOCATIONST getOBLIGATIONLOCATION() {
        return obligationlocation;
    }

    /**
     * Sets the value of the obligationlocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSOBLIGATIONLOCATIONST }
     *     
     */
    public void setOBLIGATIONLOCATION(ZESCQSOBLIGATIONLOCATIONST value) {
        this.obligationlocation = value;
    }

    /**
     * Gets the value of the services property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSSERVICEST }
     *     
     */
    public ZESCQSSERVICEST getSERVICES() {
        return services;
    }

    /**
     * Sets the value of the services property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSSERVICEST }
     *     
     */
    public void setSERVICES(ZESCQSSERVICEST value) {
        this.services = value;
    }

}
