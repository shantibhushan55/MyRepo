
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RohsStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RohsStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RohsComplianceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RohsComplianceDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RohsStatus", propOrder = {
    "rohsComplianceCode",
    "rohsComplianceDescription"
})
public class RohsStatus {

    @XmlElementRef(name = "RohsComplianceCode", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> rohsComplianceCode;
    @XmlElementRef(name = "RohsComplianceDescription", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> rohsComplianceDescription;

    /**
     * Gets the value of the rohsComplianceCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRohsComplianceCode() {
        return rohsComplianceCode;
    }

    /**
     * Sets the value of the rohsComplianceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRohsComplianceCode(JAXBElement<String> value) {
        this.rohsComplianceCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the rohsComplianceDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRohsComplianceDescription() {
        return rohsComplianceDescription;
    }

    /**
     * Sets the value of the rohsComplianceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRohsComplianceDescription(JAXBElement<String> value) {
        this.rohsComplianceDescription = ((JAXBElement<String> ) value);
    }

}
