/**
 * 
 */
package com.hp.es.service.wsInterface;

import junit.framework.TestCase;

import com.hp.es.service.util.xml.MarshalHelper;
import com.hp.es.xml.service.EIAMessage;

/**
 * @author anvoi
 *
 */
public class EsHttpListenerTest extends TestCase {

	/**
	 * 
	 */
	public EsHttpListenerTest() {
		super();
	}

	/**
	 * @param arg0
	 */
	public EsHttpListenerTest(String arg0) {
		super(arg0);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	/*
	 * Test method for 'com.hp.es.service.warrantyEntitlement.orchestration.WarrantyDeterminationCode.getHigestPriority(OrchestrationReply[])'
	 */
	public void testProcessRequestWithTwoPrologs() {

		try {
			String doubleProlog = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
				"<EIAMessage><MessageHeader><MessageID>isoit621.bbn.hp.com/15.138.17.36:12256734:http8096-Processor4:2</MessageID><MessageStatus>Created</MessageStatus><TimeStamp>2006-04-20T15:00:27.424Z</TimeStamp><MessageType>request</MessageType><MessageComment></MessageComment>"+
				"<Routing><SourceSystem><SrcSystemInstance></SrcSystemInstance><SrcSystemType></SrcSystemType><SrcHPEntity></SrcHPEntity><SrcCountry></SrcCountry><SrcSiteName></SrcSiteName></SourceSystem></Routing><ServiceDescriptor><ServiceID>ES</ServiceID><MajorVersion>8</MajorVersion><MinorVersion>1</MinorVersion></ServiceDescriptor><MessageState><Validated></Validated></MessageState>"+
				"        <MessageSecurity>"+
				"            <SecurityCredentials>"+
				"                <UserName>TheMan</UserName>"+
				"                <UserPassword>FromNowhere</UserPassword>"+
				"            </SecurityCredentials>"+
				"        </MessageSecurity>"+
				"    </MessageHeader>"+
				"    <MessageBody><?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
				"<EsRequestComplexType>"+
				"    <Operation>getWarrantyEntitlement</Operation>"+
				"    <ClientAppID>ESTC_8_2_1</ClientAppID>"+
				"    <WarrantyRequest>"+
				"        <EntitlementCheckDate>2006-04-20</EntitlementCheckDate>"+
				"        <IsoCountryCd>aa</IsoCountryCd>"+
				"        <IncludeServiceNotes>false</IncludeServiceNotes>"+
				"        <IncludeWorkings>false</IncludeWorkings>"+
				"        <IncludeAddresses>true</IncludeAddresses>"+
				"        <SourceSystem>ALL</SourceSystem>"+
				"        <SerialNumber>aa</SerialNumber>"+
				"        <ProductID>aa</ProductID>"+
				"        <SparePartNumber></SparePartNumber>"+
				"        <DateCode></DateCode>"+
				"        <ServiceID></ServiceID>"+
				"        <ConsumerBusinessLogicNeeded>false</ConsumerBusinessLogicNeeded>"+
				"    </WarrantyRequest>"+
				"</EsRequestComplexType>"+
				"</MessageBody>"+
				"    <MessageTrailer>"+
				"        <Activity>"+
				"            <ActOriginator>EIAAS</ActOriginator>"+
				"            <ActDateTime>2006-04-20T15:00:27.460Z</ActDateTime>"+
				"            <ActLocation>isoit621.bbn.hp.com/15.138.17.36:12256734:http8096-Processor4</ActLocation>"+
				"            <ActType>Created</ActType>"+
				"        </Activity>"+
				"    </MessageTrailer>"+
				"</EIAMessage>";

			
			EsHttpListener listener = new EsHttpListener();
			String tmp = listener.processRequest(doubleProlog);
			System.out.println(tmp);
			assertTrue(true);			

		} catch(Exception e) {
			fail();
			
		}
	}
	
	public void testWrapMessageEnveloppe() {

		try {
			EsHttpListener listener = new EsHttpListener();
			String requestString = " <?xml version=\"1.0\" encoding = \"UTF-8\"?> <EsRequest><Operation>getEntitlementBySn</Operation><ClientAppID>WEBCLIENT</ClientAppID><EntitlementBySnRequest><ActiveContractsOnly>true</ActiveContractsOnly><ActiveServicesOnly>true</ActiveServicesOnly><IncludeAddresses>false</IncludeAddresses><IncludeContacts>false</IncludeContacts><IncludeOffers>false</IncludeOffers><IncludeDeliverables>false</IncludeDeliverables><IncludeModifiers>false</IncludeModifiers><IncludeWorkings>false</IncludeWorkings><EntitlementCheckDate>2006-04-24</EntitlementCheckDate><IsoCountryCd>a</IsoCountryCd><ActiveWarrantyOnly>false</ActiveWarrantyOnly><ContractIdentifier>a</ContractIdentifier><IncludeWarranty>false</IncludeWarranty><IncludeContracts>true</IncludeContracts><IncludeServiceNotes>false</IncludeServiceNotes><SerialNumber>a</SerialNumber><ProductID>a</ProductID></EntitlementBySnRequest></EsRequest>";
			String tmp = listener.wrapMessageEnvellope("ES","9","0","Antoine","pwd","validated", "id",requestString);
			
			System.out.println(tmp);
			EIAMessage request = MarshalHelper.unmarshalUsingEIAMappingFile(tmp, null);	
			System.out.println(request.toString());
		} catch(Exception e) {
			e.printStackTrace();
			fail();	
			
			
		}

		
	}

}
