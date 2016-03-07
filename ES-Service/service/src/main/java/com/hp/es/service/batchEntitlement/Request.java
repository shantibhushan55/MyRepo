/*
 * Created on Dec 8, 2004
 */
package com.hp.es.service.batchEntitlement;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.hp.es.service.util.ESLog;
import com.hp.ruc.io.StreamUtil;
import com.hp.ruc.io.zip.StreamCompress;
import com.hp.ruc.io.zip.StreamCompressException;
import com.hp.sif.SifException;

/**
 * @author stefsobe
 *
 */
public class Request {
    private static final String HEADER_RESPONSE=
        "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"+
        "<BatchEntitlement>\n";
    
    private static final String TRAILER_RESPONSE=
        						"</BatchEntitlement>\n\r";
    private static final String XML_ENC="UTF-8";
    
    private String requestId;
    private String status;
    private String errorMessage;
    private String userFirstName;
    private String userLastName;
    private String emailAddress;
    private String fileName;
    private String response;
    private int emailRetries;
    private int nbSubRequest;
    private boolean includeOffers;
    private boolean includeContracts;
    
    /*
     * The compress response
     */
    private ByteArrayOutputStream compressResponse;
    
    /*
     * A stream Compress object used to build the final ZIPPED response
     */
    private StreamCompress scZippedXmlResponseUtil = new StreamCompress();
    
    /*
     * Another stream compress used to 
     */
    private StreamCompress scZippedCsvResponseUtil = new StreamCompress();
    
    private static final String XML_PREFIX = ".xml";
    private static final String CSV_PREFIX = ".csv";
    private static final String DEFAULT_XML_FILE_NAME = "batch.xml";
    private static final String DEFAULT_CSV_FILE_NAME = "batch.csv";
    
    /**
     * @return Returns the emailAddress.
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
     * @param emailAddress The emailAddress to set.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /**
     * @return Returns the emailRetries.
     */
    public int getEmailRetries() {
        return emailRetries;
    }
    /**
     * @param emailRetries The emailRetries to set.
     */
    public void setEmailRetries(int emailRetries) {
        this.emailRetries = emailRetries;
    }
    /**
     * @return Returns the errorMessage.
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    /**
     * @param errorMessage The errorMessage to set.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    /**
     * @return Returns the fileName.
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * @param fileName The fileName to set.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * @return Returns the requestId.
     */
    public String getRequestId() {
        return requestId;
    }
    /**
     * @param requestId The requestId to set.
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    /**
     * @return Returns the response.
     */
    public String getResponse() {
        return response;
    }
    /**
     * @param response The response to set.
     */
    public void setResponse(String response) {
        this.response = response;
    }
    /**
     * @return Returns the status.
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return Returns the userFirstName.
     */
    public String getUserFirstName() {
        return userFirstName;
    }
    /**
     * @param userFirstName The userFirstName to set.
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }
    /**
     * @return Returns the userLastName.
     */
    public String getUserLastName() {
        return userLastName;
    }
    /**
     * @param userLastName The userLastName to set.
     */
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
    
    /**
     * @return Returns the nbSubRequest.
     */
    public int getNbSubRequest() {
        return nbSubRequest;
    }
    /**
     * @param nbSubRequest The nbSubRequest to set.
     */
    public void setNbSubRequest(int nbSubRequest) {
        this.nbSubRequest = nbSubRequest;
    }
    

	/**
	 * @return Returns the includeContracts.
	 */
	public boolean isIncludeContracts() {
		return includeContracts;
	}
	/**
	 * @param includeContracts The includeContracts to set.
	 */
	public void setIncludeContracts(boolean includeContracts) {
		this.includeContracts = includeContracts;
	}
	/**
	 * @return Returns the includeOffers.
	 */
	public boolean isIncludeOffers() {
		return includeOffers;
	}
	/**
	 * @param includeOffers The includeOffers to set.
	 */
	public void setIncludeOffers(boolean includeOffers) {
		this.includeOffers = includeOffers;
	}
    /**
     * This method make the XML file name based on the CSV file name
     * if there is an error, we give a basic name stored in that class
     * @param fileName2
     * @return the generated file name
     */
    private String getXmlFileName() {
        String xmlFileName = null;

        // The file name is incorrect (empty or nor easily parsable) or it does not end with CSV
        if (fileName == null || fileName.trim().length() == 0 || 
                !fileName.trim().endsWith(CSV_PREFIX)) {
            xmlFileName = DEFAULT_XML_FILE_NAME;
        }
        else {
            xmlFileName = fileName.substring(0, fileName.indexOf(CSV_PREFIX));
            xmlFileName = xmlFileName + XML_PREFIX;
        }

        return xmlFileName;
    }

    /**
     * This method make the CSV result file name bnased on the CSV file name
     * if there is an error, we give a basic name stored in that class
     * @param fileName2
     * @return the generated file name
     */
    private String getCSVFileName() {
        String csvFileName = null;

        //The file name is incorrect (empty or nor easily parsable) or it does not end with CSV
        if (fileName == null || fileName.trim().length() == 0
                || !fileName.trim().endsWith(CSV_PREFIX)) {
            csvFileName = DEFAULT_CSV_FILE_NAME;
        }
        else {
            csvFileName = fileName;
        }

        return csvFileName;
    }    
    
