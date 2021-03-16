package grafanas;

import utilities.config.objects.SharedMethods;
import io.qameta.allure.Step;

public class GrafanaShared extends SharedMethods {

    @Step("Login grafana flow with {name} / {password}.")
    public void login(String name, String password) {
        uiActions().sendKeys(webUi.grafanaLoginPage.userNameEditText, name);
        uiActions().sendKeys(webUi.grafanaLoginPage.userPasswordEditText, password);
        uiActions().click(webUi.grafanaLoginPage.loginBtn);
    }
}
