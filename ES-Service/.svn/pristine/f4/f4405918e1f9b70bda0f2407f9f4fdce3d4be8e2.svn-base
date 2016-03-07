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

import junit.framework.TestCase;


public class RegExDateMatcherTest extends TestCase {

    RegExDateMatcher matcher = new RegExDateMatcher();

    public void testExactISO() {
        final String ISO_DATE = "<mydatea>2002-11-14</mydatea>";
        String [] result = matcher.match(ISO_DATE);
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("2002-11-14", result[0]);
    }

    public void testSanityOne() {
        final String KNIGHT_DATE = "14";
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }

    public void testSanityTwo() {
        final String KNIGHT_DATE = "14-11";
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }

    public void testSanityNoise1() {
        final String KNIGHT_DATE = "-";
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }
    public void testSanityNoise2() {
        final String KNIGHT_DATE = "------------";
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }

    public void testNull() {
        final String KNIGHT_DATE = null;
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }

    public void testSanityZero() {
        final String KNIGHT_DATE = "0";
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }

    public void testSanityDisturb1() {
        final String KNIGHT_DATE = "14-11-";
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }

    public void testSanityDisturb2() {
        final String KNIGHT_DATE = "-14-11-";
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }

    public void testSanityDisturb3() {
        final String KNIGHT_DATE = "--14-11--";
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }

    public void testSanityDisturb4() {
        final String KNIGHT_DATE = "1411";
        String [] result = matcher.match(KNIGHT_DATE);
        assertNull(result);
    }

    public void testDisturb1() {
        final String ISO_DATE = "<mydatea-00>2002-11-14<sdsdads>";
        String [] result = matcher.match(ISO_DATE);
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("2002-11-14", result[0]);
    }

    public void testDisturb2() {
        final String ISO_DATE = "<mydatea2000-20-20>2002-11-14<sdadsa>";
        String [] result = matcher.match(ISO_DATE);
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("2002-11-14", result[0]);
    }

    public void testDisturb3() {
        final String ISO_DATE = "<mydatea2000-20-20>2002-11-aa</mydatea2000-20-20>BLAH<good_date>2002-11-14</good_date>";
        String [] result = matcher.match(ISO_DATE);
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("2002-11-14", result[0]);
    }

    public void testDisturb4() {
        final String ISO_DATE = "<date>2002-11-14</date><a_date>2005-7-3</a_date>";
        String [] result = matcher.match(ISO_DATE);
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("2002-11-14", result[0]);
        assertEquals("2005-7-3", result[1]);
    }

    public void testDisturb5() {
        final String ISO_DATE = "<DATEB>2002-9-5</DATEB><xls:adateb>2005-1-1</xls:adateb>";
        String [] result = matcher.match(ISO_DATE);
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("2002-9-5", result[0]);
        assertEquals("2005-1-1", result[1]);
    }

    public void testPerformance() {
        int totalExecutionTime = 0;
        for (int i=0; i<NUMBER_OF_ROUNDS; i++) {
            String[] result;
            {
                long timeBefore = System.currentTimeMillis();
                matcher = new RegExDateMatcher();
                result = matcher.match(TO_MATCH);
                long timeAfter = System.currentTimeMillis();
                totalExecutionTime += timeAfter - timeBefore;
            }
            assertNotNull(result);
            assertEquals(2, result.length);
            assertEquals("2003-03-14", result[0]);
            assertEquals("2002-05-01", result[1]);
        }
        System.out.println("Time total (ms) (total of " + NUMBER_OF_ROUNDS + " runs): " + totalExecutionTime);
        System.out.println("Time per run, avg (ms): " + totalExecutionTime/NUMBER_OF_ROUNDS);
    }

    public static final int NUMBER_OF_ROUNDS = 100;

    public static final String TO_MATCH =
        "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
        "<EIAMessage>" +
        "    <MessageHeader>" +
        "        <MessageID>test</MessageID>" +
        "        <TimeStamp></TimeStamp>" +
        "        <MessageType>request</MessageType>" +
        "        <MessageComment></MessageComment>" +
        "        <Routing>" +
        "            <SourceSystem>" +
        "                <SrcSystemInstance></SrcSystemInstance>" +
        "                <SrcSystemType></SrcSystemType>" +
        "                <SrcHPEntity></SrcHPEntity>" +
        "                <SrcCountry></SrcCountry>" +
        "                <SrcSiteName></SrcSiteName>" +
        "            </SourceSystem>" +
        "        </Routing>" +
        "        <ServiceDescriptor>" +
        "            <ServiceID>HPSE</ServiceID>" +
        "            <MajorVersion>4</MajorVersion>" +
        "            <MinorVersion>0</MinorVersion>" +
        "        </ServiceDescriptor>" +
        "        <MessageState>" +
        "            <Validated></Validated>" +
        "        </MessageState>" +
        "        <MessageSecurity>" +
        "            <SecurityCredentials>" +
        "                <UserName>TheMan</UserName>" +
        "                <UserPassword>FromNowhere</UserPassword>" +
        "            </SecurityCredentials>" +
        "            <SecurityPrivileges></SecurityPrivileges>" +
        "        </MessageSecurity>" +
        "    </MessageHeader>" +
        "    <MessageBody><EsRequestComplexType>" +
        "    <Operation>getWarrantyDetailsKNIGHT</Operation>" +
        "    <ClientAppID>TESTWARE</ClientAppID>" +
        "    <WarrantyRequest>" +
        "        <IsoCountryCd>US</IsoCountryCd>" +
        "      <EntitlementCheckDate>2003-03-14</EntitlementCheckDate>" +
        "        <IncludeServiceNotes>N</IncludeServiceNotes>" +
        "        <IncludeWorkings>N</IncludeWorkings>" +
        "        <SerialNumber>6548HSA9U676</SerialNumber>" +
        "        <ProductID>112468-001</ProductID>" +
        "        <ProofPurchaseDate>2002-05-01</ProofPurchaseDate> " +
        "        <SparePartNumber></SparePartNumber>" +
        "        <DateCode></DateCode>" +
        "        <ConsumerBusinessLogicNeeded>N</ConsumerBusinessLogicNeeded>" +
        "        <MarketSegment></MarketSegment>" +
        "        <GeoCode></GeoCode>" +
        "    </WarrantyRequest>" +
        "</EsRequestComplexType>" +
        "</MessageBody>" +
        "    <MessageTrailer>" +
        "        <Activity>" +
        "            <ActOriginator></ActOriginator>" +
        "            <ActDateTime>2002/02/04 14:05:16:487 GMT</ActDateTime>" +
        "            <ActLocation></ActLocation>" +
        "            <ActType></ActType>" +
        "        </Activity>" +
        "    </MessageTrailer>" +
        "</EIAMessage>";


}
