/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/ContactCommunicationResultSetReader.java 1.7 2004-05-08 04:42:44+02 entitlem Exp $
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
 * $Log: ContactCommunicationResultSetReader.java,v $
 * Revision 1.7  2004-05-08 04:42:44+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.6  2004-05-05 15:41:33+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.5  2004-01-29 18:07:31+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.4  2003-08-04 16:51:51+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.3  2003-07-17 17:53:57+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * reformatting
 *
 * Revision 1.2  2003-05-12 02:00:03+02  entitlem
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
 * This class reads the result set for all contact-communications<br>
 * <b>Note:</b> This class requires that the Contacts are available in the context,
 * i.e. the ContactResultSetReader must be called before!<p>
 * Theoretically, we could have multiple email adresses, phone numbers, fax
 * numbers per contact. In the XML file we have just one field for each element.
 * Therefore, in cases were we have multiple entries for the these fields, we
 * fill the elements "randomly".
 */
class ContactCommunicationResultSetReader extends ResultSetReader {

    /**
     * @param ctx The context were the created objects are stored.
     * @param rs The ResultsSet that is read
     */
    public ContactCommunicationResultSetReader(EsReplyContext ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * Parse one row of the results set and insert the customer IDs into the
     * contracts.
     */
    protected void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException {

        String sourcePersonId = rs.getString("CNTC_SOURCE_PERSON_ID");

        ContactKey key = new ContactKey(sourcePersonId);

        ContactComplexType c = ctx.getContact(key);
        if (c!=null) {
            String protocolType = rs.getString("CNTC_PROTOCOL_TYPE");
            if ("Email".equalsIgnoreCase(protocolType)) {
                String email = rs.getString("CNTC_EMAIL_ADDRESS");
                if (email!=null) {
                    // check if null in order to avoid that a previous value
                    // is overwritten in case we have multiple email adresses
                    //  in the database
                    c.setEmailAddress(rs.getString("CNTC_EMAIL_ADDRESS"));
                }
            }
            else {
                String no = convertPhoneNumber(
                                rs.getString("CNTC_PHONE_COUNTRY_CODE"),
                                rs.getString("CNTC_PHONE_CITY_CODE"),
                                rs.getString("CNTC_PHONE_NUMBER"),
                                rs.getString("CNTC_PHONE_EXTENSION"));
                if (no!=null) {
                    // check if null in order to avoid that a previous value
                    // is overwritten in case we have multiple phone or fax
                    // numbers in the database
                    if ("Phone".equalsIgnoreCase(protocolType)) {
                        c.setPhoneNumber(no);
                    }
                    else if ("Fax".equalsIgnoreCase(protocolType)) {
                        c.setFaxNumber(no);
                    }
                }
            }
        }
    }

    /**
     * Combine the phone numebr elements to one string
     */
    private String convertPhoneNumber(String countryCode, String cityCode,
                                      String number, String extention) {
        StringBuffer buf = new StringBuffer();
        if (countryCode!=null) {
            buf.append(countryCode);
        }
        if (cityCode!=null) {
            buf.append(cityCode);
        }
        if (number!=null) {
            buf.append(number);
        }
        if (extention!=null) {
            buf.append(extention);
        }
        return buf.toString();
    }
}

/*
CNTC_SOURCE_PERSON_ID
CNTC_SEQ_NUMBER
CNTC_PROTOCOL_TYPE
CNTC_ROLE
CNTC_PHONE_COUNTRY_CODE
CNTC_PHONE_CITY_CODE
CNTC_PHONE_NUMBER
CNTC_PHONE_EXTENSION
CNTC_EMAIL_ADDRESS
*/

