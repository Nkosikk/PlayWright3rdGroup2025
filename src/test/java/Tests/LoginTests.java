package Tests;

import Base.BaseTests;
import TestData.loaders.TestDataLoader;
import TestData.models.AuthTestData;
import TestData.models.SignUpTestData;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test
    public void loginWithInValidPassword() {

        AuthTestData data = TestDataLoader.get("authData.json", "invalidPassword", AuthTestData.class);

        homePage.clickLoginButton();

        loginPage.enterEmail("Elizabeth@england.com")
                .enterPassword("wrongpassword")
                .clickSubmitButton();

        loginPage.verifyTokenIsNull(page);

    }

    @Test
    public void loginWithInValidEmail() {

        AuthTestData data = TestDataLoader.get("authData.json", "invalidEmail", AuthTestData.class);

        homePage.clickLoginButton();

        loginPage.enterEmail("Uknown@england.com")
                .enterPassword("England@123")
                .clickSubmitButton();

        loginPage.verifyTokenIsNull(page);

    }

    @Test
    public void loginWithInValidEmailAndPassword() {

        AuthTestData data = TestDataLoader.get("authData.json", "invalidEmailAndPassword", AuthTestData.class);

        homePage.clickLoginButton();

        loginPage.enterEmail("Uknown@england.com")
                .enterPassword("Englanwweerhkj@123")
                .clickSubmitButton();

        loginPage.verifyTokenIsNull(page);

    }

    @Test
    public void loginWithEmptyFields() {

        AuthTestData data = TestDataLoader.get("authData.json", "invalidLoginEmptyFields", AuthTestData.class);

        homePage.clickLoginButton();

        loginPage.enterEmail("")
                .enterPassword("")
                .clickSubmitButton();

        loginPage.verifyTokenIsNull(page);

    }

    @Test
    public void loginWithValidCredentials() {

        AuthTestData data = TestDataLoader.get("authData.json", "validLogin", AuthTestData.class);

        homePage.clickLoginButton();
        loginPage.enterEmail("Elizabeth@england.com")
                .enterPassword("England@123")
                .clickSubmitButton();

        loginPage.verifyToken(page);

        homePage.clickUserMenuButton()
                .clickLogout();

    }


}
