package Tests;

import Base.BaseTests;
import org.testng.annotations.Test;

@Test
public class NdosiAutomationTests extends BaseTests {


    @Test
    public void a_testWelcomeTextVisibility() {
        boolean isWelcomeTextVisible = homePage.isWelcomeTextVisible();
        org.testng.Assert.assertTrue(isWelcomeTextVisible, "Welcome text should be visible on the Home page");
    }
    @Test
    public void b_testClickLearningMaterialsButton() {
        homePage.clickLearningMaterialsButton();
        // After clicking the Learning Materials button, we can check if the login button is visible
        boolean isLoginButtonVisible = homePage.isLoginButtonVisible();
        org.testng.Assert.assertTrue(isLoginButtonVisible, "Login button should be visible after clicking Learning Materials button");
    }

   @Test
    public void c_testLoginButton() {
        // Click the Learning Materials button to trigger the visibility of the login button
        homePage.clickLearningMaterialsButton();
        boolean isLoginButtonVisible = homePage.isLoginButtonVisible();
        org.testng.Assert.assertTrue(isLoginButtonVisible, "Login button should be visible after clicking Learning Materials button");
    }



}
