/*
 * Created on Dec 7, 2004
 */
package com.hp.es.service.batchEntitlement.db;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.InflaterInputStream;

import oracle.jdbc.OracleTypes;

import com.hp.es.service.batchEntitlement.BatchCsvReader;
import com.hp.es.service.batchEntitlement.Request;
import com.hp.es.service.batchEntitlement.SubRequest;
import com.hp.es.service.db.DbConnectionManager;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.exception.EsException;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.db.BlobUtils;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.io.zip.StreamCompressException;
import com.hp.sif.SifException;

/**
 * This class handles all accesses to the database related to batch entitlement.
 */
public final class DbBatchEntitlementManager implements ConfigChangeListener {

    static private DbBatchEntitlementManager instance = new DbBatchEntitlementManager();

 //   static private final String UPDATE_BATCH_SUB_REQUEST = "update BATCH_SUB_REQUEST set BSR_UPDATE_DATE = ?, BSR_STATUS = ? where BSR_REQUEST_ID = ? and BSR_ITEM = ?";
    static private final String DELETE_REQUEST_PROCESSED_OLDER_THAN =
        "delete BATCH_REQUEST " +
        "where (BR_STATUS='sent' or BR_STATUS='failed' ) " +
        "and BR_FINISH_DATE < sysdate - ?";

    static private final String DELETE_SUB_REQUEST =
        "delete BATCH_SUB_REQUEST where BSR_REQUEST_ID=?";

    // for processing a SubRequest we also need these flags...
    
    static private final String GET_REQUESTID_FOR_RESEND=
    		"select br.* " +
    	              "from BATCH_REQUEST br " +
    	             "where BR_REQUEST_ID=" +
    	                            "(select min(BR_REQUEST_ID) " +
    	                               "from BATCH_REQUEST br2 " +
    	                              "where (br2.BR_STATUS in ('waitForResend','processed','sending') " +
    	                              		"or (br2.BR_STATUS='processing' " +
    	                              			"and (select count(*) " +
    	                              				   "from BATCH_SUB_REQUEST " +
    	                              				  "where BSR_REQUEST_ID=BR_REQUEST_ID " +
    	                              				    "and BSR_STATUS in ('new','processing')) = 0))" +
    	                                "and (br2.BR_EMAIL_NEXT_SEND_TIME IS NULL or " +
    	                                     "br2.BR_EMAIL_NEXT_SEND_TIME<sysdate)) " +
    	            "for update nowait";
    static private final String GET_REQUESTID_FOR_SEND=
    		"select br.* " +
    	              "from BATCH_REQUEST br " +
    	             "where br.BR_REQUEST_ID=? " +
    	               "and br.BR_STATUS='processing' " +
    	               "and not exists (select 1 " +
    	               					 "from BATCH_SUB_REQUEST " +
    	                                "where BSR_REQUEST_ID=br.BR_REQUEST_ID " +
    	                                  "and BSR_STATUS<>'processed' ) " +
    	             "for update nowait";
 
    // get the request for the given request ID if all SubRequests are processed
    //If several thread were working on it, we also only need to take the request with status processing
    static private final String GET_REQUEST_FOR_SEND ="select br.* from BATCH_REQUEST br where br.BR_REQUEST_ID=?";

    /*
     * No need to lock
     */
    static private final String GET_RESPONSE_FOR_SUBREQUESTS =
        "select bsr.BSR_RESPONSE,bsr.BSR_CSV_RESPONSE "
            + "from BATCH_SUB_REQUEST bsr "
            + "where bsr.BSR_REQUEST_ID=? "
            + "order by bsr.BSR_ITEM";

    /*
     * For now we do a join to get the table
     */
    static private final String GET_UNPROCESSED_REQUEST =
		"select br.* " +
		  "from BATCH_REQUEST br " +
		 "where br.BR_REQUEST_ID = " +
				"(select min(br2.BR_REQUEST_ID) " +
		          "from BATCH_REQUEST br2 " +
		          "where br2.BR_STATUS='new') " +
		 "for update nowait";


    static private final String INSERT_SUBREQUEST = "insert into BATCH_SUB_REQUEST(BSR_REQUEST_ID,"
    		+ "BSR_ITEM,BSR_STATUS,BSR_ISO_COUNTRY_CODE,BSR_SERIAL_NUMBER, BSR_PRODUCT_ID,BSR_CHECK_DATE) "
            + "values (?,?,?,?,?,?,?)";
    
    static private final String INSERT_SUBREQUEST_WITHOUT_CHECKDATE = "insert into BATCH_SUB_REQUEST(BSR_REQUEST_ID,"
    		+ "BSR_ITEM,BSR_STATUS,BSR_ISO_COUNTRY_CODE,BSR_SERIAL_NUMBER, BSR_PRODUCT_ID) "
            + "values (?,?,?,?,?,?)";



    // store the xml response in the db
    static private final String UPDATE_REQUEST = "begin update BATCH_REQUEST "
            + "set BR_FINISH_DATE=sysdate, BR_RESPONSE=EMPTY_BLOB() "
            + "where BR_REQUEST_ID=? "
            + "RETURNING BR_RESPONSE INTO ?; end;";

    static private final String UPDATE_REQUEST_AFTER_EMAIL_SENDING = "update BATCH_REQUEST "
            + "set BR_STATUS=?,"
            + "BR_EMAIL_RETRIES=?, "
            + "BR_EMAIL_NEXT_SEND_TIME=sysdate+?/24 " // one more hour
            + "where BR_REQUEST_ID=?";
    
    
    static private final String UPDATE_REQUEST_STATUS = "update BATCH_REQUEST "
            + "set BR_STATUS=? "
            + "where BR_REQUEST_ID=? and BR_STATUS=?";
    
