package Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private String usernameField = "input[name='username']";
    private String passwordField = "input[name='password']";
    private String loginButton = "#submit-btn";
    private String loginPageTitle = "text=You have successfully logged in. This is what users see after successful authentication.";
    public LoginPage(Page page) {
        this.page = page;
    }

    public LoginPage EnterUsername(String username) {
        page.fill(usernameField, username);
        return this;
    }

    public LoginPage EnterPassword(String password) {
        page.fill(passwordField, password);
        return this;
    }

    public HomePage clickLoginButton() {
        page.click(loginButton);
        page.isVisible(loginPageTitle);
        return new HomePage(page);
    }

    public boolean isLoginSuccessVisible() {
        //wait for the login success message to be visible
        page.waitForSelector(loginPageTitle);
        return page.isVisible(loginPageTitle);
    }
}
