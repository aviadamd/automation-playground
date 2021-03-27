package base.baseUtilities;

import base.utilities.UiUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.accountManagement.AccountManagementUiPages;

import java.util.concurrent.TimeUnit;

@Slf4j
@EnableAspectJAutoProxy
public class BaseOperations extends Base {

    public static UiUtilities utilities;
    public static AccountManagementUiPages accountManagementUi;

    @BeforeClass(description = "before class start action")
    public void startSession() {
        String getPlatform = getProperty.platform;
        switch (getPlatform) {
            case "web" :
                initWebBrowser(getProperty.url);
                break;
            case "mobile" :
                initApplication();
                break;
        }
        log.debug("init " + getPlatform + " platform");
        accountManagementUi = new AccountManagementUiPages(driver);
        utilities = new UiUtilities();
    }

    @AfterMethod(description = "after method")
    public void afterMethod() {
        String getPlatform = getProperty.platform;
        switch (getPlatform) {
            case "web":
                break;
            case "mobile":
                break;
        }
    }

    @AfterClass(description = "quit sessions")
    public void closeSession() {
        String getPlatform = getProperty.platform;
        if (driver != null) {
            switch (getPlatform) {
                case "web":
                    driver.close();
                    driver.quit();
                    break;
                case "mobile":
                    server.stop();
                    driver.quit();
                    break;
            }
        }
    }

    private void initWebBrowser(String url) {
        String browser = getProperty.platformType;
        switch (browser) {
            case "chrome":
                driver = Base.initChromeDriver(chromeOptionsDisableBeforeLaunch());
                break;
            case "firefox":
                driver = Base.initFireFoxDriver(firefoxOptions());
                break;
        }
        log.debug("init " + browser + " type platform");
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void initApplication() {
        driver = Base.startAppiumServer();
        log.debug("init " + getProperty.platform + " type platform");
    }
}
