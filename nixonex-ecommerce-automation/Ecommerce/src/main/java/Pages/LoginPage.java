package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "login2")WebElement loginButton;


    @FindBy(id = "loginusername") WebElement usernameField;

    @FindBy(id = "loginpassword") WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']") WebElement loginSubmitBtn;

    @FindBy(id = "nameofuser") WebElement loggedInUserLabel;
    
    
    public LoginPage(WebDriver d) {
    	driver =d;
    	PageFactory.initElements(driver, this);
    }
    
    public void clicklogin() {
    	loginButton.click();	
    }
    
    public void enterusername(String username) {
    	usernameField.sendKeys(username);
    }
    
    public void enterpassword(String password) {
    	passwordField.sendKeys(password);
    }
    
    public void clickloginbtn() {
    	loginSubmitBtn.click();
    }
    
    public String isLoginSuccessful() {
        return loggedInUserLabel.getText();
    }


}
