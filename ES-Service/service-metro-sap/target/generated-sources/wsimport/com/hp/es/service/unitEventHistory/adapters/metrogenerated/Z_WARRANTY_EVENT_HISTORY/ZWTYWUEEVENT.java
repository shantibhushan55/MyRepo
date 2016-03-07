
package com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_WUE_EVENT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_WUE_EVENT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORIGINALSN" type="{urn:sap-com:document:sap:rfc:functions}SerialNumber" minOccurs="0"/>
 *         &lt;element name="ORIGINALPN" type="{urn:sap-com:document:sap:rfc:functions}ProductNumber" minOccurs="0"/>
 *         &lt;element name="REPLACEMENTSN" type="{urn:sap-com:document:sap:rfc:functions}SerialNumber" minOccurs="0"/>
 *         &lt;element name="REPLACEMENTPN" type="{urn:sap-com:document:sap:rfc:functions}ProductNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZWTY_WUE_EVENT", propOrder = {
    "originalsn",
    "originalpn",
    "replacementsn",
    "replacementpn"
})
public class ZWTYWUEEVENT {

    @XmlElement(name = "ORIGINALSN")
    protected String originalsn;
    @XmlElement(name = "ORIGINALPN")
    protected String originalpn;
    @XmlElement(name = "REPLACEMENTSN")
    protected String replacementsn;
    @XmlElement(name = "REPLACEMENTPN")
    protected String replacementpn;

    /**
     * Gets the value of the originalsn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORIGINALSN() {
        return originalsn;
    }

    /**
     * Sets the value of the originalsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORIGINALSN(String value) {
        this.originalsn = value;
    }

    /**
     * Gets the value of the originalpn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORIGINALPN() {
        return originalpn;
    }

    /**
     * Sets the value of the originalpn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORIGINALPN(String value) {
        this.originalpn = value;
    }

    /**
     * Gets the value of the replacementsn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREPLACEMENTSN() {
        return replacementsn;
    }

    /**
     * Sets the value of the replacementsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREPLACEMENTSN(String value) {
        this.replacementsn = value;
    }

    /**
     * Gets the value of the replacementpn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREPLACEMENTPN() {
        return replacementpn;
    }

    /**
     * Sets the value of the replacementpn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREPLACEMENTPN(String value) {
        this.replacementpn = value;
    }

}
