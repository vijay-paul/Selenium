package Selenium201;

import resources.base;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends base implements ITestListener {

	public void onTestFailure(ITestResult result) {

		String resulttext = "fail";
		String testMethodName =result.getMethod().getMethodName();
		captureScreenshot(base.driver, resulttext,testMethodName);
		System.out.println(result.getName() + "testfailed");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + "testpassed");
		String resulttext = "pass";
		String testMethodName =result.getMethod().getMethodName();
		captureScreenshot(base.driver, resulttext,testMethodName);

	}

}
