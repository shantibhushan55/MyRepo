
package com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfValidSparePart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfValidSparePart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ValidSparePart" type="{http://schemas.datacontract.org/2004/07/HP.WWSNR.ManufacturingInstalledBaseService.Data}ValidSparePart" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfValidSparePart", propOrder = {
    "validSparePart"
})
public class ArrayOfValidSparePart {

    @XmlElement(name = "ValidSparePart", nillable = true)
    protected List<ValidSparePart> validSparePart;

    /**
     * Gets the value of the validSparePart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validSparePart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidSparePart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValidSparePart }
     * 
     * 
     */
    public List<ValidSparePart> getValidSparePart() {
        if (validSparePart == null) {
            validSparePart = new ArrayList<ValidSparePart>();
        }
        return this.validSparePart;
    }

}
