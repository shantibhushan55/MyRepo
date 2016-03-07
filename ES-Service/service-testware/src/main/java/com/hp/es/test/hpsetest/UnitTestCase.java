/*
 * Project: Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/test/hpsetest/UnitTestCase.java 1.54 2004-05-08 04:41:12+02 entitlem Exp $
 *
 * Copyright (c) 2001 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * $Log: UnitTestCase.java,v $
 * Revision 1.54  2004-05-08 04:41:12+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.53  2004-05-05 15:39:52+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.52  2004-02-03 16:18:24+01  stefsobe
 * Author: stefsobe@sobesteffen ()
 * remove ACME
 *
 * Revision 1.51  2004-01-29 18:05:30+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.50  2003-08-22 11:56:50+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * enable ACME functionality
 *
 * Revision 1.49  2003-08-04 16:50:02+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.48  2003-05-30 18:01:31+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * removing dependencies on the pre-ES4.0 castor types (HpseCastor.jar)
 *
 * Revision 1.47  2003-05-27 04:01:18+02  lbednari
 * Author: lbednari@bbnnaid189.bbn.hp.com ()
 * - merged changes from branch 5_0C2
 *
 * Revision 1.46  2003-05-20 16:39:04+02  THPO
 * Author: THPO@dhcp-15-197-230-88.bbn.hp.com ()
 * there is now an "eia_raw" dir that logs the actuals with EIA envelope
 *
 * Revision 1.45  2003-05-12 01:58:22+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.44  2003-04-09 12:46:31+02  thpo
 * Author: thpo@dhcp-15-198-7-216.bbn.hp.com ()
 * supressing another exception
 *
 * Revision 1.43  2003-04-09 11:33:56+02  thpo
 * Author: thpo@dhcp-15-198-7-216.bbn.hp.com ()
 * supressing an exception
 *
 * Revision 1.42  2003-04-08 16:24:17+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * ACME stuff commented out
 *
 * Revision 1.41  2003-04-04 12:30:13+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * not anymore using "indexof", but "startswith", since EsReply may
 * contain EIAError, which will make this class confused
 *
 * Revision 1.40  2003-03-20 09:11:07+01  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * fixed typo
 *
 * Revision 1.39  2003-03-19 19:31:51+01  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * No support ignore lists, "default.ignore" or "testcase.ignore".
 * These lists carry regular expressions to ignore certain elements in the
 * XML path.
 *
 * Revision 1.38  2003-02-26 15:32:51+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.37  2003-01-22 15:27:04+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.36  2002-10-31 14:56:10+01  lbednari
 * Author: lbednari@dhcp-15-198-5-221.bbn.hp.com ()
 * - sorting of file names moved to XMLFileUtil
 *
 * Revision 1.35  2002-10-31 14:28:18+01  lbednari
 * Author: lbednari@dhcp-15-198-5-221.bbn.hp.com ()
 * - removed usage of unnecessary Vector

 * - request files sorted before adding test cases to the suite

 * - actual & expect files are palced into own directory

 * - actual & expect files omit EIA header/trailer and are indented regardless

 *   of castor.properties
 *
 * Revision 1.34  2002-10-15 20:18:23+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * run actual/expected xmls through castor before writing to files

 * (trying to get castor indents)
 *
 * Revision 1.33  2002-10-15 20:14:31+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * now writing actual and expected xml files separately when

 * comparison fails, so facilitate comparison
 *
 * Revision 1.32  2002-07-03 13:50:57+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.31  2002-05-22 08:50:11+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_0
 *
 * Revision 1.30  2002-05-13 21:02:51+02  ANVOI
 * Author: ANVOI@bbnnaid77.bbn.hp.com ()
 * Add performance Report
 *
 * Revision 1.29  2002-05-03 13:46:37+02  ANVOI
 * Author: ANVOI@bbnnaid72.bbn.hp.com ()
 * no comment
 *
 * Revision 1.28  2002-04-03 09:55:04+02  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Change presentation of the generated error report
 *
 * Revision 1.27  2002-03-29 09:59:13+01  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Change :

 *    - utf8 reading from file system

 *    - added javadoc

 *    - reformat file
 *
 * Revision 1.26  2002-03-27 09:58:23+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * Change added for the eia migration
 *
 * Revision 1.25  2002-03-14 15:33:45+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * dummy checkout for branch 1_0 creation
 *
 * Revision 1.24  2002-03-12 09:21:20+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * New version of test ware
 * support EIA
 * support modular build
 *
 * Revision 1.23  2002-02-11 11:22:22+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.22  2002-02-08 09:18:56+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.21  2002-02-07 15:02:30+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.20  2002-02-07 15:01:00+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.19  2002-02-07 14:02:20+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.18  2002-02-07 10:13:05+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 */
