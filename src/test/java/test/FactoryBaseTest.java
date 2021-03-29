package test;

import base.Base;
import base.driverManager.DriverManager;
import base.driverManager.DriverManagerFactory;
import org.testng.annotations.*;
import test.flightPageRegistration.FlightUi;

public class FactoryBaseTest extends Base {

    private DriverManager driverManager;
    public static FlightUi flightUi;

    @BeforeClass(description = "start sessions")
    public void beforeClass() {
        driverManager = DriverManagerFactory.getManager(getProperty.platformType);
        driver = driverManager.getDriver();
        navigateToUrl(getProperty.url);
        flightUi = new FlightUi(driver);
    }

    @AfterClass(description = "quit sessions")
    public void afterClass() {

        driverManager.quitDriver();
    }
}
