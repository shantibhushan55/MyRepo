
package com.hp.es.service.combinedEntitlement.bySn;

import junit.framework.TestCase;

import com.hp.es.xml.service.ProductComplexType;
import com.hp.es.xml.service.UnitListComplexType;



public class UnitListMergerTest extends TestCase {

    public UnitListMergerTest(String s) {
        super(s);
    }

    protected void setUp() {
    }

    protected void tearDown() {
    }

    //##########################################################################
    // helper methods

    private ProductComplexType createProduct(String id, String desc) {
        ProductComplexType prod = new ProductComplexType();
        prod.setProductID(id);
        prod.setProductDescription(desc);
        return prod;
    }

    private ProductComplexType createFullProduct(String id, String desc) {
        ProductComplexType prod = new ProductComplexType();
        prod.setProductID(id);
        prod.setProductDescription(desc);
        prod.setEndOfSupportLife(new org.exolab.castor.types.Date(new java.util.Date()));
        prod.setProductLineCode("PLCODE");
        prod.setProductLineDescription("PLDESC");
        return prod;
    }

    private UnitListComplexType createUnitList( String[][] pairs ) {
        UnitListComplexType list = new UnitListComplexType();
        for (int i=0; i<pairs.length; i++) {
            list.addProduct(createProduct(pairs[i][0],pairs[i][1]));
        }
        return list;
    }

    private UnitListComplexType createFullUnitList( String[][] pairs ) {
        UnitListComplexType list = new UnitListComplexType();
        for (int i=0; i<pairs.length; i++) {
            list.addProduct(createFullProduct(pairs[i][0],pairs[i][1]));
        }
        return list;
    }

    //##########################################################################

    public void testGetMergedListTwoListsNoOverlap() {
        UnitListComplexType list1 =
            createUnitList( new String[][]{{"p1","p1 list1"},{"p2","p2 list1"},{"p3","p3 list1"}} );
        UnitListComplexType list2 =
            createUnitList( new String[][]{{"p4","p4 list2"},{"p5","p5 list2"},{"p6","p6 list2"}} );
        UnitListMerger merger = new UnitListMerger("sn", list1, list2);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("sn copied ?", "sn", result.getSerialNumber());
        assertEquals("entries add up?", 6, result.getProductCount());
    }

    public void testGetMergedListTwoListsOverwrite() {
        UnitListComplexType list1 =
            createUnitList( new String[][]{{"p1","p1 list1"},{"p2","p2 list1"},{"p3","p3 list1"}} );
        UnitListComplexType list2 =
            createUnitList( new String[][]{{"p1","p1 list2"},{"p5","p5 list2"},{"p6","p6 list2"}} );
        UnitListMerger merger = new UnitListMerger("sn", list1, list2);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("entries add up?", 5, result.getProductCount());
        assertEquals("list1 won?", "p1 list1", result.getProduct(0).getProductDescription());
    }

    public void testGetMergedListSameBaseNoneRemoved() {
        UnitListComplexType list1 =
            createUnitList( new String[][]{{"p1_001","p1 list1"},{"p2","p2 list1"},{"p3","p3 list1"}} );
        UnitListComplexType list2 =
            createUnitList( new String[][]{{"p1_002","p1 list2"},{"p5","p5 list2"},{"p6","p6 list2"}} );
        UnitListMerger merger = new UnitListMerger("sn", list1, list2);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("entries add up?", 6, result.getProductCount());
        // list should be sorted, so we can find the 2 interesting ones at the beginnning
        assertEquals("entry from list1?", "p1_001", result.getProduct(0).getProductID());
        assertEquals("entry from list2?", "p1_002", result.getProduct(1).getProductID());
    }

    public void testGetMergedListSameBaseOneRemoved() {
        UnitListComplexType list1 =
            createUnitList( new String[][]{{"p1","p1 list1"},{"p2","p2 list1"},{"p3","p3 list1"}} );
        UnitListComplexType list2 =
            createUnitList( new String[][]{{"p1_002","p1 list2"},{"p5","p5 list2"},{"p6","p6 list2"}} );
        UnitListMerger merger = new UnitListMerger("sn", list1, list2);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("entries add up?", 5, result.getProductCount());
        // list should be sorted, so we can find the interesting one at the beginnning
        assertEquals("entry from list2?", "p1_002", result.getProduct(0).getProductID());
    }

    public void testGetMergedListSorting() {
        UnitListComplexType list1 =
            createUnitList( new String[][]{{"p4_002","p4 list1"},{"p5","p5 list1"},{"p1","p1 list1"}} );
        UnitListComplexType list2 =
            createUnitList( new String[][]{{"p4_001","p4 list2"},{"p2","p2 list2"},{"p3_001","p3 list2"},{"p6","p6 list2"}} );
        UnitListMerger merger = new UnitListMerger("sn", list1, list2);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("entries add up?", 7, result.getProductCount());
        // list should be sorted
        assertEquals("entry 0?", "p1", result.getProduct(0).getProductID());
        assertEquals("entry 1?", "p2", result.getProduct(1).getProductID());
        assertEquals("entry 2?", "p3_001", result.getProduct(2).getProductID());
        assertEquals("entry 3?", "p4_001", result.getProduct(3).getProductID());
        assertEquals("entry 4?", "p4_002", result.getProduct(4).getProductID());
        assertEquals("entry 5?", "p5", result.getProduct(5).getProductID());
        assertEquals("entry 6?", "p6", result.getProduct(6).getProductID());
    }

