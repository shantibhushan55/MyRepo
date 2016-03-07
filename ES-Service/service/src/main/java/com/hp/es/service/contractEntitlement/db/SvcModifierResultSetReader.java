/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/SvcModifierResultSetReader.java 1.10 2004-09-27 17:57:05+02 stefsobe Exp $
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
 * $Log: SvcModifierResultSetReader.java,v $
 * Revision 1.10  2004-09-27 17:57:05+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.9  2004-05-08 04:42:52+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:41:42+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-02-16 15:40:44+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.6  2004-01-29 18:07:40+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.5  2003-08-04 16:52:00+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-05-12 02:00:12+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.3  2003-04-28 12:40:57+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * remove redModCode
 *
 * Revision 1.2  2003-04-16 16:52:00+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * change column names
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
import com.hp.es.service.contractEntitlement.keys.ModifierKey;
import com.hp.es.xml.service.ModifierComplexType;

/**
 * This class reads the result set for modifiers.
 */
class SvcModifierResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public SvcModifierResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourceObligationId = rs.getString("SMOD_SOURCE_OBLIGATION_ID");
        String item               = rs.getString("SMOD_SVC_ITEM");
        String name               = rs.getString("SMOD_NAME");

        ModifierKey key = new ModifierKey(sourceObligationId, item, name);

        ModifierComplexType m = new ModifierComplexType();
        m.setModDesc(rs.getString("SMOD_DESC"));
        m.setModName(name);
        m.setModValue(rs.getString("SMOD_VALUE"));
        m.setRedModValue2(rs.getString("SMOD_RED_VALUE2"));

        ctx.addModifier(key, m);
    }
}

/*
SMOD_SOURCE_OBLIGATION_ID
SMOD_SVC_ITEM
SMOD_NAME
SMOD_RED_MOD_CODE
SMOD_VALUE
SMOD_VALUE_DESC
SMOD_RED_VALUE2
SMOD_GENERATED
*/
