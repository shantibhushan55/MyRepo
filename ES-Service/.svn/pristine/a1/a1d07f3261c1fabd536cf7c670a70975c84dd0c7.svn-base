/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/ContractContactResultSetReader.java 1.8 2004-05-08 04:42:45+02 entitlem Exp $
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
 * $Log: ContractContactResultSetReader.java,v $
 * Revision 1.8  2004-05-08 04:42:45+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.7  2004-05-05 15:41:34+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.6  2004-01-29 18:07:32+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.5  2003-08-04 16:51:52+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.4  2003-07-17 17:54:13+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * reformatting
 *
 * Revision 1.3  2003-05-27 10:17:13+02  juhank
 * Author: juhank@dhcp-15-197-230-117.bbn.hp.com ()
 * merged changes from 5_0C2 branch
 *
 * Revision 1.2  2003-05-12 02:00:05+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.1  2003-04-15 14:01:02+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.es.service.contractEntitlement.keys.ObligationHeaderKey;
import com.hp.es.xml.service.ContractComplexType;

/**
 * This class reads the result set for all contract-person relations.<br>
 * <b>Note:</b> This class requires that the Contracts are available in the context,
 * i.e. the ObligationHeaderResultSetReader must be called before! The contacts
 * are not needed before because we just insert the customer IDs.
 */
class ContractContactResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public ContractContactResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and insert the customer IDs into the
     * contracts.
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourceObligationId = rs.getString("OHCR_SOURCE_OBLIGATION_ID");

        ObligationHeaderKey key = new ObligationHeaderKey(sourceObligationId);

        ContractComplexType c = ctx.getContract(key);
        if (c!=null) {
            String sourcePersonId = rs.getString("OHCR_SOURCE_PERSON_ID");
            String role             = rs.getString("OHCR_ROLE");
            if ("SystemMgr".equalsIgnoreCase(role)) {
                c.setSystemMgrPersonID(sourcePersonId);
            }
            else if ("SWShipTo".equalsIgnoreCase(role)) {
                c.setSWShipToPersonID(sourcePersonId);
            }
            else if ("HWShipTo".equalsIgnoreCase(role)) {
                c.setHWShipToPersonID(sourcePersonId);
            }
            else if ("Admin".equalsIgnoreCase(role)) {
                c.setHPAdminPersonID(sourcePersonId);
            }
            else if ("Orderer".equalsIgnoreCase(role)) {
                c.setOrdererPersonID(sourcePersonId);
            }
        }
    }
}

/*
OHCR_SOURCE_OBLIGATION_ID
OHCR_SOURCE_PERSON_ID
OHCR_ROLE
OHCR_CONTACT_TYPE
*/

