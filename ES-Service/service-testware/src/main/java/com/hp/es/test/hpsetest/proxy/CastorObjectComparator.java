/*
 * Title:        HPSE 1.0 - Entitlement Service
 * Description:  HPSE Reply comparator Comparator
 *
 * Copyright (c) 2001 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * @author Antoine Voiry
 *
 * $Log: CastorObjectComparator.java,v $
 * Revision 1.8  2004-07-26 14:17:17+02  lbednari
 * Author: lbednari@bbnnaid606.bbn.hp.com ()
 * REMOVED SOME LEFT-IN DEBUGGING CODE
 *
 * Revision 1.7  2004-07-23 19:22:26+02  lbednari
 * Author: lbednari@schmucknicola.emea.cpqcorp.net ()
 * Fix for comparing enumerations of simple fields - e.g. repeatable SerialNumber field in OOS
 *
 * Revision 1.6  2004-05-08 04:41:17+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.5  2004-05-05 15:39:57+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.4  2004-01-29 18:05:35+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.3  2003-09-04 10:00:44+02  THPO
 * Author: THPO@dhcp-15-197-229-195.bbn.hp.com ()
 * adding stack info to "possible errors" section
 *
 * Revision 1.2  2003-09-02 14:46:15+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * use only public and non-static methods (get and enumerate) for comparison
 *
 * Revision 1.1  2003-09-02 11:08:31+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * derived from EsReplyComparator and AcmeReplyComparator
 *
 */
package com.hp.es.test.hpsetest.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

/**
 * This class compares two objects including the contained objects. It
 * is used to compare Castor object trees. For each object it calls
 * the getXXX() and enumerateXXX() methods (only methods without parameter)
 * and compares the returned objects using the same method.
 */
public class CastorObjectComparator extends Comparator {

    /**
     * The Constructor takes a list of elements pathes that should not be
     * compared. Note: The name of the root element can be specified in the
     * compare() method. All other elements are derived from the method name
     * (the "get" prefix is ignored), e.g. in order to surpress the comparison
     * for the element object.getExample().enumerateABC() the ignoreList could
     * contain /RootTag/Example/enumerateABC where RootTag must be set in the
     * compare() method.
     * @param ignoreList a list of Jakarta ORO regular expressions to ignore
     *        certain tree parts, i.e. "/EsReply/EsHeader/TransactionID" or
     *        ".*InputRequest.*". If an expression in the ignoreList has not
     *        a valid syntax, these expression is not used.
     */
    public CastorObjectComparator(String [] ignoreList) {

        if ( ignoreList != null ) {
            ArrayList patterns = new ArrayList();
            PatternCompiler compiler = new Perl5Compiler();
            for (int i=0; i<ignoreList.length; i++) {
                try {
                    patterns.add(compiler.compile(ignoreList[i]));
                } catch (Exception ex) {
                    // return "false" and print exception
                    // todo: well, "false" is not yet really correct
                    ex.printStackTrace();
                }
            }

            ignorePatterns = (Pattern[])patterns.toArray(new Pattern[0]);
        }
    }

