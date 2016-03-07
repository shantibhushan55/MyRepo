package com.hp.es.service;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.sif.SifException;

/**
 * A lot of garbage input that are sent to ES. This class is used to verify
 * ProductNumber in ES requst. If the invalid ProductNumber is found, the error
 * message ErrorFactory.id120_INVALID_REQUEST will be sent back.
 * 
 * @author
 * 
 */
public class ProductNumberValidator {
	/**
	 * Consider any PN as invalid if the length is greater than maximum value.
	 * 
	 * @param productNumber
	 * @param maximum
	 * @throws SifException
	 */
	public static void verifyProductNumberGreaterThan(String productNumber,
			int maximum) throws SifException {
		ESLog.debug("ENTRY");
		if (productNumber != null && (productNumber.trim().length() != 0)) {
			if (productNumber.trim().length() > maximum) {
				ESLog.debug("Invalid product number: the length of ["
						+ productNumber + "] is greater than " + maximum);
				throw ErrorFactory
						.getSifException(ErrorFactory.id120_INVALID_REQUEST,
								"Invalid product number: the length of "
										+ productNumber + " is greater than "
										+ maximum);
			}
			ESLog.debug("EXIT");
		}
	}
}
