package workFlows.grafana;

import extensions.UiActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOperations;

import java.util.LinkedHashMap;
import java.util.stream.Stream;

import static pageObjects.InitWebPages.grafanaLoginPage;
import static pageObjects.InitWebPages.grafanaSideMenu;

public class WebFlows extends CommonOperations {

    @Step("Login grafana flow with {name} / {password}.")
    public static void login(String name, String password) {
        UiActions.sendKeys(grafanaLoginPage.userNameEditText, name);
        UiActions.sendKeys(grafanaLoginPage.userPasswordEditText, password);
        UiActions.click(grafanaLoginPage.loginBtn);
    }

    @Step("Take grafana page screen shot")
    public static void takeGrafanaPageScreenShot() {
        LinkedHashMap<WebElement,String> eleAndDesc = new LinkedHashMap<>();
        eleAndDesc.put(grafanaLoginPage.loginBtn,"loginBtn");
        eleAndDesc.put(grafanaLoginPage.userNameEditText,"userNameEditText");
        eleAndDesc.put(grafanaLoginPage.userPasswordEditText,"userPassEditText");
        eleAndDesc.forEach(UiActions::elementScreenShot);
    }

    @Step("Log out from grafana")
    public static void logOut() {
        Stream.of(grafanaSideMenu.discconectIcon, grafanaSideMenu.signOut)
                .sequential()
                .filter(UiActions::elementPresented)
                .forEach(UiActions::click);
    }
}
