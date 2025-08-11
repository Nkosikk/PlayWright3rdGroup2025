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
            page.fill("#password", "secret_sauce");
            page.click("#login-button");
            Thread.sleep(1000);


            String productTitle = page.textContent(".title");
            Assert.assertEquals(productTitle, "Products", "Product title does not match");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
