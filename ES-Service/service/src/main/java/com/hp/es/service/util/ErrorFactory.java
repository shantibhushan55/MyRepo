/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/util/ErrorFactory.java 1.60 2004-09-28 13:50:21+02 stefsobe Exp $
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
 * @author Dave Frey
 *
 * $Log: ErrorFactory.java,v $
 * Revision 1.60  2004-09-28 13:50:21+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change error class of error 201 to InvalidDataContent
 *
 * Revision 1.59  2004-09-27 17:57:43+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.58  2004-08-12 02:23:52+02  lbednari
 * Author: lbednari@bbnnaid18.bbn.hp.com ()
 * Added error id 433
 *
 * Revision 1.57  2004-08-10 09:51:55+02  lbednari
 * Author: lbednari@bbnnaid625.bbn.hp.com ()
 * changed error text for 429
 *
 * Revision 1.56  2004-08-03 00:33:52+02  lbednari
 * Author: lbednari@bbnnaid660.bbn.hp.com ()
 * fully obsoleted error ids 223 and 225
 *
 * Revision 1.55  2004-07-16 18:54:12+02  lbednari
 * Author: lbednari@schmucknicola.emea.cpqcorp.net ()
 * merged from 8.0 C1
 *
 * Revision 1.54  2004-07-02 11:51:25+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Add error id 431 for PoP
 *
 * Revision 1.53  2004-05-08 04:42:13+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.52  2004-05-05 15:41:00+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.51  2004-01-29 18:06:45+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.50  2003-08-04 16:51:08+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.49  2003-07-15 16:51:40+02  thpo
 * Author: thpo@dhcp-15-197-230-88.bbn.hp.com ()
 * correct warnings: 408 and 421 only in UnitList case
 *
 * Revision 1.48  2003-07-10 12:55:48+02  lbednari
 * Author: lbednari@dhcp-15-197-235-62.bbn.hp.com ()
 * - change message for 202
 *
 * Revision 1.47  2003-07-10 11:20:11+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * adjusting when we filter some blue warranty warnings, per discussion w/Philippe Eckert
 *
 * Revision 1.46  2003-07-09 20:54:21+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * applying ES3.0 warning filtering and translation
 *
 * Revision 1.45  2003-07-07 14:21:40+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * - 424 renamed

 * - 225 425 added
 *
 * Revision 1.44  2003-06-25 19:10:03+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * exception handling is simplified

 * - there are warnings

 * - there are runtime and eia exceptions
 *
 * Revision 1.43  2003-06-24 21:05:38+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * added 130
 *
 * Revision 1.42  2003-06-24 15:41:54+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * changing CBO -> consumer at P.Eckert's request
 *
 * Revision 1.41  2003-06-23 17:54:46+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * altered usage of Support Pack => Care Pack; introduced new warning id428_CARE_PACK_NOT_FOUND_WARNING
 *
 * Revision 1.40  2003-06-06 18:41:24+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * migrated ESLog clients to use the error id const in ErrorFactory
 *
 * Revision 1.39  2003-06-05 15:44:27+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * removing remaining ';' and ':' from error texts, when not used for parm separation
 *
 * Revision 1.38  2003-06-04 16:50:39+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * changed error texts to use new spec for "localizable" errors;
 * removed unused internal errors 8010 and 8011;
 * introduced psf ints to enumerate error ids;
 *
 * Revision 1.37  2003-05-19 12:27:55+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * 427 is now InvalidDataContent
 *
 * Revision 1.36  2003-05-13 16:30:40+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * added 427
 *
 * Revision 1.35  2003-05-13 13:24:24+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * next round of bug fixing
 *
 * Revision 1.34  2003-05-12 01:59:25+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.33  2003-04-28 19:13:22+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * - changed red error handling and reporting in code
 * - sync'ed SAG (ITO) and SAG (SifException) with code
 *
 * Revision 1.32  2003-04-25 18:50:09+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * two new errors for KNIGHT
 *
 * Revision 1.31  2003-03-26 16:35:14+01  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * changes for new xml schema
 *
 * Revision 1.30  2003-02-26 15:33:20+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.29  2003-01-22 15:27:43+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.28  2002-12-06 04:56:02+01  lbednari
 * Author: lbednari@bbnnaid2.bbn.hp.com ()
 * - added new entries for SWAT warnings
 *
 * Revision 1.27  2002-11-21 00:01:16+01  lbednari
 * Author: lbednari@bbnnaid59.bbn.hp.com ()
 * - added some statics to support error handling
 *
 * Revision 1.26  2002-11-11 18:07:05+01  lbednari
 * Author: lbednari@dhcp-15-198-5-221.bbn.hp.com ()
 * - changed text of warning 418
 *
 * Revision 1.25  2002-11-04 19:39:59+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * added warnings 405, 408, 416
 *
 * Revision 1.24  2002-11-04 16:12:09+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * cleanup StartDate warnings
 *
 * Revision 1.23  2002-10-08 15:47:25+02  JUHANK
 * Author: JUHANK@dhcp-15-198-3-133.bbn.hp.com ()
 * - added warning 401 and 402

 * - added functional 203 and 204
 *
 * Revision 1.22  2002-09-23 19:50:43+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * more 3.0 error/warning def changes;

 * some unfortunate IDE-induced reformatting changes, sorry about diff
 *
 * Revision 1.21  2002-08-23 15:51:10+02  frey
 * Author: frey@dhcp-15-130-67-196.france.hp.com ()
 * changed the warnings for start date calculation
 *
 * Revision 1.20  2002-08-20 17:50:01+02  frey
 * Author: frey@dhcp-15-130-67-196.france.hp.com ()
 * added more WARNINGs in support of warranty start date calculation
 *
 * Revision 1.19  2002-08-19 13:15:27+02  frey
 * Author: frey@dhcp-15-130-67-196.france.hp.com ()
 * added four start date warnings for 3.0 reqmts spec
 *
 * Revision 1.18  2002-08-02 14:33:01+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * merging in changes between branch_point2_1 and merge2_1a
 *
 * Revision 1.17  2002-07-25 04:38:15+02  lbednari
 * Author: lbednari@bbnnaid2.bbn.hp.com ()
 * - added error numbers for ACME
 *
 * Revision 1.16  2002-07-24 16:27:18+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * fixed all EIA-SF deprecated warnings
 *
 * Revision 1.15  2002-07-03 13:51:18+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.14  2002-06-17 02:53:28+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * for consistency, all ErrorText strings do NOT end with a "."
 *
 * Revision 1.13  2002-06-16 16:33:42+02  lbednari
 * Author: lbednari@bbnnaid33.bbn.hp.com ()
 * - change error text for no data found
 *
 * Revision 1.12  2002-06-12 20:14:25+02  lbednari
 * Author: lbednari@dhcp-15-198-6-111.bbn.hp.com ()
 * - added internal CORBA errors
 *
 * Revision 1.11  2002-06-11 19:35:40+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * added 8001 internal error
 *
 * Revision 1.10  2002-06-11 15:38:57+02  lbednari
 * Author: lbednari@bbnnaid61.bbn.hp.com ()
 * - added 8010 and 8011
 *
 * Revision 1.9  2002-06-07 14:29:04+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * merged multiple internal timeout errors to a single parameterized 8000
 *
 * Revision 1.8  2002-06-06 17:57:30+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * moved internal error range from DEBUG => WARNING
 *
 * Revision 1.7  2002-06-06 17:05:06+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * added     public static boolean isHpseInternal() testers
 *
 * Revision 1.6  2002-06-06 15:10:39+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * merged warnings 400, 410 into a parameterized 400.
 *
 * Revision 1.5  2002-06-06 14:39:19+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * implemented "internal" errors 8000-8999.
 *
 * Revision 1.4  2002-06-03 17:10:00+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * moved from service.productEntitlement => service.util
 *
 * Revision 1.3  2002-06-03 11:14:22+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * new errors

 *
 * Revision 1.1  2002-05-30 20:38:56+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * working copy; to be tested and discussed and possibly moved
 * to service.util.
 *
 *
 */
