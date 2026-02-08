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

    public Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    PlayWrightBrowserFactory pf;
    Properties prop;

    protected BrowserContext context;

    @BeforeMethod
    public void setup() {
        pf = new PlayWrightBrowserFactory();
        prop = pf.init_prop();
        pf.initBrowser(prop);

        page = pf.getPage();
        context = page.context();

        context.tracing().start(
                new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true)
        );

        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        signUpPage = new SignUpPage(page);
    }




    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            context.tracing().stop(
                    new Tracing.StopOptions()
                            .setPath(Paths.get("traces/" + result.getName() + ".zip"))
            );
        } else {
            context.tracing().stop();
        }

        if (context != null) {
            context.close();
        }
    }

}
