/*
 * BatchFunctionnalTestCase.java
 * Created on 21 d�c. 2004
 *
 * Entitlement Service Project
 */
package com.hp.es.test.batchEntitlement;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.zip.ZipInputStream;

import com.hp.es.service.util.xml.MarshalHelper;
import com.hp.es.test.hpsetest.XMLFileUtil;
import com.hp.es.test.hpsetest.proxy.CastorObjectComparator;
import com.hp.es.xml.batchEntitlement.BatchEntitlement;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 *
 
 */
class BatchFunctionnalTestCase {

    String testCasePath=null;
    String testCaseName=null;
    String offerIncluded =null;
    String contractIncluded=null;
    
    String userFirstName= null;
    String userLastName= null;
    String userEmail= null;    
    
    String statusExpected=null;
    String errorMessageExpected=null;
    String expectedResultFile=null;
    String differenceDetails = null;

    int id;
    
    /**
     * @param testCaseName
     * @param offerIncluded
     * @param contractIncluded
     * @param userFirstName
     * @param userLastName
     * @param userEmail
     * @param statusExpected
     * @param errorMessageExpected
     * @param expectedResultFile
     */
    BatchFunctionnalTestCase(String testCasePath,String testCaseName , String offerIncluded,
            String contractIncluded, String userFirstName, String userLastName,
            String userEmail, String statusExpected,
            String errorMessageExpected, String expectedResultFile) {
        this.testCasePath = testCasePath;
        String repSeparator = System.getProperties().getProperty("file.separator");
        this.testCaseName = testCasePath+repSeparator+testCaseName;
        this.offerIncluded = offerIncluded;
        this.contractIncluded = contractIncluded;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.statusExpected = statusExpected;
        this.errorMessageExpected = errorMessageExpected;
        this.expectedResultFile = expectedResultFile;
    }
  
