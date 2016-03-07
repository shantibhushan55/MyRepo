
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_OOSINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_OOSINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OOSKEY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SERIALNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SALESORDERNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OMSYSTEMDESC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SHIPFROMCTRY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SHIPTOCTRY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SHIPTOCUSTNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SALESCHANNEL" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PURCHASEAGREENUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCTALIAS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PROOFOFPURCHASEDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="SHIPMENTDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="INSTALLATIONDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="BORNONDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="FACTORYRESTARTDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZWTY_OOSINFO", propOrder = {
    "ooskey",
    "serialnum",
    "salesordernum",
    "omsystemdesc",
    "shipfromctry",
    "shiptoctry",
    "shiptocustnum",
    "saleschannel",
    "purchaseagreenum",
    "productalias",
    "proofofpurchasedate",
    "shipmentdate",
    "installationdate",
    "bornondate",
    "factoryrestartdate"
})
public class ZWTYOOSINFO {

    @XmlElement(name = "OOSKEY")
    protected String ooskey;
    @XmlElement(name = "SERIALNUM")
    protected String serialnum;
    @XmlElement(name = "SALESORDERNUM")
    protected String salesordernum;
    @XmlElement(name = "OMSYSTEMDESC")
    protected String omsystemdesc;
    @XmlElement(name = "SHIPFROMCTRY")
    protected String shipfromctry;
    @XmlElement(name = "SHIPTOCTRY")
    protected String shiptoctry;
    @XmlElement(name = "SHIPTOCUSTNUM")
    protected String shiptocustnum;
    @XmlElement(name = "SALESCHANNEL")
    protected String saleschannel;
    @XmlElement(name = "PURCHASEAGREENUM")
    protected String purchaseagreenum;
    @XmlElement(name = "PRODUCTALIAS")
    protected String productalias;
    @XmlElement(name = "PROOFOFPURCHASEDATE")
    protected String proofofpurchasedate;
    @XmlElement(name = "SHIPMENTDATE")
    protected String shipmentdate;
    @XmlElement(name = "INSTALLATIONDATE")
    protected String installationdate;
    @XmlElement(name = "BORNONDATE")
    protected String bornondate;
    @XmlElement(name = "FACTORYRESTARTDATE")
    protected String factoryrestartdate;

    /**
     * Gets the value of the ooskey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOOSKEY() {
        return ooskey;
    }

    /**
     * Sets the value of the ooskey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOOSKEY(String value) {
        this.ooskey = value;
    }

    /**
     * Gets the value of the serialnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIALNUM() {
        return serialnum;
    }

    /**
     * Sets the value of the serialnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIALNUM(String value) {
        this.serialnum = value;
    }

    /**
     * Gets the value of the salesordernum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSALESORDERNUM() {
        return salesordernum;
    }

    /**
     * Sets the value of the salesordernum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSALESORDERNUM(String value) {
        this.salesordernum = value;
    }

    /**
     * Gets the value of the omsystemdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOMSYSTEMDESC() {
        return omsystemdesc;
    }

    /**
     * Sets the value of the omsystemdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOMSYSTEMDESC(String value) {
        this.omsystemdesc = value;
    }

    /**
     * Gets the value of the shipfromctry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHIPFROMCTRY() {
        return shipfromctry;
    }

    /**
     * Sets the value of the shipfromctry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHIPFROMCTRY(String value) {
        this.shipfromctry = value;
    }

    /**
     * Gets the value of the shiptoctry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHIPTOCTRY() {
        return shiptoctry;
    }

    /**
     * Sets the value of the shiptoctry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHIPTOCTRY(String value) {
        this.shiptoctry = value;
    }

    /**
     * Gets the value of the shiptocustnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHIPTOCUSTNUM() {
        return shiptocustnum;
    }

    /**
     * Sets the value of the shiptocustnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHIPTOCUSTNUM(String value) {
        this.shiptocustnum = value;
    }

    /**
     * Gets the value of the saleschannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSALESCHANNEL() {
        return saleschannel;
    }

    /**
     * Sets the value of the saleschannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSALESCHANNEL(String value) {
        this.saleschannel = value;
    }

    /**
     * Gets the value of the purchaseagreenum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPURCHASEAGREENUM() {
        return purchaseagreenum;
    }

    /**
     * Sets the value of the purchaseagreenum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPURCHASEAGREENUM(String value) {
        this.purchaseagreenum = value;
    }

    /**
     * Gets the value of the productalias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTALIAS() {
        return productalias;
    }

    /**
     * Sets the value of the productalias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTALIAS(String value) {
        this.productalias = value;
    }

    /**
     * Gets the value of the proofofpurchasedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROOFOFPURCHASEDATE() {
        return proofofpurchasedate;
    }

    /**
     * Sets the value of the proofofpurchasedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROOFOFPURCHASEDATE(String value) {
        this.proofofpurchasedate = value;
    }

    /**
     * Gets the value of the shipmentdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHIPMENTDATE() {
        return shipmentdate;
    }

    /**
     * Sets the value of the shipmentdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHIPMENTDATE(String value) {
        this.shipmentdate = value;
    }

    /**
     * Gets the value of the installationdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSTALLATIONDATE() {
        return installationdate;
    }

    /**
     * Sets the value of the installationdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSTALLATIONDATE(String value) {
        this.installationdate = value;
    }

    /**
     * Gets the value of the bornondate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBORNONDATE() {
        return bornondate;
    }

    /**
     * Sets the value of the bornondate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBORNONDATE(String value) {
        this.bornondate = value;
    }

    /**
     * Gets the value of the factoryrestartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFACTORYRESTARTDATE() {
        return factoryrestartdate;
    }

    /**
     * Sets the value of the factoryrestartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFACTORYRESTARTDATE(String value) {
        this.factoryrestartdate = value;
    }

}
