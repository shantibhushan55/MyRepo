
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductLifeCycleEventsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductLifeCycleEventsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ComponentEvents" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfComponentEvent" minOccurs="0"/>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalRequest" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductLifeCycleEventsRequest" minOccurs="0"/>
 *         &lt;element name="ProductEvents" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfProductEvent" minOccurs="0"/>
 *         &lt;element name="ProductNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductLifeCycleEventsResponse", propOrder = {
    "componentEvents",
    "errorCode",
    "errorDescription",
    "originalRequest",
    "productEvents",
    "productNumber",
    "serialNumber"
})
public class ProductLifeCycleEventsResponse {

    @XmlElementRef(name = "ComponentEvents", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfComponentEvent> componentEvents;
    @XmlElementRef(name = "ErrorCode", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> errorCode;
    @XmlElementRef(name = "ErrorDescription", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> errorDescription;
    @XmlElementRef(name = "OriginalRequest", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductLifeCycleEventsRequest> originalRequest;
    @XmlElementRef(name = "ProductEvents", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfProductEvent> productEvents;
    @XmlElementRef(name = "ProductNumber", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> productNumber;
    @XmlElementRef(name = "SerialNumber", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> serialNumber;

    /**
     * Gets the value of the componentEvents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfComponentEvent }{@code >}
     *     
     */
    public JAXBElement<ArrayOfComponentEvent> getComponentEvents() {
        return componentEvents;
    }

    /**
     * Sets the value of the componentEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfComponentEvent }{@code >}
     *     
     */
    public void setComponentEvents(JAXBElement<ArrayOfComponentEvent> value) {
        this.componentEvents = ((JAXBElement<ArrayOfComponentEvent> ) value);
    }

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
     *     {@link JAXBElement }{@code <}{@link ProductLifeCycleEventsRequest }{@code >}
     *     
     */
    public JAXBElement<ProductLifeCycleEventsRequest> getOriginalRequest() {
        return originalRequest;
    }

    /**
     * Sets the value of the originalRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductLifeCycleEventsRequest }{@code >}
     *     
     */
    public void setOriginalRequest(JAXBElement<ProductLifeCycleEventsRequest> value) {
        this.originalRequest = ((JAXBElement<ProductLifeCycleEventsRequest> ) value);
    }

    /**
     * Gets the value of the productEvents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductEvent }{@code >}
     *     
     */
    public JAXBElement<ArrayOfProductEvent> getProductEvents() {
        return productEvents;
    }

    /**
     * Sets the value of the productEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductEvent }{@code >}
     *     
     */
    public void setProductEvents(JAXBElement<ArrayOfProductEvent> value) {
        this.productEvents = ((JAXBElement<ArrayOfProductEvent> ) value);
    }

    /**
     * Gets the value of the productNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductNumber() {
        return productNumber;
    }

    /**
     * Sets the value of the productNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductNumber(JAXBElement<String> value) {
        this.productNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the serialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSerialNumber(JAXBElement<String> value) {
        this.serialNumber = ((JAXBElement<String> ) value);
    }

}
