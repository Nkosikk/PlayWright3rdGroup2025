package Pages;

import com.microsoft.playwright.Page;

public class LearningMaterials {
    Page page;
    // Locators for the elements on the Learning Materials page
    // These locators are used to interact with the elements on the page
    // They are defined as strings and can be used with Playwright methods to check visibility or
    // perform actions like clicking.
    private String practiceAssessmentLocator = "button:has-text('Practice Assessments')";
    private String seleniumPracticeLocator = "button:has-text('Selenium Practice')";

    // Constructor that initializes the page object
    // The page object is passed as a parameter to the constructor, allowing the class to interact
    // with the Playwright Page API.
    // This is essential for performing actions like checking visibility of elements or clicking buttons.
    // The page object represents the current state of the browser page being tested.
    // It allows the class to perform actions like checking visibility of elements or clicking buttons.

    public LearningMaterials(Page page) {
        this.page = page;
    }
    // This method checks if the "Practice Assessments" button is visible on the page.
    public boolean isPracticeAssessmentButtonVisible() {
        return page.isVisible(practiceAssessmentLocator);
    }
    // This method checks if the "Practice Assessments" button is visible on the page.
    public boolean isSeleniumPracticeButtonVisible() {
        return page.isVisible(seleniumPracticeLocator);
    }
    // This method checks if the Learning Materials page is loaded by verifying the visibility of
    // the "Practice Assessments" and "Selenium Practice" buttons.
    // If both buttons are visible, it returns true, indicating that the page is loaded.
    public boolean isPageLoaded() {
        return isPracticeAssessmentButtonVisible() && isSeleniumPracticeButtonVisible();
    }

    // This method clicks the "Practice Assessments" button on the page.
    public void clickSeleniumPracticeButton() {
        page.click(seleniumPracticeLocator);
    }

    // This method fills the username input field with the provided username.
    public void enterUsername(String username) {
        page.fill("input[name='username']", username);
    }

    // This method fills the password input field with the provided password.
    public void enterPassword(String password) {
        page.fill("input[name='password']", password);
    }

    // This method clicks the "Login" button on the page.
    public void clickLoginButton() {
        page.click("button:has-text('Login')");
    }

}
