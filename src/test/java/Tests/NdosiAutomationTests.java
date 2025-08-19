package Tests;

import Base.BaseTests;
import org.testng.annotations.Test;

public class NdosiAutomationTests extends BaseTests {

    @Test
    public void clickLearningMaterialTests1() {
        homePage.clickLearningMaterials();
    }

//    @Test
//    public void testIsLoggedIn1() {
//        boolean loggedIn = homePage.isLoggedIn();
//        org.testng.Assert.assertTrue(loggedIn, "User should be logged in and Logout button should be visible");
//    }

}
