/*
 * DBCSVLoader.java
 * Created on 8 d�c. 2004
 *
 * Entitlement Service Project
 * This class should be used to looad CSV file into the database
 */
package com.hp.es.test.batchEntitlement;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.zip.DeflaterOutputStream;

import oracle.sql.BLOB;

import com.hp.ruc.db.RucPoolManager;
import com.hp.ruc.io.StreamUtil;


/**
 * @author anvoi
 */
public class DBCSVLoader {
    private String _fileName= null;
    private String _userEmail=null;
    private String _userFirstName=null;
    private String _userLastName=null;
    private String _includeOffers=null;
    private String _includeContracts=null;

    private static final String INSERT_REQUEST =
            "begin INSERT INTO BATCH_REQUEST" +
            "(BR_INCLUDE_CONTRACTS, BR_INCLUDE_OFFERS, BR_USER_FIRST_NAME, " +
            "BR_USER_LAST_NAME, BR_USER_EMAIL, BR_FILE_NAME, BR_REQUEST) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?) " +
            "RETURNING BR_REQUEST_ID, BR_REQUEST INTO ?, ?; end;";

    
    
    /**
     * Constructor (default)
     * It create an instance of this class
     */
    public DBCSVLoader() {
        super();
    }

    /*
     * Main Method
     * @param args a list of parameters
     * 		currently this method support /
     * 		arg0 file name
     * 		arg1 user email
     * 		arg2 user first name
     * 		arg3 user last name
     * 		arg4 include Offer (Y/N)
     *  	arg5 include Contracts (Y/N)
     */
    public static void main(String[] args) {
        try {
	        DBCSVLoader loader = new DBCSVLoader();
	        loader.execute(args);
	        System.out.println("Blob inserted succesfully");
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
        
        f = new File(_fileName);
        
        if(!f.exists()) {
            throw new RuntimeException("File "+_fileName + " does not exist.");
        }
        
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
        
        updateDb(in);
        
        
        
        
        
    }
    
    /*
     * Check the parameter and return it 
     * @param an array of arguments
     * @return false if there is a pramater problem
     */
    private boolean getParameters(String[] args) {
        if(args.length!=6 ) {
            return false;
        }
        _fileName= args[0];
        _userEmail=args[1];
        _userFirstName=args[2];
        _userLastName=args[3];
        if(!args[4].equalsIgnoreCase("Y") || !args[4].equalsIgnoreCase("N")) {
            _includeOffers=args[4];
        }
        if(!args[5].equalsIgnoreCase("Y") || !args[5].equalsIgnoreCase("N")) {
            _includeContracts=args[5];
        }        
        return true;
        
   }
   
   /*
    * Display usage information
    * @return the usage for this class
    */
   private String displayUsage() {
       StringBuffer sb= new StringBuffer();
       sb.append("Usage of "+this.getClass().getName());
       sb.append("* 		arg0 file name");
       sb.append("* 		arg1 user email");
       sb.append("* 		arg2 user first name");
       sb.append("* 		arg3 user last name");
       sb.append("* 		arg4 include Offer (Y/N)");
       sb.append("*  		arg5 include Contracts (Y/N)");
       return sb.toString();
   }
    /*
     * return the request id 
     */
private int  updateDb(InputStream in) throws Exception {
       CallableStatement  st = null;
       BLOB blob = null;
       Connection con = null;
       //ResultSet rs= null;
       boolean commited = false;
       // create pool and get a connection out of it
       int rec_id=0;
       
       try {
           con = RucPoolManager.getInstance().getConnection();
           con.setAutoCommit(false);		  
		   st = con.prepareCall(INSERT_REQUEST);
		   st.setString(1,_includeContracts);
		   st.setString(2, _includeOffers);
		   st.setString(3, _userFirstName);
		   st.setString(4, _userLastName);
		   st.setString(5, _userEmail);               
		   st.setString(6,getShortFileName(_fileName));
		   st.setBlob(7, BLOB.empty_lob());
		   
		   st.registerOutParameter(8, Types.INTEGER);
		   st.registerOutParameter(9, Types.BLOB);		

           st.execute();
           rec_id = st.getInt(8);
           blob = (BLOB) st.getBlob(9);		   

           DeflaterOutputStream blobOutputStream = new DeflaterOutputStream(new BufferedOutputStream(blob.getBinaryOutputStream()));
		   StreamUtil.copyInputToOutput(in, blobOutputStream);
		   blobOutputStream.flush();    
		   blobOutputStream.close();
		   con.commit();
		   commited= true;
       }catch(Exception e) {
    	   if(con != null) {
    		   con.rollback();
    	   }
           throw e;
       } finally {
           if(!commited) {
        	   if(con != null) {
        		   try {con.rollback();} catch (Exception e) {}
        	   }
           }
           if(st != null) {
        	   try { st.close(); } catch (Exception e) {}
           }
//           try { rs.close(); } catch (Exception e) {}
           if(blob != null) {
        	   try { blob.close(); } catch (Exception e) {}
           }
           if(con != null) {
        	   try { con.close(); } catch (Exception e) {}
           }
       }
       return rec_id;
       
   }



   /*
    * @param String the long file name (including path)
    * @return the name of file without path
    */
   private static  String getShortFileName(String longFileName) {
       String repSeparator = System.getProperties().getProperty("file.separator");
       
       int lastPathSeparator = longFileName.lastIndexOf(repSeparator);
       
       return longFileName.substring(lastPathSeparator+1);
       
   }
   
   
   public static int insertTestCaseInDatabase(InputStream in,String fileName, String includeContracts,
           String includeOffers,String userFirstName,String userLastName,String userEmail) throws Exception {
       CallableStatement  st = null;
       //String poolName = null;
       BLOB blob = null;
       Connection con = null;
       
       boolean commited = false;
       // create pool and get a connection out of it
       int rec_id=0;
       
       try {
           con = RucPoolManager.getInstance().getConnection();
           con.setAutoCommit(false);		  
		   st = con.prepareCall(INSERT_REQUEST);
		   st.setString(1,includeContracts);
		   st.setString(2, includeOffers);
		   st.setString(3, userFirstName);
		   st.setString(4, userLastName);
		   st.setString(5, userEmail);               
		   st.setString(6,getShortFileName(fileName));
		   st.setBlob(7, BLOB.empty_lob());
		   
		   st.registerOutParameter(8, Types.INTEGER);
		   st.registerOutParameter(9, Types.BLOB);		

           st.execute();
           rec_id = st.getInt(8);
           blob = (BLOB) st.getBlob(9);		   

           DeflaterOutputStream blobOutputStream = new DeflaterOutputStream(new BufferedOutputStream(blob.getBinaryOutputStream()));
		   StreamUtil.copyInputToOutput(in, blobOutputStream);
		   blobOutputStream.flush();    
		   blobOutputStream.close();
		   con.commit();
		   commited= true;
       }catch(Exception e) {
    	   if(con != null)
    		   con.rollback();
           throw e;
       } finally {
           if(!commited) {
               try {con.rollback();} catch (Exception e) {}
           }
           try { st.close(); } catch (Exception e) {}
           
           try { blob.close(); } catch (Exception e) {}
           try { con.close(); } catch (Exception e) {}
       }
       return rec_id;
       
   }
   
}
