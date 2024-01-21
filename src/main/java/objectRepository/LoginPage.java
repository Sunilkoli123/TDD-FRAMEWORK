package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//Rule 01 create a seperate class for the each pagpage

	// Rule 01 Declaration

	@FindBy(linkText ="Log in")
	private WebElement logintbtn;
	@FindBy(id = "Email")
	private WebElement usernametxt;
	@FindBy(id = "Password")
	private WebElement paswwordtxt;
	@FindBy(xpath = "//input[@value=\"Log in\"]")
	private WebElement loginsubmitbtn;

//Rule 03

//create a constructor to initialse these webelemnts using pagefactory class
	public LoginPage(WebDriver driver) {
		// use last pagefactory method
//PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, this);
	}

//Rule 04 utilisation of webelements by getters

	
	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPaswwordtxt() {
		return paswwordtxt;
	}

	public WebElement getLogintbtn() {
		return logintbtn;
	}

	public WebElement getLoginsubmitbtn() {
		return loginsubmitbtn;
	}
//Rule 05 business library -generic method
	/**
	 * This method is used to login the app
	 * 
	 * @param username
	 * @param pwd
	 * @throws InterruptedException 
	 */
	public void loginAPP(String username, String pwd) throws InterruptedException {
		logintbtn.click();
		Thread.sleep(3000);
		usernametxt.click();
		usernametxt.sendKeys(username);
		paswwordtxt.click();
		paswwordtxt.sendKeys(pwd);
		loginsubmitbtn.click();
	}

	

	
}
