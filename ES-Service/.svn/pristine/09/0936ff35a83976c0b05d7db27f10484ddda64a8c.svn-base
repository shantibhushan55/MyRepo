/*
 * Project: HPSE
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/util/db/OracleHelper.java 1.12
 * 2004-09-09 01:52:50+02 lbednari Exp $
 *
 * Copyright (c) 2002 Hewlett-Packard GmbH, Germany. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Hewlett-Packard.
 *
 * $Log: OracleHelper.java,v $
 * Revision 1.13  2004-09-27 17:57:54+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 * Revision 1.12 2004-09-09 01:52:50+02 lbednari
 * Author: lbednari@bbnnaid90.bbn.hp.com () - made sentinel to be a static
 * member to avoid garbage collection once RUC starts to use weak refs
 *
 * Revision 1.11 2004-05-08 04:41:46+02 entitlem Author:
 * entitlem@isoit621.bbn.hp.com (#Frank Renftle) no change, just pushing head
 * past branch_point8_0C1
 *
 * Revision 1.10 2004-05-05 15:40:31+02 entitlem Author:
 * entitlem@isoit621.bbn.hp.com (#Frank Renftle) no change, just pushing head
 * past branch_point6_1
 *
 * Revision 1.9 2004-02-05 14:47:10+01 lbednari Author:
 * lbednari@schmucknicola.emea.cpqcorp.net () - made reading of the config file
 * dynamic
 *
 * Revision 1.8 2004-02-02 10:25:30+01 JUHANK Author:
 * JUHANK@hankejuergen.emea.hpqcorp.net () changed to use ESLog
 *
 * Revision 1.7 2003-08-04 16:50:40+02 entitlem Author:
 * entitlem@isoit621.bbn.hp.com (#Frank Renftle) no change, just pushing head
 * past branch_point5_0
 *
 * Revision 1.6 2003-05-12 01:59:07+02 entitlem Author:
 * entitlem@isoit621.bbn.hp.com (#Frank Renftle) no change, just pushing head
 * past branch_point5_0C2
 *
 * Revision 1.5 2003-02-26 15:33:05+01 entitlem Author:
 * entitlem@isoit621.bbn.hp.com (#Frank Renftle) no change, just pushing head
 * past branch_point3_1
 *
 * Revision 1.4 2003-01-22 15:27:24+01 entitlem Author:
 * entitlem@isoit621.bbn.hp.com (#Frank Renftle) no change, just pushing head
 * past branch_point3_0
 *
 * Revision 1.3 2002-12-06 18:00:48+01 lbednari Author:
 * lbednari@bbnnaid233.bbn.hp.com () - list of error codes is now configurable
 * via properties file
 *
 * Revision 1.2 2002-10-25 04:50:02+02 lbednari Author:
 * lbednari@bbnnaid110.bbn.hp.com () - put in concrete Oracle error numbers
 *
 * Revision 1.1 2002-10-23 19:53:54+02 lbednari Author:
 * lbednari@dhcp-15-198-4-171.bbn.hp.com () Initial revision
 *
 */
package com.hp.es.service.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.hp.es.constants.EsConstants;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.config.DynConfigFactory;
import com.hp.ruc.config.ReadOnlyProperties;

public final class OracleHelper {

    private static ArrayList _errorCodes = new ArrayList();

    /*
     * REMOVE private static EIACatalog _eiaCatalog = EIACatalog.getInstance();
     * private static EIANotify _notify = EIANotify.getInstance();
     */

    // reference to make sure the sentinel is not garbage collected once RUC
    // starts
    // to use weak references
    private static ConfigChangeListener sentinel = null;

    static {

        DynConfigFactory dcf = DynConfigFactory.getDynInstance();

        // try to load the props to see if they come from CP or FS
        try {
            ReadOnlyProperties conf = dcf.getConfig(EsConstants.COMMON_PROPERTIES_FILENAME);

            // First register a listener that will always be triggered when the
            // config changes - this will trigger a re-init of the error code
            // array
            // Secondly make sure we will always be notified when the file
            // changes.

            sentinel = new ConfigChangeListener() {
                public void configChanged(ConfigChangeEvent event) {
                    init(event.getNewConfig());
                }
            };

            if (conf.isClassPathBased()) {
                dcf.listenForClassPathConfig(EsConstants.COMMON_PROPERTIES_FILENAME, sentinel);
                dcf.watchClassPathConfig(EsConstants.COMMON_PROPERTIES_FILENAME, EsConstants.PROPS_RELOAD_SECS);
            }
            else {
                dcf.listenForFileSystemConfig(EsConstants.COMMON_PROPERTIES_FILENAME,
                        sentinel);
                dcf.watchFileSystemConfig(EsConstants.COMMON_PROPERTIES_FILENAME,
                        EsConstants.PROPS_RELOAD_SECS);
            }

            // Maybe the config was already watched by some other class and
            // therefore
            // there will be no initial change event sent to us - make sure we
            // are
            // initialized anyway...
            init(dcf.getConfigFromClassPath(EsConstants.COMMON_PROPERTIES_FILENAME));
        }
        catch (java.io.IOException e) {
        	ESLog.error("Cannot load config files");
        }
    }

    /**
     * Build an array of error codes from a property in the passed Properties
     * object.
     *
     * @param conf
     */
    private static void init(ReadOnlyProperties conf) {

        if (conf != null) {
            String errorCodeList = conf.getProperty("db.down.errorCodes", "");
            synchronized (_errorCodes) {
                _errorCodes.clear();
                if (!"".equals(errorCodeList)) {
                    StringTokenizer st = new StringTokenizer(errorCodeList, ",");
                    String token = null;
                    while (st.hasMoreTokens()) {
                        try {
                            token = st.nextToken();
                            _errorCodes.add(new Integer(token));
                        }
                        catch (NumberFormatException nfe) {
                            ESLog.error("bad db.down.errorCodes");
                        }
                    }
                }
                else {
                    ESLog.error("bad db.down.errorCodes");
                }
            } //sync
        }
        else {
        	
            ESLog.error("Bad db.down.errorCodes file");
        }

    }

    /**
     * Checks if the given Oracle error code indicates that the DB is down. This
     * could be because the Listener is unreachable or the DB is shutting down
     * or in the middle of startup, etc.
     *
     * @param errorCode
     *            Oracle error code as extracted from an SLQException
     * @return True if the error code is representing an error
     */
    static public boolean isDatabaseDown(int errorCode) {
        // need to make sure the array is not in the middle of an update when
        // we check...
        synchronized (_errorCodes) {
            for (int i = 0; i < _errorCodes.size(); i++) {
                if (errorCode == ((Integer)_errorCodes.get(i)).intValue())
                    return true;
            }
        }

        return false;
    }
}