
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZADDRSLINE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZADDRSLINE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FMTADDRLINE1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMTADDRLINE2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMTADDRLINE3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMTADDRLINE4" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMTADDRLINE5" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="STREETADDR1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="STREETADDR2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="POSTBOXNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CITY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CITYAREA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CITYSUBAREA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GEOGRAPHICAREA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="25"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GEOGRAPHICSBAREA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="25"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GEOREGIONDESC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="25"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="POSTALCODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HPCTRYCD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ISOCTRYCD" minOccurs="0">
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
@XmlType(name = "ZADDRSLINE", propOrder = {
    "fmtaddrline1",
    "fmtaddrline2",
    "fmtaddrline3",
    "fmtaddrline4",
    "fmtaddrline5",
    "streetaddr1",
    "streetaddr2",
    "postboxnum",
    "city",
    "cityarea",
    "citysubarea",
    "geographicarea",
    "geographicsbarea",
    "georegiondesc",
    "postalcode",
    "hpctrycd",
    "isoctrycd"
})
public class ZADDRSLINE {

    @XmlElement(name = "FMTADDRLINE1")
    protected String fmtaddrline1;
    @XmlElement(name = "FMTADDRLINE2")
    protected String fmtaddrline2;
    @XmlElement(name = "FMTADDRLINE3")
    protected String fmtaddrline3;
    @XmlElement(name = "FMTADDRLINE4")
    protected String fmtaddrline4;
    @XmlElement(name = "FMTADDRLINE5")
    protected String fmtaddrline5;
    @XmlElement(name = "STREETADDR1")
    protected String streetaddr1;
    @XmlElement(name = "STREETADDR2")
    protected String streetaddr2;
    @XmlElement(name = "POSTBOXNUM")
    protected String postboxnum;
    @XmlElement(name = "CITY")
    protected String city;
    @XmlElement(name = "CITYAREA")
    protected String cityarea;
    @XmlElement(name = "CITYSUBAREA")
    protected String citysubarea;
    @XmlElement(name = "GEOGRAPHICAREA")
    protected String geographicarea;
    @XmlElement(name = "GEOGRAPHICSBAREA")
    protected String geographicsbarea;
    @XmlElement(name = "GEOREGIONDESC")
    protected String georegiondesc;
    @XmlElement(name = "POSTALCODE")
    protected String postalcode;
    @XmlElement(name = "HPCTRYCD")
    protected String hpctrycd;
    @XmlElement(name = "ISOCTRYCD")
    protected String isoctrycd;

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
     * Gets the value of the postboxnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTBOXNUM() {
        return postboxnum;
    }

    /**
     * Sets the value of the postboxnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTBOXNUM(String value) {
        this.postboxnum = value;
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
     * Gets the value of the cityarea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCITYAREA() {
        return cityarea;
    }

    /**
     * Sets the value of the cityarea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCITYAREA(String value) {
        this.cityarea = value;
    }

    /**
     * Gets the value of the citysubarea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCITYSUBAREA() {
        return citysubarea;
    }

    /**
     * Sets the value of the citysubarea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCITYSUBAREA(String value) {
        this.citysubarea = value;
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
     * Gets the value of the geographicsbarea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEOGRAPHICSBAREA() {
        return geographicsbarea;
    }

    /**
     * Sets the value of the geographicsbarea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEOGRAPHICSBAREA(String value) {
        this.geographicsbarea = value;
    }

    /**
     * Gets the value of the georegiondesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEOREGIONDESC() {
        return georegiondesc;
    }

    /**
     * Sets the value of the georegiondesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEOREGIONDESC(String value) {
        this.georegiondesc = value;
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
     * Gets the value of the hpctrycd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPCTRYCD() {
        return hpctrycd;
    }

    /**
     * Sets the value of the hpctrycd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPCTRYCD(String value) {
        this.hpctrycd = value;
    }

    /**
     * Gets the value of the isoctrycd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCTRYCD() {
        return isoctrycd;
    }

    /**
     * Sets the value of the isoctrycd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCTRYCD(String value) {
        this.isoctrycd = value;
    }

}
