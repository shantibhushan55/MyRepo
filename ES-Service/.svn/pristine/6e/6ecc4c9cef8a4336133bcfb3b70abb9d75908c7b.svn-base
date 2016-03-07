/**
 * 
 */
package com.hp.es.service.manufacturingHeaderInformation.integration;

import junit.framework.Assert;

import org.junit.Test;

import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.xml.service.AssociatedContractsRequest;
import com.hp.es.xml.service.EntitlementBySnRequest;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.EsRequestComplexTypeChoice;
import com.hp.es.xml.service.WarrantyRequest;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author ANVOI
 * requires to have config in the classpath.
 * and
 * the following VM argument
 * -DES_HOME=C:\\home\\entitlem\\st\\trunk\\service\\work
 * -DTEST_HOME=C:\\home\\entitlem\\st\\trunk\\service\\work
 */
public class ManufacturingInstalledBaseServiceIntegrationTest extends  ManufacturingInstalledBaseServiceIntegration{
/*
 * extending ManufacturingInstalledBaseServiceIntegration gives us a dirty way to test protected methods...
 */
	/**
	 * 
	 */
	public ManufacturingInstalledBaseServiceIntegrationTest() {
		super();
	}
	
	/**
	 * Test method for {@link com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		ManufacturingInstalledBaseServiceIntegration mibsi = ManufacturingInstalledBaseServiceIntegration.getInstance();
		RegionConfiguration rc = mibsi.getRegionConfiguration();
		Assert.assertNotNull(rc);
	}


	




	/**
	 * Test method for {@link com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration#getRegionConfiguration()}.
	 */
	@Test
	public void testExecuterequestMapping() {
		ManufacturingInstalledBaseServiceIntegration mibsi = ManufacturingInstalledBaseServiceIntegration.getInstance();
		
		
		MetricsHandler metricsHandler = null;
		Transaction t= null;
		/*
		 * We first test the request mapping
		 */
		
		try {
			EsRequestComplexType request = null;
			t= mibsi.execute(request, metricsHandler);
			Assert.fail("This should have generated an exception");
		} catch (SifException e) {
			Assert.assertEquals("9999",e.getErrorID());
		}
		
		
		
		try {
			EsRequestComplexType request = null;
			request = new EsRequestComplexType();
			t= mibsi.execute(request, metricsHandler);
			Assert.fail("This should have generated an exception");
		} catch (SifException e) {
			Assert.assertEquals("9999",e.getErrorID());
		}
		
		try {
			EsRequestComplexType request = null;
			request = new EsRequestComplexType();
			request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
			request.getEsRequestComplexTypeChoice().setAssociatedContractsRequest(new AssociatedContractsRequest());
			t= mibsi.execute(request, metricsHandler);
			Assert.fail("This should have generated an exception");
		} catch (SifException e) {
			Assert.assertEquals("9999",e.getErrorID());
		}
		
		
		try {
			EsRequestComplexType request = null;
			request = new EsRequestComplexType();
			request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
			request.getEsRequestComplexTypeChoice().setEntitlementBySnRequest(new EntitlementBySnRequest());
			request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().setSerialNumber(null);
			t= mibsi.execute(request, metricsHandler);
			Assert.fail("This should have generated an exception");
		} catch (SifException e) {
			Assert.assertEquals("9999",e.getErrorID());
		}
		
		
		try {
			EsRequestComplexType request = null;
			request = new EsRequestComplexType();
			request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
			request.getEsRequestComplexTypeChoice().setEntitlementBySnRequest(new EntitlementBySnRequest());
			request.getEsRequestComplexTypeChoice().getEntitlementBySnRequest().setSerialNumber("tmp");
			t= mibsi.execute(request, metricsHandler);
			Assert.fail("This should have generated an exception");
		} catch (SifException e) {
			Assert.assertEquals("9999",e.getErrorID());
		}
		
		
		try {
			EsRequestComplexType request = null;
			request = new EsRequestComplexType();
			request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
			request.getEsRequestComplexTypeChoice().setWarrantyRequest(new WarrantyRequest());
			request.getEsRequestComplexTypeChoice().getWarrantyRequest().setSerialNumber(null);
			t= mibsi.execute(request, metricsHandler);
			Assert.fail("This should have generated an exception");
		} catch (SifException e) {
			Assert.assertEquals("9999",e.getErrorID());
		}
		
		
		try {
			EsRequestComplexType request = null;
			request = new EsRequestComplexType();
			request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
			request.getEsRequestComplexTypeChoice().setWarrantyRequest(new WarrantyRequest());
			request.getEsRequestComplexTypeChoice().getWarrantyRequest().setSerialNumber("tmp");
			t= mibsi.execute(request, metricsHandler);
			
		} catch (SifException e) {
			Assert.fail("This should not have generated an exception with id"+e.getErrorID());
		}
		
		/*
		 * We then test the reply mapping
		 */
		Assert.assertTrue(true);
	}
	
	
	
