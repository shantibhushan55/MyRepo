/*
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/util/RucLogWrapper.java 1.8 2004-09-27 17:57:44+02 stefsobe Exp $
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
 * $Log: RucLogWrapper.java,v $
 * Revision 1.8  2004-09-27 17:57:44+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.7  2004-05-08 04:42:18+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.6  2004-05-05 15:41:06+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.5  2004-02-17 15:43:40+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * Replaced the usage of EIAutil with ESLog in logging statements
 *
 * Revision 1.4  2004-01-29 18:06:50+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-08-04 16:51:13+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.2  2003-05-12 01:59:32+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.1  2003-04-23 10:05:41+02  lbednari
 * Author: lbednari@bbnnaid102.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.util;


import java.util.Properties;

import com.hp.ruc.log.BaseLog;
import com.hp.ruc.log.Log;

/**
 * Log implementation uses Log4j as an underlying logging system.
 * @see com.hp.ruc.log.BaseLog
 */
public class RucLogWrapper extends BaseLog {

    public RucLogWrapper() {
        super();
    }

    /**
     * Write .
     * @param logLevel
     * @param caller (use 'this' in the call)
     * @param data (
     * @param t
     */
    public void write(int logLevel, Object caller, Object data, Throwable t) {

        String text = (caller!=null) ? caller.getClass().getName() + ": " : "";
        if (data!=null) {
            text = text + data.toString();
        }

        switch(logLevel) {
            case Log.FATAL:
            case Log.ERROR:
            case Log.WARN:

                if (t != null) {
                    ESLog.error(text, t );
                } else {
                    ESLog.error(text);
                }
                break;

            case Log.INFO:

                if (t != null) {
                    ESLog.info(text, t );
                } else {
                    ESLog.info(text);
                }
                break;

            default:
                // debug

                if (t != null) {
                    ESLog.debug(text, t );
                } else {
                    ESLog.debug(text);
                }
                break;
        }
    }


    /**
     * This method does nothing. The object could still be used to write messages
     * to the EIA log file.
     */
    public void close() {
    }

    /**
     * Properties are ignored for this wrapper.
     * @param initProperties
     */
    public void init(Properties initProperties) {
    }
}