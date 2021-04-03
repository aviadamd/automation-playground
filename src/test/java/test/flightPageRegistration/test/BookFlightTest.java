package test.flightPageRegistration.test;

import base.data.JsonReader;
import org.testng.annotations.Test;
import test.FactoryBaseTest;
import test.flightPageRegistration.components.*;

public class BookFlightTest extends FactoryBaseTest {

    @Test(priority = 1)
    public void registrationPage() {
        JsonReader jsonReader = new JsonReader();
        RegistrationComponent registrationComponent = new RegistrationComponent();
        registrationComponent.landingPage();
        String user = jsonReader.jsonData(1).userName;
        String password = jsonReader.jsonData(1).password;
        registrationComponent.enterUserDetails(user, password);
        registrationComponent.enterUserCredentials(user, password);
        registrationComponent.submit();
    }

    @Test(priority = 2, dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationComponent registrationConfirmationPage =
                new RegistrationConfirmationComponent();
        registrationConfirmationPage.goToFlightDetailsPage();
    }
}
