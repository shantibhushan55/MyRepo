package com.hp.es.service.contractEntitlement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.service.contractEntitlement.db.OutputDetails;
import com.hp.es.service.contractEntitlement.keys.ObligationHeaderKey;
import com.hp.es.xml.service.AppliesTo;
import com.hp.es.xml.service.ContractComplexType;
import com.hp.es.xml.service.Deliverable;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.OOSComplexType;
import com.hp.es.xml.service.OfferComplexType;
import com.hp.es.xml.service.PrintAdvantageRequest;
import com.hp.es.xml.service.ProductComplexType;
import com.hp.sif.SifException;

/**
 * Test if the correct reply is generated (merging offers with the same offerCode;
 * merging deliverables with the same deliverable code; calculate quantities)
 */
public class GetPrintAdvantageEntitlementOperationTest extends TestCase{
    
    public GetPrintAdvantageEntitlementOperationTest(String inTest) {
        super(inTest);
    }
    
    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(GetPrintAdvantageEntitlementOperationTest.class);
    }
    
    /**
     * There are 3 offers, 2 of them have identical OfferCode. The ProductID 
     * and is different.
     * Checks in case multiple offers are available if the aggregation of the quantities is
     * done correctly in case OfferCode and ProductID of the OOS are identical.
     */
    public void testMultipleOffersSameProduct() {
        OutputDetails outputDetails = new OutputDetails(new PrintAdvantageRequest());
        EsReplyContext context = new EsReplyContext(outputDetails);
        
        ContractComplexType contract = new ContractComplexType();
        ObligationHeaderKey ohKey = new ObligationHeaderKey("sourceObligationID");        
        
        OfferComplexType offer1 = new OfferComplexType();
        OfferComplexType offer2 = new OfferComplexType();
        OfferComplexType offer3 = new OfferComplexType();
        OfferComplexType offer4 = new OfferComplexType();
        OfferComplexType offer5 = new OfferComplexType();
        OOSComplexType oos1 = new OOSComplexType();
        OOSComplexType oos2 = new OOSComplexType();
        OOSComplexType oos3 = new OOSComplexType();
        OOSComplexType oos4 = new OOSComplexType();
        OOSComplexType oos5 = new OOSComplexType();
        AppliesTo appliesTo1 = new AppliesTo();
        AppliesTo appliesTo2 = new AppliesTo();
        AppliesTo appliesTo3 = new AppliesTo();
        AppliesTo appliesTo4 = new AppliesTo();
        AppliesTo appliesTo5 = new AppliesTo();
        ProductComplexType product1 = new ProductComplexType();
        ProductComplexType product2 = new ProductComplexType();
        ProductComplexType product3 = new ProductComplexType();
        ProductComplexType product4 = new ProductComplexType();
        ProductComplexType product5 = new ProductComplexType();
        
        oos1.setProduct(product1);
        oos2.setProduct(product2);
        oos3.setProduct(product3);
        oos4.setProduct(product4);
        oos5.setProduct(product5);
        appliesTo1.setOOSRef(oos1);
        appliesTo2.setOOSRef(oos2);
        appliesTo3.setOOSRef(oos3);
        appliesTo4.setOOSRef(oos4);
        appliesTo5.setOOSRef(oos5);
        offer1.addAppliesTo(appliesTo1);
        offer2.addAppliesTo(appliesTo2);
        offer3.addAppliesTo(appliesTo3);
        offer4.addAppliesTo(appliesTo4);
        offer5.addAppliesTo(appliesTo5);
        // reverse order in order to test sortation
        contract.addOffer(offer5);
        contract.addOffer(offer4);
        contract.addOffer(offer3);
        contract.addOffer(offer2);
        contract.addOffer(offer1);
        
        context.addContract(ohKey,contract);

        // fill data
        {
            // offer1 and offer2 needs to be merged together
            // products with productID1 needs to be merged and the quantities 
            // needs to be added
            offer1.setOfferCode("offerCode1");
            offer1.setAvailableQuantity(5);
            offer1.setServiceQuantity(10);
            product1.setProductID("productID1");
            product1.setProductDescription("productDescription1");
    
            offer2.setOfferCode("offerCode1");
            offer2.setAvailableQuantity(3);
            offer2.setServiceQuantity(6);
            product2.setProductID("productID1");
            product2.setProductDescription("productDescription1");
        }

        {
            offer3.setOfferCode("offerCode2");
            offer3.setAvailableQuantity(1);
            offer3.setServiceQuantity(20);
            product3.setProductID("productID2");
            product3.setProductDescription("productDescription2");  
        }        
        
        {
            // offer4 and offer4 needs to be merged together
            // products are not merged
            offer4.setOfferCode("offerCode4");
            offer4.setAvailableQuantity(5);
            offer4.setServiceQuantity(10);
            product4.setProductID("productID4");
            product4.setProductDescription("productDescription4");
    
            offer5.setOfferCode("offerCode4");
            offer5.setAvailableQuantity(3);
            offer5.setServiceQuantity(6);
            product5.setProductID("productID1");
            product5.setProductDescription("productDescription1");
        }        
        
        GetPrintAdvantageEntitlementOperation operation = new GetPrintAdvantageEntitlementOperation();
        EsReply reply = null;
        try {
            reply = operation.generateReply(context, new EsRequestComplexType());
        } catch(SifException eiaEx) {
            fail(eiaEx.toString());
        }
        checkMultipleOffersSameProduct(reply);
    }
    
    private void checkMultipleOffersSameProduct(EsReply reply) {
        ContractComplexType contract =
            reply
                .getEsReplyChoice()
                .getPrintAdvantageEntitlement()
                .getContract(
                0);
        OfferComplexType[] offers = contract.getOffer();
        
        if(offers.length != 3) {
            fail("There have to be 3 offers.");
        }
        
        // ---------------------------------------------
        check(offers[0], "offerCode1", offers[0].getDeliverable(0), 1, "productID1", 8, 16);
        
        // ---------------------------------------------
        check(offers[1], "offerCode2", offers[1].getDeliverable(0), 1, "productID2", 1, 20);
 
        // ---------------------------------------------
        check(offers[2], "offerCode4", offers[2].getDeliverable(0), 2, "productID1", 3, 6);
        check(offers[2], "offerCode4", offers[2].getDeliverable(1), 2, "productID4", 5, 10);
    }
    
    /**
     * 
     */
    public void testProductNullValues() {
        OutputDetails outputDetails = new OutputDetails(new PrintAdvantageRequest());
        EsReplyContext context = new EsReplyContext(outputDetails);
        
        ContractComplexType contract = new ContractComplexType();
        ObligationHeaderKey ohKey = new ObligationHeaderKey("sourceObligationID");        
        
        OfferComplexType offer1 = new OfferComplexType();
        OfferComplexType offer2 = new OfferComplexType();
        OOSComplexType oos1 = new OOSComplexType();
        OOSComplexType oos2 = new OOSComplexType();
        AppliesTo appliesTo1 = new AppliesTo();
        AppliesTo appliesTo2 = new AppliesTo();
        ProductComplexType product1 = new ProductComplexType();
        ProductComplexType product2 = new ProductComplexType();
        
        oos1.setProduct(product1);
        oos2.setProduct(product2);
        appliesTo1.setOOSRef(oos1);
        appliesTo2.setOOSRef(oos2);
        offer1.addAppliesTo(appliesTo1);
        offer2.addAppliesTo(appliesTo2);
        // reverse order in order to test sortation
        contract.addOffer(offer2);
        contract.addOffer(offer1);
        
        context.addContract(ohKey,contract);

        // fill data
        {
            // offer1 and offer2 needs to be merged together
            // products with productID1 needs to be merged and the quantities 
            // needs to be added
            offer1.setOfferCode("offerCode1");
            offer1.setAvailableQuantity(5);
            offer1.setServiceQuantity(10);
            product1.setProductID(null);
            product1.setProductDescription("productDescription1");
    
            offer2.setOfferCode("offerCode1");
            offer2.setAvailableQuantity(3);
            offer2.setServiceQuantity(6);
            product2.setProductID(null);
            product2.setProductDescription("productDescription1");
        }
       
        GetPrintAdvantageEntitlementOperation operation = new GetPrintAdvantageEntitlementOperation();
        EsReply reply = null;
        try {
            reply = operation.generateReply(context, new EsRequestComplexType());
        } catch(SifException eiaEx) {
            fail(eiaEx.toString());
        }
        checkProductNullValues(reply);
    }

    private void checkProductNullValues(EsReply reply) {
        ContractComplexType contract =
            reply
                .getEsReplyChoice()
                .getPrintAdvantageEntitlement()
                .getContract(
                0);
        OfferComplexType[] offers = contract.getOffer();
        
        if(offers.length != 1) {
            fail("There have to be 1 offer.");
        }
        
        // ---------------------------------------------
        check(offers[0], "offerCode1", offers[0].getDeliverable(0), 1, null, 8, 16);
        
    }

    /**
     * Checks if the multiple contract case is handled correctly by the operation
     */
    public void testMultipleContracts() {
        OutputDetails outputDetails = new OutputDetails(new PrintAdvantageRequest());
        EsReplyContext context = new EsReplyContext(outputDetails);

        ContractComplexType contract1 = new ContractComplexType();
        ContractComplexType contract2 = new ContractComplexType();
        
        ObligationHeaderKey ohKey1 = new ObligationHeaderKey("obligationHeaderKey1");
        ObligationHeaderKey ohKey2 = new ObligationHeaderKey("obligationHeaderKey2");
        OfferComplexType offer1 = new OfferComplexType();
        OfferComplexType offer2 = new OfferComplexType();
        AppliesTo appliesTo1 = new AppliesTo();
        AppliesTo appliesTo2 = new AppliesTo();
        OOSComplexType oos1 = new OOSComplexType();
        OOSComplexType oos2 = new OOSComplexType();
        ProductComplexType product1 = new ProductComplexType();
        ProductComplexType product2 = new ProductComplexType();
        
        contract1.setPortfolioFlag("G");
        contract2.setPortfolioFlag("G");
        contract1.setSvcAgreementID("scvAgrID1");
        contract2.setSvcAgreementID("scvAgrID2");
        
        oos1.setProduct(product1);
        oos2.setProduct(product2);
        appliesTo1.setOOSRef(oos1);
        appliesTo2.setOOSRef(oos2);
        offer1.addAppliesTo(appliesTo1);
        offer2.addAppliesTo(appliesTo2);
        contract1.addOffer(offer1);
        contract2.addOffer(offer2);
                
        offer1.setOfferCode("offerCode1");
        offer2.setOfferCode("offerCode2");
        offer1.setAvailableQuantity(5);
        offer2.setAvailableQuantity(2);
        offer1.setServiceQuantity(10);
        offer2.setServiceQuantity(8);
        
        product1.setProductID("productID1");
        product2.setProductID("productID2");
        product1.setProductDescription("productDescription1");
        product2.setProductDescription("productDescription2");

        context.addContract(ohKey1, contract1);
        context.addContract(ohKey2, contract2);
        
        GetPrintAdvantageEntitlementOperation operation = new GetPrintAdvantageEntitlementOperation();
        EsReply reply = null;
        try {
            reply = operation.generateReply(context, new EsRequestComplexType());
        } catch(SifException eiaEx) {
            fail(eiaEx.toString());
        }
        checkMultipleContracts(reply);
    }
    
    private void checkMultipleContracts(EsReply reply) {
        ContractComplexType[] contracts =
            reply
                .getEsReplyChoice()
                .getPrintAdvantageEntitlement()
                .getContract();
        if(contracts.length != 2) {
            fail("Multiple contracts are not handeled correctly! There have to be 2 contracts in this reply but there are "+
                contracts.length+".");
        }
        if(contracts[0].getOfferCount() > 1) {
            fail("There should be only one offer in contract1 but there are "+ contracts[0].getOfferCount() + ".");
        }
        
        if(contracts[1].getOfferCount() > 1) {
            fail("There should be only one offer in contract2 but there are "+ contracts[1].getOfferCount() + ".");
        }


        check(contracts[0].getOffer(0), "offerCode1", contracts[0].getOffer(0).getDeliverable(0), 1, "productID1", 5, 10);
        check(contracts[1].getOffer(0), "offerCode2", contracts[1].getOffer(0).getDeliverable(0), 1, "productID2", 2, 8);
    }

    /**
     * Compares the result with the expected values.
     * @param offer
     * @param expectedOfferCode
     * @param d
     * @param expectedDelivCount
     * @param expectedCode
     * @param expectedAvQ
     * @param expectedDQ
     */
    private void check(
        OfferComplexType offer,
        String expectedOfferCode,
        Deliverable d,
        int expectedDelivCount,
        String expectedDelivCode,
        int expectedAvQ,
        int expectedDQ) {

        if (!offer.getOfferCode().equals(expectedOfferCode)) {
            fail("offer should have offerCode=" + expectedOfferCode);
        }
        
        if (offer.getDeliverableCount() != expectedDelivCount) {
            fail(
                "DeliverableCount of offer (offerCode="
                    + expectedOfferCode
                    + ") wrong (expected= "
                    + expectedDelivCount
                    + " current="
                    + offer.getDeliverableCount());
        }
        
        if ((d.getDelivCode() == null && expectedDelivCode != null)
            || (d.getDelivCode() != null
                && !d.getDelivCode().equals(expectedDelivCode))) {
            fail(
                "delivCode doesn't match for offerCode="
                    + expectedOfferCode
                    + " (expected="
                    + expectedDelivCode
                    + " current="
                    + d.getDelivCode()
                    + ")");
        }
        if (d.getAvailableQuantity() != expectedAvQ) {
            fail(
                "Available quantity for offerCode="
                    + expectedOfferCode
                    + "  should be "
                    + expectedAvQ
                    + " but is "
                    + d.getAvailableQuantity()
                    + ".");
        }
        if (d.getDeliverableQuantity() != expectedDQ) {
            fail(
                "Deliverable quantity for offerCode="
                    + expectedOfferCode
                    + " should be "
                    + expectedDQ
                    + " but is "
                    + d.getDeliverableQuantity()
                    + ".");
        }
    }
}






