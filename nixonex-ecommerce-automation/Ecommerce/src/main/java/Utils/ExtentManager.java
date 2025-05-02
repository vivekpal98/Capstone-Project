package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports report;
	private static ExtentSparkReporter htmlReport;
    
    public static ExtentReports getInstance() {
    if (report == null) {
    htmlReport = new ExtentSparkReporter("test-output/ExtentReport.html");
	report = new ExtentReports();
	report.attachReporter(htmlReport);
	
	//Add some environment details
	report.setSystemInfo("Project Name", "DemoBlaze");
	report.setSystemInfo("Machine", "Hp");
	report.setSystemInfo("OS", "Windows 11");
	report.setSystemInfo("Company", "Star Agile");
	report.setSystemInfo("User", "Vivek");
	report.setSystemInfo("Browser", "Chrome");
	
	//Configuration of report about look and feel
	htmlReport.config().setDocumentTitle("My Simple Extent Report");
	htmlReport.config().setReportName("EchoTrak Test");
	htmlReport.config().setTheme(Theme.STANDARD);
	htmlReport.config().setTimeStampFormat("dd-MMMM-yyyy");
    }
    return report;
}
    
}
