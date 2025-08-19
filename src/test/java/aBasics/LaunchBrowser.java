package aBasics;

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
            page.fill("#password", "secret_sauce");
            page.click("#login-button");
            Thread.sleep(1000);
            page.fill("#password", "secret_sauce");
            page.click("#login-button");
            Thread.sleep(1000);
            assertThat(page.locator(".title")).hasText("Products");
            System.out.println("Login successful");


            //assert that the products page is displayed
            String pageTitle = page.title();
            if (pageTitle.equals("Swag Labs")) {
                System.out.println("Login successful, products page displayed.");
            } else {
                System.out.println("Login failed, products page not displayed.");
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
