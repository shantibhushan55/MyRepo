/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/OOSLocationResultSetReader.java 1.8 2004-09-27 17:57:02+02 stefsobe Exp $
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
 * $Log: OOSLocationResultSetReader.java,v $
 * Revision 1.8  2004-09-27 17:57:02+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.7  2004-05-08 04:42:50+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.6  2004-05-05 15:41:39+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.5  2004-02-16 15:40:43+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.4  2004-01-29 18:07:37+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-08-04 16:51:56+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.2  2003-05-12 02:00:09+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.1  2003-04-15 14:01:04+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.keys.OOSKey;
import com.hp.es.xml.service.OOSComplexType;

/**
 * This class reads the result set for all OOS-address relations.<br>
 * <b>Note:</b> This class requires that the OOSes are available in the context,
 * i.e. the OOSResultSetReader must be called before! The addresses
 * are not needed before because we just insert the customer IDs.
 */
class OOSLocationResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public OOSLocationResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and insert the customer IDs into the
     * contracts.
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String oosKey = rs.getString("OAR_OOS_KEY");

        OOSKey key = new OOSKey(oosKey);

        OOSComplexType c = ctx.getOOS(key);
        if (c!=null) {
            String sourceCustomerId = rs.getString("OAR_SOURCE_CUSTOMER_ID");
            String role             = rs.getString("OAR_ROLE");
            if ("SWShipTo".equalsIgnoreCase(role)) {
                c.setSWShipToCustomerID(sourceCustomerId);
            }
            else if ("ProductShipTo".equalsIgnoreCase(role)) {
                c.setProductShipToCustomerID(sourceCustomerId);
            }
        }
    }
}

/*
OAR_OOS_KEY
OAR_SOURCE_CUSTOMER_ID
OAR_ROLE
*/

