package com.hp.es.service.orchestration.sap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;

import javax.net.SocketFactory;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.sif.SifException;

public class SocketSapSOAPAccess extends SapSOAPAccess {

    public SocketSapSOAPAccess(String url, String user, String password, long connectionTimeout, long unavailibilityDuration) {
        super(url, user, password, connectionTimeout, unavailibilityDuration);
    }

    /*
	 */
    public SapSOAPReply execute(String packageName, String sapFunctionName, Object request) throws SifException, SapAccessFailureException {
        SapSOAPReply result;
        BufferedReader in = null;
        BufferedWriter out = null;
        Socket socket = null;
        try {
            URL urlObj = new URL(_url);
            SocketFactory factory = null;
            int port = urlObj.getPort();

            if ("http".equals(urlObj.getProtocol().toLowerCase())) {
                ESLog.debug("Creating default SocketFactory");
                factory = SocketFactory.getDefault();
                ESLog.debug("Created default SocketFactory");
                if (port == -1)
                        port = 80;

            } else {
                factory = SSLSocketFactoryHolder.getSSLSocketFactory();
                if (port == -1)
                        port = 443;

            }

            // now we have the complete content for the SOAP body
            String requestBody = createXMLRequest(request);

            String authStr = createAuthString();

            ESLog.debug("Following request will be sent to SAP:" + requestBody);


            ESLog.debug("Try to connect to SAP instance.....");
            socket = factory.createSocket(urlObj.getHost(), port);
            socket.setSoTimeout((int) _connectionTimeout);

            String path = urlObj.getPath();
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), EsConstants.UTF8_ENCODING));
            out.write("POST " + path + " HTTP/1.0\r\n");
            out.write("Authorization: Basic " + authStr + "\r\n");
            out.write("Content-Length: " + String.valueOf(requestBody.length()) + "\r\n");
            out.write("Content-Type: text/xml; charset=UTF-8\r\n");
            out.write("\r\n");
            out.write(requestBody);
            out.flush();

            StringBuffer inputLine = new StringBuffer();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            String buffer;
            while ((buffer = in.readLine()) != null) {
                inputLine.append(buffer);
            }

            ESLog.debug("Finish of connecting to soap instance.....");

            String httpReply = inputLine.toString();
            if (isValidHttpReply(httpReply)) {
                Object tmp = unmarshallReply(httpReply, sapFunctionName);
                result = new SapSOAPReply(tmp);
            } else {
                ESLog.error("HTTP Reply status code is NOT OK. An IOException will be thrown. The detailed http return is " + httpReply);
                throw new SapAccessFailureException("Bad HTTP status code is retunred while access SAP. The HTTP return code is '"
                        + getHttpReturnCode(httpReply) + "'");
            }

        } catch (IOException e) {
            ESLog.error("Encounting IOException when accessing SAP with SOAP.", e);
            throw new SapAccessFailureException("Encounting IOException when accessing SAP with SOAP.", e);
        } catch (SifException e) {
            // let these simply go through
            throw e;
        } catch (Exception e) {
            ESLog.error("Exception during communication with SOAP", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "Exception during communication with SOAP");
        } finally {
            try {
                in.close();
            } catch (Exception ex) {
            }
            try {
                out.close();
            } catch (Exception e) {
            }
            try {
                socket.close();
            } catch (Exception e) {
            }
        }

        return result;

    }

    /**
     * Extract HTTP Return Code
     * 
     * @param httpReply
     * @return
     */
    private String getHttpReturnCode(String httpReply) {
        if (httpReply != null)
            return httpReply.substring(0, 12);
        return null;
    }

    /**
     * Check whether the reply from source system is OK.
     * 
     * @param httpReply
     * @return
     */
    private boolean isValidHttpReply(String httpReply) {
        if (httpReply.startsWith(EsConstants.HTTP_OK))
            return true;

        return false;
    }
}
