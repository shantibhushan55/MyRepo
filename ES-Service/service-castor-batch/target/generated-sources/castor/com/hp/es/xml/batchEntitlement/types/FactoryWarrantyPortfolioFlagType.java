/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.hp.es.xml.batchEntitlement.types;

/**
 * Enumeration FactoryWarrantyPortfolioFlagType.
 * 
 * @version $Revision$ $Date$
 */
public enum FactoryWarrantyPortfolioFlagType {


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
    private static final java.util.Map<java.lang.String, FactoryWarrantyPortfolioFlagType> enumConstants = new java.util.HashMap<java.lang.String, FactoryWarrantyPortfolioFlagType>();


    static {
        for (FactoryWarrantyPortfolioFlagType c: FactoryWarrantyPortfolioFlagType.values()) {
            FactoryWarrantyPortfolioFlagType.enumConstants.put(c.value, c);
        }

    };


      //----------------/
     //- Constructors -/
    //----------------/

    private FactoryWarrantyPortfolioFlagType(final java.lang.String value) {
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
    public static com.hp.es.xml.batchEntitlement.types.FactoryWarrantyPortfolioFlagType fromValue(
            final java.lang.String value) {
        FactoryWarrantyPortfolioFlagType c = FactoryWarrantyPortfolioFlagType.enumConstants.get(value);
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
