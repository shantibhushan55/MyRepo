
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
 *         &lt;element name="GetManufacturingBillOfMaterialResult" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ManufacturingBillOfMaterialResponse" minOccurs="0"/>
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
    "getManufacturingBillOfMaterialResult"
})
@XmlRootElement(name = "GetManufacturingBillOfMaterialResponse", namespace = "http://tempuri.org/")
public class GetManufacturingBillOfMaterialResponse {

    @XmlElementRef(name = "GetManufacturingBillOfMaterialResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ManufacturingBillOfMaterialResponse> getManufacturingBillOfMaterialResult;

    /**
     * Gets the value of the getManufacturingBillOfMaterialResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ManufacturingBillOfMaterialResponse }{@code >}
     *     
     */
    public JAXBElement<ManufacturingBillOfMaterialResponse> getGetManufacturingBillOfMaterialResult() {
        return getManufacturingBillOfMaterialResult;
    }

    /**
     * Sets the value of the getManufacturingBillOfMaterialResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ManufacturingBillOfMaterialResponse }{@code >}
     *     
     */
    public void setGetManufacturingBillOfMaterialResult(JAXBElement<ManufacturingBillOfMaterialResponse> value) {
        this.getManufacturingBillOfMaterialResult = ((JAXBElement<ManufacturingBillOfMaterialResponse> ) value);
    }

}
