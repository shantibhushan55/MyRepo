
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_PRODINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_PRODINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PRODUCTNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCTDESC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCTLINECODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCTLINEDESC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INSTALLATIONFLAG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SITEPREPARATION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCTINTRODATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="PARTINFO" type="{urn:sap-com:document:sap:rfc:functions}ZPARTLIST" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZWTY_PRODINFO", propOrder = {
    "productnum",
    "productdesc",
    "productlinecode",
    "productlinedesc",
    "installationflag",
    "sitepreparation",
    "productintrodate",
    "partinfo"
})
public class ZWTYPRODINFO {

    @XmlElement(name = "PRODUCTNUM")
    protected String productnum;
    @XmlElement(name = "PRODUCTDESC")
    protected String productdesc;
    @XmlElement(name = "PRODUCTLINECODE")
    protected String productlinecode;
    @XmlElement(name = "PRODUCTLINEDESC")
    protected String productlinedesc;
    @XmlElement(name = "INSTALLATIONFLAG")
    protected String installationflag;
    @XmlElement(name = "SITEPREPARATION")
    protected String sitepreparation;
    @XmlElement(name = "PRODUCTINTRODATE")
    protected String productintrodate;
    @XmlElement(name = "PARTINFO")
    protected ZPARTLIST partinfo;

    /**
     * Gets the value of the productnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTNUM() {
        return productnum;
    }

    /**
     * Sets the value of the productnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTNUM(String value) {
        this.productnum = value;
    }

    /**
     * Gets the value of the productdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTDESC() {
        return productdesc;
    }

    /**
     * Sets the value of the productdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTDESC(String value) {
        this.productdesc = value;
    }

    /**
     * Gets the value of the productlinecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTLINECODE() {
        return productlinecode;
    }

    /**
     * Sets the value of the productlinecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTLINECODE(String value) {
        this.productlinecode = value;
    }

    /**
     * Gets the value of the productlinedesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTLINEDESC() {
        return productlinedesc;
    }

    /**
     * Sets the value of the productlinedesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTLINEDESC(String value) {
        this.productlinedesc = value;
    }

    /**
     * Gets the value of the installationflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSTALLATIONFLAG() {
        return installationflag;
    }

    /**
     * Sets the value of the installationflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSTALLATIONFLAG(String value) {
        this.installationflag = value;
    }

    /**
     * Gets the value of the sitepreparation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEPREPARATION() {
        return sitepreparation;
    }

    /**
     * Sets the value of the sitepreparation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEPREPARATION(String value) {
        this.sitepreparation = value;
    }

    /**
     * Gets the value of the productintrodate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTINTRODATE() {
        return productintrodate;
    }

    /**
     * Sets the value of the productintrodate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTINTRODATE(String value) {
        this.productintrodate = value;
    }

    /**
     * Gets the value of the partinfo property.
     * 
     * @return
     *     possible object is
     *     {@link ZPARTLIST }
     *     
     */
    public ZPARTLIST getPARTINFO() {
        return partinfo;
    }

    /**
     * Sets the value of the partinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZPARTLIST }
     *     
     */
    public void setPARTINFO(ZPARTLIST value) {
        this.partinfo = value;
    }

}
