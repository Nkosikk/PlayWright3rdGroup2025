package Tests;

import Base.BaseTests;
import org.testng.annotations.Test;

@Test
public class NdosiAutomationTests extends BaseTests {

    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterials();
    }

    @Test
    public void testIsLoggedIn() {
        boolean loggedIn = homePage.isLoggedIn();
        org.testng.Assert.assertTrue(loggedIn, "User should be logged in and Logout button should be visible");
    }

}
