package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
        private static ExtentReports extent;
        private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

        @Override
        public void onStart(ITestContext context) {
            ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        @Override
        public void onTestStart(ITestResult result) {
            ExtentTest newTest = extent.createTest(result.getMethod().getMethodName());
            test.set(newTest);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            test.get().pass("Test passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            test.get().fail("Test failed");
            // Add code to take and attach a screenshot here
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            test.get().skip("Test skipped");
        }

        @Override
        public void onFinish(ITestContext context) {
            extent.flush();
        }
    }