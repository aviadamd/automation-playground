package base.baseUtilities.driverManager.InitDrivers;

import base.baseUtilities.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.function.Supplier;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createDriver() { firefoxDriverSupplier.get(); }

    private final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(firefoxOptions());
        return driver;
    };

    private static FirefoxOptions firefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("disable-restore-session-state");
        return firefoxOptions;
    }
}
