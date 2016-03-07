
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_SERVICE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_SERVICE">
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
 *         &lt;element name="ITEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASSOCIATED_PKG_ITEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SVC_PRODUCT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SVC_DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SVC_PRODUCT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SVC_PRODUCT_LINE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STAND_ALONE_SERVICE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INCIDENT_BASED_SERVICE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERVICE_QUANTITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AVAILABLE_QUANTITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WTY_START_DATE_ELIGIBILITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELIVERABLES" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_DELIVERABLES_T" minOccurs="0"/>
 *         &lt;element name="MODIFIERS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_MODIFIERS_T" minOccurs="0"/>
 *         &lt;element name="APPLIES_TO" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_APPLIES_TO_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_SERVICE", propOrder = {
    "mandt",
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
    "wtystartdateeligibility",
    "deliverables",
    "modifiers",
    "appliesto"
})
public class ZESCQSSERVICE {

    @XmlElement(name = "MANDT")
    protected String mandt;
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
    @XmlElement(name = "WTY_START_DATE_ELIGIBILITY")
    protected String wtystartdateeligibility;
    @XmlElement(name = "DELIVERABLES")
    protected ZESCQSDELIVERABLEST deliverables;
    @XmlElement(name = "MODIFIERS")
    protected ZESCQSMODIFIERST modifiers;
    @XmlElement(name = "APPLIES_TO")
    protected ZESCQSAPPLIESTOT appliesto;

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
     * Gets the value of the wtystartdateeligibility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWTYSTARTDATEELIGIBILITY() {
        return wtystartdateeligibility;
    }

    /**
     * Sets the value of the wtystartdateeligibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWTYSTARTDATEELIGIBILITY(String value) {
        this.wtystartdateeligibility = value;
    }

    /**
     * Gets the value of the deliverables property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSDELIVERABLEST }
     *     
     */
    public ZESCQSDELIVERABLEST getDELIVERABLES() {
        return deliverables;
    }

    /**
     * Sets the value of the deliverables property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSDELIVERABLEST }
     *     
     */
    public void setDELIVERABLES(ZESCQSDELIVERABLEST value) {
        this.deliverables = value;
    }

    /**
     * Gets the value of the modifiers property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSMODIFIERST }
     *     
     */
    public ZESCQSMODIFIERST getMODIFIERS() {
        return modifiers;
    }

    /**
     * Sets the value of the modifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSMODIFIERST }
     *     
     */
    public void setMODIFIERS(ZESCQSMODIFIERST value) {
        this.modifiers = value;
    }

    /**
     * Gets the value of the appliesto property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSAPPLIESTOT }
     *     
     */
    public ZESCQSAPPLIESTOT getAPPLIESTO() {
        return appliesto;
    }

    /**
     * Sets the value of the appliesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSAPPLIESTOT }
     *     
     */
    public void setAPPLIESTO(ZESCQSAPPLIESTOT value) {
        this.appliesto = value;
    }

}
