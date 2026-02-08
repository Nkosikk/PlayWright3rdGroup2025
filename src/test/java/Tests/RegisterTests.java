package Tests;

import TestData.loaders.TestDataLoader;
import TestData.models.SignUpTestData;
import org.testng.annotations.Test;
import Base.BaseTests;

public class RegisterTests extends BaseTests {

    @Test
    public void registerWithValidData() {

        SignUpTestData data = TestDataLoader.get("validUser");

        homePage.clickLoginButton();

        loginPage.clickSignUpLink();

        signUpPage.enterFirstName(data.getFirstName())
                .enterLastName(data.getLastName())
                .enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .enterConfirmPassword(data.getConfirmPassword())
                .selectGroup(data.getGroup())
                .clickSubmitButton();
    }

    @Test
    public void registerWithMissingEmail() {

        SignUpTestData data = TestDataLoader.get("missingEmail");

        homePage.clickLoginButton();
        signUpPage.enterFirstName(data.getFirstName())
                .enterLastName(data.getLastName())
                .enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .enterConfirmPassword(data.getConfirmPassword())
                .selectGroup(data.getGroup())
                .clickSubmitButton();
    }

    @Test
    public void registerWithPasswordMismatch() {

        SignUpTestData data = TestDataLoader.get("passwordMismatch");

        homePage.clickLoginButton();
        signUpPage.enterFirstName(data.getFirstName())
                .enterLastName(data.getLastName())
                .enterEmail(data.getEmail())
                .enterPassword(data.getPassword())
                .enterConfirmPassword(data.getConfirmPassword())
                .selectGroup(data.getGroup())
                .clickSubmitButton();
    }
}
