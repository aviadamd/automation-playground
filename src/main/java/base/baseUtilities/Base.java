package base.baseUtilities;

import base.utilities.UiUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import java.io.File;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Base {

    public static WebDriver driver;
    public static PropertyConfig getProperty;
    public static UiUtilities utilities;
    public static AppiumDriverLocalService server;
    public static Screenshot imageScreenShot;
    public static ImageDiff imageDiff;
    public ImageDiffer imageDiffer = new ImageDiffer();

    @BeforeClass
    public void initClass() {
        String path = "/src/main/resources/config.properties";
        getProperty = new PropertyConfig(path);
        utilities = new UiUtilities();
    }

    protected static void initWebBrowser(String browser) {
        switch (browser) {
            case "chrome":
                driver = initChromeDriver(chromeOptionsDisableBeforeLaunch());
                break;
            case "firefox":
                driver = initFireFoxDriver(firefoxOptions());
                break;
        }
        log.debug("init " + browser + " type platform");
    }

    protected static void navigateTo(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected static WebDriver startAppiumServer() {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", getProperty.localBin + System.getenv("PATH"));
        environment.put("ANDROID_HOME", getProperty.androidSdk);

        DesiredCapabilities capabilities = initCapabilities();
        server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(getProperty.nodeJs))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                .withEnvironment(environment)
                .withCapabilities(capabilities)
                .withStartUpTimeOut(20, TimeUnit.SECONDS));
        server.start();
        return new AndroidDriver<>(server.getUrl(), capabilities);
    }

    protected static DesiredCapabilities initCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"device");
        capabilities.setCapability(MobileCapabilityType.APP,"app path");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");
        return capabilities;
    }

    protected static WebDriver initChromeDriver(ChromeOptions options) {
        WebDriverManager.chromedriver().setup();
        if (Optional.ofNullable(options).isPresent())
            return new ChromeDriver(options);
        return new ChromeDriver();
    }

    protected static WebDriver initFireFoxDriver(FirefoxOptions options) {
        WebDriverManager.firefoxdriver().setup();
        if (Optional.ofNullable(options).isPresent())
            return new FirefoxDriver(options);
        return new FirefoxDriver();
    }

    public static FirefoxOptions firefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("disable-restore-session-state");
        return firefoxOptions;
    }

    public static ChromeOptions chromeOptionsDisableBeforeLaunch() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-extensions");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

    private MutableCapabilities setCookiesConfig(int setValue) {
        HashMap<String, Object> prefs = new HashMap<>();
        //1 - enable , 2 - disable
        prefs.put("profile.default_content_setting_values.cookies",setValue);
        prefs.put("network.cookie.cookieBehavior",setValue);
        if (setValue == 1)
            prefs.put("profile.block_third_party_cookies", true);
        else prefs.put("profile.block_third_party_cookies", false);
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("prefs", prefs);
        return capabilities;
    }
}
