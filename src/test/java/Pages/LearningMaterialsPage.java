package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LearningMaterialsPage {

    Page page;

    private String  headingTextXpath = "//h2[text()='Practice Assessments']";
    private String seleniumPractiseButtonXpath = "//button[text()='Selenium Practice']";
    private String usernameID ="username";
    private String passwordID ="password";
    private String buttonID = "Submit-btn";

    public LearningMaterialsPage(Page page){
        this.page =page;
    }

    public boolean isonLearningMaterialsPage()
    {
        return page.isVisible(headingTextXpath);
    }

    public LearningMaterialsPage clickSeleniumPractiseButton(){
        page.click(seleniumPractiseButtonXpath);
        return new LearningMaterialsPage(page);
    }

    public LearningMaterialsPage enterUsername(){
        page.fill(usernameID,"testuser");
        return new LearningMaterialsPage(page);
    }

    public LearningMaterialsPage enterPassword(){
        page.fill(passwordID,"password123");
        return new LearningMaterialsPage(page);
    }

    public LearningMaterialsPage clickLoginButton(){
        page.click(buttonID);
        return new LearningMaterialsPage(page);
    }

    public LearningMaterialsPage verifyLogin(){

        Locator loginMessage = page.locator("xpath=//*[contains(text(), 'You have successfully logged in')]");
        boolean isVisible = loginMessage.isVisible();
        return new LearningMaterialsPage(page);
    }

}
