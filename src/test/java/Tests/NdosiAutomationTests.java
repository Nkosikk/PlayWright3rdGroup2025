package Tests;

import Base.BaseTests;
import Pages.LoginPage;
import org.testng.annotations.Test;

@Test
public class NdosiAutomationTests extends BaseTests {

    @Test(priority = 1)
    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterials();
    }

    @Test(priority = 2)
    public void clickSeleniumPracticeTests() {
        homePage.clickSeleniumPractice();
    }

    @Test(priority = 3)
    public void loginTests() {
        loginPage.EnterUsername("testuser")
                .EnterPassword("password123");
        loginPage.clickLoginButton();
        assert loginPage.isLoginSuccessVisible();
        homePage.isLoggedIn();
    }
}
