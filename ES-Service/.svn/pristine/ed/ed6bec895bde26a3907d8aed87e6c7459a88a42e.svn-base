package com.hp.es.test.hpsetest.proxy;
/*
 * Title:        HPSE 1.0 - Entitlement Service
 * Description:  Comparator some useful method used in a comparison
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
 * $Log: Comparator.java,v $
 * Revision 1.12  2004-05-08 04:41:15+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.11  2004-05-05 15:39:55+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.10  2004-01-29 18:05:33+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.9  2003-08-04 16:50:04+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.8  2003-05-12 01:58:26+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.7  2003-02-26 15:32:53+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.6  2003-01-22 15:27:07+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.5  2002-07-03 13:51:01+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_1
 *
 * Revision 1.4  2002-05-22 08:50:14+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point2_0
 *
 * Revision 1.3  2002-03-29 09:58:14+01  ANVOI
 * Author: ANVOI@dhcp-15-130-68-69.france.hp.com ()
 * Change:
 *  - added javadoc
 *  - reformat file
 *
 * Revision 1.2  2002-03-14 15:33:49+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * dummy checkout for branch 1_0 creation
 *
 * Revision 1.1  2002-03-12 09:22:48+01  anvoi
 * Author: anvoi@dhcp-15-130-68-154.france.hp.com ()
 * New version of test ware
 * Support EIA
 *
 *
 */
abstract class Comparator {
    
    /*
    * Compare two String
    * @param String a
    * @param String b
    * @return true is the two string are the same
    * @exception  java.lang.Exception (if any error happen
    *
    */    
    protected boolean compareTwoString(String a,String b) {
        if ((a == null) && (b== null)) {
            return true;
        }
        if (a == null) {
            return false;
        }
        
        if (b == null) {
            return false;
        }        
        
        if(! b.trim().equalsIgnoreCase(a.trim())) {
            return false;
        }
        return true;
    }
    
    /*
    * Normalize the content of a string
    * @param String text
    * @return the string normalized
    *
    */      
    protected String normalize(String text)    {
        String newText = new String(text);
        newText = searchAndReplace( "&", "&amp;",newText);
        newText = searchAndReplace( "\"", "&quot;", newText);
        //newText = searchAndReplace( "\r","&#10;", newText);
        //newText = searchAndReplace("\n","&#13;", newText);
        return newText.trim();
    }

    /*
    * replace a text in a String
    * @param the target to replace
    * @param the replacement string
    * @param the text
    * @return the string with the replaced target
    *
    */  
    private String searchAndReplace(String target, String replacement, String text)    {
        String newText = new String(text);
        String leader = "";
        String trailer = "";
        for(int localOffset = newText.indexOf(target); localOffset != -1; localOffset = newText.indexOf(target, localOffset + replacement.length()))
        {
            leader = newText.substring(0, localOffset);
            trailer = newText.substring(localOffset + target.length());
            newText = leader + replacement + trailer;
        }

        return newText;
    }     
}
//EOF
