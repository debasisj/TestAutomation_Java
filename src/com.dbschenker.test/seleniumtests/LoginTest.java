package seleniumtests;

import com.dbschenker.framework.base.Browser;
import com.dbschenker.framework.base.DriverContext;
import com.dbschenker.framework.base.FrameworkInitialize;
import com.dbschenker.framework.config.ConfigReader;
import com.dbschenker.framework.config.Settings;
import com.dbschenker.framework.utilities.ExcelUtil;
import com.dbschenker.framework.utilities.ReportUtil;
import jxl.read.biff.BiffException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import pages.LoginPage;

import java.io.IOException;


public class LoginTest extends FrameworkInitialize{

    @Rule public TestName name = new TestName();
    @Before
    public void init() throws IOException, BiffException {
        ConfigReader.populateSettings();
        initializeBrowser(Browser.browserType.IE);

        DriverContext.browser.goToUrl(Settings.AUTBaseUrl);
        if(ReportUtil.getHtmlReporter()==null)ReportUtil.initReport();
        ReportUtil.initializeTest(name.getMethodName());
        ExcelUtil util = new ExcelUtil(Settings.TestDataPath,"LoginDetails");
/*        try {

            ResultSet result = DatabaseUtil.executeQuery("select LocationType from loc where loc  = 'C043510B'");
            while (result.next()) {
                String name = result.getString(1);
                System.out.println(name);
            }



            LogUtil logUtil = new LogUtil();
            logUtil.createlogFile();
            logUtil.writeLog("Login Test statrted");
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @After
    public void tearDown(){
        DriverContext.Driver.quit();
        ReportUtil.createReport();
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
