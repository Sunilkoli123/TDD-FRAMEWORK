package practice;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarpopupScenario2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[contains(text(),\"Departure\")]")).click();
		Thread.sleep(3000);
		WebElement nextmonth = driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]"));

		for (int i = 0; i <= 3; i++) {
			nextmonth.click();
		}
		Thread.sleep(3000);
//			List<WebElement> monthname = driver.findElements(By.xpath("//div[@role=\"heading\"]/div"));
//			for (int m = 0; m <= monthname.size() - 1; m++) {
//				String currentmonth = monthname.get(m).getText();
//
//				String month1 = currentmonth.substring(0, currentmonth.length() - 5);
//				System.out.println(month1);
//				if (month1.equals("May")) {
//					System.out.println("successfully came inside the loop");
		List<WebElement> dates = driver.findElements(By.xpath(
				"//div[@class=\"DayPicker-Month\"][2]//div[@class=\"dateInnerCell\"]/following::div[@class=\"dateInnerCell\"]/p[1]"));
		for (int k = 0; k <= dates.size() - 1; k++) {
			System.out.println(dates.get(k).getText());
			if (dates.get(k).getText().equals("3")) {
				dates.get(k).click();
				Thread.sleep(10000);
				System.out.println("Successfully clicked on the 3 rd Date");
				break;
			}

		}
		// break;
		// }

		// }

		driver.quit();
	}

}
