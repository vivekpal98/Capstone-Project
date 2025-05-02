package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {

	public WebDriver driver;
	public ExtentReports report;
	public static ExtentTest test;

	@BeforeSuite
	public void startReport() {
		Screenshot.deleteOldScreenshots();
		report = ExtentManager.getInstance();
	}

	@AfterSuite
	public void endReport() {
		report.flush();
	}


	@BeforeMethod
	public void init() {

		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {

		driver.quit();
	}
}
