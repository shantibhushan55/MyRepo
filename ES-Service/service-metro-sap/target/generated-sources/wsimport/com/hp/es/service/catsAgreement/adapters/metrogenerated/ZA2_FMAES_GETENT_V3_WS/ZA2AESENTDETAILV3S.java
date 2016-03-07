
package com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZA2_AES_ENT_DETAIL_V3_S complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZA2_AES_ENT_DETAIL_V3_S">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ENTITLEMENT_SOURCE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WARRANTY_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GRACE_PERIOD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CAREPACK_SERIAL_NUMBER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SERVICE_CONTRACT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OFFERS" type="{urn:sap-com:document:sap:rfc:functions}ZA2_AES_OFFER_V3_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZA2_AES_ENT_DETAIL_V3_S", propOrder = {
    "entitlementsource",
    "warrantycode",
    "graceperiod",
    "carepackserialnumber",
    "servicecontractid",
    "offers"
})
public class ZA2AESENTDETAILV3S {

    @XmlElement(name = "ENTITLEMENT_SOURCE")
    protected String entitlementsource;
    @XmlElement(name = "WARRANTY_CODE")
    protected String warrantycode;
    @XmlElement(name = "GRACE_PERIOD")
    protected String graceperiod;
    @XmlElement(name = "CAREPACK_SERIAL_NUMBER")
    protected String carepackserialnumber;
    @XmlElement(name = "SERVICE_CONTRACT_ID")
    protected String servicecontractid;
    @XmlElement(name = "OFFERS")
    protected ZA2AESOFFERV3T offers;

    /**
     * Gets the value of the entitlementsource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTITLEMENTSOURCE() {
        return entitlementsource;
    }

    /**
     * Sets the value of the entitlementsource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTITLEMENTSOURCE(String value) {
        this.entitlementsource = value;
    }

    /**
     * Gets the value of the warrantycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARRANTYCODE() {
        return warrantycode;
    }

    /**
     * Sets the value of the warrantycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARRANTYCODE(String value) {
        this.warrantycode = value;
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
     * Gets the value of the carepackserialnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAREPACKSERIALNUMBER() {
        return carepackserialnumber;
    }

    /**
     * Sets the value of the carepackserialnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAREPACKSERIALNUMBER(String value) {
        this.carepackserialnumber = value;
    }

    /**
     * Gets the value of the servicecontractid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICECONTRACTID() {
        return servicecontractid;
    }

    /**
     * Sets the value of the servicecontractid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICECONTRACTID(String value) {
        this.servicecontractid = value;
    }

    /**
     * Gets the value of the offers property.
     * 
     * @return
     *     possible object is
     *     {@link ZA2AESOFFERV3T }
     *     
     */
    public ZA2AESOFFERV3T getOFFERS() {
        return offers;
    }

    /**
     * Sets the value of the offers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZA2AESOFFERV3T }
     *     
     */
    public void setOFFERS(ZA2AESOFFERV3T value) {
        this.offers = value;
    }

}
