
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
 *         &lt;element name="ValidatePartToProductResult" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}PartToProductValidationResponse" minOccurs="0"/>
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
    "validatePartToProductResult"
})
@XmlRootElement(name = "ValidatePartToProductResponse", namespace = "http://tempuri.org/")
public class ValidatePartToProductResponse {

    @XmlElementRef(name = "ValidatePartToProductResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<PartToProductValidationResponse> validatePartToProductResult;

    /**
     * Gets the value of the validatePartToProductResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartToProductValidationResponse }{@code >}
     *     
     */
    public JAXBElement<PartToProductValidationResponse> getValidatePartToProductResult() {
        return validatePartToProductResult;
    }

    /**
     * Sets the value of the validatePartToProductResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartToProductValidationResponse }{@code >}
     *     
     */
    public void setValidatePartToProductResult(JAXBElement<PartToProductValidationResponse> value) {
        this.validatePartToProductResult = ((JAXBElement<PartToProductValidationResponse> ) value);
    }

}
