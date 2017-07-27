package seleniumtests;
import com.dbschenker.framework.base.Browser;
import com.dbschenker.framework.base.DriverContext;
import com.dbschenker.framework.base.FrameworkInitialize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;


public class LoginTest extends FrameworkInitialize{


    @Before
    public void init(){
        initializeBrowser(Browser.browserType.IE);

        DriverContext.browser.goToUrl("http://auintratest01/mcwms_test/");
    }

    @After
    public void tearDown(){
        DriverContext.Driver.quit();
    }

    @Test
    public void login() throws InterruptedException{
        CurrentPage =  GetInstance(LoginPage.class);
        CurrentPage.As(LoginPage.class).login("debashishj","PHILIPSNSW","debj2017");



    }
}
