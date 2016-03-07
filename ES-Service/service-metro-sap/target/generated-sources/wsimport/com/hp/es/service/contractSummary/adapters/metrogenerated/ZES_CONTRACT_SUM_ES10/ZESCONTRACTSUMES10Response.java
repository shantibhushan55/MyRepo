
package com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="CONTACTS">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_CONTACT_SUM" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DELIVERABLES">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_DELIV_SUM" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LOCATIONS">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_LOCATION_SUM" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MESSAGES">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_MESSAGE" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OBLIGATION_HEADERS">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_OBLIGATION_HD_SUM" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PROC_STATE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCTS">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_PRODUCT_ITEM_SUM" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RUNTIME">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_RUNTIME" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SERVICES">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_SERVICES_ITEM_SUM" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SVC_AGREEMENT_ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
@XmlRootElement(name = "ZES_CONTRACT_SUM_ES10.Response")
public class ZESCONTRACTSUMES10Response {

    @XmlElement(name = "CONTACTS", required = true)
    protected ZESCONTRACTSUMES10Response.CONTACTS contacts;
    @XmlElement(name = "DELIVERABLES", required = true)
    protected ZESCONTRACTSUMES10Response.DELIVERABLES deliverables;
    @XmlElement(name = "LOCATIONS", required = true)
    protected ZESCONTRACTSUMES10Response.LOCATIONS locations;
    @XmlElement(name = "MESSAGES", required = true)
    protected ZESCONTRACTSUMES10Response.MESSAGES messages;
    @XmlElement(name = "OBLIGATION_HEADERS", required = true)
    protected ZESCONTRACTSUMES10Response.OBLIGATIONHEADERS obligationheaders;
    @XmlElement(name = "PROC_STATE", required = true)
    protected String procstate;
    @XmlElement(name = "PRODUCTS", required = true)
    protected ZESCONTRACTSUMES10Response.PRODUCTS products;
    @XmlElement(name = "RUNTIME", required = true)
    protected ZESCONTRACTSUMES10Response.RUNTIME runtime;
    @XmlElement(name = "SERVICES", required = true)
    protected ZESCONTRACTSUMES10Response.SERVICES services;
    @XmlElement(name = "SVC_AGREEMENT_ID", required = true)
    protected String svcagreementid;

    /**
     * Gets the value of the contacts property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCONTRACTSUMES10Response.CONTACTS }
     *     
     */
    public ZESCONTRACTSUMES10Response.CONTACTS getCONTACTS() {
        return contacts;
    }

    /**
     * Sets the value of the contacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCONTRACTSUMES10Response.CONTACTS }
     *     
     */
    public void setCONTACTS(ZESCONTRACTSUMES10Response.CONTACTS value) {
        this.contacts = value;
    }

    /**
     * Gets the value of the deliverables property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCONTRACTSUMES10Response.DELIVERABLES }
     *     
     */
    public ZESCONTRACTSUMES10Response.DELIVERABLES getDELIVERABLES() {
        return deliverables;
    }

    /**
     * Sets the value of the deliverables property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCONTRACTSUMES10Response.DELIVERABLES }
     *     
     */
    public void setDELIVERABLES(ZESCONTRACTSUMES10Response.DELIVERABLES value) {
        this.deliverables = value;
    }

    /**
     * Gets the value of the locations property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCONTRACTSUMES10Response.LOCATIONS }
     *     
     */
    public ZESCONTRACTSUMES10Response.LOCATIONS getLOCATIONS() {
        return locations;
    }

