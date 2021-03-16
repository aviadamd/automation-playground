package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InitWebPages {

    public InitWebPages(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
