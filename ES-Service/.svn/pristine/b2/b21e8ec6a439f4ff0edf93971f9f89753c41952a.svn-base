/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.manufacturingHeaderInformation.integration;

import java.util.ArrayList;
import java.util.List;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ManufacturingBillOfMaterialRequest;
import com.hp.es.service.manufacturingHeaderInformation.adapters.metrogenerated.ManufacturingInstalledBaseService.ProductBillOfMaterial;
import com.hp.es.service.manufacturingHeaderInformation.integration.mapping.ManufacturingInstalledBaseServiceComplexTypeMetroManufacturingInstalledBaseServiceComplexTypeMapper;
import com.hp.es.service.manufacturingHeaderInformation.integration.mapping.ManufacturingInstalledBaseServiceHeaderMapper;
import com.hp.es.service.manufacturingHeaderInformation.integration.mapping.ManufacturingInstalledBaseServiceMetroErrrorMapper;
import com.hp.es.service.manufacturingHeaderInformation.integration.mapping.ManufacturingInstalledBaseServiceRequestMapper;
import com.hp.es.service.manufacturingHeaderInformation.integration.mapping.ManufacturingInstalledBaseServiceUnitListComplexTypeMapper;
import com.hp.es.service.manufacturingHeaderInformation.orchestration.ManufacturingInstalledBaseServiceTransaction;
import com.hp.es.service.manufacturingHeaderInformation.orchestration.SnrRegion;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsEntry;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;



public class ManufacturingInstalledBaseServiceIntegration implements IntegrationInterface {

	protected static ManufacturingInstalledBaseServiceIntegration _instance = new ManufacturingInstalledBaseServiceIntegration();
	protected SnrRegion _region = null;
	
	protected ManufacturingInstalledBaseServiceIntegration() {
		RegionConfiguration regionConfig = null; 

	    try {
	        regionConfig = new RegionConfiguration(Configuration.getInstance().getProperties(), EsConstants.SNR_PROP_PREFIX + ".");
	        _region = SnrRegion.getInstance((RegionConfiguration) regionConfig);
	    } catch (Exception e) {
	        ESLog.error("Failed to load the configuration for SNR.", e);
	        _region= null;
	    }
	  
	}

	
	
	/**
	 * getInstance
	 * @return the instance
	 */
	public static ManufacturingInstalledBaseServiceIntegration getInstance() {
		return _instance;
	}	



	
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */
	public Transaction execute(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		ESLog.debug("Entering ManufacturingInstalledBase Service Integration");
		MetricsEntry entry = null;
        if (metricsHandler!=null) {
        	entry = metricsHandler.addEntry("ManufacturingInstalledBaseServiceIntegration.execute()");
        }
		try {
			return callSNR(request, metricsHandler);
		}finally {
            if (entry!=null)
                entry.actionDone();
		}
	}

	/*
	 * Inherited method from the interface
	 */
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getName()
	 */

	public String getRegionName() {
		return _region.getConfiguration().getRegionName();
	}
	
	public RegionConfiguration getRegionConfiguration() {
		return _region.getConfiguration();
	}
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getName()
	 */
	public String getName() {
		return this.getClass().toString() + "-" + _region.getConfiguration().getRegionName();
	}	
	

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#isRegionInFailoverMode()
	 */
	public boolean isRegionInFailoverMode() {
		/*
		 * SNR have no failover
		 */
		return false;
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getRegionDisplayName()
	 */
	public String getRegionDisplayName() {
		return "SNR";
	}

	public boolean isLocal() {
		return true;
	}
	
	/** 
	 * callRegion 
	 * @param request
	 * @param metricsHandler
	 * @return
	 * @throws SifException
	 */
	protected Transaction callSNR(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		
		ESLog.debug("Mapping ES request to SNR request");
		// map ES request to SWOP request
		
		
		// pass request to the region and get the result
		Transaction transaction = null;
		try {
			ManufacturingBillOfMaterialRequest  snrMfgRequest = mapEsRequest2SnrManufacturingServiceRequest(request);
			ESLog.debug("Send request to SNR using Region: " );
			transaction = _region.execute(EsConstants.FUNCTION_NAME_SNR_MFG,snrMfgRequest, getRegionDisplayName(),isLocal(), metricsHandler);
		}catch(SifException e) {
			ESLog.debug("SifException while processing SNR request, stack trace", e);				
			throw e;
		}	catch (Exception e) {
			// No need to print something that was printed twice already
			ESLog.error("Exception while connecting to SNR Manufacturing Service"+ e.getMessage());
			ESLog.debug("Exception while connecting to SNR, stack trace", e);				
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Exception while connecting to SNR", e.toString());
		}
				
		// Check which reply we have error, unit list, or normal reply
		if(transaction.isSourceSystemError()) {
			ESLog.debug("We have SNR Manufacturing Servic errors ...");
			// Unit event history ERRORS
			mapSnrManufacturingServiceError2EsErrors((ManufacturingInstalledBaseServiceTransaction)transaction);
		} else if (transaction instanceof ErrorTransaction) {
			ESLog.debug("We have an ErrorTransaction ...");
			// THROWABLE
			// There is no need to do anything here, it will be done in the composition layer
			// so we simply return the transaction
			mapErrorTransaction2EsErrors((ErrorTransaction)transaction);
		} else {
			EsReply esReply = null;// new EsReply();
			ManufacturingInstalledBaseServiceTransaction mibTx = (ManufacturingInstalledBaseServiceTransaction)transaction;

			
			if(transaction.isSourceSystemUnitList()) {
				 	esReply = mapManufacturingServiceUnitListReply2ESUnitListReply(mibTx.getSourceSystemUnitList());
			}else {
				ESLog.debug("We have a SNR Manufacturing Service to an ES reply");
				// STANDARD REPLY
				esReply = mapManufacturingServiceReply2ESReply(mibTx.getSourceSystemStandardReply());
			}
			ManufacturingInstalledBaseServiceHeaderMapper headerMapper = new ManufacturingInstalledBaseServiceHeaderMapper(request,mibTx);
			try {
				esReply.setEsHeader(headerMapper.map());
			} catch (MappingException e) {
				ESLog.error("Issue in mapping ES header for MIB reply", e);
	            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
	            		"Issue when mapping SNR data", e.toString());
			}
			transaction.setMappedReply(esReply);
		}
		return transaction;
	}





