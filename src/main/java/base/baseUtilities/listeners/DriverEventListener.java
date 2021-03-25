package base.baseUtilities.listeners;

import base.baseUtilities.BaseOperations;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

@Slf4j
public class DriverEventListener extends BaseOperations implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        log.debug("accepting alert");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        log.debug("alert accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        log.debug("alert dismissed");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        log.debug("dismissing alert");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        log.debug("navigating to " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        log.debug("navigated to " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        log.debug("navigating back");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        log.debug("navigated back");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        log.debug("navigating forward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        log.debug("navigated forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        log.debug("refreshing");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        log.debug("refreshed");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.debug("getting element " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        log.debug("element gotten " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        log.debug("clicking on element " + webElement.toString());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        log.debug("clicked on element " + webElement.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        log.debug("changing value of element " + webElement.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        log.debug("changed value of element " + webElement.toString());
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        log.debug("executing script \n" + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        log.debug("script executed \n" + s);
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        log.debug("switching to window " + s);
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        log.debug("switched to window " + s);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        log.debug("exception is thrown");
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        log.debug("making screenshot");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        log.debug("screenshot made");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        log.debug("getting text from element " + webElement.toString());
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        log.debug("text gotten <" + s + "> from element " + webElement.toString());
    }
}
