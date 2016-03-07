
package com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZGIS_ROUTING_DETAILS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZGIS_ROUTING_DETAILS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SOLD_TO_COMPANY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CUSTOMER_SEGMENT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTRACT_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SPECIAL_HANDLING" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BUSINESS_CODES" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_BUSINESS_CODES" minOccurs="0"/>
 *         &lt;element name="RESPONSE_TIME_VALUES" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_RESP_TIME_VALUES" minOccurs="0"/>
 *         &lt;element name="REPAIR_TIME_VALUES" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_REPAIR_TIME_VALUES" minOccurs="0"/>
 *         &lt;element name="RESTORATION_TIME_VALUES" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_REST_TIME_VALUES" minOccurs="0"/>
 *         &lt;element name="MESSAGES" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_MESSAGES_T" minOccurs="0"/>
 *         &lt;element name="PROC_STATE" minOccurs="0">
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
@XmlType(name = "ZGIS_ROUTING_DETAILS", propOrder = {
    "soldtocompany",
    "customersegment",
    "contracttype",
    "specialhandling",
    "businesscodes",
    "responsetimevalues",
    "repairtimevalues",
    "restorationtimevalues",
    "messages",
    "procstate"
})
public class ZGISROUTINGDETAILS {

    @XmlElement(name = "SOLD_TO_COMPANY")
    protected String soldtocompany;
    @XmlElement(name = "CUSTOMER_SEGMENT")
    protected String customersegment;
    @XmlElement(name = "CONTRACT_TYPE")
    protected String contracttype;
    @XmlElement(name = "SPECIAL_HANDLING")
    protected String specialhandling;
    @XmlElement(name = "BUSINESS_CODES")
    protected ZESCQSBUSINESSCODES businesscodes;
    @XmlElement(name = "RESPONSE_TIME_VALUES")
    protected ZESCQSRESPTIMEVALUES responsetimevalues;
    @XmlElement(name = "REPAIR_TIME_VALUES")
    protected ZESCQSREPAIRTIMEVALUES repairtimevalues;
    @XmlElement(name = "RESTORATION_TIME_VALUES")
    protected ZESCQSRESTTIMEVALUES restorationtimevalues;
    @XmlElement(name = "MESSAGES")
    protected ZESCQSMESSAGEST messages;
    @XmlElement(name = "PROC_STATE")
    protected String procstate;

    /**
     * Gets the value of the soldtocompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOLDTOCOMPANY() {
        return soldtocompany;
    }

    /**
     * Sets the value of the soldtocompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOLDTOCOMPANY(String value) {
        this.soldtocompany = value;
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
     * Gets the value of the contracttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTRACTTYPE() {
        return contracttype;
    }

    /**
     * Sets the value of the contracttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTRACTTYPE(String value) {
        this.contracttype = value;
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
     * Gets the value of the businesscodes property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSBUSINESSCODES }
     *     
     */
    public ZESCQSBUSINESSCODES getBUSINESSCODES() {
        return businesscodes;
    }

    /**
     * Sets the value of the businesscodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSBUSINESSCODES }
     *     
     */
    public void setBUSINESSCODES(ZESCQSBUSINESSCODES value) {
        this.businesscodes = value;
    }

    /**
     * Gets the value of the responsetimevalues property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSRESPTIMEVALUES }
     *     
     */
    public ZESCQSRESPTIMEVALUES getRESPONSETIMEVALUES() {
        return responsetimevalues;
    }

    /**
     * Sets the value of the responsetimevalues property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSRESPTIMEVALUES }
     *     
     */
    public void setRESPONSETIMEVALUES(ZESCQSRESPTIMEVALUES value) {
        this.responsetimevalues = value;
    }

    /**
     * Gets the value of the repairtimevalues property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSREPAIRTIMEVALUES }
     *     
     */
    public ZESCQSREPAIRTIMEVALUES getREPAIRTIMEVALUES() {
        return repairtimevalues;
    }

    /**
     * Sets the value of the repairtimevalues property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSREPAIRTIMEVALUES }
     *     
     */
    public void setREPAIRTIMEVALUES(ZESCQSREPAIRTIMEVALUES value) {
        this.repairtimevalues = value;
    }

    /**
     * Gets the value of the restorationtimevalues property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSRESTTIMEVALUES }
     *     
     */
    public ZESCQSRESTTIMEVALUES getRESTORATIONTIMEVALUES() {
        return restorationtimevalues;
    }

    /**
     * Sets the value of the restorationtimevalues property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSRESTTIMEVALUES }
     *     
     */
    public void setRESTORATIONTIMEVALUES(ZESCQSRESTTIMEVALUES value) {
        this.restorationtimevalues = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSMESSAGEST }
     *     
     */
    public ZESCQSMESSAGEST getMESSAGES() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSMESSAGEST }
     *     
     */
    public void setMESSAGES(ZESCQSMESSAGEST value) {
        this.messages = value;
    }

    /**
     * Gets the value of the procstate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROCSTATE() {
        return procstate;
    }

    /**
     * Sets the value of the procstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROCSTATE(String value) {
        this.procstate = value;
    }

}