package com.hp.es.test.hpsetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.es.service.util.xml.MarshalHelper;
import com.hp.es.test.hpsetest.proxy.ServiceTesterProxy;
import com.hp.es.tools.IndentXml;
import com.hp.es.xml.service.EIAError;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.types.MessageTypeType;

public class UnitTestCase extends TestCase {



    /**
     * Suffix for actual & expect subdirs in report dir
     */
    private static String _dateTimeSuffix = (new java.text.SimpleDateFormat("yyyyMMdd_HHmm")).format(new Date());

    /*
    The file name that will be used for testing
    */
    private String _fileName = "";

    /**
     * ignoreList a list of Jakarta ORO regular expressions to ignore certain tree parts, i.e. \"/EsReply/EsHeader/TransactionID\" or \"/EsReply/EsHeader/InputRequest.*\"
     */
    private String [] _globalIgnoreList;

    /*
    * The proxy used to access the server to test
    * shared among test case instances)
    */
    private static ServiceTesterProxy _stp;

    /**
     * init method.
    */
    static {
        _stp = ServiceTesterProxy.getServiceTesterProxy();
        _stp.init();
    }


    /**
     * The constructor with the test name.
     * extends junit
     * @param name of the test case (this would be the function called by junit)
     * @param fileName (the xml test case)
     * @param globalIgnoreList
    */
    public UnitTestCase(String name, String fileName, String[] globalIgnoreList) {
        super(name);
        _fileName = fileName;
        _globalIgnoreList = globalIgnoreList;
    }

    /*
    * This Method defines the test suite
    * this test suite is automaticly generated
    * with the test that are present here.
    */
    public static Test suite() {
        TestSuite suite= new TestSuite();
        String[] fileNames = null;

        //Load the list of file (we only take care about request xml files)
        fileNames = XMLFileUtil.loadListOfRequestFile();

        String [] globalIgnoreList = XMLFileUtil.loadIgnoreList("default.ignore");

        if (globalIgnoreList == null) {
            globalIgnoreList = new String [] {};
        }

        StringBuffer sb = new StringBuffer();
        sb.append("\nDEFAULT IGNORE LIST = \n");
        for (int i=0; i<globalIgnoreList.length; i++) { 
        		sb.append(globalIgnoreList[i] + "\n");
        }
        sb.append("(END OF DEFAULT IGNORE LIST)\n\n");
        ServiceTesterUtil.dump(sb.toString());
        System.out.println(sb.toString());

        //Build a list of test case
        if ( fileNames.length == 0 ) {
            System.out.println("UnitTestCase suite is empty.");
        } else {
            for (int i=0; i<fileNames.length; i++) {
                String [] ignoreList;
                String [] localIgnoreList = XMLFileUtil.loadIgnoreList(fileNames[i] + ".ignore");
                if (
                    (localIgnoreList != null) &&
                    (localIgnoreList.length > 0)
                ) {
                    if (localIgnoreList[0].equals("localIgnoreList")) {
                        ignoreList = new String[localIgnoreList.length - 1];
                        System.arraycopy(localIgnoreList, 1, ignoreList, 0, localIgnoreList.length - 1);
                    } else {
                        ignoreList = new String[globalIgnoreList.length  + localIgnoreList.length];
                        System.arraycopy(globalIgnoreList, 0, ignoreList, 0, globalIgnoreList.length);
                        System.arraycopy(localIgnoreList, 0, ignoreList, globalIgnoreList.length, localIgnoreList.length);
                    }
                } else {
                    ignoreList = globalIgnoreList;
                }

                if ( (ignoreList != null ) && (ignoreList.length > 0) ) {
                    sb = new StringBuffer();
                    if (
                        (localIgnoreList != null) &&
                        (localIgnoreList.length > 0)
                    ) {
                    sb.append("Ignore list for test " + fileNames[i] + " follows: (entries starting with \"#\" will be ignored) \n");
                    for (int ignore=0; ignore<ignoreList.length; ignore++) {
                        sb.append("      " + ignoreList[ignore] + " \n");
                        }
                    } else {                    	
                    	sb.append("Ignore list for test " + fileNames[i] + " = default.ignore \n");
                    }
                    //sb.append("\n");
                    ServiceTesterUtil.dump(sb.toString());
                    //System.out.println(sb.toString());
                }

                suite.addTest(new UnitTestCase("fileUnitTest",fileNames[i], ignoreList));
            }
        }

        return suite;
    }

