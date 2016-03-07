/**
 * 
 */
package com.hp.es.service.contractSummary.integration.mapping;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCONTRACTSUMES10Response;
import com.hp.es.service.contractSummary.adapters.metrogenerated.ZES_CONTRACT_SUM_ES10.ZESCQSCONTACTSUM;
import com.hp.es.service.contractSummary.keys.CSContactKey;
import com.hp.es.service.contractSummary.orchestration.ContractSummaryTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ContactComplexType;


/**
 * @author yesilyur
 *
 */
public class MetroCSContactMapper  extends CSContactMapper{

	/**
	 * 
	 */
	MetroCSContactMapper(ContractSummaryTransaction transaction, XMLIdGenerator XMLIdGenerator) {
	       super(transaction,XMLIdGenerator);
	}

	ContactComplexType[] map() throws MappingException {

    	if(_transaction == null) {
    		return new ContactComplexType[0];
    	}
    	Collection sapContacts = null;
    	ContactComplexType[] contacts = null;
    	ZESCONTRACTSUMES10Response cqsResponse = (ZESCONTRACTSUMES10Response)_transaction.getSourceSystemStandardReply();
    	if(cqsResponse.getCONTACTS() != null){
        	sapContacts =cqsResponse.getCONTACTS().getItem();
        	contacts = new ContactComplexType[sapContacts.size()];    		
    	}else{
    		return new ContactComplexType[0];    		
    	}

        ESLog.debug("Mapping " + contacts.length + " contacts ...");
        int i=0;
        for (Iterator it=sapContacts.iterator(); it.hasNext(); ) {
            contacts[i++] = mapContact((ZESCQSCONTACTSUM) it.next());
        }
        return contacts;
	}

	
    protected ContactComplexType mapContact(ZESCQSCONTACTSUM input) throws MappingException {
    	ESLog.debug("Mapping Contact ");
        ContactComplexType contact = new ContactComplexType();
        contact.setId(_XMLIdGenerator.nextId());

        contact.setSourcePersonID(input.getSOURCEPERSONID());
        contact.setEmailAddress(MappingUtils.nullString(input.getEMAILADDRESS()));
        contact.setFaxNumber(MappingUtils.nullString(input.getFAXNUMBER()));
        contact.setFullName(MappingUtils.nullString(input.getFULLNAME()));
        contact.setPhoneNumber(MappingUtils.nullString(input.getPHONENUMBER()));
        
        if(_ctx != null) {
        	CSContactKey key = new CSContactKey(contact.getSourcePersonID());
        	_ctx.addContact(key, contact);
        }
       
        return contact;
    }
	
}
