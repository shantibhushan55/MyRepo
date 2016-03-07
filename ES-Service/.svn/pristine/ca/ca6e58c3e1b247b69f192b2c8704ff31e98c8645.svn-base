/*
 * Created on Mar 10, 2006
 */
package com.hp.es.service.orchestration.sap;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author JUHANK
 */
public class RegionFactoryTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(RegionFactoryTest.class);
	}

	public RegionFactoryTest(String arg0) {
		super(arg0);
	}

    public static Test suite() {
        // discover test*() methods via reflection:
        return new TestSuite(RegionFactoryTest.class);
    }
	
	/*
	 * Test method for available regions
	 */
	public void testAvailableRegions() {
		RegionFactory rf = RegionFactory.getInstance();
		ArrayList availableRegions = rf.getAvailableRegions();
		assertEquals(availableRegions.size(), 3);
	}

	/*
	 * OBSOLETE
	 * Test method for LocalRegionName
	 */
	/*
	public void testLocalRegionName() {
		RegionFactory rf = RegionFactory.getInstance();
		assertEquals("AM", rf.getLocalRegionName());
		assertEquals("AM", rf.getLocalRegion().getConfiguration().getRegionName());
	}
	*/
	
	/*
	 * Test method for LocalRegionName
	 */
	public void testRegionByName() {
		RegionFactory rf = RegionFactory.getInstance();
		// AM
		Region region = rf.getRegionByName("AM");
		assertEquals("AM", region.getConfiguration().getRegionName());

		// AP
		region = rf.getRegionByName("AP");
		assertEquals("AP", region.getConfiguration().getRegionName());

		// EMEA
		region = rf.getRegionByName("EMEA");
		assertEquals("EMEA", region.getConfiguration().getRegionName());
	}
	

}
