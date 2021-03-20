package test.grafana;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import base.baseUtilities.Listeners;
import test.TestMethodsObjects;

@org.testng.annotations.Listeners({Listeners.class})
public class GrafanaLoginTest extends TestMethodsObjects {

    @Test(description = "test 01 : login to grafana")
    @Description("login to grafana with valid user name and pass word")
    public void test01_login() {
        grafanaShared().login("admin", "5311072BsDvir");
    }

}
