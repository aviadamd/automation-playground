package test.accountManagement;

import base.baseUtilities.BaseOperations;
import io.qameta.allure.Step;

public class AccountManagementShared extends BaseOperations {

    @Step("Login account management flow with {name} / {password}.")
    public void login(String name, String password) {
        uiActions().clickOptional(webUi.accountManagementLoginPage.bannerCookies_xBtn);
//        uiActions().sendKeys(webUi.accountManagementLoginPage.userNameEditText, name);
//        uiActions().sendKeys(webUi.accountManagementLoginPage.userPasswordEditText, password);
//        uiActions().click(webUi.accountManagementLoginPage.loginBtn);
    }
}
