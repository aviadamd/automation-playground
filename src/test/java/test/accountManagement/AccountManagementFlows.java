package test.accountManagement;

import base.baseUtilities.BaseOperations;

public class AccountManagementFlows extends BaseOperations {

    public void login(String name, String password) {
        utilities.uiActions().clickOptional(
                accountManagementUi.getAccountManagementLoginPage().bannerCookies_xBtn);
    }
}
