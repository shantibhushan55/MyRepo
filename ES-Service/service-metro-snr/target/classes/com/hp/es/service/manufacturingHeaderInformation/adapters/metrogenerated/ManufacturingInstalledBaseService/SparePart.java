
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for spare_part complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="spare_part">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="part_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spare_part_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spare_part_description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spare_enhance_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_keyword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_materialgrp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_unitofmeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_materialgrptxt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_csrflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_hazardous" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_orderinstr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_techcourier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_returnableflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_usagepercentage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_element1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_element2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_element3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_requested_delivery_ts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_rohs_status_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_is_compliant_with_product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_is_whole_unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp_is_compliant_with_rohs_jurisdiction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "spare_part", propOrder = {
    "partNumber",
    "sparePartNo",
    "sparePartDescription",
    "spareEnhanceDesc",
    "spCategory",
    "spKeyword",
    "spStatus",
    "spMaterialgrp",
    "spUnitofmeasure",
    "spMaterialgrptxt",
    "spCsrflag",
    "spHazardous",
    "spOrderinstr",
    "spTechcourier",
    "spReturnableflag",
    "spUsagepercentage",
    "spElement1",
    "spElement2",
    "spElement3",
    "spRequestedDeliveryTs",
    "spRohsStatusCode",
    "spIsCompliantWithProduct",
    "spIsWholeUnit",
    "spIsCompliantWithRohsJurisdiction"
})
public class SparePart {

