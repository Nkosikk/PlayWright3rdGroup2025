package aBasics;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchBrowser {

    @Test
    public void launchChromium() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.saucedemo.com");
            page.fill("#user-name", "standard_user");
            page.fill("#password","secret_sauce");
            page.click("#login-button");

            // Wait for inventory page to load
            page.waitForSelector(".inventory_list");


            // Verify login by checking for a product item or page title
            boolean isLoggedIn = page.isVisible(".inventory_item");
            Assert.assertTrue(isLoggedIn, "Login failed or inventory page not loaded.");


            // Optional: Print confirmation
            System.out.println("Login successful and inventory page loaded.");


            Thread.sleep(10000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
