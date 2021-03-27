package test.flightPageRegistration.components;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import test.BaseTest;

@Slf4j
public class RegistrationComponent extends BaseTest {

    public void landingPage(){
        utilities.uiActions().elementPresented(flightUi.registrationPage.firstNameTxt,5);
    }

    private void sendKeys(WebElement element, String key) {
        element.sendKeys(key);
        System.out.println("send " + key + " to " + element.toString());
    }

    public void enterUserDetails(String firstName, String lastName){
        sendKeys(flightUi.registrationPage.firstNameTxt, firstName);
        sendKeys(flightUi.registrationPage.lastNameTxt, lastName);
    }

    public void enterUserCredentials(String username, String password){
        sendKeys(flightUi.registrationPage.usernameTxt, username);
        sendKeys(flightUi.registrationPage.passwordTxt, password);
        sendKeys(flightUi.registrationPage.confirmPasswordTxt, password);
    }

    public void submit(){
        utilities.uiActions()
                .click(flightUi.registrationPage.submitBtn);
    }
}
