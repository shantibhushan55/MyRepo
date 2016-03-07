
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartSearchInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartSearchInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PartIsFoundInMfgBillOfMaterial" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartIsFoundInSupportBillOfMaterial" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartSearchInformation", propOrder = {
    "partIsFoundInMfgBillOfMaterial",
    "partIsFoundInSupportBillOfMaterial"
})
public class PartSearchInformation {

    @XmlElement(name = "PartIsFoundInMfgBillOfMaterial")
    protected Boolean partIsFoundInMfgBillOfMaterial;
    @XmlElement(name = "PartIsFoundInSupportBillOfMaterial")
    protected Boolean partIsFoundInSupportBillOfMaterial;

    /**
     * Gets the value of the partIsFoundInMfgBillOfMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPartIsFoundInMfgBillOfMaterial() {
        return partIsFoundInMfgBillOfMaterial;
    }

    /**
     * Sets the value of the partIsFoundInMfgBillOfMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPartIsFoundInMfgBillOfMaterial(Boolean value) {
        this.partIsFoundInMfgBillOfMaterial = value;
    }

    /**
     * Gets the value of the partIsFoundInSupportBillOfMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPartIsFoundInSupportBillOfMaterial() {
        return partIsFoundInSupportBillOfMaterial;
    }

    /**
     * Sets the value of the partIsFoundInSupportBillOfMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPartIsFoundInSupportBillOfMaterial(Boolean value) {
        this.partIsFoundInSupportBillOfMaterial = value;
    }

}
