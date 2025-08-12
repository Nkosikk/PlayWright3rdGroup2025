package aBasics;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class LaunchBrowser {

    @Test
    public void launchChromium() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            // Navigate to the SauceDemo login page and perform login
            page.navigate("https://www.saucedemo.com");
            page.fill("#user-name", "standard_user");
            Thread.sleep(1000);
            page.fill("#password", "secret_sauce");
            Thread.sleep(1000);
            // Click the login button
            page.click("#login-button");
            // verify user is logged in by checking for word "Products"
            page.waitForSelector("text=Products");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
