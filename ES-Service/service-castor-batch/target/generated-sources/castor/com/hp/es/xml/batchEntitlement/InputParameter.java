/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.hp.es.xml.batchEntitlement;

/**
 * Class InputParameter.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InputParameter implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _isoCountryCd.
     */
    private java.lang.String _isoCountryCd;

    /**
     * Field _serialNumber.
     */
    private java.lang.String _serialNumber;

    /**
     * Field _productID.
     */
    private java.lang.String _productID;

    /**
     * Field _checkDate.
     */
    private org.exolab.castor.types.Date _checkDate;


      //----------------/
     //- Constructors -/
    //----------------/

    public InputParameter() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Overrides the java.lang.Object.equals method.
     * 
     * @param obj
     * @return true if the objects are equal.
     */
    @Override()
    public boolean equals(
            final java.lang.Object obj) {
        if ( this == obj )
            return true;

        if (obj instanceof InputParameter) {

            InputParameter temp = (InputParameter)obj;
            boolean thcycle;
            boolean tmcycle;
            if (this._isoCountryCd != null) {
                if (temp._isoCountryCd == null) return false;
                if (this._isoCountryCd != temp._isoCountryCd) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._isoCountryCd);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._isoCountryCd);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._isoCountryCd); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._isoCountryCd); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._isoCountryCd.equals(temp._isoCountryCd)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._isoCountryCd);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._isoCountryCd);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._isoCountryCd);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._isoCountryCd);
                    }
                }
            } else if (temp._isoCountryCd != null)
                return false;
            if (this._serialNumber != null) {
                if (temp._serialNumber == null) return false;
                if (this._serialNumber != temp._serialNumber) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._serialNumber);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._serialNumber);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._serialNumber); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._serialNumber); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._serialNumber.equals(temp._serialNumber)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._serialNumber);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._serialNumber);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._serialNumber);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._serialNumber);
                    }
                }
            } else if (temp._serialNumber != null)
                return false;
            if (this._productID != null) {
                if (temp._productID == null) return false;
                if (this._productID != temp._productID) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._productID);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._productID);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._productID); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._productID); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._productID.equals(temp._productID)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._productID);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._productID);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._productID);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._productID);
                    }
                }
            } else if (temp._productID != null)
                return false;
            if (this._checkDate != null) {
                if (temp._checkDate == null) return false;
                if (this._checkDate != temp._checkDate) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._checkDate);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._checkDate);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._checkDate); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._checkDate); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._checkDate.equals(temp._checkDate)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._checkDate);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._checkDate);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._checkDate);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._checkDate);
                    }
                }
            } else if (temp._checkDate != null)
                return false;
            return true;
        }
        return false;
    }

    /**
     * Returns the value of field 'checkDate'.
     * 
     * @return the value of field 'CheckDate'.
     */
    public org.exolab.castor.types.Date getCheckDate(
    ) {
        return this._checkDate;
    }

    /**
     * Returns the value of field 'isoCountryCd'.
     * 
     * @return the value of field 'IsoCountryCd'.
     */
    public java.lang.String getIsoCountryCd(
    ) {
        return this._isoCountryCd;
    }

    /**
     * Returns the value of field 'productID'.
     * 
     * @return the value of field 'ProductID'.
     */
    public java.lang.String getProductID(
    ) {
        return this._productID;
    }

    /**
     * Returns the value of field 'serialNumber'.
     * 
     * @return the value of field 'SerialNumber'.
     */
    public java.lang.String getSerialNumber(
    ) {
        return this._serialNumber;
    }

    /**
     * Overrides the java.lang.Object.hashCode method.
     * <p>
     * The following steps came from <b>Effective Java Programming
     * Language Guide</b> by Joshua Bloch, Chapter 3
     * 
     * @return a hash code value for the object.
     */
    public int hashCode(
    ) {
        int result = 17;

        long tmp;
        if (_isoCountryCd != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_isoCountryCd)) {
           result = 37 * result + _isoCountryCd.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_isoCountryCd);
        }
        if (_serialNumber != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_serialNumber)) {
           result = 37 * result + _serialNumber.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_serialNumber);
        }
        if (_productID != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_productID)) {
           result = 37 * result + _productID.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_productID);
        }
        if (_checkDate != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_checkDate)) {
           result = 37 * result + _checkDate.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_checkDate);
        }

        return result;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'checkDate'.
     * 
     * @param checkDate the value of field 'checkDate'.
     */
    public void setCheckDate(
            final org.exolab.castor.types.Date checkDate) {
        this._checkDate = checkDate;
    }

    /**
     * Sets the value of field 'isoCountryCd'.
     * 
     * @param isoCountryCd the value of field 'isoCountryCd'.
     */
    public void setIsoCountryCd(
            final java.lang.String isoCountryCd) {
        this._isoCountryCd = isoCountryCd;
    }

    /**
     * Sets the value of field 'productID'.
     * 
     * @param productID the value of field 'productID'.
     */
    public void setProductID(
            final java.lang.String productID) {
        this._productID = productID;
    }

    /**
     * Sets the value of field 'serialNumber'.
     * 
     * @param serialNumber the value of field 'serialNumber'.
     */
    public void setSerialNumber(
            final java.lang.String serialNumber) {
        this._serialNumber = serialNumber;
    }

    /**
     * Method unmarshalInputParameter.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.hp.es.xml.batchEntitlement.InputParameter
     */
    public static com.hp.es.xml.batchEntitlement.InputParameter unmarshalInputParameter(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.hp.es.xml.batchEntitlement.InputParameter) org.exolab.castor.xml.Unmarshaller.unmarshal(com.hp.es.xml.batchEntitlement.InputParameter.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
