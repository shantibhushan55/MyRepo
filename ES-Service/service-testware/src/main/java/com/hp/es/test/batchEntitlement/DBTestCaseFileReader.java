/*
 * DBFileReader.java
 * Created on 17 d�c. 2004
 *
 * Entitlement Service Project
 */
package com.hp.es.test.batchEntitlement;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.zip.InflaterInputStream;

import oracle.sql.BLOB;

import com.hp.ruc.db.RucPoolManager;
import com.hp.ruc.io.StreamUtil;

public class DBTestCaseFileReader {
    
    private String _path=null;
    
    
    private static final String GET_REQUEST =
        "select * FROM BATCH_REQUEST where BR_REQUEST_ID=? ";

    private static final String TEST_REQUEST_ID="select count(*) from BATCH_REQUEST "+
        	" WHERE BR_request_id=? and (BR_STATUS='sent' or BR_STATUS='failed')";	 


    
    
    private String _requestId;


    private static final String BATCHPOOLNAME = "batchEntitlement";
    
    /**
     * 
     */
    public DBTestCaseFileReader() {
        super();
    }

    public static void main(String[] args) {
        try {
            DBTestCaseFileReader reader = new DBTestCaseFileReader();
            reader.execute(args);
	        System.out.println("File read from Database successfully");
	        System.exit(0);
        }catch(Exception e) {
            e.printStackTrace();
        }        
    }
    
    /*
     * Execute method
     * This is the entry point for using that class
     * @parameter a list of argument
     * @return 0 if succesfull, -1 if fails
     */
    private void execute(String[] args) throws Exception {
        getParameters(args);
        File f = null;
        //Now let's try to open the file
        if(!getParameters(args) ) {
            throw new RuntimeException("Error" + displayUsage());
        }
        
        f = new File(_path);
        
        if(!f.exists() && !f.isDirectory()) {
            throw new RuntimeException("Path "+_path + " does not exist.");
        }
        
        
        
        readRequestFromDb();
        
        
        
        
        
    }
    
    /*
     * Check the parameter and return it 
     * @param an array of arguments
     * @return false if there is a pramater problem
     */
    private boolean getParameters(String[] args) {
        if(args.length!=2 ) {
            return false;
        }
        _path= args[0];
        _requestId=args[1];
        return true;
        
   }
   
   /*
    * Display usage information
    * @return the usage for this class
    */
   private String displayUsage() {
       StringBuffer sb= new StringBuffer();
       sb.append("Usage of "+this.getClass().getName());
       sb.append("* 		arg0 path to save file\n\r");
       sb.append("* 		arg1 request Id\n\r");

       return sb.toString();
   }    
   
   /*
   private void  readFromDb() throws Exception {
       PreparedStatement  st = null;
     //  String poolName = null;
       BLOB blob = null;
       Connection con = null;
       ResultSet rs= null;
      //boolean commited = false;
       // create pool and get a connection out of it
       
       try {
           con = PoolManager.getInstance().getConnection(BATCHPOOLNAME);
           con.setAutoCommit(false);		  
		   st = con.prepareCall(GET_REQUEST);
		   st.setString(1,_requestId);
		   
		   rs = st.executeQuery();
		   
		   if(rs.next()) {
	           blob = (BLOB) rs.getBlob("BR_RESPONSE");		   
		   }else {
		       throw new RuntimeException("Request " + _requestId + " not found.");
		   }

		   FileOutputStream fos = new FileOutputStream(_path+ _requestId+".zip");

           
		   StreamUtil.copyInputToOutput( blob.getBinaryStream(), fos);
		   fos.flush();    
		   fos.close();
       }catch(Exception e) {
           throw e;
       } finally {
           try { st.close(); } catch (Exception e) {}
           try { rs.close(); } catch (Exception e) {}
           try { blob.close(); } catch (Exception e) {}
           try { con.close(); } catch (Exception e) {}
       }
       
   }
   */
   
