/*
 * BatchxmlConverterTest.java
 * Created on 11 janv. 2005
 *
 * Entitlement Service Project
 */
package com.hp.es.service.batchEntitlement;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

import com.hp.sif.SifException;

/**
 * @author anvoi
 *
 */
public class BatchxmlConverterTest extends TestCase {

    /**
     * Default Contructor
     */
    public BatchxmlConverterTest() {
        super();
    }
    /**
     * @param arg0
     */
    public BatchxmlConverterTest(String arg0) {
        super(arg0);
    }
    
    
    /* (non-Javadoc)
     * @see junit.framework.TestCase#run()

    public TestResult run() {
        return super.run();
    }
         */
    /*
     * @return the test suite

    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(BatchxmlConverterTest.class);
    }     */
    
    /*
     * Test with an XML containing an error
     * 
     */
    /*public void testWithError() {
        String xmlTest ="<EntitlementItem><InputParameter>" +
        		"<IsoCountryCd>US</IsoCountryCd><SerialNumber>1234XX78</SerialNumber></InputParameter>" +
        		"<EntitlementStatus>E</EntitlementStatus><PartialResultFlag>N</PartialResultFlag></EntitlementItem>";
        String csvExpected ="\"US\",\"1234XX78\",,E,N,,,,,,,,,,,,,,,,,,,,,,,,,,,\r\n";
        String csvActual = null;
        
        try {
            csvActual=BatchxmlConverter.getInstance().XMLToCSV(xmlTest);
            assertTrue(compare(csvExpected,csvActual));
        } catch (SifException e) {
            
            Assert.fail();
        }
        
    }
  
    
     * Test with an XML containing a multiple
     * 
     
    public void testWithMultiple() {
        String xmlTest ="<EntitlementItem>"+
            "<InputParameter><IsoCountryCd>US</IsoCountryCd><SerialNumber>0123456789</SerialNumber></InputParameter>"+
            "<EntitlementStatus>M</EntitlementStatus><PartialResultFlag>N</PartialResultFlag>"+
            "</EntitlementItem>";
        
        String csvExpected ="\"US\",\"0123456789\",,M,N,,,,,,,,,,,,,,,,,,,,,,,,,,,\r\n";
        String csvActual = null;

        
        try {
            csvActual=BatchxmlConverter.getInstance().XMLToCSV(xmlTest);
            assertTrue("Comparison Failed",compare(csvExpected,csvActual));
        } catch (SifException e) {
            Assert.fail();
        }  
        
    }
    
    
     * Test with an XML  containing an offer summary and no offer
     * 
     
    public void testWithEntitlementSummaryNoOfferNoContract() {
        String xmlTest ="<EntitlementItem>"+
	        "<InputParameter><IsoCountryCd>US</IsoCountryCd><SerialNumber>MD07J123RT</SerialNumber><ProductID>C7732A</ProductID></InputParameter>"+
	        "<EntitlementStatus>S</EntitlementStatus><PartialResultFlag>N</PartialResultFlag>"+
	        "<EntitlementSummary>"+
	        "<SerialNumber>MD07J123RT</SerialNumber><ProductId>C7730A</ProductId><ProductDescription>HP ScanJet 4300C Scanner Engine only.</ProductDescription>"+
	        "<ActiveWarrantyEntitlement>false</ActiveWarrantyEntitlement><OverallWarrantyStartDate>2000-08-30</OverallWarrantyStartDate>"+
	        "<OverallWarrantyEndDate>2001-11-28</OverallWarrantyEndDate><WarrantyDeterminationDescription>Ship Date</WarrantyDeterminationDescription><GracePeriod>90</GracePeriod>"+
	        "<FactoryWarrantyPortfolioFlag>S</FactoryWarrantyPortfolioFlag><FactoryWarrantyTermCode>3X</FactoryWarrantyTermCode><ShipToCountry>HK</ShipToCountry>"+
	        "</EntitlementSummary>"+
	        "</EntitlementItem>";
        
        String csvExpected ="\"US\",\"MD07J123RT\",\"C7732A\",S,N,\"MD07J123RT\",\"C7730A\",\"HP ScanJet 4300C Scanner Engine only.\",false,2000-08-30,2001-11-28,,,,\"Ship Date\",90,,S,\"3X\",,,\"HK\",,,,,,,,,,\r\n";
        String csvActual = null;
        
        try {
            csvActual=BatchxmlConverter.getInstance().XMLToCSV(xmlTest);
            assertTrue(compare(csvExpected,csvActual));
        } catch (SifException e) {
            Assert.fail();
        }  
    }

    
    
     * Test with an XML  containing an offer summary and no offer
     * 
     */
    public void testWithEntitlementSummaryNoOfferContract() {
        /*String xmlTest ="<EntitlementItem><InputParameter><IsoCountryCd>US</IsoCountryCd><SerialNumber>MD07J123RT</SerialNumber><ProductID>C7732A</ProductID></InputParameter>"+
        "<EntitlementStatus>S</EntitlementStatus><PartialResultFlag>N</PartialResultFlag>"+
        "<EntitlementSummary>"+
        "<SerialNumber>MD07J123RT</SerialNumber><ProductId>C7730A</ProductId><ProductDescription>HP ScanJet 4300C Scanner Engine only.</ProductDescription>"+
        "<ActiveWarrantyEntitlement>false</ActiveWarrantyEntitlement><OverallWarrantyStartDate>2000-08-30</OverallWarrantyStartDate><OverallWarrantyEndDate>2001-11-28</OverallWarrantyEndDate>"+
        "<ActiveContractEntitlement>true</ActiveContractEntitlement><OverallContractStartDate>2003-02-01</OverallContractStartDate><OverallContractEndDate>2010-01-31</OverallContractEndDate>"+
        "<WarrantyDeterminationDescription>Ship Date</WarrantyDeterminationDescription><GracePeriod>90</GracePeriod><FactoryWarrantyPortfolioFlag>S</FactoryWarrantyPortfolioFlag><FactoryWarrantyTermCode>3X</FactoryWarrantyTermCode>"+
        "<ShipToCountry>HK</ShipToCountry>"+
        "</EntitlementSummary>"+
        "</EntitlementItem>";
        
        String csvExpected ="\"US\",\"MD07J123RT\",\"C7732A\",S,N,\"MD07J123RT\",\"C7730A\",\"HP ScanJet 4300C Scanner Engine only.\",false,2000-08-30,2001-11-28,true,2003-02-01,2010-01-31,\"Ship Date\",90,,S,\"3X\",,,\"HK\",,,,,,,,,,\r\n";
        String csvActual = null;
        
        try {
            csvActual=BatchxmlConverter.getInstance().XMLToCSV(xmlTest);
            assertTrue(compare(csvExpected,csvActual));
        } catch (SifException e) {
            Assert.fail();
        }        */
    }    
    
    
     /* Test with an XML  containing an offer summary and one offer
     * 
     
    public void testWithEntitlementSummaryOneOffer() {
        String xmlTest ="<EntitlementItem>"+
			"<InputParameter><IsoCountryCd>US</IsoCountryCd><SerialNumber>MD07J123RT</SerialNumber><ProductID>C7732A</ProductID></InputParameter>"+
			"<EntitlementStatus>S</EntitlementStatus><PartialResultFlag>N</PartialResultFlag>"+
			"<EntitlementSummary>"+
			"<SerialNumber>MD07J123RT</SerialNumber><ProductId>C7730A</ProductId><ProductDescription>HP ScanJet 4300C Scanner Engine only.</ProductDescription>"+
			"<ActiveWarrantyEntitlement>false</ActiveWarrantyEntitlement><OverallWarrantyStartDate>2000-08-30</OverallWarrantyStartDate><OverallWarrantyEndDate>2001-11-28</OverallWarrantyEndDate>"+
			"<ActiveContractEntitlement>true</ActiveContractEntitlement><OverallContractStartDate>2003-02-01</OverallContractStartDate><OverallContractEndDate>2010-01-31</OverallContractEndDate>"+
			"<WarrantyDeterminationDescription>Ship Date</WarrantyDeterminationDescription><GracePeriod>90</GracePeriod><FactoryWarrantyPortfolioFlag>S</FactoryWarrantyPortfolioFlag>"+
			"<FactoryWarrantyTermCode>3X</FactoryWarrantyTermCode><ShipToCountry>HK</ShipToCountry>"+
			"<OfferSummary>"+
			"<OfferCode>SVCPRODID290P_6</OfferCode><PortfolioFlag>G</PortfolioFlag><ObligationType>C</ObligationType>"+
			"<PackageCode>SVCPRODID290P_1</PackageCode><StartDate>2003-01-01</StartDate><EndDate>2010-12-31</EndDate><Status>A</Status>"+
			"</OfferSummary>"+
			"</EntitlementSummary>"+
			"</EntitlementItem>";
        
        String csvExpected ="\"US\",\"MD07J123RT\",\"C7732A\",S,N,\"MD07J123RT\",\"C7730A\",\"HP ScanJet 4300C Scanner Engine only.\",false,2000-08-30,2001-11-28,true,2003-02-01,2010-01-31,\"Ship Date\",90,,S,\"3X\",,,\"HK\",\"SVCPRODID290P_6\",,G,C,,\"SVCPRODID290P_1\",,2003-01-01,2010-12-31,A\r\n";
        String csvActual = null;
     
        try {
            csvActual=BatchxmlConverter.getInstance().XMLToCSV(xmlTest);
            assertTrue(compare(csvExpected,csvActual));
        } catch (SifException e) {
            Assert.fail();
        }   
    }   
    
    
     * Test with an XML containing an offer summary and 2 offers
     * 
     
    public void testWithEntitlementSummaryTwoOffers() {
        String xmlTest ="<EntitlementItem>"+
	        "<InputParameter><IsoCountryCd>US</IsoCountryCd><SerialNumber>MD07J123RT</SerialNumber><ProductID>C7732A</ProductID></InputParameter>"+
	        "<EntitlementStatus>S</EntitlementStatus><PartialResultFlag>N</PartialResultFlag>"+
	        "<EntitlementSummary>"+
	        "<SerialNumber>MD07J123RT</SerialNumber><ProductId>C7730A</ProductId><ProductDescription>HP ScanJet 4300C Scanner Engine only.</ProductDescription>"+
	        "<ActiveWarrantyEntitlement>false</ActiveWarrantyEntitlement><OverallWarrantyStartDate>2000-08-30</OverallWarrantyStartDate><OverallWarrantyEndDate>2001-11-28</OverallWarrantyEndDate>"+
	        "<ActiveContractEntitlement>true</ActiveContractEntitlement><OverallContractStartDate>2003-02-01</OverallContractStartDate><OverallContractEndDate>2010-01-31</OverallContractEndDate>"+
	        "<WarrantyDeterminationDescription>Ship Date</WarrantyDeterminationDescription><GracePeriod>90</GracePeriod><FactoryWarrantyPortfolioFlag>S</FactoryWarrantyPortfolioFlag>"+
	        "<FactoryWarrantyTermCode>3X</FactoryWarrantyTermCode><ShipToCountry>HK</ShipToCountry>"+
	        "<OfferSummary>"+
	        "<OfferCode>SVCPRODID290P_6</OfferCode><PortfolioFlag>G</PortfolioFlag><ObligationType>C</ObligationType>"+
	        "<PackageCode>SVCPRODID290P_1</PackageCode><StartDate>2003-01-01</StartDate><EndDate>2010-12-31</EndDate><Status>A</Status>"+
	        "</OfferSummary>"+
	        "<OfferSummary>"+
	        "<OfferCode>EXCH</OfferCode>"+
	        "<OfferDescription>Parts Exchange</OfferDescription>"+
	        "<PortfolioFlag>S</PortfolioFlag>"+
	        "<ObligationType>W</ObligationType>"+
	        "<WarrantyTermCode>3X</WarrantyTermCode>"+
	        "<StartDate>2000-08-30</StartDate>"+
	        "<EndDate>2001-11-28</EndDate>"+
	        "<Status>X</Status>"+
	        "</OfferSummary>"+
	        "</EntitlementSummary>"+
	        "</EntitlementItem>";
        String csvExpected ="\"US\",\"MD07J123RT\",\"C7732A\",S,N,\"MD07J123RT\",\"C7730A\",\"HP ScanJet 4300C Scanner Engine only.\",false,2000-08-30,2001-11-28,true,2003-02-01,2010-01-31,\"Ship Date\",90,,S,\"3X\",,,\"HK\",\"SVCPRODID290P_6\",,G,C,,\"SVCPRODID290P_1\",,2003-01-01,2010-12-31,A\r\n"+
        	"\"US\",\"MD07J123RT\",\"C7732A\",S,N,\"MD07J123RT\",\"C7730A\",\"HP ScanJet 4300C Scanner Engine only.\",false,2000-08-30,2001-11-28,true,2003-02-01,2010-01-31,\"Ship Date\",90,,S,\"3X\",,,\"HK\",\"EXCH\",\"Parts Exchange\",S,W,\"3X\",,,2000-08-30,2001-11-28,X\r\n";
        String csvActual = null;
       
        try {
            csvActual=BatchxmlConverter.getInstance().XMLToCSV(xmlTest);
            assertTrue(compare(csvExpected,csvActual));
        } catch (SifException e) {
            Assert.fail();
        }        
    }       
    
    
    
     * Test entitlement web client Wits192
     * 
     
    public void testWits192 () {
        String xmlTest ="<EntitlementItem>"+
	        "<InputParameter><IsoCountryCd>US</IsoCountryCd><SerialNumber>MD07J123RT</SerialNumber><ProductID>C7732A</ProductID></InputParameter>"+
	        "<EntitlementStatus>S</EntitlementStatus><PartialResultFlag>N</PartialResultFlag>"+
	        "<EntitlementSummary>"+
	        "<SerialNumber>MD07J123RT</SerialNumber><ProductId>C7730A</ProductId><ProductDescription>HP ScanJet 4300C Scanner Engine only.</ProductDescription>"+
	        "<ActiveWarrantyEntitlement>false</ActiveWarrantyEntitlement><OverallWarrantyStartDate>2000-08-30</OverallWarrantyStartDate><OverallWarrantyEndDate>2001-11-28</OverallWarrantyEndDate>"+
	        "<ActiveContractEntitlement>false</ActiveContractEntitlement>"+
	        "<WarrantyDeterminationDescription>Ship Date</WarrantyDeterminationDescription><GracePeriod>90</GracePeriod>"+
	        "<FactoryWarrantyPortfolioFlag>S</FactoryWarrantyPortfolioFlag><FactoryWarrantyTermCode>3X</FactoryWarrantyTermCode><ShipToCountry>HK</ShipToCountry>"+
	        "</EntitlementSummary>"+
	        "</EntitlementItem>";
        
        String csvExpected ="\"US\",\"MD07J123RT\",\"C7732A\",S,N,\"MD07J123RT\",\"C7730A\",\"HP ScanJet 4300C Scanner Engine only.\",false,2000-08-30,2001-11-28,false,,,\"Ship Date\",90,,S,\"3X\",,,\"HK\",,,,,,,,,,\r\n";
        String csvActual = null;
        
        try {
            csvActual=BatchxmlConverter.getInstance().XMLToCSV(xmlTest);
            assertTrue(compare(csvExpected,csvActual));
        } catch (SifException e) {
            Assert.fail();
        }  
    }*/
    
    
    /*
     * Comparison method, return tru, if both string are equals
     */
    public boolean compare(String csvExpected,String csvActual) {
        if (csvExpected.equals(csvActual)) {
            return true;
        }
        System.out.print("Expected : " +csvExpected);
        System.out.print("Actual   : " +csvActual);
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println("Test Starting.");
        BatchxmlConverterTest test = new BatchxmlConverterTest();
        test.testWithEntitlementSummaryNoOfferContract();
        
        
        
        System.out.println("End of test.");
    }    
    
    
    public void testFixTring1() {
        String stringToFix="product 1";
        String stringFixedExpected="\"product 1\"";
        String stringFixed= null;
        
        try {
            stringFixed= BatchxmlConverter.getInstance().fixString(stringToFix);
            assertTrue(stringFixed.equals(stringFixedExpected));
        } catch (Exception e) {
            Assert.fail();
        }          
    }
    
