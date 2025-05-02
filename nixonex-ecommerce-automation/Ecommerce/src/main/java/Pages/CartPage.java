package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	  WebDriver driver;
	  @FindBy(id = "cartur")
	    WebElement cartLink;

	    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/button")WebElement placeOrderBtn;

	    // Form fields
	    @FindBy(id = "name")WebElement nameField;

	    @FindBy(id = "country")WebElement countryField;

	    @FindBy(id = "city")WebElement cityField;

	    @FindBy(id = "card")WebElement cardField;

	    @FindBy(id = "month")WebElement monthField;

	    @FindBy(id = "year")WebElement yearField;

	    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")WebElement purchaseBtn;

	    @FindBy(xpath = "/html/body/div[10]/h2")WebElement confirmationMessage;
	    
	    @FindBy(xpath="//*[@id=\"tbodyid\"]/tr[2]/td[4]/a")WebElement deletesamsung;
	    
	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void deletesamsungbtn() {
	        deletesamsung.click();
	    }
	    public void goToCart() {
	        cartLink.click();
	    }
	    public void clickPlaceOrder() {
	        placeOrderBtn.click();
	    }
	    
	   
	    
	    public void fillFormDetails(String name, String country, String city, String card, String month, String year) {
	        nameField.sendKeys(name);
	        countryField.sendKeys(country);
	        cityField.sendKeys(city);
	        cardField.sendKeys(card);
	        monthField.sendKeys(month);
	        yearField.sendKeys(year);
	    }
	    public void clickPurchase() {
	        purchaseBtn.click();
	    }
	    public String isOrderConfirmed() {
	        return confirmationMessage.getText();
	    }
	    
	   

}
