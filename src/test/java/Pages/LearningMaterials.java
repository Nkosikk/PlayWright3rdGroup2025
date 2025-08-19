package Pages;

import com.microsoft.playwright.Page;

import java.security.PublicKey;

public class LearningMaterials {
    Page page;
    ;
    private String seleniumPractice = "button:has-text('Selenium Practice')";
    private String usernameLocator = "#username";
    private String passwordLocator = "#password";
    private String loginButtonLocator = "#sumbit-btn";

    public LearningMaterials(Page page) {
    }

    public LearningMaterials seleniumPractice()
    {
        page.click(seleniumPractice);
        return new LearningMaterials(page);
    }
    public LearningMaterials enterUsername(String username) {
        page.fill(usernameLocator, username);
        return new LearningMaterials(page);
    }
    public LearningMaterials enterPassword(String password) {
        page.fill(passwordLocator, password);
        return new LearningMaterials(page);
    }
    public LearningMaterials clickLoginButton() {
        page.click(loginButtonLocator);
        return new LearningMaterials(page);
    }

}
