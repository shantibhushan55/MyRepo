
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_CUSTOMER_IDENTITY complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_CUSTOMER_IDENTITY">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SITE_LEVEL_CUSTOMER_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="END_CUSTOMER_AMIDL2_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="END_CUSTOMER_AMIDL2_SEGMENTS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_CUSTOMER_SEGMENTS" minOccurs="0"/>
 *         &lt;element name="END_CUSTOMER_AMIDL3_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="END_CUSTOMER_AMIDL3_SEGMENTS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_CUSTOMER_SEGMENTS" minOccurs="0"/>
 *         &lt;element name="END_CUSTOMER_AMIDL4_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="END_CUSTOMER_AMIDL4_SEGMENTS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_CUSTOMER_SEGMENTS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_CUSTOMER_IDENTITY", propOrder = {
    "sitelevelcustomerid",
    "endcustomeramidl2ID",
    "endcustomeramidl2SEGMENTS",
    "endcustomeramidl3ID",
    "endcustomeramidl3SEGMENTS",
    "endcustomeramidl4ID",
    "endcustomeramidl4SEGMENTS"
})
public class ZESCQSCUSTOMERIDENTITY {

    @XmlElement(name = "SITE_LEVEL_CUSTOMER_ID")
    protected String sitelevelcustomerid;
    @XmlElement(name = "END_CUSTOMER_AMIDL2_ID")
    protected String endcustomeramidl2ID;
    @XmlElement(name = "END_CUSTOMER_AMIDL2_SEGMENTS")
    protected ZESCQSCUSTOMERSEGMENTS endcustomeramidl2SEGMENTS;
    @XmlElement(name = "END_CUSTOMER_AMIDL3_ID")
    protected String endcustomeramidl3ID;
    @XmlElement(name = "END_CUSTOMER_AMIDL3_SEGMENTS")
    protected ZESCQSCUSTOMERSEGMENTS endcustomeramidl3SEGMENTS;
    @XmlElement(name = "END_CUSTOMER_AMIDL4_ID")
    protected String endcustomeramidl4ID;
    @XmlElement(name = "END_CUSTOMER_AMIDL4_SEGMENTS")
    protected ZESCQSCUSTOMERSEGMENTS endcustomeramidl4SEGMENTS;

    /**
     * Gets the value of the sitelevelcustomerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITELEVELCUSTOMERID() {
        return sitelevelcustomerid;
    }

    /**
     * Sets the value of the sitelevelcustomerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITELEVELCUSTOMERID(String value) {
        this.sitelevelcustomerid = value;
    }

    /**
     * Gets the value of the endcustomeramidl2ID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDCUSTOMERAMIDL2ID() {
        return endcustomeramidl2ID;
    }

    /**
     * Sets the value of the endcustomeramidl2ID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDCUSTOMERAMIDL2ID(String value) {
        this.endcustomeramidl2ID = value;
    }

    /**
     * Gets the value of the endcustomeramidl2SEGMENTS property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSCUSTOMERSEGMENTS }
     *     
     */
    public ZESCQSCUSTOMERSEGMENTS getENDCUSTOMERAMIDL2SEGMENTS() {
        return endcustomeramidl2SEGMENTS;
    }

    /**
     * Sets the value of the endcustomeramidl2SEGMENTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSCUSTOMERSEGMENTS }
     *     
     */
    public void setENDCUSTOMERAMIDL2SEGMENTS(ZESCQSCUSTOMERSEGMENTS value) {
        this.endcustomeramidl2SEGMENTS = value;
    }

    /**
     * Gets the value of the endcustomeramidl3ID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDCUSTOMERAMIDL3ID() {
        return endcustomeramidl3ID;
    }

    /**
     * Sets the value of the endcustomeramidl3ID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDCUSTOMERAMIDL3ID(String value) {
        this.endcustomeramidl3ID = value;
    }

    /**
     * Gets the value of the endcustomeramidl3SEGMENTS property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSCUSTOMERSEGMENTS }
     *     
     */
    public ZESCQSCUSTOMERSEGMENTS getENDCUSTOMERAMIDL3SEGMENTS() {
        return endcustomeramidl3SEGMENTS;
    }

    /**
     * Sets the value of the endcustomeramidl3SEGMENTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSCUSTOMERSEGMENTS }
     *     
     */
    public void setENDCUSTOMERAMIDL3SEGMENTS(ZESCQSCUSTOMERSEGMENTS value) {
        this.endcustomeramidl3SEGMENTS = value;
    }

    /**
     * Gets the value of the endcustomeramidl4ID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDCUSTOMERAMIDL4ID() {
        return endcustomeramidl4ID;
    }

    /**
     * Sets the value of the endcustomeramidl4ID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDCUSTOMERAMIDL4ID(String value) {
        this.endcustomeramidl4ID = value;
    }

    /**
     * Gets the value of the endcustomeramidl4SEGMENTS property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSCUSTOMERSEGMENTS }
     *     
     */
    public ZESCQSCUSTOMERSEGMENTS getENDCUSTOMERAMIDL4SEGMENTS() {
        return endcustomeramidl4SEGMENTS;
    }

    /**
     * Sets the value of the endcustomeramidl4SEGMENTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSCUSTOMERSEGMENTS }
     *     
     */
    public void setENDCUSTOMERAMIDL4SEGMENTS(ZESCQSCUSTOMERSEGMENTS value) {
        this.endcustomeramidl4SEGMENTS = value;
    }

}
