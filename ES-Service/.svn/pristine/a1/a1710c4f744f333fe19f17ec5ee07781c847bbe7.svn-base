/*
 * $Header: /ENTITLEMENT/src/java/com/hp/es/service/db/DBSkuKmatManagerImpl.java 1.7 2004-05-08 04:42:33+02 entitlem Exp $
 *
 * Copyright (c) 2000 Hewlett-Packard GmbH, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Hewlett-Packard, GmbH. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Hewlett-Packard.
 */
package com.hp.es.service.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.hp.es.service.util.OracleHelper;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;

/**
 * This class is used to query the database for sku related information.
 *
 * @author Robin Naresh
 * @since ES 6.0
 */

public class DbSkuKmatManager{



    private static DbSkuKmatManager singletonInstance = new DbSkuKmatManager();

    //-----------------------------------------------------------------------------

    private DbSkuKmatManager() {
    	super();
    }
    //------------------------------
    public static DbSkuKmatManager getInstance() {

        return singletonInstance;
    }
    
    //-----------------------------------------------------------------------------

   public String skuKmatConversion(String ProductId)
    throws DataAccessException, DatabaseDownException {
        if (ProductId == null) {
            throw new NullPointerException("ProductId cannot be null");
        }

        Connection connection = null;
        CallableStatement statement = null;
        String convertedPID;

        try {
            //connection = this.connectionManager.getConnection();
            connection = DbConnectionManager.getInstance().getReadonlyConnection();
            statement =  connection.prepareCall(
                    "{ ?= call ES_COMMON_UTILS.mapping_sku_kmat(?)}");

            statement.registerOutParameter(1, java.sql.Types.VARCHAR);
            statement.setString(2, ProductId);
            statement.execute();
            convertedPID = statement.getString(1);
         }
         catch (SQLException e) {
            if (OracleHelper.isDatabaseDown(e.getErrorCode())) {
                throw new DatabaseDownException(e);
            } else {
                DataAccessException exception = new DataAccessException(e);
                exception.setErrorCode(8000);
                throw exception;
            }
        }
        finally {
            try {
                statement.close();
            }
            catch (Exception e) {
            }
            if (connection != null) {
                //this.connectionManager.releaseConnection(connection);
              try{connection.close();}catch(Exception e){}
            }
        }
        return convertedPID;
    }

}
