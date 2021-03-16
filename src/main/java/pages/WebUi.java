package pages;

import org.openqa.selenium.WebDriver;
import pages.accountManagement.Login;
import pages.grafana.GrafanaLoginPage;

public class WebUi {

    public GrafanaLoginPage grafanaLoginPage;
    public Login login;

    public WebUi(WebDriver driver) {
        this.grafanaLoginPage = new GrafanaLoginPage(driver);
        this.login = new Login(driver);
    }
}