    /**
     * Sets the value of the locations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCONTRACTSUMES10Response.LOCATIONS }
     *     
     */
    public void setLOCATIONS(ZESCONTRACTSUMES10Response.LOCATIONS value) {
        this.locations = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCONTRACTSUMES10Response.MESSAGES }
     *     
     */
    public ZESCONTRACTSUMES10Response.MESSAGES getMESSAGES() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCONTRACTSUMES10Response.MESSAGES }
     *     
     */
    public void setMESSAGES(ZESCONTRACTSUMES10Response.MESSAGES value) {
        this.messages = value;
    }

    /**
     * Gets the value of the obligationheaders property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCONTRACTSUMES10Response.OBLIGATIONHEADERS }
     *     
     */
    public ZESCONTRACTSUMES10Response.OBLIGATIONHEADERS getOBLIGATIONHEADERS() {
        return obligationheaders;
    }

    /**
     * Sets the value of the obligationheaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCONTRACTSUMES10Response.OBLIGATIONHEADERS }
     *     
     */
    public void setOBLIGATIONHEADERS(ZESCONTRACTSUMES10Response.OBLIGATIONHEADERS value) {
        this.obligationheaders = value;
    }

    /**
     * Gets the value of the procstate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROCSTATE() {
        return procstate;
    }

    /**
     * Sets the value of the procstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROCSTATE(String value) {
        this.procstate = value;
    }

    /**
     * Gets the value of the products property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCONTRACTSUMES10Response.PRODUCTS }
     *     
     */
    public ZESCONTRACTSUMES10Response.PRODUCTS getPRODUCTS() {
        return products;
    }

    /**
     * Sets the value of the products property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCONTRACTSUMES10Response.PRODUCTS }
     *     
     */
    public void setPRODUCTS(ZESCONTRACTSUMES10Response.PRODUCTS value) {
        this.products = value;
    }

    /**
     * Gets the value of the runtime property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCONTRACTSUMES10Response.RUNTIME }
     *     
     */
    public ZESCONTRACTSUMES10Response.RUNTIME getRUNTIME() {
        return runtime;
    }

    /**
     * Sets the value of the runtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCONTRACTSUMES10Response.RUNTIME }
     *     
     */
    public void setRUNTIME(ZESCONTRACTSUMES10Response.RUNTIME value) {
        this.runtime = value;
    }

    /**
     * Gets the value of the services property.
     * 
     * @return
     *     possible object is
     *     {@link ZESCONTRACTSUMES10Response.SERVICES }
     *     
     */
    public ZESCONTRACTSUMES10Response.SERVICES getSERVICES() {
        return services;
    }

    /**
     * Sets the value of the services property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZESCONTRACTSUMES10Response.SERVICES }
     *     
     */
    public void setSERVICES(ZESCONTRACTSUMES10Response.SERVICES value) {
        this.services = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_CONTACT_SUM" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class CONTACTS {

        protected List<ZESCQSCONTACTSUM> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZESCQSCONTACTSUM }
         * 
         * 
         */
        public List<ZESCQSCONTACTSUM> getItem() {
            if (item == null) {
                item = new ArrayList<ZESCQSCONTACTSUM>();
            }
            return this.item;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_DELIV_SUM" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class DELIVERABLES {

        protected List<ZESCQSDELIVSUM> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZESCQSDELIVSUM }
         * 
         * 
         */
        public List<ZESCQSDELIVSUM> getItem() {
            if (item == null) {
                item = new ArrayList<ZESCQSDELIVSUM>();
            }
            return this.item;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_LOCATION_SUM" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class LOCATIONS {

        protected List<ZESCQSLOCATIONSUM> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZESCQSLOCATIONSUM }
         * 
         * 
         */
        public List<ZESCQSLOCATIONSUM> getItem() {
            if (item == null) {
                item = new ArrayList<ZESCQSLOCATIONSUM>();
            }
            return this.item;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_MESSAGE" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class MESSAGES {

        protected List<ZESCQSMESSAGE> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZESCQSMESSAGE }
         * 
         * 
         */
        public List<ZESCQSMESSAGE> getItem() {
            if (item == null) {
                item = new ArrayList<ZESCQSMESSAGE>();
            }
            return this.item;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_OBLIGATION_HD_SUM" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class OBLIGATIONHEADERS {

        protected List<ZESCQSOBLIGATIONHDSUM> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZESCQSOBLIGATIONHDSUM }
         * 
         * 
         */
        public List<ZESCQSOBLIGATIONHDSUM> getItem() {
            if (item == null) {
                item = new ArrayList<ZESCQSOBLIGATIONHDSUM>();
            }
            return this.item;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_PRODUCT_ITEM_SUM" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class PRODUCTS {

        protected List<ZESCQSPRODUCTITEMSUM> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZESCQSPRODUCTITEMSUM }
         * 
         * 
         */
        public List<ZESCQSPRODUCTITEMSUM> getItem() {
            if (item == null) {
                item = new ArrayList<ZESCQSPRODUCTITEMSUM>();
            }
            return this.item;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_RUNTIME" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class RUNTIME {

        protected List<ZESCQSRUNTIME> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZESCQSRUNTIME }
         * 
         * 
         */
        public List<ZESCQSRUNTIME> getItem() {
            if (item == null) {
                item = new ArrayList<ZESCQSRUNTIME>();
            }
            return this.item;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_SERVICES_ITEM_SUM" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class SERVICES {

        protected List<ZESCQSSERVICESITEMSUM> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZESCQSSERVICESITEMSUM }
         * 
         * 
         */
        public List<ZESCQSSERVICESITEMSUM> getItem() {
            if (item == null) {
                item = new ArrayList<ZESCQSSERVICESITEMSUM>();
            }
            return this.item;
        }

    }

}
