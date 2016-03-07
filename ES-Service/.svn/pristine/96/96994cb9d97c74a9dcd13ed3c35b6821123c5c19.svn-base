/**
 * Project: Entitlement Service
 *
 * 
 * 
 * Copyright (c) 2001 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 */
 
package com.hp.es.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import com.hp.es.xml.service.EIAError;

/**
 * Tools for dealing with warnings. See individual methods for details.
 */
public class WarningsBuilder {
    
    /**
     * Orders a given list of warnings (i.e. EIAError). All elements are expected to
     * be of type Entitlement Service EIAError. Besides, all double entries are 
     * filtered. A double entry is an entry that has the same errorID and errorText
     * like another. The payload is not considered into this comparison. Which entry
     * is filtered for doubles is not specified 
     * @param warnings a non-null list containing entries of type Entitlement Service EIAError 
     * @return a filtered, order list of type EIAError, or null if the parameter was null
     */
    public static List<EIAError> orderAndFilterWarnings(List<?> warnings) {
        if (warnings == null) {
            return null;
        }
        
        TreeSet<WarningsHashEntry> filterAndOrder = new TreeSet<WarningsHashEntry>();
        for (Iterator<?> it = warnings.iterator(); it.hasNext();) {
            Object obj = it.next();
            if (obj instanceof EIAError) {
                EIAError error = (EIAError) obj;
                filterAndOrder.add(new WarningsHashEntry(error));                
            }
        }
        
        ArrayList <EIAError> result = new ArrayList<EIAError>(filterAndOrder.size());
        for (Iterator<WarningsHashEntry> it = filterAndOrder.iterator(); it.hasNext();) {
            result.add(it.next().wrappedError);
        }
        
        return result;
        
    }

    private static class WarningsHashEntry implements Comparable {
        
        EIAError wrappedError;
        String errorId = null;
        String errorText = null;
        
        public WarningsHashEntry(EIAError wrappedError) {
            if (wrappedError == null) {
                throw new NullPointerException();   
            }
            this.wrappedError = wrappedError;
            errorId = wrappedError.getErrorID();
            errorText = wrappedError.getErrorText();
       }
        
        
        
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof WarningsHashEntry) {
                WarningsHashEntry other = (WarningsHashEntry) obj;
                if (this.errorId == null) {
                    if (other.errorId != null) {
                        return false;
                    }
                } else {
                    if (other.errorId == null) {
                        return false;
                    }
                    if (this.errorId.equals(other.errorId) == false) {
                        return false;
                    }
                }
                if (this.errorText == null) {
                    if (other.errorText != null) {
                        return false;
                    }
                } else {
                    if (other.errorText == null) {
                        return false;
                    }
                    if (this.errorText.equals(other.errorText) == false) {
                        return false;
                    }
                }
                return true;
            } 
            return false;
            
        }

        public int compareTo(Object o) {
            WarningsHashEntry other = (WarningsHashEntry) o;
            int result = 0;
            result = nullIsAlwaysLastInCompare(this.errorId, other.errorId);
            if (result == 0) {
                result = nullIsAlwaysLastInCompare(this.errorText, other.errorText);
            }
            return result;
        }
        
        // see comperator logic
        protected int nullIsAlwaysLastInCompare(String s1, String s2) {
            if (s1 == null && s2 != null) {
                return 1;
            }
            if (s1 != null && s2 == null) {
                return -1;
            }
            if (s1 == null && s2 == null) {
                return 0;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(s1, s2);
        }

    }

}
