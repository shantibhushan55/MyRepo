/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/keys/Key.java 1.8 2004-05-08 04:42:56+02 entitlem Exp $
 *
 * Copyright (c) 2002 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * $Log: Key.java,v $
 * Revision 1.8  2004-05-08 04:42:56+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.7  2004-05-05 15:41:45+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.6  2004-01-29 18:07:44+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.5  2003-08-04 16:52:03+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-05-12 02:00:15+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.3  2003-05-07 18:37:15+02  lbednari
 * Author: lbednari@dhcp-15-197-235-62.bbn.hp.com ()
 * - reversed ordering
 *
 * Revision 1.2  2003-05-07 16:50:13+02  GERE
 * Author: GERE@dhcp-15-197-235-53.bbn.hp.com ()
 * implementation of the Comparable Interface
 *
 * Revision 1.1  2003-04-15 14:00:31+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.keys;


public abstract class Key implements Comparable {

    protected int hashCode;
    protected String selfAsString = null;
    /*
     * Is used for caching the parent. Otherwise we would create a new object
     * with every call to getParent()
     */
    private Key parent;

    /*
     * delimitter for toString() method
     */
    protected static final String KEY_DELIMITTER = "|";

    /**
     * Create an empty key
     * @roseuid 3E830A0A026E
     */
    public Key() {
        hashCode = 0;
        parent = null;
    }

    /**
     * Default implementation. For performance reasons, this method should
     * be overwritten by the subclasses.
     * @param o
     * @return String
     * @roseuid 3E82EB7A03D6
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
    abstract protected Key createParent();

    /**
     * @return the parent key for the current key
     */
    public Key getParent() {
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
