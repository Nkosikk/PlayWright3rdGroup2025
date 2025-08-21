package Pages;


import com.microsoft.playwright.Page;

import static org.testng.Assert.assertTrue;

public class HomePage {
    private Page page;
    // Locators for elements on the home page
    private String learnAutomationHeaderLocator = "h2:has-text('Learn Automation the Right Way')";
    private String learnAutomationButtonLocator = "button:has-text('Learn Automation')";

    // Constructor to initialize the page
    public HomePage(Page page) {
        this.page = page;
    }
// Method to verify the presence of the "Learn Automation the Right Way" header
    public void isLearnAutomationHeaderVisible() {
        assertTrue(page.locator(learnAutomationHeaderLocator).isVisible(),
            "Learn Automation the Right Way header is not visible");
    }

    // Method to click the "Learn Automation" button
    public void clickLearnAutomationButton() {
        page.locator(learnAutomationButtonLocator).click();
    }



}
