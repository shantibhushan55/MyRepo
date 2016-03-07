/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/keys/ContactKey.java 1.6 2004-05-08 04:42:55+02 entitlem Exp $
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
 * $Log: ContactKey.java,v $
 * Revision 1.6  2004-05-08 04:42:55+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.5  2004-05-05 15:41:44+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.4  2004-01-29 18:07:43+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-08-04 16:52:02+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.2  2003-05-12 02:00:14+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.1  2003-04-15 14:00:30+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.keys;


public class ContactKey extends Key {
    private String sourcePersonID;

    /**
     * Create an key and initialize it with the source data
     * @param key
     * @roseuid 3E830A0C023F
     */
    public ContactKey(ContactKey key) {
        this(key.getSourcePersonID());
    }
    
    /**
     * @roseuid 3E82EC500398
     */
    public ContactKey(String newSourcePersonID) {
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
    protected Key createParent() {
        return null;
    }
}
