package utilities;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyListener implements ITestListener{
	ExtentReports e;
	ExtentTest t;
	SvcreenshotUtility s;
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test case started");
		t.log(LogStatus.INFO, result.getMethod().getMethodName(), "has Started");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test case passed");
		try
		{
		t.log(LogStatus.PASS, "Screeshot "+t.addScreenCapture(s.takeScreenshot()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test case falied");
		t.log(LogStatus.FAIL, result.getMethod().getMethodName(), "has failed");
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test case skipped");
		t.log(LogStatus.SKIP, result.getMethod().getMethodName(), "has Skipped");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	public void onStart(ITestContext context)
	{
		System.out.println("TestNg started");
		s=new SvcreenshotUtility();
		e=new ExtentReports("test-output\\MyReport.html");
		t=e.startTest("Logintest has started");
		e.addSystemInfo("Browser","Chrome");
		e.addSystemInfo("Build", "Smoke Testing");
		
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("TestNg started");
		e.endTest(t);
		e.flush();
	}

}
