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
            page.click("#login-button");

            page.waitForLoadState();

            page.waitForURL("https://www.saucedemo.com/inventory.html");

            page.isVisible("#header_container > div.header_secondary_container > span");

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