package com.hp.es.service.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.oro.text.regex.Perl5Substitution;
import org.apache.oro.text.regex.Util;

import com.hp.es.service.util.exception.EsException;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.types.ErrorLevelType;
import com.hp.sif.SifException;
import com.hp.sif.SifUtil;

public class ErrorFactory
{

    
    public static final int id9999_INTERNAL_ERROR = 9999;

    public static final int id100_SERVICE_UNREACHABLE = 100;
    public static final int id101_SERVICE_IS_DOWN = 101;
    public static final int id102_VERSION_NOT_SUPPORTED = 102;
    public static final int id110_SERVICE_UNKNOWN = 110;
    public static final int id111_ACCESS_DENIED = 111;
    public static final int id120_INVALID_REQUEST = 120;
    
    public static final int id121_FRAUD_SN = 121;
    
    public static final int id200_MISSING_PARAMETER = 200;
    public static final int id201_PARAMETER_HAS_INVALID_DATA = 201;
    public static final int id202_PRODUCT_NR_NOT_PROVIDED = 202;
    public static final int id203_CARE_PACK_NOT_FOUND = 203;
    public static final int id204_INVALID_CARE_PACK = 204;
    public static final int id210_PRODUCT_NR_NOT_FOUND = 210;
    public static final int id211_MISSING_WARRANTY_RULE = 211;
    public static final int id212_NO_START_DATE = 212;
    public static final int id213_NO_WARRANTY_FOUND = 213;
    public static final int id214_PRODUCT_PART_NOT_ELIGIBLE = 214;
    public static final int id220_MULTIPLE_CISYS_NUMBERS_FOUND = 220;
    public static final int id221_NO_TOP_LEVEL_ASSIGNED = 221;
    public static final int id222_KNIGHT_NOT_AVAILABLE = 222;
    public static final int id223_KNIGHT_INVALID_RESULT = 223;
    public static final int id224_ALL_SOURCE_SYSTEMS_TIMED_OUT = 224;

    //232--235 for combined error
    public static final int id232_PRODUCT_NR_NOT_PROVIDED = 232;
    public static final int id233_NO_START_DATE = 233;
    public static final int id234_PRODUCT_NR_NOT_FOUND = 234;
    public static final int id235_NO_WARRANTY_FOUND = 235;
    public static final int id236_NO_ISO_COUNTRY_CODE = 236;
    public static final int id237_NO_PRODUCT_SHIP_TO  = 237;

    public static final int id300_NO_DATA_FOUND = 300;
    public static final int id301_NO_DATA_FOUND = 301;

    public static final int id400_SYSTEM_NOT_AVAILABLE = 400;
    public static final int id401_WRONG_INPUT_DATA = 401;
    public static final int id402_UNIT_NOT_FOUND = 402;
    public static final int id405_USING_PRODUCT_SYNONYM = 405;
    public static final int id408_UNIT_LIST_TRUNCATED = 408;
    public static final int id410_NO_SERVICE_ID_FOR_BOD_PRODUCT = 410;
    public static final int id411_SERVICE_ID_DECODE_FAILED = 411;
    public static final int id412_REG_PURCHASE_DATE_TOO_EARLY = 412;
    public static final int id413_REG_PURCHASE_DATE_TOO_LATE = 413;
    public static final int id414_REG_DATE_TOO_EARLY = 414;
    public static final int id415_REG_DATE_TOO_LATE = 415;
    public static final int id416_SERIAL_NR_DECODE_FAILED = 416;
    public static final int id417_SERIAL_NR_DECODE_INVALID = 417;
    public static final int id418_INACCURATE_START_DATE = 418;
    public static final int id420_CONSUMER_PRODUCT = 420;
    public static final int id421_PRODUCT_NOT_EXACT_MATCH = 421;
    public static final int id422_SWAT_UNIT_DATA_INCONSISTENT = 422;
    public static final int id424_INVALID_KNIGHT_RESULT = 424;
    public static final int id425_MANDATORY_FIELD_MISSING_IN_KNIGHT_RESULT = 425;
    public static final int id426_SOURCESYSTEM_RETURNED_WARNING = 426;
    public static final int id427_INVALID_PRODUCT_NUMBER = 427;
    public static final int id428_CARE_PACK_NOT_FOUND_WARNING = 428;
    public static final int id436_SOURCE_SYSTEM_RETURNED_WARNING_OR_ERROR = 436;
    public static final int id437_SPECIAL_INSTRUCTION_FIELD_TRUNCARED = 437;

    public static final int id429_WARRANTY_REDETERMINED_BASED_INPUT_COUNTRY = 429;
    public static final int id430_DATECODE_PASSED_AS_INPUT_PARAMETER = 430;
    public static final int id431_START_DATE_REALIGNED = 431;
    public static final int id432_WARRANTY_CALCULATED_BASED_SPAREPARTNUMBER = 432;
    public static final int id433_INPUT_POP_DATE_NOT_USED = 433;
    public static final int id434_SYSTEMS_NOT_AVAILABLE = 434;
    public static final int id435_UNIT_TRACKED_IN_SEVERAL_SWOP = 435;
    
