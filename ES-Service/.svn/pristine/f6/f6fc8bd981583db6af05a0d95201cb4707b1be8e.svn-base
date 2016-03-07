package com.hp.es.service.contractEntitlement.integration.mapping;

import java.util.Collection;
import java.util.Iterator;

import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSCONTACT;
import com.hp.es.service.contractEntitlement.adapters.metrogenerated.CONTRACT_ENT.ZESCQSENTITLEMENTREPLYV1;
import com.hp.es.service.contractEntitlement.keys.ContactKey;
import com.hp.es.service.contractEntitlement.orchestration.ContractTransaction;
import com.hp.es.service.util.ESLog;
import com.hp.es.service.util.MappingUtils;
import com.hp.es.service.util.XMLIdGenerator;
import com.hp.es.service.util.exception.MappingException;
import com.hp.es.xml.service.ContactComplexType;

class MetroContactMapper extends ContactMapper{



    MetroContactMapper(ContractTransaction transaction, XMLIdGenerator XMLIdGenerator) {
       super(transaction,XMLIdGenerator);
    }

    ContactComplexType[] map() throws MappingException {

    	if(_transaction == null) {
    		return new ContactComplexType[0];
    	}

    	Collection sapContacts =((ZESCQSENTITLEMENTREPLYV1)_transaction.getSourceSystemStandardReply()).getCONTACTS().getItem();
        ContactComplexType[] contacts = new ContactComplexType[sapContacts.size()];

        ESLog.debug("Mapping " + contacts.length + " contacts ...");
        int i=0;
        for (Iterator it=sapContacts.iterator(); it.hasNext(); ) {
            contacts[i++] = mapContact((ZESCQSCONTACT) it.next());
        }
        return contacts;
    }

    protected ContactComplexType mapContact(ZESCQSCONTACT input) throws MappingException {
    	ESLog.debug("Mapping Contact ");
        ContactComplexType contact = new ContactComplexType();
        contact.setId(_XMLIdGenerator.nextId());

        contact.setSourcePersonID(input.getSOURCEPERSONID());
        contact.setEmailAddress(MappingUtils.nullString(input.getEMAILADDRESS()));
        contact.setFaxNumber(MappingUtils.nullString(input.getFAXNUMBER()));
        contact.setFullName(MappingUtils.nullString(input.getFULLNAME()));
        contact.setPhoneNumber(MappingUtils.nullString(input.getPHONENUMBER()));
        
        if(_ctx != null) {
        	ContactKey key = new ContactKey(contact.getSourcePersonID());
        	_ctx.addContact(key, contact);
        }
       
        return contact;
    }

}
