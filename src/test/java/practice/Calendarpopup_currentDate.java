package practice;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendarpopup_currentDate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Date currentdate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy ");
		String date = dateFormat.format(currentdate);
		System.out.println(date);
		String[] datearr = date.split("/");
		String day = datearr[0];
        
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[contains(text(),\"Departure\")]")).click();
		Thread.sleep(3000);
		List<WebElement> dates = driver.findElements(By.xpath(
				"//div[@class=\"DayPicker-Month\"][2]//div[@class=\"dateInnerCell\"]/following::div[@class=\"dateInnerCell\"]/p[1]"));
		for (int k = 0; k <= dates.size() - 1; k++) {
			System.out.println(dates.get(k).getText());
			if (dates.get(k).getText().equals(day)) {
				dates.get(k).click();
				Thread.sleep(10000);
				System.out.println("Successfully clicked on the"+" Current "+"Date");
				break;
			}

		}

Thread.sleep(3000);
		
        
	}

}
