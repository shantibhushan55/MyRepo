/*
 * DbBatchEntitlementManagerTest.java
 * Created on 13 d�c. 2004
 *
 * Entitlement Service Project
 */
package com.hp.es.service.batchEntitlement.db;
/*
import java.io.IOException;
import java.sql.SQLException;

import com.hp.es.service.batchEntitlement.Request;
import com.hp.es.service.batchEntitlement.SubRequest;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.io.zip.StreamCompressException;
import com.hp.sif.SifException;
*/
/**
 * @author ANVOI
 *
 * This class is a testbed for DbBatchEntitlementManager
 * It aims to test public interface from the class.
 * It required valid db.properties file to connect to the database (example of valid proerty file)
 *       # Drivers
 *       jdbc.drivers=oracle.jdbc.driver.OracleDriver
 *       
 *       # settings for the default database connection pool
 *       default.url=jdbc:oracle:thin:@isoit621.bbn.hp.com:1521:ODS
 *       default.maxconns=5
 *       default.initconns=1
 *       default.modifier=com.hp.es.service.db.DbConnectionModifier
 *       default.user=gdcc_test
 *       default.password=gdcc_test
 *       
 *       # setting for batch entitlement
 *       batchEntitlement.url=jdbc:oracle:thin:@isoit621.bbn.hp.com:1521:ODS
 *       batchEntitlement.maxconns=5
 *       batchEntitlement.initconns=1
 *       batchEntitlement.modifier=com.hp.es.service.db.DbConnectionModifier
 *       batchEntitlement.user=gdcc_test
 *       batchEntitlement.password=gdcc_test
 *       
	UPDATE  BATCH_REQUEST SET BR_STATUS='new', br_start_date=null;
	
	delete from BATCH_sub_request;
	
	update batch_request set br_subrequest_count=null;
	
	update batch_request set br_start_date=sysdate, br_finish_date=sysdate, br_error_message='error', br_status='processed', br_subrequest_count=0
	where br_request_id=8;
	
	
	update batch_request set br_user_email='antoine.voiry@hp.com';
	commit;

 * 
 */
public class DbBatchEntitlementManagerTest  {

    /**
     * 
     */
    public DbBatchEntitlementManagerTest() {
        super();
    }

    
    
    public static void main(String[] args) throws Exception{
        DbBatchEntitlementManager test = DbBatchEntitlementManager.getInstance();
     //    test.extractRequestToSubRequests();
     //    test.getRequestForEmailing(null);
        System.out.println("Test of request extraction");       
        	test.extractRequestToSubRequests();
        System.out.println("Test of request extraction finished");
        
//        System.out.println("Test with Sub Request 1");
//        SubRequest sr = new SubRequest();
//        sr.setRequestId("2");
//        sr.setItem("0");
//        sr.setResponse("<XML> Lals</XML>");
//        test.updateSubRequest(sr);
        
        
        
        
//        System.out.println("Sub Request details :"+ sr.toString());
//        sr.setResponse("<XML> Lals</XML>");
//        //This will generate an error
//        test.testUpdateSubRequest(sr);
//        System.out.println("Test with Sub Request 1 finished");
//        
//        
//        
//        System.out.println("Test with Sub Request 2");
//        sr = test.testGetNextSubRequest(null);
//        System.out.println("Sub Request details :"+ sr.toString());
//        sr.setResponse("<XML> Lals</XML>");
//        test.testUpdateSubRequest(sr);
//        System.out.println("Test with Sub Request 2 finished");
//        
//        
//        System.out.println("Test getRequestForEmailing 1 ");
//        Request r =test.getRequestForEmailing(Id);
//        if (r != null) {
//            r.setStatus("failed");
//            test.updateRequest(r);
//            System.out.println("Test getRequestForEmailing 1 succeded");
//        }else {
//            System.out.println("Test getRequestForEmailing 1 failed");
//        }
//        
//        
//        System.out.println("Test getRequestForEmailing 2 ");
//        r =test.getRequestForEmailing(null);
//        if (r != null) {
//            r.setStatus("sent");
//            test.updateRequest(r);
//            System.out.println("Test getRequestForEmailing 2 succeded");
//        }else {
//            System.out.println("Test getRequestForEmailing 2 failed");
//        }
      
    }
    
  
    /**
     * @param r

    private void updateRequest(Request r) {
        
        DbBatchEntitlementManager dbBatch = DbBatchEntitlementManager.getInstance();
        System.out.println("Test of updateRequest succeeded with Request  ");
        try {
            dbBatch.updateRequestStatus(r);
        } catch (DataAccessException e) {
            System.out.println("updateRequest should not have generated an execption with Request  ");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("updateRequest should not have generated an execption with Request  ");
            e.printStackTrace();
        } catch (DatabaseDownException e) {
            System.out.println("updateRequest should not have generated an execption with Request  ");
            e.printStackTrace();
        }

    }
     */


