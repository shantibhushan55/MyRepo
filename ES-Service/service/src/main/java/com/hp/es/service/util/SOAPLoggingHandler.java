package com.hp.es.service.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;


public class SOAPLoggingHandler implements SOAPHandler<SOAPMessageContext> {
	

	public Set<QName> getHeaders() {
		return null;
	}

	public void close(MessageContext arg0) {
	}

	public boolean handleFault(SOAPMessageContext msg) {
		ESLog.debug("fault message is handled");
		logSOAPMessage(msg);
		return true;
	}

	public boolean handleMessage(SOAPMessageContext msg) {
		logSOAPMessage(msg);
		return true;
	}

	private void logSOAPMessage(SOAPMessageContext msg) {
		try {
			Boolean outboundProperty = (Boolean) msg
					.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

			if (outboundProperty.booleanValue()) {	
				
					SOAPMessage message = msg.getMessage();
					String logMessage = convertToString(message);
					// Outbound message
					ESLog.debug("put SOAP request to ThreadLocal: " + logMessage);
					ThreadLocalHolder.getRequests().set(logMessage);
			} else {		
				SOAPMessage message = msg.getMessage();
				String logMessage = convertToString(message);
				// Inbound message
				ESLog.debug("put SOAP response to ThreadLocal: " + logMessage);
				ThreadLocalHolder.getResponeses().set(logMessage);
			}
		} catch (Exception e) {
			// this Class is just an assistant class. no need to throw errors. even errors occurred,
			// system should continue to process request
			ESLog.error("error occured when log SOAPMessage", e);
		}
	}

	/**
	 * <p>
	 * Convert a SOAPMessage object to a string.
	 * </p>
	 * 
	 * @param obj
	 *            the SOAPMessage object who is ready to be converted
	 * @return The string who present the original inbound and outbound SOAP message
	 * @throws Exception
	 */
	private static String convertToString(SOAPMessage msg) throws IOException {
		String str = null;
		ByteArrayOutputStream baos = null;
		BufferedOutputStream bos = null;
		
		try {
			baos = new ByteArrayOutputStream();
			bos = new BufferedOutputStream(baos);
			msg.writeTo(bos);
			bos.flush();
			str = baos.toString();
		} catch (Exception e) {
			// this Class is just an assistant class. no need to throw errors. even errors occurred,
			// system should continue to process request
			ESLog.error("error occured when covert SOAPMessage to string", e);
		} finally {
			if(bos != null) {
				bos.close();
				bos = null;
			}
			if(baos != null) {
				baos.close();
				baos = null;
			}
		}
		return str;
	}

	
	/*private static List<String> getArrayByCount(String tempStr,int count){
    	List<String> list = new ArrayList<String>();
    	if(tempStr!=null&&tempStr.length()>0){
    		int yushu = tempStr.length()%count;
    		int size = tempStr.length()/count;
    		if(yushu>0){
    			size++;
    		}
    		for(int i=0;i<size;i++){
    			if(i==size-1){
    				if(yushu>0){
    					list.add(tempStr.substring(i*count, i*count+yushu));
    				}else{
    					list.add(tempStr.substring(i*count, (i+1)*count));
    				}
    			}else{
    				list.add(tempStr.substring(i*count, (i+1)*count));
    			}
    		}
    	}
    	return list; 	
    }*/

}
