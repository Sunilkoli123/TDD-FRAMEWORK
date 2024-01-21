package genericutilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of allmethods related to selenium
 * @author Sunil 
 *
 */
public class seleniumutility {
/** 
 * This methid will maximize the window
 * @param driver
 */
public void maximizewindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * 
	 */
//	public void minimizewindow(WebDriver driver) {
//		driver.manage().window().minimize();
//		
//	}
	
	/**
	 * This method will add 10seconds of implicit wait
	 * @param driver
	 */
	
	public void addImplicityWait(WebDriver driver) {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	/**
	 * This method will wait for 10 seconds for element to be visible
	 * @param driver
	 * @param element
	 */
		public void waitforElementToBeVisible(WebDriver driver,WebElement element) {
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		/**
		 * This method will handle dropdown based on index
		 * @param element
		 * @param index
		 */
		public void handleDropdown(WebElement element,int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
			
		}
		/**
		 * This method will handle dropdown based on value
		 * @param element
		 * @param value
		 */
		public void handleDropdown(WebElement element,String value) {
			Select sel = new Select(element);
			sel.selectByValue(value);
			
		}
		/**
		 * This method will handle dropdown based on visible text
		 * @param element
		 * @param value
		 */
		public void handleDropdown(String text,WebElement element) {
			Select sel = new Select(element);
			sel.selectByValue(text);
			
		}
		
		
		/**
		 * This method wil handle double click mouse operation
		 * @param driver
		 * @param element
		 */
		public void handlesdoubleclickmouseActions(WebDriver driver,WebElement element) {
			Actions action= new Actions(driver);
			action.doubleClick(element).perform();
					
		}
	/**
	 * This method will handle click mouse operation
	 * 
	 */
		
		public void handlesclickmouseActions(WebDriver driver,WebElement element) {
			Actions action= new Actions(driver);
			action.moveToElement(element).click();
					
		}
	
		
		
		
		 /**
		  * This method will handle  mouse hover operation
		  * @param driver
		  * @param element
		  */
		public void mousehoverAction(WebDriver driver , WebElement element) {
			Actions action= new Actions(driver);
			action.moveToElement(element).perform();
		}
		
		
		/**
		 * This method will perform right click action on a web element 
		 * @param driver
		 * @param element
		 */
		public void rightClickAction(WebDriver driver,WebElement element) {
			Actions action= new Actions(driver);
			action.contextClick(element).perform();

		}
		
		/**
		 * This method will perform scroll down action
		 * @param driver
		 */
		public void scrollAction(WebDriver driver) {
			
			JavascriptExecutor j= (JavascriptExecutor)driver;
			j.executeScript("window.scrollBy(0,1000)");
			
		}
		
		
		/**
		 * This method will click ok in Alert pop-up
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
			
		}
		

		/**
		 * This method will click Cancel in Alert pop-up
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
			
		}
		
		
		/**
		 * This method will capture Alert text and return it to a caller
		 * @param driver
		 * @return
		 */
		public String getAlertText(WebDriver driver) {
			return driver.switchTo().alert().getText();
			
		}
		
		
		/**
		 * This method will handle frame based on index
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver,int index) {
			driver.switchTo().frame(index);
			
		}
		
		
		/**
		 * This method will handle frame based on the name or ID
		 * @param driver
		 * @param nameOrId
		 */
		public void hanleFrame(WebDriver driver, String nameOrId) {
			driver.switchTo().frame(nameOrId);
		}
		
		
		/**
		 * This method will handle frame based on the frame element
		 * @param driver
		 * @param element
		 */
		public void hanleFrame(WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
		}
		
		
		
		/**
		 * This method will cpature the screenshot and return the path to a caller
		 * @param driver
		 * @param screenshotname
		 * @return
		 * 
		 * @throws IOException
		 */
		public String captureScreenshot(WebDriver driver,String screenshotname) throws IOException {
			TakesScreenshot ts= (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest= new File(".\\Scrrenshots\\"+screenshotname+".png");
			Files.copy(src, dest);
			return dest.getAbsolutePath(); //used in extent reports
		}
		
		
}
