package base.baseUtilities.driverManager;

import base.baseUtilities.Base;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends Base {

    protected abstract void createDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
