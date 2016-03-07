
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WwsnrsTracePrimaryReturn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WwsnrsTracePrimaryReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wwsnrsinput" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}WWSNRSPrimaryInput" minOccurs="0"/>
 *         &lt;element name="header" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}WWSNRSHeader" minOccurs="0"/>
 *         &lt;element name="BundleUnits" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfBundleUnit" minOccurs="0"/>
 *         &lt;element name="unit_configuration" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfunit_configuration" minOccurs="0"/>
 *         &lt;element name="shopping_basket" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfshopping_basket" minOccurs="0"/>
 *         &lt;element name="RoHS_unit_status" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}RoHS_unit_status" minOccurs="0"/>
 *         &lt;element name="spare_part" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfspare_part" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WwsnrsTracePrimaryReturn", propOrder = {
    "wwsnrsinput",
    "header",
    "bundleUnits",
    "unitConfiguration",
    "shoppingBasket",
    "roHSUnitStatus",
    "sparePart"
})
public class WwsnrsTracePrimaryReturn {

    @XmlElementRef(name = "wwsnrsinput", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<WWSNRSPrimaryInput> wwsnrsinput;
    @XmlElementRef(name = "header", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<WWSNRSHeader> header;
    @XmlElementRef(name = "BundleUnits", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfBundleUnit> bundleUnits;
    @XmlElementRef(name = "unit_configuration", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfunitConfiguration> unitConfiguration;
    @XmlElementRef(name = "shopping_basket", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfshoppingBasket> shoppingBasket;
    @XmlElementRef(name = "RoHS_unit_status", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<RoHSUnitStatus> roHSUnitStatus;
    @XmlElementRef(name = "spare_part", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfsparePart> sparePart;

    /**
     * Gets the value of the wwsnrsinput property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WWSNRSPrimaryInput }{@code >}
     *     
     */
    public JAXBElement<WWSNRSPrimaryInput> getWwsnrsinput() {
        return wwsnrsinput;
    }

    /**
     * Sets the value of the wwsnrsinput property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WWSNRSPrimaryInput }{@code >}
     *     
     */
    public void setWwsnrsinput(JAXBElement<WWSNRSPrimaryInput> value) {
        this.wwsnrsinput = ((JAXBElement<WWSNRSPrimaryInput> ) value);
    }

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WWSNRSHeader }{@code >}
     *     
     */
    public JAXBElement<WWSNRSHeader> getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WWSNRSHeader }{@code >}
     *     
     */
    public void setHeader(JAXBElement<WWSNRSHeader> value) {
        this.header = ((JAXBElement<WWSNRSHeader> ) value);
    }

    /**
     * Gets the value of the bundleUnits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBundleUnit }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBundleUnit> getBundleUnits() {
        return bundleUnits;
    }

    /**
     * Sets the value of the bundleUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBundleUnit }{@code >}
     *     
     */
    public void setBundleUnits(JAXBElement<ArrayOfBundleUnit> value) {
        this.bundleUnits = ((JAXBElement<ArrayOfBundleUnit> ) value);
    }

    /**
     * Gets the value of the unitConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfunitConfiguration }{@code >}
     *     
     */
    public JAXBElement<ArrayOfunitConfiguration> getUnitConfiguration() {
        return unitConfiguration;
    }

    /**
     * Sets the value of the unitConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfunitConfiguration }{@code >}
     *     
     */
    public void setUnitConfiguration(JAXBElement<ArrayOfunitConfiguration> value) {
        this.unitConfiguration = ((JAXBElement<ArrayOfunitConfiguration> ) value);
    }

    /**
     * Gets the value of the shoppingBasket property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfshoppingBasket }{@code >}
     *     
     */
    public JAXBElement<ArrayOfshoppingBasket> getShoppingBasket() {
        return shoppingBasket;
    }

    /**
     * Sets the value of the shoppingBasket property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfshoppingBasket }{@code >}
     *     
     */
    public void setShoppingBasket(JAXBElement<ArrayOfshoppingBasket> value) {
        this.shoppingBasket = ((JAXBElement<ArrayOfshoppingBasket> ) value);
    }

    /**
     * Gets the value of the roHSUnitStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RoHSUnitStatus }{@code >}
     *     
     */
    public JAXBElement<RoHSUnitStatus> getRoHSUnitStatus() {
        return roHSUnitStatus;
    }

    /**
     * Sets the value of the roHSUnitStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RoHSUnitStatus }{@code >}
     *     
     */
    public void setRoHSUnitStatus(JAXBElement<RoHSUnitStatus> value) {
        this.roHSUnitStatus = ((JAXBElement<RoHSUnitStatus> ) value);
    }

    /**
     * Gets the value of the sparePart property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfsparePart }{@code >}
     *     
     */
    public JAXBElement<ArrayOfsparePart> getSparePart() {
        return sparePart;
    }

    /**
     * Sets the value of the sparePart property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfsparePart }{@code >}
     *     
     */
    public void setSparePart(JAXBElement<ArrayOfsparePart> value) {
        this.sparePart = ((JAXBElement<ArrayOfsparePart> ) value);
    }

}
