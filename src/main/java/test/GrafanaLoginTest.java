package test;

import base.utilities.BaseOperations;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import base.utilities.Listeners;

@org.testng.annotations.Listeners({Listeners.class})
public class GrafanaLoginTest extends BaseOperations {

    @Test(description = "test 01 : login to grafana")
    @Description("login to grafana with valid user name and pass word")
    public void test01_login() {
        grafanaShared().login("admin", "5311072BsDvir");
    }

}
