/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.hp.es.xml.batchEntitlement.types;

/**
 * Enumeration PartialResultFlagType.
 * 
 * @version $Revision$ $Date$
 */
public enum PartialResultFlagType {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant Y
     */
    Y("Y"),
    /**
     * Constant N
     */
    N("N");

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field value.
     */
    private final java.lang.String value;

    /**
     * Field enumConstants.
     */
    private static final java.util.Map<java.lang.String, PartialResultFlagType> enumConstants = new java.util.HashMap<java.lang.String, PartialResultFlagType>();


    static {
        for (PartialResultFlagType c: PartialResultFlagType.values()) {
            PartialResultFlagType.enumConstants.put(c.value, c);
        }

    };


      //----------------/
     //- Constructors -/
    //----------------/

    private PartialResultFlagType(final java.lang.String value) {
        this.value = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method fromValue.
     * 
     * @param value
     * @return the constant for this value
     */
    public static com.hp.es.xml.batchEntitlement.types.PartialResultFlagType fromValue(
            final java.lang.String value) {
        PartialResultFlagType c = PartialResultFlagType.enumConstants.get(value);
        if (c != null) {
            return c;
        }
        throw new IllegalArgumentException(value);
    }

    /**
     * 
     * 
     * @param value
     */
    public void setValue(
            final java.lang.String value) {
    }

    /**
     * Method toString.
     * 
     * @return the value of this constant
     */
    public java.lang.String toString(
    ) {
        return this.value;
    }

    /**
     * Method value.
     * 
     * @return the value of this constant
     */
    public java.lang.String value(
    ) {
        return this.value;
    }

}
