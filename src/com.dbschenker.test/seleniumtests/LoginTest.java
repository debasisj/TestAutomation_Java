package seleniumtests;
import com.dbschenker.framework.base.Browser;
import com.dbschenker.framework.base.DriverContext;
import com.dbschenker.framework.base.FrameworkInitialize;
import com.dbschenker.framework.utilities.ExcelUtil;
import jxl.read.biff.BiffException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

import java.io.IOException;


public class LoginTest extends FrameworkInitialize{


    @Before
    public void init(){
        initializeBrowser(Browser.browserType.IE);

        DriverContext.browser.goToUrl("http://auintratest01/mcwms_test/");

        try {
            ExcelUtil util = new ExcelUtil("C:\\Users\\djagadeb\\Source\\Repos\\TestAutomation_Java\\src\\resource\\TestData.xls","LoginDetails");
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        DriverContext.Driver.quit();
    }

    @Test
    public void login() throws InterruptedException{
        CurrentPage =  GetInstance(LoginPage.class);
        //CurrentPage.As(LoginPage.class).login("debashishj","PHILIPSNSW","debj2017");
        CurrentPage.As(LoginPage.class).login(ExcelUtil.ReadCell("UserName",1),
                ExcelUtil.ReadCell("Storer",1),
                ExcelUtil.ReadCell("Password",1));


    }
}
