/*
 * Created on Mar 17, 2006
 */
package com.hp.es.service.ibSearch.integration;

import java.util.ArrayList;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.IntegrationInterface;
import com.hp.es.service.ibSearch.integration.mapping.ErrorMapper;
import com.hp.es.service.ibSearch.integration.mapping.IBHeaderMapper;
import com.hp.es.service.ibSearch.integration.mapping.RequestMapper;
import com.hp.es.service.ibSearch.integration.mapping.UnitListMapper;
import com.hp.es.service.ibSearch.orchestration.IBSearchTransaction;
import com.hp.es.service.orchestration.ErrorTransaction;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.Region;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.RegionFactory;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsReplyChoice;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.ruc.metrics.MetricsHandler;
import com.hp.sif.SifException;

/**
 * @author JUHANK
 */
public class IBSearchIntegration implements IntegrationInterface {

	protected boolean _isLocal = false;
	protected Region _region = null;
	private static IBSearchIntegration _instance = new IBSearchIntegration();

	private IBSearchIntegration() {
		_isLocal = true;
		_region = RegionFactory.getInstance().getLocalRegion();
	}
	
	/**
	 * getInstance
	 * @return
	 */
	public  static IBSearchIntegration getInstance() { 

		return _instance;
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
		
		ESLog.debug("Mapping ES request to IB request");
		// map ES request to SWOP request
		Object ibRequest = mapEsRequest2IBRequest(request);
		
		// pass request to the region and get the result
		Transaction transaction = null;
		try {
			ESLog.debug("Send request to SWOP using Region: " + _region.getConfiguration().getRegionName());
			transaction = _region.execute(EsConstants.SAP_FUNCTION_NAME_IBSEARCH, 
									ibRequest, getRegionDisplayName(),isLocal(), metricsHandler);
		} catch (Exception e) {
			
			if( e instanceof SifException) {
				throw (SifException) e;
			}else {
				// No need to print soimething that was printed twice already
				ESLog.error("Exception while connecting to SWOP"+ e.getMessage());
				ESLog.debug("Exception while connecting to SWOP, stack trace", e);				
			}
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Exception while connecting to IB (SWOP)", e.toString());
		}
				
		// Check which reply we have error, unit list, or normal reply
		if(transaction.isSourceSystemError()) {
			ESLog.debug("We have IB (SWOP) errors ...");
			// IB ERRORS
			mapIBError2EsErrors((IBSearchTransaction)transaction, request);
		} else if (transaction instanceof ErrorTransaction) {
			ESLog.debug("We have an throwable ...");
			// THROWABLE
			// There is no need to do anything here, it will be done in the composition layer
			// so we simply return the transaction
			mapThrowable2EsErrors((ErrorTransaction)transaction);
		} else {
			ESLog.debug("We have a IB unit list ...");
			// UNIT LIST
			mapIBReply2UnitList((IBSearchTransaction)transaction, request);
		}
		return transaction;
	}

	/**
	 * mapEsRequest2IBRequest mapping the ES request to the IB request
	 * @param request
	 * @return
	 */
	private Object mapEsRequest2IBRequest(EsRequestComplexType request) {
		RequestMapper rm = RequestMapper.getInstance(request);
		return rm.map();
	}

	/**
	 * mapIBReply2UnitList
	 * @param transaction
	 * @param request
	 * @throws SifException 
	 */
	private void mapIBReply2UnitList(IBSearchTransaction transaction, EsRequestComplexType request) throws SifException {
		ESLog.debug("Creating EsReply for a IB Unit List ...");
		EsReply esReply = new EsReply();
		try {
			// setting header
			ESLog.debug("Setting the header in the EsReply ...");
			IBHeaderMapper headerMapper = new IBHeaderMapper(request, transaction);
			esReply.setEsHeader(headerMapper.map());
			
			// get the swop reply
			ESLog.debug("Mapping the IB SWOP reply into the IB Unit List ...");
			UnitListMapper unitListMapper = UnitListMapper.getInstance(transaction);
			esReply.setEsReplyChoice(new EsReplyChoice());
			esReply.getEsReplyChoice().setInstalledBaseUnitList(unitListMapper.map());
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
	private void mapThrowable2EsErrors(ErrorTransaction transaction) {
		ESLog.debug("Mapping a IB throwable to a ES error (SifException)");
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
	private void mapIBError2EsErrors(IBSearchTransaction transaction, EsRequestComplexType request) throws SifException {
		ESLog.debug("Creating ES Error List ...");
		ArrayList esErrors = null;
		try {
			ErrorMapper em = ErrorMapper.getInstance(transaction.getSourceSystemErrors(), request);
			
			esErrors = em.map();
		} catch (MappingException e) {
			ESLog.error("Mapping Exception", e);
            throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, 
            		"Unknown Mapping Exception", e.toString());
		}
		ESLog.debug("Setting the ES errors in the transaction ...");
		transaction.setMappedErrors(esErrors);
	}

}
