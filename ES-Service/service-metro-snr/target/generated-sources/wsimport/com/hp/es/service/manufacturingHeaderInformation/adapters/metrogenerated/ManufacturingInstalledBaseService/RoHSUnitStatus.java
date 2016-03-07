
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoHS_unit_status complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoHS_unit_status">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rohs_status_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="has_minimum_rohs_exception" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product_family" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoHS_unit_status", propOrder = {
    "rohsStatusCode",
    "hasMinimumRohsException",
    "productFamily"
})
public class RoHSUnitStatus {

    @XmlElementRef(name = "rohs_status_code", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> rohsStatusCode;
    @XmlElementRef(name = "has_minimum_rohs_exception", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> hasMinimumRohsException;
    @XmlElementRef(name = "Product_family", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> productFamily;

    /**
     * Gets the value of the rohsStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRohsStatusCode() {
        return rohsStatusCode;
    }

    /**
     * Sets the value of the rohsStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRohsStatusCode(JAXBElement<String> value) {
        this.rohsStatusCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the hasMinimumRohsException property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHasMinimumRohsException() {
        return hasMinimumRohsException;
    }

    /**
     * Sets the value of the hasMinimumRohsException property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHasMinimumRohsException(JAXBElement<String> value) {
        this.hasMinimumRohsException = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the productFamily property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductFamily() {
        return productFamily;
    }

    /**
     * Sets the value of the productFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductFamily(JAXBElement<String> value) {
        this.productFamily = ((JAXBElement<String> ) value);
    }

}
