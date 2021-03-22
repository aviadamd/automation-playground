package pages;

import org.openqa.selenium.WebDriver;
import pages.accountManagement.AccountManagementLoginPage;

public class WebUi {
    public AccountManagementLoginPage accountManagementLoginPage;

    public WebUi(WebDriver driver) {
        this.accountManagementLoginPage = new AccountManagementLoginPage(driver);
    }
}
