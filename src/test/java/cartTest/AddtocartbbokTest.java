package cartTest;

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

@Test(groups="Regression")
@Listeners(genericutilities.ListnersImplementationClass.class)
public class AddtocartbbokTest extends BaseClass {

	public void addtocartBook() throws EncryptedDocumentException, IOException, InterruptedException {

		// read the test data from excel utility
		String name = eutil.readDataFromExcel("Sheet1", 1, 1);

		HomePage h = new HomePage(driver);
		h.searchaproduct(name);
		Thread.sleep(2000);

		String name1 = driver.findElement(By.linkText("Health Book")).getText();

		// aadto cart pom class
		AddToCart a = new AddToCart(driver);
		a.AddtoCart(driver);

		// checkout by selecting a counrty
		Shoppingcart c = new Shoppingcart(driver);
		String cntryname = eutil.readDataFromExcel("Sheet1", 0, 2);
		c.Checkout(driver, cntryname);

		Assert.assertTrue(name1.equals(name));

	}
}
