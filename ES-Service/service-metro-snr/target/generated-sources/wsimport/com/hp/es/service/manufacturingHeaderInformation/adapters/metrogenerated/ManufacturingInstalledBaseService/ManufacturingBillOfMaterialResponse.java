
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManufacturingBillOfMaterialResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManufacturingBillOfMaterialResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalRequest" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ManufacturingBillOfMaterialRequest" minOccurs="0"/>
 *         &lt;element name="ProductBillOfMaterialSearchResults" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfProductBillOfMaterial" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManufacturingBillOfMaterialResponse", propOrder = {
    "errorCode",
    "errorDescription",
    "originalRequest",
    "productBillOfMaterialSearchResults"
})
public class ManufacturingBillOfMaterialResponse {

    @XmlElementRef(name = "ErrorCode", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> errorCode;
    @XmlElementRef(name = "ErrorDescription", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> errorDescription;
    @XmlElementRef(name = "OriginalRequest", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ManufacturingBillOfMaterialRequest> originalRequest;
    @XmlElementRef(name = "ProductBillOfMaterialSearchResults", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfProductBillOfMaterial> productBillOfMaterialSearchResults;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorCode(JAXBElement<String> value) {
        this.errorCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the errorDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets the value of the errorDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorDescription(JAXBElement<String> value) {
        this.errorDescription = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the originalRequest property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ManufacturingBillOfMaterialRequest }{@code >}
     *     
     */
    public JAXBElement<ManufacturingBillOfMaterialRequest> getOriginalRequest() {
        return originalRequest;
    }

    /**
     * Sets the value of the originalRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ManufacturingBillOfMaterialRequest }{@code >}
     *     
     */
    public void setOriginalRequest(JAXBElement<ManufacturingBillOfMaterialRequest> value) {
        this.originalRequest = ((JAXBElement<ManufacturingBillOfMaterialRequest> ) value);
    }

    /**
     * Gets the value of the productBillOfMaterialSearchResults property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductBillOfMaterial }{@code >}
     *     
     */
    public JAXBElement<ArrayOfProductBillOfMaterial> getProductBillOfMaterialSearchResults() {
        return productBillOfMaterialSearchResults;
    }

    /**
     * Sets the value of the productBillOfMaterialSearchResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductBillOfMaterial }{@code >}
     *     
     */
    public void setProductBillOfMaterialSearchResults(JAXBElement<ArrayOfProductBillOfMaterial> value) {
        this.productBillOfMaterialSearchResults = ((JAXBElement<ArrayOfProductBillOfMaterial> ) value);
    }

}
