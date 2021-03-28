package test.flightPageRegistration.test;

import org.testng.annotations.Test;
import test.FactoryBaseTest;
import test.flightPageRegistration.components.*;

public class BookFlightTest extends FactoryBaseTest {

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
