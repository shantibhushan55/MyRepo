/**
 * 
 */
package com.hp.es.service.contractEntitlement.orchestration;

import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.EntitlementByPnRequest;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.types.ContractIdentifierTypeType;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
class ContractScenario {

	public static final int ODS_ONLY_SCENARIO = 1;
	public static final int CQS_ONLY_SCENARIO = 2;
	public static final int CQS_AND_ODS_SCENARIO = 3;
	private static ContractScenario _instance = new ContractScenario();
	

	/**
	 * Constructor
	 */
	private ContractScenario() {
		super();
	}

	/*
	 * This method return a singleton for the class
	 * @return a singleton
	 */
	public static ContractScenario getInstance() {
		return _instance;
	}

	/*
	 * This is the method that find the right contract Scenario
	 * Scenarios are defined in the constant list of this class
	 * @param a Contract Request
	 * @return a scenario
	 */
	private int determineContractScenario(ContractRequest request) throws SifException {
		
		if((request == null)|| 
		   (request.getContractIdentifierType() == null) &&
		   ((request.getContractIdentifier() == null)|| 
		   (request.getContractIdentifier().length()== 0)))  {
			throw ErrorFactory.getSifException(
					ErrorFactory.id9999_INTERNAL_ERROR,
					"The determineContractScenario was not correctly used.");
		}
		
		// No ContractIdentifierType
		if(request.getContractIdentifierType() == null) {
			return CQS_AND_ODS_SCENARIO;
		}
		// ContractIdentifierType = FunctionalLocation 
		// ContractIdentifierType = CCRN
		if(request.getContractIdentifierType().equals(ContractIdentifierTypeType.FUNCTIONALLOCATION) ||
		   request.getContractIdentifierType().equals(ContractIdentifierTypeType.CCRN))			{
			return CQS_AND_ODS_SCENARIO;
		}
		// ContractIdentifierType = CDID
		if(request.getContractIdentifierType().equals(ContractIdentifierTypeType.CUSTOMERDEFINEDID)){
			return CQS_ONLY_SCENARIO;
		}
		// ContractIdentifierType = SAID AND ContractIdentifier does NOT start with 9
		if(request.getContractIdentifierType().equals(ContractIdentifierTypeType.SVCAGREEMENTID) &&
				!request.getContractIdentifier().startsWith("9")) {
			return CQS_ONLY_SCENARIO;
		}
		
		return ODS_ONLY_SCENARIO;
		
	}
	
	/*
	 * This is the method that find the right contract Scenario
	 * Scenarios are defined in the constant list of this class
	 * @param a Contract Request
	 * @return a scenario
	 */
	private int determineContractScenario(EntitlementBySnRequest request) throws SifException {
		
		if(request.getContractIdentifierType() == null || request.getContractIdentifier() == null) {
			return CQS_AND_ODS_SCENARIO;
		}
		
		if(request.getContractIdentifierType().equals(ContractIdentifierTypeType.FUNCTIONALLOCATION) ||
				   request.getContractIdentifierType().equals(ContractIdentifierTypeType.CCRN))			{
			return CQS_AND_ODS_SCENARIO;
		}
		
		if(request.getContractIdentifierType().equals(ContractIdentifierTypeType.SVCAGREEMENTID) ){
			return CQS_ONLY_SCENARIO;
		}
		
		
		return ODS_ONLY_SCENARIO;
	}

	/*
	 * This is the method that find the right contract Scenario
	 * Scenarios are defined in the constant list of this class
	 * @param a Contract Request
	 * @return a scenario
	 */
	private int determineContractScenario(EntitlementByPnRequest request) throws SifException {
		
		if((request == null)|| 
		   (request.getContractIdentifierType() == null) &&
		   ((request.getContractIdentifier() == null)|| 
		   (request.getContractIdentifier().length()== 0)))  {
			throw ErrorFactory.getSifException(
					ErrorFactory.id9999_INTERNAL_ERROR,
					"The determineContractScenario was not correctly used.");
		}
		
		if(request.getContractIdentifierType().equals(ContractIdentifierTypeType.FUNCTIONALLOCATION) ||
				   request.getContractIdentifierType().equals(ContractIdentifierTypeType.CCRN))			{
			return CQS_AND_ODS_SCENARIO;
		}
		
		if(request.getContractIdentifierType().equals(ContractIdentifierTypeType.SVCAGREEMENTID) ||
		   request.getContractIdentifierType().equals(ContractIdentifierTypeType.CUSTOMERDEFINEDID)){
			return CQS_ONLY_SCENARIO;
		}
		
		
		return ODS_ONLY_SCENARIO;
	}	
	
	/*
	 * This is the method that find the right contract Scenario
	 * Scenarios are defined in the constant list of this class
	 * @param a Contract Request
	 * @return a scenario
	 */
	public int determineContractScenario(EsRequestComplexType request, boolean cqsEnable, boolean odsEnable) throws SifException {
		if(request == null) {
			throw ErrorFactory.getSifException(
					ErrorFactory.id9999_INTERNAL_ERROR,
					"The determineContractScenario was not correctly used.");			
		}
		if((cqsEnable && odsEnable) || (!cqsEnable && !odsEnable)) {
			if(request.getEsRequestComplexTypeChoice().getContractRequest() != null) {
				return determineContractScenario(request.getEsRequestComplexTypeChoice().getContractRequest());
			}
	
			if(request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest() != null) {
				return determineContractScenario(request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest());
			}
			
			
			// TODO: Not NEEDED !!
			if(request.getEsRequestComplexTypeChoice().getEntitlementByPnRequest() != null) {
				return determineContractScenario(request.getEsRequestComplexTypeChoice().getEntitlementByPnRequest());
			}		
			return ODS_ONLY_SCENARIO;
		}else if(odsEnable) {
			return ODS_ONLY_SCENARIO;
			
		}else  {
			return CQS_ONLY_SCENARIO;
		}
	}	
}
