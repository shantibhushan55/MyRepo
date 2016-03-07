/*
 * Project: HPS Entitlement Service - Mercury Integration
 *
 * Copyright (c) 2007 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * Revision 1.0  
 * Author: olcay.yesilyurt@hp.com
 * Initial revision
 *
 */
package com.hp.es.service.contractSummary.orchestration;

import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.ContractSummaryRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
class ContractSummaryScenario {

	public static final int ODS_ONLY_SCENARIO = 1;
	public static final int CQS_ONLY_SCENARIO = 2;
	public static final int CQS_AND_ODS_SCENARIO = 3;
	private static ContractSummaryScenario _instance = new ContractSummaryScenario();

	
	/**
	 * Constructor
	 */
	protected ContractSummaryScenario() {
		super();
	}

	
	/*
	 * This method return a singleton for the class
	 * @return a singleton
	 */
	public static ContractSummaryScenario getInstance() {
		return _instance;
	}

	
	/*
	 * This is the method that find the right contract Scenario for contract summary operation
	 * Scenarios are defined in the constant list of this class
	 * @param a Contract Request
	 * @return a scenario
	 */
	private int determineContractSummaryScenario(ContractSummaryRequest request) throws SifException {
		if((request == null)||
		   (request.getSvcAgreementID() == null) ||
		   (request.getSvcAgreementID().length() == 0)){
			throw ErrorFactory.getSifException(
					ErrorFactory.id9999_INTERNAL_ERROR,
					"The determineContractScenario was not correctly used.");			
		}
		
		// ContractIdentifierType = CDID
		if(request.getIncludeCustomerIndicator() == false){
			return CQS_ONLY_SCENARIO;
		}
		
		// first, determine from which source systems the fields have to be gattered!!!
		return CQS_AND_ODS_SCENARIO;
	}	

	/*
	 * This is the method that find the right contract Scenario
	 * Scenarios are defined in the constant list of this class
	 * @param a Contract Request
	 * @return a scenario
	 */
	public int determineContractSummaryScenario(EsRequestComplexType request, boolean cqsEnable, boolean odsEnable) throws SifException {
		if(request == null) {
			throw ErrorFactory.getSifException(
					ErrorFactory.id9999_INTERNAL_ERROR,
					"The determineContractScenario was not correctly used.");			
		}
		if((cqsEnable && odsEnable) || (!cqsEnable && !odsEnable)) {
			
			// Determine the contract summary scenario
			if(request.getEsRequestComplexTypeChoice().getContractSummaryRequest() != null) {
				return determineContractSummaryScenario(request.getEsRequestComplexTypeChoice().getContractSummaryRequest());
			}
			
			return ODS_ONLY_SCENARIO;
		}else if(odsEnable) {
			return ODS_ONLY_SCENARIO;
			
		}else  {
			return CQS_ONLY_SCENARIO;
		}
	}	
	
}
