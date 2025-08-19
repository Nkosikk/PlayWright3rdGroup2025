package Tests;

import Base.BaseTests;
import org.testng.annotations.Test;

@Test
public class NdosiAutomationTests extends BaseTests {

    @Test
    public void testIsPageLoaded() {
        boolean isPageLoaded = homePage.isPageLoaded();
        org.testng.Assert.assertTrue(isPageLoaded, "Home page should be loaded with welcome text and Learning Materials button visible");
    }

    @Test
    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterialsButton();
    }


    @Test
    public void testIsLoggedIn() {
        boolean loggedIn = homePage.isLoggedIn();
        org.testng.Assert.assertTrue(loggedIn, "User should be logged in and Logout button should be visible");
    }

    @Test
    public void testWelcomeTextVisibility() {
        boolean isWelcomeTextVisible = homePage.isWelcomeTextVisible();
        org.testng.Assert.assertTrue(isWelcomeTextVisible, "Welcome text should be visible on the Home page");
    }

    @Test
    public void testLearningMaterialsButtonVisibility() {
        boolean isLearningMaterialsButtonVisible = homePage.isLearningMaterialsButtonVisible();
        org.testng.Assert.assertTrue(isLearningMaterialsButtonVisible, "Learning Materials button should be visible on the Home page");
    }


}
