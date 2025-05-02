package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	@FindBy(xpath ="//button[text()='Sign up']") WebElement registerbtn;
	@FindBy(xpath ="signin2") WebElement signup;

    WebDriver driver;
    JavascriptExecutor js;

    public RegisterPage(WebDriver d) {
        driver = d;	
        PageFactory.initElements(driver, this);
    }

    public void clickSignUp() {
        //driver.findElement(By.id("signin2")).click();
    	signup.click();
    }

    public void enterUsername(String username) {
        driver.findElement(By.id("sign-username")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("sign-password")).sendKeys(password);
    }

    public void clickRegister() {
    registerbtn.click();
    }


}
