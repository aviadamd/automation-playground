package base;

import base.data.JsonReader;
import utilities.UiUtilitiesObjects;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Base {

    public static WebDriver driver;
    public static PropertyConfig getProperty;
    public static JsonReader jsonReader;
    public static UiUtilitiesObjects utilities;
    public static Screenshot imageScreenShot;
    public static ImageDiff imageDiff;
    public ImageDiffer imageDiffer = new ImageDiffer();

    @BeforeClass
    public void initClass() {
        String path = "/src/main/resources/config.properties";
        getProperty = new PropertyConfig(path);
        utilities = new UiUtilitiesObjects();
        jsonReader = new JsonReader();
    }

    protected static void navigateToUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
