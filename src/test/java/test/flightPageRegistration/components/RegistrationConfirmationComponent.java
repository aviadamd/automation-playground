package test.flightPageRegistration.components;

import lombok.extern.slf4j.Slf4j;
import test.BaseTest;

@Slf4j
public class RegistrationConfirmationComponent extends BaseTest {

    public void goToFlightDetailsPage() {
        utilities.uiActions().elementPresented(flightUi.registrationConfirmationPage.signinLink,5);
        utilities.uiActions().click(flightUi.registrationConfirmationPage.signinLink);
    }
}