    /**
     * Compare two objects using the getXXX() and enumerateXXX() methods
     * @param o1 the first object to be compared
     * @param o2 the second object to be compared
     * @param nameOfRootElement the actual name of the root element (e.g. EsReply)
     * @return true is the two objects are the same (in term of content), i.e. if the
     *         getXXX() an enumerateXXX() methods return the same content
     */
    public boolean compare(Object o1, Object o2, String nameOfRootElement)
        throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        // nice little assumption about the stack, well...
        return compareTwoTreeOfObject(o1, o2, new String[] {
                (nameOfRootElement == null ? "root" : nameOfRootElement)} );
    }

    /**
     * If the compare method returns false, the getDifferences() can be used to get a
     * full description about the differences.
     * @return
     */
    public String getDifferences() {
        return strDump.toString() + "\r\n" + stackDump.toString();
    }

    /**
     * Compare two tree of object
     * @param actual reply
     * @param expected reply
     * @return true is the two replies are the same (in term of content)
     * @exception  java.lang.Exception (if any error happen
     */
    private boolean compareTwoTreeOfObject(Object a, Object b, String [] stack)
        throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Method[] m = null;
        Object[] args = new Object[0];

        if((a == null) && (b == null)) {
            return true;
        }

        if((a == null) || (b == null)) {
            if(a == null) {
                strDump.append(TAB + b.getClass().getName() + EOL);
                stackDump.append("\r\nStack: "+ stackStringRepresentation(stack));
            }
            if(b == null) {
                strDump.append(TAB + a.getClass().getName() + EOL);
                stackDump.append("\r\nStack: "+ stackStringRepresentation(stack));
            }
            return false;
        }

        //System.out.println("\tclass = " + a.getClass().getName());
        m = a.getClass().getMethods();
        for (int i = 0; i < m.length; i++) {

            Method meth = m[i];

            // ignore static and non-public methods
            if (Modifier.isPublic(meth.getModifiers())
                && (!Modifier.isStatic(meth.getModifiers()))) {

                if ((meth.getName().startsWith("get"))
                    && (!meth.getName().equals("getClass"))) {

                    //System.out.println("\t\tmethod = " + meth.getName());

                    String [] localStack = buildLocalStack(stack, meth);
                    if (elementToBeChecked(localStack)) {

                        Class[] params = meth.getParameterTypes();
                        if(params.length == 0) {

                            Class c = meth.getReturnType();
                            if(c.isPrimitive()) {
                                /*
                                 * We need first to look if this is an optionnal parameter that is set.
                                 * For that we need to search ifg there is any method that is having the same end as the getter
                                 * Exampe getActiveWarrantyOnly hasActiveWarrantyOnly
                                 * We first call the method that search for it then we will call the standard method
                                 * It is coded as follow
                                 * If has exist
                                 *         If both has result are different return false
                                 *         else perform comparison in a standard way
                                 *
                                 */
                                Method methodHas = searchForBooleanHasMethod(m,meth.getName());
                                if (methodHas != null) {
                                    Object resultA = methodHas.invoke(a, args);
                                    Object resultB = methodHas.invoke(b, args);

                                    //This should never happen but it is always better to check for null
                                    if ( (resultA == null) || (resultB == null) ) {
                                        if ( (resultA != null) || (resultB != null) ) {
                                            strDump.append(TAB + meth.getName() +" "+resultA+"<>"+resultB + EOL);
                                            stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
                                            return false;
                                        }
                                    }else if(!resultA.equals(resultB)) {//If both hasMethod results are different
                                            strDump.append(TAB + meth.getName() +" "+resultA+"<>"+resultB + EOL);
                                            stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
                                            return false;
                                    }
                                }
                                Object resultA = meth.invoke(a, args);
                                Object resultB = meth.invoke(b, args);

                                if ( (resultA == null) || (resultB == null) ) {
                                    if ( (resultA != null) || (resultB != null) ) {
                                        strDump.append(TAB + meth.getName() +" "+resultA+"<>"+resultB + EOL);
                                        stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
                                        return false;
                                    }
                                }
                                else if(!resultA.equals(resultB)) {
                                    strDump.append(TAB + meth.getName() +" "+resultA+"<>"+resultB + EOL);
                                    stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
                                    return false;
                                }
                            }
                            else if(c.isArray()) {
                                    //Do Nothing because we compare the enumerations
                            }
                            else {
                                Object resultA = meth.invoke(a, args);
                                Object resultB = meth.invoke(b, args);

                                if ( (resultA == null) || (resultB == null) ) {
                                    if ( (resultA != null) || (resultB != null) ) {
                                        strDump.append(TAB + meth.getName() +" "+resultA+"<>"+resultB + EOL);
                                        stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
                                        return false;
                                    }
                                }
                                else if (c.getName().startsWith("com.hp.es")) {
                                    //System.out.println("|"+p.getName()+"."+meth.getName()+"|");
                                    if(! compareTwoTreeOfObject(resultA, resultB, localStack)) {
                                        strDump.append(TAB + meth.getName() +" "+resultA+"<>"+resultB + EOL);
                                        stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
                                        return false;
                                    }
                                }
                                else {
                                    if( ! compareTwoObjects(resultA, resultB, stack)) {
                                        strDump.append(TAB + meth.getName() +" "+ resultA+"<>"+resultB + EOL);
                                        stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
                else if((meth.getName().startsWith("enumerate")))  {

                    //System.out.println("\t\tmethod = " + meth.getName());

                    String [] localStack = buildLocalStack(stack, meth);
                    if (elementToBeChecked(localStack)) {
                        Enumeration ea = (Enumeration) meth.invoke(a,args);
                        Enumeration eb = (Enumeration) meth.invoke(b,args);
                        if( ! compareTwoEnumeration(ea, eb, localStack)) {
                            strDump.append(TAB + meth.getName() + EOL);
                            stackDump.append("\r\nStack: " + stackStringRepresentation(localStack));
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    /**
     * Compare two object (two hpse replies)
     * @param Object a
     * @param Object a
     * @return true is the two Object  are the same (in term of content)
     */
    private boolean compareTwoObjects(Object a, Object b, String [] stack) {
        if( a instanceof String) {
            return compareTwoString((String)a,(String)b);
        }

        if ((a == null) && (b== null)) {
            return true;
        }

        if (a == null) {
            strDump.append(TAB + b.getClass().getName() + EOL);
            stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
            return false;
        }

        if (b == null) {
            strDump.append(TAB + a.getClass().getName() + EOL);
            stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
            return false;
        }

        if(! b.equals(a)) {
            strDump.append(TAB + a.getClass() +" "+a+"<>"+b.getClass()+" "+b + EOL);
            stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
            return false;
        }

        return true;
    }

    /**
     *
     * @param globalStack
     * @param m
     * @return
     */
    private static String [] buildLocalStack(String [] globalStack, Method m) {
        String currentElementName;
        if (m.getName().startsWith("get")){
            currentElementName = m.getName().substring(3, m.getName().length());
        } else {
            currentElementName = m.getName();
        }
        return appendToStack(globalStack, currentElementName);
    }

    /**
     * Check if the element is NOT contained in the ignore list
     * @param stack
     * @return
     */
    private boolean elementToBeChecked(String [] stack) {
        if ( (stack != null) && (ignorePatterns != null) ) {
            PatternMatcher matcher = new Perl5Matcher();
            String stackString = stackStringRepresentation(stack);
            for (int i=0; i< ignorePatterns.length; i++) {
                try {
                    Pattern pattern = ignorePatterns[i];
                    if (matcher.matches(stackString, pattern)) {
                        return false;
                    }
                } catch (Exception ex) {
                    // return "false" and print exception
                    // todo: well, "false" is not yet really correct
                    ex.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Compare two enumeration
     * @param Object a
     * @param Object a
     * @return true is the two Object  are the same (in term of content)
     * The order is now important
     */
    private boolean compareTwoEnumeration(Enumeration a,Enumeration b, String [] stack) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        if((a == null) && (b == null)) {
            return true;
        }

        if (a == null) {
            return false;
        }

        if (b == null) {
            return false;
        }

        ArrayList aa = new ArrayList();
        while(a.hasMoreElements()) {
            aa.add(a.nextElement());
        }

        ArrayList ab = new ArrayList();
        while(b.hasMoreElements()) {
            ab.add(b.nextElement());
        }

        if(aa.size() != ab.size()) {
            strDump.append(
                TAB
                    + "Two Enumerations does not have the same size "
                    + aa.size()
                    + "<>"
                    + ab.size()
                    + EOL);
            stackDump.append("\r\nStack: " + stackStringRepresentation(stack));
            return false;
        }

        Iterator ita = aa.iterator();
        Iterator itb = ab.iterator();

        while(ita.hasNext()) {
            Object tmp1 = ita.next();
            Object tmp2 = itb.next();
            if (tmp1.getClass().getName().startsWith("com.hp.es")) {
                if(! compareTwoTreeOfObject(tmp1, tmp2, stack)) {
                    return false;
                }
            } else {
                if( ! compareTwoObjects(tmp1, tmp2, stack)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Used to maintain a stack of strings
     * @param stack the stack to append the element to
     * @param newElement the new element to be appended
     * @return the new stack, build from the old plus the new element
     */
    private static String [] appendToStack(String [] stack, String newElement) {
        String [] result = null;
        if (stack == null) {
            result = new String[] {newElement};
        } else {
            result = new String[stack.length + 1];
            System.arraycopy(stack, 0, result, 0, stack.length);
            result[result.length - 1] = newElement;
        }
        // todo: remove in production ;)
        // to debug element names, uncomment this one
        if (DEBUG_IGNORE_PATH) System.out.println(stackStringRepresentation(result));
        return result;
    }

    /**
     * Generates a string with a series of elements, seperated by /: a/b/c
     * @param stack
     * @return
     */
    private static String stackStringRepresentation(String [] stack) {
        if (stack != null) {
            StringBuffer result = new StringBuffer();
            for (int i=0; i<stack.length; i++) {
                result.append("/" + stack[i]);
            }
            return result.toString();
        }
        return null;
    }



    /**
     * Search for a method name hasXXX when knowing a method getXXX, this method should return a boolean
     * @param Method[]
     *
     * @return
     */
    private Method searchForBooleanHasMethod(Method[] m, String strMethodName) {
        String attributeName;
        attributeName=strMethodName.substring(3);
        for(int i=0;i<m.length;i++) {
            Method m1 =m[i];
            if(m1.getName().startsWith("has")){
                if( attributeName.compareTo(m1.getName().substring(3))== 0) {
                    //Check also if this method return a boolean
                    if (m1.getReturnType().getName().equalsIgnoreCase("boolean"))
                        return m1;
                }

            }
        }
        return null;
    }



    private StringBuffer strDump = new StringBuffer("");;
    private StringBuffer stackDump = new StringBuffer("");
    private Pattern[] ignorePatterns = null;

    private static final boolean DEBUG_IGNORE_PATH = System.getProperty("com.hp.es.test.ignore.debug", "false").trim().equalsIgnoreCase("true");
    private static final String EOL = System.getProperty("line.separator");
    private static final String TAB = "\t";
}
//eof
