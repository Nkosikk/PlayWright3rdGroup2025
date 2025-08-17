package BrowserFactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.FileInputStream;
import java.util.Properties;

public class PlaywrightBrowserFactory {

    BrowserContext browserContext;
    private Page page;
    Browser browser;
    Properties prop;

    public void initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser6").trim();
        Playwright playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;

            case "firefox":
                browser = playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;

            case "webkit":
                browser = playwright.webkit().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserName);
        }

        browserContext = browser.newContext();
        page = browser.newContext().newPage();
        page.navigate(prop.getProperty("dev_url").trim());

    }

    public Page getPage() {
        return page;
    }

    public void closeBrowser() {
        if (browser != null) {
            browser.close();
        } else {
            System.out.println("Browser is not initialized or already closed.");
        }

    }

    public Properties init_prop() {
        try {
            FileInputStream ip = new FileInputStream("/Users/lence/Desktop/Automation/PlayWright3rdGroup2025/src/test/resources/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }


}
