package pages.accountManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.InitWebPages;

public class AccountManagementLoginPage extends InitWebPages {

    public AccountManagementLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"banner-cookies\"]/div/div/button")
    public WebElement bannerCookies_xBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"userCode\"]")
    public WebElement userNameEditText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
    public WebElement userPasswordEditText;

    @FindBy(how = How.CLASS_NAME, using = "login-submit")
    public WebElement loginBtn;

}
