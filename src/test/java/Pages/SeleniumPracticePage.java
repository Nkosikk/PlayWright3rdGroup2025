package Pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

public class SeleniumPracticePage {

    Page page;

    // Locators
    private String learningMaterialTitle = "h2:has-text('Practice Area')";
    //private String learningMaterialsLocator = "button:has-text('Selenium Practice')";

    private String username = "id:has-text('username')";
    private String password = "id:has-text('password')";

    public SeleniumPracticePage(Page page) {
        this.page = page;
    }


    // Page methods
    public boolean isSeleniumPracticePageDisplayed() {
        return page.isVisible(learningMaterialTitle);
    }
    public void enterUsername(String username) {
        page.fill(this.username, username );
    }

    public void enterPassword(String password) {
        page.fill(this.password, password);
    }


    public void testEnterUsername() {
        SeleniumPracticePage seleniumPracticePage = new SeleniumPracticePage(page);
        seleniumPracticePage.enterUsername("testuser");

    }

    public void testEnterPassword() {
        SeleniumPracticePage seleniumPracticePage = new SeleniumPracticePage(page);
        seleniumPracticePage.enterUsername("password123");

    }
    public void clickLoginButton() {
        page.click("id:has-text('submit-btn')");
    }

    public boolean isLoginSuccessful() {
        return page.isVisible("h2:has-text('Welcome, testuser!')");
    }


}
