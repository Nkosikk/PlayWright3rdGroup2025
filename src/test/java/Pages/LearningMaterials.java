package Pages;
import com.microsoft.playwright.Page;

public class LearningMaterials {
    Page page;

    private String usernameLocator = "input:has-text('Enter your username')";
    private String passwordLocator = "input:has-text('Enter your password')";
    private String loginButtonLocator = "button:has-text('Login')";
    private String seleniumPracticeLocator = "button:has-text('Selenium Practice')";

    public LearningMaterials(Page page){
        this.page = page;
    }

    public boolean IsInMaterial() {
        return page.isVisible("h2:has-text('Practice Assessments')");
    }

    public LearningMaterials clickSeleniumPractice() {
        page.click(seleniumPracticeLocator);
        return new LearningMaterials(page);

    }
    public LearningMaterials enterUsername() {
        page.fill(usernameLocator, "testuser");
        return this;
    }
    public LearningMaterials enterPassword() {
        page.fill(passwordLocator, "password123");
        return this;
    }
    public LearningMaterials clickLogin() {
        page.click(loginButtonLocator);
        return this;
    }



}


