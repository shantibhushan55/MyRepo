/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/db/ResultSetReader.java 1.13 2004-09-27 17:57:03+02 stefsobe Exp $
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
 * $Log: ResultSetReader.java,v $
 * Revision 1.13  2004-09-27 17:57:03+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.12  2004-05-08 04:42:51+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.11  2004-05-05 15:41:41+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.10  2004-01-29 18:07:39+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.9  2003-08-04 16:51:58+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.8  2003-07-15 17:54:48+02  lbednari
 * Author: lbednari@dhcp-15-197-229-125.bbn.hp.com ()
 * - added MetricsHandler to run()
 *
 * Revision 1.7  2003-05-27 10:17:16+02  juhank
 * Author: juhank@dhcp-15-197-230-117.bbn.hp.com ()
 * merged changes from 5_0C2 branch
 *
 * Revision 1.6  2003-05-12 02:00:11+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.5  2003-05-05 11:22:26+02  lbednari
 * Author: lbednari@bbnnaid103.bbn.hp.com ()
 * - removed closing of result set, is now done outside
 *
 * Revision 1.4  2003-04-25 12:16:19+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * avoid null pointer exception; add JavaDoc
 *
 * Revision 1.3  2003-04-23 16:10:09+02  lbednari
 * Author: lbednari@bbnnaid950.bbn.hp.com ()
 * - made sure that ResultSet is closed even if an error occurs in reading
 *
 * Revision 1.2  2003-04-22 22:33:50+02  lbednari
 * Author: lbednari@bbnnaid16.bbn.hp.com ()
 * - closing cursor at the end of run()
 *
 * Revision 1.1  2003-04-15 14:01:04+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.exolab.castor.types.Date;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.contractEntitlement.EsReplyContext;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;

/**
 * Base class for all classes that read from a result set and store the results
 * in the context.
 */
abstract class ResultSetReader {

    private EsReplyContext context;
    private ResultSet resultSet;

    /**
     * Read one row from the result set and store the result in the context
     */
    protected abstract void parseNextRow(EsReplyContext ctx, ResultSet rs) throws SQLException;

    protected ResultSetReader(EsReplyContext ctx, ResultSet rs) {
        this.context = ctx;
        this.resultSet = rs;
    }

    /**
     * Read all rows from the result set and call the parseNextRow() for each
     * row.
     */
    final public void run(MetricsHandler mh) throws SQLException {
    	MetricsEntry me = null;
    	if (mh != null)
        	me = mh.startEntry("");
        int count = 0;
        try {
            if (resultSet!=null) {
                while (resultSet.next()) {
                    parseNextRow(context, resultSet);
                    count++;
                }
            }
        } finally {
        	if(me != null) {
        		me.setActionName(this.getClass().getName() + "_read_rs (" + count + ")");
            	me.actionDone();
        	}
        }

    }

    /**
     * Helper method used to convert the data types
     */
    protected String formatTimestamp(java.sql.Timestamp time) {
        if (time==null) {
            return null;
        }

        java.util.Date date = new java.util.Date(time.getTime());

        java.text.SimpleDateFormat df = getTimestampFormatter();
        return df.format(date);
    }

    /**
     * Helper method to get a unique configured date formatter
     *
     * @return java.text.SimpleDateFormat
     */
    protected static java.text.SimpleDateFormat getTimestampFormatter(){
        return new java.text.SimpleDateFormat(EsConstants.DB_SIMPLE_DATE_FORMAT);
    }

    /**
     * Helper method used to convert the data types
     */
    protected org.exolab.castor.types.Date convertDate(java.sql.Timestamp time) {
        if (time==null) {
            return null;
        }

        return new Date(new java.util.Date(time.getTime()));
    }

    /**
     * Helper method used to convert the data types
     */
    protected org.exolab.castor.types.Date convertDate(java.sql.Date time) {
        if (time==null) {
            return null;
        }

        return new Date(new java.util.Date(time.getTime()));
    }

    /**
     * Helper method used to convert the Strings "Y" and "N" to true and false
     * @return Boolean.TRUE if the flag is "Y" or "y";
     *         Boolean.FALSE if the flag is "N" or "n";
     *         else return null
     */
    protected Boolean convertBoolean(String flag) {
        if (flag!=null) {
            if (flag.equalsIgnoreCase("Y")) {
                return Boolean.TRUE;
            }

            if (flag.equalsIgnoreCase("N")) {
                return Boolean.FALSE;
            }
        }
        return null;
    }
}
