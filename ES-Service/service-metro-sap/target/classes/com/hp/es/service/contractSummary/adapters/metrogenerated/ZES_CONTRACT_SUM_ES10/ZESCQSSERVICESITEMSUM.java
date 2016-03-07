
package com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_SERVICES_ITEM_SUM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_SERVICES_ITEM_SUM">
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
 *         &lt;element name="SOURCE_OBLIGATION_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ITEM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *               &lt;pattern value="\d*"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ASSOCIATED_PKG_ITEM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *               &lt;pattern value="\d*"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SVC_PRODUCT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SVC_DESCRIPTION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SVC_PRODUCT_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SVC_PRODUCT_LINE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="STAND_ALONE_SERVICE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INCIDENT_BASED_SERVICE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SERVICE_QUANTITY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AVAILABLE_QUANTITY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DELIV_LINK" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *               &lt;pattern value="\d*"/>
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
@XmlType(name = "ZES_CQS_SERVICES_ITEM_SUM", propOrder = {
    "mandt",
    "sourceobligationid",
    "item",
    "associatedpkgitem",
    "svcproductid",
    "svcdescription",
    "svcproducttype",
    "svcproductline",
    "standaloneservice",
    "incidentbasedservice",
    "servicequantity",
    "availablequantity",
    "delivlink"
})
public class ZESCQSSERVICESITEMSUM {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "SOURCE_OBLIGATION_ID")
    protected String sourceobligationid;
    @XmlElement(name = "ITEM")
    protected String item;
    @XmlElement(name = "ASSOCIATED_PKG_ITEM")
    protected String associatedpkgitem;
    @XmlElement(name = "SVC_PRODUCT_ID")
    protected String svcproductid;
    @XmlElement(name = "SVC_DESCRIPTION")
    protected String svcdescription;
    @XmlElement(name = "SVC_PRODUCT_TYPE")
    protected String svcproducttype;
    @XmlElement(name = "SVC_PRODUCT_LINE")
    protected String svcproductline;
    @XmlElement(name = "STAND_ALONE_SERVICE")
    protected String standaloneservice;
    @XmlElement(name = "INCIDENT_BASED_SERVICE")
    protected String incidentbasedservice;
    @XmlElement(name = "SERVICE_QUANTITY")
    protected String servicequantity;
    @XmlElement(name = "AVAILABLE_QUANTITY")
    protected String availablequantity;
    @XmlElement(name = "DELIV_LINK")
    protected String delivlink;

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
     * Gets the value of the sourceobligationid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOURCEOBLIGATIONID() {
        return sourceobligationid;
    }

    /**
     * Sets the value of the sourceobligationid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOURCEOBLIGATIONID(String value) {
        this.sourceobligationid = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITEM() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITEM(String value) {
        this.item = value;
    }

    /**
     * Gets the value of the associatedpkgitem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASSOCIATEDPKGITEM() {
        return associatedpkgitem;
    }

    /**
     * Sets the value of the associatedpkgitem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASSOCIATEDPKGITEM(String value) {
        this.associatedpkgitem = value;
    }

    /**
     * Gets the value of the svcproductid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSVCPRODUCTID() {
        return svcproductid;
    }

    /**
     * Sets the value of the svcproductid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSVCPRODUCTID(String value) {
        this.svcproductid = value;
    }

    /**
     * Gets the value of the svcdescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSVCDESCRIPTION() {
        return svcdescription;
    }

    /**
     * Sets the value of the svcdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSVCDESCRIPTION(String value) {
        this.svcdescription = value;
    }

    /**
     * Gets the value of the svcproducttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSVCPRODUCTTYPE() {
        return svcproducttype;
    }

    /**
     * Sets the value of the svcproducttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSVCPRODUCTTYPE(String value) {
        this.svcproducttype = value;
    }

    /**
     * Gets the value of the svcproductline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSVCPRODUCTLINE() {
        return svcproductline;
    }

    /**
     * Sets the value of the svcproductline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSVCPRODUCTLINE(String value) {
        this.svcproductline = value;
    }

    /**
     * Gets the value of the standaloneservice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTANDALONESERVICE() {
        return standaloneservice;
    }

    /**
     * Sets the value of the standaloneservice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTANDALONESERVICE(String value) {
        this.standaloneservice = value;
    }

    /**
     * Gets the value of the incidentbasedservice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCIDENTBASEDSERVICE() {
        return incidentbasedservice;
    }

    /**
     * Sets the value of the incidentbasedservice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCIDENTBASEDSERVICE(String value) {
        this.incidentbasedservice = value;
    }

    /**
     * Gets the value of the servicequantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEQUANTITY() {
        return servicequantity;
    }

    /**
     * Sets the value of the servicequantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEQUANTITY(String value) {
        this.servicequantity = value;
    }

    /**
     * Gets the value of the availablequantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAVAILABLEQUANTITY() {
        return availablequantity;
    }

    /**
     * Sets the value of the availablequantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAVAILABLEQUANTITY(String value) {
        this.availablequantity = value;
    }

    /**
     * Gets the value of the delivlink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVLINK() {
        return delivlink;
    }

    /**
     * Sets the value of the delivlink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVLINK(String value) {
        this.delivlink = value;
    }

}
