package practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import genericutilities.PropertyFileUtility;
import genericutilities.readDataFromExcelutility;
import genericutilities.seleniumutility;
import objectRepository.AddToCart;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.Shoppingcart;
import io.github.bonigarcia.wdm.WebDriverManager;

public class scenario1withDDTandgenericutility {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// create object utilities
		PropertyFileUtility putil = new PropertyFileUtility();
		readDataFromExcelutility eutil = new readDataFromExcelutility();
		seleniumutility sutil = new seleniumutility();

		WebDriverManager.chromedriver().setup();
//Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		sutil.maximizewindow(driver);
//driver.close();
// read the data
//read the common data  using utility

		String baseurl = putil.readDataFromPropertyFile("url");
		String username = putil.readDataFromPropertyFile("username");
		String password = putil.readDataFromPropertyFile("pwd");

//read the test data from excel utility
		String name = eutil.readDataFromExcel("Sheet1", 0, 1);

//step 2: load the url

		driver.get(baseurl);
		Thread.sleep(4000);

		// Step 3: login the application
		// By using pom class
		LoginPage l = new LoginPage(driver);

		// or by using pom business libraries for examaple to optimize the above code
		l.loginAPP(username, password);
		// login homepage
		HomePage h = new HomePage(driver);
		h.searchaproduct(name);
		Thread.sleep(2000);

		String name1 = driver.findElement(By.linkText("Smartphone")).getText();

		// aadto cart pom class
		AddToCart a = new AddToCart(driver);
		a.AddtoCart(driver);

		// checkout by selecting a counrty
		Shoppingcart c = new Shoppingcart(driver);
		String cntryname = eutil.readDataFromExcel("Sheet1", 0, 2);
		c.Checkout(driver, cntryname);

		if (name1.equals(name)) {
			System.out.println("PASS......successfully able to read utility files");
		} else {
			System.out.println("FAIl");
		}
		driver.quit();
	}
}
