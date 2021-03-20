package base.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
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
        test.log(Status.INFO, result.getMethod().getMethodName());
        log.debug("------------------ start "
                + result.getName() + " ----------------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getMethod().getMethodName() +
                " is pass");
        log.debug("------------------ success "
                + result.getName() + " ----------------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.debug("------------------ fail "
                + result.getName() + " ----------------");
        if (driver != null) saveScreenShots();
        test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        test.log(Status.FAIL, result.getMethod().getMethodName() +
                " is fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.debug("------------------ skip "
                + result.getName() + " ----------------");
        test.log(Status.SKIP, result.getMethod().getMethodName() +
                " is skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.debug("------------------ fail with steps success "
                + result.getName() + " ----------------");
    }

    @Override
    public void onStart(ITestContext context) {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        test = extent.createTest(context.getName());
        log.debug("------------------ start "
                + context.getName() + " ----------------");
        extent.setSystemInfo("os", "winos");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        log.debug("------------------ finish tests "
                + context.getName() + " ----------------");
    }

    @Attachment(value = "page screen shot", type = "image/png")
    public byte[] saveScreenShots() {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
}
