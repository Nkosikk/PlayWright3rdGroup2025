package Tests;

import BrowserFactory.PlayWrightFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class test {
 PlayWrightFactory pf;
 Page page;
 HomePage homePage;

    // This method can be used to set up any preconditions or configurations needed for the tests
    @BeforeTest
    public void setup() {
        pf = new PlayWrightFactory();
        page = pf.initBrowser("chromium");
        homePage = new HomePage(page);
    }
    @AfterTest
    public void teardown() {
       page.context().browser().close();
    }
}
