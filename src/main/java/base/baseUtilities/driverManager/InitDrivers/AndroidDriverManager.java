package base.baseUtilities.driverManager.InitDrivers;

import base.baseUtilities.PropertyConfig;
import base.baseUtilities.driverManager.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AndroidDriverManager extends DriverManager {

    private static PropertyConfig getProperty;
    @BeforeClass
    public void initClass() {
        String path = "/src/main/resources/config.properties";
        getProperty = new PropertyConfig(path);
    }

    @Override
    protected void createDriver() {
        driver = startAppiumServer();
    }

    public static AppiumDriverLocalService server;
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
}