    // store the xml response in the db and set the status to 'processed'
    static private final String UPDATE_SUBREQUEST =
        "begin update BATCH_SUB_REQUEST "
            + "set BSR_STATUS='processed',"
            + "BSR_UPDATE_DATE=sysdate,"
            + "BSR_RESPONSE = EMPTY_BLOB(),"
            + "BSR_CSV_RESPONSE = EMPTY_BLOB() "
            + "where BSR_REQUEST_ID = ? "
            + "and BSR_ITEM = ? "
            + "RETURNING BSR_RESPONSE,BSR_CSV_RESPONSE INTO ?,?; end;";

    static private final String  GET_NEXT_SUBREQUEST_LIST ="{call batch.get_next_subrequest(?,?,?,?,?,?)}";
    
    private int maxSubRequestsWithOffers = 10000;
    private int maxSubRequestsWithoutOffers = 65000;
    private int removeRequestsOlderThan;
    private int retryInterval = 1;
    private static final String ERROR_MESSAGE_FOR_BAD_CSV = "The file given to the batch is having an issue: \n\r";


    /**
     * @return the DbBatchEntitlementManager object (singleton).
     */
    public static DbBatchEntitlementManager getInstance() {
        return instance;
    }

    /**
     * private constructor
     */
    private DbBatchEntitlementManager() {        
        Configuration.getInstance().addConfigChangeListener(this);
    }

    /**
     * Read and initialize following values:
     * <ul>
     * <li>batchEntitlement.removeRequestsOlderThan
     * <li>batchEntitlement.email.retryInterval
     * <li>batchEntitlement.maxRequests.includeOffers
     * </ul>
     *
     * @see com.hp.ruc.config.ConfigChangeListener#configChanged(com.hp.ruc.config.ConfigChangeEvent)
     */
    public void configChanged(ConfigChangeEvent event) {
        if (event != null && event.getNewConfig() != null) {
            ESLog.info("Reload configuration");

            /*
             * getting batchEntitlement.removeRequestsOlderThan
             */
            try {
                removeRequestsOlderThan = event.getNewConfig()
                        .getIntegerProperty(
                                "batchEntitlement.removeRequestsOlderThan",
                                new Integer(180)).intValue();
            }
            catch (Exception e) {
                //we set default value
                ESLog.error("Error while reading parameters", e);
                ESLog.info("No removeRequestsOlderThan defined, default value \"180\" will be used");
                removeRequestsOlderThan = 180;
            }

            /*
             * getting batchEntitlement.email.retryInterval
             */
            try {
                retryInterval = event.getNewConfig().getIntegerProperty("batchEntitlement.email.retryInterval", Integer.valueOf(1)).intValue();
            }
            catch (Exception e) {
                ESLog.error("Error while reading parameters", e);
                //we set default value
                ESLog.info("No retryInterval defined, default value \"10\" will be used");
                retryInterval = 1;
            }

            /*
             * getting batchEntitlement.maxRequests.includeOffers
             */
            try {
                maxSubRequestsWithOffers = event.getNewConfig()
                        .getIntegerProperty(
                                "batchEntitlement.maxRequests.includeOffers",
                                new Integer(10000)).intValue();
            }
            catch (Exception e) {
                ESLog.error("Error while reading paramleters", e);
                //we set default value
                ESLog.info("No maxSubRequestsWithOffers defined, default value \"10000\" will be used");
                maxSubRequestsWithOffers = 10000;
            }

            /*
             * getting batchEntitlement.maxRequests.excludeOffers
             */
            try {
                maxSubRequestsWithoutOffers = event.getNewConfig()
                        .getIntegerProperty(
                                "batchEntitlement.maxRequests.excludeOffers",
                                new Integer(65000)).intValue();
            }
            catch (Exception e) {
                ESLog.error("Error while reading paramleters", e);
                //we set default value
                ESLog.info("No maxSubRequestsWithOffers defined, default value \"10000\" will be used");
                maxSubRequestsWithoutOffers = 65000;
            }

            if (ESLog.isDebugLogEnabled()) {
                ESLog.debug("removeRequestsOlderThan = " + removeRequestsOlderThan);
                ESLog.debug("retryInterval = " + retryInterval);
                ESLog.debug("maxSubRequestsWithOffers = " + maxSubRequestsWithOffers);
                ESLog.debug("maxSubRequestsWithoutOffers = " + maxSubRequestsWithoutOffers);
            }
        }
    }

