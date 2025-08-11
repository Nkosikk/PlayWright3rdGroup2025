package Pages;

import com.microsoft.playwright.Page;

public class LearningMaterialPage {
    Page page;

    private String usernameLocator = "input:has-text('Enter your username')";
    private String passwordLocator = "input:has-text('Enter your password')";
    private String loginButtonLocator = "button:has-text('Login')";
    private String seleniumPracticeLocator = "button:has-text('Selenium Practice')";

    public LearningMaterialPage(Page page){
        this.page = page;
    }

    public boolean IsInMaterial() {
        return page.isVisible("h2:has-text('Practice Assessments')");
    }

    public LearningMaterialPage clickSeleniumPractice() {
        page.click(seleniumPracticeLocator);
        return new LearningMaterialPage(page);

    }
    public LearningMaterialPage enterUsername() {
        page.fill(usernameLocator, "testuser");
        return this;
    }
    public LearningMaterialPage enterPassword() {
        page.fill(passwordLocator, "password123");
        return this;
    }
    public LearningMaterialPage clickLogin() {
        page.click(loginButtonLocator);
        return this;
    }



}
