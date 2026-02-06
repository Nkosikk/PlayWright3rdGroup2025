package Tests;

import Base.BaseTests;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends BaseTests {

    @Test
    public void loginWithInValidCredentials() {
        homePage.clickLoginButton();

        page.onceDialog(dialog -> {
            assert dialog.message().equals("Invalid credentials. Please try again.")
                    : "Unexpected alert message!";
            dialog.accept();
        });

        loginPage.enterEmail("Elizabeth@england.com")
                .enterPassword("wrongpassword")
                .clickSubmitButton();

    }

    @Test
    public void loginWithValidCredentials() {
        homePage.clickLoginButton();
        loginPage.enterEmail("Elizabeth@england.com")
                .enterPassword("England@123")
                .clickSubmitButton();

        String welcomeMessage = homePage.getWelcomeMessage();
        assert welcomeMessage.equals("Here's an overview of your learning journey") : "Welcome message does not match!";

        homePage.clickUserMenuButton()
                .clickLogout();

    }


}
