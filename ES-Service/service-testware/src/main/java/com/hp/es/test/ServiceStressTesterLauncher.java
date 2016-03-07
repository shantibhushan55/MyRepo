/*
 * Project: Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/test/ServiceStressTesterLauncher.java 1.19 2004-05-08 04:41:00+02 entitlem Exp $
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
 * $Log: ServiceStressTesterLauncher.java,v $
 * Revision 1.19  2004-05-08 04:41:00+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.18  2004-05-05 15:39:38+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.17  2004-01-29 18:05:16+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.16  2003-08-04 16:49:47+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.15  2003-05-12 01:58:09+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.14  2003-02-26 15:32:41+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.13  2003-01-22 15:26:51+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.12  2002-07-03 13:50:45+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.11  2002-06-14 17:16:36+02  lbednari
 * Author: lbednari@dhcp-15-198-6-111.bbn.hp.com ()
 * CODE MERGE WITH 2.0
 *
 * Revision 1.10  2002-05-22 08:50:00+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_0
 *
 * Revision 1.9  2002-03-27 16:18:59+01  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Change:

 *       remove dependencies with com.hp.es.util
 *
 * Revision 1.8  2002-03-14 15:33:43+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * dummy checkout for branch 1_0 creation
 *
 * Revision 1.7  2002-03-12 09:20:49+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * New version of test ware
 * Support EIA
 * Support modular build
 *
 * Revision 1.6  2002-02-28 10:30:42+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.5  2002-02-19 11:20:44+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.4  2002-02-19 11:20:03+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.3  2002-02-19 09:56:58+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.2  2002-02-18 18:58:22+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.1  2002-02-18 18:51:26+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * Initial revision
 *
 * Revision 1.3  2002-02-13 09:58:31+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.2  2002-02-12 14:48:07+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * Add load and stress test
 *
 * Revision 1.1  2002-02-12 14:43:15+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * Initial revision
 *
 * Revision 1.3  2002-02-11 18:39:20+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.2  2002-02-11 16:41:57+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.1  2002-02-11 13:03:16+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * Initial revision
 *
 * Revision 1.3  2002-02-08 11:13:08+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.2  2002-02-08 09:18:18+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.1  2002-02-07 14:08:27+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * Initial revision
 *
 * Revision 1.18  2002-02-07 10:13:05+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 */
package com.hp.es.test;
import java.util.Enumeration;

import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestResult;

import com.clarkware.junitperf.ConstantTimer;
import com.clarkware.junitperf.LoadTest;
import com.hp.es.test.hpsetest.ReportBuilder;
import com.hp.es.test.hpsetest.ServiceTesterUtil;
import com.hp.es.test.hpsetest.TestConfigHolder;
import com.hp.es.test.hpsetest.UnitTestCase;






/*
* The launcher that is used to launch the Test case suite
*/

public class ServiceStressTesterLauncher  {

    public ServiceStressTesterLauncher() {
    }


   /*
    * This Method defines the test suite
    * This is used to defined the suite of test case that are going to be used
    */
    public static Test suite() { 
        return UnitTestCase.suite();
    }  


    /*
        Main Method this execute all the test that are configured 
    */
    public static void main(String[] args) {
        Enumeration e;    
        int nbuser    = (new Integer(TestConfigHolder.getInstance().getConfigParameter("hpse.test.load.nbuser", "1"))).intValue();
        int delay     = (new Integer(TestConfigHolder.getInstance().getConfigParameter("hpse.test.load.delay" , "0"))).intValue();
        long waitTime = (new Long(TestConfigHolder.getInstance().getConfigParameter("hpse.test.stress.delay" , "0"))).longValue();
        long duration = (new Long(TestConfigHolder.getInstance().getConfigParameter("hpse.test.stress.duration" , "0"))).longValue() * 1000;
        boolean success = true;
        long end = System.currentTimeMillis() +duration;
        ConstantTimer ct = new ConstantTimer(delay);
        
        System.out.println("Java properties" + System.getProperties());
        
        ServiceTesterUtil.initReportFileAndDumpFile("Test"+"_"+nbuser);    
        ServiceTesterUtil.dump(ReportBuilder.getInstance().getReportHeader());

        ReportBuilder.getInstance().init();
        ReportBuilder.getInstance().setTestTitle("Stress test will start with "+nbuser+" users with a delay of "+delay+"ms");
        System.out.println("Stress test will start with "+nbuser+" users with a delay of "+delay+"ms");
        
        while(true) {

            Test test = suite();
            TestResult tr = new TestResult();
            
                
            Test loadTest = new LoadTest(test, nbuser,ct);
            loadTest.run(tr);    

            if(!tr.wasSuccessful()) {
                if(tr.errorCount() > 0) {
                    
                    e = tr.errors();
                    int errorNumber =1;
                    
                    while (e.hasMoreElements()) {
                        Object t = (Object) e.nextElement();
                        ReportBuilder.getInstance().addError("\n\t Error " + errorNumber + " is : \n" +"\n\t\t "+t.toString()+"\n" );
                        errorNumber++;
                    }

                }
                
                if(tr.failureCount() > 0) {
                    
                    e = tr.failures();
                    int failureNumber =1;
                    while (e.hasMoreElements()) {
                        TestFailure tf = (TestFailure)e.nextElement();         
                        ReportBuilder.getInstance().addFailure("\t Test Failure "+failureNumber+" is : \n" +"\n\t\t "+tf.toString()+"\n");
                        failureNumber++;
                    }
                }
                success = false;
            }
            
            
            try {
            	ServiceTesterUtil.appendReportToAFile(ReportBuilder.getInstance().getReport());
                Thread.sleep(waitTime);
            }catch(InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.print("-");
            if(System.currentTimeMillis() >= end) {
                break;
            }
            
        }
        
        
        System.out.println(ReportBuilder.getInstance().getReport());
        
        if(success) {
            System.exit(0);
        }else {
            System.exit(1);            
        }
        
        
       
    }
}
//EOF