   private void  readRequestFromDb() throws Exception {
       PreparedStatement  st = null;
       //String poolName = null;
       BLOB blob = null;
       Connection con = null;
       ResultSet rs= null;
       //boolean commited = false;
       // create pool and get a connection out of it
       
       try {
           con = RucPoolManager.getInstance().getConnection(BATCHPOOLNAME);
           con.setAutoCommit(false);		  
		   st = con.prepareCall(GET_REQUEST);
		   st.setString(1,_requestId);
		   
		   rs = st.executeQuery();
		   
		   if(rs.next()) {
	           blob = (BLOB) rs.getBlob("BR_REQUEST");		   
		   }else {
		       throw new RuntimeException("Request " + _requestId + " not found.");
		   }

		   FileOutputStream fos = new FileOutputStream(_path+ _requestId+".csv");

		   InflaterInputStream iis = new InflaterInputStream(
                   new BufferedInputStream(blob.getBinaryStream()));
		   
		   StreamUtil.copyInputToOutput( iis, fos);
		   fos.flush();    
		   fos.close();
       }catch(Exception e) {
           throw e;
       } finally {
           try { st.close(); } catch (Exception e) {}
           try { rs.close(); } catch (Exception e) {}
           try { blob.close(); } catch (Exception e) {}
           try { con.close(); } catch (Exception e) {}
       }
       
   }   
   /*
    * test if a request Id is finished
    * @return boolean if found
    */
   public static boolean isRequestIdFinished(int id) throws SQLException {
       PreparedStatement  st = null;
       //String poolName = null;

       Connection con = null;
       ResultSet rs= null;
       int nbrows=0;
       
       try {
           con = RucPoolManager.getInstance().getConnection(BATCHPOOLNAME);
           		  
		   st = con.prepareCall(TEST_REQUEST_ID);
		   st.setInt(1,id);
		   
		   rs = st.executeQuery();
		   if(rs.next()) {
		       nbrows=rs.getInt(1);
		   }
       
       } finally {
           try { st.close(); } catch (Exception e) {e.printStackTrace();}
           try { rs.close(); } catch (Exception e) {e.printStackTrace();}
           try { con.close(); } catch (Exception e) {e.printStackTrace();}
       }   
       if(nbrows ==0) {
           return false;
       }
       
       return true;
   }
   
   /*
    * test if a request Id is finished
    * @return the status from the database (it never return null)
    */   
   public static String getStatusForRequestId(int id) throws SQLException {
       PreparedStatement  st = null;
       //String poolName = null;
       Connection con = null;
       ResultSet rs= null;
       String status= "";
       
       try {
           con = RucPoolManager.getInstance().getConnection(BATCHPOOLNAME);
           		  
		   st = con.prepareCall(GET_REQUEST);
		   st.setInt(1,id);
		   
		   rs = st.executeQuery();
		   if(rs.next()) {
		       status=rs.getString("BR_STATUS");
		   }
       
       } finally {
           try { st.close(); } catch (Exception e) {e.printStackTrace();}
           try { rs.close(); } catch (Exception e) {e.printStackTrace();}
           try { con.close(); } catch (Exception e) {e.printStackTrace();}
       }   
       
       return status;       
   }
   
   
   /*
    * test if a request Id is finished
    * @return the errorMessage from the database for the given id (it never return null)
    */   
   public static String getErrorMessageForRequestId(int id) throws SQLException {
       PreparedStatement  st = null;
       //String poolName = null;
       Connection con = null;
       ResultSet rs= null;
       String errorMessage= "";
       
       try {
           con = RucPoolManager.getInstance().getConnection(BATCHPOOLNAME);
           		  
		   st = con.prepareCall(GET_REQUEST);
		   st.setInt(1,id);
		   
		   rs = st.executeQuery();
		   if(rs.next()) {
		       errorMessage=rs.getString("BR_ERROR_MESSAGE");
		       if(errorMessage== null) {
		           errorMessage="";
		       }
		   }
       
       } finally {
           try { st.close(); } catch (Exception e) {e.printStackTrace();}
           try { rs.close(); } catch (Exception e) {e.printStackTrace();}
           try { con.close(); } catch (Exception e) {e.printStackTrace();}
       }   
       
       return errorMessage;       
   }   

   /*
    * test if a request Id is finished
    * @return the errorMessage from the database for the given id
    */   
   public static  InputStream  getBlobFromDb(int id) throws SQLException  {
       PreparedStatement  st = null;
       //String poolName = null;
       BLOB blob = null;
       Connection con = null;
       ResultSet rs= null;
      // boolean commited = false;
       // create pool and get a connection out of it
       
       try {
           con = RucPoolManager.getInstance().getConnection(BATCHPOOLNAME);
           con.setAutoCommit(false);		  
		   st = con.prepareCall(GET_REQUEST);
		   st.setInt(1,id);
		   
		   rs = st.executeQuery();
		   
		   if(rs.next()) {
	           blob = (BLOB) rs.getBlob("BR_RESPONSE");
			   if(blob!= null && blob.length()> 0) {
			       return blob.getBinaryStream();
			   }	           
		   }


	       return null;
       } finally {
           try { st.close(); } catch (Exception e) {e.printStackTrace();}
           try { rs.close(); } catch (Exception e) {e.printStackTrace();}
           try { blob.close(); } catch (Exception e) {e.printStackTrace();}
           try { con.close(); } catch (Exception e) {e.printStackTrace();}
       }
       
   }

   
}
