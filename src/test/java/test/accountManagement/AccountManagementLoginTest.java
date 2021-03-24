package test.accountManagement;

import base.baseUtilities.listeners.AllureListeners;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test.TestMethodsObjects;

@Listeners({AllureListeners.class})
public class AccountManagementLoginTest extends TestMethodsObjects {

    @Test(description = "test 01 : login to account management")
    @Description("login to account management with valid user name and pass word")
    public void test01_login() {
        accountManagementShared().login("admin", "5311072BsDvir");
        uiActions().click(webUi.accountManagementLoginPage.loginBtn);
    }
}
