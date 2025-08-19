package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    private String welcomeText = "h2:has-text('Welcome to Ndosi Online Automation Boot-Camp')";
    private String learningMaterialsLocator = "button:has-text('Learning Materials')";


    public HomePage(Page page){
        this.page = page;
    }

    public boolean isLoggedIn() {
        return page.isVisible("button:has-text('Logout')");
    }


    public HomePage clickLearningMaterials() {
        page.click(learningMaterialsLocator);
        return new HomePage(page);

    }


}
