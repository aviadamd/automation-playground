package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.CommonOperations;

import java.util.ArrayList;
import java.util.Collections;

import static extensions.UiActions.elementPresented;

public class Verfications extends CommonOperations {

    @Step("Load page or elements")
    public static void load(ArrayList<WebElement> elements) {
        for (WebElement pageEle : elements) {
            elementPresented(pageEle);
        }
    }

    @Step("Load page or single element")
    public static void load(WebElement element) {
        load(new ArrayList<>(Collections.singleton(element)));
    }

    @Step("Verify number of elements within page or element")
    public static void verifyNumberOfElements(ArrayList<WebElement> elements, int numbers) {
        webDriverWait(10)
                .until(ExpectedConditions.visibilityOf(elements.get(elements.size() -1)));
        Assert.assertEquals(elements.size(), numbers);
    }

    @Step("Compere texts")
    private static void compereTexts(ArrayList<WebElement> elements, ArrayList<String> text) {
        if (elements.size() != text.size())
            Assert.fail(elements.size() + " not equals to " + text.size());

        for (int i = 0; i < elements.size(); i++) {

            if (isTextEquals(elements.get(i),text.get(i))) {
                System.out.println("actual text " + elements.get(i).getText() +
                        " equals expected test " + text.get(i));
            } else {
                System.out.println("actual text " + elements.get(i).getText() +
                        " not equals expected test " + text.get(i));
            }
        }
    }

    private static boolean isTextEquals(WebElement actual, String expectedText) {
        load(actual);
        String text = actual.getText().trim();
        return  text.equals(expectedText) ||
                text.contentEquals(expectedText) ||
                text.contains(expectedText);
    }
}
