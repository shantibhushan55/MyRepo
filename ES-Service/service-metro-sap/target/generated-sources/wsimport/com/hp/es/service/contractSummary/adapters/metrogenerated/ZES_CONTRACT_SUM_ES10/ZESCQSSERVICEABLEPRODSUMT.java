
package com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZES_CQS_SERVICEABLE_PROD_SUM_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZES_CQS_SERVICEABLE_PROD_SUM_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZES_CQS_PRODUCT_ID" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZES_CQS_SERVICEABLE_PROD_SUM_T", propOrder = {
    "item"
})
public class ZESCQSSERVICEABLEPRODSUMT {

    protected List<ZESCQSPRODUCTID> item;

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZESCQSPRODUCTID }
     * 
     * 
     */
    public List<ZESCQSPRODUCTID> getItem() {
        if (item == null) {
            item = new ArrayList<ZESCQSPRODUCTID>();
        }
        return this.item;
    }

}
