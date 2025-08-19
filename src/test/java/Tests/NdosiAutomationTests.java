package Tests;

import Base.BaseTests;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import static Utils.ExtentReportManager.createTest;

public class NdosiAutomationTests extends BaseTests {

    @Test
    public void clickLearningMaterialTests1() {
        ExtentTest test = createTest("clickLearningMaterialTests1");
        test.info("Navigating to Learning Materials");
        homePage.clickLearningMaterials();
        test.pass("Learning Materials clicked successfully");
    }

//    @Test
//    public void testIsLoggedIn1() {
//        boolean loggedIn = homePage.isLoggedIn();
//        org.testng.Assert.assertTrue(loggedIn, "User should be logged in and Logout button should be visible");
//    }

}
