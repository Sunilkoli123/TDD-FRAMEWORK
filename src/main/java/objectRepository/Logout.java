package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	@FindBy(linkText="Log out")private WebElement logoutbtn;

	public  Logout(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * Getter 
 * @return
 */
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
		
	/**
	 * Business library for logout 
	 * @throws InterruptedException 
	 */
	public void logout() throws InterruptedException {
		logoutbtn.click();
		Thread.sleep(5000);
		System.out.println("Successfully logged out from the app");
	}
}
