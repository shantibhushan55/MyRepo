package com.hp.es.service.plumbing;


/**
 * Title:         Entitlement ODS Viewer
 * Description:   It's a collection of tools based on the Servlet and JSP Technologies for getting an quick overview of the ODS in an common Webbrowser.
 * Copyright:     Copyright (c) 2001, 2002
 * Company:       Hewlett-Packard
 * Creation date: Jan 9, 2003
 *
 * @author Thomas Pöschmann (thpo)
 * @version 1.0
 */
public class ApacheOroInstalled {


	public static boolean isCorrect() {
        boolean result = false;
        try {
            Class utilClass = Class.forName("org.apache.oro.text.regex.Util");
            Class patternClass = Class.forName("org.apache.oro.text.regex.Pattern");
            Class patternMatcherClass = Class.forName("org.apache.oro.text.regex.PatternMatcher");
            Class patternMatcherInputClass = Class.forName("org.apache.oro.text.regex.PatternMatcherInput");
            Class substClass = Class.forName("org.apache.oro.text.regex.Substitution");
            utilClass.getMethod("substitute", new Class[] {
                StringBuffer.class,
                patternMatcherClass,
                patternClass,
                substClass,
                patternMatcherInputClass,
                Integer.TYPE
            });
            result = true;
        } catch (Throwable t) {}
        return result;
    }
}
