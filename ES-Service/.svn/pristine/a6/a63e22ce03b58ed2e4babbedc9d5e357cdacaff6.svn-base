/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 30-Aug-02
 * Time: 06:51:57
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 *
 * Project: Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/util/ESLog.java 1.27 2004-09-27 17:57:44+02 stefsobe Exp $
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
 * @author Dave Frey
 *
 * $Log: ESLog.java,v $
 * Revision 1.27  2004-09-27 17:57:44+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.26  2004-05-08 04:42:16+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.25  2004-05-05 15:41:04+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.24  2004-02-23 12:02:02+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * added logging to file in method logITO to have the message also
 * in our log file. This feature was switched off in EIA-SF 3.7
 *
 * Revision 1.23  2004-02-04 20:26:27+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * removed exceptionCategory because it doesn't exist anymore in

 * EIA-SF 3.7
 *
 * Revision 1.22  2004-02-02 10:24:25+01  JUHANK
 * Author: JUHANK@hankejuergen.emea.hpqcorp.net ()
 * updated to use EIA-SF 3.7
 *
 * Revision 1.21  2004-01-29 18:06:48+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.20  2003-11-17 15:29:48+01  lbednari
 * Author: lbednari@dhcp-15-197-230-177.bbn.hp.com ()
 * - log method for ITO was not logging to ITO
 *
 * Revision 1.19  2003-08-25 16:48:46+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * move functionality to EiaLog class and keep ESLog as wrapper around

 * EsLogLevel. This was needed in order to avoid duplication of code for AcmeLog.

 *
 * Revision 1.18  2003-08-04 16:51:11+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.17  2003-07-10 13:41:28+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * add logStats for statistic logging
 *
 * Revision 1.16  2003-07-01 23:13:50+02  lbednari
 * Author: lbednari@bbnnaid62.bbn.hp.com ()
 * - corrected JavaDoc
 *
 * Revision 1.15  2003-07-01 21:46:11+02  lbednari
 * Author: lbednari@bbnnaid62.bbn.hp.com ()
 * - removed handling of separate statistics log file
 *
 * Revision 1.14  2003-06-17 15:00:15+02  stefsobe
 * Author: stefsobe@dhcp-15-197-230-142.bbn.hp.com ()
 * checkin HPSEConstants with EsConstants; add isDebugLogEnabled()
 *
 * Revision 1.13  2003-06-11 15:35:34+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * new log() method to support LOG calls with an ITO number
 *
 * Revision 1.12  2003-05-12 01:59:29+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.11  2003-03-26 15:23:19+01  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * make logITO public
 *
 * Revision 1.10  2003-03-25 17:21:09+01  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * make logITO() public
 *
 * Revision 1.9  2003-03-25 17:02:09+01  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * add log method for exception logging
 *
 * Revision 1.8  2003-03-21 16:30:40+01  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * better implementation of hiding/reserving 'logITO()" for future use
 *
 * Revision 1.7  2003-02-26 15:33:22+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.6  2003-01-22 15:27:46+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.5  2003-01-20 11:41:38+01  JUHANK
 * Author: JUHANK@dhcp-15-198-6-163.bbn.hp.com ()
 * - added transaction logging
 *
 * Revision 1.4  2002-11-14 20:53:21+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * hiding logITO() until we know how to use it
 *
 * Revision 1.3  2002-11-05 10:35:01+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * now correctly translating severity => int
 *
 * Revision 1.2  2002-10-09 14:59:45+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * added a logITO()
 *
 * Revision 1.1  2002-10-07 15:26:06+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * first draft of central logging class
 *
 *
 */
package com.hp.es.service.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.exception.EsException;
import com.hp.sif.SifException;
import com.hp.sif.logging.logger.SifLogger;
import com.hp.sif.logging.utils.LoggingUtilities;

/**
 * This class is just a wrapper around EsLogLevel. It provides static methods
 * to access the EsLogLevel.
 */
public class ESLog {

    // create the loggers
	private static final SifLogger sifLogger = SifLogger.getInstance();

