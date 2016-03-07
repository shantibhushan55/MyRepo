/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/util/XMLIdGenerator.java 1.6 2004-05-08 04:42:17+02 entitlem Exp $
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
 * $Log: XMLIdGenerator.java,v $
 * Revision 1.6  2004-05-08 04:42:17+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.5  2004-05-05 15:41:05+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.4  2004-01-29 18:06:49+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-08-04 16:51:12+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.2  2003-05-12 01:59:31+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.1  2003-04-08 16:40:15+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.util;

/**
 * This class can be used to generate IDs, e.g. for the XML schema. Each
 * XMLIdGenerator returns unique IDs, i.e. when each operation uses another
 * XMLIdGenerator, the replies of different operations can easily be merged
 * together without updating the IDs. <b>Note: </b> When the application is
 * restarted, the same IDs will be generated again, i.e. the IDs are only unique
 * per session.
 *  
 */
public class XMLIdGenerator extends IdGenerator {

    /**
     * Generate a new ID of the format ID_prefix-count, e.g. "ID_10_1". The
     * prefix remains the same for each XMLIdGenerator and the count will be
     * incremented with each call to the nextId() method.
     * 
     * @return an ID
     */
    public synchronized String nextId() {
        idCount++;
        return prefix + idCount;
    }

    /**
     * Create a new XMLIdGenerator with a new ID prefix (see {@link nextId()}
     * 
     * @return an XMLIdGenerator
     */
    static synchronized public XMLIdGenerator getXMLIdGenerator() {
        return getXMLIdGenerator((char) 0);
    }

    //see wits
    /**
     * Create a new XMLIdGenerator with a prefix character specified (see
     * {@link nextId()})
     * 
     * @param prefixChar
     * @return an XMLIdGenerator
     */
    static synchronized public XMLIdGenerator getXMLIdGenerator(char prefixChar) {
        instanceCount++;
        String _prefix = null;
        if (prefixChar > 0) {
            _prefix = "ID_" + prefixChar + "_" + instanceCount;
        } else {
            _prefix = "ID_" + instanceCount;
        }
        return new XMLIdGenerator(_prefix);
    }

    /**
     * Private constructor
     */
    private XMLIdGenerator(String prefix) {
        this.prefix = prefix + '_';
        idCount = 0;
    }

    /*
     * Enumerates the instances of the XMLIdGenerator. In order to get unique IDs
     * even after a restart of the application, the prefix could be change to
     * System.currentTimeMillis(). Since we don't have the need today and in
     * order to keep the IDs small and readable, I used the "increment"
     * approach.
     */
    static private long instanceCount = 0;

    /*
     * Current prefix of the IDs
     */
    private String prefix;

    /*
     * Postfix of the last ID
     */
    private long idCount;
}
