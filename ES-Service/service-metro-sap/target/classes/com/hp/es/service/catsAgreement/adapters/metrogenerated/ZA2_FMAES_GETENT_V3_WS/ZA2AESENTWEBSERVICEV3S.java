
package com.hp.es.service.catsAgreement.adapters.metrogenerated.ZA2_FMAES_GETENT_V3_WS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZA2_AES_ENT_WEBSERVICE_V3_S complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZA2_AES_ENT_WEBSERVICE_V3_S">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="INPUT_HEADER" type="{urn:sap-com:document:sap:rfc:functions}ZA2_AES_INP_HEADER_V2_S" minOccurs="0"/>
 *         &lt;element name="ENTITLEMENT_HEADER" type="{urn:sap-com:document:sap:rfc:functions}ZA2_AES_ENT_HEADER_V2_S" minOccurs="0"/>
 *         &lt;element name="ENTITLEMENT_SUMMARY" type="{urn:sap-com:document:sap:rfc:functions}ZA2_AES_ENTSUMMARY_T" minOccurs="0"/>
 *         &lt;element name="ENTITLEMENT_DETAIL" type="{urn:sap-com:document:sap:rfc:functions}ZA2_AES_ENT_DETAIL_V3_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZA2_AES_ENT_WEBSERVICE_V3_S", propOrder = {
    "inputheader",
    "entitlementheader",
    "entitlementsummary",
    "entitlementdetail"
})
public class ZA2AESENTWEBSERVICEV3S {

    @XmlElement(name = "INPUT_HEADER")
    protected ZA2AESINPHEADERV2S inputheader;
    @XmlElement(name = "ENTITLEMENT_HEADER")
    protected ZA2AESENTHEADERV2S entitlementheader;
    @XmlElement(name = "ENTITLEMENT_SUMMARY")
    protected ZA2AESENTSUMMARYT entitlementsummary;
    @XmlElement(name = "ENTITLEMENT_DETAIL")
    protected ZA2AESENTDETAILV3T entitlementdetail;

    /**
     * Gets the value of the inputheader property.
     * 
     * @return
     *     possible object is
     *     {@link ZA2AESINPHEADERV2S }
     *     
     */
    public ZA2AESINPHEADERV2S getINPUTHEADER() {
        return inputheader;
    }

    /**
     * Sets the value of the inputheader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZA2AESINPHEADERV2S }
     *     
     */
    public void setINPUTHEADER(ZA2AESINPHEADERV2S value) {
        this.inputheader = value;
    }

    /**
     * Gets the value of the entitlementheader property.
     * 
     * @return
     *     possible object is
     *     {@link ZA2AESENTHEADERV2S }
     *     
     */
    public ZA2AESENTHEADERV2S getENTITLEMENTHEADER() {
        return entitlementheader;
    }

    /**
     * Sets the value of the entitlementheader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZA2AESENTHEADERV2S }
     *     
     */
    public void setENTITLEMENTHEADER(ZA2AESENTHEADERV2S value) {
        this.entitlementheader = value;
    }

    /**
     * Gets the value of the entitlementsummary property.
     * 
     * @return
     *     possible object is
     *     {@link ZA2AESENTSUMMARYT }
     *     
     */
    public ZA2AESENTSUMMARYT getENTITLEMENTSUMMARY() {
        return entitlementsummary;
    }

    /**
     * Sets the value of the entitlementsummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZA2AESENTSUMMARYT }
     *     
     */
    public void setENTITLEMENTSUMMARY(ZA2AESENTSUMMARYT value) {
        this.entitlementsummary = value;
    }

    /**
     * Gets the value of the entitlementdetail property.
     * 
     * @return
     *     possible object is
     *     {@link ZA2AESENTDETAILV3T }
     *     
     */
    public ZA2AESENTDETAILV3T getENTITLEMENTDETAIL() {
        return entitlementdetail;
    }

    /**
     * Sets the value of the entitlementdetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZA2AESENTDETAILV3T }
     *     
     */
    public void setENTITLEMENTDETAIL(ZA2AESENTDETAILV3T value) {
        this.entitlementdetail = value;
    }

}
