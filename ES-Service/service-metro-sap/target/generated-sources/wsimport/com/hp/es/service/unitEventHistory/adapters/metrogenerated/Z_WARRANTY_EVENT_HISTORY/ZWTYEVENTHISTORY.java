
package com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_EVENTHISTORY complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_EVENTHISTORY">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SERIALNUMOUT" type="{urn:sap-com:document:sap:rfc:functions}SerialNumber" minOccurs="0"/>
 *         &lt;element name="PRODUCTNUMOUT" type="{urn:sap-com:document:sap:rfc:functions}ProductNumber" minOccurs="0"/>
 *         &lt;element name="UNITEVENT" type="{urn:sap-com:document:sap:rfc:functions}ZWTY_UNIT_EVENT_TT" minOccurs="0"/>
 *         &lt;element name="WTYMESSAGE" type="{urn:sap-com:document:sap:rfc:functions}ZWTYERRORTAB" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZWTY_EVENTHISTORY", propOrder = {
    "serialnumout",
    "productnumout",
    "unitevent",
    "wtymessage"
})
public class ZWTYEVENTHISTORY {

    @XmlElement(name = "SERIALNUMOUT")
    protected String serialnumout;
    @XmlElement(name = "PRODUCTNUMOUT")
    protected String productnumout;
    @XmlElement(name = "UNITEVENT")
    protected ZWTYUNITEVENTTT unitevent;
    @XmlElement(name = "WTYMESSAGE")
    protected ZWTYERRORTAB wtymessage;

    /**
     * Gets the value of the serialnumout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIALNUMOUT() {
        return serialnumout;
    }

    /**
     * Sets the value of the serialnumout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIALNUMOUT(String value) {
        this.serialnumout = value;
    }

    /**
     * Gets the value of the productnumout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTNUMOUT() {
        return productnumout;
    }

    /**
     * Sets the value of the productnumout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTNUMOUT(String value) {
        this.productnumout = value;
    }

    /**
     * Gets the value of the unitevent property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYUNITEVENTTT }
     *     
     */
    public ZWTYUNITEVENTTT getUNITEVENT() {
        return unitevent;
    }

    /**
     * Sets the value of the unitevent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYUNITEVENTTT }
     *     
     */
    public void setUNITEVENT(ZWTYUNITEVENTTT value) {
        this.unitevent = value;
    }

    /**
     * Gets the value of the wtymessage property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYERRORTAB }
     *     
     */
    public ZWTYERRORTAB getWTYMESSAGE() {
        return wtymessage;
    }

    /**
     * Sets the value of the wtymessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYERRORTAB }
     *     
     */
    public void setWTYMESSAGE(ZWTYERRORTAB value) {
        this.wtymessage = value;
    }

}
