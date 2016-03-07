
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
 *         &lt;element name="GetSerialInfoResult" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}WwsnrsTracePrimaryReturn" minOccurs="0"/>
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
    "getSerialInfoResult"
})
@XmlRootElement(name = "GetSerialInfoResponse", namespace = "http://tempuri.org/")
public class GetSerialInfoResponse {

    @XmlElementRef(name = "GetSerialInfoResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<WwsnrsTracePrimaryReturn> getSerialInfoResult;

    /**
     * Gets the value of the getSerialInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WwsnrsTracePrimaryReturn }{@code >}
     *     
     */
    public JAXBElement<WwsnrsTracePrimaryReturn> getGetSerialInfoResult() {
        return getSerialInfoResult;
    }

    /**
     * Sets the value of the getSerialInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WwsnrsTracePrimaryReturn }{@code >}
     *     
     */
    public void setGetSerialInfoResult(JAXBElement<WwsnrsTracePrimaryReturn> value) {
        this.getSerialInfoResult = ((JAXBElement<WwsnrsTracePrimaryReturn> ) value);
    }

}
