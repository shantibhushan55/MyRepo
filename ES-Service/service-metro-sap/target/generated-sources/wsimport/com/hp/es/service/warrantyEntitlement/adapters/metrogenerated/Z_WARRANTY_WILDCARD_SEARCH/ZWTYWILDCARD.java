
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTYWILDCARD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTYWILDCARD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PRODLIST" type="{urn:sap-com:document:sap:rfc:functions}ZPRODLIST" minOccurs="0"/>
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
@XmlType(name = "ZWTYWILDCARD", propOrder = {
    "prodlist",
    "wtymessage"
})
public class ZWTYWILDCARD {

    @XmlElement(name = "PRODLIST")
    protected ZPRODLIST prodlist;
    @XmlElement(name = "WTYMESSAGE")
    protected ZWTYERRORTAB wtymessage;

    /**
     * Gets the value of the prodlist property.
     * 
     * @return
     *     possible object is
     *     {@link ZPRODLIST }
     *     
     */
    public ZPRODLIST getPRODLIST() {
        return prodlist;
    }

    /**
     * Sets the value of the prodlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZPRODLIST }
     *     
     */
    public void setPRODLIST(ZPRODLIST value) {
        this.prodlist = value;
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
