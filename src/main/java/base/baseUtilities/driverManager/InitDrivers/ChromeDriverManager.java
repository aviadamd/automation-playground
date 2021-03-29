package base.baseUtilities.driverManager.InitDrivers;

import base.baseUtilities.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Description;

import java.util.function.Supplier;

@Description("use as a class that extends DriverManager abstract class template")
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
