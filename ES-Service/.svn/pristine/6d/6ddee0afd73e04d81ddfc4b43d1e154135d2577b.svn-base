package com.hp.es.service.routingDetails.orchestration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.orchestration.Transaction;
import com.hp.es.service.orchestration.sap.RegionConfiguration;
import com.hp.es.service.orchestration.sap.SapSOAPReply;
import com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESCQSMESSAGE;
import com.hp.es.service.routingDetails.adapters.metrogenerated.ZES_ROUTING_DETAILS_ES10.ZESROUTINGDETAILSES10Response;

/**
 * @author Chunyang
 * @since 9.0.2
 */
public class RoutingDetailsTransaction extends Transaction {

    public RoutingDetailsTransaction(RegionConfiguration config, boolean failoverMode, Object sourceReply,
            String functionName, String displayName, boolean isLocal) {
        super(config, failoverMode, sourceReply, functionName, displayName, isLocal);
    }

    public boolean isSourceSystemStandardReply() {
        if (isSourceSystemError()) 
            return false;
        
            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            if (reply.getSoapCastorReply() instanceof ZESROUTINGDETAILSES10Response) {
                ZESROUTINGDETAILSES10Response out = (ZESROUTINGDETAILSES10Response) reply.getSoapCastorReply();
                return isSuccess(out.getROUTINGDETAILS().getPROCSTATE());
            }
            return false;
    }

    public Object getSourceSystemStandardReply() {
            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            if (!isSourceSystemError()) {
                if (reply.getSoapCastorReply() instanceof ZESROUTINGDETAILSES10Response) {
                    ZESROUTINGDETAILSES10Response out = (ZESROUTINGDETAILSES10Response) reply.getSoapCastorReply();
                    return out.getROUTINGDETAILS();
                }
            }
			
        return null;
    }

    public boolean isSourceSystemError() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if (reply != null) {
            if (reply.getSoapCastorReply() instanceof ZESROUTINGDETAILSES10Response) {
                ZESROUTINGDETAILSES10Response out = (ZESROUTINGDETAILSES10Response) reply.getSoapCastorReply();
                return !isSuccess(out.getROUTINGDETAILS().getPROCSTATE());
            }
        }
        return true;
    }

    public Collection getSourceSystemErrors() {

        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if (isSourceSystemError()) {
            if (reply.getSoapCastorReply() instanceof ZESROUTINGDETAILSES10Response) {
                ZESROUTINGDETAILSES10Response out = (ZESROUTINGDETAILSES10Response) reply.getSoapCastorReply();
                return getOnlySourceSystemErrors(out.getROUTINGDETAILS().getMESSAGES().getItem());
            }
        }
        return null;
    }

    
    /**
     * Extract only the error out of the list of errors. The warning will be extracted later on The sucess messwage is
     * discarded
     * 
     * @param the
     *            Collection
     * @return a new Collection
     */
    private Collection getOnlySourceSystemErrors(Collection messages) {
        ArrayList list = new ArrayList();
        Iterator iterator = messages.iterator();
        while (iterator.hasNext()) {
            Object tmp = iterator.next();

                if (tmp instanceof ZESCQSMESSAGE) {
                    ZESCQSMESSAGE msg = (ZESCQSMESSAGE) tmp;
                    if (EsConstants.CQS_ERROR_PROCESS_STATE.equals(msg.getTYPE())) {
                        list.add(msg);
                    }
                }
        }
        return list;
    }

    
    public boolean isSourceSystemWarnings() {
            SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
            if (reply != null) {
                if (reply.getSoapCastorReply() instanceof ZESROUTINGDETAILSES10Response) {
                    ZESROUTINGDETAILSES10Response out = (ZESROUTINGDETAILSES10Response) reply.getSoapCastorReply();
                    return isWarning(out.getROUTINGDETAILS().getPROCSTATE());
                }
            }
            return false;
    }

    public Collection getSourceSystemWarnings() {
        SapSOAPReply reply = (SapSOAPReply) getSourceSystemResponse();
        if (isSourceSystemWarnings()) {
            if (reply.getSoapCastorReply() instanceof ZESROUTINGDETAILSES10Response) {
                ZESROUTINGDETAILSES10Response out = (ZESROUTINGDETAILSES10Response) reply.getSoapCastorReply();
                return getOnlySourceSystemWarnings(out.getROUTINGDETAILS().getMESSAGES().getItem());
            }
        }
        return null;
    }

    /*
     * Extract only the error out of the list of errors. The warning will be extracted later on The sucess messwage is
     * discarded @param the Collection @return a new Collection
     */
    private Collection getOnlySourceSystemWarnings(Collection messages) {
        ArrayList list = new ArrayList();
        Iterator iterator = messages.iterator();
        while (iterator.hasNext()) {
            Object tmp = iterator.next();

            if (tmp instanceof ZESCQSMESSAGE) {
                ZESCQSMESSAGE msg = (ZESCQSMESSAGE) tmp;
                if (EsConstants.CQS_WARNING_PROCESS_STATE.equals(msg.getTYPE())) {
                    list.add(msg);
                }
            }
        }

        return list;
    }

    private boolean isSuccess(String proc_state) {
        if (proc_state == null) {
            return true;
        }
        
        if (proc_state.equalsIgnoreCase(EsConstants.CQS_EMPTY_PROCESS_STATE)) {
            return true;
        }

        if (proc_state.equalsIgnoreCase(EsConstants.CQS_SUCCESS_PROCESS_STATE)) {
            return true;
        }

        if (proc_state.equalsIgnoreCase(EsConstants.CQS_WARNING_PROCESS_STATE)) {
            return true;
        }

        if (proc_state.equalsIgnoreCase(EsConstants.CQS_ERROR_PROCESS_STATE)) {
            return false;
        }
        	
        return false;
    }

    /*
     * Tell if the process state is a warning.
     */
    private boolean isWarning(String proc_state) {
        // a Warning is a success.
        if (proc_state != null) {
            if (proc_state.equalsIgnoreCase(EsConstants.CQS_WARNING_PROCESS_STATE)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSourceSystemUnitList() {
        return false;
    }

    public Object getSourceSystemUnitList() {
        return null;
    }

	@Override
	public void destroy() {
		// 
		super.destroy();
	}


}
