package test.accountManagement;

import org.testng.annotations.Test;

public class AccountManagementLoginTest extends AccountManagementFlows {

    @Test(priority = 1, description = "test 01 : login to account management")
    public void test01_login() {
        login("!wiz1017", "!abs12345");
        utilities.uiActions().clickOptional(
                accountManagementUi.getAccountManagementLoginPage().bannerCookies_xBtn);
    }

    @Test(priority = 2, description = "test 02 : login to account management")
    public void test02_login() {
        login("!wiz1017", "1abs12345");
        utilities.uiActions().clickOptional(
                accountManagementUi.getAccountManagementLoginPage().bannerCookies_xBtn);
    }
}
