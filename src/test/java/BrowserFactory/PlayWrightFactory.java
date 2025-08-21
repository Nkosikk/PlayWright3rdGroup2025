package BrowserFactory;

import com.microsoft.playwright.*;

public class PlayWrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName) {

        System.out.println("The browser name: " + browserName);

            playwright = Playwright.create();
            switch (browserName.toLowerCase()) {
                case "chromium":
                  browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "firefox":
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "webkit":
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "chrome":
                    browser = playwright.chromium().launch(
                            new BrowserType.LaunchOptions()
                                    .setChannel("chrome")
                                    .setHeadless(false)
                    );
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browserName);

            }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        // Navigate to a default page
        page.navigate("https://www.example.com");
        return page;

    }



}

