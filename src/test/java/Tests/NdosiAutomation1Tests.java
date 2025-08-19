package Tests;

import Base.BaseTests;
import ExtentReport.ExtentReportListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ExtentReportListener.class) // This will enable the ExtentReportListener for this test class
public class NdosiAutomation1Tests extends BaseTests {


        @Test
        public void clickLearningMaterialTests() {
            homePage.clickLearningMaterials();
        }

//    @Test
//    public void testIsLoggedIn() {
//        boolean loggedIn = homePage.isLoggedIn();
//        org.testng.Assert.assertTrue(loggedIn, "User should be logged in and Logout button should be visible");
//    }

        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

        public ExtentSparkReporter getSpark() {
            return spark;
        } // ✅ This line links the reporter to the report

        public ExtentReports getExtent() {
            return extent;
        }

        public void setup() {
            // Configure the reporter
            spark.config().setReportName("Ndosi Automation Report");
            spark.config().setDocumentTitle("Ndosi Automation Tests");

            // Attach the reporter to the extent reports
            extent.attachReporter(spark);

            // Optionally, you can set system information
            extent.setSystemInfo("OS", "Windows");
            extent.setSystemInfo("Browser", "Chromium");
            extent.setSystemInfo("Author", "Brenda Malinga");
            // You can now create tests and log steps
            extent.createTest("Sample Test").pass("Step passed");

            extent.flush(); // Writes everything to the file

        }
    }


