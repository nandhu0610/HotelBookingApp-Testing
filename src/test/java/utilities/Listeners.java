package utilities;

import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;

public class Listeners extends BaseTest implements ITestListener {
	private static Logger logs= LogManager.getLogger();
	private static Date today = new Date();
	private static String dateFormat = today.toString().replace(' ', '-').replace(':', '-');
	private static String path = System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\report " + dateFormat;
	private static ExtentReports extent = ExtentManager.createInstance(path+".html");
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    
	public void onTestStart(ITestResult result) {
		logs.info("****************************************");
		logs.info("Testing of "+result.getName()+" started");
		ExtentTest child = ((ExtentTest) parentTest.get()).createNode(result.getMethod().getMethodName());
        test.set(child);
	}

	public void onTestSuccess(ITestResult result) {
		logs.info("Test Success");
		((ExtentTest) test.get()).pass("Test passed");
	}

	public void onTestFailure(ITestResult result) {
		logs.error("Test failed");
		((ExtentTest) test.get()).fail(result.getThrowable());
		Screenshot ss = new Screenshot();
		try {
			
			ss.takeScreenshot();
			((ExtentTest) test.get()).addScreenCaptureFromPath(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\Screenshot "+ss.dateFormat+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("<a href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\Screenshot "+ss.dateFormat+".png"+"\">Screenshot Link</a>");
		
	}

	public void onTestSkipped(ITestResult result) {
		logs.info("Test Skipped");
		((ExtentTest) test.get()).skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		Date sd =context.getStartDate();
		logs.info("-----------------Suite started at "+sd+"------------------------");
		ExtentTest parent = extent.createTest(context.getName());
        parentTest.set(parent);
	}

	public void onFinish(ITestContext context) {
		Date ed =context.getEndDate();
		logs.info(".................Suite ended at "+ed+"..........................");
		extent.flush();
	}

}
