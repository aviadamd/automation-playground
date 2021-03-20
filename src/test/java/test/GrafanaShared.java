package test;

import base.utilities.BaseOperations;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
        GrafanaShared.class
})
public class GrafanaShared extends BaseOperations {

    @Bean public GrafanaShared grafanaShared() { return new GrafanaShared();}

    @Step("Login grafana flow with {name} / {password}.")
    public void login(String name, String password) {
        uiActions().sendKeys(webUi.grafanaLoginPage.userNameEditText, name);
        uiActions().sendKeys(webUi.grafanaLoginPage.userPasswordEditText, password);
        uiActions().click(webUi.grafanaLoginPage.loginBtn);
    }
}
