package base.baseUtilities.listeners;

import base.baseUtilities.BaseOperations;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class AllureListeners extends BaseOperations implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.debug("test start method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.debug("test success method " + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.debug("fail " + result.getName());
        saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
        saveScreenshotPNG(driver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.debug("skip " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.debug("fail with steps success " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        log.debug("start " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.debug("finish tests " + context.getName());
    }

    // Image attachment for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {

        return html;
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
}
