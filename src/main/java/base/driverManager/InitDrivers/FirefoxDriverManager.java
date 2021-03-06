package base.driverManager.InitDrivers;

import base.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.context.annotation.Description;

import java.util.function.Supplier;

@Description("use as a class that extends DriverManager abstract class template")
public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createDriver() { firefoxDriverSupplier.get(); }

    @Override
    protected void stopDriver() {
        driver.quit();
    }

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
