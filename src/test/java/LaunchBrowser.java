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
            //Enter Credentials
            page.fill("#user-name", "standard_user");
            Thread.sleep(1000);
            page.fill("#password", "secret_sauce");
            Thread.sleep(1000);
            //Click on Login Button
            page.click("#login-button");
            Thread.sleep(5000); // Wait for 5 seconds to see the result
            //validate login
            String title = page.title();
            if (title.equals("Products")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }





        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
