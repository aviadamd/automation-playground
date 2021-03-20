package base.baseUtilities;

import base.utilities.UiActions;
import base.utilities.Verfications;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@EnableAspectJAutoProxy
@ContextConfiguration(classes = {
        UiActions.class,
        Verfications.class,
        JsonReader.class
})
@ComponentScan(basePackages = {"org.automation.project"})
public class BaseOperations extends Base {

    public static WebUi webUi;
    @Bean public UiActions uiActions() { return new UiActions(); }
    @Bean public Verfications verfications() { return new Verfications(); }
    @Bean public JsonReader jsonReader() { return new JsonReader();}

    @BeforeClass(description = "before class start action")
    public void startSession() {
        String getPlatform = jsonReader().jsonData(0).platform;
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
        String getPlatform = jsonReader().jsonData(0).platform;
        switch (getPlatform) {
            case "web" :
                driver.get(jsonReader().jsonData(0).url);
                break;
            case "mobile" :
                break;
        }
    }

    @AfterClass(description = "quit sessions")
    public void closeSession() {
        String getPlatform = jsonReader().jsonData(0).platform;
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
        String browser = jsonReader().jsonData(0).typeFromPlatform;
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
        driver.get(jsonReader().jsonData(0).url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void initApplication() {
        String application = jsonReader().jsonData(0).typeFromPlatform;
        if (application.equals("appium")) driver = Base.startAppiumServer();
        else throw new IllegalArgumentException("provide valid application driver type");
        log.debug("init " + application + " type platform");
    }

}