	/**
	 * mapEsRequest2IBRequest mapping the ES request to the Unit Event History request
	 * @param request
	 * @return
	 * @throws SifException 
	 */
	protected ManufacturingBillOfMaterialRequest mapEsRequest2SnrManufacturingServiceRequest(EsRequestComplexType request) throws SifException {
		ManufacturingInstalledBaseServiceRequestMapper rm = ManufacturingInstalledBaseServiceRequestMapper.getInstance(request);
		return rm.map();
	}

	
	
	/*
	 * Map to a Unit List
	 */
	protected EsReply  mapManufacturingServiceUnitListReply2ESUnitListReply(List<ProductBillOfMaterial> listProductBillOfMaterial) throws SifException {
		ESLog.debug("Creating EsReply for a SNR Manufacturing Service Unit List ...");
		EsReply esReply = new EsReply();
		
		try {
			
			ManufacturingInstalledBaseServiceUnitListComplexTypeMapper  snrUnitListMfgMapper = ManufacturingInstalledBaseServiceUnitListComplexTypeMapper.getInstance();
			
			esReply.setEsReplyChoice(new EsReplyChoice());
			esReply.getEsReplyChoice().setUnitList(snrUnitListMfgMapper.map(listProductBillOfMaterial));
			
		} catch (com.hp.es.service.util.exception.MappingException e) {
			ESLog.error("Mapping Exception", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Unknown Mapping Exception", e.toString());
		}
		// add EsReply to reply
		ESLog.debug("Setting the EsReply (which is containing the IB UnitList) in the transaction ...");
		return esReply;
		
	}
	
	
	/**
	 * mapSnrmanufacturingServiceReply2ESReply
	 * @param transaction
	 * @param request
	 * @throws SifException 
	 */
	protected EsReply mapManufacturingServiceReply2ESReply(ProductBillOfMaterial pBOM) throws SifException {
		ESLog.debug("Creating EsReply for a SNR Manufacturing Service Unit List ...");
		EsReply esReply = new EsReply();
		try {
			ESLog.debug("Setting the header in the EsReply ...");
			// get the swop reply
			ESLog.debug("Mapping the SNR Manufacturing Service  reply into the MetroManufacturingInstalledBaseServiceComplexTypeMapper ...");
			ManufacturingInstalledBaseServiceComplexTypeMetroManufacturingInstalledBaseServiceComplexTypeMapper  snrMfgMapper = ManufacturingInstalledBaseServiceComplexTypeMetroManufacturingInstalledBaseServiceComplexTypeMapper.getInstance();
			esReply.setEsReplyChoice(new EsReplyChoice());
			esReply.getEsReplyChoice().setManufacturingInstalledBaseHeader(snrMfgMapper.map(pBOM));
			
		} catch (com.hp.es.service.util.exception.MappingException e) {
			ESLog.error("Mapping Exception", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Unknown Mapping Exception", e.toString());
		}
		return esReply;
	}

	/**
	 * mapThrowable2EsErrors maps the received throwable into a SIF exception
	 * @param transaction
	 */
	protected void mapErrorTransaction2EsErrors(ErrorTransaction transaction) {
		ESLog.debug("Mapping a Unit history throwable to a ES error (SifException)");
		// getting the throwable
		Throwable throwable = transaction.getSourceSystemThrowable();
		ArrayList<SifException> errorList = new ArrayList<SifException>();
		// checking which type it is
		if(throwable instanceof SifException) {
			// convert the throwable into a SifException
			ESLog.debug("We have a SifException");
			errorList.add((SifException) throwable);
		} else {
			// create a new SifException because an unknown error occured
			ESLog.debug("We have another Exception, create an internal SifException");
			errorList.add(ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, throwable.toString()));
		}
		// adding it to the mappedErrors collection
		ESLog.debug("Add the SifException to the mapped errors list");
		transaction.setMappedErrors(errorList);
	}

	/**
	 * mapIBError2EsErrors maps the IB errors to ES errors and sets it in the 
	 * mapped error object of the transaction
	 * @param transaction (in/out)
	 * @throws SifException 
	 */
	protected void mapSnrManufacturingServiceError2EsErrors(ManufacturingInstalledBaseServiceTransaction transaction) throws SifException {
		ESLog.debug("Creating ES Error List ...");
		ArrayList<SifException> esErrors = null;
		
		try {
			ManufacturingInstalledBaseServiceMetroErrrorMapper em = ManufacturingInstalledBaseServiceMetroErrrorMapper.getInstance();
			
			esErrors = em.map(transaction.getSourceSystemErrors());
		} catch (MappingException e) {
			ESLog.error("Mapping Exception", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Unknown Mapping Exception", e.toString());
		}
		
		ESLog.debug("Setting the ES errors in the transaction ...");
		transaction.setMappedErrors(esErrors);
	}



}
