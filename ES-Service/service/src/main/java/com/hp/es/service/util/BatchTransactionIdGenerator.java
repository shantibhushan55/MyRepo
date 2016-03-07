/*
 * Project: HPS Entitlement Service
 *
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/util/TransactionIdGenerator.java 1.5 2004-05-08 04:42:19+02 entitlem Exp $
 *
 * Copyright (c) 2003 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 *
 * $Log: TransactionIdGenerator.java,v $
 * Revision 1.5  2004-05-08 04:42:19+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point8_0C1
 *
 * Revision 1.4  2004-05-05 15:41:08+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point6_1
 *
 * Revision 1.3  2004-01-29 18:06:52+01  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head in preparation of dev6_0
 *
 * Revision 1.2  2003-08-04 16:51:15+02  entitlem
 * Author: entitlem@isoit621.bbn.hp.com (#Frank Renftle)
 * no change, just pushing head past branch_point5_0
 *
 * Revision 1.1  2003-07-01 22:10:31+02  lbednari
 * Author: lbednari@bbnnaid62.bbn.hp.com ()
 * Initial revision
 *
 */
package com.hp.es.service.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.es.service.db.DbConnectionManager;




/**
 * Creates an id generator for use in all operations to get unique transaction
 * ids within an application run. This is used also by DB.
 * This generates a unique 30 DIGIT ID
 */
public class BatchTransactionIdGenerator extends  IdGenerator {
	private static BatchTransactionIdGenerator instance = new BatchTransactionIdGenerator();
	private static final String SQL_SEQ = "select BATCH_REQUEST_SEQUENCE.nextval from dual";
	
	private BatchTransactionIdGenerator() {		
	}
	
	
	private long getSequenceValue()  {
		PreparedStatement pst = null;
		ResultSet rs = null;
		long seqVal = 0;
		Connection conn= null;
		
		try {
			conn =DbConnectionManager.getInstance().getWritableConnection();
			pst = conn.prepareStatement(SQL_SEQ);
			rs = pst.executeQuery();
			while (rs.next()) {
				seqVal = rs.getLong(1);
			}
		} catch(Exception e) {
			ESLog.error("Error in getting sequence from DbConnectionManager.getInstance().getWritableConnection()", e);
		}finally {

			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					ESLog.info("Error in releasing resultset for  sequence", e);
				}
			}
			if(pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					ESLog.info("Error  in releasing prepared statement for  sequence", e);
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					ESLog.info("Error in closing connection for sequence", e);
				}
			}
		}
		
		return seqVal;
	}
	
	/**
	 * @return the instance
	 */
	public static BatchTransactionIdGenerator getInstance() {
		return instance;
	}


	


    
    /**
     * Create the next transaction ID for a service reply.
     * It must be unique accross all VMs and all servers
     * THE iD GENERATED is epxected to be returning a long
     * a long is 8 bytes signed
     * @return
     */
    public String nextId() {
    	return String.valueOf(getSequenceValue());
    }
    


   

   
    







}
