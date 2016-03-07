
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PLConfidenceLevelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PLConfidenceLevelInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ManufacturingBillOfMaterialConfidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupportBillOfMaterialConfidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitConfidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PLConfidenceLevelInfo", propOrder = {
    "manufacturingBillOfMaterialConfidence",
    "supportBillOfMaterialConfidence",
    "unitConfidence"
})
public class PLConfidenceLevelInfo {

    @XmlElementRef(name = "ManufacturingBillOfMaterialConfidence", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> manufacturingBillOfMaterialConfidence;
    @XmlElementRef(name = "SupportBillOfMaterialConfidence", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> supportBillOfMaterialConfidence;
    @XmlElementRef(name = "UnitConfidence", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> unitConfidence;

    /**
     * Gets the value of the manufacturingBillOfMaterialConfidence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getManufacturingBillOfMaterialConfidence() {
        return manufacturingBillOfMaterialConfidence;
    }

    /**
     * Sets the value of the manufacturingBillOfMaterialConfidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setManufacturingBillOfMaterialConfidence(JAXBElement<String> value) {
        this.manufacturingBillOfMaterialConfidence = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the supportBillOfMaterialConfidence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSupportBillOfMaterialConfidence() {
        return supportBillOfMaterialConfidence;
    }

    /**
     * Sets the value of the supportBillOfMaterialConfidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSupportBillOfMaterialConfidence(JAXBElement<String> value) {
        this.supportBillOfMaterialConfidence = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the unitConfidence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUnitConfidence() {
        return unitConfidence;
    }

    /**
     * Sets the value of the unitConfidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUnitConfidence(JAXBElement<String> value) {
        this.unitConfidence = ((JAXBElement<String> ) value);
    }

}
