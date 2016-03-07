/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/serviceHandler/MarshalHelper.java 1.7 2004-09-28 13:54:39+02 stefsobe Exp $
 *
 * Copyright (c) 2002 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 * 
 * $Log: MarshalHelper.java,v $
 * Revision 1.7  2004-09-28 13:54:39+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * fix substring()
 *
 * Revision 1.6  2004-09-27 17:57:47+02  stefsobe
 * Author: stefsobe@sobesteffen.emea.hpqcorp.net ()
 * change access methods of ESLog; add ItoError class
 *
 * Revision 1.5  2004-05-08 04:40:56+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.4  2004-05-05 15:39:35+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.3  2004-01-29 18:05:12+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.2  2003-10-13 11:57:19+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * cut exception message for CastorException after 200 characters
 *
 * Revision 1.1  2003-08-20 15:39:20+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.util.xml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.exolab.castor.core.exceptions.CastorException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EIAMessage;
import com.hp.es.xml.util.CastorUtil;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * Provides methods to marshal and unmarshal Castor objects
 */
public class MarshalHelper {

    /**
     * Use Castor to convert the reply into a XML string
     * 
     */
    static public String marshal(Object reply, MetricsHandler handler) throws SifException {
        
        if (reply == null) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,
                "Cannot marshal a null-object");
        }
        
        if (handler==null) {
            handler = new MetricsHandler();
        }

        final String messageType = reply.getClass().getName();

        String output = null;
        StringWriter writer = new StringWriter();
        MetricsEntry entry = null;
        if(handler != null)
        	entry = handler.addEntry("MarshalHelper.marshal()");

        try {
        	if(entry != null)
        		entry.actionStart();

            Marshaller ma = CastorUtil.getMarshaller(writer);
            ma.marshal(reply);
            output = writer.toString();
                        
            // the following is to make the compiler think this block could throw
            // this excpetion actually it is coming from unmarshalling code
            if (1 == 0) {
                throw new org.xml.sax.SAXException("DUMMY");
            }
        }
        catch (CastorException ce) {
            ESLog.error("CastorException while marshalling " + messageType, ce);
            throw ErrorFactory.getSifException(
                    ErrorFactory.id9999_INTERNAL_ERROR, "CastorException: "
                            + ce.getMessage());
        }
        catch (org.xml.sax.SAXException se) {
            ESLog.error("SAXException while marshalling " + messageType, se);
            throw ErrorFactory.getSifException(
                    ErrorFactory.id9999_INTERNAL_ERROR, "SAXException: "
                            + se.getMessage());
        }
        catch (IOException e) {
            ESLog.error("IOException while marshalling " + messageType, e);
            throw ErrorFactory.getSifException(
                    ErrorFactory.id9999_INTERNAL_ERROR, e.toString());
        }
        finally {
            try {
                writer.close();
            }
            catch (Exception e) {
            }
            if(entry != null)
            	entry.actionDone();
        }

        return output;
    }

    /**
     * Use Castor to convert the XML to an object.
     * @param bodyXml
     * @param handler
     * @param type The target class for the bodyXml.
     */
    static public Object unmarshal(String bodyXml, MetricsHandler handler, Class type)
            throws SifException {

        if (bodyXml == null) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,
                "Cannot unmarshal a null xml string");
        }

        if (type == null) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,
                "Cannot unmarshal when type (class) was not specified");
        }

        MetricsEntry entry = null;
        if (handler!=null) {
        	entry = handler.addEntry("MarshalHelper.unmarshal()");
        }

        
        StringReader reader = null;
        Object request = null;

        try {
        	if (entry!=null) {
        		entry.actionStart();
        	}

            reader = new StringReader(bodyXml);

            Unmarshaller uma = CastorUtil.getPermissiveUnmarshaller(type);
            request = uma.unmarshal(reader);

            // the following is to make the compiler think this block could throw
            // this excpetion actually it is coming from unmarshalling code
            if (1 == 0) {
                throw new org.xml.sax.SAXException("DUMMY");
            }
        }
        catch (Exception e) {
            ESLog.info("Exception while unmarshalling a request", e);

            // The getMessage() of the CastorException returns the full stack trace.
            // Until this will be fixed in Castor, we decided to simply cut the message
            // after 200 characters... 
            String msg = e.getClass().getName() + ": " + e.getMessage();
            if (msg.length()>200) {
                msg = msg.substring(0, 200) + " ...";
            }

            throw ErrorFactory.getSifException(
                ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "(could not determine which)",
                msg);
        }
        finally {
            try { reader.close(); } catch (Exception e) {ESLog.error("error when closing streams",e);}
            if (entry!=null)
            	entry.actionDone();
        }

        return request;
    }
    
    /**
     * Use Castor to convert the XML to an object.
     * @param handler
     * @param bodyXml
     */
    static public EIAMessage unmarshalUsingEIAMappingFile(String xml, MetricsHandler handler)
            throws SifException {

        if (xml == null) {
            throw ErrorFactory.getSifException(
                ErrorFactory.id9999_INTERNAL_ERROR,
                "Cannot unmarshal a null xml string");
        }

        //Class  type = EIAMessage.class;
        MetricsEntry entry = null;
        if (handler!=null) {
        	entry = handler.addEntry("MarshalHelper.unmarshal()");
        }

        
        StringReader reader = null;
        EIAMessage request = null;
        
        try {
        	if (entry!=null)
            entry.actionStart();

            reader = new StringReader(xml);

            Unmarshaller uma = CastorUtil.getUnmarshallerUsingEIAMessageMappingFile();
            request = (EIAMessage) uma.unmarshal(reader);

            // the following is to make the compiler think this block could throw
            // this excpetion actually it is coming from unmarshalling code
            if (1 == 0) {
                throw new org.xml.sax.SAXException("DUMMY");
            }
        }
        catch (Exception e) {
            ESLog.debug("Exception while unmarshalling a request", e);
            ESLog.info("Exception while unmarshalling a request");
            ESLog.info("request String=" + xml);

            // The getMessage() of the CastorException returns the full stack trace.
            // Until this will be fixed in Castor, we decided to simply cut the message
            // after 200 characters... 
            String msg = e.getClass().getName() + ": " + e.getMessage();
            if (msg.length()>200) {
                msg = msg.substring(0, 200) + " ...";
            }

            throw ErrorFactory.getSifException(
                ErrorFactory.id201_PARAMETER_HAS_INVALID_DATA,
                "(could not determine which)",
                msg);
        }
        finally {
            try { reader.close(); } catch (Exception e) {}
            if (entry!=null)
            entry.actionDone();
        }

        return request;
    }

}
