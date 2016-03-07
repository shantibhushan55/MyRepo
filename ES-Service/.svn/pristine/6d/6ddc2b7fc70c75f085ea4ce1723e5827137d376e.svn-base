/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/ContactsResultSetReader.java 1.8 2004-09-27 17:56:59+02 stefsobe Exp $
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
 * $Log: ContactsResultSetReader.java,v $
 * Revision 1.8  2004-09-27 17:56:59+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.7  2004-05-08 04:42:44+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.6  2004-05-05 15:41:34+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.5  2004-02-16 15:40:40+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.4  2004-01-29 18:07:31+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-08-04 16:51:51+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.2  2003-05-12 02:00:04+02  entitlem
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
import com.hp.es.service.contractEntitlement.keys.ContactKey;
import com.hp.es.xml.service.ContactComplexType;


/**
 * This class reads the result set for all addresses.
 * <b>Note:</b> The email address, phone number and fax number will be set by
 * the ContactCommunicationResultSetReader class.
 */
class ContactsResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public ContactsResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and put the result into the context
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourcePersonId = rs.getString("CNT_SOURCE_PERSON_ID");

        ContactKey key = new ContactKey(sourcePersonId);

        ContactComplexType c = new ContactComplexType();
        // c.setEmailAddress();  -> ContactCommunicationResultSetReader
        // c.setFaxNumber();     -> ContactCommunicationResultSetReader
        c.setFullName(rs.getString("CNT_FULL_NAME"));
        // c.setPhoneNumber();   -> ContactCommunicationResultSetReader
        c.setSourcePersonID(sourcePersonId);

        ctx.addContact(key, c);
    }
}

/*
CNT_SOURCE_PERSON_ID
CNT_PREFIX
CNT_FULL_NAME
CNT_PREFERRED_LANGUAGE
*/
