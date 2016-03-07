/*
 * Created on Mar 9, 2006
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hp.es.service.contractEntitlement.integration;

import junit.framework.TestCase;

import com.hp.es.service.RequestCleaner;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.xml.MarshalHelper;
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;
/**
 * @author gary_w_smith
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CQSGetContractIntegrationTest extends TestCase {

	/*
	public void testMapRequestAllTrue()
	{
		CQSGetContractIntegration cqsInt = new CQSGetContractIntegration("AM");
		
		EsRequestComplexType esRequest = null;		
		String xml = 
			"<EsRequest>" +
			    "<Operation>getContractEntitlement</Operation>" +
			    "<ClientAppID>EsTest</ClientAppID>" +
			    "<ContractRequest>" +
			        "<ContractIdentifierType>FunctionalLocation</ContractIdentifierType>" +
			        "<DataEntrySite>XYZ</DataEntrySite>" +
			        "<SourceCustomerID>ABCDE</SourceCustomerID>" +
			        "<ActiveContractsOnly>true</ActiveContractsOnly>" +
			        "<ActiveServicesOnly>true</ActiveServicesOnly>" +
			        "<IncludeAddresses>true</IncludeAddresses>" +
			        "<IncludeContacts>true</IncludeContacts>" +
			        "<IncludeOffers>true</IncludeOffers>" +
			        "<IncludeDeliverables>true</IncludeDeliverables>" +
			        "<IncludeModifiers>true</IncludeModifiers>" +
			        "<ContractIdentifier>12345</ContractIdentifier>" +
			        "<ProductID>45678</ProductID>" +
			        "<IncludeUniqueOffers>true</IncludeUniqueOffers>" +
			        "<IncludeUniqueDeliverables>true</IncludeUniqueDeliverables>" +
			        "<IncludeOOSes>true</IncludeOOSes>" +
			        "<IsoCountryCd>DE</IsoCountryCd>" +
			        "<StandAloneOffersOnly>true</StandAloneOffersOnly>" +
			        "<EntitlementCheckDate>2006-03-10</EntitlementCheckDate>" +
			        "<CustomerDefinedID>9876</CustomerDefinedID>" +
			    "</ContractRequest>" +
			"</EsRequest>";
			
		try{
			esRequest = (EsRequestComplexType) MarshalHelper.unmarshal(xml,null,EsRequestComplexType.class);

			Zes_cqs_contracten_request_v1 result = ((InputZes_contract_ent_es10)cqsInt.mapEsRequest2CQSRequest(esRequest)).getES_REQUEST();
			assertEquals("45678", result.getPRODUCT_ID());
			assertEquals("DE", result.getISO_COUNTRY_CODE());
			assertEquals("2006-03-10", result.getCHECK_DATE());
			assertEquals("12345", result.getCONTRACT_IDENTIFIER());
			assertEquals("SAR", result.getCONTRACT_IDENTIFIER_TYPE());
			assertEquals("XYZ", result.getDATA_ENTRY_SITE());
			assertEquals("9876", result.getCUSTOMER_DEFINED_ID());
			assertEquals("ABCDE", result.getSOURCE_CUSTOMER_ID());
			assertEquals("X", result.getACTIVE_CONTRACTS_ONLY());
			assertEquals("X", result.getACTIVE_SERVICES_ONLY());
			assertEquals("X", result.getSTANDALONE_OFFERS_ONLY());
			assertEquals("X", result.getINCLUDE_OOSES());
			assertEquals("X", result.getINCLUDE_ADDRESSES());
			assertEquals("X", result.getINCLUDE_CONTACTS());
			assertEquals("X", result.getINCLUDE_SERVICES());
			assertEquals("X", result.getINCLUDE_DELIVERABLES());
			assertEquals("X", result.getINCLUDE_MODIFIERS());
			
		}catch(SifException e){
			fail("Should not have thrown a SifException");
		}
		
	}
	*/
