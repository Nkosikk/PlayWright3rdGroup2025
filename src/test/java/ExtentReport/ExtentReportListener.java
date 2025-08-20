package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportListener {
    private static String reportDir=System.getProperty("user.dir")+"/Reports/NdosiAutomation.html";

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    public static ExtentReports extentSetup(){

        //Initialize the ExtentReports and ExtentSparkReporter

        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(new File(reportDir));
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Extent Report");
        extentSparkReporter.config().setReportName("Ndosi Automation");

        extentReports.setSystemInfo("OS",System.getProperty("os.name"));
        extentReports.setSystemInfo("Exection Machine",System.getProperty("user.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("User", System.getProperty("user.name"));
        extentReports.setSystemInfo("User Directory", System.getProperty("user.dir"));
        extentReports.setSystemInfo("User Home", System.getProperty("user.home"));
        extentReports.setSystemInfo("Java Vendor", System.getProperty("java.vendor"));
        extentReports.setSystemInfo("Java Vendor URL", System.getProperty("java.vendor.url"));


        return extentReports;
    }
}