    public void testFixTring2() {
        String stringToFix="product 1 \"";
        String stringFixedExpected="\"product 1 \"\"\"";
        String stringFixed= null;
        
        try {
            stringFixed= BatchxmlConverter.getInstance().fixString(stringToFix);
            assertTrue(stringFixed.equals(stringFixedExpected));
        } catch (Exception e) {
            Assert.fail();
        }          
    }    
    
    public void testFixTring3() {
        String stringToFix=null;
        String stringFixedExpected="";
        String stringFixed= null;
        
        try {
            stringFixed= BatchxmlConverter.getInstance().fixString(stringToFix);
            assertTrue(stringFixed.equals(stringFixedExpected));
        } catch (Exception e) {
            Assert.fail();
        }          
    }        
    
    public void testFixTring4() {
        String stringToFix="";
        String stringFixedExpected="";
        String stringFixed= null;
        
        try {
            stringFixed= BatchxmlConverter.getInstance().fixString(stringToFix);
            assertTrue(stringFixed.equals(stringFixedExpected));
        } catch (Exception e) {
            Assert.fail();
        }          
    }      
    
    public void testFixTring5() {
        String stringToFix=" \"\" ";
        String stringFixedExpected="\"\"\"\"\"\"";
        String stringFixed= null;
        
        try {
            stringFixed= BatchxmlConverter.getInstance().fixString(stringToFix);
            assertTrue(stringFixed.equals(stringFixedExpected));
        } catch (Exception e) {
            Assert.fail();
        }          
    }       
    public void testFixTring6() {
        String stringToFix=" product 1 \n \" product 2 \" ";
        String stringFixedExpected="\"product 1 \n \"\" product 2 \"\"\"";
        String stringFixed= null;
        
        try {
            stringFixed= BatchxmlConverter.getInstance().fixString(stringToFix);
            assertTrue(stringFixed.equals(stringFixedExpected));
        } catch (Exception e) {
            Assert.fail();
        }          
    }        
    
     
    public void testFixTring7() {
        String stringToFix="Rmkt HP DesignJet 5500 print 60\" RTL Dye";
        String stringFixedExpected="\"Rmkt HP DesignJet 5500 print 60\"\" RTL Dye\"";
        String stringFixed= null;
        
        try {
            stringFixed= BatchxmlConverter.getInstance().fixString(stringToFix);
            assertTrue(stringFixed.equals(stringFixedExpected));
        } catch (Exception e) {
            Assert.fail();
        }          
    }      
    
