/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.unitEventHistory.integration;

import java.util.ArrayList;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.Region;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.unitEventHistory.integration.mapping.ErrorMapper;
import com.hp.es.service.unitEventHistory.integration.mapping.RequestMapper;
import com.hp.es.service.unitEventHistory.integration.mapping.UnitEventHistoryComplexTypeMapper;
import com.hp.es.service.unitEventHistory.integration.mapping.UnitEventHistoryHeaderMapper;
import com.hp.es.service.unitEventHistory.orchestration.UnitEventHistoryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;


public class UnitEventHistoryIntegration implements IntegrationInterface {

	protected boolean _isLocal = false;
	protected Region _region = null;
	private static UnitEventHistoryIntegration _instance = null;
	private String _regionName = null;

	/**
	 * getInstance
	 * @return
	 */
	public synchronized static UnitEventHistoryIntegration getInstance() { 
		if(_instance == null) {
			_instance = new UnitEventHistoryIntegration();
		}
		return _instance;
	}	
	
	private UnitEventHistoryIntegration() {
		_isLocal = true;
		_region = RegionFactory.getInstance().getLocalRegion();
	}
	
	public UnitEventHistoryIntegration(String regionName) {
		_regionName=regionName;
        _region = RegionFactory.getInstance().getRegionByName(regionName);
        _isLocal = regionName.equals(_region.getConfiguration().getRegionName());
	}


	
	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#execute(com.hp.es.xml.service.EsRequestComplexType, com.hp.ruc.metrics.MetricsHandler)
	 */
	public Transaction execute(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		ESLog.debug("Entering Unit Warranty integration");
		return callRegion(request, metricsHandler);
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getName()
	 */
	public String getName() {
		return this.getClass().toString() + "-" + _region.getConfiguration().getRegionName();
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getRegionConfiguration()
	 */
	public RegionConfiguration getRegionConfiguration() {
		return _region.getConfiguration();
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#isRegionInFailoverMode()
	 */
	public boolean isRegionInFailoverMode() {
		return _region.inFailoverMode();
	}

	/* (non-Javadoc)
	 * @see com.hp.es.service.IntegrationInterface#getRegionDisplayName()
	 */
	public String getRegionDisplayName() {
		return EsConstants.SWOP_SYSTEM_NAME +" "+ _region.getConfiguration().getRegionName();
	}

	public boolean isLocal() {
		return _isLocal;
	}
	
	/** 
	 * callRegion 
	 * @param request
	 * @param metricsHandler
	 * @return
	 * @throws SifException
	 */
	private Transaction callRegion(EsRequestComplexType request, MetricsHandler metricsHandler) throws SifException {
		
		ESLog.debug("Mapping ES request to Unit Event History request");
		// map ES request to SWOP request
		Object  unitEventHistoryrequest = mapEsRequest2UnitEventHistoryRequest(request);
		
		// pass request to the region and get the result
		Transaction transaction = null;
		try {
			ESLog.debug("Send request to SWOP using Region: " + _region.getConfiguration().getRegionName());
			transaction = _region.execute(EsConstants.SAP_FUNCTION_NAME_UNITEVENTHISTORY, 
					unitEventHistoryrequest, getRegionDisplayName(),isLocal(), metricsHandler);
		} catch (Exception e) {
			
			if( e instanceof SifException) {
				ESLog.debug("SifException while processing SWOP request, stack trace", e);				

				throw (SifException) e;
			}else {
				// No need to print soimething that was printed twice already
				ESLog.error("Exception while connecting to SWOP Unit history"+ e.getMessage());
				ESLog.debug("Exception while connecting to SWOP, stack trace", e);				
			}
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Exception while connecting to IB (SWOP)", e.toString());
		}
				
		// Check which reply we have error, unit list, or normal reply
		if(transaction.isSourceSystemError()) {
			ESLog.debug("We have UnitEventHistory (SWOP) errors ...");
			// Unit event history ERRORS
			mapUnitEventHistoryError2EsErrors((UnitEventHistoryTransaction)transaction, request);
		} else if (transaction instanceof ErrorTransaction) {
			ESLog.debug("We have an ErrorTransaction ...");
			// THROWABLE
			// There is no need to do anything here, it will be done in the composition layer
			// so we simply return the transaction
			mapErrorTransaction2EsErrors((ErrorTransaction)transaction);
		} else {
			ESLog.debug("We have a Unit event history to an ES reply");
			// UNIT LIST
			mapUnitEventHistoryReply2ESReply((UnitEventHistoryTransaction)transaction, request);
		}
		return transaction;
	}

	/**
	 * mapEsRequest2IBRequest mapping the ES request to the Unit Event History request
	 * @param request
	 * @return
	 */
	private Object mapEsRequest2UnitEventHistoryRequest(EsRequestComplexType request) {
		RequestMapper rm = RequestMapper.getInstance(request);
		return rm.map();
	}

	/**
	 * mapIBReply2UnitList
	 * @param transaction
	 * @param request
	 * @throws SifException 
	 */
	private void mapUnitEventHistoryReply2ESReply(UnitEventHistoryTransaction transaction, EsRequestComplexType request) throws SifException {
		ESLog.debug("Creating EsReply for a UnitEventHistory Unit List ...");
		EsReply esReply = new EsReply();
		try {
			/*
			 * Map ES Header then
			 * UnitEventHistoryComplexType
			 * then create list of UnitEvent
			 * then in UnitEvent create list of EventDetails
			 * in EventDetails, we'll have extra structure, documented in the mapper itself
			 */
			// setting header
			
			
			ESLog.debug("Setting the header in the EsReply ...");
			UnitEventHistoryHeaderMapper headerMapper = new UnitEventHistoryHeaderMapper(request, transaction);
			esReply.setEsHeader(headerMapper.map());
			
			
			// get the swop reply
			ESLog.debug("Mapping the UHE reply into the UnitEventHistoryComplexType ...");
			UnitEventHistoryComplexTypeMapper uehMapper = UnitEventHistoryComplexTypeMapper.getInstance(transaction);
			esReply.setEsReplyChoice(new EsReplyChoice());
			esReply.getEsReplyChoice().setUnitEventHistory(uehMapper.map());
		} catch (com.hp.es.service.util.exception.MappingException e) {
			ESLog.error("Mapping Exception", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Unknown Mapping Exception", e.toString());
		}
		// add EsReply to reply
		ESLog.debug("Setting the EsReply (which is containing the IB UnitList) in the transaction ...");
		transaction.setMappedReply(esReply);
	}

	/**
	 * mapThrowable2EsErrors maps the received throwable into a SIF exception
	 * @param transaction
	 */
	private void mapErrorTransaction2EsErrors(ErrorTransaction transaction) {
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
	 * @param transaction
	 * @param request
	 * @throws SifException 
	 */
	private void mapUnitEventHistoryError2EsErrors(UnitEventHistoryTransaction transaction, EsRequestComplexType request) throws SifException {
		ESLog.debug("Creating ES Error List ...");
		ArrayList esErrors = null;
		
		try {
			ErrorMapper em = ErrorMapper.
				getInstance(transaction.getSourceSystemErrors(), request);
			
			esErrors = em.map();
		} catch (MappingException e) {
			ESLog.error("Mapping Exception", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Unknown Mapping Exception", e.toString());
		}
		
		ESLog.debug("Setting the ES errors in the transaction ...");
		transaction.setMappedErrors(esErrors);
	}

	public String getRegionName() {
		return _regionName;
	}

}
