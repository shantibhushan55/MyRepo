/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.hp.es.xml.batchEntitlement.types;

/**
 * Enumeration BundledWarrantyPortfolioFlagType.
 * 
 * @version $Revision$ $Date$
 */
public enum BundledWarrantyPortfolioFlagType {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant S
     */
    S("S"),
    /**
     * Constant C
     */
    C("C"),
    /**
     * Constant G
     */
    G("G");

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
    private static final java.util.Map<java.lang.String, BundledWarrantyPortfolioFlagType> enumConstants = new java.util.HashMap<java.lang.String, BundledWarrantyPortfolioFlagType>();


    static {
        for (BundledWarrantyPortfolioFlagType c: BundledWarrantyPortfolioFlagType.values()) {
            BundledWarrantyPortfolioFlagType.enumConstants.put(c.value, c);
        }

    };


      //----------------/
     //- Constructors -/
    //----------------/

    private BundledWarrantyPortfolioFlagType(final java.lang.String value) {
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
    public static com.hp.es.xml.batchEntitlement.types.BundledWarrantyPortfolioFlagType fromValue(
            final java.lang.String value) {
        BundledWarrantyPortfolioFlagType c = BundledWarrantyPortfolioFlagType.enumConstants.get(value);
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
