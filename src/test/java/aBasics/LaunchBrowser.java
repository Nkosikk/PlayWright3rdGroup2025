package aBasics;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchBrowser {

    Playwright playwright;
    Browser browser;
    Page page;

    @Test
    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType
                        .LaunchOptions()
                        .setHeadless(false));
        page = browser.newPage();
        page.navigate("https://saucedemo.com/");
    }

    @Test(dependsOnMethods = "launchBrowser")
    public void loginTest() {
        page.locator("[data-test='username']").fill("standard_user");
        page.locator("[data-test='password']").fill("secret_sauce");
        page.locator("[data-test='login-button']").click();

    }
    @Test(dependsOnMethods = "loginTest")
    public void verifyLogin() {
        Assert.assertTrue(page.locator("[data-test=\"title\"]").isVisible(), "Title is not visible after login");
    }
    @Test(dependsOnMethods = "verifyLogin")
    public void clickOnMenu() {
        page.locator("#react-burger-menu-btn").click();
    }
    @Test(dependsOnMethods = "clickOnMenu")
    public void logout() {
        page.locator("#logout_sidebar_link").click();
    }

    @Test(dependsOnMethods = "logout")
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

}

