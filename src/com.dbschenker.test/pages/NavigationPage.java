package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {
    @FindBy(how = How.XPATH,using = "//*[text()[contains(.,'Tasks')]]")
    public WebElement navTasks;
    @FindBy(how = How.XPATH,using = "//*[text()[contains(.,'Reports')]]")
    public WebElement navReports;



    public void navigateToCreateWavePage(){

    }
}