    public static final int id440_UNIT_SNR_PARENT_BUNDLE_IDENTIFIED= 440;
    public static final int id441_UNIT_SNR_PARENT_BUNDLE= 441;
    
    
    /** 
     *  New warning mapping for 3G effort TR363583.
     *  450 through 457
     */
    public static final int id450_3G_UNIT_REQUEST_POP_AND_OWNER_TYPE_INFO_SWOP = 450;
    public static final int id451_3G_UNIT_WITHIN_WARRENTY_REGULATION_SWOP = 451;
    public static final int id452_3G_UNIT_PART_WARRANTY_SWOP = 452;
    public static final int id453_3G_UNIT_HAS_PART_HISTORY_SWOP = 453;
    public static final int id454_3G_UNIT_HAS_PART_WARRANTY_SWOP = 454;

 
    public static final int[] BLUE_WARRANTY_WARNINGS_ALWAYS = new int[] {400, 410, 411, 420, 428};
    public static final int[] BLUE_WARRANTY_WARNINGS_WHEN_BLUE_BASE = new int[] {401, 405, 412, 413, 414, 415, 416, 417, 418, 422};
    public static final int[] BLUE_WARRANTY_WARNINGS_WHEN_ODS_BEATS_SWAT = new int[] {402};
    public static final int[] BLUE_WARRANTY_WARNINGS_WHEN_UNIT_LIST = new int[] {408};
    public static final int[] SWOP_WARRANTY_WARNINGS_WHEN_SWOP_BASE = new int[] {429, 418, 405, 413, 412, 416, 402, 411, 426, 430, 420, 432, 433};
    public static final int[] SWOP_WARRANTY_WARNINGS_WHEN_UNIT_LIST = new int[] {408};


    public static final int id8000_TIMEOUT_OCCURRED = 8000;
    public static final int id8001_SYSTEM_NOT_AVAILABLE = 8001;
    public static final int id8020_CORBA_BINDING_PROBLEM = 8020;
    public static final int id8021_CORBA_REQUEST_PROBLEM = 8021;

    // our catalog of errors represented as prototypical SifExceptions.
    // the hashtable key is the HPSE error id (as string, no leading zeros).
    private static Hashtable<String, EsException> _SifExceptionPrototypes = init();

    /** We use the error ids directly in the code when calling the factory methods
     *  of this class all over the place. To avoid having the numbers also appear
     *  in code that does not create an error/exception this method gives composite
     *  services an easy way to determine if the error the got back indicates an
     *  empty result
     */
    public static boolean isDataNotFound(int errorId){
        return (errorId == 300);
    }
    /** Compares passed string to predefined EIA error class descriptor */
    public static boolean equalsDataNotFoundClass(String errorClass) {
        return "DataNotFound".equalsIgnoreCase(errorClass);
    }
    /** Compares passed string to predefined EIA error class descriptor */
    public static boolean equalsInvalidDataContentClass(String errorClass) {
        return "InvalidDataContent".equalsIgnoreCase(errorClass);
    }
    /** Compares passed string to predefined EIA error class descriptor */
    public static boolean equalsMissingDataContentClass(String errorClass) {
        return "MissingDataContent".equalsIgnoreCase(errorClass);
    }
    /** Compares passed string to predefined EIA error class descriptor */
    public static boolean equalsInvalidDataFormatClass(String errorClass) {
        return "InvalidDataFormat".equalsIgnoreCase(errorClass);
    }
    /** Compares passed string to predefined EIA error class descriptor */
    public static boolean equalsMisConfigurationClass(String errorClass) {
        return "MisConfiguration".equalsIgnoreCase(errorClass);
    }
    /** Compares passed string to predefined EIA error class descriptor */
    public static boolean equalsServiceNotAvailableClass(String errorClass) {
        return "ServiceNotAvailable".equalsIgnoreCase(errorClass);
    }
    /** Compares passed string to predefined EIA error class descriptor */
    public static boolean equalsInternalClass(String errorClass) {
        return "Internal".equalsIgnoreCase(errorClass);
    }
    /** Compares passed string to predefined EIA error class descriptor */
    public static boolean equalsDataContentClass(String errorClass) {
        return "DataContent".equalsIgnoreCase(errorClass);
    }


