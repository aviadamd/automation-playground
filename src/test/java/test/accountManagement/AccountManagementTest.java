package test.accountManagement;

import base.baseUtilities.Listeners;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import test.TestMethodsObjects;

@Slf4j
@org.testng.annotations.Listeners({Listeners.class})
public class AccountManagementTest extends TestMethodsObjects {

    @Test(description = "test 01 : login to account management")
    @Description("login to account management with valid user name and pass word")
    public void printMethod() {
        log.debug("print form here");
    }
}
