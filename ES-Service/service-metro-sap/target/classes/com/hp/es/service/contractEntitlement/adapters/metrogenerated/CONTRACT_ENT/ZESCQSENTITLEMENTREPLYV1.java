
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_ENTITLEMENT_REPLY_V1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_ENTITLEMENT_REPLY_V1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACTIVE_CONTRACT_ENTITLEMENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OVERALL_CONTRACT_START_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OVERALL_CONTRACT_END_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OOS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_OOS_T" minOccurs="0"/>
 *         &lt;element name="CONTRACTS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_CONTRACTS_T_V1" minOccurs="0"/>
 *         &lt;element name="LOCATIONS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_LOCATIONS_T" minOccurs="0"/>
 *         &lt;element name="CONTACTS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_CONTACTS_T" minOccurs="0"/>
 *         &lt;element name="CUSTOMER_IDENTIFICATION" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_CUSTOMER_IDENTITY" minOccurs="0"/>
 *         &lt;element name="MV_INFOR" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_MV_T" minOccurs="0"/>
 *         &lt;element name="UNIT_LIST" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_UNIT" minOccurs="0"/>
 *         &lt;element name="MESSAGES" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_MESSAGES_T" minOccurs="0"/>
 *         &lt;element name="PROC_STATE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RUNTIME" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_RUNTIMES_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_ENTITLEMENT_REPLY_V1", propOrder = {
    "activecontractentitlement",
    "overallcontractstartdate",
    "overallcontractenddate",
    "oos",
    "contracts",
    "locations",
    "contacts",
    "customeridentification",
    "mvinfor",
    "unitlist",
    "messages",
    "procstate",
    "runtime"
})
public class ZESCQSENTITLEMENTREPLYV1 {

    @XmlElement(name = "ACTIVE_CONTRACT_ENTITLEMENT")
    protected String activecontractentitlement;
    @XmlElement(name = "OVERALL_CONTRACT_START_DATE")
    protected String overallcontractstartdate;
    @XmlElement(name = "OVERALL_CONTRACT_END_DATE")
    protected String overallcontractenddate;
    @XmlElement(name = "OOS")
    protected ZESCQSOOST oos;
    @XmlElement(name = "CONTRACTS")
    protected ZESCQSCONTRACTSTV1 contracts;
    @XmlElement(name = "LOCATIONS")
    protected ZESCQSLOCATIONST locations;
    @XmlElement(name = "CONTACTS")
    protected ZESCQSCONTACTST contacts;
    @XmlElement(name = "CUSTOMER_IDENTIFICATION")
    protected ZESCQSCUSTOMERIDENTITY customeridentification;
    @XmlElement(name = "MV_INFOR")
    protected ZESCQSMVT mvinfor;
    @XmlElement(name = "UNIT_LIST")
    protected ZESCQSUNIT unitlist;
    @XmlElement(name = "MESSAGES")
    protected ZESCQSMESSAGEST messages;
    @XmlElement(name = "PROC_STATE")
    protected String procstate;
    @XmlElement(name = "RUNTIME")
    protected ZESCQSRUNTIMEST runtime;

    /**
     * Gets the value of the activecontractentitlement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVECONTRACTENTITLEMENT() {
        return activecontractentitlement;
    }

    /**
     * Sets the value of the activecontractentitlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIVECONTRACTENTITLEMENT(String value) {
        this.activecontractentitlement = value;
    }

    /**
     * Gets the value of the overallcontractstartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOVERALLCONTRACTSTARTDATE() {
        return overallcontractstartdate;
    }

    /**
     * Sets the value of the overallcontractstartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOVERALLCONTRACTSTARTDATE(String value) {
        this.overallcontractstartdate = value;
    }

    /**
     * Gets the value of the overallcontractenddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOVERALLCONTRACTENDDATE() {
        return overallcontractenddate;
    }

    /**
     * Sets the value of the overallcontractenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOVERALLCONTRACTENDDATE(String value) {
        this.overallcontractenddate = value;
    }

    /**
     * Gets the value of the oos property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSOOST }
     *     
     */
    public ZESCQSOOST getOOS() {
        return oos;
    }

    /**
     * Sets the value of the oos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSOOST }
     *     
     */
    public void setOOS(ZESCQSOOST value) {
        this.oos = value;
    }

    /**
     * Gets the value of the contracts property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSCONTRACTSTV1 }
     *     
     */
    public ZESCQSCONTRACTSTV1 getCONTRACTS() {
        return contracts;
    }

    /**
     * Sets the value of the contracts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSCONTRACTSTV1 }
     *     
     */
    public void setCONTRACTS(ZESCQSCONTRACTSTV1 value) {
        this.contracts = value;
    }

    /**
     * Gets the value of the locations property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSLOCATIONST }
     *     
     */
    public ZESCQSLOCATIONST getLOCATIONS() {
        return locations;
    }

    /**
     * Sets the value of the locations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSLOCATIONST }
     *     
     */
    public void setLOCATIONS(ZESCQSLOCATIONST value) {
        this.locations = value;
    }

    /**
     * Gets the value of the contacts property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSCONTACTST }
     *     
     */
    public ZESCQSCONTACTST getCONTACTS() {
        return contacts;
    }

    /**
     * Sets the value of the contacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSCONTACTST }
     *     
     */
    public void setCONTACTS(ZESCQSCONTACTST value) {
        this.contacts = value;
    }

    /**
     * Gets the value of the customeridentification property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSCUSTOMERIDENTITY }
     *     
     */
    public ZESCQSCUSTOMERIDENTITY getCUSTOMERIDENTIFICATION() {
        return customeridentification;
    }

    /**
     * Sets the value of the customeridentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSCUSTOMERIDENTITY }
     *     
     */
    public void setCUSTOMERIDENTIFICATION(ZESCQSCUSTOMERIDENTITY value) {
        this.customeridentification = value;
    }

    /**
     * Gets the value of the mvinfor property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSMVT }
     *     
     */
    public ZESCQSMVT getMVINFOR() {
        return mvinfor;
    }

    /**
     * Sets the value of the mvinfor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSMVT }
     *     
     */
    public void setMVINFOR(ZESCQSMVT value) {
        this.mvinfor = value;
    }

    /**
     * Gets the value of the unitlist property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSUNIT }
     *     
     */
    public ZESCQSUNIT getUNITLIST() {
        return unitlist;
    }

    /**
     * Sets the value of the unitlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSUNIT }
     *     
     */
    public void setUNITLIST(ZESCQSUNIT value) {
        this.unitlist = value;
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

    /**
     * Gets the value of the runtime property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSRUNTIMEST }
     *     
     */
    public ZESCQSRUNTIMEST getRUNTIME() {
        return runtime;
    }

    /**
     * Sets the value of the runtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSRUNTIMEST }
     *     
     */
    public void setRUNTIME(ZESCQSRUNTIMEST value) {
        this.runtime = value;
    }

}
