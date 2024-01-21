package genericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;
import objectRepository.Logout;

public class BaseClass {

	public javautility j = new javautility();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public readDataFromExcelutility eutil = new readDataFromExcelutility();
	public seleniumutility sutil = new seleniumutility();
	// declare driver reference as public so we can parameterise it wherever it is
	// required
	public WebDriver driver;

	//for listner
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun= true)
	public void bsConfig() {
		System.out.println("==============DB conncetion Successfull==============");
	}

	
	
	/**
	 * This is used for the parallel execution 
	 * for distributer execution no need of paramaters
	 * and for cross browser we need parameters
	 * @param Browser
	 * @throws IOException
	 */
//	@Parameters("Browser")
//	@BeforeTest()
	@BeforeClass(alwaysRun=true)
	public void bcConfig() throws IOException {
		String URL = putil.readDataFromPropertyFile("url");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		/*
		 *This is only for cross browser parallel execution
		 */
//		if(Browser.equalsIgnoreCase("Edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//		else if(Browser.equalsIgnoreCase("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
		driver.get(URL);
		sutil.maximizewindow(driver);
		sutil.addImplicityWait(driver);
		System.out.println("=========Browser launched succesfully=========");
		
		//for listenres we are creating sdriver refernce to give driver value because we cannot extend base 
		//we cacnot extend base class fo listners interface as it is interface so by giving value to the sdriver we can access it by class name in the listenrs name
       sdriver=driver;
	}

	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException, InterruptedException {
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("pwd");
		LoginPage l = new LoginPage(driver);
		l.loginAPP(USERNAME, PASSWORD);
		System.out.println("=========Login Successfull=========");
	}

	@AfterMethod(alwaysRun=true)
	public void amConfig() throws InterruptedException {
Logout lg = new Logout(driver);
lg.logout();
	}

	@AfterClass(alwaysRun=true)
//	@AfterTest()
	/**
	 * After test annotation is used for parallel execution
	 */
	public void acConfig() {
		driver.quit();
		System.out.println("==========Browser closed successfully===========");

	}

	@AfterSuite(alwaysRun=true)
	public void asConfig() {
		System.out.println("=========DATABASE connection closed successfully========");
	}
}
