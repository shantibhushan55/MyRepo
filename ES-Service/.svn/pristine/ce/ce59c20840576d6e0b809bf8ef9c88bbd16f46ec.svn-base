
package com.hp.es.service.combinedEntitlement.bySn;

import junit.framework.TestCase;



public class BaseProductHelperTest extends TestCase {

    public BaseProductHelperTest(String s) {
        super(s);
    }

    protected void setUp() {
    }

    protected void tearDown() {
    }

    public void testExtractBase1() {
        assertEquals("no options: ", "A2001A", BaseProductHelper.extractBase("A2001A"));
    }

    public void testExtractBase2() {
        assertEquals("option with #: ", "A2001A", BaseProductHelper.extractBase("A2001A#001"));
    }

    public void testExtractBase3() {
        assertEquals("option with _: ", "A2001A", BaseProductHelper.extractBase("A2001A_001"));
    }

    public void testExtractBase4() {
        assertEquals("option with _ and #: ", "A2001A", BaseProductHelper.extractBase("A2001A_001#002"));
    }

    public void testExtractBase5() {
        assertEquals("option with # and _: ", "A2001A", BaseProductHelper.extractBase("A2001A#001_002"));
    }

    public void testExtractBaseNull() {
        assertEquals("nzll input: ", null, BaseProductHelper.extractBase(null));
    }

    public void testCompareProducts1() {
        assertEquals("both without options: ", 0, BaseProductHelper.compareProducts("A2001A","A2001A"));
    }
    public void testCompareProducts2() {
        assertEquals("both with options: ", 0, BaseProductHelper.compareProducts("A2001A_001","A2001A#002"));
    }
    public void testCompareProducts3() {
        assertEquals("first with option: ", -1, BaseProductHelper.compareProducts("A2001A_001","A2001A"));
    }
    public void testCompareProducts4() {
        assertEquals("second with option: ", 1, BaseProductHelper.compareProducts("A2001A","A2001A#002"));
    }
    public void testCompareProductsBaseMismatch() {
        try {
            BaseProductHelper.compareProducts("A2001A","A2003A#002");
            fail("non-matching base product numbers");
        } catch (IllegalArgumentException iae) {}
    }
    public void testCompareProductsNull() {
        try {
            BaseProductHelper.compareProducts("A2001A",null);
            fail("null input");
        } catch (IllegalArgumentException iae) {}
    }

    public void testSameBaseProduct1() {
        assertEquals("same base: ", true, BaseProductHelper.sameBaseProduct("A2001A","A2001A_001"));
    }
    public void testSameBaseProduct2() {
        assertEquals("different base: ", false, BaseProductHelper.sameBaseProduct("A2001A","A2003A_001"));
    }
    public void testSameBaseProductNull() {
        try {
            BaseProductHelper.sameBaseProduct("A2001A",null);
            fail("null input");
        } catch (IllegalArgumentException iae) {}
    }

}
