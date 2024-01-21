package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// Step 1: Launch the browser
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

		// step 4 :verify the sales history column names
		driver.findElement(By.xpath("//span[contains(text(),\"Sales\")]")).click();
		String columnname = "";
		List<WebElement> columnnames = driver.findElements(By.xpath("//table/thead/tr/th"));
		for (int i = 1; i <= 5; i++) {
			columnname = columnname + columnnames.get(i).getText() + ",";
			System.out.println(columnname);

		}

	}
}
