package Pages;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

@Test
public class HomePage {
    private final Page page;


    private String welcomeText = "h2:has-text('Welcome to Ndosi Online Automation Boot-Camp')";
    private String learningMaterialsLocator = "button:has-text('Learning Materials')";
    private String seleniumPracticeLocator = "button:has-text('Selenium Practice')";
    private String logoutButtonLocator = "button:has-text('Logout')";

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
    public HomePage clickSeleniumPractice() {
        page.click(seleniumPracticeLocator);
        return new HomePage(page);
    }
}



