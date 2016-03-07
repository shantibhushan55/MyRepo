
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_OBJECT_REF complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_OBJECT_REF">
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
 *         &lt;element name="OBJECT_REF_KEY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="START_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="END_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ITEM_STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELIVERY_BLOCK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE_APPLIES_TO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROFIT_CENTER" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_PROFIT_CENTER" minOccurs="0"/>
 *         &lt;element name="START_PAGE_COUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="END_PAGE_COUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAGE_LIMIT_REACHED_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_OBJECT_REF", propOrder = {
    "mandt",
    "objectrefkey",
    "startdate",
    "enddate",
    "itemstatus",
    "deliveryblock",
    "activeappliesto",
    "profitcenter",
    "startpagecount",
    "endpagecount",
    "pagelimitreacheddate"
})
public class ZESCQSOBJECTREF {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "OBJECT_REF_KEY")
    protected String objectrefkey;
    @XmlElement(name = "START_DATE")
    protected String startdate;
    @XmlElement(name = "END_DATE")
    protected String enddate;
    @XmlElement(name = "ITEM_STATUS")
    protected String itemstatus;
    @XmlElement(name = "DELIVERY_BLOCK")
    protected String deliveryblock;
    @XmlElement(name = "ACTIVE_APPLIES_TO")
    protected String activeappliesto;
    @XmlElement(name = "PROFIT_CENTER")
    protected ZESCQSPROFITCENTER profitcenter;
    @XmlElement(name = "START_PAGE_COUNT")
    protected String startpagecount;
    @XmlElement(name = "END_PAGE_COUNT")
    protected String endpagecount;
    @XmlElement(name = "PAGE_LIMIT_REACHED_DATE")
    protected String pagelimitreacheddate;

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
     * Gets the value of the objectrefkey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJECTREFKEY() {
        return objectrefkey;
    }

    /**
     * Sets the value of the objectrefkey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJECTREFKEY(String value) {
        this.objectrefkey = value;
    }

    /**
     * Gets the value of the startdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTARTDATE() {
        return startdate;
    }

    /**
     * Sets the value of the startdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTARTDATE(String value) {
        this.startdate = value;
    }

    /**
     * Gets the value of the enddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDDATE() {
        return enddate;
    }

    /**
     * Sets the value of the enddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDDATE(String value) {
        this.enddate = value;
    }

    /**
     * Gets the value of the itemstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITEMSTATUS() {
        return itemstatus;
    }

    /**
     * Sets the value of the itemstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITEMSTATUS(String value) {
        this.itemstatus = value;
    }

    /**
     * Gets the value of the deliveryblock property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERYBLOCK() {
        return deliveryblock;
    }

    /**
     * Sets the value of the deliveryblock property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERYBLOCK(String value) {
        this.deliveryblock = value;
    }

    /**
     * Gets the value of the activeappliesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVEAPPLIESTO() {
        return activeappliesto;
    }

    /**
     * Sets the value of the activeappliesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIVEAPPLIESTO(String value) {
        this.activeappliesto = value;
    }

    /**
     * Gets the value of the profitcenter property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSPROFITCENTER }
     *     
     */
    public ZESCQSPROFITCENTER getPROFITCENTER() {
        return profitcenter;
    }

    /**
     * Sets the value of the profitcenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSPROFITCENTER }
     *     
     */
    public void setPROFITCENTER(ZESCQSPROFITCENTER value) {
        this.profitcenter = value;
    }

    /**
     * Gets the value of the startpagecount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTARTPAGECOUNT() {
        return startpagecount;
    }

    /**
     * Sets the value of the startpagecount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTARTPAGECOUNT(String value) {
        this.startpagecount = value;
    }

    /**
     * Gets the value of the endpagecount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDPAGECOUNT() {
        return endpagecount;
    }

    /**
     * Sets the value of the endpagecount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDPAGECOUNT(String value) {
        this.endpagecount = value;
    }

    /**
     * Gets the value of the pagelimitreacheddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAGELIMITREACHEDDATE() {
        return pagelimitreacheddate;
    }

    /**
     * Sets the value of the pagelimitreacheddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAGELIMITREACHEDDATE(String value) {
        this.pagelimitreacheddate = value;
    }

}
