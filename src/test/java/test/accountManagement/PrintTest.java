package test.accountManagement;

import base.baseUtilities.BaseOperations;
import base.baseUtilities.listeners.AllureListeners;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
@org.testng.annotations.Listeners({AllureListeners.class})
public class PrintTest extends BaseOperations {

    @Test(description = "test 01 : print test")
    @Description("print test")
    public void printMethod() {
        System.out.println("type platform " + getProperty.platform);
        System.out.println("type platform " + getProperty.platformType);
    }
}
