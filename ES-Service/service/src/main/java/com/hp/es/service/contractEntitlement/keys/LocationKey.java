/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/keys/LocationKey.java 1.6 2004-05-08 04:42:58+02 entitlem Exp $
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
 * $Log: LocationKey.java,v $
 * Revision 1.6  2004-05-08 04:42:58+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.5  2004-05-05 15:41:47+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.4  2004-01-29 18:07:45+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-08-04 16:52:05+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.2  2003-05-12 02:00:17+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.1  2003-04-15 14:00:31+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.keys;


public class LocationKey extends Key {
    private String sourceCustomerID;
    
    /**
     * Create an key and initialize it with the source data
     * @param key
     * @roseuid 3E830A0B039C
     */
    public LocationKey(LocationKey key) {
        this(key.getSourceCustomerID());
    }
    
    /**
     * @roseuid 3E82EB11026D
     */
    public LocationKey(String newSourceCustomerID) {
        sourceCustomerID = newSourceCustomerID;
        calculateHashCode(newSourceCustomerID);
    }
    
    /**
     * @return String
     * @roseuid 3E830A0C002C
     */
    public String toString() {
        return sourceCustomerID;     
    }
    
    /**
     * @return java.lang.String
     * @roseuid 3E830A0C00E0
     */
    public String getSourceCustomerID() {
        return sourceCustomerID;     
    }

    /**
     * Create the Key that identifies the parent object
     */
    protected Key createParent() {
        return null;
    }
}
