package com.example.orangehrms;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentManager implements ITestListener {

    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println(result.getName() + " execution has been started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel("This test case has been passed", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {


        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL, MarkupHelper.createLabel("This test case has been Failed", ExtentColor.RED));
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.SKIP, MarkupHelper.createLabel("This test case has been skipped", ExtentColor.BROWN));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {

        extentSparkReporter = new ExtentSparkReporter(".//Report/TestingReport.htm");
        extentSparkReporter.config().setDocumentTitle("AutomationTest_Execution_Report");
        extentSparkReporter.config().setReportName("Regression_Testing");
        extentSparkReporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("System Name","localhost");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Test Engineer", "Shubham");
        extentReports.setSystemInfo("OS","macOS Sequoia v15.2");
        extentReports.setSystemInfo("browser", "chrome");

    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }
}
