package aBasics;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;

public class LaunchBrowser {

    @Test
    public void launchChromium() {
        // try (Playwright playwright = Playwright.create()) {
        //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setChannel("chrome")
                            .setHeadless(false)
            );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.saucedemo.com");
            page.fill("#user-name", "standard_user");
            page.fill("#password", "secret_sauce");
            page.click("#login-button");

            // Wait for the page to load and the product title to be visible

            Locator productTitle = page.locator(".title[data-test='title']");

            Assert.assertTrue(productTitle.isVisible(), "Product title is not visible!");

            Thread.sleep(1000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
