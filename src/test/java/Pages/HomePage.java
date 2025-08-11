package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    private String welcomeText = "h2:has-text('Welcome to Ndosi Online Automation Boot-Camp')";
    private String learningMaterialsLocator = "button:has-text('Learning Materials')";
    private String SeleniumPracticeLocator="button:has-text('Selenium Pracice')";
    private String UsernameLocator="div:has-text('Username')";
    private String PasswordLocator="div:has-text('Password')";
    private String UsernameFieldLocator="input:has-text('username')";
    private String PasswordFieldLocator="input:has-text('password')";
    private String LoginLocator="button:has-text('Login')";
    private String StatusLocator="div:has-text('Status')";
    private String LogoutLocator="button:has-text('Logout')";


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
    public HomePage clickSeleniumPractice(){
        page.click(SeleniumPracticeLocator);
        return new HomePage(page);
    }
    public HomePage getUsername(){
        page.getByTitle(UsernameLocator);
        return new HomePage(page);
    }
    public HomePage getPassword(){
        page.getByTitle(PasswordLocator);
        return new HomePage(page);
    }
    public HomePage setUsername(){
        page.fill(UsernameLocator,UsernameFieldLocator);
        return new HomePage(page);
    }
    public HomePage setPassword(){
        page.fill(PasswordLocator,PasswordFieldLocator);
        return new HomePage(page);
    }
    public HomePage clickLogin(){
        page.click(LoginLocator);
        return new HomePage(page);
    }
    public HomePage clickStatus(){
        page.click(StatusLocator);
        return new HomePage(page);
    }
    public HomePage clickLogout(){
        page.click(LogoutLocator);
        return new HomePage(page);
    }
}