    /**
     * Looks up the prototype SifException, clones it, sets the timestamp.
     * If it is not found, we <strong>return</strong> a 9999 internal error.  If that's
     * missing we <strong>throw</strong> an unchecked exception.
     *
     * @param   id           The HPSE error id
     * @return  SifException A new prototype initialized to match the error id.
     *
     */
    public static SifException getSifException(int id) {
        EsException newProto = new EsException();
        String payloadMsg = "";

        EsException obj = _SifExceptionPrototypes.get(String.valueOf(id));
        if (obj == null) {
            // try to get a 9999 which will carry a payload message

            payloadMsg = "ErrorFactory.SifExceptionForId() could not find error id: " + id;
            obj = _SifExceptionPrototypes.get(String.valueOf(9999));
            if (obj == null) {
                // throw it out to the framework
                throw new RuntimeException("ErrorFactory.SifExceptionForId() could not find error id " + id + " nor 9999");
            }
        }

        newProto.setErrorLevel(obj.getErrorLevel());
        newProto.setErrorID(obj.getErrorID());
        newProto.setErrorText(obj.getErrorText());
        newProto.setErrorClass(obj.getErrorClass());

        newProto.setTimeStamp(SifUtil.getLocalTimeStamp());
        newProto.setDataPayload(payloadMsg);
        newProto.setLogLevel(newProto.getLogLevel());

        return newProto;
    }
    /**
     * Same behavior as getSifException(int) except that the provided String
     * parameter(s) are used to complete the ErrorText (using string substitution)
     * and optionally to set the DataPayLoad as well.
     *
     * An unchecked exception is thrown if there
     * are too few or too many string parameter(s) for the error.
     *
     * @param   id           The HPSE error id
     * @param   str1         First  string to use to fill in ErrorText/DataPayLoad
     *
     * @return  SifException A new, initialized SifException.
     *
     */
    public static SifException getSifException(int id, String str1) {
        SifException newProto = getSifException(id);

        newProto = fillInStrings(newProto, str1, null, null, null);

        return newProto;
    }
    /**
     * Same behavior as getSifException(int) except that the provided String
     * parameter(s) are used to complete the ErrorText (using string substitution)
     * and optionally to set the DataPayLoad as well.
     *
     * An unchecked exception is thrown if there
     * are too few or too many string parameter(s) for the error.
     *
     * @param   id           The HPSE error id
     * @param   str1         First  string to use to fill in ErrorText/DataPayLoad
     * @param   str2         Second string to use to fill in ErrorText/DataPayLoad
     * @return  SifException A new, initialized SifException.
     *
     */
    public static SifException getSifException(int id, String str1, String str2) {
        SifException newProto = getSifException(id);

        newProto = fillInStrings(newProto, str1, str2, null, null);

        return newProto;
    }
    /**
     * Same behavior as getSifException(int) except that the provided String
     * parameter(s) are used to complete the ErrorText (using string substitution)
     * and optionally to set the DataPayLoad as well.
     *
     * An unchecked exception is thrown if there
     * are too few or too many string parameter(s) for the error.
     *
     * @param   id           The HPSE error id
     * @param   str1         First  string to use to fill in ErrorText/DataPayLoad
     * @param   str2         Second string to use to fill in ErrorText/DataPayLoad
     * @param   str3         Third  string to use to fill in ErrorText/DataPayLoad
     * @return  SifException A new, initialized SifException.
     *
     */
    public static SifException getSifException(int id, String str1, String str2, String str3) {
        SifException newProto = getSifException(id);

        newProto = fillInStrings(newProto, str1, str2, str3, null);

        return newProto;
    }
    /**
     * Same behavior as getSifException(int) except that the provided String
     * parameter(s) are used to complete the ErrorText (using string substitution)
     * and optionally to set the DataPayLoad as well.
     *
     * An unchecked exception is thrown if there
     * are too few or too many string parameter(s) for the error.
     *
     * @param   id           The HPSE error id
     * @param   str1         First  string to use to fill in ErrorText/DataPayLoad
     * @param   str2         Second string to use to fill in ErrorText/DataPayLoad
     * @param   str3         Third  string to use to fill in ErrorText/DataPayLoad
     * @param   str4         Fourth string to use to fill in ErrorText/DataPayLoad
     * @return  SifException A new, initialized SifException.
     *
     */
    public static SifException getSifException(int id, String str1, String str2, String str3, String str4) {
        SifException newProto = getSifException(id);

        newProto = fillInStrings(newProto, str1, str2, str3, str4);

        return newProto;
    }
    /**
     * Retrieves the prototype SifException and converts it to an EIAError.
     * All other behavior is as described in getSifException(int).
     *
     * @param   id           The HPSE error id
     *
     * @return  SifException A new prototype initialized to match the error id.
     *
     */
    public static EIAError getEIAError(int id) {
        SifException newProto = getSifException(id);

        return convertSifException(newProto);
    }
    /**
     * Retrieves the prototype SifException for id, inserts the string
     * parameter(s), and converts it to an EIAError.  String parameter(s)
     * will be used to fill in first the parameters in the ErrorText, then
     * optionally the DataPayLoad.  An unchecked exception is thrown if there
     * are too few or too many string parameter(s) for the error.
     *
     * All other behavior is as described in the associated getSifException().
     *
     * @param   id           The HPSE error id
     * @param   str1         First string to use in filling in
     *
     * @return  SifException A new prototype initialized to match the error id.
     *
     */
    public static EIAError getEIAError(int id, String str1) {
        SifException newProto = getSifException(id);

        newProto = fillInStrings(newProto, str1, null, null, null);

        return convertSifException(newProto);
    }
    /**
     * Retrieves the prototype SifException for id, inserts the string
     * parameter(s), and converts it to an EIAError.  String parameter(s)
     * will be used to fill in first the parameters in the ErrorText, then
     * optionally the DataPayLoad.  An unchecked exception is thrown if there
     * are too few or too many string parameter(s) for the error.
     *
     * All other behavior is as described in the associated getSifException().
     *
     * @param   id           The HPSE error id
     * @param   str1         First  string to use in filling in
     * @param   str2         Second string to use in filling in
     *
     * @return  SifException A new prototype initialized to match the error id.
     *
     */
    public static EIAError getEIAError(int id, String str1, String str2) {
        SifException newProto = getSifException(id);

        newProto = fillInStrings(newProto, str1, str2, null, null);

        return convertSifException(newProto);
    }
    /**
     * Retrieves the prototype SifException for id, inserts the string
     * parameter(s), and converts it to an EIAError.  String parameter(s)
     * will be used to fill in first the parameters in the ErrorText, then
     * optionally the DataPayLoad.  An unchecked exception is thrown if there
     * are too few or too many string parameter(s) for the error.
     *
     * All other behavior is as described in the associated getSifException().
     *
     * @param   id           The HPSE error id
     * @param   str1         First  string to use in filling in
     * @param   str2         Second string to use in filling in
     * @param   str3         Third  string to use in filling in
     *
     * @return  SifException A new prototype initialized to match the error id.
     *
     */
    public static EIAError getEIAError(int id, String str1, String str2, String str3) {
        SifException newProto = getSifException(id);

        newProto = fillInStrings(newProto, str1, str2, str3, null);

        return convertSifException(newProto);
    }
    /**
     * Retrieves the prototype SifException for id, inserts the string
     * parameter(s), and converts it to an EIAError.  String parameter(s)
     * will be used to fill in first the parameters in the ErrorText, then
     * optionally the DataPayLoad.  An unchecked exception is thrown if there
     * are too few or too many string parameter(s) for the error.
     *
     * All other behavior is as described in the associated getSifException().
     *
     * @param   id           The HPSE error id
     * @param   str1         First  string to use in filling in
     * @param   str2         Second string to use in filling in
     * @param   str3         Third  string to use in filling in
     * @param   str4         Fourth string to use in filling in
     *
     * @return  SifException A new prototype initialized to match the error id.
     *
     */
    public static EIAError getEIAError(int id, String str1, String str2, String str3, String str4) {
        SifException newProto = getSifException(id);

        newProto = fillInStrings(newProto, str1, str2, str3, str4);

        return convertSifException(newProto);
    }
    /**
     * This attempts to fill in the text messages for the provided SifException
     * using the provided String parms.  The String parms can be null, but
     * any null parms must be after (in the signature) any valid Strings.
     * If there are too few String parms for the given SifException,
     * an unchecked exception is thrown.  The provided Strings are used to first
     * make parameter substitutions in the ErrorText. If there are more String parms 
     * than needed for string substitution by the given SifException the
     * remaining ones are concatenated - separated by '; ' - and written to the
     * DataPayLoad.
     *
     * In summary, the caller is expected to know how many string substitutions are
     * made for any specific error id.
     * 
     * @param   ee           The <code>SifException</code>
     * @param   str1         First string to use in filling in SifException messages.
     * @param   str2         Second string
     * @param   str3         Third string
     * @param   str4         Fourth string
     *
     * @return  SifException A new prototype initialized to match the error id.
     *
     */
    private static SifException fillInStrings(SifException ee, String str1, String str2, String str3, String str4) {
        int parmsInErrorText;       // this is our minimum number of string substitutions
        int validStringParms = 0;

        PatternMatcher matcher = new Perl5Matcher();
        PatternCompiler compiler = new Perl5Compiler();
        Pattern pattern = null;
        String errorTextToken = "%s";  // the substitution token used in ErrorText

        try {
            pattern = compiler.compile(errorTextToken);
        }
        catch (MalformedPatternException e) {
            throw new RuntimeException("ErrorFactory.fillInStrings(): Perl5Compiler failed to compile the expression \"" + errorTextToken + "\"");
        }

        // find how many valid strings we were passed
        if (str1 != null) {
            validStringParms++;
            if (str2 != null) {
                validStringParms++;
                if (str3 != null) {
                    validStringParms++;
                    if (str4 != null) {
                        validStringParms++;
                    }
                }
            }
        }

        // find how many substitutions are needed in our ErrorText;
        // this gets the count only; nothing meaningful is changed

        parmsInErrorText = Util.substitute(
                new java.lang.StringBuffer(), // a throw-away return value
                matcher,
                pattern,
                new Perl5Substitution("", Perl5Substitution.INTERPOLATE_NONE),
                new PatternMatcherInput(ee.getErrorText()),
                Util.SUBSTITUTE_ALL);

        // insure we were passed the right number of strings

        if (validStringParms < parmsInErrorText)
            throw new RuntimeException(
                    "ErrorFactory.fillInStrings(): ErrorID [" + ee.getErrorID() + "] needs "
                    + parmsInErrorText + " string parameters, but only " + validStringParms + " were provided.");

        // fill up an indexable Vector for convenience
        Vector<String> parms = new Vector<String>();
        if (validStringParms > 0) parms.add(str1);
        if (validStringParms > 1) parms.add(str2);
        if (validStringParms > 2) parms.add(str3);
        if (validStringParms > 3) parms.add(str4);

        // now make left-to-right substitutions in the ErrorText

        int parmIndex = 1;
        String subst = null;
        while (parmIndex <= parmsInErrorText) {
            subst = parms.get(parmIndex - 1);  // vector starts w/zero, our list starts w/one

            ee.setErrorText(Util.substitute(
                    matcher,
                    pattern,
                    new Perl5Substitution(subst, Perl5Substitution.INTERPOLATE_NONE),
                    ee.getErrorText(),
                    1)
            );
            parmIndex++;
        }

        // whatever is left goes to the DataPayLoad
        StringBuffer sb = new StringBuffer();
        boolean payloadEmpty = true;
        while (parmIndex <= validStringParms) {
        	if (!payloadEmpty) sb.append("; ");
        	sb.append(parms.get(parmIndex - 1));
        	payloadEmpty = false;
        	parmIndex++;
        }
        if (!payloadEmpty) ee.setDataPayload(sb.toString());

        return ee;
    }
    /**
     * Converts the inbound SifException to an EIAError.  If inbound is null we return null.
     *
     * @param   ee object to be converted
     *
     * @return  EIAError Object converted
     */
    public static EIAError convertSifException(SifException ee) {
        if (ee == null) return null;

        EIAError newProto = new EIAError();

        newProto.setErrorLevel(ErrorLevelType.valueOf(ee.getErrorLevel()));
        newProto.setErrorID(ee.getErrorID());
        newProto.setErrorText(ee.getErrorText());
        newProto.setErrorClass(ee.getErrorClass());
        newProto.setTimeStamp(ee.getTimeStamp());
        newProto.setDataPayLoad(ee.getDataPayLoad());

        return newProto;
    }

