/*
 * Created on Dec 20, 2004
 */
package com.hp.es.service.batchEntitlement;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hp.es.service.util.ESLog;
import com.hp.ruc.io.CsvReader;

/**
 * Read the data for a batch entitlement request from the CSV file. The data
 * should have the format
 * <p>
 * IsoCountryCd,SerialNumber,ProductNumber
 * <p>
 * If a parameter is not valid (invalid lenght, invalid number of input fields),
 * the class replaces the invalid parameter with "??" and returns the correct
 * number of fields. The method lastRowWasValid() can be used to verify if the
 * last row of data was ok or not.
 */
public class BatchCsvReader extends CsvReader {
	
	private static final int MAX_ISO_COUNTRY_CODE_LENGTH = 2;

	private static final int MAX_SERIAL_NUMBER_LENGTH = 32;

	private static final int MAX_PRODUCT_NUMBER_LENGTH = 18;

	private static final String BAD_PARAMETER = "??";

	private String[] lastRow = null;

	private boolean lastRowWasValid = true;

	/*
	 * Hold the line number and line content of errors.
	 */
	private Map errorLineMap = new TreeMap();

	/**
	 * @param reader
	 */
	public BatchCsvReader(Reader reader) {
		super(reader);
	}

	/**
	 * Overwrites the method from CsvReader. It adds some error handling and
	 * guarantees that the returned Strin array has valid data. In cases were
	 * the input data (in the CSV file) are incorrect, it "fixes" these data,
	 * i.e. it replaces invalid paramter with "??"
	 */
	public String[] getAllFieldsInLine() throws EOFException, IOException {
		String[] next = super.getAllFieldsInLine();
		String[] copyOfNext=null;
		if(next != null) {
			copyOfNext=(String[])next.clone();
		}
		
		if (next == null) {
			lastRow = new String[4];
			lastRowWasValid = false;			
		} else if (next.length != 4) {
			lastRow = new String[4];
			System.arraycopy(next, 0, lastRow, 0,
					(next.length < 4 ? next.length : 4));
			lastRowWasValid = false;
			ESLog.info("The request csv file contained " + next.length
					+ " columns, instead of 4");
		} else {
			lastRow = next;
			lastRowWasValid = true;
		}

		lastRow[0] = fixColumn(lastRow[0], MAX_ISO_COUNTRY_CODE_LENGTH);
		lastRow[1] = fixColumn(lastRow[1], MAX_SERIAL_NUMBER_LENGTH);
		lastRow[2] = fixColumn(lastRow[2], MAX_PRODUCT_NUMBER_LENGTH);
		lastRow[3] = fixCheckDate(lastRow[3]);

		if (lastRowWasValid) {
			if (lastRow[0].length() == 0 && lastRow[1].length() == 0
					&& lastRow[2].length() == 0) {
				lastRowWasValid = false;
			}
		}
		//hold error line
		if(lastRowWasValid==false)
			addErrorLine(getLineCount(),copyOfNext);
		
		return lastRow;
	}

	/**
	 * This method returns the status of the last array returned by
	 * getAllFieldsInLine().
	 * 
	 * @return true if the data returned by the previous call to
	 *         getAllFieldsInLine() can be used to start a getEntBySn operation.
	 *         false if input parameter were not valid.
	 */
	public boolean lastRowWasValid() {
		return lastRowWasValid;
	}

	/**
	 * @param string
	 * @param length
	 */
	private String fixColumn(String string, int length) {
		if (string == null) {
			lastRowWasValid = false;
			return "";
		}
		String x = string.trim();
		if (x.length() > length) {
			x = BAD_PARAMETER;
			lastRowWasValid = false;
		}
		return x;
	}
	
	/**
	 * @param string
	 */
	private String fixCheckDate(String dateStr) {
		if (dateStr == null || "".equals(dateStr.trim())) {
			return "";
		}
		dateStr = dateStr.trim();
		Date checkDate = null;
		
		DateFormat dateFormat = null;
		
		try {
			if (dateStr.length() <= 10) {
				if(dateStr.indexOf("-") > -1) {
					dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				} else if (dateStr.indexOf("/") > -1) {
					dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				} else {
					throw new Exception();
				}
				dateFormat.setLenient(false);
				checkDate = dateFormat.parse(dateStr);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			dateStr = BAD_PARAMETER;
			lastRowWasValid = false;
		}
		
		if(lastRowWasValid) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -90);
			if(checkDate.after(new Date()) || checkDate.before(cal.getTime())) {
				dateStr = BAD_PARAMETER;
				lastRowWasValid = false;
			}
		}
		return dateStr;
	}

	/**
	 * @param lineNumber
	 * @param lineContent
	 */
	private void addErrorLine(int lineNumber, String[] lineContent) {
		if (errorLineMap.get(lineNumber + "") == null)
			errorLineMap.put(lineNumber + "", Arrays.asList(lineContent));
	}
	/**
	 * 
	 * @return error line message
	 */
	public String getErrorLineMessage() {
		
		if(errorLineMap.size()==0)
			return "";
		
		StringBuffer result=new StringBuffer("\nError Lines:\n");
		for(Iterator it=errorLineMap.keySet().iterator();it.hasNext();){
			String key=(String)it.next();
			result.append(key+":"+errorLineMap.get(key)+"\n");
		}
		return result.toString();
	}
}