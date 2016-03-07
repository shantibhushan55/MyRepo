/*
 * BatchFunctionnalTest.java
 * Created on 21 2004
 *
 * Entitlement Service Project
 */
package com.hp.es.test.batchEntitlement;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.hp.ruc.io.CsvReader;

/**
 * @author ANVOI
 *

 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BatchFunctionnalTest {
    ArrayList arrayTestCases = new ArrayList();
    //max wait time in ms
    //30*60*1000
    long maxwaitime;
    String pathName=null;
    /**
     * 
     */
    public BatchFunctionnalTest() {
        super();

    }

    /*
     * 	Main method, it is called to strart the programm
     * 
     */
    public static void main(String[] args) {
        /*
         * Synopsis
         * 	 Open the list_test.csv file
         *   read all line
         * 	 for each line
         * 	    load it in database and stored id locally
         * 	 end for
         *   wait until all entries previously entered in database are setted to failed or sent
         *   compare actual results to expected
         * 
         * This is requireing to have a valid db.properties file
         */
        
        // we expect to get the csv with the test cases as input parameters
        // This CSV should have this format (test case, include offer, include contract, 
        // user first name, user last name, user email
        //status expected, error message expected, expected result file 
        if (args[0].length()<2) {
            System.out.println("Please specify the name of the file containing the test cases and the max waiting time in minutes");
        }
        
        BatchFunctionnalTest test = new BatchFunctionnalTest();
        test.maxwaitime=Integer.parseInt(args[1])*60*1000;
        test.execute(args[0]);
    }
    
    /*
     * Execute method
     */
    void execute(String args) {
        try {
            String testCasesListName = args.trim();
            File testcaseFile = new File(testCasesListName);
            String repSeparator = System.getProperties().getProperty("file.separator");
            pathName= testCasesListName.substring(0,testCasesListName.lastIndexOf(repSeparator));
            
            CsvReader csvReader = new CsvReader(new InputStreamReader(new FileInputStream(testcaseFile)));
            csvReader.skipToNextLine();//We skip first line
            do {
                String[] fields = csvReader.getAllFieldsInLine();
                String testCaseName=fields[0];
                String offerIncluded =fields[1];
                String contractIncluded=fields[2];
                
                String userFirstName=fields[3];
  //              String userLastName=fields[4];
                String userEmail=fields[5];
                
                String statusExpected=fields[6];
                String errorMessageExpected=fields[7];
                String expectedResultFile=fields[8];
                
                BatchFunctionnalTestCase testCase = 
                    new BatchFunctionnalTestCase(pathName,testCaseName,offerIncluded,contractIncluded,userFirstName,userFirstName,userEmail,statusExpected,errorMessageExpected,pathName+repSeparator+expectedResultFile);
                testCase.insertTestCaseInTestDatabase();
                arrayTestCases.add(testCase);
            } while (true);
            
            
            
            
        } catch (EOFException e) {
            // ignore. we reached the end of the file
        } catch (IOException e) {
            System.out.println("Test cases list file is corrupted or not existing.");
//            System.exit(-1);
        } catch (Exception e) {
            System.out.println("Issue while loading test cases.");
            e.printStackTrace();            
//            System.exit(-1);
        } 
        
        
        //Now we are going to wait until all test case finished
        InnerWaitBatchFunctionnalTest wait= new InnerWaitBatchFunctionnalTest(this);
        wait.start();
        try {
            wait.join();
        } catch (InterruptedException e1) {
            System.out.println("Issue while loading test cases.");
            e1.printStackTrace();            
//            System.exit(-1);
        }
        
        //Now all test cases are finished or we are borred of waiting
        //Lets' play the comparison game
        try {
	        for (int i=0;i<arrayTestCases.size();i++) {
	            BatchFunctionnalTestCase test = (BatchFunctionnalTestCase)arrayTestCases.get(i);
	            boolean testResult;
	
	                testResult = test.compareWithDatabaseContent();

	            if(!testResult) {
	                System.out.println("Test case id "+test.getId() +" details "+ test.toString() +" failed, reason: "+test.getDifferenceDetails()+".");
	            }else {
	                System.out.println("Test case id "+test.getId() +" details "+ test.toString()+ " succeeded.");
	            }
	        } 
        } catch (Exception e2) {
            System.out.println("Issue while loading test cases.");
            e2.printStackTrace();            
//            System.exit(-1);
        }
//        System.exit(0);
        
    }
    /**
     * @return Returns the pathName.
     */
    public String getPathName() {
        return pathName;
    }
}
class InnerWaitBatchFunctionnalTest extends Thread {
    BatchFunctionnalTest parent=null;
    public InnerWaitBatchFunctionnalTest(BatchFunctionnalTest parentParam) {
        parent=parentParam;

    }
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        try {
            long timeToStop=System.currentTimeMillis() + parent.maxwaitime ;
            while(true) {
                
                Thread.sleep(60000);
                boolean testIsFinished= true;
                for (int i=0;i<parent.arrayTestCases.size();i++) {
                    BatchFunctionnalTestCase test = (BatchFunctionnalTestCase)parent.arrayTestCases.get(i);
                    testIsFinished= testIsFinished && test.isTestCaseFinished();
                }
                if(testIsFinished) {
                    //All test cases succeeded so we can stop waiting
                    break;
                }
                if(System.currentTimeMillis() > timeToStop) {
                    System.out.println("Thread waited too long, we stop");
                }
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }   
}