    /**
     * delete request older than a certain time
     *
     * @throws SQLException
     * @throws DataAccessException
     * @throws DatabaseDownException 
     */
	public synchronized void deleteOldRequests() throws DataAccessException, SQLException, DatabaseDownException {
        ESLog.debug("Enter");

        Connection conn = null;
        PreparedStatement ps = null;
        boolean committed = false;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_REQUEST_PROCESSED_OLDER_THAN);
            ps.setInt(1, removeRequestsOlderThan);
            ps.executeUpdate();
            conn.commit();
            committed = true;
        }
        finally {
            if (!committed) {
            	ESLog.info("Rollback non commited");
                try { conn.rollback(); } catch (Exception e) {
                	ESLog.error("Issue in rollback",e);
                }
            }
            try { ps.close(); } catch (Exception e) {
            	ESLog.debug("Issue in closing statement",e);
            }
            try { conn.close(); } catch (Exception e) {
            	ESLog.debug("Issue in closing connection",e);
            	
            }
            ESLog.debug("Exit");
        }
    }

    /**
     * Delete all sub Request for a request
     *
     * @param request
     * @param conn
     * @throws SQLException
     * Note that this method should be called by another or if wil not save the data
     */
    private void deleteSubRequests(String requestId, Connection conn)
            throws SQLException {
    	ESLog.debug("Enter");
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(DELETE_SUB_REQUEST);
            pst.setString(1, requestId);
            pst.executeUpdate();
            //Commit is being delegated to caller
        }
        finally {
            try { pst.close(); } catch (Exception e) {
            	ESLog.debug("Issue in closing statement",e);
            }
        }
    }

    /**
     * This method creates the SubRequests. It is synchronized because it may take
     * some time. Otherwise we would block the database connection.
     *
     * @return the request Id of the extracted request null if none
     */
    public synchronized String extractRequestToSubRequests() {
        ESLog.debug("Enter");

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement psGetRequest = null;
        PreparedStatement psInsertSubRequest = null;
        PreparedStatement psInsertSubRequestWithCheckDate = null;
  
        Blob blob = null;
        boolean committed = false;
        String requestId = null;
        StringBuffer errorMessage = new StringBuffer();

        InflaterInputStream iis = null;
        BatchCsvReader csvReader = null;

        try {
            conn = getConnection();
            Timestamp currentTime = getCurrentTime(conn);
            ESLog.debug("Preparing statement for run");

            psGetRequest = conn.prepareStatement(GET_UNPROCESSED_REQUEST,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = psGetRequest.executeQuery();

            if (rs.next()) {
                requestId = rs.getString("BR_REQUEST_ID");
                ESLog.debug("Statement returned request Id: " + requestId);

                boolean includeOffer = "y".equalsIgnoreCase((rs.getString("BR_INCLUDE_OFFERS")));

                blob = rs.getBlob("BR_REQUEST");      
                iis=BlobUtils.readBlob(blob);

                ESLog.debug("Blob is extracted, the CSV reader will now be created");
                csvReader = new BatchCsvReader(new InputStreamReader(iis));

                psInsertSubRequestWithCheckDate = conn.prepareStatement(INSERT_SUBREQUEST);
                psInsertSubRequest = conn.prepareStatement(INSERT_SUBREQUEST_WITHOUT_CHECKDATE);

                int rows = 0;
                int numberBadRows=0;
                try {
                    // skip the first line
                    csvReader.skipToNextLine();
                    do {
                        if (rows >= maxSubRequestsWithOffers && includeOffer) {
                            ESLog.info("Request " + requestId + " is containing more than " + maxSubRequestsWithOffers+ " and offer, processing will stop");
                            errorMessage.append("Warning: The csv-file must not contain more than ");
                            errorMessage.append(maxSubRequestsWithOffers);
                            errorMessage.append(" requests when the IncludeOffer flag was set. Only the first ");
                            errorMessage.append(maxSubRequestsWithOffers);
                            errorMessage.append(" requests were processed!");
                            break; // stop processing!
                        }
                        else if (rows >= maxSubRequestsWithoutOffers && !includeOffer) {
                            ESLog.info("Request " + requestId+ " is containing more than "+ maxSubRequestsWithoutOffers+ " and no offer, processing will stop");

                            errorMessage.append("Warning: The csv-file must not contain more than ");
                            errorMessage.append(maxSubRequestsWithoutOffers);
                            errorMessage.append(" requests when the IncludeOffer flag is false. Only the first ");
                            errorMessage.append(maxSubRequestsWithoutOffers);
                            errorMessage.append(" requests were processed!");
                            break; // stop processing!
                        }

                        String[] fields = csvReader.getAllFieldsInLine();
                        
                        ESLog.debug(" when create sub bactch request, the check date value is " + fields[3] + "!");
                        if(fields[3] == null || "".equals(fields[3].trim())) {
                            insertSubRequest(psInsertSubRequest, fields, requestId, rows);

                        } else {
                            insertSubRequest(psInsertSubRequestWithCheckDate, fields, requestId, rows);
                        }
                        
                        if (!csvReader.lastRowWasValid()) {
                            numberBadRows++;
                        }

                        rows++;
                    } while (true);
                }
                catch (EOFException e) {
                    // ignore. we reached the end of the file
                }
                catch (IOException e) {
                    //We do nothing with the exception except throwing it
                    // This may disapppear after
                    ESLog.error("Exception while reading CSV", e);
                    // This means that the CSV is probably having an issue.
                    errorMessage.append("Error: The csv-file is corrupted starting at line ");
                    errorMessage.append(rows);
                    rows=0;
                }

                /*
                 * The CSV is empty or all rows have issues
                 */
                if (rows < 1 || numberBadRows >= rows ) {

                    deleteSubRequests(requestId, conn);

                    if (errorMessage.length() == 0) {
                        errorMessage.append("Error: The csv-file is empty or all rows contains errors.");
                    }

                    if(csvReader.getErrorLineMessage().length()>0)
                    	errorMessage.append("\n"+csvReader.getErrorLineMessage()+"\n");
                    rs.updateString("BR_STATUS", "processed");
                    rs.updateTimestamp("BR_START_DATE", currentTime);
                    rs.updateTimestamp("BR_FINISH_DATE", currentTime);
                    rs.updateString("BR_ERROR_MESSAGE", ERROR_MESSAGE_FOR_BAD_CSV + fixBatchErrorMessage(errorMessage));
                    rs.updateInt("BR_SUBREQUEST_COUNT", 0);
                }
                else {
                	if(csvReader.getErrorLineMessage().length()>0)
                    	errorMessage.append("\n"+csvReader.getErrorLineMessage()+"\n");

                    rs.updateString("BR_STATUS", "processing");
                    rs.updateTimestamp("BR_START_DATE", currentTime);
                    rs.updateString("BR_ERROR_MESSAGE", fixBatchErrorMessage(errorMessage));
                    rs.updateInt("BR_SUBREQUEST_COUNT", rows);
                }

                ESLog.debug("" + rows + " SubRequests are stored");

                //we update the result set.
                rs.updateRow();

                // Commit and flagging the commited flag
                conn.commit();
                committed = true;
            }
        }
        catch (Exception e) {
            // We got a sql Exception, there is a probably an issue in the database,
            // as this may be due to a data issue, we should try to put the batch
            // as failed. If the database connection is lost we won't manage to do it
            // We know if the request is known by testing the resulset

            if(rs != null) {
                try {
                    deleteSubRequests(requestId, conn);

                    Timestamp currentTime = getCurrentTime(conn);

                    rs.updateString("BR_STATUS", "failed");
	                rs.updateTimestamp("BR_START_DATE", currentTime);
	                rs.updateTimestamp("BR_FINISH_DATE", currentTime);
	                rs.updateString("BR_ERROR_MESSAGE", e.getMessage());
	                rs.updateInt("BR_SUBREQUEST_COUNT", 0);
	                rs.updateRow();
	                conn.commit();
	                committed = true;
                }
                catch (Exception tmpE) {
                	ESLog.error("Batch Error, please investigate log file");
                }
                
            }
        	if(DbBatchEntitlementManager.isSeriousOracleIssue(e)) {
        		ESLog.error("Exception for request " + requestId, e);
        	}else {
        		ESLog.info("Oracle reported an issue with a NOWAIT statement, that's expected");
        	}
            
            requestId = null;
        }
        finally {
            if (!committed) {
                try { conn.rollback(); } catch (Exception e) {
                	ESLog.error("Issue in rollback!!",e);
                }
            }
            if(iis!=null){
	            try { iis.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            
            if(csvReader!=null){
	            try { csvReader.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            if(rs!=null){
	            try { rs.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            if(psGetRequest!=null){
	            try { psGetRequest.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
           
            if(psInsertSubRequest!=null){
	            try { psInsertSubRequest.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            
            if(psInsertSubRequestWithCheckDate!=null){
	            try { psInsertSubRequestWithCheckDate.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            
            if(conn!=null){
	            try { conn.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }

            ESLog.debug("Exit");
        }
        return requestId;
    }

    /**
     * It may generate a very long error message that cannot be inserted in the database.  So we should limit the size of error message.
     * 
     * @param errorMessage
     * @return
     */
    private String fixBatchErrorMessage(StringBuffer errorMessage) {
        //In database, the length of column BR_ERROR_MESSAGE is 1000.
        if (errorMessage.length() > 1000)
            return errorMessage.substring(0, 1000);
        return errorMessage.toString();
    }

    /**
     * We have to query the database in order to get the same timestamp
     * @return the Timestamp from the database.
     * @throws SQLException
     */
    private Timestamp getCurrentTime(Connection conn) throws SQLException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st  = conn.createStatement();
            rs = st.executeQuery("select sysdate from dual");
            if (rs.next()) {
                return rs.getTimestamp(1);
            }
        }
        finally {
        	if(rs!=null){
	            try { rs.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
        	}
        	if(st!=null){
	            try { st.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
        	}
        }
        return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * @param conn
     * @param fields
     * @throws SQLException
     * @throws ParseException 
     */
    private void insertSubRequest(PreparedStatement st, String[] fields,String requestId, int rows) throws SQLException{
        st.clearParameters();
        st.setString(1, requestId);
        st.setString(2, "" + rows);
        st.setString(3, "new");
        st.setString(4, fields[0]); // BSR_ISO_COUNTRY_CODE
        st.setString(5, fields[1]); // BSR_SERIAL_NUMBER
        st.setString(6, fields[2]); // BSR_PRODUCT_ID
        if(fields[3] != null && !"".equals(fields[3].trim())) {
        	Date checkDate = null;
    		String[] formatStrings = {"dd-MM-yyyy", "dd/MM/yyyy"};
    		for (String formatString : formatStrings) {
    	        try {
    	        	checkDate = new SimpleDateFormat(formatString).parse(fields[3]);
    	        	break;
    	        } catch (ParseException e) {}
    	    }
    		
    		if(checkDate == null) {
    			ESLog.error("parsing issue for wrong date format " + fields[3]);
    		}
    		
			st.setTimestamp(7, new Timestamp(checkDate.getTime()));
        }
        st.executeUpdate();
    }

    /**
     * Generate the response for the current request based on all SubRequests
     * belonging to it. This method will be called only once. Then the response
     * is stored in the BATCH_REQUEST table. When the email couldn't be sent,
     * then it will not be generated again. It will be read from the
     * BATCH_REQUEST table.
     *
     * @param request
     * @param conn
     * @throws SQLException
     * @throws StreamCompressException
     * @throws IOException
     * @throws SifException
     */
    private void generateResponse(Request request, Connection conn)
            throws SQLException, StreamCompressException, IOException, SifException {
        ESLog.debug("Enter");
        request.addHeaderToResponse();

        ResultSet rs = null;
        PreparedStatement st = null;
        
        long countGetBlob = 0;  // added for debug. can be removed
        long countReadBlob = 0;  // added for debug. can be removed
        long countReq = 0;  // added for debug. can be removed
        long start = 0;  // added for debug. can be removed
        long end = 0;  // added for debug. can be removed

        try {
            st = conn.prepareStatement(GET_RESPONSE_FOR_SUBREQUESTS);
            st.setString(1, request.getRequestId());
            rs = st.executeQuery();
            while (rs.next()) {
                Blob blob = null;
                InflaterInputStream iis = null;
                Blob csvBlob = null;
                InflaterInputStream csvIis = null;

                try {
                	start = System.currentTimeMillis();  // added for debug. can be removed
                    blob = rs.getBlob("BSR_RESPONSE");
                    end = System.currentTimeMillis();  // added for debug. can be removed
                    ESLog.debug("Get one xmlBlob from db time: " + (end - start));  // 
                    countGetBlob += (end - start);  // added for debug. can be removed
                    
                    start = System.currentTimeMillis();  // added for debug. can be remove
                    csvBlob=rs.getBlob("BSR_CSV_RESPONSE");
                    end = System.currentTimeMillis();  // added for debug. can be removed
                    ESLog.debug("Get one csvBlob from db time: " + (end - start));  // added for debug. can be removed
                    
                    if ((blob != null && blob.length()!=0)&&(csvBlob != null && csvBlob.length()!=0)) {
                    	start = System.currentTimeMillis();
                    	iis=BlobUtils.readBlob(blob);
                    	end = System.currentTimeMillis();  // added for debug. can be removed
                        ESLog.debug("Read one xml blob time: " + (end - start));  // added for debug. can be removed
                        countReadBlob += (end - start);
                        start = System.currentTimeMillis();
                    	csvIis=BlobUtils.readBlob(csvBlob);
                    	end = System.currentTimeMillis();  // added for debug. can be removed
                        ESLog.debug("Read one cvs blob time: " + (end - start));  // added for debug. can be removed
                        start = System.currentTimeMillis();
                        request.appendStreamToResponse(iis,csvIis);
                        end = System.currentTimeMillis(); 
                        ESLog.debug("Append one response time: " + (end - start));
                        countReq += (end - start);
                    }
                }
                finally {
                	if(iis!=null){
	                    try { iis.close(); } catch (Exception e) {
	                    	ESLog.debug("Issue in finalize",e);
	                    }
                	}
                }
            }
        }
        finally {
        	if(rs!=null){
	            try { rs.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
	            
        	}
        	
        	if(st!=null){
	            try { st.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
        	}
        }

        start = System.currentTimeMillis();  // added for debug. can be removed
        request.addTrailerToResponse();
        end = System.currentTimeMillis();  // added for debug. can be removed
        ESLog.debug("Add Trailer Time: " + (end - start));  // added for debug. can be removed
        
        ESLog.debug("Total time of get blob from DB: " + countGetBlob);  // added for debug. can be removed
        ESLog.debug("Total time of read blob: " + countReadBlob);  // added for debug. can be removed
        ESLog.debug("Total time of append response: " + countReq);  // added for debug. can be removed
    }

    /**
     * @return
     * @throws DataAccessException
     * @throws SQLException
     * @throws DatabaseDownException 
     * @throws SQLException 
     */
    private Connection getConnection() throws DataAccessException, DatabaseDownException, SQLException {
        Connection conn = DbConnectionManager.getInstance().getWritableConnection();
        conn.setAutoCommit(false);
        return conn;
    }
    
    private void updateOnSendingRequest(Request request, Connection conn)throws SQLException {
		ESLog.debug("Enter");
		PreparedStatement st = null;
		try {
            st = conn.prepareStatement(UPDATE_REQUEST_STATUS);
            st.setString(1, "failed");
            st.setString(2, request.getRequestId());
            st.setString(3, "onSending");
            st.executeUpdate();
		}
		finally {
		    try { st.close(); } catch (Exception e) {
		    	ESLog.debug("Issue in closing statement",e);
		    }
		}
    }
    
    public void updateOnSendingRequestAndDeleteSubRequest(Request request) throws DataAccessException, DatabaseDownException, SQLException{
    	 Connection conn = null;
         boolean committed = false;
         try {
             conn = getConnection();
             updateOnSendingRequest(request,conn);          
             deleteSubRequests(request.getRequestId(), conn);
             conn.commit();
             committed = true;
         } finally {
             if (!committed && conn != null) {
                 try { conn.rollback(); } catch (Exception e) {
                 	ESLog.error("Issue in rollback",e);
                 }
             }
             if(conn!=null){
 	            try { conn.close(); } catch (Exception e) {
 	            	ESLog.debug("Issue in finalize",e);
 	            }
             }

             ESLog.debug("Exit");
         }
    }

    
    public synchronized Request getOnsendingRequest(String requestId) throws DataAccessException, SQLException, DatabaseDownException{
         Connection conn = null;
         ResultSet rs = null;
         PreparedStatement st = null;
         boolean committed = false;
         Request request=new Request();
         try {
             conn = getConnection();
             if (requestId == null || requestId.trim().length() == 0) {
                 // this is the case of request to resend or of request with no
                 // line and status processed
            	 ESLog.debug("GET_REQUESTID_FOR_RESEND");
            	 st = conn.prepareStatement(GET_REQUESTID_FOR_RESEND,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             } else {
            	 ESLog.debug("GET_REQUESTID_FOR_SEND");
                 st = conn.prepareStatement(GET_REQUESTID_FOR_SEND,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 st.setString(1, requestId);
             }
             rs = st.executeQuery();
             if (rs.next()) {
                 request.setRequestId(rs.getString("BR_REQUEST_ID"));
                 request.setStatus(rs.getString("BR_STATUS"));
                 request.setErrorMessage(rs.getString("BR_ERROR_MESSAGE"));
                 request.setEmailRetries(rs.getInt("BR_EMAIL_RETRIES"));
                 request.setUserFirstName(rs.getString("BR_USER_FIRST_NAME"));
                 request.setUserLastName(rs.getString("BR_USER_LAST_NAME"));
                 request.setEmailAddress(rs.getString("BR_USER_EMAIL"));
                 request.setFileName(rs.getString("BR_FILE_NAME"));
                 request.setNbSubRequest(rs.getInt("BR_SUBREQUEST_COUNT"));
                 request.setIncludeOffers("y".equalsIgnoreCase(rs.getString("BR_INCLUDE_OFFERS")));
                 request.setIncludeContracts("y".equalsIgnoreCase(rs.getString("BR_INCLUDE_CONTRACTS")));
                 
                 ESLog.debug("updating status with onsending:"+request.getRequestId());
                 rs.updateString("BR_STATUS", "onSending");
                 rs.updateRow();
                 conn.commit();
                 committed=true;
             }
             conn.commit();
             committed=true;
             ESLog.debug("updating status with onsending commit finish");
          }finally {
                 if (!committed) {
                     try { conn.rollback(); } catch (Exception e) {
                     	ESLog.error("Issue in rollback",e);
                     }
                 }
                 if(rs!=null){
     	            try { rs.close(); } catch (Exception e) {
     	            	ESLog.debug("Issue in finalize",e);
     	            }
                 }
                 
                 if(st!=null){
     	            try { st.close(); } catch (Exception e) {
     	            	ESLog.debug("Issue in finalize",e);
     	            }
                 }
                 
                 if(conn!=null){
     	            try { conn.close(); } catch (Exception e) {
     	            	ESLog.debug("Issue in finalize",e);
     	            }
                 }
             }
         return request;
    	
    }
    
    /**
     * The worker calls that method when it has no SubRequests to process and it
     * can send an email to the user (if emailing is enabled). The method would
     * build the request first based on the SubRequest data, store it in the
     * BATCH_REQUEST table, cleanup the BATCH_SUB_REQUEST table and return it to
     * the worker. If the reponse was already built, it just loads that response
     * and returns it immediately.
     *
     * @throws DataAccessException
     * @throws SQLException
     * @throws StreamCompressException
     * @throws IOException
     * @throws SifException
     * @throws DatabaseDownException 
     */
    public synchronized Request getRequestForEmailing(Request onSendingRequest)
            throws DataAccessException, SQLException, StreamCompressException, IOException, SifException, DatabaseDownException {
        ESLog.debug("getRequestForEmailing:Enter");
        Request request = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        Blob blob = null;
        boolean committed = false;
        InflaterInputStream iis = null;
        boolean failedFlag= true;
        try {
            conn = getConnection();
            if (onSendingRequest.getRequestId() == null || onSendingRequest.getRequestId().trim().length() == 0) {
            	return null;
            } else {
            	ESLog.debug("Send");
                st = conn.prepareStatement(GET_REQUEST_FOR_SEND,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                st.setString(1, onSendingRequest.getRequestId());
            }
            
            ESLog.debug("getRequestForEmailing: executeQuery");
            rs = st.executeQuery();
            if (rs.next()) {
                request = new Request();
                ESLog.debug("BR_REQUEST_ID=" + rs.getString("BR_REQUEST_ID"));
                request.setRequestId(rs.getString("BR_REQUEST_ID"));
                ESLog.debug("BR_STATUS=" + rs.getString("BR_STATUS"));
                request.setStatus(rs.getString("BR_STATUS"));
                ESLog.debug("BR_ERROR_MESSAGE=" + rs.getString("BR_ERROR_MESSAGE"));
                request.setErrorMessage(rs.getString("BR_ERROR_MESSAGE"));
                ESLog.debug("BR_EMAIL_RETRIES=" + rs.getInt("BR_EMAIL_RETRIES"));
                request.setEmailRetries(rs.getInt("BR_EMAIL_RETRIES"));
                ESLog.debug("BR_USER_FIRST_NAME=" + rs.getString("BR_USER_FIRST_NAME"));
                request.setUserFirstName(rs.getString("BR_USER_FIRST_NAME"));
                ESLog.debug("BR_USER_LAST_NAME=" + rs.getString("BR_USER_LAST_NAME"));
                request.setUserLastName(rs.getString("BR_USER_LAST_NAME"));
                ESLog.debug("BR_USER_EMAIL=" + rs.getString("BR_USER_EMAIL"));
                request.setEmailAddress(rs.getString("BR_USER_EMAIL"));
                ESLog.debug("BR_FILE_NAME=" + rs.getString("BR_FILE_NAME"));
                request.setFileName(rs.getString("BR_FILE_NAME"));
                ESLog.debug("BR_SUBREQUEST_COUNT=" + rs.getInt("BR_SUBREQUEST_COUNT"));
                request.setNbSubRequest(rs.getInt("BR_SUBREQUEST_COUNT"));
                request.setIncludeOffers("y".equalsIgnoreCase(rs.getString("BR_INCLUDE_OFFERS")));
                request.setIncludeContracts("y".equalsIgnoreCase(rs.getString("BR_INCLUDE_CONTRACTS")));
                if (ESLog.isDebugLogEnabled()) {
                    ESLog.debug("next request: " + request.toString());
                }

                // null-status should never happen. If the status is
                // 'processing', then we have to build the response and
                // store it in the database before we can return the
                // Request object.
                if (((onSendingRequest.getStatus() == null || onSendingRequest.getStatus().equals("processing")))
                        && request.getNbSubRequest() > 0) {
                	try {
                		ESLog.debug("getRequestForEmailing: request with none response");
                    	Date startGenerateResponse = new Date();
                		generateResponse(request, conn);
                        Date endGenerateResponse = new Date();
                        ESLog.debug("getRequestForEmailing: generateResponse finish");
                        ESLog.debug("generateResponse spend time: " + (endGenerateResponse.getTime()-startGenerateResponse.getTime()));
                        
                        long startStoreResponse=System.currentTimeMillis();
                        storeResponse(request, conn);
                        long endStoreResponse=System.currentTimeMillis();
                        ESLog.debug("StoreResponse spend time"+(endStoreResponse-startStoreResponse));
                        ESLog.debug("getRequestForEmailing: storeResponse finish");
                        
                        long startDeleteSubRequests=System.currentTimeMillis();
                        deleteSubRequests(request.getRequestId(), conn);
                        long endDeleteSubRequests=System.currentTimeMillis();
                        ESLog.debug("DeleteSubRequests spend time"+(endDeleteSubRequests-startDeleteSubRequests));
                        ESLog.debug("getRequestForEmailing: deleteSubRequests finish");
                	} catch (EsException e) {
                		ESLog.error("exception occurred when generate response. request id is " + request.getRequestId(), e);
                		failedFlag = false;
                		rs.updateString("BR_STATUS", "failed");
                		if(e.getMessage()!=null&&e.getMessage().trim().length()>0){
							rs.updateString("BR_ERROR_MESSAGE", e.getMessage().length()>1000?e.getMessage().substring(0,1000):e.getMessage());
						}
                		rs.updateRow();
                		deleteSubRequests(request.getRequestId(), conn);
                		request = null;
                		conn.commit();
	                    committed = true;
                	}
                }
                else {
                	ESLog.debug("getRequestForEmailing: request with response");
                    //No need to load the blob if there is no subrequest
                    if (request.getNbSubRequest() > 0) {
                        // this means that we are in a case where the response
                        // is built and stored already
                        // here we can just load the response for resending it
                        blob=rs.getBlob("BR_RESPONSE");
                        ESLog.debug("getRequestForEmailing: request with response blob");
                        if (blob != null && blob.length()!=0) {
                        	ESLog.debug("getRequestForEmailing: request with response blob is not null");
                            try {
								iis=BlobUtils.readBlob(blob);
								request.setStreamForCompressedResponse(iis);
							} catch (Exception e) {
								ESLog.error("getRequestForEmailing: request with response read blob failed. request id is " + request.getRequestId());
								//update SQL according to request id,update its status and comments(Exception e)
								if(request!=null){	
									failedFlag = false;
									rs.updateString("BR_STATUS", "failed");
									if(e.getMessage()!=null&&e.getMessage().trim().length()>0){
										rs.updateString("BR_ERROR_MESSAGE", e.getMessage().length()>1000?e.getMessage().substring(0,1000):e.getMessage());
									}
								}
								ESLog.debug("getRequestForEmailing: request with response read blob failed error handing");
								request = null;
								rs.updateRow();
			                    conn.commit();
			                    committed = true;
								ESLog.warn("read response blob failed:"+e.getMessage());
							}
                        }
                    }
                }
                ESLog.debug("getRequestForEmailing: failedFlag:"+failedFlag);
                if(failedFlag){
                    // We are going to update NEXT_SEND_TIME of 30 minutes to avoid sending the mail twice
                    // That's a workaround for now
                    //TODO find a cleaner solution
                    Timestamp t = new Timestamp(getCurrentTime(conn).getTime() + 30000L);
                    rs.updateTimestamp("BR_EMAIL_NEXT_SEND_TIME", t);

                    rs.updateString("BR_STATUS", "sending");
                    rs.updateRow();
                    conn.commit();
                    committed = true;
                }
                
                ESLog.debug("getRequestForEmailing: start to commit");
                conn.commit();
                committed = true;
            }
        } finally {
            if (!committed) {
                try { conn.rollback(); } catch (Exception e) {
                	ESLog.error("Issue in rollback",e);
                }
            }
            if(iis!=null){
	            try { iis.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            
            if(rs!=null){
	            try { rs.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            
            if(st!=null){
	            try { st.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            
            if(conn!=null){
	            try { conn.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
        }

        ESLog.debug("Exit");
        return request;
    }

    /**
     *
     * @param request
     * @param conn
     * @throws SQLException
     * @throws DataAccessException
     * @throws IOException
     * @throws StreamCompressException
     */
    private void storeResponse(Request request, Connection conn)
            throws SQLException, DataAccessException, IOException,
            StreamCompressException {

    	ESLog.debug("Enter");
        CallableStatement cst = null;
        try {
            cst = conn.prepareCall(UPDATE_REQUEST);
            cst.setString(1, request.getRequestId());
            cst.registerOutParameter(2, Types.BLOB);

            cst.executeUpdate();
            Blob blob=cst.getBlob(2);
            ByteArrayOutputStream responseStream = request.getStreamForCompressedResponse();
            BlobUtils.writeBlob(blob, responseStream);
            //Commit is being delegated to caller
        } finally {
        	if(cst!=null){
	            try { cst.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
        	}
        }
    }

    /**
     * Update the status and the current number of retries.
     * No synchronization necessary because this method will be called by one
     * thread.
     *
     * @param request
     * @throws SQLException
     * @throws DataAccessException
     * @throws DatabaseDownException 
     */
	public void updateRequestStatus(Request request)
            throws DataAccessException, SQLException, DatabaseDownException {
        ESLog.debug("Enter");

        Connection conn = null;
        //ResultSet rs = null;
        PreparedStatement st = null;
        boolean committed = false;

        try {
            /*
             * This method is called to set the status when we have tried to
             * send an email with or without succes?
             */
            conn = getConnection();
            st = conn.prepareStatement(UPDATE_REQUEST_AFTER_EMAIL_SENDING);

            st.setString(1, request.getStatus());
            st.setInt(2, request.getEmailRetries());
            st.setInt(3, retryInterval);
            st.setString(4, request.getRequestId());
            st.executeUpdate();

            conn.commit();
            committed = true;
        } finally {
            if (!committed && conn != null) {
                try { conn.rollback(); } catch (Exception e) {
                	ESLog.error("Issue in rollback",e);
                }
            }
          //  try { rs.close(); } catch (Exception e) {}
            if(st!=null){
	            try { st.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            if(conn!=null){
	            try { conn.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }

            ESLog.debug("Exit");
        }
    }
    
    /**
     * The method updates the current SubRequest in the database. It stores the
     * whole XML string (in a compressed format) and updates the status to
     * 'processed'. Other fields are not updated, because they never change.
     * No synchronization necessary because this method will be called by one
     * thread.
     *
     * @param subRequest
     * @throws DataAccessException
     * @throws SQLException
     * @throws DatabaseDownException 
     */
    public void updateSubRequest(SubRequest subRequest)
            throws DataAccessException, SQLException, DatabaseDownException {
        ESLog.debug("Enter");

        Connection conn = null;
        CallableStatement cst = null;
        Blob blob = null;
        Blob csvBlob = null;
        boolean committed = false;

        /*
         * The SunRequest object will only be updated in one condition
         */
        try {
            //we assume that the response is not null.

            conn = getConnection();

            if (ESLog.isDebugLogEnabled()) {
                ESLog.debug("Running query to update SubRequest");
            }
            cst = conn.prepareCall(UPDATE_SUBREQUEST);

           // cst.setBlob(1, BlobUtils.getEmptyBlob());
            cst.setString(1, subRequest.getRequestId());
            cst.setString(2, subRequest.getItem());
            cst.registerOutParameter(3, Types.BLOB);
            cst.registerOutParameter(4, Types.BLOB);

            cst.executeUpdate();

            // We get the blob
            blob = cst.getBlob(3);
            if (blob != null) {
                //and we upload it in the database (this will zip it)
                // If the subRequest.getResponse() return null we let it generate
                // NullPointerException
                // This is expected
                BlobUtils.writeCompressedBlob(blob, subRequest.getResponse());
            }
            csvBlob=cst.getBlob(4);
            if (csvBlob != null) {
                //and we upload it in the database (this will zip it)
                // If the subRequest.getResponse() return null we let it generate
                // NullPointerException
                // This is expected
                BlobUtils.writeCompressedBlob(csvBlob, subRequest.getCsvResponse());
            }

            conn.commit();
            committed = true;
        }
        finally {
            if (!committed && conn != null) {
                try { conn.rollback(); } catch (Exception e) {
                	ESLog.error("Issue in rollback",e);
                }
            }
            if(cst!=null){
	            try { cst.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            if(conn!=null){
	            try { conn.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }

            ESLog.debug("Exit");
        }
    }

    /**
     * Get sub requests from db, map them to java object SubRequest, then use a local container subRequestList to hold
     * them.
     * 
     * @param currentRequestId
     *            If no current request, its value will be null.
     * @param subRequestListMaxSize
     *            Specify the max size of sub requests loaded from database to local memory
     * @return if no sub request is got from db, a list with size=0 is returned.
     * @throws DatabaseDownException 
     */
    public synchronized List<SubRequest> getSubRequestList(String currentRequestId, int subRequestListMaxSize)
            throws DataAccessException, SQLException, DatabaseDownException {
        ESLog.debug("Enter");
        List<SubRequest> subRequestList = new ArrayList<SubRequest>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cst = null;

        try {
            conn = getConnection();
            cst=conn.prepareCall(GET_NEXT_SUBREQUEST_LIST);
            cst.setString(1, currentRequestId);
            cst.setInt(2, subRequestListMaxSize);
            cst.registerOutParameter(3, OracleTypes.INTEGER);
            cst.registerOutParameter(4, OracleTypes.VARCHAR);
            cst.registerOutParameter(5, OracleTypes.VARCHAR);
            cst.registerOutParameter(6, OracleTypes.CURSOR);
            
            cst.executeQuery();            

            ESLog.debug("Query is executed, we will create SubRequest object one by one.");

            boolean includeContracts="y".equalsIgnoreCase(cst.getString(4));
            boolean includeOffers="y".equalsIgnoreCase(cst.getString(5));
            rs=(ResultSet) cst.getObject(6);
            
            while (rs.next()) {
                SubRequest subRequest = new SubRequest();
                
                subRequest.setRequestId(rs.getString("BSR_REQUEST_ID"));
                subRequest.setItem(rs.getString("BSR_ITEM"));
                subRequest.setStatus(rs.getString("BSR_STATUS"));
                subRequest.setIsoCountryCode(rs.getString("BSR_ISO_COUNTRY_CODE"));
                subRequest.setSerialNumber(rs.getString("BSR_SERIAL_NUMBER"));
                subRequest.setProductId(rs.getString("BSR_PRODUCT_ID"));
                subRequest.setCheckDate(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("BSR_CHECK_DATE")));
                subRequest.setIncludeContracts(includeContracts);
                subRequest.setIncludeOffers(includeOffers);
                
                ESLog.debug("Created a SubRequest: " + subRequest.toString());
                subRequestList.add(subRequest);
            }
            ESLog.debug("Totally " + subRequestList.size()+" sub requests are got from db");
        } finally {
        	if(rs!=null){
	            try { rs.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
        	}
        	if(cst!=null){
	            try { cst.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
        	}
            if(conn!=null){
	            try { conn.close(); } catch (Exception e) {
	            	ESLog.debug("Issue in finalize",e);
	            }
            }
            ESLog.debug("Exit");
        }        
        return subRequestList;
    }
    
    
    public static boolean isSeriousOracleIssue(Exception e) {
        String message = e.getMessage();
        
        if (message != null && (message.indexOf("ORA-00054") != -1)) {
        	return false;
        }
    	
		return true;
	}
}