
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductBillOfMaterial complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductBillOfMaterial">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BOMAdditionalInformation" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}BomAdditionalInformation" minOccurs="0"/>
 *         &lt;element name="BundleInfo" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfBundleInformation" minOccurs="0"/>
 *         &lt;element name="Components" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfProductComponent" minOccurs="0"/>
 *         &lt;element name="CurrentLifeCycleStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataSourceInfo" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Division" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductHierarchyInformation" minOccurs="0"/>
 *         &lt;element name="EOL_Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Family" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductHierarchyInformation" minOccurs="0"/>
 *         &lt;element name="Group" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductHierarchyInformation" minOccurs="0"/>
 *         &lt;element name="IsRemarketed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsReturned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Line" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductHierarchyInformation" minOccurs="0"/>
 *         &lt;element name="ManufactureDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Model" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductHierarchyInformation" minOccurs="0"/>
 *         &lt;element name="OdmCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PartnerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Plant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PlantCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductHierarchyInformation" minOccurs="0"/>
 *         &lt;element name="ProductCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductHierarchyInfo" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductHierarchyInformation" minOccurs="0"/>
 *         &lt;element name="ProductNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProgramName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProgramType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecordCreationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecordLastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RohsStatusInfo" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}RohsStatus" minOccurs="0"/>
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShippingInfo" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfProductShippingInformation" minOccurs="0"/>
 *         &lt;element name="ShoppingBaskets" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfProductShoppingBasket" minOccurs="0"/>
 *         &lt;element name="Site" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="SiteCode" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Sku" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductHierarchyInformation" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductHierarchyInformation" minOccurs="0"/>
 *         &lt;element name="UI_Element1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UI_Element2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UI_Element3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidSparePartsInfo" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ArrayOfValidSparePart" minOccurs="0"/>
 *         &lt;element name="WarrantyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WarrantyDuration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WarrantyStart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductBillOfMaterial", propOrder = {
    "bomAdditionalInformation",
    "bundleInfo",
    "components",
    "currentLifeCycleStatus",
    "dataSourceInfo",
    "division",
    "eolStatus",
    "family",
    "group",
    "isRemarketed",
    "isReturned",
    "line",
    "manufactureDate",
    "model",
    "odmCode",
    "partnerType",
    "plant",
    "plantCode",
    "product",
    "productCategory",
    "productDescription",
    "productHierarchyInfo",
    "productNumber",
    "programName",
    "programType",
    "recordCreationDate",
    "recordLastUpdateDate",
    "rohsStatusInfo",
    "serialNumber",
    "shippingInfo",
    "shoppingBaskets",
    "site",
    "siteCode",
    "sku",
    "type",
    "uiElement1",
    "uiElement2",
    "uiElement3",
    "validSparePartsInfo",
    "warrantyCode",
    "warrantyDuration",
    "warrantyStart"
})
public class ProductBillOfMaterial {

