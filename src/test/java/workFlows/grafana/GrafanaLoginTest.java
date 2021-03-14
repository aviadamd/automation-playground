package workFlows.grafana;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOperations;
import utilities.Listeners;

@org.testng.annotations.Listeners({Listeners.class})
public class GrafanaLoginTest extends CommonOperations {

    @Test(description = "test 01 : login to grafana")
    @Description("login to grafana with valid user name and pass word")
    public void test01_login() {
        GrafanaShared.login("admin", "5311072BsDvir");
    }

}
