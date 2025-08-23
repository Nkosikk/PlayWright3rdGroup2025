package Base;

import BrowserFactory.PlayWrightFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTests {

    PlayWrightFactory pf;
    Page page;
    protected HomePage homePage;
    Properties prop;

    // This method can be used to set up any preconditions or configurations needed for the tests
    @BeforeTest
    public void setup() {
        pf = new PlayWrightFactory();
        prop = pf.initializeProperties(); // Initialize first
        page = pf.initBrowser(prop);      // Now pass the non-null prop
        homePage = new HomePage(page);
    }
    @AfterTest
    public void teardown() {
        page.context().browser().close();
    }
}



