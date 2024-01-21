package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(xpath="//input[@value='Search store']")private WebElement searchtxt;

@FindBy(xpath="//input[@value='Search']")private WebElement searchbtn;


public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}


public WebElement getSearchtxt() {
	return searchtxt;
}



public WebElement getSearchbtn() {
	return searchbtn;
}

//business library(is used achive pure encapsulation)
/**
 * This method is used to search a product in home page
 * @param productname
 */
public void searchaproduct(String productname) {
	searchtxt.click();
	searchtxt.clear();
	searchtxt.sendKeys(productname);
	searchbtn.click();
}

}
