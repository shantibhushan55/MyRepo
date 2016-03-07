/*
 * Project: Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/test/ServiceLoadTesterLauncher.java 1.20 2004-05-08 04:40:59+02 entitlem Exp $
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
 * $Log: ServiceLoadTesterLauncher.java,v $
 * Revision 1.20  2004-05-08 04:40:59+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.19  2004-05-05 15:39:38+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.18  2004-01-29 18:05:15+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.17  2003-08-04 16:49:47+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.16  2003-05-12 01:58:08+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.15  2003-02-26 15:32:40+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.14  2003-01-22 15:26:50+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.13  2002-07-03 13:50:44+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.12  2002-06-14 17:16:35+02  lbednari
 * Author: lbednari@dhcp-15-198-6-111.bbn.hp.com ()
 * CODE MERGE WITH 2.0
 *
 * Revision 1.11  2002-05-22 08:49:59+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_0
 *
 * Revision 1.10  2002-05-16 11:50:18+02  ANVOI
 * Author: ANVOI@dhcp-15-130-70-149.france.hp.com ()
 * no comment
 *
 * Revision 1.9  2002-03-27 16:18:58+01  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Change:

 *       remove dependencies with com.hp.es.util
 *
 * Revision 1.8  2002-03-14 15:33:43+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * dummy checkout for branch 1_0 creation
 *
 * Revision 1.7  2002-03-12 09:20:48+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * New version of test ware
 * Support EIA
 * Support modular build
 *
 * Revision 1.6  2002-02-28 10:30:41+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.5  2002-02-13 09:58:33+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * no comment
 *
 * Revision 1.4  2002-02-12 14:48:08+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * Add load and stress test
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

public class ServiceLoadTesterLauncher  {

    public ServiceLoadTesterLauncher() {
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
    public static void main(String[] args) throws InterruptedException {
        Enumeration e;     
            
        ServiceTesterUtil.initReportFileAndDumpFile("Test");
        ServiceTesterUtil.dump(ReportBuilder.getInstance().getReportHeader());
            
        int nbuser = (new Integer(TestConfigHolder.getInstance().getConfigParameter("hpse.test.load.nbuser", "1"))).intValue();
        int delay = (new Integer(TestConfigHolder.getInstance().getConfigParameter("hpse.test.load.delay" , "0"))).intValue();
        int nbiteration     = (new Integer(TestConfigHolder.getInstance().getConfigParameter("hpse.test.load.nbiteration" , "1"))).intValue();            
        
            
        ReportBuilder.getInstance().init();
        ReportBuilder.getInstance().setTestTitle("Load test will start with "+nbuser+" users with a delay of "+delay+"ms and "+nbiteration+"iterations");
        System.out.println("Load test will start with "+nbuser+" users with a delay of "+delay+"ms and "+nbiteration+"iterations");
        
            
        Test test = suite();
        TestResult tr = new TestResult();
            
        long waitTime= delay*2;
            
        for(int i =0; i< nbiteration; i++) {
        	ConstantTimer ct = new ConstantTimer(delay);
        	Test loadTest = new LoadTest(test, nbuser,ct);
            loadTest.run(tr);
            System.out.println("Iteration "+i);
            try {
                Thread.sleep(waitTime);
            }catch(InterruptedException ie) {
                ie.printStackTrace();
            }            
        }            
            
        if(!tr.wasSuccessful()) {
                
            if(tr.errorCount() > 0) {
                    
                e = tr.errors();
                int i =1;
                    
                while (e.hasMoreElements()) {
                    Object t = (Object) e.nextElement();
                    ReportBuilder.getInstance().addError("\n\t Error " + i + " is : \n" +"\n\t\t "+t.toString()+"\n" );
                    i++;
                }

            }
                
            if(tr.failureCount() > 0) {
                    
                e = tr.failures();
                int i =1;
                while (e.hasMoreElements()) {
                    TestFailure tf = (TestFailure)e.nextElement();         
                    ReportBuilder.getInstance().addFailure("\t Test Failure "+i+" is : \n" +"\n\t\t "+tf.toString()+"\n");
                    i++;
                }
            }
            System.out.println(ReportBuilder.getInstance().getReport());
            ServiceTesterUtil.writeReportToAFile(ReportBuilder.getInstance().getReport());                
            System.exit(1);
        }else {
            System.out.println(ReportBuilder.getInstance().getReport());
            ServiceTesterUtil.writeReportToAFile(ReportBuilder.getInstance().getReport());                
            System.exit(0);                
        }
            

            
 
    }
}
//EOF