    public void testUnMarshallXML1() {
        String xmlToUnMarshall=null;
        try {
            BatchxmlConverter.getInstance().unMarshallXML(xmlToUnMarshall);
            Assert.fail();
            
        } catch (SifException e) {
            Assert.assertEquals(true, true);
            
        }          
        
    }
    
    public void testUnMarshallXML2() {
        String xmlToUnMarshall="";
        try {
            BatchxmlConverter.getInstance().unMarshallXML(xmlToUnMarshall);
            Assert.fail();
            
        } catch (SifException e) {
            Assert.assertEquals(true, true);
        }          
        
    }
    
    
    public void testUnMarshallXML3() {
        String xmlToUnMarshall="NOT A XML MESSAGE";
        try {
            BatchxmlConverter.getInstance().unMarshallXML(xmlToUnMarshall);
            Assert.fail();
            
        } catch (SifException e) {
            Assert.assertEquals(true, true);
        }          
        
    }     
    
    
    public void testUnMarshallXML4() {
        String xmlToUnMarshall="<xml><TEST></TEST>";
        try {
            BatchxmlConverter.getInstance().unMarshallXML(xmlToUnMarshall);
            Assert.fail();
            
        } catch (SifException e) {
            Assert.assertEquals(true, true);
        }          
        
    }     
    
}
