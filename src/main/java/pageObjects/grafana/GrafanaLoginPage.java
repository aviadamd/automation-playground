package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GrafanaLoginPage {

    @FindBy(how = How.NAME, using = "user")
    public WebElement userNameEditText;

    @FindBy(how = How.NAME, using = "password")
    public WebElement userPasswordEditText;

    @FindBy(how = How.XPATH, using = "/html/body/grafana-app/div/div/react-container/div/div/div[2]/div/div/form/button")
    public WebElement loginBtn;


}
