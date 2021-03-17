package base.utilities;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class Listeners extends BaseOperations implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.debug("------------------ start "
                + result.getName() + " ----------------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.debug("------------------ success "
                + result.getName() + " ----------------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.debug("------------------ fail "
                + result.getName() + " ----------------");
        if (driver != null) saveScreenShots();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.debug("------------------ skip "
                + result.getName() + " ----------------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.debug("------------------ fail with steps success "
                + result.getName() + " ----------------");
    }

    @Override
    public void onStart(ITestContext context) {
        log.debug("------------------ start "
                + context.getName() + " ----------------");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.debug("------------------ finish tests "
                + context.getName() + " ----------------");
    }

    @Attachment(value = "page screen shot", type = "image/png")
    public byte[] saveScreenShots() {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
}
