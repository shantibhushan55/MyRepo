
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
 *         &lt;element name="GetProductLifeCycleEventsResult" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductLifeCycleEventsResponse" minOccurs="0"/>
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
    "getProductLifeCycleEventsResult"
})
@XmlRootElement(name = "GetProductLifeCycleEventsResponse", namespace = "http://tempuri.org/")
public class GetProductLifeCycleEventsResponse {

    @XmlElementRef(name = "GetProductLifeCycleEventsResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ProductLifeCycleEventsResponse> getProductLifeCycleEventsResult;

    /**
     * Gets the value of the getProductLifeCycleEventsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductLifeCycleEventsResponse }{@code >}
     *     
     */
    public JAXBElement<ProductLifeCycleEventsResponse> getGetProductLifeCycleEventsResult() {
        return getProductLifeCycleEventsResult;
    }

    /**
     * Sets the value of the getProductLifeCycleEventsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductLifeCycleEventsResponse }{@code >}
     *     
     */
    public void setGetProductLifeCycleEventsResult(JAXBElement<ProductLifeCycleEventsResponse> value) {
        this.getProductLifeCycleEventsResult = ((JAXBElement<ProductLifeCycleEventsResponse> ) value);
    }

}
