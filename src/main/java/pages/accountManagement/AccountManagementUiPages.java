package pages.accountManagement;

import org.openqa.selenium.WebDriver;

public class AccountManagementUiPages {
    private final AccountManagementLoginPage accountManagementLoginPage;

    public AccountManagementUiPages(WebDriver driver) {
        this.accountManagementLoginPage = new AccountManagementLoginPage(driver);
    }
    
    public AccountManagementLoginPage getAccountManagementLoginPage() {
        return accountManagementLoginPage;
    }
}
