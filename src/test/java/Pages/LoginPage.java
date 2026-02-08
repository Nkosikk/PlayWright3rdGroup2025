package Pages;

import com.microsoft.playwright.Page;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

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
        return this;
    }

    public void verifyToken(Page page) {

        // Wait until authToken exists in localStorage
        page.waitForFunction(
                "() => window.localStorage.getItem('authToken') !== null"
        );

        // Read token from localStorage
        String token =(String) page.evaluate(
                "() => window.localStorage.getItem('authToken')"
        );

        assertNotNull("Token should exist in localStorage", token);

        System.out.println("Token after login: " + token);
    }

    public void verifyTokenIsNull(Page page) {

        // No wait here — we EXPECT it to be null
        Object token = page.evaluate(
                "() => window.localStorage.getItem('authToken')"
        );

        assertNull("Token should NOT exist in localStorage for failed login", token);

        System.out.println("Token is null as expected after failed login");
    }



}
