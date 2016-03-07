
package com.hp.es.service.warrantyEntitlement.adapters.metrogenerated.Z_WARRANTY_WILDCARD_SEARCH;

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
 *         &lt;element name="ZPRODUCTLIST" type="{urn:sap-com:document:sap:rfc:functions}ZWTYWILDCARD"/>
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
@XmlRootElement(name = "Z_WARRANTY_WILDCARD_SEARCH.Response")
public class ZWARRANTYWILDCARDSEARCHResponse {

    @XmlElement(name = "ZPRODUCTLIST", required = true)
    protected ZWTYWILDCARD zproductlist;

    /**
     * Gets the value of the zproductlist property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYWILDCARD }
     *     
     */
    public ZWTYWILDCARD getZPRODUCTLIST() {
        return zproductlist;
    }

    /**
     * Sets the value of the zproductlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYWILDCARD }
     *     
     */
    public void setZPRODUCTLIST(ZWTYWILDCARD value) {
        this.zproductlist = value;
    }

}
