
package com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_LOCATION_SUM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_LOCATION_SUM">
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
 *         &lt;element name="SOURCE_CUSTOMER_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SITE_BUSINESS_NAME1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SITE_BUSINESS_NAME2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SITE_BUSINESS_NAME3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SITE_BUSINESS_NAME4" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMT_ADDR_LINE1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMT_ADDR_LINE2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMT_ADDR_LINE3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMT_ADDR_LINE4" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMT_ADDR_LINE5" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="STREET_ADDR1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="STREET_ADDR2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CITY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GEOGRAPHIC_AREA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="POSTAL_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ISO_COUNTRY_CD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
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
@XmlType(name = "ZES_CQS_LOCATION_SUM", propOrder = {
    "mandt",
    "sourcecustomerid",
    "sitebusinessname1",
    "sitebusinessname2",
    "sitebusinessname3",
    "sitebusinessname4",
    "fmtaddrline1",
    "fmtaddrline2",
    "fmtaddrline3",
    "fmtaddrline4",
    "fmtaddrline5",
    "streetaddr1",
    "streetaddr2",
    "city",
    "geographicarea",
    "postalcode",
    "isocountrycd"
})
public class ZESCQSLOCATIONSUM {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "SOURCE_CUSTOMER_ID")
    protected String sourcecustomerid;
    @XmlElement(name = "SITE_BUSINESS_NAME1")
    protected String sitebusinessname1;
    @XmlElement(name = "SITE_BUSINESS_NAME2")
    protected String sitebusinessname2;
    @XmlElement(name = "SITE_BUSINESS_NAME3")
    protected String sitebusinessname3;
    @XmlElement(name = "SITE_BUSINESS_NAME4")
    protected String sitebusinessname4;
    @XmlElement(name = "FMT_ADDR_LINE1")
    protected String fmtaddrline1;
    @XmlElement(name = "FMT_ADDR_LINE2")
    protected String fmtaddrline2;
    @XmlElement(name = "FMT_ADDR_LINE3")
    protected String fmtaddrline3;
    @XmlElement(name = "FMT_ADDR_LINE4")
    protected String fmtaddrline4;
    @XmlElement(name = "FMT_ADDR_LINE5")
    protected String fmtaddrline5;
    @XmlElement(name = "STREET_ADDR1")
    protected String streetaddr1;
    @XmlElement(name = "STREET_ADDR2")
    protected String streetaddr2;
    @XmlElement(name = "CITY")
    protected String city;
    @XmlElement(name = "GEOGRAPHIC_AREA")
    protected String geographicarea;
    @XmlElement(name = "POSTAL_CODE")
    protected String postalcode;
    @XmlElement(name = "ISO_COUNTRY_CD")
    protected String isocountrycd;

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
     * Gets the value of the sitebusinessname1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEBUSINESSNAME1() {
        return sitebusinessname1;
    }

    /**
     * Sets the value of the sitebusinessname1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEBUSINESSNAME1(String value) {
        this.sitebusinessname1 = value;
    }

    /**
     * Gets the value of the sitebusinessname2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEBUSINESSNAME2() {
        return sitebusinessname2;
    }

    /**
     * Sets the value of the sitebusinessname2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEBUSINESSNAME2(String value) {
        this.sitebusinessname2 = value;
    }

    /**
     * Gets the value of the sitebusinessname3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEBUSINESSNAME3() {
        return sitebusinessname3;
    }

    /**
     * Sets the value of the sitebusinessname3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEBUSINESSNAME3(String value) {
        this.sitebusinessname3 = value;
    }

    /**
     * Gets the value of the sitebusinessname4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEBUSINESSNAME4() {
        return sitebusinessname4;
    }

    /**
     * Sets the value of the sitebusinessname4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEBUSINESSNAME4(String value) {
        this.sitebusinessname4 = value;
    }

    /**
     * Gets the value of the fmtaddrline1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFMTADDRLINE1() {
        return fmtaddrline1;
    }

    /**
     * Sets the value of the fmtaddrline1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFMTADDRLINE1(String value) {
        this.fmtaddrline1 = value;
    }

    /**
     * Gets the value of the fmtaddrline2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFMTADDRLINE2() {
        return fmtaddrline2;
    }

    /**
     * Sets the value of the fmtaddrline2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFMTADDRLINE2(String value) {
        this.fmtaddrline2 = value;
    }

    /**
     * Gets the value of the fmtaddrline3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFMTADDRLINE3() {
        return fmtaddrline3;
    }

    /**
     * Sets the value of the fmtaddrline3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFMTADDRLINE3(String value) {
        this.fmtaddrline3 = value;
    }

    /**
     * Gets the value of the fmtaddrline4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFMTADDRLINE4() {
        return fmtaddrline4;
    }

    /**
     * Sets the value of the fmtaddrline4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFMTADDRLINE4(String value) {
        this.fmtaddrline4 = value;
    }

    /**
     * Gets the value of the fmtaddrline5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFMTADDRLINE5() {
        return fmtaddrline5;
    }

    /**
     * Sets the value of the fmtaddrline5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFMTADDRLINE5(String value) {
        this.fmtaddrline5 = value;
    }

    /**
     * Gets the value of the streetaddr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTREETADDR1() {
        return streetaddr1;
    }

    /**
     * Sets the value of the streetaddr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTREETADDR1(String value) {
        this.streetaddr1 = value;
    }

    /**
     * Gets the value of the streetaddr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTREETADDR2() {
        return streetaddr2;
    }

    /**
     * Sets the value of the streetaddr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTREETADDR2(String value) {
        this.streetaddr2 = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCITY() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCITY(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the geographicarea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEOGRAPHICAREA() {
        return geographicarea;
    }

    /**
     * Sets the value of the geographicarea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEOGRAPHICAREA(String value) {
        this.geographicarea = value;
    }

    /**
     * Gets the value of the postalcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTALCODE() {
        return postalcode;
    }

    /**
     * Sets the value of the postalcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTALCODE(String value) {
        this.postalcode = value;
    }

    /**
     * Gets the value of the isocountrycd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCOUNTRYCD() {
        return isocountrycd;
    }

    /**
     * Sets the value of the isocountrycd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCOUNTRYCD(String value) {
        this.isocountrycd = value;
    }

}
