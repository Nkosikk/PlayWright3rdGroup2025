package Tests;

import Base.BaseTests;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test
    public void loginWithInValidPassword() {
        homePage.clickLoginButton();

        loginPage.enterEmail("Elizabeth@england.com")
                .enterPassword("wrongpassword")
                .clickSubmitButton();

        loginPage.verifyTokenIsNull(page);

    }

    @Test
    public void loginWithInValidEmail() {
        homePage.clickLoginButton();

        loginPage.enterEmail("Uknown@england.com")
                .enterPassword("England@123")
                .clickSubmitButton();

        loginPage.verifyTokenIsNull(page);

    }

    @Test
    public void loginWithInValidEmailAndPassword() {
        homePage.clickLoginButton();

        loginPage.enterEmail("Uknown@england.com")
                .enterPassword("Englanwweerhkj@123")
                .clickSubmitButton();

        loginPage.verifyTokenIsNull(page);

    }

    @Test
    public void loginWithEmptyFields() {
        homePage.clickLoginButton();

        loginPage.enterEmail("")
                .enterPassword("")
                .clickSubmitButton();

        loginPage.verifyTokenIsNull(page);

    }

    @Test
    public void loginWithValidCredentials() {
        homePage.clickLoginButton();
        loginPage.enterEmail("Elizabeth@england.com")
                .enterPassword("England@123")
                .clickSubmitButton();

        String welcomeMessage = homePage.getWelcomeMessage();
        assert welcomeMessage.equals("Here's an overview of your learning journey") : "Welcome message does not match!";

        loginPage.verifyToken(page);

        homePage.clickUserMenuButton()
                .clickLogout();

    }


}
