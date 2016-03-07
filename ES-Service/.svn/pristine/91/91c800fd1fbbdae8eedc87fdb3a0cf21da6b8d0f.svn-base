package com.hp.es.service.serviceNotes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import oracle.jdbc.OracleTypes;

import com.hp.es.service.db.DbConnectionManager;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.OracleHelper;
import com.hp.es.xml.service.ServiceNoteComplexType;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * This class handles the access to the database for all requests
 * related to service notes.
 */

public class DbServiceNoteManager {

    static private DbServiceNoteManager instance = new DbServiceNoteManager();

    
    /*
     *  PROCEDURE get_service_notes (
     *     p_product_id                 IN       product.product_id%TYPE,
     *     p_service_note               OUT      cursortype,
     *     p_affected_unit              OUT      cursortype
     *  )
     */    
	static final private String GET_SERVICE_NOTES =
        "{call sn_access.get_service_notes(?,?,?)}";

    /**
     * Call the database procedure get_service_notes() and read all
     * returned cursors. An array of ServiceNoteCompleyType objects
     * is created as the result.
     * @param productId the product number
     */
    public ServiceNoteComplexType[] getServiceNotes ( String productId, String serialNumber, MetricsHandler mh)
        throws DatabaseDownException, DataAccessException, SifException {

        ServiceNoteComplexType[] result = null;


        Connection connection = null;
        CallableStatement statement = null;

        ResultSet snrs = null;
        ResultSet aurs= null;

        try {
            connection = DbConnectionManager.getInstance().getReadonlyConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareCall(GET_SERVICE_NOTES);

            statement.setString( 1, productId);
            statement.registerOutParameter(2, OracleTypes.CURSOR);
            statement.registerOutParameter(3, OracleTypes.CURSOR);

            MetricsEntry me = null;
            if (mh !=null ) me = mh.startEntry("getServNotes_SqlExec");
            statement.execute();
            if (me !=null ) me.actionDone();

            // any error occured?
            //errorCode = statement.getInt(20);

            // Now read all returned cursors
            if (mh !=null )  me = mh.startEntry("getServNotes_GetRS: snrs");
            snrs = (ResultSet)statement.getObject(2);
            if (me !=null ) me.actionDone();
            if (mh !=null ) me = mh.startEntry("getServNotes_GetRS: aurs");
            aurs = (ResultSet)statement.getObject(3);
            if (me !=null ) me.actionDone();

            //================================================================
            // There could be multiple serial number ranges for the same service note
            // number and same product id. This is not reflected in the ES interface
            // as of today - it would result in two ServiceNote elements that repeat
            // all the other fields except the start/end serial numbers.
            // To correctly deal with this we first read the AFFECTED_UNIT_KM result
            // set so that we know how many ServiceNote objects to create.
            // The remaining service note details are then filled in from the
            // SERVICE_NOTE_KM result set. 

            // We use TreeMaps on both levels to ensure consistent sorting across executions
            // => ease regression testing
            
            int count = 0; // keep track how many entries we'll have in the end
            Map<String, TreeMap> snNumberMap = new TreeMap<String, TreeMap>();
            while (aurs.next()) {
            	// create a new instance and fill data from AFFECTED_UNIT_KM
            	String snNumber = aurs.getString("SERVICE_NOTE_NUMBER");
            	String startSerial = aurs.getString("START_SERIAL_NUMBER");
            	String endSerial = aurs.getString("END_SERIAL_NUMBER");
				if (!checkSNRange(serialNumber, startSerial, endSerial))
					continue;
            	ServiceNoteComplexType snote = new ServiceNoteComplexType();
            	snote.setServiceNoteNumber(snNumber);
            	snote.setStartingSerialNumber(nullAsEmptyString(startSerial));
            	snote.setEndingSerialNumber(nullAsEmptyString(endSerial));
                // create a container for all the entries relating to this
            	// service note number if not already there
            	if (! snNumberMap.containsKey(snNumber)) {
            		snNumberMap.put(snNumber, new TreeMap());
            	}
                // add the partially filled ServiceNote object for this range
            	Map subMap = snNumberMap.get(snNumber);
            	subMap.put(""+startSerial+":"+endSerial,snote);
				count++;
            }
            
            while (snrs.next()) {
            	// read the data
            	String snNumber = snrs.getString("SERVICE_NOTE_NUMBER");
                String description = snrs.getString("DESCRIPTION");
                String recommendedAction = snrs.getString("RECOMMENDED_ACTION");
                String objective = snrs.getString("SERVICE_NOTE_CATEGORY");
                org.exolab.castor.types.Date expiryDate = null;
            	java.sql.Date sqlDate = snrs.getDate("EXPIRY_DATE");
            	if (sqlDate != null) {
            		expiryDate = new org.exolab.castor.types.Date(new java.util.Date(sqlDate.getTime()));
            	}
            	// find the ranges relating to the same service note number and fill in the read data
            	Map ranges = snNumberMap.get(snNumber);
				if (ranges == null)
					continue;
            	Iterator it = ranges.keySet().iterator();
            	while (it.hasNext()) {
                    // they keys in the "ranges" map are the combination of start and end serial
                    String rangeDesc = (String) it.next();
            		ServiceNoteComplexType snote = (ServiceNoteComplexType)ranges.get(rangeDesc);
            	    snote.setServiceNoteDescription(nullAsEmptyString(description));
            	    snote.setExpireDate(expiryDate);
            	    snote.setRecommendedAction(nullAsEmptyString(recommendedAction));
            	    snote.setServiceNoteObjective(nullAsEmptyString(objective));                           	
            	}
            }
            
            // finally flatten the generated service notes into an array
            result = new ServiceNoteComplexType[count];
            int index = 0;
            Iterator<String> it1 = snNumberMap.keySet().iterator();
            while (it1.hasNext()) {
            	String snNumber = it1.next();
            	Map ranges = snNumberMap.get(snNumber);
            	Iterator it2 = ranges.keySet().iterator();
            	while (it2.hasNext()) {
            		String rangeDesc = (String) it2.next();
            		result[index] = (ServiceNoteComplexType)ranges.get(rangeDesc);
            		index++;
            	}
            }
                        
            //================================================================            
            
        }
        catch (SQLException e) {
        	ESLog.error("SDB Exception in finalize", e);
            String nl = System.getProperty("line.separator");
            StringBuffer buf = new StringBuffer();
            buf.append(nl);
            buf.append("productId=");
            buf.append(productId);
            buf.append(nl);

            throwException(e, "DbServiceNoteManager.getServiceNotes",
                            buf.toString());
        }
        finally {
        	MetricsEntry allClose = null;
        	if (mh !=null ) allClose = mh.startEntry("getServNotes_CloseAll");
            try { snrs.close(); } catch (Exception e) {
            	ESLog.debug("Exception in finalize", e);
            }
            try { aurs.close();} catch (Exception e) {
            	ESLog.debug("Exception in finalize", e);
            }
            try { statement.close();} catch (Exception e) {
            	ESLog.debug("Exception in finalize", e);
            }//This was missing....
            try { connection.close(); } catch (Exception e) {
            	ESLog.debug("Exception in finalize", e);
            }
            
            if (mh !=null ) allClose.actionDone();

        }

        return result;

    }


