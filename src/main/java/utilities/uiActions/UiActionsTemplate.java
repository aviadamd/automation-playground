package utilities.uiActions;

import utilities.verfications.Verifications;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.function.BiConsumer;

public interface UiActionsTemplate {

    void perform(String text, BiConsumer<UiActions, Verifications> actionsConsumer);

    void click(WebElement element);

    void clickOptional(WebElement element);

    boolean elementPresented(WebElement element, int timeOut);

    boolean elementToBeClickable(WebElement element);

    void sendKeys(WebElement element, String text);

    void selectByVisibleText(WebElement element, String text);

    void selectByValue(WebElement element, String value);

    void mouseHoverElements(WebElement element1, WebElement element2);

    <T> boolean webDriverWait(int timeOut, ExpectedCondition<T> conditions, WebElement element);

    void clear(WebElement element);
}
