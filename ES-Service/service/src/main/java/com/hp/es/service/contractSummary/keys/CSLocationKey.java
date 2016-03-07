/**
 * 
 */
package com.hp.es.service.contractSummary.keys;


/**
 * @author yesilyur
 *
 */
public class CSLocationKey  extends CSKey {

    private String sourceCustomerID;
	
    /**
     * Create an key and initialize it with the source data
     * @param key
     */
    public CSLocationKey(CSLocationKey key) {
        this(key.getSourceCustomerID());
    }
    
    /**
     *
     */
    public CSLocationKey(String newSourceCustomerID) {
        sourceCustomerID = newSourceCustomerID;
        calculateHashCode(newSourceCustomerID);
    }
    
    /**
     * @return String
     */
    public String toString() {
        return sourceCustomerID;     
    }
    
    /**
     * @return java.lang.String
     */
    public String getSourceCustomerID() {
        return sourceCustomerID;     
    }

    /**
     * Create the Key that identifies the parent object
     */
    protected CSKey createParent() {
        return null;
    }
}