    /*
    * JUNIT Method
    * Set up some stuff for a test case
    */
    protected void setUp() {

    }



    /*
    * The unit test method
    * It will read the xml file
    * send it to the framework and compare with the expected result
    * If comparaison is ok the test is a success
    * If not it is a failure
    */
    public void fileUnitTest()  {
        //The request and the reply
        String requestXml, replyXml;
        //The begin (to measure time taken)
        long timeBegin =0;
        long timeEnd=0;
        long timeTaken =0;
        try {
            //Just a debug output to show progress
        	System.out.print("/");

            //Read the xml file
            requestXml = XMLFileUtil.readFile(TestConfigHolder.getInstance().getConfigParameter("hpse.test.requestdir"), _fileName);

            //Start timer
            timeBegin =  System.currentTimeMillis();

            //Send request and receive result
            replyXml = _stp.sendRequest(requestXml);

            //Stop timer
            timeEnd = System.currentTimeMillis();
            timeTaken = timeEnd - timeBegin;

            //Compare exepected with actual result
            if(! compareWithExpectedResult(replyXml, _globalIgnoreList)) {
                //If comparison failed we raise an exception to the junit framework
                throw new AssertionFailedError("Test "+ _fileName +" is not ok : comparison failed");
            }
            ReportBuilder.getInstance().addPerformance(_fileName, timeTaken, true);

        }catch(AssertionFailedError afe) {
            ReportBuilder.getInstance().addPerformance(_fileName, timeTaken, false);
            throw afe;
        }catch(Throwable t) {
            if(timeEnd==0) {
                timeTaken=-1;
            }
            ReportBuilder.getInstance().addPerformance(_fileName, timeTaken, false);
            //We catch all execption (also error)
            //We dump it into the error file
            ServiceTesterUtil.dump("\n************************************************************************************************\n");
            ServiceTesterUtil.dump("Error for:"+_fileName+"\n");
            ServiceTesterUtil.dump(t);
            ServiceTesterUtil.dump("\n************************************************************************************************\n");
            throw new AssertionFailedError("Test "+ _fileName +" does not work error is : "+t.getMessage());

        }finally {
            //We write the result of the test into the report file
            if(Boolean.valueOf(TestConfigHolder.getInstance().getConfigParameter("hpse.test.gatherperformancedata", "true")).booleanValue()) {
                if(timeEnd==0) {
                    timeTaken=-1;
                }
                ReportBuilder.getInstance().addTest(_fileName, timeTaken);
            }else {
                ReportBuilder.getInstance().addTest(_fileName, 0);
            }
            System.out.print("\\");
        }
    }//end of fileUnitTest

    /*
    * Compare the actual result and the expected result
    * @param actualXml : the actual reply as a string
    * @return true (if compare is true)
    * @exception java.lang.Exception (we do noting about it at this level)
    */
    private boolean compareWithExpectedResult(String actualXml, String [] globalIgnoreList)  {
        String     expectedXml = "";
        boolean    resultsAreSame = false;

        try {
            expectedXml = XMLFileUtil.readFile(TestConfigHolder.getInstance().getConfigParameter("hpse.test.replydir"), _fileName);
            // todo: merge with ignore list for dedicated test
            actualXml = actualXml.trim();
            actualXml = actualXml.replaceAll("&#xd;\n", "&#xd;");

            expectedXml = expectedXml.trim();
            resultsAreSame = _stp.compareTwoMessage(actualXml, expectedXml, globalIgnoreList);

            if ( ! resultsAreSame) {
                ServiceTesterUtil.dump(actualXml,expectedXml,_fileName);

                // also dump individual actual and expected xml files for easier comparison
                dumpXmlFile(actualXml,   "actual");
                dumpXmlFile(actualXml,   "eia_raw");
                dumpXmlFile(expectedXml, "expect");
            }
        }catch(Exception e) {
            ServiceTesterUtil.dump("\n************************************************************************************************\n");
            ServiceTesterUtil.dump("Exception in comparison for:"+_fileName+"\n");
            ServiceTesterUtil.dump(e);
            ServiceTesterUtil.dump(actualXml,expectedXml,_fileName);

            throw new AssertionFailedError("Test "+ _fileName +" does not work => Exception in comparison : "+e.getMessage());

        }

        return resultsAreSame;
    }

