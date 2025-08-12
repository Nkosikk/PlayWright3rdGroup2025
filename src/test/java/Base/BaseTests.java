package Base;

import BrowserFactory.PlayWrightBrowserFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTests {

    protected Page page;
    protected HomePage homePage;
    PlayWrightBrowserFactory pf;
    Properties prop;

    @BeforeTest
    public void setup(){
        pf = new PlayWrightBrowserFactory();
        prop = pf.init_prop(); // Initialize properties if needed
        pf.initBrowser(prop);
        page = pf.getPage();
        homePage = new HomePage(page);
    }

}
