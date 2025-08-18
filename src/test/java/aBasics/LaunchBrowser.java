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
            Thread.sleep(3000);
            page.fill("#password", "secret_sauce");
            Thread.sleep(3000);
            page.click("#login-button");
            Thread.sleep(3000);

            //Assert the current URL is the product page
            Assert.assertTrue(page.url().contains("inventory.html"), "Login failed or URL mismatch");
            Thread.sleep(3000);
            // Highlight the first product
            //page.evaluate("document.querySelector('.inventory_item').style.border='3px solid red'");
            //Highlight the Product title
            page.evaluate("document.querySelector('.title').style.border='3px solid blue'");
            Thread.sleep(3000);

            //logout of the application

            // Highlight the burger menu
            //page.evaluate("document.querySelector('#react-burger-menu-btn').style.border='4px solid blue'");
           // Thread.sleep(3000);
            page.click("#react-burger-menu-btn");
            Thread.sleep(3000);

            page.click("#logout_sidebar_link");
            Thread.sleep(3000);

            // Close the browser
            browser.close();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
