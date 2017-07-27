package com.dbschenker.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Base {
/*    public BasePage() {
        PageFactory.initElements(DriverContext.Driver,this);
    }*/

    public <Tpage extends BasePage> Tpage As(Class<Tpage> pageInstance) {

        try {
            return (Tpage) this;
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return null;
    }

}
