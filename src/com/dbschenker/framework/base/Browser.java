package com.dbschenker.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {

    public browserType type;
    private WebDriver _driver;

    public Browser(WebDriver driver) {
        _driver = driver;
    }

    public void goToUrl(String Url){
        _driver.get(Url);
    }


   public  enum  browserType{
        IE,Chrome,Firefox
    }

}
