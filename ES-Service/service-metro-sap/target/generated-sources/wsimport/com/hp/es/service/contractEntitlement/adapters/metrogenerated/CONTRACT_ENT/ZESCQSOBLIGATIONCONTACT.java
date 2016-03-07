
package com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_OBLIGATION_CONTACT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_OBLIGATION_CONTACT">
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
 *         &lt;element name="OBLIG_CONTACT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBLIG_CONTACT_ROLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBLIG_SOURCE_PERSON_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_OBLIGATION_CONTACT", propOrder = {
    "mandt",
    "obligcontacttype",
    "obligcontactrole",
    "obligsourcepersonid"
})
public class ZESCQSOBLIGATIONCONTACT {

    @XmlElement(name = "MANDT")
    protected String mandt;
    @XmlElement(name = "OBLIG_CONTACT_TYPE")
    protected String obligcontacttype;
    @XmlElement(name = "OBLIG_CONTACT_ROLE")
    protected String obligcontactrole;
    @XmlElement(name = "OBLIG_SOURCE_PERSON_ID")
    protected String obligsourcepersonid;

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
     * Gets the value of the obligcontacttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBLIGCONTACTTYPE() {
        return obligcontacttype;
    }

    /**
     * Sets the value of the obligcontacttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBLIGCONTACTTYPE(String value) {
        this.obligcontacttype = value;
    }

    /**
     * Gets the value of the obligcontactrole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBLIGCONTACTROLE() {
        return obligcontactrole;
    }

    /**
     * Sets the value of the obligcontactrole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBLIGCONTACTROLE(String value) {
        this.obligcontactrole = value;
    }

    /**
     * Gets the value of the obligsourcepersonid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBLIGSOURCEPERSONID() {
        return obligsourcepersonid;
    }

    /**
     * Sets the value of the obligsourcepersonid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBLIGSOURCEPERSONID(String value) {
        this.obligsourcepersonid = value;
    }

}
