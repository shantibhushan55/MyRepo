/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/keys/DeliverableKey.java 1.8 2004-05-08 04:42:55+02 entitlem Exp $
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
 * $Log: DeliverableKey.java,v $
 * Revision 1.8  2004-05-08 04:42:55+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.7  2004-05-05 15:41:45+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.6  2004-01-29 18:07:43+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.5  2003-08-04 16:52:03+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-05-27 03:57:52+02  lbednari
 * Author: lbednari@bbnnaid189.bbn.hp.com ()
 * - merged bugfix from dev5_0C2 branch
 *
 * Revision 1.3  2003-05-12 02:00:15+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-05-07 16:48:54+02  GERE
 * Author: GERE@dhcp-15-197-235-53.bbn.hp.com ()
 * lazy construction of the selfString
 *
 * Revision 1.1  2003-04-15 14:00:30+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.keys;


public class DeliverableKey extends ServiceKey {
    private String dlvName;
    private String redDlvCode;

    /**
     * Create an key and initialize it with the source data
     * @param key
     * @roseuid 3E830A0F032A
     */
    public DeliverableKey(DeliverableKey key) {
        this(key.getSourceObligationID(), key.getItem(),
             key.getDlvName(), key.getRedDlvCode());
    }

    /**
     * Create an empty key
     * @roseuid 3E82EC5102F9
     */
    public DeliverableKey(String newSourceObligationID, String newItem,
                          String newDlvName, String newRedDlvCode) {
        super(newSourceObligationID, newItem);
        dlvName = newDlvName;
        redDlvCode = newRedDlvCode;
        calculateHashCode(newDlvName);
        calculateHashCode(newRedDlvCode);
   }

    /**
     * @return String
     * @roseuid 3E830A0F03B6
     */
    public String toString() {
        if (selfAsString == null){
          StringBuffer buf = new StringBuffer();
          buf.append(getSourceObligationID());
          buf.append(KEY_DELIMITTER);
          buf.append(getItem());
          buf.append(KEY_DELIMITTER);
          buf.append(getDlvName());
          buf.append(KEY_DELIMITTER);
          buf.append(getRedDlvCode());
          selfAsString = buf.toString();
        }
        return selfAsString;
    }

    /**
     * @return java.lang.String
     * @roseuid 3E830A10000A
     */
    public String getDlvName() {
        return dlvName;
    }

    /**
     * @return java.lang.String
     * @roseuid 3E830A10014A
     */
    public String getRedDlvCode() {
        return redDlvCode;
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
            DeliverableKey other = (DeliverableKey)o;
            return (equalStrings(this.getItem(), other.getItem()) &&
                    equalStrings(this.getSourceObligationID(), other.getSourceObligationID()) &&
                    equalStrings(this.getDlvName(), other.getDlvName()) &&
                    equalStrings(this.getRedDlvCode(), other.getRedDlvCode())
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
