package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;

public class HomePage {
    private final Page page;

    private final String welcomeText = "h2:has-text('Welcome to Ndosi Online Automation Boot-Camp')";
    private final String learningMaterialsLocator = "button:has-text('Learning Materials')";

    // Elements used after clicking Learning Materials
    private final String seleniumPracticeLink = "text=Selenium Practice";
    private final String usernameInput = "input[name='username']";
    private final String passwordInput = "input[name='password']";
    private final String loginBtn = "button:has-text('Login')";
    private final String welcomeBanner = "text=Welcome,";

    public HomePage(Page page) {
        if (page == null) throw new IllegalArgumentException("Playwright Page is null. Instantiate AFTER setUp().");
        this.page = page;
    }

    /** Waits for and validates the welcome text. */
    public HomePage validateWelcomeText() {
        page.waitForSelector(welcomeText,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10_000));
        Assert.assertTrue(page.isVisible(welcomeText), "Welcome text is not visible: " + welcomeText);
        System.out.println("Welcome text is visible.");
        return this;
    }

    public HomePage clickLearningMaterials() {
        page.click(learningMaterialsLocator);
        return this; // keep same instance
    }

    public HomePage openPractice() {
        page.click(seleniumPracticeLink);
        return this;
    }

    public HomePage login(String username, String password) throws InterruptedException {
        page.fill(usernameInput, username);
        page.fill(passwordInput, password);
        page.click(loginBtn);
        Thread.sleep(2000);
        return this;
    }

    public boolean isLoggedInAs(String user) {
        return page.isVisible(welcomeBanner + " " + user);
    }

    public boolean isLoggedIn() {
        return page.isVisible("button:has-text('Logout')");
    }
}
