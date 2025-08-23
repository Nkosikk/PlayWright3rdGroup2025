package Tests;

import Base.BaseTests;
import org.testng.annotations.Test;

public class WebTests extends BaseTests {

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
