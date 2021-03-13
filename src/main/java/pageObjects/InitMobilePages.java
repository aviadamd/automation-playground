package pageObjects;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InitMobilePages {

    public InitMobilePages(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
