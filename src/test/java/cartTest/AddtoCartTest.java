package cartTest;

import static org.testng.Assert.fail;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericutilities.BaseClass;
import objectRepository.AddToCart;
import objectRepository.HomePage;
import objectRepository.Shoppingcart;


//listeners
@Listeners(genericutilities.ListnersImplementationClass.class)
public class AddtoCartTest extends BaseClass {
	@Test(groups="smokesuite")
	public void addtocaredsmartphone() throws InterruptedException, EncryptedDocumentException, IOException {

//read the test data from excel utility
		String name = eutil.readDataFromExcel("Sheet1", 0, 1);

		// step 1 login homepage
		HomePage h = new HomePage(driver);
		h.searchaproduct(name);
		Thread.sleep(2000);

		String name1 = driver.findElement(By.linkText("Smartphone")).getText();

		// Step 2 aadto cart pom class
		AddToCart a = new AddToCart(driver);
		a.AddtoCart(driver);
    
		// Step 3 checkout by selecting a counrty
		Shoppingcart c = new Shoppingcart(driver);
		String cntryname = eutil.readDataFromExcel("Sheet1", 0, 2);
		c.Checkout(driver, cntryname);
		/**
		 * Validation using Hard assert 
		 */
		Assert.assertTrue(name1.contains(name));

		//System.out.println("PASS......successfully added" + name1 + "to the cart");

	}
	
	@Test(enabled =false)
	public void dummy() {
	Assert.fail();
	System.out.println("Hi");
	}
}
