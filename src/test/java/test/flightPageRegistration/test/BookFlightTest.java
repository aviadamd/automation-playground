package test.flightPageRegistration.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;
import test.FactoryBaseTest;
import test.flightPageRegistration.components.*;

@SpringBootTest
public class BookFlightTest extends FactoryBaseTest {

    @Test(priority = 1)
    public void registrationPage() {
        RegistrationComponent registrationComponent = new RegistrationComponent();
        registrationComponent.landingPage();
        registrationComponent.enterUserDetails("selenium", "docker");
        registrationComponent.enterUserCredentials("selenium", "docker");
        registrationComponent.submit();
    }

    @Test(priority = 2, dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationComponent registrationConfirmationPage =
                new RegistrationConfirmationComponent();
        registrationConfirmationPage.goToFlightDetailsPage();
    }
}
