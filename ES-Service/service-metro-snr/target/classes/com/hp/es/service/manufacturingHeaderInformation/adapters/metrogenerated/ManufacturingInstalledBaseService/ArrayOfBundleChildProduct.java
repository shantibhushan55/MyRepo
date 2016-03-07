
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBundleChildProduct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBundleChildProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BundleChildProduct" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}BundleChildProduct" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBundleChildProduct", propOrder = {
    "bundleChildProduct"
})
public class ArrayOfBundleChildProduct {

    @XmlElement(name = "BundleChildProduct", nillable = true)
    protected List<BundleChildProduct> bundleChildProduct;

    /**
     * Gets the value of the bundleChildProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bundleChildProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBundleChildProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BundleChildProduct }
     * 
     * 
     */
    public List<BundleChildProduct> getBundleChildProduct() {
        if (bundleChildProduct == null) {
            bundleChildProduct = new ArrayList<BundleChildProduct>();
        }
        return this.bundleChildProduct;
    }

}
