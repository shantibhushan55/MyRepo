
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for unit_configuration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="unit_configuration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parent_part_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="part_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="part_description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="part_serialno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="part_quantity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_moduleid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_materialgrp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_rohs_status_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_has_minimum_rohs_exception" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_unitofmeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_materialgrptxt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_csrflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_hazardous" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_orderinstr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_techcourier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_returnableflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_usagepercentage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_element1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_element2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uc_element3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unit_configuration", propOrder = {
    "parentPartNumber",
    "partNumber",
    "partDescription",
    "partSerialno",
    "partQuantity",
    "ucModuleid",
    "ucMaterialgrp",
    "ucRohsStatusCode",
    "ucHasMinimumRohsException",
    "ucUnitofmeasure",
    "ucMaterialgrptxt",
    "ucCsrflag",
    "ucHazardous",
    "ucOrderinstr",
    "ucTechcourier",
    "ucReturnableflag",
    "ucUsagepercentage",
    "ucElement1",
    "ucElement2",
    "ucElement3"
})
public class UnitConfiguration {

    @XmlElementRef(name = "parent_part_number", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> parentPartNumber;
    @XmlElementRef(name = "part_number", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> partNumber;
    @XmlElementRef(name = "part_description", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> partDescription;
    @XmlElementRef(name = "part_serialno", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> partSerialno;
    @XmlElementRef(name = "part_quantity", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> partQuantity;
    @XmlElementRef(name = "uc_moduleid", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucModuleid;
    @XmlElementRef(name = "uc_materialgrp", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucMaterialgrp;
    @XmlElementRef(name = "uc_rohs_status_code", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucRohsStatusCode;
    @XmlElementRef(name = "uc_has_minimum_rohs_exception", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucHasMinimumRohsException;
    @XmlElementRef(name = "uc_unitofmeasure", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucUnitofmeasure;
    @XmlElementRef(name = "uc_materialgrptxt", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucMaterialgrptxt;
    @XmlElementRef(name = "uc_csrflag", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucCsrflag;
    @XmlElementRef(name = "uc_hazardous", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucHazardous;
    @XmlElementRef(name = "uc_orderinstr", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucOrderinstr;
    @XmlElementRef(name = "uc_techcourier", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucTechcourier;
    @XmlElementRef(name = "uc_returnableflag", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucReturnableflag;
    @XmlElementRef(name = "uc_usagepercentage", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucUsagepercentage;
    @XmlElementRef(name = "uc_element1", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucElement1;
    @XmlElementRef(name = "uc_element2", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucElement2;
    @XmlElementRef(name = "uc_element3", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> ucElement3;

    /**
     * Gets the value of the parentPartNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParentPartNumber() {
        return parentPartNumber;
    }

    /**
     * Sets the value of the parentPartNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParentPartNumber(JAXBElement<String> value) {
        this.parentPartNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the partNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartNumber() {
        return partNumber;
    }

    /**
     * Sets the value of the partNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartNumber(JAXBElement<String> value) {
        this.partNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the partDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartDescription() {
        return partDescription;
    }

    /**
     * Sets the value of the partDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartDescription(JAXBElement<String> value) {
        this.partDescription = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the partSerialno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartSerialno() {
        return partSerialno;
    }

    /**
     * Sets the value of the partSerialno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartSerialno(JAXBElement<String> value) {
        this.partSerialno = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the partQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartQuantity() {
        return partQuantity;
    }

    /**
     * Sets the value of the partQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartQuantity(JAXBElement<String> value) {
        this.partQuantity = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucModuleid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcModuleid() {
        return ucModuleid;
    }

    /**
     * Sets the value of the ucModuleid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcModuleid(JAXBElement<String> value) {
        this.ucModuleid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucMaterialgrp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcMaterialgrp() {
        return ucMaterialgrp;
    }

    /**
     * Sets the value of the ucMaterialgrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcMaterialgrp(JAXBElement<String> value) {
        this.ucMaterialgrp = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucRohsStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcRohsStatusCode() {
        return ucRohsStatusCode;
    }

    /**
     * Sets the value of the ucRohsStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcRohsStatusCode(JAXBElement<String> value) {
        this.ucRohsStatusCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucHasMinimumRohsException property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcHasMinimumRohsException() {
        return ucHasMinimumRohsException;
    }

    /**
     * Sets the value of the ucHasMinimumRohsException property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcHasMinimumRohsException(JAXBElement<String> value) {
        this.ucHasMinimumRohsException = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucUnitofmeasure property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcUnitofmeasure() {
        return ucUnitofmeasure;
    }

    /**
     * Sets the value of the ucUnitofmeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcUnitofmeasure(JAXBElement<String> value) {
        this.ucUnitofmeasure = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucMaterialgrptxt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcMaterialgrptxt() {
        return ucMaterialgrptxt;
    }

    /**
     * Sets the value of the ucMaterialgrptxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcMaterialgrptxt(JAXBElement<String> value) {
        this.ucMaterialgrptxt = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucCsrflag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcCsrflag() {
        return ucCsrflag;
    }

    /**
     * Sets the value of the ucCsrflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcCsrflag(JAXBElement<String> value) {
        this.ucCsrflag = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucHazardous property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcHazardous() {
        return ucHazardous;
    }

    /**
     * Sets the value of the ucHazardous property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcHazardous(JAXBElement<String> value) {
        this.ucHazardous = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucOrderinstr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcOrderinstr() {
        return ucOrderinstr;
    }

    /**
     * Sets the value of the ucOrderinstr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcOrderinstr(JAXBElement<String> value) {
        this.ucOrderinstr = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucTechcourier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcTechcourier() {
        return ucTechcourier;
    }

    /**
     * Sets the value of the ucTechcourier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcTechcourier(JAXBElement<String> value) {
        this.ucTechcourier = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucReturnableflag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcReturnableflag() {
        return ucReturnableflag;
    }

    /**
     * Sets the value of the ucReturnableflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcReturnableflag(JAXBElement<String> value) {
        this.ucReturnableflag = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucUsagepercentage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcUsagepercentage() {
        return ucUsagepercentage;
    }

    /**
     * Sets the value of the ucUsagepercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcUsagepercentage(JAXBElement<String> value) {
        this.ucUsagepercentage = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucElement1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcElement1() {
        return ucElement1;
    }

    /**
     * Sets the value of the ucElement1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcElement1(JAXBElement<String> value) {
        this.ucElement1 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucElement2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcElement2() {
        return ucElement2;
    }

    /**
     * Sets the value of the ucElement2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcElement2(JAXBElement<String> value) {
        this.ucElement2 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ucElement3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUcElement3() {
        return ucElement3;
    }

    /**
     * Sets the value of the ucElement3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUcElement3(JAXBElement<String> value) {
        this.ucElement3 = ((JAXBElement<String> ) value);
    }

}
