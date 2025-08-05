import com.microsoft.playwright.*;
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
            //Thread.sleep(2000);
           Locator button = page.locator("#login-button");
            button.click();
            Thread.sleep(2000);
            button.getByLabel("Sauce Labs Backpack");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
