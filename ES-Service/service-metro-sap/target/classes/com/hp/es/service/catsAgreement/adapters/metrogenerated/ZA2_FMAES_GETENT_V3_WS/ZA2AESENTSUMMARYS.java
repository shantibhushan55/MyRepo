
package com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZA2_AES_ENT_SUMMARY_S complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZA2_AES_ENT_SUMMARY_S">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ENTITLEMENT_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ENTITLEMENT_START_DATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="ENTITLEMENT_END_DATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="ENTITLEMENT_STATUS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ENTITLEMENT_DAYS_LEFT" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZA2_AES_ENT_SUMMARY_S", propOrder = {
    "entitlementtype",
    "entitlementstartdate",
    "entitlementenddate",
    "entitlementstatus",
    "entitlementdaysleft"
})
public class ZA2AESENTSUMMARYS {

    @XmlElement(name = "ENTITLEMENT_TYPE")
    protected String entitlementtype;
    @XmlElement(name = "ENTITLEMENT_START_DATE")
    protected String entitlementstartdate;
    @XmlElement(name = "ENTITLEMENT_END_DATE")
    protected String entitlementenddate;
    @XmlElement(name = "ENTITLEMENT_STATUS")
    protected String entitlementstatus;
    @XmlElement(name = "ENTITLEMENT_DAYS_LEFT")
    protected Integer entitlementdaysleft;

    /**
     * Gets the value of the entitlementtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTITLEMENTTYPE() {
        return entitlementtype;
    }

    /**
     * Sets the value of the entitlementtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTITLEMENTTYPE(String value) {
        this.entitlementtype = value;
    }

    /**
     * Gets the value of the entitlementstartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTITLEMENTSTARTDATE() {
        return entitlementstartdate;
    }

    /**
     * Sets the value of the entitlementstartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTITLEMENTSTARTDATE(String value) {
        this.entitlementstartdate = value;
    }

    /**
     * Gets the value of the entitlementenddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTITLEMENTENDDATE() {
        return entitlementenddate;
    }

    /**
     * Sets the value of the entitlementenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTITLEMENTENDDATE(String value) {
        this.entitlementenddate = value;
    }

    /**
     * Gets the value of the entitlementstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTITLEMENTSTATUS() {
        return entitlementstatus;
    }

    /**
     * Sets the value of the entitlementstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTITLEMENTSTATUS(String value) {
        this.entitlementstatus = value;
    }

    /**
     * Gets the value of the entitlementdaysleft property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getENTITLEMENTDAYSLEFT() {
        return entitlementdaysleft;
    }

    /**
     * Sets the value of the entitlementdaysleft property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setENTITLEMENTDAYSLEFT(Integer value) {
        this.entitlementdaysleft = value;
    }

}
