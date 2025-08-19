package Base;

import BrowserFactory.PlaywrightBrowserFactory;
import BrowserFactory.PlaywrightBrowserFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTests {

    protected Page page;
    protected HomePage homePage;
    PlaywrightBrowserFactory pf;
    protected Properties prop;

    @BeforeTest
    public void setup(){
        pf = new PlaywrightBrowserFactory();
        prop = pf.init_prop(); // Initialize properties if needed
        pf.initBrowser(prop);
        page = pf.getPage();
        homePage = new HomePage(page);
    }

}
