package Tests;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Utils.BaseTest;
import Utils.Testdata;

public class LoginTest extends BaseTest {

	@Test
	public void LoginUser() throws InterruptedException {
		test= report.createTest("Login User Test");
		
		LoginPage login = new LoginPage(driver);
	      login.clicklogin();
	      Thread.sleep(2000); 
	      login.enterusername(Testdata.USERNAME);
	      login.enterpassword(Testdata.PASSWORD);
	      login.clickloginbtn();
	      Thread.sleep(3000); 
		
	      String loginvalidation = login.isLoginSuccessful();
	      assert loginvalidation.contains("Welcome");
	      System.out.println("Login Sucessful:" + loginvalidation);
		
	}
}
