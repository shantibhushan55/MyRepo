/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/serviceHandler/OperationManagerTest.java 1.9 2004-05-08 04:40:55+02 entitlem Exp $
 *
 * Copyright (c) 2002 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * $Log: OperationManagerTest.java,v $
 * Revision 1.9  2004-05-08 04:40:55+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:39:34+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-01-29 18:05:11+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.6  2003-10-14 14:36:40+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * add tests for different failover modes (never, always, normal)
 *
 * Revision 1.5  2003-08-19 13:35:58+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * change imports
 *
 * Revision 1.4  2003-08-04 16:49:44+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.3  2003-05-12 01:58:05+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.2  2003-04-28 12:27:44+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * update package name
 *
 * Revision 1.1  2003-04-04 14:58:35+02  stefsobe
 * Author: stefsobe@dhcp-15-198-3-24.bbn.hp.com ()
 * Initial revision
 *
 */

package com.hp.es.service.operations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.hp.ruc.util.ClassPath;

/**
 * JUnit test case for OperationManager
 */
public class OperationManagerTest extends TestCase {

   private final String propertiesFile = "OperationManagerTest.properties";

    public OperationManagerTest(String inName) {
        super(inName);
    }

    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(OperationManagerTest.class);
    }
 
    public static void main(String[] args) {
    //  OperationManagerTest o = new OperationManagerTest("test");
    //  o.testOperationManager();
        junit.textui.TestRunner.run(suite());
    }

   /**
    * Test if the configured operations are returned by the OperationManager
    * and if the OperationManager reinitializes correctly when the properties
    * changes. Following tests are done in one method, because one test step
    * depends on the previous one.
    * <ul>
    * <li>test if the properties file and reload interval can be overwritten
    *     by system properties
    * <li>test if OperationManager is accessible
    * <li>test if that null is returned for operations that are not configured
    * <li>test if public and private operations are accessible via the
    *     corresponding methods of the OperationManager
    * <li>test if reload works correctly when config file has changed
    * </ul>
    */
    public void testOperationManager() {
        try {
            // =================================================================
            // overwrite the file name of the properties file and the
            // reload interval for the properties file
            System.setProperty(
                "com.hp.es.serviceHandler.OperationManager.file",
                propertiesFile);
            System.setProperty(
                "com.hp.es.serviceHandler.OperationManager.configReloadInterval",
                "1");  // check every second

            // =================================================================
            // Create properties
            Properties props = new Properties();
            // Note: The FailoverOperation is used because this operation is
            // always available.
            props.setProperty("test.operation.op1.class",
                              "com.hp.es.serviceHandler.FailoverOperation");
            props.setProperty("test.failoverDuration",
                              "1");
            saveProperties(props);

            // =================================================================
            // get the OperationManager
            OperationManager m = null;
            try {
                m = OperationManager.getInstance("test");
            } catch(Exception e) {
                fail("OperationManager.getInstance(\"test\") failed: " +
                     toTrace(e));
            }
   
            // =================================================================
            // check for operation that are not configured
            Operation op = m.getAnyOperation("notConfigured");
            assertTrue("The OperationManager should return null for " +
                       "operations that are not configured.",
                       op==null);
   
            // =================================================================
            // check for operations that are configured
            // make sure that getAnyOperation() and getPublicOperation()
            // return the same operation
            op = m.getAnyOperation("op1");
            assertTrue("The OperationManager should not return null for " +
                       "operations that are configured.",
                       op!=null);
            assertTrue("The OperationManager should not return null for " +
                       "operations that are configured.",
                       op.getClass().getName().equals(
                       "com.hp.es.serviceHandler.FailoverOperation"));

            Operation op2 = m.getPublicOperation("op1");
            assertTrue("A public operation must be accessible via the " +
                       "getAnyOperation() and getPublicOperation().",
                       op==op2);

            // =================================================================
            // change properties
            props.setProperty("test.operation.op1.scope", "private");
            props.setProperty("test.operation.op2.class",
                              "com.hp.es.serviceHandler.FailoverOperation");
            saveProperties(props);
   
            // =================================================================
            // wait until the OperationManager should be reinitialized
            Thread.sleep(2000);
            op = m.getAnyOperation("op2");
            assertTrue("The OperationManager was not reinitialized when " +
                       "the operaties file was changed.",
                       op!=null);

            // =================================================================
            // make sure that the handling of public/private operations is
            // correct after the reload
            op = m.getAnyOperation("op1");
            assertTrue("The getAnyOperation() OperationManager should " +
                       "not return null for private operations.",
                       op!=null);
            op = m.getPublicOperation("op1");
            assertTrue("The getPublicOperation() OperationManager should " +
                       "return null for public operations.",
                       op==null);
        } catch (Exception e) {
            fail("Unexpected exception: " + toTrace(e));
        }
   }

   /**
    * print stack trace
    */
   private String toTrace(Throwable inThrowable) {
      StringWriter sw = new StringWriter();
      PrintWriter printWriter = new PrintWriter(sw);
      printWriter.println();
      inThrowable.printStackTrace(printWriter);
      printWriter.flush();
      return sw.toString();
   }

   /**
    * Save the properties somewhere in the class path
    */
   private void saveProperties(Properties props) {

      // get the first directory in the class path
      String dir = (String)(new ClassPath()).getDirectoryIterator().next();

      FileOutputStream fos = null;
      try {
         fos = new FileOutputStream(dir + propertiesFile);
         props.store(fos, "");
         fos.close();
      } catch (IOException io) {
      }
   }
}
