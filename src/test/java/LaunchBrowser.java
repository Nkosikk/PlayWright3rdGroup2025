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
            String username = "standard_user";
            String password = "secret_sauce";

            // Fill in the login form
            page.fill("#user-name", username);
            page.fill("#password", password);
            page.click("#login-button");
            Thread.sleep(2000);



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
