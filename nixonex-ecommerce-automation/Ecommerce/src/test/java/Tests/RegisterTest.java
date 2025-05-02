package Tests;

import org.testng.annotations.*;
import Pages.*;
import Utils.BaseTest;

public class RegisterTest extends BaseTest {
    @Test
    public void registerUser() throws InterruptedException {
    	test= report.createTest("Register User Test");
    	
        RegisterPage register = new RegisterPage(driver);
        register.clickSignUp();
        Thread.sleep(2000);
        register.enterUsername("Vivek98");
        register.enterPassword("Test@23456");
        register.clickRegister();
    }
}