    /**
     * private constructor
     */
    private DbServiceNoteManager() {   
    }

    /**
     * @return the DbSystemHandleManager object (singleton).
     */
    public static DbServiceNoteManager getInstance() {
        return instance;
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

        if(e.getMessage().indexOf("ORA-06512") != -1){
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
    
    private String nullAsEmptyString(String input) {
    	return (input == null ? "" : input);
    }
	/**
	 * Check the serialnumber in the range between start serialnumber and end serialnumber
	 * @param serial
	 * @param startSerial
	 * @param endSerial
	 * @return
	 */
	private boolean checkSNRange(String serial, String startSerial,
			String endSerial) {
		if ( serial == null
				|| "".equals(serial.trim()) 
				|| startSerial == null
				||"".equals(startSerial.trim())
				|| endSerial == null
				|| "".equals(endSerial.trim())) 
			return true;
		
		int sLength = serial.length();
		int ssLength = startSerial.length();
		int esLength = endSerial.length();
		
		if (sLength != ssLength || sLength != esLength
				|| (sLength < 10 && sLength > 12))
			return true;
		
		if (!isLexical(serial) || !isLexical(startSerial)
				|| !isLexical(endSerial))
			return true;
		if (serial.compareTo(startSerial) < 0
				|| serial.compareTo(endSerial) > 0)
			return false;
		return true;
	}

	/**
	 *
	 * @param s
	 * @return
	 */
	private boolean isLexical(String s) {
		if (s == null || s.equals(""))
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isLetterOrDigit(s.charAt(i)))
				return false;
		}
		return true;
	}
}
