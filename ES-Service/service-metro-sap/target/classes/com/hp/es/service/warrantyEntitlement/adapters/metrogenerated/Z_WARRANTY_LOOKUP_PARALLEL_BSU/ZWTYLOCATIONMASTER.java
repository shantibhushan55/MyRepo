
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTYLOCATIONMASTER complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTYLOCATIONMASTER">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SOURCECUSTOMERID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SITEBUSNAME1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SITEBUSNAME2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SITEBUSNAME3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SITEBUSNAME4" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ADDRESS" type="{urn:sap-com:document:sap:rfc:functions}ZADDRSLINE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZWTYLOCATIONMASTER", propOrder = {
    "sourcecustomerid",
    "sitebusname1",
    "sitebusname2",
    "sitebusname3",
    "sitebusname4",
    "address"
})
public class ZWTYLOCATIONMASTER {

    @XmlElement(name = "SOURCECUSTOMERID")
    protected String sourcecustomerid;
    @XmlElement(name = "SITEBUSNAME1")
    protected String sitebusname1;
    @XmlElement(name = "SITEBUSNAME2")
    protected String sitebusname2;
    @XmlElement(name = "SITEBUSNAME3")
    protected String sitebusname3;
    @XmlElement(name = "SITEBUSNAME4")
    protected String sitebusname4;
    @XmlElement(name = "ADDRESS")
    protected ZADDRSLINE address;

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
     * Gets the value of the sitebusname1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEBUSNAME1() {
        return sitebusname1;
    }

    /**
     * Sets the value of the sitebusname1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEBUSNAME1(String value) {
        this.sitebusname1 = value;
    }

    /**
     * Gets the value of the sitebusname2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEBUSNAME2() {
        return sitebusname2;
    }

    /**
     * Sets the value of the sitebusname2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEBUSNAME2(String value) {
        this.sitebusname2 = value;
    }

    /**
     * Gets the value of the sitebusname3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEBUSNAME3() {
        return sitebusname3;
    }

    /**
     * Sets the value of the sitebusname3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEBUSNAME3(String value) {
        this.sitebusname3 = value;
    }

    /**
     * Gets the value of the sitebusname4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEBUSNAME4() {
        return sitebusname4;
    }

    /**
     * Sets the value of the sitebusname4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEBUSNAME4(String value) {
        this.sitebusname4 = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link ZADDRSLINE }
     *     
     */
    public ZADDRSLINE getADDRESS() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZADDRSLINE }
     *     
     */
    public void setADDRESS(ZADDRSLINE value) {
        this.address = value;
    }

}
