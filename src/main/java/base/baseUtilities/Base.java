package base.baseUtilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Base {

    public static String mobile;
    public static String platform;
    public static String typeFromPlatform;
    public static String url;
    public static String localBin;
    public static String androidSdk;
    public static String nodeJs;
    public static String appPath;
    public static WebDriver driver;
    public static Properties prop;
    public static AppiumDriverLocalService server;
    public static Screenshot imageScreenShot;
    public static ImageDiff imageDiff;
    public ImageDiffer imageDiffer = new ImageDiffer();

    @SneakyThrows
    public Base() {
        prop = new Properties();
        final String path = "/src/main/resources/config.properties";
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + path);
        prop.load(ip);
        mobile = getProperties("mobile");
        platform = getProperties("platform");
        typeFromPlatform = getProperties("typeFromPlatform");
        url = getProperties("url");
        localBin = getProperties("localBin");
        androidSdk = getProperties("androidSdk");
        nodeJs = getProperties("nodeJs");
        appPath = getProperties("appPath");
        ip.close();
    }

    private static String getProperties(String proName) {
        if (System.getProperty(proName) != null)
             return System.getProperty(proName);
        else return prop.getProperty(proName);
    }

    protected static WebDriver startAppiumServer() {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", localBin + System.getenv("PATH"));
        environment.put("ANDROID_HOME", androidSdk);

        DesiredCapabilities capabilities = initCapabilities();
        server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodeJs))
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

    protected static WebDriver initFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

}
