/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/util/EncodingUtil.java 1.17 2004-09-28 13:48:56+02 stefsobe Exp $
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
 * $Log: EncodingUtil.java,v $
 * Revision 1.17  2004-09-28 13:48:56+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change log level; rename method of ConfigHolder
 *
 * Revision 1.16  2004-09-27 17:57:42+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.15  2004-05-08 04:42:14+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.14  2004-05-05 15:41:01+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.13  2004-02-02 10:23:16+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * changed from EIA log to ESLog
 *
 * Revision 1.12  2003-08-04 16:51:09+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.11  2003-05-12 01:59:26+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.10  2003-04-29 14:53:07+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * - Preparing build 5_0_0-001
 * - Preparing for use of only RUC pool
 * - smart rename: HPSE -> ES
 * - property file names changed
 *   (HpseService.properties -> EntitlementService.properties)
 * - build directories and JAR names changed
 *   (hpse_workspace -> es_workspace,
 *    HpseService.JAR -> EntitlementService.JAR)
 * - URLs: <http://barneybear:7051/ES5_0/ESListener>
 * - JSPs: hpse_bea_instance_info.jsp -> es_instance_info.jsp
 *   (trying to bug-fix WITS#340)
 * - LOG4j: ...logger.HPSE40... -> ...logger.ES50...
 * - SWAT port for production changed
 *   (EntitlementService.props.prod, swatprops.prod) changed to 21645
 *
 * Revision 1.9  2003-02-26 15:33:20+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.8  2003-01-22 15:27:44+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.7  2002-12-20 16:36:59+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * changed all log() messages to report class EncodingUtil, not WarrantyMappingEO
 *
 * Revision 1.6  2002-11-22 18:13:39+01  ANVOI
 * Author: ANVOI@dhcp-15-130-71-127.france.hp.com ()
 * change ito
 *
 * Revision 1.5  2002-11-18 16:51:09+01  ANPERS1
 * Author: ANPERS1@dhcp-15-198-7-216.bbn.hp.com ()
 * Updated the ITO logging.
 *
 * Revision 1.4  2002-10-11 15:39:51+02  JUHANK
 * Author: JUHANK@dhcp-15-198-3-133.bbn.hp.com ()
 * merged from 2.1.X (merge2_1b):
 * - ITO error id are now unique for an error message
 * - Change way of getting the encoding in the properties files
 *
 * Revision 1.3  2002-08-02 14:33:00+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * merging in changes between branch_point2_1 and merge2_1a
 *
 * Revision 1.2  2002-07-03 13:51:19+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.1  2002-07-03 08:58:59+02  juhank
 * Author: juhank@dhcp-15-198-6-106.bbn.hp.com ()
 * Initial revision
 *
 *
 */
package com.hp.es.service.util;




public class EncodingUtil {

    private static Object _syncObject = new Object();
    private static EncodingUtil _currentInstance = new EncodingUtil();
    /**
     * doCharacterEncoding()
     *
     * @param toConvert
     * @param countryCode
     * @return convertedString

    public String doSwatCharacterEncoding(String toConvert, String countryCode) {

        ESLog.debug("Enter");
        String encodingString = null;
        String convertedString = null;
        ESLog.debug("Having country code: " + countryCode);

        // checks if we have a special encoding for the contry
        encodingString = Configuration.getInstance().getProperties().getProperty(ENCODING_PREFIX + countryCode, null);

        // did we receive an encoding string?
        if(encodingString == null) {
            // NO, so we use the default encoding
            encodingString = Configuration.getInstance().getProperties().getProperty(ENCODING_PREFIX + "DEFAULT");
        }
        ESLog.debug("Using encoding: " + encodingString);

        // convert the string
        try {
            convertedString = new String(toConvert.getBytes(), encodingString);
        }
        catch (java.io.UnsupportedEncodingException uee) {
            ESLog.logITO(ItoErrorFactory
                    .getItoError(ItoErrorFactory.ID_3175_UNSUPPORTED_ENCODING),
                    "Encoding " + encodingString + " is not supported");
        }

        // return the converted string
        ESLog.debug("Exit");
        return convertedString;
    }
     */
    /**
     * get an instance of EncodingUtil
     *
     * @return EncodingUtil
     */
    public static EncodingUtil getInstance() {
        return _currentInstance;
   }
}
