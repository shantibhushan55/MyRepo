/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.hp.es.xml.batchEntitlement;

/**
 * Class EntitlementItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class EntitlementItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _inputParameter.
     */
    private com.hp.es.xml.batchEntitlement.InputParameter _inputParameter;

    /**
     * Field _entitlementStatus.
     */
    private com.hp.es.xml.batchEntitlement.types.EntitlementStatusType _entitlementStatus;

    /**
     * Field _partialResultFlag.
     */
    private com.hp.es.xml.batchEntitlement.types.PartialResultFlagType _partialResultFlag;

    /**
     * Field _entitlementSummary.
     */
    private com.hp.es.xml.batchEntitlement.EntitlementSummaryComplexType _entitlementSummary;


      //----------------/
     //- Constructors -/
    //----------------/

    public EntitlementItem() {
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

        if (obj instanceof EntitlementItem) {

            EntitlementItem temp = (EntitlementItem)obj;
            boolean thcycle;
            boolean tmcycle;
            if (this._inputParameter != null) {
                if (temp._inputParameter == null) return false;
                if (this._inputParameter != temp._inputParameter) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._inputParameter);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._inputParameter);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._inputParameter); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._inputParameter); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._inputParameter.equals(temp._inputParameter)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._inputParameter);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._inputParameter);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._inputParameter);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._inputParameter);
                    }
                }
            } else if (temp._inputParameter != null)
                return false;
            if (this._entitlementStatus != null) {
                if (temp._entitlementStatus == null) return false;
                if (this._entitlementStatus != temp._entitlementStatus) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._entitlementStatus);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._entitlementStatus);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._entitlementStatus); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._entitlementStatus); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._entitlementStatus.equals(temp._entitlementStatus)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._entitlementStatus);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._entitlementStatus);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._entitlementStatus);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._entitlementStatus);
                    }
                }
            } else if (temp._entitlementStatus != null)
                return false;
            if (this._partialResultFlag != null) {
                if (temp._partialResultFlag == null) return false;
                if (this._partialResultFlag != temp._partialResultFlag) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._partialResultFlag);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._partialResultFlag);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._partialResultFlag); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._partialResultFlag); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._partialResultFlag.equals(temp._partialResultFlag)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._partialResultFlag);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._partialResultFlag);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._partialResultFlag);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._partialResultFlag);
                    }
                }
            } else if (temp._partialResultFlag != null)
                return false;
            if (this._entitlementSummary != null) {
                if (temp._entitlementSummary == null) return false;
                if (this._entitlementSummary != temp._entitlementSummary) {
                    thcycle=org.castor.core.util.CycleBreaker.startingToCycle(this._entitlementSummary);
                    tmcycle=org.castor.core.util.CycleBreaker.startingToCycle(temp._entitlementSummary);
                    if (thcycle!=tmcycle) {
                        if (!thcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(this._entitlementSummary); };
                        if (!tmcycle) { org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._entitlementSummary); };
                        return false;
                    }
                    if (!thcycle) {
                        if (!this._entitlementSummary.equals(temp._entitlementSummary)) {
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(this._entitlementSummary);
                            org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._entitlementSummary);
                            return false;
                        }
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(this._entitlementSummary);
                        org.castor.core.util.CycleBreaker.releaseCycleHandle(temp._entitlementSummary);
                    }
                }
            } else if (temp._entitlementSummary != null)
                return false;
            return true;
        }
        return false;
    }

    /**
     * Returns the value of field 'entitlementStatus'.
     * 
     * @return the value of field 'EntitlementStatus'.
     */
    public com.hp.es.xml.batchEntitlement.types.EntitlementStatusType getEntitlementStatus(
    ) {
        return this._entitlementStatus;
    }

    /**
     * Returns the value of field 'entitlementSummary'.
     * 
     * @return the value of field 'EntitlementSummary'.
     */
    public com.hp.es.xml.batchEntitlement.EntitlementSummaryComplexType getEntitlementSummary(
    ) {
        return this._entitlementSummary;
    }

    /**
     * Returns the value of field 'inputParameter'.
     * 
     * @return the value of field 'InputParameter'.
     */
    public com.hp.es.xml.batchEntitlement.InputParameter getInputParameter(
    ) {
        return this._inputParameter;
    }

    /**
     * Returns the value of field 'partialResultFlag'.
     * 
     * @return the value of field 'PartialResultFlag'.
     */
    public com.hp.es.xml.batchEntitlement.types.PartialResultFlagType getPartialResultFlag(
    ) {
        return this._partialResultFlag;
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
        if (_inputParameter != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_inputParameter)) {
           result = 37 * result + _inputParameter.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_inputParameter);
        }
        if (_entitlementStatus != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_entitlementStatus)) {
           result = 37 * result + _entitlementStatus.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_entitlementStatus);
        }
        if (_partialResultFlag != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_partialResultFlag)) {
           result = 37 * result + _partialResultFlag.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_partialResultFlag);
        }
        if (_entitlementSummary != null
               && !org.castor.core.util.CycleBreaker.startingToCycle(_entitlementSummary)) {
           result = 37 * result + _entitlementSummary.hashCode();
           org.castor.core.util.CycleBreaker.releaseCycleHandle(_entitlementSummary);
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
     * Sets the value of field 'entitlementStatus'.
     * 
     * @param entitlementStatus the value of field
     * 'entitlementStatus'.
     */
    public void setEntitlementStatus(
            final com.hp.es.xml.batchEntitlement.types.EntitlementStatusType entitlementStatus) {
        this._entitlementStatus = entitlementStatus;
    }

    /**
     * Sets the value of field 'entitlementSummary'.
     * 
     * @param entitlementSummary the value of field
     * 'entitlementSummary'.
     */
    public void setEntitlementSummary(
            final com.hp.es.xml.batchEntitlement.EntitlementSummaryComplexType entitlementSummary) {
        this._entitlementSummary = entitlementSummary;
    }

    /**
     * Sets the value of field 'inputParameter'.
     * 
     * @param inputParameter the value of field 'inputParameter'.
     */
    public void setInputParameter(
            final com.hp.es.xml.batchEntitlement.InputParameter inputParameter) {
        this._inputParameter = inputParameter;
    }

    /**
     * Sets the value of field 'partialResultFlag'.
     * 
     * @param partialResultFlag the value of field
     * 'partialResultFlag'.
     */
    public void setPartialResultFlag(
            final com.hp.es.xml.batchEntitlement.types.PartialResultFlagType partialResultFlag) {
        this._partialResultFlag = partialResultFlag;
    }

    /**
     * Method unmarshalEntitlementItem.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.hp.es.xml.batchEntitlement.EntitlementItem
     */
    public static com.hp.es.xml.batchEntitlement.EntitlementItem unmarshalEntitlementItem(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.hp.es.xml.batchEntitlement.EntitlementItem) org.exolab.castor.xml.Unmarshaller.unmarshal(com.hp.es.xml.batchEntitlement.EntitlementItem.class, reader);
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
