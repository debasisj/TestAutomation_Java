package com.dbschenker.framework.base;

import com.dbschenker.framework.config.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FrameworkInitialize extends Base {

    WebDriver driver = null;

    public void initializeBrowser(Browser.browserType browsertype){
        switch (browsertype){
            case IE:
            {
                System.setProperty("webdriver.ie.driver", Settings.IEDriverExePath);
                driver = new InternetExplorerDriver();
            }
        }
        DriverContext.setDriver(driver);
        DriverContext.browser =  new Browser(driver);
    }
}