    private static String SifExceptionAsString(SifException ee) {
        return "[" + ee.getErrorID() + "] "
                + ee.getErrorLevel() + " "
                + ee.getErrorClass() + " \""
                + ee.getErrorText() + "\" \""
                + ee.getDataPayLoad() + "\" "
                + ee.getTimeStamp();
    }
    /**
     * Load our table of SifException prototypes.  They are only prototypes
     * because they are missing the following items to be filled in at runtime:
     *    - parameters for the ErrorText message template
     *    - a DataPayLoad, if any
     *    - the TimeStamp
     *
     * This is organized by the EIA error levels, for convenience.
     *
     * @return  Hashtable   A table of the prototypes, keyed by ErrorID
     *
     */
    private static Hashtable<String, EsException> init() {
        Hashtable<String, EsException> SifExceptionPrototypes = new Hashtable<String, EsException>();

        add_FATALs(SifExceptionPrototypes);
        add_FUNCTIONALs(SifExceptionPrototypes);
        add_WARNINGs(SifExceptionPrototypes);
        add_INFORMATIONs(SifExceptionPrototypes);
        //add_DEBUGs(SifExceptionPrototypes);

        add_HPSE_INTERNALs(SifExceptionPrototypes);  // temp implementation of app-internal signalling

        return SifExceptionPrototypes;
    }

    /**
     * @param ht
     * @param id
     * @param errorLevelString
     * @param errorText
     * @param errorClass
     * @param logLevel
     */
    private static void addException(Hashtable<String, EsException> ht, int id, String errorLevelString, String errorText, String errorClass, int logLevel) {
        EsException proto;
        proto = new EsException();
        proto.setErrorLevel(errorLevelString);
        proto.setErrorID(String.valueOf(id));
        proto.setErrorText(errorText);
        proto.setErrorClass(errorClass);
        proto.setLogLevel(logLevel);
        ht.put(proto.getErrorID(), proto);
    }

