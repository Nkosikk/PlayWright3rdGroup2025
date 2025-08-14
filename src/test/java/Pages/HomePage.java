package Pages;

import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.*;

public class HomePage {
    Page page;

    private String welcomeText = "h2:has-text('Welcome to Ndosi Online Automation Boot-Camp')";
    private String learningMaterialsLocator = "button:has-text('Learning Materials')";
    private String PracticeAssessmentsText = "h2:has-text('Practice Assessments')";
    private String SeleniumPractice = "button:has-text('Selenium Practice')";
    private String PracticeAreaText = "h2:has-text('Practice Area')";
    // private String EnterUsernameLocator ="h2:has-text('Enter Username')";
    // private String EnterPasswordLocator = "h2:has-text('Enter Password')";
    private String EnterUsernameText = "testuser";
    private String EnterPasswordText = "password123";
    private String loginbutton = "#submit-btn";

    public HomePage(Page page) {
        this.page = page;
    }

    public boolean isLoggedIn() {
        return page.isVisible("button:has-text('Logout')");
    }


    public HomePage clickLearningMaterials() {
        page.click(learningMaterialsLocator);
        return new HomePage(page);

    }

    public boolean isPracticeAssessmentsTextVisible() {
        return page.isVisible(PracticeAssessmentsText);
    }

    public HomePage clickSeleniumPractice() {
        page.click(SeleniumPractice);
        return new HomePage(page);
    }

    public boolean isPracticeAreaTextVisible() {
        return page.isVisible(PracticeAreaText);
    }

    // locate the Enter Username text and return the HomePage object
    public HomePage EnterUsername() {
        page.waitForTimeout(1000);
        // assert that the EnterUsernameText is not empty
        assertFalse(EnterUsernameText.trim().isEmpty(), "Username should not be empty");
        page.locator("//input[@id='username']").fill(EnterUsernameText);
        return new HomePage(page);
    }

    public HomePage EnterPassword() {
         page.waitForTimeout(1000);
        // assert that the EnterPasswordText is not empty
        assertFalse(EnterPasswordText.trim().isEmpty(), "Password should not be empty");
        page.locator("//input[@id='password']").fill(EnterUsernameText);
        return new HomePage(page);
    }

    public HomePage ClickLoginButton() {
        page.click(loginbutton);
        return new HomePage(page);

    }
}






