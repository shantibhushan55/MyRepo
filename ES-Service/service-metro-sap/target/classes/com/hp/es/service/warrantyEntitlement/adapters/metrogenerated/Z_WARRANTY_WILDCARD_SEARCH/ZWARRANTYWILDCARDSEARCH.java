
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="PRODUCTNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
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
 *         &lt;element name="SERIALNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TOTALRECORDRETURN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *               &lt;pattern value="\d*"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Z_WARRANTY_WILDCARD_SEARCH")
public class ZWARRANTYWILDCARDSEARCH {

    @XmlElement(name = "PRODUCTNUM")
    protected String productnum;
    @XmlElement(name = "SALESORDERNUM")
    protected String salesordernum;
    @XmlElement(name = "SERIALNUM")
    protected String serialnum;
    @XmlElement(name = "TOTALRECORDRETURN")
    protected String totalrecordreturn;

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
     * Gets the value of the totalrecordreturn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALRECORDRETURN() {
        return totalrecordreturn;
    }

    /**
     * Sets the value of the totalrecordreturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALRECORDRETURN(String value) {
        this.totalrecordreturn = value;
    }

}
