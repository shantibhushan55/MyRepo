
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SerialNumberValidationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SerialNumberValidationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalRequest" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}SerialNumberValidationRequest" minOccurs="0"/>
 *         &lt;element name="ReasonCodeWhyItsNotValid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReasonWhyItsNotValid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SerialNumberIsHPStandardsCompliant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SerialNumberIsValid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SerialNumberValidationResponse", propOrder = {
    "errorCode",
    "errorDescription",
    "originalRequest",
    "reasonCodeWhyItsNotValid",
    "reasonWhyItsNotValid",
    "serialNumberIsHPStandardsCompliant",
    "serialNumberIsValid"
})
public class SerialNumberValidationResponse {

    @XmlElementRef(name = "ErrorCode", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> errorCode;
    @XmlElementRef(name = "ErrorDescription", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> errorDescription;
    @XmlElementRef(name = "OriginalRequest", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<SerialNumberValidationRequest> originalRequest;
    @XmlElementRef(name = "ReasonCodeWhyItsNotValid", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> reasonCodeWhyItsNotValid;
    @XmlElementRef(name = "ReasonWhyItsNotValid", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> reasonWhyItsNotValid;
    @XmlElement(name = "SerialNumberIsHPStandardsCompliant")
    protected Boolean serialNumberIsHPStandardsCompliant;
    @XmlElement(name = "SerialNumberIsValid")
    protected Boolean serialNumberIsValid;

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
     *     {@link JAXBElement }{@code <}{@link SerialNumberValidationRequest }{@code >}
     *     
     */
    public JAXBElement<SerialNumberValidationRequest> getOriginalRequest() {
        return originalRequest;
    }

    /**
     * Sets the value of the originalRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SerialNumberValidationRequest }{@code >}
     *     
     */
    public void setOriginalRequest(JAXBElement<SerialNumberValidationRequest> value) {
        this.originalRequest = ((JAXBElement<SerialNumberValidationRequest> ) value);
    }

    /**
     * Gets the value of the reasonCodeWhyItsNotValid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReasonCodeWhyItsNotValid() {
        return reasonCodeWhyItsNotValid;
    }

    /**
     * Sets the value of the reasonCodeWhyItsNotValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReasonCodeWhyItsNotValid(JAXBElement<String> value) {
        this.reasonCodeWhyItsNotValid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the reasonWhyItsNotValid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReasonWhyItsNotValid() {
        return reasonWhyItsNotValid;
    }

    /**
     * Sets the value of the reasonWhyItsNotValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReasonWhyItsNotValid(JAXBElement<String> value) {
        this.reasonWhyItsNotValid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the serialNumberIsHPStandardsCompliant property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSerialNumberIsHPStandardsCompliant() {
        return serialNumberIsHPStandardsCompliant;
    }

    /**
     * Sets the value of the serialNumberIsHPStandardsCompliant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSerialNumberIsHPStandardsCompliant(Boolean value) {
        this.serialNumberIsHPStandardsCompliant = value;
    }

    /**
     * Gets the value of the serialNumberIsValid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSerialNumberIsValid() {
        return serialNumberIsValid;
    }

    /**
     * Sets the value of the serialNumberIsValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSerialNumberIsValid(Boolean value) {
        this.serialNumberIsValid = value;
    }

}
