package Tests;

import Base.BaseTests;
import org.testng.annotations.Test;

public class NdosiAutomation1Tests extends BaseTests {
    @Test
    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterials();
    }

//    @Test
//    public void testIsLoggedIn() {
//        boolean loggedIn = homePage.isLoggedIn();
//        org.testng.Assert.assertTrue(loggedIn, "User should be logged in and Logout button should be visible");
//    }

}
