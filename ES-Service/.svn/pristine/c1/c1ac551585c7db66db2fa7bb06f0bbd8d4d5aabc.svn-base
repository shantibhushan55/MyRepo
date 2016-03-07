package com.hp.es.service.warrantyEntitlement.orchestration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.ErrorFactory;
import com.hp.es.xml.service.EsReply;
import com.hp.es.xml.service.EsRequestComplexType;
import com.hp.es.xml.service.Warnings;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.config.ReadOnlyProperties;
import com.hp.sif.SifException;

public class WarrantyDeterminationCode implements ConfigChangeListener {
	
    //default priority is also configurable in det code priority properties file
    private int _defaultPriority = 100;
    
    ReadOnlyProperties _mappingProperties = null; 
    ReadOnlyProperties _priorityProperties = null;
    
	private static WarrantyDeterminationCode _instance = new WarrantyDeterminationCode();
	
	private WarrantyDeterminationCode() {
		super();
		// add the class to the config listener to watch the files WarrantyDeterminationCodeTable.properties and WarrantyDeterminationCodePriority.properties
        Configuration.getInstance().addConfigChangeListener(EsConstants.WARRANTY_DETERMINATION_CODE_TABLE_PROPERTIES_FILENAME, this);
        Configuration.getInstance().addConfigChangeListener(EsConstants.WARRANTY_DETERMINATION_CODE_PRIORITY_PROPERTIES_FILENAME, this);
	}

	/*
	 * A method returning the skeleton
	 * 
	 */
	public static WarrantyDeterminationCode getInstance() {

		return _instance;
		
	}

	public EsReply getHighestPriority(ArrayList replies, EsRequestComplexType request) throws SifException {
		/*
		 * When a single unit is found, 
		 * ES picks up the IB warranty response 
		 * with the determination code of highest priority and returns it. 
		 * If all IB warranty responses have the same determination code, ES picks up one randomly. If more than one IB warranty responses are associated to the same unit, 
		 * the warning 435: �this unit is tracked in multiple SWOP instances� is generated.
		 */ 
		
		if(replies == null || replies.size() == 0)
		{
			ESLog.info("No valid transaction found");
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "Incorrect usage of getHigestPriority");
		}
		
		// if size=1, use it.
		if(replies.size() == 1)
		{
			Transaction tr = (Transaction)replies.get(0);
			if((tr != null && tr.getMappedReply() != null) &&
					(tr.getMappedReply().getEsReplyChoice() != null) && 
					(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement() != null) &&
					(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS() != null) && 
					(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getWarranty().length > 0) &&
					(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getWarranty(0)) != null) {
				if (tr instanceof WarrantyTransaction)
					((WarrantyTransaction)tr).setEsReplyChoice(true);
				return tr.getMappedReply();
			} else {
				ESLog.info("No valid transaction found");
				throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "Incorrect usage of getHigestPriority");
			}
		}
		
		List<Transaction> transListWithOOSKey = new ArrayList<Transaction>();
		List<Transaction> transListWithReqCountryCode = new ArrayList<Transaction>();

		Iterator iter = replies.iterator();
		while(iter.hasNext()) {
			Transaction tr = (Transaction)iter.next();
			if((tr != null && tr.getMappedReply() != null) &&
			(tr.getMappedReply().getEsReplyChoice() != null) && 
			(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement() != null) &&
			(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS() != null)) {
				if(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getOOSKey() != null && !"".equals(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getOOSKey())) {
					transListWithOOSKey.add(tr);
					
					if((tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getShipToCountry() != null) &&
						(request != null && request.getEsRequestComplexTypeChoice() != null) && 
						(request.getEsRequestComplexTypeChoice().getWarrantyRequest() != null) &&
						(request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIsoCountryCd() != null)) {
						if(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getShipToCountry().equalsIgnoreCase(request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIsoCountryCd())) {
							transListWithReqCountryCode.add(tr);
						}
					}
				}
			}
		}
		
		// if 1 warranty response with OOS key, use it.
		boolean includeWarning = false;
		if(transListWithOOSKey != null && transListWithOOSKey.size() == 1) {
			Transaction tr = (Transaction)transListWithOOSKey.get(0);
			if (tr instanceof WarrantyTransaction)
	            ((WarrantyTransaction)tr).setEsReplyChoice(true);
			return tr.getMappedReply();
		} else if(transListWithOOSKey != null && transListWithOOSKey.size() > 1) {
			// if multiple responses with OOS key, warning message 435
			includeWarning = true;
		}
		
		// if 1 warranty response (with OOSKey) with requested ship-to ctry code, use it
		if(transListWithReqCountryCode != null && transListWithReqCountryCode.size() == 1) {
			Transaction tr = (Transaction)transListWithReqCountryCode.get(0);
			if (tr instanceof WarrantyTransaction)
	            ((WarrantyTransaction)tr).setEsReplyChoice(true);
			
			EsReply reply = tr.getMappedReply();
			if(includeWarning) {
				if(reply.getEsHeader().getWarnings() == null) {
					reply.getEsHeader().setWarnings(new Warnings());
				}
				reply.getEsHeader().getWarnings().addEIAError(ErrorFactory.getEIAError(ErrorFactory.id435_UNIT_TRACKED_IN_SEVERAL_SWOP));
			}
			return reply;
		}
		
		// if multiple responses with correct ship-to ctry code, remove response with incorrect ship-to ctry code
		if(transListWithReqCountryCode != null && transListWithReqCountryCode.size() > 1) {
			for(Iterator<Transaction> it = replies.iterator(); it.hasNext();) {
				Transaction tr = (Transaction)it.next();
				if(!((tr != null && tr.getMappedReply() != null) &&
					(tr.getMappedReply().getEsReplyChoice() != null) && 
					(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement() != null) &&
					(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS() != null) &&
					(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getShipToCountry() != null) &&
					(request != null && request.getEsRequestComplexTypeChoice() != null) &&
					(request.getEsRequestComplexTypeChoice().getWarrantyRequest() != null) &&
					(request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIsoCountryCd() != null) &&
					(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS().getShipToCountry().equalsIgnoreCase(request.getEsRequestComplexTypeChoice().getWarrantyRequest().getIsoCountryCd())))) {
					it.remove();
				}
			}
		}
		
		int currentPriority = 1000;
		Transaction highestPriorityTransaction = null;
		boolean duplicatePriority = false;
		ESLog.debug("Will try to find highest priority");
		if(replies != null) {
			Iterator it = replies.iterator();
			
			while(it.hasNext()) {
				Transaction tr = (Transaction)it.next();
				if((tr != null) && (tr.getMappedReply() != null) &&
				(tr.getMappedReply().getEsReplyChoice() != null) && 
				(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement() != null) &&
				(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getWarranty() != null) &&
				(tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getWarranty().length > 0)) {
					//We take the first warranty record
					if((tr.getMappedReply()).getEsReplyChoice().getWarrantyEntitlement().getWarranty(0) != null && tr.getMappedReply().getEsReplyChoice().getWarrantyEntitlement().getOOS() != null) {
						
						
						String detCode = (tr.getMappedReply()).getEsReplyChoice().getWarrantyEntitlement().getWarranty(0).getWarrantyDeterminationCode();
						ESLog.debug("Using determnination code: " + detCode);
                        //the determination code is checked only for != null, but it should also be checked for an empty string.
						if (detCode != null && detCode.trim().length() != 0) {
							// set the current priority to DEFAULT
							int retrievedPriority = _defaultPriority;
							if (_priorityProperties != null && _priorityProperties.getIntegerProperty(detCode.trim()) != null) {
                                retrievedPriority = _priorityProperties.getIntegerProperty(detCode.trim()).intValue();
                            } 
							ESLog.debug("Using priority '" + retrievedPriority + "' for determnination code: " + detCode);
							// getting the highest priority
							// Note the highest priority is 1 and the lowest priority is _defaultPriority
							if(currentPriority > retrievedPriority) {
								// the retrieved priority is higher then the current priority and
								// store the transaction
								currentPriority = retrievedPriority;
								highestPriorityTransaction = tr;
							}
							else if(currentPriority == retrievedPriority) {
								// if we have the same priority then we just set the flag
								// that we have duplicates
								duplicatePriority = true;
							} 
						} 
					}
				}
			}
		}
