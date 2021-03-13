package pageObjects;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.GrafanaLoginPage;
import pageObjects.grafana.GrafanaSideMenu;
import utilities.CommonOperations;

public class InitWebPages extends CommonOperations {

    public static GrafanaLoginPage grafanaLoginPage;
    public static GrafanaSideMenu grafanaSideMenu;

    public static void initWebPages() {
        grafanaLoginPage = PageFactory.initElements(driver, GrafanaLoginPage.class);
        grafanaSideMenu = PageFactory.initElements(driver, GrafanaSideMenu.class);
    }

}
