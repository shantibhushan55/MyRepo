/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 30-Aug-02
 * Time: 06:51:57
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 *
 * Project: Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/util/DateHelper.java 1.22 2004-07-27 04:38:20+02 zhanghai Exp $
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
 * @author Dave Frey
 *
 * $Log: DateHelper.java,v $
 * Revision 1.22  2004-07-27 04:38:20+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Add comment for function newDateWithOffset: This function uses some tricky to avoid daylight saving time
 *
 * Revision 1.21  2004-07-22 10:17:08+02  zhanghai
 * Author: zhanghai@hp-a42c3bb0oim2 ()
 * Add a new method: newDateWithOffset
 *
 * Revision 1.20  2004-05-08 04:41:26+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.19  2004-05-05 15:40:08+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.18  2004-01-29 18:05:46+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.17  2003-08-04 16:50:16+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.16  2003-06-13 18:07:50+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * just renaming a method toIsoDateString()
 *
 * Revision 1.15  2003-06-13 17:14:20+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * added toIsoDateString(Date) to print Dates as YYYY-MM-DD

 * proving test case getWarrantyEntitlement_318.xml
 *
 * Revision 1.14  2003-05-28 18:33:32+02  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * added Later/Latest versions of java date compare methods
 *
 * Revision 1.13  2003-05-12 01:58:40+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0C2
 *
 * Revision 1.12  2003-03-17 16:15:05+01  frey
 * Author: frey@dhcp-15-130-68-147.france.hp.com ()
 * added findEarliestJavaDate(d1, d2, d3)
 *
 * Revision 1.11  2003-02-26 15:33:00+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_1
 *
 * Revision 1.10  2003-01-22 15:27:17+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point3_0
 *
 * Revision 1.9  2002-12-05 04:25:55+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * added mapJava2DateStruct(java.util.Date)
 *
 * Revision 1.8  2002-11-26 19:12:59+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * no changes, just pushing head to allow branching at last version
 *
 * Revision 1.7  2002-11-25 19:08:57+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * added convenience: getYearFromJavaDate(Date date)
 *
 * Revision 1.6  2002-11-05 10:37:48+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * pushing a null pointer case out to client space
 *
 * Revision 1.5  2002-11-04 16:12:31+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * new convenience method
 *
 * Revision 1.4  2002-10-29 16:58:56+01  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * fixed "zero-based month numbering" problem
 *
 * Revision 1.3  2002-10-10 19:48:59+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * added a months offset function
 *
 * Revision 1.2  2002-10-10 10:18:45+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * added newJavaDateWithDaysOffset()
 *
 * Revision 1.1  2002-10-07 14:59:19+02  frey
 * Author: frey@dhcp-15-130-71-152.france.hp.com ()
 * the cross-ES Date helper class
 *
 *
 */
package com.hp.es.service.util;

