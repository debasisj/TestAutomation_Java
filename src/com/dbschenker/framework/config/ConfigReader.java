package com.dbschenker.framework.config;

import com.dbschenker.framework.base.Browser;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void  populateSettings() throws IOException {
        ConfigReader rdr = new ConfigReader();
        rdr.readProperty();
    }

    private void readProperty() throws IOException {
        Properties prop = new Properties();
        prop.load(getClass().getResourceAsStream("GlobalConfig.properties"));
        Settings.AUTBaseUrl = prop.getProperty("AUTBaseUrl");
        Settings.DatabaseInstanceConnectionUrl = prop.getProperty("DatabaseInstanceConnectionUrl");
        Settings.LogPath = prop.getProperty("LogPath");
        Settings.SQLServerJDBCClass = prop.getProperty("SQLServerJDBCClass");
        Settings.TestDataPath = prop.getProperty("TestDataPath");
        Settings.IEDriverExePath = prop.getProperty("IEDriverExePath");
        Settings.BrowserType = Browser.browserType.valueOf(prop.getProperty("BrowserType"));
    }
}
