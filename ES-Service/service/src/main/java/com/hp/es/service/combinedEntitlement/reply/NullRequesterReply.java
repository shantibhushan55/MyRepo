/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/combinedEntitlement/reply/NullRequesterReply.java 1.7 2004-09-27 17:56:56+02 stefsobe Exp $
 *
 * Copyright (c) 2003 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * $Log: NullRequesterReply.java,v $
 * Revision 1.7  2004-09-27 17:56:56+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.6  2004-05-08 04:41:52+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.5  2004-05-05 15:40:38+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.4  2004-01-29 18:06:21+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-12-05 13:02:05+01  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * added hasProductId()
 *
 * Revision 1.2  2003-08-04 16:50:45+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.1  2003-06-04 15:12:40+02  JUHANK
 * Author: JUHANK@dhcp-15-197-232-6.bbn.hp.com ()
 * Initial revision
 *
 *
 */
package com.hp.es.service.combinedEntitlement.reply;

import com.hp.es.xml.service.EsReply;

public class NullRequesterReply extends RequesterReply {

    public NullRequesterReply() {
        super((EsReply)null); // super class does not have no-arg constructor
    }

    public boolean isNormalReply() { return false; }
    public boolean isListReply()   { return false; }
    public boolean isErrorReply()  { return false; }
    public boolean hasProductId()  { return false; }

    public boolean isNull()        { return true; }

}