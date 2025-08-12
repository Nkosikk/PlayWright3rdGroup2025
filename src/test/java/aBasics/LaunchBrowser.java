package aBasics;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class LaunchBrowser {

    @Test
    public void launchChromium() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.ndosiautomation.co.za");
            page.click("button:has-text('Learning Materials')");
            Thread.sleep(8000);
            page.click("button:has-text('Selenium Practice')");
            Thread.sleep(8000);
            page.fill("#username", "Refilwe");
            Thread.sleep(8000);
            page.fill("#password", "Refilwe123");
            Thread.sleep(8000);
            page.click("button:has-text('Login')");
            Thread.sleep(8000);
            //page.fill("#user-name", "standard_user");
           // Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
