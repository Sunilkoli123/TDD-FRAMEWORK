package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3_CapturingTheCountryName {
	public static void main(String[] args) throws InterruptedException {
		

	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

	driver.get("https://cosmocode.io/automation-practice-webtable/");
	driver.manage().window().maximize();
	List<WebElement> countryname= driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/strong"));
	
	for(int i=0;i<=countryname.size()-1;i++) {
		System.out.println(countryname.get(i).getText());

	}
	driver.quit();
}
}
