package pages.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GrafanaSideMenu {

    @FindBy(how = How.XPATH, using = "/html/body/grafana-app/sidemenu/div[3]/div[1]/a/span")
    public WebElement discconectIcon;

    @FindBy(how = How.XPATH, using = "/html/body/grafana-app/sidemenu/div[3]/div[1]/ul/li[3]/a")
    public WebElement signOut;
}
