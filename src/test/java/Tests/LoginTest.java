package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void initPagesAndOpen() {
        // page is ready now (BaseTest.setUp ran)
        homePage = new HomePage(page);
        navigateToBaseUrl();
    }

    @Test
    public void login() throws InterruptedException {
        homePage
                .validateWelcomeText()
                .clickLearningMaterials()
                .openPractice()
                .login(username, password);
    }
}
