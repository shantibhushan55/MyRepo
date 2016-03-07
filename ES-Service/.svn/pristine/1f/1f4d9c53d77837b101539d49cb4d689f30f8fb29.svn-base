package com.hp.es.service.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;
import com.hp.ruc.db.DataAccessException;
import com.hp.ruc.db.DatabaseDownException;
import com.hp.ruc.db.RucPoolManager;
import com.hp.ruc.db.WeblogicDataSourceManager;

/**
 * This class is the central point for all DB access classes to get a connection to the database.
 * 
 * @author wangwchu
 */

public final class DbConnectionManager {

    private DataSource readonlyDataSource;
    private DataSource writableDataSource;

    /**
     * Gets a Connection object which can be used to access the database. It is important to close that Connection as soon as it is not
     * needed anymore because closing the connection will give the connection back to the connection pool, i.e. the connection can be
     * reused.
     * 
     * @return a Connection object
     */
    public Connection getReadonlyConnection() throws DatabaseDownException {
    	/*if(true) {
    		return getRemoteConnectionByJdbcForTesting();
    	}*/

        if (DatasourceConfiguration.getInstance().getWeblogicDatasourceEnable()) {
            String jndiName = DatasourceConfiguration.getInstance().getReadonlyDatasourceJndiName();
            DataSource ds = getWeblogicReadonlyDataSource(jndiName);
            return getWeblogicDbConnection(ds);
        }
        ESLog.error("Not running in weblogic, getting the RUC DB connection");
        return getRucDbConnection(null);
    }

    /**
     * Gets a Connection object which can be used to access the database. It is important to close that Connection as soon as it is not
     * needed anymore because closing the connection will give the connection back to the connection pool, i.e. the connection can be
     * reused.
     * 
     * @return
     * @throws DataAccessException
     * @throws DatabaseDownException
     */
    public Connection getWritableConnection() throws DatabaseDownException {
    	/*if(true) {
    		return getRemoteConnectionByJdbcForTesting();
    	}*/
        if (DatasourceConfiguration.getInstance().getWeblogicDatasourceEnable()) {
            String jndiName = DatasourceConfiguration.getInstance().getWritableDatasourceJndiName();
            DataSource ds = getWeblogicWritableDataSource(jndiName);
            return getWeblogicDbConnection(ds);
        }
        ESLog.info("Not running in weblogic, getting the RUC DB connection");
        return getRucDbConnection("batchEntitlement");
    }

    private Connection getWeblogicDbConnection(DataSource ds) throws DatabaseDownException {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            ESLog.debug("Just caught SQLException", e);
            throw new DatabaseDownException(e);
        }
    }

    private Connection getRucDbConnection(String connectionName) throws DatabaseDownException {
        ESLog.debug("ENTER getRucDbConnection(). connectionName=" + connectionName);
        try {
            if (connectionName == null) {
                return RucPoolManager.getInstance(EsConstants.DB_PROPERTIES_FILENAME).getConnection();
            }

            return RucPoolManager.getInstance(EsConstants.DB_PROPERTIES_FILENAME).getConnection(connectionName);

        } catch (SQLException e) {
            ESLog.debug("Caught SQLException", e);
            throw new DatabaseDownException(e);
        }
    }

    private synchronized DataSource getWeblogicReadonlyDataSource(String jndiName) throws DatabaseDownException {
        if (readonlyDataSource == null) {
            ESLog.debug("trying to get data source " + jndiName + "from WeblogicDataSourceManager");
            try {
                readonlyDataSource = WeblogicDataSourceManager.getInstance().getLocalDataSource(jndiName);
            } catch (NamingException e) {
                ESLog.debug("Caught NamingException for finding jndiName=" + jndiName, e);
                throw new DatabaseDownException(e);
            }
        }
        return readonlyDataSource;
    }

    private synchronized DataSource getWeblogicWritableDataSource(String jndiName) throws DatabaseDownException {
        if (writableDataSource == null) {
            try {
                writableDataSource = WeblogicDataSourceManager.getInstance().getLocalDataSource(jndiName);
            } catch (NamingException e) {
                ESLog.debug("Caught NamingException for finding jndiName=" + jndiName, e);
                throw new DatabaseDownException(e);
            }
        }
        return writableDataSource;
    }

    /**
     * NOTE: This is used for TESTING only.
     * 
     * NEVER use this method on production environment.
     * 
     * @return
     * @throws DataAccessException
     * @throws DatabaseDownException
     */
    public Connection getRemoteConnectionForTesting() throws DatabaseDownException {
        String dvlUrl = "t3://d9t0208g.houston.hp.com:30058";
        String jndiName = "jdbc.writableMultiDS";
        String username = "appadmin";
        String password = "1qaz2wsx";
        try {
            DataSource ds = WeblogicDataSourceManager.getInstance().getRemoteDataSource(dvlUrl, username, password, jndiName);
            return getWeblogicDbConnection(ds);
        } catch (NamingException e) {
            ESLog.debug("Caught NamingException for finding jndiName=" + jndiName, e);
            throw new DatabaseDownException(e);
        }
    }
    
    /**
     * NOTE: This is used for local TESTING only.
     * 
     * NEVER use this method on production environment.
     * 
     * @return java.sql.Connection
     * @throws DatabaseDownException 
     */
    public Connection getRemoteConnectionByJdbcForTesting() throws DatabaseDownException {
        Properties prop = new Properties();
        FileInputStream fis = null;
        Connection con = null;
		try {
			fis = new FileInputStream(EsConstants.DB_PROPERTIES_FILENAME_LOCAL);
			prop.load(fis);
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			con = DriverManager.getConnection("jdbc:oracle:thin:@//gvu1651.houston.hp.com:1525/ODSD", prop.getProperty("default.user"), prop.getProperty("default.password"));
		} catch (Exception e) {
			ESLog.error("Caught Exception for creating jdbc connection", e);
			throw new DatabaseDownException(e);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				ESLog.error("Caught Exception for closing FileInputStream", e);
			}
		}
        
        return con;
    }

    /**
     * @return the DbConnectionManager object (singleton).
     */
    public static DbConnectionManager getInstance() {
        return INSTANCE;
    }

    /**
     * private constructor
     */
    private DbConnectionManager() {
    }

    private static final DbConnectionManager INSTANCE = new DbConnectionManager();
}
