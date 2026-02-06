package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    private String loginButtonLocator = "button.user-pill:has-text('Login')";

    private String welcomeMessageLocator = "p:has-text('overview of your learning journey')";

    private String userMenuButton = "button.user-pill";

    private String logoutButton = "button.nav-dropdown-item:has-text('Logout')";




    public HomePage(Page page){
        this.page = page;
    }


    public HomePage clickLoginButton() {
        page.click(loginButtonLocator);
        return this;

    }

    public String getWelcomeMessage() {
        return page.locator(welcomeMessageLocator).textContent().trim();
    }

    public HomePage clickUserMenuButton() {
        page.click(userMenuButton);
        return this;
    }

    public void clickLogout() {
        page.locator(logoutButton).click();
    }

}