    /**
     * @param object

	private Request getRequestForEmailing(String  id) {
        
        DbBatchEntitlementManager dbBatch = DbBatchEntitlementManager.getInstance();
        System.out.println("Test of getRequestForEmailing succeeded with Id  "+ id);
        Request r = null;
        try {
            r = dbBatch.getRequestForEmailing(id);
        } catch (DataAccessException e) {
            
            System.out.println("getRequestForEmailing should not have generated an execption with Id  "+ id);
            e.printStackTrace();
        } catch (SQLException e) {
            
            System.out.println("getRequestForEmailing should not have generated an execption with Id  "+ id);
            e.printStackTrace();
        } catch (StreamCompressException e) {
            
            System.out.println("getRequestForEmailing should not have generated an execption with Id  "+ id);
            e.printStackTrace();
        } catch (IOException e) {
            
            System.out.println("getRequestForEmailing should not have generated an execption with Id  "+ id);
            e.printStackTrace();
        } catch (SifException e) {
            
            System.out.println("getRequestForEmailing should not have generated an execption with Id  "+ id);
            e.printStackTrace();
        } catch (DatabaseDownException e) {
            System.out.println("getRequestForEmailing should not have generated an execption with Id  "+ id);
            e.printStackTrace();
        }   
        return r;
    }

     */


    /**
     * @param sr
    private void testUpdateSubRequest(SubRequest sr) {
        
        DbBatchEntitlementManager dbBatch = DbBatchEntitlementManager.getInstance();
        System.out.println("Test of testUpdateSubRequest succeeded with sr  "+ sr.toString());
        try {
            dbBatch.updateSubRequest(sr);
        } catch (DataAccessException e) {
            
            System.out.println("testGetNextSubRequest should not have generated an execption with sr  "+ sr.toString());
            e.printStackTrace();
        } catch (SQLException e) {
            
            System.out.println("testGetNextSubRequest should not have generated an execption with sr  "+ sr.toString());
            e.printStackTrace();
        } catch (DatabaseDownException e) {
            System.out.println("testGetNextSubRequest should not have generated an execption with sr  "+ sr.toString());
            e.printStackTrace();
        }        
    }
     */







    /**
     * testgetNextSubRequest
     * This test aim to test the extractRequestToSubRequests method
    public String testExtractRequestToSubRequests() {
         * For this test to work, we need to have some request in the BATCH_REQUEST table with status set to new
         * For now, we will conider this request to be loaded
         * TODO: If time permit, load request before test

        String requestId = null;
        System.out.println("Test of extractRequestToSubRequests will start");
        DbBatchEntitlementManager dbBatch = DbBatchEntitlementManager.getInstance();
        
        try {
            requestId = dbBatch.extractRequestToSubRequests();
            if (requestId == null) {
                System.out.println("This test require data to be loaded in the database");
                return null;
            }
            
            System.out.println("Test of testExtractRequestToSubRequests succeeded");
            
        }catch( Exception e) {
            System.out.println("testExtractRequestToSubRequests should not have generated an execption");
            return null;
        }
        
        return requestId;
        
        
    }
         */

}
