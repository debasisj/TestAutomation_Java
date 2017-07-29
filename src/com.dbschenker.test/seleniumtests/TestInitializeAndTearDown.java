package seleniumtests;

import com.dbschenker.framework.base.DriverContext;
import com.dbschenker.framework.base.FrameworkInitialize;
import com.dbschenker.framework.config.ConfigReader;
import com.dbschenker.framework.config.Settings;
import com.dbschenker.framework.utilities.ExcelUtil;
import com.dbschenker.framework.utilities.LogUtil;
import com.dbschenker.framework.utilities.ReportUtil;
import jxl.read.biff.BiffException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.io.IOException;

public class TestInitializeAndTearDown extends FrameworkInitialize{

    @Rule
    public TestName name = new TestName();
    @Before
    public void init() throws IOException, BiffException {
        ConfigReader.populateSettings();
        Settings.logUtil = new LogUtil();
        Settings.logUtil.createlogFile();
        Settings.logUtil.writeLog("Browser started");
        initializeBrowser(Settings.BrowserType);

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
        Settings.logUtil.writeLog("Browser closed");
        DriverContext.Driver.quit();
        ReportUtil.createReport();
        Settings.logUtil.writeLog("Report Closed");
    }
}
