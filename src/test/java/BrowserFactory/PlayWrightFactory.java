package BrowserFactory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PlayWrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Page initBrowser(Properties prop) {

       String browserName = prop.getProperty("browser");

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
        page.navigate(prop.getProperty("url"));
        return page;

    }
    public static Properties initializeProperties() {
       Properties prop = new Properties();
        // Code to load properties from a file or set default values
        FileInputStream  fis = null;
        try {
            fis = new FileInputStream(".\\src\\test\\resources\\configs\\config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;

    }



}