    /**
     * @return Returns the contractIncluded.
     */
    String getContractIncluded() {
        return contractIncluded;
    }
    /**
     * @param contractIncluded The contractIncluded to set.
     */
    void setContractIncluded(String contractIncluded) {
        this.contractIncluded = contractIncluded;
    }
    /**
     * @return Returns the errorMessageExpected.
     */
    String getErrorMessageExpected() {
        return errorMessageExpected;
    }
    /**
     * @param errorMessageExpected The errorMessageExpected to set.
     */
    void setErrorMessageExpected(String errorMessageExpected) {
        this.errorMessageExpected = errorMessageExpected;
    }
    /**
     * @return Returns the expectedResultFile.
     */
    String getExpectedResultFile() {
        return expectedResultFile;
    }
    /**
     * @param expectedResultFile The expectedResultFile to set.
     */
    void setExpectedResultFile(String expectedResultFile) {
        this.expectedResultFile = expectedResultFile;
    }
    /**
     * @return Returns the offerIncluded.
     */
    String getOfferIncluded() {
        return offerIncluded;
    }
    /**
     * @param offerIncluded The offerIncluded to set.
     */
    void setOfferIncluded(String offerIncluded) {
        this.offerIncluded = offerIncluded;
    }
    /**
     * @return Returns the statusExpected.
     */
    String getStatusExpected() {
        return statusExpected;
    }
    /**
     * @param statusExpected The statusExpected to set.
     */
    void setStatusExpected(String statusExpected) {
        this.statusExpected = statusExpected;
    }
    /**
     * @return Returns the testCaseName.
     */
    String getTestCaseName() {
        return testCaseName;
    }
    /**
     * @param testCaseName The testCaseName to set.
     */
    void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }
    
    
    /**
     * @return Returns the id.
     */
    int getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    void setId(int id) {
        this.id = id;
    }
    
    /*
     * Insert test case in database
     */
    void insertTestCaseInTestDatabase() throws Exception {
        File f = new File(testCaseName);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
        
        id= DBCSVLoader.insertTestCaseInDatabase(in, testCaseName, contractIncluded,offerIncluded, userFirstName, userLastName,userEmail);
        
    }
    
    /*
     * Look if test case is finished
     */
    boolean isTestCaseFinished() throws SQLException  {
        return DBTestCaseFileReader.isRequestIdFinished(id) ;
        
    }
    
    /*
     * Look if test case is finished
     */
    boolean compareWithDatabaseContent() throws SQLException  {
        /*
         * Let's compare in that order
         * status
         * errorMessage
         * xml content
         */
        boolean compareSuccess= true;
        differenceDetails ="";
        String statusActual = DBTestCaseFileReader.getStatusForRequestId(id);
        
        if(!statusExpected.equalsIgnoreCase(statusActual)) {
            compareSuccess = false;
            differenceDetails=differenceDetails+" Status differs,";
        }

        String errorMessageActual = 
            DBTestCaseFileReader.getErrorMessageForRequestId(id);

        
        if(! errorMessageExpected.equalsIgnoreCase(errorMessageActual) )  {
            compareSuccess = false;
            differenceDetails = differenceDetails + " Error Message differs,";
        }        

        
        
        /*
         * Now we comapre the blob
         */
        
        /* 
         * 
         */
        InputStream fromDb = DBTestCaseFileReader.getBlobFromDb(id);
   
        
        if(((fromDb== null) && 	!(expectedResultFile == null || expectedResultFile.trim().length()==0))
        ||((fromDb!= null) &&(expectedResultFile == null || expectedResultFile.trim().length()==0)))        {
            differenceDetails = differenceDetails + " XML file differs,";
        }else {
            ZipInputStream zippedContent =  new ZipInputStream(fromDb);
	        try {
	            //we read the first entry
	            zippedContent.getNextEntry();
	            InputStreamReader fileReader = new InputStreamReader( zippedContent, "UTF-8");
	            String xmlActual = XMLFileUtil.readerToString(fileReader);
	            
	            FileInputStream expectedFile = new FileInputStream(new File(expectedResultFile));
	            
	            fileReader = new InputStreamReader( expectedFile, "UTF-8");
	            String xmlExpected = XMLFileUtil.readerToString(fileReader);
	            
	            // We have first to marshall them
	            BatchEntitlement expectedObject = (BatchEntitlement)MarshalHelper.unmarshal(xmlExpected,new MetricsHandler(),BatchEntitlement.class);
	            BatchEntitlement actualObject = (BatchEntitlement)MarshalHelper.unmarshal(xmlActual,new MetricsHandler(),BatchEntitlement.class);
	            
	            CastorObjectComparator comp= new CastorObjectComparator(null);
	            
	            
	            if(!comp.compare(actualObject,expectedObject,"root")) {
		            compareSuccess = false;
		            writeActualResultToDisk(xmlActual);
		            differenceDetails = differenceDetails + " XML file differs," + comp.getDifferences();	                
	            }
	        } catch (IOException e) {
	            compareSuccess = false;
	            differenceDetails = differenceDetails + " XML file differs,";        
        	} catch (SifException e) {
        	    System.out.println("Execpetion while reading xml");
        	    
        	    e.printStackTrace();
	            compareSuccess = false;
	            differenceDetails = differenceDetails + " XML file differs,";     
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
    	}
        
        return compareSuccess;

        
    }
    
    
    
    
    
    /**
     * @param xmlActual
     */
    private void writeActualResultToDisk(String xmlActual) {
        FileOutputStream fos;
        OutputStreamWriter osw=null;
        try {
            String repSeparator = System.getProperties().getProperty("file.separator");
            fos = new FileOutputStream(testCasePath+repSeparator+"actual"+repSeparator+testCaseName+".xml");
            osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write(xmlActual,0,xmlActual.length());
            osw.flush();
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }finally {
            try {
                osw.close();
            }catch(Exception e) {};
        }

        
        
        
    }

    /**
     * @return Returns the userEmail.
     */
    String getUserEmail() {
        return userEmail;
    }
    /**
     * @param userEmail The userEmail to set.
     */
    void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    /**
     * @return Returns the userFirstName.
     */
    String getUserFirstName() {
        return userFirstName;
    }
    /**
     * @param userFirstName The userFirstName to set.
     */
    void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }
    /**
     * @return Returns the userLastName.
     */
    String getUserLastName() {
        return userLastName;
    }
    /**
     * @param userLastName The userLastName to set.
     */
    void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" testCaseName: " + testCaseName);
        sb.append(" ,offerIncluded: " + offerIncluded);
        sb.append(" ,contractIncluded: " + offerIncluded);
        return sb.toString();
    }
    /**
     * @return Returns the differenceDetails.
     */
    String getDifferenceDetails() {
        return differenceDetails;
    }
    /**
     * @param differenceDetails The differenceDetails to set.
     */
    void setDifferenceDetails(String differenceDetails) {
        this.differenceDetails = differenceDetails;
    }
}
