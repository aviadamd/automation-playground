package base.baseUtilities;

import base.utilities.JavaScriptUtil;
import base.utilities.UiActions;
import base.utilities.Verfications;
import base.utilities.config.data.Properties;
import base.utilities.config.objects.SharedObjects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import base.utilities.config.data.JsonReader;

import java.io.File;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@Configuration
@SpringBootApplication
@EnableAspectJAutoProxy
@ContextConfiguration(classes = {
  //      base.utilities.config.objects.SharedObjects.class,
        UiActions.class,
        Verfications.class,
        JavaScriptUtil.class,
        JsonReader.class,
        Properties.class
})
//@ComponentScan(basePackages = {"org.automation.project"})
public class Base {

    public static WebDriver driver;
    //@Autowired public SharedObjects sharedObjects;
   // @Bean public SharedObjects sharedObjects() {
     //   return new SharedObjects();
   // }
    public static AppiumDriverLocalService server;
    public static Screenshot imageScreenShot;
    public static ImageDiff imageDiff;
    public ImageDiffer imageDiffer = new ImageDiffer();
    //public static ExtentSparkReporter spark;
    //public static ExtentReports extent;
    //public static ExtentTest test;

    protected static WebDriver startAppiumServer() {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", new JsonReader().jsonPath(0).localBin + System.getenv("PATH"));
        environment.put("ANDROID_HOME", new JsonReader().jsonPath(0).androidSdk);

        DesiredCapabilities capabilities = initCapabilities();
        server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(new JsonReader().jsonPath(0).nodeJs))
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
