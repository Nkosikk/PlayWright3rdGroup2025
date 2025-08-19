package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    private String welcomeText = "h2:has-text('Learn Automation the Right Way')";

    private String learningMaterialsLocator = "button:has-text('Learning Materials')";


    // Constructor that initializes the page object
    // The page object is passed as a parameter to the constructor, allowing the class to interact
    // with the Playwright Page API.
    // This is essential for performing actions like checking visibility of elements or clicking buttons.
    public HomePage(Page page) {
        this.page = page;
    }

    public boolean isWelcomeTextVisible() {
        return page.isVisible(welcomeText);
    }

    public boolean isLearningMaterialsButtonVisible() {
        return page.locator(learningMaterialsLocator).isVisible();
    }

// This method checks if the Home page is loaded by verifying the visibility of the welcome text and
// the Learning Materials button. If both elements are visible, it returns true
    public boolean isPageLoaded() {
        return isWelcomeTextVisible();
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


}
