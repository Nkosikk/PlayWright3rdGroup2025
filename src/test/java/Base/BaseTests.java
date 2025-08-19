package Base;

import BrowserFactory.PlayWrightBrowserFactory;
import Pages.HomePage;
import Tests.NdosiAutomationTests;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import org.testng.annotations.*;
import java.util.Properties;



public class BaseTests {

    public Page page;
    protected HomePage homePage;
    PlayWrightBrowserFactory pf;
    Properties prop;


    @BeforeMethod
    public void setup() {
        pf = new PlayWrightBrowserFactory();
        prop = pf.init_prop(); // Initialize properties if needed
        pf.initBrowser(prop);
        page = pf.getPage();
        homePage = new HomePage(page);

        page.context().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
    }



    @AfterTest
    public void tearDown() {
        // Stop tracing and export trace
        page.context().tracing().stop(new Tracing.StopOptions()
                .setPath(java.nio.file.Paths.get("trace.zip")));
        if (page != null) {
            page.close();
        }
    }

}
