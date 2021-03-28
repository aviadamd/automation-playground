package base.baseUtilities.driverManager;

import base.baseUtilities.Base;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DriverManagerFactory extends Base {

    public static DriverManager getManager(String type) {
        DriverManager driverManager;
        switch (type) {
            case "chrome":
                driverManager = new ChromeDriverManager();
                break;
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            case "android":
                driverManager = new AndroidDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        log.debug("init " + type + " before test");
        return driverManager;
    }
}
