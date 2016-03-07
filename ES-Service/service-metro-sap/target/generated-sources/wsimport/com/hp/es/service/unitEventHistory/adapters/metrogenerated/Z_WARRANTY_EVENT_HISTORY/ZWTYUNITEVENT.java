
package com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_UNIT_EVENT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_UNIT_EVENT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EVENT_SERIALNUM" type="{urn:sap-com:document:sap:rfc:functions}SerialNumber" minOccurs="0"/>
 *         &lt;element name="EVENT_PRODUCTNUM" type="{urn:sap-com:document:sap:rfc:functions}ProductNumber" minOccurs="0"/>
 *         &lt;element name="OWNERSHIPTYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EVENT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EVENT_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EVENT_DATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="EVENT_COUNTRY_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SRC_SYS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CREATE_DATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="SRC_SYS_TRANS_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EVENTDETAILS" type="{urn:sap-com:document:sap:rfc:functions}ZWTY_EVENT_DETAILS_TT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZWTY_UNIT_EVENT", propOrder = {
    "eventserialnum",
    "eventproductnum",
    "ownershiptype",
    "eventid",
    "eventtype",
    "eventdate",
    "eventcountrycode",
    "srcsys",
    "createdate",
    "srcsystransid",
    "eventdetails"
})
public class ZWTYUNITEVENT {

    @XmlElement(name = "EVENT_SERIALNUM")
    protected String eventserialnum;
    @XmlElement(name = "EVENT_PRODUCTNUM")
    protected String eventproductnum;
    @XmlElement(name = "OWNERSHIPTYPE")
    protected String ownershiptype;
    @XmlElement(name = "EVENT_ID")
    protected String eventid;
    @XmlElement(name = "EVENT_TYPE")
    protected String eventtype;
    @XmlElement(name = "EVENT_DATE")
    protected String eventdate;
    @XmlElement(name = "EVENT_COUNTRY_CODE")
    protected String eventcountrycode;
    @XmlElement(name = "SRC_SYS")
    protected String srcsys;
    @XmlElement(name = "CREATE_DATE")
    protected String createdate;
    @XmlElement(name = "SRC_SYS_TRANS_ID")
    protected String srcsystransid;
    @XmlElement(name = "EVENTDETAILS")
    protected ZWTYEVENTDETAILSTT eventdetails;

    /**
     * Gets the value of the eventserialnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTSERIALNUM() {
        return eventserialnum;
    }

    /**
     * Sets the value of the eventserialnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTSERIALNUM(String value) {
        this.eventserialnum = value;
    }

    /**
     * Gets the value of the eventproductnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTPRODUCTNUM() {
        return eventproductnum;
    }

    /**
     * Sets the value of the eventproductnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTPRODUCTNUM(String value) {
        this.eventproductnum = value;
    }

    /**
     * Gets the value of the ownershiptype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOWNERSHIPTYPE() {
        return ownershiptype;
    }

    /**
     * Sets the value of the ownershiptype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOWNERSHIPTYPE(String value) {
        this.ownershiptype = value;
    }

    /**
     * Gets the value of the eventid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTID() {
        return eventid;
    }

    /**
     * Sets the value of the eventid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTID(String value) {
        this.eventid = value;
    }

    /**
     * Gets the value of the eventtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTTYPE() {
        return eventtype;
    }

    /**
     * Sets the value of the eventtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTTYPE(String value) {
        this.eventtype = value;
    }

    /**
     * Gets the value of the eventdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTDATE() {
        return eventdate;
    }

    /**
     * Sets the value of the eventdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTDATE(String value) {
        this.eventdate = value;
    }

    /**
     * Gets the value of the eventcountrycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTCOUNTRYCODE() {
        return eventcountrycode;
    }

    /**
     * Sets the value of the eventcountrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTCOUNTRYCODE(String value) {
        this.eventcountrycode = value;
    }

    /**
     * Gets the value of the srcsys property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRCSYS() {
        return srcsys;
    }

    /**
     * Sets the value of the srcsys property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRCSYS(String value) {
        this.srcsys = value;
    }

    /**
     * Gets the value of the createdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREATEDATE() {
        return createdate;
    }

    /**
     * Sets the value of the createdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREATEDATE(String value) {
        this.createdate = value;
    }

    /**
     * Gets the value of the srcsystransid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRCSYSTRANSID() {
        return srcsystransid;
    }

    /**
     * Sets the value of the srcsystransid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRCSYSTRANSID(String value) {
        this.srcsystransid = value;
    }

    /**
     * Gets the value of the eventdetails property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYEVENTDETAILSTT }
     *     
     */
    public ZWTYEVENTDETAILSTT getEVENTDETAILS() {
        return eventdetails;
    }

    /**
     * Sets the value of the eventdetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYEVENTDETAILSTT }
     *     
     */
    public void setEVENTDETAILS(ZWTYEVENTDETAILSTT value) {
        this.eventdetails = value;
    }

}