/*
	public void testMapRequestAllFalse()
	{
		CQSGetContractIntegration cqsInt = new CQSGetContractIntegration("AM");
		
		EsRequestComplexType esRequest = null;		
		String xml = 
			"<EsRequest>" +
			    "<Operation>getContractEntitlement</Operation>" +
			    "<ClientAppID>EsTest</ClientAppID>" +
			    "<ContractRequest>" +
			        "<ContractIdentifierType>CCRN</ContractIdentifierType>" +
			        "<DataEntrySite>XYZ</DataEntrySite>" +
			        "<SourceCustomerID>ABCDE</SourceCustomerID>" +
			        "<ActiveContractsOnly>false</ActiveContractsOnly>" +
			        "<ActiveServicesOnly>false</ActiveServicesOnly>" +
			        "<IncludeAddresses>false</IncludeAddresses>" +
			        "<IncludeContacts>false</IncludeContacts>" +
			        "<IncludeOffers>false</IncludeOffers>" +
			        "<IncludeDeliverables>false</IncludeDeliverables>" +
			        "<IncludeModifiers>false</IncludeModifiers>" +
			        "<ContractIdentifier>12345</ContractIdentifier>" +
			        "<ProductID>45678</ProductID>" +
			        "<IncludeUniqueOffers>false</IncludeUniqueOffers>" +
			        "<IncludeUniqueDeliverables>false</IncludeUniqueDeliverables>" +
			        "<IncludeOOSes>false</IncludeOOSes>" +
			        "<IsoCountryCd>DE</IsoCountryCd>" +
			        "<StandAloneOffersOnly>false</StandAloneOffersOnly>" +
			        "<EntitlementCheckDate>2006-03-10</EntitlementCheckDate>" +
			        "<CustomerDefinedID>9876</CustomerDefinedID>" +
			    "</ContractRequest>" +
			"</EsRequest>";
			
		try{
			esRequest = (EsRequestComplexType) MarshalHelper.unmarshal(xml,null,EsRequestComplexType.class);

			Zes_cqs_contracten_request_v1 result = ((InputZes_contract_ent_es10)cqsInt.mapEsRequest2CQSRequest(esRequest)).getES_REQUEST();
			assertEquals("45678", result.getPRODUCT_ID());
			assertEquals("DE", result.getISO_COUNTRY_CODE());
			assertEquals("2006-03-10", result.getCHECK_DATE());
			assertEquals("12345", result.getCONTRACT_IDENTIFIER());
			assertEquals("CCRN", result.getCONTRACT_IDENTIFIER_TYPE());
			assertEquals("XYZ", result.getDATA_ENTRY_SITE());
			assertEquals("9876", result.getCUSTOMER_DEFINED_ID());
			assertEquals("ABCDE", result.getSOURCE_CUSTOMER_ID());
			assertEquals(" ", result.getACTIVE_CONTRACTS_ONLY());
			assertEquals(" ", result.getACTIVE_SERVICES_ONLY());
			assertEquals(" ", result.getSTANDALONE_OFFERS_ONLY());
			assertEquals(" ", result.getINCLUDE_OOSES());
			assertEquals(" ", result.getINCLUDE_ADDRESSES());
			assertEquals(" ", result.getINCLUDE_CONTACTS());
			assertEquals(" ", result.getINCLUDE_SERVICES());
			assertEquals(" ", result.getINCLUDE_DELIVERABLES());
			assertEquals(" ", result.getINCLUDE_MODIFIERS());
			
		}catch(SifException e){
			fail("Should not have thrown a SifException");
		}
		
	}
*/
	/*
	public void testEmptyRequest()
	{
		CQSGetContractIntegration cqsInt = new CQSGetContractIntegration("AM");
		
		EsRequestComplexType esRequest = null;		
		String xml = 
			"<EsRequest>" +
			    "<Operation>getContractEntitlement</Operation>" +
			    "<ClientAppID>EsTest</ClientAppID>" +
			    "<ContractRequest>" +
			        "<ContractIdentifierType></ContractIdentifierType>" +
			        "<DataEntrySite></DataEntrySite>" +
			        "<SourceCustomerID></SourceCustomerID>" +
			        "<ActiveContractsOnly></ActiveContractsOnly>" +
			        "<ActiveServicesOnly></ActiveServicesOnly>" +
			        "<IncludeAddresses></IncludeAddresses>" +
			        "<IncludeContacts></IncludeContacts>" +
			        "<IncludeOffers></IncludeOffers>" +
			        "<IncludeDeliverables></IncludeDeliverables>" +
			        "<IncludeModifiers></IncludeModifiers>" +
			        "<ContractIdentifier></ContractIdentifier>" +
			        "<ProductID></ProductID>" +
			        "<IncludeUniqueOffers></IncludeUniqueOffers>" +
			        "<IncludeUniqueDeliverables></IncludeUniqueDeliverables>" +
			        "<IncludeOOSes></IncludeOOSes>" +
			        "<IsoCountryCd></IsoCountryCd>" +
			        "<StandAloneOffersOnly></StandAloneOffersOnly>" +
			        "<EntitlementCheckDate></EntitlementCheckDate>" +
			        "<CustomerDefinedID></CustomerDefinedID>" +
			    "</ContractRequest>" +
			"</EsRequest>";
			
		try{
			esRequest = (EsRequestComplexType) MarshalHelper.unmarshal(xml,null,EsRequestComplexType.class);

			ContractTransaction trans = cqsInt.doContractIntegration(esRequest, new MetricsHandler());
			
			Iterator iterator = trans.getSourceSystemErrors().iterator();
			Object tmp = iterator.next();
			assertTrue(tmp instanceof Zes_cqs_messages_t);
			Zes_cqs_messages_t msg = (Zes_cqs_messages_t)tmp;
			assertEquals("E", msg.getTYPE());
			assertEquals(new BigInteger("104"), msg.getMSG_NO());
		}catch(SifException e){
			fail("Should not have thrown a SifException");
		}
	}

	public void testUnknownSAID()
	{
		CQSGetContractIntegration cqsInt = new CQSGetContractIntegration("AM");
		
		EsRequestComplexType esRequest = null;		
		String xml = 
			"<EsRequest>" +
			    "<Operation>getContractEntitlement</Operation>" +
			    "<ClientAppID>EsTest</ClientAppID>" +
			    "<ContractRequest>" +
			        "<ContractIdentifierType>SvcAgreementID</ContractIdentifierType>" + 
			        "<DataEntrySite></DataEntrySite>" +
			        "<SourceCustomerID></SourceCustomerID>" +
			        "<ActiveContractsOnly></ActiveContractsOnly>" +
			        "<ActiveServicesOnly></ActiveServicesOnly>" +
			        "<IncludeAddresses></IncludeAddresses>" +
			        "<IncludeContacts></IncludeContacts>" +
			        "<IncludeOffers></IncludeOffers>" +
			        "<IncludeDeliverables></IncludeDeliverables>" +
			        "<IncludeModifiers></IncludeModifiers>" +
			        "<ContractIdentifier>9876543</ContractIdentifier>" +  // invalid contract id
			        "<ProductID></ProductID>" +
			        "<IncludeUniqueOffers></IncludeUniqueOffers>" +
			        "<IncludeUniqueDeliverables></IncludeUniqueDeliverables>" +
			        "<IncludeOOSes></IncludeOOSes>" +
			        "<IsoCountryCd></IsoCountryCd>" +
			        "<StandAloneOffersOnly></StandAloneOffersOnly>" +
			        "<EntitlementCheckDate></EntitlementCheckDate>" +
			        "<CustomerDefinedID></CustomerDefinedID>" +
			    "</ContractRequest>" +
			"</EsRequest>";
			
		try{
			esRequest = (EsRequestComplexType) MarshalHelper.unmarshal(xml,null,EsRequestComplexType.class);
		}catch(SifException e){
			fail("Should not have thrown a SifException in unmarshalling the xml package");
		}
			
		try{
			ContractTransaction trans = cqsInt.doContractIntegration(esRequest, new MetricsHandler());
			assertTrue(trans.isSourceSystemError());

			Iterator iterator = trans.getMappedErrors().iterator();
			Object tmp = iterator.next();
			assertTrue(tmp instanceof SifException);
			SifException e = (SifException)tmp;
			assertEquals("201", e.getErrorID());
			
		}catch(SifException e){
			fail("Should not have thrown a SifException on doContractIntegration");
		}
	}
*/
	public void testGoodSAID()
	{
		CQSGetContractIntegration cqsInt = new CQSGetContractIntegration("AM");
		
		EsRequestComplexType esRequest = null;		
		String xml = 
			"<EsRequest>" +
			    "<Operation>getContractEntitlement</Operation>" +
			    "<ClientAppID>EsTest</ClientAppID>" +
			    "<ContractRequest>" +
			        "<ContractIdentifierType>SvcAgreementID</ContractIdentifierType>" + 
			        "<DataEntrySite></DataEntrySite>" +
			        "<SourceCustomerID></SourceCustomerID>" +
			        "<ActiveContractsOnly></ActiveContractsOnly>" +
			        "<ActiveServicesOnly></ActiveServicesOnly>" +
			        "<IncludeAddresses></IncludeAddresses>" +
			        "<IncludeContacts></IncludeContacts>" +
			        "<IncludeOffers></IncludeOffers>" +
			        "<IncludeDeliverables></IncludeDeliverables>" +
			        "<IncludeModifiers></IncludeModifiers>" +
			        "<ContractIdentifier>101008181172</ContractIdentifier>" + 
			        "<ProductID></ProductID>" +
			        "<IncludeUniqueOffers></IncludeUniqueOffers>" +
			        "<IncludeUniqueDeliverables></IncludeUniqueDeliverables>" +
			        "<IncludeOOSes></IncludeOOSes>" +
			        "<IsoCountryCd></IsoCountryCd>" +
			        "<StandAloneOffersOnly></StandAloneOffersOnly>" +
			        "<EntitlementCheckDate></EntitlementCheckDate>" +
			        "<CustomerDefinedID></CustomerDefinedID>" +
			    "</ContractRequest>" +
			"</EsRequest>";
			
		try{
			esRequest = (EsRequestComplexType) MarshalHelper.unmarshal(xml,null,EsRequestComplexType.class);
			RequestCleaner.cleanThisRequest(esRequest);

			ContractTransaction trans = cqsInt.doContractIntegration(esRequest, new MetricsHandler());
			
			assertTrue(trans.isSourceSystemStandardReply());

			EsReply mappedReply = trans.getMappedReply();
			assertNotNull(mappedReply);
			
			ContractEntitlementComplexType ent = mappedReply.getEsReplyChoice().getContractEntitlement();
			assertTrue(ent.getContractCount() >= 1);
			
			assertEquals(ent.getContract(0).getSvcAgreementID(), "101008181172");
						
		}catch(SifException e){
			fail("Should not have thrown a SifException on doContractIntegration");
		}
	}

	public void testSAIDwithoutType()
	{
		// Use a valid SAID but omit the contract identifier type.  It should be found 
		CQSGetContractIntegration cqsInt = new CQSGetContractIntegration("AM");
		
		EsRequestComplexType esRequest = null;		
		String xml = 
			"<EsRequest>" +
			    "<Operation>getContractEntitlement</Operation>" +
			    "<ClientAppID>EsTest</ClientAppID>" +
			    "<ContractRequest>" +
			        "<ContractIdentifierType></ContractIdentifierType>" + 
			        "<DataEntrySite></DataEntrySite>" +
			        "<SourceCustomerID></SourceCustomerID>" +
			        "<ActiveContractsOnly></ActiveContractsOnly>" +
			        "<ActiveServicesOnly></ActiveServicesOnly>" +
			        "<IncludeAddresses></IncludeAddresses>" +
			        "<IncludeContacts></IncludeContacts>" +
			        "<IncludeOffers></IncludeOffers>" +
			        "<IncludeDeliverables></IncludeDeliverables>" +
			        "<IncludeModifiers></IncludeModifiers>" +
			        "<ContractIdentifier>101008181172</ContractIdentifier>" + 
			        "<ProductID></ProductID>" +
			        "<IncludeUniqueOffers></IncludeUniqueOffers>" +
			        "<IncludeUniqueDeliverables></IncludeUniqueDeliverables>" +
			        "<IncludeOOSes></IncludeOOSes>" +
			        "<IsoCountryCd></IsoCountryCd>" +
			        "<StandAloneOffersOnly></StandAloneOffersOnly>" +
			        "<EntitlementCheckDate></EntitlementCheckDate>" +
			        "<CustomerDefinedID></CustomerDefinedID>" +
			    "</ContractRequest>" +
			"</EsRequest>";
			
		try{
			esRequest = (EsRequestComplexType) MarshalHelper.unmarshal(xml,null,EsRequestComplexType.class);
			RequestCleaner.cleanThisRequest(esRequest);

			ContractTransaction trans = cqsInt.doContractIntegration(esRequest, new MetricsHandler());
			
			assertTrue(trans.isSourceSystemStandardReply());

			EsReply mappedReply = trans.getMappedReply();
			assertNotNull(mappedReply);
			
			ContractEntitlementComplexType ent = mappedReply.getEsReplyChoice().getContractEntitlement();
			assertTrue(ent.getContractCount() >= 1);
			
			assertEquals(ent.getContract(0).getSvcAgreementID(), "101008181172");
						
		}catch(SifException e){
			fail("Should not have thrown a SifException on doContractIntegration");
		}
	}

	public void testAllLists()
	{
		CQSGetContractIntegration cqsInt = new CQSGetContractIntegration("AM");
		
		EsRequestComplexType esRequest = null;		
		String xml = 
			"<EsRequest>" +
			    "<Operation>getContractEntitlement</Operation>" +
			    "<ClientAppID>EsTest</ClientAppID>" +
			    "<ContractRequest>" +
			        "<ContractIdentifierType>SvcAgreementID</ContractIdentifierType>" + 
			        "<DataEntrySite></DataEntrySite>" +
			        "<SourceCustomerID></SourceCustomerID>" +
			        "<ActiveContractsOnly></ActiveContractsOnly>" +
			        "<ActiveServicesOnly></ActiveServicesOnly>" +
			        "<IncludeAddresses>true</IncludeAddresses>" +
			        "<IncludeContacts>true</IncludeContacts>" +
			        "<IncludeOffers>true</IncludeOffers>" +
			        "<IncludeDeliverables>true</IncludeDeliverables>" +
			        "<IncludeModifiers>true</IncludeModifiers>" +
			        "<ContractIdentifier>101008181172</ContractIdentifier>" + 
			        "<ProductID></ProductID>" +
			        "<IncludeUniqueOffers></IncludeUniqueOffers>" +
			        "<IncludeUniqueDeliverables></IncludeUniqueDeliverables>" +
			        "<IncludeOOSes>true</IncludeOOSes>" +
			        "<IsoCountryCd></IsoCountryCd>" +
			        "<StandAloneOffersOnly></StandAloneOffersOnly>" +
			        "<EntitlementCheckDate></EntitlementCheckDate>" +
			        "<CustomerDefinedID></CustomerDefinedID>" +
			    "</ContractRequest>" +
			"</EsRequest>";
			
		try{
			esRequest = (EsRequestComplexType) MarshalHelper.unmarshal(xml,null,EsRequestComplexType.class);
			RequestCleaner.cleanThisRequest(esRequest);

			ContractTransaction trans = cqsInt.doContractIntegration(esRequest, new MetricsHandler());
			assertTrue(trans.isSourceSystemStandardReply());

			EsReply mappedReply = trans.getMappedReply();
			assertNotNull(mappedReply);

			ContractEntitlementComplexType ent = mappedReply.getEsReplyChoice().getContractEntitlement();
			assertTrue(ent.getOOSCount() >= 1);
			assertTrue(ent.getContactCount() >= 1);
			assertTrue(ent.getContractCount() >= 1);
			assertTrue(ent.getLocationCount() >= 1);
		}catch(SifException e){
			fail("Should not have thrown a SifException on doContractIntegration");
		}
	}


}
