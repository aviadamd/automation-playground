package test.flightPageRegistration.test;

import base.baseUtilities.listeners.AllureListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test.BaseTest;
import test.flightPageRegistration.components.*;

@Listeners(AllureListeners.class)
public class BookFlightTest extends BaseTest {

    @Test
    public void registrationPage() {
        RegistrationComponent registrationPage = new RegistrationComponent();
        registrationPage.landingPage();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationComponent registrationConfirmationPage =
                new RegistrationConfirmationComponent();
        registrationConfirmationPage.goToFlightDetailsPage();
    }
}