    private static void add_FATALs(Hashtable<String, EsException> ht) {
        String els = ErrorLevelType.FATAL.toString();

        addException(ht, 9999, els, "Internal error", "Internal", EsLogLevel.FUNCTIONAL);
        addException(ht,  100, els, "Service is unreachable: %s", "ServiceNotAvailable", EsLogLevel.FATAL);
        addException(ht,  101, els, "Service is down: %s", "ServiceNotAvailable", EsLogLevel.FATAL);
        addException(ht,  102, els, "Service version not supported: %s", "ServiceNotAvailable", EsLogLevel.FATAL);
        addException(ht,  110, els, "Service is unknown: %s", "Misconfiguration", EsLogLevel.FATAL);
        addException(ht,  111, els, "Access to service denied: %s", "Misconfiguration", EsLogLevel.FATAL);
        addException(ht,  120, els, "Invalid request: %s", "InvalidDataFormat", EsLogLevel.INFORMATION);
        //add by kangli
        addException(ht,  121, els, "Fraud SN: %s", "FraudCustomer", EsLogLevel.FATAL);
       
    }

    private static void add_FUNCTIONALs(Hashtable<String, EsException> ht) {
        String els = ErrorLevelType.FUNCTIONAL.toString();

        addException(ht, 200, els, "Mandatory parameter is missing: %s",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 201, els, "Parameter contains invalid data: %s",
                "InvalidDataContent", EsLogLevel.DEBUG);

        // really MissingDataContent or DataNotFound ???
        addException(ht, 202, els, "No unit found with supplied serial number - try to additionally " +
                        "provide the product number",
                "MissingDataContent", EsLogLevel.DEBUG);

        // note: this is the error version of error 428 below
        addException(ht, 203, els, "Care Pack not found",
                "DataNotFound", EsLogLevel.DEBUG);

        addException(ht, 204, els, "Invalid Care Pack",
                "DataNotFound", EsLogLevel.DEBUG);

        addException(ht, 210, els, "Product number was not found: %s",
                "DataNotFound", EsLogLevel.DEBUG);

        addException(ht, 211, els, "Could not find warranty calculation rule for warranty code/country code: %s ; %s",
                "DataNotFound", EsLogLevel.DEBUG);

        addException(ht, 212, els, "Product not eligible for service. Contact HP Call Center for further information – include proof-of-purchase, photos of product and serial number labels, and customer contact information",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 213, els, "No Warranty Found",
                "DataNotFound", EsLogLevel.DEBUG);

        addException(ht, 214, els, "Product or part not eligible for warranty",
                "DataNotFound", EsLogLevel.DEBUG);

        addException(ht, 220, els, "Multiple CISYS numbers found in matching IBSystems.",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 221, els, "No top level request area assigned to some matching IBSystems.",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 222, els, "KNIGHT system not available.",
                "MissingDataContent", EsLogLevel.FUNCTIONAL);

        addException(ht, 223, els, "Invalid KNIGHT result (see DataPayload)",
                "InvalidDataContent", EsLogLevel.FUNCTIONAL);

        addException(ht, 224, els, "All Source Systems are not available: %s",
                "MissingDataContent", EsLogLevel.FUNCTIONAL);

        addException(ht, 225, els, "Mandatory fields missing in KNIGHT result",
                "InvalidDataContent", EsLogLevel.FUNCTIONAL);

        //232--235 is for combined functional errors
        addException(ht, 232, els, "No unit found with supplied serial number - try to additionally " +
                        "provide the product number. The following systems are not available: %s",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 233, els, "Warranty calculation not possible; could not find a start date. " +
                        "Retry with additional parameters. The following systems are not available: %s",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 234, els, "Product number was not found. The following systems are not available: %s",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 235, els, "No Warranty found. The following systems are not available: %s",
                "MissingDataContent", EsLogLevel.DEBUG);
        
        addException(ht, 235, els, "No Warranty found. The following systems are not available: %s",
                "MissingDataContent", EsLogLevel.DEBUG);
        
        addException(ht, 236, els, "No data found. The following systems are not available: %s",
                "MissingDataContent", EsLogLevel.DEBUG);
        
        addException(ht, 237, els, "No ISOCountryCode available for ProductShipTo Location. Contract invalid: %s 6 %s",
                "MissingDataContent", EsLogLevel.DEBUG);        

        addException(ht, 300, els, "No data found",
                "DataNotFound", EsLogLevel.DEBUG);
        
        addException(ht, 301, els, "No data found. The following systems are not available: %s",
                "DataNotFound", EsLogLevel.DEBUG);

    }

