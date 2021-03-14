package workFlows.grafana;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.CommonOperations;
import utilities.Listeners;

@org.testng.annotations.Listeners({Listeners.class})
public class GrafanaLoginTest extends CommonOperations {

    private String user;
    private String password;

    @BeforeTest
    @Parameters({"user", "password"})
    public void setupParameters(@Optional String user,@Optional String password){
        this.user = user;
        this.password = password;
    }

    @Test(description = "test 01 : login to grafana")
    @Description("login to grafana with valid user name and pass word")
    public void test01_login() {
        GrafanaShared.login(user, password);
    }

}
