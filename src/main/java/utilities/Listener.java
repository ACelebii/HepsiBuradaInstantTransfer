package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter
{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext testContext)
	{
		//specify location of the report
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/reports/Report.html");
				
		htmlReporter.config().setDocumentTitle("HepsiBurada Automation Report");
		htmlReporter.config().setReportName("HepsiBurada Testing Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name","HepsiBurada Automation");
		extent.setSystemInfo("Host name","11.111.111.111");
		extent.setSystemInfo("Environment","Test");
		extent.setSystemInfo("user","Tester");
			
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, result.getName() + "  >>  PASSED"  );
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, result.getName() + "  >>  FAILED");
		test.log(Status.FAIL, result.getThrowable());
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, result.getName() + "  >>  SKIPPED");
	}
	@Override
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}