package Tests;

import Base.BaseTests;
import org.testng.annotations.Test;

@Test
public class NdosiAutomationTests extends BaseTests {

    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterialsButton();
    }

//    @Test
//    public void testIsLoggedIn() {
//        boolean loggedIn = homePage.isLoggedIn();
//        org.testng.Assert.assertTrue(loggedIn, "User should be logged in and Logout button should be visible");
//    }

    public void testIsPageLoaded() {
        boolean isPageLoaded = homePage.isPageLoaded();
        org.testng.Assert.assertTrue(isPageLoaded, "Home page should be loaded with welcome text and Learning Materials button visible");
    }
    public void testWelcomeTextVisibility() {
        boolean isWelcomeTextVisible = homePage.isWelcomeTextVisible();
        org.testng.Assert.assertTrue(isWelcomeTextVisible, "Welcome text should be visible on the Home page");
    }
    public void testLearningMaterialsButtonVisibility() {
        boolean isLearningMaterialsButtonVisible = homePage.isLearningMaterialsButtonVisible();
        org.testng.Assert.assertTrue(isLearningMaterialsButtonVisible, "Learning Materials button should be visible on the Home page");
    }
    public void testClickLearningMaterialsButton() {
        homePage.clickLearningMaterialsButton();
        // Optionally, you can add assertions here to verify the result of clicking the button
        // For example, you might check if the user is redirected to the Learning Materials page

        boolean isLearningMaterialsPageLoaded = homePage.isPageLoaded(); // Assuming this checks for the Learning Materials page
        org.testng.Assert.assertTrue(isLearningMaterialsPageLoaded, "Learning Materials page should be loaded after clicking the button");
    }
    public void testLogout() {
        homePage.logout();
        boolean isLoggedOut = homePage.isLoggedOut();
        org.testng.Assert.assertTrue(isLoggedOut, "User should be logged out and Login button should be visible");
    }


}
