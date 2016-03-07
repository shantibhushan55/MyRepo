package com.hp.es.test.hpsetest.proxy;
import com.hp.es.service.util.xml.MarshalHelper;
import com.hp.es.test.hpsetest.TestConfigHolder;
import com.hp.es.xml.service.EIAMessage;
import com.hp.sif.SifException;

/*
 * Title:        HPSE 1.0 - Entitlement Service
 * Description:  Service tester abstract proxy
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
 * $Log: ServiceTesterProxy.java,v $
 * Revision 1.29  2004-05-08 04:41:14+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.28  2004-05-05 15:39:55+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.27  2004-01-29 18:05:32+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.26  2003-08-04 16:50:04+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.25  2003-05-12 01:58:25+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.24  2003-04-04 12:29:30+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * make sure "actual" is always created
 *
 * Revision 1.23  2003-03-19 19:31:50+01  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * No support ignore lists, "default.ignore" or "testcase.ignore".
 * These lists carry regular expressions to ignore certain elements in the
 * XML path.
 *
 * Revision 1.22  2003-02-26 15:32:52+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.21  2003-01-22 15:27:06+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.20  2002-10-15 19:53:09+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * refactored up the compareTwoMessage() and related methods
 * (they were all dup'd across subclasses)
 *
 * Revision 1.19  2002-07-03 13:50:59+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.18  2002-05-22 08:50:13+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_0
 *
 * Revision 1.17  2002-03-29 09:58:17+01  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Change:
 *  - added javadoc
 *  - reformat file
 *
 * Revision 1.16  2002-03-14 15:33:47+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * dummy checkout for branch 1_0 creation
 *
 * Revision 1.15  2002-03-12 09:22:03+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * New version of test ware
 * Support EIA
 * Support modular build
 *
 *
 */

public abstract class ServiceTesterProxy {

    /* The service tester proxy isntance */
    private static volatile ServiceTesterProxy _stp = null;

    /*
    * Constructor (never used directly)
    */
    ServiceTesterProxy() {

    }

    /*
    * Send request method (abstract)
    * @param the request in well formatted XML
    * @return the reply
    * @exception java.lang.Exception if something went wrong
    */
    public abstract String sendRequest(String requestXml) throws Exception;

    /*
    * get the name of the proxy
    * @return the name of the proxy
    */
    public abstract String getName();

    /*
    * get the the address of the tested server
    * @return the address of the tested server
    */
    public abstract String getServerAddress();

    /*
    * Init method
    * Place any code for proxy initialization here
    */
    public abstract void init();

    /*
    * Compare two xml string using the marshalling framework
    * @param received xml string
    * @param expected xml string
    * @return true if the two xml string have the same contents
    * @exception java.lang.exception if anything went wrong
    */
    public boolean compareTwoMessage(String strActual, String strExpected, String [] ignoreList) throws Exception {
        boolean result = false;
        EIAMessage    actual   = null;
        EIAMessage    expected = null;
        try {
            
            EIAComparator comp = new EIAComparator();
    
            
            actual   = unmarshalActual(strActual);
            expected   = unmarshalExpected(strExpected);
            	
            result = comp.compare(actual,expected, ignoreList);
        } catch (Exception ex) {
        	if(actual == null) {
        		System.out.println("Exception while loading actual result, " +ex.getMessage());
        	}else if (expected == null) {
        		System.out.println("Exception while loading expected result, " +ex.getMessage());
        	}else {
        		System.out.println("Exception while comparing results, " +ex.getMessage());
        	}
           // ex.printStackTrace(); 
        }
        return result;
    }


    private EIAMessage unmarshalExpected(String strExpected) throws SifException {
		return MarshalHelper.unmarshalUsingEIAMappingFile(strExpected,null);
	}

	private EIAMessage unmarshalActual(String strActual) throws SifException {
		return MarshalHelper.unmarshalUsingEIAMappingFile(strActual,null);
	}

	/*
    * Init method
    * Place any code for proxy initialization here
    */
    public final static ServiceTesterProxy getServiceTesterProxy() {
    	String proxyName = null;
    	String proxyClassName = null;
            synchronized(ServiceTesterProxy.class) {
                if(_stp == null) {
                    try {
                    	proxyName =  TestConfigHolder.getInstance().getConfigParameter("hpse.test.proxyname").trim();
                        proxyClassName = TestConfigHolder.getInstance().getConfigParameter("hpse.test.proxyname."+proxyName).trim();
                        
                        Class compClass = Class.forName(proxyClassName);
                        _stp = (ServiceTesterProxy) compClass.newInstance();
                    }catch(Exception e) {
                    	if(proxyName !=null) {
                    		System.out.println("Failed to find class name for proxy "+ proxyName +" refer to below stack trace. ");
                    		
                    	}else if (proxyClassName !=null) {
                    		System.out.println("Failed to load class "+ proxyClassName +" refer to below stack trace. ");
                    	}else {
                    		System.out.println("Unkwnown configuration issue, refer to below stack trace. ");
                    	}
                        e.printStackTrace();
                    }
                }
        }
        return _stp;
    }
    
    
    
    
}
//eof