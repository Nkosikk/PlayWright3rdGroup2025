package Pages;


import com.microsoft.playwright.Page;

import static org.testng.Assert.assertTrue;

public class LearningMaterialPage {
    private Page page;

    private String learningMaterialHeaderLocator = "span:has-text('Access Learning Materials')";
    private String userNameLocator = "input[placeholder='Username']";
    private String passwordLocator = "input[placeholder='Password']";
    private String loginButtonLocator = "button:has-text('Login')";

    // Constructor to initialize the page
    public LearningMaterialPage(Page page) {
        this.page = page;
    }

    // Method to verify that we are on the Learning Material page
    public void verifyLearningMaterialPage() {
        assertTrue(page.locator(learningMaterialHeaderLocator).isVisible(),
                "Learning Material header is not visible");
        }
    // Method to fill in the username
    public void fillUsername() {
        page.locator(userNameLocator).fill("admin");
    }
    // Method to fill in the password
    public void fillPassword() {
        page.locator(passwordLocator).fill("ndosi");
    }
    // Method to click the login button
    public void clickLoginButton() {
        page.locator(loginButtonLocator).click();
    }


}
