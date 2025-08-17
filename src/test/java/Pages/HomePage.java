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

//    public void isPageLoggedIn() {
//        if (isLoggedIn()) {
//            System.out.println("User is logged in.");
//        } else {
//            System.out.println("User is not logged in.");
//        }
//    }
// This method checks if the Home page is loaded by verifying the visibility of the welcome text and
// the Learning Materials button. If both elements are visible, it returns true
    public boolean isPageLoaded() {
        return isWelcomeTextVisible() && isLearningMaterialsButtonVisible();
    }
    public void clickLearningMaterialsButton() {
        page.click(learningMaterialsLocator);
    }
    public boolean isLoggedIn() {
        return page.isVisible("button:has-text('Logout')");
    }
    public void logout() {
        if (isLoggedIn()) {
            page.click("button:has-text('Logout')");
        } else {
            System.out.println("User is not logged in, cannot perform logout.");

        }
    }
    public boolean isLoggedOut() {
        return page.isVisible("button:has-text('Login')");
    }

}
