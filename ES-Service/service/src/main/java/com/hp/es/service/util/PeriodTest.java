/*
 * $Header: /ENTITLEMENT/src/java/com/hp/es/util/PeriodTest.java 1.9 2004-05-08 04:41:27+02 entitlem Exp $
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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * JUnit class testing the Period class
 * @author Laslo Bednarik
 */
public class PeriodTest extends TestCase {

  public PeriodTest(String s) {
      super(s);
  }

    public static Test suite() {
        return new TestSuite(PeriodTest.class);
    }


  protected void setUp() {
  }

  protected void tearDown() {
  }

  protected Calendar getCalendar(int year, int month, int day) {
      Calendar cal = Calendar.getInstance();
      // for Calendar class months are counted from 0 !!!
      cal.set(year, month-1, day);
      return cal;
  }

  protected Date getDate(int year, int month, int day) {
      return getCalendar(year, month, day).getTime();
  }

  public void testGetLengthDays() {
      Period period = null;
      int length = 0;

      // + 1 year, non-leap
      period = new Period(getDate(2001, 3, 30));
      period.setYears(1);
      length = period.getLengthDays();
      assertEquals("+1 year (non-leap case)", 365, length);

      // + 1 year, leap case
      period = new Period(getDate(1999, 3, 30));
      period.setYears(1);
      length = period.getLengthDays();
      assertEquals("+1 year (leap case)", 366, length);

      // + 1 month, non-leap
      period = new Period(getDate(2001, 3, 30));
      period.setMonths(1);
      length = period.getLengthDays();
      assertEquals("+1 month (non-leap case)", 31, length);

      // + 1 month, leap case
      period = new Period(getDate(2000, 2, 15));
      period.setMonths(1);
      length = period.getLengthDays();
      assertEquals("+1 month (leap case)", 29, length);

      // + 10 days within months
      period = new Period(getDate(2000, 2, 15));
      period.setDays(10);
      length = period.getLengthDays();
      assertEquals("+ 10 days within months", 10, length);

      // + 10 days across months boundaries - non-leap
      period = new Period(getDate(2001, 2, 25));
      period.setDays(10);
      length = period.getLengthDays();
      assertEquals("+ 10 days across months boundaries - non-leap", 10, length);

      // + 10 days across months boundaries - leap
      period = new Period(getDate(2000, 2, 25));
      period.setDays(10);
      length = period.getLengthDays();
      assertEquals("+ 10 days across months boundaries - leaps", 10, length);

      // + 10 years with 2 leap years in between
      period = new Period(getDate(1997, 1, 1));
      period.setYears(10);
      length = period.getLengthDays();
      assertEquals("+ 10 years with 2 leap years in between", 3652, length);

      // 'dump' adding of 30 days
      period = new Period(getDate(2001, 3, 30));
      period.setDays(30);
      length = period.getLengthDays();
      assertEquals("'dump' adding of 30 days", 30, length);

      // 'smart' adding of 30 days
      period = new Period(getDate(2001, 3, 30), true);
      period.setDays(30);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 30 days", 31, length);

      // 'smart' adding of 30 days (feb, non-leap)
      period = new Period(getDate(2001, 2, 20), true);
      period.setDays(30);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 30 days  (feb, non-leap)", 28, length);

      // 'smart' adding of 30 days  (feb, leap)
      period = new Period(getDate(2000, 2, 20), true);
      period.setDays(30);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 30 days (feb, leap)", 29, length);

      // 'smart' adding of 31 days
      period = new Period(getDate(2001, 3, 30), true);
      period.setDays(31);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 31 days", 31, length);

      // 'smart' adding of 60 days - (feb, non-leap)
      period = new Period(getDate(2001, 2, 20), true);
      period.setDays(60);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 60 days (feb, non-leap)", 59, length);

      // 'smart' adding of 60 days - (feb, leap)
      period = new Period(getDate(2000, 2, 20), true);
      period.setDays(60);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 60 days (feb, leap)", 60, length);

      // 'smart' adding of 61 days
      period = new Period(getDate(2000, 2, 20), true);
      period.setDays(61);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 61 days", 61, length);

      // 'smart' adding of 365 days (non-leap)
      period = new Period(getDate(2001, 2, 20), true);
      period.setDays(365);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 365 days (non-leap)", 365, length);

      // 'smart' adding of 365 days (leap)
      period = new Period(getDate(2000, 2, 20), true);
      period.setDays(365);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 365 days (leap)", 366, length);

      // 'smart' adding of 366 days
      period = new Period(getDate(2001, 2, 20), true);
      period.setDays(366);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 366 days", 366, length);

      // 'smart' adding of 1095 days
      period = new Period(getDate(2000, 2, 20), true);
      period.setDays(1095);
      length = period.getLengthDays();
      assertEquals("'smart' adding of 1095 days", 1096, length);

      // combined
      period = new Period(getDate(2000, 2, 20), true);
      period.setYears(2);  // first year is leap    ->   731
      period.setMonths(2); // feb(non-leap) + march -> + 28 + 31
      period.setDays(5);   //                       -> + 5
      length = period.getLengthDays();
      assertEquals("combined", 795, length);

      // substract/combined
      period = new Period(getDate(2002, 4, 25), true);
      period.setYears(-2);
      period.setMonths(-2);
      period.setDays(-5);
      length = period.getLengthDays();
      assertEquals("substract/combined", 795, length);

  }


    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

}
