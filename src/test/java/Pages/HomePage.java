package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    private String loginButtonLocator = "button.user-pill:has-text('Login')";

    private String userMenuButton = "button.user-pill";

    private String logoutButton = "button.nav-dropdown-item:has-text('Logout')";




    public HomePage(Page page){
        this.page = page;
    }


    public HomePage clickLoginButton() {
        page.click(loginButtonLocator);
        return this;

    }


    public HomePage clickUserMenuButton() {
        Locator userMenu = page.locator(userMenuButton)
                .filter(new Locator.FilterOptions().setHasText("Tatalo"));
        userMenu.waitFor();
        userMenu.click();
        return this;
    }


    public void clickLogout() {
        Locator logout = page.locator(logoutButton);
        logout.waitFor();
        logout.click();
    }

}