    private static void add_WARNINGs(Hashtable<String, EsException> ht) {
        String els = ErrorLevelType.WARNING.toString();

        addException(ht, 400, els, "The following systems are not available, warranty calculation is " +
                        "proceeding with reduced logic: %s",
                "ExternalSystemUnavailable", EsLogLevel.DEBUG);

        addException(ht, 401, els, "Wrong input data",
                "WrongInputData", EsLogLevel.DEBUG);

        addException(ht, 402, els, "Warranty calculated based on product number.",
                "UnitNotFound", EsLogLevel.DEBUG);

        addException(ht, 405, els, "Using product synonym for product number (synonym/original): %s ; %s",
                "DataContent", EsLogLevel.DEBUG);

        addException(ht, 408, els, "The UnitList was truncated, there were more units than we have " +
                        "returned in the list",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 410, els, "Product is BornOnDate type, but no ServiceId was provided",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 411, els, "Product is BornOnDate type, but could not calculate born_on_date from ServiceId: %s",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 412, els, "Purchase date is earlier than the shipment: %s ; %s",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 413, els, "Purchase date is more than six months later than shipment: %s ; %s",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 414, els, "Registration date is earlier than the shipment or manufacture date: %s ; %s",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 415, els, "Registration date is more than six months later than shipment or manufacture date: %s ; %s",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 416, els, "Failed to decode manufacture_date from the serial number",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 417, els, "The manufacture_date decoded from the serial number is invalid",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 418, els, "Inaccurate warranty start date (based on introduction date), provide " +
                        "additional dates for start date calculation",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 420, els, "Product is consumer product but no consumer logic has been used, " +
                        "only corporate warranty rules have been applied",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 421, els, "Product of unit found is not an exact match.",
                "UnitNotFound", EsLogLevel.DEBUG);

        addException(ht, 422, els, "Unit is tracked with inconsistent data in SWAT. Discarding SWAT data.",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 424, els, "Invalid KNIGHT result",
                "InvalidDataContent", EsLogLevel.FUNCTIONAL);

        addException(ht, 425, els, "Mandatory fields missing in KNIGHT result",
                "InvalidDataContent", EsLogLevel.FUNCTIONAL);

        addException(ht, 426, els, "Source System warning code and description: %s ; %s",
                "MissingDataContent", EsLogLevel.DEBUG);

        addException(ht, 427, els, "Invalid product number",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 428, els, "Care Pack not found",
                "DataNotFound", EsLogLevel.DEBUG);

        addException(ht, 429, els, "Warranty redetermined based on the country of service input parameter",
                "DataContent", EsLogLevel.DEBUG);

        addException(ht, 430, els, "Date code label not supported by SWOP",
                "InvalidDataContent", EsLogLevel.DEBUG);

        addException(ht, 431, els, "Some Care Pack/Bundled services start dates have been realigned with " +
                        "the warranty start date",
                "DataContent", EsLogLevel.DEBUG);

        addException(ht, 432, els, "Warranty calculated based on spare part number ",
                "DataContent", EsLogLevel.DEBUG);

        addException(ht, 433, els, "Input POP date not used",
                "DataContent", EsLogLevel.DEBUG);

        addException(ht, 434, els, "The following systems are not available: %s",
                "ExternalSystemUnavailable", EsLogLevel.DEBUG);
        
        addException(ht, 435, els, "this unit is tracked in multiple SWOP instances",
                "DataContent", EsLogLevel.DEBUG);
        
        addException(ht, 436, els, "Source System returned warning or error: %s ; %s ; %s",
                "MissingDataContent", EsLogLevel.DEBUG);        
        
        addException(ht, 437, els, "Field has been truncated: %s",
                "LargeDataContent", EsLogLevel.DEBUG);  
        
        
        addException(ht, 440, els, "This Unit is part of a parent bundle identified by SN/PN - %s/%s",
                "DataContent", EsLogLevel.DEBUG);  
        addException(ht, 441, els, "This Unit is a parent bundle",
                "DataContent", EsLogLevel.DEBUG);  
        
        //add by kangli
        /*
         * todo THIS WILL NEVER EVER WORKS
         */
        addException(ht, 438, els, "Warning for fraud: %s",
                "Fraud", EsLogLevel.DEBUG);
        
        
        /*
         * 3G exceptions
         */
        addException(ht, 450, els, "This product is subject to warranty 3G regulation, please request a POP " +
    			"date and Product Ownership Type ",
            "DataContent", EsLogLevel.DEBUG);
        
        addException(ht, 451, els, "This product is within 3G warranty regulation, main parts warranty differ from unit warranty",
            "DataContent", EsLogLevel.DEBUG);
        
        addException(ht, 452, els, "This unit has a part warranty, please request part level warranty ",
         "DataContent", EsLogLevel.DEBUG);
        
        addException(ht, 453, els, "This unit has an event history, please query the unit event history service ",
        "DataContent", EsLogLevel.DEBUG);

        addException(ht, 454, els, "This unit have a part warranty",
                "DataContent", EsLogLevel.DEBUG);

        /*
         * 

        addException(ht, 454, els, "This unit have a unit history, please query the unit event history service ",
                "DataContent", EsLogLevel.DEBUG);
        addException(ht, 455, els, "This unit have a unit history, please query the unit event history service ",
                "DataContent", EsLogLevel.DEBUG);        

        addException(ht, 457, els, "This unit have a unit history, please query the unit event history service ",
                "DataContent", EsLogLevel.DEBUG);
         */
        
    }

    private static void add_INFORMATIONs(Hashtable<String, EsException> ht) {
        // none yet
    }

  /*  private static void add_DEBUGs(Hashtable ht) {
        // none yet
    }*/

    /**
     * HPSE is currently using the SifException for some internal signalling
     * (in lieu of a proper application exception like HpseException).  We
     * must use one of the known ErrorLevels, so we use WARNING, but we assign
     * the ErrorID range 8000-8999 for internal errors.  The 8000 errors should
     * never exit HPSE services, and so should be logged and translated to 9999
     * at HPSEServiceHandler level.
     *
     * @param   ht the error "catalog" to which we will add our errors.
     *
     * @see #isHpseInternal(EIAError)
     * @see #isHpseInternal(SifException)
     */
    private static void add_HPSE_INTERNALs(Hashtable<String, EsException> ht) {
        String els = ErrorLevelType.WARNING.toString(); // reusing WARNING -- we need a known level

        addException(ht, 8000, els, "Timeout occurred while accessing system: %s",
                "ExternalSystemUnavailable", EsLogLevel.DEBUG);

        addException(ht, 8001, els, "System not available: %s",
                "ExternalSystemUnavailable", EsLogLevel.DEBUG);

        addException(ht, 8020, els, "CORBA problem during binding: %s",
                "ExternalSystemUnavailable", EsLogLevel.DEBUG);

        addException(ht, 8021, els, "CORBA problem during request: %s",
                "ExternalSystemUnavailable", EsLogLevel.DEBUG);
     }

    /**
     * HPSE is currently using the SifException/EIAError for some internal signalling
     * (in lieu of a proper application exception like HpseException).  We
     * must use one of the known ErrorLevels, so we use DEBUG, but we assign
     * the ErrorID range 8000-8999 for internal errors.  This method is intended
     * to be the authoritative answer on whether the exception/error is "internal"
     * (do not test the error id yourself!).
     *
     * @param   err the EIAError to test
     * @return  boolean     Is the passed EIAError  "HPSE internal?"
     *
     */
    public static boolean isHpseInternal(EIAError err) {
        // we don't check for null parm, errorId, etc; let these RuntimeExceptions
        // go out as RuntimeExceptions

        int errorId = Integer.parseInt(err.getErrorID());
        return (errorId >= 8000) && (errorId < 9000);
    }

    /**
     * HPSE is currently using the SifException/EIAError for some internal signalling
     * (in lieu of a proper application exception like HpseException).  We
     * must use one of the known ErrorLevels, so we use DEBUG, but we assign
     * the ErrorID range 8000-8999 for internal errors.  This method is intended
     * to be the authoritative answer on whether the exception/error is "internal"
     * (do not test the error id yourself!).
     *
     * @param   ee    The SifException to test
     * @return  boolean     Is the passed SifException  "HPSE internal?"
     *
     */
    public static boolean isHpseInternal(SifException ee) {
        return isHpseInternal(convertSifException(ee));
    }

