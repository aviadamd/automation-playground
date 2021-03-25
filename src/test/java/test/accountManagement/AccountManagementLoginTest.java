package test.accountManagement;

import base.baseUtilities.listeners.ExtentReportListener;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test.TestMethodsObjects;

@Listeners({ExtentReportListener.class})
public class AccountManagementLoginTest extends TestMethodsObjects {

    @Test(description = "test 01 : login to account management")
    @Description("login to account management with valid user name and pass word")
    public void test01_login() {
        accountManagementShared().login("admin", "5311072BsDvir");
    }
}
