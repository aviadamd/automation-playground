package base.utilities;

import base.baseUtilities.BaseOperations;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.function.BiConsumer;

@Slf4j
public class UiActions extends BaseOperations {

    public void perform(String text, BiConsumer<UiActions,Verfications> actionsConsumer) {
        log.debug(text);
        actionsConsumer.accept(uiActions(), verfications());
    }

    public void elementToBeClickable(WebElement element) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException driverException) {
            log.debug("fail , element is not clickable " + driverException.getMessage());
        }
    }

    public void click(WebElement element) {
        try {
            elementToBeClickable(element);
            log.debug("click on " + element.getText());
            element.click();
        } catch (WebDriverException  driverException) {
            Assert.fail("Fail click ", driverException);
        }
    }

    public void clickOptional(WebElement element) {
        try {
            if (elementPresented(element,5)) element.click();
        } catch (WebDriverException  driverException) {
            log.debug(element.toString() + " not presented");
        }
    }

    public boolean elementPresented(WebElement element, int timeOut) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,timeOut);
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            log.debug(element.getText() + " is visible");
            return true;
        } catch (WebDriverException e) {
            log.debug(element.toString() + " not presented");
            return false;
        }
    }

    public void sendKeys(WebElement element, String text) {
        try {
            clickOptional(element);
            element.sendKeys(text);
            log.debug("Send " + text + " to " + element.getText());
        } catch (WebDriverException driverException) {
            Assert.fail("Fail send keys ", driverException);
        }
    }

    public void updateDropDown(WebElement element, String text) {
        Select value = new Select(element);
        value.selectByVisibleText(text);
        verfications().load(element);
    }

    public void mouseHoverElements(WebElement element1, WebElement element2) {
        elementPresented(element1,5);
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).moveToElement(element2)
                .click().build().perform();
    }

    public void elementScreenShot(WebElement imageElement, String imageName) {
        try {
            imageScreenShot = new AShot()
                    .coordsProvider(new WebDriverCoordsProvider())
                    .takeScreenshot(driver,imageElement);
            ImageIO.write(imageScreenShot.getImage(),"png",
                    new File("./imageRepository/" + imageName));
        } catch (IOException ioException) {
            log.debug(ioException.getMessage());
        }
    }

    public void clear(WebElement element) {
        click(element);
        element.clear();
    }

}
