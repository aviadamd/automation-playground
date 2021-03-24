package base.baseUtilities;

import base.utilities.JavaScriptUtil;
import base.utilities.UiActions;
import base.utilities.Verfications;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.WebUi;
import base.utilities.config.JsonReader;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
@EnableAspectJAutoProxy
public class BaseOperations extends Base {

    public static WebUi webUi;
    public JsonReader jsonReader() { return new JsonReader();}
    public UiActions uiActions() { return new UiActions(); }
    public Verfications verfications() { return new Verfications(); }
    public JavaScriptUtil jsUtil() { return new JavaScriptUtil(); }

    @Severity(SeverityLevel.BLOCKER)
    @Story("init web driver with base url")
    @BeforeClass(description = "before class start action")
    public void startSession() {
        String getPlatform = jsonReader().jsonData(1).platform;
        switch (getPlatform) {
            case "web" :
                initWebBrowser(jsonReader().jsonData(1).url);
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
            case "web":
                log.info("w");
                break;
            case "mobile":
                log.info("m");
                break;
        }
    }

    @AfterClass(description = "quit sessions")
    public void closeSession() {
        if (driver == null) throw new WebDriverException("cannot reach driver");
        String getPlatform = jsonReader().jsonData(1).platform;
        switch (getPlatform) {
            case "web":
                driver.close();
                driver.quit();
                break;
            case "mobile" :
                server.stop();
                driver.quit();
                break;
        }
    }

    @Description("init web browser with {0} url")
    private void initWebBrowser(String url) {
        String browser = jsonReader().jsonData(1).typeFromPlatform;
        switch (browser) {
            case "chrome":
//                BrowserMobProxyServer proxyServer = new BrowserMobProxyServer();
//                proxyServer.setTrustAllServers(true);
//                proxyServer.enableHarCaptureTypes(
//                        CaptureType.REQUEST_HEADERS,CaptureType.REQUEST_CONTENT,
//                        CaptureType.REQUEST_BINARY_CONTENT,CaptureType.REQUEST_COOKIES,
//                        CaptureType.RESPONSE_HEADERS,CaptureType.RESPONSE_CONTENT,
//                        CaptureType.RESPONSE_BINARY_CONTENT,CaptureType.RESPONSE_COOKIES
//                );
//                proxyServer.start();
                driver = Base.initChromeDriver(disableBeforeLaunch());
                break;
            case "safari":
                driver = Base.initFireFoxDriver();
                break;
        }
        log.debug("init " + browser + " type platform");
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void initApplication() {
        String application = jsonReader().jsonData(0).typeFromPlatform;
        if (application.equals("appium"))
            driver = Base.startAppiumServer();
        else throw new IllegalArgumentException("provide valid application driver type");
        log.debug("init " + application + " type platform");
    }

    public ChromeOptions disableBeforeLaunch() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-extensions");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

    private ChromeOptions setCookiesConfig(int setValue) {
        HashMap<String, Object> prefs = new HashMap<>();
        //1 - enable , 2 - disable
        prefs.put("profile.default_content_setting_values.cookies",setValue);
        prefs.put("network.cookie.cookieBehavior",setValue);
        if (setValue == 1)
             prefs.put("profile.block_third_party_cookies", true);
        else prefs.put("profile.block_third_party_cookies", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}