    /**
     * method that add the header to the OutputStream used to represent the response
     * Note: addHeader also create the entry
     */
    public void addHeaderToResponse() throws StreamCompressException, IOException {
        
        //We assume that the name of the file generated will be the same as the input file
        scZippedXmlResponseUtil = new StreamCompress();
        scZippedXmlResponseUtil.addEntry(getXmlFileName());
        scZippedXmlResponseUtil.addContentToCurrentEntry(HEADER_RESPONSE.getBytes(XML_ENC));
        
        
        //We now do exactly the same for the CSV
        scZippedCsvResponseUtil = new StreamCompress();
        scZippedCsvResponseUtil.addEntry(getCSVFileName());
        scZippedCsvResponseUtil.addContentToCurrentEntry(BatchxmlConverter.FIRSTLINE.getBytes(XML_ENC));
    }    

    /**
     * method that add the trailer to the OutputStream used to represent the response
     * Note: add trailer also close the current entry
     */
    public void addTrailerToResponse() throws StreamCompressException, IOException{
        //We added the response inside
        scZippedXmlResponseUtil.addContentToCurrentEntry(TRAILER_RESPONSE.getBytes(XML_ENC));
        scZippedXmlResponseUtil.closeCurrentEntry();

        scZippedXmlResponseUtil.mergeAnotherStreamCompressInside(scZippedCsvResponseUtil);
        
        compressResponse = scZippedXmlResponseUtil.getFinishedZipSreamCompressed();
    } 
    
    
    private String readResponse(InputStream in) throws IOException{
    	 BufferedReader br = null;
         InputStreamReader isr = null;
         String responseString = null;
         try {
         isr = new InputStreamReader(in, XML_ENC);
         br =  new BufferedReader(isr);
	        StringBuffer sbTmp = new StringBuffer(2048);
	        char[] buffer = new char[2048];
	        int amountRead;
	        while ((amountRead = br.read(buffer)) >= 0) {
             sbTmp.append(buffer, 0, amountRead);
         }
	       responseString = sbTmp.toString();
	       }
	        finally {
	        	if(br != null) {
	        		try { br.close(); } catch(Exception e) {}
	        	}
	        	if(isr != null) {
	        		try { isr.close(); } catch(Exception e) {}
	        	}
	        }
	        return responseString;
    }

    /*
     * method that add an InputStream in the zipped response
     * @param the InputStream
     * @throws StreamCompressException, IOException 
     */
    public void appendStreamToResponse(InputStream in,InputStream csvin) throws StreamCompressException, IOException, SifException {   
    	long start=System.currentTimeMillis();
    	String xmlString =readResponse(in);
    	long end=System.currentTimeMillis();
        ESLog.debug("Read xml file by BufferedReader time: " + (end - start));
        start=System.currentTimeMillis();
        start=System.currentTimeMillis();
        String csvLines=readResponse(csvin);
    	end=System.currentTimeMillis();
    	ESLog.debug("Read csv file by BufferedReader time: " + (end - start));
        start=System.currentTimeMillis();
        scZippedCsvResponseUtil.addContentToCurrentEntry(csvLines.getBytes(XML_ENC));
        end=System.currentTimeMillis();
        ESLog.debug("Add csv Content To Current Entry time:"+ (end - start));
        start=System.currentTimeMillis();
        scZippedXmlResponseUtil.addContentToCurrentEntry(xmlString.getBytes(XML_ENC));
        end=System.currentTimeMillis();
        ESLog.debug("Add xml Content To Current Entry time:"+ (end - start));
    }    
    
    /**
     * getStreamForCompressedResponse
     * @return Returns the compressResponse.
     * This method will return Null if the stream had not been built yet.
     * @throws StreamCompressException
     */
    public ByteArrayOutputStream getStreamForCompressedResponse() throws StreamCompressException  {
        //For now we keep it like that as we want to write to db and to email
        return compressResponse;
    }
    
    
    /**
     * @param an inputStream (compressed from db)
     * @throws IOException
     * @throws IOException
     */
    public void setStreamForCompressedResponse(InputStream fromDb) throws IOException  {
        //This method should copy the stream from the database in memory in the StreamCompress Object for example
        //this.compressResponse = compressResponse;
        compressResponse = new ByteArrayOutputStream(); 
        StreamUtil.copyInputToOutput(fromDb, compressResponse);
        scZippedXmlResponseUtil = null;
    }
    
    /**
     * @see java.lang.Object#toString()
     * @return the Request as String
     */
    public String toString() {
        StringBuffer sb = new StringBuffer(150);
        sb.append("requestId=");
        sb.append(requestId);
        sb.append(" status=");
        sb.append(status);
        sb.append(" errorMessage=");
        sb.append(errorMessage);
        sb.append(" userFirstName=");
        sb.append(userFirstName);
        sb.append(" userLastName=");
        sb.append(userLastName);
        sb.append(" emailAddress=");
        sb.append(emailAddress);
        sb.append(" filename=");
        sb.append(fileName);
        sb.append(" emailRetries=");
        sb.append(emailRetries);
        sb.append(" response=<response not printed>");
        return sb.toString();
    }

    /**
     * Cloase all streams
     */
    public void releaseResources() {
        try {
            scZippedXmlResponseUtil.close();
        }
        catch (Exception e) {
            scZippedXmlResponseUtil = null;
        }

        try {
            compressResponse.close();
        }
        catch (Exception e) {
            compressResponse = null;
        }

        try {
            scZippedCsvResponseUtil.close();
        }
        catch (Exception e) {
            scZippedCsvResponseUtil = null;
        }
    }
    
    /**
     * @see java.lang.Object#finalize()
     */
    protected void finalize() throws Throwable {
        releaseResources();
        super.finalize();
    }
}
