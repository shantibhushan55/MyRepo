package com.hp.es.service.catsAgreement.integration.mapping;

import com.hp.es.service.catsAgreement.orchestration.CatsAgreementTransaction;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EIAError;

public abstract class ErrorMapper {

    protected CatsAgreementTransaction _transaction;

    protected ErrorMapper(CatsAgreementTransaction transaction) {
        _transaction = transaction;
    }

    public static ErrorMapper getInstance(CatsAgreementTransaction transaction) {
            return new MetroErrorMapper(transaction);
    }

    /**
     * map
     * 
     * @return
     * @throws MappingException
     */
    abstract public EIAError map() throws MappingException;

    /**
     * All ASTRO2 error are mapped to EIAError. This means the transaction.mappedError is composed by EIAError, instead of SifException.
     * 
     * @param errorCode
     * @param errorMessage
     * @return
     */
    protected EIAError getError(String errorCode, String errorMessage) {
        if (errorCode == null || errorCode.trim().equals("") || errorCode.trim().equals("0"))
            return null;

        if (errorCode.equals("2503")) {
            return ErrorFactory.getEIAError(ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA, "ASTRO2 " + errorCode + ": " + errorMessage);
        }
        if (errorCode.equals("2507")) {
            return ErrorFactory.getEIAError(ErrorFactory.id200_MISSING_PARAMETER, "CountryCode", "ASTRO2 " + errorCode + ": "
                    + errorMessage);
        }
        if (errorCode.equals("2508")) {
            return ErrorFactory.getEIAError(ErrorFactory.id200_MISSING_PARAMETER, "ProductNumber", "ASTRO2 " + errorCode + ": "
                    + errorMessage);
        }

        if (errorCode.equals("2509")) {
            return ErrorFactory.getEIAError(ErrorFactory.id200_MISSING_PARAMETER, "SerialNumber", "ASTRO2 " + errorCode + ": "
                    + errorMessage);
        }
        if (errorCode.equals("2510")) {
            return ErrorFactory
                    .getEIAError(ErrorFactory.id200_MISSING_PARAMETER, "ClientType", "ASTRO2 " + errorCode + ": " + errorMessage);
        }

        if (errorCode.equals("5007") || errorCode.equals("5017")) {
            return ErrorFactory.getEIAError(ErrorFactory.id300_NO_DATA_FOUND, "ASTRO2 " + errorCode + ": " + errorMessage);
        }
        if (errorCode.equals("5014")) {
            return ErrorFactory.getEIAError(ErrorFactory.id427_INVALID_PRODUCT_NUMBER, "ASTRO2 " + errorCode + ": " + errorMessage);
        }
        if (errorCode.equals("5020")) {
            return ErrorFactory.getEIAError(ErrorFactory.id401_WRONG_INPUT_DATA, "ASTRO2 " + errorCode + ": " + errorMessage);
        }
        if (errorCode.equals("5012")) {
            return ErrorFactory.getEIAError(ErrorFactory.id417_SERIAL_NR_DECODE_INVALID, "ASTRO2 " + errorCode + ": " + errorMessage);
        }
        if (errorCode.equals("5001") || errorCode.equals("5004") || errorCode.equals("5005") || errorCode.equals("2502")
                || errorCode.equals("2504") || errorCode.equals("2505") || errorCode.equals("2506") || errorCode.equals("0011")) {
            return ErrorFactory.getEIAError(ErrorFactory.id426_SOURCESYSTEM_RETURNED_WARNING, errorCode, "ASTRO2 " + errorCode + ": "
                    + errorMessage, errorMessage);
        }

        if (errorCode.equals("5010")) {
            return ErrorFactory.getEIAError(ErrorFactory.id413_REG_PURCHASE_DATE_TOO_LATE, errorCode, "ASTRO2 " + errorCode + ": "
                    + errorMessage);
        }
        if (errorCode.equals("5011")) {
            return ErrorFactory.getEIAError(ErrorFactory.id412_REG_PURCHASE_DATE_TOO_EARLY, errorCode, "ASTRO2 " + errorCode + ": "
                    + errorMessage);
        }

        // In case an unknown error or warning code is returned, the code is mapped to the warning
        // 426 and the unknown error code from ASTRO2 added into the DataPayLoad of the message.
        return ErrorFactory.getEIAError(ErrorFactory.id426_SOURCESYSTEM_RETURNED_WARNING, errorCode, "ASTRO2 " + errorCode + ": "
                + errorMessage, errorMessage);

    }
}
