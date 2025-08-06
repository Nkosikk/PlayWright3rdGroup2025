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
            Thread.sleep(1000);
            page.fill("#user-name", "standard_user");
            Thread.sleep(1000);

            // Fill in the password field
            page.fill("#password", "secret_sauce");
            Thread.sleep(1000);

            // Click the login button
            page.click("#login-button");
            Thread.sleep(1000);

            // After page.click("#login-button");
            page.waitForURL("**/inventory.html");

            // Verify that the URL contains "/inventory.html"
            Assert.assertTrue(page.url().contains("/inventory.html"), "Not on the product page");
            Thread.sleep(1000);// Click the menu button to open sidebar
            page.click("#react-burger-menu-btn");
            Thread.sleep(1000);

            // Click the logout button
            page.click("#logout_sidebar_link");
            Thread.sleep(1000);

            // verify you are back on the login page
            Assert.assertTrue(page.url().contains("saucedemo.com"), "Not redirected to login page");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
