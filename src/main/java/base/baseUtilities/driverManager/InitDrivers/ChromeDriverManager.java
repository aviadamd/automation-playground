package base.baseUtilities.driverManager.InitDrivers;

import base.baseUtilities.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.function.Supplier;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createDriver() {
        chromeDriverSupplier.get();
    }

    private final Supplier<WebDriver> chromeDriverSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptionsDisableBeforeLaunch());
        return driver;
    };

    private ChromeOptions chromeOptionsDisableBeforeLaunch() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-extensions");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }
}
