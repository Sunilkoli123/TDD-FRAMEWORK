package practice;



import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenatio1withDDT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.close();
		// read the data
		// read the common data
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String baseurl = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("pwd");

		// read the test data from excel
		FileInputStream fis1 = new FileInputStream(".\\src\\main\\resources\\TestDataSunil.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(0);
		;
		Cell cl = rw.getCell(1);
		String name = cl.getStringCellValue();

		System.out.println(name + "       djbdh");

		// step 2: load the url

		driver.get(baseurl);
		Thread.sleep(4000);

		// Step 3: login the application
		driver.findElement(By.linkText("LOGIN")).click();
		// Thread.sleep(4000);
		WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		email.click();
		email.sendKeys(username);
		WebElement pwd = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		pwd.click();
		pwd.sendKeys(password);
		driver.findElement(By.xpath("//button[@class=\"login_Btn\"]")).click();

		driver.findElement(By.xpath("//Span[contains(text(),\"Users\")]")).click();
		Thread.sleep(2000);
		WebElement searchuser = driver.findElement(By.xpath("//input[@type=\"search\"]"));
		searchuser.click();
		Thread.sleep(1000);
		searchuser.clear();
		searchuser.sendKeys(name);
		Thread.sleep(3000);
		WebElement username1 = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]\r\n" + ""));
		String name1 = username1.getText();
		if (name1.equals(name)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIl");
		}
		driver.quit();

	}
}
