package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
public class Scenario1 {
	
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	//step 1: Launch the browser
	
	
	//ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	//step 2: load the url
	driver.get("https://demoapp.skillrary.com/index.php");
	Thread.sleep(4000);
	
	//Step 3: login the application
	driver.findElement(By.linkText("LOGIN")).click();
	//Thread.sleep(4000);
	WebElement email=driver.findElement(By.xpath("//input[@id=\"email\"]"));
	email.click();
	email.sendKeys("admin");
	WebElement pwd=driver.findElement(By.xpath("//input[@id=\"password\"]"));
	pwd.click();
	pwd.sendKeys("admin");
	driver.findElement(By.xpath("//button[@class=\"login_Btn\"]")).click();
	//driver.close();
	

	// step 4: click on course 
WebElement cource=	driver.findElement(By.xpath("//span[contains(text(),\"Courses\")]"));
	//a.moveToElement(cource).click();
cource.click();
	Thread.sleep(5000);
	//step 5: click on course list
	WebElement courselist=	driver.findElement(By.xpath("//a[contains(text(),\"Course List\")]"));
	//a.moveToElement(courselist).click();
	courselist.click();
	Thread.sleep(5000);
// step 6: verify the course name
	//a[contains(text(),"Course List")]
	List<WebElement> coursename=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
	String coursenames="";
	for(int i =0;i<=coursename.size()-1;i++) {
		coursenames=coursenames+coursename.get(i).getText()+",";
		System.out.println(coursenames);
	}
	
	if(coursenames.equals("Java,Selenium Training,SQL,Testing,")) {
		
		System.out.println("PASS");
	}
	else {
		System.out.println("FAIL");
	}
	
	
	//step 7 : logout
	driver.findElement(By.xpath("//span[contains(text(),\"SkillRary Admin\")]")).click();
	WebElement logout=driver.findElement(By.linkText("Sign out"));
	Actions a = new Actions(driver);
	a.moveToElement(logout).perform();
	Thread.sleep(5000);
	logout.click();
	
	driver.quit();
	
	
}
}
