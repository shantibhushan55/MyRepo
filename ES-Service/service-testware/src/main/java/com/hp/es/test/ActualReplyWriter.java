/*
 * Project: Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/test/ActualReplyWriter.java 1.9 2004-05-08 04:41:01+02 entitlem Exp $
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
 * $Log: ActualReplyWriter.java,v $
 * Revision 1.9  2004-05-08 04:41:01+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.8  2004-05-05 15:39:40+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.7  2004-01-29 18:05:17+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.6  2003-08-04 16:49:49+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.5  2003-05-12 01:58:10+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.4  2003-02-26 15:32:42+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.3  2003-01-22 15:26:53+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.2  2002-10-15 10:15:38+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * print() => println()
 *
 * Revision 1.1  2002-10-14 19:44:53+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * tool to capture actual replies
 *
 *
 */
package com.hp.es.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.OutputStreamWriter;

import com.hp.es.test.hpsetest.TestConfigHolder;
import com.hp.es.test.hpsetest.XMLFileUtil;
import com.hp.es.test.hpsetest.proxy.ServiceTesterProxy;

/**
 * This class will simply generate the actual reply xml messages for all of the
 * request xml messages.
 * <p>It really has nothing to do with testing, but it is packaged here for
 * convenience (we don't have a client package, and we want to run this as
 * a real service client).
 */
public class ActualReplyWriter  {

    private static ServiceTesterProxy _stp = ServiceTesterProxy.getServiceTesterProxy();
    private String _xmlRequestFileName = "";

    static {
        System.out.println("Executing static block in ActualReplyWriter.");
        _stp.init();
    }

    public ActualReplyWriter(String fileName) {
        _xmlRequestFileName = fileName;
    }


    public void writeActualReplyMessage()  {

        String requestXmlString, replyXmlString;

        try {
            //Read the xml file
            requestXmlString = XMLFileUtil.readFile(TestConfigHolder.getInstance().getConfigParameter("hpse.test.requestdir"), _xmlRequestFileName);

            //Send request and receive result
            replyXmlString = _stp.sendRequest(requestXmlString);

            writeFile(replyXmlString);

        }catch(Exception t) {
            writeFile("Failed to get or write the actual reply, Throwable was; " + t);
        }
    }

    private void writeFile(String replyString) {
        try {
            String replyFullFileName = TestConfigHolder.getInstance().getConfigParameter("hpse.test.actualreplydir")
                    +System.getProperties().getProperty("file.separator")
                    +_xmlRequestFileName;
            System.out.println("Writing file: "+replyFullFileName);

            FileOutputStream fos = new FileOutputStream(replyFullFileName, true);
            OutputStreamWriter errorFileWriter = new OutputStreamWriter(fos, "UTF-8");
            errorFileWriter.write(replyString,0,replyString.length());
            errorFileWriter.flush();
            errorFileWriter.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        // first get a list of xml request file names
        String repSeparator = System.getProperties().getProperty("file.separator");
        File xmlRequestDir = new File(TestConfigHolder.getInstance().getConfigParameter("hpse.test.requestdir")+ repSeparator);
        String xmlRequestFileNames[] = xmlRequestDir.list(
                new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        if(name != null) {
                            if(name.endsWith(".xml")) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
            );

        // for each request file, get and write the actual reply
        for (int i = 0; i < xmlRequestFileNames.length; i++) {
            ActualReplyWriter arw = new ActualReplyWriter(xmlRequestFileNames[i]);
            arw.writeActualReplyMessage();
        }
    }
}

