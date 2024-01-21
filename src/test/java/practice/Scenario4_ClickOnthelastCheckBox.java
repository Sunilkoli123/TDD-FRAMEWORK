package practice;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4_ClickOnthelastCheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		List<WebElement> checkbox = driver.findElements(By.xpath("//table/tbody/tr[*]/td[1]/input[@type='checkbox']"));
		for(int i=0;i<=checkbox.size()-1;i++) {
			if(i==checkbox.size()-1) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", checkbox.get(i));
				checkbox.get(i).click();
				Thread.sleep(3000);
				
				break;
			}
		}
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
