package com.hp.es.service.contractEntitlement.orchestration;

import junit.framework.TestCase;

import com.hp.es.xml.service.ContractRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.types.ContractIdentifierTypeType;
import com.hp.sif.SifException;

public class ContractScenarioTest extends TestCase {

	public ContractScenarioTest() {
		super();
	}
	/*
	 * No need to construct anything
	 */
	public ContractScenarioTest(String arg0) {
		super(arg0);
	}
	
	
	public void  testDetermineContractScenarioWithNull() {
		//EsRequestComplexType request = null;
		
		try  {
			ContractScenario.getInstance().determineContractScenario(null, true, true);
			fail("We should have got an exception.");
			EsRequestComplexType request = new EsRequestComplexType();
			request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
			request.getEsRequestComplexTypeChoice().setContractRequest(new ContractRequest());

			ContractRequest cr = request.getEsRequestComplexTypeChoice().getContractRequest();			
			cr.setContractIdentifierType(ContractIdentifierTypeType.SVCAGREEMENTID);
			cr.setContractIdentifier(null);			
			int scenario = ContractScenario.getInstance().determineContractScenario(request, true, true);
			assertEquals("It should have been CQS & ODS", ContractScenario.CQS_AND_ODS_SCENARIO, scenario);

			cr.setContractIdentifierType(ContractIdentifierTypeType.FUNCTIONALLOCATION);
			cr.setContractIdentifier(null);			
			scenario = ContractScenario.getInstance().determineContractScenario(request, true, true);
			assertEquals("It should have been CQS & ODS", ContractScenario.CQS_AND_ODS_SCENARIO, scenario);
			
			cr.setContractIdentifierType(ContractIdentifierTypeType.FUNCTIONALLOCATION);
			cr.setContractIdentifier(null);			
			scenario = ContractScenario.getInstance().determineContractScenario(request, true, false);
			assertEquals("It should have been CQS & ODS", ContractScenario.ODS_ONLY_SCENARIO, scenario);

			cr.setContractIdentifierType(ContractIdentifierTypeType.FUNCTIONALLOCATION);
			cr.setContractIdentifier(null);			
			scenario = ContractScenario.getInstance().determineContractScenario(request, false, true);
			assertEquals("It should have been CQS & ODS", ContractScenario.ODS_ONLY_SCENARIO, scenario);			
		}catch(SifException e) {
			//assertTrue();
			
		}
	}
	
	public void  testDetermineContractScenarioWithODSONLY() {
		EsRequestComplexType request = new EsRequestComplexType();
		request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
		request.getEsRequestComplexTypeChoice().setContractRequest(new ContractRequest());

		ContractRequest cr = request.getEsRequestComplexTypeChoice().getContractRequest();
		try  {
			cr.setContractIdentifierType(ContractIdentifierTypeType.REDGROUPSERIALNO);
			cr.setContractIdentifier("123");			
			int scenario = ContractScenario.getInstance().determineContractScenario(request, true, true);
			assertEquals("It should have been ODS only", ContractScenario.ODS_ONLY_SCENARIO, scenario);

			
			cr.setContractIdentifierType(ContractIdentifierTypeType.HPCAREPACKSERIALNUMBER);
			cr.setContractIdentifier("123");			
			scenario = ContractScenario.getInstance().determineContractScenario(request, true, true);
			assertEquals("It should have been ODS only", ContractScenario.ODS_ONLY_SCENARIO, scenario);
			

			cr.setContractIdentifierType(ContractIdentifierTypeType.REDACCESSID);
			cr.setContractIdentifier("123");			
			scenario = ContractScenario.getInstance().determineContractScenario(request, true, true);
			assertEquals("It should have been ODS only", ContractScenario.ODS_ONLY_SCENARIO, scenario);			

			cr.setContractIdentifierType(ContractIdentifierTypeType.REDCONTRACTID);
			cr.setContractIdentifier("123");			
			scenario = ContractScenario.getInstance().determineContractScenario(request, true, true);
			assertEquals("It should have been ODS only", ContractScenario.ODS_ONLY_SCENARIO, scenario);
			/*
			*/			
		}catch(SifException e) {
			fail("We should not get an exception.");
			
		}
	}	
    
	public void  testDetermineContractScenarioWithCQSONLY() {
		EsRequestComplexType request = new EsRequestComplexType();
		request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
		request.getEsRequestComplexTypeChoice().setContractRequest(new ContractRequest());

		ContractRequest cr = request.getEsRequestComplexTypeChoice().getContractRequest();
		try  {
			cr.setContractIdentifierType(ContractIdentifierTypeType.SVCAGREEMENTID);
			cr.setContractIdentifier("123");			
			int scenario = ContractScenario.getInstance().determineContractScenario(request, true, true);
			assertEquals("It should have been CQS only", ContractScenario.CQS_ONLY_SCENARIO, scenario);
			
		}catch(SifException e) {
			fail("We should not get an exception.");
			
		}
	}	
	

	public void  testDetermineContractScenarioWithCQSANDODSONLY() {
		EsRequestComplexType request = new EsRequestComplexType();
		request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
		request.getEsRequestComplexTypeChoice().setContractRequest(new ContractRequest());

		ContractRequest cr = request.getEsRequestComplexTypeChoice().getContractRequest();
		try  {
			cr.setContractIdentifierType(ContractIdentifierTypeType.FUNCTIONALLOCATION);
			cr.setContractIdentifier("123");			
			int scenario = ContractScenario.getInstance().determineContractScenario(request, true, true);
			assertEquals("It should have been CQS & ODS", ContractScenario.CQS_AND_ODS_SCENARIO, scenario);


			
		}catch(SifException e) {
			fail("We should not get an exception.");
			
		}
	}		
}
