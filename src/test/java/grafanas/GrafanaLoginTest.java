package grafanas;

import utilities.config.objects.SharedMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.Listeners;

@org.testng.annotations.Listeners({Listeners.class})
public class GrafanaLoginTest extends SharedMethods {

    @Test(description = "test 01 : login to grafana")
    @Description("login to grafana with valid user name and pass word")
    public void test01_login() {

        //Allure.addAttachment("demo print","air please");
        GrafanaShared grafanaShared = new GrafanaShared();
        grafanaShared.login("admin", "5311072BsDvir");
    }

}
