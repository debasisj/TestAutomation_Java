package seleniumtests;

import com.dbschenker.framework.config.Settings;
import com.dbschenker.framework.utilities.ExcelUtil;
import org.junit.Test;
import pages.LoginPage;


public class LoginTest extends TestInitializeAndTearDown{



    @Test
    public void login() throws InterruptedException{
        CurrentPage =  GetInstance(LoginPage.class);
        //CurrentPage.As(LoginPage.class).login("debashishj","PHILIPSNSW","debj2017");
        Settings.logUtil.writeLog("Starting the test with excel read.");
        CurrentPage.As(LoginPage.class).login(ExcelUtil.ReadCell("UserName",1),
                ExcelUtil.ReadCell("Storer",1),
                ExcelUtil.ReadCell("Password",1));


    }
}
