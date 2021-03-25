package test.accountManagement;

import base.baseUtilities.BaseOperations;

public class AccountManagementShared extends BaseOperations {

    public void login(String name, String password) {
        uiActions().clickOptional(webUi.accountManagementLoginPage.bannerCookies_xBtn);
    }
}
