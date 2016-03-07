/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/keys/ModifierKey.java 1.9 2004-05-08 04:42:58+02 entitlem Exp $
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
 * $Log: ModifierKey.java,v $
 * Revision 1.9  2004-05-08 04:42:58+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:41:48+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-01-29 18:07:46+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.6  2003-08-04 16:52:05+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.5  2003-05-27 03:57:55+02  lbednari
 * Author: lbednari@bbnnaid189.bbn.hp.com ()
 * - merged bugfix from dev5_0C2 branch
 *
 * Revision 1.4  2003-05-12 02:00:18+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.3  2003-05-07 16:48:55+02  GERE
 * Author: GERE@dhcp-15-197-235-53.bbn.hp.com ()
 * lazy construction of the selfString
 *
 * Revision 1.2  2003-04-28 12:42:52+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * remove redModCode
 *
 * Revision 1.1  2003-04-15 14:00:31+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.keys;


public class ModifierKey extends ServiceKey {
    private String modName;

    /**
     * Create an key and initialize it with the source data
     * @param key
     * @roseuid 3E830A0E036E
     */
    public ModifierKey(ModifierKey key) {
        this(key.getSourceObligationID(), key.getItem(), key.getModName());
    }

    /**
     * Create an empty key
     * @roseuid 3E82EC510259
     */
    public ModifierKey(String newSourceObligationID, String newItem,
                       String newModName) {

        super(newSourceObligationID, newItem);
        modName = newModName;
        calculateHashCode(newModName);
    }

    /**
     * @return String
     * @roseuid 3E830A0F0008
     */
    public String toString() {
      if (selfAsString == null){
        StringBuffer buf = new StringBuffer();
        buf.append(getSourceObligationID());
        buf.append(KEY_DELIMITTER);
        buf.append(getItem());
        buf.append(KEY_DELIMITTER);
        buf.append(modName);
        selfAsString = buf.toString();
      }
      return selfAsString;
    }

    /**
     * @return java.lang.String
     * @roseuid 3E830A0F003A
     */
    public String getModName() {
        return modName;
    }

    /**
     * @param o
     * @return String
     */
    public boolean equals(Object o) {
        if (o==null) {
            return false;
        }

        try {
            ModifierKey other = (ModifierKey)o;
            return (equalStrings(this.getItem(), other.getItem()) &&
                    equalStrings(this.getSourceObligationID(), other.getSourceObligationID()) &&
                    equalStrings(this.getModName(), other.getModName())
                    );
        }
        catch (Exception e) {
        }

        return false;
    }

    /**
     * Create the Key that identifies the parent object
     */
    protected Key createParent() {
        return new ServiceKey(this);
    }
}