/* NOTE: do not import any Date classes; to avoid confusion, they should be explicitly typed wherever used.
import java.util.Date;
import org.exolab.castor.types.Date;
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import com.hp.es.wrapper.corba.HpseWrapper.DateStruct;

public class DateHelper {

    private static final String CDO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String XML_DATE_TIME_FORMAT = "yyyy-MM-dd";

    /**
     * This is a foreign method override for <code>java.util.Date#toString()</code> for those wanting to see
     * a <code>String</code> representation of the date-only portion, in ISO standard format.
     * @param date the date to format as a string
     * @return the ISO standard string format of the passed date, or "null"
     */
    static public String toIsoDateString(org.exolab.castor.types.Date date) {
    	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	return (date == null)
            ? ""
            : formatter.format(mapCastorDate2Java(date));
    }
    
    
    static public String toTimeStampString(Date date) {
    	DateFormat formatter = new SimpleDateFormat(XML_DATE_TIME_FORMAT);
    	return (date == null)
            ? ""
            : formatter.format(date);
    }

    static public java.util.Date mapIsoDate2JavaDate(String dateString) {
    	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	if(dateString == null || dateString.equals("") || dateString.equals("0000-00-00")) {
    		return null;
    	}
        try {
        	return formatter.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
    }

    /**
     * Creates a java.util.Date object out of the DateStruct returned from the SwatWrapper.
     *
     * @param ds a <code>SwatWrapper</code> idl date structure
     * @return java.util.Date, or <code>null</code>

    static public java.util.Date mapDateStruct2Java(DateStruct ds) {

        // stop if it doesn't seem to be a valid date
        if ( (ds == null) || (ds.day == 0) || (ds.month == 0) || (ds.year == 0)) return null;

        return new GregorianCalendar(ds.year, ds.month -1, ds.day).getTime();
    }
         */
    /**
     * Creates a SwatWrapper <code>DateStruct</code> from a java.util.Date object.
     *
     * @param date a <code>SwatWrapper</code> idl date structure
     * @return
     
    static public DateStruct mapJava2DateStruct(java.util.Date date) {

        // stop if it doesn't seem to be a valid date
        if (date == null)
            return new DateStruct((short)0, (short)0, (short)0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int monthBase1 = calendar.get(Calendar.MONTH) +1;
        return new DateStruct((short)calendar.get(Calendar.DATE), (short)monthBase1, (short)calendar.get(Calendar.YEAR));
    }
    */
    /**
     * Convert a java Date into a Castor one.  It's true this is easier to just do the new() inline, but
     * we put it in <code>DateHelper</code> in order to document/have single implementation of the
     * conversion.
     * @param  javaDate a java date
     * @return a Castor date, or null
     */
    static public org.exolab.castor.types.Date mapJavaDate2Castor(java.util.Date javaDate) {
        if (javaDate == null)
            return null;
        else
            return new org.exolab.castor.types.Date(javaDate);
    }
    /**
     * Convert a Castor Date into a java one.  It's true that it is easier to just do toDate() inline, but
     * we put it in <code>DateHelper</code> in order to document/have single implementation of the
     * conversion.
     * @param  castorDate a Castor date
     * @return a java date, or null
     */
    static public java.util.Date mapCastorDate2Java(org.exolab.castor.types.Date castorDate) {
    	if(castorDate == null || castorDate.toString().equals("") || castorDate.toString().equals("0000-00-00"))
            return null;
        else
            return castorDate.toDate();
    }
    
    static public String mapJavaDate2Abap(java.util.Date javaDate) {
    	if (javaDate == null)
    		return null;

        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat ("yyyyMMdd");
        return df.format(javaDate);
    }

    static public String mapCastorDate2Abap(org.exolab.castor.types.Date castorDate) {
    	if (castorDate == null)
    		return null;

        return mapJavaDate2Abap(mapCastorDate2Java(castorDate));
    }

    /**
     * Computes which of the two passed java dates is earlier and returns it.
     * Handles null input date(s); a real date is earlier than a null.
     *
     * @param  d1 one date
     * @param  d2 nother date
     * @return java.util.Date Earlier of the two dates, or null
     */
    static public java.util.Date findEarlierJavaDate(java.util.Date d1, java.util.Date d2)   {

        if ((d1 == null) && (d2 == null))   return null;
        else if (d1 == null)                return d2;
        else if (d2 == null)                return d1;
        else                                return (d1.before(d2)) ? d1 : d2;
    }
    static public java.util.Date findEarliestJavaDate(java.util.Date d1, java.util.Date d2, java.util.Date d3)   {

        if ((d1 == null) && (d2 == null) && (d3 == null))
            return null;

        else if (d1 == null)
            return findEarlierJavaDate(d2, d3);
        else if (d2 == null)
            return findEarlierJavaDate(d1, d3);
        else if (d3 == null)
            return findEarlierJavaDate(d1, d2);

        else  {
            java.util.Date earlierOfTwo = findEarlierJavaDate(d1, d2);
            return findEarlierJavaDate(earlierOfTwo, d3);
        }
    }
    /**
     * Computes which of the two passed java dates is later and returns it.
     * Handles null input date(s); a real date is later than a null.
     *
     * @param  d1 one date
     * @param  d2 another date
     * @return java.util.Date Later of the two dates, or null
     */
    static public java.util.Date findLaterJavaDate(java.util.Date d1, java.util.Date d2)   {

        if ((d1 == null) && (d2 == null))   return null;
        else if (d1 == null)                return d2;
        else if (d2 == null)                return d1;
        else                                return (d1.after(d2)) ? d1 : d2;
    }
    static public java.util.Date findLatestJavaDate(java.util.Date d1, java.util.Date d2, java.util.Date d3)   {

        if ((d1 == null) && (d2 == null) && (d3 == null))
            return null;

        else if (d1 == null)
            return findLaterJavaDate(d2, d3);
        else if (d2 == null)
            return findLaterJavaDate(d1, d3);
        else if (d3 == null)
            return findLaterJavaDate(d1, d2);

        else  {
            java.util.Date laterOfTwo = findLaterJavaDate(d1, d2);
            return findLaterJavaDate(laterOfTwo, d3);
        }
    }
    static public java.util.Date newJavaDateWithDaysOffset(java.util.Date baseDate, int days) {
        return newJavaDateWithOffset(baseDate, Calendar.DATE, days);
    }
    static public java.util.Date newJavaDateWithMonthsOffset(java.util.Date baseDate, int months) {
        return newJavaDateWithOffset(baseDate, Calendar.MONTH, months);
    }
    static public java.util.Date newJavaDateWithYearsOffset(java.util.Date baseDate, int months) {
        return newJavaDateWithOffset(baseDate, Calendar.YEAR, months);
    }
    static private java.util.Date newJavaDateWithOffset(java.util.Date baseDate, int offsetType, int offset) {

        // handle early exit conditions
        if (baseDate == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(baseDate);
        calendar.add(offsetType, offset);

        return calendar.getTime();
    }
    public static int getYearFromJavaDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);

        return year;
    }

    /**
     * This function is for PoP date alignment.
     * @param originalDate : This maybe originalStartDate or originalEndDate, which is located in AppliesTo element
     * @param recalculatedWarrantyStartDate
     * @param wtyStartDateFromCDO
     * @return: org.exolab.castor.types.Date
     *  The formula is : originalDate + recalculatedWarrantyStartDate - wtyStartDateFromCDO
     *  This formula is calculated at the date level.
     *  Here java date is calculated at millisecond level, which is effected by daylight saving time, so we add 6 hours to avoid it.
     *  Or the result maybe one day less than expectation in those country just using daylight saving time currently.
     *  Why we use 6 hours, not 5 or 7 or others? The answer is that we can use all of those numbers if they can avoid all kinds of daylight saving times all over the world.
     */
    public static org.exolab.castor.types.Date newDateWithOffset(org.exolab.castor.types.Date originalDate, org.exolab.castor.types.Date recalculatedWarrantyStartDate, org.exolab.castor.types.Date wtyStartDateFromCDO) {
        java.util.Date orgDate = DateHelper.mapCastorDate2Java(originalDate);
        java.util.Date recDate = DateHelper.mapCastorDate2Java(recalculatedWarrantyStartDate);
        java.util.Date cdoDate = DateHelper.mapCastorDate2Java(wtyStartDateFromCDO);
        if(orgDate != null && recDate != null && cdoDate != null){
        return DateHelper.mapJavaDate2Castor(new java.util.Date(orgDate.getTime() + recDate.getTime() - cdoDate.getTime() + 6 * 1000 * 3600));
        }
        else{
        	return null;
        }
    }
    
    
	/*
	 * Get the min date out of two castor dates.
	 * @param date1
	 * @param date2
	 * @return null if both dates are null; otherwise return the min
	 *               of both dates
	 */
	public static org.exolab.castor.types.Date minDate(
	        org.exolab.castor.types.Date date1, org.exolab.castor.types.Date date2) {
		
		// if both dates are null then we return null
		if(date1 == null && date2 == null) {
			return null;
		}
		
		// if date1 is null, then we return date2
		if(date1 == null) {
			return date2;
		}
		
		// if date2 is null, then we return date1
		if(date2 == null) {
			return date1;
		}

		// at this point we have 2 dates
		Date javaDate1 = date1.toDate();
		Date javaDate2 = date2.toDate();
		
		// check if the dates are equal, the return date1
		if(javaDate1.equals(javaDate2)) {
			return date1;
		}
		// check which one is the min date
		if(javaDate1.after(javaDate2)) {
			// date2 is min date, because it is before date 1
			return date2;
		} else {
			// date1 is min date, because it is before date 2
			return date1;
		}
	}
	
	/**
	 *
	 * @param date1
	 * @param date2
	 * @return null if date1 or date2 is null; otherwise return the max
	 *               of both dates
	 */
	public static org.exolab.castor.types.Date maxDate(
			org.exolab.castor.types.Date date1, org.exolab.castor.types.Date date2) {
		// if 1 date is null then we return null
		if(date1 == null || date2 == null) {
			return null;
		}
		
		Date javaDate1 = date1.toDate();
		Date javaDate2 = date2.toDate();
		
		// check if the dates are equal, the return date1
		if(javaDate1.equals(javaDate2)) {
			return date1;
		}
		// check which one is the min date
		if(javaDate1.after(javaDate2)) {
			// date1 is max date, because it is after date 2
			return date1;
		} else {
			// date2 is max date, because it is after date 1
			return date2;
		}
	}

	public static boolean isGreater(Date d1, Date d2) {
		if(d1 == null) {
			return false;
		}
		if(d2 == null) {
			return true;
		}
		if(d1.after(d2)) {
			return true;
		}
		return false;
	}

	public static java.util.Date cdoDateToJavaDate(String cdoPublishDate) {
	     if(cdoPublishDate == null) {
	            return null;
	     }

        Date d = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(CDO_DATE_TIME_FORMAT);
            d = sdf.parse(cdoPublishDate);
            
        } catch(ParseException pe) {
        	ESLog.info("Unable to parse CDO date" + cdoPublishDate );
        	return null;
        }
        return d;
	}
    
}
