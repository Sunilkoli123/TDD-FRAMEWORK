package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

// test case to search an user 
public class Scenario3 {
	public static void main(String[] args) throws InterruptedException {

		// Step 1: Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// step 2: load the url

		driver.get("https://demoapp.skillrary.com/index.php");
		Thread.sleep(4000);

		// Step 3: login the application
		driver.findElement(By.linkText("LOGIN")).click();
		// Thread.sleep(4000);
		WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		email.click();
		email.sendKeys("admin");
		WebElement pwd = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		pwd.click();
		pwd.sendKeys("admin");
		driver.findElement(By.xpath("//button[@class=\"login_Btn\"]")).click();

		driver.findElement(By.xpath("//Span[contains(text(),\"Users\")]")).click();
		Thread.sleep(5000);
		WebElement searchuser = driver.findElement(By.xpath("//input[@type=\"search\"]"));
		searchuser.click();
		searchuser.clear();
		searchuser.sendKeys("alam alan");
		Thread.sleep(3000);
		WebElement username = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]\r\n" + ""));
		String name = username.getText();
		if (name.equals("alam alan")) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIl");
		}
	}
}
