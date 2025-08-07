import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import java.nio.file.Paths;

public class LaunchBrowserTest {

    @Test
    public void launchChromium() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.saucedemo.com");
            page.waitForTimeout(5000);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/login-page.png")));
            page.fill("#user-name", "standard_user");
            page.fill("#password", "secret_sauce");
            page.click("#login-button");
            Locator element = page.locator(".title");
            //assertTrue(element.isVisible(), "Login failed: Products page title not visible.");
            page.waitForTimeout(10000);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/product-page.png")));
        }
    }
}
