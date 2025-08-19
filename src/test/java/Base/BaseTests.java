package Base;

import BrowserFactory.PlayWrightBrowserFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;
import java.util.Properties;


import ExtentReport.ExtentReportListener;
public class BaseTests {

    protected Page page;
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
        if (page != null) {
            page.context().tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip"))); // Save the trace file
            page.context().close();

        }
    }
}