    // a testing main
    public static final void main(String args[]) {

        SifException ee, ee2;
        //EIAError err;

        // dump the catalog
        System.out.println("_____________ prototype catalog ______________________________________________");
        for (Enumeration<EsException> e = _SifExceptionPrototypes.elements(); e.hasMoreElements();) {
            ee = e.nextElement();
            System.out.println(SifExceptionAsString(ee));
        }


        // insure we are getting independent objects;
        // since all accesses pass by here, we only need to make this
        // test in this method.
        System.out.println("_____________ separate copies for returned objects? __________________________");

        ee = getSifException(100);
        ee.setDataPayload("First copy");
        ee2 = getSifException(100);
        ee2.setDataPayload("Second copy");
        System.out.println(SifExceptionAsString(ee));
        System.out.println(SifExceptionAsString(ee2));


        // test out the string parameter options for SifException
        System.out.println("_____________ string parms for SifException __________________________________");

        try {   // no string parms; this is legal, a programmer can take full responsibility
            // for filling in strings in an SifException or EIAError.
            ee = getSifException(ErrorFactory.id102_VERSION_NOT_SUPPORTED);
            System.out.println("SUCCESS (no string parms): " + SifExceptionAsString(ee));
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE (no string parms): caught runtime while trying getSifException(102)");
        }
        
        try {   // no string parms; this is legal, a programmer can take full responsibility
            // for filling in strings in an SifException or EIAError.
            ee = getSifException(ErrorFactory.id432_WARRANTY_CALCULATED_BASED_SPAREPARTNUMBER,"SWOP ERROR:1010");
            System.out.println("SUCCESS (1 string parms): " + SifExceptionAsString(ee));
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE (no string parms): caught runtime while trying getSifException(102)");
        }

        try {   // too few string parms; if any strings are passed, we assume all are
            // passed.  too few is an error.
            ee = getSifException(ErrorFactory.id102_VERSION_NOT_SUPPORTED, "FirstParm");
            System.out.println("FAILURE: should have caught 'too few' runtime for " + SifExceptionAsString(ee));
        }
        catch (RuntimeException re) {
            System.out.println("SUCCESS (too few parms): getSifException(102, FirstParm)");
        }

        try {   // minimum string parms; covers ErrorText only
            ee = getSifException(ErrorFactory.id102_VERSION_NOT_SUPPORTED, "FirstParm", "SecondParm");
            System.out.println("SUCCESS (minimum parms): " + SifExceptionAsString(ee));
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE (minimum parms): caught runtime while trying getSifException(102, FirstParm, SecondParm)");
        }

        try {   // maximum string parms; covers ErrorText and DataPayLoad
            ee = getSifException(ErrorFactory.id102_VERSION_NOT_SUPPORTED, "FirstParm", "SecondParm", "ThirdParm");
            System.out.println("SUCCESS (maximum parms): " + SifExceptionAsString(ee));
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE (maximum parms): caught runtime while trying getSifException(102, FirstParm, SecondParm, ThirdParm)");
        }

        try {   // too many string parms
            ee = getSifException(ErrorFactory.id102_VERSION_NOT_SUPPORTED, "FirstParm", "SecondParm", "ThirdParm", "FourthParm");
            System.out.println("FAILURE: should have caught 'too many' runtime for " + SifExceptionAsString(ee));
        }
        catch (RuntimeException re) {
            System.out.println("SUCCESS (too many parms): getSifException(102, FirstParm, SecondParm, ThirdParm, FourthParm");
        }

        // test out the string parameter options for EIAError
        System.out.println("_____________ string parms for EIAError ______________________________________");
        try {   // no string parms; this is legal, a programmer can take full responsibility
            // for filling in strings in an SifException or EIAError.
        	getEIAError(ErrorFactory.id100_SERVICE_UNREACHABLE);
            System.out.println("SUCCESS (no string parms): getEIAError(100)");
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE (no string parms): caught runtime while trying getEIAError(100)");
        }


        // 'too few string parms' case does not exist; one is enough


        try {   // minimum string parms; covers ErrorText only
        	getEIAError(ErrorFactory.id100_SERVICE_UNREACHABLE, "FirstParm");
            System.out.println("SUCCESS (minimum parms): getEIAError(100, FirstParm)");
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE (minimum parms): caught runtime while trying getEIAError(100, FirstParm)");
        }

        try {   // maximum string parms; covers ErrorText and DataPayLoad
        	getEIAError(ErrorFactory.id100_SERVICE_UNREACHABLE, "FirstParm", "SecondParm");
            System.out.println("SUCCESS (minimum parms): getEIAError(100, FirstParm, SecondParm)");
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE (minimum parms): caught runtime while trying getEIAError(100, FirstParm, SecondParm)");
        }
        
        try {   // maximum string parms; covers ErrorText and DataPayLoad
        	getEIAError(ErrorFactory.id432_WARRANTY_CALCULATED_BASED_SPAREPARTNUMBER,"SWOP ERROR:1010");
            System.out.println("SUCCESS (minimum parms): getEIAError(id432_WARRANTY_CALCULATED_BASED_SPAREPARTNUMBER, FirstParm, SecondParm)");
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE id432_WARRANTY_CALCULATED_BASED_SPAREPARTNUMBER (minimum parms): caught runtime while trying getEIAError(100, FirstParm, SecondParm)");
        }

        try {   // too many string parms
        	getEIAError(ErrorFactory.id100_SERVICE_UNREACHABLE, "FirstParm", "SecondParm", "ThirdParm");
            System.out.println("FAILURE: should have caught 'too many' runtime for getEIAError(100, FirstParm, SecondParm, ThirdParm)");
        }
        catch (RuntimeException re) {
            System.out.println("SUCCESS (too many parms): getEIAError(100, FirstParm, SecondParm, ThirdParm)");
        }
/*
*/

        // test out the 9999
        System.out.println("_____________ string parms for 9999 _________________________________________");

        try {   // no string parms
            ee = getSifException(ErrorFactory.id9999_INTERNAL_ERROR);
            System.out.println("SUCCESS (no string parms): " + SifExceptionAsString(ee));
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE (no string parms): caught runtime while trying getSifException(9999)");
        }

        // 'too few' parms case does not exist

        // 'minimum parms' case is the zero string parms case above

        try {   // maximum parms case
            ee = getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "FirstParm");
            System.out.println("SUCCESS (maximum string parms): " + SifExceptionAsString(ee));
        }
        catch (RuntimeException re) {
            System.out.println("FAILURE (maximum string parms): caught runtime while trying getSifException(9999, FirstParm)");
        }

        try {   // too many string parms
            ee = getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "FirstParm", "SecondParm");
            System.out.println("FAILURE: should have caught 'too many' runtime for " + SifExceptionAsString(ee));
        }
        catch (RuntimeException re) {
            System.out.println("SUCCESS (too many parms): getSifException(9999, FirstParm, SecondParm)");
        }
    }
}
