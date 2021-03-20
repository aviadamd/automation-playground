package base.utilities;

import base.baseUtilities.BaseOperations;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.function.BiConsumer;

@Slf4j
public class UiActions extends BaseOperations {

    @Step("perform step action")
    public void perform(String text, BiConsumer<UiActions,Verfications> actionsConsumer) {
        log.debug(text);
        actionsConsumer.accept(uiActions(), verfications());
    }

    @Step("verify element {0} is clickable")
    public void elementToBeClickable(WebElement element) {
        try {
            BaseOperations.webDriverWait(10)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException driverException) {
            log.debug("fail , element is not clickable " + driverException.getMessage());
        }
    }

    @Step("click action on {0} element")
    public void click(WebElement element) {
        try {
            elementToBeClickable(element);
            log.debug("click on " + element.getText());
            element.click();
        } catch (WebDriverException  driverException) {
            Assert.fail("Fail click ", driverException);
        }
    }

    @Step("click action on {0} element")
    public void clickOptional(WebElement element) {
        try {
            if (elementPresented(element,5)) element.click();
        } catch (WebDriverException  driverException) {
            log.debug(element.toString() + " not presented");
        }
    }

    @Step("verify is {0} element is presented")
    public boolean elementPresented(WebElement element, int timeOut) {
        try {
            BaseOperations.webDriverWait(timeOut)
                    .until(ExpectedConditions.visibilityOf(element));
            log.debug(element.getText() + " is visible");
            return true;
        } catch (WebDriverException e) {
            log.debug(element.toString() + " not presented");
            return false;
        }
    }

    @Step("send {1} keys to element {0}")
    public void sendKeys(WebElement element, String text) {
        try {
            clickOptional(element);
            element.sendKeys(text);
            log.debug("Send " + text + " to " + element.getText());
        } catch (WebDriverException driverException) {
            Assert.fail("Fail send keys ", driverException);
        }
    }

    @Step("drop down to element by text")
    public void updateDropDown(WebElement element, String text) {
        Select value = new Select(element);
        value.selectByVisibleText(text);
        verfications().load(element);
    }

    @Step("mouse over elements")
    public void mouseHoverElements(WebElement element1, WebElement element2) {
        elementPresented(element1,5);
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).moveToElement(element2)
                .click().build().perform();
    }

    @Step("take web element screen shot")
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
