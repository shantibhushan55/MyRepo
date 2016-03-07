
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_OOS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_OOS">
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
 *         &lt;element name="OOS_KEY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OOS_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERIAL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TARGET_QUANTITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OOS_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATA_ENTRY_SITE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUSTOMER_DEFINED_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRODUCT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRODUCT_ID_STANDARDIZED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRODUCT_DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRODUCT_LINE_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRODUCT_LINE_DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WTY_START_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENT_PAGE_COUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENT_PAGE_COUNT_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MANUFACTURER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MANUFACTURER_PART_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_OOS", propOrder = {
    "mandt",
    "ooskey",
    "oostype",
    "serialnumber",
    "targetquantity",
    "oosgroupid",
    "dataentrysite",
    "customerdefinedid",
    "productid",
    "productidstandardized",
    "productdescription",
    "productlinecode",
    "productlinedescription",
    "wtystartdate",
    "currentpagecount",
    "currentpagecountdate",
    "manufacturerid",
    "manufacturerpartno"
})
public class ZESCQSOOS {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "OOS_KEY")
    protected String ooskey;
    @XmlElement(name = "OOS_TYPE")
    protected String oostype;
    @XmlElement(name = "SERIAL_NUMBER")
    protected String serialnumber;
    @XmlElement(name = "TARGET_QUANTITY")
    protected String targetquantity;
    @XmlElement(name = "OOS_GROUP_ID")
    protected String oosgroupid;
    @XmlElement(name = "DATA_ENTRY_SITE")
    protected String dataentrysite;
    @XmlElement(name = "CUSTOMER_DEFINED_ID")
    protected String customerdefinedid;
    @XmlElement(name = "PRODUCT_ID")
    protected String productid;
    @XmlElement(name = "PRODUCT_ID_STANDARDIZED")
    protected String productidstandardized;
    @XmlElement(name = "PRODUCT_DESCRIPTION")
    protected String productdescription;
    @XmlElement(name = "PRODUCT_LINE_CODE")
    protected String productlinecode;
    @XmlElement(name = "PRODUCT_LINE_DESCRIPTION")
    protected String productlinedescription;
    @XmlElement(name = "WTY_START_DATE")
    protected String wtystartdate;
    @XmlElement(name = "CURRENT_PAGE_COUNT")
    protected String currentpagecount;
    @XmlElement(name = "CURRENT_PAGE_COUNT_DATE")
    protected String currentpagecountdate;
    @XmlElement(name = "MANUFACTURER_ID")
    protected String manufacturerid;
    @XmlElement(name = "MANUFACTURER_PART_NO")
    protected String manufacturerpartno;

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
     * Gets the value of the ooskey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOOSKEY() {
        return ooskey;
    }

    /**
     * Sets the value of the ooskey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOOSKEY(String value) {
        this.ooskey = value;
    }

    /**
     * Gets the value of the oostype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOOSTYPE() {
        return oostype;
    }

    /**
     * Sets the value of the oostype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOOSTYPE(String value) {
        this.oostype = value;
    }

    /**
     * Gets the value of the serialnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIALNUMBER() {
        return serialnumber;
    }

    /**
     * Sets the value of the serialnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIALNUMBER(String value) {
        this.serialnumber = value;
    }

    /**
     * Gets the value of the targetquantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTARGETQUANTITY() {
        return targetquantity;
    }

    /**
     * Sets the value of the targetquantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTARGETQUANTITY(String value) {
        this.targetquantity = value;
    }

    /**
     * Gets the value of the oosgroupid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOOSGROUPID() {
        return oosgroupid;
    }

    /**
     * Sets the value of the oosgroupid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOOSGROUPID(String value) {
        this.oosgroupid = value;
    }

    /**
     * Gets the value of the dataentrysite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATAENTRYSITE() {
        return dataentrysite;
    }

    /**
     * Sets the value of the dataentrysite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATAENTRYSITE(String value) {
        this.dataentrysite = value;
    }

    /**
     * Gets the value of the customerdefinedid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMERDEFINEDID() {
        return customerdefinedid;
    }

    /**
     * Sets the value of the customerdefinedid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMERDEFINEDID(String value) {
        this.customerdefinedid = value;
    }

    /**
     * Gets the value of the productid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTID() {
        return productid;
    }

    /**
     * Sets the value of the productid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTID(String value) {
        this.productid = value;
    }

    /**
     * Gets the value of the productidstandardized property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTIDSTANDARDIZED() {
        return productidstandardized;
    }

    /**
     * Sets the value of the productidstandardized property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTIDSTANDARDIZED(String value) {
        this.productidstandardized = value;
    }

    /**
     * Gets the value of the productdescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTDESCRIPTION() {
        return productdescription;
    }

    /**
     * Sets the value of the productdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTDESCRIPTION(String value) {
        this.productdescription = value;
    }

    /**
     * Gets the value of the productlinecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTLINECODE() {
        return productlinecode;
    }

    /**
     * Sets the value of the productlinecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTLINECODE(String value) {
        this.productlinecode = value;
    }

    /**
     * Gets the value of the productlinedescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTLINEDESCRIPTION() {
        return productlinedescription;
    }

    /**
     * Sets the value of the productlinedescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTLINEDESCRIPTION(String value) {
        this.productlinedescription = value;
    }

    /**
     * Gets the value of the wtystartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWTYSTARTDATE() {
        return wtystartdate;
    }

    /**
     * Sets the value of the wtystartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWTYSTARTDATE(String value) {
        this.wtystartdate = value;
    }

    /**
     * Gets the value of the currentpagecount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCURRENTPAGECOUNT() {
        return currentpagecount;
    }

    /**
     * Sets the value of the currentpagecount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCURRENTPAGECOUNT(String value) {
        this.currentpagecount = value;
    }

    /**
     * Gets the value of the currentpagecountdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCURRENTPAGECOUNTDATE() {
        return currentpagecountdate;
    }

    /**
     * Sets the value of the currentpagecountdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCURRENTPAGECOUNTDATE(String value) {
        this.currentpagecountdate = value;
    }

    /**
     * Gets the value of the manufacturerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMANUFACTURERID() {
        return manufacturerid;
    }

    /**
     * Sets the value of the manufacturerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMANUFACTURERID(String value) {
        this.manufacturerid = value;
    }

    /**
     * Gets the value of the manufacturerpartno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMANUFACTURERPARTNO() {
        return manufacturerpartno;
    }

    /**
     * Sets the value of the manufacturerpartno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMANUFACTURERPARTNO(String value) {
        this.manufacturerpartno = value;
    }

}
