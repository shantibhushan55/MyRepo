package com.hp.es.service.orchestration.sap;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.util.CastorUtil;
import com.hp.sif.SifException;

public abstract class SapSOAPAccess { 
	
	 
	
	protected String _url;
	protected String _user;
	protected String _password;

	protected long _connectionTimeout;
	
	protected boolean _available = true;
	protected long _unavailibilityDuration;
	protected long _endOfUnavailibility;
	
	
	protected SapSOAPAccess(String url, String user, String password, long connectionTimeout, long unavailibilityDuration) {
		super();
		ESLog.info("Creating SapSOAPAccess with url:"+url +",user:"+user+"password:"+password+",connectionTimeout"+connectionTimeout+",unavailibilityDuration"+unavailibilityDuration);
		_url= url;
		_user = user;
		_password = password;

		_connectionTimeout = connectionTimeout;
		_unavailibilityDuration = unavailibilityDuration;
		
	
	}
	
	public  static SapSOAPAccess   getInstance(String type,String soapAccessImpl,String url, String user, String password, long connectionTimeout, long unavailibilityDuration) {
        ESLog.debug("Using MetroSapSOAPAccess");
        if("SAP".equalsIgnoreCase(type))
        	return new MetroSapSOAPAccess(url, user, password, connectionTimeout, unavailibilityDuration);
        if("SNR".equalsIgnoreCase(type))
        	return new MetroSNRSOAPAccess(url, user, password, connectionTimeout, unavailibilityDuration);
        if("ASTRO2".equalsIgnoreCase(type))
        	return new MetroAstro2SOAPAccess(url, user, password, connectionTimeout, unavailibilityDuration);
        
        return null;
	}
	

	public abstract SapSOAPReply execute(String packageName, String sapFunctionName, Object request) throws SifException, SapAccessFailureException ;
	

	public synchronized boolean isAvailable() {
		ESLog.debug("SapSOAPAcess>>isAvailable>>_available=" + _available);
		ESLog.debug("SapSOAPAcess>>isAvailable>>_endOfUnavailibility=" + _endOfUnavailibility);
		if(!_available) {
			if(_endOfUnavailibility < System.currentTimeMillis()) {
				_available = true;
			}
		}
		ESLog.debug("SapSOAPAcess>>isAvailable>>_availableReturned=" + _available);
		return _available;
	}

	public synchronized  void setUnAvailable() {
		if(_available) {
			_endOfUnavailibility = System.currentTimeMillis() + _unavailibilityDuration;
			_available = false;
		}		
		
		
	}

	public String getMainState() {
	
		String state = "";
		state += "URL" + this._url;
		state += "User" + this._user;
		state += "Password" + this._password;
		
		return state;
	}
	
	
    /**
     * Tries to create a CASTOR object tree from the SOAP reply string. Will discard
     * SOAP header and trailer and only process the fragment starting/ending with
     * the main tag "ZWTYLOOKUP".
     * @param url     Only used for including used SOAP URL in error messages.
     * @param reply   The complete SOAP XML reply message.
     * @return A tree of CASTOR generated class instances representing the main
     *     part of the SOAP reply.
     * @throws SwopForbiddenResultException
     */
    protected Object unmarshallReply( String reply,String sapFunctionName) throws SifException {
    	
        Object result    = null;        
        String startTag  = getStartTag(sapFunctionName);
        String endTag    = getEndTag(sapFunctionName);
        Class className = getCastorClass(sapFunctionName);
        
        Unmarshaller umarsh = CastorUtil.getPermissiveUnmarshaller(className);
        int startIndex = reply.indexOf(startTag);
        if (startIndex == -1) {
            ESLog.debug("SOAP returned invalid XML , could not find start tag: " +
            		startTag + " . The SOAP reply is: " + reply);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Could not find start tag: " + startTag);
            
        }
        int endIndex = reply.indexOf(endTag);
        if (endIndex == -1) {
            ESLog.debug("SAP returned invalid XML , could not find end tag: " +
            		endTag + " . The SOAP reply is: " + reply);
            
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,"Could not find end tag: " + endTag);
        } else {
            // we have to include the ending tag to have a valid XML fragment
            endIndex += endTag.length();
        }

