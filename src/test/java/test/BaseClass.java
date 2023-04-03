package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.Capturess;
import utilities.StaticBrowser;

public class BaseClass {
	WebDriver driver;
	public static ExtentReports reports;
	public static ExtentSparkReporter file;
	public static ExtentTest logger;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeclass(String browser) {
		WebDriver driver = StaticBrowser.openbrowser(browser, "https://amazon.com");
		this.driver = driver;
		reports = new ExtentReports();
		file = new ExtentSparkReporter(System.getProperty("user.dir") + File.separatorChar + "test-output"
				+ File.separator + "Reports" + File.separator + System.currentTimeMillis() + ".html");
		reports.attachReporter(file);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String src = Capturess.getScreenShot(driver);
			logger.log(Status.FAIL, "Test", MediaEntityBuilder.createScreenCaptureFromPath(src).build());
		}
		reports.flush();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
