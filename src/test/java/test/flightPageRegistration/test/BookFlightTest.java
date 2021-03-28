package test.flightPageRegistration.test;

import org.testng.annotations.Test;
import test.FactoryBaseTest;
import test.flightPageRegistration.components.*;

public class BookFlightTest extends FactoryBaseTest {

    @Test(priority = 1)
    public void registrationPage() {
        RegistrationComponent registrationPage = new RegistrationComponent();
        registrationPage.landingPage();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.submit();
    }

    @Test(priority = 2, dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationComponent registrationConfirmationPage =
                new RegistrationConfirmationComponent();
        registrationConfirmationPage.goToFlightDetailsPage();
    }
}
