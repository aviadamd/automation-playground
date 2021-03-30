package base.driverManager;

import base.Base;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends Base {

    protected abstract void createDriver();
    protected abstract void stopDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            stopDriver();
            driver = null;
        }
    }
}
