/**
 * 
 */
package com.hp.es.service.customerIndicator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.hp.es.service.db.DbConnectionManager;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.OracleHelper;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author yesilyur
 *
 */
public class DbCustomerIndicatorManager implements ConfigChangeListener{

	private DbConnectionManager connectionManager;
    static private DbCustomerIndicatorManager instance = null;
    
    private ArrayList listCustomIndicat = new ArrayList();;
	
    
    public int getCustomerIndicator(ArrayList listSoltTo,EsRequestComplexType request, MetricsHandler handler)throws DatabaseDownException, DataAccessException,SifException{

        if((listSoltTo == null) || (listSoltTo.size() <= 0)){
        	return 0;
        }
        	
    
        Statement stmt       = null;
        ResultSet rs         = null;

        String sqlStr = "";
        Connection connection = null;
        int errorCode = 0;
        MetricsEntry stmtExec = null;
        try {
            connection = this.connectionManager.getReadonlyConnection();
            connection.setAutoCommit(false);
            
            sqlStr = " SELECT AMID_L1, CUSTOMER_INDICATOR_NAME, " +
			"CUSTOMER_INDICATOR_VALUE FROM AMID_L1_CUSTOMER_IND_VIEW " +
			"WHERE AMID_L1 IN ";
            
            String sqlStr1000 = sqlStr;
            
            String sqlSubString = " ( ";
            String sqlSubString1000 = sqlSubString;
            
            int count = 0;
            Iterator itr = listSoltTo.iterator();
            String strSoldTo = "";
            while(itr.hasNext())
            {
            	strSoldTo = (String)itr.next();
            	if(count == 0)
                {
                      sqlSubString += " '"+strSoldTo.trim()+"'";
                }
                else
                {
                      sqlSubString += ", '"+strSoldTo.trim()+"'";
                }
                if (count == 999 /*oracle operation max 1000*/){
                      sqlSubString = sqlSubString + " ) "; 
                      sqlStr = sqlStr +  sqlSubString;          

                      stmt = connection.createStatement();
                      if(handler!=null)
                    	  stmtExec = handler.startEntry("getCustomIndicat1000_SqlExec");
                      rs = stmt.executeQuery(sqlStr);
                      if(stmtExec != null)
                    	  stmtExec.actionDone();
                      int intCnt = 0;

                      if(rs != null){
                          while (rs.next())
                          {
                          	CustomIndicator custIndic = new CustomIndicator();
                          	custIndic.setSoldToCustomerID(rs.getString("AMID_L1"));
                          	custIndic.setCustomerIndicatorName(rs.getString("CUSTOMER_INDICATOR_NAME"));
                          	custIndic.setCustomerIndicatorValue(rs.getString("CUSTOMER_INDICATOR_VALUE"));
                          	listCustomIndicat.add(custIndic);
                        	intCnt = intCnt +1;                          	
                          }                    	  
                      }else{
                      	// check for "NO DATA FOUND"
                          errorCode = ErrorFactory.id300_NO_DATA_FOUND;
                          return errorCode;
                      }
                      if(intCnt == 0){
                      	// check for "NO DATA FOUND"
                          errorCode = ErrorFactory.id300_NO_DATA_FOUND;
                          return errorCode;                	
                      }

                      sqlSubString = sqlStr1000;
                      sqlStr = sqlSubString1000;
                      count =0;
                      try { rs.close(); } catch (Exception e) {}
                      rs=null;
                  	  try { stmt.close(); }  catch (Exception e) {} 
                  	  stmt =null;
                  	  
                }else 
                {
                    count++; 
                }
            }
            
            

            
            sqlSubString = sqlSubString + " ) "; 
            sqlStr = sqlStr +  sqlSubString;          

            stmt = connection.createStatement();
            if(handler!=null)
            	stmtExec = handler.startEntry("getCustomIndicat_SqlExec");
            
            rs = stmt.executeQuery(sqlStr);
           
            if(stmtExec!=null)          
            	stmtExec.actionDone();
       
            listCustomIndicat.clear();
            int intCnt = 0;
            if(rs != null){
                while (rs.next())
                {
                	CustomIndicator custIndic = new CustomIndicator();
                	custIndic.setSoldToCustomerID(rs.getString("AMID_L1"));
                	custIndic.setCustomerIndicatorName(rs.getString("CUSTOMER_INDICATOR_NAME"));
                	custIndic.setCustomerIndicatorValue(rs.getString("CUSTOMER_INDICATOR_VALUE"));
                	listCustomIndicat.add(custIndic);
                	intCnt = intCnt +1;
                }            	
            }else{
            	// check for "NO DATA FOUND"
                errorCode = ErrorFactory.id300_NO_DATA_FOUND;
                return errorCode;
            }
            if(intCnt == 0){
            	// check for "NO DATA FOUND"
                errorCode = ErrorFactory.id300_NO_DATA_FOUND;
                return errorCode;                	
            }
            
           
        }catch (SQLException e) {
            StringBuffer buf = new StringBuffer();
            throwException(e, "DbCustomerIndicatorManager.getContractSummary",buf.toString()); 
        }catch (DatabaseDownException dde) {
            ESLog.error("Caught DatabaseDownException while calling getCustomerIndicator", dde);
            throw dde;
        }catch(Exception daEx){
            ESLog.error("Unknown DB exception: "+sqlStr,daEx);
            DataAccessException exception = new DataAccessException(daEx);
            throw exception;
        }
        
        
        finally {
            try { rs.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
        	try { stmt.close(); }  catch (Exception e) {ESLog.debug("error in finally",e);}
            try { connection.commit(); }  catch (Exception e) {ESLog.debug("error in finally",e);}
            try { connection.close(); } catch (Exception e) {ESLog.debug("error in finally",e);}
            if(stmtExec!=null)          
            	stmtExec.actionDone();
        }
        
    	return errorCode;
    }
    
    
    
	
    /*
     * This method reloads the configuration from the database. 
     *  (non-Javadoc)
     * @see com.hp.ruc.config.ConfigChangeListener#configChanged(com.hp.ruc.config.ConfigChangeEvent)
     */
	public void configChanged(ConfigChangeEvent event) {
	}
	
	
	
	/**
     * private constructor
     */
    private DbCustomerIndicatorManager() {
    	Configuration.getInstance().addConfigChangeListener(this);
        connectionManager = DbConnectionManager.getInstance();
        
    }
	
	
    /**
     * @return the DbCustomerIndicatorManager object (singleton).
     */
    public static synchronized DbCustomerIndicatorManager getInstance() {
        if (instance == null) {
                    instance = new DbCustomerIndicatorManager();

        }
        return instance;
    }



	public ArrayList getListCustomIndicat() {
		return listCustomIndicat;
	}
	
	   /**
     * Map the SQLException to a DatabaseDownException or DataAccessException
     * and throw the new exception.
     * @param e
     * @param methodName
     * @param paramList
     * @throws DatabaseDownException
     * @throws DataAccessException
     * @throws SifException
     */
    private void throwException(SQLException e, String methodName, String paramList)
        throws DatabaseDownException, DataAccessException, SifException {

        if (OracleHelper.isDatabaseDown(e.getErrorCode())) {
            throw new DatabaseDownException(e);
        }
        String message = e.getMessage();
        
        if (message != null && (message.indexOf("ORA-06512") != -1 || message.indexOf("ORA-06502") != -1 || message.indexOf("ORA-04063") != -1 || message.indexOf("ORA-01013") != -1) ) {
            ESLog.error("DB exception (" + methodName + "): One of the parameter is too long: " + paramList, e);
            throw ErrorFactory.getSifException(
                    ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                    "One of the parameters are too long.");
        }

        ESLog.error("Unknown DB exception (" + methodName
                + "): The procedure was called with following parameter:"
                + paramList, e);
        DataAccessException exception = new DataAccessException(e);
        exception.setErrorCode(e.getErrorCode());
        throw exception;
    }
	

}
