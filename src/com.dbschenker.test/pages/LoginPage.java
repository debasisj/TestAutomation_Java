package pages;

import com.dbschenker.framework.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {

    public LoginPage(){

    }
    @FindBy(how = How.ID,using = "txtUID")
    public WebElement txtUserId;
    @FindBy(how = How.NAME,using = "Storer")
    public WebElement selectBoxStorer;
    @FindBy(how = How.ID,using = "txtPWD")
    public WebElement txtPassword;




    public void login(String userName, String storer, String pwd) throws InterruptedException {
        txtUserId.sendKeys(userName);
        txtUserId.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Select selectStorer = new Select(selectBoxStorer);
        selectStorer.selectByValue(storer);
        txtPassword.sendKeys(pwd);
    }
}
