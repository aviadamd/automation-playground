package test.accountManagement;

import base.baseUtilities.Base;
import base.baseUtilities.BaseOperations;
import base.baseUtilities.listeners.ExtentReportListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

@Slf4j
@org.testng.annotations.Listeners({ExtentReportListener.class})
public class PrintTest extends BaseOperations {

    @Test(description = "test 01 : print test")
    @Description("print test")
    public void printMethod() {
        System.out.println("print form here " + getProperty.platformType);
    }
}
