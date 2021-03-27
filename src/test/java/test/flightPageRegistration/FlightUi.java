package test.flightPageRegistration;

import org.openqa.selenium.WebDriver;
import test.flightPageRegistration.pages.*;

public class FlightUi {

    public RegistrationConfirmationPage registrationConfirmationPage;
    public RegistrationPage registrationPage;

    public FlightUi(WebDriver driver) {
        this.registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        this.registrationPage = new RegistrationPage(driver);
    }
}
