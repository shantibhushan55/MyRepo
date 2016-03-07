
package com.hp.es.service.unitEventHistory.adapters.metrogenerated.Z_WARRANTY_EVENT_HISTORY;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;all>
 *         &lt;element name="EVENTHISTORY" type="{urn:sap-com:document:sap:rfc:functions}ZWTY_EVENTHISTORY"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Z_WARRANTY_EVENT_HISTORY.Response")
public class ZWARRANTYEVENTHISTORYResponse {

    @XmlElement(name = "EVENTHISTORY", required = true)
    protected ZWTYEVENTHISTORY eventhistory;

    /**
     * Gets the value of the eventhistory property.
     * 
     * @return
     *     possible object is
     *     {@link ZWTYEVENTHISTORY }
     *     
     */
    public ZWTYEVENTHISTORY getEVENTHISTORY() {
        return eventhistory;
    }

    /**
     * Sets the value of the eventhistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZWTYEVENTHISTORY }
     *     
     */
    public void setEVENTHISTORY(ZWTYEVENTHISTORY value) {
        this.eventhistory = value;
    }

}
