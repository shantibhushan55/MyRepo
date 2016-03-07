/**
 * 
 */
package com.hp.es.service.compliancevalidation;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.es.service.util.TransactionIdGenerator;
import com.hp.es.xml.service.ContractEntitlementComplexType;
import com.hp.es.xml.service.EsHeader;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.WarrantyEntitlementComplexType;
import com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 */
public class ComplianceValidationHelperTest {

	private static final Logger logger = LoggerFactory.getLogger( ComplianceValidationHelperTest.class );

	public void setup() {
		System.setProperty("ES_HOME", "C:\\home\\entitlem\\st\\trunk\\service_tibet11\\work");
		
	}
	/**
	 * Test method for {@link com.hp.es.service.compliancevalidation.ComplianceValidationHelper#callComplianceValidationService(com.hp.es.xml.service.EIAMessage, java.lang.String)}.

	@Test
	public void testCallComplianceValidationServiceEIAMessageString() {
		
		fail("Not yet implemented");
	}	 */

	/**
	 * Test method for {@link com.hp.es.service.compliancevalidation.ComplianceValidationHelper#callComplianceValidationService(com.hp.es.xml.service.EsReply, java.lang.String)}.
	 */
	@Test
	public void testCallComplianceValidationServiceEsReplyString() {
		EsReply reply= null;
		String transactionId=null;
		try {
			Assert.assertNull(ComplianceValidationHelper.getInstance().callComplianceValidationService(reply,null, transactionId));
		} catch (SifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reply= new EsReply();
		transactionId=TransactionIdGenerator.getInstance().nextId();
		try {
			Assert.assertNull(ComplianceValidationHelper.getInstance().callComplianceValidationService(reply,null, transactionId));
		} catch (SifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reply= new EsReply();
		reply.setEsHeader(new EsHeader());
		reply.setEsReplyChoice(new EsReplyChoice());
		reply.getEsReplyChoice().setContractEntitlement(new ContractEntitlementComplexType());
		
		transactionId=TransactionIdGenerator.getInstance().nextId();
		try {
			Assert.assertNull(ComplianceValidationHelper.getInstance().callComplianceValidationService(reply,null, transactionId));
		} catch (SifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		reply= new EsReply();
		reply.setEsHeader(new EsHeader());
		reply.setEsReplyChoice(new EsReplyChoice());
		reply.getEsReplyChoice().setWarrantyEntitlement(new WarrantyEntitlementComplexType());
		OOSComplexType oos = new OOSComplexType();
		reply.getEsReplyChoice().getWarrantyEntitlement().setOOS(oos);
		oos.addSerialNumber("SB112");
		oos.setShipToCountry("US");
		oos.setProduct(new ProductComplexType());
		oos.getProduct().setProductID("ABC");
		oos.getProduct().setProductLineCode("AB");
		transactionId=TransactionIdGenerator.getInstance().nextId();
		ComplianceValidationReply cvr;
		try {
			cvr = ComplianceValidationHelper.getInstance().callComplianceValidationService(reply,null, transactionId);
			System.out.println("cv reply"+cvr);
			Assert.assertNotNull("CVR should not be null",cvr);
			Assert.assertTrue("CVS should have return a OK", cvr.getValidationResponseCode().equalsIgnoreCase("OK"));
			Assert.assertNotNull("The transaction id should not be null",cvr.getCheckTransactionId());
		} catch (SifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}

	/**
	 * Test method for {@link com.hp.es.service.compliancevalidation.ComplianceValidationHelper#modifyESReply(com.hp.es.xml.service.EsReply, com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply)}.

	@Test
	public void testModifyESReplyEsReplyComplianceValidationReply() {
		fail("Not yet implemented");
	}
		 */

	/**
	 * Test method for {@link com.hp.es.service.compliancevalidation.ComplianceValidationHelper#modifyESReply(com.hp.es.xml.service.EIAMessage, com.hp.it.sbs.compliancevalidation.beans.ComplianceValidationReply)}.
	 
	@Test
	public void testModifyESReplyEIAMessageComplianceValidationReply() {
		fail("Not yet implemented");
	}
*/
}
