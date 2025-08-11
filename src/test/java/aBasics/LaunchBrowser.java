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
            String actualElementName = page.textContent("span:has-text('Products')");
            Assert.assertEquals(actualElementName,"Products");
            System.out.println(actualElementName);

            page.pause();

        }
    }
}
