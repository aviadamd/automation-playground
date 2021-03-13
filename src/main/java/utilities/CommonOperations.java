package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utilities.config.JsonReader;

import java.util.concurrent.TimeUnit;

import static pageObjects.InitWebPages.initWebPages;

public class CommonOperations extends Base {

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
        System.out.println("init " + getPlatform + " platform");
        initWebPages();

    }

    @AfterMethod(description = "after method return to base test url")
    public void afterMethod() {

        driver.get(new JsonReader().jsonData(0).url);
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
        System.out.println("init " + browser + " type platform");
        driver.manage().window().maximize();
        driver.get(new JsonReader().jsonData(0).url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void initApplication() {
        String application = new JsonReader().jsonData(0).typeFromPlatform;
        if (application.equals("appium")) {
            driver = Base.startAppiumServer();
        }
        else throw new IllegalArgumentException("provide valid application driver type");
        System.out.println("init " + application + " type platform");
    }

//    @BeforeSuite
//    void setAllureEnvironment() {
//        allureEnvironmentWriter(
//                ImmutableMap.<String, String>builder()
//                        .put("Browser", "Chrome")
//                        .put("Browser.Version", "70.0.3538.77")
//                        .put("URL", "http://testjs.site88.net")
//                        .build(), System.getProperty("user.dir")
//                        + "/allure-results/");
//    }

}
