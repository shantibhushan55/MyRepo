/**
 * Project: Entitlement Service
 *
 *
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
 */

package com.hp.es.service.util;

import java.util.Iterator;
import java.util.LinkedList;

import org.apache.oro.text.perl.Perl5Util;

/**
 * This class is used to find all "dates" out of an XML string. It is per
 * definition a string seperated with "-" having a series of 4, 1 (max 2)
 * and 1 (max 2) digits. This string must be inside a tag, and must not be
 * disturbed by something else (i.e. <not_working>a2002-02-02</not_working>).
 * Finally, the tag where it is embedded into has to contain the word "date".
 * However, you can configure all this using the properties tagRestriction and
 * dateRestriction. By that you could also turn it into american dates (i.e.
 * MM/DD/YYYY).
 */
public class RegExDateMatcher {

    /**
     * Restricts the tag in front of it. As per default, it is <[\\w:_-]*date[\\w:_-]*>
     */
    private String _tagRestriction = "<[\\w:_-]*date[\\w:_-]*>";

    /**
     * Restricts the date field. As per default, it is ^[\\d]{4}-[\\d]{1,2}-[\\d]{1,2}
     */
    private String _dateRestriction = "^[\\d]{4}-[\\d]{1,2}-[\\d]{1,2}";

    /**
     * Restricts the date field. As per default, it is ^[\\d]{4}-[\\d]{1,2}-[\\d]{1,2}
     * @return
     */
    public String getDateRestriction() {
        return _dateRestriction;
    }

    /**
     * Restricts the tag in front of it. As per default, it is <[\\w:_-]*date[\\w:_-]*>
     * @return
     */
    public String getTagRestriction() {
        return _tagRestriction;
    }

    /**
     * Restricts the date field. As per default, it is ^[\\d]{4}-[\\d]{1,2}-[\\d]{1,2}
     * @param string
     */
    public void setDateRestriction(String string) {
        _dateRestriction = string;
    }

    /**
     * Restricts the tag in front of it. As per default, it is <[\\w:_-]*date[\\w:_-]*>
     * @param string
     */
    public void setTagRestriction(String string) {
        _tagRestriction = string;
    }

    /**
     * Tries to find all the date entries inside. Calculation is based on TagRestriction and DateRestriction.
     * @param input the input to scan for
     * @return the dates (as Strings), or "null" if none found
     */
    public String [] match(String input) {
        LinkedList datesList = new LinkedList();
        if (input != null) {
            Perl5Util util = new Perl5Util();
            LinkedList result1 = new LinkedList();
            util.split(result1, "/" + _tagRestriction + "/i", input, Perl5Util.SPLIT_ALL);
            for (Iterator it = result1.iterator(); it.hasNext();) {
                String matchResult = (String) it.next();
                boolean containsDate = util.match("/" + _dateRestriction + "/", matchResult);
                if (containsDate) {
                    LinkedList result2 = new LinkedList();
                    util.split(result2, "/</", matchResult, Perl5Util.SPLIT_ALL);
                    if (result2.size() > 1) {
                        datesList.add(result2.get(0));
                    }
                }
            }
        }
        if (datesList.size() > 0) {
            return (String[]) datesList.toArray(new String [datesList.size()]);
        } else {
            return null;
        }
    }

}
