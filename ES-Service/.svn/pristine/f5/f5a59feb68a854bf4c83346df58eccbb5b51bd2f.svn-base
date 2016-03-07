/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/DlvModifierResultSetReader.java 1.10 2004-09-27 17:57:00+02 stefsobe Exp $
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
 * $Log: DlvModifierResultSetReader.java,v $
 * Revision 1.10  2004-09-27 17:57:00+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.9  2004-05-08 04:42:47+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:41:37+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-02-16 15:40:41+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.6  2004-01-29 18:07:35+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.5  2003-08-04 16:51:54+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-05-27 10:17:15+02  juhank
 * Author: juhank@dhcp-15-197-230-117.bbn.hp.com ()
 * merged changes from 5_0C2 branch
 *
 * Revision 1.3  2003-05-12 02:00:07+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-04-16 16:51:59+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * change column names
 *
 * Revision 1.1  2003-04-15 14:01:03+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.keys.DelivModifierKey;
import com.hp.es.xml.service.ModifierComplexType;

/**
 * This class reads the result set for modifiers.
 */
class DlvModifierResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public DlvModifierResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourceObligationId = rs.getString("DMOD_SOURCE_OBLIGATION_ID");
        String item               = rs.getString("DMOD_SVC_ITEM");
        String name               = rs.getString("DMOD_DLV_NAME");
        String redDlvCode         = rs.getString("DMOD_DLV_CODE");
        String modName            = rs.getString("DMOD_NAME");
        String redModCode         = "";

        DelivModifierKey key = new DelivModifierKey(sourceObligationId, item,
                                                    name, redDlvCode,
                                                    modName, redModCode );

        ModifierComplexType m = new ModifierComplexType();
        m.setModDesc(rs.getString("DMOD_DESC"));
        m.setModName(modName);
        m.setModValue(rs.getString("DMOD_VALUE"));
        m.setRedModValue2(rs.getString("DMOD_RED_VALUE2"));

        ctx.addDelivModifier(key, m);
    }
}

/*
DMOD_SOURCE_OBLIGATION_ID
DMOD_SVC_ITEM
DMOD_DLV_NAME
DMOD_RED_DLV_CODE
DMOD_MOD_NAME
DMOD_RED_MOD_CODE
DMOD_VALUE
DMOD_VALUE_DESC
DMOD_RED_VALUE2
*/
