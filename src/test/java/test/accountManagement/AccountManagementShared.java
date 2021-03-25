package test.accountManagement;

import base.baseUtilities.BaseOperations;
import org.springframework.context.annotation.Description;

public class AccountManagementShared extends BaseOperations {

    @Description("Login account management flow with username {0} and password {1}.")
    public void login(String name, String password) {
        uiActions().clickOptional(webUi.accountManagementLoginPage.bannerCookies_xBtn);
    }
}
