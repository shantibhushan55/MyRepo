
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComponentValidationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComponentValidationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalRequest" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ComponentValidationRequest" minOccurs="0"/>
 *         &lt;element name="PartToProductSearchResponse" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}PartSearchInformation" minOccurs="0"/>
 *         &lt;element name="ProductLineConfidenceLevelInfo" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}PLConfidenceLevelInfo" minOccurs="0"/>
 *         &lt;element name="SerialNumberExists" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComponentValidationResponse", propOrder = {
    "errorCode",
    "errorDescription",
    "originalRequest",
    "partToProductSearchResponse",
    "productLineConfidenceLevelInfo",
    "serialNumberExists"
})
public class ComponentValidationResponse {

    @XmlElementRef(name = "ErrorCode", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> errorCode;
    @XmlElementRef(name = "ErrorDescription", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> errorDescription;
    @XmlElementRef(name = "OriginalRequest", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ComponentValidationRequest> originalRequest;
    @XmlElementRef(name = "PartToProductSearchResponse", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<PartSearchInformation> partToProductSearchResponse;
    @XmlElementRef(name = "ProductLineConfidenceLevelInfo", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<PLConfidenceLevelInfo> productLineConfidenceLevelInfo;
    @XmlElement(name = "SerialNumberExists")
    protected Boolean serialNumberExists;

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
     *     {@link JAXBElement }{@code <}{@link ComponentValidationRequest }{@code >}
     *     
     */
    public JAXBElement<ComponentValidationRequest> getOriginalRequest() {
        return originalRequest;
    }

    /**
     * Sets the value of the originalRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ComponentValidationRequest }{@code >}
     *     
     */
    public void setOriginalRequest(JAXBElement<ComponentValidationRequest> value) {
        this.originalRequest = ((JAXBElement<ComponentValidationRequest> ) value);
    }

    /**
     * Gets the value of the partToProductSearchResponse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartSearchInformation }{@code >}
     *     
     */
    public JAXBElement<PartSearchInformation> getPartToProductSearchResponse() {
        return partToProductSearchResponse;
    }

    /**
     * Sets the value of the partToProductSearchResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartSearchInformation }{@code >}
     *     
     */
    public void setPartToProductSearchResponse(JAXBElement<PartSearchInformation> value) {
        this.partToProductSearchResponse = ((JAXBElement<PartSearchInformation> ) value);
    }

    /**
     * Gets the value of the productLineConfidenceLevelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PLConfidenceLevelInfo }{@code >}
     *     
     */
    public JAXBElement<PLConfidenceLevelInfo> getProductLineConfidenceLevelInfo() {
        return productLineConfidenceLevelInfo;
    }

    /**
     * Sets the value of the productLineConfidenceLevelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PLConfidenceLevelInfo }{@code >}
     *     
     */
    public void setProductLineConfidenceLevelInfo(JAXBElement<PLConfidenceLevelInfo> value) {
        this.productLineConfidenceLevelInfo = ((JAXBElement<PLConfidenceLevelInfo> ) value);
    }

    /**
     * Gets the value of the serialNumberExists property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSerialNumberExists() {
        return serialNumberExists;
    }

    /**
     * Sets the value of the serialNumberExists property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSerialNumberExists(Boolean value) {
        this.serialNumberExists = value;
    }

}
