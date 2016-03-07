/*
 * $Header: /ENTITLEMENT/src/java/com/hp/es/util/Period.java 1.8 2004-05-08 04:41:27+02 entitlem Exp $
 *
 * Copyright (c) 2001 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 */
package com.hp.es.service.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Helper class for calculating the end date and/or length of a period
 * given it's start date and one or more of years, months or days deltas. Leap
 * years are taken into account in the calculation.
 * <P>The usage pattern is:
 * <ul>
 * <li> create a Period instance passing in the desired start date
 * <li> set any deltas as needed
 * <li> retrieve length and/or end date
 * </ul>
 * Note that any of the deltas can be negative, so the end date might also be
 * before the start date depending on the used deltas.
 * <P>The days delta can be treated in one of two ways. In the 'dump' mode the
 * number is simply taken as a pure days diff. In the 'smart' mode however the
 * Period class supports the convention used in some systems that multiples of 365
 * actually mean the matching number of years and multiples of 30 mean the matching
 * number of months. For this logic to be used the number of days must be
 * dividable by either 365 or 30. 395 is NOT interpreted as 1 year and 1 month.
 * @author Laslo Bednarik
 */
public class Period {



    /** Flag for using 'smart' mode for days delta */
    protected boolean _beSmartAboutNumberOfDays = false;

    /** Remembering the start date */
    protected Date     _firstDate = null;

    /** Years delta */
    protected int      _years     = 0;
    /** Months delta */
    protected int      _months    = 0;
    /** Days delta */
    protected int      _days     = 0;

    /**
     * Constructor defaulting to current date and 'dump' mode.
     */
    public Period() {
        this(false);
    }
    /**
     * Constructor defaulting to current date and setting the mode.
     */
    public Period(boolean beSmart) {
        this( new Date(), beSmart);
    }

    /**
     * Constructor using passed start date and to defaulting to 'dump' mode.
     */
    public Period(Date firstDate) { this(firstDate, false); }
    /**
     * Constructor using passed start date and to setting mode.
     */
    public Period(Date firstDate, boolean beSmart) {
        _firstDate = firstDate;
        _beSmartAboutNumberOfDays = beSmart;
    }

    /**
     * Constructor using passed start date and to defaulting to 'dump' mode.
     */
    public Period(Calendar firstDate) { this(firstDate, false); }
    /**
     * Constructor using passed start date and to setting mode.
     */
    public Period(Calendar firstDate, boolean beSmart) {
        _firstDate = firstDate.getTime();
        _beSmartAboutNumberOfDays = beSmart;
    }

    /** Setting the years delta. Can be negative. */
    public void setYears(int years)   { _years = years; }

    /** Setting the months delta. Can be negative. */
    public void setMonths(int months) { _months = months; }

    /** Setting the days delta. Can be negative. */
    public void setDays(int days)     { _days = days; }

    /**
     * Returns the end date computed based on the start date given at
     * instantiation time using the various deltas that have been defined.
     * Leap years are taken into account.
     * <P>In 'smart' mode the days delta is first tried to be interpreted as
     * a number of years (multiple of 365) or a number of months (multiple of 30).
     * @return resulting end date of the period
     */
    public Date getEndDate() {
        return getEndDateAsCalendar().getTime();
    }

    /**
     * Returns the end date computed based on the start date given at
     * instantiation time using the various deltas that have been defined.
     * Leap years are taken into account.
     * <P>In 'smart' mode the days delta is first tried to be interpreted as
     * a number of years (multiple of 365) or a number of months (multiple of 30).
     * @return resulting end date of the period
     */
    public Calendar getEndDateAsCalendar() {

        Calendar myCal = Calendar.getInstance();
        myCal.setTime(_firstDate);

        if (_years != 0) myCal.add(Calendar.YEAR, _years);
        if (_months != 0) myCal.add(Calendar.MONTH, _months);

        if (_days != 0) {

            if ( _beSmartAboutNumberOfDays ) {

                //System.out.print("S");
                if ( (_days % 365) == 0 ) {
                    //System.out.print("(" + _days + " -> " + (_days / 365) + "Y)");
                    myCal.add(Calendar.YEAR, (_days / 365) );
                } else if ( (_days % 30) == 0 ) {
                    //System.out.print("(" + _days + " -> " + (_days / 30) + "M)");
                    myCal.add(Calendar.MONTH, (_days / 30) );
                } else {
                    myCal.add(Calendar.DAY_OF_YEAR, _days);
                }

            } else {
                myCal.add(Calendar.DAY_OF_YEAR, _days);
            }
        }

        return myCal;

    }

    /**
     * Computes the number of days between the start date and the end date
     * resulting from applying the deltas.
     * @return period length in days
     * @see getEndDate
     */
    public int getLengthDays() {
        Date secondDate = getEndDate();
        long firstMillis  = _firstDate.getTime();
        long secondMillis = secondDate.getTime();
        // adding 1 hour and 1 minute to the diff to account for changes to/from
        // daylight saving time
        return (int)((Math.abs(secondMillis-firstMillis)+ (3660 * 1000)) / (24 * 60 * 60 * 1000));
    }

}