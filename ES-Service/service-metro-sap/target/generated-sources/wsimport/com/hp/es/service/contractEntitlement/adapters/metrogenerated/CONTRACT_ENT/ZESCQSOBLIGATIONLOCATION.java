
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_OBLIGATION_LOCATION complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_OBLIGATION_LOCATION">
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
 *         &lt;element name="OBLIG_ADDR_ROLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBLIG_SOURCE_CUSTOMER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_OBLIGATION_LOCATION", propOrder = {
    "mandt",
    "obligaddrrole",
    "obligsourcecustomerid"
})
public class ZESCQSOBLIGATIONLOCATION {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "OBLIG_ADDR_ROLE")
    protected String obligaddrrole;
    @XmlElement(name = "OBLIG_SOURCE_CUSTOMER_ID")
    protected String obligsourcecustomerid;

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
     * Gets the value of the obligaddrrole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBLIGADDRROLE() {
        return obligaddrrole;
    }

    /**
     * Sets the value of the obligaddrrole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBLIGADDRROLE(String value) {
        this.obligaddrrole = value;
    }

    /**
     * Gets the value of the obligsourcecustomerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBLIGSOURCECUSTOMERID() {
        return obligsourcecustomerid;
    }

    /**
     * Sets the value of the obligsourcecustomerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBLIGSOURCECUSTOMERID(String value) {
        this.obligsourcecustomerid = value;
    }

}