    @XmlElementRef(name = "BOMAdditionalInformation", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<BomAdditionalInformation> bomAdditionalInformation;
    @XmlElementRef(name = "BundleInfo", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfBundleInformation> bundleInfo;
    @XmlElementRef(name = "Components", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfProductComponent> components;
    @XmlElementRef(name = "CurrentLifeCycleStatus", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> currentLifeCycleStatus;
    @XmlElementRef(name = "DataSourceInfo", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> dataSourceInfo;
    @XmlElementRef(name = "Division", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductHierarchyInformation> division;
    @XmlElementRef(name = "EOL_Status", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> eolStatus;
    @XmlElementRef(name = "Family", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductHierarchyInformation> family;
    @XmlElementRef(name = "Group", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductHierarchyInformation> group;
    @XmlElement(name = "IsRemarketed")
    protected Boolean isRemarketed;
    @XmlElement(name = "IsReturned")
    protected Boolean isReturned;
    @XmlElementRef(name = "Line", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductHierarchyInformation> line;
    @XmlElementRef(name = "ManufactureDate", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> manufactureDate;
    @XmlElementRef(name = "Model", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductHierarchyInformation> model;
    @XmlElementRef(name = "OdmCode", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> odmCode;
    @XmlElementRef(name = "PartnerType", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> partnerType;
    @XmlElementRef(name = "Plant", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> plant;
    @XmlElementRef(name = "PlantCode", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> plantCode;
    @XmlElementRef(name = "Product", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductHierarchyInformation> product;
    @XmlElementRef(name = "ProductCategory", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> productCategory;
    @XmlElementRef(name = "ProductDescription", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> productDescription;
    @XmlElementRef(name = "ProductHierarchyInfo", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductHierarchyInformation> productHierarchyInfo;
    @XmlElementRef(name = "ProductNumber", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> productNumber;
    @XmlElementRef(name = "ProgramName", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> programName;
    @XmlElementRef(name = "ProgramType", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> programType;
    @XmlElementRef(name = "RecordCreationDate", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> recordCreationDate;
    @XmlElementRef(name = "RecordLastUpdateDate", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> recordLastUpdateDate;
    @XmlElementRef(name = "RohsStatusInfo", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<RohsStatus> rohsStatusInfo;
    @XmlElementRef(name = "SerialNumber", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> serialNumber;
    @XmlElementRef(name = "ShippingInfo", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfProductShippingInformation> shippingInfo;
    @XmlElementRef(name = "ShoppingBaskets", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfProductShoppingBasket> shoppingBaskets;
    @XmlElementRef(name = "Site", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> site;
    @XmlElementRef(name = "SiteCode", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> siteCode;
    @XmlElementRef(name = "Sku", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductHierarchyInformation> sku;
    @XmlElementRef(name = "Type", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ProductHierarchyInformation> type;
    @XmlElementRef(name = "UI_Element1", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> uiElement1;
    @XmlElementRef(name = "UI_Element2", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> uiElement2;
    @XmlElementRef(name = "UI_Element3", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> uiElement3;
    @XmlElementRef(name = "ValidSparePartsInfo", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<ArrayOfValidSparePart> validSparePartsInfo;
    @XmlElementRef(name = "WarrantyCode", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> warrantyCode;
    @XmlElementRef(name = "WarrantyDuration", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> warrantyDuration;
    @XmlElementRef(name = "WarrantyStart", namespace = "http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data", type = JAXBElement.class)
    protected JAXBElement<String> warrantyStart;

    /**
     * Gets the value of the bomAdditionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BomAdditionalInformation }{@code >}
     *     
     */
    public JAXBElement<BomAdditionalInformation> getBOMAdditionalInformation() {
        return bomAdditionalInformation;
    }

    /**
     * Sets the value of the bomAdditionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BomAdditionalInformation }{@code >}
     *     
     */
    public void setBOMAdditionalInformation(JAXBElement<BomAdditionalInformation> value) {
        this.bomAdditionalInformation = ((JAXBElement<BomAdditionalInformation> ) value);
    }

    /**
     * Gets the value of the bundleInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBundleInformation }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBundleInformation> getBundleInfo() {
        return bundleInfo;
    }

    /**
     * Sets the value of the bundleInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBundleInformation }{@code >}
     *     
     */
    public void setBundleInfo(JAXBElement<ArrayOfBundleInformation> value) {
        this.bundleInfo = ((JAXBElement<ArrayOfBundleInformation> ) value);
    }

    /**
     * Gets the value of the components property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductComponent }{@code >}
     *     
     */
    public JAXBElement<ArrayOfProductComponent> getComponents() {
        return components;
    }

    /**
     * Sets the value of the components property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductComponent }{@code >}
     *     
     */
    public void setComponents(JAXBElement<ArrayOfProductComponent> value) {
        this.components = ((JAXBElement<ArrayOfProductComponent> ) value);
    }

    /**
     * Gets the value of the currentLifeCycleStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrentLifeCycleStatus() {
        return currentLifeCycleStatus;
    }

    /**
     * Sets the value of the currentLifeCycleStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrentLifeCycleStatus(JAXBElement<String> value) {
        this.currentLifeCycleStatus = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dataSourceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getDataSourceInfo() {
        return dataSourceInfo;
    }

    /**
     * Sets the value of the dataSourceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setDataSourceInfo(JAXBElement<ArrayOfstring> value) {
        this.dataSourceInfo = ((JAXBElement<ArrayOfstring> ) value);
    }

    /**
     * Gets the value of the division property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public JAXBElement<ProductHierarchyInformation> getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public void setDivision(JAXBElement<ProductHierarchyInformation> value) {
        this.division = ((JAXBElement<ProductHierarchyInformation> ) value);
    }

    /**
     * Gets the value of the eolStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEOLStatus() {
        return eolStatus;
    }

    /**
     * Sets the value of the eolStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEOLStatus(JAXBElement<String> value) {
        this.eolStatus = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the family property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public JAXBElement<ProductHierarchyInformation> getFamily() {
        return family;
    }

    /**
     * Sets the value of the family property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public void setFamily(JAXBElement<ProductHierarchyInformation> value) {
        this.family = ((JAXBElement<ProductHierarchyInformation> ) value);
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public JAXBElement<ProductHierarchyInformation> getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public void setGroup(JAXBElement<ProductHierarchyInformation> value) {
        this.group = ((JAXBElement<ProductHierarchyInformation> ) value);
    }

    /**
     * Gets the value of the isRemarketed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRemarketed() {
        return isRemarketed;
    }

    /**
     * Sets the value of the isRemarketed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRemarketed(Boolean value) {
        this.isRemarketed = value;
    }

    /**
     * Gets the value of the isReturned property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsReturned() {
        return isReturned;
    }

    /**
     * Sets the value of the isReturned property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsReturned(Boolean value) {
        this.isReturned = value;
    }

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public JAXBElement<ProductHierarchyInformation> getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public void setLine(JAXBElement<ProductHierarchyInformation> value) {
        this.line = ((JAXBElement<ProductHierarchyInformation> ) value);
    }

    /**
     * Gets the value of the manufactureDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getManufactureDate() {
        return manufactureDate;
    }

    /**
     * Sets the value of the manufactureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setManufactureDate(JAXBElement<String> value) {
        this.manufactureDate = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public JAXBElement<ProductHierarchyInformation> getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public void setModel(JAXBElement<ProductHierarchyInformation> value) {
        this.model = ((JAXBElement<ProductHierarchyInformation> ) value);
    }

    /**
     * Gets the value of the odmCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOdmCode() {
        return odmCode;
    }

    /**
     * Sets the value of the odmCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOdmCode(JAXBElement<String> value) {
        this.odmCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the partnerType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerType() {
        return partnerType;
    }

    /**
     * Sets the value of the partnerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerType(JAXBElement<String> value) {
        this.partnerType = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the plant property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlant() {
        return plant;
    }

    /**
     * Sets the value of the plant property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlant(JAXBElement<String> value) {
        this.plant = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the plantCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlantCode() {
        return plantCode;
    }

    /**
     * Sets the value of the plantCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlantCode(JAXBElement<String> value) {
        this.plantCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public JAXBElement<ProductHierarchyInformation> getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public void setProduct(JAXBElement<ProductHierarchyInformation> value) {
        this.product = ((JAXBElement<ProductHierarchyInformation> ) value);
    }

    /**
     * Gets the value of the productCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductCategory() {
        return productCategory;
    }

    /**
     * Sets the value of the productCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductCategory(JAXBElement<String> value) {
        this.productCategory = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the productDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the value of the productDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductDescription(JAXBElement<String> value) {
        this.productDescription = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the productHierarchyInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public JAXBElement<ProductHierarchyInformation> getProductHierarchyInfo() {
        return productHierarchyInfo;
    }

    /**
     * Sets the value of the productHierarchyInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public void setProductHierarchyInfo(JAXBElement<ProductHierarchyInformation> value) {
        this.productHierarchyInfo = ((JAXBElement<ProductHierarchyInformation> ) value);
    }

    /**
     * Gets the value of the productNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductNumber() {
        return productNumber;
    }

    /**
     * Sets the value of the productNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductNumber(JAXBElement<String> value) {
        this.productNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the programName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProgramName() {
        return programName;
    }

    /**
     * Sets the value of the programName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProgramName(JAXBElement<String> value) {
        this.programName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the programType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProgramType() {
        return programType;
    }

    /**
     * Sets the value of the programType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProgramType(JAXBElement<String> value) {
        this.programType = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the recordCreationDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecordCreationDate() {
        return recordCreationDate;
    }

    /**
     * Sets the value of the recordCreationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecordCreationDate(JAXBElement<String> value) {
        this.recordCreationDate = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the recordLastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecordLastUpdateDate() {
        return recordLastUpdateDate;
    }

    /**
     * Sets the value of the recordLastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecordLastUpdateDate(JAXBElement<String> value) {
        this.recordLastUpdateDate = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the rohsStatusInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RohsStatus }{@code >}
     *     
     */
    public JAXBElement<RohsStatus> getRohsStatusInfo() {
        return rohsStatusInfo;
    }

    /**
     * Sets the value of the rohsStatusInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RohsStatus }{@code >}
     *     
     */
    public void setRohsStatusInfo(JAXBElement<RohsStatus> value) {
        this.rohsStatusInfo = ((JAXBElement<RohsStatus> ) value);
    }

    /**
     * Gets the value of the serialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSerialNumber(JAXBElement<String> value) {
        this.serialNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shippingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductShippingInformation }{@code >}
     *     
     */
    public JAXBElement<ArrayOfProductShippingInformation> getShippingInfo() {
        return shippingInfo;
    }

    /**
     * Sets the value of the shippingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductShippingInformation }{@code >}
     *     
     */
    public void setShippingInfo(JAXBElement<ArrayOfProductShippingInformation> value) {
        this.shippingInfo = ((JAXBElement<ArrayOfProductShippingInformation> ) value);
    }

    /**
     * Gets the value of the shoppingBaskets property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductShoppingBasket }{@code >}
     *     
     */
    public JAXBElement<ArrayOfProductShoppingBasket> getShoppingBaskets() {
        return shoppingBaskets;
    }

    /**
     * Sets the value of the shoppingBaskets property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProductShoppingBasket }{@code >}
     *     
     */
    public void setShoppingBaskets(JAXBElement<ArrayOfProductShoppingBasket> value) {
        this.shoppingBaskets = ((JAXBElement<ArrayOfProductShoppingBasket> ) value);
    }

    /**
     * Gets the value of the site property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getSite() {
        return site;
    }

    /**
     * Sets the value of the site property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setSite(JAXBElement<ArrayOfstring> value) {
        this.site = ((JAXBElement<ArrayOfstring> ) value);
    }

    /**
     * Gets the value of the siteCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getSiteCode() {
        return siteCode;
    }

    /**
     * Sets the value of the siteCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setSiteCode(JAXBElement<ArrayOfstring> value) {
        this.siteCode = ((JAXBElement<ArrayOfstring> ) value);
    }

    /**
     * Gets the value of the sku property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public JAXBElement<ProductHierarchyInformation> getSku() {
        return sku;
    }

    /**
     * Sets the value of the sku property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public void setSku(JAXBElement<ProductHierarchyInformation> value) {
        this.sku = ((JAXBElement<ProductHierarchyInformation> ) value);
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public JAXBElement<ProductHierarchyInformation> getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProductHierarchyInformation }{@code >}
     *     
     */
    public void setType(JAXBElement<ProductHierarchyInformation> value) {
        this.type = ((JAXBElement<ProductHierarchyInformation> ) value);
    }

    /**
     * Gets the value of the uiElement1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUIElement1() {
        return uiElement1;
    }

    /**
     * Sets the value of the uiElement1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUIElement1(JAXBElement<String> value) {
        this.uiElement1 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the uiElement2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUIElement2() {
        return uiElement2;
    }

    /**
     * Sets the value of the uiElement2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUIElement2(JAXBElement<String> value) {
        this.uiElement2 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the uiElement3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUIElement3() {
        return uiElement3;
    }

    /**
     * Sets the value of the uiElement3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUIElement3(JAXBElement<String> value) {
        this.uiElement3 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the validSparePartsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfValidSparePart }{@code >}
     *     
     */
    public JAXBElement<ArrayOfValidSparePart> getValidSparePartsInfo() {
        return validSparePartsInfo;
    }

    /**
     * Sets the value of the validSparePartsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfValidSparePart }{@code >}
     *     
     */
    public void setValidSparePartsInfo(JAXBElement<ArrayOfValidSparePart> value) {
        this.validSparePartsInfo = ((JAXBElement<ArrayOfValidSparePart> ) value);
    }

    /**
     * Gets the value of the warrantyCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWarrantyCode() {
        return warrantyCode;
    }

    /**
     * Sets the value of the warrantyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWarrantyCode(JAXBElement<String> value) {
        this.warrantyCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the warrantyDuration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWarrantyDuration() {
        return warrantyDuration;
    }

    /**
     * Sets the value of the warrantyDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWarrantyDuration(JAXBElement<String> value) {
        this.warrantyDuration = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the warrantyStart property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWarrantyStart() {
        return warrantyStart;
    }

    /**
     * Sets the value of the warrantyStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWarrantyStart(JAXBElement<String> value) {
        this.warrantyStart = ((JAXBElement<String> ) value);
    }

}
