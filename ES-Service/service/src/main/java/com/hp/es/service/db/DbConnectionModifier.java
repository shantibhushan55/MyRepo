package com.hp.es.service.db;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleConnection;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.ESLog;
import com.hp.ruc.config.ConfigFactory;
import com.hp.ruc.config.ReadOnlyProperties;
import com.hp.ruc.db.ConnectionModifier;

public class DbConnectionModifier implements ConnectionModifier {

    private static final Integer DEFAULT_PREFETCH_SIZE = new Integer(100);

    private int _prefetch;

    public DbConnectionModifier() {
        try {
            ReadOnlyProperties props = ConfigFactory.getInstance().getConfig(
                    EsConstants.ES_PROPERTIES_FILENAME);
            _prefetch = props.getIntegerProperty("es.db.prefetch").intValue();
        }
        catch (Exception e) {
            ESLog.error("Error reading prefetch size", e);
            _prefetch = DEFAULT_PREFETCH_SIZE.intValue();
        }
    }

    public void modify(Connection conn) throws SQLException {
        conn.setAutoCommit(false);
        ((OracleConnection)conn).setRemarksReporting(false);
        ((OracleConnection)conn).setDefaultRowPrefetch(_prefetch);
        ((OracleConnection)conn).setIncludeSynonyms(false);
//        ((OracleConnection)conn).setImplicitCachingEnabled(true);
//        ((OracleConnection)conn).setStatementCacheSize(20);
        ((OracleConnection)conn).setImplicitCachingEnabled(false);

        ESLog.info("Successfully modified connection (prefetch "
                + ((OracleConnection)conn).getDefaultRowPrefetch() + ")");
    }
}