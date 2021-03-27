package base.utilities;

import base.baseUtilities.Base;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Collections;

@Slf4j
public class Verifications extends Base {

    public void load(ArrayList<WebElement> elements) {
        for (WebElement pageEle : elements) {
            utilities.uiActions().elementPresented(pageEle,5);
        }
    }

    public void load(WebElement element) {

        load(new ArrayList<>(Collections.singleton(element)));
    }

    public void verifyNumberOfElements(ArrayList<WebElement> elements, int numbers) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.until(
                    ExpectedConditions.visibilityOf(elements.get(elements.size() -1)));
            Assert.assertEquals(elements.size(), numbers);
        } catch (WebDriverException webDriverException) {
            log.debug(webDriverException.getMessage());
            Assert.fail(webDriverException.getMessage());
        }
    }

    private void compereTexts(ArrayList<WebElement> elements, ArrayList<String> text) {
        if (elements.size() != text.size())
            Assert.fail(elements.size() + " not equals to " + text.size());

        for (int i = 0; i < elements.size(); i++) {

            if (isTextEquals(elements.get(i),text.get(i))) {
                log.debug("actual text " + elements.get(i).getText() +
                        " equals expected test " + text.get(i));
            } else {
                log.debug("actual text " + elements.get(i).getText() +
                        " not equals expected test " + text.get(i));
            }
        }
    }

    private boolean isTextEquals(WebElement actual, String expectedText) {
        load(actual);
        String text = actual.getText().trim();
        return  text.equals(expectedText) ||
                text.contentEquals(expectedText) ||
                text.contains(expectedText);
    }
}