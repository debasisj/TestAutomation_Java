package com.dbschenker.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FrameworkInitialize extends Base {

    WebDriver driver = null;

    public void initializeBrowser(Browser.browserType browsertype){
        switch (browsertype){
            case IE:
            {
                System.setProperty("webdriver.ie.driver","C:\\Users\\djagadeb\\Source\\Repos\\MCWMS_TestAutomation\\packages\\Selenium.InternetExplorer.WebDriver.3.3\\driver\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
        }
        DriverContext.setDriver(driver);
        DriverContext.browser =  new Browser(driver);
    }
}