	/**
	 * Test method for {@link com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration#getRegionConfiguration()}.
	 */
	@Test
	public void testExecuteReplyMapping() {
		ManufacturingInstalledBaseServiceIntegration mibsi = ManufacturingInstalledBaseServiceIntegration.getInstance();
		
		
		MetricsHandler metricsHandler = null;
		Transaction t= null;
		/*
		 * We first test the request mapping
		 */
		
		try {
			EsRequestComplexType request = null;
			request = new EsRequestComplexType();
			request.setEsRequestComplexTypeChoice(new EsRequestComplexTypeChoice());
			request.getEsRequestComplexTypeChoice().setWarrantyRequest(new WarrantyRequest());
			request.getEsRequestComplexTypeChoice().getWarrantyRequest().setSerialNumber("tmp");
			mibsi.execute(request, metricsHandler);
			
		} catch (SifException e) {
			Assert.fail("This should not have generated an exception with id"+e.getErrorID());
		}
	}
	

	/**
	 * Test method for {@link com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration#getRegionConfiguration()}.
	 */
	@Test
	public void testGetName() {
		ManufacturingInstalledBaseServiceIntegration mibsi = ManufacturingInstalledBaseServiceIntegration.getInstance();
		
		Assert.assertEquals("class com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration-snr",mibsi.getName());

	}
	
	
	
	/**
	 * Test method for {@link com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration#getRegionConfiguration()}.
	 */
	@Test
	public void testGetRegionConfiguration() {
		ManufacturingInstalledBaseServiceIntegration mibsi = ManufacturingInstalledBaseServiceIntegration.getInstance();
		RegionConfiguration rc = mibsi.getRegionConfiguration();
		Assert.assertNull(rc.getFailoverUrl());
		Assert.assertEquals("http://d9w0331g.houston.hp.com/WWSNR/ManufacturingInstalledBase/ManufacturingInstalledBaseService.svc",rc.getMainUrl());
		Assert.assertEquals(14000,rc.getMainConnectionTimeout());

	}
	
	/**
	 * Test method for {@link com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration#getRegionName()}.
	 */
	@Test
	public void testGetRegionName() {
		ManufacturingInstalledBaseServiceIntegration mibsi = ManufacturingInstalledBaseServiceIntegration.getInstance();

		
		Assert.assertEquals("snr",mibsi.getRegionName());

	}
	
	/**
	 * Test method for {@link com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration#getRegionName()}.
	 */
	@Test
	public void testGetRegionDisplayName() {
		ManufacturingInstalledBaseServiceIntegration mibsi = ManufacturingInstalledBaseServiceIntegration.getInstance();
		
		Assert.assertEquals("SNR",mibsi.getRegionDisplayName());

	}
	
	/**
	 * Test method for {@link com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration#getRegionName()}.
	 */
	@Test
	public void testIsLocal() {
		ManufacturingInstalledBaseServiceIntegration mibsi = ManufacturingInstalledBaseServiceIntegration.getInstance();
		
		Assert.assertEquals(true,mibsi.isLocal());

	}
	
	/**
	 * Test method for {@link com.hp.es.service.manufacturingHeaderInformation.integration.ManufacturingInstalledBaseServiceIntegration#getRegionName()}.
	 */
	@Test
	public void testIsRegionInFailoverMode() {
		ManufacturingInstalledBaseServiceIntegration mibsi = ManufacturingInstalledBaseServiceIntegration.getInstance();
		
		Assert.assertEquals(false,mibsi.isRegionInFailoverMode());

	}


	
}