    @XmlElementRef(name = "part_number", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> partNumber;
    @XmlElementRef(name = "spare_part_no", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> sparePartNo;
    @XmlElementRef(name = "spare_part_description", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> sparePartDescription;
    @XmlElementRef(name = "spare_enhance_desc", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spareEnhanceDesc;
    @XmlElementRef(name = "sp_category", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spCategory;
    @XmlElementRef(name = "sp_keyword", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spKeyword;
    @XmlElementRef(name = "sp_status", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spStatus;
    @XmlElementRef(name = "sp_materialgrp", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spMaterialgrp;
    @XmlElementRef(name = "sp_unitofmeasure", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spUnitofmeasure;
    @XmlElementRef(name = "sp_materialgrptxt", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spMaterialgrptxt;
    @XmlElementRef(name = "sp_csrflag", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spCsrflag;
    @XmlElementRef(name = "sp_hazardous", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spHazardous;
    @XmlElementRef(name = "sp_orderinstr", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spOrderinstr;
    @XmlElementRef(name = "sp_techcourier", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spTechcourier;
    @XmlElementRef(name = "sp_returnableflag", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spReturnableflag;
    @XmlElementRef(name = "sp_usagepercentage", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spUsagepercentage;
    @XmlElementRef(name = "sp_element1", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spElement1;
    @XmlElementRef(name = "sp_element2", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spElement2;
    @XmlElementRef(name = "sp_element3", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spElement3;
    @XmlElementRef(name = "sp_requested_delivery_ts", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spRequestedDeliveryTs;
    @XmlElementRef(name = "sp_rohs_status_code", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spRohsStatusCode;
    @XmlElementRef(name = "sp_is_compliant_with_product", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spIsCompliantWithProduct;
    @XmlElementRef(name = "sp_is_whole_unit", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spIsWholeUnit;
    @XmlElementRef(name = "sp_is_compliant_with_rohs_jurisdiction", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> spIsCompliantWithRohsJurisdiction;

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
     * Gets the value of the sparePartNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSparePartNo() {
        return sparePartNo;
    }

    /**
     * Sets the value of the sparePartNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSparePartNo(JAXBElement<String> value) {
        this.sparePartNo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the sparePartDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSparePartDescription() {
        return sparePartDescription;
    }

    /**
     * Sets the value of the sparePartDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSparePartDescription(JAXBElement<String> value) {
        this.sparePartDescription = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spareEnhanceDesc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpareEnhanceDesc() {
        return spareEnhanceDesc;
    }

    /**
     * Sets the value of the spareEnhanceDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpareEnhanceDesc(JAXBElement<String> value) {
        this.spareEnhanceDesc = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpCategory() {
        return spCategory;
    }

    /**
     * Sets the value of the spCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpCategory(JAXBElement<String> value) {
        this.spCategory = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spKeyword property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpKeyword() {
        return spKeyword;
    }

    /**
     * Sets the value of the spKeyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpKeyword(JAXBElement<String> value) {
        this.spKeyword = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpStatus() {
        return spStatus;
    }

    /**
     * Sets the value of the spStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpStatus(JAXBElement<String> value) {
        this.spStatus = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spMaterialgrp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpMaterialgrp() {
        return spMaterialgrp;
    }

    /**
     * Sets the value of the spMaterialgrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpMaterialgrp(JAXBElement<String> value) {
        this.spMaterialgrp = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spUnitofmeasure property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpUnitofmeasure() {
        return spUnitofmeasure;
    }

    /**
     * Sets the value of the spUnitofmeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpUnitofmeasure(JAXBElement<String> value) {
        this.spUnitofmeasure = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spMaterialgrptxt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpMaterialgrptxt() {
        return spMaterialgrptxt;
    }

    /**
     * Sets the value of the spMaterialgrptxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpMaterialgrptxt(JAXBElement<String> value) {
        this.spMaterialgrptxt = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spCsrflag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpCsrflag() {
        return spCsrflag;
    }

    /**
     * Sets the value of the spCsrflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpCsrflag(JAXBElement<String> value) {
        this.spCsrflag = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spHazardous property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpHazardous() {
        return spHazardous;
    }

    /**
     * Sets the value of the spHazardous property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpHazardous(JAXBElement<String> value) {
        this.spHazardous = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spOrderinstr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpOrderinstr() {
        return spOrderinstr;
    }

    /**
     * Sets the value of the spOrderinstr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpOrderinstr(JAXBElement<String> value) {
        this.spOrderinstr = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spTechcourier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpTechcourier() {
        return spTechcourier;
    }

    /**
     * Sets the value of the spTechcourier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpTechcourier(JAXBElement<String> value) {
        this.spTechcourier = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spReturnableflag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpReturnableflag() {
        return spReturnableflag;
    }

    /**
     * Sets the value of the spReturnableflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpReturnableflag(JAXBElement<String> value) {
        this.spReturnableflag = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spUsagepercentage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpUsagepercentage() {
        return spUsagepercentage;
    }

    /**
     * Sets the value of the spUsagepercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpUsagepercentage(JAXBElement<String> value) {
        this.spUsagepercentage = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spElement1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpElement1() {
        return spElement1;
    }

    /**
     * Sets the value of the spElement1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpElement1(JAXBElement<String> value) {
        this.spElement1 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spElement2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpElement2() {
        return spElement2;
    }

    /**
     * Sets the value of the spElement2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpElement2(JAXBElement<String> value) {
        this.spElement2 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spElement3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpElement3() {
        return spElement3;
    }

    /**
     * Sets the value of the spElement3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpElement3(JAXBElement<String> value) {
        this.spElement3 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spRequestedDeliveryTs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpRequestedDeliveryTs() {
        return spRequestedDeliveryTs;
    }

    /**
     * Sets the value of the spRequestedDeliveryTs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpRequestedDeliveryTs(JAXBElement<String> value) {
        this.spRequestedDeliveryTs = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spRohsStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpRohsStatusCode() {
        return spRohsStatusCode;
    }

    /**
     * Sets the value of the spRohsStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpRohsStatusCode(JAXBElement<String> value) {
        this.spRohsStatusCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spIsCompliantWithProduct property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpIsCompliantWithProduct() {
        return spIsCompliantWithProduct;
    }

    /**
     * Sets the value of the spIsCompliantWithProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpIsCompliantWithProduct(JAXBElement<String> value) {
        this.spIsCompliantWithProduct = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spIsWholeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpIsWholeUnit() {
        return spIsWholeUnit;
    }

    /**
     * Sets the value of the spIsWholeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpIsWholeUnit(JAXBElement<String> value) {
        this.spIsWholeUnit = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the spIsCompliantWithRohsJurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpIsCompliantWithRohsJurisdiction() {
        return spIsCompliantWithRohsJurisdiction;
    }

    /**
     * Sets the value of the spIsCompliantWithRohsJurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpIsCompliantWithRohsJurisdiction(JAXBElement<String> value) {
        this.spIsCompliantWithRohsJurisdiction = ((JAXBElement<String> ) value);
    }

}
