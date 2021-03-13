package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends CommonOperations implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("------------------ start "
                + result.getName() + " ----------------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("------------------ success "
                + result.getName() + " ----------------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("------------------ fail "
                + result.getName() + " ----------------");
        if (driver != null) saveScreenShots();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("------------------ skip "
                + result.getName() + " ----------------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("------------------ fail with steps success "
                + result.getName() + " ----------------");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("------------------ start "
                + context.getName() + " ----------------");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("------------------ finish tests "
                + context.getName() + " ----------------");
    }

    @Attachment(value = "page screen shot", type = "image/png")
    public byte[] saveScreenShots() {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
}
