package Pages;

import com.microsoft.playwright.Page;

import org.testng.annotations.Test;

@Test
public class HomePage {

    // A method to set the page after instantiation
    private Page page;

    private String welcomeText = "h2:has-text('Welcome to Ndosi Online Automation Boot-Camp')";
    private String learningMaterialsLocator = "button:has-text('Learning Materials')";
    private String sleniumPractiseLocator = "button:has-text('Slenium Practise')";


    public HomePage() {
    }

    public HomePage(Page page) {
        this.page = page;
    }


    //This is the public no-argument constructor TestNG needs

    public boolean isLoggedIn() {
        return page.isVisible("button:has-text('Logout')");
    }


    public HomePage clickLearningMaterials() {
        page.click(learningMaterialsLocator);
        return new HomePage(page);

    }

    public HomePage clickSleniumPractise() {
        page.click(sleniumPractiseLocator);
        return new HomePage(page);

    }


}
