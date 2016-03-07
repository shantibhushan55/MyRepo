package com.hp.es.service.combinedEntitlement.bySn;

/**
 * Provides static methods for dealing with base product numbers. A product number
 * tracked in SAP can have an option included at the end - separated by a '#' or
 * a '_' character. For some comparisons it is important to ignore the option.
 */
public class BaseProductHelper {

    /**
     * Removes any options included the end of the passed product number.
     * @param productNumber possibly including options at the end.
     * @return base product number without any options.
     */
    public static String extractBase(String productNumber) {

        if (productNumber == null) return null;

        int iHash       = productNumber.indexOf('#');
        int iUnderscore = productNumber.indexOf('_');

        // no separator found
        if ( iHash == -1 && iUnderscore == -1 ) {
            return productNumber;
        }
        // underscore found
        else if ( iHash == -1 ) {
            return productNumber.substring(0,iUnderscore);
        }
        // hash found
        else if ( iUnderscore == -1 ) {
            return productNumber.substring(0,iHash);
        }
        // both found, take first
        else {
            return productNumber.substring(0, Math.min(iHash, iUnderscore));
        }

    }

    /**
     * Compares the base products of the 2 passed products.
     * @param product1
     * @param product2
     * @return true if the base products match.
     */
    public static boolean sameBaseProduct(String product1, String product2) {

        if ( (product1 == null) || (product2 == null))
            throw new IllegalArgumentException("Both product numbers have to be non-null");

        String base1 = extractBase(product1);
        String base2 = extractBase(product2);
        return base1.equals(base2);
    }


    /**
     * Assuming that both passed in product numbers share the same base product number
     * this method checks if either one is more specific than the other where
     * 'more specific' means containing an option while the other one does not.
     * @param product1
     * @param product2
     * @return 0 if none or both contain an option, -1 if only teh first contains an option
     *           and 1 if only the second one contains an option
     * @exception IllegalArgumentException is thrown if the passed product numbers dont share
     *            the same base product.
     */
    public static int compareProducts(String product1, String product2) {

        if ( (product1 == null) || (product2 == null))
            throw new IllegalArgumentException("Both product numbers have to be non-null");

        String base1 = extractBase(product1);
        String base2 = extractBase(product2);

        if ( ! base1.equals(base2) ) throw new IllegalArgumentException("Both product numbers have to share the same base product");

        boolean firstHasOption = product1.length() > base1.length();
        boolean secondHasOption = product2.length() > base2.length();

        if ( firstHasOption ^ secondHasOption ) {
            // XOR above makes sure only one was true, let's see which
            if (firstHasOption)
                return -1;
            else
                return 1;
        } 

            // either both or none have an option
            return 0;

    }

}