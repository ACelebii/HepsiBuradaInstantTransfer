package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter
{
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext testContext)
    {
        //specify location of the report
        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/wassReport.html");
        htmlReporter.config().setDocumentTitle("Api Automation Report");
        htmlReporter.config().setReportName("API Testing Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Project Name","Apı");
        extent.setSystemInfo("Host name","localhost");
        extent.setSystemInfo("Environemnt","QA");
        extent.setSystemInfo("user","Tester");

    }
    public void onTestSuccess(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
    }
    public void onTestFailure(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
        test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
    }
    public void onTestSkipped(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
    }
    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }
}