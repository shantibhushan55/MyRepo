/*
 * Created on Jun 2, 2006
 */
package com.hp.es.service.util.xml;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.exception.MissingDataException;
import com.hp.sif.logging.constants.CommonLoggingConstants;

/**
 * @author juhank
 *
 * This class provides methods to parse a message for specific values.
 * Currently there are 2 methods implemented for getting the user name and password
 * from the message header
 */
public class MessageScan implements CommonLoggingConstants {

    private String _message;
    private PatternMatcher _matcher;
    private PatternCompiler _compiler;

    /**
     * @param message
     */
    public MessageScan(String message) {
        _message = message;
        _matcher = new Perl5Matcher();
        _compiler = new Perl5Compiler();
    }
	
    /**
     * It parses the XML message for the user name field and returns it
     * @return the user name
     * @throws org.apache.oro.text.regex.MalformedPatternException
     * @throws com.hp.es.backend.translator.exception.MissingDataException
     */
    public String getUserName() throws MalformedPatternException, MissingDataException {
        return parseMessage("<UserName>([^<]*)</UserName>");
    }
    
    /**
     *  It parses the XML message for the user password field and returns it
     *  @return the user password
     *  @throws org.apache.oro.text.regex.MalformedPatternException
     *  @throws com.hp.es.backend.translator.exception.MissingDataException
     */
    public String getPassword() throws MalformedPatternException, MissingDataException {
        return parseMessage("<UserPassword>([^<]*)</UserPassword>");
    }
    
    /**
     *  It parses the XML message for the IncludeAddresses field and returns it
     *  @return the IncludeAddresses field
     *  @throws org.apache.oro.text.regex.MalformedPatternException
     *  @throws com.hp.es.backend.translator.exception.MissingDataException
     */
    public String getIncludeAddresses() throws MalformedPatternException, MissingDataException {
        return parseMessage("<IncludeAddresses>([^<]*)</IncludeAddresses>");
    }
	
    /**
     *  It parses the XML message for the IncludeContacts field and returns it
     *  @return the getIncludeContacts field
     *  @throws org.apache.oro.text.regex.MalformedPatternException
     *  @throws com.hp.es.backend.translator.exception.MissingDataException
     */
    public String getIncludeContacts() throws MalformedPatternException, MissingDataException {
        return parseMessage("<IncludeContacts>([^<]*)</IncludeContacts>");
    }

    /**
     *  It parses the XML message for the operation field and returns it
     *  @return the operation field
     *  @throws org.apache.oro.text.regex.MalformedPatternException
     *  @throws com.hp.es.backend.translator.exception.MissingDataException
     */
    public String getOperation() throws MalformedPatternException, MissingDataException {
        return parseMessage("<Operation>([^<]*)</Operation>");
    }

    /**
     *  It parses the XML message for the ClientAppID field and returns it
     *  @return the ClientAppID field
     *  @throws org.apache.oro.text.regex.MalformedPatternException
     *  @throws com.hp.es.backend.translator.exception.MissingDataException
     */
    public String getClientAppId() throws MalformedPatternException, MissingDataException {
        return parseMessage("<ClientAppID>([^<]*)</ClientAppID>");
    }

    /**
     * It does the actual parsing of the message with the received expression
     * @param expression
     * @return java.lang.String
     * @throws org.apache.oro.text.regex.MalformedPatternException
     */
    private String parseMessage(String expression) throws MalformedPatternException, MissingDataException {
        Pattern pattern = null;
        PatternMatcherInput input;
        MatchResult result;
        String data = "";
        ESLog.debug("Checking for '" + expression + "'");

        // check input
        if(_message == null) {
            ESLog.debug("Message is null -> returning null");
            return null;
        }

        try {
            // generate pattern
            pattern = _compiler.compile(expression);
        } catch(MalformedPatternException e) {
            // log the exception
        	ESLog.debug("MalformedPatternException: " + e.getMessage());
            // THROW EXCEPTION
            throw e;
        }
        // Perform parsing for the pattern
        input = new PatternMatcherInput(_message);
        if(_matcher.contains(input, pattern)) {
            // get the match result
            result = _matcher.getMatch();
            // get the first subgroup (all which is inside the parenthese '()')
            // see group help for detailed information
            data = result.group(1);
        } else {
                ESLog.debug("No data found for expression " + expression);
                ESLog.debug("complete message" + _message);
            MissingDataException mde = new MissingDataException("No data found for expression: " + expression);
            throw mde;
        }
        ESLog.debug("Found Data '" + data + "' for expression '" + expression + "'");
        return data;
    }	
}
