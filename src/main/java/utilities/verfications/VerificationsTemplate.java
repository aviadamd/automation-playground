package utilities.verfications;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;

public interface VerificationsTemplate {
    void load(WebElement element);
    void load(ArrayList<WebElement> elements);
    void verifyNumberOfElements(ArrayList<WebElement> elements, int numbers);
    boolean compereTexts(ArrayList<WebElement> elements, ArrayList<String> text);
    boolean isTextEquals(WebElement actual, String expectedText);
}
