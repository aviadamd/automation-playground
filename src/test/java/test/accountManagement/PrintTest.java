package test.accountManagement;

import base.baseUtilities.Listeners;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
@org.testng.annotations.Listeners({Listeners.class})
public class PrintTest {

    @Test(description = "test 01 : print test")
    @Description("print test")
    public void printMethod() {
        log.debug("print form here");
    }
}
