package ExtentReport;

import Base.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Paths;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        extentTest.set(extent.createTest(result.getMethod().getMethodName()));
    }


    @Override
    public void onTestFailure(ITestResult result) {
        Page page = ((BaseTests) result.getInstance()).getPage();

        String screenshotPath = captureScreenshot(page, result.getMethod().getMethodName());
        extentTest.get().log(Status.FAIL, "Test failed");
        extentTest.get().addScreenCaptureFromPath(screenshotPath);
    }

    private String captureScreenshot(Page page, String methodName) {
        String path = System.getProperty("user.dir") + "/Screenshots/" + methodName + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        return path;
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(
                Status.PASS,
                "Test Case " + result.getMethod().getMethodName() + " has passed"
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(
                Status.SKIP,
                "Test Case " + result.getMethod().getMethodName() + " has been skipped"
        );
    }

    @Override
    public void onFinish(ITestContext result){
        extent.flush();
    }

    public void onStart(ITestContext result){
        extent = ExtentReportManager.extentSetup();
    }
}
