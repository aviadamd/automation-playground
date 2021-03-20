package pages;

import org.openqa.selenium.WebDriver;
import pages.accountManagement.AccountManagementLoginPage;
import pages.grafana.GrafanaLoginPage;

public class WebUi {

    public GrafanaLoginPage grafanaLoginPage;
    public AccountManagementLoginPage accountManagementLoginPage;

    public WebUi(WebDriver driver) {
        this.grafanaLoginPage = new GrafanaLoginPage(driver);
        this.accountManagementLoginPage = new AccountManagementLoginPage(driver);
    }
}
