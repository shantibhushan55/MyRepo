/*
 * Title:        HPSE 1.0 - Entitlement Service
 * Description:  EIA Message Comparator
 *
 * Copyright (c) 2001 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * @author Antoine Voiry
 *
 * $Log: EIAComparator.java,v $
 * Revision 1.26  2004-05-08 04:41:15+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.25  2004-05-05 15:39:56+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.24  2004-02-03 16:17:24+01  stefsobe
 * Author: stefsobe@sobesteffen ()
 * remove ACME
 *
 * Revision 1.23  2004-01-29 18:05:33+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.22  2003-09-02 11:10:17+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * simplify methods; use CastorObjectComparator instead of
 * AcmeReplyComparator, EsReplyComparator and EIAErrorComparator
 *
 * Revision 1.21  2003-08-22 11:56:49+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * enable ACME functionality
 *
 * Revision 1.20  2003-08-04 16:50:05+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.19  2003-05-30 17:40:42+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * RENAMING class HpseReplyComparator TO EsReplyComparator
 *
 * Revision 1.18  2003-05-26 15:11:30+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * removing some 3.0 stuff
 *
 * Revision 1.17  2003-05-12 01:58:27+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.16  2003-04-08 16:09:24+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * - removed some more ACME stuff
 *
 * Revision 1.15  2003-03-19 19:31:48+01  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * No support ignore lists, "default.ignore" or "testcase.ignore".
 * These lists carry regular expressions to ignore certain elements in the
 * XML path.
 *
 * Revision 1.14  2003-03-19 15:05:01+01  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * no comment
 *
 * Revision 1.13  2003-02-26 15:32:53+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.12  2003-01-22 15:27:07+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.11  2002-07-04 17:57:36+02  lbednari
 * Author: lbednari@dhcp-15-198-4-186.bbn.hp.com ()
 * - added Acme related code
 *
 * Revision 1.10  2002-07-03 13:51:02+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.9  2002-05-22 08:50:15+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_0
 *
 * Revision 1.8  2002-04-11 17:22:58+02  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Changed for UTF_8
 *
 * Revision 1.7  2002-04-11 11:13:47+02  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Checkout before building for an old symbol
 *
 * Revision 1.6  2002-03-29 09:58:15+01  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Change:

 *  - added javadoc

 *  - reformat file
 *
 * Revision 1.5  2002-03-27 16:16:42+01  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Break dependencies with com.hp.es.util
 *
 * Revision 1.4  2002-03-27 10:03:07+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * Change added for the eia migration.

 * Change the way that we are accessing the server

 * A bug is still remaining

 * A migration to eia adk would be needed
 *
 * Revision 1.3  2002-03-22 10:55:24+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * EIA integrated
 *
 * Revision 1.2  2002-03-14 15:33:49+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * dummy checkout for branch 1_0 creation
 *
 * Revision 1.1  2002-03-12 09:22:49+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * New version of test ware
 * Support EIA
 *
 *
 */
package com.hp.es.test.hpsetest.proxy;



import com.hp.es.test.hpsetest.ServiceTesterUtil;
import com.hp.es.xml.service.EIAMessage;

class EIAComparator {

   /**
    * Compare two EIA messages
    * @param actual
    * @param expected
    * @param ignoreList a list of Jakarta ORO regular expressions to ignore certain tree 
    *        parts, i.e. "/EsReply/EsHeader/TransactionID" or 
    *        "/EsReply/EsHeader/InputRequest.*"  
    * @return
    * @throws Exception
    */
   boolean compare(EIAMessage actual, EIAMessage expected, String[] ignoreList) throws Exception   {

        String messageType = actual.getMessageHeader().getMessageType().toString();
        if(!messageType.equals(expected.getMessageHeader().getMessageType().toString())) {
            ServiceTesterUtil.dump("\n\r Difference : Message type are not the same.\n\r");
            return false;
        }

        String serviceID = actual.getMessageHeader().getServiceDescriptor().getServiceID(); 
        
        Object o1 = null;
        Object o2 = null;
        String root = null;
             
        if (messageType.trim().equalsIgnoreCase("error")) {
            o1 = actual.getMessageBody().getEIAError();
            o2 = expected.getMessageBody().getEIAError();
            root = "EIAError";
        }
        else if (serviceID.equalsIgnoreCase("ES")) {
            o1 = actual.getMessageBody().getEsReply();
            o2 = expected.getMessageBody().getEsReply();
            root = "EsReply";
        }
        else {
            throw new Exception("ServiceID [" + serviceID + "] is not supported");
        }

        CastorObjectComparator comp = new CastorObjectComparator(ignoreList);
        boolean ret = comp.compare(o1, o2, root);
        if (ret==false) {
            ServiceTesterUtil.dump(
                "Possible errors are:"
                    + System.getProperty("line.separator")
                    + comp.getDifferences());
        }
        return ret;
    }

}
