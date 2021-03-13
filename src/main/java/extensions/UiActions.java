package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import utilities.CommonOperations;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class UiActions extends CommonOperations {

    @Step("Verify element clickable")
    public static void elementToBeClickable(WebElement element) {
        try {
            CommonOperations.webDriverWait(10)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException  driverException) {
            System.out.println("");
        }
    }

    @Step("Click action")
    public static void click(WebElement element) {
        try {
            System.out.println("Click on " + element);
            elementToBeClickable(element);
            element.click();
        } catch (WebDriverException  driverException) {
            Assert.fail("Fail click ", driverException);
        }
    }

    @Step("Verify is element presented")
    public static boolean elementPresented(WebElement element) {
        try {
            CommonOperations.webDriverWait(10)
                    .until(ExpectedConditions.visibilityOf(element));
            System.out.println(element + " is visible");
            return true;
        } catch (WebDriverException e) {
            System.out.println(element.toString() + " not presented");
            return false;
        }
    }

    @Step("Send keys to element")
    public static void sendKeys(WebElement element, String text) {
        try {
            elementToBeClickable(element);
            element.sendKeys(text);
            System.out.println("Send " + text + " to " + element);
        } catch (WebDriverException driverException) {
            Assert.fail("Fail send keys ", driverException);
        }
    }

    @Step("Drop down to element by text")
    public static void updateDropDown(WebElement element, String text) {
        Select value = new Select(element);
        value.selectByVisibleText(text);
        Verfications.load(element);
    }

    @Step("Mouse over elements")
    public static void mouseHoverElements(WebElement element1, WebElement element2) {
        UiActions.elementPresented(element1);
        new Actions(driver).moveToElement(element1).moveToElement(element2)
                .click().build().perform();
    }

    @Step("Take web element screen shot")
    public static void elementScreenShot(WebElement imageElement, String imageName) {
        try {
            imageScreenShot = new AShot()
                    .coordsProvider(new WebDriverCoordsProvider())
                    .takeScreenshot(driver,imageElement);
            ImageIO.write(imageScreenShot.getImage(),"png", new File("./imageRepository/" + imageName));
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

}
