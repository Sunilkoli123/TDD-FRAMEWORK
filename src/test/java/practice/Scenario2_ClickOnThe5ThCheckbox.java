package practice;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2_ClickOnThe5ThCheckbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]/input[@type='checkbox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", checkbox);
		checkbox.click();
		Thread.sleep(3000);
		driver.quit();
	}

}
