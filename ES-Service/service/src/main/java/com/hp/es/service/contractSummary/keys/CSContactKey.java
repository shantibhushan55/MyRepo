/**
 * 
 */
package com.hp.es.service.contractSummary.keys;


/**
 * @author yesilyur
 *
 */
public class CSContactKey extends CSKey{
	   private String sourcePersonID;

	    /**
	     * Create an key and initialize it with the source data
	     * @param key
	     * @roseuid 3E830A0C023F
	     */
	    public CSContactKey(CSContactKey key) {
	        this(key.getSourcePersonID());
	    }
	    
	    /**
	     * @roseuid 3E82EC500398
	     */
	    public CSContactKey(String newSourcePersonID) {
	        sourcePersonID = newSourcePersonID;
	        calculateHashCode(newSourcePersonID);
	    }

	    /**
	     * @return String
	     * @roseuid 3E830A0C02B7
	     */
	    public String toString() {
	        return sourcePersonID;
	    }
	    
	    /**
	     * @return java.lang.String
	     * @roseuid 3E830A0C02F3
	     */
	    public String getSourcePersonID() {
	        return sourcePersonID;
	    }

	    /**
	     * Create the Key that identifies the parent object
	     */
	    protected CSKey createParent() {
	        return null;
	    }

}
