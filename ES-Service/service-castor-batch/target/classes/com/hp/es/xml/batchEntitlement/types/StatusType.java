/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.hp.es.xml.batchEntitlement.types;

/**
 * Enumeration StatusType.
 * 
 * @version $Revision$ $Date$
 */
public enum StatusType {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant N
     */
    N("N"),
    /**
     * Constant O
     */
    O("O"),
    /**
     * Constant X
     */
    X("X"),
    /**
     * Constant A
     */
    A("A"),
    /**
     * Constant F
     */
    F("F"),
    /**
     * Constant E
     */
    E("E"),
    /**
     * Constant B
     */
    B("B"),
    /**
     * Constant C
     */
    C("C"),
    /**
     * Constant R
     */
    R("R"),
    /**
     * Constant I
     */
    I("I");

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
    private static final java.util.Map<java.lang.String, StatusType> enumConstants = new java.util.HashMap<java.lang.String, StatusType>();


    static {
        for (StatusType c: StatusType.values()) {
            StatusType.enumConstants.put(c.value, c);
        }

    };


      //----------------/
     //- Constructors -/
    //----------------/

    private StatusType(final java.lang.String value) {
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
    public static com.hp.es.xml.batchEntitlement.types.StatusType fromValue(
            final java.lang.String value) {
        StatusType c = StatusType.enumConstants.get(value);
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
