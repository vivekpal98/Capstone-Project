package Tests;

import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductPage;
import Utils.BaseTest;
import Utils.Screenshot;
import Utils.Testdata;

public class EndtoEndtest extends BaseTest{
	
  @Test
  public void completeuserflow() throws InterruptedException {
	  test = report.createTest("End-to-End User Flow Test");

      // Login
      LoginPage login = new LoginPage(driver);
      login.clicklogin();
      Thread.sleep(2000);
      login.enterusername(Testdata.USERNAME);
      login.enterpassword(Testdata.PASSWORD);
      login.clickloginbtn();
      Thread.sleep(3000); 
      //login validation
      String loginvalidation = login.isLoginSuccessful();
      assert loginvalidation.contains("Welcome");
      System.out.println("Login Sucessful:" + loginvalidation);
      
      String loginScreenshot = Screenshot.takeScreenshot(driver, "AfterLogin");
      test.info("Login successful").addScreenCaptureFromPath(loginScreenshot);

      //Select Product
      ProductPage product = new ProductPage(driver);
      product.clickLaptopsCategory();
      Thread.sleep(2000); 
      product.selectSonyVaio();
      Thread.sleep(2000); 
      product.clickAddToCartsony();
      Thread.sleep(2000); 
      product.acceptCartAlert1();
      //1st product description print
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
     //2nd product description print
      String mobileDescription = product.getMobileDescription();
      String mobilePrice = product.getMobilePrice();
      System.out.println("Mobile Description: " + mobileDescription);
      System.out.println("Mobile Price: " + mobilePrice);
      
      String productScreenshot = Screenshot.takeScreenshot(driver, "AfterProductSelection");
      test.info("Product selected and added to cart").addScreenCaptureFromPath(productScreenshot);

      //Go to Cart,delete and Checkout
      CartPage cart = new CartPage(driver);
      cart.goToCart();
      Thread.sleep(3000);
     
      String cartproductsScreenshot = Screenshot.takeScreenshot(driver, "AddedproductsinCart");
      test.info("Product validated in cart").addScreenCaptureFromPath(cartproductsScreenshot);
      
      cart.deletesamsungbtn();
      Thread.sleep(2000);

      String cartScreenshot = Screenshot.takeScreenshot(driver, "AfterproductdeleteinCart");
      test.info("Product validated in cart after deletion").addScreenCaptureFromPath(cartScreenshot);
     
      cart.clickPlaceOrder();
      Thread.sleep(1000);

      cart.fillFormDetails(Testdata.NAME, Testdata.COUNTRY, Testdata.CITY, Testdata.CARD, Testdata.MONTH, Testdata.YEAR);
      cart.clickPurchase();
      Thread.sleep(2000);
      
      //Order Validation
      String ordervalidation = cart.isOrderConfirmed();
      assert ordervalidation.contains("Thank you for your purchase");
      System.out.println("Order Confirmed : "+ordervalidation);
      
      String checkoutScreenshot = Screenshot.takeScreenshot(driver, "AfterCheckout");
      test.pass("Order placed successfully").addScreenCaptureFromPath(checkoutScreenshot);
  }
}