	static {
		String log4jFileName = null;  
	    try {
	    	log4jFileName = System.getProperty("log4j.configuration", EsConstants.ES_LOG4J_PROPERTIES);
	        // load the es specific logging configuration
	        LoggingUtilities.loadLog4jConfiguration(log4jFileName); 
	    } catch(Exception e) {
	    	sifLogger.log(SifLogger.SIF_LOGGER_NAME, "Unable to load the file: " + log4jFileName,
	            "EsLog - Constructor", 0, EsLogLevel.FUNCTIONAL);
	    }
	}
	
	
    /**
     * Log a debug message to the log file
     * @param text  the text which is logged to the log file
     */
    public static void debug(String text) {
        if (isDebugLogEnabled()) {
        	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, getCallingMethod(), 0, EsLogLevel.DEBUG);
        }
    }

    /**
     * Log a debug message to the log file
     * @param text  the text which is logged to the log file
     * @param t        the exception which will be logged to the file
     */
    public static void debug(String text, Throwable t) {
        if (isDebugLogEnabled()) {
        	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, getCallingMethod(), 0, EsLogLevel.DEBUG);
        	sifLogger.log(EsConstants.FILE_LOGGER_NAME, t, getCallingMethod(), 0, EsLogLevel.DEBUG);
        }
    }

    /**
     * Log a warn message to the log file
     * @param text  the text which is logged to the log file
     */
    public static void warn(String text)  {
    	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, getCallingMethod(), 0, EsLogLevel.WARNING);
    }
    
    /**
     * Log a info message to the log file
     * @param text  the text which is logged to the log file
     */
    public static void info(String text)  {
    	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, getCallingMethod(), 0, EsLogLevel.INFORMATION);
    }

    /**
     * Log a info message to the log file
     * @param text  the text which is logged to the log file
     * @param t        the exception which will be logged to the file
     */
    public static void info(String text, Throwable t)  {
    	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, getCallingMethod(), 0, EsLogLevel.INFORMATION);
    	sifLogger.log(EsConstants.FILE_LOGGER_NAME, t, getCallingMethod(), 0, EsLogLevel.INFORMATION);
    }

    /**
     * Log a text into the statistics log file
     * @param text the text which is logged to the log file
     */
    public static void logStats(String text)  {
    	sifLogger.log(EsConstants.STATISTICS_LOGGER_NAME, text, getCallingMethod(), 0, EsLogLevel.INFORMATION);
    }

    /**
     * Log a error (functional) message to the log file
     * @param text  the text which is logged to the log file
     */
    public static void error(String text)  {
    	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, getCallingMethod(), 0, EsLogLevel.FUNCTIONAL);
    }

    /**
     * Log a error (functional) message to the log file
     * @param text  the text which is logged to ITO and the log file
     * @param t        the exception which will be logged to the file
     */
    public static void error(String text, Throwable t)  {
    	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, getCallingMethod(), 0, EsLogLevel.FUNCTIONAL);
    	sifLogger.log(EsConstants.FILE_LOGGER_NAME, t, getCallingMethod(), 0, EsLogLevel.FUNCTIONAL);
    }

    /**
     * Log a message to ITO and the log file. The severity is determined
     * from the ItoError object.
     * @param id    the ItoError (should never be null)

    public static void logITO(ItoError id) {
        logITO(id, null, null);
    }
         */

    /**
     * Log a message to ITO and the log file. The severity is determined
     * from the ItoError object.
     * @param id    the ItoError (should never be null)
     * @param text  the text which is only logged to the log file

    public static void logITO(ItoError id, String text) {
        logITO(id, text, null);
    }
    */

    /**
     * Log a message to ITO and the log file. The severity is determined
     * from the ItoError object.
     * @param id    the ItoError (should never be null)
     * @param t        the exception which will only be logged to the file

    public static void logITO(ItoError id, Throwable t) {
        logITO(id, null, t);
    }
     */
    /**
     * Log a message to ITO and the log file. The severity is determined
     * from the ItoError object.
     * @param id    the ItoError (should never be null)
     * @param text  the text which is only logged to the log file
     * @param t        the exception which will only be logged to the file

    public static void logITO(ItoError id, String text, Throwable t)  {
        final String callingMethod = getCallingMethod();
        // the id should never be null. Warning should always have an ITO error code
        if (id == null) {
        	sifLogger.log(EsConstants.FILE_LOGGER_NAME, "Cannot log following message to ITO because the ITO error code is missing.",
        			callingMethod, 0, EsLogLevel.WARNING);
            if (t == null) {
            	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, callingMethod, 0, EsLogLevel.WARNING);
            } else {
            	sifLogger.log(EsConstants.FILE_LOGGER_NAME, t, callingMethod, 0, EsLogLevel.WARNING);
            }
        } else {
        	sifLogger.log(EsConstants.FILE_LOGGER_NAME, id.getText(), callingMethod, id.getId(), id.getSeverity());

            // additionally log the text and the exception (if available)
            if (t != null || text != null) {
                if (t != null) {
                	sifLogger.log(EsConstants.FILE_LOGGER_NAME, t, callingMethod, id.getId(), id.getSeverity());
                } else {
                	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, callingMethod, id.getId(), id.getSeverity());
                }
            }
        }
    }
    */
    /**
     * The method logs an SifException. The severity is determined by the SifException,
     * which is indeed a EsException.
     * @see ErrorFactory
     * @param e
     */
    public static void log(SifException e) {
        log(e, "");
    }

    /**
     * The ErrorFactory creates EsExceptions instead of SifExceptions. The EsException
     * stores the log level for the current SifException. I.e. the log level can be different
     * from the error level in the SifException.
     * @param e
     * @param string
     */
    public static void log(SifException e, String text) {
        if (e != null && e instanceof EsException) {
            int logLevel = ((EsException)e).getLogLevel();
            if (logLevel != EsLogLevel.DEBUG || isDebugLogEnabled()) {
            	String callingMethod = getCallingMethod();
                // Note: First write the text and then create an additional line for
                // the exception
            	sifLogger.log(EsConstants.FILE_LOGGER_NAME, text, callingMethod, 0, logLevel);
            	sifLogger.log(EsConstants.FILE_LOGGER_NAME, "Following SifException occured:",
            			callingMethod, 0, logLevel);
            	sifLogger.log(EsConstants.FILE_LOGGER_NAME, e, callingMethod, 0, logLevel);
            }
        }
        else {
            error(text, e);
        }
    }

    /**
     * @return true if the debug level is enabled
     */
    public static boolean isDebugLogEnabled() {
    	return sifLogger.isDebugEnabled(EsConstants.FILE_LOGGER_NAME);
    }

    /**
     * Find the method that has called the public static methods of this
     * class. With Java 1.3, we have to print the stack trace and search for
     * the calling method.
     *
     * TODO: With Java 1.4 we can use following approach, which seems to have
     * a better performance:
     * <pre>
     *        Exception e = new Exception();
     *        StackTraceElement[] elems = e.getStackTrace();
     *        ...
     *         String callerMethodName = elems[index].getMethodName();
     * </pre>
     * @return
     */
    private static String getCallingMethod() {
        StringWriter sw = new StringWriter();
        try {
            Exception e = new Exception();
            e.printStackTrace(new PrintWriter(sw));
            String stackTrace = sw.getBuffer().toString();

            // find the first method in the stack trace that doesn't
            // belong to the current class
            int start = -4;
            do {
                start = stackTrace.indexOf("\tat ", start + 4);
                if ( !stackTrace.startsWith("com.hp.es.service.util.ESLog.", start + 4)) {
                    break;
                }
            }
            while (start>0);

            if (start > 0) {
                String method = null;

                // in debug mode display the method in the format "method(line number)"
                if (isDebugLogEnabled()) {
                    int end = stackTrace.indexOf(')', start);
                    if (end >= 0) {
                        method = stackTrace.substring(start + 4, end + 1);
                        if (method.endsWith("Unknown Source)")) {
                            // then use the standard format below
                            method = null;
                        }
                    }
                }

                // just display "method()"
                if (method==null) {
                    int end = stackTrace.indexOf('(', start);
                    if (end >= 0) {
                        method = stackTrace.substring(start + 4, end) + "()";
                    }
                }
                
                return method;
            }
        }
        finally {
            try {} catch (Exception e) {}
        }

        return "unknown";
    }
}
