
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProductShoppingBasket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProductShoppingBasket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductShoppingBasket" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ProductShoppingBasket" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProductShoppingBasket", propOrder = {
    "productShoppingBasket"
})
public class ArrayOfProductShoppingBasket {

    @XmlElement(name = "ProductShoppingBasket", nillable = true)
    protected List<ProductShoppingBasket> productShoppingBasket;

    /**
     * Gets the value of the productShoppingBasket property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productShoppingBasket property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductShoppingBasket().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductShoppingBasket }
     * 
     * 
     */
    public List<ProductShoppingBasket> getProductShoppingBasket() {
        if (productShoppingBasket == null) {
            productShoppingBasket = new ArrayList<ProductShoppingBasket>();
        }
        return this.productShoppingBasket;
    }

}
