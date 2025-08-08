package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    private String welcomeText = "h2:has-text('Welcome to Ndosi Online Automation Boot-Camp')";
    private String learningMaterialsLocator = "button:has-text('Learning Materials')";

    public HomePage(Page page) {
        this.page = page;
    }

    public boolean isWelcomeTextVisible() {
        return page.isVisible(welcomeText);
    }

    public boolean isLearningMaterialsButtonVisible() {
        return page.isVisible(learningMaterialsLocator);
    }

    public boolean isPageLoaded() {
        return isWelcomeTextVisible() && isLearningMaterialsButtonVisible();
    }
    public void clickLearningMaterialsButton() {
        page.click(learningMaterialsLocator);
    }

}
