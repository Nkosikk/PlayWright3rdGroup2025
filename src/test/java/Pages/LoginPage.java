package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;

    private String emailInputLocator = "#login-email";
    private String passwordInputLocator = "#login-password";
    private String submitButtonLocator = "#login-submit";

    public LoginPage(Page page){
        this.page = page;
    }

    public LoginPage enterEmail(String email) {
        page.fill(emailInputLocator, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        page.fill(passwordInputLocator, password);
        return this;
    }

    public LoginPage clickSubmitButton() {
        page.click(submitButtonLocator);
        return new LoginPage(page);
    }

}
