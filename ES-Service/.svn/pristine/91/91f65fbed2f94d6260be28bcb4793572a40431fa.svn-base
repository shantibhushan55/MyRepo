/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/contractEntitlement/EsCheckDateRange.java 1.9 2004-05-08 04:42:41+02 entitlem Exp $
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
 * $Log: EsCheckDateRange.java,v $
 * Revision 1.9  2004-05-08 04:42:41+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:41:31+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-02-05 14:46:35+01  lbednari
 * Author: lbednari@schmucknicola.emea.cpqcorp.net ()
 * - adjusted property file name constant
 *
 * Revision 1.6  2004-01-29 18:07:28+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.5  2003-12-09 15:50:51+01  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * fix bug for max date
 *
 * Revision 1.4  2003-12-08 17:20:19+01  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * fix error message
 *
 * Revision 1.3  2003-12-08 16:40:13+01  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * read ES check date from config file
 *
 * Revision 1.2  2003-08-04 16:51:48+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.1  2003-06-23 16:08:35+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.contractEntitlement;

import org.exolab.castor.types.Date;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ErrorFactory;
import com.hp.ruc.config.DynConfigFactory;
import com.hp.ruc.config.ReadOnlyProperties;
import com.hp.sif.SifException;

/**
 * This class verifies that entilement check date is in a range of
 * -90 days/+1day around current date.
 */
public class EsCheckDateRange {

    /**
     * The method verifies that the given date is in the range of
     * -90 days/+1day around current date. If not, the method throws
     * an exception.
     * @param date The date that should be in the given range.
     * @throws SifException if the date is not in the range. If the date is null
     *          then no exception is thrown.
     */
    public static void verifyDate(Date date) throws SifException {
        if (date!=null) {
            long dateInMillis = date.toDate().getTime();
            if (dateInMillis < System.currentTimeMillis()-MIN ||
                dateInMillis > System.currentTimeMillis()+MAX) {
                throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "EntitlementCheckDate",
                    "The configured range for EntitlementCheckDate is " +
                    "-" + ((MIN/(24L * 60L * 60L * 1000L))-1) + " day(s)/" +
                    "+" +  (MAX/(24L * 60L * 60L * 1000L)) +
                    " day(s) around the current date");
            }
        }
    }


    // Valid date range for the check date
    private static final long MIN;
    private static final long MAX;

    /**
     * This method is called only once when an instance of OperationManager
     * is created. It initilizes the access and watching of the properties
     * file.
     */
    static {
        long min = 0;
        long max = 0;

        try {
            DynConfigFactory configFactory = DynConfigFactory.getDynInstance();
            ReadOnlyProperties prop =
                configFactory.getConfig(
                    EsConstants.ES_PROPERTIES_FILENAME);
            Integer tmp = prop.getIntegerProperty("es.checkDate.min");
            if (tmp != null) {
                min = tmp.longValue() + 1;   // Note the '+1'
            }
            tmp = prop.getIntegerProperty("es.checkDate.max");
            if (tmp != null) {
                max = tmp.longValue();
            }
        }
        catch (Exception e) {
        }

        // default min: 91 days in milliseconds (Note: not 90 days)
        // default max:  1 day in milliseconds
        // Note: Don't remove the 'L' behind the numbers!
        MIN = (min==0L ? 91L : min) * 24L * 60L * 60L * 1000L;
        MAX = (max==0L ?  1L : max) * 24L * 60L * 60L * 1000L;
    }
}
