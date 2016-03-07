package com.hp.es.service.db;

import com.hp.es.constants.EsConstants;
import com.hp.es.service.util.Configuration;
import com.hp.es.service.util.ESLog;
import com.hp.ruc.config.ConfigChangeEvent;
import com.hp.ruc.config.ConfigChangeListener;
import com.hp.ruc.config.ReadOnlyProperties;

/**
 * 
 * The DatasourceConfiguration produces and stores the config which are used by the Db Connection. It also monitors the configuration file
 * and in case of a change of the related properties it destroys and recreates all the datasource configs.
 * 
 * @author wangwchu
 */
public class DatasourceConfiguration implements ConfigChangeListener {

    private static final String DEFAULT_JDBC_READONLY_MULTIDS = "jdbc.readonlyMultiDS";
    private static final String DEFAULT_JDBC_WRITABLE_MULTIDS = "jdbc.writableMultiDS";
    private boolean weblogicDatasourceEnable = true;

    private String writableDatasourceJndiName = DEFAULT_JDBC_WRITABLE_MULTIDS;
    private String readonlyDatasourceJndiName = DEFAULT_JDBC_READONLY_MULTIDS;

    public String getWritableDatasourceJndiName() {
        return writableDatasourceJndiName;
    }

    public boolean getWeblogicDatasourceEnable() {
        return weblogicDatasourceEnable;
    }

    public String getReadonlyDatasourceJndiName() {
        return readonlyDatasourceJndiName;
    }

    public void configChanged(ConfigChangeEvent event) {
        // check if we have a new configuration
        if (event == null || event.getNewConfig() == null) {
            return;
        }
        ESLog.debug("Received config change event for: " + event.getConfigName());
        if (EsConstants.ES_PROPERTIES_FILENAME.equalsIgnoreCase(event.getConfigName())) {
            ESLog.info("(Re-)load configuration: " + event.getConfigName());
            ReadOnlyProperties config = event.getNewConfig();

            weblogicDatasourceEnable = config.getBooleanProperty(EsConstants.WEBLOGIC_DATASOURCE_ENABLE, Boolean.TRUE).booleanValue();
            ESLog.debug("weblogicDatasourceEnable=" + weblogicDatasourceEnable);

            writableDatasourceJndiName = config.getProperty(EsConstants.DATASOURCE_WRITABLE_JNDINAME);
            ESLog.debug("writableDatasourceJndiName=" + writableDatasourceJndiName);

            readonlyDatasourceJndiName = config.getProperty(EsConstants.DATASOURCE_READONLY_JNDINAME);
            ESLog.debug("datasourceDefaultJndiName=" + readonlyDatasourceJndiName);
        }
    }

    private static DatasourceConfiguration instance = new DatasourceConfiguration();

    private DatasourceConfiguration() {
        Configuration.getInstance().addConfigChangeListener(this);
    }

    /**
     * Returning the singleton
     * 
     * @return
     */
    public static DatasourceConfiguration getInstance() {
        return instance;
    }

}
