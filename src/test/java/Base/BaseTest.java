package Base;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected Properties props;

    protected String baseUrl, username, password;
    protected boolean headlessMode;

    @BeforeSuite(alwaysRun = true)
    public void loadConfig() throws IOException {
        props = new Properties();

        // Allow override via -Dconfig.file=/abs/path or env CONFIG_FILE
        String overridePath = System.getProperty("config.file", System.getenv("CONFIG_FILE"));
        if (overridePath != null && !overridePath.isBlank()) {
            try (InputStream in = Files.newInputStream(Paths.get(overridePath))) {
                props.load(in);
                System.out.println("[CONFIG] Loaded override: " + overridePath);
            }
        } else {
            String classpathLocation = "configs/config.properties";
            try (InputStream in = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(classpathLocation)) {
                if (in == null) {
                    throw new FileNotFoundException("Missing " + classpathLocation +
                            " on classpath (put under src/test/resources/configs or src/main/resources/configs).");
                }
                props.load(in);
                System.out.println("[CONFIG] Loaded classpath: " + classpathLocation);
            }
        }

        baseUrl = requireProp("url");
        username = requireProp("username");
        password = requireProp("password");
        headlessMode = Boolean.parseBoolean(props.getProperty("headless", "true"));
        System.out.printf("[CONFIG] baseUrl=%s, headless=%s%n", baseUrl, headlessMode);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
        context = browser.newContext();
        page = context.newPage();
        if (page == null) throw new IllegalStateException("Playwright Page not initialized.");
        System.out.println("[SETUP] Page created.");
    }

    protected void navigateToBaseUrl() {
        if (page == null) {
            throw new IllegalStateException("Page is null in navigateToBaseUrl(). Did @BeforeMethod run?");
        }
        page.navigate(baseUrl);
        System.out.println("[NAV] Navigated to: " + baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        System.out.println("[TEARDOWN] Closed Playwright.");
    }

    private String requireProp(String key) {
        String val = props.getProperty(key);
        if (val == null || val.isBlank()) throw new IllegalStateException("Missing property: " + key);
        return val.trim();
    }
}
