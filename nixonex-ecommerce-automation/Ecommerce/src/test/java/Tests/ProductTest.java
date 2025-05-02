package Tests;

import org.testng.annotations.Test;

import Pages.ProductPage;
import Utils.BaseTest;

public class ProductTest extends BaseTest{

	@Test
	public void addProductToCart() throws InterruptedException {
		
		test= report.createTest("Add product to Cart");
		ProductPage product = new ProductPage(driver);

		product.clickLaptopsCategory();
		Thread.sleep(2000); 

		product.selectSonyVaio();
		Thread.sleep(2000); 

		product.clickAddToCartsony();
		Thread.sleep(2000);

		product.acceptCartAlert1();
		
		String laptopDescription = product.getLaptopDescription();
	      String laptopPrice = product.getLaptopPrice();
	      System.out.println("Laptop Description: " + laptopDescription);
	      System.out.println("Laptop Price: " + laptopPrice);
	      
	      product.clickonhomepage();  
	      Thread.sleep(2000);
		
		product.clickMobileCategory();
		Thread.sleep(2000); 

		product.selectSamsungmobile();
		Thread.sleep(2000); 

		product.clickAddToCartsamsung();
		Thread.sleep(2000);

		product.acceptCartAlert2();
		
		String mobileDescription = product.getMobileDescription();
	      String mobilePrice = product.getMobilePrice();
	      System.out.println("Mobile Description: " + mobileDescription);
	      System.out.println("Mobile Price: " + mobilePrice);
	}
}
