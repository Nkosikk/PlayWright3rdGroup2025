package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    private String welcomeText = "h2:has-text('Learn Automation the Right Way')";
    private String learningMaterialsLocator = "button:has-text('Learning Materials')";
    private String loginbuttonlocator= "button:has-text('Login')";

    public HomePage(Page page) {
        this.page = page;
    }

    public boolean isWelcomeTextVisible() {

        return page.isVisible(welcomeText);
    }

    public void clickLearningMaterialsButton() {
        page.click(learningMaterialsLocator);
    }

    public boolean isLoginButtonVisible() {
        return page.isVisible(loginbuttonlocator);
    }


}