    public void testGetMergedListExtraRemoved() {
        UnitListComplexType list1 =
            createFullUnitList( new String[][]{{"p1","p1 list1"},{"p2","p2 list1"},{"p3","p3 list1"}} );
        UnitListComplexType list2 =
            createFullUnitList( new String[][]{{"p4","p4 list2"},{"p5","p5 list2"},{"p6","p6 list2"}} );
        UnitListMerger merger = new UnitListMerger("sn", list1, list2);
        UnitListComplexType result = merger.getMergedList();

        // check if all unneeded elements removed
        for (int i=0; i<result.getProductCount(); i++) {
            assertEquals("entry "+i+" EOS date ?", null, result.getProduct(i).getEndOfSupportLife());
            assertEquals("entry "+i+" PLCODE date ?", null, result.getProduct(i).getProductLineCode());
            assertEquals("entry "+i+" PLDESC date ?", null, result.getProduct(i).getProductLineDescription());
        }
    }

    public void testGetMergedListProductNull() {
        UnitListComplexType list =
            createUnitList( new String[][]{{"p1","p1 list"},{"p2","p2 list"},{"p3","p3 list"}} );
        ProductComplexType prod = null;

        UnitListMerger merger = new UnitListMerger("sn", prod, list);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("sn copied ?", "sn", result.getSerialNumber());
        assertEquals("entries add up?", 3, result.getProductCount());
    }

    public void testGetMergedListProductNoOverlap() {
        UnitListComplexType list =
            createUnitList( new String[][]{{"p1","p1 list"},{"p2","p2 list"},{"p3","p3 list"}} );
        ProductComplexType prod = createProduct("p0", "p0 single");

        UnitListMerger merger = new UnitListMerger("sn", prod, list);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("sn copied ?", "sn", result.getSerialNumber());
        assertEquals("entries add up?", 4, result.getProductCount());
    }

    public void testGetMergedListProductLowPrio() {
        UnitListComplexType list =
            createUnitList( new String[][]{{"p1","p1 list"},{"p2","p2 list"},{"p3","p3 list"}} );
        ProductComplexType prod = createProduct("p1","p1 single");

        UnitListMerger merger = new UnitListMerger("sn", prod, list, false);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("sn copied ?", "sn", result.getSerialNumber());
        assertEquals("entries add up?", 3, result.getProductCount());
        assertEquals("list wins?", "p1 list", result.getProduct(0).getProductDescription());
    }

    public void testGetMergedListProductHighPrio() {
        UnitListComplexType list =
            createUnitList( new String[][]{{"p1","p1 list"},{"p2","p2 list"},{"p3","p3 list"}} );
        ProductComplexType prod = createProduct("p1","p1 single");

        UnitListMerger merger = new UnitListMerger("sn", prod, list, true);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("sn copied ?", "sn", result.getSerialNumber());
        assertEquals("entries add up?", 3, result.getProductCount());
        assertEquals("product wins?", "p1 single", result.getProduct(0).getProductDescription());
    }

    public void testGetMergedListProductSameBaseRemoved() {
        UnitListComplexType list =
            createUnitList( new String[][]{{"p1","p1 list"},{"p2","p2 list"},{"p3","p3 list"}} );
        ProductComplexType prod = createProduct("p1_001","p1 single");

        UnitListMerger merger = new UnitListMerger("sn", prod, list, true);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("sn copied ?", "sn", result.getSerialNumber());
        assertEquals("entries add up?", 3, result.getProductCount());
        assertEquals("product wins?", "p1 single", result.getProduct(0).getProductDescription());
        assertEquals("product wins?", "p1_001", result.getProduct(0).getProductID());
    }

    public void testGetMergedListProductSameBaseNotRemoved() {
        UnitListComplexType list =
            createUnitList( new String[][]{{"p1_002","p1 list"},{"p2","p2 list"},{"p3","p3 list"}} );
        ProductComplexType prod = createProduct("p1_001","p1 single");

        UnitListMerger merger = new UnitListMerger("sn", prod, list, true);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("sn copied ?", "sn", result.getSerialNumber());
        assertEquals("entries add up?", 4, result.getProductCount());
        assertEquals("product there?", "p1 single", result.getProduct(0).getProductDescription());
        assertEquals("product there?", "p1_001", result.getProduct(0).getProductID());
        assertEquals("list there?", "p1 list", result.getProduct(1).getProductDescription());
        assertEquals("list there?", "p1_002", result.getProduct(1).getProductID());
    }

    public void testGetMergedListListNull() {
        ProductComplexType prod = createProduct("p1_001","p1 single");

        UnitListMerger merger = new UnitListMerger("sn", prod, null, true);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("sn copied ?", "sn", result.getSerialNumber());
        assertEquals("entries add up?", 1, result.getProductCount());
        assertEquals("product there?", "p1 single", result.getProduct(0).getProductDescription());
        assertEquals("product there?", "p1_001", result.getProduct(0).getProductID());
    }

    public void testGetMergedListAllNull() {
        UnitListMerger merger = new UnitListMerger("sn", (UnitListComplexType)null, null);
        UnitListComplexType result = merger.getMergedList();

        assertEquals("sn copied ?", "sn", result.getSerialNumber());
        assertEquals("entries add up?", 0, result.getProductCount());
    }


}
