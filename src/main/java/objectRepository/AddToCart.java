package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericutilities.seleniumutility;
public class AddToCart {
	@FindBy(xpath="//input[@value='Add to cart']")private WebElement addtocartbtn;

	@FindBy(xpath="//span[contains(text(),'Shopping cart')]")private WebElement shoppingcartbtn;
	@FindBy(xpath="//input[@value='Go to cart']")private WebElement gotocartbtn;

	public AddToCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}


	public WebElement getShoppingcartbtn() {
		return shoppingcartbtn;
	}
	public WebElement getGotocartbtn() {
		return gotocartbtn;
	}
	
	seleniumutility s= new seleniumutility();
	
	//business library(is used achive pure encapsulation)
	/**
	 * This method is used to add a product in to cart
	 * @param driver 
	 * @throws InterruptedException 
	 */
	public void AddtoCart( WebDriver driver) throws InterruptedException {
		addtocartbtn.click();
		Thread.sleep(3000);
		s.mousehoverAction(driver,shoppingcartbtn);
		gotocartbtn.click();
	}




	
	
}
