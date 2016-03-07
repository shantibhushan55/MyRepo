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
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.hp.es.service.db.DbConnectionManager;




/**
 * Creates an id generator for use in all operations to get unique transaction
 * ids within an application run. This is used also by DB.
 * This generates a unique 30 DIGIT ID
 */
public class TransactionIdGenerator extends  IdGenerator {
	private static TransactionIdGenerator instance = new TransactionIdGenerator();
	
	private static String CACHE_INIT_STATUS = "INIT"; 
	private static String CACHE_START_STATUS = "START"; 
	private static String CACHE_END_STATUS = "END"; 
	
	private static final int maxSequenceNum=2000;
	private static final int iteration=600;
	
	private static final String SQL_SEQ = "SELECT TM_TRANSACTION_SEQUENCE.NEXTVAL FROM (select level from dual  connect by level <= "+maxSequenceNum+")";
	
	private static ConcurrentLinkedQueue < Long > transactionIds = new ConcurrentLinkedQueue < Long >(); 
	private static String cacheUpdateFlag = CACHE_INIT_STATUS; 
	
	private TransactionIdGenerator() {	
	}
	
	static{
		long start=System.currentTimeMillis();
		getNextSequenceValueFromDatabase();
		ESLog.info("Enter TransactionIdGenerator Init,Time cost to fetch id from resultSet to List:"+(System.currentTimeMillis()-start));
	}
	
	/**
	 * For reduce DB connection purpose, fetch a couple of ids from DB by one connection, set one min id and one max id to cache the ids,
	 * 
	 *  one request one id, if cached ids is less than 500, fetch ids from DB again;
	 *  If DB is down, give sysdate of seconds + 1 random into id;
	 */
	private long getSequenceValue() {
		Long idForReturn = new Long(0);
		if(cacheUpdateFlag.equals(CACHE_INIT_STATUS)||transactionIds.size()==0){
        	String random=String.valueOf(new Random().nextInt(10));
        	String sysdate=String.valueOf(System.currentTimeMillis());
            idForReturn =Long.valueOf(sysdate+random);
            ESLog.warn("Enter TransactionIdGenerator ,ID is generated via random,idForReturn:"+idForReturn);
		}else if(transactionIds.size()>iteration){
			idForReturn = transactionIds.poll();
			ESLog.debug("Enter TransactionIdGenerator ,ID is returned in cache,idForReturn:"+idForReturn);
		}else if(transactionIds.size()<=iteration){
			idForReturn = transactionIds.poll();
			if(!cacheUpdateFlag.equals(CACHE_START_STATUS)){
				cacheTransactions();
			}
			ESLog.debug("Enter TransactionIdGenerator ,ID is returned in cache,idForReturn:"+idForReturn);
		}
		
		if(idForReturn == 0 || idForReturn == null){
        	String random=String.valueOf(new Random().nextInt(10));
        	String sysdate=String.valueOf(System.currentTimeMillis());
            idForReturn =Long.valueOf(sysdate+random);
            ESLog.warn("Enter TransactionIdGenerator ,ID is generated via random,idForReturn:"+idForReturn);
		}
		
		return idForReturn;
	}
	
	/**
	 * if the cache is not in updating status, we fetch next 2000 into cache
	 */
	private synchronized static void cacheTransactions()  {
		if(!cacheUpdateFlag.equals(CACHE_START_STATUS)){
			Thread cacheThread = new Thread(){
				public void run(){			
					getNextSequenceValueFromDatabase();		
				}
			};
			cacheThread.start();
		}
	}
	
	/**
	 * Fetch next couple of ids, initialize minimum and maximum id when both of them are 0, other only updated the maximum id.
	 */
	
	private static void getNextSequenceValueFromDatabase()  {
		cacheUpdateFlag = CACHE_START_STATUS;
		long startTime=System.currentTimeMillis();
		
		PreparedStatement pst = null;
		ResultSet rs = null;
	
		Connection conn= null;
		try {
			conn =DbConnectionManager.getInstance().getWritableConnection();
			pst = conn.prepareStatement(SQL_SEQ);
			rs = pst.executeQuery();
			long SQLExecutedTime=System.currentTimeMillis();
			ESLog.info("Enter TransactionIdGenerator ,Time cost to fetch sequence:"+(SQLExecutedTime-startTime));

			int i = 0;
			while (rs.next()) {
				transactionIds.add(rs.getLong(1));
				i++;
			}
			long addIDToList=System.currentTimeMillis();
			ESLog.info("Enter TransactionIdGenerator ,Time cost to fetch id from resultSet to List:"+(addIDToList-SQLExecutedTime));
			
			ESLog.info("Enter TransactionIdGenerator ,cached number from DB:"+ i);
			
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
			
			cacheUpdateFlag = CACHE_END_STATUS;
		}
		
	}
	
	/**
	 * @return the instance
	 */
	public static TransactionIdGenerator getInstance() {
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
