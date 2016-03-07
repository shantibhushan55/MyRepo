
package com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_EVENT_DETAILS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_EVENT_DETAILS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DESCRIPTION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DURATION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WUE" type="{urn:sap-com:document:sap:rfc:functions}ZWTY_WUE_EVENT" minOccurs="0"/>
 *         &lt;element name="PART_EXCHANGE" type="{urn:sap-com:document:sap:rfc:functions}ZWTY_WUE_EVENT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZWTY_EVENT_DETAILS", propOrder = {
    "code",
    "description",
    "duration",
    "wue",
    "partexchange"
})
public class ZWTYEVENTDETAILS {

    @XmlElement(name = "CODE")
    protected String code;
    @XmlElement(name = "DESCRIPTION")
    protected String description;
    @XmlElement(name = "DURATION")
    protected Integer duration;
    @XmlElement(name = "WUE")
    protected ZWTYWUEEVENT wue;
    @XmlElement(name = "PART_EXCHANGE")
    protected ZWTYWUEEVENT partexchange;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODE() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODE(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRIPTION() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDURATION() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDURATION(Integer value) {
        this.duration = value;
    }

    /**
     * Gets the value of the wue property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYWUEEVENT }
     *     
     */
    public ZWTYWUEEVENT getWUE() {
        return wue;
    }

    /**
     * Sets the value of the wue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYWUEEVENT }
     *     
     */
    public void setWUE(ZWTYWUEEVENT value) {
        this.wue = value;
    }

    /**
     * Gets the value of the partexchange property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYWUEEVENT }
     *     
     */
    public ZWTYWUEEVENT getPARTEXCHANGE() {
        return partexchange;
    }

    /**
     * Sets the value of the partexchange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYWUEEVENT }
     *     
     */
    public void setPARTEXCHANGE(ZWTYWUEEVENT value) {
        this.partexchange = value;
    }

}
