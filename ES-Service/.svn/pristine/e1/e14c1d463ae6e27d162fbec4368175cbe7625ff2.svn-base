/*
 * Title:        HPSE 2.0 - Entitlement Service
 * Description:  EIA SERVICE handler Service tester proxy.
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
 * $Log: ServiceHandlerServiceTesterProxy.java,v $
 * Revision 1.20  2004-05-08 04:41:16+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.19  2004-05-05 15:39:57+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.18  2004-02-03 16:17:24+01  stefsobe
 * Author: stefsobe@sobesteffen ()
 * remove ACME
 *
 * Revision 1.17  2004-01-29 18:05:35+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.16  2003-08-22 10:49:18+02  stefsobe
 * Author: stefsobe@dhcp-15-197-237-187.bbn.hp.com ()
 * re-add ACME service handler
 *
 * Revision 1.15  2003-08-04 16:50:06+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.14  2003-05-12 01:58:30+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.13  2003-04-30 10:39:31+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * - obsolete WarrantyDetailsKNIGHT, WarrantyDetailsKNIGHTImpl,
 *   EsLocalState, HPSEServiceHandler, WarrantyService, 
 *   WarrantyServiceImpl, whole state package
 * - applied KNIGHT WSDL change (for red warranty)
 *
 * Revision 1.12  2003-04-22 13:52:29+02  lbednari
 * Author: lbednari@dhcp-15-198-3-111.bbn.hp.com ()
 * - added support for ES service
 *
 * Revision 1.11  2003-04-08 15:34:54+02  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * no ACME in ES 4.0/5.0
 *
 * Revision 1.10  2003-03-19 19:31:49+01  THPO
 * Author: THPO@dhcp-15-198-7-216.bbn.hp.com ()
 * No support ignore lists, "default.ignore" or "testcase.ignore".

 * These lists carry regular expressions to ignore certain elements in the

 * XML path.
 *
 * Revision 1.9  2003-02-26 15:32:55+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.8  2003-01-22 15:27:09+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.7  2002-10-15 19:53:08+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * refactored up the compareTwoMessage() and related methods
 * (they were all dup'd across subclasses)
 *
 * Revision 1.6  2002-07-04 18:05:28+02  lbednari
 * Author: lbednari@dhcp-15-198-4-186.bbn.hp.com ()
 * - added ACME related testing possibility
 *
 * Revision 1.5  2002-07-03 13:51:04+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.4  2002-06-14 20:27:33+02  frey
 * Author: frey@dhcp-15-130-70-66.france.hp.com ()
 * split a 'return <method call>' so I can step into <method> with debugger.
 *
 * Revision 1.3  2002-05-22 08:50:17+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_0
 *
 * Revision 1.2  2002-04-11 11:13:48+02  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Checkout before building for an old symbol
 *
 * Revision 1.1  2002-04-10 16:51:51+02  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Service handler tester proxy

 *
 * Revision 1.4  2002-03-27 15:49:01+01  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Lastest version of this file. This file is only used for basf testing.
 * Support EIA
 *
 *
 */
package com.hp.es.test.hpsetest.proxy;

import com.hp.es.service.wsInterface.EsHttpListener;
import com.hp.es.test.hpsetest.TestConfigHolder;
import com.hp.es.xml.service.EIAMessage;
import com.hp.sif.http.SifHttpErrorException;

/**
 * 
 */
public class  ServiceHandlerServiceTesterProxy extends ServiceTesterProxy{
    private EsHttpListener _es = null;

    /*
    * Constructor (never used directly)
    * @param ignoreList a list of Jakarta ORO regular expressions to ignore certain tree parts, i.e. \"/EsReply/EsHeader/TransactionID\" or \"/EsReply/EsHeader/InputRequest.*\"
    */
    ServiceHandlerServiceTesterProxy()  {
    }

    /*
    * Send request method
    * @param the request in well formatted XML
    * @return the reply
    * @exception java.lang.Exception if something went wrong
    */
    public String sendRequest(String requestXml) throws Exception {
        String  replyXml;
        EIAMessage request = null;
        EIAMessage reply = null;


        try {

            

        	replyXml =  _es.processRequest(requestXml);
            
            

        } catch (SifHttpErrorException e) {
        	replyXml = e.getMessage();        	
        }
                
        return replyXml;
    }

    
    
    /*
    * get the name of the proxy
    * @return the name of the proxy
    */
    public String getName() {
        return TestConfigHolder.getInstance().getConfigParameter("hpse.test.proxyname").trim() + "ServiceTesterProxy";
    }


    /*
    * Init method
    * Place any code for proxy initialization here
    */
    public void init() {
        //Lets load the HPSEDocHandler
        try {


            String esServiceHandlerName = "com.hp.es.service.wsInterface.EsHttpListener";
            Class compClass = Class.forName(esServiceHandlerName);

            _es = (EsHttpListener) compClass.newInstance();

            _es.init();
        }catch(Throwable e) {
            e.printStackTrace();
            // NOT NEEDED FOR 3+
            //_hpseSh = null;
            _es = null;
        }
     }

    /*
    * get the the address of the tested server
    * @return the address of the tested server
    */
    public String getServerAddress() {
        return "Direct class access";
    }
    
    
    
}

//eof