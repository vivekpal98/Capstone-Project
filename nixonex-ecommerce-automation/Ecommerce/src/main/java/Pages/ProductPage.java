package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;

    @FindBy(linkText = "Laptops")WebElement laptopsCategory;

    @FindBy(linkText = "Sony vaio i5") WebElement sonyVaioLink;
    
    @FindBy(linkText ="Phones") WebElement phonescategory;
    
    @FindBy(linkText ="Samsung galaxy s6")WebElement samsunggalaxys1;
    @FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/a")WebElement addTocartBtn1;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a") WebElement addToCartBtn;

    @FindBy(xpath ="//*[@id=\"navbarExample\"]/ul/li[1]/a")WebElement clickhomepage;
    
    @FindBy(xpath = "//*[@id='tbodyid']/div[1]") WebElement productDescription;
    @FindBy(xpath = "//*[@id='tbodyid']/h3") WebElement productPrice;

    
   
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickLaptopsCategory() {
        laptopsCategory.click();
    }

    public void selectSonyVaio() {
        sonyVaioLink.click();
    }

    public void clickAddToCartsony() {
        addToCartBtn.click();
    }

    public void acceptCartAlert1() {
        driver.switchTo().alert().accept();
    }
    
    public String getLaptopDescription() {
        return productDescription.getText();
    }

    public String getLaptopPrice() {
        return productPrice.getText();
    }
    
    public void clickonhomepage() {
    	clickhomepage.click();
    }
    
    
    
    public void clickMobileCategory() {
    	phonescategory.click();
    }

    public void selectSamsungmobile() {
    	samsunggalaxys1.click();
    }

    public void clickAddToCartsamsung() {
    	addTocartBtn1.click();
    }

    public void acceptCartAlert2() {
        driver.switchTo().alert().accept();
    }
    
   

    public String getMobileDescription() {
        return productDescription.getText();
    }

    public String getMobilePrice() {
        return productPrice.getText();
    }
}
