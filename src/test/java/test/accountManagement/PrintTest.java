package test.accountManagement;

import base.baseUtilities.listeners.AllureListeners;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
@org.testng.annotations.Listeners({AllureListeners.class})
public class PrintTest {

    @Test(description = "test 01 : print test")
    @Description("print test")
    public void printMethod() {
        log.info("print form here");
    }
}
