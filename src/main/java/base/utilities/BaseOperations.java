package base.utilities;

import base.Verfications;
import base.UiActions;
import base.utilities.config.objects.SharedObjects;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.WebUi;
import base.utilities.config.data.JsonReader;
import test.GrafanaShared;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@EnableAspectJAutoProxy
@ContextConfiguration(classes = {
        Base.class,
        BaseOperations.class,
        SharedObjects.class,
        UiActions.class,
        Verfications.class,
        GrafanaShared.class
})
@ComponentScan(basePackages = {"org.example"})
public class BaseOperations extends Base {

    public static WebUi webUi;
    @Bean public UiActions uiActions() { return new UiActions(); }
    @Bean public Verfications verfications() { return new Verfications(); }
    @Bean public GrafanaShared grafanaShared() { return new GrafanaShared();}
    @BeforeClass(description = "before class start action")
    public void startSession() {
        String getPlatform = new JsonReader().jsonData(0).platform;
        switch (getPlatform) {
            case "web" :
                initWebBrowser();
                break;
            case "mobile" :
                initApplication();
                break;
        }
        log.debug("init " + getPlatform + " platform");
        webUi = new WebUi(driver);
    }

    @AfterMethod(description = "after method return to base test url")
    public void afterMethod() {
        String getPlatform = new JsonReader().jsonData(0).platform;
        switch (getPlatform) {
            case "web" :
                driver.get(new JsonReader().jsonData(0).url);
                break;
            case "mobile" :
                break;
        }
    }

    @AfterClass(description = "quit sessions")
    public void closeSession() {
        String getPlatform = new JsonReader().jsonData(0).platform;
        switch (getPlatform) {
            case "web" :
                driver.quit();
                break;
            case "mobile" :
                server.stop();
                driver.quit();
                break;
        }
    }

    public static WebDriverWait webDriverWait(int timeOut) {

        return new WebDriverWait(driver, timeOut);
    }

    private void initWebBrowser() {
        String browser = new JsonReader().jsonData(0).typeFromPlatform;
        switch (browser) {
            case "chrome":
                driver = Base.initChromeDriver();
                break;
            case "safari":
                driver = Base.initFireFoxDriver();
                break;
        }
        log.debug("init " + browser + " type platform");
        driver.manage().window().maximize();
        driver.get(new JsonReader().jsonData(0).url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void initApplication() {
        String application = new JsonReader().jsonData(0).typeFromPlatform;
        if (application.equals("appium")) driver = Base.startAppiumServer();
        else throw new IllegalArgumentException("provide valid application driver type");
        log.debug("init " + application + " type platform");
    }

}
