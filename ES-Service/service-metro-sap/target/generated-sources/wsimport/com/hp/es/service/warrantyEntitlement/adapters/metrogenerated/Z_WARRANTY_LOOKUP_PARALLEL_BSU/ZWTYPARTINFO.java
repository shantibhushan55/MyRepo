
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_PARTINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_PARTINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PARTNUMBER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PARTSN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PARTWTYSTART" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="PARTWTYEND" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="PARTDESC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
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
@XmlType(name = "ZWTY_PARTINFO", propOrder = {
    "partnumber",
    "partsn",
    "partwtystart",
    "partwtyend",
    "partdesc"
})
public class ZWTYPARTINFO {

    @XmlElement(name = "PARTNUMBER")
    protected String partnumber;
    @XmlElement(name = "PARTSN")
    protected String partsn;
    @XmlElement(name = "PARTWTYSTART")
    protected String partwtystart;
    @XmlElement(name = "PARTWTYEND")
    protected String partwtyend;
    @XmlElement(name = "PARTDESC")
    protected String partdesc;

    /**
     * Gets the value of the partnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTNUMBER() {
        return partnumber;
    }

    /**
     * Sets the value of the partnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTNUMBER(String value) {
        this.partnumber = value;
    }

    /**
     * Gets the value of the partsn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTSN() {
        return partsn;
    }

    /**
     * Sets the value of the partsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTSN(String value) {
        this.partsn = value;
    }

    /**
     * Gets the value of the partwtystart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTWTYSTART() {
        return partwtystart;
    }

    /**
     * Sets the value of the partwtystart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTWTYSTART(String value) {
        this.partwtystart = value;
    }

    /**
     * Gets the value of the partwtyend property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTWTYEND() {
        return partwtyend;
    }

    /**
     * Sets the value of the partwtyend property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTWTYEND(String value) {
        this.partwtyend = value;
    }

    /**
     * Gets the value of the partdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTDESC() {
        return partdesc;
    }

    /**
     * Sets the value of the partdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTDESC(String value) {
        this.partdesc = value;
    }

}
