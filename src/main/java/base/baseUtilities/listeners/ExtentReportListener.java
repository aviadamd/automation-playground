package base.baseUtilities.listeners;

import base.baseUtilities.BaseOperations;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String;

@Slf4j
public class ExtentReportListener extends BaseOperations implements ITestListener {

    private static ExtentSparkReporter spark;
    private static ExtentReports extent;
    private static ExtentTest test;

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
        log.error("fail " + result.getName());
        try {
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
          //  test.log(Status.WARNING, result.getName() + "Test Case Failed",
            //        createScreenCaptureFromBase64String(screenshot(result.getName(),driver)).build());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        String error =
                "<details>"
                        + "<summary>"
                        + "<b>"
                        + "<font color="
                        + "red>"
                        + "Exception :Click to see"
                        + "</font>"
                        + "</b>"
                        + "</summary>"
                        + Arrays.toString(result.getThrowable()
                        .getStackTrace()).replace(",", "<br>")
                        + "</details> \n"
                        + "</summary>";
        test.log(Status.FAIL, MarkupHelper.createLabel(error, ExtentColor.BLUE));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.debug("skip " + result.getName());
        test.log(Status.SKIP, result.getMethod().getMethodName()+ " is skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.debug("fail with steps success " + result.getName());
        test.log(Status.WARNING,"fail with steps success " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        test = extent.createTest(context.getName());
        log.debug("start " + context.getName());
        extent.setSystemInfo("os", "winos");
        extent.setSystemInfo("Automation Tests", "Demo");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setEncoding("utf-8");
        spark.getReport().getStartTime();
    }

    @Override
    public void onFinish(ITestContext context) {
        log.debug("finish tests " + context.getName());
        spark.getReport().getEndTime();
        extent.flush();
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    private static String screenshot(String screenName,WebDriver driver) throws Exception {
        String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"/Report/"+screenName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
}