    private void dumpXmlFile(String fileContent, String fileType) {
        try {
            // check first if the actual & expect subdirs exist
            // if not then create them
            File reportDir = new File(TestConfigHolder.getInstance().getConfigParameter("hpse.test.reportdir"));
            File actualDir =null;
            File eia_rawDir =null;
            File expectDir = null;
            if (ServiceTesterUtil.getNameOfTestSuite()!= null && ServiceTesterUtil.getNameOfTestSuite().trim().length() >0) {
	            actualDir = new File(reportDir, "actual_" +ServiceTesterUtil.getNameOfTestSuite()+ "_"+_dateTimeSuffix);
	            eia_rawDir = new File(reportDir, "eia_raw_" +ServiceTesterUtil.getNameOfTestSuite()+"_"+ _dateTimeSuffix);
	            expectDir = new File(reportDir, "expect_" +ServiceTesterUtil.getNameOfTestSuite()+"_"+ _dateTimeSuffix);
            }else {
	            actualDir = new File(reportDir, "actual_" + _dateTimeSuffix);
	            eia_rawDir = new File(reportDir, "eia_raw_" + _dateTimeSuffix);
	            expectDir = new File(reportDir, "expect_" +_dateTimeSuffix);
	            	
	         }
            if ( ! actualDir.isDirectory() ) actualDir.mkdirs();
            if ( ! eia_rawDir.isDirectory() ) eia_rawDir.mkdirs();
            if ( ! expectDir.isDirectory() ) expectDir.mkdirs();

            // Create dump file in the right subdir
            File dumpFile = null;
            if ( "actual".equals(fileType) ) {
                dumpFile = new File(actualDir, _fileName);
            } else if ( "eia_raw".equals(fileType) ) {
                dumpFile = new File(eia_rawDir, _fileName);
            } else if ( "expect".equals(fileType) ) {
                dumpFile = new File(expectDir, _fileName);
            } else {
                dumpFile = new File(reportDir, "unknown_" + _fileName);
            }

            // trying to get castor indentation of our xml files
            //String castoredFileContent = EIADocumentHandler.transformEIAMessageIntoCastorXML(EIADocumentHandler.readEIAMessage(fileContent));

            
            String castoredFileContent = "";

            // if anything fails in marshalling, track this but do not fail here
            try {
                // Get castor indentation & ignore EIA header/trailer
                EIAMessage message = MarshalHelper.unmarshalUsingEIAMappingFile(fileContent,null);

                if ( "eia_raw".equals(fileType) ) {
                    castoredFileContent = fileContent;
                } else if (message.getMessageHeader().getMessageType().equals(MessageTypeType.ERROR)) {
                    
                    EIAError err = message.getMessageBody().getEIAError();
                    castoredFileContent = MarshalHelper.marshal(err,null);
                    IndentXml ind = new IndentXml();
                    castoredFileContent = ind.writeFormattedString(castoredFileContent);
                    
                }  else if (message.getMessageHeader().getMessageType().equals(MessageTypeType.REPLY)) {
                    
                	EsReply reply = message.getMessageBody().getEsReply();
                    castoredFileContent = MarshalHelper.marshal(reply,null);
                    IndentXml ind = new IndentXml();
                    castoredFileContent = ind.writeFormattedString(castoredFileContent);
                    
                    
                } else {
                    // give up - we don't know the type of content
                	//This case doess not exist any more
                    castoredFileContent = "";
                }
            } catch (Exception ex) {

            	castoredFileContent = "Error unable to get MSG body: " + ex.toString();
            }

            FileOutputStream fos = new FileOutputStream(dumpFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write(castoredFileContent,0,castoredFileContent.length());
            osw.flush();
            osw.close();

        } catch (FileNotFoundException e) {
            System.out.println("FAILED TO DUMP EIA XML MESSAGE (see below)");			e.printStackTrace();
		} catch (IOException e) {
            System.out.println("FAILED TO DUMP EIA XML MESSAGE (see below)");
			e.printStackTrace();
		}
    }
}
//EOF
