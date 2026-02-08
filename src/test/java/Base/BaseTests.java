package Base;

import BrowserFactory.PlayWrightBrowserFactory;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.util.Properties;



public class BaseTests {

    protected Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    PlayWrightBrowserFactory pf;
    Properties prop;

    protected BrowserContext context;

    @BeforeMethod
    public void setup() {
        pf = new PlayWrightBrowserFactory();
        prop = pf.init_prop(); // Initialize properties if needed
        pf.initBrowser(prop);
        page = pf.getPage();
        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        signUpPage = new SignUpPage(page);

        page.context().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
    }

    public Page getPage() {
        return page;
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
