/**
 * 
 */
package com.hp.es.service.contractSummary.keys;

/**
 * @author yesilyur
 *
 */
public abstract class CSKey {


	   protected int hashCode;
	    protected String selfAsString = null;
	    /*
	     * Is used for caching the parent. Otherwise we would create a new object
	     * with every call to getParent()
	     */
	    private CSKey parent;

	    /*
	     * delimitter for toString() method
	     */
	    protected static final String KEY_DELIMITTER = "|";

	/**
	 * 
	 */
	public CSKey() {
        hashCode = 0;
        parent = null;
	}

    /**
     * Default implementation. For performance reasons, this method should
     * be overwritten by the subclasses.
     * @param o
     * @return String
     */
    public boolean equals(Object o) {
        if (o==null) {
            return false;
        }

        try {
            if (this.getClass().equals(o.getClass())) {
                return equalStrings(this.toString(), o.toString());
            }
        }
        catch (Exception e) {
        }

        return false;
    }

    /**
     * Helper method that checks if two strings are equal (including checks for
     * null-values).
     */
    protected boolean equalStrings(String s1, String s2) {
        if (s1==null) {
            return s2==null;
        }

        if (s2==null) {
            return false;
        }

        return s1.equals(s2);
    }

    /**
     * This method should be called for each key-attribute in order to calculate
     * a unique hashCode. Another alternative would have been to use
     * <code>hashCode = this.toString().hashCode();</code> but this would create
     * a string buffer containing all attributes of the key for every key object.
     * This method avoids the string buffers.
     */
    final protected void calculateHashCode(String s) {
        long newHashCode = hashCode;
        if (s!=null) {
            newHashCode += s.hashCode();
        }
        hashCode = (int)newHashCode;
    }

    /**
     * Overwrites the hashCode() method from Object
     */
    final public int hashCode() {
        if (hashCode==0) {
            hashCode = this.toString().hashCode();
        }
        return hashCode;
    }

    /**
     * This method needs to be implemented by the subclass. It is called by
     * the getParent() method and should return a new Key object that represents
     * the parent key.
     */
    abstract protected CSKey createParent();

    /**
     * @return the parent key for the current key
     */
    public CSKey getParent() {
        if (parent==null) {
            parent = createParent();
        }
        return parent;
    }
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Object arg) {
        String selfString=toString();
        if (selfString != null){
            // need to reverse ordering as CASTOR reverses it again, so it should be fine at the end :)
            return -(selfString.compareTo(arg.toString()));
        }else {
            return 0;
        }
    }	
}
