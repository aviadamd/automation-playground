package test.accountManagement;

import base.baseUtilities.BaseOperations;
import io.qameta.allure.Step;

public class AccountManagementShared extends BaseOperations {

    @Step("Login account management flow with username {0} and password {1}.")
    public void login(String name, String password) {
        uiActions().clickOptional(webUi.accountManagementLoginPage.bannerCookies_xBtn);
    }
}