//		ESLog.debug("We found the highest priority: " + currentPriority + ", this is a duplicate id: " + duplicatePriority);
		ESLog.debug("We found the highest priority: " + currentPriority);
		if(highestPriorityTransaction == null ) {
			ESLog.info("No highest priority transaction found");
			throw ErrorFactory.getSifException(ErrorFactory.id9999_INTERNAL_ERROR, "Incorrect usage of getHigestPriority");
		}
		EsReply reply = highestPriorityTransaction.getMappedReply();
		
        // set the esReplyChoice with true to indicate this tranasction is selected as final es reply.
        if (highestPriorityTransaction instanceof WarrantyTransaction)
            ((WarrantyTransaction) highestPriorityTransaction).setEsReplyChoice(true);
        
		// If we have duplicate, we need to create a warning 435
		if(includeWarning || duplicatePriority) {	
			if(reply.getEsHeader().getWarnings() == null) {
				reply.getEsHeader().setWarnings(new Warnings());
			}
			reply.getEsHeader().getWarnings().addEIAError(ErrorFactory.getEIAError(ErrorFactory.id435_UNIT_TRACKED_IN_SEVERAL_SWOP));
		}
		
		return reply;
	}


	/* (non-Javadoc)
	 * @see com.hp.ruc.config.ConfigChangeListener#configChanged(com.hp.ruc.config.ConfigChangeEvent)
	 */
	public void configChanged(ConfigChangeEvent event) {
        if (event != null && event.getNewConfig() != null) {
            ESLog.info("(Re-)load configuration");
            if (EsConstants.WARRANTY_DETERMINATION_CODE_TABLE_PROPERTIES_FILENAME.equals(event.getConfigName()))
                _mappingProperties = event.getNewConfig();
            else if (EsConstants.WARRANTY_DETERMINATION_CODE_PRIORITY_PROPERTIES_FILENAME.equals(event.getConfigName())) {
                _priorityProperties = event.getNewConfig();                
                if (_priorityProperties != null && _priorityProperties.getIntegerProperty("default") != null)
                    _defaultPriority = _priorityProperties.getIntegerProperty("default").intValue();
            }
        }
    }

	/**
	 * getWarrantyDeterminationCode
	 * @param sourceDateForWarrantyStart
	 * @return
	 */
	public String getWarrantyDeterminationCode(String sourceDateForWarrantyStart) {
		if(_mappingProperties == null) {
            return "";
		} else { 
			if(_mappingProperties.getProperty(sourceDateForWarrantyStart) == null) {
				return "";
			} else {
				return _mappingProperties.getProperty(sourceDateForWarrantyStart);
			}
		}
	}
	
	/**
	 * getWarrantyDeterminationDescription
	 * @param sourceDateForWarrantyStart
	 * @return
	 */
	public String getWarrantyDeterminationDescription(String sourceDateForWarrantyStart) {
		if(_mappingProperties == null) {
            return "";
		} else {
			if(_mappingProperties.getProperty(sourceDateForWarrantyStart + ".description") == null) {
				return "";
			} else { 
				return _mappingProperties.getProperty(sourceDateForWarrantyStart + ".description");
			}
		}
	}
	
}
