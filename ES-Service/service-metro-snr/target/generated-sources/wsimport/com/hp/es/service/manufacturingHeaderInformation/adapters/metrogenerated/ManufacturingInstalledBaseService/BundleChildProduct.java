
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BundleChildProduct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BundleChildProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreatedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocalizationOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OtherOptions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitProductNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitSerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WarrantyOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BundleChildProduct", propOrder = {
    "createdDate",
    "localizationOption",
    "otherOptions",
    "unitProductNumber",
    "unitSerialNumber",
    "warrantyOption"
})
public class BundleChildProduct {

    @XmlElementRef(name = "CreatedDate", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> createdDate;
    @XmlElementRef(name = "LocalizationOption", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> localizationOption;
    @XmlElementRef(name = "OtherOptions", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> otherOptions;
    @XmlElementRef(name = "UnitProductNumber", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> unitProductNumber;
    @XmlElementRef(name = "UnitSerialNumber", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> unitSerialNumber;
    @XmlElementRef(name = "WarrantyOption", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> warrantyOption;

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreatedDate(JAXBElement<String> value) {
        this.createdDate = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the localizationOption property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLocalizationOption() {
        return localizationOption;
    }

    /**
     * Sets the value of the localizationOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLocalizationOption(JAXBElement<String> value) {
        this.localizationOption = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the otherOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOtherOptions() {
        return otherOptions;
    }

    /**
     * Sets the value of the otherOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOtherOptions(JAXBElement<String> value) {
        this.otherOptions = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the unitProductNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUnitProductNumber() {
        return unitProductNumber;
    }

    /**
     * Sets the value of the unitProductNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUnitProductNumber(JAXBElement<String> value) {
        this.unitProductNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the unitSerialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUnitSerialNumber() {
        return unitSerialNumber;
    }

    /**
     * Sets the value of the unitSerialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUnitSerialNumber(JAXBElement<String> value) {
        this.unitSerialNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the warrantyOption property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWarrantyOption() {
        return warrantyOption;
    }

    /**
     * Sets the value of the warrantyOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWarrantyOption(JAXBElement<String> value) {
        this.warrantyOption = ((JAXBElement<String> ) value);
    }

}
