package test.accountManagement;

import org.testng.annotations.Test;
import test.TestMethodsObjects;

public class AccountManagementLoginTest extends TestMethodsObjects {

    @Test(description = "test 01 : login to account management")
    public void test01_login() {
        accountManagementShared().login("admin", "5311072BsDvir");
    }
}
