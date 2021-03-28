package base.baseUtilities.driverManager.InitDrivers;

import base.baseUtilities.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(firefoxOptions());
    }

    private static FirefoxOptions firefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("disable-restore-session-state");
        return firefoxOptions;
    }
}
