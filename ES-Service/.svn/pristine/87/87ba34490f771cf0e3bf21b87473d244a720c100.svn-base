package com.hp.es.service;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.compliancevalidation.ComplianceValidationHelper;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.sif.SifException;


/**
 * A lot of garbage input that are sent to ES. This class is used to verify SerialNumber in ES requst. If the invalid SerialNumber is found,
 * the error message ErrorFactory.id120_INVALID_REQUEST will be sent back.
 * 
 * @author wangwchu
 * 
 */
public class SerialNumberValidator {
	 

    /**
     * Verify whether the serialNumber is invalid.
     * <p>
     * The complete list of invalid serial number is defined in EntitlementService.properties.
     * 
     * @param serialNumber
     * @throws SifException
     *             if the serialNumber is included in invalid serial number list.
     */
    public static void verifyInvalidSerialNumber(String serialNumber) throws SifException {
        ESLog.debug("ENTRY");

        if (serialNumber == null || serialNumber.trim().length()==0)
            return;
        serialNumber = serialNumber.trim().toUpperCase();
        String invalidSNs = Configuration.getInstance().getProperties().getProperty(EsConstants.ES_INVALID_SN);

        if (invalidSNs != null && invalidSNs.trim().length() > 0) {
            invalidSNs = "," + invalidSNs.trim().toUpperCase() + ",";
            if (invalidSNs.contains("," + serialNumber + ",")) {
                ESLog.error("Invalid serial number: [" + serialNumber + "]");
                //throw ErrorFactory.getSifException(ErrorFactory.id120_INVALID_REQUEST, "Invalid serial number: " + serialNumber);
                throw ComplianceValidationHelper.getInstance().generateSifExceptionForInvalidSn();
            }
        }
        ESLog.debug("EXIT");

    }

    /**
     * If the serialNumber starts with an invalid prefix, the serial number can be considered as invalid.
     * <p>
     * The complete list of invalid prefix of serial number is defined in EntitlementServices.properties.
     * 
     * @param serialNumber
     * @throws SifException
     *             if the serialNumber starts with a invalid prefix.
     */
    public static void verifyInvalidSerialNumberPrefix(String serialNumber) throws SifException {
        ESLog.debug("ENTRY");
        if (serialNumber == null || serialNumber.trim().length()==0)
            return;
        serialNumber = serialNumber.trim().toUpperCase();
        String invalidSNPrefixs = Configuration.getInstance().getProperties().getProperty(EsConstants.ES_INVALID_SN_PREFIX);
        if (invalidSNPrefixs != null && invalidSNPrefixs.trim().length() > 0) {
            String[] prefixArray = invalidSNPrefixs.trim().toUpperCase().split(",");
            for (String prefix : prefixArray) {
                if (prefix != null && (prefix.trim().length() > 0) && serialNumber.startsWith(prefix.trim())) {
                    ESLog.debug("Invalid prefix of serial number: [" + serialNumber + "]");
                    throw ComplianceValidationHelper.getInstance().generateSifExceptionForInvalidSn();
                }
            }
        }
        ESLog.debug("EXIT");
    }
    
    /**
     * If the serialNumber ends with an invalid suffix , the serial number can be considered as invalid.
     * <p>
     * The complete list of invalid suffix  of serial number is defined in EntitlementServices.properties.
     * 
     * @param serialNumber
     * @throws SifException
     *             if the serialNumber ends with a invalid suffix.
     */
    public static void verifyInvalidSerialNumberSuffix (String serialNumber) throws SifException {
        ESLog.debug("ENTRY");
        if (serialNumber == null || serialNumber.trim().length()==0)
            return;
        serialNumber = serialNumber.trim().toUpperCase();
        String invalidSNSuffixs = Configuration.getInstance().getProperties().getProperty(EsConstants.ES_INVALID_SN_SUFFIX);
        if (invalidSNSuffixs != null && invalidSNSuffixs.trim().length() > 0) {
            String[] suffixArray = invalidSNSuffixs.trim().toUpperCase().split(",");
            for (String suffix : suffixArray) {
                if (suffix != null && (suffix.trim().length() > 0) && serialNumber.endsWith(suffix.trim())) {
                    ESLog.debug("Invalid suffix of serial number: [" + serialNumber + "]");
                    throw ComplianceValidationHelper.getInstance().generateSifExceptionForInvalidSn();
                }
            }
        }
        ESLog.debug("EXIT");
    }

    /**
     * Consider any SN as invalid if the length is less than minimum value. 
     * 
     * @param serialNumber
     * @param minimum
     * @throws SifException
     */
    public static void verifySerialNumberLessThan(String serialNumber, int minimum) throws SifException {
        ESLog.debug("ENTRY");

        if (serialNumber == null || serialNumber.trim().length()==0)
            return;

        if (serialNumber.trim().length() < minimum) {
            ESLog.debug("Invalid serial number: the length of [" + serialNumber + "] is less than " + minimum);
            throw ErrorFactory.getSifException(ErrorFactory.id120_INVALID_REQUEST, "Invalid serial number: the length of " + serialNumber
                    + " is less than " + minimum);
        }
        ESLog.debug("EXIT");

    }

    /**
     * Consider any SN as invalid if the length is greater than maximum value.
     * @param serialNumber
     * @param maximum
     * @throws SifException
     */
    public static void verifySerialNumberGreaterThan(String serialNumber, int maximum) throws SifException {
        ESLog.debug("ENTRY");

        if (serialNumber == null || serialNumber.trim().length()==0)
            return;

        if (serialNumber.trim().length() > maximum) {
            ESLog.debug("Invalid serial number: the length of [" + serialNumber + "] is greater than " + maximum);
            throw ErrorFactory.getSifException(ErrorFactory.id120_INVALID_REQUEST, "Invalid serial number: the length of " + serialNumber
                    + " is greater than " + maximum);
        }
        ESLog.debug("EXIT");

    }
}
