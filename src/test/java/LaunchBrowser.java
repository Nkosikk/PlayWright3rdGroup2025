import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {

    @Test
    public void launchChromium() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.saucedemo.com");
            page.fill("#user-name", "standard_user");
            Thread.sleep(1000);
            page.fill("#password", "secret_sauce");
            page.click("#login-button");
            Thread.sleep(1000);
            assertThat(page.locator(".title")).hasText("Products");
            System.out.println("Login successful");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
