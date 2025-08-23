package Tests;

import Base.BaseTests;
import BrowserFactory.PlayWrightFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

public class test extends BaseTests {

    @Test
    public void learnAutomationHeader() {
        homePage.isLearnAutomationHeaderVisible();
    }
    @Test(dependsOnMethods = "learnAutomationHeader")
    public void clickLearnAutomationButton() {
        homePage.clickLearnAutomationButton();
        // Add assertions or further actions as needed
    }


}
