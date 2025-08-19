package aBasics;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaunchBrowser {

    @Test
    public void launchChromium() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.saucedemo.com");
            page.fill("#user-name", "standard_user");
            page.fill("#password", "secret_sauce");
            page.click("#login-button");
            Thread.sleep(1000);
        // use boolean assertions to verify the login

            page.waitForSelector(".title"); // This is the title on the products page
            // Assertion: Check if the page contains the title "Products"
            String pageTitle = page.textContent(".title");
            assertTrue(pageTitle.contains("Products"), "Login failed: 'Products' title not found");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
