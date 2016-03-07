
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_APPLIES_TO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_APPLIES_TO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MANDT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OBJECT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBJECT_REF" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_OBJECT_REFS_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_APPLIES_TO", propOrder = {
    "mandt",
    "objecttype",
    "objectref"
})
public class ZESCQSAPPLIESTO {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "OBJECT_TYPE")
    protected String objecttype;
    @XmlElement(name = "OBJECT_REF")
    protected ZESCQSOBJECTREFST objectref;

    /**
     * Gets the value of the mandt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMANDT() {
        return mandt;
    }

    /**
     * Sets the value of the mandt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMANDT(String value) {
        this.mandt = value;
    }

    /**
     * Gets the value of the objecttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJECTTYPE() {
        return objecttype;
    }

    /**
     * Sets the value of the objecttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJECTTYPE(String value) {
        this.objecttype = value;
    }

    /**
     * Gets the value of the objectref property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSOBJECTREFST }
     *     
     */
    public ZESCQSOBJECTREFST getOBJECTREF() {
        return objectref;
    }

    /**
     * Sets the value of the objectref property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSOBJECTREFST }
     *     
     */
    public void setOBJECTREF(ZESCQSOBJECTREFST value) {
        this.objectref = value;
    }

}