        String replyBody = reply.substring(startIndex, endIndex);
        try {
            result = umarsh.unmarshal(new StringReader(replyBody));
        } catch (MarshalException me) {
            String message = "XML parsing error: ";
            if (me.getCause() != null) {
            	message = message + me.getCause().getMessage();
            }
            if(ESLog.isDebugLogEnabled())	  ESLog.debug("SOAP returned invalid XML , XML parsing error. The SOAP reply is: " + reply);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,message);
        } catch (ValidationException ve) {
            String message = "XML validation error: ";
            if (ve.getCause() != null) {
                message = message + ve.getCause().getMessage();
            }
            if(ESLog.isDebugLogEnabled())	ESLog.debug("SOAP returned invalid XML , XML validation error. The SOAP reply is: " + reply);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR,message);
        }

        return result;

    }




	private Class getCastorClass(String sapFunctionName) {
		String className = null;
		Class classObj = null;
		
		if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_SWOP)) {
			className= EsConstants.SWOP_SOAP_CLASSNAME;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_IBSEARCH)) {
			className= EsConstants.IBSEARCH_SOAP_CLASSNAME;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT)) {
			className= EsConstants.CQS_SOAP_CLASSNAME;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT_BYSN)) {
			className= EsConstants.CQSBYSN_SOAP_CLASSNAME;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_SUM)) {
			className=EsConstants.CQSCS_SOAP_CLASSNAME;
		} else if (sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_ROUTINGDETAILS)) {
            className = EsConstants.CQS_ROUTINGDETAILS_SOAP_CLASSNAME;
        } else if (sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_ASTRO2)) {
            className = EsConstants.ASTRO2_SOAP_CLASSNAME;
        }
		
		if(className != null) {
			try {
				classObj = Class.forName(className);
			} catch (ClassNotFoundException e) {
				ESLog.error("Cannot load class for "+className,e);
			}
		}
		
		return classObj;
	}




	/*
	 * Returns the end tag based on the sap function name
	 * @param sapfunctionName
	 * @return start tag
	 */
	private String getEndTag(String sapFunctionName) {
		if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_SWOP)) {
			return EsConstants.SWOP_SOAP_END_TAG;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_IBSEARCH)) {
			return EsConstants.IBSEARCH_SOAP_END_TAG;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT)) {
			return EsConstants.CQS_SOAP_END_TAG;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT_BYSN)) {
			return EsConstants.CQSBYSN_SOAP_END_TAG;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_SUM)) {
			return EsConstants.CQSCS_SOAP_END_TAG;
		} else if (sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_ROUTINGDETAILS)) {
            return EsConstants.CQS_ROUTINGDETAILS_SOAP_END_TAG;
        }else if (sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_ASTRO2)) {
            return EsConstants.ASTRO2_SOAP_END_TAG;
        }
		return null;		
	}	



	/*
	 * Returns the start tag based on the sap function name
	 * @param sapfunctionName
	 * @return start tag
	 */
	private String getStartTag(String sapFunctionName) {
		if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_SWOP)) {
			return EsConstants.SWOP_SOAP_START_TAG;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_IBSEARCH)) {
			return EsConstants.IBSEARCH_SOAP_START_TAG;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT)) {
			return EsConstants.CQS_SOAP_START_TAG;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_ENT_BYSN)) {
			return EsConstants.CQSBYSN_SOAP_START_TAG;
		}else if(sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_CONTRACT_SUM)) {
			return EsConstants.CQSCS_SOAP_START_TAG;
		}else if (sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_CQS_ROUTINGDETAILS)) {
            return EsConstants.CQS_ROUTINGDETAILS_SOAP_START_TAG;
        }else if (sapFunctionName.equalsIgnoreCase(EsConstants.SAP_FUNCTION_NAME_ASTRO2)) {
            return EsConstants.ASTRO2_SOAP_START_TAG;
        }
		return null;
	}	

	
	
	/*
	 * Create the XML request 
	 */
	protected String createXMLRequest(Object request) throws IOException, MarshalException, ValidationException {
    	ESLog.debug("Preparing request");
        StringWriter sw = new StringWriter();
        sw.write(EsConstants.SOAP_HEADER);
        
        // build input CASTOR object tree and create XML from it
        Marshaller marsh = CastorUtil.getMarshaller(sw);

        marsh.marshal(request);
        sw.write(EsConstants.SOAP_FOOTER);

        // now we have the complete content for the SOAP body
        String requestBody = sw.toString();
        
        // OLCAYYE, 16/05/2007
        // For the new operation Z_GET_CONTRACT_SUMMARY CHANGING parameters has been defined on CQS.
        // It is therefore needed to send placeholders for this parameters in the request (even at SOAP WebServic call !!!).
        // These can be comparable with null pointer references on C to pass to remote procedure calls.
        // This is a ABAP issue.
        if(requestBody.indexOf("ZES_CONTRACT_SUM_ES10") > 0){
            int intNr = requestBody.indexOf("</ES_REQUEST>");
            String subStrBegin = requestBody.substring(1,intNr+13);
            String subStrEnd = requestBody.substring(intNr+13);

            String subPlaceHolder = "<CONTACTS></CONTACTS>" +
									"<DELIVERABLES></DELIVERABLES>" +
            						"<LOCATIONS></LOCATIONS>" +
            						"<MESSAGES></MESSAGES>" +
            						"<OBLIGATION_HEADERS></OBLIGATION_HEADERS>" +
            						"<PRODUCTS></PRODUCTS>" +
            						"<RUNTIME></RUNTIME>" +
            						"<SERVICES></SERVICES>";
            
            requestBody = subStrBegin + subPlaceHolder + subStrEnd;
        	
        }
        sw.close();
        return requestBody;
		
	}

	/*
	 * Create the authentification string
	 */
	protected String createAuthString() {
        String auth = _user + ":" + _password;
        sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
        return enc.encode(auth.getBytes());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SapSOAPAccess [_url=" + _url + ", _user=" + _user
				+ ", _password=" + _password + ", _connectionTimeout="
				+ _connectionTimeout + ", _available=" + _available
				+ ", _unavailibilityDuration=" + _unavailibilityDuration
				+ ", _endOfUnavailibility=" + _endOfUnavailibility + "]";
	}


}
