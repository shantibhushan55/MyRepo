
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
 *         &lt;element name="ZWTYLOOKUP" type="{urn:sap-com:document:sap:rfc:functions}ZWTYLOOKUP"/>
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
@XmlRootElement(name = "Z_WARRANTY_LOOKUP_PARALLEL_BSU.Response")
public class ZWARRANTYLOOKUPPARALLELBSUResponse {

    @XmlElement(name = "ZWTYLOOKUP", required = true)
    protected ZWTYLOOKUP zwtylookup;

    /**
     * Gets the value of the zwtylookup property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYLOOKUP }
     *     
     */
    public ZWTYLOOKUP getZWTYLOOKUP() {
        return zwtylookup;
    }

    /**
     * Sets the value of the zwtylookup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYLOOKUP }
     *     
     */
    public void setZWTYLOOKUP(ZWTYLOOKUP value) {
        this.zwtylookup = value;
    }

}
