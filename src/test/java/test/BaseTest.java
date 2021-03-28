package test;

import base.baseUtilities.Base;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import test.flightPageRegistration.FlightUi;

@Slf4j
public class BaseTest extends Base {

//    public static FlightUi flightUi;
//
//    @BeforeClass(description = "start sessions")
//    public void beforeClass() {
//        String getPlatform = getProperty.platform;
//        switch (getPlatform) {
//            case "web" :
//                Base.initWebBrowser(getProperty.platformType);
//                Base.navigateTo(getProperty.url);
//                break;
//            case "mobile" :
//                driver = Base.startAppiumServer();
//                break;
//        }
//        log.debug("init " + getPlatform + " platform");
//        flightUi = new FlightUi(driver);
//    }
//
//    @AfterMethod(description = "after method")
//    public void afterMethod() {
//        String getPlatform = getProperty.platform;
//        switch (getPlatform) {
//            case "web":
//                log.debug("web after method " + getPlatform);
//                break;
//            case "mobile":
//                log.debug("mobile after method " + getPlatform);
//                break;
//        }
//    }
//
//    @AfterClass(description = "quit sessions")
//    public void afterClass() {
//        String getPlatform = getProperty.platform;
//        if (driver != null) {
//            switch (getPlatform) {
//                case "web":
//                    driver.close();
//                    break;
//                case "mobile":
//                    server.stop();
//                    driver.quit();
//                    break;
//            }
//        }
//    }
}
