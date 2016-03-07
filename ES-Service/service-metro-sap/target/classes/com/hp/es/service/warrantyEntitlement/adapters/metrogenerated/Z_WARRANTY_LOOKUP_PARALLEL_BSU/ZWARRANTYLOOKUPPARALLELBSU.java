
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_LOOKUP_PARALLEL_BSU;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="DATECODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EQUIPMENTNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EXACTENTITLEMENT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ISOCOUNTRYCODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IV_LOCAL_SYSTEM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCTNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PROOFOFPURCHASEDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="RETRIEVEADDRESS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SERIALNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SERVICEIDNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SPAREPARTNUM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OWNERSHIPTYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PART_LEVEL_WARRANTY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SNR_MANUFACTUREDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="SNR_RETURNDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *         &lt;element name="SNR_SHIPDATE" type="{urn:sap-com:document:sap:rfc:functions}date" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Z_WARRANTY_LOOKUP_PARALLEL_BSU")
public class ZWARRANTYLOOKUPPARALLELBSU {

    @XmlElement(name = "DATECODE")
    protected String datecode;
    @XmlElement(name = "EQUIPMENTNUM")
    protected String equipmentnum;
    @XmlElement(name = "EXACTENTITLEMENT")
    protected String exactentitlement;
    @XmlElement(name = "ISOCOUNTRYCODE")
    protected String isocountrycode;
    @XmlElement(name = "IV_LOCAL_SYSTEM")
    protected String ivlocalsystem;
    @XmlElement(name = "PRODUCTNUM")
    protected String productnum;
    @XmlElement(name = "PROOFOFPURCHASEDATE")
    protected String proofofpurchasedate;
    @XmlElement(name = "RETRIEVEADDRESS")
    protected String retrieveaddress;
    @XmlElement(name = "SERIALNUM")
    protected String serialnum;
    @XmlElement(name = "SERVICEIDNUM")
    protected String serviceidnum;
    @XmlElement(name = "SPAREPARTNUM")
    protected String sparepartnum;
    @XmlElement(name = "OWNERSHIPTYPE")
    protected String ownershiptype;
    @XmlElement(name = "PART_LEVEL_WARRANTY")
    protected String partlevelwarranty;
    @XmlElement(name = "SNR_MANUFACTUREDATE")
    protected String snrmanufacturedate;
    @XmlElement(name = "SNR_RETURNDATE")
    protected String snrreturndate;
    @XmlElement(name = "SNR_SHIPDATE")
    protected String snrshipdate;

    /**
     * Gets the value of the datecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATECODE() {
        return datecode;
    }

    /**
     * Sets the value of the datecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATECODE(String value) {
        this.datecode = value;
    }

    /**
     * Gets the value of the equipmentnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEQUIPMENTNUM() {
        return equipmentnum;
    }

    /**
     * Sets the value of the equipmentnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEQUIPMENTNUM(String value) {
        this.equipmentnum = value;
    }

    /**
     * Gets the value of the exactentitlement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXACTENTITLEMENT() {
        return exactentitlement;
    }

    /**
     * Sets the value of the exactentitlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXACTENTITLEMENT(String value) {
        this.exactentitlement = value;
    }

    /**
     * Gets the value of the isocountrycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCOUNTRYCODE() {
        return isocountrycode;
    }

    /**
     * Sets the value of the isocountrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCOUNTRYCODE(String value) {
        this.isocountrycode = value;
    }

    /**
     * Gets the value of the ivlocalsystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIVLOCALSYSTEM() {
        return ivlocalsystem;
    }

    /**
     * Sets the value of the ivlocalsystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIVLOCALSYSTEM(String value) {
        this.ivlocalsystem = value;
    }

    /**
     * Gets the value of the productnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTNUM() {
        return productnum;
    }

    /**
     * Sets the value of the productnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTNUM(String value) {
        this.productnum = value;
    }

    /**
     * Gets the value of the proofofpurchasedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROOFOFPURCHASEDATE() {
        return proofofpurchasedate;
    }

    /**
     * Sets the value of the proofofpurchasedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROOFOFPURCHASEDATE(String value) {
        this.proofofpurchasedate = value;
    }

    /**
     * Gets the value of the retrieveaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETRIEVEADDRESS() {
        return retrieveaddress;
    }

    /**
     * Sets the value of the retrieveaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETRIEVEADDRESS(String value) {
        this.retrieveaddress = value;
    }

    /**
     * Gets the value of the serialnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIALNUM() {
        return serialnum;
    }

    /**
     * Sets the value of the serialnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIALNUM(String value) {
        this.serialnum = value;
    }

    /**
     * Gets the value of the serviceidnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEIDNUM() {
        return serviceidnum;
    }

    /**
     * Sets the value of the serviceidnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEIDNUM(String value) {
        this.serviceidnum = value;
    }

    /**
     * Gets the value of the sparepartnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPAREPARTNUM() {
        return sparepartnum;
    }

    /**
     * Sets the value of the sparepartnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPAREPARTNUM(String value) {
        this.sparepartnum = value;
    }

    /**
     * Gets the value of the ownershiptype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOWNERSHIPTYPE() {
        return ownershiptype;
    }

    /**
     * Sets the value of the ownershiptype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOWNERSHIPTYPE(String value) {
        this.ownershiptype = value;
    }

    /**
     * Gets the value of the partlevelwarranty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTLEVELWARRANTY() {
        return partlevelwarranty;
    }

    /**
     * Sets the value of the partlevelwarranty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTLEVELWARRANTY(String value) {
        this.partlevelwarranty = value;
    }

    /**
     * Gets the value of the snrmanufacturedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNRMANUFACTUREDATE() {
        return snrmanufacturedate;
    }

    /**
     * Sets the value of the snrmanufacturedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNRMANUFACTUREDATE(String value) {
        this.snrmanufacturedate = value;
    }

    /**
     * Gets the value of the snrreturndate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNRRETURNDATE() {
        return snrreturndate;
    }

    /**
     * Sets the value of the snrreturndate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNRRETURNDATE(String value) {
        this.snrreturndate = value;
    }

    /**
     * Gets the value of the snrshipdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNRSHIPDATE() {
        return snrshipdate;
    }

    /**
     * Sets the value of the snrshipdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNRSHIPDATE(String value) {
        this.snrshipdate = value;
    }

}
