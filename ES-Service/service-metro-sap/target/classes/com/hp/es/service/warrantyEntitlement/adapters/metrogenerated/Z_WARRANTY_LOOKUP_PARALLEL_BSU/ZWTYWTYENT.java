
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_WTYENT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_WTYENT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OOSINFO" type="{urn:sap-com:document:sap:rfc:functions}ZWTY_OOSINFO" minOccurs="0"/>
 *         &lt;element name="PRODUCTINFO" type="{urn:sap-com:document:sap:rfc:functions}ZWTY_PRODINFO" minOccurs="0"/>
 *         &lt;element name="SPAREPARTINFO" type="{urn:sap-com:document:sap:rfc:functions}ZWTYSPAREPART" minOccurs="0"/>
 *         &lt;element name="WARRANTYINFO" type="{urn:sap-com:document:sap:rfc:functions}ZWTY_WTYINFO" minOccurs="0"/>
 *         &lt;element name="OFFERINFO" type="{urn:sap-com:document:sap:rfc:functions}ZOFFERINFO" minOccurs="0"/>
 *         &lt;element name="LOCATIONMASTER" type="{urn:sap-com:document:sap:rfc:functions}ZWTYLOCATIONMASTER" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZWTY_WTYENT", propOrder = {
    "oosinfo",
    "productinfo",
    "sparepartinfo",
    "warrantyinfo",
    "offerinfo",
    "locationmaster"
})
public class ZWTYWTYENT {

    @XmlElement(name = "OOSINFO")
    protected ZWTYOOSINFO oosinfo;
    @XmlElement(name = "PRODUCTINFO")
    protected ZWTYPRODINFO productinfo;
    @XmlElement(name = "SPAREPARTINFO")
    protected ZWTYSPAREPART sparepartinfo;
    @XmlElement(name = "WARRANTYINFO")
    protected ZWTYWTYINFO warrantyinfo;
    @XmlElement(name = "OFFERINFO")
    protected ZOFFERINFO offerinfo;
    @XmlElement(name = "LOCATIONMASTER")
    protected ZWTYLOCATIONMASTER locationmaster;

    /**
     * Gets the value of the oosinfo property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYOOSINFO }
     *     
     */
    public ZWTYOOSINFO getOOSINFO() {
        return oosinfo;
    }

    /**
     * Sets the value of the oosinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYOOSINFO }
     *     
     */
    public void setOOSINFO(ZWTYOOSINFO value) {
        this.oosinfo = value;
    }

    /**
     * Gets the value of the productinfo property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYPRODINFO }
     *     
     */
    public ZWTYPRODINFO getPRODUCTINFO() {
        return productinfo;
    }

    /**
     * Sets the value of the productinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYPRODINFO }
     *     
     */
    public void setPRODUCTINFO(ZWTYPRODINFO value) {
        this.productinfo = value;
    }

    /**
     * Gets the value of the sparepartinfo property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYSPAREPART }
     *     
     */
    public ZWTYSPAREPART getSPAREPARTINFO() {
        return sparepartinfo;
    }

    /**
     * Sets the value of the sparepartinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYSPAREPART }
     *     
     */
    public void setSPAREPARTINFO(ZWTYSPAREPART value) {
        this.sparepartinfo = value;
    }

    /**
     * Gets the value of the warrantyinfo property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYWTYINFO }
     *     
     */
    public ZWTYWTYINFO getWARRANTYINFO() {
        return warrantyinfo;
    }

    /**
     * Sets the value of the warrantyinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYWTYINFO }
     *     
     */
    public void setWARRANTYINFO(ZWTYWTYINFO value) {
        this.warrantyinfo = value;
    }

    /**
     * Gets the value of the offerinfo property.
     * 
     * @return
     *     possible object is
     *     {@link ZOFFERINFO }
     *     
     */
    public ZOFFERINFO getOFFERINFO() {
        return offerinfo;
    }

    /**
     * Sets the value of the offerinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZOFFERINFO }
     *     
     */
    public void setOFFERINFO(ZOFFERINFO value) {
        this.offerinfo = value;
    }

    /**
     * Gets the value of the locationmaster property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYLOCATIONMASTER }
     *     
     */
    public ZWTYLOCATIONMASTER getLOCATIONMASTER() {
        return locationmaster;
    }

    /**
     * Sets the value of the locationmaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYLOCATIONMASTER }
     *     
     */
    public void setLOCATIONMASTER(ZWTYLOCATIONMASTER value) {
        this.locationmaster = value;
    }

}
