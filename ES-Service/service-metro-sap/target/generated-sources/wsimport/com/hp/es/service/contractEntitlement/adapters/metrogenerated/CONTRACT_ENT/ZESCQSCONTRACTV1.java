
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_CONTRACT_V1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_CONTRACT_V1">
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
 *         &lt;element name="PORTFOLIO_FLAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SVC_AGREEMENT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE_CONTRACT_ENTITLEMENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HEADER_START_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HEADER_END_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SVC_PRODUCT_TYPES" type="{urn:sap-com:document:sap:rfc:functions}ZES_PRODUCT_TYPES" minOccurs="0"/>
 *         &lt;element name="OBLIGATION_HEADERS" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_OBLIGATION_HEADERS_TV1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_CONTRACT_V1", propOrder = {
    "mandt",
    "portfolioflag",
    "svcagreementid",
    "activecontractentitlement",
    "headerstartdate",
    "headerenddate",
    "svcproducttypes",
    "obligationheaders"
})
public class ZESCQSCONTRACTV1 {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "PORTFOLIO_FLAG")
    protected String portfolioflag;
    @XmlElement(name = "SVC_AGREEMENT_ID")
    protected String svcagreementid;
    @XmlElement(name = "ACTIVE_CONTRACT_ENTITLEMENT")
    protected String activecontractentitlement;
    @XmlElement(name = "HEADER_START_DATE")
    protected String headerstartdate;
    @XmlElement(name = "HEADER_END_DATE")
    protected String headerenddate;
    @XmlElement(name = "SVC_PRODUCT_TYPES")
    protected ZESPRODUCTTYPES svcproducttypes;
    @XmlElement(name = "OBLIGATION_HEADERS")
    protected ZESCQSOBLIGATIONHEADERSTV1 obligationheaders;

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
     * Gets the value of the portfolioflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPORTFOLIOFLAG() {
        return portfolioflag;
    }

    /**
     * Sets the value of the portfolioflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPORTFOLIOFLAG(String value) {
        this.portfolioflag = value;
    }

    /**
     * Gets the value of the svcagreementid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSVCAGREEMENTID() {
        return svcagreementid;
    }

    /**
     * Sets the value of the svcagreementid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSVCAGREEMENTID(String value) {
        this.svcagreementid = value;
    }

    /**
     * Gets the value of the activecontractentitlement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVECONTRACTENTITLEMENT() {
        return activecontractentitlement;
    }

    /**
     * Sets the value of the activecontractentitlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIVECONTRACTENTITLEMENT(String value) {
        this.activecontractentitlement = value;
    }

    /**
     * Gets the value of the headerstartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHEADERSTARTDATE() {
        return headerstartdate;
    }

    /**
     * Sets the value of the headerstartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHEADERSTARTDATE(String value) {
        this.headerstartdate = value;
    }

    /**
     * Gets the value of the headerenddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHEADERENDDATE() {
        return headerenddate;
    }

    /**
     * Sets the value of the headerenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHEADERENDDATE(String value) {
        this.headerenddate = value;
    }

    /**
     * Gets the value of the svcproducttypes property.
     * 
     * @return
     *     possible object is
     *     {@link ZESPRODUCTTYPES }
     *     
     */
    public ZESPRODUCTTYPES getSVCPRODUCTTYPES() {
        return svcproducttypes;
    }

    /**
     * Sets the value of the svcproducttypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESPRODUCTTYPES }
     *     
     */
    public void setSVCPRODUCTTYPES(ZESPRODUCTTYPES value) {
        this.svcproducttypes = value;
    }

    /**
     * Gets the value of the obligationheaders property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCQSOBLIGATIONHEADERSTV1 }
     *     
     */
    public ZESCQSOBLIGATIONHEADERSTV1 getOBLIGATIONHEADERS() {
        return obligationheaders;
    }

    /**
     * Sets the value of the obligationheaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCQSOBLIGATIONHEADERSTV1 }
     *     
     */
    public void setOBLIGATIONHEADERS(ZESCQSOBLIGATIONHEADERSTV1 value) {
        this.obligationheaders = value;
    }

}
