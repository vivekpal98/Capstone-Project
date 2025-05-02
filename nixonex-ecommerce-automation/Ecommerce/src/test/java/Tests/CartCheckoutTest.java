package Tests;

import org.testng.annotations.Test;

import Pages.CartPage;
import Utils.BaseTest;
import Utils.Testdata;

public class CartCheckoutTest extends BaseTest{


  @Test
  public void CompleteCheckoutProcess() throws InterruptedException {
	  test= report.createTest("Complete Checkout process");
	  CartPage cart = new CartPage(driver);
	  
	  cart.goToCart();
	  Thread.sleep(3000);
	  
	  cart.deletesamsungbtn();
      Thread.sleep(2000);
      
	  cart.clickPlaceOrder();
      Thread.sleep(1000);
      
      cart.fillFormDetails(Testdata.NAME, Testdata.COUNTRY, Testdata.CITY, Testdata.CARD, Testdata.MONTH, Testdata.YEAR);
      cart.clickPurchase();
      Thread.sleep(2000);

      String ordervalidation = cart.isOrderConfirmed();
      assert ordervalidation.contains("Thankyou for your purchase");
      System.out.println("Order Confirmed"+ordervalidation);
  
  }
}
