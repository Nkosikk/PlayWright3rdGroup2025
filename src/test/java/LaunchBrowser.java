import Utils.ReadFromExcel;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

public class LaunchBrowser {

    @Test
    public void launchChromium() {
        try (Playwright playwright = Playwright.create()) {
            // Launch a browser instance
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            // Read username from Excel file
            ReadFromExcel reader = new ReadFromExcel();
            String username = reader.username;
            String password = reader.password;


            BrowserContext context = browser.newContext();

            // Open a new page (Child)
            Page page = context.newPage();

            // Navigate to a URL
            page.navigate("https://www.saucedemo.com/");
            // Fill in the username and password fields
            page.fill("#user-name", username);
            page.fill("#password", password);
            Thread.sleep(5000);
            page.click("#login-button");



            //Verify the title of the page
            String pageTitle = page.title();
            String productsTitle = page.textContent(".title");
            Assertions.assertEquals("Products", productsTitle, "Login failed: Products page not displayed.");

            Thread.sleep(5000);

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
