
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *       &lt;sequence>
 *         &lt;element name="ManufacturingComponentValidationResult" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ComponentValidationResponse" minOccurs="0"/>
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
    "manufacturingComponentValidationResult"
})
@XmlRootElement(name = "ManufacturingComponentValidationResponse", namespace = "http://tempuri.org/")
public class ManufacturingComponentValidationResponse {

    @XmlElementRef(name = "ManufacturingComponentValidationResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ComponentValidationResponse> manufacturingComponentValidationResult;

    /**
     * Gets the value of the manufacturingComponentValidationResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ComponentValidationResponse }{@code >}
     *     
     */
    public JAXBElement<ComponentValidationResponse> getManufacturingComponentValidationResult() {
        return manufacturingComponentValidationResult;
    }

    /**
     * Sets the value of the manufacturingComponentValidationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ComponentValidationResponse }{@code >}
     *     
     */
    public void setManufacturingComponentValidationResult(JAXBElement<ComponentValidationResponse> value) {
        this.manufacturingComponentValidationResult = ((JAXBElement<ComponentValidationResponse> ) value);
    }

}
