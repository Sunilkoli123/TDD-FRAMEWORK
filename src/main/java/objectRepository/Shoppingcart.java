package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.seleniumutility;

public class Shoppingcart {


@FindBy(name="CountryId")private WebElement selectcountry;

@FindBy(xpath="//span[contains(text(),'Shopping cart')]")private WebElement shoppingcartbtn;
@FindBy(id="checkout")private WebElement checkoutbtn;

public Shoppingcart(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}


public WebElement getSelectcountry() {
	return selectcountry;
}


public WebElement getCheckoutbtn() {
	return checkoutbtn;
}


seleniumutility s= new seleniumutility();

//business library(is used achive pure encapsulation)
/**
 * This method is used to select a country value from dropdown and checkout
 * @param driver 
 */
public void Checkout(WebDriver driver,String cntryname) {
	seleniumutility s = new seleniumutility();
	//s.handleDropdown(selectcountry,cntryname );
	s.handleDropdown(selectcountry, 4);
	checkoutbtn.click();
}
}