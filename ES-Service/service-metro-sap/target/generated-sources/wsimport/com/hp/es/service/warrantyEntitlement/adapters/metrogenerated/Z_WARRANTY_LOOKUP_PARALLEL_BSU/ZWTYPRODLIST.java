
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_PRODLIST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_PRODLIST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PRODUCTID" minOccurs="0">
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
 *         &lt;element name="OOSKEY" minOccurs="0">
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
 *         &lt;element name="SHIPTOCTRYCODE" minOccurs="0">
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
@XmlType(name = "ZWTY_PRODLIST", propOrder = {
    "productid",
    "serialnum",
    "ooskey",
    "productdesc",
    "shiptoctrycode"
})
public class ZWTYPRODLIST {

    @XmlElement(name = "PRODUCTID")
    protected String productid;
    @XmlElement(name = "SERIALNUM")
    protected String serialnum;
    @XmlElement(name = "OOSKEY")
    protected String ooskey;
    @XmlElement(name = "PRODUCTDESC")
    protected String productdesc;
    @XmlElement(name = "SHIPTOCTRYCODE")
    protected String shiptoctrycode;

    /**
     * Gets the value of the productid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTID() {
        return productid;
    }

    /**
     * Sets the value of the productid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTID(String value) {
        this.productid = value;
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
     * Gets the value of the shiptoctrycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHIPTOCTRYCODE() {
        return shiptoctrycode;
    }

    /**
     * Sets the value of the shiptoctrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHIPTOCTRYCODE(String value) {
        this.shiptoctrycode = value;
    }

}
