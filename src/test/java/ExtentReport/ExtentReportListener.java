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
    private static ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result){
        extentTest = extent.createTest(result.getMethod().getMethodName());
    }

    //@Override
    //public void onTestFailure(ITestResult result){
    //    extentTest.log(Status.FAIL,"Test Case "+ result.getMethod().getMethodName()+ " has failed");
    //}

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        Page page = ((BaseTests) testClass).page;

        String screenshotPath = captureScreenshot(page, result.getMethod().getMethodName());
        extentTest.log(Status.FAIL, "Test Case " + result.getMethod().getMethodName() + " has failed");
        extentTest.addScreenCaptureFromPath(screenshotPath);
    }

    private String captureScreenshot(Page page, String methodName) {
        String path = System.getProperty("user.dir") + "/Screenshots/" + methodName + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        return path;
    }


    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.log(Status.PASS,"Test Case " + result.getMethod().getMethodName()+ " has passed");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        extentTest.log(Status.SKIP,"Test Case " + result.getMethod().getMethodName()+ " has been skipped");
    }

    @Override
    public void onFinish(ITestContext result){
        extent.flush();
    }

    public void onStart(ITestContext result){
        extent = ExtentReportManager.extentSetup();
    }
}
