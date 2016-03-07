
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZWTY_WTYINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZWTY_WTYINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WARRANTYID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WARRANTYSTARTDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="WARRANTYENDDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="GLOBALFLAG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GRACEPERIOD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *               &lt;pattern value="\d*"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DEALCODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WARRANTYEXTENSION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *               &lt;pattern value="\d*"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WARRANTYINELIGIBLEINDICATOR" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INELIGIBLEREASONDESC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SOURCEDATEFORWARRANTYSTART" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SOURCEDATEDESC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SUPPORTPRODUCTLINE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WARRANTYBUNDLEID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
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
@XmlType(name = "ZWTY_WTYINFO", propOrder = {
    "warrantyid",
    "warrantystartdate",
    "warrantyenddate",
    "globalflag",
    "graceperiod",
    "dealcode",
    "warrantyextension",
    "warrantyineligibleindicator",
    "ineligiblereasondesc",
    "sourcedateforwarrantystart",
    "sourcedatedesc",
    "supportproductline",
    "warrantybundleid"
})
public class ZWTYWTYINFO {

    @XmlElement(name = "WARRANTYID")
    protected String warrantyid;
    @XmlElement(name = "WARRANTYSTARTDATE")
    protected String warrantystartdate;
    @XmlElement(name = "WARRANTYENDDATE")
    protected String warrantyenddate;
    @XmlElement(name = "GLOBALFLAG")
    protected String globalflag;
    @XmlElement(name = "GRACEPERIOD")
    protected String graceperiod;
    @XmlElement(name = "DEALCODE")
    protected String dealcode;
    @XmlElement(name = "WARRANTYEXTENSION")
    protected String warrantyextension;
    @XmlElement(name = "WARRANTYINELIGIBLEINDICATOR")
    protected String warrantyineligibleindicator;
    @XmlElement(name = "INELIGIBLEREASONDESC")
    protected String ineligiblereasondesc;
    @XmlElement(name = "SOURCEDATEFORWARRANTYSTART")
    protected String sourcedateforwarrantystart;
    @XmlElement(name = "SOURCEDATEDESC")
    protected String sourcedatedesc;
    @XmlElement(name = "SUPPORTPRODUCTLINE")
    protected String supportproductline;
    @XmlElement(name = "WARRANTYBUNDLEID")
    protected String warrantybundleid;

    /**
     * Gets the value of the warrantyid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARRANTYID() {
        return warrantyid;
    }

    /**
     * Sets the value of the warrantyid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARRANTYID(String value) {
        this.warrantyid = value;
    }

    /**
     * Gets the value of the warrantystartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARRANTYSTARTDATE() {
        return warrantystartdate;
    }

    /**
     * Sets the value of the warrantystartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARRANTYSTARTDATE(String value) {
        this.warrantystartdate = value;
    }

    /**
     * Gets the value of the warrantyenddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARRANTYENDDATE() {
        return warrantyenddate;
    }

    /**
     * Sets the value of the warrantyenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARRANTYENDDATE(String value) {
        this.warrantyenddate = value;
    }

    /**
     * Gets the value of the globalflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGLOBALFLAG() {
        return globalflag;
    }

    /**
     * Sets the value of the globalflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGLOBALFLAG(String value) {
        this.globalflag = value;
    }

    /**
     * Gets the value of the graceperiod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGRACEPERIOD() {
        return graceperiod;
    }

    /**
     * Sets the value of the graceperiod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGRACEPERIOD(String value) {
        this.graceperiod = value;
    }

    /**
     * Gets the value of the dealcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEALCODE() {
        return dealcode;
    }

    /**
     * Sets the value of the dealcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEALCODE(String value) {
        this.dealcode = value;
    }

    /**
     * Gets the value of the warrantyextension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARRANTYEXTENSION() {
        return warrantyextension;
    }

    /**
     * Sets the value of the warrantyextension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARRANTYEXTENSION(String value) {
        this.warrantyextension = value;
    }

    /**
     * Gets the value of the warrantyineligibleindicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARRANTYINELIGIBLEINDICATOR() {
        return warrantyineligibleindicator;
    }

    /**
     * Sets the value of the warrantyineligibleindicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARRANTYINELIGIBLEINDICATOR(String value) {
        this.warrantyineligibleindicator = value;
    }

    /**
     * Gets the value of the ineligiblereasondesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINELIGIBLEREASONDESC() {
        return ineligiblereasondesc;
    }

    /**
     * Sets the value of the ineligiblereasondesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINELIGIBLEREASONDESC(String value) {
        this.ineligiblereasondesc = value;
    }

    /**
     * Gets the value of the sourcedateforwarrantystart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOURCEDATEFORWARRANTYSTART() {
        return sourcedateforwarrantystart;
    }

    /**
     * Sets the value of the sourcedateforwarrantystart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOURCEDATEFORWARRANTYSTART(String value) {
        this.sourcedateforwarrantystart = value;
    }

    /**
     * Gets the value of the sourcedatedesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOURCEDATEDESC() {
        return sourcedatedesc;
    }

    /**
     * Sets the value of the sourcedatedesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOURCEDATEDESC(String value) {
        this.sourcedatedesc = value;
    }

    /**
     * Gets the value of the supportproductline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUPPORTPRODUCTLINE() {
        return supportproductline;
    }

    /**
     * Sets the value of the supportproductline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUPPORTPRODUCTLINE(String value) {
        this.supportproductline = value;
    }

    /**
     * Gets the value of the warrantybundleid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARRANTYBUNDLEID() {
        return warrantybundleid;
    }

    /**
     * Sets the value of the warrantybundleid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARRANTYBUNDLEID(String value) {
        this.warrantybundleid = value;
    }

}
