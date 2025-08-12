package Pages;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

@Test
public class LearningMeterialPage {
    private final Page page;


    private String seleniumPracticeLocator = "button:has-text('Selenium Practice')";
    private String UsernameLocator = "input[name='username']";
    private String PasswordLocator = "input[name='password']";
    private String loginButtonLocator = "button:has-text('Login')";


    public LearningMeterialPage(Page page) {
        this.page = page;
    }


    public LearningMeterialPage clickSeleniumPractice() {
        page.click(seleniumPracticeLocator);
        return new LearningMeterialPage(page);
    }
    public LearningMeterialPage enterUsername(String username) {
        page.fill(UsernameLocator, username);
        return new LearningMeterialPage(page);
    }
    public LearningMeterialPage enterPassword(String password) {
        page.fill(PasswordLocator, password);
        return new LearningMeterialPage(page);
    }

    public LearningMeterialPage clickLoginButton() {
        page.click(loginButtonLocator);
        return new LearningMeterialPage(page);
    }
}
