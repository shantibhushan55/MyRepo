/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/SerialNumberResultSetReader.java 1.9 2004-09-27 17:57:03+02 stefsobe Exp $
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
 * $Log: SerialNumberResultSetReader.java,v $
 * Revision 1.9  2004-09-27 17:57:03+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.8  2004-05-08 04:42:51+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.7  2004-05-05 15:41:41+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.6  2004-02-16 15:40:44+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.5  2004-01-29 18:07:39+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.4  2003-08-04 16:51:59+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.3  2003-05-12 02:00:11+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-05-05 11:23:13+02  lbednari
 * Author: lbednari@bbnnaid103.bbn.hp.com ()
 * - results coming from different table -> column name prefix changed
 *
 * Revision 1.1  2003-04-15 14:01:05+02  stefsobe
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
 * This class reads the result set for serial numbers of the OOSes.<br>
 * <b>Note:</b> This class requires that the OOSes are available in the context,
 * i.e. the OOSResultSetReader must be called before!
 */
class SerialNumberResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public SerialNumberResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set. Find the corresponding OOS in the
     * context and add the serial number to that OOS.
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String oosKey = rs.getString("SNC_OOS_KEY");

        OOSKey key = new OOSKey(oosKey);

        OOSComplexType o = ctx.getOOS(key);
        if (o!=null) {
            String serialNo = rs.getString("SNC_SERIAL_NUMBER");
            if (serialNo!=null) {
                o.addSerialNumber(serialNo);
            }
        }
    }
}

/*
OOSU_OOS_KEY
OOSU_SERIAL_NUMBER
*/

