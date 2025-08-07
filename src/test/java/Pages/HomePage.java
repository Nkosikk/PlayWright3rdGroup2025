package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    private String welcomeText = "h2:has-text('Welcome to Ndosi Online Automation Boot-Camp')";

    public HomePage(Page page){
        this.page = page;
    }

    public boolean isLoggedIn() {
        return page.isVisible("button:has-text('Logout')");
    }



}
