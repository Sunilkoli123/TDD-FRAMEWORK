package genericutilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/*
 * This class provide implementation for ItestListner Interface of TestNg
 */
public class ListnersImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// It will run start of the every @Test
		// So we can capture the method name
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "-------Test execution started------");

		// For extent reports to to recognise the @test

		test = report.createTest(methodname);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "-------Test execution Pass------");

		// for logging the status of the test in the report

		test.log(Status.PASS, methodname + "-------Test execution Pass------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();

		// getthrowable method is used to print the exceptions
		System.out.println(result.getThrowable());
		javautility j = new javautility();
		String screenshotname = methodname + "-" + j.getSystemDate();

		// For logging the status of the Test in the extent report
		test.log(Status.FAIL, methodname + "-------Test FAIL------");
		test.log(Status.INFO, result.getThrowable());

		seleniumutility s = new seleniumutility();
		// for listenres we are creating sdriver refernce to give driver value because
		// we cannot extend base
		// we cacnot extend base class fo listners interface as it is interface so by
		// giving value to the sdriver we can access it by class name in the listenrs
		// name
		// we can edit the abstarct method so we can not add IO expection which is
		// throwing by capturescreenshot methos so weneed to add try and catch block
		try {

			String path = s.captureScreenshot(BaseClass.sdriver, screenshotname);

			// it is add used to add the screenshots to the report
			test.addScreenCaptureFromPath(path);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(methodname + "-------Test execution Failed------");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "-------Test execution Skipped------");

		// for logging the status of the test in the extent report
		test.log(Status.SKIP, methodname + "-------Test execution Skipped------");

		//
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--------Suite Execution Started-------");
		// Extent report configuration
		javautility j = new javautility();
		// extent report configuration
// basic configuration using extentsparkreporter
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReport\\Report-" + j.getSystemDate() + ".html");
		esr.config().setDocumentTitle("Execution Report");
		esr.config().setReportName("Demo webSHop");
		esr.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		// attachreporter method is used to add the basic config to the report
		report.attachReporter(esr);
		report.setSystemInfo("Basebrowser", "Chrome");
		report.setSystemInfo("Base platform", "Windows");
		report.setSystemInfo("Base Enviornment", "QA");
		report.setSystemInfo("Base URL", "https://demowebshop.tricentis.com/");
		report.setSystemInfo("Reporter", "Sunil");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--------Suite Execution Finished-------");
		report.flush();
	}

}
